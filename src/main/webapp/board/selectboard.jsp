<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath }" scope="request" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <div align="center">
      <h1>게시판</h1>
      <a href="${root }/board/insertform.jsp">글 작성 하기</a>
      <table border="1px solid #000">
        <tr>
          <th>ID</th>
          <th>제목</th>
          <th>게시자</th>
        </tr>
        <c:forEach items="${list }" var="b">
          <tr>
            <td>${b.id }</td>
            <td>
              <a href="${root }/board?action=boardselect&id=${b.id}"
                >${b.title }</a
              >
            </td>
            <td>${b.registId }</td>
          </tr>
        </c:forEach>
      </table>
      <%@ include file="footer.jsp" %>
    </div>
  </body>
</html>
