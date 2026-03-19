package sec04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first02")
public class FirstServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/first02의 doGet 처리 - 여러값  redirect시 전달");

		response.setContentType("text/html;charset=utf-8");
		// 파라미터 직접 작성할 때는 파라미터명=파라미터값 : = 앞뒤로 공백이 있으면 안됨
		response.sendRedirect("second02?name=hong&age=20&addr=seoul");
	}

}
