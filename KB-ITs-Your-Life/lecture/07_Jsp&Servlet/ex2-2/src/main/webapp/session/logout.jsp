<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-04
  Time: 오후 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate();
  response.sendRedirect("loginForm.html");
%>