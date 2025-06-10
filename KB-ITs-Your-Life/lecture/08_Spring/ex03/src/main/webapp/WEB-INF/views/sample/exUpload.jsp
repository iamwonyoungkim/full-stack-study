<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2025-06-10
  Time: 오전 11:48
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
  <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
    <div>
      <input type="file" name="files" />
    </div>
    <div>
      <input type="file" name="files" />
    </div>
    <div>
      <input type="file" name="files" />
    </div>
    <div>
      <input type="file" name="files" />
    </div>
    <div>
      <input type="file" name="files" />
    </div>
    <div>
      <input type="submit" />
    </div>
  </form>
</body>
</html>
