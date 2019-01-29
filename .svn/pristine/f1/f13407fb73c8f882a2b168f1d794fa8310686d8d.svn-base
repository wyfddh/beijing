layui.use(['form','layer','table','laytpl','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
  
    	  var laydate = layui.laydate;
    	  
    	  //执行一个laydate实例
    	  laydate.render({
    		  elem: '#dateRange' 
    		  ,type: 'year'
    		  ,range: true
    		});
    	     
    	  
 
    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    //用户列表
    var tableIns = table.render({
        elem: '#legalList',
        url : projectName + '/legal/dataList.do', 
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        cellMinWidth : 95,
        page : true,
        limits : [10,15,20,25],
        limit : 10,
        id : "userListTable",
        cols : [[
            {type:"numbers",title: '序号', width:70, align:"center"},
            {field: 'title', title: '标题',style:'color:#01AAED;cursor:pointer',event:'show', minWidth:100, align:"left"},
            {field: 'firstKindName', title: '一级分类', minWidth:200, align:'left'},
            {field: 'secondKindName', title: '二级分类', align:'left',minWidth:100},
            {field: 'publisher', title: '发布单位', align:'left',minWidth:100},
            {field: 'publishYear', title: '发布年份', align:'left',minWidth:100},
            {field: 'code', title: '条款号', align:'left',minWidth:150},
            {title: '操作', minWidth:175,fixed:'right', templet:'#legalListBar',align:"center"}
        ]],
        done:function(){
        	
        }
    });
    
    var initForm = function() {
    	$(".hide").hide(); 
    	getHeadData();
    }
    
    initForm();
    
    function reloadTable() {
    	tableIns.reload();
    }
    
    $("#resetBtn1").on("click",function(){
    	
    	tableIns.reload({
    		where: { //设定异步数据接口的额外参数，任意设
  		  	}
  		  	,page: {
  		  		curr: 1 //重新从第 1 页开始
  		  	}
  		});
    })
    
    $("#searchBtn").click(function() {
    	tableIns.reload({
    		where: { //设定异步数据接口的额外参数，任意设
  			  title:$("#title").val(),
  			  firstKindId:$("#firstKind").val(),
  			  secondKindId:$("#secondKind").val(),
  			  dateRange:$("#dateRange").val(),
  			  publisher:$("#publisher").val()
  		  	}
  		  	,page: {
  		  		curr: 1 //重新从第 1 页开始
  		  	}
  		});
    })
    
//    form.on('select(firstKind)', function(data){
//    	$("#secondKind option[value!='']").remove();  
//    	var firstKindId = {"firstKindId":data.value};
//    	$.ajax({
//    		url:projectName + '/legal/getSecondKindList.do', 
//    		data:firstKindId,
//    		type:"post",
//    		async:false,
//    		success:function(result) {
//    			var secondKindList = result.data;
//    			var secondStr = "";
//    			for (var i = 0;i < secondKindList.length;i++) {
//    				secondStr +="<option value='"+secondKindList[i].id+"' >"+secondKindList[i].typeName+"</option>"
//    			}
//    			$("#secondKind").append(secondStr); 
//    			form.render();
//    		}
//    	})
//	});  
    
    
    //请求检索条件数据
    function getHeadData() {
    	$.ajax({
    		type:"post",
    		url:projectName + '/legal/headData.do',
    		async:false,
    		success:function(result) {
    			if (result.success == 1) {
    				var lists = result.data;
    				var firstKindList = lists.firstKindList;
    				var secondKindList = lists.secondKindList;
    				
    				var firstStr = "";
    				for(var i = 0;i < firstKindList.length;i++) {
    					firstStr +="<option value='"+firstKindList[i].id+"' >"+firstKindList[i].typeName+"</option>"
    				}
    				$("#firstKind").append(firstStr);
    				
    				var secondStr = "";
    				for(var k = 0;k < secondKindList.length;k++) {
    					secondStr +="<option value='"+secondKindList[k].id+"' >"+secondKindList[k].typeName+"</option>"
    				}
    				$("#secondKind").append(secondStr);
    				
    				var publiserList = lists.publiserList; 
    				var publisherStr = "";
    				for(var j = 0;j < publiserList.length;j++) {
    					publisherStr +="<option value='"+publiserList[j].publisher+"' >"+publiserList[j].publisher+"</option>"
    				}
    				$("#publisher").append(publisherStr);
    				form.render();
    			}
    		}
    	})
    }
    
    //添加
    function addUser(edit){
        /*layer.open({
            type: 2,
            content: 'test/iframe.html',
            success: function(layero, index){
                var body = layer.getChildFrame('body', index);
                var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                console.log(body.html()) //得到iframe页的body内容
                body.find('input').val('Hi，我是从父页来的')
            }
        });
*/
        var index = layui.layer.open({
            title : "发布",
            type : 2,
            area: ['80%', '700px'],
            content : [projectName + '/legal/toAdd.do','no'], 
            success : function(layero, index){
            	resizeLayer(index);
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                	
                    body.find("#title").val(edit.title);
                    body.find("#textareaHide").val(edit.content);
                    body.find("#firstKindHide").val(edit.firstKindId);
                    body.find("#secondKindHide").val(edit.secondKindId);
                    
                    body.find("#firstKind option[value='"+edit.firstKindId+"']").attr("selected",true);
                    body.find("#secondKind option[value='"+edit.secondKindId+"']").attr("selected",true);
                    
                    body.find("#publisher").val(edit.publisher);
                    body.find("#publishYear").val(edit.publishYear);
                    body.find("#code").val(edit.code);
                    body.find("#divtext").text(edit.realFileName);
                    
                    body.find("#legalId").val(edit.id);
                    body.find("#attachmentId").val(edit.attachmentId);
                    body.find("#resultPath").val(edit.resultPath);   
                    
                    body.find("#saveType").val("2"); 
                    form.render();
                } else {
                	body.find("#saveType").val("1"); 
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500) 
            },
            cancel: function(index, layero){ 
            	/*if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
            	    
            	}*/
            	var body = layui.layer.getChildFrame('body', index);
            	var resultPath = body.find("#resultPath").val();
            	var type = body.find("#saveType").val(); 
//            	if (type == "1") {
//            		cancelFile(resultPath);
//            	} else if (type == "2") {
//            		if (resultPath != "") {
//            			cancelFile(resultPath);
//            		}
//            	}
            	layer.close(index)
            },
            end :function() {
            	tableIns.reload();
            }
        })
        layui.layer.full(index);  
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
//        $(window).on("resize",function(){
//            layui.layer.full(window.sessionStorage.getItem("index"));
//        })
    }
    //删除上传的文件
//    function cancelFile(resultPath) {
//    	$.ajax({
//			type:"post",
//			url:projectName + '/attach/cancelFile.do',
//			data:{"resultPath":resultPath},
//			success:function(result) {
//				
//			}
//		})
//    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除文章接口",{
                //     newsId : newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(legalList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'show'){ //查看
        	
            var showIndex = layui.layer.open({
                title : "查看",
                type : 2,
                area: ['80%', '700px'],
                content : [projectName + '/legal/toShowGov.do?id='+data.id,'yes'], 
                success : function(layero, showIndex){
                	resizeLayer(showIndex);
                    var body = layui.layer.getChildFrame('body', showIndex);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500) 
                },
                end :function() {
                	tableIns.reload();
                }
            }) 
            /*layui.layer.full(index);*/
            window.sessionStorage.setItem("index",showIndex);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(window.sessionStorage.getItem("index"));
            })
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除？',{icon:3, title:'提示信息'},function(index){
                 $.get(projectName + '/legal/del.do',{
                     id : data.id,
                     attachmentId :data.attachmentId
                 },function(result){
                	var msg = result.msg;
                	if (msg == 1) {
                		top.layer.msg("删除成功！"); 
                        tableIns.reload();
                        layer.close(index);
                	} else {
                		top.layer.msg("系统异常删除失败！"); 
                        tableIns.reload();
                        layer.close(index);
                	}
                	
                 })
            });
        }
    });

})
