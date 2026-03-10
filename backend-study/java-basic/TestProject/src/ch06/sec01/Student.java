package ch06.sec01;

import java.util.Scanner;

public class Student {
	private String stdNo;
	private String stdName;
	private int year;
	private int score;

	public void inputStdInfo() {
		System.out.println("****학생 정보 입력****");
		Scanner sc = new Scanner(System.in);
		System.out.print("학번 : ");
		stdNo = sc.next();
		System.out.print("성명 : ");
		stdName = sc.next();
		System.out.print("학년 : ");
		year = sc.nextInt();
		System.out.print("점수 : ");
		score = sc.nextInt();
	}

	public void showStdInfo() {
		System.out.println("\n****학생 정보 출력****");
		System.out.println("학번 : " + stdNo);
		System.out.println("성명 : " + stdName);
		System.out.println("학년 : " + year);
		System.out.println("점수 : " + score);
	}
}
