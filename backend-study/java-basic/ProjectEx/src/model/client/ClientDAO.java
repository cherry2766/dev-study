package model.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.client.ClientDTO;
import util.DBConnect;

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
	public ArrayList<ClientDTO> getAllClient() throws Exception {
		clientList = new ArrayList<ClientDTO>();
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

			client = new ClientDTO(clientNo, clientName, clientPassword, clientPhone, clientAddress, clientBirth,
					clientHobby, clientGender);
			clientList.add(client);
		}

		DBConnect.close(pstmt, rs);
		return clientList;
	}

	@Override
	public boolean insert(ClientDTO dto) throws Exception {
		String sql = "insert into client values(?,?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getClientNo());
		pstmt.setString(2, dto.getClientName());
		pstmt.setString(3, dto.getClientPhone());
		pstmt.setString(4, dto.getClientAddress());
		pstmt.setDate(5, dto.getClientBirth());
		pstmt.setString(6, dto.getClientHobby());
		pstmt.setString(7, dto.getClientGender());
		pstmt.setString(8, dto.getClientPassword());

		int result = pstmt.executeUpdate();

		DBConnect.close(pstmt);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ClientDTO dto) throws Exception {
		String sql = "update client set clientName=?, clientPhone=?,clientAddress=?,clientBirth=?,clientHobby=? where clientNo=?";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getClientName());
		pstmt.setString(2, dto.getClientPhone());
		pstmt.setString(3, dto.getClientAddress());
		pstmt.setDate(4, dto.getClientBirth());
		pstmt.setString(5, dto.getClientHobby());
		pstmt.setString(6, dto.getClientNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(pstmt);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(ClientDTO dto) throws Exception {
		String sql = "delete from client where clientNo=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getClientNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(pstmt);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean login(ClientDTO dto) throws Exception {
		String sql = "select * from client where clientNo=? and clientPassword=?";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getClientNo());
		pstmt.setString(2, dto.getClientPassword());

		rs = pstmt.executeQuery();
		boolean res = rs.next();
		DBConnect.close(pstmt, rs);
		if (res) {
			return true;
		} else
			return false;
	}

}
