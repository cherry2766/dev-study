package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String book_id = request.getParameter("book_id");
		String book_name = request.getParameter("book_name");
		String book_author = request.getParameter("book_author");
		String book_price = request.getParameter("book_price");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String book_stock = request.getParameter("book_stock");
		String pub_id = request.getParameter("pub_id");
		
		int price = Integer.parseInt(book_price);
		int stock = Integer.parseInt(book_stock);
		String publishDate = year + "-" + month + "-" + day;
		
		System.out.println("도서번호: " + book_id);
		System.out.println("도서명: " + book_name);
		System.out.println("저자: " + book_author);
		System.out.println("가격: " + price);
		System.out.println("발행일: " + publishDate);
		System.out.println("재고: " + stock);
		System.out.println("출판사번호: " + pub_id);
		
	}

}
