package ex2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookEx {

	public static void main(String[] args) {
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("====== 메뉴 선택 ======");
			System.out.println("1. 총 도서 권수 확인");
			System.out.println("2. 년도 별 도서 검색");
			System.out.println("3. 저자 검색");
			System.out.println("4. 가격 별 도서 검색");
			System.out.println("5. 종료");

			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				printBookCount(con);
				break;
			case 2:
				printBookDate(con, sc);
				break;
			case 3:
				printBookAuthor(con, sc);
				break;
			case 4:
				printBookPrice(con, sc);
				break;
			case 5:
				System.out.println("종료");
				break;
			default:
				System.out.println("잘못 선택하였습니다");

			}
			if (num == 5)
				return;
		}
	}

	public static void printBookCount(Connection con) {
		String sql = "SELECT COUNT(*) FROM book";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int count = rs.getInt(1);
				System.out.println("총 도서 권수 : " + count + "권");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printBookDate(Connection con, Scanner sc) {
		String sql = "SELECT bookName FROM book WHERE bookDate >= ?";

		try {
			System.out.print("발행년도 입력 : ");
			String year = sc.nextLine();
			Date bookDate = Date.valueOf(year + "-01-01");

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, bookDate);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String bookName = rs.getString(1);
				System.out.println(bookDate + " 이후 발행된 도서 : " + bookName);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printBookAuthor(Connection con, Scanner sc) {
		String sql = "SELECT bookName FROM book WHERE bookAuthor LIKE ?";

		try {
			System.out.print("저자명 입력 : ");
			String bookAuthor = sc.nextLine();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + bookAuthor + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String bookName = rs.getString(1);
				System.out.println(bookAuthor + "이 포함된 저자의 도서명 : " + bookName);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printBookPrice(Connection con, Scanner sc) {
		String sql = "SELECT BookName FROM book WHERE bookPrice >= ?";

		try {
			System.out.print("도서가격 입력 : ");
			int bookPrice = Integer.parseInt(sc.nextLine());
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookPrice);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String bookName = rs.getString(1);
				System.out.println(bookPrice + "원 이상인 도서명 : " + bookName);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
