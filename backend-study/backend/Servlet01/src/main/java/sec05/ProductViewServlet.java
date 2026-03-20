package sec05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productsView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> list = (ArrayList<ProductVO>)request.getAttribute("list");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='gold'>");
		out.print("<td>상품번호</td><td>이름</td><td>가격</td><td>업체명</td><td>수정</td><td>삭제</td>");
		out.print("</tr>");
		
		for(int i=0; i< list.size();i++) {
			ProductVO vo = (ProductVO)list.get(i);
			String prdNo = vo.getPrdNo();
			String prdName = vo.getPrdName();
			int prdPrice = vo.getPrdPrice();
			String prdCompany = vo.getPrdCompany();
			
			
			out.print("<tr><td>"+prdNo+"</td><td>"+
								prdName+"</td><td>"+
								prdPrice+"</td><td>"+
								prdCompany+"</td><td>"+
								"<a href='/Servlet01/productUpdate?id="+prdNo+"'>수정</a></td><td>"+
								"<a href='/Servlet01/productDelete?id="+prdNo+"'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
	}

}
