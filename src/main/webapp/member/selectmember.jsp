<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<c:set var="root" value="${pageContext.request.contextPath }" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>회원리스트</h1>
		<form action="${root }/member?action=delids" method="post">
			<table border="1px solid #000">
				<tr><th>ID</th><th>PW</th><th>이름</th><th><input type="submit" value="삭제"></th></tr>
				<c:forEach items="${list }" var="m">	
					<tr>
					<td><a href="${root }/member?action=memberselect&id=${m.id}">${m.id }</a></td>
					<td>${m.pw }</td>
					<td>${m.name }</td>
					<td><input type="checkbox" value="${m.id }" name="delids"></td> 
				</tr>
				</c:forEach>
			</table>
		</form>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>