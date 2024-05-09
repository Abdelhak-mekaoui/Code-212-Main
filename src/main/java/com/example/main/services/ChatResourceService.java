package com.example.main.services;

import com.example.main.models.ChatResource;
import com.example.main.repositories.ChatResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatResourceService {

    private final ChatResourceRepository chatResourceRepository;

    @Autowired
    public ChatResourceService(ChatResourceRepository chatResourceRepository) {
        this.chatResourceRepository = chatResourceRepository;
    }

    public List<ChatResource> getAllChatResources() {
        return chatResourceRepository.findAll();
    }

    public Optional<ChatResource> getChatResourceById(String id) {
        return chatResourceRepository.findById(id);
    }

    public ChatResource addChatResource(ChatResource chatResource) {
        return chatResourceRepository.save(chatResource);
    }

    public void deleteChatResource(String id) {
        chatResourceRepository.deleteById(id);
    }

    public ChatResource updateChatResource(String id, ChatResource updatedChatResource) {
        updatedChatResource.setId(id); // Set the ID of the updated chat resource
        return chatResourceRepository.save(updatedChatResource);
    }
}
