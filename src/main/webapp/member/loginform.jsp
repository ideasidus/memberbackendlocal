<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/member/header.jsp"%>
<
<c:set var="root" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<form action="${root }/member?action=login" method="post">
			<table>
				<tr>
					<td>id</td>
					<input type="text" name="id" value="${cookie.idsave.value}">
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="text" name="pw"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="pw" value="로그인">아이디저장<input
						type="checkbox" name="idsave"
						${not empty cookie.idsave != null ? "checked":"" } /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>