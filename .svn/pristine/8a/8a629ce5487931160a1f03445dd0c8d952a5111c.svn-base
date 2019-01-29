<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%
String picTypes = request.getAttribute("picTypes")+"";
%>
<!DOCTYPE html>
<html>
<head>
<title>文件上传</title>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="designPlug-in/stream/css/stream-v1.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="designPlug-in/tools/css/common-.css"	type="text/css" media="all" />
<link href="designPlug-in/ace/assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="designPlug-in/tools/icmstools.js"></script>
</head>
<body style="width:100%;padding:5px;">

    <script type="text/javascript">
    $("#showMore").click(function(){
      $("#navsmore").toggle(200);
      $("#icon-more").toggleClass("icon-more");
    });
	
    $("#showLeft").click(function(){
      $("#LeftSidebar").toggle(200);
      $("#Wrapper").toggleClass("noleft");
    });
    
    
   
    
  </script>
  <style type="text/css">
.crumbs-nav-item {
	float: left;
}

.crumbs-link,.crumbs-nav-item .menu-drop,.crumbs-nav-item .selector-set
	{
	float: left;
}

.selector-set .ss-item {
	position: relative;
	display: inline-block;
	height: 22px;
	line-height: 22px;
	border: 1px solid #DDD;
	font-size: 12px;
	vertical-align: top;
	margin: 1px 2px;
	padding: 0 26px 0 4px;
	cursor: pointer;
}

.selector-set .ss-item b {
	font-weight: 400;
}

.selector-set .ss-item em {
}

.selector-set .ss-item i {
	display: block;
	position: absolute;
	width: 25px;
	height: 22px;
	right: 0;
	top: 0;
	background: url(designPlug-in/jd/search.ele.png) no-repeat 7px -140px;
}

.selector-set .ss-item:hover {
	text-decoration: none
}

.selector-set .ss-item:hover i {
	background-color: #e4393c;
	background-position: 7px -158px
}
</style>




	<input id='attchtype_id' name='attchtype_id' type='hidden' value='' /> 
	<div id="daishangchuan__________"  style="border: 1px solid #CCCCCC;background-color: #FFFFE1;">&nbsp;&nbsp;待上传</div>
	<div  id="i_stream_files_queue" style="width: 100%;height:200px;">
	</div>
	<div align="center" style="width: 100%;" id="center_111111111_">
	
	<div class="btn_small" id="btn_small__1111111__">
	<br>
	<div id="i_select_files" class="stream-browse-files" style="width:107px;float:left"> <!-- display:none; -->
	</div>
	
	<div style="float:left;">
		<span class="mybuttomStyel" style="display: none;" id="mybuttomDiv1" onclick="javascript:var s111 = document.getElementById('i_stream_files_queue').getElementsByTagName('select');if(s111.length>0){for(var i = 0;i<s111.length;i++){var index=s111[i].selectedIndex;var selectedValue=s111[i].options[index].value;if(selectedValue=='--'){parent.layer.msg('请选择拍摄角度', {icon: 5});return false;}	}};_t.upload();$('#mybuttomDiv2').show();$('#mybuttomDiv1').hide();$(this).addClass('mybuttomSelected').siblings().removeClass('mybuttomSelected');" href="#" >开始上传</span>
		<span class="mybuttomStyel" style="display: none;" id="mybuttomDiv2" onclick="javascript:_t.stop();$(this).addClass('mybuttomSelected').siblings().removeClass('mybuttomSelected');$('#mybuttomDiv1').show();$('#mybuttomDiv2').hide();" href="#" >暂停上传</span>
		<span class="mybuttomStyel" style="display: none;" id="mybuttomDiv3" onclick="javascript:_t.destroy();_t=null;_t=new Stream(config);$('#mybuttomDiv1').hide();$('#mybuttomDiv2').hide();$('#mybuttomDiv3').hide();if($('.m_title2').length>0){$('#mybuttomDiv4').show();$('#mybuttomDiv5').show();}" href="#" >取消上传</span>
		<span class="mybuttomStyel" style="display: none;background: #10FF00" id="mybuttomDiv4" onclick="allComplete();" href="#" >上传完成，请点击</span>
		<span class="mybuttomStyel"  id="mybuttomDiv5" onclick="guanbi();" href="#" >关闭</span>
		
	</div>
	</div>
	 </br>
	 <div style="width:100%;border: 1px solid #CCCCCC;" id="i_select_files_Complete">
		<div align="left" style="border-bottom: 1px solid #CCCCCC;background-color: #FFFFE1;">
		&nbsp;&nbsp;上传完成&nbsp;(<font color="red">请上传.bmp，.jpg，.png，.tiff，.gif格式文件</font>)</div>
		<div id="i_stream_11111"  class="UpdateStata" style="width: 100%;overflow: auto;height:100px;">
		</div>
		
	</div>
	 <div style="width:100%;" id="i_select_files___1111">
		<font color=red>推荐使用ie10以上版本浏览器/360浏览器(极速模式)</font>
	</div>
<script type="text/javascript" src="designPlug-in/stream/js/stream-v1.js"></script>
<script type="text/javascript">
var backFileJson=[];

function allComplete() {
		var attchtype_idval = $("#attchtype_id").val();
		if(attchtype_idval==""){
			alert("请上传附件！");
			return false;
		}
		$(".m_title2").each(function(index,obj){
			backFileJson.push({picName:""+$(obj).attr("picName")+"",fileName:""+$(obj).attr("fileName")+"",fileId:""+$(obj).attr("fileId")+"",fileUrl:""+$(obj).attr("fileUrl")+""});
		});
		eval("parent.$.callbackFunction(backFileJson,'${designId}')");
	}
function guanbi() {
		if($(".stream-cell-file").length>0){
			if(window.confirm("您有文件没上传完毕，确认要关闭吗? ")){
				//shanchuweishangchuandewenjian();
				return true;
			}else{
				return false;
			}
		}
		$(".m_title2").each(function(index,obj){
			backFileJson.push({picName:""+$(obj).attr("picName")+"",fileName:""+$(obj).attr("fileName")+"",fileId:""+$(obj).attr("fileId")+"",fileUrl:""+$(obj).attr("fileUrl")+""});
		});
		eval("parent.$.callbackFunction(backFileJson,'${designId}')");
	}




/**
 * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
 * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
 * 是在ID为i_stream_message_container的页面元素中写日志
 */
 var picTypes_js=<%=picTypes%>;
 var config = {
		 	picTypes : picTypes_js, /**图片类型 */
			browseFileId : "i_select_files", /** 选择文件的ID, 默认: i_select_files */
			browseFileBtn : "<span class=\"mybuttomStyel\" id='xuanzewenjian' href=\"#\" >添加图片</span>",/**  显示选择文件的样式, 默认: `<div>请选择文件</div>` */
			dragAndDropArea: "i_select_files", /** 拖拽上传区域，Id（字符类型"i_select_files"）或者DOM对象, 默认: `i_select_files` */
			dragAndDropTips: "<input type='hidden' id='xuanzewenjian_' class='buttons' value ='' />", /** 拖拽提示, 默认: `<span>把文件(文件夹)拖拽到这里</span>` */
			filesQueueId : "i_stream_files_queue", /** 文件上传容器的ID, 默认: i_stream_files_queue */
			filesQueueHeight : 175, /** 文件上传容器的高度（px）, 默认: 450 */
			messagerId : "i_stream_message_container", /** 消息显示容器的ID, 默认: i_stream_message_container */
			multipleFiles: true, /** 多个文件一起上传, 默认: false */
			autoUploading: false, /** 选择文件后是否自动上传, 默认: true */
			autoRemoveCompleted : true, /** 是否自动删除容器中已上传完毕的文件, 默认: false */
			maxSize: 209715200, /** 单个文件的最大大小，默认:2G,此处200mb */
//			retryCount : 5, /** HTML5上传失败的重试次数 */
			postVarsPerFile : { /** 上传文件时传入的参数，默认: {} */
				picCode: "",
				picName: ""
			},
//			swfURL : "/swf/FlashUploader.swf", /** SWF文件的位置 */
			tokenURL : "<%=path%>/designTk", /** 根据文件名、大小等信息获取Token的URI（用于生成断点续传、跨域的令牌） */
			frmUploadURL : "<%=path%>/designFd;", /** Flash上传的URI */
			uploadURL : "<%=path%>/designUpload", /** HTML5上传的URI */
			simLimit: 20, /** 单次最大上传文件个数 */
			extFilters: [".bmp",".jpg",".png",".tiff",".gif"], /** 允许的文件扩展名, 默认: [] , ".rpm", ".rmvb", ".gz", ".rar", ".zip", ".avi", ".mkv", ".mp3"*/
			onSelect: function(list) {console.log("select files: " + list.length);
			  for (var i=0; i < list.length; i++) {
			    //checkFileName(list[i].name,list[i].size);
			  }
			  $("#mybuttomDiv1").show();
			  $("#mybuttomDiv3").show();
			  $("#mybuttomDiv4").hide();
			}, /** 选择文件后的响应事件 */
			onMaxSizeExceed: function(size, limited, name) {
				alert("上传单个文件大小不能超过200M！");
				$("#mybuttomDiv1").hide();
				$("#mybuttomDiv2").hide();
				$("#mybuttomDiv3").hide();
				}, /** 文件大小超出的响应事件 */
			onFileCountExceed: function(selected, limit) {
				alert("单次上传文件不能超过20个");
				$("#mybuttomDiv1").hide();
				$("#mybuttomDiv2").hide();
				$("#mybuttomDiv3").hide();
				}, /** 文件数量超出的响应事件 */
			onExtNameMismatch: function(name, filters) {
				$("#mybuttomDiv1").hide();
				$("#mybuttomDiv2").hide();
				$("#mybuttomDiv3").hide();
				}, /** 文件的扩展名不匹配的响应事件 */
			onCancel : function(file) {
				var streamCellFileL=$(".stream-cell-file").length;
				if(streamCellFileL-1==0&&$(".m_title2").length>0){
						$("#mybuttomDiv1").hide();
						$("#mybuttomDiv3").hide();
						$("#mybuttomDiv4").show();
					}
				}, /** 取消上传文件的响应事件 */
			onComplete: function(file) {BigonComplete(file);}, /** 单个文件上传完毕的响应事件 */
			onQueueComplete: function() {
				_t.destroy();
				_t=null;
				_t=new Stream(config);
				$("#mybuttomDiv1").hide();
				$("#mybuttomDiv2").hide();
				$("#mybuttomDiv3").hide();
				$("#mybuttomDiv4").show();
				} /** 所有文件上传完毕的响应事件 */
			//onUploadError: function(status, msg) {alert('onUploadError')} /** 文件上传出错的响应事件 */
//			onDestroy: function() {alert('onDestroy')} /** 文件上传出错的响应事件 */
		};
 
	
	
	var _t = new Stream(config);
	
	
	
	
	function BigonComplete(file){
		var fileMsg=eval("("+file.msg+")");
		var dataObj="";
		var picName=_t.get("postVarsPerFile").picName;
		var picCode=_t.get("postVarsPerFile").picCode;
		$.ajax({
			type: "POST",
			url:"cgformAttchController.do?BigonComplete",
			data:"attchCode=${attchCode}&picName="+picName+"&picCode="+picCode+"&attchPath=${attchPath}&mainCode=${mainCode}&detailCode=${detailCode}&mainId=${mainId}&detailId=${detailId}&fileCode="+fileMsg.fileName+"&fileName="+file.name,
			success:function (data1){
				
				var dataObj=data1;//eval("("+data1+")");
				if(dataObj.msg=="0"){
					alert("附件【" + file.name + "】 上传失败 \n失败原因：附件名称过长或附件名称含有特殊字符");
				}else{
					
					var HtmlStr ="<div class='m_title2' picName='"+picName+"' fileId='"+dataObj.obj.id+"' fileName='"+dataObj.obj.attachmenttitle+"' fileUrl='"+dataObj.obj.realpath+"' style='margin:1px;float:left;'>";
					HtmlStr=HtmlStr+"<div title="+file.name+" style='height: 25px;width: 165px;text-align: left;float:left;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;border: 1px solid #98BDFF;  border-right: 0px solid #98BDFF;'>";
					HtmlStr=HtmlStr+"&nbsp;"+file.name+"</div>";
					HtmlStr=HtmlStr+"<div style='width: 25px;height: 25px;float:left;border: 1px solid #98BDFF;border-left: 0px solid #98BDFF;'>";
					HtmlStr=HtmlStr+"<a href='##' style='color:red;font-size: 17px;' title='删除附件' onclick=\"del('commonController.do?delObjFile&fileKey="+dataObj.obj.id+"','"+file.name+"',this)\" >×</a>";
					HtmlStr=HtmlStr+"</div>";
					HtmlStr=HtmlStr+"</div>";
					
					$("#i_stream_11111").append(HtmlStr);
					//tip("附件【" + file.name + "】 上传成功 ");
					var attchtype_idval = $("#attchtype_id").val()+"'"+dataObj.obj+"',"; 
					$("#attchtype_id").val(attchtype_idval);
				}
			}
		});
	}
	
	function myConfirmDialog2(content,yes,no,windowapi){
		parent.layer.confirm(content, {
			  icon: 3,
			  btn: ['确认','关闭'] //按钮
			}, yes,no);
	}
	
	function del(url,attachmenttitle,obj){
		myConfirmDialog2("您确定要删除吗？", function(){
			$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				url : url,// 请求的action路径
				error : function() {// 请求失败处理函数
				},
				success : function(data) {
					var d = $.parseJSON(data);
					if (d.success) {
						var msg = d.msg;
						//tip(msg);
						if (obj != null)
							obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
						parent.layer.msg('删除成功！', {icon: 1});
						return true;
					}
				}
			}); 
		}, function(){
    		return true;
    	},null);
	}
	
	function checkFileName(name,size){
		$.ajax({
			type: "POST",
			url:"cgformAttchController.do?checkFileProperty",
			data:"mainCode=${mainCode}&detailCode=${detailCode}&mainId=${mainId}&detailId=${detailId}&name="+name+ "&size=" + size,
			success:function (data1){
				var dataObj=eval("("+data1+")");
				if(dataObj.obj=="0"){
					if(window.confirm("附件【" + name + "】 \n系统中存在相同名称的文件，您确定要替换该文件吗？替换文件会重新上传所选文件，不替换会在原文件的基础上续传！点击【确定】替换文件。点击【取消】不替换文件")){
						$.ajax({
							async : false,
							cache : false,
							type : 'POST',
							url : "cgformAttchController.do?delObjFile"+"&name="+dataObj.msg,// 请求的action路径
							error : function() {// 请求失败处理函数
							},
							success : function(data) {
								var d = $.parseJSON(data);
								if (d.success) {
									var msg = d.msg;
								}
							}
					});
						
					}else{
						return true;
					}
				}
			}
		});
	}
	
	
	function getAllFileByMainId(){
		$.ajax({
			type: "GET",
			url:"cgformAttchController.do?getAllFileByMainId",
			data:"businessKey=${businessKey}",
			success:function (data1){
				var dataObj=eval("("+data1+")");
				console.log(dataObj);
				if(dataObj.obj!="0"){
					var HtmlStr ="";
					var attchtype_idval = $("#attchtype_id").val();
					for(var i=0;i<dataObj.obj.length;i++){
						HtmlStr =HtmlStr+"<div class='m_title2' fileid='"+dataObj.obj[i].id+"' style='margin:1px;float:left;'>";
						HtmlStr=HtmlStr+"<div title="+dataObj.obj[i].attachmenttitle+" style='height: 25px;width: 165px;text-align: left;float:left;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;border: 1px solid #98BDFF;  border-right: 0px solid #98BDFF;'>";
						HtmlStr=HtmlStr+"&nbsp;"+dataObj.obj[i].attachmenttitle+"</div>";
						HtmlStr=HtmlStr+"<div style='height: 25px;width: 25px;float:left;border: 1px solid #98BDFF;border-left: 0px solid #98BDFF;'>";
						HtmlStr=HtmlStr+"<a href='##' style='color:red;font-size: 17px;' title='删除附件' onclick=\"del('commonController.do?delObjFile&fileKey="+dataObj.obj[i].id+"','"+dataObj.obj[i].attachmenttitle+"',this)\" >×</a>";
						HtmlStr=HtmlStr+"</div>";
						HtmlStr=HtmlStr+"</div>";
						attchtype_idval = attchtype_idval+"'"+dataObj.obj[i].id+"',"; 
					}
					$("#attchtype_id").val(attchtype_idval);
					$("#i_stream_11111").append(HtmlStr);
					}else{
						return true;
					}
				}
			});
		}
	
</script>
</body>
