<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int myAnswer = Integer.parseInt(request.getParameter("answer"));
		int answer = num1 * num2;
		
		String result = "";
		if(myAnswer == answer) 	result = "정답";
		if(myAnswer != answer) 	result = "땡";
	%>
	
	<h2><%=num1 %> * <%=num2 %> = <%=myAnswer %></h2>
	<h2><%=answer %></h2>
</body>
</html>