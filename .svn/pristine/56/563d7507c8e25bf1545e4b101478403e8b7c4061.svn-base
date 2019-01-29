layui.use(['form','layer','table','laytpl','element'],function(){
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : top.layer,
			$ = layui.jquery,
			laytpl = layui.laytpl,
			table = layui.table;
	var element = layui.element;

	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

	//用户列表
	var tableIns = table.render({
		elem: '#collectDcBorrowList',
		url : projectName + '/collectDcBorrow/dataList.do?collectionType=0', 
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
		id : "collectDcBorrowListTable",
		cols : [[
//		         {type:"checkbox", width:30, align:"center"},
		         {type:"numbers",title: '序号', width:30, align:"center"},
		         {field:'cpimg', title: '藏品图片', width:120, style:'height:118px;', align:'center',templet:"#cpimg"},
		         {field: 'name', title: '普查名称', align:'center',minWidth:100,event:'show',style:'color:#01AAED;cursor:pointer'},
		         {field: 'gsNo', title: '普查编号', align:'center',minwidth:100},
		         {field: 'yearType', title: '年代', align:'center',width:80},
		         {field: 'collectionsCategory', title: '类别', align:'center',width:60},
		         {field: 'collectionLevel', title: '级别',width:100, align:'center',templet:function(d){
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
		         {field:'collectionUnit',title: '收藏单位',minwidth:100, align:'center'},
		         ]],
		         done:function(result){

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
			elem: '#collectDcBorrowFossilList',
			url : projectName + '/collectDcBorrow/dataList.do?collectionType=1', 
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
			id : "collectDcBorrowFossilListTable",
			cols : [[
//				{type:"checkbox", width:30, align:"center"},
				{type:"numbers",title: '序号', width:30, align:"center"},
				{field:'cpimg', title: '藏品图片', width:120, style:'height:118px;', align:'center',templet:"#cpimg1"},
				{field: 'name', title: '普查名称', align:'center',minWidth:100,event:'show',style:'color:#01AAED;cursor:pointer'},
				{field: 'gsNo', title: '普查编号', align:'center',minwidth:100},
				{field: 'yearType', title: '年代', align:'center',width:80},
				{field: 'collectionsCategory', title: '类别', align:'center',width:60},
				{field: 'collectionLevel', title: '级别',width:100, align:'center',templet:function(d){
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
				{field:'collectionUnit',title: '收藏单位',minwidth:100, align:'center'},
			]],
			done:function(result){
				
			}
		});
	}
	//文物
	$(".search_btn").on("click",function(){
		table.reload("collectDcBorrowListTable",{
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
		table.reload("collectDcBorrowFossilListTable",{
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
	
	//文物列表操作
    table.on('tool(collectDcBorrowList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
        	editUser(data);
        }else if(layEvent === 'show'){  //查看
        	showUser(data);
        }
    });
  //化石列表操作
    table.on('tool(collectDcBorrowFossilList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
        	editUser(data);
        }else if(layEvent === 'show'){  //查看
        	showUser(data);
        }
    });
  //查看
    function showUser(edit){    	
        var index = layui.layer.open({
            title : "查看藏品",
            type : 2,
            area: ['70%','700px'],
            content : [projectName + '/collections/toShow.do?id=' + edit.id,'yes'],
            success : function(layero, index){
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
})
