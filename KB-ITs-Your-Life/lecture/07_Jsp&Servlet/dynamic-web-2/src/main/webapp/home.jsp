<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-05
  Time: 오후 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
  <h3>홈페이지입니다.</h3>
  <a href="hobby">취미입력하기</a>
  <hr/>
    <!--
        sessionScope.를 없애도 순서대로 찾아가므로 제대로 동작함.
        request부터 찾는데, request에 member가 현재 없기 때문.
    -->
    <%-- <c:if test="${empty sessionScope.member}"> --%>
    <%-- <a href="login">로그인</a> --%>
    <%-- </c:if> --%>

    <%-- choose도 사용 가능 --%>
    <c:choose>
        <c:when test="${empty sessionScope.member}"><a href="login">로그인</a></c:when>
        <c:otherwise>
            <h3>${sessionScope.member.name}님 환영합니다.</h3>
            <a href="logout">로그아웃</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
