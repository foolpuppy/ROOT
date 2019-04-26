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
    <title>测试页面</title>
</head>
<body>
<form action="login" method="post">
    <input type="text" name="phone" placeholder="tel">
    <input type="text" name="password" placeholder="password">
    <button type="submit">提交</button>
</form>
<form action="regist" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="text" name="password" placeholder="password">
    <input type="text" name="phone" placeholder="tel">
    <input type="text" name="email" placeholder="email">
    <button type="submit">提交</button>
</form>
<form action="addItem" method="post">
    <input type="text" name="item_id" placeholder="item_id">
    <input type="text" name="item_title" placeholder="item_title">
    <input type="text" name="item_category" placeholder="item_category">
    <input type="text" name="item_price" placeholder="item_price">
    <input type="text" name="item_stock" placeholder="item_stock">
    <input type="text" name="item_state" placeholder="item_state">
    <input type="text" name="shop_id" placeholder="shop_id">
    <button type="submit">提交</button>
</form>
<form action="pay" method="post">
    <input type="text" name="order_id" placeholder="唯一订单号">
    <input type="text" name="money" placeholder="金额">
    <input type="text" name="name" placeholder="订单名称">
    <button type="submit">提交</button>
</form>
</body>
</html>
