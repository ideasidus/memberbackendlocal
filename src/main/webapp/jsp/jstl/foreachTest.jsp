<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="price" value="300,500,700,800,900,1100,1300" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="p" items="${price }" varStatus="cnt">
	price : ${p }, cnt : ${cnt.count } <br />
	</c:forEach>
	<hr />
	<c:forEach var="p" items="${price }" varStatus="cnt" begin="3">
	price : ${p }, cnt : ${cnt.count } <br />
	</c:forEach>
	<hr />
	<c:forEach var="p" items="${price }" varStatus="cnt" begin="3" end="4">
	price : ${p }, cnt : ${cnt.count } <br />
	</c:forEach>
	<hr />
	<c:forTokens items="dog:cat:bird" delims=":" var="p">
	${p } <br />
	</c:forTokens>
</body>
</html>