package ch03.sec01;

public class LogicalOp {

	public static void main(String[] args) {
		// 논리 연산자는 비교 연산자와 같이 사용되는게 일반적임
		int charCode = 'A';
		
		System.out.println((charCode >= 65) & (charCode <= 90));
		System.out.println((charCode >= 65) && (charCode <= 90));
		System.out.println(true & true);
		
		if((charCode >= 65) && (charCode <= 90)) { //unicode 65~90 범위는 영문 대문자에 해당됨
			System.out.println("대문자 입니다");
		}
		if((charCode >= 97) && (charCode <= 122)) { //unicode 97~122 범위는 영문 소문자에 해당됨
			System.out.println("소문자 입니다");
		}
		//(charCode >= 48) && (charCode <= 57)
		if(!(charCode < 48) && !(charCode > 57)) { //unicode 48~57 범위는 숫자에 해당됨
			System.out.println("0~9 숫자 입니다");
		}
		
		int value = 6;
		if((value % 2 == 0) | (value % 3 == 0)) {
			System.out.println("2 또는 3의 배수입니다");
		}
		
		if((value % 2 == 0) || (value % 3 == 0)) {
			System.out.println("2 또는 3의 배수입니다");
		}
	}

}
