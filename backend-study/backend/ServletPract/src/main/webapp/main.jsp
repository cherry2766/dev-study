<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sec01.MemberVO" %>
<%
    MemberVO vo = (MemberVO) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
<h1>메인 페이지</h1>

<button onclick="location.href='joinForm.html'">회원가입</button>
<button onclick="location.href='login.html'">가입정보확인</button>
<button onclick="location.href='admin.jsp'">관리자</button>

<hr>

<% if (vo != null) { %>
    <h2>내 정보 조회</h2>
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
        </tr>
        <tr>
            <td><%= vo.getMemId() %></td>
            <td><%= vo.getMemName() %></td>
            <td><%= vo.getMemEmail() %></td>
            <td><%= vo.getMemJoinDate() %></td>
        </tr>
    </table>
<% } else { %>
    <p>회원 정보가 없습니다.</p>
<% } %>

</body>
</html>