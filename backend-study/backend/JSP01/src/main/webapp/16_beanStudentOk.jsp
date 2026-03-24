<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
	<!-- setProperty의 property 속성값을 *로 설정하면 파라미터 명과 속성명이 같은 경우 자동 setter를 통해 저장 -->
	<jsp:useBean id="student" class="bean.StudentBean" scope="page">
		<jsp:setProperty property="*" name="student"/>
	</jsp:useBean>
	
	<%
		String[] stdInterests = student.getStdInterest();
	%>
	
	<h3>빈 속성값 출력</h3>
	학번 : <%=student.getStdNo() %><br>
	성명 : <%=student.getStdName() %><br>
	전화 : <%=student.getStdPhone() %><br>
	주소 : <%=student.getStdAddress() %><br>
	학년 : <%=student.getStdYear() %><br>
	관심분야 : 
	<% for(int i =0; i < stdInterests.length;i++) { %>
		<%=stdInterests[i]+ " " %>
	<%} %>
</body>
</html>