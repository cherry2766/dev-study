<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<String> dataList = new ArrayList<>();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요");

	request.setAttribute("dataList", dataList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_cForEach</title>
</head>
<body>
	<!-- 집합 객체인 ArrayList를 활용한 반복 -->
	<c:forEach var="data" items="${dataList }">
		${data } <br>
	</c:forEach>
	<hr>
	<!-- 일반 for문과 같이 사용 -->
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i = ${i }, 반복횟수 : ${loop.count}, index : ${loop.index}, ${loop.first ? '첫번째' : ''} , ${loop.last ? '마지막' : ''} <br>
	</c:forEach>
	<hr>
	<!-- begin / end 수정 -->
	<c:forEach var="i" begin="5" end="20" step="1" varStatus="loop">
		i = ${i }, 반복횟수 : ${loop.count}, index : ${loop.index}, ${loop.first ? '첫번째' : ''} , ${loop.last ? '마지막' : ''} <br>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
		${loop.index} : 5 * ${i } = ${5*i } <br>
	</c:forEach>
	
	<hr>
	<c:set var="fruits" value="사과,파인애플,바나나,망고,귤"/>
	<c:forTokens var="token" items="${fruits}" delims=",">
		${token} <br>
	</c:forTokens>
</body>
</html>