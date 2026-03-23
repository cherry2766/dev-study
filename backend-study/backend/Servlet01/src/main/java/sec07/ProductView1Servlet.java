package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductList")
public class ProductView1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>)request.getAttribute("prdList");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>상품번호</td><td>상품명</td><td>상품가격</td>"
		+ "<td>제조사</td><td>삭제</td></tr>");
		
		for(ProductVO vo : prdList) {
			out.print("<tr><td>" + vo.getPrdNo() + "</td>");
			out.print("<td>" + vo.getPrdName() + "</td>");
			out.print("<td>" + vo.getPrdPrice() + "</td>");
			out.print("<td>" + vo.getPrdCompany() + "</td>");
			out.print("<td><a href='/Servlet01/prdDelete?prdNo=" + vo.getPrdNo() +"'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
		out.close();
	}

}
