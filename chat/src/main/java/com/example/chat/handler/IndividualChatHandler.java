package com.example.chat.handler;

import com.example.chat.DTO.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IndividualChatHandler extends TextWebSocketHandler {
    private final Map<String, WebSocketSession> nicknameSessionMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished"+session);
        super.afterConnectionEstablished(session);
        String nickname = (String) session.getAttributes().get("nickname");
        System.out.println("nicknamenicknamenickname"+nickname);
        // Map the nickname to the WebSocketSession in the nicknameSessionMap
        nicknameSessionMap.put(nickname, session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Convert the message payload to MessageDTO
        ObjectMapper objectMapper = new ObjectMapper();
        MessageDTO messageDTO = objectMapper.readValue(message.getPayload(), MessageDTO.class);

        String response = messageDTO.getText();
        WebSocketSession s =nicknameSessionMap.get(messageDTO.getTo());
        if (s.isOpen()) {
            s.sendMessage(new TextMessage(response));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);

        // Assuming the nickname is received as a query parameter or in some other way
        String nickname = (String) session.getAttributes().get("nickname");

        // Remove the entry from nicknameSessionMap based on the nickname
        nicknameSessionMap.remove(nickname);
        System.out.println("nicknamenicknamenickname"+nickname);

        System.out.println("afterConnectionClosed");
    }


}
