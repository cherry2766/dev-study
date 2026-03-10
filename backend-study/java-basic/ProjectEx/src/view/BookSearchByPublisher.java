package view;

import java.util.Scanner;

import controller.BookController;

public class BookSearchByPublisher {
	BookController controller = BookController.getInstance();

	public void showBookByPublisher(Scanner sc) {
		String pubName;
		System.out.println("\n*******************************");
		System.out.println("도서 정보 조회");
		System.out.println("*********************************");

		System.out.print("출판사명 입력 : ");
		pubName = sc.nextLine();

		controller.bookSearchByPublisher(pubName);

	}
}
