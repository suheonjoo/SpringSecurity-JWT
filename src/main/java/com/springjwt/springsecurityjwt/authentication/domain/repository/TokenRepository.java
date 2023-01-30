package com.springjwt.springsecurityjwt.authentication.domain.repository;

import com.springjwt.springsecurityjwt.authentication.domain.LogoutAccessToken;
import com.springjwt.springsecurityjwt.authentication.domain.LogoutRefreshToken;
import com.springjwt.springsecurityjwt.authentication.domain.RefreshToken;

public interface TokenRepository {

	void saveLogoutAccessToken(LogoutAccessToken logoutAccessToken);

	void saveLogoutRefreshToken(LogoutRefreshToken logoutRefreshToken);

	void saveRefreshToken(RefreshToken refreshToken);

	boolean existsLogoutAccessTokenById(String token);

	boolean existsLogoutRefreshTokenById(String token);

	boolean existsRefreshTokenById(String token);

	void deleteRefreshTokenById(String token);

}
