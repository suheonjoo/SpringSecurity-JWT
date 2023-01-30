package com.springjwt.springsecurityjwt.authentication.domain.service.dto;

import com.springjwt.springsecurityjwt.authentication.domain.Member;

import lombok.Getter;

@Getter
public class LoginResult {

	private final String refreshToken;
	private final String accessToken;
	private final Member member;

	public LoginResult(final String refreshToken, final String accessToken, final Member member) {
		this.refreshToken = refreshToken;
		this.accessToken = accessToken;
		this.member = member;
	}
}