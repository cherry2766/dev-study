package sec03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUDTestInput2 {

	public static void main(String[] args) {
		// 필요 참조변수 선언 및 생성
		DBConnect dbCon = new DBConnect();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		String sql = null;
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;

		try {
			con = dbCon.getConnection();
			sql = "insert into book values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			// 사용자로부터 데이터 입력
			System.out.print("도서번호 입력 : ");
			bookNo = sc.nextLine();

			System.out.print("도서제목 입력 : ");
			bookTitle = sc.nextLine();

			System.out.print("도서저자 입력 : ");
			bookAuthor = sc.nextLine();

			System.out.print("도서가격 입력 : ");
			// bookPrice = sc.nextInt(); // 사용자가 enter를 넣었을 때 엔터 바로 앞 입력까지만 처리
			// 다음 입력으로 enter가 넘어감 -> nextLine()을 사용
			bookPrice = Integer.parseInt(sc.nextLine());
			System.out.print("발행일 입력 : ");
			bookDate = sc.nextLine();

			System.out.print("도서재고 입력 : ");
			bookStock = Integer.parseInt(sc.nextLine());

			System.out.print("출판사번호 입력 : ");
			pubNo = sc.nextLine();

			// pstmt 객체 sql에 데이터 바인딩
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookTitle);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);

			// 질의 전달 및 실행
			int tmpResult = pstmt.executeUpdate();
			if (tmpResult == 1) {
				System.out.println("도서정보 등록 성공");
			}

			// 등록된 값 확인 : select 절
			sql = "select * from book";
			rs = pstmt.executeQuery(sql); // pstmt 객체 위에서 구문분석 되어 있음, sql 수정 가능

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bkDate = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bkDate, bookStock, pubNo);
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
