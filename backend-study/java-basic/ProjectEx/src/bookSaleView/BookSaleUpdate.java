package bookSaleView;

import java.util.Scanner;

import controller.bookSaleController;

public class BookSaleUpdate {
	bookSaleController controller = bookSaleController.getInstance();

	public void update(Scanner sc) {
		System.out.println("------ 구매내역 수정 ------");

		System.out.print("주문번호 입력: ");
		String updateBsNo = sc.nextLine();

		System.out.print("변경할 수량 입력: ");
		int newQty = Integer.parseInt(sc.nextLine());

		controller.updateSaleQty(updateBsNo, newQty);
	}
}
