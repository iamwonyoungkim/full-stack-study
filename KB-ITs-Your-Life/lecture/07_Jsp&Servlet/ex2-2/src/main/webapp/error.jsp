<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-04
  Time: 오후 8:45
  To change this template use File | Settings | File Templates.
--%>
<%-- page 지시어에서 isErrorPage="true"인 경우에만 사용 가능 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>exception 실습</title>
</head>
<body>
<h1>divide.jsp 발생된 예외를 처리하는 페이지</h1>
<%
  out.print("발생된 예외는 : " + exception.getMessage());
%>
</body>
</html>
