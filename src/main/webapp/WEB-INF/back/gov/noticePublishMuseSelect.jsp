<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style>
    .aa .layui-form-checkbox{
        margin-bottom: 0;
    }
    .layui-form-checkbox{
        margin-bottom: 20px;
    }
    .cont{
        height: 494px;
        margin-top: 30px;
        overflow-y: scroll;
        padding-left: 20px;
    }
</style>
<title>通知公告-接收单位选择</title>
</head>
<body style="background:#fff;padding:10px">
<div class="main">
    <form class="layui-form" id="newForm">
        <blockquote class="layui-elem-quote news_search">
            <div class="layui-inline" >
            	已选择：<label id="isSelectNum">0</label>&nbsp;/&nbsp;<label id="totalNum">100</label>
            </div>
            <div class="layui-inline" style="margin-left: 10px">
                <button type="reset" lay-submit class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="reset">清空</button>
            </div>
            <div class="layui-inline aa" style="margin-left: 10px">
                <input type="checkbox" name="selectAll" id="selectAll" lay-filter="selectAll" lay-skin="primary" title="选择所有">
            </div>
            <div class="layui-input-inline" style="width: 180px;">
                <input type="text" class="layui-input searchVal" placeholder="请输入搜索的内容" id="key" name="key"/>
            </div>
            <div class="layui-input-inline" style="width: 180px;">
                <select name="town" id="town" lay-filter="select_search">
                    <option value="">选择区域</option>
                </select>
            </div>
            <div class="layui-input-inline" style="width: 180px;">
                <select name="orgTypeId" id="orgTypeId" lay-filter="select_search">
                    <option value="">选择组织类型</option>
                   	<option value="1">文物局</option>
                   	<option value="2">区文委</option>
                   	<option value="3">博物馆</option>
                   	<option value="4">文物修复资质单位</option>
                   	<option value="5">其他文物收藏单位</option>
                </select>
            </div>
            <div class="layui-input-inline" style="float: right;margin-right: 20px;">
            	<button type="button" lay-submit class="layui-btn" lay-filter="confirmSelect" title="选择完毕后请点击这里">确认选择</button>
            </div>
        </blockquote>
        <div>
            <div class="layui-inline" style="margin-left: 10px">
                <button type="button" lay-submit class="layui-btn layui-btn-sm" lay-filter="selectCurrentAll">全选</button>
            </div>
            <div class="layui-inline">
                <button type="button" lay-submit class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="backSelect">反选</button>
            </div>
            <div class="cont" id="showReceive">
                <input type="checkbox" class="receiveItem" name="receiveOrg" value="1" title="国家文物局">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">
$(function(){
	//定义一个变量用于存储选中复选框的值
    var sel_a=[];
	
	//设置数组的值
	function setSelArray(value){
		sel_a = value;
	}
	layui.use(['form','layer','laydate'],function(){
	     var form = layui.form,
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery,
	    	laydate = layui.laydate;
		
	   	laydate.render({
	   	    elem: '#deadlineTime'
	   	    ,type: 'datetime'
	   	    ,format: 'yyyy-MM-dd HH:mm'
	   	  });
	    
	    form.on("switch(isfeedback)", function(data){
	    	if(data.elem.checked){
		    	$(".iswrite").show();
		    	layui.layer.tips('若选择此项，超过截至时间后，接收单位依然可以进行数据填报', '.outTimeIsContinueWrite', {
	                tips: 3
	            });
	    	}else{
		    	$(".iswrite").hide();
	    	}
	    });
	    
	  //选中时插入，取消时去除
	    form.on("checkbox(receiveItem)", function(data){
	    	var v=$(this).val();
	    	if(data.elem.checked){
	    		if ($.inArray(v,sel_a)==-1){
	                sel_a.push(v);
		        }
	    	}else{
	             for(var i=0;i<=sel_a.length-1;i++){
	                 if(sel_a[i]==v){
	                     sel_a.splice(i,1);
	                 }
	             }
	    	}
	    	//更新已选数目
	    	$("#isSelectNum").html(sel_a.length);
	    	console.log(sel_a);
	    });
	    
	    form.on("submit(save)",function(data){
	    	if($("#menuname").val() == ""){
	            layer.open({
	                title:"提示",
	                content:"您还没有填写名称"
	            })
	        }else if($("#type").val() == ""){
	            layer.open({
	                title:"提示",
	                content:"您还没有选择类型"
	            })
	        }else {
	        	$.ajax({
		            url:"<%=request.getContextPath() %>/menu/saveInfo.do",
		            data:$("#newForm").serialize(),
		            type:"POST",
		            success:function(msg){
		                if(msg.success == 1){
		                	layer.msg('保存成功', {icon: 1});
		                	setTimeout(function(){
		    					close();
		    				},700);
		                }else if(msg.success == 0){
		                	top.layer.msg(msg.data, {icon: 1});
		    				setTimeout(function(){
		    					close();
		    				},1000);
		                }
		            }
		        });
	        }
	       return false;
	    });
	    
	  //加载所有接收单位数据
	    var getReceiveList = function(){
	    	$.ajax({
	            url:"<%=request.getContextPath() %>/organization/museum/getMuseunListData.do",
	            data:$("#newForm").serialize(),
	            type:"POST",
	            success:function(msg){
	                if(msg.success == 1){
	                	var list = msg.data;
	                	$("#showReceive").html("");
	                	//更新总数
	                	$("#totalNum").html(list.length);
	                	//更新已选数目
	                	$("#isSelectNum").html(sel_a.length);
	                	for (var i = 0; i < list.length; i++) {
	     	            	//console.log($.inArray(list[i].id,sel_a));
	                		if ($.inArray(list[i].id+"",sel_a)==-1){
// 	                 			console.log("未选中======"+list[i].id);
	    						$("#showReceive").append('<input type="checkbox" lay-filter="receiveItem" class="receiveItem" name="receiveOrg" value=\"'+list[i].id+'\" title=\"'+list[i].name+'\">');
	    	                }else{
// 	    	                	console.log("选中======"+list[i].id);
	    						$("#showReceive").append('<input type="checkbox" lay-filter="receiveItem" class="receiveItem" name="receiveOrg" value=\"'+list[i].id+'\" title=\"'+list[i].name+'\" checked>');
	    	                }
	    				}
	                 	form.render();
	                }else if(msg.success == 0){
	                	layer.msg("系统错误", {icon: 1});
	                }
	            }
	        });
	    }
	  
		//选择所有	  
	  	var setSelectAll = function(){
	  		$.ajax({
	            url:"<%=request.getContextPath() %>/organization/museum/getMuseunListData.do",
	            data:{},
	            type:"POST",
	            success:function(msg){
	                if(msg.success == 1){
	                	var list = msg.data;
	                	$("#showReceive").html("");
	                	sel_a = [];
	                	for (var i = 0; i < list.length; i++) {
	                		if ($.inArray(list[i].id+"",sel_a)==-1){
	        	                sel_a.push(list[i].id+"");
	        		        }
    						$("#showReceive").append('<input type="checkbox" lay-filter="receiveItem" class="receiveItem" name="receiveOrg" value=\"'+list[i].id+'\" title=\"'+list[i].name+'\" checked>');
	    				}
	                 	form.render();
	                	//更新总数
	                	$("#totalNum").html(list.length);
	                	//更新已选数目
	                	$("#isSelectNum").html(sel_a.length);
	                }else if(msg.success == 0){
	                	layer.msg("系统错误", {icon: 1});
	                }
	            }
	        });
	  	}

	    /**
	     * 设置区域下拉选项
	     */
	    var setTownData = function(){
	    	$.ajax({
	            url:"<%=request.getContextPath() %>/notice/publish/getTownData.do",
	            data:{},
	            type:"POST",
	            success:function(msg){
	                if(msg.success == 1){
	                	var list = msg.data;
	                	$("#town").empty();
	    				$("#town").append("<option value=''>请选择区域</option>");
	                	for (var i = 0; i < list.length; i++) {
//	     	            	console.log(list[i].id);
	    					$("#town").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>");
	    				}
	                 	form.render();
	                }else if(msg.success == 0){
	                	layer.msg("系统错误", {icon: 1});
	                }
	            }
	        });
	    }
	    //获取父页面选中的数据
	    if(parent.sel_receive != undefined){
		    sel_a = parent.sel_receive;
	    }
	    console.log(sel_a);
		//设置区域下拉框数据
		setTownData();
	    //获取接收单位数据
	    getReceiveList();
	    $('#key').on('input propertychange', function() {
	    	getReceiveList();
	    });
	    form.on('select(select_search)',function(data){
			getReceiveList();
		});
// 	    form.on('select(select_search)',function(data){
// 			getReceiveList();
// 		});
	    //确认选择
	    form.on('submit(confirmSelect)',function(data){
	    	parent.setSelReceive(sel_a);
	    	var index = parent.layui.layer.getFrameIndex(window.name); //获取窗口索引
	    	parent.layui.layer.close(index);//关闭弹出的子页面窗口
			return false;
		});
	    //清空
	    form.on('submit(reset)',function(data){
	    	sel_a=[];
	    	$("#selectAll").removeAttr("checked");
	    	//获取接收单位数据
		    getReceiveList();
			return false;
		});
	    //选择所有
	    form.on('checkbox(selectAll)',function(data){
	    	if(data.elem.checked){
		    	$("#key").val("");
		    	$("#town").val("");
		    	$("#orgTypeId").val("");
		    	setSelectAll();
	    	}else{
	    		sel_a=[];
		    	//获取接收单位数据
			    getReceiveList();
	    	}
			return false;
		});
	    //全选当前页面
	    form.on('submit(selectCurrentAll)',function(data){
	    	$(".receiveItem").each(function(index, item){
    			var v = $(this).val();
	    		if(item.checked){
	    		}else{
	    			$(this).prop('checked', true);
	    			if ($.inArray(v,sel_a)==-1){
		                sel_a.push(v);
			        }
	    		}
	    	});
	    	form.render();
	    	console.log(sel_a);
	    	//更新已选数目
        	$("#isSelectNum").html(sel_a.length);
			return false;
		});
	    //当前页面反选
	    form.on('submit(backSelect)',function(data){
	    	$(".receiveItem").each(function(index, item){
    			var v = $(this).val();
    			console.log("当前item："+item.checked);
	    		if(item.checked == true){
	    			$(this).removeAttr("checked");
	    			if ($.inArray(v,sel_a)==-1){
			        }else{
		    			for(var i=0;i<=sel_a.length-1;i++){
			                 if(sel_a[i]==(v)){
			                     sel_a.splice(i,1);
			                 }
			             }
			        }
	    		}else{
	    			$(this).prop('checked', true);
	    			if ($.inArray(v,sel_a)==-1){
		                sel_a.push(v);
			        }
	    		}
	    	});
	    	form.render();
	    	console.log(sel_a);
	    	//更新已选数目
        	$("#isSelectNum").html(sel_a.length);
			return false;
		});
	})
	
});

</script>
</body>
</html>