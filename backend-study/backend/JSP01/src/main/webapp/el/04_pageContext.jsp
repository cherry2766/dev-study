<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext</title>
</head>
<body>
	<!-- context Path를 반환받는 방법 및 a 태그의 href 속성값을 구성 -->
	<!-- 현재 페이지를 요청할때 사용한 서버주소는 브라우저가 기억하고 있음
		 동일 서버의 페이지 요청일 시에는 서버주소는 생략하는게 일반적임 
		 로그인 2와 같이 uri만 기재하면 동일 서버를 의미함 -->
	<a href="http://localhost:8080/JSP01/el/login.jsp">로그인1</a><br>
	<a href="/JSP01/el/login.jsp">로그인2(uri)</a><br>
	<!-- 서버에는 여러 context가 등록됨, context Path는 명시적으로 고정하지 않고 모듈을 통해 반환받아 표현하는 것이 효율적 -->
	<a href="<%=request.getContextPath() %>/el/login.jsp">로그인3</a><br>
	<a href="${pageContext.request.contextPath}/el/login.jsp">로그인4</a><br>

</body>
</html>