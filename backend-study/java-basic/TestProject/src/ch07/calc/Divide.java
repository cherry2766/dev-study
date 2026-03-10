package ch07.calc;

public class Divide {
	private int a, b;

	public Divide(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("나누기 : " + (a / b));
	}
}
