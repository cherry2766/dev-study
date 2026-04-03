<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Index</title>
</head>
<body>
<h1>
	index 페이지 입니다 
</h1>
<a href="/second/bookInfoView1">showBookInfoModel1</a><br>
<a href="/second/bookInfoView2">showBookInfoModelAndView2</a><br>
<a href="/second/bookInfoView3">showBookInfoModelAndView3</a><br>
<a href="/second/bookInfoView4">showBookInfoModelAndView4</a><br>

<a href="/second/newView">second/newView 페이지</a><br>
<a href="/project/newView">project/newView 페이지</a><br>
<img src="/second/resources/image/apple.png">
<P>  현재 시간 :  ${serverTime} </P>

</body>
</html>
