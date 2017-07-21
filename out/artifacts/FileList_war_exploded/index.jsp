<%--
Created by IntelliJ IDEA.
User: zzy
Date: 2017/7/19
Time: 下午5:03
To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="index.js"></script>
    <title>登录</title>
    <style>
        span {
            display: inline-block;
            width: 4em;
            text-align: right;
        }

    </style>
</head>
<body style="background-color: #FFA500">
<form action="/login" method="get">
    <div style="text-align: center">
        <h1 style="color: #EEEEEE">登录</h1>
        <div class="div">
            <span style="color: #EEEEEE;">
                用户名:</span>
            <input class="text" type="text" name="username" required/>

            <br>
            <span style="color: #EEEEEE;">


                密码:</span>
            <input class="text" type="password" name="password" required/>
            <br>
        </div>
        <br>
        <input type="submit" value="登录" style="color: #FFA500;background-color: cadetblue;width: 100px"/>
        <br/>

    </div>
</form>
</body>
</html>
