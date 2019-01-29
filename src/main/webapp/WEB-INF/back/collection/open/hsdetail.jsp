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
	

    <title>化石详情</title>
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
		
		.zj_edit_btn{
        	float: right !important;
        	width:276px;
        }
       
        .zj_edit_btn a:nth-child(1){
        	display: block;
        	background-color: white;
        	color: #ffffff;
        	padding: 9px 24px;
        	border-radius: 5px;
        	text-decoration: none;
        	height: 18px;
        	line-height: 18px;
        	float: left;
        }        
        
        .zj_edit_btn img{
        	display: block;
        	float: left;
        	margin-right: 5px;
        }
	      .a_button{
			    display: block;
			    background-color: white;
			    color: #2a9bcf;
			    padding: 9px 24px;
			    border-radius: 5px;
			    text-decoration: none;
			    height: 18px;
			    line-height: 18px;
			    float: left;
			    text-align: center;
			    color: #ffffff;
			    font-size: 14px;
		}
		a{
			text-decoration: none;
		}
		.qx{
		 display: block;
		    background-color: white;
		    color: #2a9bcf  !important;
		    padding: 9px 24px;
		    border-radius: 5px;
		    text-decoration: none;
		    height: 18px;
		    line-height: 18px;
		    float: right !important;
		    text-align: center;
		    color: #ffffff;
		    font-size: 14px;
	}
	</style>
	
</head>
<body>
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section class="Hui-article-box section_box" >
    <div id="content_warp">
    	<div style="margin-bottom: 36px !important;">
	        <div class="button_wrap zj_edit_btn">
	        	<c:if test="${fn:contains(sessionScope.user.authStr,'SystemAdmin')==true and type eq '1'}">
					<c:if test="${fn:contains(sessionScope.user.level,1)  and collection.status eq '3'}">
						<a class="a_button" style="background: #5eb95e" href="javascript:void(0)" onclick="reviewObject('${collection.id}','4')">
			             	确定
			            </a>
			            <a style="margin-left: 10px;margin-right: 10px;background: #dd514c;" class="a_button"  href="javascript:void(0)" onclick="review('${collection.id}','1')">
			             	退回
			            </a>
					</c:if>
					<c:if test="${fn:contains(sessionScope.user.level,3) and collection.status eq '2'}">
						<a class="a_button" style="background: #5eb95e" href="javascript:void(0)" onclick="reviewObject('${collection.id}','3')">
			             	确定
			            </a>
			            <a style="margin-left: 10px;margin-right: 10px;background: #dd514c;" class="a_button"  href="javascript:void(0)" onclick="review('${collection.id}','1')">
			             	退回
			            </a>
					</c:if>
				</c:if>
	            <a class="qx" href="javascript:history.go(-1);">
	            	<img src="<%=request.getContextPath() %>/back/images/cancel.png"/>
	            	取消
	            </a>
	        </div>
		</div>  
    	<div style="margin-bottom: 36px !important;">
			<span class="zj_detail_title">查看化石</span>
		</div>   	
        <form action="" method="post" class="form form-horizontal" id="form-category-add">
            <div id="tab-category" class="HuiTab">
                <div class="tabBar cl">
                	<span id="pictureword_msg">字段信息</span>
                	<span id="word_msg">化石图片</span>
                </div>
                
                <!--第二个列表页开始-->
                <div class="tabCon">
                	<div class="zj_detail_message">
                		<span>
                			基本信息
                		</span>
                	</div>
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
	                                <input type="text" class="input-text" value="${collection.name }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	
	                        <div class="col-md-5 col-xs-12 col-sm-6" style="float: right;padding:0 0 0 24px;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 文物级别：</label>
	                            <div class="formControls_spe">
	                            	<c:if test="${'1' eq collection.collectionLevel }">
	                                	<input type="text" class="input-text" value="珍贵" readonly="readonly">
	                                </c:if>
	                                <c:if test="${'2' eq collection.collectionLevel }">
	                                	<input type="text" class="input-text" value="一般" readonly="readonly">
	                                </c:if>
	                                <c:if test="${'3' eq collection.collectionLevel }">
	                                	<input type="text" class="input-text" value="其他" readonly="readonly">
	                                </c:if>
	                            </div>
	                        </div>                  		
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;margin-bottom: 9px;">
	                            <label class="form-label label_4"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 普查编号：</label>
	                            <div class="formControls_spe ">
	                                <input type="text" class="input-text" value="${collection.gsNo }" readonly="readonly">
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
		                            <input type="text" class="input-text" value="${collection.yearType }" readonly="readonly">
	                            </div>
	                        </div>	      
                    	</div>
                		
                		<div class="col-xs-12" style="margin-bottom: 50px;">
	                        <label class="form-label" style="text-align: left;"><i style="color: red;font-style: normal;line-height: 19px;">* </i> 藏品简介：</label>
	                        <textarea class="textarea">${collection.description }</textarea>
	                    </div>	
                          <!--第一行-->
	                    <div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-6 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">公开设置：</label>
	                            <div class="formControls">
	                                <input type="radio" name="isOpen" value="2" <c:if test="${collection.isOpen==2 }">checked</c:if>/>已公开
	                                <input type="radio" name="isOpen" value="1" <c:if test="${collection.isOpen==1 }">checked</c:if>/>未公开
	                            </div>
	                            <!--<div class=" col-xs-2"></div>-->
	                        </div>
	                        <div class="col-md-6 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">馆际交流设置：</label>
	                            <div class="formControls">
	                            	<input type="radio" name="isBorrow" value="1" <c:if test="${collection.isBorrow==1 }">checked</c:if>/>可供借展
	                            	<input type="radio" name="isBorrow" value="0" <c:if test="${collection.isBorrow==0 }">checked</c:if>/>不可借展
	                            </div>
	                        </div>
	                    </div>
 						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">收藏单位编号：</label>
	                            <div class="formControls">
	                                <input type="text" class="input-text" value="${collection.dwid }" readonly="readonly">
	                            </div>
	                            <div class=" col-xs-2"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">藏品编号类型：</label>
	                            <div class="formControls">
	                            	<input type="text" class="input-text" value="${collection.gsCollectionsNoType }" readonly="readonly">
	                            </div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">藏品编号：</label>
	                            <div class="formControls" style="width: 189px;">
	                                <input type="text" class="input-text" value="${collection.gsCollectionsNo }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    	
	                    </div>
                		
                		<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">原名：</label>
	                            <div class="formControls">
	                                <input type="text" class="input-text" value="${collection.formerly }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                    
	                        
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">具体年代：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${collection.gsSpecificYear }" readonly="readonly">
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">文物来源：</label>
	                            <div class="formControls "  style="width: 189px;">
	                            	<input type="text" class="input-text" value="${collection.gsSource }" readonly="readonly">
	                            </div>
	                        </div>	                        
						</div>
						
						<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_1">通长:</label>
						        <div class="formControls">
						            <input type="text" class="input-text" value="${collection.gsLength }" readonly="readonly">
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6">
						        <label class="form-label label_2">通宽:</label>
						        <div class="formControls">
						            <input type="text" class="input-text" value="${collection.gsLength }" readonly="readonly">
						        </div>
							</div>
							<div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
						        <label class="form-label label_3">通高:</label>
						        <div class="formControls" style="width: 189px;">
						            <input type="text" class="input-text" value="${collection.gsLength }" readonly="readonly">
						        </div>
							</div>							
						</div>
                		
                		<div class="col-xs-12" style="margin-bottom: 20px;">
	                    	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">具体尺寸：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${collection.size }" readonly="readonly">
	                            </div>
	                        </div>						
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">包含文物数量：</label>
	                            <div class="form-label formControls">
	                            	<input type="text" class="input-text" value="${collection.actualQuantityUnit }" readonly="readonly">
	                            </div>
	                        </div>	
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">实际数量：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text" value="${collection.actualQuantity }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>	                        
						</div>

						<div class="col-xs-12" style="margin-bottom: 20px;">
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">保存状态：</label>
	                            <div class="formControls ">
	                            	<input type="text" class="input-text" value="${collection.gsStorageState }" readonly="readonly">
	                            </div>
	                        </div>	                        
	                        <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">入藏时间范围：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${collection.gsEntryWarehouseTimeFrame }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
	                        <div class="col-md-4 col-xs-12 col-sm-6" style="padding: 0;">
	                            <label class="form-label label_3">入藏年度：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text" value="${collection.gsEntryWarehouseYear }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>
						</div>
                		
                		<div class="col-xs-12" style="margin-bottom: 20px;">
	                       	<div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_1">采集地：</label>
	                            <div class="formControls ">
	                            	<input type="text" class="input-text" value="${collection.collectionPlace }" readonly="readonly">
	                                <!--<input type="text" name="collectionPlace" class="input-text" value="">-->
	                            </div>
	                            <div class="col-3"></div>
	                        </div>						
	                    	 <div class="col-md-4 col-xs-12 col-sm-6">
	                            <label class="form-label label_2">录入员：</label>
	                            <div class="formControls ">
	                                <input type="text" class="input-text" value="${collection.creator }" readonly="readonly">
	                            </div>
	                            <div class="col-3"></div>
	                        </div>		
	                        <div class="col-md-4 col-xs-12 col-sm-6"  style="padding: 0;">
	                            <label class="form-label label_3" >审核员：</label>
	                            <div class="formControls " style="width: 189px;">
	                                <input type="text" class="input-text" value="${collection.assessor }" readonly="readonly">
	                            </div>
	                        </div>
	                        <div class="cl col-xs-8"></div>
						</div>
						
						<div class="col-xs-12" style="padding-bottom: 20px;border-bottom: 6px solid #f1f2f7;">
                            <label class="form-label label_2 fontgreen" style="width: 130px;">推荐为馆内精品：</label>
                            <div class="form-label formControls">
                                <div class="signl_check" style="width: 150px;">
                                    <div class="radio-box">
                                        <input type="radio" id="radio-1" name="demo-radio1" <c:if test="${'2' eq collection.isHighQuality}">checked</c:if> disabled="disabled">
                                        <label for="radio-1">是</label>
                                    </div>
                                    <div class="radio-box">
                                        <input type="radio" id="radio-2" name="demo-radio1" <c:if test="${'1' eq collection.isHighQuality}">checked</c:if> disabled="disabled">
                                        <label for="radio-2">否</label>
                                    </div>
                                </div>
                            </div>
						</div>
						
						<div style="clear: both"></div>
                		
                	</div>
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
                    			<li class="item ">
	                                <div class="portfoliobox ">
	                                    <div class="picbox">
	                                        <a href="${pic.url }" data-lightbox="gallery" data-title="${pic.name }" ><img src="${pic.url }" class="size-XXL"></a>
	                                    </div>
	                                    <div style="margin-top:-13px;width:100%;text-align:center">${pic.name }</div>
	                                </div>
	                            </li>
                    	</c:forEach>
                    </ul>
                </div>-->
            </div>
        </form>
    </div>
</section>
<div id="comeBack" class="pl-30" style="display: none;">
	<h3 style='font-size:14px'>原因：</h3>
	<input type="hidden" value="${collection.id}" id="infoId">
	<textarea maxlength='50' placeholder='输入审核不通过的理由，50字以内.审核通过不需要填写' class='checkList_content' name='auditMsg'></textarea>
	<input type='button' class='zj_checkList_save' value='确认'>
	<input type='button' class='zj_checkList_cancel' value='取消' onclick='layer.closeAll()'>
</div>
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
    		
    		$("#word_msg").click();
    		
    	})
    	
    	
        $("#head").load("header.jsp");
    });
    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");

</script>
<script type="text/javascript">
    $(function(){
        $.Huihover(".portfolio-area li");
    });
    $(".zj_checkList_save").unbind().on("click",function(){
		var id = $("#infoId").val();
		var status = "1";
		var auditMsg=$(".checkList_content").val();  
		if((auditMsg==""||auditMsg==null)&&status==4){
			layer.msg('未填写审核信息', {icon: 2});
			return;
		}
		$.ajax({
            type : "post",
            async : true, //同步执行
            data :  {id:id,status:status,auditMsg:auditMsg},
            url : "<%=request.getContextPath() %>/back/oCCollection/reviewObject.do",
            dataType : "json", //返回数据形式为json
            success : function(result) {
            	console.log(result);
            	layer.msg('审核成功', {icon: 1});
				setTimeout(function(){
					window.location.href = "<%=request.getContextPath() %>/back/oCCollection/info.do?type=1";
				},1000)
            },
            error : function(errorMsg) {
            	console.log(errorMsg);
            }
        });
	});
    function reviewObject(id,status){
		var content="您确定该信息审核通过吗？";
		layer.confirm(content, {
	        btn: ['确定','取消'] //按钮
	    }, function(index){
			$.ajax({
	            type : "post",
	            async : true, //同步执行
	            data :  {id:id,status:status},
	            url : "<%=request.getContextPath() %>/back/oCCollection/reviewObject.do",
	            dataType : "json", //返回数据形式为json
	            success : function(result) {
	            	console.log(result);
	            	layer.msg('审核成功', {icon: 1});
					setTimeout(function(){
						window.location.href = "<%=request.getContextPath() %>/back/oCCollection/info.do?type=1";
					},1000)
	            },
	            error : function(errorMsg) {
	            	console.log(errorMsg);
	            }
	        });
		}, function(index){
	        layer.close(index);  //关闭弹出层
	    });
	}
	function review(id,status){
		$("#infoId").val(id);
		layer.open({
			type: 1,
			title: '回退原因',
			shadeClose: true,
			shade: 0.5,
			area: ['600px', '470px'],
			content: $("#comeBack"),
		});
	}
</script>

<!--/请在上方写此页面业务相关的脚本-->
	
</body>
</html>