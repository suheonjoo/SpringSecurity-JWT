package com.springjwt.springsecurityjwt.common.exhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springjwt.springsecurityjwt.authentication.presentation.dto.response.CommonResponse;
import com.springjwt.springsecurityjwt.common.exception.UnauthorizedException;
import com.springjwt.springsecurityjwt.common.exception.UserException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = "com.springjwt.springsecurityjwt")
public class ExControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)// ㅍ 오류 오면 반응함
	public ResponseEntity<CommonResponse> illegalExHandler(IllegalArgumentException e) {
		log.info("[exceptionHandler] ex", e);
		return ResponseEntity.badRequest()
			.body(CommonResponse.failOf("IllegalArgumentException 오류", "404"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserException.class)
	public ResponseEntity<CommonResponse> userExHandler(UserException e) {
		log.error("[exceptionHandler] ex", e);
		return ResponseEntity.badRequest()
			.body(CommonResponse.failOf(e.getMessage(), "404"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CommonResponse> ValidExceptionExHandler(MethodArgumentNotValidException e) {
		return ResponseEntity.badRequest()
			.body(CommonResponse.failOf("올바른 형식이 아닙니다", "400", e.getBindingResult()));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<CommonResponse> ExceptionExHandler(UnauthorizedException e) {
		log.info("[exceptionHandler] ex", e);
		return ResponseEntity.badRequest()
			.body(CommonResponse.failOf("UnauthorizedException", "400"));
	}

}




