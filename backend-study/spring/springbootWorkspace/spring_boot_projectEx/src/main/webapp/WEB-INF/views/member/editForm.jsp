<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
    <script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script type="text/javascript" src="<c:url value='/js/searchZip.js'/>"></script>
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <div style="width: 600px; margin: 40px auto;">
        <h3>회원정보 수정</h3><br>

        <form method="post" action="<c:url value='/member/edit'/>">
            <table border="1" width="100%">
                <tr>
                    <th>아이디</th>
                    <td>${memDto.memId}</td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="memName" value="${memDto.memName}"/></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" name="memEmail" value="${memDto.memEmail}"/></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td>
                        <input type="text" name="memHp1" value="${hp1}" size="2" maxlength="3"/>-
       	 				<input type="text" name="memHp2" value="${hp2}" size="3" maxlength="4"/>-
        				<input type="text" name="memHp3" value="${hp3}" size="3" maxlength="4"/>
                    </td>
                </tr>
                <tr>
				    <th>우편번호</th>
				    <td>
				        <input type="text" id="memZipcode" name="memZipcode" value="${memDto.memZipcode}" size="5" readonly>
				        <input type="button" id="searchZipBtn" value="우편번호 찾기">
				    </td>
				</tr>
				<tr>
				    <th>주소</th>
				    <td>
				        <input type="text" id="memAddress1" name="memAddress1" value="${memDto.memAddress1}" size="40" readonly>
				    </td>
				</tr>
				<tr>
				    <th>상세주소</th>
				    <td>
				        <input type="text" id="memAddress2" name="memAddress2" value="${memDto.memAddress2}">
				    </td>
				</tr>
            </table>

            <br>
            <button type="submit">수정 완료</button>
            <a href="<c:url value='/member/myPage'/>"><button type="button">취소</button></a>
        </form>
    </div>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>