package ch07.calc;

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
