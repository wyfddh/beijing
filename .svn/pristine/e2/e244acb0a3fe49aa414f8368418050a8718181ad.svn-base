layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    

    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    var orgId=sessionStorage.getItem('orgId');
    //用户列表
    var tableIns = table.render({
        elem: '#submitList',
        url : projectName + '/collectionInfo/getSubmitList.do', 
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        page : true,
        limits : [10, 15, 20, 50],
        limit : 20,
        where:{
            orgId:orgId
        },
        id : "submitListTable",
        cols : [[
            {type:"numbers",title: '序号', width:70, align:"center"},
            {field: 'orgName', title: '收藏单位', minWidth:100, align:"left"},
            {field: 'updateDateStr', title: '完成时间', minWidth:200, align:'left'},
            {field: 'dataState', title: '完成状态', align:'left',minWidth:100},
        ]],
    });
    form.on('select(dataState)', function(data){
		  table.reload("submitListTable",{
	          page: {
	              curr: 1 //重新从第 1 页开始
	          },
	          where: {
	          	dataState:data.value
	          }
	      })
    }); 

  
    $(".search_btn").on("click",function(){
        
    });
    
    $("#resetBtn").on("click",function(){
    	tableIns.reload();
    })
})
