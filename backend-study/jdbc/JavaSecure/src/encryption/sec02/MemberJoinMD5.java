package encryption.sec02;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoinMD5 {

    public static String md5(String message) {
        String encData = "";
        try {
            //getInstance("암호화 알고리즘")
            MessageDigest md = MessageDigest.getInstance("MD5");

            //md5는 byte타입의 파라미터를 요구함 - 전달된 평문 비밀번호를 byte 타입으로 변환
            byte[] bytes = message.getBytes();

            //byte로 변환된 비밀번호를 md5 알고리즘에 대입(update())
            md.update(bytes); //암호 알고리즘 인스턴스에 평문 데이터가 전달됨

            //digest() - 데이터 해시 처리 후 반환(반환 값 byte타입 값)
            byte[] digest = md.digest();

            //해시된 비밀번호를 문자열로 변환
            System.out.println(digest);

            //byte배열에 각각 해시된 값이 들어 있으므로 배열 원소 하나씩 문자열로 변경
            for (int i = 0; i < digest.length; i++) {
                encData += Integer.toHexString(digest[i] & 0xff); // 16진수 변환
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encData;
    }

    public static void main(String[] args) {
        // 취약한 패스워드 저장1 : plan text 그대로 저장
        encryption.sec01.DBConnect dbCon = new encryption.sec01.DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("ID 입력 : ");
            String memID = sc.nextLine();
            System.out.print("비밀번호 입력 : ");
            String memPass = md5(sc.nextLine()); //md5로 해시된 값이 변수에 저장
            System.out.println(memPass);

            System.out.print("이름 입력 : ");
            String memName = sc.nextLine();
            System.out.print("e-mail 입력 : ");
            String memEmail = sc.nextLine();

            //회원가입 시간
            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String memJoinDate = now.format(formatter);

            String sql = "insert into member values(?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memID);
            pstmt.setString(2, memPass); //바인딩되는 패스워드 md5로 해시된 값이 바인딩 됨
            pstmt.setString(3, memName);
            pstmt.setString(4, memEmail);
            pstmt.setString(5, memJoinDate);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("회원가입 성공");
            } else {
                System.out.println("회원가입 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(con, pstmt);
            sc.close();
        }

    }
}
