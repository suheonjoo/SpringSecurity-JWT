package com.springjwt.springsecurityjwt.common.exception;

public class UserException extends RuntimeException {

	public UserException(String message) {
		super(message);
	}

	protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
