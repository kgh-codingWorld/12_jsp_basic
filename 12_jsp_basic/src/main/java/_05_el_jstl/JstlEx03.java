package _05_el_jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlEx03")
public class JstlEx03 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] datas = {"데이터1" , "데이터2" , "데이터3" , "데이터4" , "데이터5"};
		request.setAttribute("datas" , datas);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx03.jsp"); 
		dis.forward(request, response);
		
	}

}
