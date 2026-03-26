package mvcex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  get/post 요청 모두 처리 모듈 추가
 *  요청 url은 productList
 */

@WebServlet("/productList")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> prdList = dao.findAll();
		
		request.setAttribute("prdList", prdList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("excer/ProductListView.jsp");
		dispatcher.forward(request, response);
		
	}

}
