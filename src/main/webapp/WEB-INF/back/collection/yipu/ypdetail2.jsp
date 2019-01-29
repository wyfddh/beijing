<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <title>一普数据编辑</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
	<style>
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
        .zj_detail_title{
        	font-size: 18px;
        	color: black;
        }
        .zj_detail_btn{
        	float: right !important;
        	width: 216px;
        }
        .zj_detail_btn a:nth-child(1){
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
        .zj_detail_btn a:nth-child(2){
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
        
        .zj_detail_btn img{
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
        .zj_detail_message{
        	width: 100%;
        	padding: 24px 0;
        	border-bottom: 1px solid #f1f2f7;
        	margin-bottom: 13px;
        }
        .zj_detail_message>span{
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
        .zj_detail_content div{
        	padding: 0 24px 0 0;
        	text-align: left !important;
        }
        .zj_detail_content label{
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
        .zj_detail_content span,input{
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
        .zj_detail_audio{
        	padding-bottom: 18px;
        	border-bottom: 6px solid #f1f2f7;
        }
        
        .zj_detail_audio>span:nth-child(1){
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
        .zj_detail_audio>span:nth-child(1)>i{
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
        
        .zj_detail_3d{
        	padding: 19px 0;
        	border-bottom: 6px solid #f1f2f7;
        }
        .zj_detail_3d:after{
        	content: ".";
        	display: block;
        	opacity: 0;
        	visibility: hidden;
        	height: 0;
        	clear: both;
        }
        .zj_detail_imgLi{
        	margin: 0 30px 0 0 !important;
        	height: 109px !important;
        	
        }
        .zj_detail_imgLi>div{
        	padding: 0 !important;
        	width: 163px !important;
        	height: 109px !important;
        	border: none !important;
        }
        
        
        
        .zj_detail_imgLi>div>div:nth-child(1){
        	width: 163px !important;
        	height: 109px !important;
        }
        .zj_detail_imgLi img{
        	display: block;
        	width: 163px !important;
        	max-width: 163px !important;
        	height: 109px !important;        	
        }
        .zj_detail_imgBtn{
        	padding: 6px !important;
        	border-radius: 5px;
        	font-size: 11px;
        	line-height: 11px;
        	height: auto !important;
        }		
		
		
	</style>
</head>
<body>

<section class="Hui-article-box section_box">
    <div id="content_warp">
        <form action="" method="post" class="form form-horizontal" id="form-category-add">
            <div id="tab-category" class="HuiTab">
                <div class="tabBar cl">
                	<span id="word_msg">字段信息</span>
                	<span id="picture">化石图片</span>
                </div>
                
                
                <!--第二个列表页开始-->
                <div class="tabCon">
                	<div class="zj_detail_message">
                		<span>
                			基本信息
                		</span>
                	</div>
                	
                    <!--第一行开始-->
                    <div class="zj_detail_content">
                    	<div class="col-xs-12" style="padding: 0;margin-bottom: 25px;">
                    		<div class="col-md-3 col-xs-12 col-sm-6">
                    			<c:forEach items="${pictures}" var="pic" varStatus="row">
	                    			<c:if test="${row.index==0}">
		                    			<img src="${pic.url }" class="size-XXL">
	                    			</c:if>
	                    			<c:if test="${fn:length(pictures)<1}">
	                    				<img src="<%=request.getContextPath() %>/back/images/default_img.png" class="size-XXL">
	                    			</c:if>
                    			</c:forEach>
                    			

                    		</div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品名称：</label>
	                            <div class="formControls_spe">
	                                <input type="text" class="input-text" value="${fossil.name }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物级别：</label>
	                            <div class="formControls_spe">
	                            	<c:if test="${'1' eq fossil.collectionLevel }">
	                                	<input type="text" class="input-text" value="珍贵" readonly="readonly">
	                                </c:if>
	                                <c:if test="${'2' eq fossil.collectionLevel }">
	                                	<input type="text" class="input-text" value="一般" readonly="readonly">
	                                </c:if>
	                                <c:if test="${'3' eq fossil.collectionLevel }">
	                                	<input type="text" class="input-text" value="其他" readonly="readonly">
	                                </c:if>
		                            </div>
	                        </div>                  		
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 普查编号：</label>
	                            <div class="formControls_spe ">
	                                <input type="text" class="input-text" value="${fossil.gsNo }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>                  		
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物类别：</label>
	                            <div class="formControls_spe ">
		                            <input type="text" class="input-text" value="${collectionCategory }" readonly="readonly">
							    </div>
	                        </div>   
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 收藏单位：</label>
	                            <div class="formControls_spe ">
	                                <input type="text" class="input-text" value="${mipOrganization }" readonly="readonly">
	                            </div>
	                        </div>  
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 年代：</label>
	                            <div class="formControls_spe">
		                            <input type="text" class="input-text" value="${fossil.yearType }" readonly="readonly">
	                            </div>
	                        </div>	      
                    	</div>
                    	
                    	<div class="col-xs-12" style="margin-bottom: 50px;">
	                        <label class="form-label" style="text-align: left;"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品简介：</label>
	                        <textarea class="textarea" readonly="readonly">${fossil.description }</textarea>
	                    </div>
                    	
                    	<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">收藏单位编号：</label>
	                            <div class="formControls">
	                                <input type="text" class="input-text" value="${fossil.dwId}" readonly="readonly">
	                            </div>
	                            <div class=" col-xs-2"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">藏品编号类型：</label>
	                            <div class="formControls">
	                            	<input type="text" class="input-text" value="${fossil.gsCollectionsNoType }" readonly="readonly">
	                            </div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">藏品编号：</label>
	                            <div class="formControls" style="width: 189px;">
	                                <input type="text" class="input-text" value="${fossil.gsCollectionsNo }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    	
	                    </div>
                    	
                    	<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">原名：</label>
	                            <div class="formControls">
	                                <input type="text" class="input-text" value="${fossil.formerly }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    
	                        
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">具体年代：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${fossil.gsSpecificYear }" readonly="readonly">
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">文物来源：</label>
	                            <div class="formControls "  style="width: 189px;">
	                            	<input type="text" class="input-text" value="${fossil.gsSource }" readonly="readonly">
	                            </div>
	                        </div>	                        
						</div>
						
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_1">通长:</label>
						        <div class="formControls">
						            <input type="text" class="input-text" value="${fossil.gsLength }" readonly="readonly">
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_2">通宽:</label>
						        <div class="formControls">
						            <input type="text" class="input-text" value="${fossil.gsLength }" readonly="readonly">
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
						        <label class="form-label label_3">通高:</label>
						        <div class="formControls" style="width: 189px;">
						            <input type="text" class="input-text" value="${fossil.gsLength }" readonly="readonly">
						        </div>
							</div>							
						</div>
                		
                		<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">具体尺寸：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${fossil.size }" readonly="readonly">
	                            </div>
	                        </div>						
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">包含文物数量：</label>
	                            <div class="form-label formControls">
	                            	<input type="text" class="input-text" value="${fossil.actualQuantityUnit }" readonly="readonly">
	                            </div>
	                        </div>	
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">实际数量：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text" value="${fossil.actualQuantity }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                        
						</div>

						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">保存状态：</label>
	                            <div class="formControls ">
	                            	<input type="text" class="input-text" value="${fossil.gsStorageState }" readonly="readonly">
	                            </div>
	                        </div>	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">入藏时间范围：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${fossil.gsEntryWarehouseTimeFrame }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">入藏年度：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text" value="${fossil.gsEntryWarehouseYear }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
						</div>
                		
                		<div class="col-xs-12" style="margin-bottom: 20px;">
	                       	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">采集地：</label>
	                            <div class="formControls ">
	                            	<input type="text" class="input-text" value="${fossil.collectionPlace }" readonly="readonly">
	                                <!--<input type="text" name="collectionPlace" class="input-text" value="">-->
	                            </div>
	                            <div class="col-3"></div>
	                        </div>						
	                    	 <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">录入员：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${fossil.creator }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>		
	                        <div class="col-md-4 col-xs-12 col-sm-6"  style="padding: 0;">
	                            <label class="form-label label_3" >审核员：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text" value="${fossil.assessor }" readonly="readonly">
	                            </div>
	                        </div>
	                        <div class="cl col-xs-8"></div>
						</div>
						
						<div class="col-xs-12" style="padding-bottom: 20px;border-bottom: 6px solid #f1f2f7;">
                            <label class="form-label label_2 fontgreen" style="width: 130px;">推荐为馆内精品：</label>
                            <div class="form-label formControls">
                                <div class="signl_check" style="width: 150px;">
                                    <div class="radio-box">
                                        <input type="radio" id="radio-1" name="demo-radio1" <c:if test="${'2' eq fossil.isHighQuality}">checked</c:if> disabled="disabled">
                                        <label for="radio-1">是</label>
                                    </div>
                                    <div class="radio-box">
                                        <input type="radio" id="radio-2" name="demo-radio1" <c:if test="${'1' eq fossil.isHighQuality}">checked</c:if> disabled="disabled">
                                        <label for="radio-2">否</label>
                                    </div>
                                </div>
                            </div>
						</div>
						
						<div style="clear: both"></div>

                    </div>
                    	
                    	
                   	<!--<div>
                    <div class="row col-md-4 col-xs-12 col-sm-6">
                        <label class="form-label col-xs-6">收藏单位：</label>
                        <div class="formControls col-xs-6">
                            <input type="text" class="input-text" value="${mipOrganization }" readonly="readonly">
                        </div>
                    </div>
                    <div class="row cl  col-md-4 col-xs-12 col-sm-6">
                        <label class="form-label col-xs-6">收藏单位编号：</label>
                        <div class="formControls col-xs-6">
                            <input type="text" class="input-text" value="${fossil.dwId }" readonly="readonly">
                        </div>
                    </div>
                    <div class="row cl  col-md-4 col-xs-12 col-sm-6">
                        <label class="form-label col-xs-6">普查编号：</label>
                        <div class="formControls col-xs-6">
                            <input type="text" class="input-text" value="${fossil.gsNo }" readonly="readonly">
                        </div>
                        <div class="col-3"></div>
                    </div>
                    <div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">藏品编号：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsCollectionsNo }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">藏品编号类型：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsCollectionsNoType }" readonly="readonly">
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">原名：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.formerly }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">名称：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.name }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">文物类别：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${collectionCategory }" readonly="readonly">
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">年代：</label>
                            <div class="form-label col-xs-6">
                               <input type="text" class="input-text col-xs-4" value="${yearTypeEon.name }" style="width:30%!important;margin-right:0.6rem" readonly="readonly">
                               <input type="text" class="input-text col-xs-4" value="${yearTypeEra.name }" style="width:30%!important;margin-right:0.6rem" readonly="readonly">
                               <input type="text" class="input-text col-xs-4" value="${yearTypeEpoch.name }" style="width:30%!important" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div>
                    	<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">具体年代：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsSpecificYear }" readonly="readonly">
                            </div>
                        </div>
                        <%-- <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质地：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsTexture }" readonly="readonly">
                            </div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质地类别：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsTextureCategory }" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">质地子类别：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsTextureSubcategories }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div> --%>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">数量：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.actualQuantityUnit }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">文物级别：</label>
                            <div class="formControls col-xs-6">
                                <c:if test="${'1' eq fossil.collectionLevel }">
                                	<input type="text" class="input-text" value="珍贵" readonly="readonly">
                                </c:if>
                                <c:if test="${'2' eq fossil.collectionLevel }">
                                	<input type="text" class="input-text" value="一般" readonly="readonly">
                                </c:if>
                                <c:if test="${'3' eq fossil.collectionLevel }">
                                	<input type="text" class="input-text" value="其他" readonly="readonly">
                                </c:if>
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                    	<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">具体尺寸：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.size }" readonly="readonly">
                            </div>
                        </div>
                    	<div class="row cl col-md-4 col-xs-12 col-sm-6">
						    <label class="form-label col-lg-6 col-xs-6">外形尺寸(cm)：</label>
						    <div class="col-lg-6  col-xs-6">
						        <label class="form-label col-xs-5">通长:</label>
						        <div class="formControls col-xs-7">
						            <input type="text" class="input-text" value="${fossil.gsLength }" readonly="readonly">
						        </div>
						    </div>
						 </div>
						 <div class="row cl col-md-4 col-xs-12 col-sm-6">
						    <div class="col-lg-6 col-xs-6">
						        <label class="form-label col-xs-5">通宽:</label>
						        <div class="formControls col-xs-7">
						            <input type="text" class="input-text" value="${fossil.gsLength }" readonly="readonly">
						        </div>
						    </div>
						    <div class="col-lg-6 col-xs-6">
						        <label class="form-label col-xs-5">通高:</label>
						        <div class="formControls col-xs-7">
						            <input type="text" class="input-text" value="${fossil.gsLength }" readonly="readonly">
						        </div>
						    </div>
						</div>
                    </div>
                    <div>
                    	<div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">采集地：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.collectionPlace }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">保藏方式：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsStorageType }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">来源方式：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsSource }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">入藏年度：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsEntryWarehouseYear }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">入藏时间范围：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsEntryWarehouseTimeFrame }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                       <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">录入员：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.creator }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                    	 <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">著者：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsAuthor }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">版本：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsVersion }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                       <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">存卷：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.gsKeepOnFile }" readonly="readonly">
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                    <div>
                        <div class="row col-md-4 col-xs-12 col-sm-6">
                            <label class="form-label col-xs-6">审核员：</label>
                            <div class="formControls col-xs-6">
                                <input type="text" class="input-text" value="${fossil.assessor }" readonly="readonly" style="width:200px;">
                            </div>
                        </div>
                        <div class="row cl col-xs-8"></div>
                    </div>
                    <%-- <div>
                        <div class="row col-md-12 col-xs-12 col-sm-12">
                            <div class="row col-md-4 col-xs-12 col-sm-6">
                                <label class="form-label col-xs-6 fontgreen">推荐为馆内精品：</label>
                                <div class="form-label col-xs-6">
                                        <div class="signl_check">
                                            <div class="radio-box">
                                                <input type="radio" id="radio-1" name="demo-radio1" <c:if test="${'2' eq fossil.isHighQuality}">checked</c:if> disabled="disabled">
                                                <label for="radio-1">是</label>
                                            </div>
                                            <div class="radio-box">
                                                <input type="radio" id="radio-2" name="demo-radio1" <c:if test="${'1' eq fossil.isHighQuality}">checked</c:if> disabled="disabled">
                                                <label for="radio-2">否</label>
                                            </div>
                                        </div>
                                </div>
                            </div>

                        </div>
                    </div> --%>
                    <%-- <div>
                        <div class = "row col-md-12 col-xs-12 col-sm-12">
                            <div class="row col-md-4 col-xs-12 col-sm-6">
                                <label class="form-label col-xs-6 fontgreen">是否公开：</label>
                                <div class="form-label col-xs-6">
                                    <div class="signl_check">
                                        <div class="radio-box">
                                            <input type="radio" id="radio-3" name="demo-radio2" <c:if test="${'2' eq fossil.isOpen}">checked</c:if> disabled="disabled">
                                            <label for="radio-1">是</label>
                                        </div>
                                        <div class="radio-box">
                                            <input type="radio" id="radio-4" name="demo-radio2" <c:if test="${'1' eq fossil.isOpen}">checked</c:if> disabled="disabled">
                                            <label for="radio-2">否</label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div> --%>
                    <%-- <div>
                        <div class="row cl col-xs-12" style="margin-left: 1.5rem;">
                            <label class="form-label col-xs-1">描述：</label>
                            <div class="formControls col-xs-10">
                                <textarea class="textarea">${fossil.remark }</textarea>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="row cl col-xs-12" style="margin-left: 1.5rem;">
                            <label class="form-label col-xs-1">备注：</label>
                            <div class="formControls col-xs-10">
                                <textarea class="textarea">${fossil.description }</textarea>
                            </div>
                        </div>
                    </div> --%>
                </div>-->
            	</div>
            	<div class="tabCon">
            		
            		<div class="zj_detail_message">
	            		<span>
	            			化石图片
	            		</span>
	            	</div>
	            	
	            	
	                <div class="portfolio-content">
	                    <ul class="cl portfolio-area">
	                    	<c:forEach items="${pictures}" var="pic" varStatus="row">
	                    			<li class="item zj_detail_imgLi">
	                    				<div></div>
		                                <div class="portfoliobox ">
		                                    <div class="picbox">
		                                        <a href="${pic.url }" data-lightbox="gallery" data-title="${pic.name }" ><img src="${pic.url }" class="size-XXL"></a>
		                                    </div>
		                                    <div style="margin-top:-13px;width:100%;text-align:center">${pic.name }</div>
		                                </div>
		                            </li>
	                    	</c:forEach>
	                    </ul>
	                </div>
            		
                    <!--<h3>化石藏品标准图</h3>
                    <div class="portfolio-content">
	                    <ul class="cl portfolio-area">
		                    <c:forEach items="${pictures}" var="pic" varStatus="row">
	                    			<li class="item">
		                                <div class="portfoliobox">
		                                    <div class="picbox">
		                                        <a href="${pic.url }" data-lightbox="gallery" data-title="${pic.name }" target="_blank"><img src="${pic.url }"></a>
		                                    </div>
		                                    <div style="margin-top:-13px;width:100%;text-align:center">${pic.name }</div>
		                                </div>
		                            </li>
		                    </c:forEach>
	                    </ul>
                    </div>-->
                    
                    
                    
                </div>
            </div>
        </form>
    </div>
</section>
<!--/_menu 左边slide导航结束-->
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>

<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function () {
    	$(".size-XXL").on("click",function(){
    		
    		$("#picture").click();
    		
    	})
    	
    	
        $("#head").load("header.jsp");
    });
    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");

</script>


<!-- <script type="text/javascript">
    $(function(){
        $.Huihover(".portfolio-area li");
    });
</script> -->
<!--/请在上方写此页面业务相关的脚本-->
	
</body>
</html>