package com.spring_mvc.jdbc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring_mvc.jdbc.dto.MemberDTO;

//DBMS와 연동해서 비즈니스 로직 처리하는 클래스 : 외부자원 활용(스프링 컨테이너가 관리)
//db연결 역할의 bean으로 등록
@Repository
public class MemberDAO {
	
	private DataSource dataFactory;
	
	/*
	 * //자동 주입
	 * @Autowired
	 * @Qualifier("memberDTO") private MemberDTO dto;
	 */
	
	@Autowired
	public MemberDAO(DataSource dataSource) {
		try {
			this.dataFactory = dataSource;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보 조회 메서드
	public ArrayList<MemberDTO> memberSelect() {
		Connection con = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		try {
			con = dataFactory.getConnection(); //dbcp에서 con 객체 할당
			
			String sql = "select * from member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String memId = rs.getString("memId"); // 순서 번호 1, 2, 3... 사용해도 되고, 열 이름 사용해도 됨
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				//동적 객체가 생성되어야 하는 경우에는 DI를 통한 자동주입은 효율적이지 못함
				MemberDTO dto = new MemberDTO();
				dto.setMemId(memId);
				dto.setMemName(memName);
				dto.setMemPwd(memPwd);
				dto.setMemEmail(memEmail);
				dto.setMemJoinDate(memJoinDate);
				
				memList.add(dto);
			}
		}catch(Exception e) {
			
		}
		
		return memList;
	}

}
