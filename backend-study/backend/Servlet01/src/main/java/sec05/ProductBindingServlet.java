package sec05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/products")
public class ProductBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO product1 = new ProductVO("001","휘낭시에",20000,"돌체테리아");
		ProductVO product2 = new ProductVO("002","딸기시루",50000,"성심당");
		ProductVO product3 = new ProductVO("003","두바이쫀득빵",20000,"아롬베이크");
		
		List<ProductVO> list = new ArrayList<>();
		
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("productsView");
		dispatcher.forward(request, response);
	}

}
