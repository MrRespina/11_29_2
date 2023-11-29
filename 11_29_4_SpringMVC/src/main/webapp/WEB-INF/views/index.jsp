<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/index.js">
</script>
</head>
<body>
	View(v) - 
		JSP : .html or .jsp
		Spring : .jsp
		Spring Boot : .html 가능
		
		Spring 내에서 쓰는 자원파일들(css, js, img, ...)
			webapp - resources
	
	<table border="1" style="border-color: white;border-radius: 3px;margin-top:100px; background-color: gray;" align="center">
		<form name="ff" action="calculate.do" method="post">
		<tr>
			<td colspan="1">이름</td><td colspan="1"><input name="name" placeholder="이름입력"></td>
		</tr>
		<tr>
			<td colspan="1">x</td><td colspan="1"><input name="x" placeholder="x입력"></td>
		</tr>
		<tr>
			<td colspan="1">y</td><td colspan="1"><input name="y" placeholder="y입력"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button name="inputBtn">입력하기</button></td>
		</tr>
		</form>
	</table>
	<c:if test="${ r != null }">
	<table  border="1" style="border-color: white;border-radius: 3px;margin-top:100px; background-color: gray;" align="center">
		<tr>
			<td>이름 : ${a_name }</td>
		</tr>
		<tr>
			<td>x : ${a_x }</td>
		</tr>
		<tr>
			<td>y : ${a_y}</td>
		</tr>
		<tr>
			<td>x+y : ${r}</td>
		</tr>
		<tr>
			<td>총 실행 수 : ${a_count}</td>
		</tr>
	</table>
	</c:if>
</body>
</html>