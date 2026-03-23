<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestParam</title>
</head>
<body>
	<%!
		//선언부에 변수 선언
		String id, name, pwd, email;
		String interests[];
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		//현재 파라미터 값 반환
		id = request.getParameter("id");
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");
		email = request.getParameter("email");
		interests = request.getParameterValues("interests");
	%>
	
	<!-- 변수에 저장된 값 출력 : 표현식 사용  -->
	성명 : <%=name %> <br>
	아이디 : <%=id %> <br>
	비밀번호 : <%=pwd %> <br>
	이메일 : <%=email %> <br>
	<%for(int i = 0; i < interests.length; i++) { %>
		관심분야 : <%=interests[i] + " <br> " %>
	<%} %>
</body>
</html>