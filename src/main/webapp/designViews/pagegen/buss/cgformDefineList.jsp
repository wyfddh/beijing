<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/designContext/mytags.jsp"%>
<link href="designPlug-in/ace/assets/css/select.css" rel="stylesheet" type="text/css" />
<link href="designPlug-in/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script src="designPlug-in/zTree/js/jquery.ztree.core-3.5.js" type="text/javascript" type="text/javascript"></script>
<script src="designPlug-in/tools/icmstools.js?1212"></script>
<div class="page-content" ms-controller="EntityList_Page">
	<div class="row">
		<div class="col-lg-12 col-sm-12" style="padding-left: 0; padding-right: 0;">
	<div class="col-sm-12 " style="padding-right: 12px;">

	<!-- 查询条件----------start -->
	<!-- <div ms-include-src="queryPageCodeRdm" data-include-rendered='queryTemprender'></div> -->
	<!-- 查询条件----------end -->
	<!-- 按钮区----------start -->
	<c:if test="${type!='3' }">
	<button id="FUN005_button" type="button" class="btn" ms-click="goAdd()">
		<i class="fa fa-plus btn-xs  bigger-125"></i> 新增
	</button>
	<button id="FUN006_button" type="button" class="btn" ms-click="goUpdate()">
		<i class="fa fa-pencil   btn-xs bigger-125"></i> 编辑
	</button>
	<button id="FUN006_button" type="button" class="btn" ms-click="goRelease()">
		<i class="fa fa-pencil   btn-xs bigger-125"></i> 发布
	</button>
	<button id="FUN006_button" type="button" class="btn" ms-click="goCancelRelease()">
		<i class="fa fa-pencil   btn-xs bigger-125"></i> 取消发布
	</button>
	<button id="FUN007_button" type="button" class="btn" ms-click="goDelete()">
		<i class="fa fa-times  bigger-125"></i> 删除
	</button>
	</c:if>
	<c:if test="${type=='3' }">
	<button id="FUN006_button" type="button" class="btn" ms-click="goUpdate()">
		<i class="fa fa-pencil   btn-xs bigger-125"></i> 编辑
	</button>
	</c:if>
	<!-- 按钮区----------end -->
	<!-- 简明模式 start------------------------------>
	<div class="bd" id="bd" style="margin-top: 5px;">
		<table border="0" style="background:#eff3f8;" class="table"><tbody></tbody></table>
	</div>
	<!--简明模式  end------------------------------>
	<div ms-visible="EntityList.pageShow" style="height:50px;line-height:45px;text-align:center">
		<div style="float:left;height:50px;line-height:45px;text-align:center">
			<div class="pull-right">
				<span>共查询到{{EntityList.page.total}}条记录</span>
				<span ms-visible="EntityList.page.total>EntityList.pageNum[0].num"></span>
			</div>
		</div>
		<div style="float:right;height:50px;line-height:45px;text-align:center">
			<div class="ui-datatable-page ft14 pl20">
				<div id="pageDiv" ms-visible="EntityList.page.total>EntityList.pageNum[0].num" class="pull-right"></div>
			</div>
		</div>
	</div>
	<table ms-if="!EntityList.pageShow" style="background:#EEEEEE;width:100%;height:35px;margin-bottom:3px;">
		<tbody><tr><td align="center" style="width:100%;">暂无数据</td></tr></tbody>
	</table>
	
	</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var EntityList = avalon.define({
		$id: "EntityList_Page",
		pageShow: false, //显示分页插件	true：是		false：否
		page: {currpage: 1, pagecount: 10, total: 0}, //分页参数（当前页数、每页条数和总记录数）
		pageNum: [{"num": 10}],
		queryPageCodeRdm : "cgformDefineController.do?goQueryMain&bussCode=${bussCode}",//查询条件页面
		//查询条件页面加载完成事件
		queryTemprender : function() {
			queryTableMainAvalon.impQueryTJ = "";
			queryTableMainAvalon.InitWigetData();//初始化查询条件
			queryTableMainAvalon.clearReturnFunction = "doQuery(true)";//清除查询条件回调函数
			queryTableMainAvalon.queryReturnFunction = "doQuery(true)";//执行查询时回调方法
		},
		GetLIST: function(rFData){
			EntityList.pageShow = false;
			var baseUrl = "cgformDefineController.do?getCgformDefine&type=${type}";
			$.getJSON(baseUrl + '&rows=' + EntityList.page.pagecount + '&page=' + EntityList.page.currpage, rFData,
				function(resultData){
					EntityList.page.total = resultData.DataLength;
					if(resultData.DataLength>0) EntityList.pageShow = true;
					EntityList.showMTabHtml(resultData);
					laypage({
						cont: 'pageDiv', //容器。值支持id名、原生dom对象，jquery对象。
						pages: Math.ceil(parseInt(EntityList.page.total) * 1.0 / EntityList.page.pagecount), //
						curr: EntityList.page.currpage, //初始化当前页
						skip : true,	//是否开启跳页
						skin: 'molv',
						jump: function(e){ //触发分页后的回调
							if(e.curr != EntityList.page.currpage){
								EntityList.page.currpage = e.curr;
								$.getJSON(baseUrl + '&rows=' + EntityList.page.pagecount + '&page=' + e.curr, rFData,
									function(resultData){
										EntityList.showMTabHtml(resultData);
									}
								)
							}
						}
					});
				}
			);
		},
		showMTabHtml: function(data){
			$(".table tbody").empty();
			console.log(data);
			if(data.MainList!=null && data.MainList.length>0){
				var divhtml = "<tr style='background:#EEEEEE;'>";
				divhtml += "<th style='border:1px solid #CBCDCE;width:10px;width:5%;'>选择</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;width:10px;width:5%;'>序号</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>表单编码</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>表单名称</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>业务分类</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>存储方式</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>表单分类</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>状态</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>创建人</th>";
				divhtml += "<th style='border:1px solid #CBCDCE;'>创建时间</th>";
				divhtml += "</tr>";
				for(var j=0;j<data.MainList.length;j++){
					var cid = data.MainList[j].id;
					divhtml += "<tr>";
					divhtml += "<td style='border:1px solid #CBCDCE;'><input type='checkbox' class='main' onclick='selectDetail(this)' value='"+cid+"' status_value='"+data.MainList[j].status+"'></td>";
					divhtml += "<td style='border:1px solid #CBCDCE;text-align:center;'>"+((EntityList.page.currpage-1)*EntityList.page.pagecount+(j+1))+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;text-align:center;'>"+data.MainList[j].define_code+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;text-align:center;'>"+data.MainList[j].define_name+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;'>"+data.MainList[j].buss_type_cn+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;'>"+data.MainList[j].save_type_cn+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;'>"+data.MainList[j].type_cn+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;'>"+data.MainList[j].status_cn+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;'>"+data.MainList[j].create_name+"</td>";
					divhtml += "<td style='border:1px solid #CBCDCE;'>"+data.MainList[j].createDate_cn+"</td>";
					divhtml += "</tr>";
				}
				$(".table tbody").append(divhtml);
			}
		},
		goAdd: function(){
			jumpPage("<%=path %>/cgformDefineController.do?goAdd&type=${type}","新增业务表单");
		},
		goUpdate: function(){
			var mxids = getRowId("main");
			if(mxids==""){
        		layer.msg("请选择至少一条记录进行修改！", {icon: 5});
        		return true;
        	}
			if(mxids.split(",").length>1){
				layer.msg("只能选择一条记录进行修改！", {icon: 5});
        		return true;
			}
			var status = getRowStatus("main");
			if(status=="1"){
				layer.msg("已发布的表单不能进行修改！", {icon: 5});
        		return true;
			}
			jumpPage("<%=path %>/cgformDefineController.do?goUpdate&type=${type}&id="+mxids,"编辑业务表单");
		},
		goRelease: function(){
			var mxids = getRowId("main");
			if(mxids==""){
        		layer.msg("请选择至少一条记录进行发布操作！", {icon: 5});
        		return true;
        	}
			if(mxids.split(",").length>1){
				layer.msg("只能选择一条记录进行发布操作！", {icon: 5});
        		return true;
			}
			var status = getRowStatus("main");
			if(status=="1"){
				layer.msg("已发布的表单不可再次发布！", {icon: 5});
        		return true;
			}
			myConfirmDialog("已发布表单将不能进行修改，您确定要发布操作吗？", function(){
				$.ajax({
					url: "<%=path %>/cgformDefineController.do?doRelease",
					type: "POST",dataType: "json",//async: false,
					data: {id: mxids,status:1},
					success: function(data) {
						if(data!=null){
							if(data.success){
								layer.msg("发布成功", {icon: 1});
								 EntityList.query(true);
							}else{
								layer.msg(data.msg!="发布失败"?data.msg:"发布失败", {icon: 5});
							}
							return true;
						}
					}
				});
				}, function(){ return true; }, "");
		},
		goCancelRelease: function(){
			var mxids = getRowId("main");
			if(mxids==""){
        		layer.msg("请选择至少一条记录进行取消发布操作！", {icon: 5});
        		return true;
        	}
			if(mxids.split(",").length>1){
				layer.msg("只能选择一条记录进行取消发布操作！", {icon: 5});
        		return true;
			}
			var status = getRowStatus("main");
			if(status!="1"){
				layer.msg("未发布的表单不可取消发布！", {icon: 5});
        		return true;
			}
			myConfirmDialog("您确定要取消发布操作吗？", function(){
				$.ajax({
					url: "<%=path %>/cgformDefineController.do?doRelease",
					type: "POST",dataType: "json",//async: false,
					data: {id: mxids,status:0},
					success: function(data) {
						if(data!=null){
							if(data.success){
								layer.msg("取消发布成功", {icon: 1});
								 EntityList.query(true);
							}else{
								layer.msg("取消发布失败", {icon: 5});
							}
							return true;
						}
					}
				});
				}, function(){ return true; }, "");
		},
		goDelete: function(){
			var status = getRowStatus("main");
			if(status=="1"){
				layer.msg("已发布的业务不能删除！", {icon: 5});
        		return true;
			}
			var ids = getRowId("main");
			myConfirmDialog("您确定要删除吗？", function(){
			$.ajax({
				url: "<%=path %>/cgformDefineController.do?doBatchDel",
				type: "POST",dataType: "json",//async: false,
				data: {ids: ids},
				success: function(data) {
					if(data!=null){
						layer.msg(data.msg, {icon: 1});
						if(data.success) EntityList.query(true);
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
		},
		query: function(){
			EntityList.GetLIST(null);
		}
	});
	avalon.ready(function(){
		EntityList.GetLIST(null);
	});
	
	function jumpPage(url,pageTitle){
		console.log(url);
		layer.open({
			  type: 2,
			  title: pageTitle,
			  shadeClose: false,//点击背景不关闭
			  scrollbar: false,//滚动条已锁
			  resize:true,//是否允许放大缩小
			  content: url,
			  area: ['50%', '60%'],
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
	
	//全选、全不选
	function selectDetail(obj){
		$("#"+obj.value+" input:checkbox").each(function(){
			this.checked = obj.checked;
		});
	}
	//获取列表选中行
	function getRowId(type){
		var str = '';
		var line = $("."+type+":checked");
		for(var i=0; i<line.length; i++){
			str += line[i].value + ',';
		}
		return str.substring(0,str.length-1);
	}
	
	function getRowStatus(type){
		var statusStr = '';
		var line = $("."+type+":checked");
		for(var i=0; i<line.length; i++){
			statusStr = $(line[i]).attr('status_value');
		}
		return statusStr;
	}
	//执行查询时回调方法
	function doQuery(cpflag) {
		if(cpflag) resetPageData();
		var rFData = queryTableMainAvalon.returnFormData();//获得已选择的条件
		EntityList.GetLIST(rFData);
	}
	//重置分页信息
	function resetPageData(){
		EntityList.page.currpage = 1;
		EntityList.page.pagecount = 10;
		EntityList.page.total = 0;
		EntityList.pageShow = false;
	}
</script>