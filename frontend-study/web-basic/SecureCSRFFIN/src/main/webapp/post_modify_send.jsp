<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_username = "C##SQL_USER";
	String db_pwd = "1234";
	Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
	String S_NAME = (String) session.getAttribute("S_name");
	String CSRF_TOKEN = (String)session.getAttribute("CSRF_TOKEN");
	System.out.println(S_NAME);
	request.setCharacterEncoding("UTF-8");

	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	System.out.println(writer);
	String num = request.getParameter("num");
	String csrftoken = request.getParameter("csrftoken");

	if (S_NAME.equals(writer) && CSRF_TOKEN.equals(csrftoken)) {

		PreparedStatement psmt;

		String insertQuery = "UPDATE pratice_board set title=?, writer=?, content=? WHERE num=" + num;
		System.out.println(insertQuery);
		psmt = connection.prepareStatement(insertQuery);

		psmt.setString(1, title);
		psmt.setString(2, writer);
		psmt.setString(3, content);

		psmt.executeUpdate();
	}
	response.sendRedirect("post_list.jsp");

} catch (Exception ex) {
	ex.printStackTrace();
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>