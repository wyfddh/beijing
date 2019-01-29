
//全局控件对象

var TANGER_OCX_OBJ;

//常量定义
var OfficeType = {
    fileType: {
        Word: "Word.Document",
        Excel: "Excel.Sheet",
        PowerPoint: "PowerPoint.Show"
    },
    fileSimpleType: {
        Word: "wrod",
        Excel: "excel",
        PowerPoint: "ppt"
    }
}

// 请勿修改，否则可能出错
var userAgent = navigator.userAgent,
				rMsie = /(msie\s|trident.*rv:)([\w.]+)/,
				rFirefox = /(firefox)\/([\w.]+)/,
				rOpera = /(opera).+version\/([\w.]+)/,
				rChrome = /(chrome)\/([\w.]+)/,
				rSafari = /version\/([\w.]+).*(safari)/;
var browser;
var version;
var ua = userAgent.toLowerCase();
function uaMatch(ua) {
    var match = rMsie.exec(ua);
    if (match != null) {
        return { browser: "IE", version: match[2] || "0" };
    }
    var match = rFirefox.exec(ua);
    if (match != null) {
        return { browser: match[1] || "", version: match[2] || "0" };
    }
    var match = rOpera.exec(ua);
    if (match != null) {
        return { browser: match[1] || "", version: match[2] || "0" };
    }
    var match = rChrome.exec(ua);
    if (match != null) {
        return { browser: match[1] || "", version: match[2] || "0" };
    }
    var match = rSafari.exec(ua);
    if (match != null) {
        return { browser: match[2] || "", version: match[1] || "0" };
    }
    if (match != null) {
        return { browser: "", version: "0" };
    }
}
var browserMatch = uaMatch(userAgent.toLowerCase());
if (browserMatch.browser) {
    browser = browserMatch.browser;
    version = browserMatch.version;
}
//document.write(browser);
/*
谷歌浏览器事件接管
*/
function OnComplete2(type, code, html) {
    //alert(type);
    //alert(code);
    //alert(html);
    //alert("SaveToURL成功回调");
}
function OnComplete(type, code, html) {
    //alert(type);
    //alert(code);
    //alert(html);
    //alert("BeginOpenFromURL成功回调");
}
function OnComplete3(str, doc) {
    TANGER_OCX_OBJ.activeDocument.saved = true; //saved属性用来判断文档是否被修改过,文档打开的时候设置成ture,当文档被修改,自动被设置为false,该属性由office提供.
    //	TANGER_OCX_OBJ.SetReadOnly(true,"");
    //TANGER_OCX_OBJ.ActiveDocument.Protect(1,true,"123");
    //获取文档控件中打开的文档的文档类型
    switch (TANGER_OCX_OBJ.doctype) {
        case 1:
            fileType = "Word.Document";
            fileTypeSimple = "wrod";
            break;
        case 2:
            fileType = "Excel.Sheet";
            fileTypeSimple = "excel";
            break;
        case 3:
            fileType = "PowerPoint.Show";
            fileTypeSimple = "ppt";
            break;
        case 4:
            fileType = "Visio.Drawing";
            break;
        case 5:
            fileType = "MSProject.Project";
            break;
        case 6:
            fileType = "WPS Doc";
            fileTypeSimple = "wps";
            break;
        case 7:
            fileType = "Kingsoft Sheet";
            fileTypeSimple = "et";
            break;
        default:
            fileType = "unkownfiletype";
            fileTypeSimple = "unkownfiletype";
    }

    //alert("ondocumentopened成功回调");
}
function publishashtml(type, code, html) {
    alert(html);
    alert("Onpublishashtmltourl成功回调");
}
function publishaspdf(type, code, html) {
    alert(html);
    alert("Onpublishaspdftourl成功回调");
}
function saveasotherurl(type, code, html) {
    alert(html);
    alert("SaveAsOtherformattourl成功回调");
}
function dowebget(type, code, html) {
    alert(html);
    alert("OnDoWebGet成功回调");
}
function webExecute(type, code, html) {
    alert(html);
    alert("OnDoWebExecute成功回调");
}
function webExecute2(type, code, html) {
    alert(html);
    alert("OnDoWebExecute2成功回调");
}
function FileCommand(TANGER_OCX_str, TANGER_OCX_obj) {
    if (TANGER_OCX_str == 3) {
        alert("不能保存！");
        TANGER_OCX_OBJ.CancelLastCommand = true;
    }
}
function CustomMenuCmd(menuPos, submenuPos, subsubmenuPos, menuCaption, menuID) {
    alert("第" + menuPos + "," + submenuPos + "," + subsubmenuPos + "个菜单项,menuID=" + menuID + ",菜单标题为\"" + menuCaption + "\"的命令被执行.");
}

//创建对象
function initObj() {
    var classid = 'C9BC4DFF-4248-4a3c-8A49-63A7D317F404';
    if (browser == "IE") {
       
        document.write('<!-- 用来产生编辑状态的ActiveX控件的JS脚本-->   ');
        document.write('<!-- 因为微软的ActiveX新机制，需要一个外部引入的js-->   ');
        document.write('<object id="TANGER_OCX" classid="clsid:C39F1330-3322-4a1d-9BF0-0BA2BB90E970"');
        document.write('codebase="' + $.formServerUrl + 'designPlug-in/ntkooffice/downLoadedFiles/ofctnewclsid.cab#version=5,0,2,7" width="500px" height="500px">   ');
        document.write('<param name="IsUseUTF8URL" value="-1" />   ');
        document.write('<param name="IsUseUTF8Data" value="-1"/>   ');
        document.write('<param name="BorderStyle" value="1"/>   ');
        document.write('<param name="BorderColor" value="14402205"/>   ');
        document.write('<param name="TitlebarColor" value="15658734"/>   ');
        document.write('<param name="isoptforopenspeed" value="0"/>   ');
        document.write('<param name="MakerCaption" value="Beijing CSSCA Software Technology Co.,Ltd."/>  ');
        document.write('<param name="MakerKey" value="B229E289464B5EF63FDA2FFC82C6643D6851D169"/>  ');
        document.write('<param name="ProductCaption" value="国家文物局OA系统"/>   ');
        document.write('<param name="ProductKey" value="CD7CF84B53BC46AA831726D62F10A906020C31A3"/>  ');
        document.write('<param name="TitlebarTextColor" value="0"/>   ');
        document.write('<param name="MenubarColor" value="14402205"/>   ');
        document.write('<param name="MenuButtonColor" value="16180947"/>   ');
        document.write('<param name="MenuBarStyle" value="3"/>   ');
        document.write('<param name="MenuButtonStyle" value="7"/>   ');

        //document.write('<param name="WebUserName" value="NTKO"/>   ');
        document.write('<param name="Caption" value=""/>   ');
        document.write('<param name="CustomMenuCaption" value="我的菜单">');
        document.write('<span style="color:red">不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</span>   ');
        document.write('</object>');
    }
    else{
    	 //alert("暂不支持IE以外的浏览器！请使用ie浏览器");
    	return false;
    }
    /****/
   /**
    else if (browser == "firefox") {
    	
        document.write('<object id="TANGER_OCX" type="application/ntko-plug"  codebase="webpage/bpm/comm/projecreply/downLoadedFiles/ofctnewclsid.cab#version=5,0,2,2" width="100%" height="'+availHeight+'" ForOnSaveToURL="OnComplete2" ForOnBeginOpenFromURL="OnComplete" ForOndocumentopened="OnComplete3"');
        document.write('ForOnpublishAshtmltourl="publishashtml"');
        document.write('ForOnpublishAspdftourl="publishaspdf"');
        document.write('ForOnSaveAsOtherFormatToUrl="saveasotherurl"');
        document.write('ForOnDoWebGet="dowebget"');
        document.write('ForOnDoWebExecute="webExecute"');
        document.write('ForOnDoWebExecute2="webExecute2"');
        document.write('ForOnFileCommand="FileCommand"');
        document.write('ForOnCustomMenuCmd2="CustomMenuCmd"');
        document.write('_IsUseUTF8URL="-1"   ');
        document.write('_MakerCaption="Beijing CSSCA Software Technology Co.,Ltd."  ');
        document.write('_MakerKey="B229E289464B5EF63FDA2FFC82C6643D6851D169"  ');
        document.write('_ProductCaption="国家文物局OA系统"   ');
        document.write('_ProductKey="CD7CF84B53BC46AA831726D62F10A906020C31A3"  ');
        document.write('_IsUseUTF8Data="-1"   ');
        document.write('_BorderStyle="1"   ');
        document.write('_BorderColor="14402205"   ');
        document.write('_MenubarColor="14402205"   ');
        document.write('_MenuButtonColor="16180947"   ');
        document.write('_MenuBarStyle="3"  ');
        document.write('_MenuButtonStyle="7"   ');
        //document.write('_WebUserName="NTKO"   ');
        document.write('clsid="{C39F1330-3322-4a1d-9BF0-0BA2BB90E970}" >');
        document.write('<SPAN STYLE="color:red">尚未安装NTKO Web FireFox跨浏览器插件。请点击<a href="webpage/bpm/comm/projecreply/downLoadedFiles/ntkoplugins.xpi">安装组1件</a></SPAN>   ');
        document.write('</object>   ');
    } else if (browser == "chrome") {
        document.write('<object id="TANGER_OCX" clsid="{C39F1330-3322-4a1d-9BF0-0BA2BB90E970}"  ForOnSaveToURL="OnComplete2" ForOnBeginOpenFromURL="OnComplete" width="100%" height="'+availHeight+'" ForOndocumentopened="OnComplete3"');
        document.write('ForOnpublishAshtmltourl="publishashtml"');
        document.write('ForOnpublishAspdftourl="publishaspdf"');
        document.write('ForOnSaveAsOtherFormatToUrl="saveasotherurl"');
        document.write('ForOnDoWebGet="dowebget"');
        document.write('ForOnDoWebExecute="webExecute"');
        document.write('ForOnDoWebExecute2="webExecute2"');
        document.write('ForOnFileCommand="FileCommand"');
        document.write('ForOnCustomMenuCmd2="CustomMenuCmd"');
        document.write('_MakerCaption="Beijing CSSCA Software Technology Co.,Ltd."  ');
        document.write('_MakerKey="B229E289464B5EF63FDA2FFC82C6643D6851D169"  ');
        document.write('_ProductCaption="国家文物局OA系统"   ');
        document.write('_ProductKey="CD7CF84B53BC46AA831726D62F10A906020C31A3"  ');
        document.write('codebase="webpage/bpm/comm/projecreply/downLoadedFiles/ofctnewclsid.cab#version=5,0,2,2" width="100%" height="100%" type="application/ntko-plug" ');
        document.write('_IsUseUTF8URL="-1"   ');
        document.write('_IsUseUTF8Data="-1"   ');
        document.write('_BorderStyle="1"   ');
        document.write('_BorderColor="14402205"   ');
        document.write('_MenubarColor="14402205"   ');
        document.write('_MenuButtonColor="16180947"   ');
        document.write('_MenuBarStyle="3"  ');
        document.write('_MenuButtonStyle="7"   ');
        //document.write('_WebUserName="NTKO"   ');
        document.write('_Caption="NTKO OFFICE文档控件示例演示 http://www.ntko.com">    ');
        document.write('<SPAN STYLE="color:red">尚未安装NTKO Web Chrome跨浏览器插件。请点击<a href="webpage/bpm/comm/projecreply/downLoadedFiles/ntkoplugins.crx">安装组件</a></SPAN>   ');
        document.write('</object>');
    } else if (Sys.opera) {
        alert("sorry,ntko web印章暂时不支持opera!");
    } else if (Sys.safari) {
        alert("sorry,ntko web印章暂时不支持safari!");
    }
*/
    
    TANGER_OCX_OBJ = document.getElementById("TANGER_OCX");
}

//创建word
function CreateWord() {
    TANGER_OCX_OBJ.activate(true);
    TANGER_OCX_OBJ.CreateNew(OfficeType.fileType.Word);
//    ShowMenubar(true);
    ShowTitleBar(false);
//    ShowStatusbar(false);
//    ShowToolbars(true);
//    SetNoCopy(false);
//    //AddMyMenuItems();

//    TANGER_OCX_OBJ.IsShowInsertMenu = false;
//    TANGER_OCX_OBJ.IsShowEditMenu = false;
//    TANGER_OCX_OBJ.FileNew = false; //设置新建菜单
//    TANGER_OCX_OBJ.FileOpen = false; //设置打开菜单
//    TANGER_OCX_OBJ.FileClose = false; //设置关闭菜单
//    TANGER_OCX_OBJ.FileSave = true; //设置保存菜单
//    TANGER_OCX_OBJ.FileSaveAs = false; //设置另存菜单
//    TANGER_OCX_OBJ.FilePrint = false; //设置打印菜单
//    TANGER_OCX_OBJ.FilePrintPreview = false; //设置打印预览菜单
//    TANGER_OCX_OBJ.FilePageSetup = false; //设置打印设置菜单
//    TANGER_OCX_OBJ.FileProperties = false; //设置属性菜单
//    TANGER_OCX_OBJ.FullScreenMode = false;
//    //TANGER_OCX_OBJ.WebUserName = "admin"; //这个属性主要用于痕迹保留的用户名
}

//创建Excel
function CreateExcel() {
    TANGER_OCX_OBJ.CreateNew(OfficeType.fileType.Excel);
}

//创建PPT
function CreateExcel() {
    TANGER_OCX_OBJ.CreateNew(OfficeType.fileType.PowerPoint);
}

//创建菜单项
function AddMyMenuItems() {
    try {
        //在自定义主菜单中增加菜单项目
        TANGER_OCX_OBJ.AddCustomMenuItem('我的菜单1', false, false, 1);
        TANGER_OCX_OBJ.AddCustomMenuItem('');
        TANGER_OCX_OBJ.AddCustomMenuItem('我的菜单2', false, false, 2);
        TANGER_OCX_OBJ.AddCustomMenuItem('');
        TANGER_OCX_OBJ.AddCustomMenuItem('我的菜单3', false, true, 3);
        //在文件菜单中增加菜单项目
        TANGER_OCX_OBJ.AddFileMenuItem('创建Word文档', false, false, 1);
        TANGER_OCX_OBJ.AddFileMenuItem('创建Excel文档', false, false, 2);
        TANGER_OCX_OBJ.AddFileMenuItem('创建PPT文档', false, false, 3);
        TANGER_OCX_OBJ.AddFileMenuItem('关闭文档', false, true, 4);
        TANGER_OCX_OBJ.AddFileMenuItem('');
    }
    catch (err) {
        alert("不能创建新对象：" + err.number + ":" + err.description);
    }
    finally {
    }
}

//是否显示标题栏
function ShowTitleBar(bShow) {
	console.log("开始初始化是否显示标题栏..");
    TANGER_OCX_OBJ.Titlebar = false;
}

//是否显示菜单栏
function ShowMenubar(bShow) {
	console.log("开始初始化是否显示菜单栏..");
    TANGER_OCX_OBJ.Menubar = false;
}

//是否显状态栏
function ShowStatusbar(bShow) {
	console.log("开始初始化是否显状态栏..");
    TANGER_OCX_OBJ.Statusbar = bShow;
}

//是否显示工具栏
function ShowToolbars(bShow) {
	console.log("开始初始化是否显示工具栏..");
    TANGER_OCX_OBJ.Toolbars = bShow;
}

//允许或禁止用户从控件拷贝数据
function SetNoCopy(boolvalue) {
	console.log("开始初始化允许或禁止用户从控件拷贝数据..");
    TANGER_OCX_OBJ.IsNoCopy = boolvalue;
}

//工具菜单项控制
function ShowToolMenu(bShow) {
	console.log("开始初始化工具菜单项控制..");
    TANGER_OCX_OBJ.IsShowToolMenu = false;
}

//打开本地指定文件
function OpenLocalFile(filePath) {
	try {
    TANGER_OCX_OBJ.OpenLocalFile(filePath);
    //ShowTitleBar(false);
	}catch (err) {}
}

//从本地选择文件打开
function OpenSelectedFile() {
	try {
    TANGER_OCX_OBJ.ShowDialog(3);
	}catch (err) {}
}


function TANGER_OCX_SetDocUser(cuser) {
    with (TANGER_OCX_OBJ.ActiveDocument.Application) {
        UserName = cuser;
    }
}

function showAllMenu(blVisible) {
    ShowMenubar(blVisible);
    ShowTitleBar(blVisible);
    ShowStatusbar(blVisible);
    ShowToolbars(blVisible);
    //SetNoCopy(blVisible);
        //AddMyMenuItems();

    TANGER_OCX_OBJ.IsShowInsertMenu = blVisible;
    TANGER_OCX_OBJ.IsShowEditMenu = blVisible;
    TANGER_OCX_OBJ.FileNew = blVisible; //设置新建菜单
    TANGER_OCX_OBJ.FileOpen = blVisible; //设置打开菜单
    TANGER_OCX_OBJ.FileClose = blVisible; //设置关闭菜单
    TANGER_OCX_OBJ.FileSave = blVisible; //设置保存菜单
    TANGER_OCX_OBJ.FileSaveAs = blVisible; //设置另存菜单
    TANGER_OCX_OBJ.FilePrint = blVisible; //设置打印菜单
    TANGER_OCX_OBJ.FilePrintPreview = blVisible; //设置打印预览菜单
    TANGER_OCX_OBJ.FilePageSetup = blVisible; //设置打印设置菜单
    TANGER_OCX_OBJ.FileProperties = blVisible; //设置属性菜单
    TANGER_OCX_OBJ.FullScreenMode = false;
}


//进入或退出强制痕迹保留状态
function TANGER_OCX_SetMarkModify(boolvalue) {
	console.log("开始初始化进入或退出强制痕迹保留状态..开始..");
    TANGER_OCX_SetReviewMode(boolvalue);
    TANGER_OCX_EnableReviewBar(!boolvalue);
    console.log("开始初始化进入或退出强制痕迹保留状态..完成..");
}
//允许或禁止显示修订工具栏和工具菜单
function TANGER_OCX_EnableReviewBar(boolvalue) {
    TANGER_OCX_OBJ.ActiveDocument.CommandBars("Reviewing").Enabled = boolvalue;
    TANGER_OCX_OBJ.ActiveDocument.CommandBars("Track Changes").Enabled = boolvalue;
    TANGER_OCX_OBJ.IsShowToolMenu = boolvalue; //关闭或打开工具菜单
}
//打开或者关闭修订模式
function TANGER_OCX_SetReviewMode(boolvalue) {
	try {
    TANGER_OCX_OBJ.ActiveDocument.TrackRevisions = boolvalue;
	}catch (err) {}
}
//禁用修订按钮
function TANGER_OCX_DisenableReviewBar() {
    //TANGER_OCX_OBJ.ActiveDocument.Protect(0, false, "sdfdasf2342adfad", false, true);
}
//显示/不显示修订文字
function TANGER_OCX_ShowRevisions(boolvalue) {
	try {
    TANGER_OCX_OBJ.ActiveDocument.ShowRevisions = boolvalue;
	}catch (err) {}
}


function SaveToURlFile(url, fileFieldName, CPARA, fileName, HtmlForm) {
    return TANGER_OCX_OBJ.saveToURL(url, fileFieldName, CPARA, fileName, HtmlForm);
}

//设置修订按钮
function TANGER_OCX_SetEnableReviewBar(isVisible, isEnble) {
	console.log("开始初始化设置修订按钮..");
	try {
    TANGER_OCX_OBJ.SetRibbon("ReviewTrackChangesMenu", isVisible, isEnble);
	}catch (err) {}
	console.log("开始初始化设置修订按钮..完成..");
}

//设置修订接收
//isVisible是否显示
//isEnble 是否可用
function TANGER_OCX_Set(isVisible,isEnble) {
	console.log("开始初始化设置修订接收..");
	try {
    TANGER_OCX_OBJ.SetRibbon("ReviewAcceptChangeMenu", isVisible, isEnble);
	}catch (err) {}
	console.log("开始初始化设置修订接收..完成..");
}

//设置页面布局
function TANGER_OCX_ChgLayout() {
    try {
        TANGER_OCX_OBJ.showdialog(5); //设置页面布局
    }
    catch (err) {
        alert("错误：" + err.number + ":" + err.description);
    }
    finally {
    }
}

//打印当前文档,isBackground设置是否是后台打印
function TANGER_OCX_PrintDoc(isBackground) {
    var oldOption;
    try {
        var objOptions = TANGER_OCX_OBJ.ActiveDocument.Application.Options;
        oldOption = objOptions.PrintBackground;
        objOptions.PrintBackground = isBackground;
    }
    catch (err) { };
    TANGER_OCX_OBJ.printout(true);
    try {
        var objOptions = TANGER_OCX_OBJ.ActiveDocument.Application.Options;
        objOptions.PrintBackground = oldOption;
    }
    catch (err) { };
}

var fuJianRootPath = "\\UploadFiles";

//查看office
function readOffice(filePath) {
    TANGER_OCX_OBJ = document.getElementById("TANGER_OCX"); //;初始化控件对象
    if (!TANGER_OCX_OBJ) {
        return;
    }
    ShowTitleBar(false);
    ShowMenubar(false);
    if ((typeof (filePath) != "undefined") && (filePath != "")) {
        //TANGER_OCX_OBJ.BeginOpenFromURL(filePath);
        TANGER_OCX_OBJ.OpenFromURL(filePath);
        //showAllMenu(true);
    }
}
//编辑文档
//filepath文件路径
//isSaved是否已保存过文件
//isEdit能否编辑
//projectObj 年度计划对象值
function editoffice(officeObj,projectObj,tangerOcxId) {
	console.log("开始初始化控件对象..");
    TANGER_OCX_OBJ = document.getElementById(tangerOcxId); //;初始化控件对象
    //alert(TANGER_OCX_OBJ);
    if (!TANGER_OCX_OBJ) {
        return;
    }
    if ((typeof (officeObj.filePath) != "undefined") && (officeObj.filePath != "")) {
        //TANGER_OCX_OBJ.BeginOpenFromURL(filePath);
        TANGER_OCX_OBJ.OpenFromURL(officeObj.filePath);
        //alert(fuJianRootPath + filePath);
        ShowTitleBar(false);
        ShowMenubar(false);
        if (officeObj.isCreate == "Y") {
            TANGER_OCX_SetMarkModify(false);
            /**
            if(projectObj ){
            	TANGER_OCX_OBJ.SetBookmarkValue("shangbaodanwei", projectObj.shangbaodanwei);
            	TANGER_OCX_OBJ.SetBookmarkValue("qinghsibiaoti", projectObj.qinghsibiaoti);
            	TANGER_OCX_OBJ.SetBookmarkValue("qingshiwenhao", projectObj.qingshiwenhao);
            	TANGER_OCX_OBJ.SetBookmarkValue("tongguodexiangmujihuashu", projectObj.tongguodexiangmujihuashu);
            	TANGER_OCX_OBJ.SetBookmarkValue("tongguodeshuliang", projectObj.tongguodeshuliang);
            	TANGER_OCX_OBJ.SetBookmarkValue("xubaguojiajudexiangmu", projectObj.xubaguojiajudexiangmu);
            	TANGER_OCX_OBJ.SetBookmarkValue("butongguodexiangmu", projectObj.butongguodexiangmu);
            	TANGER_OCX_OBJ.SetBookmarkValue("niwenriqi", projectObj.niwenriqi);
            }
            */
        }
        else if (officeObj.isCreate == "N") {//编辑
            if (officeObj.isReadOnly == "Y") {
                //TANGER_OCX_SetReadOnly(true);
            } else {
                TANGER_OCX_SetMarkModify(true);
                TANGER_OCX_SetEnableReviewBar(false, false);
                TANGER_OCX_Set(false, false);
                if (officeObj["docUser"].length > 0) {
                    TANGER_OCX_SetDocUser(officeObj.docUser);
                }
            }
        }
    }
}

function editAttach(filePath,docUser,isReadOnly) {
    TANGER_OCX_OBJ = document.getElementById("TANGER_OCX"); //;初始化控件对象
    if (!TANGER_OCX_OBJ) {
        return;
    }
    if ((typeof (filePath) != "undefined") && (filePath != "")) {
        filePath = filePath.replace(/\\/g, "/")
        //TANGER_OCX_OBJ.OpenFromURL("../../UploadFiles/CPCNS_GongWenYingYong/PTSW_PuTongShouWen/AttachDoc/20151/37_104916.docx");
        ShowTitleBar(false);
        ShowMenubar(false);
        //alert(fuJianRootPath + filePath);
        TANGER_OCX_OBJ.OpenFromURL(fuJianRootPath + filePath);
        //TANGER_OCX_OBJ.OpenFromURL("/UploadFiles/CPCNS_GongWenYingYong/WWJFW_FaWen/AttachDoc/20159/2c119bd0-168f-44eb-94af-dac118662202.docx");
        if (isReadOnly == "Y") {
            TANGER_OCX_SetReadOnly(true)
        }
        else
        {
            TANGER_OCX_SetReadOnly(false)
            TANGER_OCX_SetMarkModify(true);
            TANGER_OCX_SetEnableReviewBar(false, false);
            TANGER_OCX_Set(false, false);
            if (docUser.length > 0) {
                TANGER_OCX_SetDocUser(docUser);
            }
        }       
    }
}

//设置只读状态
function TANGER_OCX_SetReadOnly(boolvalue) {
    var i;
    try {
        if (boolvalue) TANGER_OCX_OBJ.IsShowToolMenu = false;
        with (TANGER_OCX_OBJ.ActiveDocument) {
            if (TANGER_OCX_OBJ.DocType == 1) //word
            {
                if ((ProtectionType != -1) && !boolvalue) {
                    Unprotect();
                }
                if ((ProtectionType == -1) && boolvalue) {
                    Protect(2, true, "");
                }
            }
            
        }
    }
    catch (err) {
        //alert("错误：" + err.number + ":" + err.description);
    }
    finally { }
}

//将html form的域值拷贝到Word文档的标签中
function CopyTextToBookMark(inputId, BookMarkName) {
    try {
        var inputValue = "";
        inputValue = $("#" + inputId).val();
        var bkmkObj = TANGER_OCX_OBJ.ActiveDocument.BookMarks(BookMarkName);
        if (!bkmkObj) {
            alert("Word 模板中不存在名称为：\"" + BookMarkName + "\"的书签！");
        }
        var saverange = bkmkObj.Range
        saverange.Text = inputValue;
        TANGER_OCX_OBJ.ActiveDocument.Bookmarks.Add(BookMarkName, saverange);
    }
    catch (err) { }
    finally {
    }
}

//将html form的域值拷贝到Word文档的MailMerge域中
function CopyTextToField(inputname, FieldName) {
    try {
        var inputValue = "";
        var j, elObj, optionItem;
        var elObj = document.forms[0].elements(inputname);
        if (!elObj) {
            alert("HTML的FORM中没有此输入域：" + inputname);
            return;
        }
        switch (elObj.type) {
            case "select-one":
                inputValue = elObj.options[elObj.selectedIndex].text;
                break;
            case "select-multiple":
                var isFirst = true;
                for (j = 0; j < elObj.options.length; j++) {
                    optionItem = elObj.options[j];
                    if (optionItem.selected) {
                        if (isFirst) {
                            inputValue = optionItem.text;
                            isFirst = false;
                        }
                        else {
                            inputValue += "  " + optionItem.text;
                        }
                    }
                }

                break;
            default: // text,Areatext,selecte-one,password,submit,etc.
                inputValue = elObj.value;
                break;
        }
        var Fields = TANGER_OCX_OBJ.ActiveDocument.MailMerge.Fields;
        for (var iField = 1; iField <= Fields.Count; iField++) {
            //alert(Fields(iField).Code.Text);
            if (Fields(iField).Code.Text.indexOf(FieldName) >= 0) {
                Fields(iField).Select();
                TANGER_OCX_OBJ.ActiveDocument.Application.Selection.Text = inputValue;
            }
        }

    }
    catch (err) {
        //alert(err.number + ":" + err.description);
    }
    finally {
    }
}

//读取word中的内容
function ReadFromDoc() {
    var inputValue = "";
    var elObj = document.forms[0].elements(inputname);
    if (!elObj) {
        alert("HTML的FORM中没有此输入域：" + inputname);
        return;
    }
    elObj.value = TANGER_OCX_OBJ.ActiveDocument.Content.Text;
}

//下列函数可以将URL指定的模板文件插入到当前文档的头部。可用于简单的套红
function TANGER_OCX_DoTaoHong(URL) {
    try {
        TANGER_OCX_OBJ.ActiveDocument.Application.Selection.HomeKey(6);
        TANGER_OCX_OBJ.AddTemplateFromURL(URL);
    }
    catch (err)
	{ }
};

//下列函数可以将当前编辑的文档插入到URL指定的模板文件的”ZhengWen”书签位置。可用于稍微复杂的套红。
function TANGER_OCX_DoPaiBan(URL,projectObj,myProjectArray) {
    try {
    	delHeaders();
    	delfoot();
        //选择对象当前文档的所有内容
        var curSel = TANGER_OCX_OBJ.ActiveDocument.Application.Selection;
        TANGER_OCX_SetMarkModify(false);
        TANGER_OCX_SetReviewMode(true);
        curSel.WholeStory();
        curSel.Cut();
        //插入模板
        TANGER_OCX_OBJ.OpenFromURL(URL);
        var BookMarkName = "zhengwen";
        if (!TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists(BookMarkName)) {
            alert("Word 模板中不存在名称为：\"" + BookMarkName + "\"的书签！");
            return;
        }
        var bkmkObj = TANGER_OCX_OBJ.ActiveDocument.BookMarks(BookMarkName);
        var saverange = bkmkObj.Range
        saverange.Paste();
        for (x in myProjectArray)
    	{
        	if (TANGER_OCX_OBJ.ActiveDocument.BookMarks.Exists(myProjectArray[x])) {
        		TANGER_OCX_OBJ.ActiveDocument.BookMarks(myProjectArray[x]).Range.Text = projectObj[myProjectArray[x]];	
        	}
    	}
        
        
        TANGER_OCX_OBJ.ActiveDocument.Bookmarks.Add(BookMarkName, saverange);
        
    }
    catch (err) {
        //alert("错误：" + err.number + ":" + err.description);
    }
}

//下列函数可以在当前编辑的文档前面和后面插入两个指定的模板文件，并设置当前文档中文本格式为模板中”zhengwen”书签的字体及段落格式。可用于非常复杂的套红。
function TANGER_OCX_DoPaiBanFuZa(URL1, URL2) {
    try {
        TANGER_OCX_SetMarkModify(false); //暂时退出痕迹保留状态
        var doc = TANGER_OCX_OBJ.ActiveDocument;
        var curSel = doc.Application.Selection;
        curSel.HomeKey(6); //跳转到文档开头
        //插入模板头部
        TANGER_OCX_OBJ.AddTemplateFromURL(URL1);
        //拷贝正文书签格式
        doc.BookMarks("zhengwen").Select();
        curSel.CopyFormat();
        //选择到尾部
        curSel.EndKey(6, 1);
        curSel.PasteFormat();
        doc.BookMarks("zhengwen").Select();
        curSel.Delete();
        //删除段落标记
        curSel.Delete(1, 1);
        curSel.EndKey(6); //跳转到文档尾部
        //插入模板尾部
        TANGER_OCX_OBJ.AddTemplateFromURL(URL2);
        //设置其他书签
        //*
        doc.BookMarks("wenjiantoubu").Range.Text = "NTKO OFFICE文档控件";
        doc.BookMarks("wenhao").Range.Text = "111-111-111";
        doc.BookMarks("biaoti").Range.Text = "关于采用NTKO OFFICE文档控件的决定";
        doc.BookMarks("danwei").Range.Text = "尊敬的用户:";
        doc.BookMarks("Notekeyword").Range.Text = "痕迹保留 电子印章 手写签名 复杂模板套红 电子政务 同意采用 文档管理";
        doc.BookMarks("Publishto").Range.Text = "各合作伙伴和用户单位";
        doc.BookMarks("PublishUnit").Range.Text = "千航网络产品部";
        doc.BookMarks("PublisDate").Range.Text = "2004年3月28日";
        //*/		
        TANGER_OCX_SetMarkModify(true); //进入痕迹保留状态
    }catch (err) {
        alert("错误：" + err.number + ":" + err.description);
    }
}

function TANGER_OCX_SaveToLocal() {
    TANGER_OCX_OBJ.ShowDialog(2);
}

function delfoot(){
	console.log("开始删除页脚..");
	try {
	TANGER_OCX_OBJ.ActiveDocument.ActiveWindow.ActivePane.View.SeekView = 10; //切换页脚模式
	var sel=TANGER_OCX_OBJ.ActiveDocument.Application.Selection;
	sel.WholeStory();
	sel.Delete();
	TANGER_OCX_OBJ.ActiveDocument.ActiveWindow.ActivePane.View.SeekView = 0; 
	}catch (err) {
	}
	console.log("开始删除页脚..结束..");
}

//删除页眉
function delHeaders(){
	console.log("开始删除页眉..");
	try {
	TANGER_OCX_OBJ.ActiveDocument.ActiveWindow.ActivePane.View.SeekView = 9; //切换页脚模式
	var sel=TANGER_OCX_OBJ.ActiveDocument.Application.Selection;
	sel.WholeStory();
	sel.Delete();
	TANGER_OCX_OBJ.ActiveDocument.ActiveWindow.ActivePane.View.SeekView = 0; 
}catch (err) {
	}
console.log("开始删除页脚..结束..");
}