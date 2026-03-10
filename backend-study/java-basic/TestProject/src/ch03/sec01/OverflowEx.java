package ch03.sec01;

public class OverflowEx {

	public static void main(String[] args) {
		// 산술 연산자 사용 시 주의할 점
		// 결과 값 산출 시 overflow 주의
		
		int x = 1000000; // 백만
		int y = 1000000; // 백만
		
		int z = x * y; //1000000000000 -> int 범위 벗어남 (잘못된 값 출력) - overflow 발생
		long l = (long)x * (long)y; //강제 형변환 없이 진행하면 결과가 int 타입이여서 long에 넣어도 동일한 결과가 나타남
		System.out.println(z);
		System.out.println(l);
		
		// NaN과 Infinity 주의
		// 나누기(/) 연산과 나머지(%) 연산시 주의
		// System.out.println(10 / 0); // 정수 0으로 나눌 경우 예외 발생
		System.out.println(10 / 0.0); // 실수 0.0으로 나눌 경우 Infinity 출력
		
		// System.out.println(10 % 0); // by zero
		System.out.println(10 % 0.0); // NaN 출력 - 나눗셈이 무한대이므로 나머지 표현불가

	}

}
