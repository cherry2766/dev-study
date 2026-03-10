package ch04.sec02;

import java.util.Scanner;

public class doWhile {

	public static void main(String[] args) {
		// do ~ While (조건검사를 뒤에서 함) - 조건이 처음부터 거짓이여도 무조건 한번은 실행함
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("숫자입력 : ");
		num = sc.nextInt();
		//입력값이 7이면 프로그램을 종료해야 하는데 do~while을 사용해서 처음 입력값이 7이어도 일단 한번은 진행함
		do { 
			System.out.print("다시 입력 : ");
			num = sc.nextInt();
		}while(num != 7); //입력값이 7이 아닌동안 반복
		
		System.out.print("7 입력. 종료");
		sc.close();

	}

}
