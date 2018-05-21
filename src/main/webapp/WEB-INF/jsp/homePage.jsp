<%--
  Created by IntelliJ IDEA.
  User: Raymond Zhang
  Date: 2018/5/18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<head>
    <title>主页</title>
    <base href="<%=basePath%>">
</head>
<body>
<script language="javascript">
    function dom(id) {
        return document.getElementById(id);
    }
    function showWritePage() {
        var ele = document.getElementById("writeNote");
        ele.hidden = false;
        var ele = document.getElementById("lookNotes");
        ele.hidden = true;
    }

    function showNoteList() {
        var ele = document.getElementById("writeNote");
        ele.hidden = true;
        var ele = document.getElementById("lookNotes");
        ele.hidden = false;
    }

</script>

<div id="container" style="width:1100px;height:800px">

    <div id="header" style="background-color:#FFD7FA;">
        <h1 style="margin-bottom:0;">Main Title of Web Page</h1></div>

    <div id="menu" style="background-color:#FFD7CF;height:700px;width:100px;float:left;">
        <input type="button" value="写笔记" onclick="showWritePage()">
        <input type="button" value="查笔记" onclick="showNoteList()">

    </div>

    <div id="content">
        <iframe id="writeNote" name="writeNote" src="addNote" scrolling="no"
                style="background-color:#EEEEEE;height:700px;width:900px;float:left;" hidden="hidden"></iframe>
        <iframe id="lookNotes" name="lookNotes" src="showNotes" scrolling="no"
                style="background-color:#EEEEEE;height:700px;width:900px;float:left;" hidden="hidden"></iframe>
    </div>

    <div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
        Copyright © zhangbin.cn
    </div>

</div>

</body>
</html>
