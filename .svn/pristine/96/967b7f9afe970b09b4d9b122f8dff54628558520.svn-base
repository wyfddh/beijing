/**
 * 判断ajax请求是否需要登陆
 */
var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
$.ajaxSetup( {
    //设置ajax请求结束后的执行动作
    complete : function(XMLHttpRequest) {
        if (XMLHttpRequest.status == 999) {
            var win = window;
            while (win != win.top){
                win = win.top;
            }
            //将后端重定向的地址取出来,使用win.location.href去实现重定向的要求
            win.location.href= projectName + "/sso.jsp";
        }
    }
});

var PROPERTY = function () {

}
var pathName=window.document.location.pathname;
PROPERTY.prototype.projectPath=pathName.substring(0,pathName.substr(1).indexOf('/')+2);
//PROPERTY.prototype.projectPath = "http://192.168.5.148:8080/admin/"

PROPERTY.prototype.getProjectPath = function () {
    return this.projectPath;
}
PROPERTY.prototype.setForm= function setForm(obj,jsonValue) {
    $.each(jsonValue, function (name, ival) {
        var $oinput = obj.find("[name=" + name + "]");
        if ($oinput.attr("type") == "radio" || $oinput.attr("type") == "checkbox") {
            $oinput.each(function() {
                if (Object.prototype.toString.apply(ival) == '[object Array]') { //是复选框，并且是数组
                    for (var i = 0; i < ival.length; i++) {
                        if ($(this).val() == ival[i]) //或者文本相等
                            $(this).prop("checked", true);
                    }
                } else {
                    if ($(this).val() == ival)
                        $(this).attr("selected",true);
                }
            });
        } else if ($oinput.attr("type") == "textarea") { //多行文本框
            obj.find("[name=" + name + "]").html(ival);
        } else if($oinput.attr("type") == "div") { //div
            $('#' + name).html(ival);
        } else {
            obj.find("[name=" + name + "]").val(ival);
        }
    });
}

/**
 * 获取页数字典数据
 * @param keys 字典key数组
 */
PROPERTY.prototype.getDictData = function (key) {
    var datas = null;
    var json = {"key":key};
    $.ajax({
        type:"post",
        data:json,
        async:false,
        url:property.getProjectPath()+"sysDict/getSelectDataByKey.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                top.layer.msg(result.data);
            }
        },
        error:function(result) {
            top.layer.msg("系统异常");
        }
    });
    return datas;
}



PROPERTY.prototype.getSysDictListByPid = function(id) {
    var datas = null;
    $.ajax({
        type:"get",
        async:false,
        url:property.getProjectPath()+"collect/getSysDictListByPid.do?pid="+id,
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                top.layer.msg(result.data);
            }
        },
        error:function(result) {
            top.layer.msg("系统异常");
        }
    });
    return datas;
}
/**
 * 批量获取页数字典数据
 * @param keys 字典key数组
 */
PROPERTY.prototype.getDictDataMulti = function (keys) {
    var datas = null;
    var json = {"arr":keys};
    $.ajax({
        type:"post",
        data:json,
        async:false,
        url:property.getProjectPath()+"sysDict/getSelectDataByArea.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                top.layer.msg("系统异常");
            }
        },
        error:function(result) {
            top.layer.msg("系统异常");
        }
    });
    return datas;
}
/**
 * 根据业务字典值获取显示值
 * @param datas 业务字典列表
 * @param value 值
 */
PROPERTY.prototype.getTextByValue = function (datas,value) {
    if (null == datas || datas.length == 0){
        return null;
    }else {
        var result = null;
        for (var i=0;i<datas.length;i++){
            if (datas[i].dictCode == value){
                result = datas[i].dictName;
                break;
            }
        }
        if (null == result){
            return value;
        }
        return result;
    }
}
/**
 * 根据业务字典值获取显示值
 * @param datas 业务字典列表
 * @param value 值
 * @param valueField 值字段
 * @param textField 显示值字段
 * @returns {*}
 */
PROPERTY.prototype.getTextByValuePlus = function (datas,value,valueField,textField) {
    if (null == datas || datas.length == 0){
        return null;
    }else {
        var result = null;
        for (var i=0;i<datas.length;i++){
            if (datas[i][valueField] == value){
                result = datas[i][textField];
                break;
            }
        }
        if (null == result){
            return value;
        }
        return result;
    }
}

/**
 * 根据业务字典值获取显示值
 * @param datas 业务字典列表
 * @param value 值
 */
PROPERTY.prototype.getValueByText = function (datas,value) {
    if (null == datas || datas.length == 0){
        return null;
    }else {
        var result = null;
        for (var i=0;i<datas.length;i++){
            if (datas[i].dictName == value){
                result = datas[i].dictCode;
                break;
            }
        }
        if (null == result){
            return value;
        }
        return result;
    }
}
/**
 * 根据业务字典值获取显示值
 * @param datas 业务字典列表
 * @param value 值
 * @param valueField 值字段
 * @param textField 显示值字段
 * @returns {*}
 */
PROPERTY.prototype.getValueByTextPlus = function (datas,value,valueField,textField) {
    if (null == datas || datas.length == 0){
        return null;
    }else {
        var result = null;
        for (var i=0;i<datas.length;i++){
            if (datas[i][textField] == value){
                result = datas[i][valueField];
                break;
            }
        }
        if (null == result){
            return value;
        }
        return result;
    }
}
/**
 * 获取流水号
 * @param lsKey
 * @param lsType
 * @returns {*}
 */
PROPERTY.prototype.getLs = function (lsKey,lsType) {
    var datas = null;
    var json = {"lsKey":lsKey,"lsType":lsType};
    $.ajax({
        type:"post",
        data:json,
        async:false,
        url:property.getProjectPath()+"PostLs/getPostLs.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                top.layer.msg("系统异常");
            }
        },
        error:function(result) {
            top.layer.msg("系统异常");
        }
    });
    return datas;
}
/**
 * 获取表单json格式
 * @param form
 * @returns {{}}
 */
PROPERTY.prototype.getFormJson = function (form) {
    var o = {};
    var a = $(form).serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}


PROPERTY.prototype.getApprovalList = function (roleCode) {
    var datas = null;
    var json = {"roleCode":roleCode};
    $.ajax({
        type:"post",
        data:json,
        async:false,
        url:property.getProjectPath()+"RoleAuth/getUserListByRoleCode.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                errorMsg("系统异常");
            }
        },
        error:function(result) {
            errorMsg("系统异常");
        }
    });
    return datas;
}
/**
 * 获取所有用户信息
 * @returns {*}
 */
PROPERTY.prototype.getAllUserList = function () {
    var datas = null;
    $.ajax({
        type:"get",
        async:false,
        url:property.getProjectPath()+"RoleAuth/getAllUserList.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                errorMsg("系统异常");
            }
        },
        error:function(result) {
            errorMsg("系统异常");
        }
    });
    return datas;
}

/**
 * 获取所有组织机构信息
 * @returns {*}
 */
PROPERTY.prototype.getAllOrgList = function () {
    var datas = null;
    $.ajax({
        type:"get",
        async:false,
        url:property.getProjectPath()+"RoleAuth/getAllOrgList.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                errorMsg("系统异常");
            }
        },
        error:function(result) {
            errorMsg("系统异常");
        }
    });
    return datas;
}
/**
 * 获取时间戳
 * @param form
 * @returns {number}
 */
PROPERTY.prototype.getTimeJson = function () {
   var date = new Date();
   var time = date.getTime();
   return time;
}
var userInfo = null;
var userId = null;
//设置用户信息
PROPERTY.prototype.setUserInfo = function () {
    if (null != localStorage.userInfo){
        userInfo = JSON.parse(localStorage.userInfo);
        $("#userName").text(userInfo.userName);
        userId = userInfo.userId;
        $("#orgName").text(userInfo.orgName);
        var nowdate = getNowFormatDate();
        $("#nowDate").text(nowdate);
    }else{
        alert("用户未登陆，请先登录!");
        window.location.href= prototype.getProjectPath;
    }
}
/**
 * 控制按钮权限
 */
PROPERTY.prototype.setButtonAuth = function () {
    if (null != userInfo){
        var json = {"userId":userInfo.userId,"type":"1"}
        $.ajax({
            type:"post",
            async:false,
            url:property.getProjectPath()+"RoleAuth/getAllOrgList.do",
            success:function(result) {
                if (result.success == 1) {
                    var datas = result.data;
                    if (null != datas){
                        for (var i=0;i<datas.length;i++){
                            var tempId = datas[i].functionurl;
                            $("#"+tempId).removeClass('layui-hide');
                            $("#"+tempId).show();
                        }
                    }
                } else {
                    errorMsg("系统异常");
                }
            },
            error:function(result) {
                errorMsg("系统异常");
            }
        });
    }else{
        alert("用户未登陆，请先登录!");
        window.location.href='/login.html';
    }
}

/**
 * 查询流程状态
 * @param userId 用户id
 * @param postVideoId 影视资料id
 */
PROPERTY.prototype.getProcessStatus = function (userId,postVideoId,type) {
    var json = {"userId":userId,"postVideoId":postVideoId,"type":type}
    var datas = null;
    $.ajax({
        data:json,
        type:"post",
        async:false,
        url:property.getProjectPath()+"PostVideo/getProcessUserStatus.do",
        success:function(result) {
            if (result.success == 1) {
                datas = result.data;
            } else {
                errorMsg("系统异常");
            }
        },
        error:function(result) {
            errorMsg("系统异常");
        }
    });
    return datas;
}



var property = new PROPERTY();


//格式化时间(时间戳转换为 日期格式   年月日时分秒)
function formatDate(v) {
    if(/^(-)?\d{1,10}$/.test(v)) {
        v = v * 1000;
    } else if(/^(-)?\d{1,13}$/.test(v)) {
        v = v * 1;
    }
    var dateObj = new Date(v);
    var month = dateObj.getMonth() + 1;
    var day = dateObj.getDate();
    var hours = dateObj.getHours();
    var minutes = dateObj.getMinutes();
    var seconds = dateObj.getSeconds();
    if(month < 10) {
        month = "0" + month;
    }
    if(day < 10) {
        day = "0" + day;
    }
    if(hours < 10) {
        hours = "0" + hours;
    }
    if(minutes < 10) {
        minutes = "0" + minutes;
    }
    if(seconds < 10) {
        seconds = "0" + seconds;
    }
    var UnixTimeToDate = dateObj.getFullYear() + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;
    return UnixTimeToDate;
}



//格式化时间(时间戳转换为 日期格式   年月日)
function formatSimpleDate(v) {
    if(/^(-)?\d{1,10}$/.test(v)) {
        v = v * 1000;
    } else if(/^(-)?\d{1,13}$/.test(v)) {
        v = v * 1;
    }
    var dateObj = new Date(v);
    var month = dateObj.getMonth() + 1;
    var day = dateObj.getDate();
    var hours = dateObj.getHours();
    var minutes = dateObj.getMinutes();
    var seconds = dateObj.getSeconds();
    if(month < 10) {
        month = "0" + month;
    }
    if(day < 10) {
        day = "0" + day;
    }
    if(hours < 10) {
        hours = "0" + hours;
    }
    if(minutes < 10) {
        minutes = "0" + minutes;
    }
    if(seconds < 10) {
        seconds = "0" + seconds;
    }
    var UnixTimeToDate = dateObj.getFullYear() + '-' + month + '-' + day;
    return UnixTimeToDate;
}

function formatDateParagraph(startTime,endTime) {
    startTime = formatSimpleDate(startTime);
    endTime = formatSimpleDate(endTime);
    return startTime+" - "+endTime;
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function getDay(day){

        var today = new Date();



        var targetday_milliseconds=today.getTime() + 1000*60*60*24*day;



        today.setTime(targetday_milliseconds); //注意，这行是关键代码



        var tYear = today.getFullYear();

        var tMonth = today.getMonth();

        var tDate = today.getDate();

        tMonth = doHandleMonth(tMonth + 1);

        tDate = doHandleMonth(tDate);

        return tYear+"-"+tMonth+"-"+tDate;

     }

 function doHandleMonth(month){

        var m = month;

        if(month.toString().length == 1){
            m = "0" + month;
        }

        return m;

     }

function successMsg(msg) {
  var content = "";
  if (isEmpty(msg)) {
    content = "<div class='msg successMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + "操作成功！"
        + "</div><div class='msg-txt'></div></div>";
  } else {
    content ="<div class='msg successMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + msg
        + "</div><div class='msg-txt'></div></div>"
  }
  layer.open({
    type: 1,
    title: false,
    closeBtn: 0,
    time:1000,
    shadeClose: true,
    skin: "msg",
    content: content
  });
}
function errorMsg(msg) {
  var content = "";
  if (isEmpty(msg)) {
    content = "<div class='msg errorMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + "操作失败！"
        + "</div><div class='msg-txt'></div></div>";
  } else {
    content ="<div class='msg errorMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + msg
        + "</div><div class='msg-txt'></div></div>"
  }
  layer.open({
    type: 1,
    title: false,
    closeBtn: 0,
    time:2000,
    shadeClose: true,
    skin: "msg",
    content: content
  });

}
function alertMsg(msg) {
  var content = "";
  if (isEmpty(msg)) {
    content = "<div class='msg alertMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + "操作有误！"
        + "</div><div class='msg-txt'></div></div>";
  } else {
    content ="<div class='msg alertMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + msg
        + "</div><div class='msg-txt'></div></div>"
  }
  layer.open({
    type: 1,
    title: false,
    closeBtn: 0,
    time:2000,
    shadeClose: true,
    skin: "msg",
    content: content
  });
}
function loadingMsg(msg) {
  var content = "";
  if (isEmpty(msg)) {
    content = "<div class='msg loadingMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + "数据提交中，请稍候！"
        + "</div><div class='msg-txt'></div></div>";
  } else {
    content ="<div class='msg loadingMsg'><div class='msg-icon'></div><div class='msg-title'>"
        + msg
        + "</div><div class='msg-txt'></div></div>"
  }
  var indexLoading = layer.open({
    type: 1,
    title: false, //不显示标题
    closeBtn: 0,
    shadeClose: false,
    skin: "msg",
    content: content
  });

  return indexLoading;
}

function isEmpty(obj){
  if(typeof obj == "undefined" || obj == null || obj == "")	{
    return true;
  }else{
    return false;
  }
}
/**
 * 检测用户是否属于影视部
 * @param orgId 部门id
 */
function checkOrg(userId) {
    var flag = false;
    var json = {"userId":userId};
    $.ajax({
        url:property.getProjectPath() + 'PostVideo/checkOrg.do',
        type:'post',
        data:json,
        async:false,
        success:function(result) {
            if (result.success == "1") {
                flag = result.data;
            } else {
                var resultMsg = "系统异常";
                errorMsg(resultMsg);
            }
        }
    })
    return flag;
}

/**
 * 获取当前链接中的参数
 * getQueryString("11111");
 * @param name
 * @returns {null}
 */
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}

(function($) {
    var _ajax = $.ajax;
    $.ajax = function(opt) {
        var fn = {
            xhrFields: {
                withCredentials: true
            }
        };

        var _opt = $.extend(opt, fn);
        _ajax(_opt);
    };
})(jQuery);