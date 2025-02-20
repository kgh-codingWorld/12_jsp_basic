<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--   
	
		# EL (Expression Language)
		
			- 자바코드를 사용하지 않고 간편하게 출력을 지원하기 위한 방법이다.
			- 자바의 문법과 html의 태그요소들이 섞여있기에 프론트와 백앤드의 효율적인 업무 분리 작업을 위하여 나온 표현방법이 EL이다.
			- $ 와 {}를 사용하여 표현한다.
	
	
			[ 형식 ]
			
			${표현1.표현2}     : $ 와 {}를 사용하여 표현한다.

			[표현1 상세]	
			
			${param.} 			  : 파라미터값 접근        
			${paramValues.} 	  : 파라미터값 배열로 접근  
			${sessionScope.}	  : 세션 Scope에 접근
			${pageScope.}		  : 페이지 Scope에 접근
			${requestScope.} 	  : 리퀘스트 Scope에 접근
			${applicationScope.}  : 어플리케이션 Scope에 접근


			[표현2 상세]
			
			- form형식의 name값 , 세션 및 쿠키의 id 값 등등
			
			[ 예시 ] 
			 
			${param.contact}   : 파라메타로 전달되는 값 중에 contact속성
			${param.grade}     : 파라메타로 전달되는 값 중에 grade속성
			${sessionScope.id} : session중에 id속성
			${requestScope.name} : request요청중에 name속성
			${name} : request요청중에 name속성(생략가능)
	
	--%>

	<h3>자바의 변수 표기</h3>
	<p>${requestScope.name } / ${name}</p> <%-- request.setAttribute("name", "Tim"); --%>
	<p>${requestScope.num1 } / ${num1}</p> <%-- request.setAttribute("name", 12); --%>
	<p>${requestScope.num2 } / ${num2}</p> <%-- request.setAttribute("name", 3); --%>
	<hr>
	
	<h3>산술 연산자</h3>
	<p>${num1 + num2 } / ${num1 } + ${num2 }</p>
	<p>${num1 - num2 }</p>
	<p>${num1 * num2 }</p>
	<p>${num1 / num2 } / ${num1 div num2 }</p>
	<p>${num1 % num2 } / ${num1 mod num2 }</p>
	<hr>
	
	<h3>관계 연산자</h3>
	<p>${num1 > num2 }, ${num1 gt num2 }</p>
	<p>${num1 >= num2 }, ${num1 ge num2 }</p>
	<p>${num1 < num2 }, ${num1 lt num2 }</p>
	<p>${num1 >= num2 }, ${num1 le num2 }</p>
	<p>${num1 = num2 }, ${num1 eq num2 }</p>
	<p>${num1 != num2 }, ${num1 ne num2 }</p>
	<hr>
	
	<h3>논리 연산자</h3>
	<p>${num1 < num2 && name == "Tim" }, ${num1 < num2 and name == "Tim" }</p>
	<p>${num1 < num2 || name == "Tim" }, ${num1 < num2 or name == "Tim" }</p>
	<p>${!(name == "Tim") }, ${not(name == "Tim") }</p>
	<hr>
	
	<h3>배열형 데이터 타입</h3>
	<p>${list1 == null } / ${list1 != null }</p>
	<p>${empty list2 } / ${not empty list2 }</p> <!-- empty 키워드로 빈 배열을 판정 -->
</body>
</html>