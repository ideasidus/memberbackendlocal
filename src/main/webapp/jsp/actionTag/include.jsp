<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>front</h1>
	<!-- 각각을 컴파일해서 실행하다가 갔다온다 -->
	<jsp:include page="header.jsp"></jsp:include>
	<h1>body</h1>
	<!-- 하나로 합쳐져서 하나의 서블렛이 된다. (로컬변수 겹치면 안된다) -->
	<%@ include file="header.jsp"%>

</body>
</html>