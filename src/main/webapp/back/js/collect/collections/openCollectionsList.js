layui.use(['form','layer','table','laytpl','element'],function(){
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : top.layer,
			$ = layui.jquery,
			laytpl = layui.laytpl,
			table = layui.table;
	var element = layui.element;
	var imgStr="<img src='../shuiyin.png' class='shuiyin'>";
    $('#lightbox').append(imgStr);
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

	var applyDept = $("#applyDept").val();
	var status = $("#status").val();
	//用户列表
	
	var tableIns = table.render({
		elem: '#openCollectionsList',
		url : projectName + '/openCollection/dataList.do?collectionType=0', 
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
	         {field:'cpimg', title: '藏品图片', width:120, style:'height:118px;', align:'center',templet:"#cpimg"},
	         {field: 'name', title: '普查名称', align:'center',event:'show',style:'color:#01AAED;cursor:pointer'},
	         {field: 'gsNo', title: '普查编号', align:'center'},
	         {field: 'yearType', title: '年代', align:'center'},
	         {field: 'collectionsCategory', title: '类别', align:'center'},
	         {field: 'collectionLevel', title: '级别', align:'center',templet:function(d){
	        	 if(d.collectionLevel == "1"){
	        		 return "一级";
	        	 }else if(d.collectionLevel == "2"){
	        		 return "二级";
	        	 }else if(d.collectionLevel == "3"){
	        		 return "三级";
	        	 }else if(d.collectionLevel == "4"){
	        		 return "一般";
	        	 }else if(d.collectionLevel == "5"){
	        		 return "未定级";
	        	 }else {
	        		 return "未定级";
	        	 }
	         }},
	         {field:'collectionUnit',title: '收藏单位', align:'center'},
	         {title: '操作',toolbar:'#openCollectionsListTableBar',align:"center",width:250,style:'height:118px;',fixed:'right'}
	         ]],
         done:function(result){
        	 $("[data-field = 'cpimg']").children(".layui-table-cell").css({"height":"100%","max-width":"100%","position":"relative"});
         	$("[data-field = 'cpimg']").find("img").css({"max-width":"100%","max-height":"100%","position":"absolute","top":"50%","left":"50%","transform":"translate(-50%, -50%)"});
         }
	});
	var tabCount = 0;
	element.on('tab(layTab)', function(data){
		tabCount++;
		var tabIndex = data.index; //当前Tab的所在下标
		if (tabCount == 1) {
			getFossilTable();
		}
	});
	
	//批量移除
	$("#batchRemove").on("click",function(){
		var checkStatus = table.checkStatus("openCollectionsListTable");
   	  	var data = checkStatus.data;
   	  	var ids = new Array();
   	  	if(data.length>0){
   	  		for (var i = 0; i < data.length; i++) {
				var id = data[i].id;
				ids.push(id);
			}
   	  	}else{
   	  		layer.msg('请选择要操作的选项', {icon: 2});
   	  		return false;
   	  	}
		batchRemoveCollections(ids);
	})
	
	$("#batchRemove1").on("click",function(){
		var checkStatus = table.checkStatus("openCollectionsListTable");
   	  	var data = checkStatus.data;
   	  	var ids = new Array();
   	  	if(data.length>0){
   	  		for (var i = 0; i < data.length; i++) {
				var id = data[i].id;
				ids.push(id);
			}
   	  	}else{
   	  		layer.msg('请选择要操作的选项', {icon: 2});
   	  		return false;
   	  	}
		batchRemoveFossils(ids);
	})

	function getFossilTable() {
		tableIns1 = table.render({
			elem: '#openCollectionsFossilList',
			url : projectName + '/openCollection/dataList4Fossil.do?collectionType=1', 
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
				{field: 'collectionLevel', title: '级别', align:'center',templet:function(d){
					if(d.collectionLevel == "1"){
						return "一级";
					}else if(d.collectionLevel == "2"){
						return "二级";
					}else if(d.collectionLevel == "3"){
						return "三级";
					}else if(d.collectionLevel == "4"){
						return "一般";
					}else if(d.collectionLevel == "5"){
						return "未定级";
					}else {
						return "未定级";
					}
				}},
				{field:'collectionUnit',title: '收藏单位', align:'center'},
				{title: '操作',toolbar:'#openCollectionsFossilListTableBar',align:"center",width:250,style:'height:118px;',fixed:'right'}
			]],
			done:function(result){
				$("[data-field = 'cpimg']").children(".layui-table-cell").css({"height":"100%","max-width":"100%","position":"relative"});
	        	$("[data-field = 'cpimg']").find("img").css({"max-width":"100%","max-height":"100%","position":"absolute","top":"50%","left":"50%","transform":"translate(-50%, -50%)"});
			}
		});
	}
	//文物
	
	$(".search_btn").on("click",function(){
		table.reload("openCollectionsListTable",{
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				key:$("#key").val(),
				gsNo:$("#gsNo").val(),
				collectionsCategory:$("#collectionsCategory").val(),
				collectionUnit:$("#museum").val(),
				yearType:$("#yearType").val()
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
				key:$("#key1").val(),
				gsNo:$("#gsNo1").val(),
				collectionsCategory:$("#collectionsCategory1").val(),
				collectionUnit:$("#museum1").val(),
				yearType:$("#yearType1").val()
			}
		})
	});



	$("#resetBtn").on("click",function(){
		tableIns.reload();
	})
	$("#resetBtn1").on("click",function(){
		tableIns1.reload();
	})
	
	
	
	//从馆际公开库移除(化石)
	function removeCollectionsFossil(id){
		var url = "/openCollection/removeFossils.do";
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
            content : [projectName + '/collections/toShow.do?id=' + edit.id,'yes'],
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
    	
        var index = layui.layer.open({
            title : "查看化石",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/collectionsFossil/toShow.do?id=' + edit.id,'yes'],
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
        layui.layer.full(index);
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
        	showUser(data);
        }
        else if(layEvent === 'remove'){  //查看
        	removeCollections(data.id);
        }
    });
	
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
	
	
	function batchRemoveFossils(ids){
		var url = "/openCollection/batchRemoveFossils.do";
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
