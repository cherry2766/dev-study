<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
<script src="<c:url value='/js/idCheck.js'/>"></script>
</head>

<body>

	<h2>회원가입</h2>

	<form action="<c:url value='/member/join'/>" method="post">

		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="memId" name="memId"> <input
					type="button" id="idCheck" value="중복확인"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memPwd"></td>
			</tr>

			<tr>
				<th>이름</th>
				<td><input type="text" name="memName"></td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><input type="email" name="memEmail"></td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td><input type="text" name="memHp"></td>
			</tr>

			<tr>
				<th>우편번호</th>
				<td><input type="text" name="memZipcode"></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="memAddress1"></td>
			</tr>

			<tr>
				<th>상세주소</th>
				<td><input type="text" name="memAddress2"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><br> <input type="submit"
					value="회원가입"> <input type="reset" value="취소"></td>
			</tr>
		</table>

	</form>

</body>
</html>