package com.example.demo.service;

import com.example.demo.controller.dto.MessageCreateRequestDto;
import com.example.demo.controller.dto.MessageResponseDto;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.Message;
import com.example.demo.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Transactional
    public MessageResponseDto save(MessageCreateRequestDto request) {
      // 메시지 발행 메소드
        User user = userRepository.findById(request.getUser())
                .orElseThrow(() -> new RuntimeException("유저가 데이터베이스 내 존재하지 않습니다. 유저 id : " + request.getUser()));
        Message message = Message.create(
                request.getContent(),
                user
        );
        Message created = messageRepository.save(message);
        return MessageResponseDto.from(created);
    }
}
