package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // 필수, 유일
    private String username;

    @Column(nullable = false) // 필수
    private String Password;

    private Integer age;

    public Member(String username, String password, Integer age) {
        this.username = username;
        this.Password = password;
        this.age = age;
    }

    public Member() {

    }

    public void updatePassword(String password) {
        this.Password = password;
    }
}
