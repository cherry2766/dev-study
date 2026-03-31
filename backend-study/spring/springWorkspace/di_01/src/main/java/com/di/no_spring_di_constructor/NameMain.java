package com.di.no_spring_di_constructor;

//프레임워크로 가정하는 클래스
//자바 문법에 맞춰서 코드가 진행되게 됨
public class NameMain {
	public static void main(String[] args) {
		NameService nameService = new NameService();
		
		NameController controller = new NameController(nameService);
		controller.show("홍길동");
	}

}
