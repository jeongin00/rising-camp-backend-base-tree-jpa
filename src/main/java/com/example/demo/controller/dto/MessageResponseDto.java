package com.example.demo.controller.dto;

import com.example.demo.repository.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageResponseDto {
    private Integer id;
    private String content;
    private Integer userId;

    public static MessageResponseDto from(Message entity){
        return new MessageResponseDto(
                entity.getId(),
                entity.getContent(),
                entity.getUser().getId() // User객체
        );
    }
}
