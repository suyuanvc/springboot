<%--
  Created by IntelliJ IDEA.
  User: 28483
  Date: 2019/7/1
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin:0px auto; width:500px">
    <form id="login" action="/login/login" method="post">
        <input type="text" name="username" required/><br/>
        <input type="password" name = "password" required/><br/>
        <button type="submit">登陆</button>
    </form>
</div>
</body>
</html>
