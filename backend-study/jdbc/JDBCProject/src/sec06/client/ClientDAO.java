package sec06.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sec06.DBConnect;

public class ClientDAO implements IClientDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ClientDTO client = null;
	ArrayList<ClientDTO> clientList = null;

	public ClientDAO() {
		con = DBConnect.getConnection();
	}

	@Override
	public void insertClient(ClientDTO dto) {
		// 회원 등록

		try {
			String sql = "insert into client values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getClientNo());
			pstmt.setString(2, dto.getClientName());
			pstmt.setString(3, dto.getClientPhone());
			pstmt.setString(4, dto.getClientAddress());
			pstmt.setDate(5, new java.sql.Date(dto.getClientBirth().getTime()));
			pstmt.setString(6, dto.getClientHobby());
			pstmt.setString(7, dto.getClientGender());
			pstmt.setString(8, dto.getClientPassword());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원가입이 완료되었습니다");
			}

		} catch (SQLException e) {
			System.out.println("회원가입에 실패했습니다");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}

	}

	@Override
	public ArrayList<ClientDTO> listClient() {
		// 전체 회원 조회
		clientList = new ArrayList<ClientDTO>();

		try {
			String sql = "select * from client order by clientNo";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String clientNo = rs.getString(1);
				String clientName = rs.getString(2);
				String clientPhone = rs.getString(3);
				String clientAddress = rs.getString(4);
				Date clientBirth = rs.getDate(5);
				String clientHobby = rs.getString(6);
				String clientGender = rs.getString(7);
				String clientPassword = rs.getString(8);

				client = new ClientDTO(clientNo, clientName, clientPhone, clientAddress, clientBirth, clientHobby,
						clientGender, clientPassword);
				clientList.add(client);
			}
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return clientList;
	}

	@Override
	public ClientDTO detailClient(String clientNo) {
		// 회원 상세 조회

		try {
			String sql = "select * from client where clientNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clientNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				clientNo = rs.getString(1);
				String clientName = rs.getString(2);
				String clientPhone = rs.getString(3);
				String clientAddress = rs.getString(4);
				Date clientBirth = rs.getDate(5);
				String clientHobby = rs.getString(6);
				String clientGender = rs.getString(7);
				String clientPassword = rs.getString(8);

				client = new ClientDTO(clientNo, clientName, clientPhone, clientAddress, clientBirth, clientHobby,
						clientGender, clientPassword);
			} else {
				System.out.println("해당하는 회원번호의 회원 정보가 없습니다");
			}

		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return client;
	}

	@Override
	public void updateClient(ClientDTO dto) {
		// 회원 정보 수정
		String sql = "update client set clientName=?, clientPhone=?,clientAddress=?,clientBirth=?, clientHobby=?, clientGender=?, clientPassword=? where clientNo=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getClientName());
			pstmt.setString(2, dto.getClientPhone());
			pstmt.setString(3, dto.getClientAddress());
			pstmt.setDate(4, new java.sql.Date(dto.getClientBirth().getTime()));
			pstmt.setString(5, dto.getClientHobby());
			pstmt.setString(6, dto.getClientGender());
			pstmt.setString(7, dto.getClientPassword());
			pstmt.setString(8, dto.getClientNo());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("회원 정보가 수정되었습니다");
			} else {
				System.out.println("회원번호에 해당하는 회원 정보가 없습니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}

	}

	@Override
	public void deleteClient(String clientNo) {
		// 회원 정보 삭제
		String sql = "delete from client where clientNo = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clientNo);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원 탈퇴가 완료되었습니다");
			} else {
				System.out.println("회원번호에 해당하는 회원이 없습니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}

	}

	@Override
	public boolean login(String clientNo, String clientPassword) {
		// 로그인 여부 확인

		boolean result = false;

		try {
			String sql = "select * from client where clientNo=? and clientPassword=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, clientNo);
			pstmt.setString(2, clientPassword);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과가 있으면 로그인 성공
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return result;
	}

}
