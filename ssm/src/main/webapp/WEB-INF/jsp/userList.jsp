<%--
  Created by IntelliJ IDEA.
  User: 28483
  Date: 2019/7/1
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>nickname</td>
            <td>username</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.nickname}</td>
                <td>${c.username}</td>
                <td><a href="/user/get/${c.id}">编辑</a></td>
                <td><a href="/user/delete/${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=1">[首  页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末  页]</a>
    </div>
    <br>
    <form action="/user/add" method="post">
        nickname: <input type="text" name="nickname" > <br>
        username: <input type="text" name="username" > <br>
        password: <input type="text" name="password" > <br>
        <button type="submit">提交</button>

    </form>
</div>