<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="../../js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<!--富文本编辑器的引入-->
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="itemAddForm" class="itemForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>
                    <select name="noteType" onChange="changeType_Note()" class="select">
                        <option value="0">请选择笔记类型</option>
                        <option value="随笔">随笔</option>
                        <option value="日记">日记</option>
                    </select>
                    <select name="contentType" class="select">
                        <option>请选择内容类型</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>大标题：<input type="text" name="Title"></td>
            </tr>
            <tr>
                <td>小标题：<input type="text" name="subTitle"></td>
            </tr>
            <tr>
                <td>
                    <form action="UploadServlet.do" method="post" enctype="multipart/form-data">
                        <input type="file" name="doc" id="doc" onchange="setImagePreview()">
                        <img id="preview" width=-1 height=-1>
                        <input type="submit" value="上传图片"/>
                    </form>
                </td>
            </tr>
            <tr>
                <td>笔记内容:</td>
                <td>
                    <!--该标签直接代表一块编辑区域，可以使用name初始化该区域-->
                    <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
                </td>
            </tr>

        </table>
        <input type="hidden" name="itemParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var itemAddEditor;
    //页面初始化完毕后执行此方法
    $(function () {
        //创建富文本编辑器
        itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]", TT.kingEditorParams);
        //初始化类目选择和图片上传器

    });

    //提交表单
    function submitForm() {
        //有效性验证
        if (!$('#itemAddForm').form('validate')) {
            $.messager.alert('提示', '表单还未填写完成!');
            return;
        }

        //同步文本框中的商品描述  使用编辑器提供的接口
        itemAddEditor.sync();

        $.post("/item/save", $("#itemAddForm").serialize(), function (data) {
            if (data.status == 200) {
                $.messager.alert('提示', '添加笔记成功!');
            }
        });
    }

    function clearForm() {
        $('#itemAddForm').form('reset');
        itemAddEditor.html('');
    }


    function setImagePreview() {
        var docObj = document.getElementById("doc");
        var imgObjPreview = document.getElementById("preview");
        if (docObj.files && docObj.files[0]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '100px';
            imgObjPreview.style.height = '100px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("localImag");
            //必须设置初始大小
            localImagId.style.width = "200px";
            localImagId.style.height = "200px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters
                    .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }

</script>
