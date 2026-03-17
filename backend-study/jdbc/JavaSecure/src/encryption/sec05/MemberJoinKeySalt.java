package encryption.sec05;

import encryption.sec01.DBConnect;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoinKeySalt {
    private static final int SALT_SIZE = 16;

    // salt값(난수) 생성
    public static String getSALT() throws Exception {
        SecureRandom rnd = new SecureRandom();
        byte[] temp = new byte[SALT_SIZE];
        rnd.nextBytes(temp);

        return Byte_to_String(temp);
    }

    // 바이트 -> 문자열로 변환
    public static String Byte_to_String(byte[] temp) {
        StringBuilder sb = new StringBuilder();
        for (byte a : temp) {
            sb.append(String.format("%02x", a));
        }
        return sb.toString();
    }

    // 해시값 생성
    public static String Hashing(byte[] password, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        //KEY_STRETCHING
        for (int i = 0; i < 10000; i++) {
            String temp = Byte_to_String(password) + salt;
            md.update(temp.getBytes());
            password = md.digest();
        }
        return Byte_to_String(password);
    }

    public static void main(String[] args) throws Exception {
        // 취약한 패스워드 저장1 : plan text 그대로 저장
        encryption.sec01.DBConnect dbCon = new encryption.sec01.DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("ID 입력 : ");
            String memID = sc.nextLine();
            System.out.print("비밀번호 입력 : ");
            String memPass = sc.nextLine();

            String memsalt = getSALT();
            memPass = Hashing(memPass.getBytes(), memsalt);
            System.out.println(memPass);

            System.out.print("이름 입력 : ");
            String memName = sc.nextLine();
            System.out.print("e-mail 입력 : ");
            String memEmail = sc.nextLine();

            //회원가입 시간
            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String memJoinDate = now.format(formatter);

            String sql = "insert into member values(?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memID);
            pstmt.setString(2, memPass); //바인딩되는 패스워드 salt를 포함한 해시값
            pstmt.setString(3, memName);
            pstmt.setString(4, memEmail);
            pstmt.setString(5, memJoinDate);
            pstmt.setString(6, memsalt);

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












