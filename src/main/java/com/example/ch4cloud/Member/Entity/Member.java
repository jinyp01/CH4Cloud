package com.example.ch4cloud.Member.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "members")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String mbti;

    public Member() {}

    public Member(String name, Integer age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }
}
