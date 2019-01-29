
$('.clearDdHK').show();
var okSelect = []; //已经选择好的
var okSelectValue = []; //已经选择好的
eval("var oSelectListHK = document.getElementById('selectListHK');");

eval("var  oClearListHK = $('#queryModel_HK11_').find('#clearList_HK11_');");



var oCustext1 = document.getElementById('custext1');
var oCustext2 = document.getElementById('custext2');
eval("var aItemTxt = oSelectListHK.getElementsByTagName('a');");
var isCusPrice = false;//是否自定义价格
var radioVal = '';

eval("oSelectListHK").onclick = function(e, a) {
    var ev = e || window.event;
    var tag = ev.target || ev.srcElement;
    if(!tag)return;
    var tagName = tag.nodeName.toUpperCase();
    var aRadio = document.getElementsByName('radio2');

    if( isCusPrice ) {
      radioVal = oCustext1.value + '-' + oCustext2.value + '元';
    } else {
      radioVal = '';
    }
   
    if (tagName == 'A') { //如果点击 的是 A
	 var elementClassName = tag.className;
		if(elementClassName == 'brand-icon-official'){
			return;
		}
		else{
        var oPrevInput = prev(tag);
        tag.className='brand-icon-official';
        var parent = parents(tag, 'dd').firstChild.nextSibling.defaultValue;
            if (oPrevInput && oPrevInput.getAttribute('type').toUpperCase() == 'RADIO') { //radio
                isCusPrice = false;
                oPrevInput.checked = true;
            }
             var typegroupId=tag.getAttribute('typegroupId');
	   		 var typename=tag.getAttribute('typename');
	   		 var value=tag.getAttribute("value");
	   		 if(value!=null&&value!=""){
	   			 var infor = '<div class="selectedInfor selectedShow">'+
	        		'<input type="hidden" id="'+typegroupId+'_s111s000" name="'+typegroupId+'_s111s000" value='+value+'>'+
	        		'<input type="hidden" id="'+typegroupId+'" name="'+typegroupId+'" value='+value+'>'+
	        		'<span>' + parent + '</span>：<label>' + typename + '</label><em isinput="false"></em></div>';
	   			
	   			eval("oClearListHK").append(infor);
    }
		}
    }
    if (tagName == 'INPUT'||tagName == 'DD'||tagName == 'DIV'||tagName == 'SPAN') {
    	return;
    }
}



$("#clearList_HK11_").on("click", "em", function () {
//$('.clearList').find('em').bind('click',function(){
    var self = $(this);
    if(self.attr("isinput")=="true"){
    	this.parentNode.parentNode.removeChild(this.parentNode);
    }else{
    	    var yxValue = document.getElementById("tiaoJianId_1111_"+self.context.parentElement.children[1].getAttribute('name')+"_"+self.context.parentElement.children[1].defaultValue);
    	    yxValue.className = "";
    	    this.parentNode.parentNode.removeChild(this.parentNode);
    }

});

$("#selectListHK").on("blur", ".sl-inputtext-ss", function () {
		 var typegroupId=this.getAttribute('typegroupId');
		 var typename=this.getAttribute('typename');
		 var value=this.value;
		 if(value!=null&&value!=""){
			 var infor = '<div class="selectedInfor selectedShow">'+
     		'<input type="hidden" id="'+typegroupId+'_s111s000" name="'+typegroupId+'_s111s000" value='+value+'>'+
     		'<input type="hidden" id="'+typegroupId+'" name="'+typegroupId+'" value='+value+'>'+
     		'<span>' + typename + '</span>：<label>' + value + '</label><em isinput="true"></em></div>';
			 eval("oClearListHK").append(infor);
			 this.value="";
		 }
	});

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
  $(eval("oSelectListHK")).trigger('click', 1);
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

$(document).ready(function(){
	$(".J_brandLetter li").mouseover(function(){
		var ee11 =this;
		var selectdata=ee11.getAttribute('data-initial');
		$(".J_brandLetter li").each(function(){
			this.className="";
		});
		ee11.className="curr";
		$("#brand-8557111 li").each(function(){
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
	});


