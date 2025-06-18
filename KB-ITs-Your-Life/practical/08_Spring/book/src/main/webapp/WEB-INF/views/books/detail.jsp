<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-18
  Time: 오후 4:47
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
책 제목: ${book.title}<br>
상세 정보
<ul>
  <li>isbn: ${book.bookDetail.isbn}</li>
  <li>publisher: ${book.bookDetail.publisher}</li>
</ul>
</body>
</html>
