package ch08.sec03;

class A {
	public A(int x) {
		System.out.println("명시적생성자 A");
	}
}

class B extends A {
	public B(int x) {
		// super 클래스에 기본 생성자가 없으면 B 클래스의 생성자에서는 A 클래스 생성 요청 불가능, 명시적 생성자 호출이 필요함
		super(x);
		System.out.println("명시적생성자 B " + x);
	}
}

public class ConstructorTest {

	public static void main(String[] args) {

		// 생성자 호출 순서 연습
		B b = new B(5);

		// toString 연습
		Employee emp1 = new Employee("1234", "홍길동", "마케팅");
		Employee emp2 = new Employee("5678", "김길동", "마케팅");
		System.out.println(emp2); // 객체 인스턴스 출력, Employee 클래스에 toString() 재정의 되어 있으므로 toString이 자동호출

		// 생성자의 매개변수 전달
		Manager mg = new Manager("1234", "홍길동", "마케팅", "대리");
		System.out.println(mg);

	}

}
