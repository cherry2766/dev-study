<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>본인정보 확인</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <div style="width: 600px; margin: 40px auto;">
        <h3>본인정보 확인</h3><br>

        <table border="1" width="100%">
            <tr><th>아이디</th><td>${memDto.memId}</td></tr>
            <tr><th>이름</th><td>${memDto.memName}</td></tr>
            <tr><th>이메일</th><td>${memDto.memEmail}</td></tr>
            <tr><th>전화번호</th><td>${memDto.memHp}</td></tr>
            <tr><th>가입일</th><td>${memDto.memJoinDate}</td></tr>
            <tr><th>우편번호</th><td>${memDto.memZipcode}</td></tr>
            <tr><th>주소</th><td>${memDto.memAddress1} ${memDto.memAddress2}</td></tr>
        </table>

        <br>
        <a href="<c:url value='/member/myPage'/>"><button>마이페이지로</button></a>
    </div>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>