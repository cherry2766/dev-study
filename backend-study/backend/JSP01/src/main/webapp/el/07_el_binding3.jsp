<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_el_binding.jsp</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<h3>회원정보 수정</h3>
	<form method="post" action="memberUpdate.jsp">
		아이디 : <input type="text" name="id" value="${ mem.memId}" readonly><br>
		비밀번호 : <input type="text" name="pwd" value="${ mem.memPwd}" ><br>
		이름 : <input type="text" name="name" value="${mem.memName }" ><br>
		이메일 : <input type="text" name="email" value="${ mem.memEmail}" ><br>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>