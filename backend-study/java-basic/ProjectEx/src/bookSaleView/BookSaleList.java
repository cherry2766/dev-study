package bookSaleView;

import java.util.ArrayList;

import controller.bookSaleController;
import model.booksale.BookSaleReadDTO;

public class BookSaleList {
	bookSaleController controller = bookSaleController.getInstance();

	public void getAllBookSale() {
		controller.getAllBookSale();
	}

	public static void showAllBookSale(ArrayList<BookSaleReadDTO> list) {
		System.out.println("\n*******************************");
		System.out.println("전체 구매내역 조회");
		System.out.println("*********************************");

		System.out.println("구매번호\t 구매자명\t\t 도서명\t\t 가격\t\t 수량\t\t구매일");
		System.out.println("--------------------------------------------");

		for (BookSaleReadDTO dto : list) {
			System.out.println(dto);
		}
	}
}
