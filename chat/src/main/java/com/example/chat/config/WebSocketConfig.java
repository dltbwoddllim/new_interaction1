package com.example.chat.config;

import com.example.chat.handler.ChatHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("1111111111111");
        registry.addHandler(new ChatHandler(), "/chat")
                .setAllowedOrigins("http://localhost:3000");
    }


}