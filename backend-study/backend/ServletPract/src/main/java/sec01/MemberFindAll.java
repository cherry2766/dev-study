package sec01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member-list")
public class MemberFindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");

		if ("admin".equals(id) && "admin".equals(pw)) {

		    MemberDAO dao = new MemberDAO();
		    ArrayList<MemberVO> list = dao.memberFindAll();

		    request.setAttribute("list", list);

		    request.getRequestDispatcher("admin.jsp").forward(request, response);

		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}

	}
}
