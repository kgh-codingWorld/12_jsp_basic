<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
  
		# JSP(Java[Jakarta] Server Page)는 html태그 위에 jsp태그가 추가된 형태로 사용되어진다.
		 
	    1) 지시자(Directive) 태그        	<%@    %>
	    2) 스크립트릿(Scriptlet) 태그  	    <%     %>	
	    3) 표현식(Expression) 태그      	<%=    %>

	 --%>
	 
	 <!-- html 주석 : 개발자도구에서 볼 수 있습니다. -->
	 <%-- jsp주석 : 개발자 도구에서 볼 수 없습니다. --%>
	 <h3>출력함수</h3> <!-- html 문법 -->
	 <% 
	 	/* 자바 문법 */
	 	String name = "팀 버너스 리";
	 	System.out.println("name : " + name); // back console 환경에 데이터 출력
	 	out.println("name : " + name); // html 환경에 데이터 출력
	 %>
	 <hr/>
	 이름 : name
	 <hr/>
	 <!-- html 환경에서의 자바데이터 표기법 -->
	 이름 : <%= name %>
	 
	 
</body>
</html>