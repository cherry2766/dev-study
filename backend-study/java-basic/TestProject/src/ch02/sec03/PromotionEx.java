package ch02.sec03;

public class PromotionEx {

	public static void main(String[] args) {
		// 자동 형변환 작은타입의 data가 큰 타입 변수로 저장되는 경우
		// java가 실행중에 자동으로 진행함
		byte byteValue = 10;
		int intValue = byteValue; // 서로 다른 타입이지만 byte가 int보다 작은 타입이므로 자동형변환 발생
		System.out.println(intValue);
		
		char charValue = '가';
		intValue = charValue; // char 2byte, int 4byte 자동형변환
		System.out.println("가의 유니코드 : " + intValue);
		
		intValue = 500;
		long longValue = intValue;
		System.out.println(longValue);
		
		intValue = 500;
		double doubleValue = intValue;
		System.out.println(doubleValue);
		
		// intValue = doubleValue; //Type mismatch: cannot convert from double to int
		// 강제 타입변환 필요
	}

}
