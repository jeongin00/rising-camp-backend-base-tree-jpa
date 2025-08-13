package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @ManyToOne(fetch = FetchType.EAGER , optional = false) // 메시지는 user가 있어야 한다
    @JoinColumn(name = "user_id")
    private User user;

    public static Message create(String content, User user){
        return new Message(
                null,
                content,
                user
        );
    }
}



