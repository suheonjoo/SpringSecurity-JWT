package com.springjwt.springsecurityjwt.security.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springjwt.springsecurityjwt.authentication.domain.Member;
import com.springjwt.springsecurityjwt.authentication.infrastructure.respository.MemberJpaRepository;
import com.springjwt.springsecurityjwt.security.dto.AccountContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

	private final MemberJpaRepository memberJpaRepository;

	//@Cacheable(value = "member", key = "#email", unless = "#result == null")
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberJpaRepository.findOptionByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("No user found with email: " + email));
		List<GrantedAuthority> grantedAuthorities = Collections
			.singletonList(new SimpleGrantedAuthority(member.getRole()));
		return new AccountContext(member, grantedAuthorities);
	}
}















