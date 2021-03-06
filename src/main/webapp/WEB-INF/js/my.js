function getDateNow(date) {
    return date.getFullYear().toString() + "-" + (date.getMonth() + 1).toString() + "-" + date.getDate().toString();
}

function getJsonFormData(form) {
    //将form表单变成map数组
    var form_array = $(form).serializeArray();
    var mapped_array = {};

    $.map(form_array, function (n, i) {
        mapped_array[n['name']] = n['value'];
    });
    return mapped_array;
}

function dom(id) {
    return document.getElementById(id);
}

function checkImgFormat(imgId) {
    var maxSize = 2 * 1024 * 1024;
    var img = document.getElementById(imgId);
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

function get_cookie(Name) {
    var search = Name + "=";//查询检索的值
    var returnValue = "";//返回值
    var sd;
    var end;
    if (document.cookie.length > 0) {
        sd = document.cookie.indexOf(search);
        if (sd !== -1) {
            sd += search.length;
            end = document.cookie.indexOf(";", sd);
            if (end === -1)
                end = document.cookie.length;
            returnValue = document.cookie.substring(sd, end);
        }
    }
    return returnValue;
}//使用方式：get_cookie("name");

function setCookie(name, value, date, duration) {
    var Days = 30;

    date.setTime(date.getTime() + duration);//过期时间
    document.cookie = name + "=" + value + ";expires=" + date.toGMTString();
}

function getFormatDate(id) {
    var date = new Date();
    var year = date.getFullYear();//当前年份
    var month = date.getMonth();//当前月份
    var day = date.getDate();//天
    var hours = date.getHours();//小时
    var minute = date.getMinutes();//分
    var second = date.getSeconds();//秒
    var time = year + "年" + fnW((month + 1).toString()) + "月" + fnW(day.toString()) + "日" + " " + fnW(hours.toString()) + ":" + fnW(minute.toString()) + ":" + fnW(second);
    document.getElementById(id).innerText = time;
}

//补位 当某个字段不是两位数时补0
function fnW(str) {
    var num;
    str > 10 ? num = str : num = "0" + str;
    return num;
}

function checkObjValid(obj) {
    return (obj !== null && obj !== undefined && obj !== "");
}



function showOPInfo(szInfo) {
    szInfo = "<div>" + dateFormat(new Date(), "yyyy-MM-dd hh:mm:ss") + " " + szInfo + "</div>";
    $("#opinfo").html(szInfo + $("#opinfo").html());
}

