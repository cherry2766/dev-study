package model.booksale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBConnect;

public class BookSaleDAO implements IBookSaleDAO {

	@Override
	public boolean create(Connection con, BookSaleDTO dto) throws Exception {
		// 구매
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into booksale values(booksale_seq.nextval,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, dto.getBsQty());
			pstmt.setString(2, dto.getClientNo());
			pstmt.setString(3, dto.getBookNo());

			int result = pstmt.executeUpdate();
			return result > 0;

		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public boolean update(Connection con, BookSaleDTO dto) throws Exception {
		// 구매내역 수정
		PreparedStatement pstmt = null;
		try {
			String sql = "update bookSale set bsQty=? where bsNo=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBsQty());
			pstmt.setString(2, dto.getBsNo());

			int result = pstmt.executeUpdate();
			return result > 0;
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public boolean delete(Connection con, String bsNo) throws Exception {
		// 구매내역 취소
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from bookSale where bsNo=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bsNo);

			int result = pstmt.executeUpdate();
			return result > 0;
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public ArrayList<BookSaleReadDTO> selectAll() throws Exception {
		// 전체 구매내역 조회
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookSaleReadDTO> orderList = new ArrayList<>();

		con = DBConnect.getConnection();
		String sql = "select bs.bsNo, c.clientName, b.bookname, b.bookprice, bs.bsQty, bs.bsDate "
				+ "from bookSale bs join book b on bs.bookNo = b.bookNo join client c "
				+ "on bs.clientNo = c.clientNo order by bs.bsNo";

		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			orderList.add(new BookSaleReadDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getInt(5), rs.getDate(6)));
		}
		DBConnect.close(con, pstmt, rs);
		return orderList;
	}

	@Override
	public ArrayList<BookSaleReadDTO> selectByBsNo(String bsNo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookSaleReadDTO> orderList = new ArrayList<>();
		con = DBConnect.getConnection();
		String sql = "select bs.bsNo, c.clientName, b.bookname, b.bookprice, bs.bsQty, bs.bsDate "
				+ "from bookSale bs join book b on bs.bookNo = b.bookNo join client c "
				+ "on bs.clientNo = c.clientNo where bs.bsNo = ? order by bs.bsNo";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bsNo);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			orderList.add(new BookSaleReadDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getInt(5), rs.getDate(6)));
		}
		DBConnect.close(con, pstmt, rs);
		return orderList;
	}

	public BookSaleDTO select(Connection con, String bsNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select bsNo, clientNo, bookNo, bsQty from bookSale where bsNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bsNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return new BookSaleDTO(rs.getString("bsNo"), rs.getString("clientNo"), rs.getString("bookNo"),
						rs.getInt("bsQty"));
			} else {
				throw new Exception("해당 주문이 존재하지 않습니다.");
			}

		} finally {
			DBConnect.close(pstmt, rs);
		}
	}

}
