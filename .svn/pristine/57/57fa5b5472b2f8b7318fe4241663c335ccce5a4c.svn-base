<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <title>轮播图添加</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <style>
        *{
            padding:0;
            margin:0;
            box-sizing:border-box;
        }
        .turnImgWrap{
            background:#f1f2f7;
            padding: 28px 20px 0 30px;
            margin-top: 12px;
            height:141px;
            width:100%;
            position:relative;
        }
        .turnImgWrap:nth-child(1){
            margin-top: 0;
        }
        .img{
            width: 226px;
            height: 85px;
            display: table-cell;
            cursor: pointer;
            text-align: center;
            vertical-align: middle;
            font-size: 60px;
            color: #D9D9D9;
            border-radius: 4px;
            background-color: rgb(255, 255, 255);
            float:left;
            overflow:hidden;
        }
        .img img{
            width: 100%;
            height: 100%;
        }
        .delAll{
            position: absolute;
            right: 12px;
            top:10px;
        }
        .int-text{
            width: 500px;
            height: 36px;
            outline: none;
            border-radius: 4px;
            background-color: rgb(255, 255, 255);
            width: 500px;
            height: 36px;
            border:none;
            margin-left:8px;
            padding-left:10px;
        }
        .upfile{
            display: block;
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top:0;
            opacity: 0;
            cursor: pointer;
        }
        .Hui-article-box{
            overflow-x: hidden!important;
            overflow-y: auto!important;
        }
        .lianjie{
            width:585px;
            height:40px;
            line-height:40px;
            padding-left:35px;
            float:left;
            margin-top:22px;
        }
        .contentWrap{
            width:865px;
            margin:0 auto;
        }
        .titleWrap{
            width:100%;
            height:80px;
            position:relative;
            box-sizing:border-box;
            padding-top:20px;
        }
        .title{
            width:100%;
            height:30px;
            line-height:30px;
            box-sizing:border-box;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
        }
        .turnImgPosition{
            width:100%;
            height:30px;
            line-height:30px;
            box-sizing:border-box;
            font-size: 12px;
            font-family: "Microsoft YaHei";
            color: rgb(153, 153, 153);
        }
        .subBtn{
            border-radius: 4px;
            position: absolute;
            top: 30px;
            width: 101px;
            height: 36px;
            line-height:36px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            text-align:center;
            box-sizing:border-box;
            cursor:pointer;
        }
        .subBtn > img{
            vertical-align:text-bottom;
        }
        .confirm{
            background-color: rgb(42, 155, 207);
            color: rgb(255, 255, 255);
            right:115px;
        }
        .cancel{
            background-color: #fff;
            color: rgb(42, 155, 207);
            border:1px solid rgb(42, 155, 207);
            line-height:34px;
            right:0;
        }
        #commit{
            border:1px solid #f1f2f7;
            border-radius:5px;
        }
        .addTurnImgWrap{
            border-radius: 4px;
            background-color: rgb(42, 155, 207);
            top: 396px;
            width: 71px;
            height: 33px;
            text-align:center;
            line-height:33px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(255, 255, 255);
            margin:25px 0 0 30px;
            cursor:pointer;
        }
        .imgForm{
            padding-bottom:30px;
        }
        .noBorder{
            border:none;
        }
    </style>
</head>
<body style="background:#fff;">
<section>
    <input type="hidden" value="${carouselPosition.name}" id="positionId"/>
    <div class="contentWrap">
        <div class="titleWrap">
            <div class="title">
                轮播图编辑
            </div>
            <div class="turnImgPosition">
                轮播图位置：<span>${carouselPosition.name}</span>
            </div>

            <div class="subBtn confirm" id="submit"><img src="<%=request.getContextPath() %>/back/images/save.png"> 保存</div>
            <div class="subBtn cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"> 取消</div>
            <%--<div class="mt-20"  style="padding-left:18px;color:#F00" id="div_id"></div>--%>
            <div class="mt-20"  style="padding-left:18px;color:#F00" id="kuan" hidden>${carouselPosition.thumb1Width}</div>
            <div class="mt-20"  style="padding-left:18px;color:#F00" id="gao"  hidden>${carouselPosition.thumb1Height}</div>
        </div>
        <form id="commit" class="imgForm" action="<%=request.getContextPath()%>/turnimghome/updateMipCarouselList.do?PositionId=<%=request.getParameter("carouselPositionId")%>" method="post">
            <input type="hidden" class="" name="PositionId" value="<%=request.getParameter("carouselPositionId")%>">
            <div class="add">
                <c:forEach items="${mipCarousel}" var="cas" varStatus="status">
		            <div class="turnImgWrap" ondrop="drop(event,this)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event, this)">
                        <div class="img">
                            <span><img src="${cas.id}"></span>
                            <input type="hidden" name="pictureId" value="${cas.pictureid}">
                        </div>
                        <p class="lianjie">链接 : <input type="text" class="int-text" name="url" placeholder="请输入链接" value="${cas.url}"></p>
                        <button class="btn btn-danger-outline delAll noBorder"><i class="Hui-iconfont">&#xe6e2;</i></button>
	                </div>
		        </c:forEach>
                    <div class="turnImgWrap" style="display:none" id="addNewWrap" ondrop="drop(event,this)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event, this)">
                        <div class="img">
                            <span class="addimg"><img src = "<%=request.getContextPath()%>/back/images/moren.png"></span>
                            <input type="hidden" name="pictureId"/>
                        </div>
                        <p class="lianjie">链接：<input type="text" class="int-text" name="url" placeholder="请输入链接" ></p>
                        <c:if test="${carouselPosition.limit ne 1}" >
                            <button class="btn btn-danger-outline delAll noBorder"><i class="Hui-iconfont">&#xe6e2;</i></button>
                        </c:if>
                    </div>
            </div>


            <c:if test="${carouselPosition.limit ne 1}" >
	            <div class="addTurnImgWrap" id="addNew"><i class="Hui-iconfont">&#xe600;</i> 新增</div>
	        </c:if>
        </form>
        <form id="upload" style="display:none;">
	        <input id="file" type="file" name="file">
        </form>
    </div>
</section>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    //提交表单
	$(function(){
		$("#submit").click(function(){
			var data = $("#commit").serialize();
			if(data.length==0){
				layer.msg('[ERROR]至少得有一张图片', {icon: 2});
				return false;
			}else{
                //$("#commit").submit();
                $.ajax({
                	data:data,
                	url:"<%=request.getContextPath()%>/turnimghome/updateMipCarouselList.do",   
                	type:'post',  
                	success:function(data) {  
                		if (data == "ok") {
                			$.Huimodalalert('保存成功！',2000);  
                			setTimeout(function(){  
	                			window.location.href = "<%=request.getContextPath()%>/turnimggrid/getMipCarouselPositionList.do"; 
                			},2000); 
                		} else {
                			$.Huimodalalert('保存失败！',2000);  
                			window.location.href = "<%=request.getContextPath()%>/turnimggrid/getMipCarouselPositionList.do";  
                		}  
                	}
                })
            }
		});
	});

	 $(".close").click(function(){
	    	window.parent.location.reload(); //刷新父页面
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    	parent.layer.close(index);  // 关闭layer
	    });
    //取消
    $("#cancel").click(function(){
        layer.confirm('您确定要退出本页面吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                layer.closeAll();  //关闭弹出层
                window.location.href = "<%=request.getContextPath()%>/turnimggrid/getMipCarouselPositionList.do";  //跳转
            }, function(){
                layer.closeAll();  //关闭弹出层
        });
    });

	//根据mip_carousel_position表中limit字段判断可以上传几张图片
    //点击新增按钮
    var limitLength = "${carouselPosition.limit}";   //限制图片的张数
    var nowLength = "${carouselPosition.count}";     //图片现在有的张数

    //判断刚进来的时候有没有图片，有的话空白的隐藏，没有的话就显示出来
    function isLength(){
        if(nowLength == 0 ||nowLength < 0){
            $("#addNewWrap").css({"display":"block"});
            $(".delAll").attr({"disabled":"disabled"}).removeClass("btn-danger-outline").addClass("btn-default-outline");
            nowLength = 1;
        }else{
            $("#addNewWrap").css({"display":"none"});
        }
    }
    isLength();

    //判断图片是不是超过了限制的数量，超过的话新添按钮禁用
    function isForbid(){
        if((limitLength == 0)||(nowLength < limitLength)){
            $("#addNew").removeAttr("disabled").removeClass("btn-default").addClass("btn-danger");
        }else{
            $("#addNew").attr({"disabled":"disabled"}).removeClass("btn-danger").addClass("btn-default");
        }
    }
    isForbid();

    //添加新的轮播图
    $("#addNew").on("click",function(){
        $(".add").append('<div class="turnImgWrap" ondrop="drop(event,this)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event, this)"> ' +
                        '<div class="img">'+
                            '<span><img src="<%=request.getContextPath()%>/back/images/moren.png"></span>' +
                            '<input type="hidden" name="pictureId"/>'+
                        '</div>' +
                        '<p class="lianjie">链接：<input type="text" class="int-text" name="url" placeholder="请输入链接"></p>' +
                        '<button class="btn btn-danger-outline delAll noBorder" id="del"><i class="Hui-iconfont">&#xe6e2;</i></button>' +
                '</div>'
        );
        nowLength++;
        isForbid();
        $(".delAll").removeAttr("disabled").removeClass("btn-default-outline").addClass("btn-danger-outline");
    });

    //点击删除按钮
    $(".add").delegate("button","click",function(){
        $(this).parent(".turnImgWrap").remove();
        nowLength--;
        isForbid();
    });

    //进行拖拽
    function allowDrop(ev){
        ev.preventDefault();
    }

    var srcdiv = null;
    function drag(ev,divdom){
        srcdiv=divdom;
        ev.dataTransfer.setData("text/html",divdom.innerHTML);
    }

    function drop(ev,divdom){
        ev.preventDefault();
        if(srcdiv != divdom){
            srcdiv.innerHTML = divdom.innerHTML;
            divdom.innerHTML=ev.dataTransfer.getData("text/html");
        }
    }
    
    var that;
    $(".add").delegate(".img","click",function(){
    	that=$(this);
        layer.open({
            type: 2,
            title: '裁剪图片',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '730px'],
            content: '<%=request.getContextPath() %>/cropper/cropturnImg.html' //iframe的url
        });
    });

    //图片上传并回显
    $("#file").change(function(){
    	var formData = new FormData($("#upload")[0]);
    	$.ajax({
    		url : "<%=request.getContextPath() %>/file/uploadPicture.do?typeId=13&objectId=",
			type : "post",
			data :  formData,
			dataType:"json",
			async: false,  
          	cache: false,  
          	contentType: false,  
          	processData: false,	 
            success: function(data){
            	$(that).find("span").html("<img src="+data.url+">");
        		$(that).find("input").val(data.picId);//.attr("name","'+data.picId+'")
               layer.msg('[OK]上传成功', {icon: 1});
            }
        });
    });
//根据跳转页面不同，显示不同提示语句
<%--var positiong = $("#positionId").val();--%>
<%--if ( positiong == "首页")--%>
<%--{--%>
	<%--$("#div_id").html("上传的图片尺寸为${carouselPosition.thumb1Width}*${carouselPosition.thumb1Height}，大小控制在500k以内；为了保证显示效果，建议上传轮播图不超过10张。");--%>
<%--}--%>
<%--else if (positiong == "移动端首页")--%>
<%--{--%>
	<%--$("#div_id").html("上传的图片尺寸为${carouselPosition.thumb1Width}*${carouselPosition.thumb1Height}，大小控制在500k以内；为了保证显示效果，建议上传轮播图不超过6张。");--%>
<%--}--%>
<%--else--%>
<%--{--%>
	<%--$("#div_id").html("上传的图片尺寸为${carouselPosition.thumb1Width}*${carouselPosition.thumb1Height}，大小控制在500k以内，此处仅需上传一张图片。");--%>
<%--}--%>
</script>
</body>
</html>