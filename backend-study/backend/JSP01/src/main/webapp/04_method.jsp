<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>method</title>

</head>
<body>
	<%!String id = "abcd";

	public String getId() {
		return id;
	}%>
	메서드 선언은 반드시 선언부에서 정의 해야 함
	<br>
	<% 
	//일반 스크립트릿에서는 변수 선언 가능(지역변수)
	String id1 = "abcd";
	//메서드는 스크립트릿에서는 선언 불가능 : 호출만 가능
	/* public String getId() {
		return id;
	} */
	
	%>
	id 변수 :
	<%=id %><br> getId() 메서드 호출 결과 :
	<%= getId() %>

</body>
</html>