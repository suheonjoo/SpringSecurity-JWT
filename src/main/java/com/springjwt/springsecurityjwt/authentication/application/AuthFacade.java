package com.springjwt.springsecurityjwt.authentication.application;

import org.springframework.stereotype.Service;

import com.springjwt.springsecurityjwt.authentication.domain.Member;
import com.springjwt.springsecurityjwt.authentication.domain.service.AuthCommandUseCase;
import com.springjwt.springsecurityjwt.authentication.domain.service.dto.AuthResponseDto;
import com.springjwt.springsecurityjwt.authentication.presentation.dto.request.JoinRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthFacade {

	private final AuthCommandUseCase authCommandUseCase;

	public void logout(String accessToken, String refreshToken) {
		authCommandUseCase.logout(accessToken, refreshToken);
	}

	public void join(JoinRequest joinRequest) {
		authCommandUseCase.join(joinRequest);
	}

	public void deleteMember(Member member, String accessToken, String refreshToken) {
		authCommandUseCase.deleteMember(member, accessToken, refreshToken);
	}

	public AuthResponseDto reissue(String refreshToken) {
		return authCommandUseCase.reissue(refreshToken);
	}
}
