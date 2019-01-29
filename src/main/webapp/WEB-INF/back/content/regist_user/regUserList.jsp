<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE html> -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../../back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        a:hover{
            text-decoration: none;
        }
        .check-box, .radio-box{
            padding-left: 0;
        }
        .layui-layer-page .layui-layer-content{
            overflow-x: hidden!important;
        }
    </style>
    <title>活动管理</title>
</head>
<body>
<!-- <header id="head"></header>
<aside id="manaside"></aside> -->
<!--_header 作为公共模版分离出去-->
	<%@ include file="../../header.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section  class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 文章列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <form action="<%=request.getContextPath() %>/regUserManage/info.do" class="cl pd-20">
            <div class="row cl mt-30 ml-10">
                <div class="f-l mt-5 ml-50">创建时间：</div>
                <div class="col-xs-2">
                    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" 
                    name="startCreateTime" class="input-text Wdate" value="${startCreateTime }">
                </div>
                <div class="f-l mt-5">至</div>
                <div class="col-xs-2">
                    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" 
                   name="endCreateTime" class="input-text Wdate" value="${endCreateTime }">
                </div>
                <div class="f-l mt-5 ml-20">手机号码：</div>
                <div class="formControls col-xs-3">
                    <input type="text" class="input-text" placeholder="张三" name="phone" value="${phone }">
                </div>
                <div class="clearfix"></div>
                <div class="f-l mt-15 ml-20">最后登录时间：</div>
                <div class="col-xs-2 mt-10">
                    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin1" 
                    name="startLastLoginTime" class="input-text Wdate" value="${startLastLoginTime }">
                </div>
                <div class="f-l mt-15">至</div>
                <div class="col-xs-2 mt-10">
                    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax1" 
                    name="endLastLoginTime"class="input-text Wdate" value="${endLastLoginTime }">
                </div>
                <div class="f-l mt-15 ml-20">用户昵称：</div>
                <div class="formControls col-xs-3 mt-10">
                    <input type="text" class="input-text" placeholder="张三" name="key" value="${key }">
                </div>
                <div class="mt-20 col-xs-12 ml-40">
                    <button class="btn btn-primary" type="submit" style="margin-left: 30%"><i class="Hui-iconfont">&#xe709;&nbsp;</i>搜索</button>
                    <button class="btn btn-danger ml-30" id="reset"><i class="Hui-iconfont">&#xe68f;&nbsp;</i>重置</button>
                </div>
            </div>
            <div style="clear: both"></div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="40"><input name="" type="checkbox" value=""></th>
                        <th width="100">序号</th>
                        <th width="500">账号</th>
                        <th width="200">用户昵称</th>
                        <th width="300">注册时间</th>
                        <th width="300">最后登录时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="status">
                    <tr class="text-c">
                        <td><input name="" type="checkbox" value=""></td>
                        <td>${status.index + 1}</td>
                        <td>${user.phone}</td>
                        <td>${user.nickName}</td>
                        <td>${user.createTime}</td>
                        <td>${user.lastLoginTime}</td>
                        <td class="td-manage">
                            <a href="<%=request.getContextPath() %>/regUserManage/detail.do?id=${user.id}"><input type="button" class="btn btn-primary size-S edit" value="查看"></a>&nbsp;
                             <c:if test="${'1' eq user.status }">
                            <a href="javascript:;"><input type="button" onclick="jinyong(${user.id})" class="btn btn-success size-S qiyong" value="停用"></a>
                             </c:if>
                              <c:if test="${'0' eq user.status }">
                            <a href="javascript:;"><input type="button"  onclick="qiyong(${user.id})" class="btn btn-success size-S qiyong" value="启用"></a>
                             </c:if>
                            <a href="javascript:;"><input type="button" class="btn btn-danger size-S del" value="删除" onclick="del(${user.id})"></a>
                        </td>
                    </tr>
                     </c:forEach> 
                    </tbody>
                </table>
            </div>
             <br>
			<div id="page" align="center"></div>
        </form>
    </div>
    <div>
    </div>
</section>
<script type="text/javascript">
    /* $("#head").load("../../../organization/asideUserGover.html");
    $("#manaside").load("../../../organization/headUserGover.html"); */
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
var nums = ${page.size}; //每页出现的数量
var pages = ${page.totalPage}; //得到总页数
//调用分页
laypage({
    cont: 'page',
    pages: pages,
    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
        var page = location.search.match(/page=(\d+)/);
        return page ? page[1] : 1;
    	}(), 
   	skip: true, //是否开启跳页
   	skin: '#72CDAE', //皮肤
   	groups: 3, //连续显示分页数
    jump: function(e, first){ //触发分页后的回调
       if(!first){ //一定要加此判断，否则初始时会无限刷新
         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
       }
    }
})
/*     $('.table-sort').dataTable({
//        "info": false,
        "paging": true,
        "searching": false,
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "stateSave": true,
        "displayStart": 1, //一开始显示第一页
        "bStateSave": true,//状态保存
        "pagingType": "full_numbers",
        "aoColumnDefs": [
//            {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
        ],
        "aLengthMenu": [10, 25, 50, -1]  //也可以直接用一维数组设置数量
    }); */
</script>
<script type="text/javascript">
    /* function del(){
        layer.confirm('您确定要删除该条信息吗？', {
            btn: ['确定','取消'] //按钮
        }, function(index){
//            layer.msg('我点击了确定按钮', {icon: 1});
            //点击确定之后需要执行的函数
            layer.alert('删除成功', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            setTimeout(function(){
                layer.closeAll();  //关闭弹出层
            },1000);
        }, function(index){
            layer.close(index);  //关闭弹出层
        });
    }; */
    function del(id) {
		layer.confirm('确定删除此信息？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : "<%=request.getContextPath()%>/regUserManage/delete.do",
					type : "post",
					data :  {ids:id},
					dataType : "json",
					async: false,
					success : function(data){
						if(data){
							layer.msg('成功删除', {icon: 1});
							setTimeout(function(){
								/* window.location.href = window.location.href; */
								window.location.href = '<%=request.getContextPath()%>/regUserManage/info.do';
							},1000)
							
						}else{
							layer.msg('删除失败', {icon: 2});
						}
					},
				})
			}, function(){
			  layer.msg('已取消删除', {
			  });	
			});
	};
    
	function jinyong(id) {
		$.ajax({
			url : "<%=request.getContextPath()%>/regUserManage/jinyong.do",
			type : "get",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				if(data == "1"){
					layer.msg('停用成功', {icon: 1});
					setTimeout(function(){
						window.location.href = window.location.href;
					},1000)
					
				}
				else{
					layer.msg('停用失败', {icon: 2});
				}
			},
		})
	};
	
	function qiyong(id) {
		$.ajax({
			url : "<%=request.getContextPath()%>/regUserManage/qiyong.do",
			type : "get",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				if(data == "1"){
					layer.msg('启用成功', {icon: 1});
					setTimeout(function(){
						window.location.href = window.location.href;
					},1000)
					
				}
				else{
					layer.msg('启用失败', {icon: 2});
				}
			},
		})
	};
    /* $(".qiyong").click(function(){
        var that = $(this);
        if($(this).val() == "启用"){
            layer.confirm('您确定要启用这条消息吗？', {
                btn: ['确定','取消'] //按钮
            }, function(index){
                layer.alert('启用成功', {
                    skin: 'layui-layer-lan',
                    closeBtn: 0,
                    anim: 4 //动画类型
                });
                setTimeout(function(){
                    layer.closeAll();  //关闭弹出层
                },1000);
                $(that).val("停用").removeClass("btn-success").addClass("btn-default");
            }, function(index){
                layer.close(index);  //关闭弹出层
            });
        }else {
            layer.confirm('您确定要停用这条消息吗？', {
                btn: ['确定','取消'] //按钮
            }, function(index){
//            layer.msg('我点击了确定按钮', {icon: 1});
                //点击确定之后需要执行的函数
                layer.alert('取消发布成功', {
                    skin: 'layui-layer-lan',
                    closeBtn: 0,
                    anim: 4 //动画类型
                });
                setTimeout(function(){
                    layer.closeAll();  //关闭弹出层
                },1000);
                $(that).val("启用").removeClass("btn-default").addClass("btn-success");
            }, function(index){
                layer.close(index);  //关闭弹出层
            });
        }

    }); */
</script>
</body>
</html>