<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문</title>
</head>
<body>
	<h3>조건문</h3>
	<%
		String name = "팀2";
		if(name.equals("팀")) {
	%>
			<p>버너스 리입니다.</p>
	<%		
		}
		else {
	%>
			<p>버너스 리가 아닙니다.</p>
	<%
		}
	%>
	<hr/>
	<h3>반복문</h3>
	<%
		for (int i=0;i<10; i++) {
	%>
			<p>for문<%= i %></p>	
	<%		
		}
	%>
	<hr/>
	<%
		int idx = 0;
		while (idx < 10) {
	%>
		<p>while문<%=idx %></p>
	<%
			idx++;
		}
	%>
</body>
</html>