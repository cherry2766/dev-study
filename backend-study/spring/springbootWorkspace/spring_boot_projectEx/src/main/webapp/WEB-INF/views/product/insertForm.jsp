<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 등록</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<div id="wrap">
    <c:import url="/WEB-INF/views/layout/top.jsp" />

    <div style="width: 600px; margin: 40px auto;">
        <h3>상품 등록</h3><br>

        <form method="post" action="<c:url value='/product/insert'/>">
            <table border="1" width="100%">
                <tr>
                    <th>상품번호</th>
                    <td><input type="text" name="prdNo"/></td>
                </tr>
                <tr>
                    <th>상품명</th>
                    <td><input type="text" name="prdName"/></td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td><input type="number" name="prdPrice"/></td>
                </tr>
                <tr>
                    <th>제조회사</th>
                    <td><input type="text" name="prdCompany"/></td>
                </tr>
                <tr>
                    <th>재고</th>
                    <td><input type="number" name="prdStock"/></td>
                </tr>
                <tr>
                    <th>상품설명</th>
                    <td><textarea name="prdDescript" rows="4" cols="30"></textarea></td>
                </tr>
                <tr>
                    <th>이미지 파일명</th>
                    <td><input type="text" name="prdImg"/></td>
                </tr>
                <tr>
                    <th>카테고리</th>
                    <td>
                        <select name="ctgId">
                            <option value="1">노트북</option>
                            <option value="2">프린터</option>
                            <option value="3">마우스</option>
                            <option value="4">키보드</option>
                        </select>
                    </td>
                </tr>
            </table>
            <br>
            <button type="submit">등록 완료</button>
            <a href="<c:url value='/product/adminPage'/>"><button type="button">취소</button></a>
        </form>
    </div>

    <c:import url="/WEB-INF/views/layout/bottom.jsp" />
</div>
</body>
</html>