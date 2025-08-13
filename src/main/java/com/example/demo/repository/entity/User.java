package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String job;
    private String specialty;
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;


    public static User create(String username, String password, String name, Integer age, String job, String specialty, Team team) {
        return new User(
                null,
                username,
                password,
                name,
                age,
                job,
                specialty,
                LocalDateTime.now(),
                Collections.emptyList(),   // 제네릭 타입 추론 매개변수 불필요
                team
        );
    }
}
