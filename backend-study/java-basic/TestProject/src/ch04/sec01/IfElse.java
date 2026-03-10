package ch04.sec01;
import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		// if ~ else 예제
		Scanner sc = new Scanner(System.in);
		int num;
		int score = 85;
		
		if(score >= 90) 
			System.out.println("점수가 90보다 크거나 같습니다");
		else
			System.out.println("점수가 90 미만입니다");
		
		if(score >= 90) {
			System.out.println("점수가 90보다 크거나 같습니다");
			System.out.println("등급은 A 입니다");
		}
		else {
			System.out.println("점수가 90 미만입니다");
			System.out.println("등급은 B 입니다");
		}
		
		////////////////////////////////////////////////////
		/// 사용자로부터 입력받은 값으로 조건 선택 진행 예제
		System.out.print("점수 입력 : ");
		num = sc.nextInt();
		
		if(num % 2 == 1)
			System.out.println("홀수");
		else
			System.out.println("짝수");
		
		sc.close();
	}

}
