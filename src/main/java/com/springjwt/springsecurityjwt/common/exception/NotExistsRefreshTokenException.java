package com.springjwt.springsecurityjwt.common.exception;

import org.springframework.http.HttpStatus;

public class NotExistsRefreshTokenException extends UnauthorizedException {

	private static final String MESSAGE = "존재하지 않는 refreshToken 입니다.";
	private static final String CODE = "LOGIN-401";

	public NotExistsRefreshTokenException() {
		super(CODE, HttpStatus.UNAUTHORIZED, MESSAGE);
	}
}
