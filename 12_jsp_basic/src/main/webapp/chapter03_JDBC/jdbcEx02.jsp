<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select 예시</title>
</head>
<body>

	<%
	
		// 데이터베이스를 연결하기 위한 객체
		Connection conn = null; 	// java.sql.Connection
		
		// 쿼리문을 실행하기 위한 객체
		PreparedStatement pstmt = null; // java.sql.PreparedStatement
		
		// select쿼리의 result를 저장할 객체
		ResultSet rs = null; // java.sql.ResultSet
		
		try {
			
			// 데이터베이스 연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT");
			
			// executeQuery()  : select문 실행 메서드
			rs = pstmt.executeQuery();
			
			/*
			
				# db의 컬럼명을 가져 오는 2가지 방법
				
					1) rs.get자료형메서드("컬럼명");
					  
						ex) 
							rs.getString("PRODUCT_CD"); 
							rs.getInt("PRODUCT_PRICE");
							rs.getDate("ENROLL_DT");
					
							
					2) rs.get자료형메서드(index);
						
						ex) 
							rs.getString(1);
							rs.getInt(2);
							rs.getDate(3);
					
						- 유지보수 및 가독성 향상을 위해서 컬럼명지정 방식을 권장한다.
						- index가 1부터 시작되는 점을 유의해야 한다.
				
			*/
			
			while (rs.next()) { // 다음 row가 있으면 true를 반환한다.	
			
				String productCd = rs.getString("PRODUCT_CD"); // rs.getString(1);
				String productNm = rs.getString("PRODUCT_NM"); // rs.getString(2);
				int price = rs.getInt("PRICE"); 			   // rs.getInt(3);
				Date regDt = rs.getDate("REG_DT");			   // rs.getDate(4);	
				
				System.out.println("productCd : " + productCd);
				System.out.println("productNm : " + productNm);
				System.out.println("price : " + price);
				System.out.println("regDt : " + regDt);
				System.out.println();
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 데이터베이스 연결정보 해지
			rs.close();
			pstmt.close();
			conn.close();
		}
		
	%>
	<h3>상품이 조회되었습니다.</h3>

</body>
</html>