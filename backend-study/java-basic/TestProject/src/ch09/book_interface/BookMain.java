package ch09.book_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {

	// 고유 id 값을 DB에서 받아올 수 없는 상황이라 id 값을 안내하고 확인할 때 입력 받는 방식으로 구성
	public static void main(String[] args) {

		int idNum = 1; // 책이 등록될때마다 id값을 만들기 위해 임의로 선언
		String id, title, author, publisher, publishedDate, imageUrl;
		int price, stock, diff;

		Scanner sc = new Scanner(System.in);
		IBookDAO dao = new BookDAO();

		while (true) {
			System.out.println("책 정보를 입력하세요");

			id = "B" + idNum++; // id값 증가
			System.out.print("책이름 입력: ");
			title = sc.next();

			System.out.print("저자 입력: ");
			author = sc.next();

			System.out.print("출판사 입력: ");
			publisher = sc.next();

			System.out.print("출판일 입력: ");
			publishedDate = sc.next();

			System.out.print("이미지 파일명 입력: ");
			imageUrl = sc.next();

			System.out.print("가격 입력: ");
			price = sc.nextInt();

			System.out.print("수량 입력: ");
			stock = sc.nextInt();

			BookDTO dto = new BookDTO(id, title, author, publisher, publishedDate, imageUrl, price, stock);
			dao.insertBook(dto); // 입력받은 값을 저장한 후 책 등록

			System.out.println("등록 되었습니다 ID: " + id); // 이후 입력받을 id 값이 필요해서 사용자에게 안내
			System.out.print("계속 등록하시겠습니까? (y/n): "); // 추가로 등록할 수 있게 구성
			if (sc.next().equals("n")) // 입력받은 값이 n과 같은지 비교
				break;
		}

		System.out.print("책을 삭제하시겠습니까? (y/n): ");
		if (sc.next().equals("y")) {
			System.out.print("책 ID 입력: ");
			String deleteId = sc.next(); // 입력받은 값을 deleteId에 저장

			boolean deleted = dao.deleteBook(deleteId); // deleteBook 메서드에 입력 받은 id 값을 전달한 후 삭제하면 true로 반환받음
			System.out.println(deleted ? "삭제 완료" : "해당 ID의 책이 없습니다");
		}

		System.out.print("전체 책 목록을 조회하시겠습니까? (y/n): ");
		if (sc.next().equals("y")) {
			ArrayList<BookDTO> list = dao.getAllBook(); // getAllBook 메서드에서 등록되어 있는 전체 책 목록 반환 받음

			if (list.isEmpty()) { // 등록된게 없으면 없다고 안내
				System.out.println("등록된 책이 없습니다.");
			} else {
				for (BookDTO book : list) { // 전체 책 목록 받아서 출력
					System.out.println(book.getId() + " : " + book.getTitle() + " | 재고 : " + book.getStock());
				}
			}
		}

		System.out.print("책 1권을 조회하시겠습니까? (y/n): ");
		if (sc.next().equals("y")) {
			System.out.print("조회할 책 ID 입력: ");
			String searchId = sc.next(); // 입력 받은 id를 searchId에 저장

			BookDTO book = dao.searchBook(searchId); // searchBook 메서드에 id와 일치하는 책이 있는지 확인 후 책 1개 객체 반환 받음
			if (book == null) { // 책 없으면 없다고 출력
				System.out.println("해당 ID의 책이 없습니다.");
			} else { // 책 있으면 정보 출력
				System.out.println("===== 책 정보 =====");
				System.out.println("ID: " + book.getId());
				System.out.println("이름: " + book.getTitle());
				System.out.println("저자: " + book.getAuthor());
				System.out.println("출판사: " + book.getPublisher());
				System.out.println("출판일: " + book.getPublishedDate());
				System.out.println("이미지: " + book.getImageUrl());
				System.out.println("가격: " + book.getPrice());
				System.out.println("재고: " + book.getStock());
			}
		}

		System.out.print("책 정보를 수정하시겠습니까? (y/n): ");
		if (sc.next().equals("y")) {
			System.out.print("수정할 책 ID: ");
			String editId = sc.next(); // 첵 id를 입력 받아서 editId 에 저장

			BookDTO updatedBook = dao.searchBook(editId); // id와 일치하는 책이 있을 때만 수정 가능
			if (updatedBook == null) {
				System.out.println("해당 책이 없습니다");
			} else {
				System.out.print("이름: ");
				title = sc.next();

				System.out.print("저자: ");
				author = sc.next();

				System.out.print("출판사: ");
				publisher = sc.next();

				System.out.print("출판일: ");
				publishedDate = sc.next();

				System.out.print("이미지 파일명: ");
				imageUrl = sc.next();

				System.out.print("가격: ");
				price = sc.nextInt();

				BookDTO updated = new BookDTO(editId, title, author, publisher, publishedDate, imageUrl, price,
						updatedBook.getStock() // 책 정보를 새로 입력 받아서 저장, updatedBook.getStock() <- 기존 재고 유지
				);

				boolean isUpdated = dao.updateBook(updated); // updateBook 메서드에서 정보 수정하고 true 반환 받음
				System.out.println(isUpdated ? "수정 완료" : "수정 실패");
			}
		}

		System.out.print("재고를 변경하시겠습니까? (y/n): ");
		if (sc.next().equals("y")) {
			System.out.print("책 ID 입력: ");
			String stockId = sc.next();

			System.out.print("변경 수량(+입고 / -판매): ");
			diff = sc.nextInt();

			boolean updatedStock = dao.updateStock(stockId, diff); // 책 id와 변경 수량을 입력 받아서 updateStock 호출
																   // 변경이 되면 true 반환받음
			System.out.println(updatedStock ? "재고 변경 완료" : "재고 변경 실패");
		}
	}
}
