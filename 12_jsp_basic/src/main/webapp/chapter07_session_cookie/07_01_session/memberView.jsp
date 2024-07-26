<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	
	<%-- view(jsp)에서 session객체에 접근하는 방법 ${sessionScope.속성명} --%> 
	
	<c:if test="${sessionScope.role  == 'user'}">
		<h3>${sessionScope.id }님 로그인 되었습니다. (${sessionScope.role } 권한)</h3>
		<p><a href="myPage">마이페이지로 이동</a></p>
		<p><a href="cart">카트리스트 이동</a></p>
		<p><a href="logout">로그아웃</a></p>
	</c:if>
	
	<c:if test="${sessionScope.role == 'admin' }">
		<h3>${sessionScope.id }님 로그인 되었습니다. (${sessionScope.role } 권한)</h3>
		<p><a href="admin">관리자페이지로 이동</a></p>
		<p><a href="logout">로그아웃</a></p>
	</c:if>
</body>
</html>