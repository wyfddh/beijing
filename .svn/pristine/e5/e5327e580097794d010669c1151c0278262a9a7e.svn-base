package com.design.auto.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.AjaxJson;
import com.design.core.system.service.SystemService;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformDefineJsEntity;
import com.design.entity.TSBussTemplateEntity;
import com.design.entity.CgformDefineEntity;
import com.design.tag.FreemarkerHelper;
import com.design.utils.ParameterUtil;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;
import com.zxlhdata.framework.auth.util.LicenseUtil;



/** *
 * 
* @ClassName: AceAutoController
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 何湘简
* @date 2017-11-2 下午2:33:39
 */
@Controller
@RequestMapping("/aceAutoController")
public class AceAutoController  {
	private String jsVersion= ResourceUtil.getConfigByName("core.js.version");
	/**
	 * Logger for this class
	 */
	
	@Autowired
	private SystemService systemService;
	
	/**
	 * 动态列表展现入口
	 * @param id 动态配置ID
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(params = "modeList")
	public void modeList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//			//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String businessCode=oConvertUtils.getString(request.getParameter("businessCode"), "");
		String configformId=oConvertUtils.getString(request.getParameter("configformId"), "");
		String isTest=oConvertUtils.getString(request.getParameter("isTest"), "");
		String versionNum=oConvertUtils.getString(request.getParameter("versionNum"), "-1");
		CgformDefineEntity tSConfigform = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
						businessCode);
		long start = System.currentTimeMillis();
		FreemarkerHelper viewEngine = new FreemarkerHelper();
		Map<String, Object> paras = new HashMap<String, Object>();
		//step.3 封装页面数据
//		loadVars(configs,paras,request);
		//step.4 组合模板+数据参数，进行页面展现
		paras.put("businessCode", businessCode);
		paras.put("configformId", configformId);
		paras.put("isTest", isTest);
		paras.put("versionNum", versionNum);
		paras.put("isBusinessKey", tSConfigform.getProcessKey());
		
		loadIframeHeadConfig(paras, request,response);
		loadIframeBottomConfig(paras, request,response);
		String html = viewEngine.parseTemplate("/com/design/auto/ace_mode_list.ftl", paras);
		try {
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter writer = response.getWriter();
			writer.println(html);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws Exception *
	 * 
	* @Title: modeDemoPageA
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param request
	* @param @return    设定文件
	* @return ModelAndView    返回类型
	* @throws
	 */
	@RequestMapping(params = "modePage")
	public void modePage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"));
		String releaseCode = oConvertUtils.getString(request.getParameter("releaseCode"));
		String mainId = oConvertUtils.getString(request.getParameter("mainId"));
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"));
		String isTest=oConvertUtils.getString(request.getParameter("isTest"), "");
		String otherParameters=oConvertUtils.getString(request.getParameter("otherParameters"), "");//json方式传递
		String isDisabled=oConvertUtils.getString(request.getParameter("isDisabled"), "");
		
//		if(StringUtil.isEmpty(bussCode)&&StringUtil.isNotEmpty(bussTemplateId)){
//			//如果没传业务编码，从现实模板中取对应的业务编码，这种情况一般是从待办列表中过来的
//			List<Map<String, Object>> map = systemService.findForJdbc("select m.bus_code from cgform_define m,t_s_buss_template t where t.configform_id=m.id and t.id=? ",bussTemplateId);
//			if(map!=null&&map.size()>0){
//				bussCode = oConvertUtils.getString(map.get(0).get("bus_code"));
//			}
//		}
		
		
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", releaseCode);
		CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
		
		
		
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("versionNum", "-1");//默认为基础版本
		paras.put("taskId", "");//在此处必须为空
		paras.put("isEnd", "");
		paras.put("nodeCode", "");
		paras.put("otherParameters", otherParameters);
		paras.put("taskDefName", StringUtil.isNotEmpty(mainId)?cgformBuss.getBussName()+"：修改":cgformBuss.getBussName()+"：新增");
		
		
//		if(StringUtil.isEmpty(id)&&StringUtil.isNotEmpty(tSConfigform)&&StringUtil.isNotEmpty(tSConfigform.getProcessKey())){//如果id为空则表示是新增，则从业务模板中取最高版本中的创建模板
//			//从流程中获取当前数据的版本号,如果业务id为空，则从流程配置中获取发起环节的最高版本号和业务模板id
//			String responseBody = RestTrackClient.getMethodByParams(insideProcessUrl+"CeX2ProcessRestController/getfirstBussTemplateIdByProcesskey?processKey="+tSConfigform.getProcessKey());
//			JSONObject json = JSONObject.fromObject(responseBody);
//			if(tSConfigform!=null&&StringUtil.isNotEmpty(tSConfigform.getProcessKey())){
//				paras.put("versionNum", oConvertUtils.getString(json.getString("VERSIONS"),"-1"));
//				paras.put("nodeCode", oConvertUtils.getString(json.getString("PROCESSNODECODE")));
//				bussTemplateId = oConvertUtils.getString(json.get("MODELANDVIEW"));
//			}
//		}
//		else if(StringUtil.isNotEmpty(id)&&StringUtil.isNotEmpty(tSConfigform)&&StringUtil.isNotEmpty(tSConfigform.getProcessKey())){
//			//获得当前流程当前任务的模板id,如果当前任务和当前用户不匹配，则取创建时的模板id，则说明是查看页面进入的，如果流程已经结束则也是取创建时的模板id
//			String responseBody = RestTrackClient.getMethodByParams(insideProcessUrl+"CeX2ProcessRestController/getNowTaskTemplateByMainId?userName="+userName+"&mainId="+id);
//			JSONObject json = JSONObject.fromObject(responseBody);
//			bussTemplateId = oConvertUtils.getString(json.getString("templateId"));
//			paras.put("versionNum", oConvertUtils.getString(json.getString("versionNum"),"-1"));
//			paras.put("taskId", oConvertUtils.getString(json.getString("taskId")));
//			paras.put("isEnd", oConvertUtils.getString(json.getString("isEnd")));
//			paras.put("nodeCode", oConvertUtils.getString(json.getString("taskDefKey")));
//			paras.put("taskDefName", "当前环节："+tSConfigform.getBusName()+"-"+oConvertUtils.getString(json.getString("taskDefName")));
//			
//		}else{
//			//如果显示模板ID是空的则根据业务编码查询默认的基础版本 显示模板ID,一般情况下只有流程中表单会进入
//			List<Map<String, Object>> map = systemService.findForJdbc("select id from t_s_buss_template where configform_id=? and template_type='0' ",tSConfigform.getId());
//			if(map!=null&&map.size()>0){
//				bussTemplateId = oConvertUtils.getString(map.get(0).get("id"));
//			}
//		}
		if("true".equals(isDisabled)){//点击查看按钮进入
			paras.put("isEnd", "true");
		}
		if("true".equals(paras.get("isEnd"))){
			paras.put("taskDefName", cgformBuss.getBussName()+"：查看");
		}
//		TSBussTemplateEntity tSBussTemplate = systemService.findUniqueByProperty(TSBussTemplateEntity.class, "id",bussTemplateId);
		String mainTable = tSConfigform.getMtableName();
		long start = System.currentTimeMillis();
		FreemarkerHelper viewEngine = new FreemarkerHelper();
		paras.put("businessCode", tSConfigform.getDefineCode());
		paras.put("releaseCode", cgformBuss.getBussCode());
		paras.put("status", cgformBuss.getStatus());
		
//		paras.put("cssType", tSConfigform.getCssType());
		paras.put("bussTemplateId", bussTemplateId);
		paras.put("mainTable", mainTable);
		paras.put("configformId", tSConfigform.getId());
		paras.put("processKey", oConvertUtils.getString(tSConfigform.getProcessKey()));
		paras.put("sid", "");
		paras.put("mainId", mainId);
		paras.put("isTest", isTest);
		paras.put("formServerUrl", "");
		paras.put("oaServerUrl", "");
		request.setAttribute("bussCode", tSConfigform.getDefineCode());
		loadIframeHeadConfig(paras, request,response);
		loadIframeBottomConfig(paras, request,response);
		String html = viewEngine.parseTemplate("/com/design/auto/ace_mode_page.ftl", paras);
		try {
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter writer = response.getWriter();
			writer.println(html);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
	}
	
	
	/**
	 * 加载iframe设置
	 * @param paras
	 * @param request
	 * @throws Exception 
	 */
	private void loadIframeHeadConfig(Map<String, Object> paras,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
//		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String type=oConvertUtils.getString(request.getParameter("type"), "");
		String isTest=oConvertUtils.getString(request.getParameter("isTest"), "");
		
		StringBuilder sb= new StringBuilder("");
		if("list".equals(type)){
			
			sb.append("<script src=\"designPlug-in/layer/layer.js\"></script>");
			sb.append("<script src=\"designPlug-in/layer/extend/layer.ext.js\"></script>");
			sb.append("<script src=\"designPlug-in/laypage/laypage.js\"></script>");
			sb.append("<!-- basic styles -->");
			if("true".equals(isTest)){
				sb.append("<script src=\"designPlug-in/ace/assets/js/jquery-2.0.3.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/bootstrap.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/typeahead-bs2.min.js\"></script>");
				sb.append("<link href=\"designPlug-in/ace/assets/css/bootstrap.min.css\" rel=\"stylesheet\" />");
//				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/ace/assets/css/font-awesome.min.css\" />");
//				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/ace/assets/css/font-awesome.min-plus.css\" />");
				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/ace/assets/css/ace.min.css\" />");
				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/ace/assets/css/ace-rtl.min.css\" />");
				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/ace/assets/css/ace-skins.min.css\" />");
				sb.append("<script src=\"designPlug-in/ace/assets/js/ace-extra.min.js\"></script>");
				sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"designPlug-in/ace/assets/css/cover.css\"/>  "); 
			}
			
			sb.append("<script src=\"designPlug-in/avalon/avalon1.4.js\"></script>");
			
			sb.append("<style type=\"text/css\">");
			sb.append(".ms-controller{");
			sb.append("visibility: hidden");
			sb.append("}");
			sb.append("</style>");
			
		}
		else if("page".equals(type)){
			
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/jquery/jquery-1.8.3.js\"></script>");
			sb.append("<script type=\"text/javascript\" src='designPlug-in/layer/layer.js'></script>");
			sb.append("<script type=\"text/javascript\" src='designPlug-in/layer/extend/layer.ext.js'></script>");
			sb.append("<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/layui.css' type=\"text/css\" >");
			sb.append("<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/global.css' type=\"text/css\" >");
			sb.append("<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/code.css' type=\"text/css\" >");
//			sb.append("<script type=\"text/javascript\" src='designPlug-in/layui/laytpl.js'></script>");
			sb.append("<script type=\"text/javascript\" src='designPlug-in/layui-2.3.0/layui.js'></script>");
			
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/Validform/css/style.css\" type=\"text/css\">");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/Validform/css/tablefrom.css\" type=\"text/css\"/>");
			sb.append("<link href=\"designPlug-in/My97DatePicker/skin/WdatePicker.css\" rel=\"stylesheet\" type=\"text/css\">");
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/My97DatePicker/WdatePicker.js\"></script>");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/Validform/css/style.css\"	type=\"text/css\" media=\"all\" />");
			sb.append("<link href=\"designPlug-in/easyui-pli/css/base.css\" rel=\"stylesheet\">");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/jquery-plugs/gridstack/css/gridstack.css\">");
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/tools/icmstools.js\"></script>");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/move-menu/css/style.css\">");
//			sb.append("<link rel=\"stylesheet\" href=\"plug-in/ace/assets/css/font-awesome.min.css\">");
			sb.append("<script src=\"designPlug-in/move-menu/js/anime.js\"></script>");
			sb.append("<script src=\"designPlug-in/move-menu/js/index.js\"></script>");
			
			
			sb.append("<!-- 地区选择插件 -->");
			sb.append("<script type='text/javascript' src='designPlug-in/SelCity/js/Popt.js'></script>");
			sb.append("<script type='text/javascript' src='designPlug-in/SelCity/js/citySet.js'></script>");
			sb.append("<link href='designPlug-in/SelCity/css/sel.css' rel='stylesheet' media='all'>");
			
			sb.append("<!-- 默认事件js -->");
			sb.append("<script type='text/javascript' src='designPlug-in/design/default-close.js'></script>");
			sb.append("<script type='text/javascript' src='designPlug-in/design/default-save.js'></script>");
			sb.append("<script type='text/javascript' src='designPlug-in/design/default-submit.js'></script>");
			
			sb.append("<script type='text/javascript'>");
			sb.append("function InitDefaultJsString_"+paras.get("businessCode")+"(){");
			 CriteriaQuery cq1 = new CriteriaQuery(CgformDefineJsEntity.class);
		  		cq1.eq("defineCode", paras.get("businessCode"));
		  		cq1.eq("version", -1);
		  		if(StringUtil.isNotEmpty(paras.get("nodeCode"))){
		  			cq1.eq("nodeCode", paras.get("nodeCode"));
		  		}
		  		cq1.add();
		  		List<CgformDefineJsEntity> cgformDefineJsList= systemService.getListByCriteriaQuery(cq1, false);
			if(cgformDefineJsList!=null&&cgformDefineJsList.size()>0){
				sb.append(cgformDefineJsList.get(0).getJs());
			}
			sb.append("}");
			
			sb.append("</script>");
			
			
			sb.append("<style type=\"text/css\">");
			sb.append(".grid-stack-item-content {");
			sb.append(" color: #2c3e50;");
			sb.append("text-align: center;");
			sb.append("}");
			sb.append(".profile-info-name{");
			sb.append("cursor: auto;");
			sb.append("}");
			sb.append(".profile-user-info{");
			sb.append("border: 1px solid #CCCCCC;");
			sb.append("}");
			sb.append(".select{");
			sb.append("border:1px dotted #ff0404;");
			sb.append("}");
			sb.append("</style>");
		}
		else{
		}
		paras.put("config_iframe_head", sb.toString());
		
		
	}
	
	private void loadIframeBottomConfig(Map<String, Object> paras,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
//		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String type=oConvertUtils.getString(request.getParameter("type"), "");
		String isTest=oConvertUtils.getString(request.getParameter("isTest"), "");
		String cssType=oConvertUtils.getString(request.getParameter("cssType"), "TY");
		//如果列表以iframe形式的话，需要加入样式文件
		StringBuilder sb= new StringBuilder("");
		if("list".equals(type)){
			if("true".equals(isTest)){
				sb.append("<script src=\"designPlug-in/ace/assets/js/jquery-ui-1.10.3.custom.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.ui.touch-punch.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.slimscroll.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.easy-pie-chart.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.sparkline.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.pie.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.resize.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/ace-elements.min.js\"></script>");
				sb.append("<script src=\"designPlug-in/ace/assets/js/ace.min.js\"></script>");
			}
			sb.append("<script src=\"designPlug-in/tools/icmstools.js\"></script>");
			sb.append("<script src=\"designPlug-in/layer/SZHLCommon.js\"></script>");
			
		}
		else if("page".equals(type)){
			
			sb.append("<script src=\"designPlug-in/jquery-plugs/gridstack/js/jquery.min.js\" type=\"text/javascript\"></script>");
			sb.append("<script src=\"designPlug-in/jquery/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>");
			sb.append("<script src=\"designPlug-in/jquery-plugs/gridstack/js/jquery-ui.min.js\"></script>");
			sb.append("<script src=\"designPlug-in/jquery-plugs/gridstack/js/bootstrap.min.js\"></script>");
			sb.append("<script src=\"designPlug-in/jquery-plugs/gridstack/js/lodash.min.js\"></script>");
			sb.append("<script src=\"designPlug-in/jquery-plugs/gridstack/js/knockout-min.js\"></script>");
			sb.append("<script src=\"designPlug-in/jquery-plugs/gridstack/js/gridstack.js\"></script>");
			sb.append("<script src=\"designPlug-in/design/design."+jsVersion+".js\"></script>");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/template/BootstrapFormLayout.css\">");
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/Validform/js/Validform_v5.3.2_min.js\"></script>");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/template/"+cssType+".css\">");
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/jquery/Loading.js\"></script>");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/upload/control/css/zyUpload.css\" type=\"text/css\">");
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/upload/core/zyFile.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"designPlug-in/upload/control/js/zyUpload.js\"></script>");
			sb.append("<script type=\"text/javascript\"  src=\"designPlug-in/upload/upload.js\"></script>");
			sb.append("<script type=\"text/javascript\"  src=\"designPlug-in/jquery/imgViewer/js/viewer.min.js.js\"></script>");
			sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/jquery/imgViewer/css/view.css\" type=\"text/css\">");
			
		}
		
		else{
		}
			paras.put("config_iframe_bottom", sb.toString());
	}
	
	
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(HttpServletRequest request,HttpServletResponse response) throws Exception {
//		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		AjaxJson j = new AjaxJson();
		String bussCode=oConvertUtils.getString(request.getParameter("bussCode"),"");
		String releaseCode=oConvertUtils.getString(request.getParameter("releaseCode"),"");
		if(StringUtil.isEmpty(bussCode)&&StringUtil.isNotEmpty(releaseCode)){
			CgformBussEntity cgformBuss = systemService
					.findUniqueByProperty(CgformBussEntity.class, "bussCode",
							releaseCode);
			CgformDefineEntity tSConfigform_ = systemService
					.findUniqueByProperty(CgformDefineEntity.class, "id",
							cgformBuss.getDefineId());
			bussCode=tSConfigform_.getDefineCode();
		}
		String id=oConvertUtils.getString(request.getParameter("id"),"");
		if(StringUtil.isNotEmpty(id)){
			CgformDefineEntity tSConfigform = systemService
					.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
							bussCode);
			String mainTable = "cgform_rdata_master";
			if (tSConfigform != null&&"1".equals(tSConfigform.getSaveType())&&StringUtil.isNotEmpty(tSConfigform.getMtableName())) {
				mainTable = tSConfigform.getMtableName();
			}
			systemService.executeSql("delete from "+mainTable+" where id in ('"+id.replace(",", "','")+"') ");
			if("cgform_rdata_master".equals(mainTable)){
				systemService.executeSql("delete from cgform_rdata_detail where master_id in ('"+id.replace(",", "','")+"') ");
			}
		}
		String message = "删除成功";
		j.setMsg(message);
		return j;
	}
}
