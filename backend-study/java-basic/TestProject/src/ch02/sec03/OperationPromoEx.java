package ch02.sec03;

public class OperationPromoEx {

	public static void main(String[] args) {
		// 연산 중 발생하는 자동 형변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		
		// byte byteValue3 = byteValue1 + byteValue2; // byte + byte 이어도 더하기 연산은 int가 기본임
		// + 연산은 : int + int 이므로 byteValue1과 byteValue2는 자동형변환 되어져서 int형으로 변경됨
		// + 결과도 int이므로 byte 변수에 대입 불가능(오류 발생)
		int intValue = byteValue1 + byteValue2;
		System.out.println(intValue);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		// char charValue3 = charValue1 + charValue2; // 정수형 +연산 int가 기본 타입
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드 : " + intValue2);
		System.out.println("유니코드 출력문자 : " + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3/4; // 정수/정수 => 정수(int) : 소수점 이하 연산은 진행되지 않음
		System.out.println(intValue4);
		
		////////////////////////////////////////////////////////////////////
		///연산 결과가 실수여야 할 때는 실수연산 진행해야 함
		// intValue4 = intValue3/4.0; // 정수/실수 => 정수가 실수로 형변환 되면서 실수/실수 => 실수(double)
		double doubleValue = intValue3/4.0;
		System.out.print(doubleValue);
		System.out.println(doubleValue); //커서를 다음줄로 옮김
		System.out.print(doubleValue);

	}

}
