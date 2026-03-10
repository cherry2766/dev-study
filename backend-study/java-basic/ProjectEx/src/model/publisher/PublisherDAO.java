package model.publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBConnect;

public class PublisherDAO implements IPublisherDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PublisherDTO publisher = null;
	ArrayList<PublisherDTO> publisherList = null;

	public PublisherDAO() {
		con = DBConnect.getConnection();
	}

	@Override
	public boolean insert(PublisherDTO dto) throws Exception {
		// 출판사 등록
		String sql = "insert into publisher values(?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getPubNo());
		pstmt.setString(2, dto.getPubName());

		int result = pstmt.executeUpdate();

		DBConnect.close(pstmt);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(PublisherDTO dto) throws Exception {
		// 출판사 수정
		String sql = "update publisher set pubName=? where pubNo=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getPubName());
		pstmt.setString(2, dto.getPubNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(pstmt);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(PublisherDTO dto) throws Exception {
		// 출판사 삭제
		String sql = "delete from publisher where pubNo=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getPubNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(pstmt);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<PublisherDTO> getAllPublisher() throws Exception {
		// 출판사 조회
		publisherList = new ArrayList<PublisherDTO>();
		String sql = "select * from publisher order by pubNo";
		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			String pubNo = rs.getString(1);
			String pubName = rs.getString(2);

			publisher = new PublisherDTO(pubNo, pubName);
			publisherList.add(publisher);
		}

		DBConnect.close(pstmt, rs);
		return publisherList;
	}

}
