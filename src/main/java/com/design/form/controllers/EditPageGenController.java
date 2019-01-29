package com.design.form.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.design.core.common.model.json.AjaxJson;
import com.design.core.system.service.SystemService;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformDefineEntity;
import com.design.form.service.EditPageGenServiceI;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;
import com.tj720.admin.service.ActivityService;
import com.tj720.admin.service.MipSpreadtrumService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.inter.service.table.MipWenchuangService;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Title: Controller
 * @author onlineGenerator
 * @date 2016-09-04 00:52:40
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/editPageGenController")
public class EditPageGenController  {
//	String insideProcessUrl =SysConfigUtil.getConfigByName("insideProcessUrl");//内部流程访问接口地址
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	@Autowired
	private EditPageGenServiceI tSEditPageGenService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private MipSpreadtrumService mipSpreadtrumService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private MipWenchuangService mipWenchuangService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(params = "doUpdateStatus")
	@ResponseBody
	public AjaxJson doUpdateStatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		String status = oConvertUtils.getString(request.getParameter("status"), "");
		String releaseCode = oConvertUtils.getString(request.getParameter("releaseCode"), "");
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", releaseCode);
		if(StringUtil.isEmpty(mainId)){
			j.setSuccess(false);
			j.setMsg("mainId为空，不能操作！");
			return j;
		}
		mainId=mainId.replace(",", "','");
		if(cgformBuss==null){
			j.setSuccess(false);
			j.setMsg("未查询到业务编码为【"+releaseCode+"】的数据！");
			return j;
		}
		CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
		if(!"1".equals(cgformBuss.getStatus())){
			j.setSuccess(false);
			j.setMsg("未发布的表单不允许操作！");
			return j;
		}
		if(tSConfigform==null){
			j.setSuccess(false);
			j.setMsg("未查询到关联表单！");
			return j;
		}
		if(StringUtil.isNotEmpty(tSConfigform.getMtableName())){
			systemService.executeSql("update "+tSConfigform.getMtableName()+" set status=? where id in ('"+mainId+"') ", status);
		}else{
			systemService.executeSql("update cgform_rdata_master set status=? where id  in ('"+mainId+"') ", status);
		}
		return j;
	}
	
	
	/**
	 * @throws Exception 
	 * 
	 * @Title: doSaveOrUpdateIcmsData
	 * @Description:
	 * @param request
	 * @param 设定文件
	 * @return AjaxJson 返回类型
	 * @throws
	 */
	@RequestMapping(params = "doSaveOrUpdateData")
	@ResponseBody
	public AjaxJson doSaveOrUpdateData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String refBusscode = oConvertUtils.getString(request.getParameter("refBusscode"), "");
		Map<String, String[]> parameterMap_temp = request.getParameterMap();
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.putAll(parameterMap_temp);
		
		AjaxJson j = tSEditPageGenService.doSaveOrUpdateData(request);
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		//如果此业务配置有流程key则就需要启动流程，如果已经启动就不需要启动---------------
//		StringBuffer jso=RestUtils.getReqParamString(request);
//		String refBusscode = oConvertUtils.getString(request.getParameter("refBusscode"), "");
//		CgformDefineEntity tSConfigform = systemService.findUniqueByProperty(CgformDefineEntity.class, "defineCode", refBusscode);
//		if(StringUtil.isNotEmpty(tSConfigform)&&StringUtil.isNotEmpty(tSConfigform.getProcessKey())){
//			jso.append("&BUSSCODE="+refBusscode);
//			jso.append("&BUSKEY="+j.getObj());
//			jso.append("&BUSINESS_KEY="+j.getObj());
//			jso.append("&PROCESSKEY="+tSConfigform.getProcessKey());
//			jso.append("&USERID="+ResourceUtil.getSessionUserName().getUserName());
//			RestTrackClient.postMethodByParams(insideProcessUrl+"CeX2ProcessRestController/startProcessInstance",jso.toString());
//			/*** * 生成自定义字段数据到平台------------------*/
//			systemService.toAddTPProcessBizdata(oConvertUtils.getString(j.getObj()),"false",refBusscode);
//			/*** * 生成自定义字段数据到平台------------------* */
//		}
		//如果此业务配置有流程key则就需要启动流程，如果已经启动就不需要启动---------------
		
		LoginInfoDto us = Tools.getUser();
    	User user = userService.get(us.getId());
		
    	String id = ((String[])parameterMap.get(refBusscode + "@id"))[0];
    	if(StringUtils.isBlank(id)) {
    		//同步到内容公众服务与管理
    		String releaseCode = oConvertUtils.getString(request.getParameter("releaseCode"), "");
    		if("B1537760233716".equals(releaseCode)) {		//展览
    			mipSpreadtrumService.saveDesignData(parameterMap, user.getId(), user.getOrgId());
    		}else if("B1537761254725".equals(releaseCode)) {		//社教活动
    			activityService.saveDesignData(parameterMap, user.getId(), user.getOrgId(), "1");
    		}else if("B1537762903934".equals(releaseCode)) {		//社教讲座
    			activityService.saveDesignData(parameterMap, user.getId(), user.getOrgId(), "2");
    		}else if("B1537772421773".equals(releaseCode)) {		//文创
    			MipWenchuang saveDesignData = mipWenchuangService.saveDesignData(parameterMap, user.getId(), user.getOrgId());
    			try {
    				mipWenchuangService.save(saveDesignData);
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
		return j;
	}

	
	/**
	 * 获取关联业务数据
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "getLinkBussDataJson")
	@ResponseBody
	public Map<String, Object> getLinkBussDataJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		Map<String, Object> mapCounts = new HashMap<String, Object>();
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
		String versionNum = oConvertUtils.getString(request.getParameter("versionNum"), "");
		
		String mainTable = "";
		CgformDefineEntity tSConfigform = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
						bussCode);
		if (tSConfigform != null) {
			mainTable = tSConfigform.getMtableName();
			request.setAttribute("printId", tSConfigform.getPrintId());
		}
		
		Map<String, Object> pMap  = new HashMap<String, Object>();
		pMap.put("JudgeFlag", "");
		pMap.put("mainId", mainId);
		pMap.put("versionNum", versionNum);
		pMap.put("mainTable", mainTable);
		pMap.put("bussCode", bussCode);
		pMap.put("bussTemplateId", bussTemplateId);
		mapCounts =tSEditPageGenService.getLinkBussDataJson(pMap,request);
		System.out.println(mapCounts);
		return mapCounts;
	}
	
	
	
	
	
	/**
	 * 获取附件数据
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "getAttachDataJson")
	@ResponseBody
	public List<Map<String, Object>> getAttachDataJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		List<Map<String, Object>> mapCounts = new ArrayList<Map<String, Object>>();
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		String showType = oConvertUtils.getString(request.getParameter("showType"), "");
		
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
		int versionnum = oConvertUtils.getInt(request.getParameter("versionnum"),0);
		String mainTable = "";
		CgformDefineEntity tSConfigform = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
						bussCode);
		if (tSConfigform != null) {
			mainTable = tSConfigform.getMtableName();
			request.setAttribute("printId", tSConfigform.getPrintId());
		}
		
		Map<String, Object> pMap  = new HashMap<String, Object>();
		pMap.put("JudgeFlag", "");
		pMap.put("mainId", mainId);
		pMap.put("mainTable", mainTable);
		pMap.put("bussCode", bussCode);
		pMap.put("showType", showType);
		pMap.put("versionnum", versionnum);
		pMap.put("bussTemplateId", bussTemplateId);
		mapCounts =tSEditPageGenService.getAttachDataJson(pMap);
		System.out.println(mapCounts);
		return mapCounts;
	}
	
	
	/**
	 * 获取图片数据
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "getPicDataJson")
	@ResponseBody
	public List<Map<String, Object>> getPicDataJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		List<Map<String, Object>> mapCounts = new ArrayList<Map<String, Object>>();
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
		int versionnum = oConvertUtils.getInt(request.getParameter("versionnum"),0);
		String mainTable = "";
		CgformDefineEntity tSConfigform = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
						bussCode);
		if (tSConfigform != null) {
			mainTable = tSConfigform.getMtableName();
			request.setAttribute("printId", tSConfigform.getPrintId());
		}
		
		Map<String, Object> pMap  = new HashMap<String, Object>();
		pMap.put("JudgeFlag", "");
		pMap.put("mainId", mainId);
		pMap.put("versionnum", versionnum);
		pMap.put("mainTable", mainTable);
		pMap.put("bussCode", bussCode);
		pMap.put("bussTemplateId", bussTemplateId);
		mapCounts =tSEditPageGenService.getPicDataJson(pMap);
		System.out.println(mapCounts);
		return mapCounts;
	}
	
	
	@RequestMapping(params = "getRegionDataJson")
	@ResponseBody
	public Map<String, Object> getRegionDataJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		Map<String, Object> mapCounts = new HashMap<String, Object>();
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		String fieldName = oConvertUtils.getString(request.getParameter("fieldName"),"");
		Map<String, Object> pMap  = new HashMap<String, Object>();
		pMap.put("JudgeFlag", "");
		pMap.put("mainId", mainId);
		pMap.put("fieldName", fieldName);
		mapCounts =tSEditPageGenService.getRegionDataJson(pMap);
		System.out.println(mapCounts);
		return mapCounts;
	}
	
	
	/**
	 * 获取主业务数据
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "getBussDataJson")
	@ResponseBody
	public List<Map<String, Object>> getBussDataJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		List<Map<String, Object>> mapCounts = new ArrayList<Map<String, Object>>();
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		String taskId = oConvertUtils.getString(request.getParameter("taskId"), "");
		int versionNum = oConvertUtils.getInt(request.getParameter("versionNum"),0);
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
		String mainTable = "";
		CgformDefineEntity tSConfigform = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
						bussCode);
		if (tSConfigform != null) {
			mainTable = tSConfigform.getMtableName();
			request.setAttribute("printId", tSConfigform.getPrintId());
		}
		
		Map<String, Object> pMap  = new HashMap<String, Object>();
		pMap.put("JudgeFlag", "");
		pMap.put("mainId", mainId);
		pMap.put("mainTable", mainTable);
		pMap.put("versionNum", versionNum);
		pMap.put("bussCode", bussCode);
		pMap.put("taskId", taskId);
		pMap.put("bussTemplateId", bussTemplateId);
		mapCounts =tSEditPageGenService.getBussDataJson(pMap,request);
		System.out.println(mapCounts);
		return mapCounts;
	}
	
	/**
	 * 数据来源选择
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goSelectPage")
	public ModelAndView goSelectPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		List<Map<String, Object>> fieldList = systemService.findForJdbc("select d.* from cgform_select_back t,cgform_select_field d where "
				+ "t.s_code='"+request.getParameter("sCode")+"' and t.id=d.main_id  order by d.sort asc ");
		request.setAttribute("fieldList", fieldList);
		request.setAttribute("sCode", oConvertUtils.getString(request.getParameter("sCode")));
		request.setAttribute("wherePara", oConvertUtils.getString(request.getParameter("wherePara")));
		request.setAttribute("selectId", oConvertUtils.getString(request.getParameter("selectId")));
		request.setAttribute("inputId", oConvertUtils.getString(request.getParameter("inputId")));
		List<Map<String, Object>> backList = systemService.findForJdbc("select t.* from cgform_select_back t where "
				+ " t.s_code='"+request.getParameter("sCode")+"'  ");
		//如果是自定义jsp页面则需要实现backDataToPage方法
		if(backList!=null&&backList.size()>0&&StringUtil.isNotEmpty(backList.get(0).get("jump_page"))){
			return new ModelAndView(new RedirectView(backList.get(0).get("jump_page").toString()));
		}
		return new ModelAndView(prefix+"pagegen/select"+suffix);
	}
	
	@RequestMapping(params = "getSelectData")
	@ResponseBody
	public JSONObject getSelectData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String sCode= oConvertUtils.getString(request.getParameter("sCode"));
		List<Map<String, Object>> backList = systemService.findForJdbc("select t.* from cgform_select_back t where "
				+ " t.s_code='"+sCode+"'  ");
		List<Map<String, Object>> fieldList = systemService.findForJdbc("select d.* from cgform_select_back t,cgform_select_field d where "
				+ "t.s_code='"+request.getParameter("sCode")+"' and t.id=d.main_id  order by d.sort asc ");
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		if(backList!=null&&backList.size()>0){
			if(StringUtil.isNotEmpty(backList.get(0).get("json_url"))){//获取rest接口数据
			
			}
			else if(StringUtil.isNotEmpty(backList.get(0).get("json_sql"))){//获取数据库sql语句中的数据
				List<Map<String, Object>> sqlList = systemService.findForJdbc(backList.get(0).get("json_sql").toString());
				
				for(Map<String, Object> m:sqlList){
					JSONObject jo1=new JSONObject();
					if(fieldList!=null&&fieldList.size()>0){
						for(Map<String, Object> f:fieldList){
							jo1.put(f.get("field_code"), m.get(f.get("field_code")));
						}
					}
					ja.add(jo1);
				}
				jo.put("total", sqlList.size());
				jo.put("rows", ja);
			}
		}
		return jo;
	}
	
//	/**
//	 * 提交审批流程
//	 * @param request
//	 * @return 
//	 */
//	@RequestMapping(params = "submitBusiness")
//	@ResponseBody
//	public ActivitiCom submitBusiness(ProcessVar pVar,Variable var, HttpServletRequest request) {
//		Map<String, Object> map = var.getVariableMap();
//		map.put("nodeActionId", pVar.getNodeActionId());
//		ActivitiCom activitiCom= activitiService.complete(pVar.getTaskId(), map,pVar);
//		System.out.println(activitiCom.getComplete());
//		return activitiCom;
//	}
//	
//	
//	@RequestMapping(params = "getTransactionHistory")
//	public ModelAndView getTransactionHistory(HttpServletRequest request) {
//		StringBuffer jso=RestUtils.getReqParamString(request);
//		String responseBody=RestTrackClient.getMethodByParams(insideProcessUrl+"CeX2ProcessRestController/getTransactionHistory?"+jso.toString());
//		JSONArray json = JSONArray.fromObject(responseBody);
//		request.setAttribute("json", json);
//		return new ModelAndView("system/configform/transactionHistory");
//	}

}
