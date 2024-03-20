package com.example.main.controllers;

import com.example.main.dtos.ChatResponse;
import com.example.main.services.ChatBotProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController // This should not include the path
@RequestMapping("/api/v1")
public class ChatBotProxyController {

    private final ChatBotProxyService chatBotProxyService;

    @Autowired
    public ChatBotProxyController(ChatBotProxyService chatBotProxyService) {
        this.chatBotProxyService = chatBotProxyService;
    }

    @PostMapping("/chat-proxy")
    public ResponseEntity<ChatResponse> proxyToFastAPI(@RequestBody String query) {
        String response = chatBotProxyService.proxyToFastAPI(query);

        //return ResponseEntity.ok(response);
        ChatResponse chatResponse = ChatResponse.builder()
                .message("This is a test response from the server")
                .build();

        return ResponseEntity.ok(chatResponse);
    }
}
