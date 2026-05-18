package com.example.ch4cloud.Repository;

import com.example.ch4cloud.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
