package com.spring_boot_react.project;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring_boot_react.project.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
	
	//토큰 인증
    private final JwtService jwtService; //토큰유효성검사를 위해 토큰객체 주입
    
    public AuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    
    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, java.io.IOException{
    	// 토큰 검증 및 사용자 가져오기
        String jws = request.getHeader(HttpHeaders.AUTHORIZATION); //요청시 헤더에 담긴 Authorization 갖고옴
        if (jws != null) {
            // 토큰 유효성 검증 및 사용자 정보 추출
            String user = jwtService.getAuthUser(request); //토큰 유효성 검사
            System.out.println(user);
            // Authenticate(토큰검증 후 인증객체 생성)
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
                    java.util.Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);//현재 요청context에 인증 저장-해당인증정보는 로그인되었음을 알림
        }
        filterChain.doFilter(request, response); //필터체인에 request,response 전달(필터 체인을 계속 진행하여 다음 필터로 요청과 응답을 전달)
    }

}
