package bookSaleView;

import java.util.ArrayList;
import java.util.Scanner;

import controller.bookSaleController;
import model.booksale.BookSaleReadDTO;

public class BookSaleSelect {
	bookSaleController controller = bookSaleController.getInstance();

	public void getBookSale(Scanner sc) {
		String bsNo;
		System.out.println("\n*******************************");
		System.out.println("상세 구매내역 조회");
		System.out.println("*********************************");

		System.out.print("주문번호 입력 : ");
		bsNo = sc.nextLine();
		controller.getBookSale(bsNo);
	}

	public static void showBookSaleBybsNo(ArrayList<BookSaleReadDTO> list) {

		System.out.println("구매번호\t 구매자명\t\t 도서명\t\t 가격\t\t 수량\t\t구매일");
		System.out.println("--------------------------------------------");

		for (BookSaleReadDTO dto : list) {
			System.out.println(dto);
		}

	}
}
