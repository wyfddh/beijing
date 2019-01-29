 var isDisabledto_=false;
var defineBianKuangCss_="border:1px solid #CBCDCE;";
var defineDetailBianKuangCss_="border:1px solid #CBCDCE;";


function JD_BUSSTitleDataHtml(mainColumnsTitle,mainColumnsTitleHtmlId,name) {
	var mainColumnsHtml="";
	if(mainColumnsTitle.length>0){
		var countWidth=0;//算出需要显示的总宽度，用于计算宽度
		$(mainColumnsTitle).each(function(i,val) {
			if(val.isShow!="Y"&&val.isListHide!="Y"){
				countWidth=(parseInt(countWidth)+parseInt(val.dataLength));
			}
		});
		mainColumnsHtml+="<th style='text-align: inherit;width:10px;"+defineBianKuangCss_+"' align='center'>" +
				" <input  onclick='thatClickMain(\""+name+"\",this)' type='checkbox' typelist='main'   >" +
						"</th>";
		mainColumnsHtml+="<th style='text-align: inherit;width:50px;"+defineBianKuangCss_+"' align='center'>序号</th>";
		$(mainColumnsTitle).each(function(i,val) {
			mainColumnsHtml+="<th  ";
 			if((val.isShow=="Y"&&val.isListHide=="Y")){
 				mainColumnsHtml+=" style='text-align:center;display: none;"+defineBianKuangCss_+"' ";
 				mainColumnsHtml+=" >";
 			}else{
 				mainColumnsHtml+=" style='text-align:center;width:"+(parseInt(val.dataLength)/parseInt(countWidth)*90)+"%;"+defineBianKuangCss_+"' ";
 				mainColumnsHtml+=" >";
 			}
 			mainColumnsHtml+=val.titleName+"</th>";
 		});
	}
	$("#"+mainColumnsTitleHtmlId).html(mainColumnsHtml);
}

function thatClickMain(name,that){
	 $("#"+name+"_cf_body").find('input:checkbox').each(function(){
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		});
}

function JD_BUSSBodyDataHtml(mainColumns,mainColumnsHtmlId,listStyle,name) {
	var mainColumnsHtml="";
	$(mainColumns).each(function(i,val1) {
		mainColumnsHtml+="<tr  "+("zc"==listStyle?"onclick=\""+name+"_goRightWindows('"+val1["ID"]+"')\"":"")+" > ";
		mainColumnsHtml+="<td  style='"+defineDetailBianKuangCss_+"' align='center'>" +
		"<input  type='checkbox' type='checkbox' typelist='main' ";
		//循环得到所有字段的值，放在复选框中---------
		for(var item in val1){
                var jValue=val1[item];//key所对应的value
                if("mainColumn"!=item&&"$reinitialize"!=item){
                	 mainColumnsHtml+=item+"='"+jValue+"'";
                }
        }
		mainColumnsHtml+=" ></td>";
		mainColumnsHtml+="<td  style='"+defineDetailBianKuangCss_+"' align='center'>"+(val1.XH+i+1)+"</td>";
		$(val1.mainColumn).each(function(ii,val11) {
			mainColumnsHtml+="<td align='center'  ";
			if(val11.isShow=="Y"&&val11.isListHide=="Y"){
				mainColumnsHtml+=" style='display: none;"+defineBianKuangCss_+"' ";
			}else{
				mainColumnsHtml+="style='"+defineBianKuangCss_+"' ";
			}
			mainColumnsHtml+=" ><span>";
			mainColumnsHtml+=val11.value;
			mainColumnsHtml+="</span> ";
			mainColumnsHtml+="</td> ";
			});
		mainColumnsHtml+="</tr > ";
	});
	$("#"+mainColumnsHtmlId).html(mainColumnsHtml);
}