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
 .layui-form-label{
 width:150px;
 }
 .childrenBody{
    padding-top:10px;
    padding-left:20px;
    padding-right:20px;
 }
 .layui-inline{
    margin-top:10px;
    margin-bottom:10px;
 }
 .label-title{
    color:#BE9A5B;
    font-size:18px;
    font-weight:700;
 }
 .layui-row{
    padding-bottom:25px;
 }
 
 .map{
        height:350px;
}
#editWrap{
        border-radius: 4px;
        width: 715px;
        height: 350px;
        float:left;
}
#editor{
    margin:0;
}
#edui1{
    height: 350px;
    width:713px!important;
}
#edui1_bottombar{
    display:none!important;
}
#edui1_iframeholder{
    height:310px!important;
}
.disabled{
     pointer-events: none;
     cursor: default;
     opacity: 0.6;
 }
 .preventEvent{
    pointer-events:none
}
.pt_30{
    padding-top:30px;
}
.labelStyle{
    width:100%;
    text-align: left;
    padding-left: 0px;
}
.rowStyle{
    margin-left: 43px;
}
/* #mesForm{
width:400px;
margin:0 auto;

} */
</style>
<title>基本信息</title>
</head>
<body class="childrenBody">
 <div style=" width:400px;margin:0 auto;">  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
        <input type="hidden" id="level" name="level" value="${level}"/>
        <input type="hidden" id="type" name="level" value="${type}"/>
        <input type="hidden" name="id" id="id" value="${culturalRelicOtherEquipment.id}">
        <input type="hidden" name="orgId" id="orgId" value="${orgId}">   
		   <div class="layui-form-item">
		   <div class="layui-inline">
		    <label class="layui-form-label">仪器设备名称:</label>
			    <div class="layui-input-inline">
			      <input type="text" name="eName" value="${culturalRelicOtherEquipment.eName}" lay-verify="required" autocomplete="off" placeholder="请输入仪器设备名称" class="layui-input">
			    </div>
		    </div>
		  </div>
		  <div class="layui-form-item">
		  <div class="layui-inline">
		    <label class="layui-form-label">型号规格:</label>
		    <div class="layui-input-inline">
		      <input type="text" name="specification" value="${culturalRelicOtherEquipment.specification}"  placeholder="请输入型号规格" autocomplete="off" class="layui-input">
		    </div>
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label"> 数量（台/套）:</label>
		      <div class="layui-input-inline">
		        <input type="number" name="eCount" lay-verify="num1" value="${culturalRelicOtherEquipment.eCount}" autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    
		  </div>
		  <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">购置单价（万元）:</label>
              <div class="layui-input-inline">
                <input type="number" name="price" value="${culturalRelicOtherEquipment.price}" lay-verify="num"  autocomplete="off" class="layui-input">
              </div>
            </div>     
          </div>
		  <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">使用频率:</label>
              <div class="layui-input-inline">
                <select  name="useFrequency" class="typeOne" id="useFrequency">  
                    <option value="" name="useFrequency" <c:if test="${'' eq culturalRelicOtherEquipment.useFrequency}">selected</c:if>>请选择</option>
                    <option value="1" name="useFrequency" <c:if test="${'1' eq culturalRelicOtherEquipment.useFrequency}">selected</c:if>>频繁</option>
                    <option value="2" name="useFrequency" <c:if test="${'2' eq culturalRelicOtherEquipment.useFrequency}">selected</c:if>>经常</option>
                    <option value="3" name="useFrequency" <c:if test="${'3' eq culturalRelicOtherEquipment.useFrequency}">selected</c:if>>偶尔</option>
                </select>
              </div>
            </div>    
          </div>	
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">购买年份:</label>
              <div class="layui-input-inline">
                <input type="text" name="purchaseYear" value="${culturalRelicOtherEquipment.purchaseYear}" id="purchaseYear"   autocomplete="off" class="layui-input purchaseYear">
              </div>
            </div>  
          </div>	  
		  <div class="layui-form-item">  
		    <div class="layui-inline">
		      <label class="layui-form-label">报废年份：</label>
		      <div class="layui-input-inline">
		        <input type="tel" name="scrapYear" value="${culturalRelicOtherEquipment.scrapYear}"  autocomplete="off"  class="layui-input scrapYear">
		      </div>
		    </div>
		  </div>
		  <div class="layui-form-item" pane="">
		    <label class="layui-form-label">是否为申请资质时已配备设备:</label>
		    <div class="layui-input-block">
		      <input type="radio" name="existEquipment" value="1" title="是" <c:if test="${'1' eq culturalRelicOtherEquipment.existEquipment}">checked</c:if>>
		      <input type="radio" name="existEquipment" value="0" title="否" <c:if test="${'0' eq culturalRelicOtherEquipment.existEquipment}">checked</c:if>>
		    </div>
		  </div>		   
		  <div class="layui-form-item" id="btns">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
		      <button id="cancel" class="layui-btn layui-btn-primary">取消</button>
		    </div>
		  </div>
    </form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>

<script type="text/javascript">

layui.use(['form','layer','upload','laydate'],function(){
    
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laydate=layui.laydate,
        $ = layui.jquery;
    var index = parent.layer.getFrameIndex(window.name);
    form.verify({ 
        num:[/^$|^\d{1,8}(\.\d{1,4})?$/,'请输入1-8位的数字，小数点后最多4位']
    ,num1:[/^$|^\d+$/,'请输入1-8位的数字']
        ,phone:[/^(1(3|5|8)\d{9})?$/,'请输入正确电话号码']
        /* ,phone:[/(^$)|(^(\(\d{3,4}\)|(\d{3,4}-))?\d{7,8}$)/,'请输入正确电话号码'] */
        ,zCode:[/(^$)|(^[1-9][0-9]{5}$)/,'请输入正确的邮编']
        ,email:[/(^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+)|(^$)/,'请输入正确的邮箱']
    });
    
    var mydate = new Date();
    var year = mydate.getFullYear();
    lay('.scrapYear').each(function(){
        laydate.render({
            elem: this, //指定元素
            type:'year'
            
        });
     }); 
    lay('.purchaseYear').each(function(){
        laydate.render({
            elem: this, //指定元素
            type:'year',
            max: year
        });
     }); 
    
    
    //页面初始化
//     var key = $("#id").val();
//     var level = $("#level").val();
//     if(level == "2" || (key != null && key != "")){
//         $('input,select,textarea').attr('disabled',"disabled"); 
//         form.render('select');
//     }
    initFileds();
    
    var type = $("#type").val();
    if(type == "show"){
    	$('input,select,textarea',$('form[name="mesForm"]')).attr("disabled","disabled");
    	$("#btns").hide();
    	$("#useFrequency").attr("disabled","disabled");
    	form.render('select');
    }
    //提交
    form.on("submit(demo1)",function(data){
      
            var loading; 
            $.ajax({
                   url:"<%=request.getContextPath()%>/relicsBureau/saveOtherEquipment.do",
                   data:$('#mesForm').serialize(),
                   type:"POST",
                   beforeSend: function () {
                       
                   },
                   success:function(data){
                       layer.msg("保存成功！");
                       if(data.success == 1){
                    	   parent.layer.close(index);
                    	   window.parent.update();
                        }else if(data.success == 0){
                            layer.msg("保存失败！",{icon:2});
                        }
                   },
                   error:function(msg){
                       layer.msg("保存失败！",{icon:2});
                   }
             });
        
       return false;
    });
    
    $("#cancel").click(function(){
    	 parent.layer.close(index);
    })
    
    //返回校验
    $("#btn_back").click(function(){
        if(checkModification()){
            layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
                btn: ['确定','取消'] //按钮
            }, function(index){ 
                layer.close(index);  //关闭弹出层
                //点击确定之后需要执行的函数
                var orgId = $("#orgId").val();
                window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+orgId;
            }, function(index){
                layer.close(index);  //关闭弹出层
            });
        }else{
            var orgId = $("#orgId").val();
            window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+orgId;
        }
    });
    
    //修改
    $("#btn_edit").click(function(){
        $('input,select,textarea',$('form[name="mesForm"]')).removeAttr("disabled");
        $("#museumName").attr('disabled','disabled');
        $("#parentOrgName").attr('disabled','disabled');
        $("#btn_edit").addClass("hideBtn");
        $("#btn_submit").removeClass("hideBtn");
        form.render('select');
    });
    
    
    function encodeBase64(mingwen,times){    
        var code="";    
        var num=1;    
        if(typeof times=='undefined'||times==null||times==""){    
           num=1;    
        }else{    
           var vt=times+"";    
           num=parseInt(vt);    
        }    
        if(typeof mingwen=='undefined'||mingwen==null||mingwen==""){    
        }else{    
            $.base64.utf8encode = true;    
            code=mingwen;    
            for(var i=0;i<num;i++){    
               code=$.base64.btoa(code);    
            }    
        }    
        return code;    
    }; 
    
});




/**
 * 电话号码
 * @param money
 * @returns {*}
 */
function validatePhone(phone) {
    var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    if (reg.test(phone)) {
        return "Y";
    }
    return "请输入正确的金额,且最多两位小数!";
}
 
 

</script>
</body>
</html>