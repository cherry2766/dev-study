package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first03")
public class FirstServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 클라이언트요청(first03)->서버응답(first03)->Refresh:클라이언트요청(second03)->서버응답(second03)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//refresh 기능을 활용한 포워딩 : Refresh는 응답 헤더 정보임, addHeader() 통해서 header에 포함 가능
		//브라우저는 응답헤더에 Refresh가 있으면 설정된 url로 설정시간 경과후에 요청을 보냄
		
		System.out.println("/first03의 doGet 처리");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("3초 후에 second03 url로 Refresh 됩니다");
		out.println("</body></html>");
		
		//응답시 전달되는 header에 포함되는 내용 : addHeader("전달정보(기능)","정보옵션")
		//"Refresh" 정보옵션 : "지연시간(초);url=요청주소?파라미터명=파라미터값"
		response.addHeader("Refresh","10;url=second03");
	}

}
