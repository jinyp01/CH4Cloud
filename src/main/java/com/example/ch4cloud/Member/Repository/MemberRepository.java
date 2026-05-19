package com.example.ch4cloud.Member.Repository;

import com.example.ch4cloud.Member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
