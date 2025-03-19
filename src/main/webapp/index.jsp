<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String root = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>
			<a href="${root}/member/insertform.html">회원입력</a>
		</h2>
		<h2>
			<a href="">회원수정</a>
		</h2>
		<h2>
			<a href="">회원삭제</a>
		</h2>
		<h2>
			<a href="${root}/member?action=memberselectall">회원조회</a>
		</h2>
	</div>
</body>
</html>