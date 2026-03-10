package model.booksale;

import java.sql.Connection;
import java.util.ArrayList;

public interface IBookSaleDAO {
	public boolean create(Connection con, BookSaleDTO dto) throws Exception;
	// 구매

	public boolean update(Connection con, BookSaleDTO dto) throws Exception;
	// 구매내역 수정

	public boolean delete(Connection con, String bsNo) throws Exception;
	// 구매내역 취소

	public ArrayList<BookSaleReadDTO> selectAll() throws Exception;
	// 전체 구매내역 조회

	public ArrayList<BookSaleReadDTO> selectByBsNo(String bsNo) throws Exception;
	// 구매 번호로 1건 조회
}
