package com.example.chat.config;

import com.example.chat.data.handler.GroupChatHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class GroupWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new GroupChatHandler(), "/Groupchat")
                .setAllowedOrigins("http://localhost:3000");
    }


}