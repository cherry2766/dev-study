package sec06.book;

import java.util.ArrayList;

public interface IBookDAO {
	// 도서 등록
	public void insertBook(BookDTO dto);

	// 전체 도서 정보 조회
	public ArrayList<BookDTO> listBook();
	
	// 도서 상세 조회
	public BookDTO detailBook(String bookNo);

	// 도서 정보 수정
	public void updateBook(BookDTO dto);

	// 도서 정보 삭제
	public void deleteBook(String bookNo);

}
