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
	function updateboard(){
		
		//alert("update");
		document.getElementById("rform").action = "${root}/board?action=boardupdate";
		document.getElementById("rform").submit();
	}
	function deleteboard(){
		//alert("delete");
		document.getElementById("rform").action = "${root}/board?action=boarddelete";
		document.getElementById("rform").submit();
	}

</script>
<body>
	<div align="center">
		<h1>게시글</h1>
		<form action="#" method="post" id="rform">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="${write.id }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${write.title }"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="content" value="${write.content }"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="registid" value="${write.registId }"/></td>
				</tr>
				<tr>
					<td>작성날짜</td>
					<td><input type="text" name="registdate" value="${write.registDate }"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" value="수정" onclick="updateboard()"/>
						<input type="button" value="삭제" onclick="deleteboard()"/>
					</td>
				</tr>

			</table>
		</form>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>