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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <style type="text/css"> 
        *{
            margin: 0;
            padding: 0;
        }
        .a1{
            width: 394px;
            height: 414px;
            /* border:1px solid #e0e0e0; */
            padding: 15px 10px 0;
            margin-left: 100px;
        }
        .a2{
            height:70px;
            background-color: #f9f9f9;
            text-align: center;
        }
        .a2 img{
            width: 130px;
            transform: translateY(22px);
            cursor: pointer;
        }
        .a3{
            width: 450px;
            overflow: hidden;
            transform: translateX(-25px);
            margin-top: 12px;
        }
        .a4{
            width: 600px;
            height: 400px;
            overflow-y: scroll;
            overflow-x: hidden;
            padding-bottom: 30px;
        }
        .a5{
            height:68px;
            width: 394px;
            background-color: #f9f9f9;
            margin-top: 12px;
            transition: all 0.5s;
            margin-left: 25px;
            cursor: pointer;
        }
        .a5:nth-child(1){
            margin-top: 0;
        }
        .a5:hover{
            transform: translate3d(0,0,1000px);
            box-shadow: 0 0 15px #ddd;
        }
        .a5 img{
            display: inline-block;
            float: left;
            width: 40px;
            height: 40px;
            margin-left: 18px;
            margin-top: 14px;
        }
        .a6{
            font-size: 12px;
            float: left;
            margin-left: 10px;
            margin-top: 14px;
        }
        .a7{
            color: #666;
        }
        .a8{
            color: #ccc;
            margin-top: 8px;
        }
    </style>
    <title>转发页面</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;padding:10px;">
<div class="a1">
	<input type="hidden" id="type" name ="type" value="${type}"/>
 	<div class="a2"><img src="<%=request.getContextPath() %>/back/images/aa.svg"  onclick="goAddTopic()" alt=""></div>
    <div class="a3">
        <div class="a4" id="getTopicLis">
            <!-- <div class="a5">
                <img src="img/jlydd.png " alt="">
                <div class="a6">
                    <div class="a7">宫廷艺术品</div>
                    <div class="a8">32件</div>
                </div>
            </div> -->
        </div>
    </div>
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
<script type="text/javascript">
$(function(){
	orgId = '${orgId}';
	id = '${id}';
	topicId = '${topicId}';
	//初始化专题列表
	init();
});	

function init(){
	
	 $("#getTopicLis").html("");
	 debugger;
	 $.ajax({
			url : "<%=request.getContextPath()%>/topic/getTopicLis.do",
			type : "post",
			data :  {orgId:orgId,topicId:topicId},
			dataType : "json",
			success : function(data){
				if(data.success==1){
					var arr = data.data;
					for(var i=0;i<arr.length;i++){
						var html =  "<div class='a5' onclick='addToTopic(\""+arr[i].id+"\")'>";
							html += "<img src="+arr[i].iconUrl+" alt=''>";
							html += "<div class='a6'>";
							html += "<div class='a7'>"+arr[i].name+"</div>";
							html += "<div class='a8'>"+arr[i].collectionCount+"件</div>";
							html += "</div>";
							html += "</div>";
						$("#getTopicLis").append(html);
					}
				}else{
					layer.msg('获取专题列表失败', {icon: 2});
				}
			},
	 })
}


function addToTopic(topicId) {
	var type = $("#type").val();
	 $.ajax({
			url : "<%=request.getContextPath()%>/topic/addToTopic.do",
			type : "post",
			data :  {id:id,topicId:topicId,type:type},
			dataType : "json",
			success : function(data){
				if(data.success==1){
					layer.msg('添加成功', {icon: 1});
					setTimeout(function(){
						init(orgId);
					},1000)
				}else if(data.success==2){
					layer.msg(data.data, {icon: 6});
				}else{
					layer.msg('添加失败', {icon: 2});
				}
			},
		})
}

function goAddTopic() {
	var url = "<%=request.getContextPath() %>/topic/goAddTopic.do";
    layer.open({
        type: 2,
        title: '添加专题',
        shadeClose: true,
        shade: 0.5,
        maxmin: true, //开启最大化最小化按钮
        area: ['400px', '300px'],
        content: [url,'no'],
        end: function () {
        	
        }
    });
	
};

</script>
</body>
</html>