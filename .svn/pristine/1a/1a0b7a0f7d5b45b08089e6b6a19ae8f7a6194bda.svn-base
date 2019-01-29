
var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
layui.use(['form','layer','table','laytpl','element'],function(){
	var form = layui.form,
	//layer = layui.layer;
	layer = parent.layer === undefined ? layui.layer : top.layer,
			$ = layui.jquery,
			laytpl = layui.laytpl,
			table = layui.table;
	var element = layui.element;
	var imgStr="<img src='../shuiyin.png' class='shuiyin'>";
    $('#lightbox').append(imgStr);
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

	//用户列表
	var tableIns = table.render({
		elem: '#openCollectionsList',
		url : projectName + '/openCollection/getPublicOpenList.do', 
		request:{
			pageName: 'currentPage',
			limitName: 'size'
		},
		where:{
			
		},
		cellMinWidth : 95,
		page : true,
		limits : [10,15,20,25],
		limit : 10,
		id : "openCollectionsListTable",
		cols : [[
	         {type:"checkbox", width:30, align:"center"},
	         {type:"numbers",title: '序号', width:60, align:"center"},
	         {field:'applyDept', title: '申请单位', width:120, style:'height:118px;', align:'center',},
	         {field: 'applyCollectCount', title: '申请公开藏品数', align:'center'},
	         {field: 'applyTimeStr', title: '申请时间', align:'center'},
	         {field: 'status', title: '状态', align:'center',templet:function(res){
	        	 if(res.status == 1){
	        		 return "待审核";
	        	 }else if(res.status == 2){
	        		 return "审核通过";
	        	 }else if(res.status == 3){
	        		 return "审核不通过";
	        	 }else{
	        		 return res.status;
	        	 }
	         }},
	         {title: '操作',toolbar:'#openCollectionsListTableBar',align:"center",width:250,style:'height:118px;',fixed:'right'}
	         ]],
         done:function(result){
//        	 $("[data-field = 'cpimg']").children(".layui-table-cell").css({"height":"100%","max-width":"100%","position":"relative"});
//         	$("[data-field = 'cpimg']").find("img").css({"max-width":"100%","max-height":"100%","position":"absolute","top":"50%","left":"50%","transform":"translate(-50%, -50%)"});
         }
	});
	
	var level = "${level}";
	if(!(level == 1 || level == 2)){
		getFossilTable();
	}
	
	var tabCount = 0;
	element.on('tab(layTab)', function(data){
		tabCount++;
		var tabIndex = data.index; //当前Tab的所在下标
		if (tabCount == 1) {
			getFossilTable();
		}
	});
	
	//批量移除
//	$("#batchRemove").on("click",function(){
//		var checkStatus = table.checkStatus("openCollectionsListTable");
//   	  	var data = checkStatus.data;
//   	  	var ids = new Array();
//   	  	if(data.length>0){
//   	  		for (var i = 0; i < data.length; i++) {
//				var id = data[i].id;
//				ids.push(id);
//			}
//   	  	batchRemoveCollections(ids);
//   	  	}else{
//   	  		layer.msg('请选择要操作的选项', {icon: 2});
//   	  		return false;
//   	  	}
//		
//	})
	
	

	function getFossilTable() {
		tableIns1 = table.render({
			elem: '#openCollectionsFossilList',
			url : projectName + '/openCollection/getOpenColectionList.do', 
			request:{
				pageName: 'currentPage',
				limitName: 'size'
			},
			where:{
				
			},
			cellMinWidth : 95,
			page : true,
			limits : [10,15,20,25],
			limit : 10,
			id : "openCollectionsFossilListTable",
			cols : [[
				{type:"checkbox", width:30, align:"center"},
				{type:"numbers",title: '序号', width:60, align:"center"},
				{field:'cpimg', title: '藏品图片', width:120, style:'height:118px;', align:'center',templet:"#cpimg1"},
				{field: 'name', title: '普查名称', align:'center',event:'show',style:'color:#01AAED;cursor:pointer'},
				{field: 'gsNo', title: '普查编号', align:'center'},
				{field: 'yearType', title: '年代', align:'center'},
				{field: 'collectionsCategory', title: '类别', align:'center'},
				{field: 'collectionLevel', title: '级别', align:'center'},
				{field:'collectionUnit',title: '收藏单位', align:'center'},
				{title: '操作',toolbar:'#openCollectionsFossilListTableBar',align:"center",width:250,style:'height:118px;',fixed:'right'}
			]],
			done:function(result){
				$("[data-field = 'cpimg']").children(".layui-table-cell").css({"height":"100%","max-width":"100%","position":"relative"});
	        	$("[data-field = 'cpimg']").find("img").css({"max-width":"100%","max-height":"100%","position":"absolute","top":"50%","left":"50%","transform":"translate(-50%, -50%)"});
			}
		});
	}
	
	$("#batchRemove").click(function(){
		var checkStatus = table.checkStatus("openCollectionsFossilListTable");
  	  var data = checkStatus.data;
  	  var newData = new Array();
  	  var count = 0;
  	  var level = $("#level").val();
  	  var orgId = $("#orgId").val();
  	  if(data != null && data.length>0){
  		  for(var i=0;i<data.length;i++){
  			  if(level == 1 || level == 2){
  				newData.push(data[i].id);
  			  }else{
  				if(data[i].collectionUnit == orgId){
  	  				newData.push(data[i].id);
  	  			  }else{
  	  				  count++;
  	  			  }
  			  } 
  		  }
  		  if(count>0){
  				if(newData.length>0){
  				  layer.msg('操作成功,已自动剔除无效选项', {icon: 1});   				  
  			  }else{
  				  layer.msg('操作失败,所选项均为无效选项', {icon: 2});  
  				  return false;
  			  }
  		  }
  		var url = "/openCollection/batchRemove4OpenCollection.do";
		$.ajax({
			url :projectName + url,
			type : "get",
			data :  {"ids":newData},
			traditional: true,
			dataType : "json",
			success : function(data){
//				top.layer.close(indexpub);
				console.log(data);
				if(data == "1"){
					layer.msg('移除成功', {icon: 1});
					tableIns1.reload();
				
				}
				else{
					layer.msg('移除失败', {icon: 2});
				}
			},
		})
  	  }else{ 		  
  		  layer.msg('请选择要操作的选项', {icon: 2});
  	  }
  	  return false;
	})
	//文物
	$(".search_btn").on("click",function(){
		table.reload("openCollectionsListTable",{
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				applyDept:$("#applyDept").val(),
				status:$("#status").val()
			}
		})
	});
	//化石
	$(".search_btn1").on("click",function(){
		table.reload("openCollectionsFossilListTable",{
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				applyDept:$("#applyDept1").val(),
			}
		})
	});



	$("#resetBtn").on("click",function(){
		tableIns.reload();
	})
	$("#resetBtn1").on("click",function(){
		tableIns1.reload();
	})
	
	$("#batchApproval").click(function(){
		var checkStatus = table.checkStatus("openCollectionsListTable");
  	  var data = checkStatus.data;
  	  var newData = new Array();
  	  var count = 0;
	  if(data != null && data.length>0){
		  for(var i=0;i<data.length;i++){
			  var status =  data[i].status;
			  if(status == 1){
				  newData.push(data[i].id);
			  }else{
				  count++;
			  }
		  }
		  if(count > 0){
			  if(newData.length>0){
				  layer.msg('操作成功,已自动剔除无效选项', {icon: 1});  
			  }else{
				  layer.msg('操作失败,所选项均为无效选项', {icon: 2});  
			  }
		  }else{
			  var id = newData.join(",");
			  layer.open({	
				title:"审核",
				  type: 2, 
				  area: ['450px', '218px'],
				  content: [projectName+'/openCollection/getConfirm.do?ids='+id]
			  	  ,end:function(){
			  		tableIns.reload();
			  	  }
				});
		  }
	  }else{
		  
		  layer.msg('请选择要操作的选项', {icon: 2});
	  }
	})
	
	
	
	
	
	//从馆际公开库移除(化石)
	function removeCollectionsFossil(id){
		var url = "/openCollection/remove4OpenCollection.do";
		$.ajax({
			url :projectName + url,
			type : "get",
			data :  {"id":id},
			traditional: true,
			dataType : "json",
			success : function(data){
//				top.layer.close(indexpub);
				console.log(data);
				if(data == "1"){
					layer.msg('移除成功', {icon: 1});
					tableIns1.reload();
				}
				else{
					layer.msg('移除失败', {icon: 2});
				}
			},
		})
	}
	
	//查看
    function showUser(edit){
    	
        var index = layui.layer.open({
            title : "查看藏品",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '//openCollection/toShowStatic.do?id=' + edit.id,'yes'],
            success : function(layero, index){
            	resizeLayer(index);
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                	
//                	body.find("#editOrg option[value='"+edit.orgId+"']").attr("selected",true);
                	
                	
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回藏品列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            },
            end :function() {
            	tableIns.reload();
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
	
	//查看1
    function showUser1(edit){
    	
        var index = layer.open({
            title : "查看公开藏品",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/openCollection/toShowStatic.do?id=' + edit.id,'yes'],
            success : function(layero, index){
            	resizeLayer(index);
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                	
//                	body.find("#editOrg option[value='"+edit.orgId+"']").attr("selected",true);
                	
                	
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回化石列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            },
            end :function() {
            	tableIns1.reload();
            }
        })
        layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
	
	
	
	table.on('tool(openCollectionsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'show'){  //查看
        	showCollections(data.id);
        }
        else if(layEvent === 'approval'){  //查看
        	setAuthSetting(data.id);
        }
        else if(layEvent === 'remove'){  //查看
        	removeCollections(data.id);
        }
    });
	  
	    function showCollections(id){		
			layer.open({
					
					title:"查看",
				  type: 2, 
				  area: ['1000px', '600px'],
				  content: [projectName+'/openCollection/getCollectionDetail.do?id='+id]
				});
		}
	    function setAuthSetting(id){
		
		layer.open({
		
			title:"审核",
			  type: 2, 
			  area: ['450px', '218px'],
			  content: [projectName+'/openCollection/getConfirm.do?ids='+id]
		,end:function(){
	  		tableIns.reload();
	  	  }
			});
	}
	
	table.on('tool(openCollectionsFossilList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'show'){  //查看
        	showUser1(data);
        }else if(layEvent === 'remove'){  //查看
//        	showUser(data);
        	removeCollectionsFossil(data.id);
        }
    });

	

	form.on('select(commonYearId)',function(data) {
		var opt = data.value;
		if(opt != ""){
			$("#yearType").val(opt);
			$("#orhterYearId").val("");
			$("#commonYearId").attr("name","yearType")
			$("#orhterYearId").attr("name","yearType2")
		}
		form.render();
	});
	form.on('select(orhterYearId)',function(data) {
		var opt = data.value;
		if(opt != ""){
			$("#yearType").val(opt);
			$("#commonYearId").val("");
			$("#commonYearId").attr("name","yearType2")
			$("#orhterYearId").attr("name","yearType")
		}
		form.render();
	});
	
	form.on('select(commonYearId1)',function(data) {
		var opt = data.value;
		if(opt != ""){
			$("#yearType1").val(opt);
			$("#orhterYearId1").val("");
			$("#commonYearId1").attr("name","yearType")
			$("#orhterYearId1").attr("name","yearType2")
		}
		form.render();
	});
	form.on('select(orhterYearId1)',function(data) {
		var opt = data.value;
		if(opt != ""){
			$("#yearType1").val(opt);
			$("#commonYearId1").val("");
			$("#commonYearId1").attr("name","yearType2")
			$("#orhterYearId1").attr("name","yearType")
		}
		form.render();
	});
	//从馆际公开库移除(藏品)
	function removeCollections(id){
		var url = "/openCollection/removeCollections.do";
		$.ajax({
			url :projectName + url,
			type : "get",
			data :  {"id":id},
			traditional: true,
			dataType : "json",
			success : function(data){
//				top.layer.close(indexpub);
				console.log(data);
				if(data == "1"){
					layer.msg('移除成功', {icon: 1});
					tableIns.reload();
				}
				else{
					layer.msg('移除失败', {icon: 2});
				}
			},
		})
	}
	
	function batchRemoveCollections(ids){
		var url = "/openCollection/batchRemoveCollections.do";
		$.ajax({
			url :projectName + url,
			type : "get",
			data :  {"ids":ids},
			traditional: true,
			dataType : "json",
			success : function(data){
//				top.layer.close(indexpub);
				console.log(data);
				if(data == "1"){
					layer.msg('移除成功', {icon: 1});
					tableIns.reload();
				}
				else{
					layer.msg('移除失败', {icon: 2});
				}
			},
		})
	}
	
})

function checkAuth(orgId,currentId){
	if(orgId == currentId){
		return false;
	}else{
		return true;
	}
	
}

function setAuthSetting(id){
    layer.confirm('', {
        title:"设置确认",
        area: ['450px', '218px'],
        skin: 'demo-class',
        success: function(layero, index){
            console.log($('.demo-class').length);
            form1.render();
        },
        content:"<form class='layui-form' id='batchSetForm'>"
        + "<div class='layui-form-item'>"
        + "<div class='layui-input-block' style='margin-left: 0px' id='batchSetting'>"
        + "<input type='radio' name='setting' value='1' title='不公开' checked>"
        + "<input type='radio' name='setting' value='2' title='公开可查询'>"
        + "<input type='radio' name='setting' value='3' title='公开可下载'>"
        + "</div>"
        + "</div>"
        + "</form>",            btn: ['取消', '确认']
    }, function(index, layero){
        layer.close(index);
    }, function(index){
        var authSetting = $('#batchSetting input[name="setting"]:checked ').val()
        var data = {id:id,authSetting:authSetting};
        $.ajax({
            url:property.getProjectPath() + 'PostVideo/setAuthSetting.do',
            type:'post',
            data:data,
            success:function(result) {
                if (result.success == "1") {
                    successMsg("权限设置成功！");
                    loadTable();
                } else if (result.success == 0){
                    var resultMsg = result.error.message;
                    errorMsg(resultMsg);
                }
                loadTable();
                layer.close(index);
            }
        })
    });
    return false;
}
