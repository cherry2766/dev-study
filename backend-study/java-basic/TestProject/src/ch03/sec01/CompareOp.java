package ch03.sec01;

public class CompareOp {

	public static void main(String[] args) {
		// 비교 연산자
		// < > <= >= == !=
		// 결과 : boolean 타입의 true/false 산출
		// 동등 비교 연산자는 모든 타입에 사용
		// (문자열 비교에는 ==가 아니라 가급적이면 equals()메서드 사용해서 동등 비교 연산 진행 권장)
		
		// 값 형 변수
		int num1 = 10;
		int num2 = 10;
		
		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		
		char char1 = 'A';
		char char2 = 'B';
		char char3 = '가';
		char char4 = 'ㄱ';
		
		boolean result4 = (char1 < char2) ;
		System.out.println("result4 : " + result4);
		System.out.println((int)char1);
		System.out.println((int)char2);
		System.out.println((int)char3);
		System.out.println((int)char4);
		
		
	}

}
