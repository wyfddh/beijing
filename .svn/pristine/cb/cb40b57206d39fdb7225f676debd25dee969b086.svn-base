<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<!--[if lt IE 9]>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/respond.min.js"></script>
    <![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->
	<style type="text/css">
		a:hover {
			text-decoration: none;
		}
		.layui-layer-page .layui-layer-content {
			overflow-x: hidden !important;
		}

		.huodong{
			padding: 30px;
		}

		.huodong > div{
			margin: 0 0 15px;
		}

		tbody .text-c{
			border-bottom: 1px solid #DDDDDD;
		}
		thead>tr{
			background: #F1F2F7!important;
			height: 60px!important;
			border-radius: 7px!important;
		}
		thead>tr>th{
			color: #666666!important;
		}


		<%--新改的样式--%>
		.selectInput{
			border: 1px solid rgb(241, 242, 247);
			border-radius: 4px;
			background-color: rgb(252, 252, 252);
			width: 188px;
			height: 24px;
			box-sizing:border-box;
		}
		.w300{
			width:300px;
			box-sizing:border-box;
		}
		.w360{
			width:360px;
			box-sizing:border-box;
		}
		.mr{
			margin-right:6px;
		}
		.inputWidth{
			border: 1px solid rgb(241, 242, 247);
			border-radius: 4px;
			background-color: rgb(252, 252, 252);
			width: 193px;
			height: 24px;
			box-sizing:border-box;
		}
		.areaSel{
			border: 1px solid rgb(241, 242, 247);
			border-radius: 4px;
			background-color: rgb(252, 252, 252);
			width: 77px;
			height: 24px;
			box-sizing:border-box;
		}
		.museumSel{
			border: 1px solid rgb(241, 242, 247);
			border-radius: 4px;
			background-color: rgb(252, 252, 252);
			width: 129px;
			height: 24px;
			box-sizing:border-box;
		}
		.clearFloat{
			clear:both;
			margin:0!important;
		}
		.input-calender{
			border: 1px solid rgb(241, 242, 247);
			border-radius: 4px;
			background-color: rgb(252, 252, 252);
			width: 111px;
			height: 24px;
			box-sizing:border-box;
		}
		.btnCheck{
			border-radius: 4px;
			width: 59px;
			height: 26px;
			margin-right:20px;
			box-sizing:border-box;
			cursor:pointer;
		}
		.btnCheck > img{
			width:16px;
			height:16px;
			margin-top:-3px;
		}
		.search{
			background-color: rgb(42, 155, 207);
			font-size: 14px;
			font-family: "Microsoft YaHei";
			color: rgb(255, 255, 255);
			line-height:26px;
			border:none;
			outline:none;
		}
		.reset{
			background-color: rgb(255, 255, 255);
			border:1px solid rgb(42, 155, 207);
			font-size: 14px;
			font-family: "Microsoft YaHei";
			color: rgb(255, 255, 255);
			line-height:24px;
			color:rgb(42, 155, 207);
		}
		th:nth-child(1){
			border-top-left-radius:5px;
			border-bottom-left-radius:5px;
		}
		th:nth-last-child(1){
			border-top-right-radius:5px;
			border-bottom-right-radius:5px;
		}
		.cursor{
			cursor:pointer;
		}
		.checked{
			border-radius: 4px;
			background-color: rgb(42, 155, 207);
			width: 49px;
			height: 24px;
			font-size: 12px;
			font-family: "Microsoft YaHei";
			color: rgb(255, 255, 255);
			line-height: 24px;
			text-align:center;
			border:none;
			outline:none;
		}
	</style>
	<title>讲解词审查</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
 <%@ include file="../weihuNav.jsp"%> 
 
<!--_menu 左边slide导航开始-->
 <%@ include file="../../content/aside.jsp" %>
<section  class="Hui-article-box">
    <form action="<%=request.getContextPath()%>/back/audioSearch/index.do" class="huodong" method="post" id="audioForm">
    	<div class="hide">   
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${example.size }" name="size">
	        </div> 
        <div class="f-l w300">
        	审核状态 :
			<select name="status" class="selectInput pl-10" size="1">
				<option value="">全部</option>
				<option value="1" <c:if test="${example.status==1}">selected</c:if>>待审核</option>
				<option value="2" <c:if test="${example.status==2}">selected</c:if>>已通过</option>
			</select>
		</div>

		<div class="f-l w300">
			藏品名称 : <input type="text" class="pl-10 inputWidth" id="collectionName"  value="${example.collectionName}" name="collectionName" placeholder="藏品名称">
		</div>

		<div class="f-l w300">
			用户昵称 : <input type="text" class="pl-10 inputWidth" id="userNameIn"  value="${example.userName}" name="userName" placeholder="用户昵称">
		</div>
		<c:if test="${level==1}">
			<div  class="f-l w300">
        		单位 :
	    			<select name="area" class="areaSel pl-10 mr" size="1" id="diqu" onchange="selectmesuem(this.value)">
						<option value="">地区</option>
						<c:forEach items="${cityList}" var="a" varStatus="row">
							<option value="${a.id}" <c:if test="${a.id==area}">selected</c:if>>${a.shortname}</option>
						</c:forEach>
					</select>
	    		    <select name="unit" class="museumSel pl-10" size="1" id="danwei">
						<option value="">单位</option>
						<c:forEach items="${mesuemList}" var="u" varStatus="row">
							<option value="${u.id}" <c:if test="${u.id ==example.collectionUnit}">selected</c:if> >${u.name}</option>
						</c:forEach>
					</select>
			</div>
		</c:if>
		<c:if test="${level==2}">
			<div  class="f-l w300">
				单位 :
				 	<select name="unit" class="museumSel pl-10" size="1" id="danwei">
						<option value="">单位</option>
						<c:forEach items="${mesuemList}" var="u" varStatus="row">
							<option value="${u.id}" <c:if test="${u.id ==example.collectionUnit}">selected</c:if> >${u.name}</option>
						</c:forEach>
					</select>
			</div>
		</c:if>

        <div  class="f-l w360">
            	上传时间 :&nbsp;
                <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemax" class="input-calender input-text Wdate pl-10" name="startTime" value="${example.startTime}">
                &nbsp;至&nbsp;
                <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemin" class="input-calender input-text Wdate pl-10"  name="endTime" value="${example.endTime}">
        </div>

		<div class="clearFloat"></div>

        <div class="btnWrap">
			<button class="btnCheck search" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" /> 搜索</button>
			<button class="btnCheck reset" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" /> 重置</button>
			<span style="float:right;">共${totle}条数据</span>
		</div>

        <div>
            <table class="table">
                <thead>
                	<tr class="text-c">
                	    <!--<th width="40"><input name="" type="checkbox" value=""></th>-->
                	    <th width="80">序号</th>
                	    <th width="300">藏品名称</th>
                	    <th width="300">单位</th>
                	    <th width="300">讲解词功能</th>
                	    <th width="100">时长</th>
                	    <th width="200">用户昵称</th>
                	    <th width="300">上传时间</th>
                	    <th width="100">点赞数</th>
                	    <th width="150">审核状态</th>
                	    <th width="300">操作</th>
                	</tr>
                </thead>
            	<tbody>
            	<c:set var="recordNumber" value="${(example.currentPage - 1) * example.size }" /> 
            	<c:forEach items="${mipAudioList}" var="audio" varStatus="row">
	            	<tr class="text-c">
	            		<td>${row.count + recordNumber}</td>
						<td>${audio.collectionName}</td>
						<td>${audio.mueseumName}</td>
						<td>
							<img class="cursor play" isPlaying="false" data="${audio.url}" src="<%=request.getContextPath() %>/back/images/table_play.png" title="播放">
							<img class="cursor hide stop" src="<%=request.getContextPath() %>/back/images/table_stop.png" title="暂停">
							<a href="" download="music">
								<img class="cursor downloadMusic" data="${audio.url}" src="<%=request.getContextPath() %>/back/images/table_download.png" title="下载">
							</a>
						</td>
						<td>
						<c:choose>
						<c:when test="${ audio.duration>3600}">
						<jsp:useBean id="dateValue" class="java.util.Date"/>
						<jsp:setProperty name="dateValue" property="time" value="${(audio.duration-28800)*1000}"/>
                        <fmt:formatDate value="${dateValue}" pattern="hh:mm:ss"/>
						</c:when>
						<c:otherwise>
						<jsp:useBean id="dateValue1" class="java.util.Date"/>
						<jsp:setProperty name="dateValue1" property="time" value="${audio.duration*1000}"/>
                        <fmt:formatDate value="${dateValue1}" pattern="mm:ss"/>
						</c:otherwise>
						</c:choose>
						</td>
						<td>${audio.userName}</td>
						<td>
						<fmt:formatDate value="${audio.createtime}" pattern="yyyy-MM-dd"/></td>
						<td>${audio.likeCounts}</td>
						<td>
							<c:if test="${audio.status==1}">待审核</c:if>
							<c:if test="${audio.status==2}">已通过</c:if>
						</td>
						<td>
							<c:if test="${audio.status==1}">
								<img class="cursor" src="<%=request.getContextPath() %>/back/images/tabel_check.png" title="审核" onclick="checkAudio('${audio.id}')">
							</c:if>
							<img class="cursor delTable" src="<%=request.getContextPath() %>/back/images/tabel_del.png" title="删除" onclick="deleteRole('${audio.id}')">
						</td>
	            	</tr>
            	</c:forEach>
                </tbody>
            </table>
            <br>
			<div id="page" align="left"></div>
        </div>
		<audio id="audio" controls src="" hidden></audio>
    </form>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

$(function(){
	 $("#pageSize").change(function() {
	    	var size = $(this).val();
	    	if (size == "") {
	    		return false;
	    	} else {
	    		$("#pageSizeHide").val(size); 
		    	$("#audioForm").submit();
	    	}
	    	
  })
})
	
	<%--添加左边样式。--%>
	var level = ${level};
	if (level == 2) { 
		$(".fabu-aside>ul>li").eq(2).addClass("weihu");
	} else {
		$(".fabu-aside>ul>li").eq(3).addClass("weihu");
	}
	$(".headerNav a.checkAudio").addClass("active");
	$(".headerNav a.checkAudio").find("img").attr("src",'<%=request.getContextPath() %>/back/images/check_audio.png');

	<%--点击播放--%>
	$("tbody").delegate(".play","click",function(){
		var this_img = $(this);										  <%--当前点击的对象--%>
		var audioMusic = document.getElementById("audio");
		<%--先判断是不是刚才的放了一半,如果是就继续播放,不是就从头开始--%>
		<%--然后将音频地址变成要播放的那个,开始播放--%>
		if(this_img.attr("isPlaying") == "false"){
			$(".play").attr("isPlaying","false").show(500).next(".stop").hide(500);         <%-- 标记全部变为false--%>
			var audioUrl = this_img.attr("data");                     						<%-- 点击的那个播放地址--%>
			this_img.attr("isPlaying","true");                        						<%-- 把标记变为true,表示当前播放的就是这个--%>
			audioMusic.currentTime = 0.0;
			$("#audio").attr("src",audioUrl);                         						<%--播放路径改为当前的那个--%>
			setTimeout(function(){
				audioMusic.play();
			});
			this_img.hide(500).next(".stop").show(500);               						<%-- 图标换了 --%>
		}else{
			this_img.hide(500).next(".stop").show(500);               						<%-- 图标换了 --%>
			audioMusic.play();
		}
	});

	<%--点击暂停--%>
	$("tbody").delegate(".stop","click",function(){
		var audioMusic = document.getElementById("audio");
		$(this).hide(500).prev(".play").show(500);   				  <%-- 图标换了 --%>
		audioMusic.pause();                         				  <%--音频暂停--%>
	});

	<%--点击下载--%>
	$("tbody").delegate(".downloadMusic","click",function(){
		var thisDownLoad = $(this);
		var src = thisDownLoad.attr("data");                          <%--要下载的那个url--%>
		thisDownLoad.parent("a").attr("href",src);                    <%--a标签里改成要下载的那个--%>
	});
	function formReset() {  
	    $(':input,#myform')  
	     .not(':button, :submit, :reset, :hidden')  
	     .val('')  
	     .removeAttr('checked')  
	     .removeAttr('selected');     
	}

	//点击列表中的删除
	function deleteRole(id){
	    layer.confirm('确定要删除该讲解词吗？', {
	        btn: ['确定','取消'] //按钮
	    }, function(index){
	        //点击确定之后需要执行的函数
	    	$.ajax({
				url : "<%=request.getContextPath() %>/back/audioSearch/delectAudio.do",
				type : "post",
				data :  {"id":id},
				async: false,
				success : function(data){
					if(data.data == "SUCCESS"){
						layer.alert('删除成功', {
					            skin: 'layui-layer-lan',
					            closeBtn: 0,
					            anim: 4 //动画类型
					    });
						setTimeout(function(){
							 $("#audioForm").submit();
						},1000)

					}else{
						layer.msg('删除失败', {icon: 2});
				        setTimeout(function(){
				            layer.closeAll();  //关闭弹出层
				        },1000);
					}
				},
			})
	    }, function(index){
	        layer.close(index);  //关闭弹出层
	    });
	}

	//点击列表中的审查
	function checkAudio(id){
		layer.confirm('是否通过审核？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
				url:"<%=request.getContextPath() %>/back/audioSearch/updateAudio.do",
				type:"POST",
				data:{"id":id},
				async:false,
				success:function(data){
					//如果审查通过的话
					if(data.data == "SUCCESS"){
						layer.msg('审查通过', {
							time: 2000, //20s后自动关闭
							btn: ['确定', '取消']
						});
						setTimeout(function(){
							$("#audioForm").submit();
						},1000)
					}else{
						//否则
						layer.msg('审查失败', {
							time: 2000, //20s后自动关闭
							btn: ['确定', '取消']
						});
					}
				}
			})
		}, function(){
			layer.closeAll();
		});
	}

	var nums = ${example.size}; //每页出现的数量
	var pages = ${example.totalPage}; //得到总页数
	<%--调用列表分页--%>
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
	});
	 var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${example.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
	function selectmesuem(id){
		$.ajax({
			url:"<%=request.getContextPath() %>/back/audioSearch/getMuseum.do",
			type:"POST",
			data:{"id":id},
			async:false,
			success:function(data){
				var cityList = data.data;
				$("#danwei").html("");
				if(cityList.length==0){
					$("#danwei").append('<option value="">单位</option>')
				}
				for(var i = 0;i < cityList.length;i++){
					$("#danwei").append('<option value="'+cityList[i].id+'">'+cityList[i].shortname+'</option>')
				}
			}
		})
		
	}

	<%--判断省级地级或者博物馆管理员--%>
	var gover = ${level};
	function judge(){
	    //    省级 |  地级
	    if(gover == "1" || gover=="2"){
	        $("#diqu").show();
	        $("#danwei").show();
	        return false;
	    }else if(gover == "3"){//    博物馆管理员
	        $("#shengji").hide();
	        return false;
	    }
	}
	judge();
</script>
</body>
</html>