package _04_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletEx03")
public class ServletEx03 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		
		 	# PrintWriter 
		 
			- response.getWriter(); 메서드를 이용하여 PrintWriter 객체를 생성한다.
			
			- PrintWriter객체는 Springframework의 @ResponseBody , ResponseEntity , @RestController와 같은 기능을 한다.
			
			- PrintWriter객체의 print()메서드로 새로운 html을 표시한다.
		 
		*/
		
		// 반환되는 데이터의 encoding을 utf-8로 지정하여 데이터를 한글화 한다.
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("이거뭐야");
		out.print("<h1>join<?h1>");
		out.print("<a href='#'>이동하기</a>");
	}


}
