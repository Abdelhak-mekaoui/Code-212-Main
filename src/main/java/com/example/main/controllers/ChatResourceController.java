package com.example.main.controllers;

import com.example.main.models.ChatResource;
import com.example.main.services.ChatResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/chat-resources")
public class ChatResourceController {

    private final ChatResourceService chatResourceService;

    @Autowired
    public ChatResourceController(ChatResourceService chatResourceService) {
        this.chatResourceService = chatResourceService;
    }

    @GetMapping
    public List<ChatResource> getAllChatResources() {
        return chatResourceService.getAllChatResources();
    }

    //@PreAuthorize("hasRole('client_admin')")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('manage-account')")
    public ResponseEntity<ChatResource> getChatResourceById(@PathVariable String id) {
        Optional<ChatResource> chatResource = chatResourceService.getChatResourceById(id);
        return chatResource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChatResource> addChatResource(@RequestBody ChatResource chatResource) {
        ChatResource newChatResource = chatResourceService.addChatResource(chatResource);
        return ResponseEntity.status(HttpStatus.CREATED).body(newChatResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatResource> updateChatResource(@PathVariable String id, @RequestBody ChatResource updatedChatResource) {
        Optional<ChatResource> existingChatResource = chatResourceService.getChatResourceById(id);
        if (existingChatResource.isPresent()) {
            ChatResource savedChatResource = chatResourceService.updateChatResource(id, updatedChatResource);
            return ResponseEntity.ok(savedChatResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatResource(@PathVariable String id) {
        Optional<ChatResource> chatResource = chatResourceService.getChatResourceById(id);
        if (chatResource.isPresent()) {
            chatResourceService.deleteChatResource(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
