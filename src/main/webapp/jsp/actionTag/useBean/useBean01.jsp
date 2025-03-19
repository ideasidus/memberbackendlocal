<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.ssafy.dto.MemberDto"%>
<jsp:useBean id="dto" class="edu.ssafy.dto.MemberDto" scope="session"/>
<jsp:setProperty property="id" name="dto" value="13"/>
<jsp:setProperty property="pw" name="dto" value="24"/>
<jsp:setProperty property="name" name="dto" value="둘리"/>

<%-- <% 
	MemberDto dto = new MemberDto("11", "22", "둘리");
	session.setAttribute("dto", dto);
%>
 --%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>