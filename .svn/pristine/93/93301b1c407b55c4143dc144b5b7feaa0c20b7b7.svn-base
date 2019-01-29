<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE html> -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        a:hover{
            text-decoration: none;
        }
        .check-box, .radio-box{
            padding-left: 0;
        }
        input,textarea:hover{
            border:1px solid #dddddd!important;
            outline:none!important;
        }
        <%--新改的样式--%>
        .line{
            width:100%;
            height:50px;
            box-sizing:border-box;
            line-height:50px;
            border:none;
        }
        .line:after{
            display:block;
            content:"";
            clear:both;
        }
        .title{
            width:50px;
            height:100%;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            float:left;
            text-align:right;
            padding-right:15px;
        }
        .topSel{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            width: 260px;
            height: 24px;
            margin-top:13px;
        }
        .secondLine{
            float:left;
            width:350px;
        }
        .inputText{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            width: 260px;
            height: 24px;
            margin-top:13px;
            padding-left:8px;
            box-sizing:border-box;
        }
        .areaSel{
            width:80px;
            margin-right:11px;
        }
        .langInput{
            width: 420px;
        }
        .seconeLineTwo{
            width:490px;
        }
        .areaText{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            width: 770px;
            height: 121px;
            resize:none;
            margin-top:13px;
        }
        .bigLine{
            height:150px;
        }
        .subBtn{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(255, 255, 255);
            line-height: 36px;
            text-align:center;
            box-sizing:border-box;
            float:left;
            margin-right:12px;
            cursor:pointer;
        }
        .subBtn > img{
            vertical-align:text-top;
        }
        .conform{
            background-color: rgb(42, 155, 207);
        }
        .cancel{
            border:1px solid rgb(42, 155, 207);
            line-height: 34px;
            background:#fff;
            color: rgb(42, 155, 207);
        }
        .star{
            color:#ff7267;
            display:inline-block;
            padding-right: 4px;
        }
    </style>
    <title>组织机构管理文物局详情</title>
</head>
<body style="background:#fff!important;">
<div class="pl-30 pr-30 pt-10">
    <form action="" id="newForm">
        <div class="line">
            <div class="title">上级 : </div>
            <c:if test="${'0' eq relicOrganization.parentId }">
            <input class="topSel"  type="text" readonly="readonly" value="国家文物局" disabled>
            </c:if>

            <c:if test="${'16' eq relicOrganization.parentId }">
            <input class="topSel"  type="text" readonly="readonly" value="山东省文物局" disabled>
            </c:if>

            <c:if test="${'7' eq relicOrganization.parentId }">
            <input class="topSel"  type="text" readonly="readonly" value="吉林省文物局" disabled>
            </c:if>
        </div>

        <div class="line">
            <div class="secondLine">
                <div class="title"><span class="star">*</span>名称 : </div>
                <input class="inputText" readonly="readonly" id="nameNew" type="text"  value="${relicOrganization.name }" disabled>
            </div>
            <div class="secondLine">
                <div class="title">层级 : </div>
                <c:if test="${'1' eq relicOrganization.level }">
                    <input type="text" class="inputText" value="1级" readonly="readonly" disabled>
                </c:if>
                <c:if test="${'2' eq relicOrganization.level }">
                    <input type="text" class="input-text" value="2级" readonly="readonly" disabled>
                </c:if>
                <c:if test="${'3' eq relicOrganization.level }">
                    <input type="text" class="input-text" value="3级" readonly="readonly" disabled>
                </c:if>
            </div>
        </div>

        <div class="line">
            <div class="secondLine">
                <div class="title"><span class="star">* </span>地区 : </div>
                <!-- <span class="select-box"> -->
                <select name="provinceId" disabled class="topSel areaSel">
                    <option value="">请选择</option>
                    <c:forEach items="${proList}" var="pro" varStatus="row">
                        <option value="${pro.id}" <c:if test="${pro.id eq relicOrganization.provinceId}">selected</c:if>>${pro.name}</option>
                    </c:forEach>
                </select>

                <select name="cityId" disabled class="topSel areaSel">
                    <option value="">请选择</option>
                    <c:forEach items="${cityList}" var="city" varStatus="row">
                        <option value="${city.id}" <c:if test="${city.id eq relicOrganization.cityId}">selected</c:if> >${city.name}</option>
                    </c:forEach>
                </select>

                <select name="townId" disabled class="topSel areaSel">
                    <option value="">请选择</option>
                    <c:forEach items="${townList}" var="town" varStatus="row">
                        <option value="${town.id}" <c:if test="${town.id eq relicOrganization.townId}">selected</c:if> >${town.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="secondLine seconeLineTwo">
                <div class="title"><span class="star">* </span>地址 : </div>
                <input class="inputText langInput" readonly="readonly" id="addressNew" type="text"   value="${relicOrganization.address }" disabled>
            </div>
        </div>

        <div style="clear:both;"></div>

        <div class="line">
            <div class="secondLine">
                <div class="title">电话 : </div>
                <input class="inputText" readonly="readonly" type="text"   value="${relicOrganization.tel }" disabled>
            </div>
            <div class="secondLine seconeLineTwo">
                <div class="title">传真 : </div>
                <input class="inputText langInput" readonly="readonly" type="text"   value="${relicOrganization.fex }" disabled>
            </div>
        </div>

        <div class="line">
            <div class="title">邮箱 : </div>
            <input class="inputText" readonly="readonly" type="text"   value="${relicOrganization.email }" disabled>
        </div>

        <div class="line bigLine">
            <div class="title">描述 : </div>
            <textarea  name="info" cols="20" rows="30" readonly="readonly" class="areaText"   datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！">${relicOrganization.info }</textarea>
        </div>

        <div class="line" align="left">
            <div class="title"></div>
            <button class="subBtn cancel" id="close"><img src="<%=request.getContextPath() %>/back/images/cancel.png"> 返回</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $("#close").click(function(){
        parent.layer.closeAll();
    });
</script>
</body>
</html>