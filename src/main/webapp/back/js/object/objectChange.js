layui.use(['form','layer','table','element','laytpl'],function(){
    var form = layui.form,
    	element = layui.element,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
  
 
    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    var level= $("#level").val();
    var colsList = [];
    var tableFossIns;
    if(level=="1"){
    	colsList=[
         {type:"numbers",title: '序号', width:70, align:"left"},
         {field: 'cpimg', title: '标题图片',style:'height:118px;',width: 180, align:"left", templet:"#cpimg"},
         {field: 'name', title: '普查名称', minWidth:200, align:'left'},
         {field: 'formerly', title: '藏品原名', align:'left',minWidth:100},
         {field: 'gsNo', title: '一普编号', align:'left',minWidth:100},
         {field: 'yearType', title: '所属年代', align:'left',minWidth:100},
         {field: 'collectionCategory', title: '文物类别', align:'left',minWidth:150},
         {field: 'collectionLevel', title: '文物级别', align:'left',minWidth:130},
         {field: 'collectionUnit', title: '收藏单位', align:'left',minWidth:130},
         {title: '操作', minWidth:175, style:'height:118px;',templet:'#objectListBar',align:"center",style:'height:118px;',fixed:'right'}
        ];
    }else{
    	colsList=[
    	          {type:"numbers",title: '序号', width:70, align:"center"},
    	          {field: 'cpimg', title: '标题图片',style:'height:118px;',width: 180, align:"left", templet:"#cpimg1"},
    	          {field: 'name', title: '普查名称', minWidth:200, align:'center'},
    	          {field: 'formerly', title: '藏品原名', align:'left',minWidth:100},
    	          {field: 'gsNo', title: '一普编号', align:'left',minWidth:100},
    	          {field: 'yearType', title: '所属年代', align:'left',minWidth:100},
    	          {field: 'collectionCategory', title: '文物类别', align:'left',minWidth:150},
    	          {field: 'collectionLevel', title: '文物级别', align:'left',minWidth:150},
    	          {title: '操作', minWidth:175, style:'height:118px;',templet:'#objectListBar',fixed:"right",align:"center",style:'height:118px;',fixed:'right'}
    	         ];
    }
    
  //文物列表
    var tableIns = table.render({
        elem: '#objectList',
        url : projectName + '/objectChange/infoList.do', 
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        cellMinWidth : 95,
        page : true,
        limits : [10,15,20,25],
        limit : 10,
        id : "objectListTable",
        cols : [colsList],
        done:function(){
        	
        }
    });
    
    var tabCount = 0;
    element.on('tab(changeTab)', function(data){
    	tabCount++;
    	var tabIndex = data.index; //当前Tab的所在下标
    	if (tabCount == 1) {
    		getFossilTable();
    	}
    });
    
    
    $("#resetBtn").click(function() {
    	$("#name").val("");
    	$("#collectionCategory").val("");
    	$("#yearType").val("");
    	$("#otherYearType").val("");
    })
    
    function getFossilTable(){
    	//化石
        tableFossIns = table.render({
            elem: '#objectFossList',
            url : projectName + '/objectChange/infoList.do?collectionType=2', 
            request:{
            	pageName: 'currentPage',
            	limitName: 'size'
            },
            cellMinWidth : 95,
            page : true,
            limits : [10,15,20,25],
            limit : 10,
            id : "objectFossListTable",
            cols : [colsList],
            done:function(){
            	
            }
        });
    }
    
    $("#search").click(function() {
    	tableIns.reload({
    		where: { //设定异步数据接口的额外参数，任意设
    			name:$("#name").val(),
    			collectionCategory:$("#collectionCategory").val(),
    			yearType:$("#yearType").val(),
    			otherYearType:$("#otherYearType").val(),
    			collectionUnit:$("#collectionUnit").val()
  		  	}
  		  	,page: {
  		  		curr: 1 //重新从第 1 页开始
  		  	}
  		});
    })
    
    $("#resetBtnFoss").click(function() {
    	$("#nameFoss").val("");
    	$("#collectionCategoryFoss").val("");
    	$("#yearTypeEon").val(""); 
    	$("#yearTypeEra").val("");
    	$("#yearTypeEpoch").val("");
    })
    
     $("#searchFoss").click(function() {
    	 tableFossIns.reload({
    		where: { //设定异步数据接口的额外参数，任意设
    			name:$("#nameFoss").val(),
    			collectionCategory:$("#collectionCategoryFoss").val(),
    			yearTypeEon:$("#yearTypeEon").val(),
    			yearTypeEra:$("#yearTypeEra").val(),
    			yearTypeEpoch:$("#yearTypeEpoch").val(),
    			collectionUnit:$("#collectionUnitFoss").val()
  		  	}
  		  	,page: {
  		  		curr: 1 //重新从第 1 页开始
  		  	}
  		});
    })
    
    
    form.on('select(yearTypeChange)', function(data){
    	if($("#otherYearType").val() !="" && $("#yearType").val() !=""){
    		$("#otherYearType").siblings("div.layui-form-select").find("dd:first").click();  
    	}
    	 
	}); 
    
    form.on('select(otherYearTypeChange)', function(data){
    	if($("#yearType").val() !="" && $("#otherYearType").val() !=""){
    		$("#yearType").siblings("div.layui-form-select").find("dd:first").click();
    	}
	});
    
    form.on('select(yearTypeEon)', function(data){
    	var id = data.value;
		if(id==""){
			return false;
		}
	    $.ajax({
	      url : projectName+"/objectChange/selectEra.do",
	      type : "post",
	      data :  {id:id},
	      dataType : "json",
	      success : function(result){
	    	    var yearTypeEraList = result.data;
	  			$("#yearTypeEra").empty();
	  			var secondStr = '<option value="">全部</option>';
	  			for (var i = 0;i < yearTypeEraList.length;i++) {
	  				secondStr +="<option value='"+yearTypeEraList[i].id+"' >"+yearTypeEraList[i].name+"</option>"
	  			}
	  			$("#yearTypeEra").append(secondStr); 
	  			form.render();
	      }
	   })
    	 
	});
    
    form.on('select(yearTypeEra)', function(data){
    	var id = data.value;
		if(id==""){
			return false;
		}
	    $.ajax({
	      url : projectName+"/objectChange/selectEra.do",
	      type : "post",
	      data :  {id:id},
	      dataType : "json",
	      success : function(result){
	    	    var yearTypeEraList = result.data;
	  			$("#yearTypeEpoch").empty();
	  			var secondStr = '<option value="">全部</option>';
	  			for (var i = 0;i < yearTypeEraList.length;i++) {
	  				secondStr +="<option value='"+yearTypeEraList[i].id+"' >"+yearTypeEraList[i].name+"</option>"
	  			}
	  			$("#yearTypeEpoch").append(secondStr); 
	  			form.render();
	      }
	   })
	});
    

    //列表操作
    table.on('tool(objectList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'versionChange'){ 
        	versionChange(data.id);
        }
    });
    
    function versionChange(selectId){
    	var index = layui.layer.open({
            type: 2,
            title: '版本变动',
            shadeClose: true,
            shade: 0.5,
            area: ['900px', '400px'],
            content: [projectName+'/objectChange/goChangeList.do?selectId='+ selectId+'&collectionType='+1,'yes']
        });
    	
	}
    
  //列表操作
    table.on('tool(objectFossList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'versionChangeFoss'){ 
        	versionChangeFoss(data.id);
        }
    });
    
    function versionChangeFoss(selectId){
    	var index = layui.layer.open({
            type: 2,
            title: '版本变动',
            shadeClose: true,
            shade: 0.5,
            area: ['900px', '400px'],
            content: [projectName+'/objectChange/goChangeList.do?selectId='+ selectId+'&collectionType='+2,'yes']
        });
    	
	}
})

