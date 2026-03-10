package ch12_collection.data_arraylist;

import java.util.List;
import java.util.Scanner;

public class MemberControllerMain {
	// 필요 변수 선언 및 생성
	static String id, pass, name, phone, address;
	static Scanner sc = new Scanner(System.in);
	static IMemberDAO idao = new MemberDAO();

	public static void main(String[] args) {

		while (true) {
			System.out.println("**** 메뉴 선택 ****");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 전체회원조회");
			System.out.println("4. 개인회원조회");
			System.out.println("5. 회원정보수정");
			System.out.println("6. 종료");

			int num = sc.nextInt();

			switch (num) {
			case 1:
				join();
				break;
			case 2:
				leave();
				break;
			case 3:
				list();
				break;
			case 4:
				detail();
				break;
			case 5:
				edit();
				break;
			case 6:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("번호를 다시 입력하세요");
			}
		}
	}

	// 회원 등록
	public static void join() {
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

		MemberDTO dto = new MemberDTO(id, pass, name, phone, address);
		idao.insertMember(dto);
	}

	public static void leave() {
		// 회원 삭제
		System.out.println("회원정보를 삭제합니다");
		System.out.print("id 입력 : ");
		id = sc.next();
		idao.deleteMember(id);
	}

	public static void list() {
		// 전체 회원 조회
		System.out.println("전체 회원정보를 조회합니다");
		List<MemberDTO> ar = idao.getAllMember();
		if (ar != null) {
			for (MemberDTO mem : ar) {
				System.out.println(mem.getMemId() + "\t" + mem.getMemPass() + "\t" + mem.getMemName() + "\t"
						+ mem.getMemPhone() + "\t" + mem.getMemAddress());
			}
		} else {
			System.out.println("조회할 회원이 없습니다");
		}
	}

	public static void detail() {
		// 한명 회원 조회
		System.out.println("회원정보를 조회합니다");
		System.out.print("id 입력 : ");
		id = sc.next();
		MemberDTO mDTO = idao.searchMember(id);
		if (mDTO != null) {
			System.out.println("**** " + id + "회원정보 ****");
			System.out.println(mDTO.getMemId() + "\t" + mDTO.getMemPass() + "\t" + mDTO.getMemName() + "\t"
					+ mDTO.getMemPhone() + "\t" + mDTO.getMemAddress());
		} else {
			System.out.println("해당 id의 회원이 조회되지 않습니다. id값 확인하세요");
		}
	}

	public static void edit() {
		// 회원 정보 수정
		System.out.println("회원정보를 수정합니다");
		System.out.print("수정할 id 입력 : ");
		id = sc.next();
		MemberDTO mDTO = idao.searchMember(id);
		if (mDTO == null) {
			System.out.println("해당 id의 회원이 없습니다.");
			return;
		}

		System.out.println("**** " + id + "회원정보 ****");
		System.out.println(mDTO.getMemId() + "\t" + mDTO.getMemPass() + "\t" + mDTO.getMemName() + "\t"
				+ mDTO.getMemPhone() + "\t" + mDTO.getMemAddress());
		// 수정 내용을 입력 받기
		System.out.println();
		System.out.print("pass 입력 : ");
		pass = sc.next();
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("전화번호 입력 : ");
		phone = sc.next();
		System.out.print("주소 입력 : ");
		address = sc.next();
		// 수정 내용의 객체
		MemberDTO dto = new MemberDTO(id, pass, name, phone, address);

		idao.updateMember(dto);

	}
}
