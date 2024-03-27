package com.example.main.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatQuestion {
    private String chatQuestion;

    @Override
    public String toString() {
        return "ChatQuestion{" +
                "message='" + chatQuestion + '\'' +
                '}';
    
}
}
