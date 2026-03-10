package bookSaleView;

import java.util.Scanner;

import controller.bookSaleController;
import model.booksale.BookSaleDTO;

public class BookSaleCreate {
	bookSaleController controller = bookSaleController.getInstance();

	public void create(Scanner sc, String clientNo) {
		System.out.println("------ 도서 구매 ------");

		System.out.print("도서번호 입력: ");
		String bookNo = sc.nextLine();

		System.out.print("수량 입력: ");
		int qty = Integer.parseInt(sc.nextLine());

		BookSaleDTO dto = new BookSaleDTO();
		dto.setClientNo(clientNo);
		dto.setBookNo(bookNo);
		dto.setBsQty(qty);

		controller.buy(dto);
	}
}
