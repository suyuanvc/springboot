<%--
  Created by IntelliJ IDEA.
  User: 28483
  Date: 2019/7/2
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action = "/upload/upload" method="post" enctype="multipart/form-data">
        选择图片：<input type="file" name="file" accept="image/*"/><br>
        <input type="submit" value="上传"/>
    </form>

<img src="/upload/${fileName}">
</body>
</html>
