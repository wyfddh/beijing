<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
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
    <title>组织机构列表</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;padding:10px;">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form" id="myform">    
	            <div class="layui-inline">
	                <div class="layui-input-inline">
	                    <input type="text" class="layui-input searchVal" placeholder="请输入组织名称"  name="key" id="key"/>
	                </div>		                               
	                <div class="layui-input-inline">
	                    <select id="orgTypeId" name="orgTypeId">
	                      	<option value="">选择组织类型</option>
                        	<option value="1">文物局</option>
                        	<option value="2">区文委</option>
                        	<option value="3">博物馆</option>
                        	<option value="4">文物修复资质单位</option>
                        	<option value="5">其他文物收藏单位</option>
	                    </select>
	                </div>
	               	<div class="layui-input-inline">
	                    <select id="platformId" name="platformId">
	                      	<option value="">是否直属馆</option>
                        	<option value="1">是</option>
                        	<option value="0">否</option>
	                    </select>
	                </div>
	                <a class="layui-btn search_btn search" data-type="reload"  name="search">搜索</a>
	                <a class="layui-btn layui-btn-primary reset" data-type="reload" name="reset" style="margin-left:0px">重置</a>
                	<input type="reset" id="reset" value="重置" hidden>
	            </div>
	            <div class="layui-inline a2">
	           		<c:if test="${sessionScope.btn.add == 1 }">
			           <a class="layui-btn " onclick="add()">新增组织机构</a>
		        	</c:if>
            	</div>	            
    		</form> 
  	</blockquote>  	           
     <div>
         <table class="layui-hide" id="orgList"></table>                
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

	
   tableIns = table.render({
	    elem: '#orgList',
	    url:'<%=request.getContextPath() %>/organization/museum/getList.do',
	    request:{
        	pageName: 'currentPage',
        	limitName: 'size'
	     },
	    page : true,
	    
	    limits : [10,15,20,25],
        limit : 10,
	    cols: [[
	       {type:'numbers'}
	      ,{field:'name',title: '组织名称'}	      
	      ,{field:'baseName',title: '组织类型'}	      
	      ,{field:'parentId',title: '上级机构'}	
	      ,{field:'platformId',title: '是否直属馆', templet:function(d){
	    	  	if(d.platformId==0){
	        		return "否";
		        }else{
		        		return "是";
		        }
      		}}
	      ,{title: '操作',width:200,align:"center",fixed:'right',templet:function(d){
          	var html = ''; 
          	if('${sessionScope.btn.edit }' == '1'){
       			html += '<a class="layui-btn layui-btn-xs"  href="javascript:edit(\''+d.id+'\');" title="修改">修改</a>';
	    	}
	      	if('${sessionScope.btn.del }' == '1'){
       			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:del(\''+d.id+'\');" title="删除">删除</a>';
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
			  orgTypeId: $("#orgTypeId").val(),
			  platformId: $("#platformId").val()
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
    	$("#orgTypeId").val('') ; 
    	$("#platformId").val('') ;
    	form.render();
    	reloadTable();
});

function add(){
	var index = layui.layer.open({
        type: 2,
        title: '新建组织机构',
        area: ['40%', '600px'],
        content: "<%=request.getContextPath() %>/organization/museum/add.do",
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
//编辑
function edit(value){
	var index = layui.layer.open({
	    type: 2,
	    title: '编辑组织机构',
        area: ['40%', '600px'],
        content: '<%=request.getContextPath() %>/organization/museum/edit.do?relicOrganizationId='+value,
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

function del(id) {
	layer.confirm('确定删除此信息？', {
		  btn: ['确定','再想想'] //按钮
		}, function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/organization/museum/delete.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				async: false,
				success : function(data){
					if(data==1){
						layer.msg('成功删除', {icon: 1});
						setTimeout(function(){
							parent.layer.closeAll();
						},700)							
					}else if(data==2){
						layer.msg('该组织已存在用户，请先删除用户后操作', {icon: 2});
					}else{
						layer.msg('删除失败', {icon: 2});
					}
					tableIns.reload();
				}
			})
		}, function(){
		  layer.msg('已取消删除', {
		  });	
		});
}
	


</script>
</body>
</html>