<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>Hello World!</h2>
<%--居中显示--%>
<div style="text-align: center">
<%--这里提交路径，要找到项目的路径--%>
<%--${pageContext.request.contextPath}代表当前项目--%>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    爱好:
    <input type="checkbox" name="bobbys" value="女孩">女孩
    <input type="checkbox" name="bobbys" value="代码">代码
    <input type="checkbox" name="bobbys" value="唱歌">唱歌
    <input type="checkbox" name="bobbys" value="电影">电影
    <br>
    <input type="submit">
</form>
</div>
</body>
</html>
