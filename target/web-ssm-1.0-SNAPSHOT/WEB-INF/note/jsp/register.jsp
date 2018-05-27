<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<head>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/my.js"></script>

    <script language="javascript">
        function checkRegisterInfo() {
            var uid = $("input[name=userId]").val();
            var uName = $("input[name=userName]").val();
            var uPwd = $("input[name=userPassword]").val();
            var uAge = $("input[name=userAge]").val();
            var uEmail = $("input[name=userEmail]").val();
            var errorMsg;
            if (!(/^\d{6,10}$/.test(uid))) {
                errorMsg = "id格式不正确";
                alert(errorMsg);
                return false;
            }
            //验证用户名
            if (!/^[a-zA-z]\w{6,15}$/.test(uName)) {
                errorMsg = "无效用户名";
                alert(errorMsg);
                return false;
            }
            //验证密码
            if (!/^[a-zA-z]\w{6,15}$/.test(uPwd)) {
                errorMsg = "密码格式不正确";
                alert(errorMsg);
                return false;
            }
            //验证年龄
            if (!/^\d{2}$/.test(uAge)) {
                errorMsg = "无效的年龄输入";
                alert(errorMsg);
                return false;
            }
            //验证邮箱
            if (uEmail === "" || (uEmail !== "" && !(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(uEmail)))) {
                errorMsg = "请输入正确的E-mail 地址";
                alert(errorMsg);
                return false;
            }
            return true;

        }

        function clearR() {
            $('#registerUser').resetForm();
        }

        function addUser() {
            if (!checkRegisterInfo()) {
                return false;
            }
            var array = getJsonFormData("#userR");
            array["userCreatetime"] = getDateNow(new Date());
            //注册用户
            $.ajax({
                type: "POST",
                url: "<%=basePath%>" + "/user/add",
                data: JSON.stringify(array),
                cache: false,
                contentType: "application/json",    //不可缺
                processData: false,    //不可缺
                dataType: "json",
                success: function (suc) {
                    if (suc.code === 0) {
                        alert(suc.msg);
                        //回到登录页面
                        document.cookie = "userId=" + $("#userId").val();
                        window.location.assign(document.referrer);
                        return false;
                    } else {
                        alert(suc.msg);
                        return false;
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("网络错误，请检查网络后重试" + XMLHttpRequest + textStatus + errorThrown);
                    return false;
                }
            });
            return false;
        }

    </script>
</head>
<body>

<div style="color:#00FFFF" align="center">
    <H1> 用户注册信息：</H1>
</div>

<div align="center">
    <hr>
    <form id="userR" name="userR" enctype="multipart/form-data">
        <table>
            <tr>
                <td>ID号&nbsp;：<input id="userId" name="userId" type="text" required="required" maxlength="16"
                                     style="width:250px" placeholder="请输入用户id，6-10位纯数字"></td>
            </tr>
            <tr>
                <td>用户名：<input id="userName" name="userName" type="text" required="required" maxlength="16"
                               style="width:250px" placeholder="输入您的用户名，6-15位数字或字母"></td>
            </tr>
            <tr>
                <td>密码&nbsp;：<input id="userPassword" name="userPassword" type="password" required="required"
                                    style="width:250px" placeholder="输入您的密码，6-15位数字或字母"></td>
            </tr>
            <tr>
                <td>年龄&nbsp;：<input id="userAge" name="userAge" type="text" required="required" maxlength="3"
                                    style="width:250px" placeholder="输入您的年龄"></td>
            </tr>

            <tr>
                <td>邮箱&nbsp;：<input id="userEmail" name="userEmail" type="text" required="required" minlength="5"
                                    style="width:250px" placeholder="输入您的邮箱"></td>
            </tr>
            <tr>
            </tr>
        </table>
    </form>
    <input type="button" value="注册" onclick="addUser()">
    <input type="button" value="清空" onclick="clearR()">
    <hr>
</div>
</body>


</html>