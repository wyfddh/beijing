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
 .hideBtn{
     display: none;
 }
  .childrenBody{
 	padding:20px;
 }
  .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
 }
 .layui-row{
 	padding-top:30px;
 }
 .comeIn{
 	padding-top:10px;
 }
 #btn_add{
 	color:#996600;
 	font-size:16px;
 	font-weight:250;
 	padding-left:40px;
 }
 .disabled{
	 pointer-events: none;
	 cursor: default;
	 opacity: 0.6;
 }
</style>
<title>经费来源与保障</title>
</head>
<body class="childrenBody">
 
	<div>
        <form class="layui-form" role="form"  id="myform" name="myform">
        <input type="hidden" name="museumId" id="museumId" value="${museumId}">
		<input type="hidden" name="isFull" id="isFull" value="">
		<input type="hidden" name="level" id="level" value="${level}">
        	<div class="layui-row">
				          	<div class="layui-col-md2 layui-col-md-offset10">
				          		<span style="text-align:center;display:block;">
				          		<c:if test="${'1' eq level}">
				                   <c:if test="${empty costList || costList eq null}">
										<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveCost"> 提交</a>
										<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
					                </c:if>
					                <c:if test="${not empty costList && costList ne null}">
										<a id="btn_edit" type="button" class="layui-btn">编辑</a>
										<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveCost" style="margin-left:0;"> 提交</a>
					                </c:if>
					              </c:if>
					                <a id="btn_back" type="button" class="layui-btn">返回</a>
									</span>
							</div>
				          </div>
             <div class="layui-row">
	            <div class="layui-col-md2">
	               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp经费与收入</a>
	            </div>
	         </div>
             <div class="layui-inline layui-col-md12">
	                <div class="layui-input-inline layui-col-md12">
	            	   <div class="layui-input-inline layui-col-md1" >
	                     <span>&nbsp</span>
	                    </div>
		                 <div class="layui-input-inline layui-col-md2" >
		                   <span style="text-align:center;display:block">资金来源</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-md4" >
		                    <span style="text-align:center;display:block">来源说明</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-md2" >
		                      <span style="text-align:center;display:block">金额</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-md3" >
		                     <span style="text-align:center;display:block">拨款/收入时间</span>
		                 </div>
	               </div>
	               </div>
                             <div id="comeInList">
                               <c:forEach items="${costList}" var="item" varStatus="sta">
                                   <div class="layui-input-inline layui-col-md12 comeIn" data="${item.id}">
                                       <div class="layui-input-inline layui-col-md1">
                                          <a id="delete_btn" style="padding-left:40px;"onclick="deleteCost('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png" alt="" style="padding-top:3px;width:2rem;height:2rem;border-radius: 1.5rem"></a>
                                        </div>
                                       <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
                                           <select name="costType" lay-verify="required" id="costType">
                                           	<option value="">请选择</option>
                                           	<option value="01" <c:if test="${'01' eq item.costType}">selected</c:if>>经费</option>
                                           	<option value="02" <c:if test="${'02' eq item.costType}">selected</c:if>>收入</option>
                                           </select>
                                       </div>
                                       <div class="layui-input-inline layui-col-md4" style="padding-right:10px;">
                                           <input type="text" value="${item.description}" class="layui-input" name="description"   placeholder="">
                                       </div>
                                       <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
                                           <input type="text" value="${item.moneyStr}"  class="layui-input" name="money"  placeholder="/万">
                                       </div>
                                       <div class="layui-input-inline layui-col-md3" style="padding-right:10px;">
                                           <input type="text" value="${item.costTime}" class="layui-input costTime" name="costTime"  placeholder="年/月/日">
                                       </div>
                                   </div>
                                   </c:forEach>
                               </div>
                            <div class="layui-inline layui-col-md12" role="group" style="margin-bottom: 20px">
                     			<a id="btn_add" >添加</a>
                 			</div>
                        </form>
                    </div>
                
           
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    layui.use(['form', 'laydate'], function() {
    	var form = layui.form,
    	layer = layui.layer,
    	laydate = layui.laydate,
    	$=layui.jquery;
    	
        var len=$("#comeInList").children().length;
        var level =$("#level").val();
  	  
	    lay('.costTime').each(function(){
	  	   laydate.render({
	  	      elem: this
	  	     ,trigger: 'click'
	  	   });
	    }); 
	    initFileds();
		if(len>0 || level =="2"){
			$('input,select,textarea',$('form[name="myform"]')).attr('disabled',"disabled");
			$("#btn_add").addClass("disabled");
			$("#comeInList .comeIn").find("#delete_btn").addClass("disabled");
			form.render('select');
		}
		
		$("#btn_back").click(function(){
			var museumId = $("#museumId").val();
			if( checkModification()){
				layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
			        btn: ['确定','取消'] //按钮
			    }, function(index){
			    	layer.close(index);  //关闭弹出层
			        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
			    }, function(index){
			        layer.close(index);  //关闭弹出层
			    });
			}else{
		        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
			}
	    });
		
		$(document).on('click','#btn_edit',function(){
			$('input,select,textarea',$('form[name="myform"]')).removeAttr("disabled");
			$("#btn_edit").addClass("hideBtn");
			$("#btn_submit").removeClass("hideBtn");
			$("#btn_add").removeClass("disabled");
			$("#comeInList .comeIn").find("#delete_btn").removeClass("disabled");
			form.render('select');
	    });
		
    	$(document).on('click','#btn_add',function(){
    		       var str="<div class=\"layui-input-inline layui-col-md12 comeIn\">\n" +
    		           "                                            <div class=\"layui-input-inline layui-col-md1\">\n" +
    		           "                                                   <a style=\"padding-left:40px;\" id =\"delete_btn\" onclick=\"deleteCost(this)\"><img src=\"<%=request.getContextPath() %>/back/images/delete.png\" alt=\"\" style=\"padding-top:3px;width:2rem;height:2rem;border-radius: 1.5rem\"></a>\n"+
    		           "                                            </div>\n" +
    		           "                                            <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n" +
    		           "                                                <select class=\"layui-col-md3\" lay-verify=\"required\" name=\"costType\" id=\"costType\">\n"+
    		       	   "											            <option value=\"\">请选择</option>\n"+
    		  		   "										          	    <option value=\"01\" >经费</option>\n"+
    		  		   "										          	    <option value=\"02\" >收入</option>\n"+
    		           "													</select>\n" +
    		           "                                            </div>\n" +
    		           "                                            <div class=\"layui-input-inline layui-col-md4\" style=\"padding-right:10px;\">\n" +
    		           "                                                <input type=\"text\" class=\"layui-input\" name=\"description\"  placeholder=\"\">\n" +
    		           "                                            </div>\n" +
    		           "                                            <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n" +
    		           "                                                <input type=\"text\" class=\"layui-input\" name=\"money\"  placeholder=\"/万\">\n" +
    		           "                                            </div>\n" +
    		           "                                            <div class=\"layui-input-inline layui-col-md3\" style=\"padding-right:10px;\">\n" +
    		           "                                                <input type=\"text\" class=\"layui-input costTime\" name=\"costTime\" id=\"costTime\" placeholder=\"年/月/日\">\n" +
    		           "                                            </div>\n" +
    		           "                                        </div>";
    		       $("#comeInList").append(str);
    		       form.render('select');
    		       var len=$("#comeInList").children().length;
    		       $("input[name='costTime']").eq(len-1).attr("id","costTime"+len);
    		       laydate.render({
    		   	    	elem: '#costTime'+len
    		   	   });
    	});
    	
    	 //提交表单
    	form.on('submit(saveCost)', function(data){
    		 if( checkModification()){
 	    		var museumId=$("#museumId").val();
 		    	$("#isFull").val("1");
 			   	var costList=new Array();
 			   	var len=$("#comeInList").children().length;
 		        for(var i=0;i<len;i++){
 		            var id=$("#comeInList .comeIn").eq(i).attr("data")?$("#comeInList .comeIn").eq(i).attr("data"):"";
 		            var costTime= $("#comeInList .comeIn").eq(i).find("input[name='costTime']").val()||"";
 		            var description= $("#comeInList .comeIn").eq(i).find("input[name='description']").val()||"";
 		            var money= $("#comeInList .comeIn").eq(i).find("input[name='money']").val()||"";
 		            var costType= $("#comeInList .comeIn").eq(i).find("select[name='costType']").find("option:selected").attr('value')||"";

 		            costList.push({"costTime":costTime,"description":description,"costType":costType,"money":money,"id":id,"museumId":museumId})
 		        }
 		    	console.log(costList);
 		    	var loading; 
 		    	$.ajax({
 			       url:"<%=request.getContextPath()%>/museumCost/save.do",
 			       data:{"costList":JSON.stringify(costList),"museumId":museumId,"isFull":"1"},
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
 		                	layer.msg("保存失败！",{icon:2});
 		                }
 			       },
 			      error:function(msg){
	    	    	   layer.close(loading);
	    	    	   layer.msg("保存失败！",{icon:2});
	    	       }
 			   }); 
    		 }else{
    			 layer.msg("资料没有修改，无需提交！");
    		 }
	    });
    });
function deleteCost(id) {
	layer.confirm('确定删除该条数据？', {icon: 3, title: '删除确认'}, function (index) {
		layer.close(index);
		if(typeof(id)==="object"){
	        $(id).parents(".layui-col-md12")[0].remove();
	    }else{
	    	$.ajax({
	    		   url:"<%=request.getContextPath()%>/museumCost/deleteCost.do",
			       data:{"id":id},
			       type:"POST",
			       success:function(msg){
			    	   if(msg.success == 1){
			    		  layer.msg("删除成功");
		                 setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
		             }else if(msg.success == 0){
		            	 layer.msg("删除失败",{icon:2});
		             }
			       }
			 });
	    }
		
    })
}    

</script>
</body>
</html>