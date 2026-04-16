<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 관리</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <div style="width: 900px; margin: 40px auto;">
        <h3>상품 관리</h3><br>

        <a href="<c:url value='/product/insertForm'/>"><button>+ 상품 등록</button></a>
        <br><br>

        <table border="1" width="100%">
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>가격</th>
                <th>재고</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
            <c:forEach var="prd" items="${prdList}">
            <tr>
                <td>${prd.prdNo}</td>
                <td>${prd.prdName}</td>
                <td><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/>원</td>
                <td>${prd.prdStock}</td>
                <td><a href="<c:url value='/product/editProductForm'/>?prdNo=${prd.prdNo}"><button>수정</button></a></td>
                <td><a href="<c:url value='/product/deleteProduct'/>?prdNo=${prd.prdNo}" 
   					   onclick="return confirm('${prd.prdName}을 삭제하시겠습니까?')">
   					 	<button>삭제</button>
					</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>