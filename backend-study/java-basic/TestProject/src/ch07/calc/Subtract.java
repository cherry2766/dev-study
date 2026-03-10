package ch07.calc;

public class Subtract {
	private int a, b;

	public Subtract(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("빼기 : " + (a - b));
	}
}
