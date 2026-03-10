package ch07.calc;

public class Multiply {
	private int a, b;

	public Multiply(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("곱하기 : " + (a * b));
	}
}
