package sec04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dispatcher 기능(request)을 활용한 요청(포워딩) : 클라이언트 상관없이 직접 서버를 통해 요청
		// 클라이언트는 포워딩되는 상황을 알 수 없습니다
		// 메서드 호출과는 완전히 다름 : request를 진행, 
		// A서블릿 -> 톰캣컨테이너에게 요청 -> 컨테이너가 request, response 객체 생성 후 -> B서블릿 doGet(request, response) 호출
		
		// 한글데이터를 파라미터로 전송하고자 하면 , 파라미터 규칙에 따라 한글은 1byte 문자로 변환되어야 함
		
		String name ="홍길동";
		int age = 30;
		
		// URLEncoder 객체를 활용해서 url 인코딩 진행 후 파라미터로 전송함
		String encodedName = URLEncoder.encode(name,"utf-8");
		
		
		// request.getRequestDispatcher(포워딩할 url?파라미터나열)
		RequestDispatcher dispatcher = request.getRequestDispatcher("second05?name="+encodedName+"&age="+age); // dispatch 인스턴스 반환
		
		dispatcher.forward(request, response); 
		// 현재 서블릿이 받은 request, response 객체는 반드시 같이 전달되어야 응답할 클라이언트 정보를 기억할 수 있음
	}

}
