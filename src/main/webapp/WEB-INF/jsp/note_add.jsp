<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link href="../../js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<!--富文本编辑器的引入-->
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script charset="utf-8" type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    var itemAddEditor;
    //页面初始化完毕后执行此方法
    $(function () {
        //创建富文本编辑器
        itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]", TT.kingEditorParams);
        //初始化类目选择和图片上传器
        TAOTAO.init({
            fun: function (node) {

            }
        });
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


    function setImg(obj) {//用于进行图片上传，返回地址
        var f = $(obj).val();
        if (f == null || f === undefined || f === '') {
            return false;
        }
        if (!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)) {
            alert("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        }
        var data = new FormData();
        $.each($(obj)[0].files, function (i, file) {
            data.append('file', file);
        });
        $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+"/pic/upload",
            data: data,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success: function (suc) {
                if (suc.code === 0) {
                    $("#thumbUrl").val(suc.message);//将地址存储好
                    $("#thumbUrlShow").attr("src", suc.message);//显示图片
                } else {
                    alert("上传失败");
                    $("#url").val("");
                    $(obj).val('');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("上传失败，请检查网络后重试" + XMLHttpRequest + textStatus + errorThrown);
                $("#url").val("");
                $(obj).val('');
            }
        });
    }
</script>

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
                <td>大标题：<label>
                    <input type="text" name="Title">
                </label></td>
            </tr>
            <tr>
                <td>小标题：<label>
                    <input type="text" name="subTitle">
                </label></td>
            </tr>
            <tr>
                <td>图片上传：
                    <input type="file" name="doc" id="selectFile" onchange="setImg(this);"/>
                    <input type="hidden" name="img" id="thumbUrl"/>
                    <img id="thumbUrlShow" src="" width="100" height="100"/>
                </td>


            </tr>
            <tr>
                <td>笔记内容:
                    <textarea style="width:800px;height:300px;" name="desc"></textarea>
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

