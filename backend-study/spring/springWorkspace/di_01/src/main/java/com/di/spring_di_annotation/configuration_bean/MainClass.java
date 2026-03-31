package com.di.spring_di_annotation.configuration_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//스프링 컨테이너 생성(설정 클래스 해석)
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Member member = context.getBean("member", Member.class);
		//Member 클래스 bean 등록시 전달한 필드값을 확인
		System.out.println(member);
		member.showBmi();

	}

}
