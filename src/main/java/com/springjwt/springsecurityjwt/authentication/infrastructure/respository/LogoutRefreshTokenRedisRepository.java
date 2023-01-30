package com.springjwt.springsecurityjwt.authentication.infrastructure.respository;

import org.springframework.data.repository.CrudRepository;

import com.springjwt.springsecurityjwt.authentication.domain.LogoutRefreshToken;

public interface LogoutRefreshTokenRedisRepository extends CrudRepository<LogoutRefreshToken, String> {
}
