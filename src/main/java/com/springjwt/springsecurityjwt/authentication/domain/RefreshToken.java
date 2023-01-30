package com.springjwt.springsecurityjwt.authentication.domain;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("refreshToken")
public class RefreshToken extends Token {

	private RefreshToken(String id, long expiration) {
		super(id, expiration);
	}

	public static RefreshToken of(String refreshToken, Long expiration) {
		return new RefreshToken(refreshToken, expiration);
	}
}