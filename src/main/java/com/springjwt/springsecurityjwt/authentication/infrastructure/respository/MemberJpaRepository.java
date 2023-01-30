package com.springjwt.springsecurityjwt.authentication.infrastructure.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjwt.springsecurityjwt.authentication.domain.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
	Optional<Member> findOptionByEmail(String email);
}























































