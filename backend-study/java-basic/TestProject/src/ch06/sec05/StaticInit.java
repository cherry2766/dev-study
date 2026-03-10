package ch06.sec05;

public class StaticInit {
	// 인스턴스 필드와 메서드
	int a;

	void method() {
		/* ... */}

	// static 필드와 메서드
	static int staticA;

	static void staticMethod() {
		// static 메서드 내에서 this 사용 불가
		// this.a = 10;
	};

	// static 블록(초기화)
	static { // static 기능과 관련된 코드
		// a=1; // 인스턴스 변수 static 블럭 사용 불가
		// method() // 인스턴스 메서드 static 블럭 사용 불가
		staticA = 10;
		staticMethod();

		// 객체 인스턴스 생성 후 사용하는건 가능
		StaticInit st = new StaticInit();
		st.a = 10;
	}
}
