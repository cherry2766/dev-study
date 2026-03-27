<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>
 <h1 class="cls1">상품 정보 수정</h1>
<form  method="post" action="${contextPath}/product/modProduct">
 <table align="center" >
   <tr>
     <td width="200"><p align="right" >상품번호</td>
     <td width="400"><input   type="text" name="no" value="${prdInfo.prdNo}" readonly ></td>
     
   </tr>
 <tr>
     <td width="200"><p align="right" >상품명</td>
     <td width="400"><input   type="text" name="name" value="${prdInfo.prdName}" >
     </td>
   </tr>
   <tr>
     <td width="200"><p align="right" >상품가격</td>
     <td width="400"><input   type="text" name="price" value="${prdInfo.prdPrice}" ></td>
   </tr>
   <tr>
     <td width="200"><p align="right" >제조사</td>
     <td width="400"><input   type="text" name="company"  value="${prdInfo.prdCompany}" ></td>
   </tr>
   <tr align="center" >
    <td colspan="2" width="400"><input type="submit" value="수정하기" >
       <input type="reset" value="다시입력" > </td>
   </tr>
 </table>
</form>
</html>
