<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문</title>
</head>

	<%-- 

		1) forEach문1 
	
			[형식]
	
			<c:forEach var="임시변수명" begin="시작" end="끝" step="증감식"></c:forEach>
		
			- java의 for문 기능을 한다.
			- var속성에 임시변수명을 작성하고 begin , end속성으로 반복 횟수를 지정한다.
			  (옵션)step을 통해서 증감식을 지정할 수 있다.
		
	  
	  
		2) forEach문2
			
			[형식]
			
			<c:forEach var="임시변수명" items=${배열이름}" varStatus="변수명">	</c:forEach>
			
			- 자바의 forEach문 기능을 한다.
			- items 속성에 배열 및 어레이리스트등 반복가능한 객체를 지정한다.
			
			[ varStatus 속성값 ]
			
			${변수명.current} : 현재 for문의 해당하는 값
			${변수명.index}   : 0부터의 순서
			${변수명.count}   : 1부터의 순서
			${변수명.first}   : 첫 번째인지 여부
			${변수명.last}    : 마지막인지 여부
			${변수명.begin}   : for문의 시작 번호
			${변수명.end}     : for문의 끝 번호
			${변수명.step}    : for문의 증가값
			
	 --%>

<body>

	<h3>1) forEach문</h3>
	<c:forEach var="year" begin="1900" end="2024">
		${year}
	</c:forEach>
	<hr>
	
	<%-- 
	
		- JSTL 코드는 JSP 주석으로 처리해야 한다.
		- forEach는 내림차순이 적용되지 않는다.
		
		<c:forEach var="i"  begin="10" end="1">
			${i } 
		</c:forEach>
		
	--%>
	<c:forEach var="year" begin="1900" end="2024" step="${year + 10 }">
		${year}
	</c:forEach>
	
	<hr>
	
	
	<h3>2) forEach문</h3>
	<c:forEach var="data" items="${datas }"> <%-- items="data" 틀림 --%>
		${data } 
	</c:forEach>
	<hr>
	<a><c:forEach var="data" items="${datas }" varStatus="i"> <%-- items="data" 틀림 --%>
		<p id="data${i.index }" >${i.first} / ${i.index} / ${i.count} / ${data }</p> 
	</c:forEach></a>
	
</body>
</html>