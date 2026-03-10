package ch09.sec03;

public class Main {

	public static void main(String[] args) {
		// 구현 클래스 객체 생성
		ImplC c = new ImplC();

		// 인터페이스 참조변수에 c변수 대입
		IInterfaceA ia = c;
		IInterfaceB ib = c;
		IInterfaceC ic = c;

		ia.methodA(); // super 인터페이스 타입(자신이 생성한 추상메서드만 접근 가능)
		ib.methodB(); // super 인터페이스 타입(자신이 생성한 추상메서드만 접근 가능)

		// 서브 인터페이스에서는 상속받은 인터페이스의 추상메서드 접근 가능
		ic.methodA();
		ic.methodB();
		ic.methodC();

	}

}
