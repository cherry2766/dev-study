package ch04.sec01;
import java.util.Scanner;

public class MultipleIfElse {

	public static void main(String[] args) {
		// 여러 조건 검사 다중 if ~ else
		Scanner sc = new Scanner(System.in);
		char grade;
		
		System.out.print("점수 입력 (0~100) :");
		int score = sc.nextInt();
		
		if(score >= 90)
			grade = 'A';
		else if(score >= 80)
			grade = 'B';
		else if(score >= 70)
			grade = 'C';
		else if(score >= 60)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.print("성적 : " + grade);
		sc.close();
	}

}
