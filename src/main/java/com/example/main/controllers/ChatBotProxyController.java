package com.example.main.controllers;

import com.example.main.dtos.ChatQuestion;
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
    public ResponseEntity<ChatResponse> proxyToFastAPI(@RequestBody ChatQuestion chatQuestion) {
       System.out.println(chatQuestion.toString());
       ChatResponse chatResponse = chatBotProxyService.proxyToFastAPI(chatQuestion);

        System.out.println(chatResponse.toString());
        // ChatResponse chatResponse = ChatResponse.builder()
        //         .chatResponse(response)
        //         .build();

        return ResponseEntity.ok(chatResponse);
    }
}
