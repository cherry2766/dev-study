package ch03.sec02;

public class BitLogicEx {

	public static void main(String[] args) {
		// 비트 논리 연산 : 정수 비트연산자 정수
		// 정수를 2진수 bit로 구성하고 동일 위치 bit끼리 논리 연산
		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + ~45);

	}

}
