package com.example.main.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChatResponse {

    private String message;

    @Override
    public String toString() {
        return "ChatResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
