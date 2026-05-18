package com.example.ch4cloud.Controller;

import com.example.ch4cloud.Dto.Request.SaveMemberRequestDto;
import com.example.ch4cloud.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    ResponseEntity<SaveMemberRequestDto> saveMember(@RequestBody SaveMemberRequestDto request) {


        return ResponseEntity.status(HttpStatus.CREATED).body();
    }

    @GetMapping("/api/members/{memberId}")




}
