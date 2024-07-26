package _07_session_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*

	# 세션(Session)
	
		[ Session 관련 메서드 메뉴얼 ]
	
		1) setAttribute(속성명, 값) : 세션 속성명과 속성값으로 value를 할당한다. 
		
		2) getAttribute(속성명) : 세션 속성명의 값을 Object 타입으로 리턴한다. (할당했던 데이터 타입으로 형변환 후 사용한다.) 
								  해당 되는 속성명이 없을 경우에는 null 값을 리턴한다.
								  
		3) removeAttribute(속성명)	: 세션속성을 제거한다. (해당 속성만 제거) 
		
		4) invalidate() : 세션속성을 제거한다. (초기화 , 주로 로그아웃시 사용)
		
		5) setMaxInactiveInterval(유지기간(초))	: 세션을 유지하기 위한 세션 유지시간을 초 단위로 설정한다. (기본값은 30분)

*/


@WebServlet("/sessionLogin")
public class SessionLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// 로그인(인증)화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/sessionLogin.jsp"); 
		dis.forward(request, response);
	}

	// 로그인 기능 처리 로직
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1) 전송된 id , password를 받는다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
	    // 2) SQL쿼리로 인증한다. 
		// 예시 : SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PASSWORD = ?
	
//		String dbId = "qwer1234";
//		String dbPasswd = "qwer1234";
//		String dbRole = "user";
		
		String dbId = "admin";
		String dbPasswd = "admin";
		String dbRole = "admin";
		
		// 3-1) 인증된 유저이면 session객체에 관련된 정보를 저장한다.
		if(id.equals(dbId) && passwd.equals(dbPasswd)) {
			// 3-1-1) 세션 객체를 생성 한다.
			HttpSession session = request.getSession();
			
			// 3-1-2) 세션객체에 인증 관련 정보를 등록한다. 
			// session.setAttribute("세션정보" , 데이터);
			session.setAttribute("id", id);
			session.setAttribute("role", dbRole);
			
			// 3-1-3) View로 페이지 이동
			RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/memberView.jsp"); 
			dis.forward(request, response);
		} 
		else {
			// 3-2) 인증된 유저가 아니면 비인증 유저에 관한 절차를 진행한다.
			String jsScript = """
					<script>
						alert("패스워드를 확인하세요.");
						history.go(-1);
					</script>
				""";
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();	
			out.print(jsScript);
		}
		
		
		
	}

}
