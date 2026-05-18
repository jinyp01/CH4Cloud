package com.example.ch4cloud.Dto.Response;

import com.example.ch4cloud.Dto.Request.SaveMemberRequestDto;
import com.example.ch4cloud.Entity.Member;
import lombok.Getter;

@Getter
public class SaveMemberResponseDto {

    private final Long id;
    private final String name;
    private final int age;
    private final String mbit;

    public SaveMemberResponseDto(Long id, String name, int age, String mbit) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbit = mbit;
    }

    public static SaveMemberResponseDto from(Member member){
        return new SaveMemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }
}
