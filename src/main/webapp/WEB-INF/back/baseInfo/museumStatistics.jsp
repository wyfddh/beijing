<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.io.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark"
	href="<%=request.getContextPath()%>/back/favicon.ico">
<link rel="Shortcut Icon"
	href="<%=request.getContextPath()%>/back/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/lib/layui/css/layui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/public.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/lib/zTree/v3/css/metroStyle/metroStyle.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/userMangermen/css/formSelects-v4.css" />
<style type="text/css">
ul.ztree {
	margin-top: 10px;
	width: 98%;
}
.layui-nav{
		background-color: #F4F4F4 !important;
 		color: #373737; 
	}
	.layui-nav cite{
 		color: #373737; 
	}
	.layui-nav a{
 		color: #373737 !important; 
	}
	.layui-nav-item:hover{
		background-color: #E1E1E1 !important;
	}
	.layui-nav-item a:hover{
		background-color: #E1E1E1 !important;
	}
	.layui-nav-tree .layui-this>a, .layui-nav-tree .layui-this>a:hover{
		background-color: #E1E1E1 !important;
	}
</style>


<!--/meta 作为公共模版分离出去-->
<style type="text/css">
.laytable-cell-1-titleImageSrc { /*最后的pic为字段的field*/
	height: 100%;
	/*max-width: 100%; */
}

.layui-elem-field {
	height: -webkit-fill-available;
}

body {
	min-width: 1200px;
}
</style>
<title>汇总查询</title>
</head>
<body class="childrenBody">
	<div class="layui-col-xs2">
		<div class="layui-elem-field" style="margin-right: 20px;">
			<div class="layui-collapse" lay-accordion="">
				<div class="layui-colla-item" id="myQuery">
					<h2 class="layui-colla-title">
						我的常用查询<i class="layui-icon layui-colla-icon"></i>
					</h2>
					<ul class="layui-colla-content layui-nav layui-nav-tree" style="height: 100%;width: 100%;" >
						<c:forEach items="${myQuery}" var ="li" varStatus="status">
							<li class="layui-nav-item item1">
								<a href="javascript:query('${li.queryTerms}','${li.queryOrgs}');"><cite>${li.queryName}</cite></a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="layui-colla-item" id="otherQuery">
					<h2 class="layui-colla-title">
						其他人的常用查询<i class="layui-icon layui-colla-icon"></i>
					</h2>
					<ul class="layui-colla-content layui-nav layui-nav-tree" style="height: 100%;width: 100%;" >
						<c:forEach items="${otherQuery}" var ="li" varStatus="status">
							<li class="layui-nav-item item1">
								<a href="javascript:query('${li.queryTerms}','${li.queryOrgs}');"><cite>${li.queryName}</cite></a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="layui-colla-item" style="border-color: rgba(255,255,255,.7);">
					<h2 class="layui-colla-title">
						自定义字段查询<i class="layui-icon layui-colla-icon"></i>
					</h2>
					<div class="layui-colla-content" style="padding: 5px 1px;">
						<input type="text" id="key" placeholder="请输入搜索" class="empty" style="width:98%; height:25px;"/><br/>
						<div class="zTreeDemoBackground left" style="width:98%; height:640px; overflow:auto;background-color:white;">
							<ul id="treeDemo" class="ztree" style=""></ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="layui-col-xs10">
		<form class="layui-form" id="roleForm">
			<blockquote class="layui-elem-quote quoteBox">
				<form class="layui-form">
					<div class="layui-inline" style="width: 100%;">
						<div class="layui-input-inline">
							<h3 id="select_tips">选择单位</h3>
						</div>
						<div class="layui-input-inline">
							<div>
								<div style="width: 600px; display: inline-block; vertical-align: top;">
									<select id="org" name="org" xm-select="select1" xm-select-search="">
										<option value="">全部</option>
									</select>
								</div>
							</div>
						</div>
						<button class="layui-btn search_btn search" type="button" name="search">搜索</button>
						<c:if test="${sessionScope.user.orgTypeId != 2 }" var="isShow">
							<input type="checkbox" name="flag" id="flag" lay-skin="primary" title="只看直属18家馆">
						</c:if>
					</div>
					<div class="layui-inline" style="width: 100%;">
						<div style="float:left">
							<a class="layui-btn layui-btn-primary" style="" id="save" onClick="openSave()">保存当前查询</a>
						    <a class="layui-btn "  onClick="exportToExcel()" style="margin-left:10px">导出</a>
						</div>
					</div>
				</form>
			</blockquote>
			<table class="layui-hide" id="dataList"></table>
		</form>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/lib/layui/layui.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/js/common.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/userMangermen/js/jquery.ztree.core.js"></script>		
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/userMangermen/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/userMangermen/js/jquery.ztree.exhide.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/userMangermen/js/fuzzysearch.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/userMangermen/js/formSelects-v4.js"></script>

	<script type="text/javascript">
		var	queryOrgs = "";
		var orgs = "";
		var queryTerms = "";
		//var	queryArr = [];
		var tableCols =new Array();
		var tableData;
		//左边ztree的初始化
		var appName = '<%=request.getContextPath()%>';
		var setting = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true,
                chkboxType : {
					"Y" : "",
					"N" : ""
				}
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: true
            },
            callback: {
            	beforeCheck: zTreeBeforeCheck, 
            	onCheck: onCheck
            }
        };
		function zTreeBeforeCheck(treeId, treeNode) {
			 if(treeNode.isParent){
				treeNode.chkDisabled = true;	
	 		    return false;   //当是父节点 返回false 不让选取
			 }else{
				 return true;
			 }
	 	}
		function onCheck(){			
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			//每次点击 清空数组
			tableCols.splice(0,tableCols.length);
			tableCols.push({field: 'col0',width:200,title: "组织名称",sort: true, fixed: 'left'})
			for(var i=0;i<nodes.length;i++){
				var field = nodes[i]["uniqueName"];
				var name = nodes[i]["name"];
				tableCols.push({field: field,title: name,sort: true})
	        }			
			tableCols = rep(tableCols);
			getQueryTerms();
			window.refresh();
		}
		
		//如果带了参数 则为点击常用查询进来的 默认选中树
		function backCheck(queryTerms){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			//隐藏 保存按钮
			$("#save").hide();
			//重新初始化tree(清空check)
			initNode_async();
			//回显 check
			var queryTermsArr = queryTerms.split(",");
			for(var i=0;i<queryTermsArr.length;i++){
				var node = treeObj.getNodeByParam("uniqueName",queryTermsArr[i]);
				if(node.checked!=true){
					treeObj.checkNode(node);
					treeObj.updateNode(node);
				}
			}
			var nodes = treeObj.getCheckedNodes(true);
			//每次点击 清空数组
			tableCols.splice(0,tableCols.length);
			tableCols.push({field: 'col0',title: "组织名称", sort: true, fixed: 'left'})
			for(var i=0;i<nodes.length;i++){
				var field = nodes[i]["uniqueName"];
				var name = nodes[i]["name"];
				tableCols.push({field: field,title: name,sort: true})
	        }
			tableCols = rep(tableCols);
			window.refresh();
		}
		
		var zNodes;
	    $(document).ready(function () {
	        initNode();
	    });
	     function initNode() {
	        $.ajax({
	            type: 'GET',
	            url:  appName+ "/cmsSubject/list.do?Pid=2",
	            dataType: "text",
	            success: function (data) {
	                var obj = eval('(' + data + ')');
	                zNodes = obj.data;
	                var t = $("#treeDemo");
	                t = $.fn.zTree.init(t, setting, zNodes);             
	            }
	        });
	    } 
	     
	     function initNode_async() {
		        $.ajax({
		            type: 'GET',
		            url:  appName+ "/cmsSubject/list.do?Pid=2",
		            dataType: "text",
		            async: false, 
		            success: function (data) {
		                var obj = eval('(' + data + ')');
		                zNodes = obj.data;
		                var t = $("#treeDemo");
		                t = $.fn.zTree.init(t, setting, zNodes);             
		            }
		        });
		    } 
  
	
	$(function(){	
		//每次点击 清空数组
		tableCols.splice(0,tableCols.length);
		tableCols.push({field: 'col0',width:200,title: "组织名称",sort: true, fixed: 'left'})
		layui.use(['form','layer','table', 'element'],function(){
			var form = layui.form,
		    layer = parent.layer === undefined ? layui.layer : top.layer,
		    $ = layui.jquery,
		    table = layui.table;
			window.refresh = function(){	
				//展示已知数据
				  table.render({
				    elem: '#dataList'
				    ,cols: [tableCols]
				    ,data: tableData
				    ,cellMinWidth: 100
				    //,skin: 'line' //表格风格
				    ,even: true //行间隔颜色深浅区分
				    ,page: true//是否显示分页
				    //,limits: [5, 7, 10]
				    //,limit: 5 //每页默认显示的数量
				  });
			}
		})
    	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
    	fuzzySearch('treeDemo','#key',null,true); //初始化模糊搜索方法
    	
    	//进来默认查一遍所有博物馆
    	$.ajax({
            type: 'post',
            url:  appName+ "/museuminfo/query.do",
            data:{"queryTerms":"","queryOrgs":"","type":"0"},
            success: function (data) {
              //展示已知数据
          	  tableData = data.data;
          	  window.refresh();  
            }
        });
    	var formSelects = layui.formSelects;	
    	formSelects.data('select1', 'server', {
    	    url: appName+ "/museuminfo/selectMuseum.do"
    	});
    	//初始化 先取了 直属馆 数据
    	getOrgs();
	})
	
	$(".search").click(function() {
		search();
	})
	function search(){	
		$("#save").show();
		getQueryTerms();
		//只看18家直属单位 
		if($("#flag").prop("checked")){
			//清空 下拉框	
			$(".icon-qingkong").click();
			queryOrgs = orgs;
		}else{
			queryOrgs = layui.formSelects.value('select1', 'valStr');
		}
	　　	$.ajax({
            type: 'post',
            url:  appName+ "/museuminfo/query.do",
            data:{"queryTerms":queryTerms,"queryOrgs":queryOrgs,"type":"0"},
            success: function (data) {
              //展示已知数据
          	  tableData = data.data;
          	  window.refresh();  
            }
        });
	}
	
	function query(Terms,Orgs){	
		//清空 下拉框	
		$(".icon-qingkong").click();
		$.ajax({
            type: 'post',
            url:  appName+ "/museuminfo/query.do",
            data:{"queryTerms":Terms,"queryOrgs":Orgs,"type":"0"},
            success: function (data) {
                 //展示已知数据
             	 tableData = data.data;
                 //参数带过去 回显选中左边树
             	 backCheck(Terms);
             	//赋值给 queryTerms queryOrgs
         		queryTerms = Terms;
         		queryOrgs = Orgs;
         		
            }
        });
	}
	
	function openSave(){
		var url = appName+ "/museuminfo/openSave.do?queryTerms="+queryTerms+"&queryOrgs="+queryOrgs+"&type=0";
	    layer.open({
	        type: 2,
	        title: '保存查询',
	        shadeClose: true,
	        shade: 0.5,
	        maxmin: true, //开启最大化最小化按钮
	        area: ['600px', '300px'],
	        content: [url,'no'],
	        end: function () {
	        	//刷新左边我的常用查询 复杂 暂时没做
	        }
	    });
	};
	
	function getQueryTerms(){
		var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
	    var nodes = treeObj.getCheckedNodes(true);
	　　	queryTerms = "";
	　　	var queryArr = [];　　	
	　　	for(var i=0;i<nodes.length;i++){
	　　		if(!queryArr.contain(nodes[i].uniqueName)){
		　　		queryArr.push(nodes[i].uniqueName);
	　　		}
	　　	}
	　　	queryArr.reArr();
	　　	for(var i=0;i<queryArr.length;i++){
	　　		queryTerms += queryArr[i]+",";
	　　	}
	　　	queryTerms = queryTerms.substr(0,queryTerms.length-1);
	}
	
	//获取直属馆  赋值给orgs
	function getOrgs(){		
		$.ajax({
            type: 'post',
            url:  appName+ "/museuminfo/getOrgs.do",
            data:{},
            success: function (data) {
            	orgs = data;           
            }
        });
	}

	//导出到excel
	window.exportToExcel = function() {
		var url = appName + '/museuminfo/export.do';	
		url += '?queryTerms='+queryTerms;
		url += '&queryOrgs='+queryOrgs;
		url += '&type=0';
		window.location.href = url;
	}
	
	
	var getSelectValue = function (){
		layui.formSelects.value('select1');              //取值默认数组
        layui.formSelects.value('select1', 'val');       //取值val数组
        layui.formSelects.value('select1', 'valStr');    //取值val字符串  ,拼接
        layui.formSelects.value('select1', 'name');      //取值name数组
        layui.formSelects.value('select1', 'nameStr');   //取值name字符串  ,拼接
	}
	//数组去重  只针对这里使用
	function rep(arr) {
	     var ret = new Array();
	     var cols = [];
	     for (var i = 0; i < arr.length; i++) {
	         if (!cols.contain(arr[i].field)) {
	             ret.push(arr[i]);
	             cols.push(arr[i].field);
	         }
	     }
	    return ret;
	 }
	//基本的数组去重
	Array.prototype.reArr = function(){
		var newArr = [];
		for(var i = 0; i < this.length; i++){
		    if(newArr.indexOf(this[i])== -1){
		        newArr.push(this[i]);
		    }
		 }
		 return newArr;
	}
	//数组contain
	Array.prototype.contain = function(val){
	     for (var i = 0; i < this.length; i++){
	       if (this[i] == val){
	       	  return true;
	      }
	     }
	     return false;
	}
	</script>
</body>
</html>