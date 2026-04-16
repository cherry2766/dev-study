<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <div style="width: 600px; margin: 40px auto;">
        <h3>마이페이지</h3> <br><br>

        <h4>🛒 주문 내역</h4>
        <a href="<c:url value='/order/orderListView'/>">▸ 주문 목록 보기</a>

        <br><br><br>

        <h4>👤 회원 정보</h4>
        <a href="<c:url value='/member/myInfo'/>">▸ 본인정보 확인</a><br><br>
        <a href="<c:url value='/member/editForm'/>">▸ 회원정보 수정</a><br><br>
        <a href="<c:url value='/member/deleteForm'/>">▸ 회원 탈퇴</a>
    </div>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>