<%--
  Created by IntelliJ IDEA.
  User: Raymond Zhang
  Date: 2018/5/18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/my.js"></script>
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
            dataType: "json",
            success: function (suc) {
                if (suc.code === 0) {
                    pathShow.value = suc.msg;
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
                alert("网络错误，请检查网络后重试" + XMLHttpRequest + textStatus + errorThrown);
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
        var s = document.getElementById("imgUrl").value;
        if (s == null || s === undefined || s === "") {
            alert("请至少上传一张图片");
            return false;
        }

        if (document.getElementById("desc").value === '') {
            alert("描述不能为空");
            return false;
        }
        return true;
    }

    function add_Note_Submit() {
        if (!validationNoteForm()) {
            return;
        }
        var uid = get_cookie("userId");
        console.log(uid);
        if (uid === null || uid === undefined || uid === "") {
            alert("请先登录!");
            return;
        }


        var formData = new FormData();
        formData.append("uid", uid);
        formData.append("cid", ($("#contentType").find("option:selected").val()));
        formData.append("title", dom("title").value);
        formData.append("subTitle", dom("subTitle").value);
        formData.append("imgUrl", dom("imgUrl").value);
        formData.append("desc", dom("desc").value);
        $.ajax({
            type: "POST",
            url: "<%=basePath%>" + "/content/add",
            data: formData,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺;
            dataType: "json",
            success: function (suc) {
                if (suc.code === 0) {
                    alert(suc.msg);
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
    function setImagePreview() {
        if (!checkImgFormat("doc")) {
            return false;
        }
        uploadImg();
        var docObj = document.getElementById("doc");
        var imgObjPreview = document.getElementById("preview");
        if (docObj.files && docObj.files[0]) {
            imgObjPreview.style.width = '100px';
            imgObjPreview.style.height = '100px';
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE涓嬶紝浣跨敤婊ら暅
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("preview");
            localImagId.style.width = "200px";
            localImagId.style.height = "200px";

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
        noteTypes["-1"] = ["请选择笔记类型"];
        noteTypes["0"] = ["技术知识", "趣闻"];
        noteTypes["1"] = ["工作记录", "生活记录", "情感记录"];
        var value = selectS[0].value;
        selectS[1].options.length = 0;
        var option;
        for (i = 0; i < noteTypes[value].length; i++) {
            var index;
            if (value === "0") {
                index = i + 2;
            } else {
                index = i + 4;
            }
            option = new Option(noteTypes[value][i], (index).toString());
            selectS[1].options.add(option);
            selectS[1].options.selected = noteTypes[value][0];
        }
        if (selectS[0].value === "-1") {
            selectS[1].disabled = true;
        }
        else {
            selectS[1].disabled = false;
        }
    }

</script>


<div id="add_note" style="padding:10px 10px 10px 10px">

    <table>
        <tr>
            <td><select id="noteType" name="noteType" onChange="changeType_Note()" class="select">
                <option value="-1">请选择笔记类型</option>
                <option value="0">随笔</option>
                <option value="1">日记</option>
            </select>

                <select id="contentType" name="contentType" class="select">
                    <option value="noneType">请选择内容类型</option>
                </select></td>

        </tr>
        <tr>
            <td><input autofocus="autofocus" type="text" name="title" id="title" placeholder="大标题:" maxlength="20">
                <input autofocus="autofocus" type="text" name="subTitle" id="subTitle" placeholder="小标题:"
                       maxlength="15"></td>
        </tr>
        <tr>
            <td>
                <input type="file" name="doc" id="doc" onchange="setImagePreview();">

            </td>
        </tr>
        <tr>
            <td>
                <img id="preview" width=-1 height=-1>
                <input type="text" id="imgUrl" name="imgUrl" hidden="hidden" width="300px"/>
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

