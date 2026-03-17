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
    // 현재 사용중인 ide에 따라 로그기록이 다름
    // 현재 이클립스는 서버 콘솔에만 log를 기록하고 다른 파일로 기록하지는 않음
    application.log(request.getParameter("JSESSIONID"));
%>
<script>history.back(-1)</script>
</body>
</html>