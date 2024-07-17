<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete 예시</title>
</head>
<body>

	<% 
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "1234");

			String sql = "DELETE FROM PRODUCT WHERE PRODUCT_CD = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "P10016");

			/*
				- 화면에서 전송된 데이터를 저장
				pstmt.setString(1 , request.getParameter("전송된 데이터"));
			*/
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	
	%>

</body>
</html>