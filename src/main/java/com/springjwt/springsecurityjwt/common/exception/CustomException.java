package com.springjwt.springsecurityjwt.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	private final String errorCode;


	protected CustomException(String errorCode, HttpStatus httpStatus, String message, Throwable cause) {
		super(message,cause);
		this.errorCode = errorCode;
	}
	protected CustomException(String errorCode, HttpStatus httpStatus, String message) {
		super(message);
		this.errorCode = errorCode;
	}

}