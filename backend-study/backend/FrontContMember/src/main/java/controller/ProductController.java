package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductVO;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO dao = null;
	public void init() throws ServletException {
		dao = new ProductDAO();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String url = request.getPathInfo();
		if(url == null || url.equals("/listProducts")) {
			ArrayList<ProductVO> prdList = dao.findAll();
			request.setAttribute("prdList", prdList);
			nextPage = "/listProducts.jsp";
			
		}else if(url.equals("/productForm")) {
			nextPage= "/productForm.jsp";
			
		}else if(url.equals("/addProduct")) {
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String company = request.getParameter("company");
			ProductVO vo = new ProductVO(no,name,price,company);
			dao.addProduct(vo);
			request.setAttribute("msg", "add");
			nextPage = "/product/listProducts";
			
		}else if(url.equals("/modProductForm")) {
			String no = request.getParameter("no");
			ProductVO prdInfo = dao.findProduct(no);
			request.setAttribute("prdInfo", prdInfo);
			nextPage = "/modProductForm.jsp";
		}else if(url.equals("/modProduct")) {
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String company = request.getParameter("company");
			ProductVO vo = new ProductVO(no,name,price,company);
			dao.modProduct(vo);
			request.setAttribute("msg", "mod");
			nextPage = "/product/listProducts";
		}else if(url.equals("/delProduct")) {
			String no = request.getParameter("no");
			dao.delProduct(no);
			request.setAttribute("msg", "del");	
			nextPage = "/product/listProducts";
		}else {
			ArrayList<ProductVO> prdList = dao.findAll();
			request.setAttribute("prdList", prdList);
			nextPage = "/listProducts.jsp";
		}
		System.out.println("url = " + url);
		System.out.println("nextPage = " + nextPage);
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
