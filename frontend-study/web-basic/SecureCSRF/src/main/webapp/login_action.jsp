<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

request.setCharacterEncoding("utf-8"); // post방식 한글처리
String id = request.getParameter("id");
String pw = request.getParameter("pass");
System.out.println(id);
System.out.println(pw);
try
{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
  String db_username = "C##SQL_USER";
  String db_pwd = "1234";
  Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
    
    request.setCharacterEncoding("UTF-8");
    
    String insertQuery = "SELECT * FROM member WHERE memid='" + id +"' and mempwd='"+pw+"'";
    
    PreparedStatement psmt = connection.prepareStatement(insertQuery);
    
    ResultSet result = psmt.executeQuery();
    
    if(result.next()){
      String dbid = result.getString("memid");
      String dbpwd = result.getString("mempwd");
      String dbname = result.getString("memname");
    //로그인증명을 위한 session 생성
    session.setAttribute("S_ID", dbid);
    session.setAttribute("S_name", dbname);//로그인 증명 저장 session 생성   
    }
  response.sendRedirect("post_list.jsp"); //로그인 후 요청
}catch (Exception ex)
{ ex.printStackTrace();
    out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>