<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="data" value="둘리" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.isok eq 'ok'}">
		<jsp:forward page="forward2.ㅓ네"></jsp:forward>
	</c:if>
	<h1>현재 페이지는 forward1 입니다.</h1>
</body>
</html>