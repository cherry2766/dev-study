package ch03.sec02;

public class AssignOp {

	public static void main(String[] args) {
		// 누적 대입 연산자 : 누적 연산 사용하는 변수는 초기화 필요
		int result = 0;
		result += 10; // result =  result + 10;
		System.out.println("result=" + result);
		
		result -= 5;
		System.out.println("result=" + result);
		
		result *= 3;
		System.out.println("result=" + result);
		
		result /= 5;
		System.out.println("result=" + result);
		
		result %= 3;
		System.out.println("result=" + result);

	}

}
