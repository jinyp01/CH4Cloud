package com.example.ch4cloud.Member.Controller;

import com.example.ch4cloud.Member.Dto.Request.SaveMemberRequestDto;
import com.example.ch4cloud.Member.Dto.Response.GetMemberResponseDto;
import com.example.ch4cloud.Member.Dto.Response.SaveMemberResponseDto;
import com.example.ch4cloud.Member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    ResponseEntity<SaveMemberResponseDto> saveMember(@RequestBody SaveMemberRequestDto request) {
        SaveMemberResponseDto response = memberService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/api/members/{memberId}")
    ResponseEntity<GetMemberResponseDto> getMember(@PathVariable Long memberId){
        GetMemberResponseDto response = memberService.getOne(memberId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
