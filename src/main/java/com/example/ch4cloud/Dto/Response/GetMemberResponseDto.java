package com.example.ch4cloud.Dto.Response;

import com.example.ch4cloud.Entity.Member;
import lombok.Getter;

@Getter
public class GetMemberResponseDto {

    private final Long id;
    private final String name;
    private final int age;
    private final String mbti;

    public GetMemberResponseDto(Long id, String name, int age, String mbit) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbit;
    }

    public static GetMemberResponseDto from(Member member) {
        return new GetMemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }


}
