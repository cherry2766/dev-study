package bookSaleView;

import java.util.Scanner;

import clientview.ClientLogin;
import util.ResultView;
import view.BookDelete;
import view.BookInsert;
import view.BookList;
import view.BookSearchByPublisher;
import view.BookUpdate;

public class MainView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menuNum;

		ClientLogin login = new ClientLogin();
		if (login.login(sc)) {
			String clientNo = login.getLoginClientNo();

			ResultView.succMsg("로그인 되었습니다");
			while (true) {
				System.out.println("===============구매내역관리 프로그램=============");
				System.out.println("1. 도서 구매");
				System.out.println("2. 전체 구매내역 조회");
				System.out.println("3. 상세 구매내역 조회");
				System.out.println("4. 구매내역 수정");
				System.out.println("5. 도서구매 취소");
				System.out.println("6. 종료(로그아웃)");
				System.out.println("========================================");

				System.out.print("메뉴 번호 입력 : ");
				menuNum = sc.nextLine();

				switch (menuNum) {
				case "1":
					BookSaleCreate create = new BookSaleCreate();
					create.create(sc,clientNo);
					break;
				case "2":
					BookSaleList list = new BookSaleList();
					list.getAllBookSale();
					break;
				case "3":
					BookSaleSelect bs = new BookSaleSelect();
					bs.getBookSale(sc);
					break;
				case "4":
					BookSaleUpdate update = new BookSaleUpdate();
					update.update(sc);
					break;
				case "5":
					BookSaleDelete delete = new BookSaleDelete();
					delete.delete(sc);
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
		} else {
			ResultView.errorMsg("로그인 실패");
		}

	}

}
