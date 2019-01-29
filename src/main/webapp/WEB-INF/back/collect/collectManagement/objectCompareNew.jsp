<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/css/trendsManage.css" />
<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >

<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<title>版本变动信息</title>
<style type="text/css">
	.box:after{
		display: block;
		content: "";
		clear: both;
	}
	.box>div{
		width: 46%;
		height: 100%;
		margin-bottom: 20px;
	}
	.box{
		width: 1024px;
		margin: 0 auto;
	}
	.boxChild{
		float: left;
		height: 100px;
		width: 20px;
		margin-right: 5px;
	}
	.box-last{
		float: left;height: 100px;width: 20px;background: #33ccff;
	}
	.changeColor{
		background: #A5D0FF !important;
	}
	.hasd>div{
		height:36px;
		line-height: 36px;
		color:#505050;
		display:flex;
		background:#ffffff;
	}
	.hasd>div>span{
		width:60%;
		display:block;
		    text-align: center;
		  border-right: 1px solid #dadada;
    border-bottom: 1px solid #dadada;
	}
	.hasd>div>label{
		width:40%;
		display:block;
		border-right: 1px solid #dadada;
    border-bottom: 1px solid #dadada;
		text-align: center
	}
</style>
</head>
<body>
	<div class="box">
		<div class="boxChild">
			<div style="width: 100%;height: 30px;background: #ffffff;text-align: center;font-size:18px;">${contentNow.version}</div>
			<div style="width: 100%;height: 200px;background: #5E6161;" align="center">
				<img alt="" src="${contentNow.imageUrl}" style="height: 100%;">
			</div>
			<div class="hasd">
				<c:if test="${contentNow.name!=contentNext.name}">
					<div class="changeColor"><label>藏品名称：</label><span>${contentNow.name}</span></div>
				</c:if>
				<c:if test="${contentNow.name==contentNext.name}">
					<div id="name"><label>藏品名称：</label><span>${contentNow.name}</span></div>
				</c:if>
				
				<c:if test="${contentNow.formerly!=contentNext.formerly}">
					<div class="changeColor"><label>原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label><span>${contentNow.formerly}</span></div>
				</c:if>
				<c:if test="${contentNow.formerly==contentNext.formerly}">
					<div id="formerly"><label>原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label><span>${contentNow.formerly}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsNo!=contentNext.gsNo}">
					<div class="changeColor"><label>普查编号：</label> <span>${contentNow.gsNo}</span></div>
				</c:if>
				<c:if test="${contentNow.gsNo==contentNext.gsNo}">
					<div id="gsNo"><label>普查编号：</label> <span>${contentNow.gsNo}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsCollectionsnoType!=contentNext.gsCollectionsnoType}">
					<div class="changeColor"><label>藏品编号：</label> <span>${contentNow.gsCollectionsnoType}</span></div>
				</c:if>
				<c:if test="${contentNow.gsCollectionsnoType==contentNext.gsCollectionsnoType}">
					<div id="gsCollectionsnoType"><label>藏品编号：</label> <span>${contentNow.gsCollectionsnoType}</span></div>
				</c:if>
				
				<c:if test="${contentNow.dwid!=contentNext.dwid}">
					<div class="changeColor"><label>收藏单位编号：</label> <span>${contentNow.dwid}</span></div>
				</c:if>
				<c:if test="${contentNow.dwid==contentNext.dwid}">
					<div id="dwid"><label>收藏单位编号：</label> <span>${contentNow.dwid}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.organizationName!=contentNext.organizationName}">
					<div class="changeColor"><label>收藏单位：</label> <span>${contentNow.organizationName}</span></div>
				</c:if>
				<c:if test="${contentNow.organizationName==contentNext.organizationName}">
					<div id="organizationName"><label>收藏单位：</label> <span>${contentNow.organizationName}</span></div>
				</c:if>
				
				<c:if test="${contentNow.collectionLevel!=contentNext.collectionLevel}">
					<div class="changeColor"><label>文物级别：</label> <span>${contentNow.collectionLevel}</span></div>
				</c:if>
				<c:if test="${contentNow.collectionLevel==contentNext.collectionLevel}">
					<div id="collectionLevel"><label>文物级别：</label> <span>${contentNow.collectionLevel}</span></div>
				</c:if>
				
				<c:if test="${contentNow.collectionsCategory!=contentNext.collectionsCategory}">
					<div class="changeColor"><label>文物类别：</label> <span>${contentNow.collectionsCategory}</span></div>
				</c:if>
				<c:if test="${contentNow.collectionsCategory==contentNext.collectionsCategory}">
					<div id="collectionsCategory"><label>文物类别：</label> <span>${contentNow.collectionsCategory}</span></div>
				</c:if>
				
				<c:if test="${contentNow.yearType!=contentNext.yearType}">
					<div class="changeColor"><label>文物年代：</label> <span>${contentNow.yearType}</span></div>
				</c:if>
				<c:if test="${contentNow.yearType==contentNext.yearType}">
					<div id="yearType"><label>文物年代：</label> <span>${contentNow.yearType}</span></div>
				</c:if>
				<c:choose>    
					<c:when test="${contentNow.gsSpecificYear!=null&&contentNow.gsSpecificYear!=''}">
						<c:if test="${contentNow.gsSpecificYear!=contentNext.gsSpecificYear}">
							<div class="changeColor"><label>具体年代：</label> <span>${contentNow.gsSpecificYear}</span></div>
						</c:if>
						<c:if test="${contentNow.gsSpecificYear==contentNext.gsSpecificYear}">
							<div id="gsSpecificYear0"><label>具体年代：</label> <span>${contentNow.gsSpecificYear}</span></div>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${contentNow.yearType!=contentNext.yearType}">
							<div class="changeColor"><label>具体年代：</label> <span>${contentNow.yearType}</span></div>
						</c:if>
						<c:if test="${contentNow.yearType==contentNext.yearType}">
							<div id="yearType0"><label>具体年代：</label> <span>${contentNow.yearType}</span></div>
						</c:if>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsTexture!=contentNext.gsTexture}">
					<div class="changeColor"><label>质&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</label> <span>${contentNow.gsTexture}</span></div>
				</c:if>
				<c:if test="${contentNow.gsTexture==contentNext.gsTexture}">
					<div id="gsTexture"><label>质&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</label> <span>${contentNow.gsTexture}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsTextureCategory!=contentNext.gsTextureCategory}">
					<div class="changeColor"><label>质地类别：</label> <span>${contentNow.gsTextureCategory}</span></div>
				</c:if>
				<c:if test="${contentNow.gsTextureCategory==contentNext.gsTextureCategory}">
					<div id=gsTextureCategory><label>质地类别：</label> <span>${contentNow.gsTextureCategory}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsTextureSubcategories!=contentNext.gsTextureSubcategories}">
					<div class="changeColor"><label>质地子类别：</label> <span>${contentNow.gsTextureSubcategories}</span></div>
				</c:if>
				<c:if test="${contentNow.gsTextureSubcategories==contentNext.gsTextureSubcategories}">
					<div id="gsTextureSubcategories"><label>质地子类别：</label> <span>${contentNow.gsTextureSubcategories}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsLength!=contentNext.gsLength}">
					<div class="changeColor"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：</label> <span>${contentNow.gsLength}</span></div>
				</c:if>
				<c:if test="${contentNow.gsLength==contentNext.gsLength}">
					<div id="gsLength"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：</label> <span>${contentNow.gsLength}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsWidth!=contentNext.gsWidth}">
					<div class="changeColor"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宽：</label> <span>${contentNow.gsWidth}</span></div>
				</c:if>
				<c:if test="${contentNow.gsWidth==contentNext.gsWidth}">
					<div id="gsWidth"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宽：</label> <span>${contentNow.gsWidth}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsHeight!=contentNext.gsHeight}">
					<div class="changeColor"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高：</label> <span>${contentNow.gsHeight}</span></div>
				</c:if>
				<c:if test="${contentNow.gsHeight==contentNext.gsHeight}">
					<div id="gsHeight"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高：</label> <span>${contentNow.gsHeight}</span></div>
				</c:if>
				
				<c:if test="${contentNow.size!=contentNext.size}">
					<div class="changeColor"><label>具体尺寸：</label> <span>${contentNow.size}</span></div>
				</c:if>
				<c:if test="${contentNow.size==contentNext.size}">
					<div id="size"><label>具体尺寸：</label> <span>${contentNow.size}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.massRange!=contentNext.massRange}">
					<div class="changeColor"><label>质量范围：</label> <span>${contentNow.massRange}</span></div>
				</c:if>
				<c:if test="${contentNow.massRange==contentNext.massRange}">
					<div id="massRange"><label>质量范围：</label> <span>${contentNow.massRange}</span></div>
				</c:if>
				
				<c:if test="${contentNow.mass!=contentNext.mass}">
					<div class="changeColor"><label>具体质量：</label> <span>${contentNow.mass}</span></div>
				</c:if>
				<c:if test="${contentNow.mass==contentNext.mass}">
					<div id="mass"><label>具体质量：</label> <span>${contentNow.mass}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsStorageState!=contentNext.gsStorageState}">
					<div class="changeColor"><label>保存状态：</label> <span>${contentNow.gsStorageState}</span></div>
				</c:if>
				<c:if test="${contentNow.gsStorageState==contentNext.gsStorageState}">
					<div id="gsStorageState"><label>保存状态：</label> <span>${contentNow.gsStorageState}</span></div>
				</c:if>
				
				<c:if test="${contentNow.endResidueLevel!=contentNext.endResidueLevel}">
					<div class="changeColor"><label>完残程度：</label> <span>${contentNow.endResidueLevel}</span></div>
				</c:if>
				<c:if test="${contentNow.endResidueLevel==contentNext.endResidueLevel}">
					<div id="endResidueLevel"><label>完残程度：</label> <span>${contentNow.endResidueLevel}</span></div>
				</c:if>
				
				<c:if test="${contentNow.endResidualCondition!=contentNext.endResidualCondition}">
					<div class="changeColor"><label>完残状况：</label> <span>${contentNow.endResidualCondition}</span></div>
				</c:if>
				<c:if test="${contentNow.endResidualCondition==contentNext.endResidualCondition}">
					<div id="endResidualCondition"><label>完残状况：</label> <span>${contentNow.endResidualCondition}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.actualQuantityUnit!=contentNext.actualQuantityUnit}">
					<div class="changeColor"><label>包含文物数量：</label> <span>${contentNow.actualQuantityUnit}</span></div>
				</c:if>
				<c:if test="${contentNow.actualQuantityUnit==contentNext.actualQuantityUnit}">
					<div id="actualQuantityUnit"><label>包含文物数量：</label> <span>${contentNow.actualQuantityUnit}</span></div>
				</c:if>
				
				<c:if test="${contentNow.actualQuantity!=contentNext.actualQuantity}">
					<div class="changeColor"><label>实际数量：</label> <span>${contentNow.actualQuantity}</span></div>	
				</c:if>
				<c:if test="${contentNow.actualQuantity==contentNext.actualQuantity}">
					<div id="actualQuantity"><label>实际数量：</label> <span>${contentNow.actualQuantity}</span></div>
				</c:if>
				
				
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsSource!=contentNext.gsSource}">
					<div class="changeColor"><label>文物来源：</label> <span>${contentNow.gsSource}</span></div>
				</c:if>
				<c:if test="${contentNow.gsSource==contentNext.gsSource}">
					<div id="gsSource"><label>文物来源：</label> <span>${contentNow.gsSource}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsEntryWarehouseTimeFrame!=contentNext.gsEntryWarehouseTimeFrame}">
					<div class="changeColor"><label>入藏时间范围：</label> <span>${contentNow.gsEntryWarehouseTimeFrame}</span></div>
				</c:if>
				<c:if test="${contentNow.gsEntryWarehouseTimeFrame==contentNext.gsEntryWarehouseTimeFrame}">
					<div id="gsEntryWarehouseTimeFrame"><label>入藏时间范围：</label> <span>${contentNow.gsEntryWarehouseTimeFrame}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsEntryWarehouseYear!=contentNext.gsEntryWarehouseYear}">
					<div class="changeColor"><label>入藏年度：</label> <span>${contentNow.gsEntryWarehouseYear}</span></div>
				</c:if>
				<c:if test="${contentNow.gsEntryWarehouseYear==contentNext.gsEntryWarehouseYear}">
					<div id="gsEntryWarehouseYear"><label>入藏年度：</label> <span>${contentNow.gsEntryWarehouseYear}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsAuthor!=contentNext.gsAuthor}">
					<div class="changeColor"><label>著&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</label> <span>${contentNow.gsAuthor}</span></div>f
				</c:if>
				<c:if test="${contentNow.gsAuthor==contentNext.gsAuthor}">
					<div id="gsAuthor"><label>著&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</label> <span>${contentNow.gsAuthor}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsVersion!=contentNext.gsVersion}">
					<div class="changeColor"><label>版&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本：</label> <span>${contentNow.gsVersion}</span></div>
				</c:if>
				<c:if test="${contentNow.gsVersion==contentNext.gsVersion}">
					<div id="gsVersion"><label>版&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本：</label> <span>${contentNow.gsVersion}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsKeepOnFile!=contentNext.gsKeepOnFile}">
					<div class="changeColor"><label>存&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卷：</label> <span>${contentNow.gsKeepOnFile}</span></div>
				</c:if>
				<c:if test="${contentNow.gsKeepOnFile==contentNext.gsKeepOnFile}">
					<div id="gsKeepOnFile"><label>存&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卷：</label> <span>${contentNow.gsKeepOnFile}</span></div>
				</c:if>
				
				<c:if test="${contentNow.creator!=contentNext.creator}">
					<div class="changeColor"><label>录&nbsp;入&nbsp;&nbsp;员：</label> <span>${contentNow.creator}</span></div>
				</c:if>
				<c:if test="${contentNow.creator==contentNext.creator}">
					<div id="creator"><label>录&nbsp;入&nbsp;&nbsp;员：</label> <span>${contentNow.creator}</span></div>
				</c:if>
				
				<c:if test="${contentNow.assessor!=contentNext.assessor}">
					<div class="changeColor"><label>审&nbsp;核&nbsp;&nbsp;员：</label> <span>${contentNow.assessor}</span></div>
				</c:if>
				<c:if test="${contentNow.assessor==contentNext.assessor}">
					<div id="assessor"><label>审&nbsp;核&nbsp;&nbsp;员：</label> <span>${contentNow.assessor}</span></div>
				</c:if>
				
				<c:if test="${contentNow.isHighQuality!=contentNext.isHighQuality}">
					<div class="changeColor"><label>馆内精品：</label> <span>${contentNow.isHighQuality}</span></div>
				</c:if>
				<c:if test="${contentNow.isHighQuality==contentNext.isHighQuality}">
					<div id="isHighQuality"><label>馆内精品：</label> <span>${contentNow.isHighQuality}</span></div>
				</c:if>
			</div>
		</div>
		<div class="box-last" style="">
			<div style="width: 100%;height: 30px;background: #ffffff;text-align: center;font-size:18px">${contentNext.version}</div>
			<div style="width: 100%;height: 200px;background: #5E6161;" align="center">
				<img alt="" src="${contentNext.imageUrl}" style="height: 100%;">
			</div>
			<div class="hasd">
				<c:if test="${contentNow.name!=contentNext.name}">
					<div class="changeColor"><label>藏品名称：</label><span>${contentNext.name}</span></div>
				</c:if>
				<c:if test="${contentNow.name==contentNext.name}">
					<div id="name1"><label>藏品名称：</label><span>${contentNext.name}</span></div>
				</c:if>
				
				<c:if test="${contentNow.formerly!=contentNext.formerly}">
					<div class="changeColor"><label>原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label><span>${contentNext.formerly}</span></div>
				</c:if>
				<c:if test="${contentNow.formerly==contentNext.formerly}">
					<div id="formerly1"><label>原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label><span>${contentNext.formerly}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsNo!=contentNext.gsNo}">
					<div class="changeColor"><label>普查编号：</label> <span>${contentNext.gsNo}</span></div>
				</c:if>
				<c:if test="${contentNow.gsNo==contentNext.gsNo}">
					<div id="gsNo1"><label>普查编号：</label> <span>${contentNext.gsNo}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsCollectionsnoType!=contentNext.gsCollectionsnoType}">
					<div class="changeColor"><label>藏品编号：</label> <span>${contentNext.gsCollectionsnoType}</span></div>
				</c:if>
				<c:if test="${contentNow.gsCollectionsnoType==contentNext.gsCollectionsnoType}">
					<div id="gsCollectionsnoType1"><label>藏品编号：</label> <span>${contentNext.gsCollectionsnoType}</span></div>
				</c:if>
				
				<c:if test="${contentNow.dwid!=contentNext.dwid}">
					<div class="changeColor"><label>收藏单位编号：</label> <span>${contentNext.dwid}</span></div>
				</c:if>
				<c:if test="${contentNow.dwid==contentNext.dwid}">
					<div id="dwid1"><label>收藏单位编号：</label> <span>${contentNext.dwid}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.organizationName!=contentNext.organizationName}">
					<div class="changeColor"><label>收藏单位：</label> <span>${contentNext.organizationName}</span></div>
				</c:if>
				<c:if test="${contentNow.organizationName==contentNext.organizationName}">
					<div id="organizationName1"><label>收藏单位：</label> <span>${contentNext.organizationName}</span></div>
				</c:if>
				
				<c:if test="${contentNow.collectionLevel!=contentNext.collectionLevel}">
					<div class="changeColor"><label>文物级别：</label> <span>${contentNext.collectionLevel}</span></div>
				</c:if>
				<c:if test="${contentNow.collectionLevel==contentNext.collectionLevel}">
					<div id="collectionLevel1"><label>文物级别：</label> <span>${contentNext.collectionLevel}</span></div>
				</c:if>
				
				<c:if test="${contentNow.collectionsCategory!=contentNext.collectionsCategory}">
					<div class="changeColor"><label>文物类别：</label> <span>${contentNext.collectionsCategory}</span></div>
				</c:if>
				<c:if test="${contentNow.collectionsCategory==contentNext.collectionsCategory}">
					<div id="collectionsCategory1"><label>文物类别：</label> <span>${contentNext.collectionsCategory}</span></div>
				</c:if>
				
				<c:if test="${contentNow.yearType!=contentNext.yearType}">
					<div class="changeColor"><label>文物年代：</label> <span>${contentNext.yearType}</span></div>
				</c:if>
				<c:if test="${contentNow.yearType==contentNext.yearType}">
					<div id="yearType1"><label>文物年代：</label> <span>${contentNext.yearType}</span></div>
				</c:if>
				
				<c:choose>    
					<c:when test="${contentNow.gsSpecificYear!=null&&contentNow.gsSpecificYear!=''}">
						<c:if test="${contentNow.gsSpecificYear!=contentNext.gsSpecificYear}">
							<div class="changeColor"><label>具体年代：</label> <span>${contentNow.gsSpecificYear}</span></div>
						</c:if>
						<c:if test="${contentNow.gsSpecificYear==contentNext.gsSpecificYear}">
							<div id="gsSpecificYear01"><label>具体年代：</label> <span>${contentNow.gsSpecificYear}</span></div>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${contentNow.yearType!=contentNext.yearType}">
							<div class="changeColor"><label>具体年代：</label> <span>${contentNow.yearType}</span></div>
						</c:if>
						<c:if test="${contentNow.yearType==contentNext.yearType}">
							<div id="yearType01"><label>具体年代：</label> <span>${contentNow.yearType}</span></div>
						</c:if>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsTexture!=contentNext.gsTexture}">
					<div class="changeColor"><label>质&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</label> <span>${contentNext.gsTexture}</span></div>
				</c:if>
				<c:if test="${contentNow.gsTexture==contentNext.gsTexture}">
					<div id="gsTexture1"><label>质&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</label> <span>${contentNext.gsTexture}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsTextureCategory!=contentNext.gsTextureCategory}">
					<div class="changeColor"><label>质地类别：</label> <span>${contentNext.gsTextureCategory}</span></div>
				</c:if>
				<c:if test="${contentNow.gsTextureCategory==contentNext.gsTextureCategory}">
					<div id="gsTextureCategory1"><label>质地类别：</label> <span>${contentNext.gsTextureCategory}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsTextureSubcategories!=contentNext.gsTextureSubcategories}">
					<div class="changeColor"><label>质地子类别：</label> <span>${contentNext.gsTextureSubcategories}</span></div>
				</c:if>
				<c:if test="${contentNow.gsTextureSubcategories==contentNext.gsTextureSubcategories}">
					<div id="gsTextureSubcategories1"><label>质地子类别：</label> <span>${contentNext.gsTextureSubcategories}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsLength!=contentNext.gsLength}">
					<div class="changeColor"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：</label> <span>${contentNext.gsLength}</span></div>
				</c:if>
				<c:if test="${contentNow.gsLength==contentNext.gsLength}">
					<div id="gsLength1"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：</label> <span>${contentNext.gsLength}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsWidth!=contentNext.gsWidth}">
					<div class="changeColor"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宽：</label> <span>${contentNext.gsWidth}</span></div>
				</c:if>
				<c:if test="${contentNow.gsWidth==contentNext.gsWidth}">
					<div id="gsWidth1"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宽：</label> <span>${contentNext.gsWidth}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsHeight!=contentNext.gsHeight}">
					<div class="changeColor"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高：</label> <span>${contentNext.gsHeight}</span></div>
				</c:if>
				<c:if test="${contentNow.gsHeight==contentNext.gsHeight}">
					<div id="gsHeight1"><label>通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高：</label> <span>${contentNext.gsHeight}</span></div>
				</c:if>
				
				<c:if test="${contentNow.size!=contentNext.size}">
					<div class="changeColor"><label>具体尺寸：</label> <span>${contentNext.size}</span></div>
				</c:if>
				<c:if test="${contentNow.size==contentNext.size}">
					<div id="size1"><label>具体尺寸：</label> <span>${contentNext.size}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.massRange!=contentNext.massRange}">
					<div class="changeColor"><label>质量范围：</label> <span>${contentNext.massRange}</span></div>
				</c:if>
				<c:if test="${contentNow.massRange==contentNext.massRange}">
					<div id="massRange1"><label>质量范围：</label> <span>${contentNext.massRange}</span></div>
				</c:if>
				
				<c:if test="${contentNow.mass!=contentNext.mass}">
					<div class="changeColor"><label>具体质量：</label> <span>${contentNext.mass}</span></div>
				</c:if>
				<c:if test="${contentNow.mass==contentNext.mass}">
					<div id="mass1"><label>具体质量：</label> <span>${contentNext.mass}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsStorageState!=contentNext.gsStorageState}">
					<div class="changeColor"><label>保存状态：</label> <span>${contentNext.gsStorageState}</span></div>
				</c:if>
				<c:if test="${contentNow.gsStorageState==contentNext.gsStorageState}">
					<div id="gsStorageState1"><label>保存状态：</label> <span>${contentNext.gsStorageState}</span></div>
				</c:if>
				
				<c:if test="${contentNow.endResidueLevel!=contentNext.endResidueLevel}">
					<div class="changeColor"><label>完残程度：</label> <span>${contentNext.endResidueLevel}</span></div>
				</c:if>
				<c:if test="${contentNow.endResidueLevel==contentNext.endResidueLevel}">
					<div id="endResidueLevel1"><label>完残程度：</label> <span>${contentNext.endResidueLevel}</span></div>
				</c:if>
				
				<c:if test="${contentNow.endResidualCondition!=contentNext.endResidualCondition}">
					<div class="changeColor"><label>完残状况：</label> <span>${contentNext.endResidualCondition}</span></div>
				</c:if>
				<c:if test="${contentNow.endResidualCondition==contentNext.endResidualCondition}">
					<div id="endResidualCondition1"><label>完残状况：</label> <span>${contentNext.endResidualCondition}</span></div>
				</c:if>
			</div>
			<div class="hasd">
				<c:if test="${contentNow.actualQuantityUnit!=contentNext.actualQuantityUnit}">
					<div class="changeColor"><label>包含文物数量：</label> <span>${contentNext.actualQuantityUnit}</span></div>
				</c:if>
				<c:if test="${contentNow.actualQuantityUnit==contentNext.actualQuantityUnit}">
					<div id="actualQuantityUnit1"><label>包含文物数量：</label> <span>${contentNext.actualQuantityUnit}</span></div>
				</c:if>
				
				<c:if test="${contentNow.actualQuantity!=contentNext.actualQuantity}">
					<div class="changeColor"><label>实际数量：</label> <span>${contentNext.actualQuantity}</span></div>	
				</c:if>
				<c:if test="${contentNow.actualQuantity==contentNext.actualQuantity}">
					<div id="actualQuantity1"><label>实际数量：</label> <span>${contentNext.actualQuantity}</span></div>
				</c:if>
				
				
			</div>
			<div class="hasd">
				<c:if test="${contentNow.gsSource!=contentNext.gsSource}">
					<div class="changeColor"><label>文物来源：</label> <span>${contentNext.gsSource}</span></div>
				</c:if>
				<c:if test="${contentNow.gsSource==contentNext.gsSource}">
					<div id="gsSource1"><label>文物来源：</label> <span>${contentNext.gsSource}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsEntryWarehouseTimeFrame!=contentNext.gsEntryWarehouseTimeFrame}">
					<div class="changeColor"><label>入藏时间范围：</label> <span>${contentNext.gsEntryWarehouseTimeFrame}</span></div>
				</c:if>
				<c:if test="${contentNow.gsEntryWarehouseTimeFrame==contentNext.gsEntryWarehouseTimeFrame}">
					<div id="gsEntryWarehouseTimeFrame1"><label>入藏时间范围：</label> <span>${contentNext.gsEntryWarehouseTimeFrame}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsEntryWarehouseYear!=contentNext.gsEntryWarehouseYear}">
					<div class="changeColor"><label>入藏年度：</label> <span>${contentNext.gsEntryWarehouseYear}</span></div>
				</c:if>
				<c:if test="${contentNow.gsEntryWarehouseYear==contentNext.gsEntryWarehouseYear}">
					<div id="gsEntryWarehouseYear1"><label>入藏年度：</label> <span>${contentNext.gsEntryWarehouseYear}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsAuthor!=contentNext.gsAuthor}">
					<div class="changeColor"><label>著&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</label> <span>${contentNext.gsAuthor}</span></div>f
				</c:if>
				<c:if test="${contentNow.gsAuthor==contentNext.gsAuthor}">
					<div id="gsAuthor1"><label>著&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</label> <span>${contentNext.gsAuthor}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsVersion!=contentNext.gsVersion}">
					<div class="changeColor"><label>版&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本：</label> <span>${contentNext.gsVersion}</span></div>
				</c:if>
				<c:if test="${contentNow.gsVersion==contentNext.gsVersion}">
					<div id="gsVersion1"><label>版&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本：</label> <span>${contentNext.gsVersion}</span></div>
				</c:if>
				
				<c:if test="${contentNow.gsKeepOnFile!=contentNext.gsKeepOnFile}">
					<div class="changeColor"><label>存&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卷：</label> <span>${contentNext.gsKeepOnFile}</span></div>
				</c:if>
				<c:if test="${contentNow.gsKeepOnFile==contentNext.gsKeepOnFile}">
					<div id="gsKeepOnFile1"><label>存&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卷：</label> <span>${contentNext.gsKeepOnFile}</span></div>
				</c:if>
				
				<c:if test="${contentNow.creator!=contentNext.creator}">
					<div class="changeColor"><label>录&nbsp;入&nbsp;&nbsp;员：</label> <span>${contentNext.creator}</span></div>
				</c:if>
				<c:if test="${contentNow.creator==contentNext.creator}">
					<div id="creator1"><label>录&nbsp;入&nbsp;&nbsp;员：</label> <span>${contentNext.creator}</span></div>
				</c:if>
				
				<c:if test="${contentNow.assessor!=contentNext.assessor}">
					<div class="changeColor"><label>审&nbsp;核&nbsp;&nbsp;员：</label> <span>${contentNext.assessor}</span></div>
				</c:if>
				<c:if test="${contentNow.assessor==contentNext.assessor}">
					<div id="assessor1"><label>审&nbsp;核&nbsp;&nbsp;员：</label> <span>${contentNext.assessor}</span></div>
				</c:if>
				
				<c:if test="${contentNow.isHighQuality!=contentNext.isHighQuality}">
					<div class="changeColor"><label>馆内精品：</label> <span>${contentNext.isHighQuality}</span></div>
				</c:if>
				<c:if test="${contentNow.isHighQuality==contentNext.isHighQuality}">
					<div id="isHighQuality1"><label>馆内精品：</label> <span>${contentNext.isHighQuality}</span></div>
				</c:if>
			</div>
		</div>
	</div>
<script>
	$(".boxChild>.hasd>div").hover(function(){
		var id = $(this).attr("id");
		$(this).css("background","#A5D0FF")
		$('#' +id + "1").css("background","#A5D0FF")
		//$(".box-last>.hasd>div").eq($(this).index()).css("background","#A5D0FF")
	},function(){
		var id = $(this).attr("id");
		$(this).css("background","#ffffff")
		$('#' +id +  "1").css("background","#ffffff")
		//$(".box-last>.hasd>div").eq($(this).index()).css("background","#ffffff")
	})
	
	$(".box-last>.hasd>div").hover(function(){
		var id = $(this).attr("id");
		$(this).css("background","#A5D0FF")
		id = id.substring(0, id.length-1);
		$('#' +id).css("background","#A5D0FF")
		//$(".box-last>.hasd>div").eq($(this).index()).css("background","#A5D0FF")
	},function(){
		var id = $(this).attr("id");
		id = id.substring(0, id.length-1);
		$(this).css("background","#ffffff")
		$('#' +id).css("background","#ffffff")
		//$(".box-last>.hasd>div").eq($(this).index()).css("background","#ffffff")
	})
</script>
</body>
</html>