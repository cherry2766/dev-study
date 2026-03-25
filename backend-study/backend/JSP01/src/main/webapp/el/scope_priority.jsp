<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope_priority</title>
</head>
<body>
	<%
		//session.setAttribute("name", "session");
		application.setAttribute("name", "application");
		//request.setAttribute("name", "request");
	%>
		<jsp:forward page="17_scope_priority_result.jsp"/>
</body>
</html>