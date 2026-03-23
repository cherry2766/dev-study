package sec06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/selView")
public class MemberView1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	//타입체크 필요없음의 설정
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request에 저장되는 Attribute는 모두 Object 타입으로 변환됨 - 모든 타입의 데이터를 Attribute로 저장하기 위해 변환
		//실제 Attribute에 저장된 데이터타입으로 변환하는 작업을 해야 함
		//1. 전달된 바인딩 데이터 추출
		ArrayList<MemberVO> memList = (ArrayList<MemberVO>)request.getAttribute("memList");
		
		//2. 응답 데이터 생성
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//톰캣 컨테이너 버퍼로 출력
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>"
		+ "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for(MemberVO vo : memList) {
			out.print("<tr><td>" + vo.getId() + "</td>");
			out.print("<td>" + vo.getPwd() + "</td>");
			out.print("<td>" + vo.getName() + "</td>");
			out.print("<td>" + vo.getEmail() + "</td>");
			out.print("<td>" + vo.getMemJoinDate() + "</td>");
			out.print("<td><a href='/Servlet01/memDelete?memId=" + vo.getId() +"'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
		out.close();
		
	}

}
