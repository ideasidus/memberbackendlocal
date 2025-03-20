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
      <h1>게시글 작성</h1>
      <form action="${root }/board?action=boardinsert" method="post">
        <table>
          <tr>
            <td>제목</td>
            <td><input type="text" name="title" /></td>
          </tr>
          <tr>
            <td>작성자 아이디</td>
            <td><input type="text" name="registId" /></td>
          </tr>
          <tr>
            <td>내용</td>
            <td><input type="text" name="content" /></td>
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
