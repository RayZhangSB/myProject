<%--
  Created by IntelliJ IDEA.
  User: Raymond Zhang
  Date: 2018/5/18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
<script src="../../js/jquery.form.js"></script>
<script language="javascript">

    function uploadImg() {
        var pathShow = $("#imgUrl");
        var formData = new FormData();

        formData.append("image", $("#doc")[0].files[0]);
        $.ajax({
            type: "POST",
            url: "/pic/upload",
            data: formData,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success: function (suc) {
                if (suc.code === 0) {
                    pathShow.val(suc.message);//将地址存储好
                    pathShow.style.hidden = false;
                } else {
                    alert("上传失败,原因未知");
                    pathShow.style.hidden = true;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("上传失败，请检查网络后重试" + XMLHttpRequest + textStatus + errorThrown);
                pathShow.style.hidden = true;
            }
        });
    }

    function showResponse() {
        //处理上传的返回结果
        //picUrl==
        alert("上传成功");
    }

    function check() {
        var maxSize = 2 * 1024 * 1024;  //2M
        var img = document.getElementById("doc");

        if (img.value === "" || img.value === undefined || img.value == null) {
            alert("请选择文件!");
            return false;
        } else if (!/\.(gif|jpg|jpeg|png|GIF|JPG|JPEF|PNG)$/.test(img.value)) {
            alert("图片类型必须为gif|jpg|jpeg|png中的一种!");
            return false;
        } else if (img.files[0].size > maxSize) {
            alert("上传图片不能超过2M !");
            return false;
        }
        return true;
    }

    function setImagePreview() {
        if (!check())
            return;
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
            var path = document.getElementById("path");
            path.value = imgObjPreview.src;
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

    function changeType_Note() {
        var slecctS = document.querySelectorAll(".select");
        var countrys = new Array();
        countrys["0"] = ["请选择笔记类型"];
        countrys["随笔"] = ["技术知识", "趣闻"];
        countrys["日记"] = ["工作记录", "生活记录", "情感记录"];
        var value = slecctS[0].value;
        slecctS[1].options.length = 0;
        var option;
        for (i = 0; i < countrys[value].length; i++) {
            option = new Option(countrys[value][i], countrys[value][i]);
            slecctS[1].options.add(option);
            slecctS[1].options.selected = countrys[value][0];
        }
        if (slecctS[0].value == "0") {
            slecctS[1].disabled = true;
        }
        else {
            slecctS[1].disabled = false;
        }
    }

    function add_Note_Submit() {

    }
</script>
<body>

<div id="add_note">
    <form id="addNote" name="addNote" method="post">
        <table id="typeSelect" style="background-color:#EEEEEE;float:left;">
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
                    <%--<form id="uploadPicForm" name="uploadPic" action="${pageContext.request.contextPath}/pic/upload" method="post" enctype="multipart/form-data" target="frameFile"--%>
                    <%-->--%>
                    <%--&lt;%&ndash;multiple="multiple" 可以多选&ndash;%&gt;--%>
                    <%--<input type="file" name="doc" id="doc" accept="image/*" onchange="setImagePreview();" >--%>
                    <%--<input id="submit_form" name="submit_form" type="submit" value="上传图片"/>--%>
                    <%--</form>--%>
                    <%--<img id="preview" width=-1 height=-1>--%>
                    <%--<input type="text" name="path" id="path">--%>
                    <%--<iframe id="frameFile" name="frameFile" style="display:none;"></iframe>--%>


                    <form id="uploadPicForm" name="uploadPic" method="post" enctype="multipart/form-data">
                        <%--multiple="multiple" 可以多选--%>
                        <input type="file" name="doc" id="doc" accept="image/*" onchange="setImagePreview();">
                        <input id="submit_form" name="submit_form" type="button" value="上传图片" onclick="uploadImg();"/>
                    </form>
                    <img id="preview" width=-1 height=-1>
                    <input type="text" name="imgUrl" id="imgUrl" hidden="hidden"/>
                </td>
            </tr>
            <tr>
                <td>内容描述：<textarea autofocus="autofocus" style="width:600px;height:300px;" name="desc"></textarea>
                </td>
            </tr>
            <tr>
                <input type="button" name="addSubmit" id="addSubmit" onclick="add_Note_Submit();"/>
                <input type="reset" name="reset" value="重置"/>
            </tr>
        </table>

    </form>
</div>


</div>

</body>
</html>
