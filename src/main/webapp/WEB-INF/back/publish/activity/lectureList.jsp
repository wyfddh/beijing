<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.io.*"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
 <%
	Properties pro = new Properties(); 
	String realpath = request.getRealPath("/WEB-INF/classes"); 
	try{  
		//读取配置文件
		FileInputStream in = new FileInputStream(realpath+"/config.properties"); 
		pro.load(new InputStreamReader(in, "UTF-8")); 
	}
	catch(FileNotFoundException e){ 
		 out.println(e); 
	} 
	catch(IOException e){
		out.println(e);
	} 

	//通过key获取配置文件
	String webIp = pro.getProperty("pc.ip"); 
%> 
 <!DOCTYPE html>
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
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <style type="text/css">
		.laytable-cell-1-pictureId{  /*最后的pic为字段的field*/
	      height: 100%;
			/*max-width: 100%; */
	    }

    </style>
    <title>学术讲座列表</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;padding:10px;">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form" id="myform"> 
        <input type="hidden" id="level" name="level" value="${level}">
	            <div class="layui-inline">
	                <div class="layui-input-inline">
	                    <input type="text" class="layui-input searchVal" placeholder="请输入讲座标题/内容"  name="key" id="key"/>
	                </div>	
	                <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="publishTime" name="publishTime" placeholder="发布日期范围 ">
			      	</div>                
	                <div class="layui-input-inline">
	                    <select id="status" name="status">
	                      	<option value="">发布状态</option>
                        	<option value="0">未发布</option>
                        	<option value="1">已发布</option>
	                    </select>
	                </div>
	                <a class="layui-btn search_btn search" data-type="reload"  name="search">搜索</a>
	                <a class="layui-btn layui-btn-primary reset" data-type="reload" name="reset" style="margin-left:0px">重置</a>
                	<input type="reset" id="reset" value="重置" hidden>
	            </div>
	            <div class="layui-inline a2">
                	<a class="layui-btn " onclick="add()">新增学术讲座</a>
            	</div>	            
    		</form> 
  	</blockquote>  	           
     <div>
         <table class="layui-hide" id="activityList"></table>                
     </div>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table','laytpl','laydate'],function(){
	     	form = layui.form,
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery,
	        laytpl = layui.laytpl,
	        table = layui.table,
	        laydate = layui.laydate;
	})	
	//日期范围
	laydate.render({
	    elem: '#publishTime'
	    ,type: 'datetime'
	    ,range: true
	 });
	var level = $("#level").val();
   tableIns = table.render({
	    elem: '#activityList',
	    url:'<%=request.getContextPath() %>/activityAdmin/getActivityList.do?type=2',
	    request:{
        	pageName: 'currentPage',
        	limitName: 'size'
	     },
	    page : true,
	    limits : [10,15,20,25],
        limit : 10,
	    cols: [[
	       {type:'numbers'}
       	  ,{field: 'pictureId', title: '标题图片', align:"center", templet:function(d){
	           	if(d.pictureId != undefined && d.pictureId != ''){
		            	return '<img style="max-width:150px;max-height:60px;" src="' + d.pictureId + '">';
	           	}else{
	           		return "-"
	           	}
           }}
	      ,{field:'activityName',title: '讲座标题'}	 
	      ,{field:'activityTime', title: '讲座时间'}
	      ,{field:'orgName', title: '发布单位'}
	      ,{field:'publishTime', title: '发布时间', templet:function(d){
	    	  if(d.status=='0'){
	        		return "-";
	        	}else{
	        		 return timestampToTime(d.publishTime);
	        	}
      		}}
	      ,{field:'status',title: '状态', templet:function(d){
	    	  if(d.status == '0'){
	          		return "<span style='color:#0099ff;'>未提交</span>";
	          	}else if(d.status == '1'){
	          		return "<span style='color:#0099ff;'>已发布</span>";
	          	}else if(d.status == '3'){
	          		return "<span style='color:#0099ff;'>待审批</span>";
	          	}else if(d.status == '4'){
	          		return '<a style="color:red;" href="javascript:sendBack(\''+d.id+'\',\''+d.message+'\');">已驳回</a>';
	          	}else {
	          		return "-";
	          	}
    		}}
	      ,{title: '操作',width:240,style:"height:70px;",fixed:'right',align:"center",templet:function(d){
          	var html = ''; 
          	html += '<a class="layui-btn layui-btn-primary layui-btn-xs" href="javascript:view(\''+d.id+'\');"  title="预览">预览</a>';
          	if(level == '1'){
          		if(d.status=='0' || d.status == '4'){
	   		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
	   		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:edit(\''+d.id+'\');" title="编辑">编辑</a>';
	       			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:del(\''+d.id+'\');" title="删除">删除</a>';
          		}else if(d.status=='1'){
	    	  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publishBack(\''+d.id+'\');" title="取消发布">取消发布</a>';
          		}else if(d.status == '3'){
	       			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:del(\''+d.id+'\');" title="删除">删除</a>';
          		}
          	}else if(level == '2'){
          		if(d.status=='0'){
	   		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish1(\''+d.id+'\');" title="发布">发布</a>';
	   		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:edit(\''+d.id+'\');" title="编辑">编辑</a>';
	       			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:del(\''+d.id+'\');" title="删除">删除</a>';
          		}else if(d.status=='1'){
          			if('${orgId}' == d.orgId){
		    	  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publishBack(\''+d.id+'\');" title="取消发布">取消发布</a>';
          			}else{
		    	  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData1(\''+d.id+'\');" title="取消发布">取消发布</a>';
          			}
          		}else if(d.status == '3'){
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish(\''+d.id+'\');" title="审批">审批</a>';
          		}
          	}
          	return html;
        }}
	    ]]
	  }); 
 
})

function reloadTable() {
	tableIns.reload({
		  where: { //设定异步数据接口的额外参数，任意设
			  key: $("#key").val(),
			  publishTime: $("#publishTime").val(),
			  status: $("#status").val()
		  }
		  ,page: {
		    curr: 1 //重新从第 1 页开始
		  }
		});
}

$(".search").click(function() {
	reloadTable();
})
//点击重置
$(".reset").click(function(){
    	$("#key").val('') ; 
    	$("#publishTime").val('');
		$("#status").val('');
    	form.render();
    	reloadTable();
});

function add(){
    var index = layui.layer.open({
        type: 2,
        title: '新增讲座',
        area: ['70%', '850px'],
        content: "<%=request.getContextPath() %>/activityAdmin/toLectureAdd.do",
        success : function(layero,index){
        	var body = layui.layer.getChildFrame('body', index);
	  		resizeLayer(index);	           
		},
        end: function () {
        	reloadTable();
        }
    });
    layui.layer.full(index);
    window.sessionStorage.setItem("index",index);
}

function edit(id){
    var index = layui.layer.open({
        type: 2,
        title: '编辑讲座',
        shadeClose: true,
        content: "<%=request.getContextPath() %>/activityAdmin/toLectureUpdate.do?id="+id,
        success : function(layero,index){
        	var body = layui.layer.getChildFrame('body', index);
	  		resizeLayer(index);	           
		},
        end: function () {
        	reloadTable();
        }
    });
    layui.layer.full(index);
    window.sessionStorage.setItem("index",index);
}
function del(id){
	layer.confirm("确认要删除吗", { title: "删除确认" }, function (index) {
	      layer.close(index);	     
	      $.ajax({
	            url:"<%=request.getContextPath() %>/activityAdmin/deleteActivity.do?id="+id,
	            type:"get",
	            success:function(msg){
	                if(msg.code == 1){
	                	layer.msg('删除成功');
	                	setTimeout(function(){
	                		parent.layer.closeAll();
	    				},700);
	                }else{
	                	layer.msg(msg.msg);
	                }
	                tableIns.reload();
	            }
	        });
	      
	  });
}

function publish(id,status){
	
	var index = layui.layer.open({
	      title : "编辑内容",
	      type : 2,
	      content : "<%=request.getContextPath() %>/cmsArticel/goPublish.do?id="+id+"&type=edit&tableName=mip_activity&message=",
		  area: ["700px", "500px"],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
		  		//自适应高度
		  		resizeLayer(index);
	            setTimeout(function(){
	                layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
	                    tips: 3
	                });
	            },500)
			},
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      },
	      end :function() {
	    	  tableIns.reload();
       }
	  });
	
}
//预览
window.view = function(id){
	window.open("<%=webIp %>html/jiangzuo.html?bg="+id);
}

//时间戳转时间格式
function timestampToTime(timestamp) {
	console.log(timestamp);
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate()) + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D;
}

//取消发布
function publishBack(id){
	var status = '0';
	layer.confirm("确认要取消发布吗", { title: "取消发布确认" }, function (index) {
	      layer.close(index);	     
	      $.ajax({
	            url:"<%=request.getContextPath() %>/activityAdmin/publishActivity.do?id="+id+"&status="+status,
	            type:"get",
	            success:function(msg){
	                if(msg.code == 1){
	                	layer.msg('取消发布成功');
	                	setTimeout(function(){
	                		parent.layer.closeAll();
	    				},700);
	                }else{
	                	layer.msg(msg.msg);
	                }
	                tableIns.reload();
	            }
	        });
	      
	  });
}

//提交审核
function saveData(id){
	layer.confirm("确认要提交审批吗？", { title: "提交审批确认" }, function (index) {
      layer.close(index);
      //var sql = "update mip_activity set status = '3'  where id= "+"'"+id+"'";
      $.post("<%=request.getContextPath() %>/cmsArticel/saveData.do", { 'id': id,'tableName':'mip_activity'}, function (data) {
          if(data.code == 1){
          	layer.msg('提交成功');
          }else{
          	layer.msg(data.msg);
          }
          tableIns.reload();
      }); 
  });
}

//提交审核
function saveData1(id){
	layer.confirm("确认要取消发布吗？", { title: "取消发布确认" }, function (index) {
      layer.close(index);
      //var sql = "update mip_activity set status = '3'  where id= "+"'"+id+"'";
      $.post("<%=request.getContextPath() %>/cmsArticel/saveData.do", { 'id': id,'tableName':'mip_activity'}, function (data) {
          if(data.code == 1){
          	layer.msg('取消成功');
          }else{
          	layer.msg(data.msg);
          }
          tableIns.reload();
      }); 
  });
}

//驳回详情
function sendBack(id,message){   
	debugger
	var index = layui.layer.open({
	      title : "编辑内容",
	      type : 2,
	      content : "<%=request.getContextPath() %>/cmsArticel/goPublish.do?id="+id+"&type=view&message="+message,
		  area: ["700px", "500px"],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
		  		//自适应高度
		  		resizeLayer(index);
			},
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      },
	      end :function() {
	    	  tableIns.reload();
          }
	  });
}

//提交审核
window.publish1 = function(id){
	layer.confirm("确认要发布吗？", { title: "发布确认" }, function (index) {
      layer.close(index);
      $.post("<%=request.getContextPath() %>/cmsArticel/shenPi.do", 
    		  { 'tableName':'mip_activity','result':'1','message':'','id':id }, function (data) {
          if(data.code == 1){
          	layer.msg('发布成功');
          }else{
          	layer.msg(data.msg);
          }
          tableIns.reload();
      }); 
  });
}

//格式化时间
function filterTime(val){
    if(val < 10){
        return "0" + val;
    }else{
        return val;
    }
}
</script>
</body>
</html>