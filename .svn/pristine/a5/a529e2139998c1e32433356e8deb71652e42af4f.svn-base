layui.use(['form','table'],function(){
	var index = parent.layer.getFrameIndex(window.name);
	var form = layui.form;
	var table = layui.table;
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	var id = $("#id").val();
	var tableIns = table.render({
        elem: '#collectionsList',
        url : projectName + '/openCollection/getCollectionDetailList.do?id='+id, 
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
        id : "collectionsList",
        cols : [[
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
//            {field: 'gsTexture', title: '质地', align:'left'},
//            {field:'collectionUnit',title: '收藏单位', align:'left'}
           
        ]],
        done:function(result){      	
        }
    });
	
	
});