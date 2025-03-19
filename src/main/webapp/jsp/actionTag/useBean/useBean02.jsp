<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.dto.MemberDto"%>
    
<% 
	MemberDto dto = (MemberDto) session.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= dto.getId() %><br/>
	${dto.id }<br/>
</body>
</html>