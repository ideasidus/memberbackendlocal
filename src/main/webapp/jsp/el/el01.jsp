<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	request.setAttribute("name", "둘리");
 	String [] music = {"학교종이땡땡이","어린음악단","라면송"};
 	pageContext.setAttribute("music", music);
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getAttribute("name") %>
	${name }<br>
	${music[0] }<br>
	<%= request.getParameter("name") %><br>
	${param.name }
	${param.age  + 1 }<br>
	${param.age eq 9 }<br>
	${param.age ne 9 }<br>
	${!empty param.addr }
</body>
</html>