package sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO implements IMemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void save(MemberVO member) {
		try {
			con = DBConnect.getConnection();
			
			String sql = "insert into member2 (memId, memPwd, memName, memEmail) values (?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPwd());
			pstmt.setString(3, member.getMemName());
			pstmt.setString(4, member.getMemEmail());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public MemberVO login(String memId, String memPwd) {
		MemberVO vo = null;
		try {
			con = DBConnect.getConnection();
			
			String sql = "select * from member2 where memId=? and memPwd=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new MemberVO();
				
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				Date date = rs.getDate("memJoinDate");
				String email = rs.getString("memEmail");	
				
				vo.setMemId(id);
				vo.setMemPwd(pwd);
				vo.setMemName(name);
				vo.setMemJoinDate(date);
				vo.setMemEmail(email);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public MemberVO memberFindById(String memId) {
		MemberVO vo = null;
		try {
			con = DBConnect.getConnection();
			
			String sql = "select * from member2 where memId=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new MemberVO();
				
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				Date date = rs.getDate("memJoinDate");
				String email = rs.getString("memEmail");	
				
				vo.setMemId(id);
				vo.setMemPwd(pwd);
				vo.setMemName(name);
				vo.setMemJoinDate(date);
				vo.setMemEmail(email);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;		
	}

	@Override
	public ArrayList<MemberVO> memberFindAll() {
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		MemberVO vo = null;
		try {
			con = DBConnect.getConnection();
			
			String sql = "select * from member2";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				Date date = rs.getDate("memJoinDate");
				String email = rs.getString("memEmail");	
				
				vo = new MemberVO();
				
				vo.setMemId(id);
				vo.setMemPwd(pwd);
				vo.setMemName(name);
				vo.setMemJoinDate(date);
				vo.setMemEmail(email);
				
				memList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memList;		
		
	}

}
