package bookSaleView;

import java.util.Scanner;

import controller.bookSaleController;

public class BookSaleDelete {
	bookSaleController controller = bookSaleController.getInstance();

	public void delete(Scanner sc) {
		System.out.println("------ 도서구매 취소 ------");

		System.out.print("주문번호 입력: ");
		String cancelBsNo = sc.nextLine();

		controller.cancelSale(cancelBsNo);
	}
}
