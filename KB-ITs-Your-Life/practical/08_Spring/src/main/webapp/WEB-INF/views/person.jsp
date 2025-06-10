<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-10
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Person Information Form</title>
</head>
<body>
<h2>개인 정보 입력</h2>
<form action="/person/create1" method="post">
  <input type="text" name="name" placeholder="이름">
  <input type="number" name="age" placeholder="나이">
  <input type="date" name="birthday">
  <input type="checkbox" name="hobby" value="reading">독서
  <input type="checkbox" name="hobby" value="sports">운동
  <input type="checkbox" name="hobby" value="music">음악
  <input type="submit" value="제출">
</form>
</body>
</html>