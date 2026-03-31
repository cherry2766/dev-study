package com.di.spring_di_annotation.component;

import org.springframework.stereotype.Component;

//해당 패키지를 설정파일에 등록하면 자동 bean 생성됨(@Component)
@Component
public class NameService {
	public String showName(String name) {
		System.out.println("NameService showName() 메소드");
		String myName = " 내 이름은 " + name + " 입니다.";
		return myName;
	}

}
