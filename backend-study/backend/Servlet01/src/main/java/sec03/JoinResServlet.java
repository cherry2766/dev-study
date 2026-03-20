package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberJoin")
public class JoinResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;

		String year = request.getParameter("year");

		String[] interests = request.getParameterValues("interests");

		String department = request.getParameter("department");

//		System.out.println("성명 : " + name);
//		System.out.println("ID : " + id);
//		System.out.println("비밀번호 : " + pwd);
//		System.out.println("휴대폰 번호 : " + phone);
//		System.out.println("학년 : " + year);
//		System.out.print("관심분야 : ");
//
//		for (String s : interests) {
//			System.out.print(s + " ");
//		}
//		System.out.println();
//
//		System.out.println("학과 : " + department);
		
		String interest_list = "";
		for(String interest : interests) {
			interest_list += interest + " ";
		}
		
		//response 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//output stream : 톰캣 컨테이너의 버퍼(서버의 저장공간)로 연결됨, 서버는 응답데이터를 버퍼에 저장했다가 한번에 클라이언트로 전송
		out.println("<html><head></head><body>");
		out.println("<h1>회원 가입 내용</h1><br>");
		out.println("이름 : " + name + "<br>");
		out.println("ID : " + id + "<br>");
		out.println("비밀번호 : " + pwd + "<br>");
		out.printf("휴대폰 번호 : %s - %s - %s<br>", phone1, phone2, phone3);
		out.println("학년 : " + year + "<br>");
		out.println("관심분야 : " + interest_list + "<br>");
		out.println("학과 : " + department + "<br>");
		out.println("</body></html>");
	}

}
