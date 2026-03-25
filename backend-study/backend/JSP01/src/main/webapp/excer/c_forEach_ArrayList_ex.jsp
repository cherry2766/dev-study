<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.ProductVO"%>

<%

	ProductVO vo1 = new ProductVO("001", "아이폰", 1200000,"애플");
	ProductVO vo2 = new ProductVO("002", "갤럭시", 1000000,"삼성");
	ProductVO vo3 = new ProductVO("003", "에어팟", 350000, "애플");
	ProductVO vo4 = new ProductVO("004", "맥북", 2500000, "애플");
	
	ArrayList<ProductVO> prdList = new ArrayList<>();
	
	prdList.add(vo1);
	prdList.add(vo2);
	prdList.add(vo3);
	prdList.add(vo4);

	request.setAttribute("prdList", prdList);
%>

<jsp:forward page="c_forEach_ArrayList_result_ex.jsp"></jsp:forward>