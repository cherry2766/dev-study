package sec05;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	private static IStudentDAO idao = new StudentDAO();

	public static void main(String[] args) {
		// 클래스 테스트 용(controller)

		Scanner sc = new Scanner(System.in);

		try {
			while (true) {
				printMenu();
				System.out.println("메뉴를 선택하세요");

				int menu = sc.nextInt();
				sc.nextLine(); // 엔터 처리

				switch (menu) {
				case 1:
					insertStudent(sc);
					break;
				case 2:
					listStudent();
					break;
				case 3:
					detailStudent(sc);
					break;
				case 4:
					deleteStudent(sc);
					break;
				case 5:
					updateStudent(sc);
					break;
				case 6:
					searchByDptNoStudent(sc);
					break;
				case 7:
					searchByDptNameStudent(sc);
					break;
				case 0:
					System.out.println("종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("다시 입력하세요.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printMenu() {
		System.out.println("====== 학생 관리 메뉴 ======");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 전체 정보 조회");
		System.out.println("3. 학생 정보 상세 조회");
		System.out.println("4. 학생 정보 삭제");
		System.out.println("5. 학생 정보 수정");
		System.out.println("6. 학과별 정보 조회");
		System.out.println("7. 학과이름별 정보 조회");
		System.out.println("0. 종료");
	}

	private static void insertStudent(Scanner sc) {
		StudentDTO dto = ReadWrite.getStdInfo(sc);
		if (dto == null)
			return;
		idao.insertStudent(dto);
	}

	private static void listStudent() {
		ArrayList<StudentDTO> stdList = idao.getAllStudent();
		if (stdList == null || stdList.size() == 0) {
			System.out.println("학생 정보가 없습니다");
			return;
		}
		ReadWrite.writeStdInfo(stdList);
	}

	private static void detailStudent(Scanner sc) {
		System.out.println("학번을 입력하세요");
		String stdNo = sc.nextLine();
		StudentDTO dto = idao.detailStudent(stdNo);
		if (dto != null)
			ReadWrite.writeStdInfo(dto);
	}

	private static void deleteStudent(Scanner sc) {
		System.out.println("학번을 입력하세요");
		String stdNo = sc.nextLine();
		idao.deleteStudent(stdNo);
	}

	private static void updateStudent(Scanner sc) {
		System.out.println("학번을 입력하세요");
		String stdNo = sc.nextLine();
		StudentDTO dto = idao.detailStudent(stdNo);

		if (dto != null) {
			ReadWrite.writeStdInfo(dto);
			idao.updateStudent(ReadWrite.getStdInfo(sc, stdNo)); // 학번 수정 방지
		}

	}

	private static void searchByDptNoStudent(Scanner sc) {
		System.out.println("학과 번호를 입력하세요");
		String dptNo = sc.nextLine();

		ArrayList<StudentDTO> stdList = idao.searchStudent(dptNo);

		if (stdList == null || stdList.size() == 0) {
			System.out.println("학생 정보가 없습니다");
			return;
		}
		ReadWrite.writeStdInfo(stdList);
	}

	private static void searchByDptNameStudent(Scanner sc) {
		System.out.println("학과 이름를 입력하세요");
		String dptName = sc.nextLine();

		ArrayList<StudentDTO> stdList = idao.searchStudent1(dptName);

		if (stdList == null || stdList.size() == 0) {
			System.out.println("학생 정보가 없습니다");
			return;
		}
		ReadWrite.writeStdInfo(stdList);
	}

}
