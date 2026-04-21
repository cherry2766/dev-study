package com.spring_boot_react.project.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_boot_react.project.domain.AppUser;
import com.spring_boot_react.project.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AppUserRepository repository;

	public UserDetailsServiceImpl(AppUserRepository repository) {
		this.repository = repository;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = repository.findByUsername(username);
		UserBuilder builder = null;
		// Optional.isPresent() : 객체 최종 값이 null이면 false / 값이 있으면 true
		if (user.isPresent()) {
			AppUser currentUser = user.get();
			//User.withUsername -> UserBuilder의 인스턴스 반환(builder 인스턴스 최소 조건 계정명이 반드시 필요함)
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
		}else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}
