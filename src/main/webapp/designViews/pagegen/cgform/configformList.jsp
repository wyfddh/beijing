<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@include file="/designContext/unified.jsp"%>

<div class="col-sm-3 tree-ber-po" style="padding-left: 0; display: block;">
	<div class="tree-ber-shou">
		<img src="designPlug-in/ace/assets/avatars/home-images/btn_l.png" />
	</div>
	<div class="tree-ber" style="display: block;">
		<div class="input-icon"style=" margin: 3px;"> 														
			<input type='text' id='searchtree' style="width:95%;" placeholder="请输入关键字搜索"  />
		</div> 
		<div id="tree2" class="ztree" style="width:100%;height:565px;overflow:auto;border:0px solid #000;padding:0px;"></div>
		<input type="hidden" name="groupId" id="groupId" />
	</div>
</div>
<div class="col-sm-9" id="right_" style="padding-right: 12px;">
<t:layuiTable name="tSBaseParameterList" pageSize="${cgformBuss.pageSize }" 
	pagination="${cgformBuss.isPage=='Y'?'true':'false' }"  initSort="${cgformBuss.initSort }" limits="${cgformBuss.limits }"
	tableTitleUrl="listPageGenController.do?getListTitle&bussCode=${bussCode }"
	tableQueryUrl="listPageGenController.do?getQueryList&bussCode=${bussCode }"
	tableDataUrl="listPageGenController.do?getListData&bussCode=${bussCode }"
 	bussCode="${bussCode }" isCheckbox="${cgformBuss.isCheckbox=='Y'?'true':'false' }"
 	isIndex="${ cgformBuss.isIndex=='Y'?'true':'false' }"
 	onLoadSuccess="reloadData" >
  <t:layuiButton title="录入" operationCode="addMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="addMain"></t:layuiButton>
  <t:layuiTableBar title="编辑" operationCode="edit" icon="layui-btn layui-btn-xs"   url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="updateMain"></t:layuiTableBar>
  <t:layuiTableBar title="删除" operationCode="del"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="deleteSelect"></t:layuiTableBar>
  <%-- <t:layuiTableBar operationCode="detail" title="查看" icon="layui-btn layui-btn-primary layui-btn-xs"   url="aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode=${bussCode }" funname="detail"></t:layuiTableBar> --%>
</t:layuiTable>
</div>

<script type="text/javascript" src="designPlug-in/zTree/js/fuzzysearch.js"></script>
<script type="text/javascript" src="designPlug-in/zTree/js/jquery.ztree.exhide-3.5.js"></script>
<script type="text/javascript">
var treeberpo,treebershou,treeber;
$(document).ready(function(){
	 treeberpo = document.getElementsByClassName("tree-ber-po")[0];
	 treebershou = document.getElementsByClassName("tree-ber-shou")[0];
	 treeber = document.getElementsByClassName("tree-ber")[0];
	treebershou.onclick = show;
	setTimeout("loadTree('')",1000);
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
	


function reloadData(){
	$("[data-field='show_type']").children().each(function(){
	    if($(this).text() == 'text'){
	        $(this).text("文本框");
	    }else if($(this).text() == 'password'){
	         $(this).text("密码框");
		}
	    else if($(this).text() == 'radio'){
	         $(this).text("单选框");
		}
	    else if($(this).text() == 'checkbox'){
	         $(this).text("多选框");
		}
	    else if($(this).text() == 'year'){
	         $(this).text("年份");
		}
	    else if($(this).text() == 'yymm'){
	         $(this).text("年月");
		}
	    else if($(this).text() == 'date'){
	         $(this).text("日期");
		}
	    else if($(this).text() == 'time'){
	         $(this).text("时分秒");
		}
	    else if($(this).text() == 'datetime'){
	         $(this).text("日期+时分秒");
		}else if($(this).text() == 'textarea'){
	         $(this).text("大文本框");
		}else if($(this).text() == 'list'){
	         $(this).text("下拉选择框");
		}else if($(this).text() == 'popup'){
	         $(this).text("弹出选择框");
		}
	});
	$("[data-field='type']").children().each(function(){
	    if($(this).text() == 'string'){
	        $(this).text("字符串");
	    }else if($(this).text() == 'int'){
	         $(this).text("整型");
		}else if($(this).text() == 'double'){
	         $(this).text("浮点型");
		}else if($(this).text() == 'Date'){
	         $(this).text("日期");
		}else if($(this).text() == 'text'){
	         $(this).text("长文本");
		}else if($(this).text() == 'blob'){
	         $(this).text("二进制");
		}
	});
}

//初始化树
var setting = {
	data:{simpleData:{enable:true,idKey: "id",pIdKey: "pId",rootPId:"root"}},
	callback:{onClick:zTreeOnClick}
};
function zTreeOnClick(event, treeId, treeNode){
	var key = treeNode.id;
	$("#groupId").val(key!='ABC'?key:'');
	var data={group_id:$("#groupId").val()};
	layuiTableReload("${bussCode }",data);
}
function loadTree(filter){
	$.ajax({
		url: "cgformReportIndexController.do?tree&content="+filter,
		type: "POST",dataType: "json",//async: false,
		success: function(data) {
			if(data!=null){
				var treeObj = $.fn.zTree.init($("#tree2"), setting, data);
				treeObj.expandAll(true); //展开所有节点
				/* var nodes = treeObj.transformToArray(treeObj.getNodes()); //获取所有节点
				for(var i=0; i<nodes.length; i++){
					if(!nodes[i].isParent) break;
					treeObj.expandNode(nodes[i], true);
				} */
				fuzzySearch('tree2','#searchtree',null,true);
			}
		}
	});
	
}
function findTree(){
	loadTree($.trim($("#searchtree").val()));
}

//新建-----------------------
function addMain(title, url, name, width, height,data) {
	jumpPage("<%=path %>/cgformReportIndexController.do?goAdd&bussCode=${bussCode }&groupId="+$("#groupId").val(),"新增指标");
}
//新建-----------------------
//修改-----------------------
function updateMain(title, url, name, width, height, data) {
	console.log(data);
	jumpPage("<%=path %>/cgformReportIndexController.do?goUpdate&bussCode=${bussCode }&id="+data.id,"编辑指标");
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
				url: "<%=path %>/cgformReportIndexController.do?doBatchDel",
				type: "POST",dataType: "json",//async: false,
				data: {ids: data.id},
				success: function(data) {
					if(data!=null){
						if(data.success){
							layer.msg(data.msg, {icon: 1});
							var datas={group_id:$("#groupId").val()!='ABC'?$("#groupId").val():''};
							layuiTableReload("${bussCode }",datas);
						}
						if(!data.success){
							layer.msg(data.msg, {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
    }
    
    function jumpPage(url,pageTitle){
		console.log(url);
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