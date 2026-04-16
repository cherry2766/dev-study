<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 탈퇴</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <div style="width: 600px; margin: 40px auto;">
        <h3>회원 탈퇴</h3><br>

        <p>탈퇴하시려면 비밀번호를 입력해주세요.</p>

        <c:if test="${param.error eq 'true'}">
            <p style="color: red;">비밀번호가 일치하지 않습니다.</p>
        </c:if>

        <form method="post" action="<c:url value='/member/delete'/>">
            <table border="1" width="100%">
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" name="memPwd" placeholder="비밀번호 입력"/></td>
                </tr>
            </table>
            <br>
            <button type="submit">탈퇴 확인</button>
            <a href="<c:url value='/member/myPage'/>"><button type="button">취소</button></a>
        </form>
    </div>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>