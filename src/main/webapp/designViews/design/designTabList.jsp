<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线设计表单</title>
<script type="text/javascript" src="designPlug-in/tools/curdtools.js"></script>
<t:base type="jquery,easyui,tools,layer"></t:base>
</head>
<body class="easyui-layout"  style="overflow-y: auto;" >
<div region="center" style="padding: 1px;">
<div style="float: left;"><a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="add_1('添加页签','designController.do?addTab&defineCode=${defineCode}&formId=${formId}')">添加页签</a>
</div> 
<form formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="designController.do?save">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<thead class="datagrid-header">
					<tr class="datagrid-header-row">
						<th>操作</th>
						<th>页签编码</th>
						<th>页签名称</th>
						<th>关联业务编码</th>
						<th>关联主表字段</th>
						<th>明细表字段</th>
						<th>图标样式</th>
						<th>显示顺序</th>
					</tr>
				</thead>
				<tbody class="datagrid-body">
					<c:if test="${not empty designTabList }">
						<c:forEach items="${designTabList }" var="map" varStatus="status">
							<tr>
							<td>[<a href="#" class="myclass" onclick="add_1('编辑按钮','designController.do?addTab&formId=${formId}&id=${map.id }')" > 编辑 </a>]
							[<a href="#" class="myclass" onclick="designList('${map.linkBussCode }')" > 设计列表 </a>]
							[<a href="#" class="myclass" onclick="del_1('designController.do?delTab&id=${map.id }')"  > 删除 </a>] </td>
								<td>${map.tabCode } </td>
								<td>${map.tabName } </td>
								<td>${map.linkBussCode } </td>
								<td>${map.mainField } </td>
								<td>${map.detailField } </td>
								<td>${map.tabIcon } </td>
								<td>${map.orderNum } </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<c:if test="${empty designTabList }">
				<table
					style="background: #f5f9fa; width: 100%; height: 35px; margin-bottom: 3px; border: 1px solid #DDDDDD;">
					<tbody>
						<tr>
							<td align="center" style="width: 100%;">暂无数据</td>
						</tr>
					</tbody>
				</table>
			</c:if>
	</form>
</div>

</body>
</html>
<script type="text/javascript">



function designList(linkBussCode) {
    if (linkBussCode == "" || linkBussCode == null) {
        parent.layer.msg("请先关联业务编码", {
            icon: 5
        });
        return false;
    }
    parent.layer.open({
        type: 2,
        title: "设计列表",
        shadeClose: false, // 开启遮罩关闭
        area: ["90%", "90%"], // 宽高
        content: "designController.do?mconfigure&bussCode=" + linkBussCode + "&versionNum=-1",
        btn: ['保存', '关闭'],
        yes: function(index, layero) {
            var form1 = parent.layer.getChildFrame("form", index);
            $.ajax({
                type: "POST",
                url: $(form1).attr("action"),
                data: $(form1).serialize(),
                success: function(data) {
                    parent.layer.close(index); // 如果设定了yes回调，需进行手工关闭
                    parent.layer.msg('操作成功！', {
                        icon: 1
                    });
                },
                error: function(data) {
                    parent.layer.msg("error:" + data.responseText, {
                        icon: 5
                    });
                }
            });
        },
        cancel: function() {}
    });
}


function del_1(url) {

myConfirmDialog("您确定要删除吗？", function(dindex){
        $.ajax({
        	async : false,
            type: "POST",
            url: url,
            success: function(data) {
            	tip(data.msg);
            	 window.location.reload();
            },
            error: function(data) {
                tip(data.responseText);
            }
        });
        layer.close(dindex);
}, function(){
		return true;
	},"");
}


function add_1(title,contentUrl) {
	layer.open({
        type: 2,
        title: title,
        shadeClose: false, // 开启遮罩关闭
        area: ["50%", "90%"], // 宽高
        content: contentUrl,
        btn: ['保存', '关闭'],
        yes: function(index, layero) {
            var form1 = layer.getChildFrame("form", index);
            $.ajax({
                type: "POST",
                url: $(form1).attr("action"),
                data: $(form1).serialize(),
                success: function(data) {
                	layer.close(index); // 如果设定了yes回调，需进行手工关闭
                	layer.msg('操作成功！', {
                        icon: 1
                    });
                    window.location.reload();
                },
                error: function(data) {
                    layer.msg("error:" + data.responseText, {
                        icon: 5
                    });
                }
            });
        },
        cancel: function() { window.location.reload();}
    });
}




</script>
