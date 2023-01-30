package com.springjwt.springsecurityjwt.security.handler;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.springjwt.springsecurityjwt.authentication.domain.service.LoginService;
import com.springjwt.springsecurityjwt.authentication.domain.service.dto.LoginResult;
import com.springjwt.springsecurityjwt.authentication.presentation.dto.response.LoginResponse;
import com.springjwt.springsecurityjwt.security.provider.JwtTokenProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private final JwtTokenProvider jwtTokenProvider;
	private final ObjectMapper objectMapper;
	private final LoginService loginService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException {
		String user = (String)authentication.getPrincipal();
		LoginResult loginResult = loginService.login(user);
		setHttpResponseOption(response, loginResult);
	}

	private void setHttpResponseOption(HttpServletResponse response, LoginResult loginResult) throws IOException {
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader(HttpHeaders.SET_COOKIE,
			jwtTokenProvider.createCookie(loginResult.getRefreshToken()).toString());
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.writeValue(response.getWriter(), LoginResponse.from(loginResult));
	}

}
