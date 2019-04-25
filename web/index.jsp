<%--
  Created by IntelliJ IDEA.
  user: K
  Date: 2019/4/24
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="login" method="post">
    <input type="text" name="phone" placeholder="tel">
    <input type="text" name="password" placeholder="password">
    <button type="submit">登录</button>
</form>
<form action="regist" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="text" name="password" placeholder="password">
    <input type="text" name="phone" placeholder="tel">
    <input type="text" name="email" placeholder="email">
    <button type="submit">登录</button>
</form>
</body>
</html>
