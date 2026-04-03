<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index 페이지 입니다. <br>
	<p>Product</p>
	<a href="/data2/product/productForm">상품등록1(getParameter())</a><br>
	<a href="/data2/product/productForm2">상품등록2(@RequestParam생략)</a><br>
	<a href="/data2/product/productForm3">상품등록3(command 객체 사용)-콘솔에 로그로 전달된 값 출력</a><br>
	<a href="/data2/product/productForm4">상품등록4(@ModelAttribute)</a><br>
	
	<p>student</p>
	<a href="/data2/student/studentForm">studentForm(getParameter())+url에 data 첨부해서 요청</a><br>
	<a href="/data2/student/studentForm2">studentForm2(@RequestParam)</a><br>
	<a href="/data2/student/studentForm2-1">studentForm2(@RequestParam생략)</a><br>
	<a href="/data2/student/studentForm3">studentForm3(command 객체 사용)</a><br>
	<a href="/data2/student/studentForm4">studentForm4(@ModelAttribute)</a><br>
	<a href="/data2//student/studentSearchForm">studentSearchForm(HashMap)</a><br>
	
	<p>showInfo</p>
	<a href="/data/showInfo">showInfoModel</a><br>
	<a href="/data/showInfo2">showInfoModelAndView</a><br>
	<a href="/data/showInfo3">showInfoModelAndView / Model</a><br>
	
</body>
</html>