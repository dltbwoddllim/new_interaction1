package com.example.chat.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatHandler extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished"+session);
        super.afterConnectionEstablished(session);
        sessions.add(session);
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("handleTextMessage"+session+"message"+message);
        String msg = message.getPayload();
        session.sendMessage(new TextMessage("Response to " + msg));
        System.out.println(msg);
        System.out.println("실행");
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        sessions.remove(session);
        System.out.println("afterConnectionClosed");


    }

}
