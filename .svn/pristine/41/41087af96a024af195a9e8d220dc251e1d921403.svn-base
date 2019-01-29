layui.use(['form','layer','table','element','laytpl'],function(){
   var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
   var element = layui.element;
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    var recordType=$("#recordType").val();
    var museumId=$("#museumId").val();
    var tableIns;
    var buildTableIns;
    var renderList=[];
    var buildCols=[];
    var renderList = [
        {type:"numbers", title: '序号', width:70, align:"center"},
        {field: 'version', title: '版本号', align:"center"},
        {field: 'createBy', title: '操作人', align:"center"},
        {field: 'createDate', title: '修改提交时间', align:"center"},
        {field: 'type', title: '类型',width:105, align:"center"},
        {title: '操作',width:150, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
    ];   
    //用户列表
    if(recordType=="base"){	
    	    tableIns = table.render({
            elem: '#recordList',
            url : projectName+'/eidtRecord/getBaseInfoList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols :[renderList]
        });
    }else if(recordType=="build"){
    	$("#gsjz").removeClass("layui-hide");
    	$("#jcss").removeClass("layui-hide");
    	$("#warehouse").removeClass("layui-hide");
    	$("#showroom").removeClass("layui-hide");
    	element.render();
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getBaseHouseList.do?museumId='+museumId, 
            cellMinWidth : 95,
            height:300,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    	
    	buildTableIns = table.render({
            elem: '#buildList',
            url : projectName + '/eidtRecord/getBuildList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 300,   
            limits : [10,15,20,25],
            limit : 10,
            id : "buildListTable",
            cols : [renderList]
        });
    	
    	warehouseTableIns = table.render({
            elem: '#warehouseList',
            url : projectName + '/eidtRecord/getWarehouseList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 300,   
            limits : [10,15,20,25],
            limit : 10,
            id : "warehouseListTable",
            cols : [renderList]
        });
    	
    	warehouseTableIns = table.render({
            elem: '#showroomList',
            url : projectName + '/eidtRecord/getShowRoomList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 300,   
            limits : [10,15,20,25],
            limit : 10,
            id : "showroomListTable",
            cols : [renderList]
        });
    }else if(recordType=="service"){
    	$("#shfw").removeClass("layui-hide");
    	$("#jbcl").removeClass("layui-hide");
    	element.render();
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getServiceList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 300,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    	
    	displayList = table.render({
            elem: '#displayList',
            url : projectName + '/eidtRecord/getDiplayShowList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 300,   
            limits : [10,15,20,25],
            limit : 10,
            id : "displayListTable",
            cols : [renderList]
        });
    }else if(recordType=="digitization"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getDigitizationList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType=="promotion"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getPromotionList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "collection"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getCollectionList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }
    else if(recordType == "safe"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getSafeList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }
    else if(recordType == "relicsBureau"){
    	$("#relicsBureau").removeClass("layui-hide");
    	tableIns = table.render({
            elem: '#relicsBureauList',
            url : projectName + '/eidtRecord/getRelicsBureauList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "relicsBureauTable",
            cols : [renderList]
        });
    }
    else if(recordType == "relicsBureauPerson"){
    	$("#relicsBureauPersonChange").removeClass("layui-hide");
    	$("#relicsBureauPersonDetail").removeClass("layui-hide");
    	tableIns = table.render({
            elem: '#relicsBureauPersonChangeList',
            url : projectName + '/eidtRecord/getRelicsBureauPersonChangeList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "relicsBureauPersonChangeTable",
            cols : [renderList]
        });
    	tableIns = table.render({
            elem: '#relicsBureauPersonDetailList',
            url : projectName + '/eidtRecord/getRelicsBureauPersonDetailList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "relicsBureauPersonDetailTable",
            cols : [renderList]
        });
    }
    else if(recordType == "relicsUnit"){
    	$("#relicsUnit").removeClass("layui-hide");
    	tableIns = table.render({
            elem: '#relicsUnitList',
            url : projectName + '/eidtRecord/getRelicsUnitList.do?museumId='+museumId, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : true,
            height : 600,   
            limits : [10,15,20,25],
            limit : 10,
            id : "relicsUnitTable",
            cols : [renderList]
        });
    }
    
    var checkData = [];
    table.on('checkbox(recordList)', function(obj){
            checkData.push(obj.data);
    });
    
    var checkBuildData = [];
    table.on('checkbox(buildList)', function(obj){
    	checkBuildData.push(obj.data);
    });
    

    
    function reloadTable(fieldList) {
    	tableIns.reload({cols :[fieldList]});
    }
    
    function reloadBuildTable(fieldList) {
    	buildTableIns.reload({cols :[fieldList]});
    }
    
  //列表操作
    table.on('tool(recordList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    
    //列表操作
    table.on('tool(buildList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "building";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    
  //列表操作
    table.on('tool(warehouseList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "warehouse";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
        	,success:function(layero, index){
            	resizeLayer(index);
            }
        	});
        }
    });
    
    table.on('tool(showroomList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "showroom";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    table.on('tool(displayList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "display";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    
    table.on('tool(relicsBureauList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "relicsBureau";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    table.on('tool(relicsBureauPersonChangeList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "relicsBureauPersonChange";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    table.on('tool(relicsBureauPersonDetailList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "relicsBureauPersonDetail";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
    table.on('tool(relicsUnitList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        recordType = "relicsUnit";
        if(layEvent === 'show'){ //查看
        	layer.open({
                type: 2,
                title: "查看详情",
                shadeClose: true,
                shade: 0.5,
                area: ['1000px', '600px'],
                content: [projectName+'/eidtRecord/showDetail.do?museumId='+ museumId +'&id='+ data.id+'&type='+recordType,'yes']
	        	,success:function(layero, index){
	            	resizeLayer(index);
	            }
        	});
        }
    });
})
