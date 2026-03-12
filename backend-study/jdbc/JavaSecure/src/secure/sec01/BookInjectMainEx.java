package secure.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookInjectMainEx {
    public static void main(String[] args) {

        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("도서 번호 입력 : ");
            String bookNo = sc.nextLine();

            String sql = "select * from book where bookNo='" + bookNo + "'";

            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

            System.out.println("------------- 도서 정보 조회 -------------");
            System.out.println("도서번호   \t 도서이름 \t\t\t\t 저자");

            while (rs.next()) {
                bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);

                System.out.format("%-10s\t %-20s\t %6s \n", bookNo, bookName, bookAuthor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
