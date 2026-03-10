package ch04.sec01;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// switch 예제
		// switch(조건) <- 정수(연산식이어도 정수/문자표현이 되게끔)
		Scanner sc = new Scanner(System.in);
		int year;
		
		System.out.print("학년 입력 : ");
		year = sc.nextInt();
		
		switch(year) {
			case 1 : System.out.println("1학년"); break;
			case 2 : System.out.println("2학년"); break;
			case 3 : System.out.println("3학년"); break;
			case 4 : System.out.println("4학년"); break;
			default : System.out.println("잘못 입력했습니다");
		}	
		String position;
		
		System.out.print("직급 입력 : ");
		position = sc.next();
		
		switch(position) {
			case "부장" : 
				System.out.println("700만원"); 
				break;
			case "과장" : 
				System.out.println("500만원"); 
				break;
			default : 
				System.out.println("300만원");
		}
		
		//////////////////////////////////////////////////////
		/// 점수를 입력 받아서 등급을 처리
		int score;
		char grade;
		
		System.out.print("점수 입력 (0~100) : ");
		score = sc.nextInt();
		
		switch(score/10) {
			case 10 :
			case 9 : grade='A'; break;
			case 8 : grade='B'; break;
			case 7 : grade='C'; break;
			case 6 : grade='D'; break;
			default : grade='F';
		}
		System.out.println("학점 : " + grade);
		
		sc.close();
	}
}
