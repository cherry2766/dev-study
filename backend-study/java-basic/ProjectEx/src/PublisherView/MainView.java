package PublisherView;

import java.util.Scanner;

import clientview.ClientLogin;
import util.ResultView;

public class MainView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menuNum;

		ClientLogin login = new ClientLogin();
		if (login.login(sc)) {

			ResultView.succMsg("로그인 되었습니다");
			while (true) {
				System.out.println("===============출판사관리 프로그램=============");
				System.out.println("1. 출판사정보 등록");
				System.out.println("2. 출판사정보 조회");
				System.out.println("3. 출판사정보 수정");
				System.out.println("4. 출판사정보 삭제");
				System.out.println("5. 종료(로그아웃)");
				System.out.println("========================================");

				System.out.print("메뉴 번호 입력 : ");
				menuNum = sc.nextLine();

				switch (menuNum) {
				case "1":
					PublisherInsert insert = new PublisherInsert();
					insert.insert(sc);
					break;
				case "2":
					PublisherList list = new PublisherList();
					list.getAllPublisher();
					break;
				case "3":
					PublisherUpdate update = new PublisherUpdate();
					update.update(sc);
					break;
				case "4":
					PublisherDelete del = new PublisherDelete();
					del.delete(sc);
					break;
				case "5":
					System.out.println("-------------------------");
					System.out.println("종료합니다");
					System.out.println("-------------------------");
					sc.close();
					System.exit(0); // 프로그램 종료 명령
				default:
					System.out.println("잘못 입력하였습니다");
				}

			}
		} else {
			ResultView.errorMsg("로그인 실패");
		}

	}

}
