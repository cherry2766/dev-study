package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second05")
public class SecondServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second05의 doGet 호출");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("dispatch 이용한 포워딩, 포워딩되었지만 url은 동일합니다");
		out.println("</body></html>");
	}

}
