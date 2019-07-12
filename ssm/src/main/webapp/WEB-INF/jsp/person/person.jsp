<%--
  Created by IntelliJ IDEA.
  User: 28483
  Date: 2019/7/1
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<div style="margin:0px auto; width:500px">
    <form action="" method="post">
        name: <input name="name" value="${person.name}"> <br>
        age: <input name="age" value="${person.age}"> <br>
        birthday: <input type="date" name="_birthday" value="<fmt:formatDate value='${person.birthday}' type='date' pattern='yyyy-MM-dd'/>"> <br>
        <input id="id" name="id" type="hidden" value="${person.id}" />
        <button type="submit" onclick="personSubmit()">提交</button>
    </form>
</div>
<script>
    function personSubmit() {
        var id = $("#id").val();
        if(id == ""){
            alert("add");
            document.form.action="/person/add";
        }else{
            alert("update");
            document.form.action="/person/update";
        }
        return true;
       /* $.ajax({
            type: 'POST',
            url: id==""?"/person/add":"/person/update",
            data: $("#personForm").serialize(),
            success: function (data) {
                alert("succsss");
                window.location.href="/person/findAll";
            },
            dataType: JSON});*/
    }
</script>