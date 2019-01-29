<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>后台common</title>
<style>
	.list{
	    background: #B6DBDB;
	    position: absolute;
	    top:2.75rem;
	    display: none;
	}
	.list > li{
	    padding: 0 0.8rem 0 0.8rem;
	}
	.list > li a{
	    color:#fff;
	    font-size: 1rem;
	}
	.rotate{
	    animation:xuanzhuan 1s ease 0s;
	}
	.titlebg dl dt{
	    font-size:16px;
		color:#ffffff!important;
	}
	.titlebg{
		height:100%;
	}
	.titlebg dl dt:hover{
		background:#747474;
	}
	.titlebg{
		height:100%;
	}
	
	.titlebg dl dt i{
		color:#ffffff!important
	}
	.secondtitle{
		height: 96px !important;
		width: 100%;
		position: relative;
		padding: 26px 18px;
		box-sizing: border-box;
	}
	.secondtitle li{
		display: block;
		float: left;
		padding: 0 !important;
	}
	.secondtitle li a{
		color:#2a9bcf;
		font-size:14px !important;
		text-decoration: none;
		display: block;
		padding: 11px 24px;
		line-height: 18px;
		background-color: white;
		border: 1px solid #2a9bcf;
		border-radius: 5px;
		margin: 0 12px;
	}
	.rotate_currency{
	    animation:xuanzhuan1 1s ease 0s;
	}
	@keyframes xuanzhuan1 {
	    0%{transform:rotate(90deg)}
	    90%{transform:rotate(0deg)}
	    100%{transform:rotate(0deg)}
	}
	
    .current{
        background:#747474!important;
        color:#ffffff;
    }
    dl dt:hover{
        background:#747474!important;
        border-left:1px solid #dc1720;
    }


	
	.zj_menu_hearder{
		border-top-left-radius: 5px !important;
		border-bottom-left-radius: 5px !important;
		margin-bottom: 6px;
		overflow: hidden;
		background-color: white;
	}
	.thirdTitle img{
		
		display: block;
		float: left;
		width: 16px;
		height: 18px;
		margin-right: 6px;
	}
</style>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<!-- <header class="navbar-wrapper">
    <div id="nav_bar" class="navbar navbar-fixed-top" style="background: #268e6b">
        <div class="container-fluid cl">
            <i class="Hui-iconfont hidden-xs iconLogo" style="float: left;line-height: 2.8rem;color: #ffffff;font-size: 2.25rem;margin-left: 1.5rem">&#xe667;</i>
            <i class="Hui-iconfont visible-xs iconLogo" style="float: left;line-height: 2.8rem;color: #ffffff;font-size: 1.5rem;margin-left: 1.5rem">&#xe667;</i>
            <div class="logo navbar-logo f-l mr-10 hidden-xs" style="font-size: 1.5rem;line-height: 2.75rem;position: relative"><span class="titleLogo">内容管理子系统</span>
                <ul class="list logoList">
                    <li class="system_child"><a href="#">内容管理子系统</a></li>
                    <li class="system_child"><a href="#">藏品服务子系统</a></li>
                    <li class="system_child"><a href="#">公众号管理子系统</a></li>
                    <li class="system_child"><a href="#">数据统计子系统</a></li>
                    <li class="system_child"><a href="#">文物百科子系统</a></li>
                    <li class="system_child"><a href="#">用户管理子系统</a></li>
                </ul>
            </div>
            <div class="logo navbar-logo-m f-l mr-10 visible-xs"><span class="titleLogo">内容管理子系统</span>
                <ul class="list logoList">
                    <li class="system_child"><a href="#">内容管理子系统</a></li>
                    <li class="system_child"><a href="#">藏品服务子系统</a></li>
                    <li class="system_child"><a href="#">公众号管理子系统</a></li>
                    <li class="system_child"><a href="#">数据统计子系统</a></li>
                    <li class="system_child"><a href="#">文物百科子系统</a></li>
                    <li class="system_child"><a href="#">用户管理子系统</a></li>
                </ul>
            </div>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li style="line-height: 2.75rem" class="headimg">
                        <img src="images/heae-img.png" alt="头像加载失败" style="width:2.5rem;height:2.5rem;border-radius: 1.5rem">
                    </li>
                    <li style="text-align: center;width: 6.25rem;">
                        <div id="userName" class="user" style="height: 1.2rem;line-height: 1rem;padding-top: 0.4rem">陈立东</div>
                        <div class="user" style="height: 1.2rem;line-height: 1rem">超级管理员</div>
                    </li>
                    <li style="width: 1rem;height:2.75rem;line-height: 2.75rem;">
                        <div class="line" style="margin-top: 0.6rem;border-top: none;"></div>
                    </li>
                    <li style="height: 2.75rem;">
                        <i class="Hui-iconfont" style="line-height:2.75rem;color: #e66b6b;font-size: 2.25rem;margin-left: 1.5rem;margin-right: 2rem">&#xe726;</i>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header> -->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript">
    $(function(){
        $(".titleLogo").click(function(){
//            alert($("#logoList").css("display")=="none")
            if($(".logoList").css("display")=="none"){
                $(".logoList").slideDown(500);
                $(".iconLogo").removeClass("rotate_currency").addClass("rotate").css({transform:"rotate(90deg)"});
            }else {
                $(".logoList").slideUp(300);
                $(".iconLogo").removeClass("rotate").addClass("rotate_currency").css({transform:"rotate(0deg)"});
            }
        })
    })
</script>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<div class="zj_menu_hearder">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2 titlebg">
		
		<dl id="menu-article">
			<!--<dt style="font-size:18px!important;"><i class="Hui-iconfont">&#xe616;</i> 藏品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
			<dd style="display:block">
				<ul class="secondtitle">
					<li>
						<!--<a href="/mip/back/fCCollection/info.do" title="一普数据列表" style="font-size:16px!important;">一普数据列表</a>-->
						<ul class="thirdTitle">
							<li class="zj_public_wenwu">
								<a href="/admin/back/oCCollection/info.do" rel="/mip/back/oCCollection/info.do" title="文物藏品类别">
									<img src="<%=request.getContextPath() %>/back/images/zj_wenwu.png"/>
									文物表
								</a>
							</li>
							<li class="zj_public_haushi">
								<a href="/admin/back/oCFossil/info.do" rel="/mip/back/oCFossil/info.do" title="化石藏品类别">
									<img src="<%=request.getContextPath() %>/back/images/zj_huashi.png"/>
									标本化石
								</a>
							</li>
						</ul>
					</li>
					<li>
						<!--<a href="/mip/back/oCCollection/info.do" title="藏品数据列表" style="font-size:16px!important;">藏品数据列表</a>-->
						<ul class="thirdTitle">
							<li class="zj_public_yipuWenwu">
								<a href="/admin/back/fCCollection/info.do" rel="/mip/back/fCCollection/info.do" title="文物藏品类别">
									<img src="<%=request.getContextPath() %>/back/images/zj_yipu.png"/>
									一普文物（文物）
								</a>
							</li>
							<li class="zj_public_yipuhuashi">
								<a href="/admin/back/fCFossil/info.do" rel="/mip/back/fCFossil/info.do" title="化石藏品类别">
									<img src="<%=request.getContextPath() %>/back/images/zj_yipu.png"/>
									一普文物（标本化石）
								</a>
							</li>
						</ul>
					</li>
					<!-- <li><a href="javascript:void(0)" title="馆际交流授权">馆际交流授权</a></li>
					<li><a href="javascript:void(0)" title="馆际交流申请">馆际交流申请</a></li>
					<li><a href="javascript:void(0)" title="藏品变更审核">藏品变更审核</a></li> -->
				</ul>
			</dd>
		</dl>
	</div>
</div>
<div class="zj_menu_hr"></div>
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<!--/_menu 作为公共模版分离出去-->




    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
    <script type="text/javascript">
        var curUrl = window.location.href;
        var urlState = false;
        //    遍历a标签
        $(".secondtitle a").each(function(){
            if ((curUrl + '/').indexOf($(this).attr('rel')) > -1&&$(this).attr('rel')!='') {
                $(this).addClass('current');
                $(this).parents().css('display', 'block');
                urlState = true;
            } else {
                $(this).removeClass('current');
            }
            if (!urlState) {
                $(".menu_dropdown a").removeClass('current');
            }
        })
    </script>
<!--/请在上方写此页面业务相关的脚本-->

<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<!--/此乃百度统计代码，请自行删除-->
</body>
</html>