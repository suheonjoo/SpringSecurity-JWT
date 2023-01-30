package com.springjwt.springsecurityjwt.authentication.domain.service;

import com.springjwt.springsecurityjwt.authentication.domain.Member;
import com.springjwt.springsecurityjwt.authentication.domain.service.dto.AuthResponseDto;
import com.springjwt.springsecurityjwt.authentication.presentation.dto.request.JoinRequest;

public interface AuthCommandUseCase {

	void logout(String accessToken, String refreshToken);

	void join(JoinRequest joinRequest);

	void deleteMember(Member member, String accessToken, String refreshToken);

	AuthResponseDto reissue(String refreshToken);

}
