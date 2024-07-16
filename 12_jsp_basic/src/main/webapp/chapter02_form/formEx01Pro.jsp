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
	
		- 폼 전송을 통해서 넘어 오는 데이터는 request내장(built in) 객체를 통해서 전달을 받는다.
		- 페이지의 encoding설정 외에 request객체의 encoding을 setCharacterEncoding메서드를 이용하여 추가로 지정해 주어야한다.
		- request.getParameter(name명); 메소드를 통해서 form을 통해 넘어온 데이터의 name속성 값을 가져온다.
		- request.getParameter(name명); 의 기본 반환타입은 문자열이다.
		- request.getParameterValues(name명); 메소드를 통해서 배열데이터를 전송받을 수 있다.
		
	 	- request.getParameter(name명); 해당 name이 없을 경우 null을 반환한다.
	 	- request.getParameter(name명); 전송된 데이터가 없을 경우 "" 을 반환한다.
	 --%>
	 <%
	 	//내장(built in) 객체 / 생성 없이 그냥 사용
	 	//request.
	 	
	 	request.setCharacterEncoding("utf-8");
	 	
	 	//요청.가져옴 매개변수(데이터);
	 	String name = request.getParameter("name");
	 	String contact = request.getParameter("contact");
	 	//int age = request.getParameter("age"); 전달되는 타입은 모두 String
	 	int age = Integer.parseInt(request.getParameter("age")); // 숫자 형변환
	 	
	 	System.out.println("이름 : " + name);
	 	System.out.println("연락처 : " + contact);
	 	System.out.println("나이 : " + age);
	 	
	 %>
	 <h1>전송되었습니다.</h1>
	 <p><a href="formEx01.jsp">뒤로가기</a></p>
</body>
</html>