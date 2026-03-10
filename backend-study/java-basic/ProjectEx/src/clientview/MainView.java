package clientview;

import java.util.Scanner;

public class MainView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menuNum;

		while (true) {
			System.out.println("===============회원관리 프로그램=============");
			System.out.println("1. 회원 등록");
			System.out.println("2. 로그인");
			System.out.println("3. 전체회원 조회");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원정보 삭제");
			System.out.println("6. 종료(로그아웃)");
			System.out.println("========================================");

			System.out.print("메뉴 번호 입력 : ");
			menuNum = sc.nextLine();

			switch (menuNum) {
			case "1":
				ClientInsert insert = new ClientInsert();
				insert.insert(sc);
				break;
			case "2":
				ClientLogin login = new ClientLogin();
				boolean result = login.login(sc);
				if (result) {
					System.out.println("로그인 성공!");
				} else {
					System.out.println("로그인 실패!");
				}
				break;
			case "3":
				ClientList list = new ClientList();
				list.getAllClient();
				break;
			case "4":
				ClientUpdate update = new ClientUpdate();
				update.update(sc);
				break;
			case "5":
				ClientDelete del = new ClientDelete();
				del.delete(sc);
				break;
			case "6":
				System.out.println("-------------------------");
				System.out.println("종료합니다");
				System.out.println("-------------------------");
				sc.close();
				System.exit(0); // 프로그램 종료 명령
			default:
				System.out.println("잘못 입력하였습니다");
			}

		}

	}

}
