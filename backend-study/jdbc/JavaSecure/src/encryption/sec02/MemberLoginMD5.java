package encryption.sec02;

import encryption.sec01.DBConnect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberLoginMD5 {
    // 로그인 할 때 사용할 해시 생성 메서드는 join할때 사용했던 메서드와 모든 연산이 동일해야 함
    public static String md5(String pass) {
        String encData = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = pass.getBytes();
            // 해시로 변환할 데이터를 digest에 전달하면 update 메서드는 해시구성 구조에 맞게끔 구조 변환
            md.update(bytes);
            // update된 데이터를 byte 배열 타입의 해시값으로 변경해서 반환함
            byte[] digest = md.digest();
            System.out.println("byte 타입 해시값 : " + digest);
            //byte 타입의 해시값을 문자열로 변환
            for (int i = 0; i < digest.length; i++) {
                encData += Integer.toHexString(digest[i] & 0xff);
            }
            System.out.println(encData);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encData;
    }

    public static void main(String[] args) {

        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null; //select 구문

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("ID 입력 : ");
            String memID = sc.nextLine();
            System.out.print("비밀번호 입력 : ");
            String memPass = md5(sc.nextLine());

            //select 쿼리문 작성
            String sql = "select * from member where memID = '" + memID + "'" + "and memPWD = '" + memPass + "'";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //회원가입 진행 시 중복 아이디 허용하지 않았다고 가정
            //위 쿼리가 진행되었다면 한명에 대한 정보가 나오거나 정보가 추출되지 않았을 것임
            if (rs.next()) {
                System.out.println("로그인 되었습니다");
                //웹에서는 로그인되었다면 자격증명을 포함해서 클라이언트에게 전달
            } else {
                System.out.println("로그인 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(con, pstmt, rs);
            sc.close();
        }

    }
}
