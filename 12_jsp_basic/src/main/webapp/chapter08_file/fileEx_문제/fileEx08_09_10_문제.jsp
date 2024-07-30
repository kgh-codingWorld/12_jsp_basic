<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<h3>fileEx08</h3>
	<fieldset>
		<table border="1">
			<tr>
				<td><a>test1.hwp</a></td>
				<td><a>test2.txt</a></td>
				<td><a>test3.xlxs</a></td>
			</tr>
		</table>
	</fieldset>

	<h3>fileEx09</h3>
	<form>
		<fieldset>
			<legend>파일 삭제</legend>
			<p>삭제할 파일명 : <input type="text" /></p>
			<input type="submit" value="삭제하기">
		</fieldset>
	</form>
	<hr/>

	<h3>fileEx10</h3>
	<form>
		<fieldset>
		<legend>파일 수정</legend>
		   <p>삭제할 파일명 : <input type="text" ></p>
		   <p>수정할 파일 : <input type="file" ></p>
		   <input type="submit" value="수정하기">
		</fieldset>
	</form>

</body>
</html>