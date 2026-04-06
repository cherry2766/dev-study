<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
</head>
<body>
	<table border="1">
		<tr align="center" bgcolor="lightgreen">
			<th width="7%">상품번호</th>
			<th width="7%">상품명</th>
			<th width="7%">가격</th>
			<th width="7%">제조사</th>
			<th width="7%">제조일</th>
			<th width="7%">재고</th>
		</tr>
		<c:forEach var="prd" begin="0" end="${prdList.size()}" step="1"
			items="${prdList}">
			<tr>
				<td width="7%">${prd.prdNo}</td>
				<td width="7%">${prd.prdName}</td>
				<td width="7%">${prd.prdPrice}</td>
				<td width="7%">${prd.prdCompany}</td>
				<td width="7%">${prd.prdDate}</td>
				<td width="7%">${prd.prdStock}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>