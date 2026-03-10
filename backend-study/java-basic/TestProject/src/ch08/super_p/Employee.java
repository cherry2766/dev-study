package ch08.super_p;

import java.util.Scanner;

public class Employee {
	private String empNo, name, part;
	public Scanner sc = new Scanner(System.in);
	// 접근제한자 protected

	// 멤버필드값 설정 메서드 구성
	public void setEmployee() {
		System.out.print("사번 입력 : ");
		empNo = sc.next();
		System.out.print("성명 입력 : ");
		name = sc.next();
		System.out.print("부서 입력 : ");
		part = sc.next();
		
		//sc.close();
	}

	// 멤버 필드 값 출력
	public void showEmpInfo() {
		System.out.println("\n******************");
		System.out.println("사번 : " + empNo);
		System.out.println("성명 : " + name);
		System.out.println("부서 : " + part);
	}

	public void exitSc() {
		sc.close();
	}
}
