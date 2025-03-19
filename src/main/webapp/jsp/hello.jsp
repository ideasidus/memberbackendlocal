<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 디렉티브 -->
<%@ taglib prefix="c"uri="jakarta.tags.core" %>
<!-- 디클리어레이션 -->
<%! 
	int a = 10;
	int getA(){
		return a;
	}
	// 함수 호출 불가
%>
<!-- 스크립트 릿 -->
<%
	int a = 20;
	int b = 30;
	// 함수 선언 불가
	getA();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 익스프레션 -->
	<%= a%><br/>
	<%= b%><br/>
	<%= getA()%>
</body>
</html>