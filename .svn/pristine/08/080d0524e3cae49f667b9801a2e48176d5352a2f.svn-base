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
    
    //用户列表
    var tableIns = table.render({
        elem: '#collectionsList',
        url : projectName + '/collections/dataListStatic.do', 
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
        id : "collectionsListTable",
        cols : [[
//            {type:"numbers",title: '序号', width:30, align:"center"},
            {type:"checkbox", width:30, align:"center"},
//            {field: 'gsNo', title: '一普编号', align:'left'},   
            {field:'cpimg', title: '藏品图片',width:120, style:'height:118px;', align:'left',templet:"#cpimg"},
            {field: 'name', title: '藏品名称', align:'left',event:'show',style:'color:#01AAED;cursor:pointer'},
            {field: 'collectionsCategory', title: '类别', align:'left'},
            {field: 'collectionLevel', title: '级别', align:'left',templet:function(d){
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
            {field: 'yearType', title: '年代', align:'left'},
            {field: 'gsTexture', title: '质地', align:'left'},
//            {field: 'gjOpen', title: '馆际公开状态',  align:"center",unresize:true,templet:function(d){
//            	if(d.gjOpen == "1"){
//            		return "未公开"
//            	}else if(d.gjOpen == "2"){
//            		return "已公开";
//            	}else{
//            		return d.gjOpen;
//            	}
//            }},
//            {field: 'isOpen', title: '公众公开状态',  align:"center",unresize:true,templet:function(d){
//            	if(d.isOpen == "1"){
//            		return "未公开"
//            	}else if(d.isOpen == "2"){
//            		return "已公开";
//            	}else if(d.isOpen == "3"){
//            		return "待审核";
//            	}else{
//            		return d.isOpen;
//            	}
//            }},
            {field:'collectionUnit',title: '收藏单位', align:'left'},
//            {field: 'formerly', title: '藏品原名', align:'center',minWidth:100},
//            {title: '讲解词', align:'center',minWidth:100,templet:"#description"},
//            {title: '二维码', align:'center',width:70,templet:"#qrcode"},
//            {field: 'gsCollectionsNo', title: '藏品编号', align:'center',width:100},
//            {field: 'mass', title: '质量', align:'center',minWidth:50},
//            {field: 'gsEntryWarehouseYear', title: '入藏年度', align:'center',width:100},
//            {field: 'gsStorageState', title: '保存状态', align:'center',width:100},
//            {field: 'gsSource', title: '文物来源', align:'center',minWidth:50},  
//            {title: '操作', toolbar:'#collectionsListBar',align:"center",width:250,fixed:'right',style:'height:118px;'}
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
    
    function getFossilTable() {
    	tableIns1 = table.render({
            elem: '#collectionsFossilList',
            url : projectName + '/collectionsFossil/dataListStatic.do', 
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
            id : "collectionsFossilListTable",
            cols : [[
//                {type:"numbers",title: '序号', width:30, align:"center"},
            	{type:"checkbox", width:30, align:"center"},
//                {field: 'gsNo', title: '一普编号', align:'left'},
                {field:'cpimg', title: '藏品图片',width:120, style:'height:118px;', align:'left',templet:"#cpimg1"},
                {field: 'name', title: '藏品名称', align:'left',event:'show',style:'color:#01AAED;cursor:pointer'
                },
                {field: 'collectionsCategory', title: '类别', align:'left'},
                {field: 'collectionLevel', title: '级别', align:'left',templet:function(d){
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
                {field: 'yearType', title: '年代', align:'left'},
//                {field: 'gjOpen', title: '馆际公开状态',  align:"center",unresize:true,templet:function(d){
//                	if(d.gjOpen == "1"){
//                		return "未公开"
//                	}else if(d.gjOpen == "2"){
//                		return "已公开";
//                	}else{
//                		return d.gjOpen;
//                	}
//                }},
//                {field: 'isOpen', title: '公众公开状态',  align:"center",unresize:true,templet:function(d){
//                	if(d.isOpen == "1"){
//                		return "未公开"
//                	}else if(d.isOpen == "2"){
//                		return "已公开";
//                	}else if(d.isOpen == "3"){
//                		return "待审核";
//                	}else{
//                		return d.isOpen;
//                	}
//                }},
                {field:'collectionUnit',title: '收藏单位', align:'left'},
               
//                {title: '操作',toolbar:'#collectionsFossilListBar',align:"center",width:250,style:'height:118px;',fixed:'right'}
            ]],
            done:function(result){
            	$("[data-field = 'cpimg']").children(".layui-table-cell").css({"height":"100%","max-width":"100%","position":"relative"});
            	$("[data-field = 'cpimg']").find("img").css({"max-width":"100%","max-height":"100%","position":"absolute","top":"50%","left":"50%","transform":"translate(-50%, -50%)"});
            }
        });
    }
    //化石
    $(".search_btn1").on("click",function(){
    	var isHighQualityVal = $("#isHighQuality").val();
    	if (isHighQualityVal == "") {
    		isHighQualityVal = 0;
    	}
    	var isOpenVal = $("#isOpen1").val();
    	if (isOpenVal == "") {
    		isOpenVal = 0;
    	}
        table.reload("collectionsFossilListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
            	
            	key:$("#key1").val(),
            	yearTypeEon:$("#yearTypeEon").val(),
            	yearTypeEra:$("#yearTypeEra").val(),
            	yearTypeEpoch:$("#yearTypeEpoch").val(),
            	collectionsCategory:$("#collectionsCategory1").val(),
            	collectionUnit:$("#museum1").val(),
            	isHighQuality:isHighQualityVal,
            	isOpen:isOpenVal
            }
        })
    });
    //文物
    $(".search_btn").on("click",function(){
    	var isOpenVal = $("#isOpen").val();
    	if (isOpenVal == "") {
    		isOpenVal = 0;
    	}
    	var gjOpenVal = $("#gjOpen").val();
    	if (gjOpenVal == "") {
    		gjOpenVal = 0;
    	}
        table.reload("collectionsListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
            	key:$("#key").val(),
            	yearType:$("#yearType").val(),
            	gsTexture:$("#gsTexture").val(),
            	collectionsCategory:$("#collectionsCategory").val(),
            	gsSource:$("#gsSource").val(),
            	collectionLevel:$("#collectionLevel").val(),
            	gsEntryWarehouseTimeFrame:$("#gsEntryWarehouseTimeFrame").val(),
            	collectionUnit:$("#museum").val(),
            	isOpen:isOpenVal,
            	gjOpen:gjOpenVal
            }
        })
    });
    
    
    
    $("#resetBtn").on("click",function(){
    	tableIns.reload();
    })
    $("#resetBtn1").on("click",function(){
    	$("#yearTypeEra option[value!='']").remove(); 
    	$("#yearTypeEpoch option[value!='']").remove(); 
    	tableIns1.reload();
    })
    
    
    //添加
    function addUser(edit){
    	
        var index = layui.layer.open({
            title : "新增藏品",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/collections/toAdd.do','yes'],
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
  //添加
    function addUser1(edit){
    	
        var index = layui.layer.open({
            title : "新增化石",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/collectionsFossil/toAdd.do','yes'],
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
    
    //修改
    function editUser(edit){
    	
        var index = layui.layer.open({
            title : "修改藏品",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/collections/toEdit.do?id=' + edit.id,'yes'],
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
    //修改1
    function editUser1(edit){
    	
        var index = layui.layer.open({
            title : "修改化石",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/collectionsFossil/toEdit.do?id=' + edit.id,'yes'],
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
  //查看
    function showUser(edit){
    	
        var index = layui.layer.open({
            title : "查看藏品",
            type : 2,
            area: ['80%','700px'],
            content : [projectName + '/collections/toShowStatic.do?id=' + edit.id,'yes'],
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
            content : [projectName + '/collectionsFossil/toShowStatic.do?id=' + edit.id,'yes'],
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
    
    
    
    $(".addNews_btn").click(function(){
        addUser();
    })
    $(".addNews_btn1").click(function(){
        addUser1();
    })
    

    $(".addToTopic").click(function(){
    	addToTopic();
    })
     $(".addToTopic1").click(function(){
    	 addToTopic();
    })
    //文物列表操作
    table.on('tool(collectionsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
        	editUser(data);
        }else if(layEvent === 'show'){  //查看
        	showUser(data);
        }else if(layEvent === 'pub'){ // 公开
        	indexpub = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	publish(data.id);
        }else if(layEvent === 'nopub'){ // 取消公开
        	indexnopub = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	non_publish(data.id);
        }else if(layEvent === 'top'){ // 置顶
        	indextop = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	toTop(data.id);
        }else if(layEvent === 'down'){ // 取消置顶
        	indexdown = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	toDown(data.id);
        }else if(layEvent === 'del'){ //删除
        	indexdel = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	deleteColl(data.id);
        }
    });
    //化石列表操作
    table.on('tool(collectionsFossilList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
        	editUser1(data);
        }else if(layEvent === 'show'){  //查看
        	showUser1(data);
        }else if(layEvent === 'pub'){ // 公开
        	indexpub1 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	publish1(data.id);
        }else if(layEvent === 'nopub'){ // 取消公开
        	indexnopub1 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	non_publish1(data.id);
        }else if(layEvent === 'top'){ // 置顶
        	indextop1 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	toTop1(data.id);
        }else if(layEvent === 'down'){ // 取消置顶
        	indexdown1 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	toDown1(data.id);
        }else if(layEvent === 'del'){ //删除
        	indexdel1 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	deleteColl1(data.id);
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
    
    form.on('select(yearTypeEon)',function(data) {
    	var eon = data.value;
    	$("#yearTypeEra option[value!='']").remove(); 
    	$("#yearTypeEpoch option[value!='']").remove(); 
    	form.render();
    	$.ajax({
    		url:projectName + '/collectionsFossil/getYearTypeByParentId.do',
    		data:{"parentId":eon},
    		type:'post',
    		success:function(result) {
    			if (result.success == 1) {
    				var era = result.data;
        			var eraStr = "";
        			for (var i = 0;i < era.length;i++) {
        				eraStr +="<option value='"+era[i].id+"' >"+era[i].name+"</option>"
        			}
        			$("#yearTypeEra").append(eraStr); 
        			form.render();
    			}
    		}
    	})
    });
    
    form.on('select(yearTypeEra)',function(data) {
    	var era = data.value;
    	$("#yearTypeEpoch option[value!='']").remove(); 
    	form.render();
    	$.ajax({
    		url:projectName + '/collectionsFossil/getYearTypeByParentId.do',
    		data:{"parentId":era},
    		type:'post',
    		success:function(result) {
    			if (result.success == 1) {
    				var epoch = result.data;
        			var epochStr = "";
        			for (var i = 0;i < epoch.length;i++) {
        				epochStr +="<option value='"+epoch[i].id+"' >"+epoch[i].name+"</option>"
        			}
        			$("#yearTypeEpoch").append(epochStr); 
        			form.render();
    			}
    		}
    	})
    	
    })
    
    
    
    
    function publish(id) {
		$.ajax({
			url :projectName + '/collections/publish.do',
			type : "get",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indexpub);
				console.log(data);
				if(data == "1"){
					layer.msg('公开成功', {icon: 1});
					$.ajax({
						url:projectName + '/image/printWatermarkForEachCollection.do',
						type : "post",
						data :  {ids:id},
						dataType : "json",
						success:function(response){
							console.log("************************");
							console.log(response);
						}
					});
					tableIns.reload();

				}else if(data == "-1"){
					layer.msg('请先上传藏品图片', {icon: 2});
				}else if(data == "-2"){
					layer.msg('请先确认是否通过审核', {icon: 2});
				}
				else{
					layer.msg('公开失败', {icon: 2});
				}
			},
		})
	};
	function non_publish(id) {
		$.ajax({
			url :projectName + '/collections/nonPublish.do',
			type : "post",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indexnopub);
				if(data == "1"){
					layer.msg('取消公开成功', {icon: 1});
					tableIns.reload();
				}else if(data == "-1"){

				}else{
					layer.msg('取消公开失败', {icon: 2});
				}
			},
		})
	};
	
	function publish1(id) {
		$.ajax({
			url : projectName + '/collectionsFossil/publish.do',
			type : "get",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indexpub1);
				if(data == "1"){
					$.ajax({
						url:projectName + '/image/printWatermarkForEachCollection.do',
						type : "post",
						data :  data,
						dataType : "json",
						success:function(response){
							console.log("************************");
							console.log(response);
						}
					});
					layer.msg('公开成功', {icon: 1});
					tableIns1.reload();

				}else if(data == "-1"){
					layer.msg('请先上传藏品图片', {icon: 1});
				}else{
					layer.msg('公开失败', {icon: 2});
				}
			},
		})
	};

	function non_publish1(id) {
		$.ajax({
			url : projectName + '/collectionsFossil/nonPublish.do',
			type : "post",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indexnopub1);
				if(data == "1"){
					layer.msg('取消公开成功', {icon: 1});
					tableIns1.reload();

				}else if(data == "-1"){

				}else{
					layer.msg('取消公开失败', {icon: 2});
				}
			},
		})
	};
	
	
	function toTop(id) {
		$.ajax({
			url :projectName +  '/collections/top.do',
			type : "post",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indextop);
				if(data){
					layer.msg('置顶成功', {icon: 1});
					tableIns.reload();

				}else{
					layer.msg('置顶失败', {icon: 2});
				}
			},
		})
	};

	function toDown(id) {
		$.ajax({
			url :projectName + '/collections/down.do',
			type : "post",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indexdown);
				if(data){
					layer.msg('取消置顶成功', {icon: 1});
					tableIns.reload();

				}else{
					layer.msg('取消置顶失败', {icon: 2});
				}
			},
		})
	};
	
	function toTop1(id) {
		$.ajax({
			url :projectName + '/collectionsFossil/top.do',
			type : "post",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indextop1);
				if(data){
					layer.msg('置顶成功', {icon: 1});
					tableIns1.reload();

				}else{
					layer.msg('置顶失败', {icon: 2});
				}
			},
		})
	};

	function toDown1(id) {
		$.ajax({
			url :projectName + '/collectionsFossil/down.do',
			type : "post",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				top.layer.close(indexdown1);
				if(data){
					layer.msg('取消置顶成功', {icon: 1});
					tableIns1.reload();

				}else{
					layer.msg('取消置顶失败', {icon: 2});
				}
			},
		})
	};
	
	
	function deleteColl(id) {
		layer.confirm('确定删除此信息？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : projectName + '/collections/del.do',
					type : "post",
					data :  {ids:id},
					dataType : "json",
					async: false,
					success : function(data){
						top.layer.close(indexdel);
						if(data){
							layer.msg('成功删除', {icon: 1});
							tableIns.reload();

						}else{
							layer.msg('删除失败', {icon: 2});
						}
					},
				})
			}, function(){
			  layer.msg('已取消删除', {
			  });
			});
	};
	function deleteColl1(id) {
		layer.confirm('确定删除此信息？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : projectName + '/collectionsFossil/del.do',
					type : "post",
					data :  {ids:id},
					dataType : "json",
					async: false,
					success : function(data){
						top.layer.close(indexdel1);
						if(data){
							layer.msg('成功删除', {icon: 1});
							tableIns1.reload();

						}else{
							layer.msg('删除失败', {icon: 2});
						}
					},
				})
			}, function(){
			  layer.msg('已取消删除', {
			  });
			});
	};
	
	function addToTopic(id) {
		var checkStatus = table.checkStatus('collectionsListTable'); //test即为基础参数id对应的值
		console.log(checkStatus.data) //获取选中行的数据
		var dataList =checkStatus.data;
		var ids="";
		if(dataList.length==0){
			layer.msg('请先选择藏品', {icon: 2});
			return false;
		}
		for(var i=0;i<dataList.length;i++){
			ids += dataList[i].id+",";
		}
		var url = projectName+"/topic/goTopic.do?id="+ids+"&type=1";
	    layer.open({
	        type: 2,
	        title: '专题列表',
	        shadeClose: true,
	        shade: 0.5,
	        maxmin: true, //开启最大化最小化按钮
	        area: ['600px', '600px'],
	        content: [url,'no'],
	        end: function () {
	        	
	        }
	    });
		
	};
	
	$(".openSetting").click(function(){
		$(".daochuList").toggleClass("show");
		return false;
	})
	$(".daochuList li").off().on('click', function (e) {
	      stopBubble(e);
	      debugger;
	      var type = $(this).attr("data-type");
	      var checkStatus = table.checkStatus("collectionsListTable");
    	  if(type == "2"){
    		  checkStatus = table.checkStatus("collectionsFossilListTable");
    	  }
    	  var data = checkStatus.data;
	      if ($(this).index() == 0) {
	    	  var newData = new Array();
	    	  var count = 0;
	    	  if(data != null && data.length>0){
	    		  for(var i=0;i<data.length;i++){
	    			  var isOpen =  data[i].isOpen;
	    			  var gjOpen =  data[i].gjOpen;
	    			  if(gjOpen != "2"){
	    				  newData.push(data[i].id);
	    			  }else{
	    				  count++;
	    			  }
	    		  }
	    		  if(count > 0){
	    			  if(newData.length>0){
	    				  layer.msg('已自动剔除无效选项', {icon: 2});  
	    			  }else{
	    				  layer.msg('所选项均为无效选项', {icon: 2});  
	    			  }
	    		  }else{
	    			  openSetting(newData,"1",type);
	    		  }
	    	  }else{
	    		  
	    		  layer.msg('请选择要操作的选项', {icon: 2});
	    	  }
	        $(".daochuList").toggleClass("show");
	        
	        return false;
	      } else if ($(this).index() == 1) {
	    	  var newData = new Array();
	    	  var count = 0;
	    	  if(data != null && data.length>0){
	    		  for(var i=0;i<data.length;i++){
	    			  var isOpen =  data[i].isOpen;
	    			  var gjOpen =  data[i].gjOpen;
	    			  if(isOpen != "3" && isOpen != "2"){
	    				  newData.push(data[i].id);
	    			  }else{
	    				  count++;
	    			  }
	    		  }
	    		  if(count > 0){
	    			  if(newData.length>0){
	    				  layer.msg('已自动剔除无效选项', {icon: 2});  
	    			  }else{
	    				  layer.msg('所选项均为无效选项', {icon: 2});  
	    			  }
	    		  }else{
	    			  openSetting(newData,"2",type);
	    			  
	    		  }
	    	  }else{
	    		  layer.msg('请选择要操作的选项', {icon: 2});
	    	  }
	        $(".daochuList").toggleClass("show");
	        
	        return false;
	      }else if($(this).index() == 2){
	    	  var newData = new Array();
	    	  var gjData = new Array();
	    	  var isData = new Array();
	    	  var count = 0;
	    	  if(data != null && data.length>0){
	    		  for(var i=0;i<data.length;i++){
	    			  var isOpen =  data[i].isOpen;
	    			  var gjOpen =  data[i].gjOpen;
	    			  if(isOpen == "1" || gjOpen == "1"){
	    				  if(isOpen == "1"){
		    				  isData.push(data[i].id);
		    			  }
		    			  if(gjOpen == "1"){
		    				  gjData.push(data[i].id);
		    			  }
	    			  }else{
	    				  count++;
	    			  }
	    		  }
	    		  if(count > 0){
	    			  if(isData.length>0 || gjData.length>0){
	    				  layer.msg('已自动剔除无效选项', {icon: 2});  
	    			  }else{
	    				  layer.msg('所选项均为无效选项', {icon: 2});  
	    			  }
	    		  }else{
	    			  openSetting(gjData,"1",type);
	    			  openSetting(isData,"2",type);
	    		  }
	    	  }else{
	    		  
	    		  layer.msg('请选择要操作的选项', {icon: 2});
	    	  }
	        $(".daochuList").toggleClass("show");
	        
	        return false;
	      } 	      
	      else {
	    	  $(".daochuList").toggleClass("show");
	        return false;
	      }
	    });

	function stopBubble(e){

	  if(e && e.stopPropagation)

	    e.stopPropagation()

	  else

	    window.event.cancelBubble = true

	}
	
	function openSetting(data,info,type){
		if(data.length == 0){
			return false;
		}
		var url = "";
		var paStr = "";
		if(type == "1"){
			paStr = "/collections";
		}else{
			paStr = "/collectionsFossil";
		}
		if(info == "1"){
			url = paStr+"/publishAllNew.do";
		}else if(info == "2"){
			url = paStr+"/publishToOpen.do";
		}else if(info == "3"){
			url = paStr+"/publishToAll.do";
		}else{
			return false;
		}
		$.ajax({
			url :projectName + url,
			type : "get",
			data :  {"ids":data,"type":type},
			traditional: true,
			dataType : "json",
			success : function(data){
//				top.layer.close(indexpub);
				console.log(data);
				if(data == "1"){
					layer.msg('公开成功', {icon: 1});
					$.ajax({
						url:projectName + '/image/printWatermarkForEachCollection.do',
						type : "post",
						data :  {ids:data},
						dataType : "json",
						success:function(response){
							console.log("************************");
							console.log(response);
						}
					});
					tableIns.reload();
					tableIns1.reload();

				}else if(data == "-1"){
					layer.msg('请先上传藏品图片', {icon: 2});
				}else if(data == "-2"){
					layer.msg('请先确认是否通过审核', {icon: 2});
				}
				else{
					layer.msg('公开失败', {icon: 2});
				}
			},
		})
	}
    
})


 
