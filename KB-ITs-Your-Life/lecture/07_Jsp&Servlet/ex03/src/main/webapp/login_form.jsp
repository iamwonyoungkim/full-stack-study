<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-04
  Time: 오후 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>getParameter 실습</h1>
    <form action="login" method="post">
        <fieldset>
            <legend>로그인 폼</legend>
            <ul style="list-style: none">
                <li>
                    <label for="userid">아이디</label>
                    <input type="text" name="userid" id="userid">
                    <%-- name에 해당하는 파라미터가 없다면 null 리턴 (오타 주의) --%>
                </li>
                <li>
                    <label for="passwd">비밀번호</label>
                    <input type="password" name="passwd" id="passwd">
                </li>
                <li><input type="submit" value="전송"></li>
            </ul>
        </fieldset>
    </form>
</body>
</html>
