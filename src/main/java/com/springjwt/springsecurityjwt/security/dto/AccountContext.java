package com.springjwt.springsecurityjwt.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.springjwt.springsecurityjwt.authentication.domain.Member;

import lombok.Getter;

@Getter
public class AccountContext extends User {

	private Member member;

	public AccountContext(Member member, Collection<? extends GrantedAuthority> authorities) {
		super(member.getEmail(), member.getPassword(), authorities);
		this.member = member;
	}
}
