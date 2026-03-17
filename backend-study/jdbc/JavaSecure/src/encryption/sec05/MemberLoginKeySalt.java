package encryption.sec05;

import encryption.sec01.DBConnect;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberLoginKeySalt {

    public static void main(String[] args) throws Exception {

        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null; //select 구문

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("ID 입력 : ");
            String memID = sc.nextLine();
            System.out.print("비밀번호 입력 : ");
            String memPass = sc.nextLine();

            //select 쿼리문 작성, id 값으로 조회
            String sql = "select * from member where memID = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memID);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                // 비밀번호와 솔트 값 가져오기
                String dbPassword = rs.getString("MEMPWD");
                String dbSalt = rs.getString("MEMSALT");

                String hashPassword = MemberJoinKeySalt.Hashing(memPass.getBytes(), dbSalt);

                if (hashPassword.equals(dbPassword)) {
                    System.out.println("로그인 되었습니다");
                } else {
                    System.out.println("로그인 실패");
                }
            }else {
                System.out.println("아이디가 존재하지 않습니다");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(con, pstmt, rs);
            sc.close();
        }

    }
}
