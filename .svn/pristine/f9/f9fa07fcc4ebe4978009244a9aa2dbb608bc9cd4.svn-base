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
 .label-type-1{
 	width:130px !important;
 }
  .label-type-2{
 	width:130px !important;
 }
   .label-type-3{
 	width:auto !important;
 }
 .layui-form-radio{
 	padding-right: 5px;
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
 	padding-bottom:20px;
 }
 .seclength{
 	width:200px;
 }
</style>
<title>藏品管理与科学研究</title>
</head>
<body class="childrenBody">
	<div>  
	<form class="mesForm form-horizontal layui-form" role="form"  id="mesForm" name="mesForm">
		 <input type="hidden" name="museumId" id="museumId" value="${museumId}">
	     <input type="hidden" name="isFull" id="isFull" value="">
	     <input type="hidden" name="level" id="level" value="${level}">
	     <input type="hidden" name="id" id="id" value="${result.id}">
			<div class="layui-row" style="padding-top:20px;">    
	          <div class="layui-col-md2 layui-col-md-offset10">
	          		<span style="text-align:center;display:block;">
			          	<c:if test="${'1' eq level}">
							<c:if test="${empty result.id || result.id eq null}">
								<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase"> 提交</a>
								<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
			                </c:if>
			                <c:if test="${not empty result.id && result.id ne null}">
								<a id="btn_edit" type="button" class="layui-btn">编辑</a>
								<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveBase" style="margin-left:0px"> 提交</a>
			                </c:if>
			              </c:if>
			                <a id="btn_back" type="button" class="layui-btn">返回</a>
	                </span>
	    	  </div>
            </div>
           <div class="layui-row">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp藏品信息</a>
	            </div>
            </div>
          
            <div class="layui-row">
            	<div class="layui-col-md4">
                      <label class="layui-form-label label-type-1">藏品总数(件)：</label>
                    <div class="layui-input-inline layui-col-md6">
	                    <input type="text" class="layui-input typeOne" lay-verify="num" name="totalNum" id="totalNum" value="${result.totalNum}" placeholder="/件">
                    </div>
                </div>
                <div class="layui-col-md4">
                       <label class="layui-form-label label-type-1" for="allFloorArea">文物数量(件)：</label>
                    	<div class="layui-input-inline layui-col-md6">
                    		<input type="text" class="layui-input typeOne" lay-verify="num" name="relicsNum" id="relicsNum"  value="${result.relicsNum}" placeholder="/件">
                   	    </div>
                 </div>
                 <div class="layui-col-md4">
                    <label class="layui-form-label label-type-1" for="allBuildingArea">一级文物数量(件)：</label>
                    <div class="layui-input-inline layui-col-md6">
                      <input type="text" class="layui-input typeOne" name="firstLevel" id="firstLevel"lay-verify="num"  value="${result.firstLevel}" placeholder="/件">
                   	</div>
                </div>
            </div>
            <div class="layui-row">
            	<div class="layui-col-md4">
                      <label class="layui-form-label label-type-1" for="mumName">二级文物数量(件)：</label>
                    <div class="layui-input-inline layui-col-md6">
	                    <input type="text" class="layui-input typeOne" name="secondLevel" id="secondLevel" lay-verify="num" value="${result.secondLevel}">
                    </div>
                </div>
                <div class="layui-col-md4">
                       <label class="layui-form-label label-type-1" for="allFloorArea">三级文物数量(件)：</label>
                    	<div class="layui-input-inline layui-col-md6">
                    		<input type="text" class="layui-input typeOne" name="thirdLevel" id="thirdLevel"   lay-verify="num" value="${result.thirdLevel}" placeholder="/件">
                   	    </div>
                 </div>
            </div> 
            
            <div class="layui-row">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp藏品管理</a>
	            </div>
            </div>
                  
            <div class="layui-row" >
            	<div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label label-type-2">藏品分类保存程度：</label>
                    <div class="layui-input-inline layui-col-md6">
                        <select  name="classifyStorage" id="classifyStorage" class="seclength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.classifyStorage}">selected</c:if>>全部藏品按质地分类存放</option>
                            <option value="2" <c:if test="${'2' eq result.classifyStorage}">selected</c:if>>珍贵文物按质地分类存放</option>
                            <option value="3" <c:if test="${'3' eq result.classifyStorage}">selected</c:if>>少部分文物按质地分类存放</option>
                            <option value="4" <c:if test="${'4' eq result.classifyStorage}">selected</c:if>>无</option>
                        </select>
                    </div>
                </div>  
                <div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label label-type-2">藏品分库保存程度：</label>
                    <div class="layui-input-inline layui-col-md6">
                        <select  name="fenkuStorage" id="fenkuStorage" class="seclength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.fenkuStorage}">selected</c:if>>全部藏品分库保存</option>
                            <option value="2" <c:if test="${'2' eq result.fenkuStorage}">selected</c:if>>珍贵文物分库保存</option>
                            <option value="3" <c:if test="${'3' eq result.fenkuStorage}">selected</c:if>>少部分文物分库保存</option>
                            <option value="4" <c:if test="${'4' eq result.fenkuStorage}">selected</c:if>>无</option>
                        </select>
                    </div>
                </div>  
                <div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label label-type-2">藏品档案建立情况：</label>
                    <div class="layui-input-inline layui-col-md6" >
                        <select  name="collectionRecord" id="collectionRecord" class="seclength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.collectionRecord}">selected</c:if>>全部藏品均建立了藏品档案</option>
                            <option value="2" <c:if test="${'2' eq result.collectionRecord}">selected</c:if>>珍贵文物全部建立了藏品档案</option>
                            <option value="3" <c:if test="${'3' eq result.collectionRecord}">selected</c:if>>部分一级以上珍贵文物全部建立了藏品档案</option>
                            <option value="4" <c:if test="${'4' eq result.collectionRecord}">selected</c:if>>无</option>
                        </select>
                    </div>
                </div>  
                
            </div> 
             <div class="layui-row" >
             	<div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label label-type-3">藏品配备装具程度：</label>
                    <div class="layui-input-inline layui-col-md6">
                        <select  name="outfit" id="outfit" class="seclength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.outfit}">selected</c:if>>全部藏品均有符合要求的装具</option>
                            <option value="2" <c:if test="${'2' eq result.outfit}">selected</c:if>>珍贵文物均有符合要求的装具</option>
                            <option value="3" <c:if test="${'3' eq result.outfit}">selected</c:if>>少部分文物有符合要求的装具</option>
                            <option value="4" <c:if test="${'4' eq result.outfit}">selected</c:if>>无</option>
                        </select>
                    </div>
                </div>  
                <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3">珍贵文物是否有专用柜：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="specialStorage" value="1" <c:if test="${'1' eq result.specialStorage}">checked</c:if> title="是">
                             <input type="radio" name="specialStorage"  value="0" <c:if test="${'0' eq result.specialStorage}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >是否建立了藏品编目卡片：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="card"   value="1" <c:if test="${'1' eq result.card}">checked</c:if> title="是">
                             <input type="radio" name="card" value="0" <c:if test="${'0' eq result.card}">checked</c:if> title="否">
                     </div>
                 </div>
             </div>
             <div class="layui-row" >
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >是否建立藏品管理制度：</label>
                     <div class="layui-col-md5">
                             <input type="radio" name="manageSystem"   value="1" <c:if test="${'1' eq result.manageSystem}">checked</c:if> title="是">
                             <input type="radio" name="manageSystem"  value="0" <c:if test="${'0' eq result.manageSystem}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >是否建立库房管理制度：</label>
                     <div class="layui-col-md5">
                             <input type="radio" name="storehouseManage"    value="1" <c:if test="${'1' eq result.storehouseManage}">checked</c:if> title="是">
                             <input type="radio" name="storehouseManage"    value="0" <c:if test="${'0' eq result.storehouseManage}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >是否建立了《库房日记》：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="storehouseDiary" value="1" <c:if test="${'1' eq result.storehouseDiary}">checked</c:if> title="是">
                             <input type="radio" name="storehouseDiary"  value="0" <c:if test="${'0' eq result.storehouseDiary}">checked</c:if> title="否">
                     </div>
                 </div>
			</div>  
			<div class="layui-row" >
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3">是否建立本馆入藏标准：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="standard"   value="1" <c:if test="${'1' eq result.standard}">checked</c:if> title="是">
                             <input type="radio" name="standard" value="0" <c:if test="${'0' eq result.standard}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >是否建立藏品养护办法：</label>
                     <div class="layui-col-md5">
                             <input type="radio" name="conservation"   value="1" <c:if test="${'1' eq result.conservation}">checked</c:if> title="是">
                             <input type="radio" name="conservation"  value="0" <c:if test="${'0' eq result.conservation}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >藏品是否定期养护：</label>
                     <div class="layui-col-md5">
                             <input type="radio" name="conservationRegular"    value="1" <c:if test="${'1' eq result.conservationRegular}">checked</c:if> title="是">
                             <input type="radio" name="conservationRegular"    value="0" <c:if test="${'0' eq result.conservationRegular}">checked</c:if> title="否">
                     </div>
                 </div>
			</div>     
			<div class="layui-row">
				<div class="layui-input-inline layui-col-md6">
                     <label class="layui-form-label label-type-3" >是否建立藏品保护管理制度和安全操作规程：</label>
                     <div class="layui-col-md3">
                             <input type="radio" name="safetyOperation"   value="1" <c:if test="${'1' eq result.safetyOperation}">checked</c:if> title="是">
                             <input type="radio" name="safetyOperation"  value="0" <c:if test="${'0' eq result.safetyOperation}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md6">
                     <label class="layui-form-label label-type-3">否建立藏品征集办法、征集工作流程：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="collectionMethod"   value="1" <c:if test="${'1' eq result.collectionMethod}">checked</c:if> title="是">
                             <input type="radio" name="collectionMethod" value="0" <c:if test="${'0' eq result.collectionMethod}">checked</c:if> title="否">
                     </div>
                 </div>
			</div> 
			<div class="layui-row">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp学术研究</a>
	            </div>
            </div> 
            
            <div class="layui-row" >
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3" >是否有学术委员会：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="academicBoard" value="1" <c:if test="${'1' eq result.academicBoard}">checked</c:if> title="是">
                             <input type="radio" name="academicBoard"  value="0" <c:if test="${'0' eq result.academicBoard}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3">是否有科研部门：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="researchDepart"   value="1" <c:if test="${'1' eq result.researchDepart}">checked</c:if> title="是">
                             <input type="radio" name="researchDepart" value="0" <c:if test="${'0' eq result.researchDepart}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label label-type-3">是否拥有独立的科研室、实验室：</label>
                     <div class="layui-col-md4">
                             <input type="radio" name="laboratory" style="padding-right: 5px;"  value="1" <c:if test="${'1' eq result.laboratory}">checked</c:if> title="是">
                             <input type="radio" name="laboratory" style="padding-right: 5px;" value="0" <c:if test="${'0' eq result.laboratory}">checked</c:if> title="否">
                     </div>
                 </div>
             </div>
             
             <div class="layui-row" >
                <div class="layui-col-md6">
                    <label class="layui-form-label label-type-3">科研室、实验室方向：</label>
                    <div class="layui-input-inline layui-col-md6">
                      <input type="text" class="layui-input" name="labAspect" id="labAspect"  value="${result.labAspect}" placeholder="">
                   	</div>
                </div>
             </div>
    </form>
</div>
              
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

layui.use(['form', 'layer'],function(){
	  var form = layui.form;
	  var layer = parent.layer === undefined ? layui.layer : top.layer;
	  
	  var idStr= $("#id").val();
	  var level = $("#level").val();
	  if(level=="2" || (idStr !=null && idStr != "")){
		 $("input[type!='hidden'],select").attr('disabled',"disabled");
		 form.render('select');
	  }
	  initFileds();	
	  $("#btn_edit").click(function(){
		  $("input[type!='hidden'],select").removeAttr("disabled");
		  $("#btn_edit").addClass("hideBtn");
		  $("#btn_submit").removeClass("hideBtn");
		  form.render('select');
	  });
		
	//校验
    form.verify(
    {num:[/(^$)|(^[0-9]*$)/,'请输入数字']}
	); 
		
	  //监听提交
	  form.on('submit(saveBase)', function(data){
		  //13个单选控件
		  if(checkModification()){
			  if(checkFullCom(13)){
				  $("#isFull").val("1");
			  }else{
				  $("#isFull").val("0");
			  }
			  	var loading; 
	        	$.ajax({
	    	       url:"<%=request.getContextPath()%>/colletionInfo/save.do",
	    	       data:$('#mesForm').serialize(),
	    	       type:"POST",
	    	       beforeSend: function () {
	    	    	   loading = layer.load();
	    	       },
	    	       success:function(msg){
	    	    	   layer.close(loading);  
	    	    	   if(msg == 1){
	    	    		   layer.msg("保存成功！");
	                         setTimeout(function(){
	    							window.location.href = window.location.href;
	    						},1000) 
	                    }else if(msg == 0){
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
	  
	  $("#btn_back").click(function(){
			if( checkModification()){
				layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
			        btn: ['确定','取消'] //按钮
			    }, function(index){
			    	layer.close(index);  //关闭弹出层
			        //点击确定之后需要执行的函数
			    	var museumId = $("#museumId").val();
			        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
			    }, function(index){
			        layer.close(index);  //关闭弹出层
			    });
			}else{
				var museumId = $("#museumId").val();
		        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
			}
	    });
});
</script>
</body>
</html>