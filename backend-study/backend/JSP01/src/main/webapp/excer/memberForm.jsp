<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>연습 문제</title>
	</head>
	<body>
		<h3>회원 가입창</h3>
		<form name="frmStudent" method="post"  action="newMemberOk.jsp">
		 <table>
		   <tr><td>아이디</td><td><input type="text" name="memId"></td></tr>
	        <tr><td>비밀번호</td><td><input type="text" name="MemPwd" ></td></tr>
	       <tr><td>이름</td><td><input type="text" name="memName" ></td></tr>
	       <tr><td>이메일</td><td><input type="text" name="memEmail" ></td></tr>
	       <tr><td colspan="2"> <input type="submit" value="가입하기">  
	    		<input type="reset" value="다시입력"></td></tr>
	    </table>
	  </form>
	</body>
</html>