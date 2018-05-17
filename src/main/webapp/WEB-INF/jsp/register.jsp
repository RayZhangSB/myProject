<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>用户注册</title>
</head>

<body>
<div style="color:#00FFFF" align="center">
    <H1> 用户注册信息：</H1>
</div>

<div align="center">
    <hr>
    <form action="register.jsp" method="get">
    <table>
        <tr>
            <td>ID号：<input name="userId" type="text" required="required" maxlength="16"
                           placeholder="请输入用户id，长度6-16只能由数字组成"></td>
        </tr>
        <tr>
            <td>姓名：<input name="userName" type="text" required="required" maxlength="16" placeholder="输入您的姓名"></td>
        </tr>
        <tr>
            <td>密码：<input name="userPassword" type="text" required="required" maxlength="16" placeholder="输入您的密码"></td>
        </tr>
        <tr>
            <td>年龄：<input name="userAge" type="text" maxlength="3" placeholder="输入您的年龄，选填"></td>
        </tr>

        <tr>
            <td>邮箱：<input name="userEmail" type="text" minlength="5" placeholder="输入您的邮箱，选填"></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="提交">
                <input type="reset" value="重置"></td>

        </tr>
    </table>
</form>
<hr>
</div>
</body>


</html>