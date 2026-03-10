package ch09.book_interface;

import java.util.ArrayList;

public class BookDAO implements IBookDAO {

	private ArrayList<BookDTO> books = new ArrayList<>(); // BookDTO 객체를 담고 있는 ArrayList 타입의 인스턴스 생성

	@Override
	public void insertBook(BookDTO dto) {
		books.add(dto); // 전달받은 객체를 ArrayList에 추가
	}

	@Override
	public boolean deleteBook(String id) { // 책 id를 받아서 ArrayList에 해당 id의 책이 있는지 확인 후 있을때만 삭제
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId().equals(id)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<BookDTO> getAllBook() { // 전체 책 목록 반환
		return books;
	}

	@Override
	public BookDTO searchBook(String id) { // 책 id를 받아서 ArrayList에 해당 id의 책이 있으면 책 1개 반환, 없으면 null
		for (BookDTO book : books) {
			if (book.getId().equals(id))
				return book;
		}
		return null;
	}

	@Override
	public boolean updateBook(BookDTO dto) { // ArrayList에 id가 일치하는 책이 있을 때만 정보 수정

		BookDTO book = searchBook(dto.getId());
		if (book == null) {
			return false;
		}

		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPublisher(dto.getPublisher());
		book.setPublishedDate(dto.getPublishedDate());
		book.setImageUrl(dto.getImageUrl());
		book.setPrice(dto.getPrice());

		return true;
	}

	@Override
	public boolean updateStock(String id, int diff) { // 재고 수정하는 메서드

		BookDTO book = searchBook(id); 
		if (book == null) {
			return false; // ArrayList에 책이 없으면 false
		}

		int newStock = book.getStock() + diff; // 재고 계산
		if (newStock < 0) {
			return false; // 재고가 마이너스일 수 없으므로 false
		}

		book.setStock(newStock); // 기존 책의 재고를 변경
		return true;
	}

}
