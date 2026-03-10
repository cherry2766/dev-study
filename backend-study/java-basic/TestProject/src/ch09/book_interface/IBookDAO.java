package ch09.book_interface;

import java.util.ArrayList;

//컨트롤러와 DAO의 중간자 역할, 인터페이스 생성
public interface IBookDAO {
	// 추상 메서드 생성

	// 책 등록 : 1개의 책 정보를 받아서 DB에 저장
	public void insertBook(BookDTO dto);

	// 책 정보 삭제 : 책의 아이디를 전달받아서 삭제
	public boolean deleteBook(String id);

	// 전체 책 목록 조회
	// DB에서 BookDTO 객체들을 담고 있는 전체 책 정보(ArrayList)를 반환
	public ArrayList<BookDTO> getAllBook();

	// 책 1권 조회 - id 를 받고 DB에서 검색 후 정보 반환
	public BookDTO searchBook(String id);

	// 책 정보 수정, 책이 존재할때만 수정
	public boolean updateBook(BookDTO dto);

	// 책 재고 수정, 책이 존재할때만 재고 변경
	public boolean updateStock(String id, int diff);
}
