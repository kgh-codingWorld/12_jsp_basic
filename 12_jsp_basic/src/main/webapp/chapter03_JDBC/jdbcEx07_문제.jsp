<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<!-- 
		
		- 전송된 상품코드를 Database에서 select하고 자바 console환경에 select된 데이터를 출력하는 로직을 작성해보시오.
		
		- (참고) SQL Like절은 예외케이스로 사용방법이 다르다.
		  COLUMN LIKE %?%  와 같은 형식으로 사용할 수 없고 
		  COLUMN LIKE CONCAT('%' , 전송된데이터 ,  '%') 와 같은 형식으로 사용한다.
		  
		  ex)예시
		  "SELECT * FROM MEMBER WHERE ADDRESS LIKE %전송된데이터%"   					> X
		  "SELECT * FROM MEMBER WHERE ADDRESS LIKE CONCAT('%' , 전송된데이터 ,  '%')"   > O
		   
		- 상품이 조회된 후 아래와 같이 조회화면으로 이동할 수 있도록 화면을 작성해보시오.
		   <h3>상품이 조회되었습니다.</h3>
		   <a href="">상품조회 화면으로 이동하기</a>  
		    
	-->

	<form action="jdbcEx07_연습.jsp" method="post">
		<p>상품검색 : <input type="text" name="productNm"></p>
		<p><input type="submit" value="검색"></p>
	</form>

</body>
</html>