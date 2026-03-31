package com.di.spring_di_annotation;

import org.springframework.beans.factory.annotation.Autowired; //타입을 기준으로 자동 주입
import org.springframework.beans.factory.annotation.Qualifier; //동일타입 bean이 여러개 존재할 때 특정하기 위해 사용
import javax.annotation.Resource; //java annotation , Autowired + Qualifier

//생성자 종류에 따라 생성자에 반영도 가능
//@Autowired
public class NameController {
	//객체 필드에 직접 주입(생성자를 통해 주입됨) -> 생성자 호출하면서 자동 주입
	//@Autowired
	//name 속성을 생략 - 필드명과 id가 같은 bean을 주입
	@Resource
	INameService nameService;
	
	//setter에 주입
	//@Autowired
	//@Qualifier("anotherNameService")
	//@Resource(name = "anotherNameService")
	public void setNameService(INameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("Name Controller:" + nameService.showName(name));
	}
}
