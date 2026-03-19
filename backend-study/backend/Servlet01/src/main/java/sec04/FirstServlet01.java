package sec04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first01")
public class FirstServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/first01의 doGet 처리");
		// redirect 방식의 포워딩 : 클라이언트에게 응답을 통해서 다시 요청하도록 진행
		response.setContentType("text/html;charset=utf-8");
		// response.sendRedirect("second01"); //클라이언트인 브라우저에게 요청을 진행하도록 강제함
		// 서버 -> (응답) -> 클라이언트 -> (요청) -> 현재 클라이언트의 context/second01
		// sendRedirect("second01") : uri가 servlet path만 있으므로 응답한 서블릿의 uri의 context가 기본(Servlet01)
		
		// 파라미터값을 전달해서 포워딩 가능
		response.sendRedirect("second01?param=redirect");
	}

}
