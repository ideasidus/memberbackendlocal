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
		<h1>회원입력</h1>
		<form action="${root }/member?action=memberinsert" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="text" name="pw" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="입력" /></td>
				</tr>

			</table>
		</form>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>