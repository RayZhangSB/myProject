<%--
  Created by IntelliJ IDEA.
  User: Raymond Zhang
  Date: 2018/5/18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script language="javascript">

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

</script>
<body>

<div id="add_note">
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
                上传图片：
                <form action="UploadServlet.do" method="post" enctype="multipart/form-data">
                    <input type="file" name="doc" id="doc" onchange="setImagePreview()">
                    <img id="preview" width=-1 height=-1>
                    <input type="submit" value="上传图片"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>内容描述：<textarea autofocus="autofocus" style="width:600px;height:300px;" name="desc"></textarea>
            </td>
        </tr>
    </table>


</div>


</div>

</body>
</html>
