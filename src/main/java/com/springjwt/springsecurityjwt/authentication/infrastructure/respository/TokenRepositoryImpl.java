package com.springjwt.springsecurityjwt.authentication.infrastructure.respository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springjwt.springsecurityjwt.authentication.domain.repository.TokenRepository;
import com.springjwt.springsecurityjwt.authentication.domain.LogoutAccessToken;
import com.springjwt.springsecurityjwt.authentication.domain.LogoutRefreshToken;
import com.springjwt.springsecurityjwt.authentication.domain.RefreshToken;

import lombok.RequiredArgsConstructor;

@Component
@Transactional
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

	private final LogoutAccessTokenRedisRepository logoutAccessTokenRedisRepository;
	private final LogoutRefreshTokenRedisRepository logoutRefreshTokenRedisRepository;
	private final RefreshTokenRedisRepository refreshTokenRedisRepository;

	@Override
	public void saveLogoutAccessToken(LogoutAccessToken logoutAccessToken) {
		logoutAccessTokenRedisRepository.save(logoutAccessToken);
	}

	@Override
	public void saveLogoutRefreshToken(LogoutRefreshToken logoutRefreshToken) {
		logoutRefreshTokenRedisRepository.save(logoutRefreshToken);
	}

	@Override
	public void saveRefreshToken(RefreshToken refreshToken) {
		refreshTokenRedisRepository.save(refreshToken);
	}

	@Override
	public boolean existsLogoutAccessTokenById(String token) {
		return logoutAccessTokenRedisRepository.existsById(token);
	}

	@Override
	public boolean existsLogoutRefreshTokenById(String token) {
		return logoutRefreshTokenRedisRepository.existsById(token);
	}

	@Override
	public boolean existsRefreshTokenById(String token) {
		return refreshTokenRedisRepository.existsById(token);
	}

	@Override
	public void deleteRefreshTokenById(String token) {
		refreshTokenRedisRepository.deleteById(token);
	}
}
