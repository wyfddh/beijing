<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String wwxxwip = "http://test.tj720.com/mip/pc/index.html#/displayDetails/inner/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico">
		<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/back/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
		   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
		<!--/meta 作为公共模版分离出去-->
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
		<style>
			.top{
			     height: 300px;
                border-radius: 7px;
                background: #fff;
                position: absolute;
                top: 0px;
                left: 145px;
                right: 0;
                bottom: 0;
                padding-left: 30px; 
			}	
			.mycontainer{
			     margin-left:1px;
			     margin-right:1px;
			}	
			.myrow{
			     margin-top:15px;
			     height:40px;
			}
			.main{
                border-radius: 7px;
                 background: #fff; 
                position: absolute;
                top: 320px;
                left: 145px;
                right: 0;
                bottom: 0;
                padding-left: 30px; 
/*                 background:url('../back/images/Group 3.png') no-repeat;  */
/*                 background-size:100% 100%; */
			}
			.images{
			 width:100px;
			 height:100px;
			 
			}
 			.img:hover .imgdiv{ 	
 			    display:block
 			} 
            .imgdiv{
                position: absolute;
                background: #ccc;
                height:100%;
                display:none;
                opacity:0.6;
            }
            .img{
               width:100px;
                height:100px; 
                margin:15px;
            }
            .imageList{
                font-size:25px;
                margin:15px;
            }
            .iconColor{
                color:rgba(243, 149, 29, 0.68);
                opacity:0.8;
            }
            .delete{
                position:absolute;
                left:1px;
                bottom:1px;
            }
            .show{
                position:absolute;
                right:1px;
                bottom:1px;
            }
            .addcollection{
                color:#004cffa3;
                margin-left:5px;
                font-weight:500;
            }
            .gocollectionList{
                color:#004cffa3;
                margin-left:5px;
                font-weight:500;
            }
            .empty{
                position:absolute;
                left:37%; 
                top:60%; 
                font-size: 14px;
                 font-weight: 550;
            }
            .picDiv{
                position:absolute;
                left:40%; 
                top:10%; 
            }
            .introduction{
                display: -webkit-box;
				-webkit-box-orient: vertical;
				-webkit-line-clamp: 3;
				overflow: hidden;
            }
            .imageInfo{
               
            }
            .labelcss label{
                font-weight:bold;
            }
		</style>
		
		<title>藏品专题库</title>
	</head>

	<body>

		<!--_menu 左边slide导航开始-->
		<%@ include file="../aside.jsp" %>
		<!--/_menu 作为公共模版分离出去-->
        <div class="top">	        	           
	               <div class="container mycontainer">
	                   <div class="row myrow">
	                       <div class="col-md-2">
	                          <img src="${topic.iconUrl}" id="iconUrl" onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/7259105_164349794186_2.jpg' " width="200px" height="200px">
	                       </div>
	                       <div class="col-md-10">
	                            <div class="row myrow">
                                   <div class="col-md-6 labelcss">
                                      <label id="name" style="font-size:16px;font-weight:bold;">${topic.name}</label>
<!--                                        <i class="Hui-iconfont">&#xe6cb;</i>  -->
                                       <a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo('${topic.id }',this,'${topic.name }')"  title="二维码">
                                                    <img src="<%=request.getContextPath() %>/back/images/erweima.png" alt="没有图片"/>
                                        </a>
                                       <input  type="hidden" value="${topic.id}" id="topicId">
                                   </div>
                                   <div class="col-md-6 labelcss">
                                        <div style="width:100%;height:100%;justify-content:center;">
                                            <c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true && (topic.status eq 1)}">
                                                <input class="btn btn-primary-outline radius size-s" type="button" id="edit" value="编辑">
                                            </c:if>
                                            <input class="btn btn-primary-outline radius size-s" type="button" id="back" onclick="javascript:history.go(-1);" value="返回上一页">
                                        </div>
                                   </div>
                               </div>
	                           <div class="row myrow">
	                               <div class="col-md-8">
	                                   <div class="row myrow">
	                                       <div class="col-md-6 labelcss">
	                                           <i class="Hui-iconfont">&#xe60d;</i>
		                                       <label>创建人</label>
		                                       <p id="publishOrg" style="color:gray;">${topic.orgname}</p>
		                                   </div>
		                                   <div class="col-md-6 labelcss">
		                                        <i class="Hui-iconfont">&#xe64b;</i>
		                                        <label>标签</label>
		                                        <p  style="color:gray;" >
		                                        <span id="label">
			                                        <c:if test="${topic.label ne null && topic.label!=''}">${topic.label}</c:if>
			                                        <c:if test="${topic.label == null || topic.label ==''}">暂无标签</c:if>
		                                        </span>
		                                        </p>
		                                   </div>
	                                   </div>
	                                   <br>
		                               <div class="row myrow">
		                                   <div class="col-md-6 labelcss">
		                                        <i class="Hui-iconfont">&#xe6c9;</i>
		                                        <label>展厅</label>
		                                        <p id="exhibitionHall" style="color:gray;">${topic.exhibitionHall}</p>
		                                   </div>
		                                   <div class="col-md-6 labelcss">
		                                        <i class="Hui-iconfont">&#xe690;</i>
		                                        <label>时间</label>
		                                        <p style="color:gray;">		                                        
			                                        <label id="startTime">${topic.startTime}</label>
			                                        <c:if test="startTime!=null">-</c:if>
			                                        <label id="endTime">${topic.endTime }</label>
			                                        
		                                        </p>
		                                   </div>
		                               </div>
	                               </div>   
	                               <div class="col-md-4">
                                       <label style="font-weight:bold;">简介</label>
                                       <p id="introduction" class="introduction" style="color:gray;">
                                           ${topic.introduction}                                                                                                    
                                       </p>
                                   </div>
	                               
	                           </div>
	                           
	                       </div>
	                   </div>
	               </div>
        </div>	
        <div class="main">                          
                <div class="row" >
                    <div class="col-md-3">
                        <div>
	                        <label style="font-size:16px;font-weight:700;">专题藏品</label>
	                        <label style="font-size:14px;color: gray;" id="collectionCount">20件藏品</label>
	                       <c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true && (topic.status eq 1)}">
	                        <label style="color:cornflowerblue;" id="addCollection">+添加</label>
	                        <label style="color:cornflowerblue;" id="sort">排序</label>
	                        </c:if>
                        </div>
                    </div>
                    <div class="col-md-9" > 
	                    <div style="position:relative;float:right;margin-right: 10px;"> 
		                    <i class="Hui-iconfont iconColor" id="imageList" style="font-size:25px;"> &#xe6c0;</i>            
		                     <i class="Hui-iconfont" id="imageLi" style="font-size:25px;">&#xe6bf;</i>
	                     </div>     
                    </div>
                </div>
                <hr>
                <div class="row imageInfo" id="images">
                    
                </div>
        </div>  
       <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
		<!-- 数据内容结束 -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
		<script type="text/javascript">
		var topicId = $("#topicId").val();
		layui.use(['form','layer','table'],function(){
	        var form = layui.form
	            layer = parent.layer === undefined ? layui.layer : top.layer,
	            $ = layui.jquery;
	        var table = layui.table;
   
		var imageList = [];
		    
		   init();
		    function init(){
		    	var topicId = $("#topicId").val();
		    	//加载图集
		    	var json = {"topicId":topicId};
		    	$.ajax({
                        url: "<%=request.getContextPath()%>/topic/getCollectionList.do",
                        type: "post",
                        data: json,
                        async: false,
                        dataType: "text",
                        success: function(result) {
                        	result =  eval("(" + result + ")"); 
                        	  var list = result.data;
                        	  imageList = list;
                        	  if(null != list && list.length>0){
                        		  var htmlStr = "";
                                  for (var i = 0; i < list.length; i++) {
                                    var url = list[i].url;
                                    var id = list[i].id;
                                    var tempHtml = ""; 
                                    if(i/12==0){
                                         tempHtml = "<div class='row'>"
                                             +"<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>";
                                     }
                                     else{
                                         if((i+1)/12==0){
                                             tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>"
                                             +"</div>";
                                         }else{                                      
                                             tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>";
                                         }
                                     }
                                    htmlStr = htmlStr+tempHtml;
                                    } 
                        		  $("#images").html(htmlStr);
                        		  $(".delete").attr("src","<%=request.getContextPath()%>/back/images/delete.svg");
                                  $(".show").attr("src","<%=request.getContextPath()%>/back/images/show.svg");
                              }else{
                                  $("#sort").hide();
                                  var picStr = "<div class='picDiv'><img src='../back/images/Group 3.png'></img></div>"
                                  var htmlStr = "<div class='empty'><p>您还没有添加藏品呢，赶快添加藏品充实您的专题~<a class='addcollection'>开始添加</a></p><p>或者您可以在藏品库中添加藏品到专题中<a class='gocollectionList'>去藏品库</a></p></div>";
                                  htmlStr = picStr+htmlStr;
                                  $("#images").html(htmlStr);  
                              }
                        	  var str = list.length+"件藏品";
                        	  $("#collectionCount").text(str);
                        	  							
                        },
                        error: function() {
                            alert("数据请求异常，请联系管理员");
                        }
                    })
		    }
		//编辑按钮
		 $("#edit").click(function(){	
			 var topicId = $("#topicId").val();
			 var name = $("#name").text();
			 var publishOrg = $("#publishOrg").text();
			 var label = $("#label").text();
			 console.log(label);
			 if(label.indexOf("暂无标签")>-1){
				 label = "";
			 }
			 var iconUrl = $("#iconUrl").attr("src");
			 var exhibitionHall = $("#exhibitionHall").text();
			 var startTime = $("#startTime").text();
			 var endTime = $("#endTime").text();
			 var introduction = $("#introduction").text();
			 var url = '<%=request.getContextPath() %>/CollectionTopic/goEditTopicPage.do';
			 var json = {"topicId":topicId,"name":name,"publishOrg":publishOrg,"label":label,"exhibitionHall":exhibitionHall,"introduction":introduction
					 ,"startTime":startTime,"endTime":endTime,"iconUrl":iconUrl};			 
			 layer.open({
                 type: 2
                 ,id: 'layerDemo' //防止重复弹出
                 ,title: name
                 ,content: ['<%=request.getContextPath() %>/CollectionTopic/goEditTopicPage.do','yes']
                 ,area: ['1000px', '800px']
                 ,shade: 0 //不显示遮罩
                 ,yes: function(){
                     layer.closeAll();
                 },
				 end:function(){
	                 location.reload();
	             }
                 ,success: function(layero, index){
                	 var iframe = window['layui-layer-iframe' + index];
                         iframe.child(json);
                 }
             });


		 });
		$('.images').on('error',function(){
			$(this).attr("src",'<%=request.getContextPath() %>/back/images/7259105_164349794186_2.jpg');
		});
		//添加藏品按钮
         $("#addCollection").click(function(){   
             var topicId = $("#topicId").val();
             var json = {"topicId":topicId};
             layer.open({
                 type: 2,
                 title: '添加藏品',
                 shadeClose: true,
                 shade: 0.5,
                 area: ['95%', '95%'],
                 content: '<%=request.getContextPath()%>/topic/goSelectCollection.do?topicId='+topicId,
                 end:function(){
                     location.reload();
                 }
             });
         });
		
       //排序按钮
         $("#sort").click(function(){   
        	 var topicId = $("#topicId").val();
        	 
        	 layer.open({
                 type: 2,
                 title: '排列顺序',
                 shadeClose: true,
                 shade: 0.5,
                 area: ['650px', '700px'],
                 content: '<%=request.getContextPath()%>/topic/goEditSort.do?topicId='+topicId,
                 end:function(){
                     location.reload();
                 }
             });
         });
       //切换中图模式
       $("#imageList").click(function(){
    	   var list = imageList;
    	   $("#imageList").addClass("iconColor");
    	   $("#imageLi").removeClass("iconColor");
    	   if(null != list && list.length>0){
               var htmlStr = "";
               for (var i = 0; i < list.length; i++) {
                 var url = list[i].url;
                 var id = list[i].id;
                 var tempHtml = ""; 
                 if(i/12==0){
                      tempHtml = "<div class='row'>"
                          +"<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>";
                  }
                  else{
                      if((i+1)/12==0){
                          tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>"
                          +"</div>";
                      }else{                                      
                          tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images' /></div>";
                      }
                  }
                 htmlStr = htmlStr+tempHtml;
                 } 
               $("#images").html(htmlStr);
               $(".delete").attr("src","<%=request.getContextPath()%>/back/images/delete.svg");
               $(".show").attr("src","<%=request.getContextPath()%>/back/images/show.svg");
           }else{
        	   $("#sort").hide();
        	   var picStr = "<div class='picDiv'><img src='../back/images/Group 3.png'></img></div>"
               var htmlStr = "<div class='empty'><p>您还没有添加藏品呢，赶快添加藏品充实您的专题~<a class='addcollection'>开始添加</a></p><p>或者您可以在藏品库中添加藏品到专题中<a class='gocollectionList'>去藏品库</a></p></div>";
               htmlStr = picStr+htmlStr;
               $("#images").html(htmlStr);  
           }
    	      
       });
       //添加藏品
       $(".addcollection").click(function(){
    	   var topicId = $("#topicId").val();
           var json = {"topicId":topicId};
           layer.open({
               type: 2,
               title: '添加藏品',
               shadeClose: true,
               shade: 0.5,
               area: ['95%', '95%'],
               content: '<%=request.getContextPath()%>/topic/goSelectCollection.do?topicId='+topicId,
               end:function(){
                   location.reload();
               }
           });
    	   
       })
       //去藏品库
       $(".gocollectionList").click(function(){
    	   location.href='<%=request.getContextPath()%>/back/oCCollection/info.do?topicId='+topicId;
   	   
       })
    	$(".delete").click(function(){
    		var id = $(this).attr("data");
    		layer.confirm('真的删除么', function(index){
               if(id==null){
            	   layer.msg("id为空，不允许删除!");
            	   return;
               }
    			deleteCollection(id);
              layer.close(index);
            });
    	})  
	     $(".show").click(function(){
            var id = $(this).attr("data");
            goCollection(id);
        })   
       //切换列表模式
       $("#imageLi").click(function(){
    	   var list = imageList;
    	   $("#imageLi").addClass("iconColor");
           $("#imageList").removeClass("iconColor");
           if(null != list){
        	   var tableStr = "<table id='imageTable' lay-filter='demoEvent'></table>";
        	   $("#images").html(tableStr);
        	   var imageData = [];
               for (var i = 0; i < list.length; i++) {
                   var url = list[i].url;
                   var name = list[i].name;
                   var tempData = {"id":list[i].id,"name":list[i].name,"collectionsCategory":list[i].collectionsCategory,"sort":list[i].sort
                			   ,"collectionLevel":list[i].collectionLevel,"gsNo":list[i].gsNo,"yearType":list[i].yearType,
                			   "collectionUnit":list[i].collectionUnit};                	   
                	   imageData.push(tempData);
                   } 
               table.render({
            	    elem: '#imageTable'
            	    ,height: 315
            	    ,data:imageData
            	    ,cellMinWidth: 120
            	    ,page: true //开启分页
            	    ,cols: [[ //表头
            	      {field: 'id', title: 'ID', sort: true}
            	      ,{field: 'sort', title: '排序', sort: true}            	      
            	      ,{field: 'name', title: '藏品名称', event: 'showCollection',templet: '<div><a data={{d.id}}" class="layui-table-link showLi">{{d.name}}</a></div>'}
            	      ,{field: 'collectionsCategory', title: '类别'} 
            	      ,{field: 'collectionLevel', title: '级别'}
            	      ,{field: 'gsNo', title: '一普编号'}
            	      ,{field: 'yearType', title: '年代'}
            	      ,{field: 'collectionUnit', title: '存放博物馆'} 
            	      ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            	    ]]
               ,done: function(res, curr, count){
            	   $("[data-field='id']").css('display','none');
            	   }
            	  });     
           }          
       })
       
       table.on('tool(demoEvent)', function(obj){
    	    var data = obj.data;
    	    if(obj.event === 'detail'){
    	    	goCollection(data.id);
    	      } else if(obj.event === 'del'){
    	        layer.confirm('真的删除行么', function(index){
    	        	deleteCollection(data.id);
    	          layer.close(index);
    	        });
    	      } 
    	  });
		});
		
		$("#deleteCollection").click(function(){
			var id = $(this).attr("data");
			deleteCollection(id);
		})
		$(".Hui-iconfont.deleteLi").click(function(){
            var id = $(this).attr("data");
            if(id==null){
                layer.msg("id为空，不允许删除!");
                return;
            }
            deleteCollection(id);
        })
        $(".layui-table-link.showLi").click(function(){
            var id = $(this).attr("data");
            goCollection(id);
        })
		function deleteCollection(id){
			var topicId = $("#topicId").val();
			var json = {"topicId":topicId,"collectionId":id};
			$.ajax({
                type:"post",
                data:json,
                url:'<%=request.getContextPath()%>/topic/deleteCollectionByTopic.do', 
                success:function(result) {
                    var index = parent.layer.getFrameIndex(window.name);
                    if (result.success == 1) {
                        top.layer.msg("删除成功！");
                        location.reload();
                    } else {
                        top.layer.msg("系统异常删除失败！");
                    }
                } 
            }); 
		}
		//查看藏品
		function goCollection(id){
            var json = {"topicId":topicId,"collectionId":id};
            layer.open({
                type: 2,
                title: '查看藏品',
                shadeClose: true,
                shade: 0.5,
                area: ['95%', '95%'],
                content: '<%=request.getContextPath()%>/back/oCCollection/detail.do?id='+id,
                end:function(){
                    location.reload();
                }
            });
            
           
        }
		 function makeCodeInfo(elText, thisTd,imgName) {
	            var cpimg = $(thisTd).parent().parent().find("#cpimg img").attr("src");
	            var name = $(thisTd).parents("td").siblings(".name").html();
	             
	            if(elText == null) {
	                alert("沒有id，没法生成二维码。");
	                elText.focus();
	                return;
	            }
	            layer.open({
	                type: 1,
	                title: name,
	                area:['470px','390px'],
	                content: "<div id='qrcode' style='padding:20px 100px;text-align:center;'></div>" +
	                    "<a id='download' download='qrcode.jpg'></a>" +
	                    "<button class='btn button btn-primary size-S' id='downQrcode' style='float: right;margin-right: 15px;margin-bottom: 10px;'>下载</button>"+ 
	                    "<button class='btn button btn-primary size-S' id='printQrcode' style='float: right;margin-right: 15px;margin-bottom: 10px;'>打印</button>"+
	                    "<button class='btn button btn-primary size-S' id='copyUrl' style='float: right;margin-right: 15px;margin-bottom: 10px;'>复制链接</button>"
	            });
	            var qrcode = new QRCode(document.getElementById("qrcode"), {
	                text: name,
	                width: 270,
	                height: 270
	            });
	            
	            //地址错误，上线后修改
	            var elText1 = 'http://192.168.5.188:89/#/cpde?id='+elText;
	              $.ajax({
	                     type: "GET",
	                     url: "/admin/createTwoDimensionCode.do",
	                     data: {content:elText1, picCollectionPicUrl:cpimg},
	                     dataType: "json",
	                     success: function(data){
	                        url = data.data;
	                        $("#qrcode").html("<img style='width:270px;height:270px;' src="+url+" />");
	                        $("#download").attr("href",url);
	                     }
	                 });
	            //qrcode.makeCode(elText1);

	            //下载
	            $("#downQrcode").click(function(){
	            	var form = $("<form>");   //定义一个form表单
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
	    	        form.submit();   //表单提交
	            });
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
	                var clipboard = new Clipboard('.btn', {
	                        text: function() {
	                            return elText1;
	                        }
	                    });
	                clipboard.on('success',
	                function(e) {
	                    top.layer.msg("复制成功");
	                });
	            })

	        }

		
		</script>
	</body>

</html>