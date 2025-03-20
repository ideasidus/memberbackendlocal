<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 디렉티브 -->  
<!-- 

 -->
<!-- 디클리어레이션 -->

<%! 
	// 클래스 맴버 생성하는 코드
	// 클래스안의 객체변수 영역
	private int a = 10;
	int getA(){
		return a;
	}
	
%>

<!-- 스크릿트릿 -->
<% 
	// service 안의 지역블럭
	int a = 20; 
	int b = 30;
	// 함수선언 안되
	getA();
	
	// <!-- -->
	//request.getParameter(name);
	//out.append(c)
	//response.getWriter();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 익스프레션 -->
	<%=a%><br/>
	<%=b%><br/>
	<%=getA()%>
	
</body>
</html>