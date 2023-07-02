package com.example.restapi.controller;

import com.example.restapi.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ChatController {

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService_) {
        this.chatService = chatService_;
    }

    @GetMapping("/chat")
    public ResponseEntity<java.lang.String> connectuser(@RequestParam Integer id) {
        //using chatservice to connect user
        String result = chatService.connectUser(id);



        // Return a success response
        return ResponseEntity.status(HttpStatus.CREATED).body("ss");
    }


}
