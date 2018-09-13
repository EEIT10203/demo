'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var onlineArea = document.querySelector('#onlineArea');

var stompClient = null;
var username = null;
var receiverUser = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function privateChat(receiver){
	
	//移除舊的聊天者標記
	if(receiver != receiverUser) {
		if(receiverUser != null && receiverUser !="") {
			document.getElementById("button_" + receiverUser).classList.remove('btn-primary');	
			document.getElementById("button_" + receiverUser).classList.add('btn-link');
			receiverUser = null;
		}	
		
		if(receiver !=null && receiver != '') {
			receiverUser = receiver;	
			document.getElementById("button_" + receiver).classList.remove('btn-link');
			document.getElementById("button_" + receiver).classList.add('btn-primary');			
		}
	} 

}

function connect(event) {
    username = document.querySelector('#name').value.trim();

    //if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    //}
    event.preventDefault();
}


function onConnected() {
	
	//stompClient.subscribe("/app/chat.participants", onLiveUsersReceived);

    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    //
    stompClient.subscribe('/user/queue/private', onMessageReceived);
    
    // Tell your username to the server
    stompClient.send("/app/chat.addUser",{},JSON.stringify({type: 'JOIN'}));

    connectingElement.classList.add('hidden');
}

function onLiveUsersReceived(payload) {
	
	var onlineUsers = JSON.parse(payload.body)
	
	onlineArea.innerHTML = '';

	if(onlineUsers) {
		for(var i=0 ; i< onlineUsers.length; i++){
			var lielm = document.createElement('li');

			if(onlineUsers[i] == username) {
				lielm.appendChild(document.createTextNode(onlineUsers[i])); 
				onlineArea.insertBefore(lielm, onlineArea.firstChild);
			} else {
				var buttonnode= document.createElement('input');
				buttonnode.setAttribute('type','button');
				buttonnode.setAttribute('id', "button_" + onlineUsers[i]);
				buttonnode.setAttribute('value', onlineUsers[i]);
				buttonnode.setAttribute('onclick', "privateChat('" + onlineUsers[i] + "')");
				
				if(receiverUser == onlineUsers[i]) {
					buttonnode.setAttribute('class','btn btn-primary btn-block');					
				} else {
					buttonnode.setAttribute('class','btn btn-link btn-block');					
				}
				
				lielm.appendChild(buttonnode);
				onlineArea.appendChild(lielm);
			} 
			//<li><button type="button" class="btn btn-link" onclick="privateChat('fuyu')">anny</button></li>
		}
	}
	
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            //sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
        
        if(receiverUser) {
        	stompClient.send("/app/chat.private." + receiverUser , {}, JSON.stringify(chatMessage));
        } else {
        	stompClient.send("/app/chat.message", {}, JSON.stringify(chatMessage));
        }
        messageInput.value = '';
                
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
    	stompClient.subscribe("/app/chat.participants", onLiveUsersReceived);
    	
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    var textElement = document.createElement('p');
    
    var messageText = "";
    if(message.receiver != null) {
    	messageText = document.createTextNode("私密給 " + message.receiver + ": " + message.content);
    } else {
    	messageText = document.createTextNode(message.content);
    }
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)