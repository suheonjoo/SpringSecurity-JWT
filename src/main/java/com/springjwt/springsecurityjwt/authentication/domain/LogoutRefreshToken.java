package com.springjwt.springsecurityjwt.authentication.domain;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("logoutRefreshToken")
public class LogoutRefreshToken extends Token {

	private LogoutRefreshToken(String id, long expiration) {
		super(id, expiration);
	}

	public static LogoutRefreshToken of(String refreshToken, Long expiration) {
		return new LogoutRefreshToken(refreshToken, expiration);
	}
}
