<%@ page language="java" contentType="text/html" import="java.util.*" pageEncoding="utf-8"%>
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

<br style="border-color: #0092DC"><hr>
<form action="register.jsp" method="get">
    <table>
        <tr>
            <td>姓名：<input name="userName" type="text" required="required" maxlength="16"></td>
        </tr>
        <tr>
            <td>密码：<input name="userPassword" type="text" required="required" maxlength="16"></td>
        </tr>
        <tr>
            <td>年龄：<input name="userAge" type="text" required="required" maxlength="3"></td>
        </tr>

        <tr>
            <td>邮箱：<input name="userEmail" type="text" minlength="5"></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<hr>
</body>

</html>