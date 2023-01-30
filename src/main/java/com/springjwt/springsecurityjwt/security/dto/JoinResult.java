package com.springjwt.springsecurityjwt.security.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springjwt.springsecurityjwt.authentication.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinResult {

	private Member member;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd | HH:mm:ss")
	private LocalDateTime createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd | HH:mm:ss")
	private LocalDateTime lastModifiedDate;

}










