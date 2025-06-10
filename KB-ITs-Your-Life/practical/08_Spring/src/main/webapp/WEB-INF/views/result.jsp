<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-10
  Time: 오후 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>결과 페이지</title>
</head>
<body>
    <h2>전달받은 데이터 출력</h2>

    <h3>기본 데이터</h3>
    <p>숫자: ${num}</p>
    <p>문자열: ${hello}</p>
    <p>논리값: ${yn}</p>

    <h3>Person 객체 데이터</h3>
    <p>이름: ${person.name}</p>
    <p>나이: ${person.age}</p>
    <p>생일: <fmt:formatDate value="${person.birthday}" pattern="yyyy-MM-dd"/></p>

    <h3>취미 목록</h3>
    <ul>
        <c:forEach var="hobby" items="${person.hobby}">
            <li>${hobby}</li>
        </c:forEach>
    </ul>





</body>
</html>
