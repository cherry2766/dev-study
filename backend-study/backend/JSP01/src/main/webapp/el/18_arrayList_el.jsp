<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mB" class="bean.MemberVOEl"/>
<jsp:useBean id="mC" class="bean.MemberVOEl"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>

<%
	mB.setMemId("son");
	mB.setMemName("손흥민");
	
	mC.setMemId("park");
	mC.setMemName("박지성");
	
	memberList.add(mB);
	memberList.add(mC);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el 표현어로 배열 출력</title>
</head>
<body>
	회원 1 id : ${ memberList[0].memId} <br>
	회원 1 이름 : ${ memberList[0].memName} <br>
	회원 2 id : ${ memberList[1].memId} <br>
	회원 2 이름 : ${ memberList[1].memName} <br>
</body>
</html>