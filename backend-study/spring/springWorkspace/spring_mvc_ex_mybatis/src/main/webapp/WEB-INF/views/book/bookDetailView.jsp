<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상세 도서 정보 조회</title>
	</head>
	<body>
		 <h3>상세 도서 정보 조회</h3>
	     <table border="1" width="300">
				<tr><td>도서번호</td><td>${book.bookNo}</td></tr>
				<tr><td>도서명</td><td>${book.bookName}</td></tr>
				<tr><td>저자</td><td>${book.bookAuthor}</td></tr>
				<tr><td>가격</td><td>${book.bookPrice}</td></tr>
				<tr><td>발행일</td>
					<td><fmt:formatDate value="${book.bookDate}" pattern="YYYY-MM-dd"/></td></tr>
				<tr><td>재고</td><td>${book.bookStock}</td></tr>
				<tr><td>출판사</td>	<td>${book.pubNo}</td></tr>
		</table><br><br>
    
		<a href="<c:url value='/'/>">[홈으로 이동]</a> <br>

		<a href="<c:url value='/book/updateBookFrom'/>">[도서 정보 수정]</a> 
	</body>
</html>