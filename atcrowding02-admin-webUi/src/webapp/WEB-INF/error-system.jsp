<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/10/1
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报错界面</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="views/css/login.css">
    <script type="text/javascript" src="js/jquery/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="views/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function (){
                // 相当于浏览器的后退按钮
                window.history.back();
            });
        });
    </script>
    <style>

    </style>
</head>


<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<h2 class="form-signin-heading" style="text-align: center;"><i class="glyphicon glyphicon-log-in"></i>尚筹网系统消息</h2>
<!--
    requestScope对应的是存放request域数据的Map
    requestScope.exception相当于request.getAttribute("exception")
    requestScope.exception.message相当于exception.getMessage()
-->
<h3 style="text-align: center;"> ${ requestScope.exception.message } </h3>
<button style="width: 150px;margin: 50px auto 0px auto;" type="submit" class="btn btn-lg btn-success btn-block">返回上一步</button>

</body>
</html>
