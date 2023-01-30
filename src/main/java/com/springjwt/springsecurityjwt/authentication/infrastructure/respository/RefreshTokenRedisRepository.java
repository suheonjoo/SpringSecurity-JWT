package com.springjwt.springsecurityjwt.authentication.infrastructure.respository;

import org.springframework.data.repository.CrudRepository;

import com.springjwt.springsecurityjwt.authentication.domain.RefreshToken;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, String> {
}

