package sec01;

import java.sql.Connection; // DBMS와 session을 연결하고 관리하는 객체
import java.sql.DriverManager; // DBMS와 통신 담당

public class DBTestConn {

	public static void main(String[] args) {
		// 접속(Connection) 객체 선언
		Connection con = null;
		// DB 연결은 외부 자원을 사용 - 외부 시스템과 통신
		// 예외처리 필요
		try {
			//1. JDBC DRIVER 로드 : 런타임시 로드(자동 로드 : 생략 가능)
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 객체 인스턴스 생성 - db위치(주소:url),계정명, 비밀번호
			//DriverManager를 통해 접속 시도 DriverManager.getConnection(url,user,pwd)
			//url : jdbc종류:@ip주소:포트(윈도우1521):sid
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";
			con = DriverManager.getConnection(url,user,pwd); // DB연결을 성공하면 객체가 반환됨 / 실패하면 null값이 반환됨
			
			if(con != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
		} catch(Exception e) {
			e.printStackTrace(); // 오류 발생할때까지의 과정을 추적해서 오류 내용 출력
		}

	}

}
