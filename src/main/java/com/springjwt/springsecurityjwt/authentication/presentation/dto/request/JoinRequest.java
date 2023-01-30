package com.springjwt.springsecurityjwt.authentication.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class JoinRequest {

	@NotEmpty(message = "공백을 입력할수 없습니다")
	private String username;

	@Email(message = "이메일 형식이어야 합니")
	private String email;

	@NotEmpty(message = "공백을 입력할수 없습니다")
	private String password;

}
