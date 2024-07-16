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
	
		String id   = request.getParameter("id");
		String pw   = request.getParameter("pw");
		String dbId = request.getParameter("dbId");
		String dbPw = request.getParameter("dbPw");
		
		if(id.equals(dbId) && pw.equals(dbPw)) {
	%>
			alert("로그인이 완료되었습니다.");
	<%		
		} else {
	%>
			alert("아이디 또는 비밀번호가 맞지 않습니다.");
	<%
		}
	%>
	
</body>
</html>