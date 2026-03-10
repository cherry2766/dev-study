package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductMain {

	public static void main(String[] args) {
		PrdDBConn dbCon = new PrdDBConn();
		Connection con = null; // 연결
		Statement st = null; // 질의어 DB한테 전달하고 실행 후 반환
		ResultSet rs = null; // 반환 받은 객체 저장 select 만 필요

		try {
			con = dbCon.getPrdDBConn();
			st = con.createStatement();
			String sql = "SELECT * FROM client ORDER BY clientNo"; // product 테이블에 데이터가 하나도 없어서 이걸로 했습니다
			rs = st.executeQuery(sql);

			System.out.println("----------------전체 회원 정보 조회----------------");
			System.out.println("회원번호 \t 회원이름 \t 전화번호 \t 주소 \t 생년월일 \t 취미 \t 성별");

			while (rs.next()) {
				String clientNo = rs.getString(1);
				String clientName = rs.getString(2);
				String clientPhone = rs.getString(3);
				String clientAddress = rs.getString(4);
				Date clientBirth = rs.getDate(5);
				String clientHobby = rs.getString(6);
				String clientGender = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6s %13s \t%3s %10s\n", clientNo, clientName, clientPhone,
						clientAddress, clientBirth, clientHobby, clientGender);
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
