package com.di.spring_di_annotation.configuration_bean;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.di.spring_di_annotation.configuration_bean")
@Configuration //구성파일설정 @
public class ApplicationConfig {
	
	@Bean
	public BMI bmi() {
		BMI bmi = new BMI();
		return bmi;
	}
	
	@Bean
	public Member member() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("수영");
		courses.add("헬스");
		courses.add("에어로빅");
		
		Member member = new Member();
		member.setBmi(bmi());
		member.setName("홍길동");
		member.setAge(23);
		member.setHeight(175);
		member.setWeight(70);
		member.setCourses(courses);
		
		return member;
	}

}
