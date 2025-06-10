<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-10
  Time: 오전 11:14
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
    <%-- DTO 쿼리 파라미터는 자동으로 뷰로 전달됨 --%>
    <h2>SAMPLE DTO ${sampleDTO}</h2>
    <%-- 기본 자료형 쿼리 파라미터는 뷰로 전달되지 않음 --%>
    <h2>PAGE ${page}</h2>
</body>
</html>
