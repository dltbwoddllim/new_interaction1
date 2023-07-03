package com.example.chat.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatHandler extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.add(session);
        System.out.println("afterConnectionEstablished"+session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        sessions.remove(session);
        System.out.println("afterConnectionClosed");


    }
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("handleTextMessage"+session+"message"+message);
        String msg = message.getPayload();
        System.out.println(msg);
        System.out.println("실행");
    }

    private void startSendingMessages(WebSocketSession session) {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    // 모든 연결된 세션에게 "ok" 메시지를 전송합니다.
                    for (WebSocketSession s : sessions) {
                        if (s.isOpen()) {
                            s.sendMessage(new TextMessage("ok"));
                        }
                    }

                    Thread.sleep(1000); // 1초마다 메시지 전송
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

}
