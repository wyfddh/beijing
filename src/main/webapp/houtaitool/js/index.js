//var projectPath = "http://localhost:8081/admin";
var pathName=window.document.location.pathname;
var projectPath=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var main = {
  form: {},
  table: {},
  element: {},
  load: function (table, form, element) {
    this.form = form;
    this.table = table;
    this.element = element;
    this.initTable();
    this.bindEvent();
    this.initElement();
    this.getSelectData();
    this.getHeadData();
  },
  GetQueryString: function(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null) {
		return  unescape(r[2]); 
	} else {
		return null;
	}
  },
  getCookie:function(name) {
	  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	    if(arr !=null) {
	    	return unescape(arr[2]);
	    } else {
	    	return null;
	    } 
  },
  initTable: function () {
    var _this = this;
    
    
    //var storage=window.localStorage;
    //orgId = storage.org;
   
    //orgId = $.cookie('org');
    orgId=sessionStorage.getItem('org');
    
    title = "一普库";
    var insTable = _this.table.render({
      elem: '#collection'
      , id: "collectionTable"
      , url: projectPath + '/collectionInfo/getCollectionInfoList.do'
      , title: title
      , toolbar: '#collectiontoolbar'
      , request: {
        pageName: 'currentPage',
        limitName: 'size'
      }
      , limits: [10, 15, 20, 50]
      , limit: 20
      , cols: [[
          {type: 'checkbox',width:"4%"}
        , {title: '操作', toolbar: '#barDemo',width:"18%"}
//        , {type: 'numbers',title: '序号',width:80}
        , {field: 'collectionName', title: '文物藏品名称',width:"22%"}
        , {field: 'collectionOldName', title: '藏品原名'}  
        , {field: 'generalSurveyNum', title: '一普数据编号'}
        , {field: 'collectionYearTypeName', title: '年代',width:"8%"}
        , {field: 'containCollectionCount', title: '文物藏品数量（件/套）',width:"12%"}
        , {field: 'collectionCategoryName', title: '藏品类别',width:"10%"}
        , {field: 'collectionTextureName', title: '藏品质地',width:"9.7%"}
        , {field: 'collectionLevelName', title: '文物级别',width:"7%"}
        , {field: 'collectionComeFromName', title: '文物来源'}             
        , {field: 'exhibitingName', title: '是否在展',width:"8%"}
        , {field: 'collectionOrgName', title: '收藏单位',width:"10%"}
        , {field: 'address', title: '单位地址'}
        
      ]]
      , page: true
      , where:{
        repertoryState:"1",
        screenState:"1",
        autoCheck:"1",
        orgId:orgId
      },done: function(res, curr, count){
    	$("#totalNum").text(count);
        $("[data-field='generalSurveyNum']").css('display','none');
        
        $("[data-field='address']").css('display','none');
        $("[data-field='collectionOldName']").css('display','none');
        $("[data-field='collectionComeFromName']").css('display','none');
        var repertoryState = $("#repertoryState").val();
        if (repertoryState == 1) {
        	$("[data-field='exhibitingName']").css('display','none');
        	$("[data-field='collectionLevelName']").css('width','100px');    
        } else if (repertoryState == 2) {
        	//$("[data-field='collectionName']").find(".").css('width','300px');
        }  
        //判断org级别
//        if (res.msg == 2) {
//        	$("[data-field='address']").css('width','300px');
//        } else {
//        	$("[data-field='address']").css('width','120px');
//        }
        if (res.msg == 2) {
        	$("[data-field='collectionOrgName']").css('display','none');
        	$("[data-field='collectionLevelName']").css('width','300px');   
        	$("#filterSubmit").removeClass("layui-hide");
        } else if (res.msg == 1) {
        	$("#getSubmitList").removeClass("layui-hide");  
        }
        
        $('.layui-table-tool-self').hide();
      }
    });
    //监听复选框数量
    _this.table.on('checkbox(collection)', function(obj){
      var checkboxNum = $("#checkboxNum").text();
      if (checkboxNum >= 0) {
        if (obj.type == "one") {
          if (obj.checked) {
            checkboxNum++;
          } else {
            checkboxNum--;
          }
        } else {
          if (obj.checked) {
            checkboxNum = _this.table.cache.collectionTable.length;
          } else {
            checkboxNum = 0;
          }
        }
      }
      $("#checkboxNum").text(checkboxNum);
    });

    //头工具栏事件
    _this.table.on('toolbar(collection)', function (obj) {
      var checkStatus = _this.table.checkStatus(obj.config.id);
      var data = checkStatus.data;

      switch (obj.event) {
        case 'batchSure':
          var arr1 = new Array;
          for(var i=0;i<data.length;i++){
            arr1.push(data[i].id);
          }
          if (arr1.length > 0) {
            var jsonData = {"arr1":arr1,"state":"4"};
            _this.modifyData(jsonData);
          } else {
            top.layer.msg("至少选择一项数据！")
          }
          break;
        case 'batchHandle':
          var arr1 = new Array;
          var arr2 = new Array;
          var allObj = _this.table.cache.collectionTable;
          if (data.length == 0) {
            for(var k=0;k<allObj.length;k++){
              arr2.push(allObj[k].id);
            }
          } else {
            for (var i = 0;i < allObj.length;i++) {
              for (var j = 0;j < data.length;j++) {
                if (allObj[i].id == data[j].id) {
                  arr1.push(data[j].id);
                  break;
                }
                if (j == data.length - 1) {
                  if (allObj[i].id != data[j].id) {
                    arr2.push(allObj[i].id);
                  }
                }
              }
            }
          }
          var jsonData = {"arr1":arr1,"arr2":arr2,"state":"1"};
          _this.modifyData(jsonData);
          break;
        case 'batchExclude':
          var arr1 = new Array;
          for(var i=0;i<data.length;i++){
            arr1.push(data[i].id);
          }
          if (arr1.length > 0) {
            var jsonData = {"arr1":arr1,"state":"3"};
            _this.modifyData(jsonData);
          } else {
            top.layer.msg("至少选择一项数据！")
          }
          break;
        case 'batchLike':
          var arr1 = new Array;
          for(var i=0;i<data.length;i++){
            arr1.push(data[i].id);
          }
          if (arr1.length > 0) {
            var jsonData = {"arr1":arr1,"state":"2"};
            _this.modifyData(jsonData);
          } else {
            top.layer.msg("至少选择一项数据！")
          }
          break;
        case 'batchExhibiting':
          var arr1 = new Array;
          for(var i=0;i<data.length;i++){
            if (data[i].dataState == 4) {
              arr1.push(data[i].id);
            }
          }
          if (arr1.length > 0) {
            var jsonData = {"arr1":arr1,"state":"1"};
            _this.exhibiting(jsonData);
          } else {
            top.layer.msg("至少选择一项数据！")
          }
          break;
        case 'batchExport':
          $(".daochuList").toggleClass("show");
          $(".daochuList li").off().on('click', function (e) {
            stopBubble(e);
            if ($(this).index() == 0) {
              _this.table.exportFile(insTable.config.id, data,'xls');
              return false;
            } else if ($(this).index() == 1) {
              var allData = _this.table.cache.collectionTable;
              _this.table.exportFile(insTable.config.id, allData,'xls');
              return false;
            } else {
//              window.location.href=projectPath + '/collectionInfo/batchExport.do';

              return false;
            }
          });
          break;
        case 'filterSubmit':
    	  layui.layer.confirm('您已全部筛选完成！', {
    		  btn: ['确定','取消'] //按钮
    		}, function(index){
    			$.ajax({ 
    				url:projectPath + '/collectionInfo/filterSubmit.do',
    				type:'post',
    				data:{"orgId":orgId},
    				success:function(res) {
    					if (res.success == 1) {
    						layer.msg('提交成功！', {icon: 1});
    					} else {
    						layer.msg(res.data, {icon: 2});
    					}
    				}
    			})
    		}, function(index){
    		  
    		});
    	  
    	  break;
        case 'getSubmitList':
        	sessionStorage.setItem("orgId",orgId);
        	var index = layui.layer.open({
        		title:'完成筛选情况列表',
                type : 2,  
                area: ['70%', '740px'],
                content : ['submitList.html','yes'],
                success : function(layero, index){
                   
                }
                
            })
          return false;
      }
    });

    //监听行工具事件
    _this.table.on('tool(collection)', function (obj) {
      var data = obj.data;
      if (obj.event === 'sure') {
        var arr1 = new Array;
        arr1.push(data.id);
        var jsonData = {"arr1":arr1,"state":"4"};
        _this.modifyData(jsonData);
      } else if (obj.event === 'exclude') {
        var arr1 = new Array;
        arr1.push(data.id);
        var jsonData = {"arr1":arr1,"state":"3"};
        _this.modifyData(jsonData);
      } else if (obj.event === 'like') {
        var arr1 = new Array;
        arr1.push(data.id);
        var jsonData = {"arr1":arr1,"state":"2"};
        _this.modifyData(jsonData);
      } else if (obj.event === 'detail') {

        localStorage["dataId"]=JSON.stringify(data.id);
        var index = layui.layer.open({
          title : "查看藏品",
          type : 2,
          area: ['70%', '740px'],
          content : ["detail.html"],
          success : function(layero, index){
        	  resizeLayer(index);
          },
          end :function() {
            
          }
        })
        // layui.layer.full(index);
      } else if (obj.event === 'exhibiting') {
        var arr1 = new Array;
        if (data.dataState == 4) {
          arr1.push(data.id);
          var jsonData = {"arr1":arr1,"state":"1"};
          _this.exhibiting(jsonData);
        } else {
          top.layer.msg("数据异常！");
        }
      } else if (obj.event === 'noexhibiting') {
        var arr1 = new Array;
        if (data.dataState == 4) {
          arr1.push(data.id);
          var jsonData = {"arr1":arr1,"state":"0"};
          _this.exhibiting(jsonData);
        } else {
          top.layer.msg("数据异常！");
        }
      }
    });

  },
 
  //是否在展
  exhibiting:function(data) {
    var that=this;
    $.ajax({
      type:'post',
      data:data,
      url:projectPath + '/collectionInfo/exhibiting.do',
      success:function(res) {
        if (res.success == 1) {
          top.layer.msg("操作成功！");
        } else {
          top.layer.msg("操作失败！");
        }
        that.reloadTable();
        that.getHeadData();
        $("#checkboxNum").text("0");
      }
    })
  },
  //修改数据状态
  modifyData:function(data) {
    var that=this;
    $.ajax({
      type:'post',
      data:data,
      url:projectPath + '/collectionInfo/modifyState.do',
      success:function(res) {
        if (res.success == 1) {
          top.layer.msg("操作成功！");
        } else {
          top.layer.msg("操作失败！");
        }
        that.reloadTable();
        that.getHeadData();
        $("#checkboxNum").text("0");
      }
    })
  },
  //获取下拉框数据
  getSelectData: function () {
    var that = this;
    var params = {
      arr: ['exhibiting', 'degree_disability', 'collection_come_from',
        'save_state', 'collection_texture']
    };
    $.ajax({
      data: params,
      type: 'post',
      url: projectPath + '/collectDict/getSelectDataByArr.do',
      success: function (data) {
        that.initSelect("#collectionTexture", data.data.collection_texture);
        that.initSelect("#degreeDisability", data.data.degree_disability);
        that.initSelect("#collectionComeFrom", data.data.collection_come_from);
        that.initSelect("#saveState", data.data.save_state);
        that.initSelect("#exhibiting", data.data.exhibiting);
        //that.initSelect("#org",data);
      }
    });
    //获取组织
    $.ajax({
      type:'post',
      data:{"orgId":orgId},
      url:projectPath + '/collectDict/getOrg.do',
      success:function(res) {
        if (res.success == 1) {
          var orgList = res.data;
          var orgStr = "";
          for (var i = 0;i < orgList.length;i++) {
            orgStr +="<option value='"+orgList[i].orgId+"' >"+orgList[i].orgName+"</option>"
          }
          $("#org").append(orgStr);
          that.form.render();
        }
      }
    })

  },
  //初始下拉框数据
  initSelect: function (obj, data) {
    // $(obj).empty();
    $.each(data, function (i, elm) {
      var str = "<option value='" + elm.dictCode + "'>" + elm.dictName
          + "</option>";
      $(obj).append(str);
    });
    this.form.render();

  },
  initElement: function () {
    layui.use('element', function () {
      var element = layui.element;


    });


    //监听提交
    this.form.on('submit(formDemo)', function (data) {
      layer.msg(JSON.stringify(data.field));
      return false;
    });

  },
  //绑定tab切换
  bindEvent: function () {
    var _this = this;
    //查询按钮
    $("#searchimg").on('click', function () {

    });
    _this.element.on('tab(docDemoTabBrief)', function(data){
      var layId = this.getAttribute('lay-id');
      if (layId === "a1") {
        $("#repertoryState").val("1");
        $("#checkboxNum").text("0");
        clearData();
        var screenState = $("#screenState").val();
        if (screenState == 1) {
        	title = "一普库待筛选数据";
        } else if (screenState == 2) {
        	title = "一普库疑似数据";
        } else if (screenState == 3) {
        	title = "一普库排除数据";
        }
        _this.getHeadData();
        _this.reloadTable();
        $("[data-field='exhibitingName']").css('display','none');
         
        $("#batchSure").show();
        $("#batchHandle").show();
        $("#batchExhibiting").hide();
        $("#exhibitingDiv").hide();
        _this.form.render();
      } else if (layId === "a2") {
        $("#repertoryState").val("2");
        $("#checkboxNum").text("0");
        clearData();
        title = "革命库数据";
        
        _this.getHeadData();
        _this.reloadTable();
        $("#batchSure").hide();
        $("#batchHandle").hide();
        $("#batchExhibiting").removeClass("layui-hide");
        $("[data-field='exhibitingName']").css('display','table-cell');
//        $("[data-field='address']").css('width','140px');
        $("[data-field='collectionName']").css('width','300px');
        $("#exhibitingDiv").removeClass("layui-hide");
        _this.form.render();
        
      }
    });
    _this.element.on('tab(optionTabBrief)', function(data){
      var layId = this.getAttribute('lay-id');
      if (layId === "b1") {
        $("#screenState").val("1");
        $("#checkboxNum").text("0");
        clearData();
        title = "一普库待筛选数据";
      } else if (layId === "b2") {
        $("#screenState").val("2");
        $("#checkboxNum").text("0");
        clearData();
        title = "一普库疑似数据";
      } else if (layId === "b3") {
        $("#screenState").val("3");
        $("#checkboxNum").text("0");
        clearData();
        title = "一普库排除数据";
      }
      _this.getHeadData();
      _this.reloadTable();
      
    });

    function clearData() {
    	$("#collectionCategory").val("");
        $("#collectionYearType").val("");
        $("#collectionLevel").val("");
    }
    _this.form.on('select',function(data) {
      _this.reloadTable();
    });
    _this.form.on('switch(switch)', function(data){
      var checkState = data.elem.checked;
      if (checkState) {
        $("#autoCheck").val("1");
      } else {
        $("#autoCheck").val("0");
      }
      _this.getHeadData();
      _this.reloadTable();
    });

    //查看更多
    $(".getMore").on('click', function () {
      var elm = $(this).siblings("ul");
      if($(this).text()=="更多>"){
    	  $(this).text("收起>")
      }else{
    	  $(this).text("更多>")
      }
      elm.toggleClass("active");
      
     
        
    });
    
    $(".zhankai").on('click',function () {
        if($(".zhankai1").hasClass("cur")){
            $(".zhankai1").removeClass("cur");
            $(".zhankai2").addClass("cur");
            $(".typeCont").hide();
            $(".yearCont").hide();
            $(".levelCont").hide();
            $(".search .layui-form-item").css({"margin-top":"0"});
        }else{
            $(".zhankai1").addClass("cur");
            $(".zhankai2").removeClass("cur");
            $(".typeCont").show();
            $(".yearCont").show();
            $(".levelCont").show();
            $(".search .layui-form-item").css({"margin-top":"20px"});
        }
    })
    //搜索按钮事件
    $("#searchBtn").on('click', function () {
      _this.reloadTable();
    });
    $(document).keyup(function(event){
    	  if(event.keyCode ==13){
    		  _this.reloadTable();
    	  }
    	});

    document.addEventListener('click', function (e) {
      if (!$(e.target).hasClass("daochuList") && !$(e.target).hasClass(
              "daochu")) {
        $(".daochuList").removeClass("show");
      }
      return false
    })
  },
  //获取头部数据
  getHeadData:function(collectionCategory,collectionYearType) {
    function isEmpty(obj){
      if(typeof obj == "undefined" || obj == null || obj == "")	{
        return true;
      }else{
        return false;
      }
    }
    var that=this;
    var autoCheck = $("#autoCheck").val();
    var repertoryState = $("#repertoryState").val();
    var screenState = $("#screenState").val();
    var data = {"repertoryState":repertoryState,"screenState":screenState,
      "collectionCategory":collectionCategory,"collectionYearType":collectionYearType,"orgId":orgId,"autoCheck":autoCheck};
    $.ajax({
      type:'post',
      data:data,
      url:projectPath + '/collectionInfo/getTabData.do',
      success:function(res) {
        if (res.success == 1) {
          var map = res.data;
          $(".layui-tab-brief li").eq(0).find(".num").text(map.countDto.yipuCount);
          $(".layui-tab-brief li").eq(1).find(".num").text(map.countDto.revolutionCount);
          $(".layui-tab-skin li").eq(0).find(".num").text(map.countDto.screenCount);
          $(".layui-tab-skin li").eq(1).find(".num").text(map.countDto.likeCount);
          $(".layui-tab-skin li").eq(2).find(".num").text(map.countDto.excludeCount);
        }
      }
    });
    $.ajax({
        type:'post',
        data:data,
        url:projectPath + '/collectionInfo/getCollectionCategoryHead.do',
        success:function(res) {
          if (res.success == 1) {
            var map = res.data;
            if (isEmpty(collectionCategory)) {
              that.initHead(".typeList",map.categoryList,1);
            }
          }
        }
      });
    $.ajax({
        type:'post',
        data:data,
        url:projectPath + '/collectionInfo/getYearTypeHead.do',
        success:function(res) {
          if (res.success == 1) {
            var map = res.data;
            
            if (isEmpty(collectionYearType)) {
              that.initHead(".yearList",map.yearTypeList,2);
            }
            
           
          }
        }
      });
    $.ajax({
        type:'post',
        data:data,
        url:projectPath + '/collectionInfo/getLevelHead.do',
        success:function(res) {
          if (res.success == 1) {
            var map = res.data;
            
            that.initHead(".levelList",map.levelList,3);
           
          }
        }
      });
    
  },
  //初始化头部数据
  initHead:function (obj,data,type) {
    var that=this;
     if(type==1){
       $(obj).empty();
       var str1="<li class='typeItem active' data=''><span>全部</span><span class='ml10'>(</span><span class='num'></span><span>)</span></li>";
       $(obj).prepend(str1);
       var typeCount = 0;
       $.each(data,function (i,elm) {
         var str="<li class='typeItem' data='"+elm.id+"'><span>"+elm.name+"</span><span class='ml10'>(</span><span class='num'>"+elm.collectCount+"</span><span>)</span></li>"
         /*$(elm).find(".num").text(data[i].collectCount);
         $(elm).attr("data",data[i].id);*/
         typeCount+=elm.collectCount;
         $(obj).append(str);
       });
       $(".typeList li").eq(0).find(".num").text(typeCount);
       that.form.render();
     }else if(type==2){
       $(obj).empty();
       var str1="<li class='yearItem active' data=''><span>全部</span><span class='ml10'>(</span><span class='num'>2400</span><span>)</span></li>";
       $(obj).prepend(str1);
       var yearCount = 0;
       $.each(data,function (i,elm) {
         var str="<li class='yearItem' data='"+elm.code+"'><span>"+elm.name+"</span><span class='ml10'>(</span><span class='num'>"+elm.collectCount+"</span><span>)</span></li>"
         /*$(elm).find(".num").text(data[i].collectCount);
          $(elm).attr("data",data[i].id);*/
         yearCount+=elm.collectCount;
         $(obj).append(str);
       });
       $(".yearList li").eq(0).find(".num").text(yearCount);
       that.form.render();
     }else{
       $(obj).empty();
       var str1="<li class='levelItem active' data=''><span>全部</span><span class='ml10'>(</span><span class='num'>2400</span><span>)</span></li>";
       $(obj).prepend(str1);
       var levelCount = 0;
       $.each(data,function (i,elm) {
         var str="<li class='levelItem' data='"+elm.dictCode+"'><span>"+elm.dictName+"</span><span class='ml10'>(</span><span class='num'>"+elm.collectCount+"</span><span>)</span></li>"
         /*$(elm).find(".num").text(data[i].collectCount);
          $(elm).attr("data",data[i].id);*/
         levelCount+=elm.collectCount;
         $(obj).append(str);
       });
       $(".levelList li").eq(0).find(".num").text(levelCount);
       that.form.render();
     }
    //li点击事件
    $(".search li").off().on('click', function () {
      if ($(this).hasClass("active")) {
      } else {
        $(this).addClass('active').siblings().removeClass('active');
        var ulClass = $(this).parent().attr("class");
        if ($(this).parent().hasClass("typeList")) {
          var typeData = $(this).attr("data");
          $("#collectionCategory").val(typeData);
          $("#collectionYearType").val("");
          $("#collectionLevel").val("");
          that.getHeadData(typeData);
          that.reloadTable()
        } else if ($(this).parent().hasClass("yearList")) {
          var yearData = $(this).attr("data");
          var typeData = $("#collectionCategory").val();
          $("#collectionYearType").val(yearData);
          $("#collectionLevel").val("");
          that.getHeadData(typeData,yearData);
          that.reloadTable()
        } else if ($(this).parent().hasClass("levelList")) {
          var levelData = $(this).attr("data");
          $("#collectionLevel").val(levelData);
          that.reloadTable()
        }
      }
    });
  },
  //重载表格
  reloadTable : function() {
    var _this = this;
    _this.table.reload("collectionTable", {
      page: {
        curr: 1 //重新从第 1 页开始
      },
      title:title,
      where: {
        key: $("#key").val(),
        collectionTexture: $("#collectionTexture").val(),
        degreeDisability: $("#degreeDisability").val(),
        exhibiting: $("#exhibiting").val(),
        collectionComeFrom:$("#collectionComeFrom").val(),
        saveState: $("#saveState").val(),
        org: $("#org").val(),
        screenState: $("#screenState").val(),
        repertoryState: $("#repertoryState").val(),
        collectionCategory: $("#collectionCategory").val(),
        collectionYearType: $("#collectionYearType").val(),
        collectionLevel: $("#collectionLevel").val(),
        autoCheck: $("#autoCheck").val(),
        orgId:orgId
      }
    });
    var repertoryState = $("#repertoryState").val()
    if (repertoryState == 2) {
    	$("#batchSure").hide();
        $("#batchHandle").hide();
        $("#batchExhibiting").removeClass("layui-hide"); 
    } else if (repertoryState == 1){
    	$("#batchExhibiting").hide();
    	var screenState = $("#screenState").val()
    	if (screenState == 1) {
    		$("#batchSure").show();
            $("#batchHandle").show();
    	} else if (screenState == 2) {
    		$("#batchLike").hide();
    	} else if (screenState == 3) {
    		$("#batchExclude").hide();
            $("#batchHandle").hide();
    	}
    	
        
    }
    return false;
  }
};

$(function () {
  layui.use(['form', 'table', 'element'], function () {
    var table = layui.table, element = layui.element;
    form = layui.form;
    main.load(table, form, element);
  })
});
function stopBubble(e){

  if(e && e.stopPropagation)

    e.stopPropagation()

  else

    window.event.cancelBubble = true

}

