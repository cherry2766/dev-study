package ch07.sec01;

// MultiClass.java 에서 동일 이름의 클래스가 이미 있음(접근제한은 다름)
public class Add {
	private int a, b;
	public Add(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("더하기 : " + (a + b));
	}
}
