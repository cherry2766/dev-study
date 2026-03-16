<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게시글 상세 열람</title>
</head>

<body>
	<h1>게시글 상세 열람</h1>
	<%
	try {
		// 웹페이지별로 db 관리를 해야 함 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_username = "C##SQL_USER";
		String db_pwd = "1234";

		Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);

		// 게시글 보기 : 특정 게시글 출력
		// 게시글 번호 파라미터 필요
		request.setCharacterEncoding("UTF-8"); //전달된 파라미터의 인코딩 방식 설정

		// 전달되는 파라미터는 문자열임
		String num = request.getParameter("num");

		// PreparedStatement 플레이스 홀더 ? 사용 (파라미터라이제이션 방식)
		String readQuery = "select * from pratice_board where num = ?";
		PreparedStatement pstmt = connection.prepareStatement(readQuery);

		// setInt() 메서드를 통해 값을 바인딩
		pstmt.setInt(1, Integer.parseInt(num));

		ResultSet result = pstmt.executeQuery();
	%>

	<table border="1">
		<%
		// 조회 결과를 request에 저장
		while (result.next()) {
			request.setAttribute("num", result.getInt("num"));
			request.setAttribute("regdate", result.getTimestamp("regdate"));
			request.setAttribute("writer", result.getString("writer"));
			request.setAttribute("title", result.getString("title"));
			request.setAttribute("content", result.getString("content"));
		%>
		<tr>
			<td>번호</td>
			<!-- request에 저장된 값을 JSTL 태그로 출력 -->
			<td><c:out value="${num}" /></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><c:out value="${regdate}" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><c:out value="${writer}" /></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><c:out value="${title}" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><c:out value="${content}" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type=button onclick="location.href='post_list.jsp'">목록으로</button>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} catch (Exception ex) {
	System.out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
	}
	%>

</body>
</html>