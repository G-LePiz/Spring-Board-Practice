package com.example.board.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id; // id

    private final String username; // 유저이름

    private final Integer age; // 나이


    public SignUpResponseDto(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
