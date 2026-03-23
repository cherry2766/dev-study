package sec01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sign-up")
public class MemberSaveForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("id");
	    String memPwd = request.getParameter("pwd");
	    String memName = request.getParameter("name");
	    String memEmail = request.getParameter("email");
				
	    MemberVO vo = new MemberVO();
	    vo.setMemId(memId);
	    vo.setMemPwd(memPwd);
	    vo.setMemName(memName);
	    vo.setMemEmail(memEmail);
	    
	    MemberDAO dao = new MemberDAO();
	    dao.save(vo);
	    
	    response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Refresh", "3;url=login.html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>회원가입 완료</title></head>");
        out.println("<body>");
        out.println("<h2>회원가입이 완료되었습니다.</h2>");
        out.println("<p>3초 후 로그인 페이지로 이동합니다.</p>");
        out.println("</body>");
        out.println("</html>");
	}

}
