package sec03;

import java.sql.Connection;
import java.sql.Statement;
import sec02.DBConnect;

public class CRUDTest {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		DBConnect dbCon = new DBConnect();
		
		try {
			con = dbCon.getConnection();
			stmt = con.createStatement();
			// insert 구문 : 정해진 값을 이용해서 질의어 작성
			String sql = "insert into book values('100','자바','김바로',10000,'2021-03-01',5,'2')";
			// insert 등의 쿼리는 데이터 삽입 후 실행 종료
			// insert/update/delete 질의 : executeUpdate(), select : executeQuery()
			// Statement 객체는 매번 형식검사(전처리)를 진행함
			int tmpResult = stmt.executeUpdate(sql);
			if(tmpResult == 1) {
			System.out.println("인서트 성공");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
