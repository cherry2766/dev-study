<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c_forEach_ArrayList_result_ex.jsp</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="orange">
			<td width="5%"><b>상품번호</b></td>
			<td width="5%"><b>상품명</b></td>
			<td width="5%"><b>상품가격</b></td>
			<td width="5%"><b>제조사</b></td>
		</tr>
		<c:forEach var="data" items="${prdList}">
			<tr align="center">
				<td>${data.prdNo}</td><td>${data.prdName}</td><td>${data.prdPrice}</td><td>${data.prdCompany}</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>