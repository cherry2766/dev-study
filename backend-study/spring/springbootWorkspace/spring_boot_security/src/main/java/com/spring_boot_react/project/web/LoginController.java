package com.spring_boot_react.project.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_react.project.domain.AccountCredentials;
import com.spring_boot_react.project.service.JwtService;

@RestController
public class LoginController {

	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
		System.out.println(credentials.username());

		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.username(),
				credentials.password());
		Authentication auth = authenticationManager.authenticate(creds); //로그인 기능
		// Generate token
		String jwts = jwtService.getToken(auth.getName()); //오류 발생 가능
		// Build response with the generated token
		// 생성된 토큰의 접두어 추가해서 브라우저에게 전달
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer" + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization").build(); //응답 객체 생성
	}
}
