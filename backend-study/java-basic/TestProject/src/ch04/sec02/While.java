package ch04.sec02;

import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		// while 문 정리
		/*
		 * while(1==1) { //무한반복 }
		 */
		int i = 0; //초기화 없이 비교 연산 불가능
		int sum = 0;
		while(i<=100) { //짝수의 합, i가 102가 되면 false 반복 종료
			sum += i;
			i+=2; //2씩 증가
		}
		System.out.println("i값 : " + i + " sum값 : " + sum);
		
		//////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("숫자입력 : ");
		num = sc.nextInt();
		
		while(num != 7) { //입력값이 7이 아닌동안 반복
			System.out.print("다시 입력 : ");
			num = sc.nextInt();
		}
		
		System.out.print("7 입력. 종료");
		sc.close();
	}

}
