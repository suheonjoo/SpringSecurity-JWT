package com.springjwt.springsecurityjwt.authentication.infrastructure.respository;

import org.springframework.data.repository.CrudRepository;

import com.springjwt.springsecurityjwt.authentication.domain.LogoutAccessToken;

public interface LogoutAccessTokenRedisRepository extends CrudRepository<LogoutAccessToken, String> {

}
