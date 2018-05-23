<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<table class="easyui-datagrid" id="itemList" title="笔记列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/content/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'noteId',width:100">笔记ID</th>
        <th data-options="field:'uid',width:100">用户ID</th>
        <th data-options="field:'cid',width:100">笔记类型</th>
        <th data-options="field:'title',width:100">笔记大标题</th>
        <th data-options="field:'subTitle',width:100">笔记小标题</th>
        <th data-options="field:'imgUrl',width:100">图片url</th>
        <th data-options="field:'desc',width:100">内容描述</th>
    </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑笔记"
     data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'"
     style="width:80%;height:80%;padding:10px;">
</div>
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
<script>

    function getSelectionsIds() {
        var itemList = $("#itemList");
        var sels = itemList.datagrid("getSelections");
        var ids = [];
        for (var i in sels) {
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text: '添加',
        iconCls: 'icon-add',
        handler: function () {
            $(".tree-title:contains('增加笔记')").parent().click();
        }
    }, {
        text: '编辑',
        iconCls: 'icon-edit',
        handler: function () {
            var ids = getSelectionsIds();
            if (ids.length === 0) {
                $.messager.alert('提示', '必须选择一个笔记才能编辑!');
                return;
            }
            if (ids.indexOf(',') > 0) {
                $.messager.alert('提示', '只能选择一个笔记!');
                return;
            }

            $("#itemEditWindow").window({
                onLoad: function () {
                    //回显数据
                    var data = $("#itemList").datagrid("getSelections")[0];
                    data.priceView = TAOTAO.formatPrice(data.price);
                    $("#itemeEditForm").form("load", data);

                    // 加载笔记描述
                    $.getJSON('/rest/item/query/item/desc/' + data.id, function (_data) {
                        if (_data.status === 200) {
                            //UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
                            itemEditEditor.html(_data.data.itemDesc);
                        }
                    });

                    //加载笔记规格
                    $.getJSON('/rest/item/param/item/query/' + data.id, function (_data) {
                        if (_data && _data.status === 200 && _data.data && _data.data.paramData) {
                            $("#itemeEditForm .params").show();
                            $("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
                            $("#itemeEditForm [name=itemParamId]").val(_data.data.id);

                            //回显笔记规格
                            var paramData = JSON.parse(_data.data.paramData);

                            var html = "<ul>";
                            for (var i in paramData) {
                                var pd = paramData[i];
                                html += "<li><table>";
                                html += "<tr><td colspan=\"2\" class=\"group\">" + pd.group + "</td></tr>";

                                for (var j in pd.params) {
                                    var ps = pd.params[j];
                                    html += "<tr><td class=\"param\"><span>" + ps.k + "</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='" + ps.v + "'/></td></tr>";
                                }

                                html += "</li></table>";
                            }
                            html += "</ul>";
                            $("#itemeEditForm .params td").eq(1).html(html);
                        }
                    });

                    TAOTAO.init({
                        "pics": data.image,
                        "cid": data.cid,
                        fun: function (node) {
                            TAOTAO.changeItemParam(node, "itemeEditForm");
                        }
                    });
                }
            }).window("open");
        }
    }, {
        text: '删除',
        iconCls: 'icon-cancel',
        handler: function () {
            var ids = getSelectionsIds();
            if (ids.length === 0) {
                $.messager.alert('提示', '未选中笔记!');
                return;
            }
            $.messager.confirm('确认', '确定删除ID为 ' + ids + ' 的笔记吗？', function (r) {
                if (r) {
                    var params = {"ids": ids};
                    $.post("/content/delete", params, function (data) {
                        if (data.status === 200) {
                            $.messager.alert('提示', '删除笔记成功!', undefined, function () {
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>