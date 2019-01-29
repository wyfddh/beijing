layui.use(['form','layer','table','laytpl'],function(){
   var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
  
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    var recordType=$("#type").val();
    var id=$("#id").val();
    var museumId=$("#museumId").val();
    var tableIns;
    var buildTableIns;
    var renderList=[];
    var buildCols=[];
    renderList = [
        {type:"numbers", title: '序号', width:70, align:"center"},
        {field: 'property', title: '字段名', align:"center"},
        {field: 'beforeEdit', title: '变动前', align:"center"},
        {field: 'afterEdit', title: '变动后', align:"center"},
    ];
    //用户列表
    if(recordType=="base"){    	
    	    tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getBaseInfoList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols :[renderList]
        });
    }else if(recordType=="build"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getBaseHouseList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            height:500,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    	
    }
    else if(recordType=="building"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getBuildList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            height:500,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }
    else if(recordType=="service"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getServiceList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType=="digitization"){

    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getDigitizationList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType=="promotion"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getPromotionList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "collection"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getCollectionList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "safe"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getSafeList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "warehouse"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getWarehouseList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "showroom"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getShowRoomList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "display"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getDiplayShowList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }else if(recordType == "relicsBureau"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getRelicsBureauList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }
    else if(recordType == "relicsBureauPersonChange"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getRelicsBureauPersonChangeList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }
    else if(recordType == "relicsBureauPersonDetail"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getRelicsBureauPersonDetailList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
            cols : [renderList]
        });
    }
    else if(recordType == "relicsUnit"){
    	tableIns = table.render({
            elem: '#recordList',
            url : projectName + '/eidtRecord/getRelicsUnitList.do?museumId='+museumId+'&id='+id, 
            cellMinWidth : 95,
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            page : false,
            height : 500,   
            limits : [10,15,20,25],
            limit : 10,
            id : "recordListTable",
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
    
//   
    
    function reloadTable(fieldList) {
    	tableIns.reload({cols :[fieldList]});
    }
    
    function reloadBuildTable(fieldList) {
    	buildTableIns.reload({cols :[fieldList]});
    }
    
    
    function showDetailRecord(type,id,nextId) {
		layer.open({
            type: 2,
            title: "查看详情",
            shadeClose: true,
            shade: 0.5,
            area: ['1300px', '800px'],
            content: ['<%=request.getContextPath() %>/eidtRecord/showDetailRecord.do?type='+type+'&id='+id+'&nextId='+nextId,'yes']
        });
	}
    
    
    
    
})
