package com.example.demo.controller.dto;

import com.example.demo.repository.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class UserCreateRequestDto {
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String job;
    private String specialty;
    private Integer teamId;
}