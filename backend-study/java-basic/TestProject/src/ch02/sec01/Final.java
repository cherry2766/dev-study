package ch02.sec01;

public class Final {

	public static void main(String[] args) {
		// 상수 : final 예약어 사용
		// final 데이터 타입 상수명(대문자로 사용);
		// float, double : 실수 타입 명
		final float PI = 3.14f; //실수 리터럴 뒤에 f 추가하여 float 타입임을 알려줘야 함
		double radius = 10; //실수 뒤에 예약 문자 없으면 double 형
		double circleArea = 0;
		
		circleArea = radius * radius * PI;
		
		System.out.println("원의 면적 = " + circleArea);
	}

}
