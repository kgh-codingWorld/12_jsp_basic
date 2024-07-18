package _05_el_jstl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ELEx01")
public class ELEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// jsp ver. , spring ver.
		// request.setAttribute("변수명", "데이터");
		// spring ver.
		// model.addAttribute("변수명", "데이터");
		
		// 빈손으로 가지 않기
		request.setAttribute("name", "Tim");
		request.setAttribute("num1", 12);
		request.setAttribute("num2", 3);
		
		ArrayList<String> list1 = null;						// 생성 x
		ArrayList<String> list2 = new ArrayList<String>();	// 생성 o , 데이터 x
		ArrayList<String> list3 = new ArrayList<String>();  // 생성 o , 데이터 o
		list3.add("data1");
		list3.add("data2");
		list3.add("data3");
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		
		// jsp vpdlwlfh dlehd
		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/elEx01.jsp"); // webapp 디렉터리 하위 경로부터 기술한다.
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
