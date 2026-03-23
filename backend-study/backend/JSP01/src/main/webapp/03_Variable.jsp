<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>variable</title>
<%!
	//변수 선언 jsp 스크립트 영역, 선언된 변수 전역변수
	//변수 사용 전에만 선언영역 나타나면 되고, html 태그와는 무관함(어디에 있어도 상관없음)
	//가독성을 위해 지시어 아래 페이지 위에 두도록 권장
	int x = 10; //변수 선언하면서 바로 초기화는 가능
	long y; //변수 선언만 가능
	// y=10; //선언된 변수에 값 저장은 불가능
	
	float floatValue = 3.14F; //리터럴 3.14가 float형임을 알림
	double doubleValue = 3.14; //double이 기본
	
	char ch= 'a';
	String myJob =  "프로그래머";
	
	boolean b = true;
%>
<%
	//스크립트릿에서 선언된 변수에 값 저장
	y = 100;
%>
</head>
<body>
	표현식은 해당 데이터가 출력되어야 할 영역(태그)에서 사용
	<h3>변수 값 출력</h3>
	x : <%= x%>
	y : <%= y%>
	floatValue : <%= floatValue%>
	myJob : <%= myJob%>
	b : <%= b%>
</body>
</html>