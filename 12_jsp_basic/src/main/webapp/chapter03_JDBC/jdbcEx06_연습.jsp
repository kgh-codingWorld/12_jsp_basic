<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "1234");
			
			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_CD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("productCd"));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String productCd = rs.getString("PRODUCT_CD");
				String productNm = rs.getString("PRODUCT_NM");
				int price		 = rs.getInt("PRICE");
				Date regDt 		 = rs.getDate("REG_DT");	
				
				System.out.println("--조회 결과--");
				System.out.println("productCd: " + productCd);
				System.out.println("productNm: " + productNm);
				System.out.println("price: " + price);
				System.out.println("regDt: " + regDt);
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
	%>

</body>
</html>