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
<script type="text/javascript">
	function updatemember(){
		
		//alert("update");
		document.getElementById("rform").action = "${root}/member?action=memberupdate";
		document.getElementById("rform").submit();
	}
	function deletemember(){
		//alert("delete");
		document.getElementById("rform").action = "${root}/member?action=memberdelete";
		document.getElementById("rform").submit();
	}

</script>
<body>
	<div align="center">
		<h1>회원상세</h1>
		<form action="#" method="post" id="rform">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="${mem.id }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="text" name="pw" value="${mem.pw }"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${mem.name }"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" value="수정" onclick="updatemember()"/>
						<input type="button" value="삭제" onclick="deletemember()"/>
					</td>
				</tr>

			</table>
		</form>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>