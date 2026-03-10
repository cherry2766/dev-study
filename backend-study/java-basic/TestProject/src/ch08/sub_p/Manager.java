package ch08.sub_p;

import java.util.Scanner;

import ch08.super_p.Employee; // 다른 패키지이므로 상속 받으려면 import 해야댐

public class Manager extends Employee {
	// Employee를 상속받았음, 필드는 모두 private이므로 직접 접근 불가
	// part="abc";
	// 단 필드의 저장 공간은 생성됨
	// Scanner sc = new Scanner(System.in);
	// 런타임 예외 발생(키보드 하나로 두개의 객체 참조)
	private String position; // 직위

	// Manager 객체 정보 저장 메서드
	// 두번 이상 사용하면 sc.close(); 되어버려서 오류 발생
	public void setManager() {
		setEmployee(); // super 클래스 메서드 호출 일반 직원 정보 저장
		System.out.println("직위 입력 : "); // Manager 고유 정보 저장
		position = sc.next(); // sc 상속받은 참조변수
		// sc.close();
	}

	// Manager 객체 정보 출력
	public void showManagInfo() {
		showEmpInfo();
		System.out.println("직위 : " + position);
	}
	
}
