
var cityDataUrl="designController.do?getCityData";

function getCityData(pid){
	var resultData;
	$.ajax({
		async : false,
	    url: cityDataUrl,
	    data:{pid:pid},
	    success: function(data) {
	    	resultData=data;
	    },
	    error: function(data) {
	        parent.layer.msg("error:" + data.responseText, {
	            icon: 5
	        });
	    }
	});
	return resultData;
}

function SelCity(obj, e,fieldName) {
	var province;
	
//	$.getJSON(cityDataUrl,function(resultProvince) {
		province=getCityData("");
//	});
    var ths = obj;
    var dal = '<div class="_citys" id="'+fieldName+'_citys_1" style="width:'+$("#"+fieldName+"_sel_city").width()+'px;">'+
    '<span title="关闭" id="'+fieldName+'_cColse" >×</span>'+
    '<div id="'+fieldName+'_citysheng" class="_citys0">请选择省份</div>'+
    '<div id="'+fieldName+'_citys0" class="_citys1"></div>'+
    '<div style="display:none" id="'+fieldName+'_citys1" class="_citys1"></div>'+
    '<div style="display:none" id="'+fieldName+'_citys2" class="_citys1"></div>'+
    '<div style="display:none" id="'+fieldName+'_citys3" class="_citys1"></div>'+
    '</div>';
    Iput.show({
        id: ths,
        event: e,
        content: dal,
        width: $("#"+fieldName+"_sel_city").width()
    });
    $("#"+fieldName+"_citys_1 #"+fieldName+"_cColse").click(function() {
        Iput.colse()
    });
    var tb_province = [];
    var b =province;
    console.log(b);
    for (var i = 0,len = b.length; i < len; i++) {
        tb_province.push('<a data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '" title="' + b[i]['name'] + '">' + b[i]['name'] + '</a>')
    }
    $("#"+fieldName+"_citys_1 #"+fieldName+"_citys0").append(tb_province.join(""));
    $("#"+fieldName+"_citys_1 #"+fieldName+"_citys0 a").click(function() {
        var g = getCity($(this),fieldName);
        $("#"+fieldName+"_citys_1 #"+fieldName+"_citys1 a").remove();
        $("#"+fieldName+"_citys_1 #"+fieldName+"_citys1").append(g);
        $("#"+fieldName+"_citys_1 ._citys1").hide();
        $("#"+fieldName+"_citys_1 ._citys1:eq(1)").show();
        $("#"+fieldName+"_citys_1 #"+fieldName+"_citys0 a,#"+fieldName+"_citys_1 #"+fieldName+"_citys1 a,#"+fieldName+"_citys_1 #"+fieldName+"_citys2 a").removeClass("AreaS");
        $(this).addClass("AreaS");
        var lev = $(this).data("name");
        ths.value = $(this).data("name");
        if (document.getElementById(fieldName+"_province") == null) {
            var hcitys = $('<input>', {
                type: 'hidden',
                name: fieldName+"_province",
                "data-id": $(this).data("id"),
                id: fieldName+"_province",
                val: lev
            });
            $(ths).after(hcitys)
        } else {
            $("#"+fieldName+"_province").val(lev);
            $("#"+fieldName+"_province").attr("data-id", $(this).data("id"))
        }
        $("#"+fieldName+"_city").remove();
        $("#"+fieldName+"_county").remove();
        $("#"+fieldName+"_citys_1 #"+fieldName+"_citys1 a").click(function() {
            $("#"+fieldName+"_citys_1 #"+fieldName+"_citys1 a,#"+fieldName+"_citys_1 #"+fieldName+"_citys2 a").removeClass("AreaS");
            $(this).addClass("AreaS");
            var lev = $(this).data("name");
            if (document.getElementById(fieldName+"_city") == null) {
                var hcitys = $('<input>', {
                    type: 'hidden',
                    name: fieldName+"_city",
                    "data-id": $(this).data("id"),
                    id: fieldName+"_city",
                    val: lev
                });
                $(ths).after(hcitys)
            } else {
                $("#"+fieldName+"_city").attr("data-id", $(this).data("id"));
                $("#"+fieldName+"_city").val(lev)
            }
            var bc = $("#"+fieldName+"_province").val();
            ths.value = bc + "/" + $(this).data("name");
            var ar = getArea($(this),fieldName);
            $("#"+fieldName+"_citys_1 #"+fieldName+"_citys2 a").remove();
            if (ar == '') Iput.colse();
            $("#"+fieldName+"_citys_1 #"+fieldName+"_citys2").append(ar);
            $("#"+fieldName+"_citys_1 ._citys1").hide();
            $("#"+fieldName+"_citys_1 ._citys1:eq(2)").show();
            $("#"+fieldName+"_county").remove();
            $("#"+fieldName+"_citys_1 #"+fieldName+"_citys2 a").click(function() {
            	 
                $("#"+fieldName+"_citys_1 #"+fieldName+"_citys2 a").removeClass("AreaS");
                $(this).addClass("AreaS");
                var lev = $(this).data("name");
                if (document.getElementById(fieldName+"_county") == null) {
                    var hcitys = $('<input>', {
                        type: 'hidden',
                        name: fieldName+"_county",
                        "data-id": $(this).data("id"),
                        id: fieldName+"_county",
                        val: lev
                    });
                    $(ths).after(hcitys)
                } else {
                    $("#"+fieldName+"_county").val(lev);
                    $("#"+fieldName+"_county").attr("data-id", $(this).data("id"))
                }
                var bc = $("#"+fieldName+"_province").val();
                var bp = $("#"+fieldName+"_city").val();
                ths.value = bc + "/" + bp + "/" + $(this).data("name");
                
                var g = getAddress($(this),fieldName);
            	$("#"+fieldName+"_citys_1 #"+fieldName+"_citys3").append(g);
            	 $("#"+fieldName+"_citys_1 ._citys1").hide();
            	 $("#"+fieldName+"_citys_1 ._citys1:eq(3)").show();
            	 $("#"+fieldName+"_citys_1 #"+fieldName+"_citys3 input").on('input',function(){
            		 
            		 if (document.getElementById(fieldName+"_address") == null) {
                         var hcitys = $('<input>', {
                             type: 'hidden',
                             name: fieldName+"_address",
                             id: fieldName+"_address",
                             val: $(this).val()
                         });
                         $(ths).after(hcitys)
                     } else {
                         $("#"+fieldName+"_address").val($(this).val());
                     }
                     var bc = $("#"+fieldName+"_province").val();
                     var bp = $("#"+fieldName+"_city").val();
                     var ct = $("#"+fieldName+"_county").val();
                     ths.value = bc + "/" + bp + "/" + ct+"/"+$(this).val();
            	 });
            	 $("#"+fieldName+"_citys_1 #"+fieldName+"_citys3 a").click(function() {
            		 var address=$("#"+fieldName+"_address").val();
            		 if(address==""){
            			 layer.msg('请输入详细地址',{icon: 5});
            			 return;
            		 }
            		 Iput.colse();
            	 });
            })
        })
    })
}
function getCity(obj,fieldName) {
    var c = obj.data('id');
    $.ajaxSettings.async = false;
    var e;
    var f = [];
//	$.getJSON(cityDataUrl+"&pid="+c,function(resultCity) {
		f=getCityData(c);
//	});
    
    var g = '';
//    for (var i = 0; i < e.length; i++) {
//        if (e[i]['id'] == c) {
//            f = e[i]['son'];
//            break
//        }
//    }
    
    for (var j = 0; j < f.length; j++) {
        g += '<a data-id="' + f[j]['id'] + '" data-name="' + f[j]['name'] + '" title="' + f[j]['name'] + '">' + f[j]['name'] + '</a>'
    }
    $("#"+fieldName+"_citys_1 #"+fieldName+"_citysheng").html('请选择城市');
    
    return g
}
function getArea(obj,fieldName) {
    var c = obj.data('id');
    $.ajaxSettings.async = false;
    var e;
    var f = [];
//	$.getJSON(cityDataUrl+"&pid="+c,function(resultArea) {
		e=getCityData(c);
		f=e;
//	});
    
    var g = '';
//    for (var i = 0; i < e.length; i++) {
//        for (var j = 0; j < e[i]['son'].length; j++) {
//            if (e[i]['son'][j]['id'] == c && e[i]['son'][j]['sec']) {
//                f = e[i]['son'][j]['sec'];
//                break
//            }
//        }
//    }
    if (f.length) {
        for (var k = 0; k < f.length; k++) {
            g += '<a data-id="' + f[k]['id'] + '" data-name="' + f[k]['name'] + '" title="' + f[k]['name'] + '">' + f[k]['name'] + '</a>'
        }
    }
    $("#"+fieldName+"_citys_1 #"+fieldName+"_citysheng").html('请选择区县');
    return g
}

function getAddress(obj,fieldName) {
    var g = '<input type="text" style="width: 95%;'+
    'height: 34px;'+
    'display: inline-block;'+
    'padding: 0px 5px;'+
    'font-size: 14px;'+
    'margin-left: 6px;" placeholder="请输入" value=""><a>确定</a>';
    $("#"+fieldName+"_citys_1 #"+fieldName+"_citysheng").html('请输入详细地址');
    return g
}

