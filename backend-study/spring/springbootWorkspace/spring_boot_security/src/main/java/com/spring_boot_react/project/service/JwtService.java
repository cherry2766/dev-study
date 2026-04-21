package com.spring_boot_react.project.service;

import java.security.Key;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtService {
	static final long EXPIRATIONTIME = 86400000; // JWT 만료시간 (1일 밀리초)
	static final String PREFIX = "Bearer"; // 토큰에서 사용할 접두사
	
	//서명에 사용할 인증 키를 생성 - 배포시에는 만들어진 키 값을 application.properties에서 읽어와야 함
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	//jwt 토큰 생성 모듈
	public String getToken(String username) {
		String token = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(key)
				.compact(); // xxxx.yyyy.zzzz 형식으로 jwt 토큰 구성
		
		return token;
	}
	
	//jwt 토큰 검증 모듈
	public String getAuthUser(HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION); //http 프로토콜 약속에 의해 자격증명은  HttpHeaders.AUTHORIZATION에 담겨 전송됨
		
		if ( token != null) {
			//user 정보 추출
			//parseClaimsJws(token) : 앞에서 생성된 parser에 의해 인증(서명)확인 후 토큰을 객체로 구성함
			//body/header/sign -> body에서 로그인한 사용자 정보를 추출
            String user =  Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody().getSubject();
            //user 있으면
            if(user != null) {
                return user; //토큰은 유효하고 인증자에 대한 정보 반환
            }   
		}
		return null; //유효하지 않은 토큰이거나 user 정보가 없는 경우
	}
}
