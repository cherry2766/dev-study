<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<c:if test='${msg =="add"}'>
	<script type="text/javascript">
		window.onload = function() {
			alert("상품을 등록 했습니다");
		}
	</script>
</c:if>
<c:if test='${msg =="mod"}'>
	<script type="text/javascript">
		window.onload = function() {
			alert("상품정보를 수정 했습니다");
		}
	</script>
</c:if>
<c:if test='${msg =="del"}'>
	<script type="text/javascript">
		window.onload = function() {
			alert("상품정보를 삭제 했습니다");
		}
	</script>
</c:if>
<style>
    body {
        margin: 0;
        background-color: #f0f4f8;
        display: flex;
        justify-content: center;
        min-height: 100vh;
    }

    .container {
        width: 100%;
        max-width: 700px;
        background: white;
        padding: 30px;
        border-radius: 10px;
        text-align: center;
    }

    h4 {
        margin-bottom: 20px;
        font-size: 24px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    thead {
        background-color: #4da6ff; 
        color: white;
    }

    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: center;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    .empty {
        padding: 20px;
        color: #777;
    }
</style>

</head>
<body>

<div class="container">
    <h4>상품 정보</h4>

    <table>
        <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>제조사</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>

        <tbody>
        <c:choose>
            <c:when test="${empty prdList}">
                <tr>
                    <td colspan="6" class="empty">등록된 상품이 없습니다</td>
                </tr>
            </c:when>

            <c:otherwise>
                <c:forEach var="product" items="${prdList}">
                    <tr>
                        <td>${product.prdNo}</td>
                        <td>${product.prdName}</td>
                        <td><fmt:formatNumber value="${product.prdPrice}" type="number"/></td>
                        <td>${product.prdCompany}</td>
                        <td><a
							href="${contextPath }/product/modProductForm?no=${product.prdNo}">수정</a></td>
						<td><a
							href="${contextPath }/product/delProduct?no=${product.prdNo}">삭제</a></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <a href="${contextPath }/product/productForm">상품 등록</a>
</div>

</body>
</html>