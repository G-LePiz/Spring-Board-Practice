package com.example.board.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username; // 유저이름

    private final String password; // 비밀번호

    private final Integer age; // 나이

    public SignUpRequestDto(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
