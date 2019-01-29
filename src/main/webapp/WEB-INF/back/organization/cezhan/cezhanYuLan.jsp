<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cezhanYuLan.min.css" />

		<title>策展预览</title>
	</head>
	<body>
		<div class="cezhanYuLan">
			<div style="margin-bottom: 36px !important;">
				<span class="zj_edit_title">策展预览</span>
				<div class="button_wrap zj_edit_btn">
					<a id="saveTabOne" onClick="release('${curation.status}','${curation.id}')">
						<img src="<%=request.getContextPath() %>/back/images/save.png"/>
						审核
					</a>
					<a href="javascript:history.go(-1);">
						<img src="<%=request.getContextPath() %>/back/images/cancel.png"/>
						取消
					</a>
				</div>
			</div>
			<div class="cezhanYuLan_title">
				<span style='float:none;'>${curation.title}</span>
				<p style='float:none;font-size:14px;width:100%;margin-top:15px;'>策展人：<span class="cezhanYuLan_title_author">${curation.userName}</span></p>
			</div>
			<div class="cezhanYuLan_content">
				<div class="cezhanYuLan_content_preface">
					<div class="cezhanYuLan_content_allTitle">
						<span>
							序
						</span>
					</div>
					<div class="">
						<textarea resize="none" readonly>${curation.description}</textarea>
					</div>
				</div>
				<div class="cezhanYuLan_content_chapter">
					<c:forEach items="${curation.curationChapterDtos}" var="spre" varStatus="status">
						<div class="cezhanYuLan_content_allTitle">
							<span>
								第<span name="number">${status.count}</span>章
							</span>
							<span>
								${spre.title}
							</span>
						</div>
						<div>
							<div class="zj_museumInfo_type">
								<div id="zj_museumInfo_slider">
									<div class="slider">
										<div class="bd" style="overflow: hidden;position: relative;height: 143px;">
											<ul class="museum_type" style="position: absolute;">
												<c:forEach items="${spre.collections}" var="spreC" varStatus="statusC">
													<li>
														<img src="${spreC.imgSrc}">
														<p title="${spreC.name}" style="overflow:hidden;text-overflow: ellipsis;white-space: nowrap;">${spreC.name}</p>
														<c:if test="${status.count==1&&statusC.count==1}">
															<span>封面</span>
														</c:if>
													</li>
												</c:forEach>
											</ul>
										</div>
										<span class="prev">
											<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_back.png" alt="" />
										</span>
										<span class="next">
											<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_next.png" alt="" />
										</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
			</div>
		</div>
		<div class="imgPanel">
			<img src="" alt="">
		</div>
	</body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript">
		$(document).ready(function() { 
			var currentDate = new Date().toLocaleDateString(); 
			$("span[name='number']").each(function() { 
				var a = $(this).text(); 
				$(this).text(NumberToChinese(a)); 
			}); 
		}); 
		var chnNumChar = ["零","一","二","三","四","五","六","七","八","九"];
		var chnUnitSection = ["","万","亿","万亿","亿亿"];
		var chnUnitChar = ["","十","百","千"];
		function NumberToChinese(num){
			var unitPos = 0;
			var strIns = '', chnStr = '';
			var needZero = false;
			if(num === 0){
			  return chnNumChar[0];
			}
			while(num > 0){
				var section = num % 10000;
				if(needZero){
					chnStr = chnNumChar[0] + chnStr;
				}
				strIns = SectionToChinese(section);
				strIns += (section !== 0) ? chnUnitSection[unitPos] : chnUnitSection[0];
				chnStr = strIns + chnStr;
				needZero = (section < 1000) && (section > 0);
				num = Math.floor(num / 10000);
				unitPos++;
			}
			return chnStr;
		}
		function SectionToChinese(section){
			var strIns = '', chnStr = '';
			var unitPos = 0;
			var zero = true;
			while(section > 0){
				var v = section % 10;
				if(v === 0){
					if(!zero){
						zero = true;
						chnStr = chnNumChar[v] + chnStr;
					}
				}else{
					zero = false;
					strIns = chnNumChar[v];
					strIns += chnUnitChar[unitPos];
					chnStr = strIns + chnStr;
				}
				unitPos++;
				section = Math.floor(section / 10);
			}
			return chnStr;
		}
	
		function release(publish, id) {
			layer.confirm('确定审核此信息？', {
				btn: ['确定', '再想想'] //按钮
			}, function() {
				$.ajax({
					url: "<%=request.getContextPath()%>/curation/updateStatus.do",
					type: "post",
					data: {
						id: id
					},
					async: false,
					dataType: "text",
					success: function(data) {
						if(data == "success") {
							layer.msg('审核成功', {
								icon: 1
							});
							setTimeout(function(){
		       					window.location.href = '<%=request.getContextPath()%>/curation/curation.do';
		       		        },2000);
						}
					},
					error: function() {
					alert("审核失败，请联系管理员");
					}
				})
			}, function() {
			layer.msg('已取消审核', {});
			});
		}
		$(function(){
			var left=true,right=false,dis=820;
			$(".museum_type").each(function(index,val,arr){
				$(this).width($(this).find("li").length*164);
				if($(this).find("li").length<=5){
					$(this).parents(".zj_museumInfo_type").find(".next,.prev").css("display","none");
				}
			})
			$(".next").on("click",function(){
				var ul=$(this).parent().find(".museum_type");
				var num=ul.find("li").length,
					dis=0;
				if(num<=5){
					$(".next,.prev").css("display","none");
				}
				if(5<num<=10){
					dis=820;
				}
				if(10<num){
					dis=1640;
				}
				if(!(parseInt(ul.css("left"))<=-dis) && !ul.is(":animated")){
		
					ul.animate({
							left:"-=820px"
						},200,function(){
					});
				}
			});
			$(".prev").on("click",function(){
		
				var ul=$(this).parent().find(".museum_type");
		
				if(!(parseInt(ul.css("left"))>=0) && !ul.is(":animated")){
					ul.animate({
						left:"+=820px"
					},200);
				}
			})
			$(".museum_type").on("click","img",function(e){
				$(".imgPanel").css("display","block").find("img").attr("src",$(this)[0].src);
			});
			$(".imgPanel").click(function(){$(this).css("display","none")});
		});
	</script>
</html>
