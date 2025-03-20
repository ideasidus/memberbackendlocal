<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.isok eq 'ok' }">
			<h1>쉴까요?</h1>
		</c:when>
		<c:when test="${param.isok eq 'no' }">
			<h1>계속공부할까요?</h1>
		</c:when>
		<c:otherwise>
			<h1>어쩌라고?</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>