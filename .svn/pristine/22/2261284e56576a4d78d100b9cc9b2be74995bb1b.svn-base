<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>山东后台导入页面</title>
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
    color:#008582;
    font-size: 1rem;
}
.list > li:hover{
    background:#008582;
}
.list > li:hover a{
    color:#B6DBDB;
    text-decoration: none;
}
.rotate{
    animation:xuanzhuan 1s ease 0s;
}
/*aside的样式*/
aside{
background:#72cdae!important;
}
.titlebg dl dt{
background:#72cdae;
color:#ffffff!important}
.titlebg{
height:100%;
background:#72cdae;
}
.titlebg dl dt:hover{background:#16b57f;}
.titlebg{height:100%;background:#72cdae;}

.titlebg dl dt i{
color:#ffffff!important
}
.secondtitle li a{
color:#ffffff!important;
font-size:0.8rem!important;}
.secondtitle li a:hover{
background:#16b57f!important;
}
.thirdTitle li a{
font-size:0.6rem!important;
padding-left:2rem!important;}
@keyframes xuanzhuan {
    0%{transform:rotate(0deg)}
    90%{transform:rotate(90deg)}
    100%{transform:rotate(90deg)}
}
.rotate_currency{
    animation:xuanzhuan1 1s ease 0s;
}
@keyframes xuanzhuan1 {
    0%{transform:rotate(90deg)}
    90%{transform:rotate(0deg)}
    100%{transform:rotate(0deg)}
}
</style>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<header class="navbar-wrapper">
    <div id="nav_bar" class="navbar navbar-fixed-top" >
        <div class="container-fluid cl" style="background: #268e6b">
            <i class="Hui-iconfont hidden-xs iconLogo" style="float: left;line-height: 2.8rem;color: #ffffff;font-size: 2.25rem;margin-left: 1.5rem">&#xe667;</i>
            <i class="Hui-iconfont visible-xs iconLogo" style="float: left;line-height: 2.8rem;color: #ffffff;font-size: 1.5rem;margin-left: 1.5rem">&#xe667;</i>
            <div class="logo navbar-logo f-l mr-10 hidden-xs" style="font-size: 1.5rem;line-height: 2.75rem;position: relative"><span class="titleLogo">藏品管理子系统</span>
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
                        <img src="<%=request.getContextPath() %>/back/images/heae-img.png" alt="头像加载失败" style="width:2.5rem;height:2.5rem;border-radius: 1.5rem">
                    </li>
                    <li style="text-align: center;width: 6.25rem;">
                        <div id="userName" class="user" style="height: 1.2rem;line-height: 1rem;padding-top: 0.4rem">超管</div>
                        <div class="user" style="height: 1.2rem;line-height: 1rem">超级管理员</div>
                    </li>
                    <li style="width: 1rem;height:4.375rem;line-height: 2.75rem;">
                        <div class="line" style="margin-top: 0.6rem;border-top: none;"></div>
                    </li>
                    <li>
                        <i class="Hui-iconfont" style="line-height: 2.75rem;color: #e66b6b;font-size: 2.25rem;margin-left: 1.5rem;margin-right: 2rem">&#xe726;</i>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<!--/_header 作为公共模版分离出去-->

<!--/请在上方写此页面业务相关的脚本-->

<!--此乃百度统计代码，请自行删除-->
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".titleLogo").click(function(){
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
<!--/此乃百度统计代码，请自行删除-->
</body>
</html>