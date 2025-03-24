<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<c:set var="root"
	value="${pageContext.request.servletContext.contextPath }"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:if test="${!empty loginedMember }">
			<label>로그인ID : ${loginedMember.id }</label>
			<!-- <input type="button" value="logout" /> -->
			<a href="${root }/member?action=logout">로그아웃</a>
		</c:if>
		<c:if test="${empty loginedMember }">
			<a href="${root }/member/loginform.jsp">로그인</a>
		</c:if>
	</div>
</body>
</html>