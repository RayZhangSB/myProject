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

function setCookie(name, value, date) {
    var Days = 30;
    date.setTime(date.getTime() + 3600 * 2000);//过期时间 10分钟
    document.cookie = name + "=" + value + ";expires=" + date.toGMTString();
}