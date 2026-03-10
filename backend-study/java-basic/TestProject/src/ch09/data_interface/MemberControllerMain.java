package ch09.data_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberControllerMain {

	public static void main(String[] args) {
		// 회원등록
		// 회원 정보 입력 받기
		String id, pass, name, phone, address;
		Scanner sc = new Scanner(System.in);

		System.out.println("회원정보를 입력합니다");
		System.out.print("id 입력 : ");
		id = sc.next();
		System.out.print("pass 입력 : ");
		pass = sc.next();
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("전화번호 입력 : ");
		phone = sc.next();
		System.out.print("주소 입력 : ");
		address = sc.next();

		// 회원 등록 모듈
		// 1. dto 객체 생성
		MemberDTO dto = new MemberDTO(id, pass, name, phone, address);

		// 2. DB 저장을 위한 DAO 메서드 호출
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);
		// 권장하는 방법
		IMemberDAO idao = new MemberDAO();
		idao.insertMember(dto);
		
		//회원 삭제
		System.out.println("회원정보를 삭제합니다");
		System.out.print("id 입력 : ");
		id = sc.next();
		idao.deleteMember(id);
		
		//전체 회원 조회
		System.out.println("전체 회원정보를 조회합니다");
		ArrayList<MemberDTO> ar = idao.getAllMember();
		System.out.println("반복문 통해 ar 출력 코드");
		
		//한명 회원 조회
		System.out.println("회원정보를 조회합니다");
		System.out.print("id 입력 : ");
		id = sc.next();
		MemberDTO mDTO = idao.searchMember(id);
		System.out.println("mDTO 출력코드");
		
		//회원 정보 수정
		//수정할 회원 정보를 출력
		System.out.println("회원정보를 수정합니다");
		System.out.print("수정할 id 입력 : ");
		id = sc.next();
		mDTO = idao.searchMember(id);
		System.out.println("한명 회원정보 출력");
		//수정 내용을 입력 받기
		System.out.print("id 입력 : ");
		id = sc.next();
		System.out.print("pass 입력 : ");
		pass = sc.next();
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("전화번호 입력 : ");
		phone = sc.next();
		System.out.print("주소 입력 : ");
		address = sc.next();
		
		dto = new MemberDTO(id, pass, name, phone, address);
		
		idao.updateMember(dto);

	}

}
