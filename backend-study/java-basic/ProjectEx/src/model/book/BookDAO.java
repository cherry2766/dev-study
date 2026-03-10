package model.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import util.DBConnect;

public class BookDAO implements IBookDAO {

	@Override
	public boolean insert(BookDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book values(?,?,?,?,?,?,?)";

		con = DBConnect.getConnection();
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getBookNo());
		pstmt.setString(2, dto.getBookName());
		pstmt.setString(3, dto.getBookAuthor());
		pstmt.setInt(4, dto.getBookPrice());
		pstmt.setString(5, dto.getBookDate());
		pstmt.setInt(6, dto.getBookStock());
		pstmt.setString(7, dto.getPubNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(con, pstmt);

		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean update(BookDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBConnect.getConnection();
		String sql = "update book set bookName=?, bookAuthor=?, bookPrice=?,bookDate=?, bookStock=? where bookNo=?";

		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getBookName());
		pstmt.setString(2, dto.getBookAuthor());
		pstmt.setInt(3, dto.getBookPrice());
		pstmt.setString(4, dto.getBookDate());
		pstmt.setInt(5, dto.getBookStock());
		pstmt.setString(6, dto.getBookNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(con, pstmt);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(BookDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from book where bookNo=?";
		con = DBConnect.getConnection();
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getBookNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(con, pstmt);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Vector<BookDTO> getAllBook() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BookDTO> dataSet = null;
		String sql = "select * from book order by bookNo";
		con = DBConnect.getConnection();
		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		dataSet = new Vector<BookDTO>();

		while (rs.next()) {
			dataSet.add(new BookDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getDate(5).toString(), // YYYY-MM-DD만 출력
					rs.getInt(6), rs.getString(7)

			));
		}
		DBConnect.close(con, pstmt, rs);

		return dataSet;
	}

	@Override
	public ArrayList<BookPublisherDTO> getBookByPublisher(String pubName) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookPublisherDTO> list = new ArrayList<>();
		con = DBConnect.getConnection();
		String sql = "select p.pubName, b.bookName from book b join publisher p on b.pubNo = p.pubNo where p.pubName=? order by p.pubName";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, pubName);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			list.add(new BookPublisherDTO(rs.getString(1), rs.getString(2)));
		}
		DBConnect.close(con, pstmt, rs);

		return list;
	}

	@Override
	public int selectStock(Connection con, String bookNo) throws Exception {
		// 재고 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select bookStock from book where bookNo = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bookNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("bookStock");
			} else {
				throw new Exception("해당 도서가 존재하지 않습니다.");
			}
		} finally {
			DBConnect.close(pstmt, rs);
		}
	}

	@Override
	public boolean updateStock(Connection con, String bookNo, int diff) throws Exception {
		// 재고 변경
		PreparedStatement pstmt = null;
		try {
			String sql = "update book set bookStock = bookStock + ? where bookNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, diff);
			pstmt.setString(2, bookNo);

			int result = pstmt.executeUpdate();
			return result > 0;
		} finally {
			DBConnect.close(pstmt);
		}
	}
}
