<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@include file="/designContext/unified.jsp"%>
<div class="col-sm-3 tree-ber-po" style="padding-left: 0; display: block;">
	<div class="tree-ber-shou">
		<img src="designPlug-in/ace/assets/avatars/home-images/btn_l.png" />
	</div>
	<div class="tree-ber" style="display: block;height: 800px;">
		<div class="input-icon"style=" margin: 3px 5px;"> 														
			<input type='text' id='searchtree' style="width:95%;"  placeholder="请输入关键字搜索" />
		</div>
		<div id="tree2" class="ztree" style="width:100%;height:780px;overflow:auto;border:0px solid #000;padding:0px;"></div>
		<input type="hidden" name="mainId" id="mainId" />
	</div>
</div>
<div class="col-sm-9" id="right_" style="padding-right: 12px;height: 800px;">
<t:layuiTable name="tSBaseParameterList" pageSize="${cgformBuss.pageSize }" 
	pagination="${cgformBuss.isPage=='Y'?'true':'false' }"  initSort="${cgformBuss.initSort }" limits="${cgformBuss.limits }"
	tableTitleUrl="listPageGenController.do?getListTitle&bussCode=${bussCode }"
	tableQueryUrl="listPageGenController.do?getQueryList&bussCode=${bussCode }"
	tableDataUrl="listPageGenController.do?getListData&bussCode=${bussCode }"
 	bussCode="${bussCode }" isCheckbox="${cgformBuss.isCheckbox=='Y'?'true':'false' }"
 	isIndex="${ cgformBuss.isIndex=='Y'?'true':'false' }"
 	tableHeight="300"
 	onLoadSuccess="reloadData" >
  <t:layuiButton title="添加数据源" operationCode="addBackMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="addBackMain"></t:layuiButton>
  <t:layuiButton title="编辑数据源" operationCode="updateBackMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="updateBackMain"></t:layuiButton>
  <t:layuiButton title="删除数据源" operationCode="deleteSelectMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?doBatchDel&type=page&releaseCode=${bussCode }" funname="deleteSelectMain"></t:layuiButton>
  <t:layuiButton title="添加字段" operationCode="addMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="addMain"></t:layuiButton>
  
  <t:layuiTableBar title="编辑字段" operationCode="edit" icon="layui-btn layui-btn-xs"   url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="updateMain"></t:layuiTableBar>
  <t:layuiTableBar title="删除" operationCode="del"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="deleteSelect"></t:layuiTableBar>
  <%-- <t:layuiTableBar operationCode="detail" title="查看" icon="layui-btn layui-btn-primary layui-btn-xs"   url="aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode=${bussCode }" funname="detail"></t:layuiTableBar> --%>
</t:layuiTable>
	<div class="col-sm-12" style="padding-left: 0; display: block;">
		<div class="layui-btn layui-btn-primary" id="t1" onclick="show_alHtml('tdemo1');">单选框应用案例</div>
		<div class="layui-btn layui-btn-primary" id="t2" onclick="show_alHtml('tdemo2');">多选框应用案例</div>
		<div class="layui-btn layui-btn-primary" id="t3" onclick="show_alHtml('tdemo3');">下拉框应用案例</div>
	</div>
	<div class="col-sm-12 layui-form" style="padding:10px; display: block;" id="show_al"  lay-filter="tdemo111">
	
	</div>

</div>

<script id="tdemo3" type="text/html">
<div class="layui-form-item" >
    <label class="layui-form-label" style='width: inherit;'>下拉选择框</label>
    <div class="layui-input-block">
      <select name="interest" lay-filter="tdemo3">
        <option value=""></option>
        {{#  layui.each(d, function(index, item_111_){ }}
 			<option value="1" selected="">{{ item_111_.typename }}</option>
		{{#  }); }}
      </select>
    </div>
</div>
</script>
<script id="tdemo2" type="text/html">
<div class="layui-form-item layui-form">
    <label class="layui-form-label" style='width: inherit;'>复选框</label>
    <div class="layui-input-block"  lay-filter="tdemo2">
    {{#  layui.each(d, function(index, item_111_){ }}
		<input type="checkbox" lay-skin="primary" title="{{ item_111_.typename }}">
	{{#  }); }}
    </div>
  </div>
</script>
<script id="tdemo1" type="text/html">
<div class="layui-form-item layui-form">
    <label class="layui-form-label" style='width: inherit;'>单选框</label>
    <div class="layui-input-block" lay-filter="tdemo1">
      {{#  layui.each(d, function(index, item_111_){ }}
		<input type="radio" name="w1" title="{{ item_111_.typename }}">
	{{#  }); }}
    </div>
  </div>
</script>

<script type="text/javascript" src="designPlug-in/zTree/js/fuzzysearch.js"></script>
<script type="text/javascript" src="designPlug-in/zTree/js/jquery.ztree.exhide-3.5.js"></script>

<script type="text/javascript">
var form,laytpl;
var treeberpo,treebershou,treeber;
$(document).ready(function(){
	 treeberpo = document.getElementsByClassName("tree-ber-po")[0];
	 treebershou = document.getElementsByClassName("tree-ber-shou")[0];
	 treeber = document.getElementsByClassName("tree-ber")[0];
	treebershou.onclick = show;
	setTimeout("loadTree('')",1000);
	layui.use(['form','laytpl'], function(){form = layui.form;laytpl = layui.laytpl;});
	
});

	function show() {
		if(treeber.style.display == "block") {
			$("#right_").attr("class","col-sm-12");
			treeber.style.display = 'none';
			treeberpo.style.width = '1%';
			treebershou.innerHTML = '<img src="designPlug-in/ace/assets/avatars/home-images/btn_r.png"/>';
        	
		} else {
			$("#right_").attr("class","col-sm-9");
			treeber.style.display = 'block';
			treeberpo.style.width = '25%'
		}
	}
	
	
	
	
	function show_alHtml(id){
		var mainId=$("#mainId").val();
		if(mainId==""){
			layer.msg("请先选择数据源！", {icon: 5});
			return false;
		}
		var checkStatus = ${bussCode }_table.checkStatus('${bussCode }');
		if(checkStatus.data.length<2){
			layer.msg("请先选择展示字段，最多选择两个字段！", {icon: 5});
			return false;
		}
		if(checkStatus.data.length>2){
			layer.msg("只能选择两个展示字段！", {icon: 5});
			return false;
		}
		var selectid="";
		console.log(checkStatus.data);
		for(var w=0;w<checkStatus.data.length;w++){
			selectid+=checkStatus.data[w]["field_code"]+",";
		}
		
		$.ajax({
			async : false,
		    type: "POST",
		    url: "designController.do?getDictDataHtml&mainId="+mainId,
		    data:{design_id:"",selectid:selectid,fieldhref:""},
		    success: function(data) {
		    	var dictDataList_ = data.dictDataList;
		    	htmltmp=eval("("+dictDataList_+")");
		    	console.log("---------------------return dictDataList htmltmp--");
		    	console.log(htmltmp);
		    	var getTpl = document.getElementById(id).innerHTML;
				laytpl(getTpl).render(htmltmp.resultList, function(html){
					document.getElementById('show_al').innerHTML=html;
				});
				form.render(null, 'tdemo111');
		    }
		});
	}
	
	
function reloadData(){
	$("[data-field='is_query']").children().each(function(){
	    if($(this).text() == 'Y'){
	        $(this).text("是");
	    }else if($(this).text() == 'N'){
	         $(this).text("否");
		}
	});
	$("[data-field='is_hide']").children().each(function(){
	    if($(this).text() == 'Y'){
	        $(this).text("是");
	    }else if($(this).text() == 'N'){
	         $(this).text("否");
		}
	});
}

//初始化树
var setting = {
	data:{simpleData:{enable:true,idKey: "id",pIdKey: "pId",rootPId:"root"}},
	callback:{onClick:zTreeOnClick}
};


function zTreeOnClick(event, treeId, treeNode){
	if(treeNode.isParent){
		layer.msg("不能选择父级节点！", {icon: 5});
		return false;
	}else{
		var key = treeNode.id;
		layuiCleanQuery("${bussCode }");
		$("#mainId").val(key!='ABC'?key:'');
		var data={main_id:$("#mainId").val()};
		layuiTableReload("${bussCode}",data);
	}
}
function loadTree(filter){
	$.ajax({
		url: "cgformSelectBackController.do?selectTree&sName="+filter,
		type: "POST",dataType: "json",//async: false,
		success: function(data) {
			if(data!=null){
				var treeObj = $.fn.zTree.init($("#tree2"), setting, data);
				treeObj.expandAll(true); //展开所有节点
				 var nodes = treeObj.transformToArray(treeObj.getNodes()); //获取所有节点
				for(var i=0; i<nodes.length; i++){
					if(i==1){
						treeObj.selectNode(nodes[i]);
						treeObj.setting.callback.onClick(null, treeObj.setting.treeId, nodes[i]);//点击第一个父节点下面第一个子节点
					}
				}
				fuzzySearch('tree2','#searchtree',null,true);
			}
		}
	});
}




function findTree(){
	loadTree($.trim($("#searchtree").val()));
}

//新建-----------------------
function addBackMain(title, url, name, width, height,data) {
	jumpPage("<%=path %>/cgformSelectBackController.do?goAdd&bussCode=${bussCode }","新增数据源");
}
//新建-----------------------
//修改-----------------------
function updateBackMain(title, url, name, width, height, data) {
	var id = $("#mainId").val();
	if(id==null||id==""){
		layer.msg("请选择数据源进行编辑！", {icon: 5});
		return false;
	}
	jumpPage("<%=path %>/cgformSelectBackController.do?goUpdate&bussCode=${bussCode }&id="+$("#mainId").val(),"编辑数据源");
}
//修改-----------------------


//新建-----------------------
function addMain(title, url, name, width, height,data) {
	var id = $("#mainId").val();
	if(id==null||id==""){
		layer.msg("请先选择数据源！", {icon: 5});
		return false;
	}
	jumpPage("<%=path %>/cgformSelectFieldController.do?goAdd&bussCode=${bussCode }&mainId="+id,"新增数据源");
}
//新建-----------------------
//修改-----------------------
function updateMain(title, url, name, width, height, data) {
	jumpPage("<%=path %>/cgformSelectFieldController.do?goUpdate&bussCode=${bussCode}&id="+data.id,"编辑字段");
}
//修改-----------------------
//查看-----------------------
function detail(title, url, name, width, height, data) {
    window.open(url + "&id=" + data.id, "_blank");
}
//查看-----------------------

//删除-----------------------
    function deleteSelect(title, url, name, width, height, data) {
    	myConfirmDialog("您确定要删除吗？", function(){
			$.ajax({
				url: "<%=path %>/cgformSelectFieldController.do?doBatchDel",
				type: "POST",dataType: "json",//async: false,
				data: {ids: data.id},
				success: function(data) {
					if(data!=null){
						if(data.success){
							layer.msg(data.msg, {icon: 1});
							var datas={group_id:$("#mainId").val()!='ABC'?$("#mainId").val():''};
							layuiTableReload("${bussCode }",datas);
						}else{
							layer.msg(data.msg, {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
    }
  

    function deleteSelectMain(title, url, name, width, height, data) {
    	var id = $("#mainId").val();
    	if(id==null||id==""){
    		layer.msg("请选择要删除数据源！", {icon: 5});
    		return false;
    	}
    	myConfirmDialog("您确定要删除吗？", function(){
			$.ajax({
				url: "<%=path %>/cgformSelectBackController.do?doBatchDel",
				type: "POST",dataType: "json",//async: false,
				data: {ids: id},
				success: function(data) {
					loadTree('');
					if(data!=null){
						if(data.success){
							layer.msg(data.msg, {icon: 1});
						}else{
							layer.msg(data.msg, {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
    }
    function jumpPage(url,pageTitle){
		layer.open({
			  type: 2,
			  title: pageTitle,
			  shadeClose: false,//点击背景不关闭
			  scrollbar: false,//滚动条已锁
			  resize:true,//是否允许放大缩小
			  content: url,
			  area: ['50%', '70%'],
			  maxmin: true,
			  cancel: function(index){
				  layer.confirm('确定要关闭吗？', {
					  icon: 3,
					  btn: ['确定','取消'] //按钮
				  }, function(){
					  layer.close(index);
					  layer.closeAll('dialog');
				  }, function(){
					  return;
				  });
				  return false;
			  }
		});
	}
</script>