<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎来到易笔记主页</title>
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/taotao.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>

    <style type="text/css">
        .content {
            padding: 10px 10px 10px 10px;
        }
    </style>
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>笔记管理</span>
            <ul>
                <li>
                    <a onclick="addTab('新增笔记','addNote')">新增笔记</a>
                    <%--<input type="button" value="新增笔记"  onclick="addTab(this.value,'addNote')">--%>
                </li>
                <hr>
                <li>
                    <a onclick="addTab('查看笔记','content-list')">查看笔记</a>

                </li>

            </ul>
        </li>

        <li>
            <span>网站用户管理</span>
            <ul>
                <li>
                    <a onclick="addTab('用户登录','login')">用户登录</a>
                </li>

                <hr>
                <li>
                    <a onclick="addTab('用户注册','register')">用户注册</a>
                </li>
            </ul>
        </li>
    </ul>

</div>

<div data-options="region:'center',title:''">
    <div id="tabs" class="easyui-tabs">
    </div>
</div>

<script type="text/javascript">
    function addTab(title, url) {
        var tabS = $('#tabs');
        var tab = tabS.tabs('exists', title);    //判断tab是否已经存在
        if (tab) {                                  //防止tab重复添加
            tabS.tabs('select', title);        //如果已经存在tab，则刷新该界面
        } else {                                    //如果不存在该界面则加载
            tabS.tabs('add', {
                title: title,
                content: "<iframe scrolling='no'  style='width:1100px;height:700px;float:left '   src='" + url + "'></iframe>",
                closable: true,       //true表示在tab上显示一个关闭按钮

            });
        }
    }
</script>
</body>
</html>