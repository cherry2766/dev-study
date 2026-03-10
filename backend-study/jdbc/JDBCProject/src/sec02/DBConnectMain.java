package sec02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectMain {

	public static void main(String[] args) {
		// DB 연결 TEST
		Connection con = null; // 외부 자원 DB 사용
		DBConnect dbCon = new DBConnect(); // DB 연결 담당클래스 참조변수
		Statement stmt = null; // 외부 자원 DB 사용
		ResultSet rs = null; // 외부 자원 DB 사용, 사용 종료 후에 close()해야 함
		
		// DB 테이블 사용 - SELECT 구문 실행
		// 쿼리문을 DBMS에 전송하기 위해 필요한 객체 생성 : Statement 객체 생성
		// select 문 결과 객체를 받기 위한 객체 생성 : resultSet 객체 생성
		// Statement : 질의어를 DBMS에게 전달, 전달된 결과 값을 반환
		// insert/update/delete : 실행한 수가 수치로 반환됨
		
		try {
			con = dbCon.getConnection(); // DB 연결 요청
			stmt = con.createStatement(); // statement 객체 인스턴스 반환
			String sql = "select * from book order by bookno";
			
			// 질의어가 select 이므로 Statement.executeQuery(질의문자열) : 반환값으로 view(ResultSet) 객체가 반환
			rs = stmt.executeQuery(sql);
			
			// 오류 없이 반환된 값이 있으면
			// 반환값 접근하고 필요한 경우 가져다가 사용(프린트진행예정)
			System.out.println("-----------------------전체 도서 정보 조회-----------------------");
			System.out.println("도서번호 \t 도서명 \t 저자 \t 가격 \t 발행일 \t 재고 \t 출판사번호");
			
			// ResultSet 객체 활용 전달된 질의 결과를 순회하면서 변수에 담기
			// ResultSet.next() : 포인터 이동 후 참조해야하는 레코드가 있으면 true, 없으면 false
			while(rs.next()) {
				//현재 rs 참조하는 레코드의 각 컬럼의 값을 반환 받아서 변수에 저장
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", 
						bookNo,bookName, bookAuthor, bookPrice,bookDate, bookStock, pubNo);
			}	
			// 생성된 객체를 닫을때는 생성 순서의 반대로 닫음
			rs.close();
			stmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
