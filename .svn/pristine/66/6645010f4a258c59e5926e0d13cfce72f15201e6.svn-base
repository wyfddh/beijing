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
 width:100px;
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
   /* padding-bottom:25px;*/
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
.headFont{
    font-weight: bold;
    margin-left: 43px;
}
.add{
    color:#BE9A5B;
    margin-left: 43px;
}
.layui-table{
    margin-left: 28px;
    width: 95%;
}
.delbtn{
    width: 35px;
}
</style>
<title>主要仪器设备</title>
</head>
<body class="childrenBody">
 <div>  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
        <input type="hidden" id="geography" name="geography" value="">
        <input type="hidden" id="level" name="level" value="${level}"/>
        <input type="hidden" name="orgId" id="orgId" value="${relicsBureauId}">
        <input type="hidden" name="isFull" id="isFull" value="">
        <div class="layui-row">
            <div class="layui-col-md2 layui-col-md-offset10 pt_30">
                <span style="text-align:center;display:block;">
                    <c:if test="${'1' eq level}">
                        <c:if test="${empty status || status eq 0}">
                            <a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase">保存</a>
                            <a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
                        </c:if>
                        <c:if test="${not empty status && status ne 0}">
                            <a id="btn_edit" type="button" class="layui-btn">编辑</a>
                            <a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveBase" style="margin-left:0px">保存</a>
                        </c:if>
                    </c:if>
                    <a id="btn_back" type="button" class="layui-btn">返回</a>
                </span>
            </div>
        </div>
    
        <div class="layui-row">
            <div class="layui-col-md3">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;必备设备</a>
            </div>
        </div>
            <table id="table1" class="layui-table" lay-skin="nob">
                <thead>
                    <tr>
                        <th width="30px">序号</th>
                        <th width="200px">仪器设备名称</th>
                        <th>是否为申请资质时已配备设备：</th>
                        <th width="200px">型号规格</th>
                        <th>数量(台/套)：</th>
                        <th>购置单价(万元)：</th>
                        <th>使用频率</th>
                        <th>购买年份</th>
                        <th>报废年份</th>                     
                    </tr>
                </thead>
                <tbody id="tbody1">
                        <c:if test="${!(status eq 0)}">
                    <c:forEach items="${list}" var="item" varStatus="row">
                        <tr data="${item.id}" id="tr${item.id}">
                            <td >
                                ${row.count }
                            </td>
                            <td >
                                <input type="text" class="layui-hide"  name="id" value="${item.id}">
                                <input type='text' class='layui-hide'  name='editType' value='1'>                        
                                <input type='text' class='layui-input' readonly="readonly" title="${item.eName }" name='eName' value='${item.eName }'>
                            </td>
                            <td>
                                <select  name="existEquipment" class="typeOne" disabled="disabled">  
                                    <option value="" name="existEquipment" <c:if test="${'' eq item.existEquipment}">selected</c:if>>请选择</option>
                                    <option value="0" name="existEquipment" <c:if test="${'0' eq item.existEquipment}">selected</c:if>>是</option>
                                    <option value="1" name="existEquipment" <c:if test="${'1' eq item.existEquipment}">selected</c:if>>否</option>
                                </select>
                            </td>
                            <td>
                                <input type="text" class="layui-input" disabled="disabled" title="${item.specification}"  name="specification" value="${item.specification}">
                            </td>
                            <td>
                                <input type="number" class="layui-input" lay-verify="num1" disabled="disabled" name="eCount" value="${item.eCount}">
                            </td>
                            <td>
                                <input type="number" class="layui-input" disabled="disabled" lay-verify="num"  name="price" value="${item.price}">
                            </td>
                            <td>
                                <select  name="useFrequency" class="typeOne" disabled="disabled">  
                                    <option value="" name="useFrequency" <c:if test="${'' eq item.useFrequency}">selected</c:if>>请选择</option>
                                    <option value="1" name="useFrequency" <c:if test="${'1' eq item.useFrequency}">selected</c:if>>频繁</option>
                                    <option value="2" name="useFrequency" <c:if test="${'2' eq item.useFrequency}">selected</c:if>>经常</option>
                                    <option value="3" name="useFrequency" <c:if test="${'3' eq item.useFrequency}">selected</c:if>>偶尔</option>
                                </select>
                            </td>
                            <td>
                                <input type="text" class="layui-input purchaseYear" disabled="disabled" name="purchaseYear" value="${item.purchaseYear}">
                            </td>                                                      
                            <td>
                                <input type="text" class="layui-input scrapYear" disabled="disabled" placeholder='请选择' id="scrapYear" name="scrapYear" <c:if test="${not empty item.scrapYear && item.scrapYear ne 0}">value="${item.scrapYear}"</c:if>>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${status eq 0}">
                    <tr>
                            <td >
                                ${row.count }
                            </td>
                            <td >
                                <input type="text" class="layui-hide"  name="id" value="${item.id}">
                                    <input type='text' class='layui-hide'  name='editType' value='0'>                                        
                                <input type='text' class='layui-input' title="${item.eName }" readonly="readonly"  name='eName' value='${item.eName }'>
                            </td>
                            <td>
                                <select  name="existEquipment" class="typeOne" disabled="disabled">  
                                    <option value="" name="existEquipment" <c:if test="${'' eq item.existEquipment}">selected</c:if>>请选择</option>
                                    <option value="0" name="existEquipment" <c:if test="${'0' eq item.existEquipment}">selected</c:if>>是</option>
                                    <option value="1" name="existEquipment" <c:if test="${'1' eq item.existEquipment}">selected</c:if>>否</option>
                                </select>
                            </td>
                            <td>
                                <input type="text" class="layui-input" title="${item.specification}" disabled="disabled"  name="specification" value="${item.specification}">
                            </td>
                            <td>
                                <input type="number" class="layui-input" lay-verify="num1" disabled="disabled"  name="eCount" value="${item.eCount}">
                            </td>
                            <td>
                                <input type="number" class="layui-input" disabled="disabled" lay-verify="num" name="price" value="${item.price}">
                            </td>
                            <td>
                                <select  name="useFrequency" class="typeOne" disabled="disabled">  
                                    <option value="" name="useFrequency" <c:if test="${'' eq item.useFrequency}">selected</c:if>>请选择</option>
                                    <option value="1" name="useFrequency" <c:if test="${'1' eq item.useFrequency}">selected</c:if>>频繁</option>
                                    <option value="2" name="useFrequency" <c:if test="${'2' eq item.useFrequency}">selected</c:if>>经常</option>
                                    <option value="3" name="useFrequency" <c:if test="${'3' eq item.useFrequency}">selected</c:if>>偶尔</option>
                                </select>
                            </td>
                            <td>
                                <input type="text" class="layui-input purchaseYear" disabled="disabled"  name="purchaseYear" value="${item.purchaseYear}">
                            </td>                                                      
                            <td>
                                <input type="text" class="layui-input scrapYear" disabled="disabled"  placeholder='请选择' id="scrapYear" name="scrapYear" <c:if test="${not empty item.scrapYear && item.scrapYear ne 0}">value="${item.scrapYear}"</c:if>>
                            </td>
                        </tr>
                </c:if>
                </tbody>
            </table>
         <div class="layui-row">
            <div class="layui-col-md3">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;其他设备</a>
            </div>
        </div>
            <input type="text" class="layui-hide" value="1" name="addPersonnel">
            <div class="layui-row">
	            <div class="layui-col-md1 layui-col-md-offset11 pt_30">            
	                <a id="addEquiment" type="button" class="layui-btn"  lay-filter="addEquiment"style="float: right;margin-right: 115px;">添加</a>
	            </div>
            </div>
            <table id="table2" class="layui-table" lay-skin="nob" lay-filter="table2">

            </table>
            
    </form>
    <script type="text/html" id="barDemo">
            <a class="layui-btn  layui-btn-xs" lay-event="show">查看</a>
		<c:if test="${'1' eq level}">
            <a class="layui-btn  layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn  layui-btn-xs" lay-event="del">删除</a>
		</c:if>
    </script>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>

<script type="text/javascript">

layui.use(['form','table','layer','upload','laydate'],function(){
    
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laydate=layui.laydate,
        $ = layui.jquery;
    var table = layui.table;
        
    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
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
            type:'year'
            ,max:year
        });
     }); 
    
        
    var count = 0;
    
    //页面初始化
    var level = $("#level").val();
    if(level == "2"){
        $('input,select,textarea').attr('disabled',"disabled"); 
        form.render('select');
    }
    initFileds();
    var relicsBureauId = $("#orgId").val();
    table.render({
        elem: '#table2'
        ,url:"<%=request.getContextPath()%>/relicsBureau/getOtherEquiment.do?relicsBureauId="+relicsBureauId
        // ,toolbar: '#toolbarDemo'
        ,title: '其他设备'
        ,cols: [[
            {type: 'numbers', fixed: 'left',title:'序号'}
            ,{field:'eName', title:'仪器设备名称'}
            ,{field:'eCount', title:'数量(台/套)'}
            ,{field:'price', title:'购置单价(万元)'}
            ,{field:'useFrequency', title:'使用频率',templet: function(res){
                if(res.useFrequency=="1"){
                	return '频繁';
                }else if(res.useFrequency=="2"){
                	return '经常';
                }else if(res.useFrequency=="3"){
                	return '偶尔';
                }else{
                	return '';
                }
            }}
            ,{field:'purchaseYear', title:'购买年份'}
            ,{field:'scrapYear', title:'报废年份'}
            ,{field:'existEquipment', title:'是否为申请资质时已配备设备',width:200,templet: function(res){
                if(res.existEquipment=="1"){
                    return '是';
                }else if(res.existEquipment=="0"){
                    return '否';
                }else{
                    return '';
                }
            }}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:200}
        ]],
        page:false
    });
    
  //监听行工具事件
    table.on('tool(table2)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            var index = layer.confirm('确定删除?', function(index){
            	layer.close(index);          	
                var id = data.id;
                var json = {"id":id};
                $.ajax({
                    url:"<%=request.getContextPath()%>/relicsBureau/deleteOtherEquipment.do",
                    data:json,
                    type:"POST",
                    success:function(data){                                                   
                       if(data.success == 1){
                    	   layer.msg("删除成功！");
                    	   obj.del();
                        }else if(data.success == 0){
                            layer.msg("删除失败！",{icon:2});
                        }
                    },
                    error:function(msg){
                       layer.msg("删除失败！",{icon:2});
                    }
                 });
                  
            });
        } else if(obj.event === 'edit'){
        	var orgId = $("#orgId").val();
        	var id = data.id;
            var a = layer.open({
                type: 2,
                title: "编辑设备",
                shadeClose: true,
                shade: 0.5,
                maxmin: false, //开启最大化最小化按钮
                area: ['800px', '720px'],
                content: ['<%=request.getContextPath() %>/relicsBureau/goEditOtherEquiment.do?relicsBureauId='+ orgId+'&id='+id,'yes'],
                success:function(layero, index){
                    resizeLayer(index);
                },
                end:function(){
                	update();
                }
            });
        }else if(obj.event === 'show'){
        	var orgId = $("#orgId").val();
            var id = data.id;
            var a = layer.open({
                type: 2,
                title: "查看设备",
                shadeClose: true,
                shade: 0.5,
                maxmin: false, //开启最大化最小化按钮
                area: ['800px', '720px'],
                content: ['<%=request.getContextPath() %>/relicsBureau/goShowOtherEquiment.do?relicsBureauId='+ orgId+'&id='+id,'yes'],
                success:function(layero, index){
                    resizeLayer(index);
                }
            });
        }
    
        
    });
    
    //提交
    form.on("submit(saveBase)",function(data){               
//         if(checkModification()){
            $("#isFull").val("1");
            var loading; 
            var dataList = new Array();
            var otherDataList = new Array();
          
            $("#tbody1").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var eName = tdArr.find("[name='eName']").val();
                var eCount = tdArr.find("[name='eCount']").val();
                var purchaseYear = tdArr.find("[name='purchaseYear']").val();
                var price = tdArr.find("[name='price']").val();
                var specification = tdArr.find("[name='specification']").val();
                var useFrequency = tdArr.find("[name='useFrequency']").val();
                var scrapYear = tdArr.find("[name='scrapYear']").val();
                var existEquipment = tdArr.find("[name='existEquipment']").val();
                var editType = tdArr.find("[name='editType']").val();
                if (!isEmpty(eName)) {
                    dataList.push({"id":id,"eName":eName,"eCount":eCount,"purchaseYear":purchaseYear,
                    	"price":price,"specification":specification,"useFrequency":useFrequency,
                    	"scrapYear":scrapYear,"existEquipment":existEquipment,"spareData1":editType});
                }
            });
            $("#tbody2").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var eName = tdArr.find("[name='eName']").val();
                var eCount = tdArr.find("[name='eCount']").val();
                var purchaseYear = tdArr.find("[name='purchaseYear']").val();
                var price = tdArr.find("[name='price']").val();
                var useFrequency = tdArr.find("[name='useFrequency']").val();
                var scrapYear = tdArr.find("[name='scrapYear']").val();
                var existEquipment = tdArr.find("[name='existEquipment']").val();
                var editType = tdArr.find("[name='editType']").val();
                if (!isEmpty(eName)) {
                	otherDataList.push({"id":id,"eName":eName,"eCount":eCount,"purchaseYear":purchaseYear,
                        "price":price,"useFrequency":useFrequency,
                        "scrapYear":scrapYear,"existEquipment":existEquipment,"spareData1":editType});
                }
            });

            var dto = {};
            dto.orgId = $("#orgId").val();
            dto.culturalRelicMainEquipment = dataList;
            dto.culturalRelicOtherEquipment = otherDataList;
            dto.isFull = $("#isFull").val();
            $.ajax({
                url:"<%=request.getContextPath()%>/relicsBureau/saveEquipment.do",
                data:JSON.stringify(dto),
                type:"POST",
                dataType:"json", 
                contentType : 'application/json;charset=utf-8',
                success:function(data){
                       layer.msg("保存成功！");
                   if(data.success == 1){
                       setTimeout(function(){
                           window.location.href = window.location.href;
                       },1000)
                    }else if(data.success == 0){
                        layer.msg("保存失败！",{icon:2});
                    }
                },
                error:function(msg){
                   layer.msg("保存失败！",{icon:2});
                }
             });
//         }else{
//             layer.msg("资料没有修改，无需提交！");
//         }
       return false;
    });
    
    
    
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
//         $("#addEquiment").removeClass("layui-hide");
        var relicsBureauId = $("#orgId").val();
//         table.render({
//             elem: '#table2'
<%--             ,url:"<%=request.getContextPath()%>/relicsBureau/getOtherEquiment.do?relicsBureauId="+relicsBureauId --%>
//             // ,toolbar: '#toolbarDemo'
//             ,title: '其他设备'
//             ,cols: [[
//                 {type: 'numbers', fixed: 'left',title:'序号'}
//                 ,{field:'eName', title:'仪器设备名称'}
//                 ,{field:'eCount', title:'数量(台/套)'}
//                 ,{field:'price', title:'购置单价(万元)'}
//                 ,{field:'useFrequency', title:'使用频率',templet: function(res){
//                     if(res.useFrequency=="1"){
//                         return '频繁';
//                     }else if(res.useFrequency=="2"){
//                         return '经常';
//                     }else if(res.useFrequency=="3"){
//                         return '偶尔';
//                     }else{
//                         return '';
//                     }
//                 }}
//                 ,{field:'purchaseYear', title:'购买年份'}
//                 ,{field:'scrapYear', title:'报废年份'}
//                 ,{field:'existEquipment', title:'是否为申请资质时已配备设备',width:200,templet: function(res){
//                     if(res.existEquipment=="1"){
//                         return '是';
//                     }else if(res.existEquipment=="0"){
//                         return '否';
//                     }else{
//                         return '';
//                     }
//                 }}
//                 ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:200}
//             ]],
//             page:false
//         });
        
    });
    var count = 0;
    function addRow() {
        count++;
        var str =        
            "<tr id='tr"+count+"'>"
            +"<td>"  
            +"<a data='"+count+"' class='deleteRow' editType='1' href='javascript:;'><img src='"+projectName+"/back/images/delete.png'></a>"
            +"</td>"
            +"<td>"
            +"<input type='text' class='layui-hide'  name='id' >"
            +"<input type='text' class='layui-hide'  name='editType' value='1'>"
            +"<input type='text' class='layui-input' lay-verify='required' name='eName' value='${item.eName}'>"
            +"</td>"
            +"<td>"
            +"<input type='text' class='layui-input' lay-verify='required' name='eCount' value='${item.eCount}'>"
            +"</td>"
            +"<td>"
            +"<input type='text' class='layui-input purchaseYear' lay-verify='required' name='purchaseYear' value='${item.purchaseYear}'>"
            +"</td>"
            +"<td>"
            +"<input type='text' class='layui-input' lay-verify='required' name='price' value='${item.price}'>"
            +"</td>"
            +"<td>"
            +"<input type='text' class='layui-input' lay-verify='required' name='specification' value='${item.specification}'>"
            +"</td>"
            +"<td>"
            +"<select  name='natures' class='typeOne' >"
            +"<option value='1' name='useFrequency'>频繁</option>"
            +"<option value='2' name='useFrequency'>经常</option>"
            +"<option value='3' name='useFrequency'>偶尔</option>"
            +"</select>"
            +"</td>"
            +"<td>"
            +"<input type='text' class='layui-input scrapYear'  placeholder='在用' id='scrapYear' name='scrapYear' value='${item.scrapYear}'>"
            +"</td>"
            +"<td>"
            +"<select  name='existEquipment' class='typeOne' >"  
            +"<option value='0' name='existEquipment' >是</option>"
            +"<option value='1' name='existEquipment' >否</option>"
            +"</select>"
            +"</td>"
        +"</tr>"           
        return str;
    }
    
    $("#add").click(function() {
        var rowStr = addRow();
        $("#tbody2").append(rowStr);     
        form.render();    
        lay('.scrapYear').each(function(){
            laydate.render({
                elem: this, //指定元素
                type:'year',
                max: year
            });
         }); 
        lay('.purchaseYear').each(function(){
            laydate.render({
                elem: this, //指定元素
                type:'year'
                
            });
         }); 
    })
    $(document).on('click', '.deleteRow', function() {
        deleteRow($(this));
    })
    function deleteRow(result) {
        var data = result.attr("data");
        var trId = "tr"+data;
        var tdArr = $('#'+trId).children();
        var id = tdArr.find("[name='id']").val();
       if(id != null && id != ""){
    	   tdArr.find("[name='editType']").val("2");
    	   $('#'+trId).hide();
       }else{
    	   $('#'+trId).remove(); 
       }       
    }
    
    
    function isEmpty(obj){
        if(typeof obj == "undefined" || obj == null || obj == "")   {
            return true;
        }else{
            return false;
        }
    }
    
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

$("#addEquiment").click(function(){
	var orgId = $("#orgId").val();
	var a = layer.open({
        type: 2,
        title: "新增设备",
        shadeClose: true,
        shade: 0.5,
        maxmin: false, //开启最大化最小化按钮
        area: ['800px', '720px'],
        content: ['<%=request.getContextPath() %>/relicsBureau/goOtherEquiment.do?relicsBureauId='+ orgId,'yes'],
        success:function(layero, index){
            resizeLayer(index);
        },
        end:function(){
            update();
        }
    });
})


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
 
 
 function update(){
	 layui.use(['table'],function(){
		 var relicsBureauId = $("#orgId").val();
		  var table = layui.table;
		  table.render({
	            elem: '#table2'
	            ,url:"<%=request.getContextPath()%>/relicsBureau/getOtherEquiment.do?relicsBureauId="+relicsBureauId
	            // ,toolbar: '#toolbarDemo'
	            ,title: '其他设备'
	            ,cols: [[
	                {type: 'numbers', fixed: 'left',title:'序号'}
	                ,{field:'eName', title:'仪器设备名称'}
	                ,{field:'eCount', title:'数量(台/套)'}
	                ,{field:'price', title:'购置单价(万元)'}
	                ,{field:'useFrequency', title:'使用频率',templet: function(res){
	                    if(res.useFrequency=="1"){
	                        return '频繁';
	                    }else if(res.useFrequency=="2"){
	                        return '经常';
	                    }else if(res.useFrequency=="3"){
	                        return '偶尔';
	                    }else{
	                        return '';
	                    }
	                }}
	                ,{field:'purchaseYear', title:'购买年份'}
	                ,{field:'scrapYear', title:'报废年份'}
	                ,{field:'existEquipment', title:'是否为申请资质时已配备设备',width:200,templet: function(res){
	                    if(res.existEquipment=="1"){
	                        return '是';
	                    }else if(res.existEquipment=="0"){
	                        return '否';
	                    }else{
	                        return '';
	                    }
	                }}
	                ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:200}
	            ]],
	            page:false
	        });
	 });
 }

</script>
</body>
</html>