package com.example.demo.websocket;

import java.security.Principal;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

	@Autowired
    SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	ChatSessions chatSessions;
	
	@SubscribeMapping("/chat.participants")
	public Collection<String> retrieveParticipants() {
		System.out.println("***chat.participants");
		return chatSessions.getActiveSessions().values();
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String index() {

		return "chat";
	}
	
    @MessageMapping("/chat.message")
    public void sendMessage(@Payload ChatMessage message, Principal principal) {
    	message.setSender(principal.getName());
    	messagingTemplate.convertAndSend("/topic/public", message);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage message,Principal principal, SimpMessageHeaderAccessor headerAccessor) {
    	message.setSender(principal.getName());
    	messagingTemplate.convertAndSend("/topic/public", message);
    	
    	// Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        
    	chatSessions.add(headerAccessor.getSessionId(),  message.getSender());
    	
    	messagingTemplate.convertAndSend("/topic/chat.participants", "");  
    }
    
    @MessageMapping("/chat.addPrivate.{username}")
    public void addPrivateUser(@Payload ChatMessage message,  @DestinationVariable("username") String username,Principal principal, SimpMessageHeaderAccessor headerAccessor) {
    	
    	message.setSender(principal.getName());
    	message.setReceiver(username);

    	if(!username.equals(principal.getName())) {
    		messagingTemplate.convertAndSend("/user/" + principal.getName() + "/queue/private", message);
    	}
    	messagingTemplate.convertAndSend("/user/" + username + "/queue/private", message);
    	
    	
    	// Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
    }
    
    /**
     * 精准推送
     * @param msg
     * @param principal
     * @return
     */
    @MessageMapping("/chat.private.{username}") 
    public void handle1(@Payload ChatMessage message,  @DestinationVariable("username") String username, Principal principal) {

    	message.setSender(principal.getName());
    	message.setReceiver(username);
    	
    	if(!username.equals(principal.getName())) {
    		messagingTemplate.convertAndSend("/user/" + principal.getName() + "/queue/private", message);
    	}
    	messagingTemplate.convertAndSend("/user/" + username + "/queue/private", message);
  
    }

 

}