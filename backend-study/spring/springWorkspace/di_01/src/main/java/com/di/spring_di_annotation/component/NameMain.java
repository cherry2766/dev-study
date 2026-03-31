package com.di.spring_di_annotation.component;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//프레임워크로 가정하는 클래스
//자바 문법에 맞춰서 코드가 진행되게 됨
public class NameMain {
	public static void main(String[] args) {
		//스프링컨테이너(컨텍스트) 생성
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config2.xml");

		NameController controller = context.getBean("nameController", NameController.class);
		controller.show("홍길동");
	}

}
