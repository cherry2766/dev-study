package model.book;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

public interface IBookDAO {
	public boolean insert(BookDTO dto) throws Exception; // 오류 처리는 메서드를 호출한 쪽으로 전달함

	public boolean update(BookDTO dto) throws Exception;

	public boolean delete(BookDTO dto) throws Exception;

	public Vector<BookDTO> getAllBook() throws Exception;

	public ArrayList<BookPublisherDTO> getBookByPublisher(String pubName) throws Exception;

	public int selectStock(Connection con, String bookNo) throws Exception;
	// 재고 조회

	public boolean updateStock(Connection con, String bookNo, int diff) throws Exception;
	// 재고 수정
}
