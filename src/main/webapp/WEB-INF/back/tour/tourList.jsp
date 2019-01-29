<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.io.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	String mobileIp = pro.getProperty("mobile.rootpath"); 
%>

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
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        .laytable-cell-1-imgUrl{  /*最后的pic为字段的field*/
	      height: 100%;
	    }
	    .layui-icon{
	    	margin-right: 0px !important;
	    }
	    .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
		     top: 50%;
		     transform: translateY(-50%);
		}
    </style>
    <title>导览-列表</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
            	<div class="layui-input-inline">
            		<input class="layui-input inputText" placeholder="请输入展览名称" type="text" id="name" name="name">
            	</div>
            	<div class="layui-input-inline" style="width: 100px;height: ">
	            	<select class="layui-select" name="status" id="status">
	            		<option value="">发布状态</option>
						<option value="2">已发布</option>
						<option value="1">待发布</option>
					</select>
            	</div>

				<c:if test="${orgType == 0}">
					<div class="layui-input-inline">
						<select class="layui-select" name="publishOrg" id="publishOrg">
							<option value="">所属单位</option>
								<c:forEach items="${orgList}" var="mus" varStatus="row">
									<option value="${mus.id}">${mus.name}</option>
								</c:forEach>
						</select>
					</div>
				</c:if>
            	<div class="layui-input-inline" >
	                <button class="layui-btn search_btn" type="button">搜索</button>
					<button class="layui-btn reset_btn" type="reset">重置</button>
               </div>
				<div class="layui-input-inline" style="width: 400px"></div>
				<div class="layui-input-inline" style="margin-right: auto	">
					<button class="layui-btn " type="button" onclick="goTheme()">引用专题</button>
					<button class="layui-btn " type="button" onclick="goAdd()">新增导览</button>
				</div>
            </div>
        </form>
    </blockquote>
    <table id="tourList" lay-filter="tourList"></table>
    
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/downImg.js"></script>
<script type="text/javascript">
	layui.use(['form','layer','table', 'laydate'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
		laydate = layui.laydate;
		
		//导览列表
	    var tableIns = table.render({
	        elem: '#tourList',
	        url : '<%=request.getContextPath() %>/tour/getListData.do',
	        cellMinWidth : 80,
	        request:{
                pageName: 'currentPage',
                limitName: 'size'
            },
	        page : true,
	        limits : [10,20,25],
	        limit : 10,
	        id : "tourListTable",
	        cols : [[
	        	{type:'checkbox'},
	            {type:"numbers", title: '序号',align:"center"},
	            {field: 'name', title: '导览名称'},
	            {field: 'address', title: '地址'},
	            {field: 'label', title: '标签'},
	            {field: 'publishOrgName', title: '所属单位'},
	            {field: 'publishOrgName', title: '二维码',templet:function(d){
	            	var html='';
	            	if(d.status == '2'){
	            		html += '<a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo(\''+d.id+'\',this,\''+d.name+'\')"  title="二维码">';
	            		html += '<img src="<%=request.getContextPath() %>/back/images/erweima.png"/>';
	            		html += '</a>';
	            		
	            	}
	            	return html;
	            }},
	            {field: 'createdTime',width:120, title: '录入时间', templet:function(d){
	            	if(d.createdTime == null){
	            		return "-";
	            	}else{
	            		return timestampToTime(d.createdTime);
	            	}
	            }},
	            {field: 'status', title: '状态', templet:function(d){
	            	if(d.status == '1'){
	            		return '<button class="layui-btn layui-btn-normal layui-btn-xs">未提交</button>';
	            	}else if(d.status == '2'){
	            		return '<button class="layui-btn  layui-btn-xs">已发布</button>';
	            	}else if(d.status == '3'){
                        return '<button class="layui-btn  layui-btn-xs layui-btn-warm">提交待审核</button>';
                    }else if(d.status == '4'){
                        return '<button class="layui-btn  layui-btn-xs  layui-btn-danger">已驳回</button>';
                    }
	            	else{
	            		return "-";
	            	}
	            }},
	            {width:240,title: '操作',align:"center",fixed: 'right',templet:function(d){
                    var html = '';
                    html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');"  title="预览">预览</a>';
                    <c:if test="${orgType == 1}">
						if(d.status == '1' || d.status == '4' ){
							html += '<a class="layui-btn layui-btn-xs"  href="javascript:submitApproval(\''+d.id+'\');" title="提交审批">提交审批</a>';
							html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
							html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteTour(\''+d.id+'\');" title="删除">删除</a>';
						}else if(d.status == '2'){
							html += '<a class="layui-btn layui-btn-xs"  href="javascript:unpub(\''+d.id+'\');" title="取消发布">取消发布</a>';
						}else if(d.status == '3'){
                            html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteTour(\''+d.id+'\');" title="删除">删除</a>';
                        }
					</c:if>
                    <c:if test="${orgType == 0}">
	                    if(d.status == '1' || d.status == '4' ){
							html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish1(\''+d.id+'\');" title="发布">发布</a>';
							html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
							html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteTour(\''+d.id+'\');" title="删除">删除</a>';
						}else if(d.status == '2'){
							if('${orgId}' == d.publishOrg){
								html += '<a class="layui-btn layui-btn-xs"  href="javascript:unpub(\''+d.id+'\');" title="取消发布">取消发布</a>';
							}else{
								html += '<a class="layui-btn layui-btn-xs"  href="javascript:submitApproval1(\''+d.id+'\');" title="取消发布">取消发布</a>';
							}
						}else if(d.status == '3'){
                            html += '<a class="layui-btn layui-btn-xs"  href="javascript:approval(\''+d.id+'\');" title="审批">审批</a>';
	                    }
                    </c:if>
	            	return html;
	            }}
	        ]]
	    });
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
                     name: $("#name").val(),  //搜索的关键字
	                 status: $("#status").val(),  //状态
                     publishOrg: $("#publishOrg").val()  //博物馆id
	             }
	         })
	    });

		//重置
        $(".reset_btn").on("click",function(){
			$("#name").val("");
            $("#publishOrg").val("");
            $("#status").val("");
            tableIns.reload({
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    name: $("#name").val(),  //搜索的关键字
                    status: $("#status").val(),  //状态
                    publishOrg: $("#publishOrg").val()  //博物馆id
                }
            })
        });

	  //去新增页面
		  window.goAdd = function(){
			  var index = layui.layer.open({
			      title : "新增导览",
			      type : 2,
			      content : "<%=request.getContextPath() %>/tour/goAdd.do",
			      area: ['500px', '300px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
					  //自适应高度
				  	  resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回藏品专题列表', '.layui-layer-setwin .layui-layer-close', {
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
	  //去编辑页面
  		window.goEdit = function(id){
		  var index = layui.layer.open({
		      title : "编辑藏品专题",
		      type : 2,
		      content : "<%=request.getContextPath() %>/tour/goEdit.do?id="+id,
		      area: ['700px', '750px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
					//自适应高度
			  	  	resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回藏品专题列表', '.layui-layer-setwin .layui-layer-close', {
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
		  layui.layer.full(index);
	      window.sessionStorage.setItem("index",index);
	 }

        //去应用主题页面
        window.goTheme = function(){
            var index = layui.layer.open({
                title : "引用主题",
                type : 2,
                content : "<%=request.getContextPath() %>/tour/goTheme.do",
                area: ['800px', '800px'],
                success : function(layero,index,data1){
                    var body = layui.layer.getChildFrame('body', index);
                    //自适应高度
                    resizeLayer(index);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回导览列表', '.layui-layer-setwin .layui-layer-close', {
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
            layui.layer.full(index);
            window.sessionStorage.setItem("index",index);
        }
		//删除
		window.deleteTour= function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/tour/deleteTour.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('删除成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//发布
		window.pub = function(id){
			layer.confirm("确认要发布吗", { title: "发布确认" }, function (index) {
		      layer.close(index);
		      updatePublish(id);
		  });
		}
		//取消发布
		window.unpub = function(id){
			layer.confirm("确认要取消发布吗", { title: "取消发布确认" }, function (index) {
		      layer.close(index);
		      updatePublish(id);
		  });
		}
		
		//发布获取取消发布
		function updatePublish(id){
			$.post("<%=request.getContextPath() %>/tour/publishTopic.do", { id: id }, function (data) {
		          if(data == 'success'){
		          	layer.msg('操作成功');
		          }else if(data == 'error'){
		          	layer.msg(data);
		          }
		          tableIns.reload();
		      }); 
		}

        window.submitApproval = function(id){

            layer.confirm("确认要提交审批吗", { title: "确认" }, function (index) {
                layer.close(index);
                $.post("<%=request.getContextPath() %>/tour/submitApproval.do", { id: id }, function (data) {
                    if(data.code == 1){
                        layer.msg('提交成功');
                    }else if(data.code == 0){
                        layer.msg(data.msg);
                    }
                    tableIns.reload();
                });
            });
		}
        window.submitApproval1 = function(id){

            layer.confirm("确认要取消发布吗", { title: "确认" }, function (index) {
                layer.close(index);
                $.post("<%=request.getContextPath() %>/tour/submitApproval.do", { id: id }, function (data) {
                    if(data.code == 1){
                        layer.msg('取消成功');
                    }else if(data.code == 0){
                        layer.msg(data.msg);
                    }
                    tableIns.reload();
                });
            });
		}

        /**
		 * 审批
         * @param id
         */
		window.approval = function (id) {
            layer.open({
                type: 2,
                title: '审批',
                shadeClose: true,
                shade: 0,
                area: ['330px', '170px'],
                content: "<%=request.getContextPath() %>/tour/getApprovalUrl.do?tourId="+id,
                // cancel:function() {
                //     tableIns.reload();
                // },
                end:function() {
                    tableIns.reload();
                }
            });
        }
        
		//提交审核
		window.publish1 = function(id){
			layer.confirm("确认要发布吗？", { title: "发布确认" }, function (index) {
		      layer.close(index);
		      $.ajax({
	                url:"<%=request.getContextPath() %>/tour/approvalTour.do",
	                data:{
	                    status : "1",
	                    tourId : id
	                },
	                type:"POST",
	                success:function(msg){
	                    if(msg.success == 1){
	                    	layer.msg('发布成功');
	                    }else{
	                        layer.msg(msg.data);
	                    }
	                }
	            });
       		  tableIns.reload();
		  });
		}
		
	});
	//时间戳转时间格式
	function timestampToTime(obj) {
		var date =  new Date(obj);
	    var y = 1900+date.getYear();
	    var m = "0"+(date.getMonth()+1);
	    var d = "0"+date.getDate();
	    var h = date.getHours() + ':';
	    var mi = date.getMinutes();
	    var s = date.getSeconds();
	    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
	}
	
	function makeCodeInfo(elText,thisTd,imgName) {
		debugger
        console.log(elText)
		var name = $(thisTd).parents("td").siblings(".name").html();
		 if (elText == null) {
			alert("沒有普查编号，没法生成二维码。");
			elText.focus();
			return;
		}
		 layer.open({
			  type: 1,
              title:name,
              area:['470px','390px'],
			  content: "<div id='qrcode' style='padding:20px 100px;text-align:center;'></div>"+
                       "<a id='download' download='qrcode.jpg'></a>"+
                       "<button class='btn button btn-primary size-S' id='downQrcode' style='float: right;margin-right: 15px;margin-bottom: 10px;'>下载</button>"+ 
						"<button class='btn button btn-primary size-S' id='printQrcode' style='float: right;margin-right: 15px;margin-bottom: 10px;'>打印</button>"+
						"<button class='btn button btn-primary size-S' id='copyUrl' style='float: right;margin-right: 15px;margin-bottom: 10px;'>复制链接</button>"
			});
		  var qrcode = new QRCode(document.getElementById("qrcode"), {
                text:name,
				width : 270,
				height : 270
			});
			  var elText1 = '<%=mobileIp%>/guideDetail?id='+elText;
			  $.ajax({
		             type: "GET",
		             url: "<%=request.getContextPath() %>/createTwoDimensionCode.do",
		             data: {content:elText1, picCollectionPicUrl:''},
		             dataType: "json",
		             success: function(data){
		            	console.log(data);
				    	url = data.data;
				    	$("#qrcode").html("<img style='width:270px;height:270px;' src="+url+" />");
				    	$("#download").attr("href",url);
		             }
		         });

        //下载
        $("#downQrcode").click(function(){
        	<%-- var form = $("<form>");   //定义一个form表单
	        form.attr('style','display:none');   //在form表单中添加查询参数
	        form.attr('target','');
	        form.attr('method','post');
	        form.attr('action',"<%=request.getContextPath() %>/download/downLoadImage.do");
	       
	        var input1 = $('<input>'); 
	        input1.attr('type','hidden'); 
	        input1.attr('name','urlImage'); 
	        input1.attr('value',url); 
	        
	        var input2 = $('<input>'); 
	        input2.attr('type','hidden'); 
	        input2.attr('name','name'); 
	        input2.attr('value',imgName); 
	       
	        $('body').append(form);  //将表单放置在web中
	        form.append(input1);   //将查询参数控件提交到表单上
	        form.append(input2);
	        form.submit();   //表单提交 --%>
	        var e = $("#download");
	        downImg(e,url);
	        
	      	return false;
        })
        $("#printQrcode").click(function() {
				$("#qrcode").print({
					globalStyles: false,
				    mediaPrint: false,
				    stylesheet: null,
				    noPrintSelector: ".no-print",
				    iframe: false,
				    append: null,
				    prepend: null,
				    deferred: $.Deferred()
				})
			})
		$("#copyUrl").click(function() {
			var clipboard = new Clipboard('#copyUrl', {
			        text: function() {
			            return elText1;
			        }
			    });
		    clipboard.on('success',
		    function(e) {
		        top.layer.msg("复制成功");
		    });
		})

	}


</script>
</body>
</html>