package com.spring_boot_react.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import org.springframework.security.web.authentication.AuthenticationFilter;
import com.spring_boot_react.project.AuthenticationFilter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.spring_boot_react.project.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// 인메모리 계정인 user 계정 수정(암호 변경)
	// user/password
//	@Bean
//	public InMemoryUserDetailsManager userDetailService() {
//		UserDetails user = User.builder()
//				.username("user") //id
//				.password(passwordEncoder().encode("password")) //password
//				.roles("USER") //권한
//				.build();
//		return new InMemoryUserDetailsManager(user); //스프링 시큐리티 설정 반환
//	}

	// db 사용자 계정을 이용한 스프링 시큐리티 구성 - 사용자 계정 시큐리티에 연결
	private final UserDetailsServiceImpl userDetailsService;
	private final AuthenticationFilter authenticationFilter;
	//private final AuthenticationFilter authenticationFilter;
	//private final AuthEntryPoint exceptHandler;

	public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthenticationFilter authenticationFilter) {
		this.userDetailsService = userDetailsService;
		this.authenticationFilter = authenticationFilter;
	}

	// db 사용자 설정
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf)-> csrf.disable()) //session 사용하지 않음
		.sessionManagement(
				(sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests( // /login은 인증 없이 요청가능, 로그인 요청 제외 나머지 모든 요청은 인증을 요구하게 됨
				(authorizeHttpRequests)-> authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/login")
				.permitAll().anyRequest().authenticated()
				) //모든 요청에 대해 /login을 선행할 것 -> 클라이언트가 jwt 토큰이 없으면 로그인을 요구하게됨
		.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
