package com.springjwt.springsecurityjwt.authentication.presentation.dto.response;

import com.springjwt.springsecurityjwt.authentication.domain.Member;
import com.springjwt.springsecurityjwt.authentication.domain.service.dto.LoginResult;

import lombok.Getter;

@Getter
public class LoginResponse {

	private String token;
	private LoginMemberResponse member;

	private LoginResponse() {
	}

	public LoginResponse(final String token,
		final LoginMemberResponse loginMemberResponse) {
		this.token = token;
		this.member = loginMemberResponse;
	}

	public static LoginResponse from(final LoginResult loginResult) {
		final Member member = loginResult.getMember();
		final LoginMemberResponse loginMemberResponse = LoginMemberResponse.from(member);
		return new LoginResponse(loginResult.getAccessToken(), loginMemberResponse);
	}
}