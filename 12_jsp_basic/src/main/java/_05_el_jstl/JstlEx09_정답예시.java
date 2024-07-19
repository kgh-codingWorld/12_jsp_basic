package _05_el_jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx09_연습") // 서블릿에 대한 요청 처리
public class JstlEx09_정답예시 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("isChecked" , true);
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx09_연습.jsp");  // 서블릿에서 처리된 결과를 JSP 페이지로 전달하기 위하여 요청 포워딩
		dis.forward(request, response);
		
	}

}
