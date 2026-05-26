package com.example.ch4cloud.Member.Service;

import com.example.ch4cloud.Member.Dto.Request.SaveMemberRequestDto;
import com.example.ch4cloud.Member.Dto.Response.GetMemberResponseDto;
import com.example.ch4cloud.Member.Dto.Response.SaveMemberResponseDto;
import com.example.ch4cloud.Member.Entity.Member;
import com.example.ch4cloud.Member.Repository.MemberRepository;
import com.example.ch4cloud.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(
                MemberNotFoundException::new
        );
    }

    @Transactional
    public SaveMemberResponseDto save(SaveMemberRequestDto request) {
        Member member = new Member(request.getName(), request.getAge(), request.getMbti());
        memberRepository.save(member);

        return SaveMemberResponseDto.from(member);
    }

    @Transactional(readOnly = true)
    public GetMemberResponseDto getOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                MemberNotFoundException::new
        );

        return GetMemberResponseDto.from(member);
    }
}
