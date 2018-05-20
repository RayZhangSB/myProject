<%--
  Created by IntelliJ IDEA.
  User: Raymond Zhang
  Date: 2018/5/18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script language="javascript">

    function uploadImg() {
        var pathShow = document.getElementById("imgUrl");
        var formData = new FormData();
        // var formData = new FormData($('#uploadPicForm')[0]);
        formData.append("doc", $("#doc")[0].files[0]);
        $.ajax({
            type: "POST",
            url: "<%=basePath%>" + "/pic/upload",
            data: formData,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            // xhrFields: {
            //     withCredentials: true
            // },
            async: false,
            dataType: "json",
            success: function (suc) {
                if (suc.code === 0) {
                    pathShow.value = suc.message;
                    pathShow.hidden = false;
                    alert("上传成功!")
                    return false;
                } else {
                    pathShow.hidden = true;
                    alert("上传失败,原因未知");
                    return false;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                pathShow.hidden = true;
                alert("上传失败，请检查网络后重试" + XMLHttpRequest + textStatus + errorThrown);
                return false;
            }
        });
        return false;
    }


    function validationNoteForm() {
        if (document.getElementById("contentType").value === "noneType") {
            alert("请先选择内容类型");
            return false;
        }
        if (document.getElementById("title").value === '') {
            alert("大标题不能为空");
            return false;
        }
        var s = document.getElementById("preview").src;
        if (s == null || s === undefined || s === "") {
            alert("请至少上传一张图片");
            return false;
        }

        if (document.getElementById("desc").value === '') {
            alert("描述不能为空");
            return false;
        }

    }

    function add_Note_Submit() {
        validationNoteForm();
    }

    function checkImgFormat() {
        var maxSize = 2 * 1024 * 1024;
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
        if (!checkImgFormat()) {
            return false;
        }
        uploadImg();
        var docObj = document.getElementById("doc");
        var imgObjPreview = document.getElementById("preview");
        if (docObj.files && docObj.files[0]) {

            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '100px';
            imgObjPreview.style.height = '100px';


            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE涓嬶紝浣跨敤婊ら暅
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("preview");
            //蹇呴』璁剧疆鍒濆§嬪ぇ灏
            localImagId.style.width = "200px";
            localImagId.style.height = "200px";
            //鍥剧墖寮傚父鐨勬崟鎹夛紝闃叉­㈢敤鎴蜂慨鏀瑰悗缂€鏉ヤ吉閫犲浘鐗
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
        var selectS = document.querySelectorAll(".select");
        var noteTypes = [];
        noteTypes["0"] = ["请选择笔记类型"];
        noteTypes["随笔"] = ["技术知识", "趣闻"];
        noteTypes["日记"] = ["工作记录", "生活记录", "情感记录"];
        var value = selectS[0].value;
        selectS[1].options.length = 0;
        var option;
        for (i = 0; i < noteTypes[value].length; i++) {
            option = new Option(noteTypes[value][i], noteTypes[value][i]);
            selectS[1].options.add(option);
            selectS[1].options.selected = noteTypes[value][0];
        }
        if (selectS[0].value === "0") {
            selectS[1].disabled = true;
        }
        else {
            selectS[1].disabled = false;
        }
    }

</script>

</head>
<body>

<div id="add_note">

    <table id="typeSelect" style="background-color:#EEEEEE;float:left;">
        <tr>
            <td><select id="noteType" name="noteType" onChange="changeType_Note()" class="select">
                <option value="0">请选择笔记类型</option>
                <option value="随笔">随笔</option>
                <option value="日记">日记</option>
            </select>

                <select id="contentType" name="contentType" class="select">
                    <option value="noneType">请选择内容类型</option>
                </select></td>

        </tr>
        <tr>
            <td><input autofocus="autofocus" type="text" name="title" id="title" placeholder="大标题:">
                <input autofocus="autofocus" type="text" name="subTitle" id="subTitle" placeholder="小标题:"></td>
        </tr>


        <tr>
            <td>

                <%--<form action="pic/upload" method="post" enctype="multipart/form-data">--%>
                <%--<input type="file" name="doc" id="doc" onchange="setImagePreview()">--%>
                <%--<img id="preview" width=-1 height=-1>--%>
                <%--<input type="submit" value="同步上传"/>--%>
                <%--<input type="text"  id="imgUrl" hidden="hidden"/>--%>
                <%--</form>--%>

                <form id="formToUpdate" method="post" action="#" enctype="multipart/form-data">
                    <input type="file" name="doc" id="doc" onchange="setImagePreview()"><br/>
                        <img id="preview" width=-1 height=-1>
                    <input type="text" id="imgUrl" hidden="hidden" width="250px"/>

                </form>
                <input id="ajaxSubmit" type="button" value="异步上传">

            </td>
        </tr>
        <tr>
            <td><textarea autofocus="autofocus" style="width:400px;height:200px;" name="desc"
                          id="desc" placeholder="内容描述：不超过150字"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" name="addSubmit" id="addSubmit" onclick="add_Note_Submit()" value="添加"/></td>

            <td><input type="reset" name="reset" value="重置"/></td>
        </tr>
    </table>


</div>


</body>
</html>