<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setAttribute("name", "둘리");
String[] music = { "학교종이땡땡땡", "어린음악단", "라면송", "라디오가가" };
session.setAttribute("music", music);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("name")%><br> ${name }
	<br> ${music[0] }
	<br>
	<%=request.getParameter("name")%>
	<br> ${param.name } ${param.age + 1 } ${param.age eq 9 }

	<!-- ne, gt, lt, addr -->
</body>
</html>