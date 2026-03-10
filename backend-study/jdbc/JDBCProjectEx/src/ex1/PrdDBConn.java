package ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrdDBConn {
	public Connection getPrdDBConn() {
		Connection con = null;

		try {
			// DB 위치, 계정명, 비밀번호
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";

			// DriverManager.getConnection()를 통해 DB 연결 시도, 성공하면 객체 반환, 실패하면 null
			con = DriverManager.getConnection(url, user, pwd);

			if (con != null) {
				System.out.println("연결 성공!");
			} else {
				System.out.println("연결 실패!");
			}

			return con;
		} catch (Exception e) {
			e.printStackTrace(); // 에러 발생하면 오류 출력
			return null;
		}

	}

}
