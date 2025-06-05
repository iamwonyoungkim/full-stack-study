<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-05
  Time: 오후 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%-- submit을 누르면 /login에 post로 간다 --%>
  <form action="login" method="post">
    이메일: <input type="email" name="email" value="${cookie.saveEmail.value}" required><br>
    비밀번호: <input type="password" name="password" required><br>
    <input type="checkbox" name="saveEmail" ${cookie.saveEmail != null ? 'checked' : ''}> 이메일 저장<br>
    <input type="submit" value="로그인">
  </form>
</body>
</html>
