<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
<script src="<c:url value='/js/login.js'/>"></script>
</head>

<body>

	<h2>로그인</h2>

	<form id="loginForm">

		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="id" name="id"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pwd" name="pwd"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><br> <input type="submit"
					value="로그인"> <input type="reset" value="취소"></td>
			</tr>
		</table>

	</form>

</body>
</html>