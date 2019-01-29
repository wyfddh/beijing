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
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
  .childrenBody{
 	padding-left:20px;
 	padding-right:20px;
 	padding-bottom:20px;
 }
 .layui-row{
 	padding-top:30px;
 }
 .gold{
 	padding-top:10px;
 }
 #btn_add{
 	color:#996600;
 	font-size:16px;
 	font-weight:250;
 	padding-left:40px;
 }

</style>
<title>获奖情况</title>
</head>
<body class="childrenBody">
 	<form action="" id="mesForm" name="mesForm" class="layui-form">
		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
  			<ul class="layui-tab-title">
			    <li><a id="tab1" onclick="changTab('1')">基本信息</a></li>
			    <li class="layui-this">获奖情况</li>
			    <li><a id="tab3" onclick="changTab('3')">资质证书</a></li>
		        <input type="hidden" name="id" id="id" value="${personId}">
		        <input type="hidden" name="level" id="level" value="${level}">
		        <input type="hidden" name="museumId" id="museumId" value="${museumId}">
			</ul>
		   <div class="layui-tab-content">
		   		<div class="layui-inline layui-col-xs12">
	                <div class="layui-input-inline layui-col-xs12">
	            	   <div class="layui-input-inline layui-col-xs1" >
	                     <span>&nbsp</span>
	                    </div>
		                 <div class="layui-input-inline layui-col-xs3" >
		                   <span style="text-align:center;display:block">获奖名称</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-xs3" >
		                    <span style="text-align:center;display:block">获奖时间</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-xs5" >
		                      <span style="text-align:center;display:block">奖项说明</span>
		                 </div>
	               </div>
	              </div>
	               <div id="goldList" class="layui-input-inline layui-col-xs12" style="padding-top:10px;" >
                      	<c:forEach items="${awardList}" var="item" varStatus="sta">
                          <div class="layui-col-xs12 gold" data="${item.id}">
                              <div class="layui-col-xs1">
                              	<a id="delete_btn" style="padding-left:40px;"onclick="deleteGold('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png" alt="" style="padding-top:3px;"></a>
                              </div>
                              <div class="layui-input-inline layui-col-xs3" style="padding-right:10px;">
                                  <input class="layui-input" type="text" id="awardName" name="awardName" value="${item.awardName}">
                              </div>
                              <div class="layui-input-inline layui-col-xs3" style="padding-right:10px;">
                                  <input class="layui-input awardTime" type="text"  name="awardTime" placeholder="" value="${item.awardTime}">
                              </div>
                              <div class="layui-input-inline layui-col-xs5">
                              		<input class="layui-input" type="text" id="awardDescription" name="awardDescription" value="${item.awardDescription}">
                              </div>
                          </div>
                          </c:forEach>
                    </div>
                    <div class="layui-inline layui-col-xs12" role="group" style="margin-bottom: 20px">
                     			<a id="btn_add" >添加</a>
                 	</div>
                 	
                 	<div class="layui-row">
		  				<div class="layui-input-inline layui-col-xs2 layui-col-xs-offset5">
		  				<c:if test="${'1' eq level}">
					      	<a id="saveBtn" type="button" class="layui-btn" lay-submit lay-filter="saveAward"> 保存</a>
					      </c:if>
						  <a id="close" type="button" class="layui-btn">关闭</a>
					    </div>
				    </div>
		     </div>
      </div>
      </form>  
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
	function changTab(tab) {
		var personId = $("#id").val();
		var museumId = $("#museumId").val();
		if(personId != null && personId != "" && personId != "undefind"){
			if(tab == "1"){
				window.location.href='<%=request.getContextPath() %>/museumPerson/personInfo.do?personId=' + personId+'&museumId='+museumId;
			}else if(tab == "3"){
				window.location.href='<%=request.getContextPath() %>/museumPerson/certificationList.do?personId=' + personId+'&museumId='+museumId;
			}
		}
	}
	
	layui.use(['form', 'laydate'], function() {
    	var form = layui.form,
    	layer = layui.layer,
    	laydate = layui.laydate,
    	$=layui.jquery;
    	
    	initFileds();
        var level =$("#level").val();
   	 	lay('.awardTime').each(function(){
	  	   laydate.render({
	  	      elem: this
	  	     ,trigger: 'click'
	  	   });
	  	 });
    	if(level=="2"){
    		$('input,select,textarea',$('form[name="personForm"]')).attr('disabled',"disabled");
    		$("#goldList .gold").find("#delete_btn").addClass("disabled");
    	}
    	$(document).on('click','#btn_add',function(){
		   var str="<div class=\"layui-col-xs12 gold\">\n" +
		    	"	       <div class=\"layui-col-xs1\">\n" +
		        "       	  	<a id=\"delete_btn\" style=\"padding-left:40px;\"onclick=\"deleteGold(this);\" ><img src=\"<%=request.getContextPath() %>/back/images/delete.png\" style=\"padding-top:3px;\"></a>\n"+
		        "   		</div>\n" +
		        "   		<div class=\"layui-input-inline layui-col-xs3\" style=\"padding-right:10px;\">\n" +
		        "       		<input class=\"layui-input\" type=\"text\" id=\"awardName\" name=\"awardName\">\n" +
		        "   		</div>\n" +
		        "   		<div class=\"layui-input-inline layui-col-xs3\" style=\"padding-right:10px;\">\n" +
		        "       		<input class=\"layui-input\" type=\"text\"  name=\"awardTime\" placeholder=\"\">\n" +
		        "   		</div>\n" +
		        "   		<div class=\"layui-input-inline layui-col-xs5\">\n" +
		        "       			<input class=\"layui-input\" type=\"text\" id=\"awardDescription\" name=\"awardDescription\">\n" +
		        "   		</div>\n" +
    		    "    </div>";
    		       $("#goldList").append(str);
    		       form.render('select');
    		       var len=$("#goldList").children().length;
     		       $("input[name='awardTime']").eq(len-1).attr("id","awardTime"+len);
     		       laydate.render({
     		   	    	elem: '#awardTime'+len
     		   	   });
    	});
    	
    	//提交表单
	    form.on("submit(saveAward)",function(data){
	    	if( checkModification()){
	    		var goldList=new Array();
		        var len=$("#goldList").children().length;
		        var museumId = $("#museumId").val();
		        for(var i=0;i<len;i++){
		            var id=$("#goldList .gold").eq(i).attr("data")?$("#goldList .gold").eq(i).attr("data"):"";
		            var personId=$("#id").val();
		            var awardName= $("#goldList .gold").eq(i).find("input[name='awardName']").val()||"";
		            var awardTime= $("#goldList .gold").eq(i).find("input[name='awardTime']").val()||"";
		            var awardDescription= $("#goldList .gold").eq(i).find("input[name='awardDescription']").val()||"";
		            goldList.push({"awardName":awardName,"awardTime":awardTime,"awardDescription":awardDescription,"id":id,"personId":personId})
		        }
		        var loading;
		    	$.ajax({
			       url:"<%=request.getContextPath()%>/museumPerson/awardSave.do",
			       data:{"awardListStr":JSON.stringify(goldList),"museumId":museumId},
			       type:"POST",
			       beforeSend: function () {
	    	    	   loading = layer.load();
	    	       },
			       success:function(msg){
			    	   layer.close(loading); 
			    	   if(msg.success == 1){
			    		   layer.msg("保存成功！");
		                    setTimeout(function(){
									window.location.href = window.location.href;
								},1000)
		                }else if(msg.success == 0){
		                	layer.msg("保存失败！");
		                }
			       },
			       error:function(msg){
	    	    	   layer.close(loading);
	    	    	   layer.msg("保存失败！");
	    	       }
			   });
	    	}else{
				layer.msg("资料没有修改，无需提交！");
			}
	    });
    });
	
	
	function deleteGold(id) {
		
		layer.confirm('确定删除该条数据？', {icon: 3, title: '删除确认'}, function (index) {
			if(typeof(id)==="object"){
		        $(id).parents(".layui-col-xs12")[0].remove();
		    }else{
		    	$.ajax({
				       url:"<%=request.getContextPath()%>/museumPerson/awardDelete.do",
				       data:{"id":id},
				       type:"POST",
				       success:function(msg){
				    	   if(msg.success == 1){
				    		   layer.msg("删除成功！");
			                 setTimeout(function(){
								window.location.href = window.location.href;
							},1000)
			             }else if(msg.success == 0){
			            	 layer.msg("删除失败！");
			             }
				       }
				});
		    }
        })
	}
	
	//关闭
	$("#close").click(function(){
		close();
	});

	function close(){
		layer.closeAll();
	    parent.location.reload();
	}
    
</script>
</body>
</html>