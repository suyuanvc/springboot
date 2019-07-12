<%--
  Created by IntelliJ IDEA.
  User: 28483
  Date: 2019/6/26
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
亲爱的${user.nickname}.<br>
<a href="/user/findAll">点击进入user</a><br>
<a href="/person/findAll">点击进入person</a><br>
<a href="/upload/uploadPage">上传图片</a><br>
<input type="button" value="通过AJAX获取一个Hero对象---" id="sender"><br>
<input type="button" value="通过AJAX获取多个分类对象" id="sender2"><br>

<div id="messageDiv"></div>

<script>
    $('#sender').click(function(){
        var url="../user2/user/1";
        $.get(
            url,
            function(data) {
                console.log(data);
                var json=data;
                var name =json.nickname;
                var id = json.id;
                $("#messageDiv").html("id："+ id + "<br>nickname:" +name );

            });
    });
    var j = 1;
    $('#sender2').click(function(){
        var url="../user2/findAll?start="+j+"&size=5";
        j++;
        $.get(
            url,
            function(data) {
                console.log(data);
                var users = data;
                for(var i = 0;i<users.length;i++){
                    var old = $("#messageDiv").html();
                    var user = users[i];
                    $("#messageDiv").html(old + "<br>"+user.id+"   -----   "+user.nickname);
                }
            });
    });
</script>
</body>
</html>