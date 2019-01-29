layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    

    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : projectName + '/userManagemen/dataList.do', 
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
            {field: 'name', title: '姓名', minWidth:100, align:"left"},
            {field: 'museunName', title: '所属组织', minWidth:200, align:'left'},
            {field: 'phone', title: '登录手机号', align:'left',minWidth:100},
            {field: 'roleName', title: '角色', align:'left',minWidth:100},
            {field: 'cTime', title: '添加时间', align:'left',minWidth:100},
            {field: 'statusName', title: '状态', align:'left',minWidth:100},
            {title: '操作', minWidth:175, toolbar:'#userListBar',align:"center",fixed:'right'}
        ]],
        done:function(){
        	
        }
    });

  
    $(".search_btn").on("click",function(){
        table.reload("userListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                userName:$("#userName").val(),
                orgId:$("#orgId").val(),
                roleId:$("#roleId").val(),
            }
        })
    });
    
    $("#resetBtn").on("click",function(){
    	tableIns.reload();
    })
    
    
    //添加用户
    function addUser(edit){
    	var tit;
    	if (edit) {
    		tit = "编辑用户";
    	} else {
    		tit = "添加用户";
    	}
        var index = layui.layer.open({
            title : tit,
            type : 2,
            area: ['80%', '700px'],
            content : [projectName + '/userManagemen/toAdd.do','no'],
            success : function(layero, index){
            	resizeLayer(index);
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                
                	body.find("#editName").val(edit.name);
                	body.find("#editOrg option[value='"+edit.orgId+"']").attr("selected",true);
                	console.log(body.find("#orgId11").length);
                	body.find("#orgId11").val(edit.orgId);
                	body.find("#phonediv").hide();
                	body.find("#editPhone").removeAttr("lay-verify");
                	body.find("#phonehide").val(edit.phone);
                	body.find("#phonehidediv").show();
                	body.find("#editEmail").val(edit.email);
                	body.find("#password").attr("placeholder","不修改就不用填写");
                	body.find("#password").removeAttr("lay-verify");
                	body.find("#repassdiv").hide();
                	body.find("#repassword").removeAttr("lay-verify");
                	body.find("#statusHide").val(edit.status);
                	body.find("#id").val(edit.id);
                	body.find("#roleDiv").show();
                	body.find("#type").val("2");
                	
                    form.render();
                }else{
                	body.find("#editOrg option[value='"+currentOrg1111+"']").attr("selected",true);
                	body.find("#orgId11").val(currentOrg1111);
                	body.find("#roleDiv").show();
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
            	/*table.reload("userListTable",{
                    page: {
                        curr: 1 //重新从第 1 页开始
                    },
                    where: {
                        userName:$("#userName").val(),
                        orgId:$("#orgId").val(),
                        roleId:$("#roleId").val(),
                    }
                })*/
            }
            
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        /*//改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })*/
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    
    function getHeadData() {
    	$.ajax({
    		type:"post",
    		url:projectName + '/userManagemen/getHeadData.do',
    		success:function(result) {
    			if (result.success == 1) {
    				var map = result.data;
    				var roleList = map.roleList;
    				var roleStr = "";
    				for(var i = 0;i < roleList.length;i++) {
    					roleStr +="<option value='"+roleList[i].id+"' >"+roleList[i].name+"</option>"
    				}
    				$("#roleId").append(roleStr);
    				
    				var orgList = map.orgList;
    				var orgStr = "";
    				for(var j = 0;j < orgList.length;j++) {
    					orgStr +="<option value='"+orgList[j].id+"' >"+orgList[j].name+"</option>"
    				}
    				$("#orgId").append(orgStr);
    				form.render();
    			}
    		}
    	})
    }
    var initForm = function() {
    	$(".hide").hide(); 
    	getHeadData();
    }
    
    initForm();
    
    

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定停用此用户？",
                btnText = "停用";
            if(_this.text()=="启用"){
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
            	$.ajax({
            		url:projectName + '/userManagemen/updataStatus.do',
            		type:"post",
            		data:{"id":data.id,"status":data.status},
            		success:function(result) {
            			if (result.success == 1) {
            				if (data.status == 1) {
            					top.layer.msg("已停用!");
            				} else {
            					top.layer.msg("已启用!");
            				} 
            				
            			} else {
            				layer.msg('系统异常', {icon: 2});
            			}
            		}
            	})
            	tableIns.reload();
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('删除后可能会影响部分数据，若账户不再使用，建议将该账户状态改为停用就即可？',{icon:3, title:'提示信息'},function(index){
                 $.get(projectName + '/userManagemen/del.do',{
                	 id : data.id  
                 },function(result){
                	if (result.success == 1) {
                		top.layer.msg("删除成功！");
                	} else {
                		top.layer.msg("系统异常删除失败");
                	}
                    tableIns.reload();
                    layer.close(index);
                 })
            });
        }
    });

})
