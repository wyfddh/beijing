layui.use(['form','layer','table','laytpl'],function(){
   var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
  
 
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
   
    
    //用户列表
    var tableIns = table.render({
        elem: '#legalTypeList',
        url : projectName + '/legalType/dataList.do', 
        cellMinWidth : 95,
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        page : true,
        limits : [10,15,20,25],
        limit : 10,
        id : "legalTypeId",
        cols : [[
            {type:"numbers", title: '序号', width:70, align:"center"},
            {field: 'typeName', title: '分类名', align:"left"},
            {field: 'kind', title: '分类级别',  align:'center',templet:function(d){
            return d.kind == "1" ? "一级分类" : "二级分类";
            }},
            {title: '操作', templet:'#legalTypeListBar',fixed:"right",align:"center"}
        ]]
    });
    
    function reloadTable() {
    	tableIns.reload();
    }
    
    $("#typeNameId").change(function() {
    	tableIns.reload({
    		where: { //设定异步数据接口的额外参数，任意设
  			  typeName: $("#typeNameId").val()
  		  	}
  		  	,page: {
  		  		curr: 1 //重新从第 1 页开始
  		  	}
  		});
    })
    
    //添加用户
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
    	var tit = "添加分类";
    	if (edit) {
    		tit = "修改分类"
    	}
        var index = layui.layer.open({
            title : tit,
            type : 2,
            closeBtn:1 ,
            area: ['700px', '500px'],
            content: [projectName + '/legalType/toAdd.do','no'], 
            success : function(layero, index){
            	resizeLayer(index);
                var body = layui.layer.getChildFrame('body', index);
               
                if(edit){
                	body.find("#divLevel").hide();
                	body.find("#typeName").val(edit.typeName);
                	body.find("#type1").val("2");
                	body.find("#id").val(edit.id);
                    form.render();
                }
                
                
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)  
            },
            end :function() {
            	tableIns.reload();
            }
        })
        /*layui.layer.full(index);*/ 
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })
 

    var initData = function() {
    	$(".hide").hide(); 
    }
    initData();
    //列表操作
    table.on('tool(legalTypeList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定停用此用户？",
                btnText = "停用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除？',{icon:3, title:'提示信息'},function(index){
                 $.get(projectName + '/legalType/del.do',{
                     id : data.id ,
                     kind:data.kind//将需要删除的Id作为参数传入
                 },function(result){
                	 var msg = result.msg;
                	 if (msg == 1) {
                		 layer.close(index);
                		 top.layer.msg("删除成功！");
                    	 tableIns.reload();  
                	 } else if (msg == 2) {
                		 layer.close(index);
                    	 top.layer.msg("系统异常删除失败！");
                	 } else if (msg == 3) {
                		 layer.close(index);
                		 top.layer.msg("该分类下有法律法规，不允许删除！");
                	 }
                	 
                 }) 
            });
        }
    });
})
