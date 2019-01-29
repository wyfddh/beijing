<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <style>
        .asidemanage{
            background:#4b4b4b;
        }
        aside .menu_dropdown{
            background:#4b4b4b;
        }
        #menu-article dt{
            background:#4b4b4b;
        }
        #menu-article dt:hover{
            background:#747474;
        }
        #menu-article dd ul li:hover{
            background:#747474;
        }
        #menu-article dd ul li a:hover{
            background:#747474;
        }
        .secondTitle li a:hover{
            background:#747474!important;
            color:#ffffff;
        }
        .current{
            background:#747474!important;
            color:#ffffff;
        }
        dl dt:hover{
            background:#747474!important;
            border-left:1px solid #dc1720;
        }
        /*       a{
        display:block;
        width:100%;
        } */
    </style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--<input runat="server" id="divScrollValue" type="hidden" value="" />-->
<aside class="Hui-aside asidemanage">
    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <dt class="listColor">组织机构管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
            <dd>
                <ul>
                <c:if test="${level lt 3 }">
                    <li><a href="<%=request.getContextPath()%>/organization/relic/info.do" rel="" title="文物局" class="listColor">文物局</a></li>
                 </c:if>   
                    <li><a href="<%=request.getContextPath()%>/organization/museum/info.do" title="博物馆" class="listColor">博物馆</a></li>
                    <!-- <li><a href="#" title="意见反馈" class="listColor">用户策展审核</a></li> -->
                </ul>
            </dd>
        </dl>
        <dl id="menu-picture">
            <dt class="listColor">权限管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
            <dd>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/admin/user/adminList.do" title="管理员账号管理" class="listColor">管理员账号管理</a></li>
                    <li><a href="<%=request.getContextPath()%>/role/info.do" title="角色管理" class="listColor">角色管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-system">
            <dt class="listColor">系统设置<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
            <dd>
                <ul>
        <%--
                	<li><a href="<%=request.getContextPath()%>/collectionTransfer/getOrganization.do" title="博物馆转移藏品" class="listColor">博物馆转移藏品</a></li>
        --%>
                    <li><a href="<%=request.getContextPath()%>/back/pictureSearch/index.do" title="以图搜图设置" class="listColor">以图搜图设置</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
<script type="text/javascript">
    var curUrl = window.location.href;
    var urlState = false;
//    遍历a标签
    $(".menu_dropdown a").each(function(){
        if ((curUrl + '/').indexOf($(this).attr('href')) > -1&&$(this).attr('href')!='') {
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
</body>
</html>