package com.example.chat.config;

import com.example.chat.handler.GroupChatHandler;
import com.example.chat.handler.IndividualChatHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Configuration
@EnableWebSocket
public class IndividualWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new IndividualChatHandler(), "/IndividualChat")
                .setAllowedOrigins("http://localhost:3000")
                .addInterceptors(new NicknameInterceptor());
    }
    private static class NicknameInterceptor implements HandshakeInterceptor {
        @Override
        public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                       WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
            if (request instanceof ServletServerHttpRequest) {
                ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
                MultiValueMap<String, String> queryParams = UriComponentsBuilder.fromUri(servletRequest.getURI())
                        .build()
                        .getQueryParams();

                // Retrieve the nickname from the query parameters
                String nickname = queryParams.getFirst("nickname");
                if (nickname != null && !nickname.isEmpty()) {
                    // Store the nickname in the WebSocket session attributes
                    attributes.put("nickname", nickname);
                } else {
                    // Reject the handshake if the nickname is missing or empty
                    return false;
                }
            }

            return true;
        }

        @Override
        public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Exception exception) {
            // No need to implement anything in this case
        }
    }
}