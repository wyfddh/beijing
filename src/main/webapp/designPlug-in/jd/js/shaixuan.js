
function delStr(str, arr) { //删除数组给定相同的字符串
    var n = -1;
    for (var i = 0,
    len = arr.length; i < len; i++) {
        if (str == arr[i]) {
            n = i;
            break;
        }
    }
    n > -1 && arr.splice(n, 1);
};
function trim(str) {
    return str.replace(/^\s+|\s+$/g, '')
};
function text(e) {
    var t = '';
    e = e.childNodes || e;
    for (var j = 0; j < e.length; j++) {
        t += e[j].nodeType != 1 ? e[j].nodeValue: text(e[j].childNodes);
    }
    return trim(t);
}

function prev(elem) {
    do {
        elem = elem.previousSibling;
    } while ( elem && elem . nodeType != 1 );
    return elem;
};

function next(elem) {
    do {
        elem = elem.nextSibling;
    } while ( elem && elem . nodeType != 1 );
    return elem;
}

function parents(elem, parents) {  //查找当前祖先辈元素需要的节点  如 parents(oDiv, 'dd') 查找 oDiv 的祖先元素为dd 的
    if(!elem || !parents) return;
    var parents = parents.toUpperCase();
    do{
        elem = elem.parentNode;
    } while( elem.nodeName.toUpperCase() != parents );
    return elem;
};
function clear_tiaojian(){
//  $(oSelectList).find('input').attr('checked',false);
  radioVal = '';
  isCusPrice = false;
  okSelect.length = 0;
  oSelectList.trigger('click', 1);
  if(okSelect.length>0){
  	okSelect.splice(0,okSelect.length);
  }
  if(okSelectValue.length>0){
  	for(var i=0;i<okSelectValue.length;i++){
  		var subSelectValue =okSelectValue[i].split("|");
  		 var yxValue = document.getElementById(subSelectValue[2]);
  		 yxValue.className = "";
  	}
  	okSelectValue.splice(0,okSelectValue.length);
  }
  goSubmit();
}

function s_more(thisObj,bussCode) {
	if($(thisObj).attr("class")!=null&&$(thisObj).attr("class")!=undefined){
		if($(thisObj).attr("class").indexOf("opened")>0){
			$(thisObj).removeClass("opened");
			$(thisObj).html($(thisObj).html().replace("收起","更多条件"));
			$("[hide_div='hideQuery'").each(function(){
				$(this).addClass("hideQuery");
				$(this).removeClass("openQuery");
			});
    		}else{
    			$(thisObj).addClass("opened");
    			$(thisObj).html($(thisObj).html().replace("更多条件","收起"));
    			$("[hide_div='hideQuery'").each(function(){
    				$(this).addClass("openQuery");
    				$(this).removeClass("hideQuery");
    			});
    		}
	}
}

function j_more(thisObj) {
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
}

function emClick (bussCode){
	$('#queryTableMainForm_'+bussCode).find("em").on("click", function (e1) {
	    var self = $(this);
	    if(self.attr("isinput")=="true"){
	    	self.closest('.selectedInfor').remove();
	    }else{
	    	var ere=self.closest('.selectedInfor').children("input").get(0);
	    	var yxValue = $('#'+bussCode+'_query_param').find("#tiaoJianId_1111_"+$(ere).attr('name')+"_"+$(ere).val());
	    	yxValue.removeClass("brand-icon-official");
	    	self.closest('.selectedInfor').remove();
	    }
	    eval("queryData_"+bussCode+"();");
	});
}






var okSelect,okSelectValue,oSelectList,oClearList,oCustext1,oCustext2,aItemTxt;
function readyQuery(bussCode){
	 okSelect = []; //已经选择好的
	 okSelectValue = []; //已经选择好的
	 oSelectList =$('#'+bussCode+'_query_param').find('#selectList');
	 oClearList = $('#'+bussCode+'_query_param #queryModel_11_').find('#clearList_11_');
	 oCustext1 = $('#'+bussCode+'_query_param').find('#custext1');
	 oCustext2 = $('#'+bussCode+'_query_param').find('#custext2');
	 aItemTxt = oSelectList.find("a");
	 $('#queryTableMainForm_'+bussCode).find('.clearDd').show();
	
	$('#'+bussCode+'_query_param').find(".J_brandLetter li").mouseover(function(){
		var ee11 =this;
		var selectdata=ee11.getAttribute('data-initial');
		$('#'+bussCode+'_query_param').find(".J_brandLetter li").each(function(){
			this.className="";
		});
		ee11.className="curr";
		$('#'+bussCode+'_query_param').find("#brand-8557111 li").each(function(){
			var selectdataValue=this.getAttribute('data-initial');
			if(selectdata=="0"){
				this.style.display='block'; 
			}else if(selectdataValue==selectdata){
				this.style.display='block'; 
			}else{
				this.style.display='none'; 
			}
		});
	});
	
	oSelectList.on("click",function (e, a) {
	    var ev = e || window.event;
	    var tag = ev.target || ev.srcElement;
	    if(!tag)return;
	    var tagName = tag.nodeName.toUpperCase();
	   
	    if (tagName == 'A') { //如果点击 的是 A
		 var elementClassName = tag.className;
			if(elementClassName == 'brand-icon-official'){
				return;
			}
			else{
	        var oPrevInput = prev(tag);
	        tag.className='brand-icon-official';
	        var parent = parents(tag, 'dd').firstChild.defaultValue;
	            if (oPrevInput && oPrevInput.getAttribute('type').toUpperCase() == 'RADIO') { //radio
	                oPrevInput.checked = true;
	            }
	             var typegroupId=tag.getAttribute('typegroupId');
		   		 var typename=tag.getAttribute('typename');
		   		 var value=tag.getAttribute("value");
		   		 if(value!=null&&value!=""){
		   			 var infor = '<div class="selectedInfor selectedShow">'+
		   			'<input type="hidden" id="'+typegroupId+'" name="'+typegroupId+'" value='+value+'>'+
		   			 '<input type="hidden" id="'+typegroupId+'_s111s000" name="'+typegroupId+'_s111s000" value='+value+'>'+
		        		'<span>' + parent + '</span>：<label>' + typename + '</label><em isinput="false"></em></div>';
		   			oClearList.append(infor);
		   			
		   			emClick(bussCode);
	    }
			}
	    }
	    if (tagName == 'INPUT'||tagName == 'DD'||tagName == 'DIV'||tagName == 'SPAN') {
	    	return;
	    }
	});

	

	$('#'+bussCode+'_query_param').find("#selectList").on("blur", ".sl-inputtext-ss", function () {
			 var typegroupId=this.getAttribute('typegroupId');
			 var typename=this.getAttribute('typename');
			 var value=this.value;
			 if(value!=null&&value!=""){
				 var infor = '<div class="selectedInfor selectedShow">'+
				 '<input type="hidden" id="'+typegroupId+'" name="'+typegroupId+'" value='+value+'>'+
				 '<input type="hidden" id="'+typegroupId+'_s111s000" name="'+typegroupId+'_s111s000" value='+value+'>'+
	     		'<span>' + typename + '</span>：<label>' + value + '</label><em isinput="true"></em></div>';
				 oClearList.append(infor);
				 this.value="";
				 emClick(bussCode);
			 }
		});
}


