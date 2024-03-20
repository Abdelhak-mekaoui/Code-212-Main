package com.example.main.services;


import com.example.main.config.ChatBotProxyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatBotProxyService {

    private final RestTemplate restTemplate;
    private final ChatBotProxyConfig proxyConfig;

    @Autowired
    public ChatBotProxyService(RestTemplate restTemplate, ChatBotProxyConfig proxyConfig) {
        this.restTemplate = restTemplate;
        this.proxyConfig = proxyConfig;
    }

    public String proxyToFastAPI(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(query, headers);

        //return restTemplate.postForObject(proxyConfig.getChatBotEndPoint(), entity, String.class);
        return "{\"response_str\": \"This is a simulation response\", \"query\": \"" + query + "\"}";
    }
}