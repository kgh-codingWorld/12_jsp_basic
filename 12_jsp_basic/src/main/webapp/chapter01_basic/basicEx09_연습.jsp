<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습예시</title>
</head>
<body>
	
	<p>
		[ 문제설명 ]<br><br>
		
		1.  랜덤객체를 생성하여 1부터 12까지 선택한다.<br>
		2. <br>
			1, 3, 5, 7, 8, 10, 12 월은 '1일 ~ 31일' ,<br> 
			2월은 '1일 ~ 28일' , <br>
			4, 6, 9, 11월은 '1일 ~ 30일'을 셀렉트 태그에 표기하시오.<br> 
	</p>

	<%
		Random ran = new Random();
	%>
	
</body>
</html>