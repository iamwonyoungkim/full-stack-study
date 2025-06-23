<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-23
  Time: 오전 10:31
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
<h1>login</h1>
<form name='f' action='/security/login' method='POST'>
  <%-- csrf 토큰을 hidden으로 심어둬야 한다. (사용자에게는 보여줄 필요 x) --%>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <c:if test="${param.error != null}">
      <div style="color:red">사용자 ID 또는 비밀번호가 틀립니다.</div>
    </c:if>
  <table>
    <tr>
      <td>User:</td>
      <td><input type='text' name='username' value=''></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type='password' name='password'/></td>
    </tr>
    <tr>
      <td colspan='2'>
        <input name="submit" type="submit" value="Login"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
