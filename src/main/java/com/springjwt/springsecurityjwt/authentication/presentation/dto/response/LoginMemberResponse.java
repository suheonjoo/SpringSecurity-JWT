package com.springjwt.springsecurityjwt.authentication.presentation.dto.response;

import com.springjwt.springsecurityjwt.authentication.domain.Member;

import lombok.Getter;

@Getter
public class LoginMemberResponse {

	private Long id;
	private String email;
	private String name;

	private LoginMemberResponse() {
	}

	private LoginMemberResponse(final Long id, final String email, final String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public static LoginMemberResponse from(final Member member) {
		return new LoginMemberResponse(member.getId(), member.getEmail(), member.getUsername());
	}
}

