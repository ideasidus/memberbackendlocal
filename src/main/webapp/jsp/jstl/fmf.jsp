<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<% request.setAttribute("value", 123456789); %>
<jsp:useBean id="date" class="java.util.Date" scope="session"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${value }<br>
	<fmt:formatNumber type="number" value="${value }" maxFractionDigits="3"/><br>
	<fmt:formatNumber type="currency" value="${value }" maxFractionDigits="3"/><br>
	${date }<br>
	<fmt:formatDate value="${date }" type="date"/><br>
	<fmt:formatDate value="${date }" type="time"/><br>
	<fmt:formatDate value="${date }" type="both"/><br>
	
</body>
</html>








