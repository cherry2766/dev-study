package com.di.spring_di_xml_setter;

public class NameController {
	NameService nameService;
	
	//setter를 통해 주입받는 경우 기본 생성자만 사용 가능
	//생성자가 다른 전달받을 내용이 많을때는 setter를 활용 해 주입 받기
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("Name Controller:" + nameService.showName(name));
	}
}
