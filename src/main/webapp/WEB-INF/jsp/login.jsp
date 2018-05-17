<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<title>登录页</title>
<body>
<div style="color:#00FF00" align="center">
    <H1>欢迎进入易记空间</H1>
</div>

<div align="center">
    <form action="userAccess/login" method="post">
        <table width="100%"  >
            <tr>
                <td width="50%" height="30" align="right">用户名：</td>
                <td width="50%" height="30" align="left">
                    <input type="text" name="UserName" >
                </td>
            </tr>
            <tr>
                <td width="50%" height="30" align="right">密&nbsp;码：</td>
                <td width="70%" height="30" align="left">
                    <input type="password" name="UserPassword" inputmode="">
                </td>
            </tr>
            <tr >
                <td width="100%" height="40" align="center" colspan="2" >
                    <input type="submit" name="login" value="登录">
                    <input type="reset" value="重填">
                </td>

            </tr>


        </table>
</form>
<form action="userAccess/register" method="post">

    <input type="submit" name="register" value="注册">
</form>
</div>




</body>
</html>
