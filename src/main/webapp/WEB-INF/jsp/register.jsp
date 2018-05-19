<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>


<script language="javascript">
    $(function () {
        //必须填的，就需要加入红星标记
        $("form :input.required").each(function () {
            var $required = $("<strong class='high'>*</strong>");
            $(this).parent().append($required);
        });
        $('form :input').blur(function () {
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();//删除以前的提醒元素
            //验证用户名
            if ($(this).is('#userName')) {
                if (this.value === "" || this.value.length < 6) {
                    var errorMsg = "请输入至少6位的用户名.";
                    $parent.append('<span class="formtips onError">' + errorMsg + '</span>');
                } else {
                    var okMsg = "输入正确.";
                    $parent.append('<span class="formtips onSuccess">' + okMsg + '</span>');
                }
            }
            if ($(this).is('#useAge')) {
                if (this.value.length < 1 || this.value.length > 3) {
                    var errorMsg = "请输入正确年龄";
                    $parent.append('<span class="formtips onError">' + errorMsg + '</span>');
                } else {
                    var okMsg = "输入正确.";
                    $parent.append('<span class="formtips onSuccess">' + okMsg + '</span>');
                }
            }

            //验证邮箱
            if ($(this).is('#userEmail')) {
                if (this.value === "" || (this.value !== "" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value))) {
                    var errorMsg = "请输入正确的E-mail 地址";
                    $parent.append('<span class="formtips onError">' + errorMsg + '</span>');
                } else {
                    var okMsg = "输入正确";
                    $parent.append('<span class="formtips onSuccess">' + okMsg + '</span>');
                }
            }
        }).keyup(function () {
            //这样再输入的时候只要满足条件就能提示，而不用等到失去焦点后再提示
            $(this).triggerHandler("blur");
        }).focus(function () {
            $(this).triggerHandler("blur");
        });

        //最终验证
        $("#send").click(function () {
            $("form .required:input").trigger("blur");
            var numError = $("form .onError").length;
            //numError>0,有错，false.阻止表单提交》return false
            if (numError) {
                return false;
            }
            alert("注册成功，密码已发送至邮箱，注意查收！");
        });
    })
</script>

<body>
<div style="color:#00FFFF" align="center">
    <H1> 用户注册信息：</H1>
</div>

<div align="center">
    <hr>
    <form action="${pageContext.request.contextPath}/user/add" method="post">
        <table>
            <tr>
                <td>ID号：<input id="userId" name="userId" type="text" required="required" maxlength="16"
                               placeholder="请输入用户id，长度6-16只能由数字组成"></td>
            </tr>
            <tr>
                <td>用户名：<input id="userName" name="userName" type="text" required="required" maxlength="16"
                               placeholder="输入您的用户名"></td>
            </tr>
            <tr>
                <td>密码：<input id="userPassword" name="userPassword" type="text" required="required" maxlength="16"
                              placeholder="输入您的密码"></td>
            </tr>
            <tr>
                <td>年龄：<input id="userAge" name="userAge" type="text" maxlength="3" placeholder="输入您的年龄"></td>
            </tr>

            <tr>
                <td>邮箱：<input id="userEmail" name="userEmail" type="text" minlength="5" placeholder="输入您的邮箱"></td>
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