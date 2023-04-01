<%--
  Created by IntelliJ IDEA.
  User: dly
  Date: 2021/10/21
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>首页</h1>

    <hr>

    ${username}
    <a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
