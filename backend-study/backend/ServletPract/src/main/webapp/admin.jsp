<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, sec01.MemberVO" %>

<%
    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
</head>
<body>

<form name="formLogin" method="post" action="member-list">
    아이디 : <input type="text" name="user_id"> <br> 
    비밀번호 : <input type="password" name="user_pw"> <br>
    <input type="submit" value="로그인">
    <input type="reset" value="다시입력">
</form>

<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
%>
    <p style="color:red;"><%= msg %></p>
<%
    }
%>

<hr>

<!-- ⭐ 로그인 성공 시에만 테이블 출력 -->
<% if (list != null) { %>

    <h2>전체 회원 목록</h2>

    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
        </tr>

    <% for (MemberVO vo : list) { %>
        <tr>
            <td><%= vo.getMemId() %></td>
            <td><%= vo.getMemName() %></td>
            <td><%= vo.getMemEmail() %></td>
            <td><%= vo.getMemJoinDate() %></td>
        </tr>
    <% } %>

    </table>

<% } %>

</body>
</html>