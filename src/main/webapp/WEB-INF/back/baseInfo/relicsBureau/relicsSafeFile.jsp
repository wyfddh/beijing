<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/layui.css" media="all">
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <script src="<%=request.getContextPath() %>/back/js/relics/jquery-1.10.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/back/layer/layer.js"></script>
    <script src="<%=request.getContextPath() %>/back/layui/layui.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/cyStyle.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/cyType.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/videoDetail.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/formSelects-v4.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/inputTags.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/relics/videoDetail.css">
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
 .childrenBody{
    padding-top:10px;
    padding-left:20px;
    padding-right:20px;
 }
	#choseCollectList .layui-btn-sm{
            height: 25px;
            line-height: 25px;
            margin-top: 12px;
        }
        .xm-select-label {
            margin-top: -8px !important;
        }
        #choseCollectList .layui-btn-sm{
            float: left;
        }
        .collectListss::-webkit-scrollbar {/*滚动条整体样式*/
            width: 10px;     /*高宽分别对应横竖滚动条的尺寸*/
            height: 1px;
        }
        .collectListss::-webkit-scrollbar-thumb {/*滚动条里面小方块*/
            border-radius: 10px;
            -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
            background: rgba(29,116,78,1);
        }
        .collectListss::-webkit-scrollbar-track {/*滚动条里面轨道*/
            -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
            border-radius: 10px;
            background: #c0c4cd;
        }
</style>
<title>基本信息</title>
</head>
<body class="childrenBody">
 <div>  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
		<input type="hidden" id="level" name="level" value="${level}"/>
        <input type="hidden" name="museumId" id="museumId" value="${museumId}">
		<div class="layui-row">
			<div class="layui-col-md2 layui-col-md-offset9 pt_30">
				<span style="text-align:center;display:block;">
					<c:if test="${'1' eq level}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase" style="margin-left:0px">保存</a>
	                </c:if>
	                <a id="btn_back" type="button" class="layui-btn">返回</a>
                </span>
    		</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-md6 layui-col-md-offset3 ">
		        <div class="cardOne mt24">
		                <div class="title"><img src="<%=request.getContextPath() %>/back/images/xingxing.png" alt="">&nbsp;&nbsp;<span class="title_name">文物保管场所安全条件</span></div>
		
		                <div class="OneBody mt24">
		                    <div class="oneHeard">
		
		                    </div>
		                    <div class="oneBody mt24"  style="width: 43%;position: relative">
		                        <input id="attachment" name="attachment" value="${fkId}" type="hidden">
		                        <div class="layui-upload-drag" id="test10">
		                            <img src="<%=request.getContextPath() %>/back/images/Shapemax.png" alt="">
		                            <p>点击或拖动文件上传</p>
		                            <p class="tip">支持单个或批量上传。文件类型包括：图片、文档。</p>
		                        </div>
		                        <c:if test="${'1' eq level}">
		                        <button type="button" class="layui-btn" id="testListAction">开始上传</button>
		                        </c:if>
		                        <div class="fileControl">
		                            <ul id="demoList">
		                            </ul>
		
		                        </div>
		                    </div>
		                </div>
		         </div>
	         </div>
        </div>
	</form>
</div>
<script src="<%=request.getContextPath() %>/back/js/relics/component.js"></script>
<script src="<%=request.getContextPath() %>/back/js/relics/common.js"></script>
<script src="<%=request.getContextPath() %>/back/js/relics/formSelects-v4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>

<script type="text/javascript">

layui.use(['form','layer','upload','laydate','element'],function(){
	
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
       	laydate=layui.laydate,
        $ = layui.jquery,
        upload = layui.upload,
        element = layui.element;
    	
    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
	//页面初始化
	var attCount = 0;
	var attachmentsList = new Array();
	attachmentsList = loadAttachments();
	if (null != attachmentsList){
        attCount = attachmentsList.length;
        $("#demoList").append(getAttachmentList(attachmentsList));
        $(".fileName").click(function(){
        	downFile($(this).data("path"),$(this).data("name"));
        });
    }
	var tableId =$("#museumId").val();
	var demoListView = $('#demoList');
	var level = $("#level").val();
	if(level == '1'){
	    var uploadListIns = upload.render({
	        elem: '#test10'
	        ,url: projectName+"/attach/uploadForPost.do?tableName=culturalSafeList"+"&tableId="+tableId
	        ,accept: 'file'
	        ,multiple: true
	        ,auto: false
	        ,xhr:xhrOnProgress
	        ,progress:function(index,value){//上传进度回调 value进度值
	            var tr = demoListView.find('#upload-'+ index)
	                ,tds = tr.children();
	            tds.eq(1).html('<span style="color: red;">正在上传</span>');
	            element.progress('progressBar'+index, value+'%')//设置页面进度条
	            // console.log(e,value);
	        }
	        ,bindAction: '#testListAction'
	        ,choose: function(obj){
	            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
	            //读取本地文件
	            obj.preview(function(index, file, result){
	                var tr=$(["<li>" +
	                "                                    <div class='upLeft' id='upload-"+index+"'>" +
	                "                                        <a class=\"fileName\" href=\"javascript:void(0);\" >"+file.name+"</a>" +
	                "                                        <span class=\"fileState\">准备上传</span>" +
	                "                                    </div>" +
	                "                                    <div class=\"upRight\">" +
	                "                                        <div class='layui-progress layui-col-md8 layui-col-sm8' lay-showPercent='yes' lay-filter='progressBar"+index+"'>" +
	                "                                            <div class=\"layui-progress-bar layui-progress-big layui-bg-red\" lay-percent=\"30%\">" +
	                '<span class="layui-progress-text">'+'0%'+'</span>'+'</div>' +
	                "                                        </div>" +
	                "                                        <span class=\"layui-col-md1 layui-col-sm1\">&nbsp;</span>"+
	                "                                        <a href=\"javascript:void (0);\"  class=\"layui-col-md1 layui-col-sm1 layui-hide demo-reload\">重传</a>" +
	                "                                        <a href=\"javascript:void (0);\"  class=\"layui-col-md1 layui-col-sm1 demo-cancel\">取消</a>" +
	                "                                    </div>" +
	                "                                </li>"].join(''));
	                //单个重传
	                tr.find('.demo-reload').on('click', function(){
	                    obj.upload(index, file);
	                });
	                demoListView.append(tr);
	                //删除
	
	            });
	        }
	        ,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
	            //layer.load(); //上传loading
	        }
	        ,done: function(res, index, upload){
	            if(res.code == 1){ //上传成功
	                attCount = attCount+1;
	                var tr = demoListView.find('#upload-'+ index)
	                    ,tds = tr.children();
	                tds.eq(1).html('<span style="color: #3B82FF;">上传成功</span>');
	                //tds.eq(2).html(''); //清空操作
	                tr.siblings(".upRight").find(".demo-reload").remove();
	                tr.siblings(".upRight").find(".demo-cancel").addClass("demo-delete");
	                tr.siblings(".upRight").find(".demo-cancel").text("删除");
	                tr.siblings(".upRight").find(".demo-cancel").attr("data-id",res.data.id);
	                tr.siblings(".upRight").find(".demo-delete").removeClass("demo-cancel");
	
	                tr.siblings(".upRight").find(".layui-bg-red").addClass("layui-bg-green");
	                tr.siblings(".upRight").find(".layui-bg-green").removeClass("layui-bg-red");
	                tr.find(".fileName").click(function(){
	                	downFile(res.data.resultPath,res.data.realFileName);
	                });
	                //将新增的插入到数据列表里面
	                attachmentsList.push({"id":"","museumId":"","fkId":res.data.id,"attName":"","attPath":""})
	                //重新设置下拉框
	                return delete this.files[index]; //删除文件队列已经上传成功的文件
	            }else {
	                var tr = demoListView.find('#upload-'+ index)
	                    ,tds = tr.children();
	                tds.eq(1).html('<span style="color: #3B82FF;">'+res.msg+'</span>');
	            }
	            this.error(index, upload);
	        }
	        ,error: function(index, upload){
	            var tr = demoListView.find('#upload-'+ index)
	            tr.siblings(".upRight").find('.demo-reload').removeClass('layui-hide'); //显示重传
	        }
	    });
	}
    //提交
    form.on("submit(saveBase)",function(data){
    	if(attachmentsList.length == 0){
    		layer.msg("请先上传附件再保存！");
    		return false;
    	}
    	var museumId = $("#museumId").val();
    	var json = {"fileStr":JSON.stringify(attachmentsList),"museumId":museumId};
        $.ajax({
            url:projectName+"/relicsBureau/saveCulturalSafeFileList.do",
            data:json,
            type:'post',
            async:false,
            success:function(result) {
                if (result.success == 1) {
                    top.layer.msg("保存成功");
                    setTimeout(function(){
                    	window.location.href = window.location.href;
                    },2000)
                } else {
                    top.layer.msg(result.error.message);
                }
            },
            error:function(result) {
                top.layer.msg("系统异常");
            }
        });
    });
    //删除附件
    $('#demoList').on('click','.demo-delete',function(){
    	
    	if(level == '2'){
    		return false;
    	}
        var attId = $(this).attr("data-id");
        $(this).parent().parent().remove();
        deleteAttachment(attId);
        attCount = attCount-1;
    });
    //取消上传
    $('#demoList').on('click','.demo-cancel',function(){
        var attId = $(this).attr("data-id");
        $(this).parent().parent().remove();
    });
    
	
	//返回校验
	$("#btn_back").click(function(){
		if(!checkSave()){
			layer.confirm('您上传的文件尚未保存，确定要离开吗？', {  
		        btn: ['确定','取消'] //按钮
		    }, function(index){ 
		    	layer.close(index);  //关闭弹出层
		        //点击确定之后需要执行的函数
		        var museumId = $("#museumId").val();
		        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
		    }, function(index){
		        layer.close(index);  //关闭弹出层
		    });
		}else{
			var museumId = $("#museumId").val();
	        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
		}
    });
	
	function checkSave(){
		var flag = true;
		 for(var i=0;i<attachmentsList.length;i++){
    		if(attachmentsList[i].museumId == ''){
    			flag = false;
    			break;
    		}
		  }
		 return flag;
	}
	
	function loadAttachments() {
	    var datas = null;
	    var museumId=$("#museumId").val();
	    var level=$("#level").val();
	    var json = {"museumId":museumId,"level":level};
	    $.ajax({
	        type:"post",
	        data:json,
	        async:false,
	        url:projectName+"/relicsBureau/getCulturalSafeFileList.do",
	        success:function(result) {
	            if (result.success == 1) {
	                console.log(result.data);
	                datas = result.data;
	            } else {
	                top.layer.msg(result.data);
	            }
	        },
	        error:function(result) {
	            top.layer.msg("系统异常");
	        }
	    });
	    return datas;
	}
	
	//删除附件

	function deleteAttachment(attId) {
	    var json = {"attId":attId};
	    debugger;
	    for(var i=0;i<attachmentsList.length;i++){
	    	if(attachmentsList[i].fkId == attId){
	    		if(attachmentsList[i].museumId != '' && attachmentsList[i].museumId != null){
	    			attachmentsList[i].isDelete = '1';
	    		}else{
	    			attachmentsList.splice(i,1);
	    		}
	    		break;
	    	}
	    }
	    layer.msg("删除成功");
	}

	function deleteCollect(id) {
	    for (var i = 0, length = choseCollect.length; i < length; i++) {
	        var culId = choseCollect[i].culId;
	        if (id == culId) {
	            choseCollect.splice(i,1);
	            $('#'+id).remove();
	            break;
	        }
	    }
	}
	
	//修改
	$("#btn_edit").click(function(){
    });
	
	function isEmpty(obj){
	    if(typeof obj == "undefined" || obj == null || obj == "")	{
	        return true;
	    }else{
	        return false;
	    }
	}
    
    function encodeBase64(mingwen,times){    
        var code="";    
        var num=1;    
        if(typeof times=='undefined'||times==null||times==""){    
           num=1;    
        }else{    
           var vt=times+"";    
           num=parseInt(vt);    
        }    
        if(typeof mingwen=='undefined'||mingwen==null||mingwen==""){    
        }else{    
            $.base64.utf8encode = true;    
            code=mingwen;    
            for(var i=0;i<num;i++){    
               code=$.base64.btoa(code);    
            }    
        }    
        return code;    
    }; 
    
   function getTimeJson(){
   	   var date = new Date();
   	   var time = date.getTime();
   	   return time;
   }
   
   function xhrOnProgress(fun) {
	    xhrOnProgress.onprogress = fun;
	    return function() {
	    var xhr = $.ajaxSettings.xhr();
	    if (typeof xhrOnProgress.onprogress !== 'function')
	        return xhr;
	    if (xhrOnProgress.onprogress && xhr.upload) {
	        xhr.upload.onprogress = xhrOnProgress.onprogress;
	     }                return xhr;
	   }
	}
    
   
   function getAttachmentList(data) {
	    var htmlStr = '';
	    for (var i=0;i<data.length;i++){
	    	if('${level}' == '1'){
		        var tr="<li>" +
		        "                                    <div class='upLeft' id='upload-"+data[i].fkId+"'>" +
		        "                                        <a title=\"下载附件\" class=\"fileName\"  href=\"javascript:void(0);\" data-path='"+data[i].attPath+"' data-name='"+data[i].attName+"'>"+data[i].attName+"</a>" +
		        "                                        <span class=\"fileState\">上传成功</span>" +
		        "                                    </div>" +
		        "                                    <div class=\"upRight\">" +
		        "                                        <div class='layui-progress layui-bg-green layui-col-md8 layui-col-sm8'  lay-filter='progressBar"+data[i].fkId+"'>" +
		        "                                            <div class=\"layui-progress-bar layui-bg-green\" lay-percent=\"100%\"></div>" +
		        "                                        </div>" +
		        "                                        <span class=\"layui-col-md1 layui-col-sm1\">&nbsp;</span>" +
		        "                                        <a href=\"javascript:void (0);\" class=\"layui-col-md1 layui-col-sm1 demo-delete\" data-id='"+data[i].fkId+"'>删除</a>" +
		        "                                    </div>" +
		        "                                </li>";
		        htmlStr = htmlStr+tr;
	    	}else{
		        var tr="<li>" +
		        "                                    <div class='upLeft' id='upload-"+data[i].fkId+"'>" +
		        "                                        <a title=\"下载附件\" class=\"fileName\"  href=\"javascript:void(0);\" data-path='"+data[i].attPath+"' data-name='"+data[i].attName+"'>"+data[i].attName+"</a>" +
		        "                                    </div>" +
		        "                                    <div class=\"upRight\">" +
		        "                                        <div class='layui-progress layui-bg-green layui-col-md8 layui-col-sm8'  lay-filter='progressBar"+data[i].fkId+"'>" +
		        "                                            <div class=\"layui-progress-bar layui-bg-green\" lay-percent=\"100%\"></div>" +
		        "                                        </div>" +
		        "                                        <span class=\"layui-col-md1 layui-col-sm1\">&nbsp;</span>" +
		        "                                    </div>" +
		        "                                </li>";
		        htmlStr = htmlStr+tr;
	    	}
	    }
	    return htmlStr;
	}
   
   function downFile(path,fileName) {
		var url = projectName + '/attach/downFile.do?path='+path+'&fileName='+fileName;
		window.location.href = url;
   }
});

</script>
</body>
</html>