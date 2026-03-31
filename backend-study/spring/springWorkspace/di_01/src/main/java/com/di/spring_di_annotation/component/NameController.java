package com.di.spring_di_annotation.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameController {
	
	@Autowired
	NameService nameService;
	//new 연산자로 객체 직접 생성하지 않고

	
	public void show(String name) {
		System.out.println("Name Controller:" + nameService.showName(name));
	}
}
