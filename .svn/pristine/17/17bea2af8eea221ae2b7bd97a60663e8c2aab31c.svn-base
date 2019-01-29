<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<link rel="stylesheet" type="text/css" href="designPlug-in/jd/css/list(1).css" media="all">
<link rel="stylesheet" type="text/css" href="designPlug-in/jd/css/list.css" media="all">
<link rel="stylesheet" type="text/css" href="designPlug-in/jd/css/ui-base.css" media="all">
<link rel="stylesheet" type="text/css" href="designPlug-in/My97DatePicker/skin/WdatePicker.css" />
<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var queryModel_11_="${query}";
</script>

<style>
        .openQuery{
            display: inline;
        }
        .hideQuery {
            display: none;
        }
    </style>


<div  ms-controller="query_table_main${query}${generateID}">
<div class="list-screen">
		<form method="post" name="queryTableMainForm${query}"   id="queryTableMainForm${query}" target="_self">
			<div id="queryModel_${query}11_" class=" hasBeenSelected clearfix">
			<div class="screen-top" style="position:relative;float:right;">
				&nbsp;&nbsp;
				<div class="ui action input" >
					<div type="button" class="btn btn-a" ms-click="queryData()">查询</div>
					<div type="button" class="btn btn-a"  ms-click="clearQueryData()">清除条件</div>
				</div>
				</div>
				<dl>
					<dt>已选条件：</dt>
					<dd style="" class="clearDd${query}">
						<div id="clearList_${query}11_" class="clearList"></div>
				</dd></dl>
			</div>
		</form>
			<div id="selectList${query}" class="screenBox screenBackground">
					<div id="J_searchWrap" class="w">
						<div id="J_container">
							<div id="J_selector" class="selector">
									 <div  ms-repeat-item="queryListData">
									 <input type="hidden" ms-attr-id="{{item.tiaoJianField}}" ms-attr-name="{{item.tiaoJianField}}" value="">
									<input type="hidden" ms-attr-id="{{item.tiaoJianField}}_show" ms-attr-name="{{item.tiaoJianField}}_show" value="">
										<div  class="J_selectorLine s-line s-brand" data-initial="h"  ms-attr-id="{{item.tiaoJianId}}"	 ms-class-1="{{item.showType}}">
											<div class="sl-wrap" id="pingpai" >
												<div class="sl-key">
													<span>{{item.tiaoJianName}}：</span>
												</div>
												<div class="sl-value" ms-if="!item.isinput">
													<div class="clr"></div>
													<div class="sl-v-list" >
														<ul class="J_valueList v-fixed">
															<dd>
																<input type="hidden" id="typegroupname" name="typegroupname" ms-attr-value="{{item.tiaoJianName}}">
																	<li id="brand-8557"  ms-repeat-tjitem="item.tiaoJianList" ><label>
																			<a href="javascript:;"  ms-attr-id="tiaoJianId_1111_{{item.tiaoJianField}}_{{tjitem.value}}" ms-attr-title="{{tjitem.name}}" values2="" ms-attr-typegroupid="{{item.tiaoJianField}}"  ms-attr-typename="{{tjitem.name}}" ms-attr-value="{{tjitem.value}}" values1="" ms-attr-attrval="{{tjitem.name}}">{{tjitem.name}}<i></i>
																		</a> </label></li>
															</dd>
														</ul>
														<%-- 
														<div class="sl-price"  ms-if="item.isdefined">
												            <input class="input-txt" id="priceMin" title="最低价" maxlength="6" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');">
												             <em> - </em>
												            <input class="input-txt" id="priceMax" title="最高价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');">
												            <a class="btn btn-default" id="priceBtn">确定</a>
												        </div>
												         --%>
													</div>
												</div>
												<div class="sl-value" ms-if="item.isinput">
													<div class="clr"></div>
													<div class="sl-v-list" style="height:35px">
															<dd ms-if="item.isdate==0">
																<input class="sl-inputtext-ss" type="text" ms-attr-id="{{item.tiaoJianField}}"  ms-attr-typegroupid="{{item.tiaoJianField}}"  ms-attr-typename="{{item.tiaoJianName}}" placeholder="单个条件支持模糊查询，多个条件请用“,”隔开，多个条件不支持模糊查询" ms-attr-name="{{item.tiaoJianField}}" style="width:50%;height:28px" value="">
															</dd>
															<dd ms-if="item.isdate==1">
																<input class="sl-inputtext-ss" type="text" ms-attr-id="{{item.tiaoJianField}}"  ms-attr-typegroupid="{{item.tiaoJianField}}"  ms-attr-typename="{{item.tiaoJianName}}" placeholder="多条件查询请用“,”隔开" ms-attr-name="{{item.tiaoJianField}}" style="width:47%;height:28px" value="" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
																<span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i> </span>
															</dd>
															<dd ms-if="item.isdate==2">
																<input class="sl-inputtext-ss" type="text" ms-attr-id="{{item.tiaoJianField}}"  ms-attr-typegroupid="{{item.tiaoJianField}}"  ms-attr-typename="{{item.tiaoJianName}}" placeholder="多条件查询请用“,”隔开" ms-attr-name="{{item.tiaoJianField}}" style="width:47%;height:28px" value="" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
																<span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i> </span>
															</dd>
													</div>
												</div>
												<div class="sl-ext"  ms-if="item.ismore&&!item.isinput" >
													<span ms-click="j_more(this);" style="visibility: visible;cursor:pointer;" id="geng_duo" class="sl-e-more J_extMore">更多<i></i> </span>
												</div>
											</div>
										</div>
										</div>
								<div id="J_selectorMore" class="s-more"  ms-if="queryTableMainAvalon${query}.queryCountNum>queryTableMainAvalon${query}.queryDNum" >
									<span ms-click="s_more(this);"  class="sm-wrap" id="gengduoxuanxiang"> <span style="visibility: visible;cursor:pointer;">更多条件<i></i>
									</span> </span>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
		<div reco_id="3" class="w">
			<div  >
				<div id="hotsale" class="hot-sales-main J_promGoodsWrap_46">
				</div>
			</div>
		</div>
</div>
<script type="text/javascript" src="designPlug-in/jd/js/shaixuan.js"></script>
<script type="text/javascript">

    var queryTableMainAvalon${query} = avalon.define({
        $id: "query_table_main${query}${generateID}",
        queryListData: [],//动态加载的查询条件数据
        queryCountNum: 0,//查询条件组的总数
        queryDNum: 1,//默认显示几组条件后出现更多选项的方法
        impQueryTJ: "",//传入的查询条件
        hideQueryListData:[],//隐藏的查询项
        clearReturnFunction:null,//清除查询条件时回调方法
        queryReturnFunction:null,//执行查询时回调方法
        queryfromMap:{},
        returnFormData: function () {//返回已选择的查询条件数据
        	queryTableMainAvalon${query}.queryfromMap={};//清空查询条件
        	var queryFromFieldNmae = "";
        	var jsonData = $("#queryTableMainForm${query}").serializeArray();//获取选择的条件值
        	$.map(jsonData, function (item) {
        		var iname=item.name;
        		if(!(iname.indexOf("_s111s000")!=-1)){
        			var has = item.name in queryTableMainAvalon${query}.queryfromMap;
            		var mapValue=item.value;
            		if(has){
            			var value = queryTableMainAvalon${query}.queryfromMap[iname];
            			mapValue=mapValue+","+value
            		}
            		if(!has){
            			queryFromFieldNmae=queryFromFieldNmae+","+iname;
            		}
            		queryTableMainAvalon${query}.queryfromMap[iname] = mapValue;
        		}
        	});
        	if(jsonData.length>0){
        		queryTableMainAvalon${query}.queryfromMap["queryFromFieldNmae"] = queryFromFieldNmae;	
        	}else{
        		queryTableMainAvalon${query}.queryfromMap={};//清空查询条件
        	}
        	console.log(queryTableMainAvalon${query}.queryfromMap);
        	return queryTableMainAvalon${query}.queryfromMap;
        },
        j_more: function(thisObj) {
        	var parentObj=$(thisObj).parent().parent();
        	if(parentObj.attr("class")!=null&&parentObj.attr("class")!=undefined){
        		if(parentObj.attr("class").indexOf("extend")>0){ 
        			parentObj.removeClass("extend");
        			$(thisObj).html($(thisObj).html().replace("收起","更多"));
        			$(thisObj).removeClass("opened");
            		}else{
            			parentObj.addClass("extend");
            			$(thisObj).html($(thisObj).html().replace("更多","收起"));
            			$(thisObj).addClass("opened");
            		}
        	}
        },
        s_more: function(thisObj) {
        	if($(thisObj).attr("class")!=null&&$(thisObj).attr("class")!=undefined){
        		if($(thisObj).attr("class").indexOf("opened")>0){
        			$(thisObj).removeClass("opened");
        			$(thisObj).html($(thisObj).html().replace("收起","更多条件"));
        			for(var iq=0;iq<queryTableMainAvalon${query}.hideQueryListData.length;iq++){
        				$("#"+queryTableMainAvalon${query}.hideQueryListData[iq]).addClass("hideQuery");
        			}
            		}else{
            			$(thisObj).addClass("opened");
            			$(thisObj).html($(thisObj).html().replace("更多条件","收起"));
            			for(var iq=0;iq<queryTableMainAvalon${query}.hideQueryListData.length;iq++){
            				$("#"+queryTableMainAvalon${query}.hideQueryListData[iq]).removeClass("hideQuery");
            			}
            		}
        	}
        },
        clearQueryData: function () {//清除查询条件
        	$("#queryTableMainForm${query}").find(".clearList").find(".selectedInfor").each(function(){
        		var yxValue = document.getElementById("tiaoJianId_1111_"+$(this).context.children[1].getAttribute('name')+"_"+$(this).context.children[1].defaultValue);
        		if($(this).find("em").attr("isinput")=="false"){
        			yxValue.className="";
        		}
    			$(this).remove();
    		});
        	
        if(queryTableMainAvalon${query}.clearReturnFunction!=null){
        	eval(queryTableMainAvalon${query}.clearReturnFunction);
        }
        queryTableMainAvalon${query}.queryfromMap={};
        },
        queryData: function () {//执行查询时回调方法
        	if(queryTableMainAvalon${query}.returnFormData()["queryFromFieldNmae"]!=null&&queryTableMainAvalon${query}.returnFormData()["queryFromFieldNmae"]!=undefined){
		        if(queryTableMainAvalon${query}.queryReturnFunction!=null){
		        	eval(queryTableMainAvalon${query}.queryReturnFunction);
		        }
        	}else{
        		if(queryTableMainAvalon${query}.clearReturnFunction!=null){
                	eval(queryTableMainAvalon${query}.clearReturnFunction);
                }
            	queryTableMainAvalon${query}.queryfromMap={};
            }
        },
        InitWigetData: function () {
            queryTableMainAvalon${query}.GetQueryLIST();
            //ComFunJS.initForm();
        },
        GetQueryLIST: function () {
        	//需换成动态的获取条件json数据webpage/icms/query/GetQueryLIST.json
            $.getJSON("listPageGenController.do?getQueryCondition&bussCode=${bussCode}&detailStatus=${detailStatus}",
            		{tableName:""}, function (resultData) {
                    if (resultData.success) {
                       var is=0;
                   	   var ssswwww=resultData.obj;
                        for(var i=0; i<ssswwww.length; i++)  
                        {
                        	if((i+1)>queryTableMainAvalon${query}.queryDNum){
                        		ssswwww[i]["showType"] = "hideQuery";
                        		queryTableMainAvalon${query}.hideQueryListData[is]=ssswwww[i].tiaoJianId;
                        		is++;
                        	}else{
                        		ssswwww[i]["showType"] = "openQuery";
                        	}
                        }
                        
                        //console.log(queryTableMainAvalon${query}.hideQueryListData);
                        queryTableMainAvalon${query}.queryListData=ssswwww;
                        queryTableMainAvalon${query}.queryCountNum=ssswwww.length;
                        hideStatus();
                    }
                }
              );
            //console.log(queryTableMainAvalon${query}.impQueryTJ);
            //console.log(resultData.queryListData);
        }
    });
    
    
    function hideStatus() {
    	if("true"=="${isSelect}"){
    		$("[id^='status_']").remove();
    		/**
    		$("[id^='status_']").find("li").each(function(i,o){
    			var typegroupid =$(o).find("a").attr("typegroupid");//
    			var statusValue=$(o).find("a").attr("value");
    			if(typegroupid.indexOf("t_b_cul_borrow_main")!=-1){
    					$(o).remove();
    			}
    		  });
    		*/
    	}
    };
    
    
    
</script>		
		