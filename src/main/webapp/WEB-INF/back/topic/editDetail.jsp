<%@page import="com.tj720.mip.springbeans.Config"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Config config1 = new Config();
String picUrl = config1.getRootPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/tag.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Tags/css/tag.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<style>
    .icon{
    position:relative;
    float:right; 
    }
    .layui-form-item{
        margin-left:5px;
        margin-top:15px;
    }
    .labels{
    	float: left;
	    height: 17px;
	    margin-bottom: 10px;
	    font-size: 12px;
	    font-family: PingFang-SC-Medium;
	    font-weight: 500;
	    color: rgba(119,140,162,1);
	    line-height: 17px;
	    text-align: center;
	    margin-right: 13px;
	    padding: 5px 10px;
	    color: black;
	    border-radius: 14px;
    }
    li.active{
    	float: left;
	    height: 17px;
	    margin-bottom: 10px;
	    font-size: 12px;
	    font-family: PingFang-SC-Medium;
	    font-weight: 500;
	    color: rgba(119,140,162,1);
	    line-height: 17px;
	    text-align: center;
	    margin-right: 13px;
	    padding: 5px 10px;
	    background: #009688;
	    color: #fff;
	    border-radius: 14px;
	}
	li:hover{
    cursor: pointer;
	}
	.tagDiv{ 
		background: #ccc;
	    border-radius: 10px;
	    padding-left: 11px;
	    padding-top: 10px;
	}
</style>
<body>

<form class="layui-form" action="" id="layerDemo">
   <div style="position: relative">
    <div class="col-md-6" style="display:inline;">
    <div class="layui-form-item">
        <label class="layui-form-label">专题名称</label>
        <div class="layui-input-inline">
            <input type="hidden" name="id" id="id">
            <input type="text" name="name" style="width: 325px" id="name" required   placeholder="请输入专题名称" autocomplete="off" class="layui-input">
        </div>       
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标签</label>
        <div class="layui-input-block">
            <div class="layui-input-inline" style="width:350px;" id="labelContainer">
	            <input type="text" id="tagValue" class="layui-input">
	             
	             <input type="hidden" name="label" id="label">
             </div>
             <div class="layui-input-inline">
             	<a href="javascript:void (0);" class="getMore">标签库></a>
             	
             </div>
        </div>    
    </div>
    <div class="layui-form-item layui-form-text layui-hide" id="labelsDiv">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline tagDiv" style="width: 325px">
            <ul>
            	<li class='labels active' data='生产工具' ><span>生产工具</span></li>
            	<li class='labels ' data='雕塑造像'><span>雕塑造像</span></li>
            	<li class='labels ' data='证章符号'><span>证章符号</span></li>
            	<li class='labels ' data='民族民俗'><span>民族民俗</span></li>
            	<li class='labels ' data='生活用品'><span>生活用品</span></li>
            	<li class='labels ' data='邮品'><span>邮品&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='证件票据'><span>证件票据</span></li>
            	<li class='labels ' data='宗教用品'><span>宗教用品</span></li>
            	<li class='labels ' data='建筑构件'><span>建筑构件</span></li>
            	<li class='labels ' data='照片底片'><span>照片底片</span></li>
            	<li class='labels ' data='旗帜牌匾'><span>旗帜牌匾</span></li>
            	<li class='labels ' data='模型'><span>模型&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='交通工具'><span>交通工具</span></li>
            	<li class='labels ' data='音像制品'><span>音像制品</span></li>
            	<li class='labels ' data='机械仪器'><span>机械仪器</span></li>
            	<li class='labels ' data='丧葬用品'><span>丧葬用品</span></li>
            	<li class='labels ' data='医疗卫生'><span>医疗卫生</span></li>
            	<li class='labels ' data='文体娱乐'><span>文体娱乐</span></li>
            	<li class='labels ' data='高科技'><span>高科技&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='祭器礼器'><span>祭器礼器</span></li>
            	<li class='labels ' data='书画'><span>书画&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='货币'><span>货币&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='兵器武器'><span>兵器武器</span></li>
            	<li class='labels ' data='其他'><span>其他&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='文献'><span>文献&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            	<li class='labels ' data='印章'><span>印章&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
            </ul>
        </div>
    </div>
    <div class="layui-form-item" style="display: none;">
        <label class="layui-form-label">展览展厅</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" style="width: 325px" name="exhibitionHall" id="exhibitionHall">
        </div> 
    </div>
    <div class="layui-form-item" style="display: none;">
        <label class="layui-form-label">展期</label>   
        <div class="layui-input-inline" style="width: 150px;">
	      <input type="text" class="layui-input" id="startTime" name="fristTime">
	    </div>
	    <div class="layui-form-mid">-</div>
	    <div class="layui-input-inline" style="width: 150px;">
	      <input type="text" class="layui-input" id="endTime" name="sencondTime">
	    </div> 
    </div>  
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">专题类别</label>
        <div class="layui-input-inline" style="width: 325px;">
            <select id="type" name="type" >
            	<option value="">请选择</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">介绍</label>
        <div class="layui-input-inline">
            <textarea placeholder="请输入内容" class="layui-textarea" style="width:325px;height:200px;" id="introduction" name="introduction">${topic.introduction}</textarea>
        </div>
    </div>
    <input type="hidden" lay-submit lay-filter="formDemo">
    <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-filter="save" id="save">确定</button>
	      <button class="layui-btn layui-btn-primary" id="cancel">取消</button>
	    </div>
    </div>
    </div>
	<div class="icon col-md-6" style="position:absolute;top:5px;right:5px;">
	      <span id="iconspan">
	           <img src=""  id="icon" onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/null_pic-12491114727.jpg' " width="200px" height="200px">
	           <div style="position:absolute;width:100px;height:20px;z-indent:2;left:63px;bottom:4px;font-size:18px;">
			             编辑封面
			    </div>
	           <input type="hidden" class="layui-input" name="iconUrl" id="iconUrl">
	      </span>
	 </div>
    </div>
</form>
<script src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script>
var tag = new Tag("tagValue");   
layui.use(['laydate', 'layedit','layer','form'], function(){
        var form = layui.form;
        var layedit = layui.layedit;
        var laydate = layui.laydate;
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        var index = parent.layer.getFrameIndex(window.name); //获取当前窗口索引
        //监听提交
        form.on('submit(layerDemo)', function(data){
            return false;
        });
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#startTime' //指定元素
        });
        laydate.render({
            elem: '#endTime' //指定元素
          });
        var pathName=window.document.location.pathname;
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
        $("#save").click(function(){
        	var data = $("#layerDemo").serialize();
            $.ajax({
                type:"post",
                data:data,
                url:projectName + '/topic/editTopic.do', 
                success:function(result) {
                	var index = parent.layer.getFrameIndex(window.name);
                    if (result.success == 1) {
                        top.layer.msg("修改成功！");
                        parent.layer.close(index);
                        
                    } else {
                        top.layer.msg("系统异常修改失败！");
                        parent.layer.close(index);
                    }
                } 
            });
           return false; 
        });
        
        $("#iconspan").click(function(){        	
        	layui.layer.open({
                type: 2
                ,id: 'iconDemo' //防止重复弹出
                ,content: ['<%=request.getContextPath() %>/cropper/newCropMuseum.html','yes']
                ,area: ['780px', '600px']
                ,shade: 0 //不显示遮罩
                ,success: function(layero, index){
                    
                }
            });	
        })
        
        $("#cancel").click(function(){
        	layer.close(index); 
        })
        
        //查看标签库
	    $(".getMore").on('click', function () {
	      if($(this).text()=="标签库>"){
	    	  $(this).text("标签库∨");
	    	  $("#labelsDiv").removeClass("layui-hide");
	    	  $("#labelsDiv").show();
	      }else{
	    	  $(this).text("标签库>")
	    	  $("#labelsDiv").hide();
	      }
	        
	    });
      	//li点击事件
        $(".labels").off().on('click', function () {
       	  var tagSize = $('.tagList').children().size();
       	  var childList = $('.tagList').children();
       	  if (tagSize < 4) {
       		  var isTrue = true;
       		  var labelData = $(this).attr("data");
       		  for(var i=0; i<tagSize; i++){
       			  if(childList[i].innerText == labelData){
       				isTrue = false;
       				break;
       			  }
       		  }
       		  if(isTrue){
	       	      $("#tagValue_tagcontaine .tagInput").val(labelData);
	       	      $("#tagValue").val(labelData);
	         	  $("#addLabel").click();
       		  }else{
       			top.layer.msg("请勿重复添加");
       		  }
       	  }else{
     			top.layer.msg("超过最大标签数4个");
   		  }
       	  
          if ($(this).hasClass("active")) {
        	  
          } else {
            $(this).addClass('active').siblings().removeClass('active');
            //var ulClass = $(this).parent().attr("class");
          } 
          $('.getMore').click();
        });  
      	
        initType();
      	function initType(){
      		$.ajax({
                type:"post",
                data:'',
                url:'<%=request.getContextPath() %>/topicType/getSelectList.do', 
                success:function(result) {
                	var index = parent.layer.getFrameIndex(window.name);
                	if (result.success == 1) {
                		var list1 = result.data;
	                	$("#type").text("");
	                	$("#type").append("<option value=''>请选择</option>");
	                	for(var i = 0; i < list1.length; i++) {
	                		var item = list1[i];
	                		if('${topic.type }' == item.id){
		                        $("#type").append("<option value='"+item.id+"' selected>"+item.name+"</option>");
	                		}else{
		                        $("#type").append("<option value='"+item.id+"'>"+item.name+"</option>");
	                		}
						}
    	            	form.render();
                    } else {
                        top.layer.msg("获取分类失败");
                    } 
                } 
            });
      	}
        
    });
    $(function(){
    	child();
    })
    function child(){
	    $("#id").val('${topic.id}');
	    $("#name").val('${topic.name}');
	    $("#label").val('${topic.label}');        
	    tag.tagValue = '${topic.label}';
	    tag.initView();
	    $("#exhibitionHall").val('${topic.exhibitionHall}');
	    $("#icon").attr("src",'${topic.iconUrl}');
	    $("#iconUrl").val('${topic.iconUrl}');
	    var startTime = '${topic.startTime}'.split('/').join('-'); 
	    var endTime = '${topic.endTime }'.split('/').join('-');
	    $("#startTime").val(startTime);
	    $("#endTime").val(endTime); 
	}
    
    function update(url,id,url1){
    	console.log(url);
    	var urlStr = url1;
    	console.log(urlStr);
        $("#icon").attr("src",urlStr);        
        $("#iconUrl").val(url);
    }
    
    
</script>
</body>
</html>