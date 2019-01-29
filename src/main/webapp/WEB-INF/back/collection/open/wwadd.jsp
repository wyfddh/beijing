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
    <title>藏品添加</title>
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
            background: #00CCFF!important;color: #ffffff;
        }
        #DataTables_Table_0_filter{
            display: none;
        }
        #coverVideo{
            width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        #coverAudio{
            width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        #coverPic{
        	 width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        .close{
            position: absolute;right: 0;
        }
        .lig{
            line-height:30px
        }
        #word_msg{
            border-top-right-radius:0!important;
            border-bottom-right-radius:0px!important;
        }
        .clo{
            width:20px;
            height:20px;
            background:#BD634B;
            color:#fff;
            font-size:20px;
            z-index:999;
            opacity:0.7!important;
            text-align:center;
            line-height:18px;
            text-shadow:none!important;
            float:right;
            position:relative;
            left:10px;
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
        .zj_add_title{
        	font-size: 18px;
        	color: black;
        }
        .zj_add_btn{
        	float: right !important;
        	   
        } 
        .zj_add_btn a:nth-child(1){
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
        .zj_add_btn a:nth-child(2){
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
        
        .zj_add_btn img{
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
        .zj_add_message{
        	width: 100%;
        	padding: 24px 0;
        	border-bottom: 1px solid #f1f2f7;
        	margin-bottom: 13px;
        }
        .zj_add_message>span{
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
        .zj_add_content div{
        	padding: 0 24px 0 0;
        	text-align: left !important;
        }
        .zj_add_content label{
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
        .zj_add_content span,input{
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
        .zj_add_audio{
        	padding-bottom: 18px;
        	border-bottom: 6px solid #f1f2f7;
        }
        
        .zj_add_audio>span:nth-child(1){
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
        .zj_add_audio>span:nth-child(1)>i{
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
        
        .zj_add_3d{
        	padding: 19px 0;
        	border-bottom: 6px solid #f1f2f7;
        }
        .zj_add_3d:after{
        	content: ".";
        	display: block;
        	opacity: 0;
        	visibility: hidden;
        	height: 0;
        	clear: both;
        }
        .zj_add_imgLi{
        	margin: 0 30px 0 0 !important;
        	height: 109px !important;
        	
        }
        .zj_add_imgLi>div:nth-child(1){
        	position: absolute;
        	left: 10px !important;
        	top: 0 !important;
        }
        .zj_add_imgLi>div:nth-child(2){
        	padding: 0 !important;
        	width: 163px !important;
        	height: 109px !important;
        	border: none !important;
        }
        .zj_add_imgLi>div:nth-child(2)>div{
        	padding: 0 !important;
        	width: 163px !important;
        	height: 109px !important;
        	border: none !important;
        }
        
        
        .zj_add_imgLi>div>div:nth-child(1){
        	width: 163px !important;
        	height: 109px !important;
        }
        .zj_add_imgLi img{
        	display: block;
        	width: 163px !important;
        	max-width: 163px !important;
        	height: 109px !important;        	
        }
        .zj_add_imgBtn{
        	padding: 6px !important;
        	border-radius: 5px;
        	font-size: 11px;
        	line-height: 11px;
        	height: auto !important;
        }
    </style>
     
    
</head>
<body>
	
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section class="Hui-article-box section_box" style="overflow:auto">
    <div id="content_warp">
	 	<div style="margin-bottom: 36px !important;">
			<span class="zj_add_title">添加藏品</span>
	        <div class="button_wrap zj_add_btn"> 
	        	
	        	<button id="save" class="btn btn-secondary  radius" style="width: 100px">保存</button>
	        	<!-- <button id="saveTabOne" class="btn btn-secondary radius" style="width: 100px">保存并送审</button>  -->
	        	<!-- <button id="" class="btn" onclick="history.go(-1)" style="width: 100px">取消</button>   --> 
	           <%--  <a id="saveTabOne">   
	             	<img src="<%=request.getContextPath() %>/back/images/save.png"/>
	             	保存并送审
	            </a>
	            <a href="javascript:history.go(-1);">
	            	<img src="<%=request.getContextPath() %>/back/images/cancel.png"/>
	            	取消
	            </a> --%> 
	        </div>
		</div>   	
        <form action="" method="get" class="form form-horizontal" id="form-collection-add">
        	<input type="text" class="hide" id="saveStatus" name="saveStatus"> 
            <div id="tab-category" class="HuiTab">
                <div class="tabBar cl">
                	<span>字段信息</span>
                	<span id="picture">藏品图片</span>
                	<!--<span id="kzMsg">扩展信息</span>-->
                </div>
                
                <!--第一个列表页开始-->
                <div class="tabCon">
                	
                	<input type="hidden" name="id" value="${collection.id}">
                    <!--第一行开始-->
                	<div class="zj_add_message">
                		<span>
                			基本信息
                		</span>
                	</div>             
                	
                	
                    <div class="zj_add_content">
                    	<div class="col-xs-12" style="padding: 0;margin-bottom: 25px;">
                    		<div class="col-md-3 col-xs-12 col-sm-6">
			                    <img src="<%=request.getContextPath() %>/back/images/default_img.png" class="size-XXL">
                    		</div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品名称：</label>
	                            <div class="formControls_spe">
	                                <input type="text" name="name" class="input-text mingcheng" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物级别：</label>
	                            <div class="formControls_spe">
	                            	<span class="select-box">
		                            	<select class="select" name="collectionLevel" >
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
	                                <input type="text" name="gsNo" class="input-text puchaNum" value="" readonly="readonly" >
	                            </div>
	                            <div class="col-3"></div>
	                        </div>                  		
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物类别：</label>
	                            <div class="formControls_spe ">
		                            <span class="select-box">
								        <select class="select wenwuleibie" name="collectionsCategory">
								        	<option value="">请选择</option>
			                                    <c:forEach items="${ccList}" var="cc" varStatus="row">
													<option value="${cc.id}" >${cc.name}</option>
												</c:forEach>
		                                </select>
								    </span>
							    </div>
	                        </div>   
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 收藏单位：</label>
	                            <div class="formControls_spe ">
	                                <input type="text" class="input-text collectUnit" value="${org.name}" readonly="readonly" disabled="disabled">
	                                <input type="hidden" name="collectionUnit" class="input-text" value="${org.id }">
	                            </div>
	                        </div>  
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 年代：</label>
	                            <div class="formControls_spe">
		                            <span class="select-box">
		                            	<select class="select niandai" name="yearType">
		                            		<option value="">请选择</option>
			                            	<c:forEach items="${ytList}" var="yt" varStatus="row">
												<option value="${yt.id}" >${yt.name}</option>
											</c:forEach>
										</select>
									</span>
	                            </div>
	                        </div>	      
                    	</div>
                    	
                    	<div class="col-xs-12" style="margin-bottom: 50px;">
	                        <label class="form-label" style="text-align: left;"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品简介：</label>
	                        <textarea name="description" class="textarea cangpinjianjie">${collection.description }</textarea>
	                    </div>	
                        
 						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">收藏单位编号：</label>
	                            <div class="formControls">
	                                <input type="text" name="dwid" class="input-text" value="">
	                            </div>
	                            <!--<div class=" col-xs-2"></div>-->
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">藏品编号类型：</label>
	                            <div class="formControls">
	                            	<span class="select-box">
								        <select class="select cangpinNumType" name="gsCollectionsNoType">
								        	<option value="">请选择</option>
	                                        <option value="藏品总登记号">藏品总登记号</option>
	                                        <option value="辅助账号">辅助账号</option>
	                                    </select>
								    </span>
	                            </div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">藏品编号：</label>
	                            <div class="formControls" style="width: 189px;">
	                                <input type="text" name="gsCollectionsNo" class="input-text cangpinNum" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    	
	                    </div>
                    	
                    	<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">原名：</label>
	                            <div class="formControls">
	                                <input type="text" name="formerly" class="input-text yuanming" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    
	                        
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">具体年代：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsSpecificYear" class="input-text" value="">
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">文物来源：</label>
	                            <div class="formControls "  style="width: 189px;">
	                            	<span class="select-box">
		                            	<select class="select" name="gsSource">
		                            		<option value="">请选择</option>
											<option value="征集购买"  >征集购买</option>
											<option value="接受捐赠"  >接受捐赠</option>
											<option value="依法交换"  >依法交换</option>
											<option value="拨交"  >拨交</option>
											<option value="移交"  >移交</option>
											<option value="旧藏" >旧藏</option>
											<option value="发掘"  >发掘</option>
											<option value="采集"  >采集</option>
											<option value="拣选"  >拣选</option>
											<option value="其他"  >其他</option>
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
		                            	<select class="select zhidiType"  name="gsTextureCategory">
	                            		<option value="">请选择</option>
										<option value="单一质地">单一质地</option>
										<option value="复合或组合质地" >复合或组合质地</option>
									</select>
									</span>
	                            </div>
	                        </div>		
	                        
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">质地：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsTexture" class="input-text" value="${collection.gsTexture }">
	                            </div>
	                            <%-- <div class="form-label ">
	                            	<span class="">
		                            	<select class="select" id="ms" multiple="multiple" name="gsTextureSubcategories">
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
											<option value="木" <c:if test="${'木' eq collection.gsTextureSubcategories}">selected</c:if> >木</option>
										</select>
									</span>
	                            </div> --%>
	                   		</div>						
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3" >质地子类别:</label>
	                            <div class="form-label formControls"  style="width: 189px;">
	                            	<span class="select-box">
		                            	<select class="select zhidiziType" name="gsTextureSubcategories">
	                            		<option value="">请选择</option>
										<option value="有机质" >有机质</option>
										<option value="无机质"  >无机质</option>
										<option value="有机复合或组合"  >有机复合或组合</option>
										<option value="无机复合或组合"  >无机复合或组合</option>
										<option value="有机无机复合或组合"  >有机无机复合或组合</option>
									</select>
									</span>
	                            </div>
	                        </div>						
						</div>
						
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_1">通长:</label>
						        <div class="formControls">
						            <input type="text" class="input-text ckg tongchang" value="">
						            <input type="text" name="gsLength" class="input-text" value="0" hidden>
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_2">通宽:</label>
						        <div class="formControls">
						            <input type="text" class="input-text ckg tongkuan" value="">
						            <input type="text" name="gsWidth" class="input-text" value="0" hidden>
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
						        <label class="form-label label_3">通高:</label>
						        <div class="formControls" style="width: 189px;">
						            <input type="text" class="input-text ckg tonggao" value="">
						            <input type="text" name="gsHeight" class="input-text" value="0" hidden>
						        </div>
							</div>							
						</div>

						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">具体尺寸：</label>
	                            <div class="formControls ">
	                                <input type="text" name="size" class="input-text" value="">
	                            </div>
	                        </div>						
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">包含文物数量：</label>
	                            <div class="form-label formControls">
	                            	<span class="select-box">
		                            	<select class="select" name="actualQuantityUnit">
		                            		<option value="">请选择</option>
											<option value="单件"  >单件</option>
											<option value="一套多件"  >一套多件</option>
										</select>
									</span>
	                            </div>
	                        </div>	
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">实际数量：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text shijishuliang" value="" id = "trueNum">
                                	<input type="text" name="actualQuantity" class="input-text" value="1" hidden>
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                        
						</div>

						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">完残程度：</label>
	                            <div class="formControls ">
	                                <input type="text" name="endResidueLevel" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">入藏时间范围：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsEntryWarehouseTimeFrame" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">入藏年度：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" name="gsEntryWarehouseYear" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
						</div>

						<div class="col-xs-12" style="margin-bottom: 20px;">
	                		<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">保存状态：</label>
	                            <div class="formControls ">
	                            	<span class="select-box">
		                            	<select class="select" name="gsStorageState" >
		                            		<option value="">请选择</option>
											<option value="状态稳定，不需修复"  >状态稳定，不需修复</option>
											<option value="部分损腐，需要修复"  >部分损腐，需要修复</option>
											<option value="腐蚀损毁严重，急需修复"  >腐蚀损毁严重，急需修复</option>
											<option value="已修复"  >已修复</option>
										</select>
									</span>
	                            </div>
	                        </div>
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">著者：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsAuthor" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3" >版本：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" name="gsVersion" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                    </div>
						
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">质量范围：</label>
	                            <div class="formControls ">
	                                <input type="text" name="massRange" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">具体质量：</label>
	                            <div class="formControls">
	                                <input type="text" name="mass" class="input-text" value="" style="width: 50px;float: left;">
									<select class="select" name="massUnit" style="width:85px;float: right;padding: 4px 0;">
	                            		<option value="">请选择</option>
										<option value="g" >g</option>
										<option value="kg" >kg</option>
									</select>	                                
	                            </div>
	                        </div>		
	                        
	                        
	                        
	                    	<div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">完残状况：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" name="endResidualCondition" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>						
						</div>
						
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                       	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">存卷：</label>
	                            <div class="formControls ">
	                                <input type="text" name="gsKeepOnFile" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>						
	                    	 <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">录入员：</label>
	                            <div class="formControls ">
	                                <input type="text" name="creator" class="input-text" value="">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>		
	                        <div class="col-md-4 col-xs-12 col-sm-6"  style="padding: 0;">
	                            <label class="form-label label_3" >审核员：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" name="assessor" class="input-text" value="">
	                            </div>
	                        </div>
	                        <div class="cl col-xs-8"></div>
						</div>
						
						<div class="col-xs-12" style="padding-bottom: 20px;border-bottom: 6px solid #f1f2f7;">
                            <label class="form-label label_2 fontgreen" style="width: 130px;">推荐为馆内精品：</label>
                            <div class="form-label formControls">
                                <div class="signl_check" style="width: 150px;">
                                    <div class="radio-box">
                                        <input type="radio" id="radio-1" name="isHighQuality" value="2" checked="checked" >
                                        <label for="radio-1">是</label>
                                    </div>
                                    <div class="radio-box">
                                        <input type="radio" id="radio-2" value="1" name="isHighQuality" checked="checked" >
                                        <label for="radio-2">否</label>
                                    </div>
                                </div>
                            </div>
						</div>
						
						<div style="clear: both"></div>
						
                    </div>
                    
                    <div class="zj_add_message">
	            		<span>
	            			音频讲解词
	            		</span>
	            	</div>
	            	<div class="zj_add_audio">
	            		<span id="myaudio">
	            			<i class="Hui-iconfont">&#xe600;</i>
	            			添加音频
	            		</span>
	            		<audio src="" controls></audio>
	            		<input type="text" class="input-text hidden" name="fAudio" value="" id="upload_audio">
	            	</div>
	            	<div class="zj_add_message">
	            		<span>
	            			三维信息
	            		</span>
	            	</div>
	            	<div class="zj_add_3d">
                        <label style="float: left;">三维藏品地址： </label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
                            <input type="text" class="input-text" name="threeDimensionalCollection" value="" placeholder="URL地址">
                        </div>	            	
	            	</div>
	            	<div class="zj_add_message">
	            		<span>
	            			环拍信息
	            		</span>
	            	</div>
	            	<div class="zj_add_3d" style="margin-bottom: 50px;">
                        <label style="float: left;">环拍信息地址： </label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
							<input type="text" class="input-text" name="ringBeatData" value="" placeholder="URL地址">
                        </div>	            	
	            	</div>
                    
                    
                    <!--<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">收藏单位：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text collectUnit" value="${org.name}" readonly="readonly" disabled="disabled">
                                <input type="hidden" name="collectionUnit" class="input-text" value="${org.id }">
                            </div>
                        </div>
                        <div class="row cl  col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">收藏单位编号：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="dwid" class="input-text" value="">
                            </div>
                        </div>
                        <div class="row cl  col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">普查编号：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsNo" class="input-text puchaNum" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>-->
                    <!--第二行开始-->
                    <!--<div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">藏品编号：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsCollectionsNo" class="input-text cangpinNum" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">藏品编号类型：</label>
                            <div class="formControls col-xs-6">
                            	<span class="select-box">
							        <select class="select cangpinNumType" name="gsCollectionsNoType">
							        	<option value="">请选择</option>
                                        <option value="藏品总登记号">藏品总登记号</option>
                                        <option value="辅助账号">辅助账号</option>
                                    </select>
							    </span>
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">原名：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="formerly" class="input-text yuanming" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>-->
                    <!--第三行开始-->
                    <!--<div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6"><span class="c-red">*</span>名称：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="name" class="input-text mingcheng" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6"><span class="c-red">*</span>文物类别：</label>
                            <div class="formControls col-xs-6">
	                            <span class="select-box">
							        <select class="select wenwuleibie" name="collectionsCategory">
							        	<option value="">请选择</option>
	                                      <c:forEach items="${ccList}" var="cc" varStatus="row">
											  <option value="${cc.id}" >${cc.name}</option>
										  </c:forEach>
	                                </select>
							    </span>
						    </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6"><span class="c-red">*</span>年代：</label>
                            <div class="form-label col-xs-6">
	                            <span class="select-box">
	                            	<select class="select niandai"  name="yearType">
	                            		<option value="">请选择</option>
		                            	<c:forEach items="${ytList}" var="yt" varStatus="row">
											<option value="${yt.id}" >${yt.name}</option>
										</c:forEach>
									</select>
								</span>
                            </div>
                        </div>
                    </div>-->
                    <!--第四行开始-->
                    <!--<div>
                    	<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">具体年代：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsSpecificYear" class="input-text" value="">
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质地类别：</label>
                            <div class="form-label col-xs-6">
	                            <span class="select-box">
	                            	<select class="select zhidiType"  name="gsTextureCategory">
	                            		<option value="">请选择</option>
										<option value="单一质地">单一质地</option>
										<option value="复合或组合质地" >复合或组合质地</option>
									</select>
								</span>
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质地子类别：</label>
                            <div class="form-label col-xs-6">
                            	<span class="select-box">
	                            	<select class="select zhidiziType" name="gsTextureSubcategories">
	                            		<option value="">请选择</option>
										<option value="有机质" >有机质</option>
										<option value="无机质"  >无机质</option>
										<option value="有机复合或组合"  >有机复合或组合</option>
										<option value="无机复合或组合"  >无机复合或组合</option>
										<option value="有机无机复合或组合"  >有机无机复合或组合</option>
									</select>
								</span>
                            </div>
                        </div>
                    </div>-->
                    <!--第五行开始-->
                    <!--<div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质地：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsTexture" class="input-text zhidi" value="">
                            </div>
                   		 </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">实际数量：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text shijishuliang" value="" id = "trueNum">
                                <input type="text" name="actualQuantity" class="input-text" value="1" hidden>
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">包含文物数量：</label>
                            <div class="form-label col-xs-6">
                            	<span class="select-box">
	                            	<select class="select" name="actualQuantityUnit">
	                            		<option value="">请选择</option>
										<option value="单件"  >单件</option>
										<option value="一套多件"  >一套多件</option>
									</select>
								</span>
                            </div>
                        </div>
                    </div>
                    <div>
                    	<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">具体尺寸：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="size" class="input-text" value="">
                            </div>
                        </div>
                    	<div class="row cl col-md-4 col-xs-12 col-sm-6">
						    <label class="form-label col-lg-6 col-xs-6">外形尺寸(cm)：</label>
						    <div class="col-lg-6  col-xs-6">
						        <label class="form-label col-xs-5">通长:</label>
						        <div class="formControls col-xs-7">
						            <input type="text" class="input-text ckg tongchang" value="">
						            <input type="text" name="gsLength" class="input-text" value="0" hidden>
						        </div>
						    </div>
						 </div>
						 <div class="row cl col-md-4 col-xs-12 col-sm-6">
						    <div class="col-lg-6 col-xs-6">
						        <label class="form-label col-xs-5">通宽:</label>
						        <div class="formControls col-xs-7">
						            <input type="text" class="input-text ckg tongkuan" value="">
						            <input type="text" name="gsWidth" class="input-text" value="0" hidden>
						        </div>
						    </div>
						    <div class="col-lg-6 col-xs-6">
						        <label class="form-label col-xs-5">通高:</label>
						        <div class="formControls col-xs-7">
						            <input type="text" class="input-text ckg tonggao" value="">
						            <input type="text" name="gsHeight" class="input-text" value="0" hidden>
						        </div>
						    </div>
						</div>
                    </div>
                    <div>
                    	<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质量范围：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="massRange" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">具体质量：</label>
                            <div class="formControls col-xs-3">
                                <input type="text" name="mass" class="input-text" value="">
                            </div>
                            <div class="formControls col-xs-3">
                            	<span class="select-box">
	                            	<select class="select" name="massUnit">
	                            		<option value="">请选择</option>
										<option value="g" >g</option>
										<option value="kg" >kg</option>
									</select>
								</span>
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">完残程度：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="endResidueLevel" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">完残状况：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="endResidualCondition" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">文物来源：</label>
                            <div class="formControls col-xs-6">
                            	<span class="select-box">
	                            	<select class="select" name="gsSource">
	                            		<option value="">请选择</option>
										<option value="征集购买"  >征集购买</option>
										<option value="接受捐赠"  >接受捐赠</option>
										<option value="依法交换"  >依法交换</option>
										<option value="拨交"  >拨交</option>
										<option value="移交"  >移交</option>
										<option value="旧藏" >旧藏</option>
										<option value="发掘"  >发掘</option>
										<option value="采集"  >采集</option>
										<option value="拣选"  >拣选</option>
										<option value="其他"  >其他</option>
									</select>
								</span>
                            </div>
                        </div>
                       <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">文物级别：</label>
                            <div class="formControls col-xs-6">
                            	<span class="select-box">
	                            	<select class="select" name="collectionLevel" >
	                            		<option value="">请选择</option>
										<option value="1"  >一级</option>
										<option value="2"  >二级</option>
										<option value="3"  >三级</option>
										<option value="4" >一般</option>
										<option value="5" >未定级</option>
									</select>
								</span>
                            </div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">保存状态：</label>
                            <div class="formControls col-xs-6">
                            	<span class="select-box">
	                            	<select class="select" name="gsStorageState" >
	                            		<option value="">请选择</option>
										<option value="状态稳定，不需修复"  >状态稳定，不需修复</option>
										<option value="部分损腐，需要修复"  >部分损腐，需要修复</option>
										<option value="腐蚀损毁严重，急需修复"  >腐蚀损毁严重，急需修复</option>
										<option value="已修复"  >已修复</option>
									</select>
								</span>
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">入藏时间范围：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsEntryWarehouseTimeFrame" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                       <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">入藏年度：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsEntryWarehouseYear" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">著者：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsAuthor" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">版本：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsVersion" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                       <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">存卷：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="gsKeepOnFile" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">录入员：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="creator" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                         <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">录入时间：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="createTime" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div>
                       <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">提交时间：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="submitTime" class="input-text" value="">
                            </div>
                            <div class="col-3"></div>
                        </div> 
                    </div>
                    <div class="row cl">
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">审核员：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" name="assessor" class="input-text" value="">
                            </div>
                        </div>
                        <div class="row cl col-xs-8"></div>
                     </div>
                    <%-- <div class="row cl">
						 <label class="form-label col-xs-3 col-sm-2">审核员：</label>
							<div class="formControls col-xs-6 col-sm-9">
                                <input type="text" name="assessor" class="input-text" value="${collection.assessor }">
                            </div>
                        </div>
                    </div> --%>
					<div class="row cl">
						 	<label class="form-label col-xs-3 col-sm-2"><span class="c-red">*</span>藏品简介：</label>
							<div class="formControls col-xs-6 col-sm-9">
                               <textarea name="description" class="textarea cangpinjianjie"></textarea>
                           	</div>
                    </div>
                   <%--  <div>
                        <div class="row cl col-xs-12" style="margin-left: 1.5rem;">
                            <label class="form-label col-xs-1">备注：</label>
                            <div class="formControls col-xs-10">
                                <textarea name="remark" class="textarea">${collection.remark }</textarea>
                            </div>
                        </div>
                    </div> --%>
                    <div>
                        <div class="row col-md-12 col-xs-12 col-sm-12">
                            <div class="row col-md-4 col-xs-12 col-sm-6">
                                <label class="form-label col-xs-7 fontgreen">推荐为馆内精品：</label>
                                <div class="form-label col-xs-5">
                                    <div class="signl_check">
                                        <div class="radio-box">
                                            <input type="radio" id="radio-1" name="isHighQuality" value="2" checked="checked" >
                                            <label for="radio-1">是</label>
                                        </div>
                                        <div class="radio-box">
                                            <input type="radio" id="radio-2" value="1" name="isHighQuality" checked="checked" >
                                            <label for="radio-2">否</label>
                                        </div>
                                    </div>
                                </div>
                        	</div>
                    	</div>
                    </div>
                    <%-- <div>
                        <div class = "row col-md-12 col-xs-12 col-sm-12">
                            <div class="row col-md-4 col-xs-12 col-sm-6">
                                <label class="form-label col-xs-6 fontgreen">是否公开：</label>
                                <div class="form-label col-xs-6">
                                    <div class="signl_check">
                                        <div class="radio-box">
                                            <input type="radio" id="radio-3" name="isOpen" value="2" <c:if test="${'2' eq collection.isOpen}">checked</c:if>>
                                            <label for="radio-3">是</label>
                                        </div>
                                        <div class="radio-box">
                                            <input type="radio" id="radio-4" name="isOpen" value="1" <c:if test="${'1' eq collection.isOpen}">checked</c:if>>
                                            <label for="radio-4">否</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> --%>-->
                    <!--保存取消按钮开始-->
                   <!--  <div class="row cl col-xs-10 col-sm-12 col-offset-1">
                        <button class="btn btn-primary radius mr-10 saveinfo">保存</button>
                        <button class="btn btn-danger radius">取消</button>
                    </div> -->
	                <!--<div class="button_wrap" style="padding-left:115px;padding-top:30px;">
	                     <span class="btn-upload c">
	                         <a id = "saveTabOne" class="btn btn-primary radius saveinfo" style="margin-right: 1.5rem;background: #369593;color:#ffffff">保存</a>
	                     </span>
	                     <span class="btn-upload c">
	                         <a href="javascript:history.go(-1);" class="btn btn-danger radius">取消</a>
	                     </span>
	                </div>-->

            </div>
            
            <!-- 第二个tab -->
                <div class="tabCon" id="secondTab">
                	<div class="zj_add_message">
                		<span>
                			藏品图片
                		</span>
                	</div>
             		<span id="mypicture">
            			<i class="Hui-iconfont">&#xe600;</i>
            			上传图片
            		</span>
                	
                	
                 	<!--<a href="#" class="btn btn-primary radius col-md-5 mt-20" id="mypicture"><i class="Hui-iconfont">&#xe642;</i> 上传图片</a>-->
                    <!--<p style="line-height: 30px;" id="pictureMsg" class="msg audio hidden"><i class="Hui-iconfont pt-5" style="font-size: 16px;color: #00CC44">&#xe6a8;</i></p>-->
                   <!--  <input type="file" value="上传"> -->
                    <div class="portfolio-content">
        	            <ul class="cl portfolio-area" id="pictureUL">
	                    			 <%--<li class="item box-size">
                                        <div class="clo"></div>
		                                <div class="portfoliobox box-size">
		                                    <div class="picbox box-size">
		                                        <a href="<%=request.getContextPath()%>/${pic.url }" data-lightbox="gallery" data-title="${pic.name }" ><img src="<%=request.getContextPath()%>/${pic.url }" class="size-XXL"></a>
		                                    </div>
		                                    <div style="margin-top: -20px;"><span style="padding-left: 10px;">${pic.name }</span>
												<c:if test="${'1' eq pic.isMain }">
		                                    		<button pic_id="${pic.id }" class="btn btn-primary size-MINI r btnMain" style="margin-right: 10px;margin-top: -3px">设为主图</button>
												</c:if>
												<c:if test="${'2' eq pic.isMain }">
		                                    		<input type="hidden" pic_main="${pic.id }" class="pic_main" >
												</c:if>
		                                    </div>
		                                    <input type="text" class="input-text hidden" name="pictureId" value="" id="pictureId">
		                                </div>
		                            </li>--%>
	                    </ul>
                </div>
                    <%-- <h3>藏品前台图片</h3>
                    <c:forEach items="${pictures}" var="pic" varStatus="row">
                    		<c:if test="${pic.isMain eq 2 }">
		                      <div class="portfolio-content">
		                        <ul class="cl portfolio-area">
		                            <li class="item box-size">
		                                <div class="portfoliobox box-size">
		                                    <div class="picbox box-size">
		                                        <a href="<%=request.getContextPath()%>/${pic.thumb1}" data-lightbox="gallery" data-title="藏品缩略图640x426"><img src="<%=request.getContextPath()%>/${pic.thumb1}" style="max-width: inherit;max-height: inherit;width:280px;height:190px;margin-top: -20px;"></a>
		                                    </div>
		                                    <div style="margin-top: -20px;"><span style="padding-left: 10px;">藏品缩略图640x426</span></div>
		                                </div>
		                            </li>
		                            <li class="item box-size-L">
		                                <div class="portfoliobox box-size-L">
		                                    <div class="picbox box-size-L">
		                                        <a href="<%=request.getContextPath()%>/${pic.thumb2}" data-lightbox="gallery" data-title="藏品缩略图278x${pic.thumb2Height }"><img src="<%=request.getContextPath()%>/${pic.thumb2}" style="max-width: inherit;max-height: inherit;width:246px;height:166px;margin-top: -20px;"></a>
		                                    </div>
		                                    <div style="margin-top: -20px;"><span style="padding-left: 20px;">藏品缩略图278x${pic.thumb2Height }</span></div>
		                                </div>
		                            </li>
		                            <li class="item box-size-M">
		                                <div class="portfoliobox box-size-M">
		                                    <div class="picbox box-size-M">
		                                        <a href="<%=request.getContextPath()%>/${pic.thumb3}" data-lightbox="gallery" data-title="藏品缩略图192x128"><img src="<%=request.getContextPath()%>/${pic.thumb3}" style="max-width: inherit;max-height: inherit;width:212px;height:142px;margin-top: -20px;"></a>
		                                    </div>
		                                    <div style="margin-top: -20px;"><span style="padding-left: 10px;">藏品缩略图192x128</span></div>
		                                </div>
		                            </li>
		                        </ul>
		                    </div>
						</c:if>
                   	</c:forEach> --%>

                </div>
            <!-- 第三个tab -->
                <!--<div class="tabCon cl">
                     <div class="row pt-20 clearfix">
                        <label for="" class="col-xs-4 col-sm-3 col-md-2 text-r">藏品简介：</label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
                            <textarea  class="textarea" name="" cols="" rows=""  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！"></textarea>
                        </div>
                    </div> 
                    <div class="row clearfix pt-10">
                        <label class="col-xs-4 col-sm-3 col-md-2 text-r">三维藏品：</label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
                            <input type="text" class="input-text" name="threeDimensionalCollection" value="" placeholder="URL地址">
                        </div>
                    </div>
                    <div class="row clearfix pt-10">
                        <label class="col-xs-4 col-sm-3  col-md-2 text-r">环拍数据：</label>
                        <div class="col-xs-8 col-sm-9 col-md-8">
                            <input type="text" class="input-text" name="ringBeatData" value="" placeholder="URL地址">
                        </div>
                    </div>
                    <div class="row cl">
                        <label class="col-xs-4 col-sm-3  col-md-2 text-r">视频介绍：</label>
                        <div class="formControls col-xs-8 col-sm-8 col-md-9">
                        <video src="" controls="controls"></video>
                            <a href="#" class="btn btn-primary radius col-md-5" id="myvideo"><i class="Hui-iconfont">&#xe642;</i> 添加视频</a>
                            <p style="line-height: 30px;" id="videoMsg" class="msg video hidden"><i class="Hui-iconfont pt-5" style="font-size: 16px;color: #00CC44">&#xe6a8;</i></p>
                            
                        </div>
                        <input type="text" class="input-text hidden" name="fVideo" value="" id="upload_video">
                    </div>

                    <div class="row cl">
                        <label class="col-xs-4 col-sm-3 text-r col-md-2">音频介绍：</label>
                        <div class="formControls col-xs-8 col-sm-9 col-md-8">
                        	<audio src="" controls></audio>
                            <a href="#" class="btn btn-primary radius col-md-5" id="myaudio"><i class="Hui-iconfont">&#xe642;</i> 添加音频</a>
                            <p style="line-height: 30px;" id="audioMsg" class="msg audio hidden"><i class="Hui-iconfont pt-5" style="font-size: 16px;color: #00CC44">&#xe6a8;</i></p>
                            
                        </div>
                        <input type="text" class="input-text hidden" name="fAudio" value="" id="upload_audio">
                    </div>

                     <div class="button_wrap" style="padding-left:115px;padding-top:30px;">
                         <span class="btn-upload c">
                             <a id="saveTabThree" class="btn btn-primary radius saveinfo" style="margin-right: 1.5rem;background: #369593;color:#ffffff">保存</a>
                         </span>
                        <span class="btn-upload c">
                             <a href="javascript:history.go(-1);" class="btn btn-danger radius">取消</a>
                         </span>
                    </div>
                </div>-->
            </div>
        </form>
        
        <!--视频遮罩层开始-->
        <form id="uploadFormVideo" enctype="multipart/form-data" method="post" >
	         <div id="coverVideo">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="row cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="videoTitle">请选择视频文件：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadVideo" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntVideo">
		    			 </span>
	                 </div>
	             </div>
	             <div class="row cl text-c pd-40">
	             	<input type="button" id="uploadVideo_button" value="上传" class="btn btn-primary radius upload">
	                 <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" value="重置" />
	             </div>
	         </div>
         </form>
         
         <!--音频遮罩层开始-->
        <form id="uploadFormAudio" enctype="multipart/form-data" method="post" >
	         <div id="coverAudio">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="row cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="audioTitle">请选择音频文件：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadAudio" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntAudio">
		    			 </span>
	                 </div>
	             </div>
	             <div class="row cl text-c pd-40">
	             	<input type="button" id="uploadAudio_button" value="上传" class="btn btn-primary radius upload">
	                 <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" value="重置" />
	             </div>
	         </div>
         </form>
         
         <!--图片遮罩层开始-->
        <form id="uploadFormPic" enctype="multipart/form-data" method="post" >
	         <div id="coverPic">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="row cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="cTitle">请选择图片：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="" id="uploadPic" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntPic">
		         			<input type="hidden" name="objectId" value="${collection.id }">
		         			<input type="hidden" name="typeId" value="3">
		    			 </span>
	                 </div>
	             </div>
	             <div class="row cl text-c pd-40">
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
    		
    		$("#picture").click();
    		
    	})
    	
    	
        $("#head").load("headerServe.html");
    });
    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");
    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,8]}// 不参与排序的列
        ]
    });
</script>
<script type="text/javascript">
    $(function(){
        $.Huihover(".portfolio-area li");
    });
</script>

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

<script>
    $(function(){
    	$("#save").click(function(){
    		$("#saveStatus").val("1");
            if($(".mingcheng").val() == ""){
                layer.open({
                title: '提示',
                content: '名称不能为空'
                });
            return false;
            }
            else if($(".niandai").val() == ""){
                layer.open({
                title: '提示',
                content: '年代不能为空'
                });
            return false;
            }
            else if($(".wenwuleibie").val() == ""){
                layer.open({
                title: '提示',
                content: '文物类别不能为空'
                });
            return false;
            }
            else if($(".cangpinjianjie").val() == ""){
                layer.open({
                title: '提示',
                content: '藏品简介不能为空'
                });
            return false;
            }
            else if(isNaN($(".tongchang").val())){
                layer.open({
                    title: '提示',
                    content: '通长只能为一个阿拉伯数字'
                });
                return false;
            }
            else if(isNaN($(".tongkuan").val())){
                layer.open({
                    title: '提示',
                    content: '通宽只能为一个阿拉伯数字'
                });
                return false;
            }
            else if(isNaN($(".tonggao").val())){
                layer.open({
                    title: '提示',
                    content: '通高只能为一个阿拉伯数字'
                });
                return false;
            }
            else{
                 var data = $('form#form-collection-add').serialize();
                 $.ajax({
                      url : "<%=request.getContextPath() %>/back/oCCollection/addOrUpdate.do",
                      type : "post",
                      data :  data,
                      dataType : "json",
                      success : function(data){
                      if(data){
                          layer.msg('保存成功', {icon: 1});
                          setTimeout(function(){
                              window.location.href = "${preUrl}";
                          },1000)
                      }else{
                          layer.msg('保存失败', {icon: 2});
                          }
                      },
                 })
            }
        })
        $("#saveTabOne").click(function(){
        	$("#saveStatus").val("2");
            if($(".mingcheng").val() == ""){
                layer.open({
                title: '提示',
                content: '名称不能为空'
                });
            return false;
            }
            else if($(".niandai").val() == ""){
                layer.open({
                title: '提示',
                content: '年代不能为空'
                });
            return false;
            }
            else if($(".wenwuleibie").val() == ""){
                layer.open({
                title: '提示',
                content: '文物类别不能为空'
                });
            return false;
            }
            else if($(".cangpinjianjie").val() == ""){
                layer.open({
                title: '提示',
                content: '藏品简介不能为空'
                });
            return false;
            }
            else if(isNaN($(".tongchang").val())){
                layer.open({
                    title: '提示',
                    content: '通长只能为一个阿拉伯数字'
                });
                return false;
            }
            else if(isNaN($(".tongkuan").val())){
                layer.open({
                    title: '提示',
                    content: '通宽只能为一个阿拉伯数字'
                });
                return false;
            }
            else if(isNaN($(".tonggao").val())){
                layer.open({
                    title: '提示',
                    content: '通高只能为一个阿拉伯数字'
                });
                return false;
            }
            else{
                 var data = $('form#form-collection-add').serialize();
                 $.ajax({
                      url : "<%=request.getContextPath() %>/back/oCCollection/addOrUpdate.do",
                      type : "post",
                      data :  data,
                      dataType : "json",
                      success : function(data){
                      if(data){
                          layer.msg('保存成功', {icon: 1});
                          setTimeout(function(){
                              window.location.href = "${preUrl}";
                          },1000)
                      }else{
                          layer.msg('保存失败', {icon: 2});
                          }
                      },
                 })
            }
        })
    });
</script>

<script type="text/javascript">
$(function(){
	$('#saveTabThree').click(function() {
		var data = $('form#form-collection-add').serialize();
		$.ajax({
			url : "<%=request.getContextPath() %>/back/oCCollection/addOrUpdate.do",
			type : "post",
			data :  data,
			dataType : "json",
			success : function(data){
				if(data){
					layer.msg('保存成功', {icon: 1});
					setTimeout(function(){
						window.location.href = "${preUrl}";
					},1000)
				}else{
					layer.msg('保存失败', {icon: 2});
				}
			},
		})
	});
});
</script>

<!-- 上传视频功能 -->
<script type="text/javascript">
$(function(){
	$("#uploadVideo_button").click(function() {
		 var formData = new FormData($( "#uploadFormVideo" )[0]);
		$.ajax({
			url : "<%=request.getContextPath() %>/file/uploadVideo.do",
			type : "post",
			data :  formData,
			dataType:"json",
			 async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
            success: function (data) {
                if(data.error == 1){
                	layer.msg(data.message, {icon: 2});
                }
                if(data.error == 0){
                   /* alert(data.url); */
                   layer.msg('[OK]上传成功', {icon: 1});
                   $("#upload_video").attr("value",data.url);
                   $("video").attr("src",data.src);
                   setTimeout(function(){
                	   $("#coverVideo").slideUp(300);
                	   $("#uploadVideo").val("");
                	   $("#accIntVideo").val("");
					},1000)
                  
                }
            },
		})
	});
});
//上传音频
$(function(){
	$("#uploadAudio_button").click(function() {
		var audio = $("#accIntAudio").val();
		if(audio==""||audio==null){
			layer.msg('[ERROR]请选择音频文件', {icon: 2});
			return;
		}
		 var formData = new FormData($( "#uploadFormAudio" )[0]);
		$.ajax({
			url : "<%=request.getContextPath() %>/file/uploadAudio.do",
			type : "post",
			data :  formData,
			dataType:"json",
			 async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
            success: function (data) {
                if(data.error == 1){
                	layer.msg(data.message, {icon: 2});
                }
                if(data.error == 0){
                   /* alert(data.url); */
                   layer.msg('[OK]上传成功', {icon: 1});
                   $("#upload_audio").attr("value",data.url);
                   $("audio").attr("src",data.src);
                   setTimeout(function(){
                	   $("#coverAudio").slideUp(300);
                	   $("#uploadAudio").val("");
                	   $("#accIntAudio").val("");
					},1000)
                }
            },
		})
	});
});
//上传图片
$(function(){
	$("#uploadPic_button").click(function() {
		 var formData = new FormData($( "#uploadFormPic" )[0]);
		$.ajax({
			url : "<%=request.getContextPath() %>/file/uploadPicture.do",
			type : "post",
			data :  formData,
			dataType:"json",
			async: false,  
          	cache: false,  
          	contentType: false,  
          	processData: false,  
            success: function (data) {
                if(data.error == 1){
                	layer.msg(data.message, {icon: 2});
                }
                if(data.error == 0){
                	$("#pictureUL").append(
                			'<li class="item box-size zj_add_imgLi">'
                            +'<div class="clo">x</div>'
                            +'<div class="portfoliobox box-size">'
                            +'<div class="picbox box-size">'
                            +'<a href="'+data.url+'" data-lightbox="gallery" data-title="'+data.picName+'" ><img src="'+data.url+'" class="size-XXL"></a>'
                            +'</div>'
                            +'<div style="margin-top: -20px;"><span style="padding-left: 10px;">'+data.picName+'</span>'
                            +'</div>'
                            +'<input type="text" class="input-text hidden" name="pictureIds" value="'+data.picId+'" id="pictureIds">'
                            +'</div>'
                            +'</li>');
                	
                   layer.msg('[OK]上传成功', {icon: 1});
                   setTimeout(function(){
						$.cookie('word_msg', '1'); 
					},1000);
                   $("#coverPic").slideUp(300);
                }
            },
		})
	});
});
</script>

<!-- 分页功能 -->
<script type="text/javascript">
	var nums = ${page.size};			
	var pages = ${page.totalPage}; 		
	//调用分页
	laypage({
	    cont: 'page',
	    pages: pages,
	    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
	        var page = location.search.match(/page=(\d+)/);
	        return page ? page[1] : 1;
	    	}(), 
	   	skip: true, //是否开启跳页
	   	skin: '#72CDAE', //皮肤
	   	groups: 3, //连续显示分页数
	    jump: function(e, first){ //触发分页后的回调
	       if(!first){ //一定要加此判断，否则初始时会无限刷新
	         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
	       }
	    }
	})
</script>

<script type="text/javascript">
$(function(){
	if($.cookie('word_msg')=='1'){
		$.cookie('word_msg', null); 
		$('#word_msg').click();
	}
	$(".btnMain").click(function(){
		var pic_id = $(this).attr('pic_id');
		var c_id = ${collection.id };
		var index=window.location.href.indexOf('#');
		var href;
		if(index>0)
			href=window.location.href.substr(0,index)+"#word_msg";
		else
			href=window.location.href+"#word_msg";
		$.ajax({
			url : "<%=request.getContextPath()%>/back/oCCollection/setMain.do",
			type : "post",
			data :  {picId : pic_id, collectionId : c_id},
			dataType : "json",
			success : function(data){
				if(data){
					layer.msg('更换主图成功', {icon: 1});
					setTimeout(function(){
						$.cookie('word_msg', '1'); 
						location.reload(true);
					},1000)
				}else{
					layer.msg('更换主图失败', {icon: 2});
				}
			},
		});
		return false;
	});
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
    //提交表单验证


</script>

<!-- <script>
    $(function() {
        $('#ms').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '100%'
        });
    });
</script> -->

<script>
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
           }else if(result == "0"){
               layer.msg('删除失败', {icon: 2});
           }else{
               layer.msg('此图片不允许被删除', {icon: 2});
           }
        })
    })
</script>

<!--/请在上方写此页面业务相关的脚本-->
	
</body>
</html>