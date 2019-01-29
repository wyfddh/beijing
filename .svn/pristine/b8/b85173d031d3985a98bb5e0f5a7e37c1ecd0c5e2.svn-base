<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义报表demo</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />

<%-- <link href="<%=request.getContextPath() %>/designPlug-in/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" /> --%>
</head>
<body>
    <div class="layui-container"> 
        <div class="layui-row">
            <div class="layui-col-md3">
			       <form class="layui-form">
			       <div class="layui-form-item layui-form-text">
				    <label class="layui-form-label">sql</label>
				    <div class="layui-input-block">
				      <textarea placeholder="请输入内容" class="layui-textarea" id="sql" name="desc"></textarea>
				    </div>
				  </div>
				  </form>
			</div>
		    <div class="layui-col-md9">
		      <div>
		          <button class="layui-btn"  id="addkey">添加字段</button>
		          <button class="layui-btn"  id="priview">预览</button>
		      </div>
		      <table id="demo" lay-filter="test"></table>
		      
		    </div>
        </div>
    </div>
    <input type="hidden" id="key">
    <input type="hidden" id="name">
    <input type="hidden" id="isValueKey">
    
    <div style="width:1000px;height:400px;" id="report"></div>
    <div style="width:1000px;height:400px;" id="report1"></div>
    <div style="width:1000px;height:400px;" id="report2"></div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/echarts/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/report/report.js"></script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" lay-filter="demo">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" lay-filter="demo">删除</a>
</script>
<script type="text/javascript">
// var convertData = [];
layui.use(['form', 'table'], function(){
	  var form = layui.form;
	  var table = layui.table;
	  var tableData = [];
	  table.render({
		    elem: '#demo'
		    ,cols: [[ //标题栏
		    	{type:'checkbox'},
		    	{type:"numbers", title: '序号', width:70, align:"center"},
		      {field: 'key', title: '字段名', width: 120}
		      ,{field: 'name', title: '字段中文名', minWidth: 150},
		      {field: 'isValueKey', title: '是否值字段', minWidth: 150},
		      {fixed: 'right', width:150, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
		    ]]
		    ,data: tableData
		    //,skin: 'line' //表格风格
		    ,even: true
		    //,page: true //是否显示分页
		    //,limits: [5, 7, 10]
		    //,limit: 5 //每页默认显示的数量
		  });
	    $("#priview").click(function(){
// 	    	var myChart = echarts.init(document.getElementById('report'));
// // 	         var convertData = {"area":"博物馆区域","count":"博物馆数量"};
	        var sql = $("#sql").val();
	        if(null == sql || sql == ""){
	        	layer.msg("请输入sql");
	        	return;
	        }
	        if(null == tableData || tableData.length == 0){
                layer.msg("请给出字段映射关系"); 
                return;
            }
	        myReport.getReportByType('report',sql,"文物级别统计",'pie',tableData);
// 	        var json = {"title":"北京市博物馆区域分布","sql":sql,"type":"line","convertData":tableData};
// 	        $.ajax({
<%-- 	            url:"<%=request.getContextPath()%>/report/getPreviewReport.do", --%>
// 	            type:"POST",  
// 	            dataType:"json",
// 	            contentType: "application/json",                 
// 	            data:JSON.stringify(json), 
// 	            success:function(data){
// 	                   var json = data.data;
// 	                var option = {
// 	                        title: {"text":"北京市博物馆区域分布"},
// 	                        tooltip: {},
// 	                        xAxis: {data:json.xAxis},
// 	                        yAxis: {},
// 	                        legend: json.legend,
// 	                        series: json.series
// 	                    };
// 	                // 使用刚指定的配置项和数据显示图表。
// 	                myChart.setOption(option);         
// 	            },
// 	            error:function(msg){

// 	            }
// 	      });
// 	        var myChart1 = echarts.init(document.getElementById('report1'));
// //	      var convertData = {"area":"博物馆区域","count":"博物馆数量"};
// 	      var json1 = {"title":"北京市博物馆区域分布","sql":sql,"type":"bar","convertData":tableData};
// 	     $.ajax({
<%-- 	         url:"<%=request.getContextPath()%>/report/getPreviewReport.do", --%>
// 	         type:"POST",  
//              dataType:"json",
//              contentType: "application/json",                 
//              data:JSON.stringify(json1), 
// 	         success:function(data){
// 	                var json = data.data;
// 	                console.log(json);
// 	             var option = {
// 	                     title: {"text":"北京市博物馆区域分布"},
// 	                     tooltip: {},
// 	                     xAxis: {data:json.xAxis},
// 	                     yAxis: {},
// 	                     legend: json.legend,
// 	                     series: json.series
// 	                 };
// 	             // 使用刚指定的配置项和数据显示图表。
// 	             myChart1.setOption(option);         
// 	         },
// 	         error:function(msg){

// 	         }
// 	   });
// 	        var myChart2 = echarts.init(document.getElementById('report2'));
// 	        var json2 = {"title":"北京市博物馆区域分布","sql":sql,"type":"pie","convertData":tableData};
// 	        $.ajax({
<%-- 	            url:"<%=request.getContextPath()%>/report/getPreviewReport.do", --%>
// 	            type:"POST",  
//                 dataType:"json",
//                 contentType: "application/json",                 
//                 data:JSON.stringify(json2), 
// 	            success:function(data){
// 	                   var json = data.data;
// 	                   console.log(json);
// 	                var option = {
// 	                        title: {"text":"北京市博物馆区域分布"},
// 	                        tooltip: {},
// 	                        legend: json.legend,
// 	                        series: json.series
// 	                    };
// 	                // 使用刚指定的配置项和数据显示图表。
// 	                myChart2.setOption(option);         
// 	            },
// 	            error:function(msg){

// 	            }
// 	      });
	    });
	     $("#addkey").click(function(){
	    	 var a = layer.open({
	             type: 2,
	             title: "添加字段",
	             area: ['1200px', '760px'],
	             content: ['<%=request.getContextPath() %>/report/addkey.do?type=add','yes'],
	             end :function(){
	                 var key = $("#key").val();
	                 var name = $("#name").val();
	                 var isValueKey = $("#isValueKey").val();
	                 var data = {"key":key,"name":name,"isValueKey":isValueKey};
	                 tableData.push(data);
	                 var newtableData = [];
	                 for (var i = 0; i < tableData.length; i++) {
						var temp = tableData[i];
						var json = {};
						json.key = temp.key;
						json.name = temp.name;
						if(temp.isValueKey==0){
							json.isValueKey = "否";
						}else{
							json.isValueKey = "是";
						}
						newtableData.push(json);
					}
	                 table.render({
	                     elem: '#demo'
	                     ,cols: [[ //标题栏
	                    	 {type:'checkbox'},
	                    	 {type:"numbers", title: '序号', width:70, align:"center"},
	                       {field: 'key', title: '字段名', width: 120}
	                       ,{field: 'name', title: '字段中文名', minWidth: 150}
	                       ,{field: 'isValueKey', title: '是否值字段', minWidth: 150}
	                       ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
	                     ]]
	                     ,data: newtableData
	                     //,skin: 'line' //表格风格
	                     ,even: true
	                     
	                   });
	             }
	             
	         });  
        });
	     
	     table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
	    	 var data = obj.data; //获得当前行数据
	    	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	    	  var tr = obj.tr; //获得当前行 tr 的DOM对象
	    	 if(layEvent === 'del'){ //删除
	    	    layer.confirm('真的删除行么', function(index){
	    	      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
	    	     for (var i = 0; i < tableData.length; i++) {
					if(tableData[i].key==data.key){
						tableData.splice(i, 1);
						break;
					}
				}
	    	      layer.close(index);
	    	      //向服务端发送删除指令
	    	    });
	    	  } else if(layEvent === 'edit'){ //编辑
	    		  var key = $("#key").val();
                  var name = $("#name").val();
                  var isValueKey = $("#isValueKey").val();
	    		  var a = layer.open({
	                  type: 2,
	                  title: "修改字段",
	                  area: ['1200px', '760px'],
	                  content: ['<%=request.getContextPath() %>/report/addkey.do?type=edit&key='+key+'&name='+name+'&isValueKey='+isValueKey,'yes'],
	                  end :function(){
	                      var key = $("#key").val();
	                      var name = $("#name").val();
	                      var isValueKey = $("#isValueKey").val();
	                      var data = {"key":key,"name":name,"isValueKey":isValueKey};
	                      var newtableData = [];
	                      for (var i = 0; i < tableData.length; i++) {
	                         var temp = tableData[i];
	                         var json = {};
	                         json.key = temp.key;
	                         json.name = temp.name;
	                         if(temp.isValueKey==0){
	                             json.isValueKey = "否";
	                         }else{
	                             json.isValueKey = "是";
	                         }
	                         if(temp.key == key){
	                        	 json.name = name;
	                        	 json.isValueKey = isValueKey;
	                         }
	                         newtableData.push(json);
	                     }
	                      table.render({
	                          elem: '#demo'
	                          ,cols: [[ //标题栏
	                              {type:'checkbox'},
	                              {type:"numbers", title: '序号', width:70, align:"center"},
	                            {field: 'key', title: '字段名', width: 120}
	                            ,{field: 'name', title: '字段中文名', minWidth: 150}
	                            ,{field: 'isValueKey', title: '是否值字段', minWidth: 150}
	                            ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
	                          ]]
	                          ,data: newtableData
	                          //,skin: 'line' //表格风格
	                          ,even: true
	                          
	                        });
	                  }
	                  
	              });
	    	    
	    	    //同步更新缓存对应的值
	    	    obj.update({
	    	      username: '123'
	    	      ,title: 'xxx'
	    	    });
	    	  }
	    	});
	    	 
	     
	});	
	
</script>
</body>
</html>