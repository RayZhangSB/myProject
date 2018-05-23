<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<title>登录页</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/my.js"></script>
<script language="javascript">
    function initId() {
        console.log(document.cookie);
        console.log(document.referrer);
        var resId = get_cookie("userId");
        if (resId !== null && resId !== undefined && resId !== "") {
            $("#userId").val(resId);
        }
    }

    function userValidation() {
        var uNameOrId = $("#userId").val();
        var uPwd = $("#userPassword").val();
        //验证用户名
        if (!(/^\d{6,10}$/.test(uNameOrId))) {
            var errorMsg = "无效id";
            alert(errorMsg);
            return false;
        }
        //验证密码
        if (!/^[a-zA-z]\w{6,15}$/.test(uPwd)) {
            errorMsg = "无效密码";
            alert(errorMsg);
            return false;
        }
        var formData = new FormData();
        formData.append("userId", uNameOrId);
        formData.append("userPassword", uPwd);
        $.ajax({
            type: "POST",
            url: "<%=basePath%>" + "/user/login",
            data: formData,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺;
            dataType: "json",
            success: function (suc) {
                if (suc.code === 0) {
                    document.cookie = "userId=" + uNameOrId;
                    alert(suc.msg);
                    window.location.assign("<%=basePath%>" + "/toIndex");//转到主页!!
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
<body onload="initId()">
<div align="center">
    <H1>易笔记登录</H1>
</div>

<div align="center">

    <table width="100%">
        <tr>
            <td width="50%" height="30" align="right">用户名：</td>
            <td width="50%" height="30" align="left" a>
                <input type="text" name="userId" id="userId" style="width:200px" PLACEHOLDER="请输入用户id">
            </td>
        </tr>
        <tr>
            <td width="50%" height="30" align="right">密&nbsp;码：</td>
            <td width="70%" height="30" align="left">
                <input type="password" id="userPassword" name="userPassword" style="width:200px" PLACEHOLDER="请输入密码"
                       inputmode="">
            </td>
        </tr>
        <tr>
            <td width="100%" height="40" align="center" colspan="2">
                <input type="button" name="login" value="登录" onclick="userValidation()">

            </td>
        </tr>
    </table>
</div>


</body>
</html>
