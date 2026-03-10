package ch06.sec06;

public class Singleton {
	// 클래스 멤버필드 생성(static 생성)
	// singleton 참조변수 : 객체 생성되어 있음. 클래스 명을 통해 접근 가능
	// 필드 보호 위해서 private 으로 접근 제한
	private static Singleton singleton = new Singleton(); // 클래스 내부에서 객체 인스턴스 하나 생성

	// 생성자 함수 : Singleton 패턴을 활용할 예정 -> 객체 인스턴스를 한 개만 유지되도록 구성
	// private 이므로 외부 접근 불가능(생성자 함수 1개) - 클래스 내부 접근 가능
	private Singleton() {

	}
	
	static Singleton getInstance() {
		return singleton;
	}
}
