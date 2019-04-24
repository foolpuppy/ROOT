<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2019/4/24
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
</head>
<script>
    $(document).ready(function () {
        $('#showInfo').click(function () {
            $.ajax({
                url: 'get',
                data: {},
                success: function (responseText) {
                    $('#result').text(responseText);
                }
            });
        });
    });
</script>
<body>
<button id="showInfo">显示信息</button>
<div id="result">

</div>
</body>
</html>
