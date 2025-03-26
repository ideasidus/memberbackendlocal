<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath }"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/member/header.jsp"%>
	<div align="center">
		<h1>회원리스트</h1>
		<form class="row mb-3" action="${root }/member" method="get"
			id="search-form">
			<input type="hidden" name="action" value="memberselectall" /> <input
				type="hidden" id="currentPage" name="currentPage" value="1" />
			<div class="d-flex justify-content-end">
				<select class="form-select w-25" name="key">
					<optiondisabled ${emptyparam.key?'selected':'' }>검색항목 선택</option>
					<option value="name" ${param.key=='name'?'selected':'' }>name</option>
					<option value="id" ${param.key=='email'?'selected':'' }>id</option>
				</select> <input
					type="text" class="form-control w-25" name="word"
					value="${param.word}">
				<button type="submit" class="btn btn-primary">검색</button>
			</div>
		</form>
		<form action="${root }/member?action=delids" method="post">
			<table border="1px solid #000">
				<tr>
					<th>ID</th>
					<th>PW</th>
					<th>이름</th>
					<th><input type="submit" value="삭제"></th>
				</tr>
				<c:forEach items="${page.list }" var="m">
					<tr>
						<td><a href="${root }/member?action=memberselect&id=${m.id}">${m.id }</a></td>
						<td>${m.pw }</td>
						<td>${m.name }</td>
						<td><input type="checkbox" value="${m.id }" name="delids"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<nav class="d-flex justify-content-center">
			<ul class="pagination">
				<!-- 이전 버튼 -->
				<c:if test="${page.hasPre}">
					<li class="page-item"><a class="page-link" href="#"
						data-page="${ page.startPage-1}">이전</a></li>
				</c:if>

				<!-- 페이지 번호 -->
				<c:forEach begin="${page.startPage}" end="${page.endPage}"
					var="item">
					<li
						class="page-item ${page.condition.currentPage == item ? 'active' : ''}">
						<a class="page-link" href="#" data-page="${ item}">${item}</a>
					</li>
				</c:forEach>

				<!-- 다음 버튼 -->
				<c:if test="${page.hasNext}">
					<li class="page-item"><a class="page-link" href="#"
						data-page="${ page.endPage+1}">다음</a></li>
				</c:if>
			</ul>
		</nav>

		<%@ include file="footer.jsp"%>
	</div>
</body>
<script>
const pageLinks = document.querySelectorAll(".pagination a");
pageLinks.forEach(link =>{
  link.addEventListener("click", (e)=>{
    e.preventDefault(); //a 링크의 기본 동작 중지
    document.querySelector("#currentPage").value=link.dataset.page; // 링크에 설정된 data 속성으로 form의 page 수정
    document.querySelector("#search-form").submit(); // form sumbit
  })
})
</script>

</html>