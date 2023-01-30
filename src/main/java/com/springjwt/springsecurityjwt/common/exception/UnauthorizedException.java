package com.springjwt.springsecurityjwt.common.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends CustomException {

	protected UnauthorizedException(String errorCode, HttpStatus httpStatus, String message,Throwable cause) {
		super(errorCode, httpStatus, message,cause);
	}
	protected UnauthorizedException(String errorCode, HttpStatus httpStatus, String message) {
		super(errorCode, httpStatus, message);
	}

}