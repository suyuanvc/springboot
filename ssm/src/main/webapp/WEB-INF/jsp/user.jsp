<%--
  Created by IntelliJ IDEA.
  User: 28483
  Date: 2019/7/1
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div style="margin:0px auto; width:500px">

    <form action="/user/update" method="post">

        nickname: <input name="nickname" value="${user.nickname}"> <br>
        username: <input name="username" value="${user.username}"> <br>
        password: <input name="password" value="${user.password}"> <br>
        <input name="id" type="hidden" value="${user.id}">
        <button type="submit">提交</button>

    </form>
</div>