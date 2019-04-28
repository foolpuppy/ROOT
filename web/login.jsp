<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2019/4/28
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    // 获取当前域名下的cookies，是一个数组
    cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if ((cookie.getName()).compareTo("userTel") == 0) {
                response.sendRedirect("index.html");
            }
        }
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script type="text/javascript" src="res/layui/layui.js"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="/">首页</a>
        </p>
        <div class="sn-quick-menu">
            <div class="login"><a href="register.html">请注册</a></div>
            <div class="sp-cart"><a href="shopcart.html">购物车</a><span>2</span></div>
        </div>
    </div>
</div>


<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="/" title="商城">
                    <img src="res/static/img/logo.png">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="" class="layui-form" novalidate>
                    <input type="text" name="title" required lay-verify="required" autocomplete="off"
                           class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>


<div class="content content-nav-base  login-content">

    <div class="login-bg">
        <div class="login-cont w1200">
            <div class="form-box">
                <form class="layui-form" action="login" method="post">
                    <legend>手机号登录</legend>
                    <div class="layui-form-item">
                        <div class="layui-inline iphone">
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-cellphone iphone-icon"></i>
                                <input type="tel" name="phone" id="phone" lay-verify="required|phone"
                                       placeholder="请输入手机号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline iphone">
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-password iphone-icon"></i>
                                <input type="password" name="password" id="password" lay-verify="required|password"
                                       placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline veri-code">
                            <div class="layui-input-inline">
                                <input id="pnum" type="text" name="pnum" lay-verify="required" placeholder="请输入验证码"
                                       autocomplete="off" class="layui-input">
                                <input type="button" class="layui-btn" id="find" value="验证码"/>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item login-btn">
                        <div class="layui-input-block" style="padding-top: 0px">
                            <input class="layui-btn" lay-submit="" lay-filter="demo1" type="submit" name="submit"
                                   value="登录" style="width: 300px; background-color:#FF794E;">
                        </div>
                    </div>
                </form>
                <p style="text-align: center; color: gray">没有帐号？<a href="register.html">请注册</a></p>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <div class="ng-promise-box">
        <div class="ng-promise w1200">
            <p class="text">
                <a class="icon1" href="javascript:">7天无理由退换货</a>
                <a class="icon2" href="javascript:">满99元全场免邮</a>
                <a class="icon3" style="margin-right: 0" href="javascript:">100%品质保证</a>
            </p>
        </div>
    </div>
    <div class="mod_help w1200">
        <p>
            <a href="javascript:">关于我们</a>
            <span>|</span>
            <a href="javascript:">帮助中心</a>
            <span>|</span>
            <a href="javascript:">售后服务</a>
            <span>|</span>
            <a href="javascript:">母婴资讯</a>
            <span>|</span>
            <a href="javascript:">关于货源</a>
        </p>
        <p class="coty">母婴商城版权所有 &copy; 2012-2020</p>
    </div>
</div>
<script type="text/javascript">
    layui.config({
        base: 'res/static/js/util' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['jquery', 'form'], function () {
        var $ = layui.$, form = layui.form;

        $("#find").click(function () {
            if (!/^1\d{10}$/.test($("#phone").val())) {
                layer.msg("请输入正确的手机号");
                return false;
            }
            var obj = this;
            $.ajax({
                type: "post",
                url: "json/login.json",
                dataType: "json",//返回的
                success: function (data) {

                    if (data.result) {
                        $("#find").addClass(" layui-btn-disabled");
                        $('#find').attr('disabled', "true");
                        settime(obj);
                        $("#msg").text(data.msg);
                    } else {
                        layer.msg(data.msg);
                    }
                },
                error: function (msg) {
                    console.log(msg);
                }
            });
        });
        var countdown = 60;

        function settime(obj) {
            if (countdown == 0) {
                obj.removeAttribute("disabled");
                obj.classList.remove("layui-btn-disabled");
                obj.value = "获取验证码";
                countdown = 60;
                return;
            } else {

                obj.value = "重新发送(" + countdown + ")";
                countdown--;
            }
            setTimeout(function () {
                    settime(obj)
                }
                , 1000)
        }
    })
</script>

</body>
</html>