<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Product Result</title>
  </head>
    <body>
      <h3>상품 정보 등록 결과</h3>
      상품번호 : ${productInfo.prdNo}<br>
      상품명 : ${productInfo.prdName}<br>
      가격 : ${productInfo.prdPrice}<br>
      제조회사 : ${productInfo.prdMaker}<br>
      제조일 : <fmt:formatDate value="${productInfo.prdDate}" pattern="YYYY-MM-dd" /><br>
      재고 : ${productInfo.prdStock}<br>
    </body>
</html>