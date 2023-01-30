package com.springjwt.springsecurityjwt.common.exception;

import org.springframework.http.HttpStatus;

public class TokenAuthenticationFilterException extends UnauthorizedException{

	private static final String MESSAGE = "유효하지 않은 토큰입니다.";
	private static final String CODE = "LOGIN-401";

	public TokenAuthenticationFilterException(Throwable cause) {
		super(CODE, HttpStatus.UNAUTHORIZED, MESSAGE, cause);
	}
}