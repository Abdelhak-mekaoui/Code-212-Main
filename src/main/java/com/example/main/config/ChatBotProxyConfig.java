package com.example.main.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatBotProxyConfig {

    @Value("${proxy.chat-bot.url}")
    private String chatBotEndPoint;

    public String getChatBotEndPoint() {
        return chatBotEndPoint;
    }
}
