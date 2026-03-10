package ch07.sec01;

import java.util.Scanner;

// 현재 클래스들은 동일 패키지 범위
// 한개 java 파일에 여러개 클래스 생성 시 public class는 한개만 존재해야 함

// 접근 제한이 생략된 경우 package 접근제한임
// 동일 패키지 내에서만 사용 가능
/*class Add {
	private int a, b;

	public Add(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("더하기 : " + (a + b));
	}
}*/

class Subtract {
	private int a, b;

	public Subtract(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("빼기 : " + (a - b));
	}
}

class Multiply {
	private int a, b;

	public Multiply(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("곱하기 : " + (a * b));
	}
}

class Divide {
	private int a, b;

	public Divide(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculator() {
		System.out.println("나누기 : " + (a / b));
	}
}

public class MultiClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		char op;

		System.out.print("정수1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자 입력 (+, -, *, /) : ");
		op = sc.next().charAt(0);

		switch (op) {
		case '+':
			Add ad = new Add(num1, num2);
			ad.calculator();
			break;
		case '-':
			Subtract s = new Subtract(num1, num2);
			s.calculator();
			break;
		case '*':
			Multiply m = new Multiply(num1, num2);
			m.calculator();
			break;
		case '/':
			Divide d = new Divide(num1, num2);
			d.calculator();
			break;
		default:
			System.out.println("연산자를 잘못 입력하였습니다.");
		}

		sc.close();
	}

}
