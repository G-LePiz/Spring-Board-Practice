package com.example.board.service;

import com.example.board.dto.MemberResponseDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.dto.UpdatePasswordRequestDto;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) { //멤버 생성

        Member member = new Member(username, password, age);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(),savedMember.getAge());
    }

    public MemberResponseDto findById(Long id) { // 멤버 조회

        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id :" + id);
        }

        Member findmember = optionalMember.get();

        return new MemberResponseDto(findmember.getUsername(), findmember.getAge());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);
        if (!findMember.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지않습니다");
        }
        findMember.updatePassword(newPassword);
    }
}
