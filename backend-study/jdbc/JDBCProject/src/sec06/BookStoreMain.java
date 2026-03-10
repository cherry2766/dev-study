package sec06;

import sec06.book.IBookDAO;

import java.util.ArrayList;
import java.util.Scanner;

import sec06.book.BookDAO;
import sec06.book.BookDTO;

import sec06.client.ClientDAO;
import sec06.client.IClientDAO;

public class BookStoreMain {
	private static IBookDAO bookDao = new BookDAO();
	private static IClientDAO clientDao = new ClientDAO();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			if (!login(sc)) {
				System.out.println("로그인한 사용자만 이용할 수 있습니다");
				sc.close();
				return;
			}

			while (true) {
				printMenu();
				System.out.print("메뉴 번호 입력 : ");

				int num = sc.nextInt();
				sc.nextLine();

				switch (num) {
				case 1:
					insertBook(sc);
					break;
				case 2:
					listBook();
					break;
				case 3:
					detailBook(sc);
					break;
				case 4:
					updateBook(sc);
					break;
				case 5:
					deleteBook(sc);
					break;
				case 6:
					System.out.println("종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("다시 입력하세요.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean login(Scanner sc) {
		System.out.println("***************");
		System.out.println("로그인");
		System.out.println("***************");

		System.out.print("회원번호: ");
		String clientNo = sc.nextLine();

		System.out.print("비밀번호: ");
		String clientPassword = sc.nextLine();

		if (clientDao.login(clientNo, clientPassword)) {
			System.out.println("로그인 성공!");
			return true;
		} else {
			System.out.println("로그인 실패!");
			return false;
		}

	}

	private static void printMenu() {
		System.out.println("***************");
		System.out.println("도서 관리 프로그램");
		System.out.println("***************");
		System.out.println("다음 메뉴에서 선택");
		System.out.println("1. 도서 등록");
		System.out.println("2. 전체 도서 조회");
		System.out.println("3. 상세 도서 조회");
		System.out.println("4. 도서 정보 수정");
		System.out.println("5. 도서 정보 삭제");
		System.out.println("6. 종료");
		System.out.println("-----------------");
	}

	private static void insertBook(Scanner sc) {
		BookDTO dto = ReadWrite.getBookInfo(sc);
		if (dto == null)
			return;
		bookDao.insertBook(dto);
	}

	private static void listBook() {
		ArrayList<BookDTO> bookList = bookDao.listBook();
		if (bookList == null || bookList.size() == 0) {
			System.out.println("도서 정보가 없습니다");
			return;
		}
		ReadWrite.writeBookInfo(bookList);
	}

	private static void detailBook(Scanner sc) {
		System.out.println("도서 번호를 입력하세요");
		String bookNo = sc.nextLine();
		BookDTO dto = bookDao.detailBook(bookNo);

		if (dto != null) {
			ReadWrite.writeBookInfo(dto);
		} else {
			System.out.println("해당 도서가 없습니다");
		}
	}

	private static void updateBook(Scanner sc) {
		System.out.println("도서 번호를 입력하세요");
		String bookNo = sc.nextLine();
		BookDTO dto = bookDao.detailBook(bookNo);

		if (dto != null) {
			ReadWrite.writeBookInfo(dto);
			bookDao.updateBook(ReadWrite.getBookInfo(sc, bookNo));
		}
	}

	private static void deleteBook(Scanner sc) {
		System.out.println("도서 번호를 입력하세요");
		String bookNo = sc.nextLine();
		bookDao.deleteBook(bookNo);
	}

}
