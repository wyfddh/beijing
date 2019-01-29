package com.design.list.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.AjaxJson;
import com.design.core.common.model.json.SortDirection;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformBussQueryEntity;
import com.design.entity.CgformDefineEntity;
import com.design.entity.LayuiCols;
import com.design.list.service.ListPageGenServiceI;
import com.design.utils.ParameterUtil;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.UUIDGenerator;
import com.design.utils.oConvertUtils;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Tools;
import com.zxlhdata.framework.auth.util.LicenseUtil;

/**
 * @Title: Controller
 * @author onlineGenerator
 * @date 2014-08-30 10:54:41
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/listPageGenController")
public class ListPageGenController  {
	/**
	 * Logger for this class
	 */
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	@Autowired
	private ListPageGenServiceI tSListPageGenService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private IUserService userService;
	@Autowired
	private MipOrganizationService organizationService;


	
	
	public List<CgformBussQueryEntity> getFieldByQueryList(String bussId) {
		CriteriaQuery cq = new CriteriaQuery(CgformBussQueryEntity.class);
		cq.eq("bussId", bussId);
		cq.addOrder("sort", SortDirection.asc);
		cq.add();
		return systemService.getListByCriteriaQuery(cq, false);
	}
	
	/**
	 * @throws Exception 
	 * 
	 * @Title: getQueryCondition
	 * @Description: 取查询条件组合editByHexj20161125
	 * @param request
	 * @param response
	 * @param 设定文件
	 * @return AjaxJson 返回类型
	 * @throws
	 */
	@RequestMapping(params = "getQueryCondition", method = RequestMethod.GET)
	@ResponseBody
	public Map getQueryCondition(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String gno = oConvertUtils.getString(request.getParameter("bussCode"),
				"");
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		int versionnum = oConvertUtils.getInt(request.getParameter("versionnum"),-1);
		String bussCode = oConvertUtils.getString(
				request.getParameter("bussCode"), "");
		
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
		CgformDefineEntity tBCulConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
		String mainTable = "";
		String detailTable = "";
		if (tBCulConfigform != null) {
			mainTable = tBCulConfigform.getMtableName();
		}
		
		if("2".equals(tBCulConfigform.getSaveType())){
			mainTable="cgform_rdata_master";
		}
		
		StringBuffer sas = new StringBuffer();
		Map j = new HashMap();
		j.put("success", false);
		// List<TBCulIndexrelationEntity> tBCulIndexList =
		// tBCulCoreCommonService
		// .getIndexQueryCondition(gno, ResourceUtil.getSessionMunitId());
		sas.append("[");
		List<CgformBussQueryEntity> mainList = new ArrayList<CgformBussQueryEntity>();
		if (StringUtil.isNotEmpty(mainTable)) {
			mainList = getFieldByQueryList(cgformBuss.getId());
		}
		if (mainList != null && mainList.size() > 0) {
			for (int iq = 0; iq < mainList.size(); iq++) {
				CgformBussQueryEntity cgFormField = mainList.get(iq);
				sas.append("{");
				sas.append("\"tiaoJianName\": \"" + cgFormField.getContent()
						+ "\",");
				sas.append("\"tiaoJianField\": \"" + cgFormField.getDefineId()
						+ "@" + cgFormField.getFieldName() + "\",");
				sas.append("\"tiaoJianId\": \"" + cgFormField.getFieldName()
						+ "_" + cgFormField.getId() + "\",");
//				if (StringUtil.isNotEmpty(cgFormField.getDictField())) {
//					sas.append("\"isinput\": false,");
//					sas.append("\"ismore\": true,");
//				} else {
					sas.append("\"isinput\": true,");
					sas.append("\"ismore\": false,");
//				}
				
				//加入日期状态
//				if("date".equals(cgFormField.getShowType())){
//					sas.append("\"isdate\": 1,");
//				}else if("datetime".equals(cgFormField.getShowType())){
//					sas.append("\"isdate\": 2,");
//				}else{
//					sas.append("\"isdate\": 0,");
//				}

				if (StringUtil.isNotEmpty(cgFormField.getQueryMode())
						&& "group".equals(cgFormField.getQueryMode())) {
					sas.append("\"isdefined\": true");
				} else {
					sas.append("\"isdefined\": false");
				}
				
//				if (StringUtil.isNotEmpty(cgFormField.getDictField())) {
//					sas.append(",");
//					sas.append("\"tiaoJianList\": [");
//
////					List<TSType> stypes = TSTypegroup.allTypes.get(cgFormField
////							.getDictField().toLowerCase());
////					if(stypes!=null&&stypes.size()>0){
////						for (int is = 0; is < stypes.size(); is++) {
////							TSType tstype = stypes.get(is);
////							sas.append("{");
////							sas.append("\"name\": \"" + tstype.getTypename()
////									+ "\",");
////							sas.append("\"value\": \"" + tstype.getTypecode()
////									+ "\"");
////							sas.append("}");
////							if ((stypes.size() - is) != 1) {
////								sas.append(",");
////							}
////						}
////					}
//					//换成动态获取
//					sas.append("]");
//				}
				sas.append("}");
				if ((mainList.size() - iq) != 1) {
					sas.append(",");
				}
			}
		}
		sas.append("]");
		System.out.println(sas.toString());
		JSONArray json = JSONArray.fromObject(sas.toString());
		j.put("obj", json);
		j.put("success", true);
		return j;
	}

	@RequestMapping(params = "goSelectSysCode")
	public ModelAndView goSelectSysCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//		if(!LicenseUtil.valid(authType, randomCode)){
//			return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		String typegroupCode = oConvertUtils.getString(
				request.getParameter("typegroupCode"), "");
		String defVal = oConvertUtils.getString(request.getParameter("defVal"),
				"");// defVal，如果默认值为空则查询该字典下的所有
		request.setAttribute("typegroupCode", typegroupCode);
		request.setAttribute("defVal", defVal);
		return new ModelAndView(prefix+"pagegen/selectSysCode"+suffix);
	}

	@RequestMapping(params = "goQueryMain")
	public ModelAndView goQueryMain(HttpServletRequest request) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String bussCode = oConvertUtils.getString(
				request.getParameter("bussCode"), "");
		String isSelect = oConvertUtils.getString(
				request.getParameter("isSelect"), "false");
		String query = oConvertUtils.getString(request.getParameter("query"),
				"");
		request.setAttribute("bussCode", bussCode);
		request.setAttribute("query", query);
		request.setAttribute("isSelect", isSelect);
		request.setAttribute("generateID", UUIDGenerator.generate());
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//		if(!LicenseUtil.valid(authType, randomCode)){
//			return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		return new ModelAndView(prefix+"pagegen/queryMain"+suffix);
	}

//	/**
//	 * 获得数据字典
//	 * 
//	 * @Title: getSelectSysCode
//	 * @Description:
//	 * @param request
//	 * @param response
//	 * @param 设定文件
//	 * @return AjaxJson 返回类型
//	 * @throws
//	 */
//	@RequestMapping(params = "getSelectSysCode")
//	@ResponseBody
//	public void getSelectSysCode(HttpServletRequest request,
//			HttpServletResponse response) {
//		String typegroupCode = oConvertUtils.getString(
//				request.getParameter("typegroupCode"), "");
//		String defVal = oConvertUtils.getString(request.getParameter("defVal"),
//				"");
//
//		List<TSType> tSTypeList = systemService
//				.getTypesByGroupCode(typegroupCode);
//		TSTypegroup group = systemService.getTypeGroupByCode(typegroupCode);
//		String id = oConvertUtils.getString(request.getParameter("id"), "");
//		String param = oConvertUtils.getString(request.getParameter("param"),
//				"");
//		String defVals[] = defVal.split("\\,");
//		StringBuffer rows = new StringBuffer();
//		rows.append("{");
//		rows.append("'id':'");
//		rows.append(typegroupCode);
//		rows.append("',");
//		// rows.append("'pId':'" +
//		// tSType.getTSTypegroup().getId() + "',");
//		rows.append("'pId':'root',");
//		rows.append("'name':'");
//		rows.append(oConvertUtils.getString(group.getTypegroupname()));
//		rows.append("'");
//		rows.append(",open:true},");
//		if (tSTypeList != null && tSTypeList.size() > 0) {
//			for (int i = 0; i < tSTypeList.size(); i++) {
//				TSType tSType = (TSType) tSTypeList.get(i);
//				String typename = oConvertUtils.getString(tSType.getTypename());
//				String typeid = oConvertUtils.getString(tSType.getId());
//				String typecode = oConvertUtils.getString(tSType.getTypecode());
//				TSType parentType = tSType.getTSType();
//				String parentId = "";
//				if (parentType != null)
//					parentId = oConvertUtils.getString(parentType.getId());
//				if (parentId == null || "".equals(parentId)) {
//					parentId = typegroupCode;
//				}
//				// List<TSType> tSTypList =
//				// systemService.findByProperty(TSType.class,"TSType.id",tSType.getId());
//				//
//				boolean isdefVal = false;
//				if (defVals.length > 0 && StringUtil.isNotEmpty(defVal)) {
//					for (int o = 0; o < defVals.length; o++) {
//						if (defVals[o].equals(typecode)) {
//							isdefVal = true;
//						}
//					}
//				} else {
//					isdefVal = true;
//				}
//				if (isdefVal) {
//					if (StringUtil.isNotEmpty(param)) {
//						if (typename.indexOf(param) != -1) {
//							rows.append("{");
//							rows.append("'id':'" + typeid + "',");
//							rows.append("'code':'" + typecode + "',");
//							rows.append("'pId':'" + parentId + "',");
//							rows.append("'name':'"
//									+ oConvertUtils.getString(tSType
//											.getTypename()) + "'");
//							rows.append("}");
//							if ((tSTypeList.size() - i) != 1) {
//								rows.append(",");
//							}
//						}
//					} else {
//						rows.append("{");
//						rows.append("'id':'" + typeid + "',");
//						rows.append("'code':'" + typecode + "',");
//						rows.append("'pId':'" + parentId + "',");
//						rows.append("'name':'" + typename + "'");
//						rows.append("}");
//						if ((tSTypeList.size() - i) != 1) {
//							rows.append(",");
//						}
//					}
//				}
//			}
//		}
//		String rowStr = "[" + rows.toString() + "]";
//		response.setContentType("application/json");
//		response.setHeader("Cache-Control", "no-store");
//		PrintWriter pw = null;
//		try {
//			pw = response.getWriter();
//		} catch (java.io.IOException e) {
//			e.printStackTrace();
//		}
//		pw.write(rowStr);
//		pw.flush();
//	}

	
//	/**
//	 * 获得数据字典
//	 * 
//	 * @Title: getSelectSysCode
//	 * @Description:
//	 * @param request
//	 * @param response
//	 * @param 设定文件
//	 * @return AjaxJson 返回类型
//	 * @throws
//	 */
//	@RequestMapping(params = "getSelectSysCode1")
//	public @ResponseBody List<Map<String, Object>> getSelectSysCode1(HttpServletRequest request, HttpServletResponse response) {
//		List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
//		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
//		String typegroupCode = oConvertUtils.getString(request.getParameter("typegroupCode"), "");
//		String defVal = oConvertUtils.getString(request.getParameter("defVal"), "");
//		
//		//List<TSType> tSTypeList = systemService.getTypesByGroupCode(typegroupCode);
//		TSTypegroup group = systemService.getTypeGroupByCode(typegroupCode);
//		
//		String sql = "select * from t_s_type where typegroupid='" + group.getId()+"'";
//		
//
//		sql += " ORDER BY sort";
//		
//		List<Map<String, Object>> tSTypeList = systemService.findForJdbc(sql.toString(), new ArrayList<Object>().toArray());
//		
//		String param = oConvertUtils.getString(request.getParameter("param"), "");
//		String defVals[] = defVal.split("\\,");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", typegroupCode);
//		map.put("name", oConvertUtils.getString(group.getTypegroupname()));
//		map.put("pId", "root");
//		map.put("open", true);
//		json.add(map);
//		if (tSTypeList != null && tSTypeList.size() > 0) {
//			for (int i = 0; i < tSTypeList.size(); i++) {
//				/*TSType tSType = (TSType) tSTypeList.get(i);
//				String typename = oConvertUtils.getString(tSType.getTypename());
//				String typeid = oConvertUtils.getString(tSType.getId());
//				String typecode = oConvertUtils.getString(tSType.getTypecode());
//				TSType parentType = tSType.getTSType();*/
//				Map<String, Object> mapTSType = tSTypeList.get(i);
//				String typename = oConvertUtils.getString(String.valueOf(mapTSType.get("TYPENAME")));
//				String typeid = oConvertUtils.getString(String.valueOf(mapTSType.get("ID")));
//				String typecode = oConvertUtils.getString(String.valueOf(mapTSType.get("TYPECODE")));
//				String parentId = oConvertUtils.getString(String.valueOf(mapTSType.get("TYPEPID")));
//				
//				/*String parentId = "";
//				if (parentType != null)
//					parentId = oConvertUtils.getString(parentType.getId());*/
//				if (parentId == null ||"".equals(parentId)) {
//					parentId = typegroupCode;
//				}
//				boolean isdefVal = false;
//				if (defVals.length > 0 && StringUtil.isNotEmpty(defVal)) {
//					for (int o = 0; o < defVals.length; o++) {
//						if (defVals[o].equals(typecode)) {
//							isdefVal = true;
//						}
//					}
//				} else {
//					isdefVal = true;
//				}
//				if (isdefVal) {
//					if (StringUtil.isNotEmpty(param) && typename.indexOf(param) < 0) {
//						continue;
//					}
//					map = new HashMap<String, Object>();
//					map.put("id", typeid);
//					map.put("name", typename);
//					map.put("pId", parentId);
//					map.put("code", typecode);
//					json.add(map);
//				}
//			}
//		}
//		return json;
//	}

	
	
	/**
	 * @throws Exception 
	 * 获得图文或者简易列表数据
	 * 
	 * @Title: getCollectinMainListData
	 * @Description:
	 * @param tBCulCollectinfoMain
	 * @param request
	 * @param 设定文件
	 * @return AjaxJson 返回类型
	 * @throws
	 */
	@RequestMapping(params = "getTWorJYListData")
	@ResponseBody
	public AjaxJson getTWorJYListData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		AjaxJson j = new AjaxJson();
		String tmageTextJson = tSListPageGenService.getJsonByBussData(request);
		if (StringUtil.isNotEmpty(tmageTextJson)) {
			System.out.println(tmageTextJson);
			JSONArray json = JSONArray.fromObject(tmageTextJson);
			j.setObj(json);
			j.setSuccess(true);
		} else {
			j.setSuccess(false);
		}
		return j;
	}
	
	
	
	@RequestMapping(params = "getListTitle")
	@ResponseBody
	public List<LayuiCols> getListTitle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"));
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
		
		List<CgformBussListEntity> mainList = getFieldByBussList(cgformBuss.getId(),new String[]{"isShowList"});
		List<LayuiCols> layuiColsList=new ArrayList<LayuiCols>();
		if (mainList != null && mainList.size() > 0) {
			for (int iq = 0; iq < mainList.size(); iq++) {
				LayuiCols layuiCols=new LayuiCols();
				layuiCols.setAlign("left");
				layuiCols.setTitle(mainList.get(iq).getContent());
				layuiCols.setWidth(oConvertUtils.getInt(mainList.get(iq).getColumnWidth()));
				layuiCols.setField(mainList.get(iq).getFieldName());
				layuiCols.setIsHide(mainList.get(iq).getIsListHide());
				layuiColsList.add(layuiCols);
			}
		}
//		if(StringUtil.isNotEmpty(cgformBuss.getOperationWidth())&&oConvertUtils.getInt(cgformBuss.getOperationWidth())>0){
			LayuiCols layuiCols=new LayuiCols();
			layuiCols.setTitle("操作");
			layuiCols.setToolbar("#"+bussCode+"_bar");
			layuiCols.setFixed("right");
			layuiCols.setAlign("center");
			layuiCols.setWidth(oConvertUtils.getInt(cgformBuss.getOperationWidth()));
			layuiColsList.add(layuiCols);
//		}
		
		return layuiColsList;
	}
	
	
	@RequestMapping(params = "getQueryList")
	@ResponseBody
	public Map<String,Object> getQueryList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"));
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
		
		List<CgformBussQueryEntity> mainList = getFieldByQueryList(cgformBuss.getId());
		List<LayuiCols> layuiColsList=new ArrayList<LayuiCols>();
		Map<String,Object> m=new HashMap<String,Object>();
		
		
		if (mainList != null && mainList.size() > 0) {
			for (int iq = 0; iq < mainList.size(); iq++) {
				LayuiCols layuiCols=new LayuiCols();
				layuiCols.setTitle(mainList.get(iq).getContent());
				layuiCols.setField(mainList.get(iq).getFieldName());
				layuiCols.setType(mainList.get(iq).getQueryMode());
					CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
					cq.eq("id", mainList.get(iq).getDefineId());
//					cq.eq("fieldName", mainList.get(iq).getFieldName());
					cq.add();
					List<CgFormLgFieldEntity> e1 = systemService.getListByCriteriaQuery(cq, false);
				layuiCols.setShowType(((e1!=null&&e1.size()>0)?e1.get(0).getShowType():""));
				layuiCols.setDictField(((e1!=null&&e1.size()>0)?e1.get(0).getDictField():""));
				layuiCols.setDictText(((e1!=null&&e1.size()>0)?e1.get(0).getDictText():""));
				layuiCols.setFieldHref(((e1!=null&&e1.size()>0)?e1.get(0).getFieldHref():""));
				layuiCols.setSelectId(((e1!=null&&e1.size()>0)?e1.get(0).getSelectId():""));
				layuiCols.setInputId(((e1!=null&&e1.size()>0)?e1.get(0).getInputId():""));
				layuiCols.setWindowHeight(((e1!=null&&e1.size()>0)?e1.get(0).getWindowHeight():""));
				layuiCols.setWindowWidth(((e1!=null&&e1.size()>0)?e1.get(0).getWindowWidth():""));
				layuiColsList.add(layuiCols);
			}
		}
		String  html= queryHtml(layuiColsList,bussCode);
		m.put("obj", layuiColsList);
		m.put("html", html);
		return m;
	}

	private String queryHtml(List<LayuiCols> layuiColsList,String bussCode) throws Exception {
		String html="";
		CgformBussEntity tSConfigform = systemService
				.findUniqueByProperty(CgformBussEntity.class, "bussCode",
						bussCode);
		CgformDefineEntity define = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "id",
						tSConfigform.getDefineId());
		if (layuiColsList != null && layuiColsList.size() > 0) {
		html+="<div class='list-screen' style='margin-bottom: 10px;'>";
		html+="<form method='post' name='queryTableMainForm_"+bussCode+"'   id='queryTableMainForm_"+bussCode+"' target='_self'>";
		html+="<div id='queryModel_11_' class=' hasBeenSelected clearfix'>";
		html+="<div class='screen-top' style='position:relative;float:right;'>";
		html+="<div class='ui action input' style='margin-right:5px;'>";
		html+="<div type='button' class='layui-btn' onclick='queryData_"+bussCode+"()'>查询</div>";
		html+="<div type='button' class='layui-btn layui-btn-primary'  onclick='clearQueryData_"+bussCode+"()'>清除条件</div>";
		html+="</div>";
		html+="</div>";
		html+="<dl>";
		html+="<dt>已选条件：</dt>";
		html+="<dd style='' class='clearDd'>";
		html+="<div id='clearList_11_' class='clearList'></div>";
		html+="</dd></dl>";
		html+="</div>";
		html+="</form>";
		html+="<div id='selectList' class='screenBox screenBackground'>";
		html+="<div id='J_searchWrap' class='w'>";
		html+="<div id='J_container'>";
		html+="<div id='J_selector' class='selector'>";
		
			for (int iq = 0; iq < layuiColsList.size(); iq++) {
				String isHide="openQuery";
				if((iq+1)>oConvertUtils.getInt(tSConfigform.getInitRow(),2)){
					isHide="hideQuery";
				}
					html += "<div  class='J_selectorLine s-line s-brand "+isHide+" ' hide_div='"+isHide+"' style='margin-top: 5px;' >";
					html += "<div class='sl-wrap' id='pingpai' >";
					html += "<div class='sl-key col-xs-2' style='text-align: right;'>";
					html += "<span>"+layuiColsList.get(iq).getTitle()+"：</span>";
					html += "</div>";
					
					if ("group".equals(layuiColsList.get(iq).getType())) {
						html += "<input type='hidden' id='"+layuiColsList.get(iq).getField()+"' name='"+layuiColsList.get(iq).getField()+"' value=''>";
						html += "<input type='hidden' id='"+layuiColsList.get(iq).getField()+"_show' name='"+layuiColsList.get(iq).getField()+"_show' value=''>";
						
						html += "<div class='sl-value' >";
						html += "<div class='clr'></div>";
						html += "<div class='sl-v-list col-xs-10' style='height: 40px;' >";
						html += "<input  style='display: initial;width: 40%;text-align: left;' "
								+ " typegroupid='"+layuiColsList.get(iq).getField()+"_start'  typename='"+layuiColsList.get(iq).getTitle()+"-start'";
						html += "name='" + layuiColsList.get(iq).getField()
								+ "_start'";
						if ("year".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy' class='layui-input' ";
						}
						else if ("yymm".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy-MM' class='layui-input' ";
						}
						else if ("date".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy-MM-dd' class='layui-input' ";
						}
						else if ("datetime".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy-MM-dd HH:mm:ss' class='layui-input' ";
						}
						else if ("time".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='HH:mm:ss'  class='layui-input' ";
						}else{
							html += " class='sl-inputtext-ss layui-input' ";
						}
						html += "id='" + layuiColsList.get(iq).getField()
								+ "_start' >";
						html += "&nbsp;至&nbsp;<input style='display: initial;width: 40%;text-align: left;'"
								+ " typegroupid='"+layuiColsList.get(iq).getField()+"_end'  typename='"+layuiColsList.get(iq).getTitle()+"-end'";
						html += "name='" + layuiColsList.get(iq).getField()
								+ "_end'";
						if ("year".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy' class='layui-input' ";
						}
						else if ("yymm".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy-MM' class='layui-input' ";
						}
						else if ("date".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy-MM-dd' class='layui-input' ";
						}
						else if ("datetime".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='yyyy-MM-dd HH:mm:ss' class='layui-input' ";
						}
						else if ("time".equals(layuiColsList.get(iq).getShowType())) {
							html += "placeholder='HH:mm:ss' class='layui-input' ";
						}else {
							html += "class='sl-inputtext-ss layui-input'  ";
						}
						html += "id='" + layuiColsList.get(iq).getField()
								+ "_end' >";
						html += "</div>";
						html += "</div>";
//						html += "</div>";
					}else{
						
						html += "<div class='sl-value' >";
						html += "<div class='clr'></div>";
						
						if("list".equals(layuiColsList.get(iq).getShowType())
								||"checkbox".equals(layuiColsList.get(iq).getShowType())
								||"radio".equals(layuiColsList.get(iq).getShowType())){
							html += "<div class='sl-v-list col-xs-10' style='height:100%'>";
							html += "<ul class='J_valueList v-fixed'>";
							html += "<dd>";
							html += "<input type='hidden' id='typegroupname' name='typegroupname' value='"+layuiColsList.get(iq).getTitle()+"'>";
							if(StringUtil.isNotEmpty(layuiColsList.get(iq).getDictText())
									&&StringUtil.isNotEmpty(layuiColsList.get(iq).getDictField())
									&&StringUtil.isNotEmpty(layuiColsList.get(iq).getFieldHref())
									&&StringUtil.isNotEmpty(layuiColsList.get(iq).getSelectId())){
								String selectId=layuiColsList.get(iq).getSelectId();
								String dictText=layuiColsList.get(iq).getDictText();
								String dictField=layuiColsList.get(iq).getDictField();
								if(selectId.endsWith(",")){
									selectId=selectId.substring(0, selectId.length()-1);
								}
									List<Map<String, Object>> rr1 = systemService.findForJdbc("select json_sql from cgform_select_back where s_code='"+layuiColsList.get(iq).getFieldHref()+"'");
									if(rr1!=null&&rr1.size()>0){
										String sl="select "+selectId+" from ("+rr1.get(0).get("json_sql")+") as w ";
										List<Map<String, Object>> rr = systemService.findForJdbc(sl);
										if(rr!=null&&rr.size()>0){
											for(int s=0;s<rr.size();s++){
												html += "<li id='brand-8557'  ><label>";
									            	 html += "<a href='javascript:;'  "
																+ "id='tiaoJianId_1111_"+layuiColsList.get(iq).getField()+"_"+rr.get(s).get(dictText)+"' "
																+ " values2='' "
																+ "typegroupid='"+layuiColsList.get(iq).getField()+"'  "
																+ "value='"+rr.get(s).get(dictText)+"' "
																+ "values1='' ";
									            	 html +="title='"+ rr.get(s).get(dictField)+"' "
									            	 		+ "typename='"+ rr.get(s).get(dictField)+"' "
									            	 		+ "attrval='"+ rr.get(s).get(dictField)+"' >"+ rr.get(s).get(dictField)+"<i></i>";
														html += "</a>";
												html += "</label></li>";
											}
										}
									}
								}
							html += "</dd>";
							html += "</ul>";
						}else if("popup".equals(layuiColsList.get(iq).getShowType())){
							html += "<div class='sl-v-list col-xs-10' style='height:35px'>";
							html += "<div class='col-xs-10' style='padding-left: 0px;'>";
							html += "<input class='layui-input ' ";
							html += "name='"+ layuiColsList.get(iq).getField() + "'";
							html += "id='"+define.getDefineCode()+"@"+ layuiColsList.get(iq).getField() + "' typegroupid='"+layuiColsList.get(iq).getField()+"'  typename='"+layuiColsList.get(iq).getTitle()+"'";
							html += " type='hidden'>";
							html += "<input class='layui-input ' style='display: inherit;width: 100%;text-align: left;'";
							html += "name='showName_"+define.getDefineCode()+"_" + layuiColsList.get(iq).getField() + "'";
							html += "id='showName_"+define.getDefineCode()+"_" + layuiColsList.get(iq).getField() + "' "
									+ "typegroupid='"+layuiColsList.get(iq).getField()+"'  "
											+ "typename='"+layuiColsList.get(iq).getTitle()+"'";
							html += " type='inputxt' readonly='readonly'>";
							html += "</div>";
							html += "<div class='col-xs-2' style='text-align: left;'>";
							html += "<span class='fly-search LAY_search' "
									+ " onclick=\"popupChoose('"+define.getDefineCode()+"','"+layuiColsList.get(iq).getFieldHref()+"','"+layuiColsList.get(iq).getWindowWidth()+"','"+layuiColsList.get(iq).getWindowHeight()+"','" + layuiColsList.get(iq).getInputId() + "','"+layuiColsList.get(iq).getSelectId()+"','','"+ layuiColsList.get(iq).getField() + "');\" "
									+ "><i class='layui-icon'></i></span>";
							html += "</div>";
						} else{
							html += "<div class='sl-v-list col-xs-10' style='height:35px'>";
							html += "<input  style='display: inherit;width: 100%;text-align: leftt;'";
							html += "name='" + layuiColsList.get(iq).getField() + "'";
							html += "id='" + layuiColsList.get(iq).getField() + "' "
									+ "typegroupid='"+layuiColsList.get(iq).getField()+"'  "
											+ "typename='"+layuiColsList.get(iq).getTitle()+"'";
							if ("year".equals(layuiColsList.get(iq).getShowType())) {
								html += "placeholder='yyyy' class='layui-input ' ";
							}
							else if ("yymm".equals(layuiColsList.get(iq).getShowType())) {
								html += "placeholder='yyyy-MM' class='layui-input '";
							}
							else if ("date".equals(layuiColsList.get(iq).getShowType())) {
								html += "placeholder='yyyy-MM-dd' class='layui-input '";
							}
							else if ("datetime".equals(layuiColsList.get(iq).getShowType())) {
								html += "placeholder='yyyy-MM-dd HH:mm:ss' class='layui-input '";
							}
							else if ("time".equals(layuiColsList.get(iq).getShowType())) {
								html += "placeholder='HH:mm:ss' class='layui-input '";
							}else{
								html += "placeholder='多条件查询请用“,”隔开' class='sl-inputtext-ss layui-input '";
							}
							html += " >";
						}
						html += " </div>";
						if("list".equals(layuiColsList.get(iq).getShowType())
								||"checkbox".equals(layuiColsList.get(iq).getShowType())
								||"radio".equals(layuiColsList.get(iq).getShowType())){
							html += "<div class='sl-ext'  >";
							html += "<span onclick='j_more(this);' style='visibility: visible;cursor:pointer;' id='geng_duo' class='sl-e-more J_extMore'>更多<i></i> </span>";
							html += "</div>";
						}
						html += "</div>";
						
					}
					html += "</div>";
					html += "</div>";
					
					
			}
	if(layuiColsList.size()>oConvertUtils.getInt(tSConfigform.getInitRow(),2)){
		html += "<div id='J_selectorMore' class='s-more'   >";
		html += "<span onclick='s_more(this,\""+bussCode+"\");'  class='sm-wrap' id='gengduoxuanxiang'> <span style='visibility: visible;cursor:pointer;'>更多条件<i></i>";
		html += "</span> </span>";
		html += "</div>";
	}
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "<script  type=\"text/javascript\"  >";
    html += "function popupChoose(bussCode,fieldHref,windowWidth_,windowHeight_,inputId,selectId,wherePara,fieldName) {";
    html += "if(fieldHref==\"\"||fieldHref==null){";
    html += "layer.msg('请先配置数据源！', {icon: 5});";
    html += "return false;";
    html += " }";
    html += "var windowWidth = windowWidth_!=null&&windowWidth_!=\"\"&&windowWidth_!=\"null\"?windowWidth_:document.body.offsetWidth*(parseFloat(\"100\")/100);";
    html += "var windowHeight = windowHeight_!=null&&windowHeight_!=\"\"&&windowHeight_!=\"null\"?windowHeight_:document.body.offsetHeight*(parseFloat(\"100\")/100)-100;";
    html += "if(windowWidth.toString().indexOf(\"%\")!=-1){";
    html += "windowWidth = document.body.offsetWidth*(parseFloat(windowWidth)/100);";
    html += "}";
    html += "if(windowHeight.toString().indexOf(\"%\")!=-1){";
    html += "windowHeight =document.body.offsetHeight*(parseFloat(windowHeight)/100)-100;";
    html += "}";
    html += "windowHeight=parseFloat(windowHeight);";
    html += "windowHeight=windowHeight;";
    html += "layer.open({";
    html += "type: 2,";
    html += "title: '请选择',";
    html += "maxmin: true,";
    html += "shadeClose: true,";
    html += "area: [windowWidth+'px', windowHeight+'px'],";
    html += "content: 'editPageGenController.do?goSelectPage&wherePara='+wherePara+'&selectId='+selectId+'&inputId='+inputId+'&sCode='+fieldHref,";
    html += "btn: ['确定', '关闭'],";
    html += " yes: function(index, layero) {";
   /* html += " try{clickcallback_" + $.businessCode+"_"+designO["fieldName"] + "(0,layero, index);}catch(e){layer.msg('未实现clickcallback_" + $.businessCode+"_"+designO["fieldName"]+ "方法！', {icon: 5});}";*/
    html += " var iframeWin =  $(layero).find('iframe')[0].contentWindow;";
    html += " try{iframeWin.backDataToPage();}catch(e){layer.msg('未实现backDataToPage方法！', {icon: 5});}";
    html += " var typegroupId=$('#selectList').find('#showName_'+bussCode+'_'+fieldName).attr('typegroupId');";
	html += " var typename=$('#selectList').find('#showName_'+bussCode+'_'+fieldName).attr('typename');";
	html += " var value=$('#selectList').find(\"[id='\"+bussCode+\"@\"+fieldName+\"']\").val();";
	html += " var valueNmae=$('#selectList').find(\"[id='showName_\"+bussCode+\"_\"+fieldName+\"']\").val();";
	html += " if(value!=null&&value!=\"\"){";
	html += " var infor = '<div class=\"selectedInfor selectedShow\">'+";
	html += " '<input type=\"hidden\" id=\"'+typegroupId+'\" name=\"'+typegroupId+'\" value=\"'+value+'\">'+";
	html += " '<input type=\"hidden\" id=\"'+typegroupId+'_s111s000\" name=\"'+typegroupId+'_s111s000\" value=\"'+value+'\">'+";
	html += " '<span>' + typename + '</span>：<label>' + valueNmae + '</label><em isinput=\"false\"></em></div>';";
	html += " oClearList.append(infor);";
	html += " $('#selectList').find(\"[id='\"+bussCode+\"@\"+fieldName+\"']\").val('');";
	html += " $('#selectList').find(\"[id='showName_\"+bussCode+\"_\"+fieldName+\"']\").val('');";
	html += " emClick(bussCode);";
	html += " parent.layer.close(index);";
	html += " }";
    html += " },";
    html += " cancel: function() {}";
    html += " });";
    html += " }";
    html += "</script>";
    html += "<style type='text/css'>";
    html += ".openQuery {";
	html += "display: inline;";
	html += " }";
	html += ".hideQuery {";
	html += "display: none;";
	html += "}";
    html += "</style>";
		}
		return html;
	}
	
	
	@RequestMapping(params = "getListData")
	@ResponseBody
	public Map<String,Object> getListData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		int page = oConvertUtils.getInt(request.getParameter("page"), 1);
		int limit = oConvertUtils.getInt(request.getParameter("limit"),1);
		Map<String,Object> mp=new HashMap<String,Object>();
		
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"));
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
		if(cgformBuss==null){
			mp.put("code", -1);
			mp.put("success", false);
			mp.put("msg", "未找到编码为【"+bussCode+"】业务");
			mp.put("count", 0);
			mp.put("data", null);
			return mp;
		}
		CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
		List<CgformBussListEntity> mainList = getFieldByBussList(cgformBuss.getId(),new String[]{"isShowList"});
		List<Map<String, Object>> aaq11 = systemService.findForJdbc("select field_name,show_type,input_id,select_id,dict_text,dict_field,field_href from cgform_lg_field where define_id ='"+tSConfigform.getId()+"' and show_type in ('popup','list','checkbox','radio')");
		if("0".equals(cgformBuss.getStatus())){
			mp.put("code", -1);
			mp.put("success", false);
			mp.put("msg", "未发布的业务");
			mp.put("count", 0);
			mp.put("data", null);
			return mp;
		}
		
		
		JSONObject jo=new JSONObject();
		String fields="",tempFields="";
		List<LayuiCols> layuiColsList=new ArrayList<LayuiCols>();
		if (mainList != null && mainList.size() > 0) {
			for (int iq = 0; iq < mainList.size(); iq++) {
				LayuiCols layuiCols=new LayuiCols();
				layuiCols.setAlign("left");
				layuiCols.setTitle(mainList.get(iq).getContent());
				layuiCols.setWidth(oConvertUtils.getInt(mainList.get(iq).getColumnWidth()));
				layuiCols.setField(mainList.get(iq).getFieldName());
				layuiColsList.add(layuiCols);
				fields+=mainList.get(iq).getFieldName()+",";
			}
			fields=fields.substring(0, fields.length()-1);
		}
		String mainTableName = tSConfigform.getMtableName();
		if("2".equals(tSConfigform.getSaveType())){
			mainTableName = "cgform_rdata_master";
			List<Map<String, Object>> rr1 = systemService.findForJdbc("SELECT field_name,temp_field   FROM cgform_field_temp"
					+ "  where buss_id='"+cgformBuss.getId()+"' ");
			if(rr1!=null&&rr1.size()>0){
				for(Map<String, Object> m:rr1){
//					and field_name not in ('create_date','create_by','create_name','org_id','org_name','update_by','update_name','update_date')
					if(m.get("field_name").equals("id")
							||m.get("field_name").equals("create_date")
							||m.get("field_name").equals("create_by")
							||m.get("field_name").equals("create_name")
							||m.get("field_name").equals("org_id")
							||m.get("field_name").equals("org_name")
							||m.get("field_name").equals("update_by")
							||m.get("field_name").equals("update_name")
							||m.get("field_name").equals("update_date")){
						tempFields+=m.get("field_name")+"  as '"+m.get("field_name")+"',";
					}else{
						tempFields+=m.get("temp_field")+" as '"+m.get("field_name")+"',";
					}
					jo.put(m.get("field_name"), m.get("temp_field"));
				}
				tempFields=tempFields.substring(0, tempFields.length()-1);
			}
		}
		
		StringBuffer ssq = new StringBuffer();
		ssq.append(" SELECT  "+(!"".equals(tempFields)?tempFields:fields));
		ssq.append(" FROM "+mainTableName+" ");
		ssq.append(" where 1=1 ");
		if("2".equals(tSConfigform.getSaveType())){
			ssq.append(" and  buss_id='"+cgformBuss.getId()+"' ");
		}
		
		//按照上级查看下级的原则， 这里加载所有可以查看的单位
		//去掉指标管理 releaseCode=B1530720132097
		if("B1530720132097".equals(bussCode) || "B1530842987354".equals(bussCode) || "B1530720176225".equals(bussCode) 
				|| "B1530720176225".equals(bussCode) || "B1530720176225".equals(bussCode) || "B1530716962445".equals(bussCode)) {
			//不做权限控制
		}else {
			LoginInfoDto user = Tools.getUser();
			User user2 = userService.get(user.getId());
			List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(user2.getOrgId()), true);
			String orgs = "";
			for (com.tj720.admin.model.MipOrganization orgchild : sonOrg) {
				if(orgchild != null && orgchild.getId() != null && orgchild.getId() != 0) {
					orgs += "'" + orgchild.getId() + "',";
				}
			}
			if(StringUtils.isNotBlank(orgs)) {
				orgs = orgs.substring(0, orgs.length()-1);
			}
			ssq.append(" and  org_id in ("+orgs+") ");
		}
		
//		if(StringUtil.isNotEmpty(linkBussCode)){//如果有值，则表示是明细列表,需要从配置中查询关联的主表数据存储在哪个明细字段中
//			CgformDefineEntity mainTSConfigform = systemService.findUniqueByProperty(
//					CgformDefineEntity.class, "defineCode", bussCode);
//			List<Map<String, Object>> map11 = systemService.findForJdbc("select field_name,main_field,main_table from "
//					+ "cgform_lg_field where main_table like'%"+mainTSConfigform.getMtableName().toLowerCase()+"%' and BUSS_TEMPLATE_ID in (select id from t_s_buss_template where"
//					+ " configform_id='"+tSConfigform.getId()+"'  and template_type='0')  ");// and deleteflag<>'"+ResourceUtil.DELETEFLAG+"'
//			if(map11!=null&&map11.size()>0){
//				ssq.append(" and ( ");
//				for(int i=0;i<map11.size();i++){
//					ssq.append( map11.get(i).get("field_name")+" ='"+mainId+"' ");
//					if((map11.size()-i)!=1){
//						ssq.append(" or ");
//					}
//				}
//				ssq.append(" ) ");
//			}
//		}
		querySql(request, ssq,cgformBuss,mainTableName,jo);
		
		String sql_="describe "+mainTableName+" create_date";
		List<Map<String, Object>> aaq1 = systemService.findForJdbc(sql_);
		if(aaq1!=null&&aaq1.size()>0){
			ssq.append("  ORDER BY  "+mainTableName+".create_date desc ");
		}
		
		/******* 查询总数 ********/
		StringBuffer countQuerySql = new StringBuffer();
		countQuerySql.append(" SELECT ");
		countQuerySql.append(" COUNT(*) countsize ");
		countQuerySql.append(" FROM ");
		countQuerySql.append(" ( ");
		countQuerySql.append(ssq);
		countQuerySql.append(" ) countall ");

		List<Map<String, Object>> countQueryList = systemService
				.findForJdbc(countQuerySql.toString());// 总数
		/******* 查询总数 ********/
		ssq.append(" LIMIT  ?,? ");
		List<Object> mainPara = new ArrayList<Object>();
		mainPara.add((page - 1) * limit);
		mainPara.add(limit);
		List<Map<String, Object>> aaq = systemService.findForJdbc(ssq.toString(),mainPara.toArray());
		
		
		List<Map<String, Object>> dataList=new ArrayList<Map<String, Object>>();
		if(aaq!=null&&aaq.size()>0){
			for(Map<String, Object> d:aaq){
				Map<String, Object> data =new HashMap<String, Object>();
				if(StringUtil.isNotEmpty(fields)){
					for(String f1:fields.split("\\,")){
						data.put(f1, oConvertUtils.getString(d.get(f1)));
						if(aaq11!=null&&aaq11.size()>0){
							for(Map<String, Object> d1:aaq11){
								if(f1.equals(d1.get("field_name"))){
									if(StringUtil.isNotEmpty(d1.get("dict_text"))
											&&StringUtil.isNotEmpty(d1.get("dict_field"))
											&&StringUtil.isNotEmpty(d1.get("field_href"))){
											List<Map<String, Object>> rr1 = systemService.findForJdbc("select json_sql from cgform_select_back where s_code='"+d1.get("field_href")+"'");
//											String value="未配置查询数据表参数，请联系管理员！";
											String value=" - ";
											if(rr1!=null&&rr1.size()>0){
												String sl="select "+d1.get("dict_field")+" from ("+rr1.get(0).get("json_sql")+") as w where w."+d1.get("dict_text")+"='"+d.get(f1)+"'";
												//处理多值的情况
												if(StringUtil.isNotEmpty(d.get(f1))&&d.get(f1).toString().split("\\,").length>1){
													sl="select "+d1.get("dict_field")+" from ("+rr1.get(0).get("json_sql")+") as w where w."+d1.get("dict_text")+" in ('"+d.get(f1).toString().replace(",", "','")+"')";
												}
												List<Map<String, Object>> rr = systemService.findForJdbc(sl);
												
												if(rr!=null&&rr.size()>0){
													value="";
													for(int s=0;s<rr.size();s++){
														value+=rr.get(s).get(d1.get("dict_field")).toString()+",";
													}
													value=value.substring(0, value.length()-1);
												}
											}
											data.put(f1, value);
										}else{
//											data.put(f1, "未配置查询数据表参数，请联系管理员！");
											data.put(f1, " - ");
										}
									}
							}
								}
							}
						}
				dataList.add(data);
			}
		}
		mp.put("code", 0);
		mp.put("msg", "");
		mp.put("count", countQueryList.get(0).get("countsize"));
		mp.put("data", dataList);
		mp.put("success", true);
		return mp;
	}
	
	public void querySql(HttpServletRequest request, StringBuffer ssq,
			CgformBussEntity cgformBuss,
			String mainTableName,JSONObject jo) throws Exception {
		
		//通过查询表中参数查询相关字段数据
		List<CgformBussQueryEntity> mainList = getFieldByQueryList(cgformBuss.getId());
		for(CgformBussQueryEntity cgformBussQuery:mainList){
			String d=oConvertUtils.getString(request.getParameter(cgformBussQuery.getFieldName()));
			String start=oConvertUtils.getString(request.getParameter("query_"+cgformBussQuery.getFieldName()+"_start"));
			String end=oConvertUtils.getString(request.getParameter("query_"+cgformBussQuery.getFieldName()+"_end"));
			if(StringUtil.isNotEmpty(d)||StringUtil.isNotEmpty(start)||StringUtil.isNotEmpty(end)){
				if(jo.containsKey(cgformBussQuery.getFieldName())){
					ssq.append(getQueryWay(cgformBussQuery,jo.getString(cgformBussQuery.getFieldName()),d,request,jo));
				}else{
					ssq.append(getQueryWay(cgformBussQuery,cgformBussQuery.getFieldName(), d,request,jo));
				}
			}
		}
		/**初始化表单数据查询，在没有配置表单查询字段中，如果想查询某个字段的值，需要这样处理**/
		Map properties = request.getParameterMap();
		Iterator<Map.Entry<Integer, String>> it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			Object beforeV = entry.getValue();
			String sql_ = "describe " + mainTableName + " \""+entry.getKey()+"\"" ;
			List<Map<String, Object>> aaq1 = systemService.findForJdbc(sql_);
			if (aaq1 != null && aaq1.size() > 0&&StringUtil.isNotEmpty(((String[])beforeV)[0])) {
				String ssq1 =ssq.toString().split("where")[1];
				String ssq2 =" "+entry.getKey()+" ";
				String ssq3 =" "+entry.getKey()+" ";
				if(!ssq1.contains(ssq2)&&!ssq1.contains(ssq3)){//如果已经存在的查询条件就不应该在次查询，
					ssq.append("and " + entry.getKey()+ " = '"+ ((String[])beforeV)[0]+ "' ");
				}
			}
		}
		/**初始化表单数据查询，在没有配置表单查询字段中，如果想查询某个字段的值，需要这样处理**/
	}

	private String getQueryWay(CgformBussQueryEntity bussQuery,String fieldName,String queryValue,
			HttpServletRequest request,JSONObject jo) {
		boolean isTemp=true;
		if(bussQuery.getFieldName().equals("id")
				||bussQuery.getFieldName().equals("create_date")
				||bussQuery.getFieldName().equals("create_by")
				||bussQuery.getFieldName().equals("create_name")
				||bussQuery.getFieldName().equals("org_id")
				||bussQuery.getFieldName().equals("org_name")
				||bussQuery.getFieldName().equals("update_by")
				||bussQuery.getFieldName().equals("update_name")
				||bussQuery.getFieldName().equals("update_date")){
			fieldName=bussQuery.getFieldName();
			 isTemp=false;
		}
		
		
		String queryS=" and " + fieldName+ " = '"+ queryValue + "' ";
		CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
		cq.eq("id", bussQuery.getDefineId());
		cq.add();
		List<CgFormLgFieldEntity> e1 = systemService.getListByCriteriaQuery(cq, false);
		
		if("group".equals(bussQuery.getQueryMode())){
			String start=oConvertUtils.getString(request.getParameter("query_"+bussQuery.getFieldName()+"_start"));
			String end=oConvertUtils.getString(request.getParameter("query_"+bussQuery.getFieldName()+"_end"));
			if(jo.containsKey(bussQuery.getFieldName())&&isTemp){//说明是键值保存的
				if(e1!=null&&e1.size()>0){
					if("date".equals(e1.get(0).getType().toLowerCase())){
						if("date".equals(e1.get(0).getShowType())){
							queryS=" and (STR_TO_DATE(" + fieldName+ ",'%Y-%m-%d')>'"+start+"' ";
							queryS+=" and STR_TO_DATE(" + fieldName+ ",'%Y-%m-%d')<'"+end+"' ) ";
						}
						if("datetime".equals(e1.get(0).getShowType())){
							queryS=" and ( STR_TO_DATE(" + fieldName+ ",'%Y-%m-%d %T')>'"+start+"' ";
							queryS+=" and STR_TO_DATE(" + fieldName+ ",'%Y-%m-%d %T')<'"+end+"' ) ";
						}
						if("yymm".equals(e1.get(0).getShowType())){
							queryS=" and ( STR_TO_DATE(" + fieldName+ ",'%Y-%m')>'"+start+"' ";
							queryS+=" and STR_TO_DATE(" + fieldName+ ",'%Y-%m')<'"+end+"' ) ";
						}
						if("year".equals(e1.get(0).getShowType())){
							queryS=" and ( STR_TO_DATE(" + fieldName+ ",'%Y')>'"+start+"' ";
							queryS+=" and STR_TO_DATE(" + fieldName+ ",'%Y')<'"+end+"' ) ";
						}
						if("time".equals(e1.get(0).getShowType())){
							queryS=" and ( STR_TO_DATE(" + fieldName+ ",'%T')>'"+start+"' ";
							queryS+=" and STR_TO_DATE(" + fieldName+ ",'%T')<'"+end+"' ) ";
						}
					}
					if("int".equals(e1.get(0).getType())){
						queryS=" and ( CONVERT("+fieldName+",SIGNED) >"+start+" ";
						queryS+=" and CONVERT("+fieldName+",SIGNED)<"+end+" ) ";
					}
				}
			}else{
				if(e1!=null&&e1.size()>0){
					if("date".equals(e1.get(0).getType().toLowerCase())){
						if("date".equals(e1.get(0).getShowType())){
							queryS=" and (  DATE_FORMAT(" + fieldName+ ",'%Y-%m-%d')>'"+start+"' ";
							queryS+=" and DATE_FORMAT(" + fieldName+ ",'%Y-%m-%d')<'"+end+"' ) ";
						}
						if("datetime".equals(e1.get(0).getShowType())){
							queryS=" and (  DATE_FORMAT(" + fieldName+ ",'%Y-%m-%d %T')>'"+start+"' ";
							queryS+=" and DATE_FORMAT(" + fieldName+ ",'%Y-%m-%d %T')<'"+end+"' ) ";
						}
						if("yymm".equals(e1.get(0).getShowType())){
							queryS=" and (  DATE_FORMAT(" + fieldName+ ",'%Y-%m')>'"+start+"' ";
							queryS+=" and DATE_FORMAT(" + fieldName+ ",'%Y-%m')<'"+end+"' ) ";
						}
						if("year".equals(e1.get(0).getShowType())){
							queryS=" and (  DATE_FORMAT(" + fieldName+ ",'%Y')>'"+start+"' ";
							queryS+=" and DATE_FORMAT(" + fieldName+ ",'%Y')<'"+end+"' ) ";
						}
						if("time".equals(e1.get(0).getShowType())){
							queryS=" and (  DATE_FORMAT(" + fieldName+ ",'%T')>'"+start+"' ";
							queryS+=" and DATE_FORMAT(" + fieldName+ ",'%T')<'"+end+"' ) ";
						}
					}
					if("int".equals(e1.get(0).getType().toLowerCase())){
						queryS=" and (  "+fieldName+">"+start+" ";
						queryS+=" and "+fieldName+"<"+end+" ) ";
					}
				}
			}
		}else{
			queryValue=oConvertUtils.getString(request.getParameter(bussQuery.getFieldName()));
			queryValue = queryValue.replaceAll("，", ",");
			if("like".equals(bussQuery.getQueryType())){
				if(StringUtil.isNotEmpty(queryValue)){
						queryS=" and  (";
						String [] re=queryValue.split(",");
						for(int q=0;q<re.length;q++){
							queryS+="  " + fieldName+ " like '%"+ re[q] + "%'  ";
							if((re.length-q)!=1){
								queryS+=" or ";
							}
						}
						queryS+=" )";
				}
			}
			else if("l_like".equals(bussQuery.getQueryType())){
				if(StringUtil.isNotEmpty(queryValue)){
						queryS=" and  (";
						String [] re=queryValue.split(",");
						for(int q=0;q<re.length;q++){
							queryS+="  " + fieldName+ " like '%"+ re[q] + "'  ";
							if((re.length-q)!=1){
								queryS+=" or ";
							}
						}
						queryS+=" )";
				}
			}
			else if("r_like".equals(bussQuery.getQueryType())){
				if(StringUtil.isNotEmpty(queryValue)){
						queryS=" and  (";
						String [] re=queryValue.split(",");
						for(int q=0;q<re.length;q++){
							queryS+="  " + fieldName+ " like '"+ re[q] + "%'  ";
							if((re.length-q)!=1){
								queryS+=" or ";
							}
						}
						queryS+=" )";
				}
			}
			else if("equal".equals(bussQuery.getQueryType())){
				
				if(StringUtil.isNotEmpty(queryValue)){
					queryS=" and  (";
						
					if(queryValue.split(",").length>0){//处理多个值用，号分割的值
						String [] re=queryValue.split(",");
						for(int q=0;q<re.length;q++){
							
							if(e1!=null&&e1.size()>0){
								if("int".equals(e1.get(0).getType())){
									queryS+="  CONVERT("+fieldName+",SIGNED) ="+re[q]+" ";
								}
								else if("date".equals(e1.get(0).getType().toLowerCase())){
									if("date".equals(e1.get(0).getShowType())){
										queryS+="  STR_TO_DATE(" + fieldName+ ",'%Y-%m-%d')='"+re[q]+"' ";
									}
									if("datetime".equals(e1.get(0).getShowType())){
										queryS+="  STR_TO_DATE(" + fieldName+ ",'%Y-%m-%d %T')='"+re[q]+"' ";
									}
									if("yymm".equals(e1.get(0).getShowType())){
										queryS+="  STR_TO_DATE(" + fieldName+ ",'%Y-%m')='"+re[q]+"' ";
									}
									if("year".equals(e1.get(0).getShowType())){
										queryS+="  STR_TO_DATE(" + fieldName+ ",'%Y')='"+re[q]+"' ";
									}
									if("time".equals(e1.get(0).getShowType())){
										queryS+="  STR_TO_DATE(" + fieldName+ ",'%T')='"+re[q]+"' ";
									}
								}
								else {
									queryS+=fieldName+" ="+re[q]+" ";
								}
								if((re.length-q)!=1){
									queryS+=" or ";
								}
							}
						}
					}
					queryS+=" )";
				}
			}
		}
		
		return queryS;
	}
	
	public List<CgformBussListEntity> getFieldByBussList(String bussId,String[] flag) {
		CriteriaQuery cq = new CriteriaQuery(CgformBussListEntity.class);
		cq.eq("bussId", bussId);
		if(flag!=null&&flag.length>0){
			for(int i=0;i<flag.length;i++){
				if("isShowList".equals(flag[i])){
					cq.eq("isShowList", "Y");
				}
			}
		}
		cq.addOrder("sort", SortDirection.asc);
		cq.add();
		return systemService.getListByCriteriaQuery(cq, false);
	}
	
	
	@RequestMapping(params = "goView")
	public ModelAndView goView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//		if(!LicenseUtil.valid(authType, randomCode)){
//			return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		String id = oConvertUtils.getString(request.getParameter("id"), "");
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
		String url = "aceModeDemoController.do?modePage&type=page&bussCode="+bussCode+"&id=" + id ;
		request.setAttribute("url",url );
		request.setAttribute("id", id);
		request.setAttribute("bussCode", bussCode);
		return new ModelAndView(new RedirectView(url), null);
	}
	
	
//	/**
//	 * 提交业务数据
//	 * 
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(params = "submitBusiness")
//	public @ResponseBody boolean submitBusiness(HttpServletRequest request) {
//		String bussCode = request.getParameter("bussCode");
//		String mainId = request.getParameter("mainId");
//		String status = oConvertUtils.getString(request.getParameter("status"), "3");
//		if (StringUtil.isEmpty(bussCode) || StringUtil.isEmpty(mainId))
//			return false;
//		return tSListPageGenService.submitBusiness(bussCode, mainId, status);
//	}
//	
//	/**
//	 * 提交流程审批
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(params = "submitMainByBusiness")
//	@ResponseBody
//	public  boolean submitMainByBusiness(HttpServletRequest request) {
//		String bussCode = request.getParameter("bussCode");
//		String mainId = request.getParameter("mainId");
//		String status = oConvertUtils.getString(request.getParameter("status"), "3");
//		if (StringUtil.isEmpty(bussCode) || StringUtil.isEmpty(mainId))
//			return false;
//		return tSListPageGenService.submitMainByBusiness(bussCode, mainId, status);
//	}
	
	
	
	@RequestMapping(params = "goConfigformList")
	public ModelAndView goConfigformList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//		if(!LicenseUtil.valid(authType, randomCode)){
//			return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		String releaseCode=oConvertUtils.getString(request.getParameter("releaseCode"), "");
		String jumpPage=oConvertUtils.getString(request.getParameter("jumpPage"), "pagegen/configformList");
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", releaseCode);
		request.setAttribute("bussCode", releaseCode);
//		request.setAttribute("listStyle", tSConfigform.getListStyle());
		request.setAttribute("cgformBuss", cgformBuss);
		
		//初始化参数传递---------------------
		String initParameter="1=1";
		Map properties = request.getParameterMap();
		Iterator<Map.Entry<Integer, String>> it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			Object beforeV = entry.getValue();
			if (StringUtil.isNotEmpty(((String[])beforeV)[0])) {
				initParameter+="&"+entry.getKey()+"="+((String[])beforeV)[0];
				request.setAttribute("initParameter_"+entry.getKey(), ((String[])beforeV)[0]);
			}else{
				request.setAttribute("initParameter_"+entry.getKey(),"");
			}
		}
		request.setAttribute("initParameter", initParameter);
		//初始化参数传递---------------------
		return new ModelAndView(prefix+jumpPage+suffix);
	}

	
	@RequestMapping(params = "goConfigDetailformList")
	public ModelAndView goConfigDetailformList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		String mainId=oConvertUtils.getString(request.getParameter("mainId"), "");
		String bussCode=oConvertUtils.getString(request.getParameter("bussCode"), "");
		String selectBusCode=oConvertUtils.getString(request.getParameter("selectBusCode"), "");
		String versionnum=oConvertUtils.getString(request.getParameter("versionnum"), "-1");
//		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
//		CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
		//如果显示模板ID是空的则根据业务编码查询默认的基础版本 显示模板ID
//		List<Map<String, Object>> map = systemService.findForJdbc("select id from t_s_buss_template where configform_id=? and template_type='0' ",tSConfigform.getId());
//		if(map!=null&&map.size()>0){
//			//从流程中获取第一个填报单中的模板id和版本号，用来展示明细列表，明细列表应以第一个创建业务表单数据的模板为准
//			String insideProcessUrl =ResourceUtil.getConfigByName("insideProcessUrl");
//			String responseBody = RestTrackClient.getMethodByParams(insideProcessUrl+"CeX2ProcessRestController/getCreateTemplateByMainId?mainId="+mainId);
//			JSONObject json = JSONObject.fromObject(responseBody);
//			
//			List<Map<String, Object>> map1 = systemService.findForJdbc("SELECT  GROUP_CONCAT(link_buss_code) as link_buss_code from  cgform_lg_field where buss_code=? "
//					+ "  "+(!"".equals(json.getString("versionNum"))?" and VERSIONNUM="+json.getString("versionNum"):" and VERSIONNUM=-1 ")
//					+ " and show_type='v_formDetailed'  and is_show ='Y' "+(!"".equals(json.getString("templateId"))?" and BUSS_TEMPLATE_ID='"+json.getString("templateId")+"'":"")
//					+ "     " ,bussCode);// and deleteflag<>'"+ResourceUtil.DELETEFLAG+"'
//			String linkBussCodes=(map1!=null&&map1.size()>0&&StringUtil.isNotEmpty(map1.get(0).get("link_buss_code")))?map1.get(0).get("link_buss_code").toString():"";
//			
//			Map<String, Object> map12 = systemService.findOneForJdbc("SELECT  GROUP_CONCAT(link_buss_code) as link_buss_code from  cgform_tab where form_id in (select d.id from cgform_lg_field d where "
//					+ " d.is_show='Y' "
//							+ " and d.IS_FORM_HIDE <>'Y' "
//							 +(!"".equals(json.getString("versionNum"))?" and VERSIONNUM="+json.getString("versionNum"):" and VERSIONNUM=-1 ")
//							+ " and d.show_type ='v_formDetailedTab'  "
//							+ (!"".equals(json.getString("templateId"))?" and BUSS_TEMPLATE_ID='"+json.getString("templateId")+"'":"")
//							+ " and d.buss_code='"+bussCode+"' ) ");
//			if(!map12.isEmpty()){
//				linkBussCodes+=map12.get("link_buss_code");
//			}
//			
//			
//			if(linkBussCodes.split("\\,").length>0){
//				CriteriaQuery cq1 = new CriteriaQuery(CgformDefineEntity.class);
//				cq1.in("busCode", linkBussCodes.split("\\,"));
//				cq1.add();
//				List<CgformDefineEntity> tSConfigformList_=systemService.getListByCriteriaQuery(cq1, false);
//				request.setAttribute("tSConfigformList_", tSConfigformList_);
//				request.setAttribute("linkBussCode",StringUtil.isEmpty(selectBusCode)&&tSConfigformList_.size()>0?tSConfigformList_.get(0).getBusCode():selectBusCode);//默认显示第一个
//				request.setAttribute("selectBusCode", StringUtil.isEmpty(selectBusCode)&&tSConfigformList_.size()>0?tSConfigformList_.get(0).getBusCode():selectBusCode);//默认显示第一个页签
//			}
//		}
		request.setAttribute("bussCode", bussCode);
//		request.setAttribute("configformId", tSConfigform.getId());
//		request.setAttribute("listStyle", tSConfigform.getListStyle());
		request.setAttribute("versionnum", versionnum);
		request.setAttribute("mainId", mainId);
		return new ModelAndView(prefix+"pagegen/configDetailformList"+suffix);
	}
	
	
}
