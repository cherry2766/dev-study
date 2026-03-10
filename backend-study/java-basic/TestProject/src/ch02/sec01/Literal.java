package ch02.sec01;

public class Literal {

	public static void main(String[] args) {
		// 리터럴 -> 실제 값 총칭(저장되는 값의 유형을 총칭)
		// 정수/실수/문자(char)/문자열(String)/논리
		int score = 95;
		double average = 88.5;
		char fanilyName = '김'; // 문자 리터럴 : '' 표현
		String name = "홍길동"; // 문자열 : "" 표현
		boolean result = true; // 논리 리터럴(논리 타입 : boolean)
		
		System.out.println(score);
		System.out.println(average);
		System.out.println(fanilyName);
		System.out.println(name);
		System.out.println(result);
		
		// 변수 사용 범위 : {} 선언된 변수의 가장 가까운 블럭 내에서만 사용 가능
		
	}

}
