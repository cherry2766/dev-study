package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출"); 
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출"); 
	}

	// doGet()이 서버 컨테이너에 의해 호출될 때 request 객체와 response 객체 인스턴스 참조값이 전달됨
	// 호출되는 시점에 연결된 특정 브라우저가 요청할때 전송된 모든 정보를 request에 포함해서 전달함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에게 요청시 전달된 파라미터를 추출해서 처리
		// HttpServletRequest.setCharacterEncoding(코드처리방식) : request객체에 전달된 값(통신데이터)에 대한 encoding
		request.setCharacterEncoding("UTF-8");
		// 1개 파라미터 반환 : HttpServletRequest.getParameter(파라미터명)
		// 원칙적으로 파라미터값은 문자열
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디 : "+ user_id);
		System.out.println("비밀번호 : "+ user_pw); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식으로 전송");
		doGet(request, response);
		
//		request.setCharacterEncoding("UTF-8");
//		String user_id = request.getParameter("user_id");
//		String user_pw = request.getParameter("user_pw");
//		System.out.println("아이디 : "+ user_id);
//		System.out.println("비밀번호 : "+ user_pw); 
	}

}
