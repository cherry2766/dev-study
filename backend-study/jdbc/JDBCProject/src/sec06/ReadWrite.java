package sec06;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import sec06.book.IBookDAO;
import sec06.book.BookDAO;

import sec06.book.BookDTO;

public class ReadWrite {
	// 도서 정보 입력
	public static BookDTO getBookInfo(Scanner sc) {
		BookDTO dto = null;
		try {

			System.out.println("***************");
			System.out.println("도서 정보 등록");
			System.out.println("***************");

			System.out.print("도서번호 입력 : ");
			String bookNo = sc.nextLine();

			System.out.print("도서명 입력 : ");
			String bookName = sc.nextLine();

			System.out.print("저자 입력 : ");
			String bookAuthor = sc.nextLine();

			System.out.print("가격 입력 : ");
			int bookPrice = sc.nextInt();
			sc.nextLine();

			System.out.print("발행일 입력 : ");
			String bookDate = sc.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fm.parse(bookDate);

			System.out.print("재고 입력 : ");
			int bookStock = sc.nextInt();
			sc.nextLine();

			System.out.print("출판사 번호 입력 : ");
			String pubNo = sc.nextLine();

			dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, date, bookStock, pubNo);

		} catch (Exception e) {
			System.out.println("입력이 잘못되었습니다");
			e.printStackTrace();
		}

		return dto;
	}

	// 도서 정보 수정
	public static BookDTO getBookInfo(Scanner sc, String bookNo) {
		BookDTO dto = null;
		try {

			System.out.println("***************");
			System.out.println("도서 정보 수정");
			System.out.println("***************");

			System.out.print("도서명 입력 : ");
			String bookName = sc.nextLine();

			System.out.print("저자 입력 : ");
			String bookAuthor = sc.nextLine();

			System.out.print("가격 입력 : ");
			int bookPrice = sc.nextInt();
			sc.nextLine();

			System.out.print("발행일 입력 : ");
			String bookDate = sc.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fm.parse(bookDate);

			System.out.print("재고 입력 : ");
			int bookStock = sc.nextInt();
			sc.nextLine();

			System.out.print("출판사 번호 입력 : ");
			String pubNo = sc.nextLine();

			dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, date, bookStock, pubNo);

		} catch (Exception e) {
			System.out.println("입력이 잘못되었습니다");
			e.printStackTrace();
		}

		return dto;
	}

	// 전체 도서 조회
	public static void writeBookInfo(ArrayList<BookDTO> bookList) {

		System.out.println("***************");
		System.out.println("전체 도서 정보 조회");
		System.out.println("***************");
		System.out.format("%-8s %-20s %-10s %-12s %-6s %-12s %-8s\n", "도서번호", "도서명", "가격", "발행일", "출판사", "저자", "재고");

		for (BookDTO book : bookList) {
			String bookNo = book.getBookNo();
			String bookName = book.getBookName();
			String bookAuthor = book.getBookAuthor();
			int bookPrice = book.getBookPrice();
			Date bookDate = book.getBookDate();
			int bookStock = book.getBookStock();
			String pubNo = book.getPubNo();

			System.out.format("%-8s %-20s %-10d %-12s %-6s %-12s %-8d\n", bookNo, bookName, bookPrice, bookDate, pubNo,
					bookAuthor, bookStock);
		}
	}

	// 상세 도서 조회
	public static void writeBookInfo(BookDTO dto) {

		System.out.println("***************");
		System.out.println("도서 정보 조회");
		System.out.println("***************");
		System.out.format("%-8s %-20s %-10s %-12s %-6s %-12s %-8s\n", "도서번호", "도서명", "가격", "발행일", "출판사", "저자", "재고");

		String bookNo = dto.getBookNo();
		String bookName = dto.getBookName();
		String bookAuthor = dto.getBookAuthor();
		int bookPrice = dto.getBookPrice();
		Date bookDate = dto.getBookDate();
		int bookStock = dto.getBookStock();
		String pubNo = dto.getPubNo();

		System.out.format("%-8s %-20s %-10d %-12s %-6s %-12s %-8d\n", bookNo, bookName, bookPrice, bookDate, pubNo,
				bookAuthor, bookStock);

	}

}
