<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import</title>
</head>
<body>
	
	<%
	 	Random ran = new Random();
		String[] languages = {"java", "html", "css", "javascript", "jquery", "mysql", "jsp"};
		int r = ran.nextInt(6);
	%>
	<h1><%= languages[r] %>언어 재미있다...</h1>
	<%
		Date temp = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(temp);
	%>
	<h1>현재시간 : <%=now %></h1>
</body>
</html>