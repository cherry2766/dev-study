<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		<h3>book 관리 시스템</h3><br>
		
		<a href="<c:url value='/book/listAllBook' />">전체 도서 정보 조회</a><br> 
		<a href="<c:url value='/book/newBookForm' />">도서 등록</a><br> 

</body>
</html>