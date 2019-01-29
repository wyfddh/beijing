var type_ss_20180822="";
function initHelp(flag,type) {
	type_ss_20180822=type;
	var storage_=window.localStorage;
	if(flag=="0"&&storage_["isShow"]=="false"){
		return false;
	}
    show({
        steps: [{
            ele: "#help_1",
            nm: "1",
            intro: "<p class='title'><strong>表单设计区</strong>中的控件是可以拖动的。</p><p class='desc'>各个控件可以放大和缩小</strong>且<strong>只能按照等比例缩放</p>",
            intropos: {
                left: ($("#design_left").width()+$("#design_center").width()+20),
                top: $("#design_north").height(),
                arrowDect: "left"
            },
            numPos: {
                top: "-16px",
                right: "-16px"
            }
        }, {
            ele: "#help_1",
            nm: "2",
            intro: "<p class='title'><strong>隐藏字段区</strong></p><p class='desc'>可以把表单不需要显示的字段放在这里面，比如主键id或者其他隐藏字段，系统会把默认字段加载进来。</p>",
            intropos: {
                left: ($("#design_left").width()+$("#design_center").width()+20),
                top: $("#design_north").height(),
                arrowDect: "left"
            },
            numPos: {
                top: "-8px",
                right: "-16px"
            }
        }, {
            ele: "#design_event",
            nm: "3",
            intro: "<p class='title'><strong>事件绑定</strong></p><p class='desc'>里面可以给每一个元素绑定事件，事件函数包括：<strong>单击事件</strong>、<strong>双击事件</strong>、<strong>获取光标事件</strong>、<strong>失去光标事件</strong>，对于下拉控件还增加了<strong>数据更改回调</strong>事件。</p>",
            intropos: {
                left: $("#design_left").width()+20,
                top: $("#design_north").height()+$("#help_1").height()-150,
                arrowDect: "bottom"
            },
            numPos: {
                top: "-16px",
                right: "-16px"
            }
        }, {
            ele: "#design_event",
            nm: "4",
            intro: "<p class='title'><strong>预览js</strong></p><p class='desc'>里面可以即时的预览js文本。</p>",
            intropos: {
            	left: $("#design_left").width()+120,
                top: $("#design_north").height()+$("#help_1").height()-90,
                arrowDect: "bottom"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }, {
            ele: "#design_event",
            nm: "5",
            intro: "<p class='title'>当您不知道事件是怎么运行的时候，您可以查看<strong>“帮助”</strong></p>",
            intropos: {
            	left: $("#design_left").width()+220,
                top: $("#design_north").height()+$("#help_1").height()-80,
                arrowDect: "bottom"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }, {
            ele: "#design_left",
            nm: "6",
            intro: "<p class='title'><strong>指标</strong></p><p class='desc'>是预先定义好的，在指标管理里面维护。</p>",
            intropos: {
            	left: $("#design_left").width()+20,
                top: $("#design_north").height()+50,
                arrowDect: "left"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }, {
            ele: "#design_left",
            nm: "7",
            intro: "<p class='title'><strong>控件</strong></p><p class='desc'>分为常用控件和虚拟控件。</p>",
            intropos: {
            	left: $("#design_left").width()+20,
                top: $("#design_north").height()+50,
                arrowDect: "left"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }, {
            ele: "#design_right",
            nm: "8",
            intro: "<p class='title'><strong>字段属性</strong></p><p class='desc'>可以维护控件基本信息，点击表单中某个控件来维护控件基本信息</p>",
            intropos: {
            	left: ($("#design_left").width()+$("#design_center").width()-$("#design_right").width())+10,
                top: $("#design_north").height()+50,
                arrowDect: "right"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }, {
            ele: "#design_right",
            nm: "9",
            intro: "<p class='title'><strong>表单属性</strong></p><p class='desc'>可以维护表单基本信息</p>",
            intropos: {
            	left: ($("#design_left").width()+$("#design_center").width()-$("#design_right").width())+10,
                top: $("#design_north").height()+50,
                arrowDect: "right"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }, {
            ele: "#design_north",
            nm: "10",
            intro: "<p class='title'><strong>按钮操作区域</strong></p><p class='desc'>分为保存、预览等按钮，点击保存按钮可以保存当前配置结果，点击预览可以实时预览表单，点击关闭按钮则直接关闭设计页面，好了，介绍完了，开始设计表单吧！</p>",
            intropos: {
            	left: 10,
                top: $("#design_north").height()+20,
                arrowDect: "top"
            },
            numPos: {
                top: "-16px",
                left: "-16px"
            }
        }]
    });
    bindEv();
}

function bindEv() {
    // bk.event.on("introShowSingle", showSingle());
    // bk.event.on("introShowAnimation",
    // introShowAnimation());
    // bk.event.on("introHideSingle", hideSingle());
}

function show(c) {
    if (!c && !c.steps) {
        return;
    }
    this.opt = c;
    this.currentStep = 0;
    this._showElement();
}

function showSingle(c) {
    $("" + c).show();
    if (!c) {
        return;
    }
    this.opt = {
        steps: [{
            ele: c
        }]
    };
    this.currentStep = 0;
    _showElement();
    $("#introjs-helperLayer").hide();
}

function introShowAnimation(c) {
    $("" + c).addClass("animated").addClass("bounceInLeft").one("webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend", function() {
        $(this).removeClass("animated").removeClass("bounceInLeft")
    });
}

function hideSingle(c) {
    skip();
}

function _addOverlayLayer() {
    if (!document.getElementById("introjs-overlay")) {
        var c = document.createElement("div"),
            d = "";
        c.className = "introjs-overlay";
        c.id = "introjs-overlay";
        d += "top: 0;bottom: 0;opacity: 0.8; left: 0;right: 0;position: fixed;";
        c.setAttribute("style", d);
        document.body.appendChild(c);
    }
}

function _addHelpLayer(e, d) {
    if (!this.helperLayer) {
        var c = document.createElement("div");
        c.id = "introjs-helperLayer";
        c.className = "introjs-helperLayer";
        document.body.appendChild(c);
        this.helperLayer = c;
    }
    $(this.helperLayer).css({
        left: e.left + "px",
        top: e.top + "px",
        width: d.width,
        height: d.height
    });
    $("#introjs-overlay").show();
    $("#introjs-helperLayer").show();
}

function skip() {
    $("#introjs-overlay").hide();
    $("#introjs-helperLayer").hide();
    this.removeRelativeClass();
}

function bulidTipText() {
    var c = this.opt.steps[this.currentStep];
}

function _addTipLayer() {
	
    var d = this;
    if (!document.getElementById("introjs-helperNumberLayer")) {
        var c = ['<div id="introjs-tooltip" class="introjs-tooltip">', '<span id="introjs-helperNumberLayer" class="introjs-helperNumberLayer">?</span>', '<div id="introjs-tooltiptext" class="introjs-tooltiptext">', "</div>", '<div class="introjs-tooltipbuttons">', '<a id="introjs-skipbutton" class="introjs-button introjs-skipbutton" href="javascript:void(0);">我知道了</a>', '<a id="introjs-prevbutton" href="javascript:void(0);" class="introjs-button introjs-prevbutton introjs-disabled">上一步</a>', '<a id="introjs-nextbutton" href="javascript:void(0);" class="introjs-button introjs-nextbutton">下一步</a>', "</div>", '<div id = "introjs-arrow"></div>', "</div>"];
        $("#introjs-helperLayer").html(c.join(""));
        $("#introjs-nextbutton").on("click", function() {
            d.nextStep();
            return false
        });
        $("#introjs-prevbutton").on("click", function() {
            if ($(this).hasClass("introjs-disabled")) {
                return false
            }
            d.backStep();
            return false
        });
        $("#introjs-skipbutton").on("click", function() {
            d.skip();
            var storage=window.localStorage;
            storage["isShow"]="false";
            return false
        })
    }
    var e = this.opt.steps[this.currentStep];
    //$("#introjs-helperNumberLayer").text(this.currentStep + 1);
    $("#introjs-tooltiptext").html(e.intro);
    
    if (e.numPos) {
        $("#introjs-helperNumberLayer").css({
            right: e.numPos["right"],
            top: e.numPos["top"],
            left: e.numPos["left"] || "auto"
        });
    }
    if (e.intropos) {
        $("#introjs-tooltip").css({
            left: e.intropos["left"],
            top: e.intropos["top"]
        });
        document.getElementById("introjs-arrow").className = "introjs-arrow " + e.intropos["arrowDect"]
    }
    this.updateBtnStatus();
}

function updateBtnStatus() {
    $("#introjs-tooltip").find(".introjs-disabled").removeClass("introjs-disabled");
    if (this.currentStep == 0) {
        $("#introjs-prevbutton").addClass("introjs-disabled");
    }
    if (this.currentStep == this.opt.steps.length - 1) {
        $("#introjs-nextbutton").text("完成");
    } else {
        $("#introjs-nextbutton").text("下一步");
    }
}

function nextStep() {
    this.currentStep++;
    
    if (this.opt.steps.length <= this.currentStep) {
        this.skip();
        return
    }
    
    var h = this.opt.steps[this.currentStep];
    if(type_ss_20180822!="1"&&"#design_event"==h.ele){
    	this.currentStep=this.currentStep+3;
	}
    _showElement();
}

function backStep() {
    this.currentStep--;
    var h = this.opt.steps[this.currentStep];
    if(type_ss_20180822!="1"&&"#design_event"==h.ele){
    	this.currentStep=this.currentStep-3;
	}
    this._showElement();
}

function removeRelativeClass() {
    $(".introjs-relativePosition").removeClass("introjs-relativePosition");
    $(".introjs-showElement").removeClass("introjs-showElement");
    $(".introjs-fixParent").removeClass("introjs-fixParent");
}

function _showElement() {
    var h = this.opt.steps[this.currentStep];
    $targetElem = $(h.ele);
    var e = $targetElem.offset(),
        c = {
            width: $targetElem.width(),
            height: $targetElem.height()
        };
    if($targetElem.length>0){
    	 	
    	    if(h.nm=="1"){
    	    	layui_element.tabChange('designMain', 'help_1');
    	    }
    	    if(h.nm=="2"){
    	    	layui_element.tabChange('designMain', 'help_2');
    	    	$("[design-fieldname='id']").closest(".grid-stack-item").click();
    	    }
    	    if(h.nm=="3"){
    	    	layui_element.tabChange('jsTabBrief', 'designJsEvent');
    	    }
    	    if(h.nm=="4"){
    	    	layui_element.tabChange('jsTabBrief', 'designJsPreview');
    	    }
    	    if(h.nm=="5"){
    	    	layui_element.tabChange('jsTabBrief', 'designJsHelp');
    	    }
    	    if(h.nm=="6"){
    	    	layui_element.tabChange('docDemoTabBrief_left', 'ZB');
    	    }
    	    if(h.nm=="7"){
    	    	layui_element.tabChange('docDemoTabBrief_left', 'KJ');
    	    }
    	    if(h.nm=="8"){
    	    	layui_element.tabChange('docDemoTabBrief', 'FieldSet');
    	    }
    	    if(h.nm=="9"){
    	    	layui_element.tabChange('docDemoTabBrief', 'formSet');
    	    }
    	    this.removeRelativeClass();
    	    this._addOverlayLayer();
    	    this._addHelpLayer(e, c);
    	    this._addTipLayer();
    	    $targetElem.addClass("introjs-showElement");
    	    var g = $targetElem.css("position");
    	    if (g !== "absolute" && g !== "relative") {
    	        $targetElem.addClass("introjs-relativePosition");
    	    }
    	    var d = $targetElem[0].parentNode;
    	    while (d != null) {
    	        if (d.tagName.toLowerCase() === "body") {
    	            break
    	        }
    	        var f = $(d).css("z-index");
    	        if (/[0-9]+/.test(f)) {
    	            d.className += " introjs-fixParent";
    	        }
    	        d = d.parentNode;
    	    }
    }else{
    	
    }
    
   
}