<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-09
  Time: 오전 11:14
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
  <h1>환영합니다.</h1>

  <sec:authorize access="isAnonymous()"> <!-- 로그인 안 한 경우 -->
    <a href="/security/login">로그인</a>
  </sec:authorize>

  <sec:authorize access="isAuthenticated()"> <!-- 로그인 한 경우 -->
    <sec:authentication property="principal.username"/>
    <form action="/security/logout" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <input type="submit" value="로그아웃"/>
    </form>
  </sec:authorize>

</body>
</html>
