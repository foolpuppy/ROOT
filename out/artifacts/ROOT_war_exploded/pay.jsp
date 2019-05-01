<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="top.wigon.entity.Order" %>
<%@ page import="top.wigon.service.impl.OrderServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2019/5/1
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pay</title>
</head>
<body>
<%
    OrderServiceImpl orderService = new OrderServiceImpl();
    List<Order> orderList = orderService.getAllOrders();
    session.setAttribute("order", orderList);
%>
<C:forEach var="res" items="${sessionScope.order}">
    <a href="GoPay?order_no=${res.orderId}">${res.orderId}</a><br>
</C:forEach>
</body>
</html>
