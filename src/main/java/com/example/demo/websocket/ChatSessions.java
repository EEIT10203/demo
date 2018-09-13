package com.example.demo.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class ChatSessions {

	private Map<String, String> activeSessions = new ConcurrentHashMap<>();

	public void add(String sessionId, String user) {
		activeSessions.put(sessionId, user);
	}

	public String getParticipant(String sessionId) {
		return activeSessions.get(sessionId);
	}

	public void removeParticipant(String sessionId) {
		activeSessions.remove(sessionId);
	}

	public Map<String, String> getActiveSessions() {
		return activeSessions;
	}

	public void setActiveSessions(Map<String, String> activeSessions) {
		this.activeSessions = activeSessions;
	}
}
