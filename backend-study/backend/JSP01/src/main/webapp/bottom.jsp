<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bottom</title>
</head>
<body>
	<font color="green" size="3pt">
		bottom 페이지 입니다 <p>
		작성자<b><%= name %></b>입니다.
		<!-- name 변수가 현재 파일에 선언되지 않았지만, include로 결합될 파일이므로 
			 다른 파일에서 선언되고 할당된 변수 사용 가능
		-->
	</font>
</body>
</html>