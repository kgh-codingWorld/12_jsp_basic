package _04_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletEx02") // 소문자가 국룰, 실행은 servlet에서 해야 데이터가 서버를 통해 브라우저로 넘어감
public class ServletEx02 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 
		 	- servlet에서 jsp파일로 데이터를 전송할 경우 
		 	  request.setAttribute("속성명", 값); 메서드를 사용하여 전송한다.
		 */
		request.setAttribute("a", "글자데이터");
		request.setAttribute("b", 3);
		request.setAttribute("c", 3.14);
		request.setAttribute("d", true);
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter04_servlet/servletEx02.jsp");
		dis.forward(request, response);
	
	}


}
