package com.example.chat.controller;

import com.example.chat.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @MessageMapping("/send")
    public void sendMessage(ChatMessage message) {
        // 채팅 메시지를 받아 처리하는 핸들러 메서드입니다.
        // 메시지를 수신한 후 필요한 로직을 수행하고, 다른 사용자에게 메시지를 전달할 수 있습니다.

        // 예시: 메시지를 수신한 사용자에게 응답을 보내기
        System.out.println("sendMessage"+message);
    }
}