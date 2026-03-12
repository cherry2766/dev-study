package secure.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;

public class StudentInjectMainFilter {
    public static void main(String[] args) {
        //DB 연결
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]|[select|delete|insert|order by|create|alter|drop|all|union]"); // 필터링할 문구(정규식)를 문자열로 전달
        Matcher matcher = null; // 필터링 패턴과 매칭시 사용할 참조변수

        //java.sql 패키지의 모든 객체는 오류를 던지기 때문에 사용측에서는 예외처리가 반드시 필요함
        try {
            System.out.print("학생 번호 입력 : ");
            String stdNo = sc.nextLine();
            System.out.println(stdNo);

            matcher = pattern.matcher(stdNo.toLowerCase());

            boolean match = true;
            // 입력 값 검증 진행
            matcher.find(); // 설정한 정규식 패턴과 전달된 문자열을 매칭시켜서 정규식 패턴에 대한 문자열로 확인되면 true 반환
            while (matcher.find()) {
                match = false; // 입력된 문자가 필터링 됨
                break;
            }
            System.out.println(match);

            if (match) {

                // select 쿼리문 작성 : 입력된 학생 번호에 대한 정보를 출력
                String sql = "select * from student where stdNo='" + stdNo + "'";

                //String sql = "select * from student where stdNo=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);

                rs = pstmt.executeQuery();

                System.out.println("------------- 학생 정보 조회 -------------");
                System.out.println("학생번호   \t 학생이름 \t\t\t\t 학년");

                // 필요내용만 출력 : 모든 컬럼을 select 하지만 사용자에게 전달한 정보만 출력하는 방식으로 프로그램 개발
                // 3개의 컬럼만 표현
                while (rs.next()) {
                    stdNo = rs.getString(1);
                    String stdName = rs.getString(2);
                    int stdYear = rs.getInt(3);

                    //한 행씩 출력
                    System.out.format("%-10s\t %-20s\t %6d \n", stdNo, stdName, stdYear);
                }
            } else {
                System.out.println("잘못된 입력입니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
