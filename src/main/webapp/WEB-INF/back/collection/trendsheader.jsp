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
        background:#2a9bcf!important;
        color:#ffffff !important;
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
<!--_menu 作为公共模版分离出去-->
<div class="zj_menu_hearder">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2 titlebg">
		<dl id="menu-article">
			<dd style="display:block">
				<ul class="secondtitle">
					<li>
						<ul class="thirdTitle">
						    <li class="zj_public_cangping">
								<a href="/admin/back/oCCollection/info.do?type=1" rel="/admin/back/oCCollection/info.do?type=1" title="藏品变动列表">
									藏品审核
								</a>
							</li>
							<li class="zj_public_wenwu">
								<a href="/admin/trendsManage/statisticsInfo.do" rel="/admin/trendsManage/statisticsInfo.do" title="文物藏品类别">
									藏品动态统计
								</a>
							</li>
							<li class="zj_public_haushi">
								<a href="/admin/trendsManage/info.do" rel="/admin/trendsManage/info.do" title="藏品变动列表">
									藏品变动列表
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</dd>
		</dl>
	</div>
</div>
<div class="zj_menu_hr"></div>
    <script type="text/javascript">
        var curUrl = window.location.href;
        var urlState = false;
        //    遍历a标签
        $(".secondtitle a").each(function(){
            if ((curUrl + '/').indexOf($(this).attr('rel')) > -1&&$(this).attr('rel')!='') {
                $(this).addClass('current');
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
</body>
</html>