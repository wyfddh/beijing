/*****
icms常用函数
*/

/**
 * @Title: 时间转换字符串（格式：yyyy-MM-dd）
 * @author longb
 * @date 2016-04-14
 */
 var isDisabledto=false;
var defineBianKuangCss="border:1px solid #CBCDCE;";
var defineDetailBianKuangCss="border:1px solid #CBCDCE;";
function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

//获得form中各属性的，属性名：属性值
function getIcmsFromMap(fromId){
	
	var jsonData = $("#"+fromId).serializeArray();
	var fromMap={};
	var fromFieldNmae = "";
	$.map(jsonData, function (item) {
		var iname=item.name;
			var has = item.name in fromMap;
    		var mapValue=item.value;
    		if(has){
    			var value = fromMap[iname];
    			mapValue=mapValue+","+value
    		}
    		if(!has){
    			fromFieldNmae=fromFieldNmae+","+iname;
    		}
    		fromMap[iname] = mapValue;
	});
	//console.log(fromMap);
	return fromMap;
}
/**
 * 确认窗口
 * @param content
 * @param yes
 * @param no
 * @param windowapi
 */
function myConfirmDialog(content,yes,no,windowapi){
	layer.confirm(content, {
		  icon: 3,
		  btn: ['确认','关闭'] //按钮
		}, yes,no);
}

/**
 * 获取光标提示消息
 * @param thisa
 */
function Validformfocusin(thisa){
	//if($(thisa).attr("errormsg")=="\"null\"") return false;
	//var vl= $(thisa).parent().find(".Validforminfo");
	//vl.remove();
	//var objtiphtml="";
	//objtiphtml+="<div class='Validforminfo_ss' style='display: block;position: absolute;top: -36px;z-index: 2;width:215px'>";
	//objtiphtml+=$(thisa).attr("errormsg");
	//objtiphtml+="<span class='dec'>";
	//objtiphtml+="<s class='dec1'>◆</s>";
	//objtiphtml+="<s class='dec2'>◆</s>";
	//objtiphtml+="</span>";
	//objtiphtml+="</div>";
	//if($(thisa).attr("errormsg")!=""){
	//	$(thisa).parent().append(objtiphtml);
	//}
}
/**
 * 失去光标提示消息
 * @param thisa
 */
function Validformfocusout(thisa){
	//var vl= $(thisa).parent().find(".Validforminfo_ss");
	//$(thisa).css("background-color","#FFFFFF")
	//vl.remove();
	try{
		alertMonitorData();
	}catch(e){
		
	}
}
	
	
//点击左箭头
   function psPrev(liheight,uiid,thisa) {
    	var ximgHeight =$("#"+uiid).height();
    	var ximgtop=$("#"+uiid).position().top;
    	if($(thisa).attr("class").indexOf("disabled")>0){ 
    			return false;
   		}
    	$(thisa).parent().find(".ps-next").removeClass("disabled");
    	if((ximgtop+liheight)==0){
			$(thisa).addClass("disabled");
		}
    	$("#"+uiid).css("top",(ximgtop+liheight)+"px");
    }
   
   //点击右箭头
    function psNext(liheight,uiid,thisa) {
    	var ximgHeight =$("#"+uiid).height();
    	var ximgtop=$("#"+uiid).position().top;
    	if(liheight==ximgHeight){
    		$(thisa).addClass("disabled");
    	}
   		if($(thisa).attr("class").indexOf("disabled")>0){ 
   			return false;
   		}
   		$(thisa).parent().find(".ps-prev").removeClass("disabled");
    		if(((ximgtop-liheight)-liheight+ximgHeight)==0){
    			$(thisa).addClass("disabled");
    		}
    		$("#"+uiid).css("top",(ximgtop-liheight)+"px");
    }
    
    /***
     * 显示和隐藏左右箭头
     */
    function InitializePrevOrNext() {
    	setTimeout("InitializePrevOrNext1()",2000); 
	}
    
    
    /**
     * 初始化左右箭头的方法
     */
    function InitializePrevOrNext1() {
    	$(document).find("div[isPrevOrNext]").each(function(index){
    		var prevOrNext=$(this).attr("isPrevOrNext");
    		var prevOrNexts=prevOrNext.split("|");
    		var height_1_ =$("#"+prevOrNexts[0]).height();
    		if(height_1_>prevOrNexts[1]){
    			$(this).find(".ps-prev").show();
    			$(this).find(".ps-next").show();
    		}else{
    			$(this).find(".ps-prev").hide();
    			$(this).find(".ps-next").hide();
    		}
    	});
    }
    
    
    /**
     * 数据字典选择方法
     * @param typegroupCode
     * @param codeId
     * @param codeNameId
     * @param fieldHref
     */
    function goSelectSysCode(typegroupCode,codeId,codeNameId,fieldHref) {
    	var width="300px",height="400px";
    	var url="tBCommQueryController.do?goSelectSysCode&typegroupCode="+typegroupCode;
    	 var ss="";
    	if(fieldHref!=""&&fieldHref!=null){
    		url=fieldHref;
    		 //ss="1";
			  if(fieldHref.indexOf("user")!=-1||fieldHref.indexOf("users")!=-1){
				  ss="2";
			  }
			  if(fieldHref.indexOf("depart")!=-1||fieldHref.indexOf("depart")!=-1){
				  ss="1";
			  }
			  if(fieldHref.indexOf("tBCrbcEbaseController.do?enterpriseSelect")!=-1){
				  var enterpriseId=$("#t_b_crbc_erevoke\\@BUSINESS_ID").val();
				  url+="&enterpriseId="+enterpriseId;
			  }
			  //库位选择
			  if(fieldHref.indexOf("getKWEntity")!=-1){
				  var xb = codeId.split("[")[1].split("]")[0];
				  var kf = document.getElementById("t_b_cul_iv_detail[" + xb + "].B0215");
				  if(kf){
					  if(kf.value==""){
						  layer.msg('请先选择库房！', {icon: 5});
						  return true;
					  }
					  url = url + "%26parentId%3D" +kf.value;
				  }
			  }
			  if(fieldHref.indexOf("tBCrbcEbaseA")!=-1){
				  width="1200px",height="600px";
			  }
    	}
    	layer.open({
 			  type: 2,
 			  title: "请选择",
 			  maxmin: true,
 			  shadeClose: true, //点击遮罩关闭层
 			  area : [width , height],
 			  content: url,
 			  btn: ['确定','清空','关闭'],
 			  yes: function(index, layero){
 				  	var codeIdVal = layer.getChildFrame('#codeId'+ss, index).attr("value");
 				  	
 					if (codeIdVal==null||codeIdVal == "") {
 						layer.msg('请选择！', {icon: 5});
						return true;
 					}else{
 						var isParentIdVal = layer.getChildFrame('#isParentId'+ss, index).attr("value");
 						//alert(isParentIdVal);
 						if (isParentIdVal==null||isParentIdVal == "true") {
 							layer.msg('请选择最末级节点！', {icon: 5});
 							return true;
 						}
 						document.getElementById(codeId).value=layer.getChildFrame('#codeId'+ss, index).attr("value");
 						document.getElementById(codeNameId).value=layer.getChildFrame('#codeNameId'+ss, index).attr("value");
 						layer.close(index); //如果设定了yes回调，需进行手工关闭
 					}
 			  },btn2: function(index, layero){
 				document.getElementById(codeId).value="";
				document.getElementById(codeNameId).value="";
				layer.close(index); //如果设定了yes回调，需进行手工关闭
 			  },btn3: function(index, layero){
 				 layer.close(index); //如果设定了yes回调，需进行手工关闭
 			  },cancel: function(){ 
 				//alert(4);
 			  }
 		});
     }
    
    /**
     * 选择部门或者部门下用户的方法
     * @param codeId
     * @param codeNameId
     * @param selectType
     * @param windowapi
     */
    function goSelectDepartOrUser(codeId,codeNameId,selectType,windowapi) {
  	   var swidth=300,sheight=400;
  	   if(selectType=="user"||selectType=="users"){
  		 swidth=350;
  		 sheight=350;
  	   }
  	   
  	 layer.open({
		  type: 2,
		  title: "请选择",
		  maxmin: true,
		  shadeClose: true, //点击遮罩关闭层
		  area : [swidth+'px' , sheight+'px'],
		  content: 'departController.do?departSelect&selectType='+selectType,
		  btn: ['确定','清空','关闭'],
		  yes: function(index, layero){
			  var ss="1";
			  if(selectType=="user"||selectType=="users"){
				  ss="2";
			  }
			 var codeIdVal = layer.getChildFrame('#codeId'+ss, index).attr("value");
				if (codeIdVal==null||codeIdVal == "") {
					layer.msg('请选择！', {icon: 5});
					return true;
				}else{
					document.getElementById(codeId).value=layer.getChildFrame('#codeId'+ss, index).attr("value");
					document.getElementById(codeNameId).value=layer.getChildFrame('#codeNameId'+ss, index).attr("value");
					layer.close(index); //如果设定了yes回调，需进行手工关闭
				}
		  },btn2: function(index, layero){
			document.getElementById(codeId).value="";
			document.getElementById(codeNameId).value="";
			layer.close(index); //如果设定了yes回调，需进行手工关闭
		  },btn3: function(index, layero){
			 layer.close(index); //如果设定了yes回调，需进行手工关闭
		  },cancel: function(){ 
			//alert(4);
		  }
		});
    }
    
    
   function showUserInfo(swidth,sheight) {
   	   layer.open({
 		  type: 2,
 		  title: "用户信息",
 		  maxmin: true,
 		  shadeClose: true, //点击遮罩关闭层
 		  area : [swidth+'px' , sheight+'px'],
 		  content: 'userController.do?userinfo',
 		  btn: ['关闭'],cancel: function(){ 
 		  }
 		});
    }
    
    function editUserInfo(swidth,sheight) {
	   layer.open({
		   type: 2,
		   title: "修改用户密码",
		   maxmin: true,
		   shadeClose: true, //点击遮罩关闭层
		   area : [swidth+'px' , sheight+'px'],
		   content: 'userController.do?changepassword',
		   btn: ['确定','关闭'],
		   yes: function(index,layero){
			   var form1= layer.getChildFrame('form', index);
			   //form1.submit();
			   /**$(form1).submit(function(data) {
				   	alert(data);
	                alert("submit");
	                return false;
	            });
			   */
			    //alert($(form1).serialize());
	            $.ajax({
	                type: "POST",
	                dataType: "html",
	                url: "userController.do?savenewpwd",
	                data: $(form1).serialize(),
	                success: function (data) {
	                	layer.msg('操作成功！', {icon: 1});
	                	//alert('操作成功');
	                },
	                error: function(data) {
	                	layer.msg("error:"+data.responseText, {icon: 5});
	                    //alert("error:"+data.responseText);
	                }
	            });
		   	},
		   	cancel: function(){}
  		});
    }
    
    function updateIndexTableDate(busscode,mainId) {
    	$.ajax({
			async : false,
			cache : false,
			type : "POST",
			url : "tBCulCoreCommonController.do?updateIndexTableDate&mainId="+mainId+"&busscode="+busscode,// 请求的action路径
			error : function() {// 请求失败处理函数
			},
			success : function(data) {
				var data0=eval("("+data+")");
			}
		});
   	 }
    
    
    
    /**
     * 明细数据Title  html组装方法
     * @param detailTitleData
     * @param detailTitleDataHtmlId
     */
    function detailTitleDataHtml(detailTitleData,detailTitleDataHtmlId) {
    	var culIndexHtml = "";
		if (detailTitleData.length > 0) {
			culIndexHtml+="<th   align='center'>序号</th>";
			culIndexHtml += "<th width=\"5%\" align='center'> ";
			culIndexHtml += "选择";
			culIndexHtml += "</th>";
			$(detailTitleData).each(function(i, val) {
				$(val.trData).each(function(ii, val1) {
					culIndexHtml += "<th";
					if (val1.isShow == "N"&&val1.isHide == "Y") {
						culIndexHtml += "style=\"display: none;\"  ";
					}
					culIndexHtml += " >"+ val1.indexName+ "</th>";
				});
			});
		}
		$("#"+detailTitleDataHtmlId).html(culIndexHtml);
    }
    
    /**
     * 明细行数据body  html组装方法
     * @param detailTitleData
     * @param detailTitleDataHtmlId
     */
    function detailDataListHtml(detailListData,detailDataListHtmlId) {
    	var culIndexHtml = "";
		if (detailListData.length > 0) {
			$(detailListData).each(function(i, val) {
				culIndexHtml += "<tr  >";
				culIndexHtml+="<td   align='center'>"+(i+1)+"</td>";
				culIndexHtml += "<td>";
				culIndexHtml += "<input detailid='"+detailListData[i].ID+"'  type=\"checkbox\">";
				culIndexHtml += "</td>";
				
				var countWidth=0;//算出需要显示的总宽度，用于计算宽度
				$(val.trData).each(function(i,valqq) {
					if(valqq.isShow!="N"&&valqq.isShow!=""){
						countWidth=(parseInt(countWidth)+parseInt(valqq.dataLength));
					}
				});
				
				$(val.trData).each(function(ii, val1) {
					culIndexHtml += "<td  ";
					if (val1.isShow == "Y"&&val1.isHide == "Y") {
						culIndexHtml += "style=\"display: none;\"";
					}
					culIndexHtml += ">";
					if(!isDisabledto){
						if ((val1.codeType!=""||val1.fieldHref!="")&&val1.isEdit == "Y") {//如果是编辑类型并且是选择类型
							culIndexHtml+="<input  style='width:80%;'  type='hidden'  id='"+val1.isEditFormField+"' name='"+val1.isEditFormField+"' value='"+val1.value+"'>";
							culIndexHtml+="<input  placeholder='请选择'  onclick=goSelectSysCode('"+val1.codeType+"','"+val1.isEditFormField+"','"+val1.isEditFormField+"_1','"+val1.fieldHref+"')   class='sl-inputtext-ss' style='width:80%;'  type='text'  id='"+val1.isEditFormField+"_1' name='"+val1.isEditFormField+"_1' value='"+val1.valueName+"' readonly>";
							culIndexHtml+="&nbsp;&nbsp;&nbsp;<a href='##'   onclick=goSelectSysCode('"+val1.codeType+"','"+val1.isEditFormField+"','"+val1.isEditFormField+"_1','"+val1.fieldHref+"')  ><i class='fa fa-search'></i></a>";
						}
						else if ((val1.showType=="date"||val1.showType=="datetime")&&val1.isEdit == "Y") {
							culIndexHtml+="<input   onclick=\"WdatePicker()\" type='text' style='width:80%;'    id='"+val1.isEditFormField+"' name='"+val1.isEditFormField+"' value='"+val1.value+"' >";
							culIndexHtml+="<span class='add-on'>";
							culIndexHtml+="<i data-time-icon='icon-time'  data-date-icon='icon-calendar' class='icon-calendar'></i>";
							culIndexHtml+=" </span>";
						}
						
						else if ((val1.showType=="text"||val1.showType=="textarea")&&val1.isEdit == "Y") {//如果是编辑类型
							culIndexHtml += "<input name='"+val1.isEditFormField+"' id ='"+val1.isEditFormField+"'  style='width: "+(parseInt(val1.fieldLength)/parseInt(countWidth)*85)+"px;' type='text' value='"+val1.value+"'  />";
						}
						else if (val1.isShow == "N"&&val1.isEdit == "Y") {//如果是编辑类型
							culIndexHtml += "<input name='"+val1.isEditFormField+"' id ='"+val1.isEditFormField+"'  style='width: "+(parseInt(val1.fieldLength)/parseInt(countWidth)*85)+"px;' type='text' value='"+val1.value+"'  />";
						}
						else{
							culIndexHtml += val1.value;
						}
					}else{
						if((val1.codeType!=""||val1.fieldHref!="")&&val1.isEdit == "Y"){
							culIndexHtml += val1.valueName;
						}else if (val1.isShow == "N"&&val1.isEdit == "Y") {
							culIndexHtml += val1.valueName;
						}
						else{
							culIndexHtml += val1.value;
						}
						
					}
					culIndexHtml += "</td>";
				});
				culIndexHtml += "</tr>";
			});
		}
		$("#"+detailDataListHtmlId).html(culIndexHtml);
    }
    
    /**
     * 组装明细item的方法；明细号1 明细号2 明细号3 明细号4
     * @param detailItemData//明细号json数据
     * @param detailItemDataHtmlId//展示明细号数据html的id
     */
    function detailItemDataHtml(detailItemData,detailItemDataHtmlId,isDisabled){
    	var culIndexHtml="";
    	//var s_detailid=$("#detailItemDataHtml").find(".active").attr("detailid");
    	if(detailItemData.length>0){
		$(detailItemData).each(function(i,val) {
    		$(val.trData).each(function(ii,val1) {
    			culIndexHtml+="<li detailId='"+val1.ID+"'";
    			//if(val1.ID==s_detailid){
    			//	culIndexHtml+="class='active'";
    			//}
    			culIndexHtml+="onclick=\"selectItem('"+val1.ID+"',this)\">";
    			//页面显示1、2、3、4、5序号
				culIndexHtml+=i+1;
				if(!isDisabled){
					culIndexHtml+="<img onclick=\"delItem('"+val1.ID+"')\" style=\"cursor: pointer;\" src='plug-in/ace/assets/avatars/images/plus_05.png'/>";
				}
				culIndexHtml+="</li>";
    			});
    		});
    	}
		$("#"+detailItemDataHtmlId).html(culIndexHtml);
		$("#"+detailItemDataHtmlId).find("li:first").addClass("active");
		$("#"+detailItemDataHtmlId).find("li:first").click();
    }
    
    /**
     * 删除附件
     */
    function del(id,attachmenttitle,obj){
 	   	myConfirmDialog("您确定要删除吗？", function(){
 			$.ajax({
 				async : false,
 				cache : false,
 				type : 'POST',
 				url : "commonController.do?delObjFile&fileKey="+id,// 请求的action路径
 				error : function() {// 请求失败处理函数
 				},
 				success : function(data) {
 					var d = $.parseJSON(data);
 					if (d.success) {
 						var msg = d.msg;
 						//$.dialog.tips(msg);
 						if (obj != null){
 							try{
	 							obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
	 						 	  InitializePrevOrNext();
	 						 	layer.msg('删除成功！', {icon: 1});
	 	 						return true;
 						   	}catch(e){}
 						}
 					}
 				}
 			}); 
 		}, function(){
	   		return true;
	   	},"");
 	}
    
    /**
     * 附件html组装方法
     * @param fileDataJson//附件json
     * @param filehtmlId//显示附件html的id
     */
    var extend2Class={docx:"fa fa-file-word-o",doc:"fa fa-file-word-o",pdf:"fa fa-file-pdf-o",jpg:"fa fa-image",bmp:"fa fa-image",jpeg:"fa fa-image",xlsx:"fa fa-file-excel-o",xls:"fa fa-file-excel-o",txt:"fa fa-times times"};
    function fileDataHtml(fileDataJson,filehtmlId,sid){
    	//console.log(cDetailPageTAvalon.detailPicData);
    	if(fileDataJson.length>0){
    		$(fileDataJson).each(function(i,val) {
    			var extend=extend2Class[val.extend]==undefined?"fa fa-file-o":extend2Class[val.extend];
				var culIndexHtml="";
				var isImg = (/(bmp|jpg|png|tiff|gif)$/i.test(val.extend));
				culIndexHtml+="<li  title=\""+val.attachmenttitle+"\" style='white-space: nowrap;overflow: hidden;text-overflow: ellipsis;width: 80px;'>";
    			culIndexHtml+="<p style='cursor: pointer;position: relative;"+(isImg?("background:url(\"listPageGenController.do?showOneImg&imgSize=150_150&picPath="+(val.realpath?val.realpath:val.fileUrl)+"\") no-repeat;background-size:100%;"):"")+"'>";
    			culIndexHtml+="<input class='times' type='checkbox' value='"+val.id+"' style='left: 0;top: 0px;'>";
    			if(!isImg){
        			culIndexHtml+="<i class='"+extend+"'></i>";
    			}
    			if(!isDisabledto){
    				culIndexHtml+="<i class='fa fa-times times'  onclick=\"del('"+val.id+"','"+val.attachmenttitle+"',this)\"></i>";
    			}
    			culIndexHtml+="</p>	";
    			culIndexHtml+=val.attachmenttitle;
   				culIndexHtml+="</li>";
				$("#"+filehtmlId).append(culIndexHtml);
	       });
    	}
    	try{
    		InitializePrevOrNext();
    	}catch(e){}
    }
    
    
    function downloadFiles(fileHtmlId){
    	var downFileId = "";
    	var check = $(fileHtmlId+" input:checkbox:checked");
    	for(var i=0; i<check.length; i++){
    		downFileId += check[i].value + ',';
		}
    	downFileId = downFileId.substring(0,downFileId.length-1);
    	if(downFileId != ""){
    		var downUrl_="listPageGenController.do?downFiles&downFileId="+downFileId;
    		download_file(downUrl_);
    	}else{
    		layer.msg('请先选择要下载的附件！', {icon: 5});
    	}
    }
    
    /**
     * 组装表单的方法，
     * @param formData  表单json数据
     * @param formHtmlId  显示表单html的id
     * @param callbackFunction  回调方法，在循环json数据时，可能有特殊的赋值
     */
    
    var sssse= (new Date).getTime();
   
    function formHtml(formData,formHtmlId,callbackFunction,isDisabled){
    	isDisabledto=isDisabled;
    	if(formData.length>0){
    		$(formData).each(function(i,val) {
	        		$(val.trData).each(function(ii,val1) {
        			var culIndexHtml="";
        			if(val1.isShow=="Y"&&val1.isFormHide=="Y"){
        				culIndexHtml+="<input type=\"hidden\" id='"+val1.culFieldname+"' name='"+val1.culFieldname+"' value='"+val1.value+"'>";
	        		}else{
	        			culIndexHtml+="<div class='col-xs-12 col-md-"+val1.tdColspan+"' style='margin-bottom: 1px;padding-right: 0px;padding-left: 0px; '>";
	        			culIndexHtml+="<div class='profile-user-info profile-user-info-striped' style='margin: 0 1px;border: 1px solid #CCCCCC;'>";
	        			culIndexHtml+="<div class='profile-info-row' style='min-height: 43px;'>";
	        			culIndexHtml+="<div class='profile-info-name' style='width: 140px;padding-top: 10px;' >";
	        			//if(val1.isGb=="1"){
	        			//	culIndexHtml+="<span class='rad' >★</span>";
	        			//}
	        			
	        			if(isDisabled){//如果是从待办过来的则不允许编辑
	        				culIndexHtml+=val1.indexName+" </div>";
	        				culIndexHtml+="<div class='profile-info-value' style='padding-left: 32px;padding-top: 10px;' >";
	        				if(val1.isCodetype==1){
	        					culIndexHtml+= val1.isCodetypeValue;
	        				}else{
	        					var dalue=val1.value;
								if((val1.isShowType=="date"||val1.isShowType=="datetime"||val1.isShowType=="4")&&val1.isCodetype==0&&val1.fieldHref==""){
									if(dalue!=null&&dalue!=undefined&&dalue!=""){
										dalue=dalue.replace("00:00:00","");//alert(m_text_);
										dalue=dalue.replace(".0","");
									}
								}
	        					culIndexHtml+= dalue;
	        				}
	        				culIndexHtml+="</div>";
	    					culIndexHtml+="</div>";
	    					culIndexHtml+="</div>";
	   						culIndexHtml+="</div>";
	        			}else{
		        			if(val1.isMust=="1"||val1.isMust=="Y"){
		        				culIndexHtml+="<span class='rad'>*</span>";
		        			}
				        	culIndexHtml+=val1.indexName+" </div>";
				        	
		        			culIndexHtml+="<div class='profile-info-value' style='padding-left: 32px;' ";
		        			if (val1.culFieldname.indexOf("@BATCH_NO") != -1
								||val1.culFieldname.indexOf("@DETAIL_NO") != -1) {
		        				
								culIndexHtml += " > <input type=\"text\" id='"+val1.culFieldname+"' name='"+val1.culFieldname+"' value='"+val1.value+"' readonly>";
								//culIndexHtml += val1.value;
							}else{
								
			        			if((val1.isShowType=="text"||val1.isShowType=="0"||val1.isShowType=="1"||val1.isShowType=="2")&&val1.isCodetype==0&&val1.fieldHref==""){
									culIndexHtml+=" ><input  ";
									if(val1.isMust=="1"||val1.isMust=="Y"){
										culIndexHtml+="datatype='"+val1.dataType+"'   itipmsg='"+val1.fieldAlert+"' ";
									}else{
										culIndexHtml+="datatype='/^\s*$/|"+val1.dataType+"' ";
									}
									if(val1.isEdit=="N"){//如果不能编辑
										culIndexHtml+="readonly ";
									}
									culIndexHtml+="onFocus='Validformfocusin(this)' onBlur='Validformfocusout(this)' class='sl-inputtext-ss' style='width:100%;'  type='text'  id='"+val1.culFieldname+"' name='"+val1.culFieldname+"' value='"+val1.value+"'>";
								}
								else if((val1.isShowType=="textarea"||val1.isShowType=="3")&&val1.isCodetype==0&&val1.fieldHref==""){
									culIndexHtml+=" ><textarea ";
									if(val1.isMust=="1"||val1.isMust=="Y"){
										culIndexHtml+="datatype='"+val1.dataType+"'  itipmsg='"+val1.fieldAlert+"'";
									}
									if(val1.isEdit=="N"){//如果不能编辑
										culIndexHtml+="readonly ";
									}
									culIndexHtml+=" onFocus='Validformfocusin(this)' onBlur='Validformfocusout(this)' class='sl-inputtext-ss' style='width:100%;height:75px'  id='"+val1.culFieldname+"' name='"+val1.culFieldname+"'  >"+val1.value+"</textarea>";
								}
								else if((val1.isShowType=="date"||val1.isShowType=="datetime"||val1.isShowType=="4")&&val1.isCodetype==0&&val1.fieldHref==""){
									
									var dalue=val1.value;
									//if(dalue!=null&&dalue!=undefined&&dalue!=""){
									//	dalue=dalue.replace("00:00:00","");//alert(m_text_);
									//	dalue=dalue.replace(".0","");
									//}
									culIndexHtml+=" ><input  class='ace' style='width:100%;' onFocus='Validformfocusin(this)' onBlur='Validformfocusout(this)'  itipmsg='"+val1.fieldAlert+"' ";
										if(val1.isEdit=="N"){//如果不能编辑
											culIndexHtml+="readonly ";
										}else{
											if(val1.culFieldname.indexOf("@B1002")!=-1||val1.culFieldname.indexOf("@B0901")!=-1){
												if(dalue!=null && dalue!=undefined && dalue!="") dalue=dalue.substring(0,19);
												culIndexHtml+="onclick=\"WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})\"";
											}else{
												if(dalue!=null && dalue!=undefined && dalue!="") dalue=dalue.substring(0,10);
												culIndexHtml+="onclick=\"WdatePicker()\"";
											}
										}
									culIndexHtml+=" type='text' id='"+val1.culFieldname+"' name='"+val1.culFieldname+"' value='"+dalue+"'>";
									if(val1.isEdit=="Y"){
										culIndexHtml+="<span class='add-on' style='position: absolute;right: 20px;'>";//{maxDate:'%y-%M-%d'}
										culIndexHtml+="<i data-time-icon='icon-time'  data-date-icon='icon-calendar' class='icon-calendar'></i>";
										culIndexHtml+=" </span>";
									}
								}//
								if((val1.isCodetype==1||val1.fieldHref!="")&&val1.selectOption.length==0){
									var ok=" onclick=goSelectSysCode('"+val1.codeType+"','"+val1.culFieldname+"','"+val1.isCodetypeName+"','"+val1.fieldHref+"')   ";
										culIndexHtml+=" > <input  style='width:100%;'    id='"+val1.culFieldname+"' name='"+val1.culFieldname+"' value='"+val1.value+"' ";
										//如果是申请人则可以编辑
										if(val1.culFieldname.indexOf("@APPLY_BY")<0){
											culIndexHtml+=" type='hidden' ><input readonly ";
											if(val1.isEdit=="Y"){//如果不能编辑
												culIndexHtml+=ok;
											}
										}else{
											if(val1.isEdit=="Y"){//如果不能编辑
												ok=" onclick=goSelectSysCode('"+val1.codeType+"','"+val1.culFieldname+"','"+val1.culFieldname+"','"+val1.fieldHref+"')   ";
											}
										}
										if(val1.isMust=="1"||val1.isMust=="Y"){
											culIndexHtml+="datatype='"+val1.dataType+"'   itipmsg='"+val1.fieldAlert+"' nullmsg='请选择"+val1.indexName+"'";
										}else{
											culIndexHtml+="datatype='/^\s*$/|"+val1.dataType+"' ";
										}
										
										culIndexHtml+=" onFocus='Validformfocusin(this)' onBlur='Validformfocusout(this)'   placeholder='请选择'   class='sl-inputtext-ss' style='width:100%;'  type='text'  id='"+val1.isCodetypeName+"' name='"+val1.isCodetypeName+"' value='"+val1.isCodetypeValue+"' >";
								
										if(val1.isEdit=="Y"){
											culIndexHtml+="<span class='add-on' style='position: absolute;right: 20px;'   "+ok+"  ><i class='fa fa-search'  ></i></span>";
										}
									
									
									
								}
								//下拉选择类型
								if(val1.isCodetype==1&&val1.selectOption.length>0){
									culIndexHtml+=" ><select  style='width:100%;' ";
									if(val1.isMust=="1"||val1.isMust=="Y"){
										culIndexHtml+="datatype='"+val1.dataType+"'   itipmsg='"+val1.fieldAlert+"' nullmsg='请选择"+val1.indexName+"'";
									}else{
										culIndexHtml+="datatype='/^\s*$/|"+val1.dataType+"' ";
									}
									if(val1.isEdit=="N"){//如果不能编辑
										culIndexHtml+="readonly ";
									}
									culIndexHtml+="  id='"+val1.culFieldname+"' name='"+val1.culFieldname+"' > ";
									culIndexHtml+=" <option value=''>请选择</option> ";
									$(val1.selectOption).each(function(ii1,selectVal) {
										culIndexHtml+=" <option value='"+selectVal.value+"' ";
										if(val1.value==selectVal.value){
											culIndexHtml+=" selected";
										}
									culIndexHtml+=">"+selectVal.name+"</option> ";
									});
									culIndexHtml+=" </select> ";
								}
							}
		        			culIndexHtml+="</div>";
	    					culIndexHtml+="</div>";
	    					culIndexHtml+="</div>";
	   						culIndexHtml+="</div>";
	        			}
        			}
        			try{
						eval(callbackFunction);
					}catch(e){}
					$("#"+formHtmlId).append(culIndexHtml);
					try{
					topicDiv(formHtmlId);//初始化鼠标移入提示信息功能
					InitValidform(formHtmlId);//初始化表单验证方法
					}catch(e){}
        		});
        	});
    		
    	}
    }
    
    function topicDiv(formHtmlId){
    	if($("#topic-"+sssse+"").length==0){
    		
        	var topicHtml="";
        	topicHtml+="<div id='topic-"+sssse+"' style='";
    		topicHtml+="background: #fff;";
    		topicHtml+="border-top: 1px solid #ddd;";
    		topicHtml+="border-right: 2px solid #ddd;";
    		topicHtml+="border-bottom: 2px solid #ddd;";
    		topicHtml+="border-left: 1px solid #ddd;";
    		topicHtml+="position: absolute;";
    		topicHtml+="display: none; z-index: 2;left: 641px; top: 170px;'>";
        	topicHtml+="<div class='adorn' style='width: 7px; ";
    		topicHtml+="height: 11px; ";
    		topicHtml+="overflow: hidden; ";
    		topicHtml+="position: absolute; ";
    		topicHtml+="bottom: 15px; ";
    		topicHtml+="left: -7px;'></div> ";
        	topicHtml+="<div   class='inner_html'  id='inner_html' style='max-height: 200px;overflow-x: auto;max-width: 400px;padding: 10px;";
    		topicHtml+="line-height: 20px;'>/div> ";
        	topicHtml+="</div>";
        	$("#"+formHtmlId).append(topicHtml);
    	}
    	var aLi=document.getElementById(formHtmlId).getElementsByTagName('input'); 
        bindTopic(aLi);
        aLi=document.getElementById(formHtmlId).getElementsByTagName('textarea'); 
        bindTopic(aLi);
        aLi=document.getElementById(formHtmlId).getElementsByTagName('select'); 
        bindTopic(aLi);

    }

var g_oTimerHide = null;

function bindTopic(aElement) {
	var i = 0;
	for (i = 0; i < aElement.length; i++) {
		aElement[i].miaovIndex = i;
		aElement[i].onmouseover = function(ev) {
			showTopic(this.miaovIndex, window.event || ev,this);
		};
		aElement[i].onmouseout = function() {
			hideTopic();
		};
		aElement[i].onmousemove = function(ev) {
			var oEvent = window.event || ev;
			setPosition(oEvent.clientX, oEvent.clientY);
		};
	}
}



function showTopic(index, oEvent,this1) {
	  
	var oTopic = document.getElementById("topic-"+sssse);
	  
	if (g_oTimerHide) {
		clearTimeout(g_oTimerHide);
	}
	var tip_msg=$(this1).attr("itipmsg");
	if(tip_msg!=""&&tip_msg!=null&&tip_msg!="\"null\""){
		oTopic.getElementsByTagName('div')[1].innerHTML = tip_msg;
		oTopic.style.display = 'block';
		setPosition(oEvent.clientX, oEvent.clientY);
	}

}

function hideTopic() {
	var oTopic = document.getElementById("topic-"+sssse);
	if (g_oTimerHide) {
		clearTimeout(g_oTimerHide);
	}
	g_oTimerHide = setTimeout(function() {
		oTopic.style.display = 'none';
	}, 50);
}


function setPosition(x, y) {
	var top = document.body.scrollTop || document.documentElement.scrollTop;
	var left = document.body.scrollLeft || document.documentElement.scrollLeft;
	x += left;
	y += top;
	var oTopic = document.getElementById("topic-"+sssse);
	var l = x + 20;
	var t = y - (oTopic.offsetHeight + 20);
	var bRight = true;
	var iPageRight = left + document.documentElement.clientWidth;
	if (l + oTopic.offsetWidth > iPageRight) {
		bRight = false;
		l = x - (oTopic.offsetWidth - 40);
		oTopic.getElementsByTagName('div')[0].className = 'adorn_r';
	} else {
		oTopic.getElementsByTagName('div')[0].className = 'adorn';
	}
	oTopic.style.left = l + 'px';
	oTopic.style.top = (y-53) + 'px';
} 


var myValidform;
function InitValidform(formId) {
	myValidform=$("#"+formId).Validform({
	tiptype:function(msg,o,cssctl){
		//msg：提示信息;
		//o:{obj:*,type:*,curform:*}, obj指向的是当前验证的表单元素（或表单对象），type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态, curform为当前form对象;
		//cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）;
		if(!o.obj.is("form")){//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
			var vl= $(o.obj).closest(".grid-stack-item").find(".Validforminfo");
			vl.remove();
			var objtiphtml="";
			if(o.type==3){
				objtiphtml+="<span class='Validform_checktip Validform_wrong'>";
			}
			if(o.type==2){
				objtiphtml+="<span class='Validform_checktip Validform_right'>";
			}
			objtiphtml+=msg;
			objtiphtml+="</span>";
			var objtip=$(objtiphtml);
			cssctl(objtip,o.type);
			var infohtml="";
			infohtml+="<div class='Validforminfo' style='display: block;position: absolute;left: 130px;z-index: 2;width:215px'>";
			infohtml+=objtiphtml;
			infohtml+="</div>";
			$(o.obj).closest(".grid-stack-item").append(infohtml);
		//if(o.type==2){
			vl= $(o.obj).closest(".grid-stack-item").find(".Validforminfo");
			vl.fadeOut(2500);
		//}
		}
	}
});
	//$.closeLoading_();//关闭加载窗口
}

   
    
    
    /**
	 * 组装文物图片的方法
	 * 
	 * @param backFileJson
	 */
    function uploadPicFileCallback(backFileJson){
    	if(backFileJson.length>0){
    		$(backFileJson).each(function(i,val) {
	    		var culIndexHtml="";
		    	culIndexHtml+=" <span  class=\"ps-item\" ><a onmouseout='onmouseoutPic(this)' onmouseover='onmouseoverPic(this)' ";
				culIndexHtml+=" title=\""+val.fileName+"\" infotypename='"+val.picName+"' id=\""+val.fileId+"\" href=\"javascript:;\"><img ";
				culIndexHtml+="  class=\"loading-style2\" ";
				culIndexHtml+=" src=\"tBCommAttchController.do?showImg&fileId="+val.fileId+"\"> ";
				culIndexHtml+=" </a></span> ";
				$("#ximg").append(culIndexHtml);
    		});
    		$("#dimg").find("img").attr("src","tBCommAttchController.do?showImg&fileId="+backFileJson[backFileJson.length-1].fileId);
    		$("#dimg").find("span").text(backFileJson[backFileJson.length-1].picName);
    		$("#imgs2").show();
    		$("#imgs1").hide();
    	}
 	  // console.log(backFileJson);
    	try{
    		InitializePrevOrNext();
    	}catch(e){
			
		}
    }
    
    
    /**
     * 复杂图文模式下的html组装
     * @param imageTextListData
     * @param imageTextDataHtmlId
     * @param xianshigeshu//默认显示的图文个数
     */
    function imageTextDataHtml(imageTextListData,imageTextDataHtmlId,xianshigeshu) {
		var culIndexHtml="";
		if(imageTextListData.length>0){
    		$(imageTextListData).each(function(i,val) {
				culIndexHtml+="<table class='table' style='background: #EEEEEE;color: #0A0A0A;margin-bottom: 0px;' >";
				culIndexHtml+="<tbody>";
				culIndexHtml+="<tr class='title_background' >";
				culIndexHtml+="<th  align='left' style='width:100%;'>";
				culIndexHtml+="<dt>";
				culIndexHtml+="<span  style='margin-left: 0px;float: left;'  >";
				culIndexHtml+="<input class='ace' type='checkbox' typelist='main' checkIndex='"+i+"' st='"+val.STATUSCODE+"' onclick=\"thatClickMain('0',this,'image_text')\" checkvalue='"+val.ID+"'>";
				culIndexHtml+="<span class='lbl'></span>";
				culIndexHtml+="</span>";
				var o=true;
				$(val.IMAGETEXTLIST).each(function(i1,val1) {
					if(val1.isShow=="Y"){
						culIndexHtml+="<span style='width:250px;float: left;margin-right: 50px;margin-left: 10px;'>";
						culIndexHtml+="&nbsp;&nbsp;";
						culIndexHtml+=val1.NAME+"：";
						var m_text_= val1.VALUE;
						m_text_=m_text_.replace("00:00:00","");//alert(m_text_);
						if(o){
							o=false;
							culIndexHtml+="<a href='tBCulCoreCommonController.do?goView&mainId="+val.ID+"&bussCode="+val.BUSSCODE+"' target='_blank' > ";
							culIndexHtml+=""+m_text_+"<i></i> ";
							culIndexHtml+="</a>";
						}else{
							culIndexHtml+=""+m_text_+"<i></i> ";
						}
						culIndexHtml+="</span>";
					}
				});
				
				if(val.culDataList.length>=xianshigeshu){
					culIndexHtml+="<span onclick=\"gengduo('"+val.ID+"',this);\" style='color:#2a6496;cursor:pointer;margin-right: 10px;margin-left: 10px;'>";
					culIndexHtml+="更多>>";
					culIndexHtml+="</span>";
				}
				culIndexHtml+="<!-- ";
				culIndexHtml+="&nbsp;&nbsp;当前批次总征集数量：";
				culIndexHtml+="<span class='badge badge-primary '>val1.ZONGSHULIANG</span>";
				culIndexHtml+="&nbsp;&nbsp;查询条件匹配数量：";
				culIndexHtml+="<span class='badge badge-success '>val1.PIPEISHULIANG</span>";
				culIndexHtml+="-->";
				culIndexHtml+="</dt>";
				culIndexHtml+="</th>";
				culIndexHtml+="</tr>";
				culIndexHtml+="</tbody>";
				culIndexHtml+="</table>";
    			
				$(val.culDataList).each(function(i2,val2) {
					culIndexHtml+="<!-- 明细信息条 start -->";
					culIndexHtml+="<div   style='padding-right: 3px;padding-left: 3px;";
					if(i2>= xianshigeshu){
						culIndexHtml+=" display: none; ' gengduoid='"+val.ID+"' ";
					}else{
						culIndexHtml+=" ' ";
					}
					culIndexHtml+=" class='col-xs-12 col-md-4 center' >";
					culIndexHtml+="<div class='col-xs-12  show11111' onmousemove='showButtons(this)' onmouseout='hideButtons(this)' style='background: #F5F5F5;margin-bottom: 5px;margin-top:5px; border:1px solid #ddd ;padding-right: 0px;padding-left: 0px;'   >";
					culIndexHtml+="<div class='labe' style='left: 1px;position: absolute;top: -3px;'>";
					culIndexHtml+="<label class='inline'> ";
					culIndexHtml+="<input class='ace' typelist='detail'  checkmainid='"+val.ID+"' checkIndex='"+i+"' st='"+val.STATUSCODE+"' checkdetailid='"+val2.ID+"' checkcid='"+val2.CID+"' type='checkbox'>";
					culIndexHtml+="<span class='lbl'></span>";
					culIndexHtml+="</label>";
					culIndexHtml+="</div>";
					culIndexHtml+="<div class='col-xs-12 col-md-5 center' style='padding-right: 0px;height:140px;margin-bottom: 10px;'>";
					culIndexHtml+="<span class='profile-picture' style='height: 150px;width: 140px;'>";
					culIndexHtml+="<img id='avatar' src='tBCommAttchController.do?showImg&businesskey="+val.ID+"&detailid="+val2.ID+"&attchCode=A0201&picType=1' onerror=\"javascript: this.src = 'plug-in/jd/image/win_11.gif'\"    class='editable img-responsive editable-click editable-empty' alt='Alexs Avatar' style='height: 140px;";
					culIndexHtml+="width: 140px;'></img>";
					culIndexHtml+="</span>";
					culIndexHtml+="</div>";
					
					$(val2.culData).each(function(i3,val3) {
						if(val3.isShow=="Y"){
							culIndexHtml+="<div class='col-xs-12 col-md-7' style='margin-top:5px;margin-bottom: 1px;padding-right: 0px;padding-left: 0px;'>";
							culIndexHtml+="<div class='profile-user-info profile-user-info-striped' style='margin: 0;border:0px;'>";
							culIndexHtml+="<div class='profile-info-row' style='height:20px;padding-right: 0px;padding-left: 0px;'>";
							culIndexHtml+="<div class='profile-info-name' title='"+val3.name+"' style='color: #0A0A0A;background: #F5F5F5;width: 100px;padding-right: 5px;padding: 0px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>";
							culIndexHtml+="&nbsp;&nbsp;"+val3.name;
							culIndexHtml+="&nbsp;</div>";
							culIndexHtml+="<div class='profile-info-value'  style='padding-right: 0px;text-align: left;padding-top: 0px;margin-left: 45px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>";
							
							if(val3.fieldname=="CUL_NAME"){
								culIndexHtml+="&nbsp;&nbsp;&nbsp;<a href='glaccountController.do?jumpLifecycle&cid="+val2.CID+"' target='_blank' >  ";
								culIndexHtml+=val3.value;
								culIndexHtml+="</a>";
							}else{
								culIndexHtml+="&nbsp;&nbsp;&nbsp;"+val3.value;
							}
							culIndexHtml+="</div>";
							culIndexHtml+="</div>";
							culIndexHtml+="</div>";
							culIndexHtml+="</div>";
						}
					});
					culIndexHtml+="<!--<div class='he' id='buttons' style='display: none;position: absolute;";
					culIndexHtml+="width: 25px;";
					culIndexHtml+="height: 130px;";
					culIndexHtml+="font-size: 10px;";
					culIndexHtml+="padding-top: 13px;";
					culIndexHtml+="line-height: 16px;";
					culIndexHtml+="background-image: url(plug-in/ace/assets/avatars/images1/1_03.png);";
					culIndexHtml+="text-align: center;";
					culIndexHtml+="position: absolute;";
					culIndexHtml+="top: 20px;";
					culIndexHtml+="right: 0px;";
					culIndexHtml+="opacity: 0.6;'>";
					culIndexHtml+="<ul>";
					culIndexHtml+="<li style='border-bottom: 1px solid #FFFFFF;'>";
					culIndexHtml+="<a href='tBCulCollectinfoMainController.do?tBCulCollectinfoMain&detailId="+val2.ID+"&mainId="+val.ID+"'  target='_blank'><span>";
					culIndexHtml+="<i class='fa fa-pencil'></i><br />";
					culIndexHtml+="修<br/>改";
					culIndexHtml+="</span></a>";
					culIndexHtml+="</li>";
					culIndexHtml+="<li>";
					culIndexHtml+="<a href='##' id='"+val2.ID+"' onclick='delDetail(this)'><span>";
					culIndexHtml+="<i class='fa fa-times'></i><br />";
					culIndexHtml+="删<br/>除";
					culIndexHtml+="</span></a>";
					culIndexHtml+="</li>";
					culIndexHtml+="</ul>";
					culIndexHtml+="</div>-->";
					culIndexHtml+="</div>";
					culIndexHtml+="</div>";
					culIndexHtml+=" <!--明细end -->";
				});
    		});
		}
		$("#"+imageTextDataHtmlId).html(culIndexHtml);
	}
    
    
    
    /**
     * 复杂简明headTitle模式的html组装
     * @param sAClearListMainTitleData
     * @param sAClearListMainTitleDataHtmlId
     */
    function sAClearListMainTitleDataHtml(sAClearListMainTitleData,sAClearListMainTitleDataHtmlId) {
		var culIndexHtml="";
		if(sAClearListMainTitleData.length>0){
				culIndexHtml+="<th style='text-align: inherit;width:5%;"+defineBianKuangCss+"' align='center'>选择</th>";
				culIndexHtml+="<th style='text-align: inherit;width:5%;"+defineBianKuangCss+"' align='center'>序号</th>";
				/*culIndexHtml+="<th style='text-align: inherit;width:5%;"+defineBianKuangCss+"' align='center'>明细</th>";*/
				var countWidth=0;//算出需要显示的总宽度，用于计算宽度
				$(sAClearListMainTitleData).each(function(i,val) {
					if(val.isShow!="N"&&val.isShow!=""){
						countWidth=(parseInt(countWidth)+parseInt(val.dataLength));
					}
				});
    		$(sAClearListMainTitleData).each(function(i,val) {
    			culIndexHtml+="<th  align='left'  ";
    			if(val.isShow=="N"||val.isShow==""){
    				culIndexHtml+=" style='text-align: inherit;display: none;"+defineBianKuangCss+"' ";
    			}else{
    				culIndexHtml+=" style='text-align: inherit;width:"+(parseInt(val.dataLength)/parseInt(countWidth)*85)+"%;"+defineBianKuangCss+"' ";
    			}
    			culIndexHtml+=" >"+val.titleName+"</th>";
    		});
		}
		$("#"+sAClearListMainTitleDataHtmlId).html(culIndexHtml);
	}
    
	
	/**
	 * 复杂简明模式的body的html方法
	 * @param sAClearListMainBodyData
	 * * @param sAClearListMainBodyDataHtmlId//复杂简明模式的headtitlejson
	 * @param sAClearListMainBodyDataHtmlId
	 */
	function sAClearListMainBodyDataHtml(sAClearListMainBodyData,sAClearListMainBodyDataHtmlId) {
		var culIndexHtml="";
		if(sAClearListMainBodyData.length>0){
    		$(sAClearListMainBodyData).each(function(i,val) {
    			culIndexHtml+="<tr > ";
    			culIndexHtml+="<td  style='"+defineBianKuangCss+"' align='center'> <input  onclick=thatClickMain('"+i+"',this,'simple_and_clear') type='checkbox' typelist='main' checkIndex='"+i+"' st='"+val.STATUSCODE+"'  checkValue='"+val.ID+"' >";
    			culIndexHtml+="</td> ";
    			culIndexHtml+="<td  style='"+defineBianKuangCss+"' align='center'> "+(val.XH+i+1)+"";
    			culIndexHtml+="</td> ";
				var o=true;
				$(val.mainValue).each(function(ii,val1) {
					culIndexHtml+="<td   ";
					if(val1.isShow=="N"||val1.isShow==""){
        				culIndexHtml+=" style='display: none;"+defineBianKuangCss+"' ";
        			}else{
        				culIndexHtml+=" style='"+defineBianKuangCss+"' ";
        			}
					var m_text_= val1.value;
					m_text_=m_text_.replace("00:00:00","");
					if(val1.isShow!="N"&&val1.isShow!=""&&o){
						culIndexHtml+="<span> ";
						culIndexHtml+="<a href='tBCulCoreCommonController.do?goView&mainId="+sAClearListMainBodyData[i].ID+"&bussCode="+val.BUSSCODE+"' target='_blank' > ";
						culIndexHtml+=""+m_text_+"<i></i> ";
						culIndexHtml+="</a></span> ";
						o=false;
					}else{
						culIndexHtml+="><span>"+m_text_+"</span></td> ";
					}
					
				});
				culIndexHtml+="</tr> ";
    		});
		}
		$("#"+sAClearListMainBodyDataHtmlId).html(culIndexHtml);
	}
	
	
	/**
	 * 复杂简明模式的headtitle
	 */
	function sAClearListDetailTitleDataHtml(sAClearListDetailTitleData) {
		var culIndexHtml="";
		if(sAClearListDetailTitleData.length>0){
			
			var countWidth=0;//算出需要显示的总宽度，用于计算宽度
			$(sAClearListDetailTitleData).each(function(i,val) {
				if(val.isShow!="N"&&val.isShow!=""){
					countWidth=(parseInt(countWidth)+parseInt(val.dataLength));
				}
			});
			
    		$(sAClearListDetailTitleData).each(function(i,val) {
    			culIndexHtml+="<th  ";
    			if(i==0){
    				culIndexHtml+=" align='center'  style='text-align: inherit;width:5%;"+defineDetailBianKuangCss+"'>";
    				culIndexHtml+="<input  onclick='thatclick(this)' type='checkbox'>";
    				culIndexHtml+="</th>";
    				culIndexHtml+="<th align='center' style='text-align: inherit;width:5%;"+defineDetailBianKuangCss+"'>序号";
    				culIndexHtml+="</th>";
    				culIndexHtml+="<th ";
        			culIndexHtml+=" align='center'>";
    			}
    			else if(i!=0&&(val.isShow=="N"||val.isShow=="")){
    				culIndexHtml+=" style='text-align: inherit;display: none;"+defineDetailBianKuangCss+"' ";
    				culIndexHtml+=" align='center'>";
    			}else{
    				culIndexHtml+=" style='text-align: inherit;width:"+(parseInt(val.dataLength)/parseInt(countWidth)*90)+"%;"+defineDetailBianKuangCss+"' ";
    				culIndexHtml+=" align='center'>";
    			}
    			culIndexHtml+=val.titleName+"</th>";
    		});
		}
		return culIndexHtml;
	}
	
	/**
	 * 复杂简明模式的Body
	 */
	 function sAClearListDetailBodyDataHtml(indexs,sAClearListMainBodyData) {
		var culIndexHtml="";
		$(sAClearListMainBodyData[indexs].culDataList).each(function(i,val1) {
			culIndexHtml+="<tr > ";
			var countWidth=0;//算出需要显示的总列数，用于计算宽度
    		$(val1.culData).each(function(ii,val11) {
				culIndexHtml+="<td  ";
				if(ii==0){
					culIndexHtml+=" style='"+defineDetailBianKuangCss+"' ";
					culIndexHtml+=" align='center'> <input  type='checkbox' checkIndex='"+indexs+"' st='"+sAClearListMainBodyData[indexs].STATUSCODE+"'  typelist='detail'  checkcid='"+val1.CID+"' checkmainid='"+sAClearListMainBodyData[indexs].ID+"' checkdetailid='"+val11.value+"' >";
					culIndexHtml+="</td> ";
					culIndexHtml+="<td  style='"+defineDetailBianKuangCss+"' align='center'>"+(i+1)+"</td>";
					culIndexHtml+="<td align='center' ";
    				culIndexHtml+=" style='"+defineDetailBianKuangCss+"'> ";
					culIndexHtml+=" <img  src=\"tBCommAttchController.do?showImg&businesskey="+sAClearListMainBodyData[indexs].ID+"&detailid="+val11.value+"&picType=1\" onerror=\"javascript: this.src = 'plug-in/jd/image/win_11.gif'\" height='35px' ></img>";
					culIndexHtml+="</td> ";
				}
				else if(ii!=0&&(val11.isShow=="N"||val11.isShow=="")){
    				culIndexHtml+=" style='display: none;"+defineDetailBianKuangCss+"' ";
    				culIndexHtml+=" align='center'>";
					culIndexHtml+="</td> ";
    			}
				else{
					culIndexHtml+=" style='"+defineDetailBianKuangCss+"' ";
					culIndexHtml+=" align='center'><span>";
					if(val11.fieldname=="CUL_NAME"){
						culIndexHtml+="<a href='glaccountController.do?jumpLifecycle&cid="+val1.CID+"' target='_blank' >  ";
						culIndexHtml+=val11.value;
						culIndexHtml+="</a>";
					}else{
						culIndexHtml+=val11.value;
					}
					culIndexHtml+="</span> ";
					
					culIndexHtml+="</td> ";
				}
				
			});
    		culIndexHtml+="</tr > ";
		});
		return culIndexHtml;
	}
	 
	 /**
	  * 出现数据修改的标识
	  * @returns
	  */
	   function alertMonitorData(){
			var is_change = $.fn.isChange();
			if(is_change){
				$(".li-archive").find("font").html("<font color='red' size=3 ><b>*</b></font>");
			}else{
				$(".li-archive").find("font").html("");
			}
		}
	 
	 /**
	  * 简易图文模式的html组装
	  * @param imageTextListData
	  * @param imageTextDataHtmlId
	  */
	 function JD_imageTextDataHtml(imageTextListData,imageTextDataHtmlId,xianshigeshu) {
			var culIndexHtml="";
			if(imageTextListData.length>0){
					$(imageTextListData).each(function(i2,val2) {
						culIndexHtml+="<!-- 明细信息条 start -->";
						culIndexHtml+="<div style='padding-right: 3px;padding-left: 3px;";
						if(i2>= xianshigeshu){
							culIndexHtml+=" display: none; ' gengduoid='"+val2.ID+"' ";
						}else{
							culIndexHtml+=" ' ";
						}
						culIndexHtml+=" class='col-xs-12 col-md-4 center' >";
						culIndexHtml+="<div class='col-xs-12  show11111' onmousemove='showButtons(this)' onmouseout='hideButtons(this)' style='background: #F5F5F5;margin-bottom: 5px;margin-top:5px; border:1px solid #ddd ;padding-right: 0px;padding-left: 0px;'   >";
						culIndexHtml+="<div class='labe' style='left: 0px;position: absolute;top: -3px;'>";
						culIndexHtml+="<label class='inline'> ";
						culIndexHtml+="<input class='ace' typelist='detail' st='"+val2.STATUS+"' checkIndex='"+i2+"'  checkmainid='"+val2.ID+"' checkcid='"+val2.CID+"' checkdetailid='"+val2.ID+"' type='checkbox'>";
						culIndexHtml+="<span class='lbl'></span>";
						culIndexHtml+="</label>";
						culIndexHtml+="</div>";
						culIndexHtml+="<div class='col-xs-12 col-md-5 center' style='padding-right: 0px;height:140px;margin-bottom: 10px;'>";
						culIndexHtml+="<span class='profile-picture' style='height: 150px;width: 140px;'>";
						culIndexHtml+="<img id='avatar' src='tBCommAttchController.do?showImg&businesskey="+val2.ID+"&detailid="+val2.ID+"&bussCode="+val2.BUSSCODE+"&picType=1' onerror=\"javascript: this.src = 'plug-in/jd/image/win_11.gif'\"    class='editable img-responsive editable-click editable-empty' alt='Alexs Avatar' style='height: 140px;";
						culIndexHtml+="width: 140px;'></img>";
						
						culIndexHtml+="<div class='show-nav-cen' style='left:inherit;width: 130px;background-color: #000000;";
						culIndexHtml+="position: absolute;";
						culIndexHtml+="bottom: -5px;font-size:12px;";
						culIndexHtml+="opacity: 0.8;color:#ffffff;text-align: left;padding:0px 2px;'>";
						if(val2.STATUS=="0"){
							culIndexHtml+="<div>状态："+val2.STATUSCN+"</div>";
						}else{
							culIndexHtml+="<div ><span>状态：<span/><span style='color:red;'>"+val2.STATUSCN+"<span/></div>";
						}
						culIndexHtml+="<div>录入时间："+val2.CREATE_DATE+"</div>";
						culIndexHtml+="</div>";
						culIndexHtml+="</span>";
						
						culIndexHtml+="</div>";
						
						$(val2.culData).each(function(i3,val3) {
							if(val3.isShow=="Y"){
								culIndexHtml+="<div class='col-xs-12 col-md-7' style='margin-top: 5px;margin-bottom: 1px;padding-right: 0px;padding-left: 0px;'>";
								culIndexHtml+="<div class='profile-user-info profile-user-info-striped' style='margin: 0;border:0px;'>";
								culIndexHtml+="<div   class='profile-info-row' style='height:20px;padding-right: 0px;padding-left: 0px;'>";
								culIndexHtml+="<div class='profile-info-name' title='"+val3.name+"' style='color: #0A0A0A;background: #F5F5F5;width: 100px;padding-right: 5px;padding: 0px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>";
								culIndexHtml+="&nbsp;&nbsp;"+val3.name;
								culIndexHtml+="&nbsp;</div>";
								culIndexHtml+="<div class='profile-info-value' title='"+val3.value+"' style='padding-right: 0px;text-align: left;padding-top: 0px;margin-left: 45px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>";
								culIndexHtml+="&nbsp;&nbsp;&nbsp;";
								if(val3.fieldname=="CUL_NAME"){
									var cidnew=val2.CID==undefined||val2.CID==""||val2.CID==null?val2.ID:val2.CID;
									culIndexHtml+="<a href='glaccountController.do?jumpLifecycle&cid="+cidnew+"' target='_blank' >  ";
									culIndexHtml+=val3.value;
									culIndexHtml+="</a>";
								}else{
									culIndexHtml+=val3.value;
								}
								culIndexHtml+="</div>";
								culIndexHtml+="</div>";
								culIndexHtml+="</div>";
								culIndexHtml+="</div>";
							}
						});
						/**
						if(val2.STATUS=="0"){
							culIndexHtml+="<div class='he' id='buttons' style='display: none;position: absolute;";
							culIndexHtml+="width: 25px;";
							culIndexHtml+="height: 130px;";
							culIndexHtml+="font-size: 10px;";
							culIndexHtml+="padding-top: 13px;";
							culIndexHtml+="line-height: 16px;";
							culIndexHtml+="background-image: url(plug-in/ace/assets/avatars/images1/1_03.png);";
							culIndexHtml+="text-align: center;";
							culIndexHtml+="position: absolute;";
							culIndexHtml+="top: 20px;";
							culIndexHtml+="right: 0px;";
							culIndexHtml+="opacity: 0.6;'>";
							culIndexHtml+="<ul>";
							culIndexHtml+="<li style='border-bottom: 1px solid #FFFFFF;'>";
							culIndexHtml+="<a href='tBCulController.do?goUpdate&bussCode="+val2.BUSSCODE+"&cid="+val2.ID+"'  target='_blank'><span>";
							culIndexHtml+="<i class='fa fa-pencil'></i><br />";
							culIndexHtml+="修<br/>改";
							culIndexHtml+="</span></a>";
							culIndexHtml+="</li>";
							culIndexHtml+="<li>";
							culIndexHtml+="<a href='##' id='"+val2.ID+"' onclick='delDetail(this)'><span>";
							culIndexHtml+="<i class='fa fa-times'></i><br />";
							culIndexHtml+="删<br/>除";
							culIndexHtml+="</span></a>";
							culIndexHtml+="</li>";
							culIndexHtml+="</ul>";
							culIndexHtml+="</div>";
						}
						*/
						culIndexHtml+="</div>";
						
						culIndexHtml+="</div>";
						culIndexHtml+="<!-- 明细end -->";
					});
					$("#"+imageTextDataHtmlId).html(culIndexHtml);
			}
			
		}
    
	 /**
	  * 简单简易模式的headTitle  html组装
	  * @param sAClearListDetailTitleData
	  * @param sAClearListDetailTitleDataHtmlId
	  */
	function JD_sAClearListDetailTitleDataHtml(sAClearListDetailTitleData,sAClearListDetailTitleDataHtmlId) {
		var culIndexHtml="";
		if(sAClearListDetailTitleData.length>0){
			var countWidth=0;//算出需要显示的总宽度，用于计算宽度
			$(sAClearListDetailTitleData).each(function(i,val) {
				if(val.isShow!="N"&&val.isShow!=""&&i!=0){
					countWidth=(parseInt(countWidth)+parseInt(val.dataLength));
				}
			});
     		$(sAClearListDetailTitleData).each(function(i,val) {
     			culIndexHtml+="<th  ";
     			if(i==0){
     				culIndexHtml+=" style='width:5%;text-align:center;"+defineBianKuangCss+"' >";
     				culIndexHtml+="<input onclick='thatclick(this)' type='checkbox'>";
     				culIndexHtml+="<th  ";
     				culIndexHtml+="style='width:5%;text-align:center;"+defineBianKuangCss+"' ";
     				culIndexHtml+=" >";
     			}
     			else if(i!=0&&(val.isShow=="N"||val.isShow=="")){
     				culIndexHtml+=" style='text-align:center;display: none;"+defineBianKuangCss+"' ";
     				culIndexHtml+=" >";
     			}else{
     				culIndexHtml+=" style='text-align:center;width:"+(parseInt(val.dataLength)/parseInt(countWidth)*90)+"%;"+defineBianKuangCss+"' ";
     				culIndexHtml+=" >";
     			}
     			culIndexHtml+=val.titleName+"</th>";
     		});
		}
		$("#"+sAClearListDetailTitleDataHtmlId).html(culIndexHtml);
	}
		
		/**
		 * 简单简易模式Body  html 组装
		 * @param sAClearListDetailBodyData
		 * @param sAClearListDetailBodyDataHtmlId
		 */
		function JD_sAClearListDetailBodyDataHtml(sAClearListDetailBodyData,sAClearListDetailBodyDataHtmlId) {
			var culIndexHtml="";
			$(sAClearListDetailBodyData).each(function(i,val1) {
				culIndexHtml+="<tr > ";
	        	$(val1.culData).each(function(ii,val11) {
					culIndexHtml+="<td  ";
					if(val11.isShow=="N"||val11.isShow==""){
        				culIndexHtml+=" style='display: none;"+defineBianKuangCss+"' ";
        			}else{
        				culIndexHtml+="style='"+defineBianKuangCss+"' ";
        			}
					if(ii==0){
						culIndexHtml+=" align='center'><input  type='checkbox' type='checkbox' typelist='detail' checkmainid='"+val1.MAIN_ID+"' st='"+val1.STATUS+"'  checkcid='"+val1.CID+"' checkdetailid='"+val1.ID+"' >";
						culIndexHtml+="</td> ";
						culIndexHtml+="<td  style='"+defineBianKuangCss+"' align='center' > ";
						culIndexHtml+=" <img  src=\"tBCommAttchController.do?showImg&businesskey="+val1.ID+"&detailid="+val1.ID+"&bussCode="+val1.BUSSCODE+"&picType=1\" onerror=\"javascript: this.src = 'plug-in/jd/image/win_11.gif'\"   height='35px' width='35px' ></img>";
					}else{
						culIndexHtml+=" ><span>";
						if(val11.fieldname=="CUL_NAME"){
							culIndexHtml+="<a href='glaccountController.do?jumpLifecycle&cid="+val1.CID+"' target='_blank' >  ";
							culIndexHtml+=val11.value;
							culIndexHtml+="</a>";
						}else{
							culIndexHtml+=val11.value;
						}
					}
					culIndexHtml+="</span> ";
					culIndexHtml+="</td> ";
     			});
	        	culIndexHtml+="</tr > ";
			});
			$("#"+sAClearListDetailBodyDataHtmlId).html(culIndexHtml);
		}
		
		
		
		
		
		
		/**
		 * 
		 * @param rid
		 * @param bussCode
		 * @param cfunction  回调函数，多个函数可以用分号隔开,默认执行带条件的查询方法
		 * @returns {Boolean}
		 */
		function submitBusiness(rid,bussCode,cfunction) {
			if(rid==''){
				layer.msg("请选择要提交的记录！", {icon: 5});
				return true;
			}
			if(rid.split(',').length>1){
				layer.msg("只能选中一条记录进行提交！", {icon: 5});
				return true;
			}
			myConfirmDialog("您确定要提交吗？", function() {
				$.ajax({
					url: "listPageGenController.do?submitBusiness",
					type: "POST",dataType: "json",async: false,
					data: {mainId:rid, bussCode:bussCode},
					success: function(data) {
						try{
							eval("queryTableMainAvalon.queryData()");
						}catch(e){
							eval(cfunction);
						}
						layer.msg("提交"+(data?"成功":"失败"), {icon: (data?1:5)});
					}
				});
			}, function() {
				return true;
			},"");
			
		}
		
	/**
	 * 
	 * @param mainId  主表id
	 * @param selectBussCode  选择页面的业务编码
	 * @param bussCode  当前业务的编码
	 * @param isVer  是否需要保存版本数据
	 */
		function goSelectCulData(mainId,selectBussCode,bussCode,isVer) {
			//D01
			var index = layer.open({
				  type: 2,
				  title: '文物数据选择',
				  shadeClose: false,//点击背景不关闭
				  scrollbar: false,//滚动条已锁
				  resize:true,//是否允许放大缩小
				  content: "tBCulCoreCommonController.do?collectSelect&isVer="+isVer+"&mainId="+mainId+"&bussCode="+bussCode+"&selectBussCode="+selectBussCode,
				  area: ['80%', '80%'],
				  maxmin: true,
				  cancel: function(index){
					  if(mainId==""){
						  layer.confirm('确定要关闭么？', {
							  icon: 3,
							  btn: ['确定','取消'] //按钮
							}, function(){
								 layer.close(index);
								 window.close();
							}, function(){
								return;
							});
						  return false;
					  }
					  else{
						  return true;
					  }
				  }
				});
				//layer.full(index);
	    	   
	      }
		/**
		 * 打开藏品全生命周期页面
		 * @param cid
		 */
		function goCollectLifecycle(cid){
			layer.open({
				  type: 2,
				  title: '藏品全生命周期',
				  shadeClose: false,//点击背景不关闭
				  scrollbar: false,//滚动条已锁
				  resize:true,//是否允许放大缩小
				  content: "glaccountController.do?jumpLifecycle&cid="+cid,
				  area: ['80%', '80%'],
				  maxmin: true,
				  cancel: function(index){
					  layer.confirm('确定要关闭么？', {
						  icon: 3,
						  btn: ['确定','取消'] //按钮
					  }, function(){
						  layer.close(index);
						  layer.closeAll('dialog');
					  }, function(){
						  return;
					  });
					  return false;
				  }
			});
		}
	
		
		/**
		 * 打开流程办理页面
		 * @param ACTIONNAME
		 * @param TASKID
		 * @param LINE
		 * @param TIPMSG1
		 * @param TIPMSG2
		 * @param ACTIONID
		 * @param NODEID
		 * @param PROCESSID
		 * @returns {Boolean}
		 */
		  function toTaskExecutionPage(mainid,actionname,taskid,line,tipmsg1,tipmsg2,actionid,nodeid,processid) {
			  if(mainid==""){
				   layer.msg('数据未保存，请先保存数据！', {icon: 5});
					return true;
			   }
			   var is_change = $.fn.isChange();
				if(is_change){
					layer.msg('数据有修改，请先保存！', {icon: 5});
					return true;
				}
		   	   layer.open({
		   			  type: 2,
		   			  title: actionname,
		   			  maxmin: true,
		   			  shadeClose: false, //点击遮罩关闭层
		   			  area : ['400px' , '300px'],
		   			  content: 'processRestController.do?toTaskExecutionPage',
		   			  btn: ['发送','关闭'],
		   			  yes: function(index, layero){
		   				myConfirmDialog("您确定要发送吗？", function(){
		   					var approvalOpinions = layer.getChildFrame('#userName_111_', index).val();
		   				$.ajax({
		   					async : false,
		   					cache : false,
		   					type : 'POST',
		   					url : "processRestController.do?complete&APPROVAL_OPINIONS="+approvalOpinions+"&VARIABLE={'LINE':'"+line+"'}&TASKID="+taskid,// 请求的action路径
		   					error : function() {// 请求失败处理函数
		   					},
		   					success : function(data) {
		   							layer.msg('发送成功！', {icon: 1});
		   							setTimeout("window.close()",2000); 
		   					}
		   				});
		   				}, function(){
		   			  		return true;
		   			  	},"");
		   			  },btn2: function(index, layero){
		   				return true;
		   			  },cancel: function(){ 
		   				//alert(4);
		   			  }
		   			 });
		   	}
		  
		  
		  
		  
  /**
   * 流程办理记录
   * @param mainId 
   * @returns
   */
  function processInformation(mainId) {
	   //webpage/icms/collect/input/detailData.json
		var processInformationHtml="";
		$.getJSON("processRestController.do?getTransactionHistory",{PROJECTID:mainId,MUNITID:"",APPID:""},function(resultData) {
			//console.log("resultData");
			//console.log(resultData);
			processInformationHtml+=" <!-- ===================  流程信息弹窗    =================-->";
			processInformationHtml+="<div  style='background-color:#fff;margin: 5px;'>";
			processInformationHtml+="<table border='1' bordercolor='#ccc' width='100%'>";
			processInformationHtml+="<tr bgcolor='#E1EDF7' height='30px'>";
			processInformationHtml+="<td align='center' width='30%' >步骤</td>";
			processInformationHtml+="<td  align='center' width='10%'>处理人</td>";
			processInformationHtml+="<td width='20%' align='center'>到达时间</td>";
			processInformationHtml+="<td width='20%' align='center'>处理时间</td>";
			processInformationHtml+="<td  align='center'>意见</td>";
			processInformationHtml+="</tr>";
			$(resultData.Result).each(function(i,val) {
				processInformationHtml+="<tr  height='30px'>";
				processInformationHtml+="<td  align='center'>"+val.TASKNODENAME+"</td>";
				processInformationHtml+="<td  align='center'>"+val.TASKEXECUTOR+"</td>";
				processInformationHtml+="<td align='center'>"+val.TASKSTARTTIME+"</td>";
				processInformationHtml+="<td align='center'>"+val.TASKENDTIME+"</td>";
				processInformationHtml+="<td  align='center'>"+val.TASKCOMMENT+"</td>";
				processInformationHtml+="</tr>";
			});
			processInformationHtml+="</table>";
			processInformationHtml+="</div>";
			processInformationHtml+="<!-- ===================  流程信息弹窗    =================-->";
			layer.open({
				   type: 1,
				   title: "流程信息",
				   //skin: 'layui-layer-rim', //加上边框
				   area: ['800px', '500px'], //宽高
				   content: processInformationHtml
				 });
		});
	}
		 
		  
		  
		  
    /**获取选择的信息
     *  isBatch:是否支持批量操作 true 或 false
     * **/
	function getSelectInfo(isBatch){
		var selectMainId="",detailId="";
  		var cids="";
  		var selIndex=0;
  		var allCheckStatus = new Array();
		var returnVal = new Array();
		if(collectinMListTA.showListType=="simple_and_clear"){
    		$("#sAClearListMainBodyDataHtml").find("[type='checkbox']").each(function(index, domEle) {
        		if (domEle.checked&&$(domEle).attr("typelist")=="main") {
        			var st=$(domEle).attr("st");
        			if(st!=undefined&&st!=null&&st!=""){
        				allCheckStatus.push(st);
        			}
        			if(isBatch){
        				selectMainId+=$(domEle).attr("checkvalue")+",";
        			}else{
        				selectMainId=$(domEle).attr("checkvalue");
        				selIndex++;
        			}
				}
        		if (domEle.checked&&$(domEle).attr("typelist")=="detail") {
        			var st=$(domEle).attr("st");
        			if(st!=undefined&&st!=null&&st!=""){
        				allCheckStatus.push(st);
        			}
					
        			if(isBatch){
        				selectMainId+=$(domEle).attr("checkmainid")+",";
        				detailId+=$(domEle).attr("checkdetailid")+",";
        				cids+=$(domEle).attr("checkcid")+",";
        			}else{
        				if(selectMainId!=$(domEle).attr("checkmainid")){
   							selIndex++;
   						}
        				selectMainId=$(domEle).attr("checkmainid");
        				detailId=$(domEle).attr("checkdetailid");
        				cids=$(domEle).attr("checkcid");
        			}
				}
			});
		}
		if(collectinMListTA.showListType=="image_text"){
			$("#image_text").find("[type='checkbox']").each(function(index, domEle) {
        		if (domEle.checked&&$(domEle).attr("typelist")=="main") {
        			var st=$(domEle).attr("st");
        			if(st!=undefined&&st!=null&&st!=""){
        				allCheckStatus.push(st);
        			}
        			if(isBatch){
        				selectMainId+=$(domEle).attr("checkvalue")+",";
        			}else{
        				selectMainId=$(domEle).attr("checkvalue");
        				selIndex++;
        			}
				}
        		if (domEle.checked&&$(domEle).attr("typelist")=="detail") {
        			var st=$(domEle).attr("st");
        			if(st!=undefined&&st!=null&&st!=""){
        				allCheckStatus.push(st);
        			}
        			if(isBatch){
        				selectMainId+=$(domEle).attr("checkmainid")+",";
						detailId+=$(domEle).attr("checkdetailid")+",";
						cids+=$(domEle).attr("checkcid")+",";
        			}else{
        				if(selectMainId!=$(domEle).attr("checkmainid")){
   							selIndex++;
   						}
        				selectMainId=$(domEle).attr("checkmainid");
        				detailId=$(domEle).attr("checkdetailid");
        				cids=$(domEle).attr("checkcid");
        			}
				}
			});
		}
		selectMainId=noRepeatStr(selectMainId);
		detailId=noRepeatStr(detailId);
		cids=noRepeatStr(cids);
		returnVal.push(selectMainId);
		returnVal.push(detailId);
		returnVal.push(cids);
		returnVal.push(selIndex);
		returnVal.push(allCheckStatus);
		return returnVal;
	}
	
	/**
	 * 过滤重复的id
	 * @param ids
	 * @returns
	 */
	function noRepeatStr(ids){
        var tempArr=new Array();
        var idsArr=ids.split(",");
        var s=0;
        for(var i=0;i<idsArr.length;i++){     
            if(tempArr.join('').indexOf(idsArr[i])==-1){
                tempArr[s]=idsArr[i];
                s++;
            }
        }     
        return tempArr.join(',');     
    }
	
	function printBillByList(bill_type,bill_id){
		layer.msg('正在准备数据，清稍候！', {icon: 1});
		var	url="/birtServer/frameset?__locale=zh_CN&__designer&__title=Birt_Report_Viewer&__showtitle=true&__report="+bill_type+".rptdesign&MAIN_ID="+bill_id;//工单打印预览
		window.open(url,"_blank");
	}
	
	/**导出查询结果*/
	function exportDataByQueryResult(jsonType,gno,rFData,isVer){
		layer.msg('正在导出数据，清稍候！', {icon: 1});
		var url_="listPageGenController.do?createDownloadFile&isVer="+isVer+"&jsonType="+jsonType+"&gno="+gno+"&currpage="
			+ model.search.searchcontent
			+ "&pagecount="
			+ model.page.pagecount;
		$.getJSON(url_,rFData,function(resultData) {
			if(resultData.success){
				//alert(resultData.obj[0].downFilePath);
				var downUrl_="listPageGenController.do?downFile&downFilePath="+resultData.obj[0].downFilePath;
				layer.msg('导出文件准备成功！', {icon: 1});
				download_file(downUrl_);
				//myLayPage("pageDiv",resultData.obj[0].DataLength,"tBCulCoreCommonController.do?getTWorJYListData&gno=${bussCode}&jsonType=TW",rFData);
			}else{
				layer.msg('导出文件失败！', {icon: 0});
			}
		});
	}
	
	/* ajax下载文件 
	@url: 文件url路径
	*/
	function download_file(url){
		if(typeof(download_file.iframe)== "undefined")
		{
			var iframe = document.createElement("iframe");
			download_file.iframe = iframe;
			document.body.appendChild(download_file.iframe); 
		}
		download_file.iframe.src = url;
		download_file.iframe.style.display = "none";
	}
	//operationList
	function setOperationFun_(operCode){
		//alert(operCode);
		if(operCode!=null&&operCode.length>0){
			var operCode_=operCode.substring(1,operCode.length-1);
			//alert(operCode+"---"+operCode_);
			var arr_operCode=operCode_.split(',');
			if(arr_operCode!=null){
				for(index_=0;index_<arr_operCode.length;index_++){
					//alert("|"+arr_operCode[index_]+"|");
					try{
						$("#"+arr_operCode[index_].trim()+"_button").show();
					}catch(e){alert(e);}
				}
			}
		}
		//alert(operCode);
	}
	
	String.prototype.trim=function() {
	    return this.replace(/(^\s*)|(\s*$)/g,'');
	}
	
	
	/**
	 * 验证是否提交过此业务的数据
	 */
	 function verifyWhetherSubmitted(refBusscode,bussCode,refDataid) {
		 var verify=false;
		$.ajax({
			url : "icmsController.do?verifyWhetherSubmitted&refDataid="+refDataid+"&refBusscode="+refBusscode+"&bussCode="+bussCode,
			type : "GET",
			async : false,
			dataType : "json",
			success : function(data) {
				if(data.VERIFYSTATUS){
					verify=true;
				}else{
					verify=false;
				}
			}
		});
		return verify;
	}
	 
	 function verifyWhetherSubmittedStatus(refBusscode,bussCode,refDataid) {
		 var verify;
		$.ajax({
			url : "icmsController.do?verifyWhetherSubmitted&refDataid="+refDataid+"&refBusscode="+refBusscode+"&bussCode="+bussCode,
			type : "GET",
			async : false,
			dataType : "json",
			success : function(data) {
				if(data.VERIFYSTATUS){
					verify=data.STATUS;
				}else{
					verify=data.STATUS;
				}
			}
		});
		return verify;
	}
	 
	 function verifyProcess(hideButtons,showButtons,bussCode) {
		$.ajax({
			url : "processRestController.do?verifyProcess",
			type : "GET",
			async : false,
			dataType : "json",
			success : function(data) {
				console.log(data);
				if(data.status=="00"){
					if(hideButtons.length>0){
						$.each(hideButtons,function(n,value) {  
							$("#"+value).hide()
				        });
					}
					if(showButtons.length>0){
						$.each(showButtons,function(n,value) {  
							$("#"+value).show()
				        });
					}
				}
			}
		});
	}
	
	
    
	
	
	//直接把表对应传递过来
	function outExcel__(){
	    //alert(divBody.innerHTML );
	    document.f1.reportConent.value = divBody.innerHTML;
	    //alert(document.f1.reportConent.value);
	    document.f1.action = "/library/include/excel_download.jsp";
	    //document.f1.target='_blank';
	    document.f1.submit();
	}
	
	
	function insertOpinionInfo(title,selectDetailId,bussCode,status,AlertMsg){
		layer.open({
			  type: 2,
			  title: title,
			  skin: '',
			  shadeClose: false,//点击背景不关闭
			  scrollbar: false,//滚动条已锁
			  resize:true,//是否允许放大缩小
			  maxmin: true,
			  area: ['600px', '300px'], //宽高
			  content: "crbcController.do?goToOpinionInfo&detailId="+selectDetailId+"&bussCode="+bussCode+"&status="+status,
			  btn:['提交','关闭'],
			  yes: function(index, layero){
				  var form1= layer.getChildFrame('form', index);
				  var explain=$(form1).find("#explain").val();
		        	if( "" == explain ){
		        		alert("意见不能为空，请重新输入");
		        		return false;
		        	}
		        	$.ajax({
						async : false,
						cache : false,
						type : "POST",
						url : "crbcController.do?doAddOpinion&detailId="+selectDetailId+"&explain="+explain+"&bussCode="+bussCode+"&status="+status,// 请求的action路径
						data:$(form1).serialize(),
						error : function() {// 请求失败处理函数
						},
						success : function(data) {
							var data0=eval("("+data+")");
							$('#gritter-notice-wrapper').remove(); 
							if (data0.success) {
								layer.msg(AlertMsg, {icon: 1});
								layer.close(index);
								doQuery();
							}else{
								layer.msg('数据保存异常！');
							}
						}
					});
			  },cancel: function(){ 
	 				//alert(4);
	 	      }
			});
	}
	
	
	
	/**
	 * 
	 * @param mainId  主表id
	 * @param selectBussCode  选择页面的业务编码
	 * @param bussCode  当前业务的编码
	 * @param isVer  是否需要保存版本数据
	 * @param functionId 菜单id
	 */
	function goSelectCulDataByFunction(mainId,selectBussCode,bussCode,isVer,functionId) {
		//alert(functionId);
		var themeId = "";
		var menuType = "";
		if(bussCode == "A03" || bussCode == "E07"){
			menuType = document.getElementById("menuType").value;
		}
		//D01
		var index = layer.open({
			  type: 2,
			  title: '企业信息选择',
			  shadeClose: false,//点击背景不关闭
			  scrollbar: false,//滚动条已锁
			  resize:true,//是否允许放大缩小
			  content: "tBCrbcEillegalController.do?querytBCrbcEbaseA&functionId="+functionId+"&isVer="+isVer+"&mainId="+mainId+"&themeId="+themeId+"&menuType="+menuType+"&bussCode="+bussCode+"&selectBussCode="+selectBussCode,
			  area: ['80%', '80%'],
			  maxmin: true,
			  cancel: function(index){
				  if(mainId==""){
					  layer.confirm('确定要关闭么？', {
						  icon: 3,
						  btn: ['确定','取消'] //按钮
						}, function(){
							 layer.close(index);
							 window.close();
						}, function(){
							return;
						});
					  return false;
				  }else{
					  return true;
				  }
			  }
			});
			//layer.full(index);
	}
	
