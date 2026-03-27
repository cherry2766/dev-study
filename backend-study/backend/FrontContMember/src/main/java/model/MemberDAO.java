package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	//connection pool 사용하기 위한 DataSource 인스턴스 생성
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			conn = dataFactory.getConnection();
			String sql = "select * from member2";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String memId = rs.getString("memId");
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				MemberVO dto = new MemberVO(memId,memPwd,memName,memEmail,memJoinDate);
				
				memberList.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("회원 정보 조회 실패");
			e.printStackTrace();
		}
		return memberList;
	}
	
	public void addMember(MemberVO m) {
		try {
			conn = dataFactory.getConnection();
			  String id = m.getId();
			  String pwd = m.getPwd();
			  String name = m.getName();
			  String email = m.getEmail();
			  String query = "INSERT INTO member2 (memid, mempwd, memname, mememail)" + " VALUES(?, ? ,? ,?)";

			  pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, id);
			  pstmt.setString(2, pwd);
			  pstmt.setString(3, name);
			  pstmt.setString(4, email);
			  pstmt.executeUpdate();
			  pstmt.close();
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO findMember(String _id) {
		MemberVO memInfo = null;
		try {
			  conn = dataFactory.getConnection();
			  String query = "select * from  member2 where memid=?";
			  pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, _id);

			  ResultSet rs = pstmt.executeQuery();
			  while(rs.next()) {
				  String id = rs.getString("memid");
				  String pwd = rs.getString("mempwd");
				  String name = rs.getString("memname");
				  String email = rs.getString("mememail");
				  Date joinDate = rs.getDate("memjoinDate");
				  memInfo = new MemberVO(id, pwd, name, email, joinDate);
			  }	  
			  pstmt.close();
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memInfo;
	}
	
	public void modMember(MemberVO memberVO) {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		
		try {
			String sql = "update member2 set mempwd=?, memname=?, mememail=? where memid=?";
			conn = dataFactory.getConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, pwd);
			  pstmt.setString(2, name);
			  pstmt.setString(3, email);
			  pstmt.setString(4, id);
			  pstmt.executeUpdate();
			  pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String _id) {
		try {
			String sql = "delete from member2 where memid=?";
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
