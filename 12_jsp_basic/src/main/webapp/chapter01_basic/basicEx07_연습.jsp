<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<p>
		[ 문제설명 ]<br><br>
		
		1. 랜덤객체를 생성 <br>
		2. 랜덤에서 0이 나올 경우 셀렉트태그 생성<br>
		3. 랜덤에서 1이 나올 경우 체크박스 생성<br>
		4. 랜덤에서 2가 나올 경우 라디오 생성<br>
	</p>
	 
	<%
		Random ran = new Random();
		int r = ran.nextInt();
		
		if(r==0) {
	%>
			<select>
				<option>HTML5</option>
				<option>CSS3</option>
				<option>JAVASCRIPT</option>
			</select>
	<%
		} else if(r==1) {
	%>
			<input type="checkbox" name="chkLanguages" value="HTML5">
			<input type="checkbox" name="chkLanguages" value="CSS3">
			<input type="checkbox" name="chkLanguages" value="JAVASCRIPT">
	<%
		} else if(r==2) {
	%>
			<input type="radio" name="rdoLanguages" value="HTML5">
			<input type="radio" name="rdoLanguages" value="CSS3">
			<input type="radio" name="rdoLanguages" value="JAVASCRIPT">
	<%
		}
	%>		
</body>
</html>