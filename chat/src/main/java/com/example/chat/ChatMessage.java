package com.example.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String sender;
    private String recipient;
    private String content;

    // 생성자, 게터 및 세터 생략

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    // 기타 필요한 메서드들
}
