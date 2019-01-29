<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
	<title>藏品管理</title>
	<style>
		.laytable-cell-1-cpimg {
			height: 100%;
			max-width: 100%;
			position: relative;
		}
		.laytable-cell-1-cpimg img {
			max-width: 100%;
			max-height: 100%;
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
		}
		.laytable-cell-2-cpimg {
			height: 100%;
			max-width: 100%;
			position: relative;
		}
		.laytable-cell-2-cpimg img {
			max-width: 100%;
			max-height: 100%;
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
		}
    </style>
</head>
<body class="childrenBody">
<div class="layui-tab layui-tab-brief" lay-filter="changeTab">
  <ul class="layui-tab-title">
    <li class="layui-this">文物</li>
    <li>标本化石</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
		<form class="layui-form">
		    <blockquote class="layui-elem-quote quoteBox">
		        <form class="layui-form" id="formSearch" method="post">
		        	<div class="layui-row"> 
		        		<div class="layui-col-md4">
		                    <label class="layui-form-label" for="" >藏品名称：</label>
		                    <div class="layui-input-inline layui-col-md8">
		                        <input type="text" id="name"  name="name" placeholder="输入藏品名称" autocomplete="off" class="layui-input inputHead">
		                    </div>
                		</div>
                		<div class="layui-col-md4">
		                    <label class="layui-form-label" for="" >文物类别：</label>
		                    <div class="layui-input-inline layui-col-md8">
		                        <select name="collectionCategory" id="collectionCategory"  lay-search class="inputHead">  
							        <option value="">全部</option>
							        <c:forEach items="${collectionCategoryList}" var="cc" varStatus="row">
									<option value="${cc.id}">${cc.name}</option>
								</c:forEach>  
							      </select>
		                    </div>
                		</div>
		              </div> 
		             
			              <div class="layui-row" style="padding-top:20px;"> 
				               <c:if test="${level==1}">
				              	<div class="layui-col-md4">
				              		<label class="layui-form-label" for="" >收藏单位：</label>
				                    <div class="layui-input-inline layui-col-md8">
				                        <select name="collectionUnit" id="collectionUnit"  lay-search class="">  
									        <option value="">全部</option>
									        <c:forEach items="${organizationList}" var="cc" varStatus="row">
												<option value="${cc.id}">${cc.name}</option>
										</c:forEach>  
									      </select>
				                    </div>
			                    </div>
			                    </c:if>
			                    <div class="layui-col-md4">
			                    <label class="layui-form-label" for="" >常用年代：</label>
			                    <div class="layui-input-inline layui-col-md8">
			                        <select name="yearType" id="yearType"  lay-filter="yearTypeChange" lay-search class="inputHead">  
								        <option value="">全部</option>
											<option value="45">新石器时代</option>
											<option value="48">商</option>
											<option value="49">周</option>
											<option value="50">西周</option>
											<option value="51">东周</option>
											<option value="55">汉</option>
											<option value="56">西汉</option>
											<option value="57">东汉</option>
											<option value="79">唐</option>
											<option value="87">宋</option>
											<option value="93">元</option>
											<option value="94">明</option>
											<option value="95">清</option>
											<option value="96">民国</option>
											<option value="97">中华人民共和国</option>
								      </select>
			                    </div>
	                		</div>
	                		<div class="layui-col-md4">
			                    <label class="layui-form-label" for="" >其他年代：</label>
			                    <div class="layui-input-inline layui-col-md8">
			                        <select name="otherYearType" id="otherYearType" lay-filter="otherYearTypeChange" lay-search class="inputHead">  
								        <option value="">全部</option>
											<c:forEach items="${yearTypeList}" var="yt" varStatus="row">
												<c:if test="${yt.id != 45 && yt.id != 48 &&yt.id != 49 &&yt.id != 50 &&yt.id != 51 &&yt.id != 55 &&yt.id != 56 &&yt.id != 57 &&yt.id != 79 &&yt.id != 87 &&yt.id != 93 &&yt.id != 94 &&yt.id != 95 &&yt.id != 96 &&yt.id != 97}">
													<option value="${yt.id}">${yt.name}</option>
												</c:if>
											</c:forEach>
								      </select>
			                    </div>
	                		</div>
			            </div>
		              <div class="layui-row" style="padding-top:10px;"> 
                		<div class="layui-col-md3" style="padding-left:20px;">
		                    <button class="layui-btn search_btn" type="button" lay-submit lay-filter="search" id="search">搜索</button> 
					        <button type="reset" id="resetBtn"  class="layui-btn layui-btn-primary">重置</button> 
                		</div>
		              </div> 
		        </form> 
		        <input type="hidden" name="level" id="level" value="${level }">
		    </blockquote>
    		<table id="objectList" lay-filter="objectList"></table>
        <!--操作-->
	    	<script type="text/html" id="objectListBar">
    	  		<a class="layui-btn layui-btn-xs" lay-event="versionChange">版本变动情况</a>
			</script>    
         </form>
    </div>
    <div class="layui-tab-item">
    		<form class="layui-form">
		    <blockquote class="layui-elem-quote quoteBox">
		        <form class="layui-form" id="formSearch" method="post">
		        	<div class="layui-row"> 
		        		<div class="layui-col-md4">
		                    <label class="layui-form-label" for="" >藏品名称：</label>
		                    <div class="layui-input-inline layui-col-md8">
		                        <input type="text" id="nameFoss"  name="nameFoss"  placeholder="输入藏品名称" autocomplete="off" class="layui-input inputHead">
		                    </div>
                		</div>
                		<div class="layui-col-md4">
		                    <label class="layui-form-label" for="" >文物类别：</label>
		                    <div class="layui-input-inline layui-col-md8">
		                        <select name="collectionCategoryFoss" id="collectionCategoryFoss"  lay-search class="inputHead">  
							        <option value="">全部</option>
							        <c:forEach items="${collectionCategoryListFoss}" var="cc" varStatus="row">
									<option value="${cc.id}" >${cc.name}</option>
								</c:forEach>  
							      </select>
		                    </div>
                		</div>
                		
		              </div> 
		             
			           <div class="layui-row" style="padding-top:10px;"> 
			                 <c:if test="${level==1}">
			                 	<div class="layui-col-md4">
					              	<label class="layui-form-label" for="">收藏单位：</label>
				                    <div class="layui-input-inline layui-col-md8">
				                        <select name="collectionUnitFoss" id="collectionUnitFoss"  lay-search class="">  
									        <option value="">全部</option>
									        <c:forEach items="${organizationList}" var="cc" varStatus="row">
												<option value="${cc.id}">${cc.name}</option>
										</c:forEach>  
									      </select>
				                    </div>
			                    </div>
		                    </c:if>
		                    <div class="layui-col-md3">
		                    <label class="layui-form-label" for="">宙：</label>
		                    <div class="layui-input-inline layui-col-md6">
		                        <select name="yearTypeEon" id="yearTypeEon"  lay-filter="yearTypeEon" lay-search class="inputHead">  
							        <option value="">全部</option>
										<c:forEach items="${yearTypeEonList}" var="yt" varStatus="row">
											<option value="${yt.id}">${yt.name}</option>
										</c:forEach>
							      </select>
		                    </div>
                		</div>
                		<div class="layui-col-md2">
		                    <label class="layui-form-label" for=""  style="width:30px;">代：</label>
		                    <div class="layui-input-inline layui-col-md8">
		                        <select name="yearTypeEra" id="yearTypeEra"   lay-filter="yearTypeEra" lay-search class="inputHead">  
							        <option value="">全部</option>
							      </select>
		                    </div>
                		</div>
                		<div class="layui-col-md2">
		                    <label class="layui-form-label" for=""  style="width:30px;">纪：</label>
		                    <div class="layui-input-inline layui-col-md8">
		                        <select name="yearTypeEpoch" id="yearTypeEpoch"  lay-search class="inputHead">  
							        <option value="">全部</option>
							      </select>
		                    </div>
                		</div>
			          </div>
		              <div class="layui-row" style="padding-top:10px;"> 
                		<div class="layui-col-md3" style="padding-left:20px;">
		                    <button class="layui-btn search_btn" type="button" lay-submit lay-filter="searchFoss" id="searchFoss">搜索</button> 
					        <button type="reset" id="resetBtnFoss"  class="layui-btn layui-btn-primary">重置</button> 
                		</div>
		              </div> 
		              <input type="hidden" name="level" id="level" value="${level }">
		        </form> 
		    </blockquote>
    		<table id="objectFossList" lay-filter="objectFossList"></table>
        <!--操作-->
	    	<script type="text/html" id="objectListBar">
    	  		<a class="layui-btn layui-btn-xs" lay-event="versionChangeFoss">版本变动情况</a>
			</script>    
			
			<!-- 藏品图片 -->
			<script type="text/html" id="cpimg">
					<a  data-lightbox="gallery">
						<img  onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/null_pic-12491114727.jpg' " class="bbc" src="{{d.imageUrl}}" >
					</a>
		</script>
		<!-- 藏品图片 -->
			<script type="text/html" id="cpimg1">
					<a data-lightbox="gallery">
						<img onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/null_pic-12491114727.jpg' " class="bbc" src="{{d.imageUrl}}" >
					</a>
		    </script>
         </form>
    </div>
  </div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/object/objectChange.js"></script>
<script type="text/javascript">

</script>
</body>
</html>