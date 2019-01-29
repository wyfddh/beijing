
<!DOCTYPE html>
<html>
 <head>
  <title>${businessCode}_v${versionNum}</title>
${config_iframe_head }
 </head>
 <body>

<div class="my-icms col-xs-12"  style="overflow-x:hidden;overflow-y:hidden;" id="tBCulCoreBdataList" ms-controller="tBCulCoreBdataList_table">
<!-- 查询条件----------start -->
<div ms-include-src="queryPageCodeRdm" data-include-rendered='queryTemprender' ></div>
<!-- 查询条件----------end -->	

<!-- 按钮区----------start -->
<button type="button"  id="FUN001_button" class="btn"   ms-click="addMain('aceModeDemoController.do?modePage&type=page&configformId=${configformId}&bussCode=${businessCode}&versionNum=${versionNum}')">
	<i class="fa fa-plus btn-xs  bigger-125"></i>
	录入
</button>
<button type="button" id="FUN002_button" class="btn "  ms-click="updateMain()" >
	<i class="fa fa-pencil   btn-xs bigger-125"></i>
	修改
</button>
<button type="button" id="FUN003_button" class="btn "  ms-click="delMain()">
	<i class="fa fa-times   btn-xs btu-danger"></i>
	  删除
</button>

<#if isBusinessKey?default("")!=''>
<button type="button" id="FUN008_button" class="btn"   ms-click="subBusin()">
	<i class="fa fa-check-square-o"></i>
	 提交审核
</button>
</#if>
<!--
<button type="button" class="btn" ms-click="exportData()"  >				
	<i class="fa fa-file-text  bigger-125"></i>	
	导出
</button>
 按钮区----------end -->	
<br/><br/>

		
<!-- 简明模式 start------------------------------>
<div class="table-responsive" ms-if="!tBCulCoreBdataListTA.isnull">
	<div class="col" id="isimpleAndClearData">
		<div class="bd" id="bd">
			<table border="0" style="background: #eff3f8"  class="table"  >
				<!-- 主数据的head start -->
					<tr style="background: #EEEEEE;color: #666;" id="sAClearListDetailTitleDataHtml">
					</tr>
				<!-- 主数据的head end -->
				
				<!-- 主数据 start -->
				<tbody id="sAClearListDetailBodyDataHtml" >
				
				</tbody>
				<!-- 主数据 end -->
			</table>
		</div>
	</div>
</div>

<!--简明模式  end------------------------------>
<table ms-if="tBCulCoreBdataListTA.isnull" style="background: #EEEEEE;width:100%;height:35px;margin-bottom:3px;">
	<tbody>
		<tr >
			<td align="center" style="width:100%;">暂无数据</td>
		</tr>
	</tbody>
</table>

<!-- 分页----------start -->
<div style="height:50px;line-height:45px;text-align:center">
	<div style="float:right;height:50px;line-height:45px;text-align:center">
		 <div class="ui-datatable-page ft14 pl20">
			<div id="pageDiv" ms-visible="tBCulCoreBdataListTA.page.total>tBCulCoreBdataListTA.pageNum[0].num" class="pull-right"></div>
		</div>
	</div>
	<div style="float:left;height:50px;line-height:45px;text-align:center">
		<div class="pull-right" ms-visible="tBCulCoreBdataListTA.listDataSize!=0">
			<span>共查询到{{tBCulCoreBdataListTA.page.total}}条记录</span>
			<span ms-visible="tBCulCoreBdataListTA.page.total>tBCulCoreBdataListTA.pageNum[0].num">
			 <!--  选择每页条数
				<select style="height: 25px; width: 50px;" ms-change="selNum(this.value)" ms-duplex="tBCulCoreBdataListTA.page.pagecount">
					<option ms-repeat-pg="pageNum" ms-attr-value="pg.num" ms-attr-selected="pg.num==tBCulCoreBdataListTA.page.pagecount?'selected':''">{{pg.num}}</option>
				</select>
			  -->
			</span>
	  </div>
	</div>
</div>
<!-- 分页----------end-->	
</div>
${config_iframe_bottom }
<script type="text/javascript">
	var tBCulCoreBdataListTA = avalon.define({
		$id : "tBCulCoreBdataList_table",
		imageTextListData : [],//图文数据集合
		sAClearListDetailTitleData : [],//简明明细head集合表头
		sAClearListMainTitleData : [],//简明主表头
		sAClearListDetailBodyData : [],//简明主数据集合
		listDataSize :0,//列表集合大小
		xianshigeshu : 20,//默认每个批次显示个数
		showListType:"",
		isnull: false,//是否有数据
		page: { pageindex: 1, pagecount: 10, total: 0 }, //分页参数
		pageNum: [{ "num": 10 }, { "num": 20 }, { "num": 30 }, { "num": 50 }, { "num": 100 }],
		search: { seartype: "1", searchcontent: "1" },
		queryPageCodeRdm : "listPageGenController.do?goQueryMain&versionNum=0&bussCode=${businessCode}",//查询条件页面
		queryTemprender : function() {
				queryTableMainAvalon.impQueryTJ = "";
				queryTableMainAvalon.InitWigetData();//初始化查询条件
				queryTableMainAvalon.clearReturnFunction = "clearQueryData()";//清除查询条件回调函数
				queryTableMainAvalon.queryReturnFunction = "doQuery()";//执行查询时回调方法
		},//查询条件页面加载完成事件
		selNum : function(item) { //选择显示的条数
			tBCulCoreBdataListTA.page.pagecount = item;
		},
		addMain: function (url) {
       	 window.open(url,"_blank");
       },//添加
       exportData: function () {
			var rFData = queryTableMainAvalon.returnFormData();//获得已选择的条件
			//按查询结果导出
			exportDataByQueryResult("BUSS_JY",'',rFData,'_ver');
		},
       updateMain: function () {
    		var id="";
    		var selIndex=0;
   		    $("#sAClearListDetailBodyDataHtml").find("[type='checkbox']").each(function(index, domEle) {
				if (domEle.checked) {
					id+=$(this).attr("checkdetailid")+",";
					selIndex++;
				}
			});
	       	if(id==""){
	       		layer.msg("请选择要修改的记录！", {icon: 5});
	    		return true;
	       	}
	       	id=noRepeatStr(id);
	        window.open("aceModeDemoController.do?modePage&type=page&versionNum=${versionNum}&configformId=${configformId}&bussCode=${businessCode}&id="+id,"_blank");
		},
		printDoc: function (printId) {
    		var array_=getSelectInfo(false);
    		var selectMainId=array_[0];;
    		var detailId=array_[1],cids=array_[2];
    		var selIndex=array_[3];
    		var allCheckStatus =array_[4];
	       	if(selectMainId==""){
	       		layer.msg("请选择要打印的记录！", {icon: 5});
	    		return true;
	       	}
	       	if(selIndex>1){
	       		layer.msg("请选择一条数据再点击打印！", {icon: 5});
	    		return true;
	       	}
	       	printBillByList(printId,selectMainId);
		},
		subBusin : function() {
			var id="";
    		var selIndex=0;
    		$("#sAClearListDetailBodyDataHtml").find("[type='checkbox']").each(function(index, domEle) {
				if (domEle.checked) {
					id+=$(this).attr("checkdetailid")+",";
					selIndex++;
				}
			});
	       	if(id==""){
	       		layer.msg("请选择要提交的记录！", {icon: 5});
	    		return true;
	       	}
    	    if(id!=""){
    		    id=id.substring(0,id.length-1);
    	    }
    	    id=noRepeatStr(id);
			submitBusiness(id,"","doQuery()");
		},
		delMain : function() {
			var id="";
        	$("#sAClearListDetailBodyDataHtml").find("[type='checkbox']").each(function(index, domEle) {
        		if (domEle.checked) {
        			id+=$(domEle).attr("checkdetailid")+",";
					}
				});
	        	if(id==""){
	        		layer.msg("请选择要删除的记录！", {icon: 5});
	        		return true;
	        	}
        		id=noRepeatStr(id);
        		if(id.indexOf(",")!=-1){
	        		layer.msg("为避免出错,请单个删除！", {icon: 5});
	        		return true;
	        	}
	        	myConfirmDialog("您确定要删除吗？", function() {
	        		tBCulCoreBdataListTA.sAClearListDetailBodyData.clear();
					$.getJSON("tBCrbcErevokeController.do?doDelA",
		            {id:id}, function (resultData) {
	                    $.ajaxSettings.async = false;
	                    doQuery();
	                    layer.msg(resultData.msg);
						return true;
	               });
				}, function() {
					return true;
				},"");
		},
		getJYListData : function(rFData) { //选择显示的条数
			var url_="listPageGenController.do?getTWorJYListData&versionNum=0&configformId=${configformId}&gno=${businessCode}&jsonType=BUSS_JY&currpage="
				+ tBCulCoreBdataListTA.search.searchcontent
				+ "&pagecount="
				+ tBCulCoreBdataListTA.page.pagecount;
			$.getJSON(url_,rFData,function(resultData) {
				tBCulCoreBdataListTA.isnull=true;
				if(resultData.success){
					setData(resultData);
					myLayPage("pageDiv",resultData.obj[0].DataLength,"listPageGenController.do?getTWorJYListData&configformId=${configformId}&divId=&gno=${businessCode}&jsonType=BUSS_JY",rFData);
				}
			});
		}
	});
	
	function delDetail(thia){
		var id=$(thia).attr("id")
		myConfirmDialog("您确定要删除吗？", function() {
    		tBCulCoreBdataListTA.sAClearListDetailBodyData.clear();
			$.getJSON("tBCulController.do?delItem",
            {id:id}, function (resultData) {
	            $.ajaxSettings.async = false;
	            doQuery();
	            layer.msg('删除成功！', {icon: 1});
				return true;
	        });
		}, function() {
			return true;
		},"");
	}
	
	function showDetail(thisO,index) { //显示简易模式数据
		var vdetailHtml=$(thisO).parent().parent().parent().find("#detailHtml"+index);
		if($(vdetailHtml).is(":visible")){
			$(thisO).html("<i class='fa fa-plus'></i>");
			$(vdetailHtml).hide(100);
		}else{
			$(thisO).html("<i class='fa fa-minus'></i>");
			$(vdetailHtml).show(100);
		}
	}
	
	function myLayPage(domId,dataLength,jsonUrl,rFData){
		var pageindex=tBCulCoreBdataListTA.page.pageindex;
		var pagecount=tBCulCoreBdataListTA.page.pagecount;
		tBCulCoreBdataListTA.page.total = dataLength;
		jsonUrl="listPageGenController.do?getTWorJYListData&versionNum=0&gno=${businessCode}&jsonType=BUSS_JY"
		laypage({
			cont : domId, //容器。值支持id名、原生dom对象，jquery对象。
			pages : Math.ceil(parseInt(dataLength)* 1.0/ pagecount), //
			curr : 1, //初始化当前页
			skin : 'molv',
			groups : 3, //连续显示分页数
			jump : function(e) { //触发分页后的回调
				if (e.curr != pageindex) {
					tBCulCoreBdataListTA.search.searchcontent = e.curr;
					var url_=jsonUrl+"&currpage="+ e.curr+ "&pagecount="+ tBCulCoreBdataListTA.page.pagecount;
					$.getJSON(url_,rFData,function(resultData) {
						if(resultData.success){
							setData(resultData);
						}else{
							tBCulCoreBdataListTA.isnull=true;
						}
						tBCulCoreBdataListTA.page.pageindex = e.curr;
					});
				}
			}
		});
	}
	//设置值到相应的HTML元素上
	function setData(resultData) {
		if (resultData.success) {
			if(resultData.obj[0].DataLength>0){
				tBCulCoreBdataListTA.isnull = false;
			}
			tBCulCoreBdataListTA.sAClearListDetailTitleData=resultData.obj[0].detailTitle;
			tBCulCoreBdataListTA.sAClearListDetailBodyData = resultData.obj[0].culDataList;
			tBCulCoreBdataListTA.listDataSize = resultData.obj[0].DataLength;
			JD_BUSSTitleDataHtml(tBCulCoreBdataListTA.sAClearListDetailTitleData,"sAClearListDetailTitleDataHtml");
			JD_BUSSBodyDataHtml(tBCulCoreBdataListTA.sAClearListDetailBodyData,"sAClearListDetailBodyDataHtml");
		} else {
			
			//JD_BUSS
			tBCulCoreBdataListTA.isnull = true;
			tBCulCoreBdataListTA.sAClearListDetailTitleData.clear();
			tBCulCoreBdataListTA.sAClearListDetailBodyData.clear();
			tBCulCoreBdataListTA.imageTextListData.clear();
		}
	}

	function doQuery() {
		//alert("执行查询时回调方法");
		tBCulCoreBdataListTA.search.searchcontent="1";
		tBCulCoreBdataListTA.search.seartype="1";
		tBCulCoreBdataListTA.search.pageindex=5;
		tBCulCoreBdataListTA.search.pagecount=10;
		tBCulCoreBdataListTA.search.total=0;
		tBCulCoreBdataListTA.page.total = 0;
		var rFData = queryTableMainAvalon.returnFormData();//获得已选择的条件
		if (rFData.queryFromFieldNmae != null
				&& rFData.queryFromFieldNmae != undefined) {
			tBCulCoreBdataListTA.getJYListData(rFData);
		}else{
			tBCulCoreBdataListTA.getJYListData("");
		}
	}
	
	function clearQueryData() {
		tBCulCoreBdataListTA.search.searchcontent="1";
		tBCulCoreBdataListTA.search.seartype="1";
		tBCulCoreBdataListTA.search.pageindex=5;
		tBCulCoreBdataListTA.search.pagecount=10;
		tBCulCoreBdataListTA.search.total=0;
		tBCulCoreBdataListTA.page.total = 0;
		//alert("清除查询条件回调函数");
		tBCulCoreBdataListTA.getJYListData("");
	}
	
	function gengduo(sid,thss) {
		$("#image_text").find("div[gengduoid='"+sid+"']").each(function(){
			if($(this).is(":visible")){
				$(this).hide();
				$(thss).text("更多>>");
			}else{
				$(thss).text("收起>>");
				$(this).show();
			}
		});
	}
	
	
	function showListType(type) {
		//alert("清除查询条件回调函数");
		$("#image_text").hide();
		$("#simple_and_clear_button").hide();
		
		$("#simple_and_clear").show();
		$("#image_text_button").show();
		tBCulCoreBdataListTA.showListType=type;
		doQuery();
	}

	avalon.ready(function() {
		$.ajaxSettings.async = true;
		tBCulCoreBdataListTA.search.searchcontent="1";
		tBCulCoreBdataListTA.search.seartype="1";
		tBCulCoreBdataListTA.search.pageindex=5;
		tBCulCoreBdataListTA.search.pagecount=10;
		tBCulCoreBdataListTA.search.total=0;
		tBCulCoreBdataListTA.isnull=true;
		tBCulCoreBdataListTA.page.total = 0;
		tBCulCoreBdataListTA.getJYListData("");
		tBCulCoreBdataListTA.showListType="image_text";//默认显示简易模式
	});
	
	
	 function thatclick(that){
		$(that).closest('table').find('tr > td:first-child input:checkbox').each(function(){
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		});
	}
	 
	function thatClickMain(index,that,showListType){
		$("#detailHtml"+index).find('input:checkbox').each(function(){
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		});
	}
	 
	function showButtons(thiss){
		$(thiss).find("#buttons").show();
	}
	function hideButtons(thiss){
		$(thiss).find("#buttons").hide();
	}
	
	setOperationFun_("");
	
</script>

 </body>