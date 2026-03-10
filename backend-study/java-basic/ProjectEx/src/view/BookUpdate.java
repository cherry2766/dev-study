package view;

import java.util.Scanner;

import controller.BookController;
import model.book.BookDTO;

public class BookUpdate {
	BookController controller = BookController.getInstance();

	public void update(Scanner sc) {
		String bookNo, bookName, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;

		System.out.println("\n*************************");
		System.out.println("도서정보 수정");
		System.out.println("***************************");
		
		// 수정이므로 입력된 데이터 먼저 보여주고 수정 데이터 입력 받기
		BookList bls = new BookList();
		bls.getAllBook();
		
		System.out.print("수정할 도서번호 입력 : ");		
		bookNo = sc.nextLine();
		
		System.out.print("도서제목 입력 : ");	
		bookName = sc.nextLine();
		
		System.out.print("도서저자 입력 : ");	
		bookAuthor = sc.nextLine();
		
		System.out.print("도서가격 입력 : ");	
		bookPrice = Integer.parseInt(sc.nextLine());
		
		System.out.print("발행일 입력 : ");	
		bookDate = sc.nextLine();
		
		System.out.print("도서재고 입력 : ");	
		bookStock = Integer.parseInt(sc.nextLine());
		
		System.out.print("출판사번호 입력 : ");	
		pubNo = sc.nextLine();	
		System.out.println("***************************");
		
		// 컨트롤러에 수정 데이터 전달
		controller.update(new BookDTO(bookNo, bookName, bookAuthor,bookPrice, bookDate,bookStock, pubNo));
	}
}
