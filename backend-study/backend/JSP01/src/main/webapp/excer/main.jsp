<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습 문제</title>

<style>
    body {
        margin: 0;
        background-color: #f0f4f8;
    }

    .container {
        max-width: 480px;
        width: 100%;
        margin: 0 auto;
        min-height: 100vh;
        background: white;
        padding: 40px 20px;
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        text-align: center;
    }

    h3 {
        margin-bottom: 30px;
        font-size: 24px;
    }

    hr {
        margin-bottom: 30px;
        border: none;
        height: 1px;
        background-color: #eee;
        width: 100%;
    }

    .btn-area {
        display: flex;
        justify-content: center;
    }

    a {
        display: block;
        width: 80%;
        max-width: 300px;
        padding: 14px;
        text-decoration: none;
        background-color: #4da6ff;
        color: white;
        border-radius: 8px;
        font-weight: bold;
        text-align: center;
    }

    a:hover {
        background-color: #3399ff;
    }
</style>

</head>
<body>

<div class="container">
    <h3>상품 관리</h3>
    <hr>
    <div class="btn-area">
        <a href="${contextPath}/productList">상품 정보 조회</a>
    </div>
</div>

</body>
</html>