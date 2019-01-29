<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/collection_manage.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
    <%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/back/multiple-select-master/demos/assets/bootstrap/css/bootstrap.css" /> --%>
    <%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/back/multiple-select-master/multiple-select.css" /> --%>
    <title>藏品编辑</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    
     <style>
        .img_wrap{
            width: 300px;
            height: 300px;
            position: absolute;
            top:50%;
            laft:100%;
            margin-top: -150px;
            margin-left: 500px;
            background: red;
        }
        .grid-bg{
            background: #00CCFF!important;
            color: #ffffff;
        }
        #DataTables_Table_0_filter{
            display: none;
        }
        #coverVideo{
            width: 1000px;
            height: 500px;
            background: rgba(0,0,0,0.7);
            position: fixed;
            left: 25%;
            top:20%;
            border:5px solid lightslategray;
            min-width: 800px;
            display: none;
        }
        #coverAudio{
            width: 1000px;
            height: 500px;
            background: rgba(0,0,0,0.7);
            position: fixed;
            left: 25%;
            top:20%;
            border:5px solid lightslategray;
            min-width: 800px;
            display: none;
        }
        #coverPic{
        	 width: 1000px;
        	 height: 500px;
        	 background: rgba(0,0,0,0.7);
        	 position: fixed;
        	 left: 25%;
        	 top:20%;
        	 border:5px solid lightslategray;
        	 min-width: 800px;
        	 display: none;
        }
        .close{
            position: absolute;
            right: 0;
        }
        .lig{
            line-height:30px
        }
        .zj_edit_imgLi .clo{
            width:20px !important;
            height:20px !important;
            background:#BD634B;
            color:#fff;
            font-size:20px;
            z-index:999;
            opacity:0.7!important;
            text-align:center;
            line-height:18px;
            text-shadow:none!important;
            float:right;
            position:absolute !important;
            left:10px;
            top: 0;
            cursor:pointer;
        }
        
    	/*zj  2017/8/3*/
        /*大坑，第三次修改*/
       	body{
       		background-color: white !important;
       	}
        .section_box{
        	position:static !important;
        	width: 860px !important;
        	display: block;
        	padding: 30px 0 0 0 !important;
        	margin: 0 auto !important;
        }
        .zj_edit_title{
        	font-size: 18px;
        	color: black;
        }
        .zj_edit_btn{
        	float: right !important;
        	width: 250px;
        }
        .zj_edit_btn a:nth-child(1){
        	display: block;
        	background-color: #2a9bcf;
        	color: white;
        	padding: 9px 24px;
        	border-radius: 5px;
        	text-decoration: none;
        	height: 18px;
        	line-height: 18px;
        	float: left;
        	border: 1px solid #2a9bcf;
        }
        .zj_edit_btn a:nth-child(2){
        	display: block;
        	background-color: white;
        	color: #2a9bcf;
        	padding: 9px 24px;
        	border-radius: 5px;
        	text-decoration: none;
        	height: 18px;
        	line-height: 18px;
        	float: right;
        	border: 1px solid #2a9bcf;
        }        
        
        .zj_edit_btn img{
        	display: block;
        	float: left;
        	margin-right: 5px;
        }
        .tabBar{
        	border: 0 !important;
        }
        .current{
        	color: white;
        	background-color: #2a9bcf !important;
        	border-radius: 5px !important;
        }
        .tabBar span{
        	padding: 12px;
        	font-size: 14px;
        	line-height: 14px;
        	height: auto !important;
        	font-weight: normal !important;
        	background-color: white;
        	margin-right: 12px !important;
        	border: 1px solid #2a9bcf;
        	border-radius: 5px !important;
        }
        .zj_edit_message{
        	width: 100%;
        	padding: 24px 0;
        	border-bottom: 1px solid #f1f2f7;
        	margin-bottom: 13px;
        }
        .zj_edit_message>span{
        	font-size: 16px;
        }
        .tabCon{
        	border: 1px solid #f1f2f7;
        	padding: 0 12px !important;
        }
        .size-XXL{
        	display: block;
        	width: 180px;
        	height: 112px;
        	border-radius: 5px !important;
        }
        li{
        	list-style: none;
        }
        .box-size{
        	float: left;
        }
        .zj_edit_content div{
        	padding: 0 24px 0 0;
        	text-align: left !important;
        }
        .zj_edit_content label{
        	padding: 0 !important;
        }
        
        
        .label_1{
        	width: 110px;
        	float: left;
        	text-align: left !important;
        }
        .label_2{
        	width: 110px;
        	float: left;
        	text-align: left !important;
        }       
        .label_3{
        	width: 80px;
        	float: left;
        	text-align: left !important;
        }        
        .label_4{
        	width: 90px;
        	float: left;
        	text-align: left !important;
        }        
        .zj_edit_content span,input{
        	font-size: 14px;
        	border-radius: 5px !important;
        	border: 1px solid #e6e6e6 !important;
        }
        .formControls{
        	float: left !important;
        	width: 135px ;
        	padding: 0 !important;
        }
        .formControls_spe{
       		width: 180px !important;
       		float: left !important;
       		padding: 0 !important;
        }
        .zj_edit_audio{
        	padding-bottom: 18px;
        	border-bottom: 6px solid #f1f2f7;
        }
        
        .zj_edit_audio>span:nth-child(1){
        	display: block;
        	color: white;
        	background-color: #2a9bcf;
        	width: 82px;
        	border-radius: 5px;
        	padding: 10px;
        	font-size: 14px;
        	line-height: 16px;
        	margin-bottom: 18px;
        	cursor: pointer;
        }
        .zj_edit_audio>span:nth-child(1)>i{
        	font-size: 16px;
        	color: white;
        }
        #mypicture{
        	display: block;
        	color: white;
        	background-color: #2a9bcf;
        	width: 82px;
        	border-radius: 5px;
        	padding: 10px;
        	font-size: 14px;
        	line-height: 16px;
        	margin-bottom: 18px;
        	cursor: pointer;        
        }
        #mypicture>i{
        	font-size: 16px;
        	color: white;
        }
        
        .zj_edit_3d{
        	padding: 19px 0;
        	border-bottom: 6px solid #f1f2f7;
        }
        .zj_edit_3d:after{
        	content: ".";
        	display: block;
        	opacity: 0;
        	visibility: hidden;
        	height: 0;
        	clear: both;
        }
        .zj_edit_imgLi{
        	margin: 0 30px 0 0 !important;
        	height: 109px !important;
        	
        }
        .zj_edit_imgLi>div{
        	padding: 0 !important;
        	width: 163px !important;
        	height: 109px !important;
        	border: none !important;
        }
        
        
        
        .zj_edit_imgLi>div>div:nth-child(1){
        	width: 163px !important;
        	height: 109px !important;
        }
        .zj_edit_imgLi img{
        	display: block;
        	width: 163px !important;
        	max-width: 163px !important;
        	height: 109px !important;        	
        }
        .zj_edit_imgBtn{
        	padding: 6px !important;
        	border-radius: 5px;
        	font-size: 11px;
        	line-height: 11px;
        	height: auto !important;
        }
        .radioc{
		    margin-top: 6px;
		}
    </style>
     
    
</head>
<body>
<section class="Hui-article-box section_box">
    <div id="content_warp">
    	<div style="margin-bottom: 36px !important;">
    		<span class="zj_edit_title">查看藏品</span>
            <div class="button_wrap zj_edit_btn">
            </div>
		</div>
        <form action="" method="get" class="form form-horizontal" id="form-collection-add">
            <div id="tab-category" class="HuiTab">
                <div class="tabBar cl">
                	<span id="picture">藏品信息</span>
                	
                </div>
                <!--第一个列表页开始-->
                <div class="tabCon">
                	<input type="hidden" name="id" value="${collection.id}">
                	<div class="zj_edit_message">
                		<span>
                			基本信息
                		</span>
                	</div>
                	
                    <!--第一行开始-->
                    <div class="zj_edit_content" style="">
                    	<div class="col-xs-12" style="padding: 0;margin-bottom: 25px;">
                    		<div class="col-md-3 col-xs-12 col-sm-6">
			                    <c:forEach items="${pictures}" var="pic" varStatus="row">
			                		<c:if test="${row.index==0}">
			                            <img src="${pic.url }" class="size-XXL">
			                        </c:if>
			                	</c:forEach>                     		
                    		</div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品名称：</label>
	                            <div class="formControls_spe">
	                                <input type="text" name="name" class="input-text mingcheng" value="${collection.name }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物级别：</label>
	                            <div class="formControls_spe">
	                            	<span class="select-box">
		                            	<select class="select" name="collectionLevel" disabled="disabled" >
		                            		<option value="">请选择</option>
											<option value="1" <c:if test="${'1' eq collection.collectionLevel}">selected</c:if> >一级</option>
											<option value="2" <c:if test="${'2' eq collection.collectionLevel}">selected</c:if> >二级</option>
											<option value="3" <c:if test="${'3' eq collection.collectionLevel}">selected</c:if> >三级</option>
											<option value="4" <c:if test="${'4' eq collection.collectionLevel}">selected</c:if> >一般</option>
											<option value="5" <c:if test="${'5' eq collection.collectionLevel}">selected</c:if> >未定级</option>
										</select>
									</span>
	                            </div>
	                        </div>                  		
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;margin-bottom: 9px;">
	                            <label class="form-label label_4"><!--<i style="color: red;font-style: normal;line-height: 19px;">* </i>--> 普查编号：</label>
	                            <div class="formControls_spe ">
	                                <input type="text" name="gsNo" class="input-text puchaNum" value="${collection.gsNo }" readonly="readonly" disabled="disabled"">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>                  		
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物类别：</label>
	                            <div class="formControls_spe ">
		                            <span class="select-box">
								        <select class="select" name="collectionsCategory" disabled="disabled" >
								        	<option value="">请选择</option>
		                                      <c:forEach items="${ccList}" var="cc" varStatus="row">
												  <option value="${cc.id}" <c:if test="${cc.id eq collection.collectionsCategory}">selected</c:if> >${cc.name}</option>
											  </c:forEach>
		                                </select>
								    </span>
							    </div>
	                        </div>                  		
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 收藏单位：</label>
	                            <div class="formControls_spe ">
	                                <input type="text" class="input-text collectUnit" value="${org.name}" readonly="readonly" disabled="disabled">
	                                <input type="hidden" name="collectionUnit" class="input-text" value="${org.id }" readonly="readonly">
	                            </div>
	                        </div>  
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 年代：</label>
	                            <div class="formControls_spe">
		                            <span class="select-box">
		                            	<select class="select niandai" name="yearType" disabled="disabled" >
		                            		<option value="">请选择</option>
			                            	<c:forEach items="${ytList}" var="yt" varStatus="row">
												<option value="${yt.id}" <c:if test="${yt.id eq collection.yearType}">selected</c:if> >${yt.name}</option>
											</c:forEach>
										</select>
									</span>
	                            </div>
	                        </div>	                       	
                    	</div>
                        
						<div class="col-xs-12" style="margin-bottom: 50px;">
	                        <label class="form-label" style="text-align: left;"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品简介：</label>
	                        <textarea name="description" class="textarea cangpinjianjie" readonly="readonly">${collection.description }</textarea>
	                    </div>
	                    
	                    
	                    <!--第一行-->
	                    <div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-6 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">公开设置：</label>
	                            <div class="formControls radioc">
	                                <input type="radio" disabled name="isOpen" value="2" <c:if test="${collection.isOpen==2 }">checked</c:if>/>已公开
	                                <input type="radio" disabled name="isOpen" value="1" <c:if test="${collection.isOpen==1 }">checked</c:if>/>未公开
	                            </div>
	                            <!--<div class=" col-xs-2"></div>-->
	                        </div>
	                        <div class="col-md-6 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">馆际交流设置：</label>
	                            <div class="formControls radioc">
	                            	<input type="radio" disabled name="isBorrow" value="1" <c:if test="${collection.isBorrow==1 }">checked</c:if>/>可供借展
	                            	<input type="radio" disabled name="isBorrow" value="0" <c:if test="${collection.isBorrow==0 }">checked</c:if>/>不可借展
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">收藏单位编号：</label>
	                            <div class="formControls">
	                                <input type="text" readonly="readonly" name="dwid" class="input-text" value="${collection.dwid }">
	                            </div>
	                            <!--<div class=" col-xs-2"></div>-->
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">藏品编号类型：</label>
	                            <div class="formControls">
	                            	<span class="select-box">
								        <select class="select cangpinNumType" disabled="disabled" name="gsCollectionsNoType">
								        	<option value="">请选择</option>
	                                        <option value="藏品总登记号" <c:if test="${'藏品总登记号' eq collection.gsCollectionsNoType}">selected</c:if> >藏品总登记号</option>
	                                        <option value="辅助账号" <c:if test="${'辅助账号' eq collection.gsCollectionsNoType}">selected</c:if> >辅助账号</option>
	                                    </select>
								    </span>
	                            </div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">藏品编号：</label>
	                            <div class="formControls" style="width: 189px;">
	                                <input type="text" readonly="readonly" name="gsCollectionsNo" class="input-text cangpinNum" value="${collection.gsCollectionsNo }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    	
	                    </div>
						<!--第二行-->
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">原名：</label>
	                            <div class="formControls">
	                                <input type="text" readonly="readonly" name="formerly" class="input-text yuanming" value="${collection.formerly }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>							
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">具体年代：</label>
	                            <div class="formControls ">
	                                <input type="text" readonly="readonly" name="gsSpecificYear" class="input-text" value="${collection.gsSpecificYear }">
	                            </div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">文物来源：</label>
	                            <div class="formControls "  style="width: 189px;">
	                            	<span class="select-box">
		                            	<select class="select" name="gsSource" disabled="disabled">
		                            		<option value="">请选择</option>
											<option value="征集购买" <c:if test="${'征集购买' eq collection.gsSource}">selected</c:if> >征集购买</option>
											<option value="接受捐赠" <c:if test="${'接受捐赠' eq collection.gsSource}">selected</c:if> >接受捐赠</option>
											<option value="依法交换" <c:if test="${'依法交换' eq collection.gsSource}">selected</c:if> >依法交换</option>
											<option value="拨交" <c:if test="${'拨交' eq collection.gsSource}">selected</c:if> >拨交</option>
											<option value="移交" <c:if test="${'移交' eq collection.gsSource}">selected</c:if> >移交</option>
											<option value="旧藏" <c:if test="${'旧藏' eq collection.gsSource}">selected</c:if> >旧藏</option>
											<option value="发掘" <c:if test="${'发掘' eq collection.gsSource}">selected</c:if> >发掘</option>
											<option value="采集" <c:if test="${'采集' eq collection.gsSource}">selected</c:if> >采集</option>
											<option value="拣选" <c:if test="${'拣选' eq collection.gsSource}">selected</c:if> >拣选</option>
											<option value="其他" <c:if test="${'其他' eq collection.gsSource}">selected</c:if> >其他</option>
										</select>
									</span>
	                            </div>
	                        </div>	                        
						</div>
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6" >
	                            <label class="form-label label_2">质地类别：</label>
	                            <div class="form-label formControls">
		                            <span class="select-box">
		                            	<select class="select zhidiType" name="gsTextureCategory" disabled="disabled">
		                            		<option value="">请选择</option>
											<option value="单一质地" <c:if test="${'单一质地' eq collection.gsTextureCategory}">selected</c:if> >单一质地</option>
											<option value="复合或组合质地" <c:if test="${'复合或组合质地' eq collection.gsTextureCategory}">selected</c:if> >复合或组合质地</option>
										</select>
									</span>
	                            </div>
	                        </div>							
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">质地：</label>
	                            <div class="formControls ">
	                                <input type="text" readonly="readonly" name="gsTexture" class="input-text" value="${collection.gsTexture }">
	                            </div>
	                   		</div>						
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3" >质地子类别:</label>
	                            <div class="form-label formControls"  style="width: 189px;">
	                            	<span class="select-box">
		                            	<select class="select zhidiziType" id="" disabled="disabled" name="gsTextureSubcategories">
		                            		<option value="">请选择</option>
											<option value="有机质" <c:if test="${'有机质' eq collection.gsTextureSubcategories}">selected</c:if> >有机质</option>
											<option value="无机质" <c:if test="${'无机质' eq collection.gsTextureSubcategories}">selected</c:if> >无机质</option>
											<option value="有机复合或组合" <c:if test="${'有机复合或组合' eq collection.gsTextureSubcategories}">selected</c:if> >有机复合或组合</option>
											<option value="无机复合或组合" <c:if test="${'无机复合或组合' eq collection.gsTextureSubcategories}">selected</c:if> >无机复合或组合</option>
											<option value="有机无机复合或组合" <c:if test="${'有机无机复合或组合' eq collection.gsTextureSubcategories}">selected</c:if> >有机无机复合或组合</option>
										</select>
									</span>
	                            </div>
	                        </div>						
						</div>						
						<!--第三行-->
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_1">通长:</label>
						        <div class="formControls">
						            <input type="text" name="gsLength" readonly="readonly" class="input-text ckg tongchang" value="${collection.gsLength }">
						           <%--  <input type="text" name="gsLength" class="input-text" value="${collection.gsLength }" hidden> --%>
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_2">通宽:</label>
						        <div class="formControls">
						            <input type="text" name="gsWidth" readonly="readonly" class="input-text ckg tongkuan" value="${collection.gsWidth }">
						            <%-- <input type="text" name="gsWidth" class="input-text" value="${collection.gsWidth }" hidden> --%>
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
						        <label class="form-label label_3">通高:</label>
						        <div class="formControls" style="width: 189px;">
						            <input type="text" name="gsHeight" readonly="readonly" class="input-text ckg tonggao" value="${collection.gsHeight }">
						            <%-- <input type="text" name="gsHeight" class="input-text" value="${collection.gsHeight }" hidden> --%>
						        </div>
							</div>							
						</div>
						<!--第四行-->
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">具体尺寸：</label>
	                            <div class="formControls ">
	                                <input type="text" name="size" readonly="readonly" class="input-text" value="${collection.size }">
	                            </div>
	                        </div>						
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">包含文物数量：</label>
	                            <div class="form-label formControls">
	                            	<span class="select-box">
		                            	<select class="select" name="actualQuantityUnit" disabled="disabled">
		                            		<option value="">请选择</option>
											<option value="单件" <c:if test="${'单件' eq collection.actualQuantityUnit}">selected</c:if> >单件</option>
											<option value="一套多件" <c:if test="${'一套多件' eq collection.actualQuantityUnit}">selected</c:if> >一套多件</option>
										</select>
									</span>
	                            </div>
	                        </div>	
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">实际数量：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text shijishuliang" value="" id = "trueNum" readonly="readonly">
	                                <input type="text" name="actualQuantity" class="input-text" hidden value="${collection.actualQuantity }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                        
						</div>
						<!--第五行-->
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">完残程度：</label>
	                            <div class="formControls ">
	                                <input type="text" name="endResidueLevel" readonly="readonly" class="input-text" value="${collection.endResidueLevel }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">入藏时间范围：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsEntryWarehouseTimeFrame" readonly="readonly" class="input-text" value="${collection.gsEntryWarehouseTimeFrame }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">入藏年度：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" name="gsEntryWarehouseYear" readonly="readonly" class="input-text" value="${collection.gsEntryWarehouseYear }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
						</div>
						<!--第六行-->

	                    <div class="col-xs-12" style="margin-bottom: 20px;">
	                		<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">保存状态：</label>
	                            <div class="formControls ">
	                            	<span class="select-box">
		                            	<select class="select" name="gsStorageState" disabled="disabled" >
		                            		<option value="">请选择</option>
											<option value="状态稳定，不需修复" <c:if test="${'状态稳定，不需修复' eq collection.gsStorageState}">selected</c:if> >状态稳定，不需修复</option>
											<option value="部分损腐，需要修复" <c:if test="${'部分损腐，需要修复' eq collection.gsStorageState}">selected</c:if> >部分损腐，需要修复</option>
											<option value="腐蚀损毁严重，急需修复" <c:if test="${'腐蚀损毁严重，急需修复' eq collection.gsStorageState}">selected</c:if> >腐蚀损毁严重，急需修复</option>
											<option value="已修复" <c:if test="${'已修复' eq collection.gsStorageState}">selected</c:if> >已修复</option>
										</select>
									</span>
	                            </div>
	                        </div>
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">著者：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsAuthor" readonly="readonly" class="input-text" value="${collection.gsAuthor }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3" >版本：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" name="gsVersion" readonly="readonly" class="input-text" value="${collection.gsVersion }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                    </div>						
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">质量范围：</label>
	                            <div class="formControls ">
	                                <input type="text" name="massRange" readonly="readonly" class="input-text" value="${collection.massRange }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">具体质量：</label>
	                            <div class="formControls">
	                                <input type="text" name="mass" class="input-text" value="${collection.mass }" style="width: 50px;float: left;">
	                            	<select class="select" name="massUnit" style="width:85px;float: right;padding: 4px 0;" disabled="disabled">
	                            		<option value="">请选择</option>
										<option value="g" <c:if test="${'g' eq collection.massUnit}">selected</c:if> >g</option>
										<option value="kg" <c:if test="${'kg' eq collection.massUnit}">selected</c:if> >kg</option>
									</select>	                                
	                            </div>
	                        </div>						
	                    	 <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">完残状况：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" readonly="readonly" name="endResidualCondition" class="input-text" value="${collection.endResidualCondition }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>						
						</div>
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                       	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">存卷：</label>
	                            <div class="formControls ">
	                                <input type="text" readonly="readonly" name="gsKeepOnFile" class="input-text" value="${collection.gsKeepOnFile }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>						
	                    	 <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">录入员：</label>
	                            <div class="formControls ">
	                                <input type="text" readonly="readonly" name="creator" class="input-text" value="${collection.creator }">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>		
	                        <div class="col-md-4 col-xs-12 col-sm-6"  style="padding: 0;">
	                            <label class="form-label label_3" >审核员：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" readonly="readonly" name="assessor" class="input-text" value="${collection.assessor }">
	                            </div>
	                        </div>
	                        <div class="cl col-xs-8"></div>
						</div>
						<div class="col-xs-12" style="padding-bottom: 20px;border-bottom: 6px solid #f1f2f7;">
                            <label class="form-label label_2 fontgreen" style="width: 130px;">推荐为馆内精品：</label>
                            <div class="form-label formControls">
                                <div class="signl_check" style="width: 150px;">
                                    <div class="radio-box">
                                        <input type="radio" disabled id="radio-1" name="isHighQuality" value="2" <c:if test="${'2' eq collection.isHighQuality}">checked</c:if> />
                                        <label for="radio-1">是</label>
                                    </div>
                                    <div class="radio-box">
                                        <input type="radio" disabled id="radio-2" value="1" name="isHighQuality" <c:if test="${'1' eq collection.isHighQuality}">checked</c:if>>
                                        <label for="radio-2">否</label>
                                    </div>
                                </div>
                            </div>
						</div>
                    </div>
					<div style="clear: both"></div>
					<div class="zj_edit_message">
	            		<span>
	            			音频讲解词
	            		</span>
	            	</div>
	            	<div class="zj_edit_audio">
	            		
	            		<audio src="${rootUrl}${collection.fAudio }" controls></audio>
	            		<input type="text" readonly="readonly" class="input-text hidden" name="fAudio" value="${collection.fAudio }" id="upload_audio">
	            	</div>
	            	<div class="zj_edit_message">
	            		<span>
	            			三维信息
	            		</span>
	            	</div>
	            	<div class="zj_edit_3d">
                        <label style="float: left;">三维藏品地址： </label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
                            <input type="text" readonly="readonly" class="input-text" name="threeDimensionalCollection" value="${collection.threeDimensionalCollection }" placeholder="URL地址">
                        </div>	            	
	            	</div>
	            	<div class="zj_edit_message">
	            		<span>
	            			环拍信息
	            		</span>
	            	</div>
	            	<div class="zj_edit_3d" style="margin-bottom: 50px;">
                        <label style="float: left;">环拍信息地址： </label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
							<input type="text" readonly="readonly" class="input-text" name="ringBeatData" value="${collection.ringBeatData }" placeholder="URL地址">
                        </div>	            	
	            	</div>	
	   		</div>
            
            <!-- 第二个tab -->
                <div class="tabCon" id="secondTab">
                	<div class="zj_edit_message">
                		<span>
                			主图设置
                		</span>
                	</div>
             		<span id="mypicture">
            			<i class="Hui-iconfont">&#xe600;</i>
            			上传图片
            		</span>
                 	<!--<a href="#" class="btn btn-primary radius col-md-5 mt-10" id="mypicture"><i class="Hui-iconfont">&#xe642;</i> 上传图片</a>-->
                    <!--<a id="saveTabTwo" class="btn btn-primary radius saveinfo col-md-5 mt-10 saveTabTwoThree" style="margin-left: 1.5rem;background: #369593;color:#ffffff">保存</a>-->
                    <p style="line-height: 30px;" id="pictureMsg" class="msg audio hidden"><i class="Hui-iconfont pt-5" style="font-size: 16px;color: #00CC44">&#xe6a8;</i></p>
                    <!--  <input type="file" value="上传"> -->
    	     		<ul class="cl portfolio-area">
                    	<c:forEach items="${pictures}" var="pic" varStatus="row">
                    		<c:if test="${row.index==0}">
	                    		<div style="margin-bottom: 24px;">
	                    			<a href="${pic.url }" data-lightbox="gallery" data-title="${pic.name }" ><img style="height: 109px;width: 163px;display: block;" src="${pic.url }" class="size-XXL"></a>
                                    <input type="hidden" name="pictureIds" value="${pic.id}">
                                    <h3 style="font-size: 14px;padding: 12px 0 0 0;width: 163px;text-align: center;">当前主图</h3>
	                    		</div>
                    		</c:if>
                    		
                    	
                			<li class="item box-size zj_edit_imgLi">
                				<c:if test="${pic.typeId ne '1' }">
                                	<div class="clo">x</div>
                                </c:if>
                                <div class="portfoliobox box-size">
                                    <div class="picbox box-size">
                                        <a href="${pic.url }" data-lightbox="gallery" data-title="${pic.name }" ><img src="${pic.url }" class="size-XXL"></a>
                                    	<input type="hidden" name="pictureIds" value="${pic.id }">
                                    </div>
                                    <div style="position: absolute;bottom: 3px;right: 3px;">
                                    	<span>${pic.name }</span>
										<c:if test="${'1' eq pic.isMain }">		                                    
                                    		<button pic_id="${pic.id }" class="btn btn-primary size-MINI r btnMain zj_edit_imgBtn">设为主图</button>
										</c:if>
										<c:if test="${'2' eq pic.isMain }">		                                    
                                    		<input type="hidden" pic_main="${pic.id }" class="pic_main" >
										</c:if>
                                    </div>
                                </div>
                            </li>
                    	</c:forEach>
                    </ul>
                   
                </div>
                
            </div>
        </form>
        
        <!--视频遮罩层开始-->
        <form id="uploadFormVideo" enctype="multipart/form-data" method="post" >
	         <div id="coverVideo">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="videoTitle">请选择视频文件：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadVideo" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntVideo">
		    			 </span>
	                 </div>
	             </div>
	             <div class="cl text-c pd-40">
	             	<input type="button" id="uploadVideo_button" value="上传" class="btn btn-primary radius upload">
	                 <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" value="重置" />
	             </div>
	         </div>
         </form>
         
         <!--音频遮罩层开始-->
        <form id="uploadFormAudio" enctype="multipart/form-data" method="post" >
	         <div id="coverAudio">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="audioTitle">请选择音频文件：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadAudio" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntAudio">
		    			 </span>
	                 </div>
	             </div>
	             <div class="cl text-c pd-40">
	             	<input type="button" id="uploadAudio_button" value="上传" class="btn btn-primary radius upload">
	                 <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" value="重置" />
	             </div>
	         </div>
         </form>
         
         <!--图片遮罩层开始-->
        <form id="uploadFormPic" enctype="multipart/form-data" method="post" >
	         <div id="coverPic">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="cTitle">请选择图片：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadPic" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntPic">
		         			<input type="hidden" name="objectId" value="${collection.id }">
		         			<input type="hidden" name="typeId" value="3">
		    			 </span>
	                 </div>
	             </div>
	             <div class="cl text-c pd-40">
	             	<input type="button" id="uploadPic_button" value="上传" class="btn btn-primary radius upload">
	                 <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" value="重置" />
	             </div>
	         </div>
         </form>
    </div>
</section>
<!--/_menu 左边slide导航结束-->
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/back/multiple-select-master/demos/assets/jquery.min.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<%-- <script src="<%=request.getContextPath() %>/back/multiple-select-master/multiple-select.js"></script> --%>
<script type="text/javascript">
    $(function () {
    	
    	$(".size-XXL").on("click",function(){
    		
    		$("#word_msg").click();
    		
    	})
    	
        $("#head").load("headerServe.html");
    });
    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");
</script>
<script type="text/javascript">
    $(function(){
        $.Huihover(".portfolio-area li");
    });
</script>
      <!-- 判断长宽高是不是数字-->
<script type="text/javascript">
    $(".ckg").blur(function(){
         var a = $(this).val();
         var b = parseFloat(a);
         if(isNaN(b)){
        /*      alert("这是一个非数"); */
             $(this).next().val("0");
             <%--alert( $(this).attr("val"));--%>
         }else {
            /*  alert("这是一个数"); */
              $(this).next().val(b);
             <%--alert( $(this).attr("val"))--%>
           }
    });
    //判断实际数量不是数字
    $("#trueNum").blur(function(){
         var a = $(this).val();
         var b = parseFloat(a);
         if(isNaN(b)){
            /*   alert("这是一个非数"); */
              $(this).next().val("1");
              <%--alert( $(this).attr("val"));--%>
         }else {
        /*       alert("这是一个数"); */
              $(this).next().val(b);
              <%--alert( $(this).attr("val"))--%>
         }
    });
</script>


<script type="text/javascript">
	//点击视频按钮
	$("#myvideo").click(function(){
	    $("#videoTitle").html("请添加视频文件：");
	    $("#coverVideo").slideDown(500);
	});
	//点击音频按钮
	$("#myaudio").click(function(){
	    $("#audioTitle").html("请添加音频文件");
	    $("#coverAudio").slideDown(500);
	});
	//点击图片按钮
	$("#mypicture").click(function(){
	    $("#cTitle").html("请添加图片");
	    $("#coverPic").slideDown(500);
	});
	//点击关闭按钮
	$(".close").click(function(){
	    $("#coverVideo").slideUp(300);
	});
	$(".close").click(function(){
	    $("#coverAudio").slideUp(300);
	});
	$(".close").click(function(){
	    $("#coverPic").slideUp(300);
	});
</script>


    <script>
        if($.cookie('word_msg')=='1'){
            $.cookie('word_msg', null);
            $('#word_msg').click();
        }
        $(".portfolio-area").delegate("li .clo","click",function(){
            <%--alert(111);--%>
            var that = $(this);
            var thisId = $(this).siblings(".portfoliobox").find("input").val();
            <%--alert(thisId);--%>
            $.ajax({
                url:"<%=request.getContextPath() %>/back/oCCollection/deletePic.do",
                type:"post",
                data:{
                    picId:thisId
                },
                dataType : "json",
            }).success(function(result){
                console.log(result);
                    if(result == "1"){
                    <%--alert(1);--%>
                    $(that).parent("li").remove();
                    $.cookie('word_msg', '1');
                    location.reload(true);
                }else if(result == "0"){
                    layer.msg('删除失败', {icon: 2});
                }else{
                    layer.msg('此图片不允许被删除', {icon: 2});
                }
            })
        })
    </script>

	
</body>
</html>