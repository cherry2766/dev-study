<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문 상세 조회</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <h3 align="center">주문 상세 조회</h3><br>

    <h4 align="center">주문 정보</h4>
    <table border="1" width="60%">
        <tr><th>주문번호</th><td>${orderInfo.ordNo}</td></tr>
        <tr><th>주문일</th><td>${orderInfo.ordDate}</td></tr>
        <tr><th>수령인</th><td>${orderInfo.ordReceiver}</td></tr>
        <tr><th>연락처</th><td>${orderInfo.ordRcvPhone}</td></tr>
        <tr><th>배송지</th><td>${orderInfo.ordRcvAddress1}</td></tr>
        <tr><th>결제수단</th><td>${orderInfo.ordPay}</td></tr>
        <tr><th>배송메세지</th><td>${orderInfo.ordRcvMsg}</td></tr>
    </table>

    <br>

    <h4>주문 상품</h4>
    <table border="1" width="60%">
        <tr>
            <th>상품번호</th>
            <th>상품명</th>
            <th>수량</th>
            <th>가격</th>
            <th>합계</th>
        </tr>
        <c:forEach var="op" items="${orderProductList}">
        <tr>
            <td>${op.prdNo}</td>
            <td>${op.prdName}</td>
            <td>${op.ordQty}</td>
            <td><fmt:formatNumber value="${op.prdPrice}" pattern="#,###"/>원</td>
            <td><fmt:formatNumber value="${op.prdPrice * op.ordQty}" pattern="#,###"/>원</td>
        </tr>
        </c:forEach>
    </table>

    <br>
    <a href="<c:url value='/order/orderListView'/>"><button>목록으로</button></a>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>