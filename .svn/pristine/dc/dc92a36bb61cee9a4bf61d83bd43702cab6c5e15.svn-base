package com.design.form.controllers;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformReportIndexEntity;
import com.design.entity.CgformSelectBackEntity;
import com.design.form.service.CgformReportIndexServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ParameterUtil;
import com.design.utils.ResourceUtil;
import com.design.utils.oConvertUtils;
import com.zxlhdata.framework.auth.util.LicenseUtil;

/**
 * @Title: Controller
 * @author onlineGenerator
 * @date 2016-09-04 00:52:40
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/cgformReportIndexController")
public class CgformReportIndexController  {
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgformReportIndexServiceI cgformReportIndexService;
	
	/**
	 * 指标管理页面跳转
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goCgformReportIndex")
	public ModelAndView goCgformReportIndex(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		return new ModelAndView(prefix+"pagegen/cgform/cgformReportIndex"+suffix);
	}
	
	/**
	 * 获取指标列表
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getCgformReportIndex")
	public @ResponseBody Map<String, Object> getCgformReportIndex(HttpServletRequest request) {
		return cgformReportIndexService.getCgformReportIndex(request);
	}
	
	/**
	 * 获取指标树
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "tree")
	public @ResponseBody List<Map<String, Object>> tree(HttpServletRequest request) throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "ABC");
		map.put("name", "指标");
		map.put("pId", "root");
		map.put("code", "root");
		json.add(map);
		List<Map<String, Object>> list = cgformReportIndexService.getCgformReportIndexList(request);
		if(list!=null && list.size()>0){
			for (Map<String, Object> bean : list) {
				map = new HashMap<String, Object>();
				String name = bean.get("field_name")+"  "+bean.get("content");
				map.put("id", bean.get("id"));
				map.put("name", name);
				map.put("pId", StringUtils.isNotBlank((String)bean.get("group_id"))?bean.get("group_id"):"ABC");
				json.add(map);
			}
		}
		return json;
	}
	
	/**
	 * 指标新增页面跳转
	 * @param cgformReportIndex
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CgformReportIndexEntity cgformReportIndex, HttpServletRequest req) throws Exception {
		String groupId = req.getParameter("groupId");
		String bussCode = req.getParameter("bussCode");
		if(StringUtils.isNotBlank(groupId)){
			CgformReportIndexEntity parentCgformReport = systemService.getEntity(CgformReportIndexEntity.class, groupId);
			req.setAttribute("parentCgformReport", parentCgformReport);
		}
		
		List<Map<String, Object>> selectList = systemService.findForJdbc("select t.* from cgform_select_back t ");
		JSONArray rows = new JSONArray();
		JSONObject node = new JSONObject();
			if(selectList!=null && selectList.size()>0){
				for(Map<String, Object> selec : selectList){
					node = new JSONObject();
						node.put("id", oConvertUtils.getString(selec.get("s_code"), ""));
						node.put("name", oConvertUtils.getString(selec.get("s_name"), ""));
						node.put("va", oConvertUtils.getString(selec.get("s_code"), ""));
						List<Map<String, Object>> fieldList = systemService.findForJdbc("select t.* from cgform_select_field t where main_id='"+oConvertUtils.getString(selec.get("id"), "")+"' ");
						String fields="";
						if(fieldList!=null&&fieldList.size()>0){
							for(Map<String, Object> f:fieldList){
								 fields+=f.get("field_code")+"#"+f.get("field_name")+"@";
							}
							fields=fields.substring(0, fields.length()-1);
						}
						node.put("sub", fields);
						rows.add(node);
				}
			}
		cgformReportIndex.setInputId("隐藏的值,显示的值");
		req.setAttribute("list", rows);
		req.setAttribute("bean", cgformReportIndex);
		req.setAttribute("bussCode", bussCode);
		req.setAttribute("oper", "add");
		return new ModelAndView(prefix+"pagegen/cgform/cgformReportIndexAdd"+suffix);
	}
	
	/**
	 * 指标新增
	 * @param cgformReportIndex
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doAdd")
	public @ResponseBody Map<String, Object> doAdd(CgformReportIndexEntity cgformReportIndex, HttpServletRequest request) throws Exception {
		Map<String, Object> j = new HashMap<>();
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String message = "指标添加成功";
		boolean success = true;
		CriteriaQuery cq = new CriteriaQuery(CgformReportIndexEntity.class);
		cq.eq("fieldName", cgformReportIndex.getFieldName());
		cq.add();
		List<CgformReportIndexEntity> list = systemService.getListByCriteriaQuery(cq, false);
		if(list!=null&&list.size()>0){
			j.put("msg", "该指标已存在！");
			j.put("success", false);
			return j;
		}
		try{
			systemService.save(cgformReportIndex);
		}catch(Exception e){
			e.printStackTrace();
			message = "指标添加失败";
			success = false;
		}
		j.put("msg", message);
		j.put("success", success);
		return j;
	}
	
	/**
	 * 编辑页面跳转
	 * @param cgformReportIndex
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CgformReportIndexEntity cgformReportIndex, HttpServletRequest req) throws Exception {
		String groupId = req.getParameter("groupId");
		String bussCode = req.getParameter("bussCode");
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		if(StringUtils.isNotBlank(groupId)){
			CgformReportIndexEntity parentCgformReport = systemService.getEntity(CgformReportIndexEntity.class, groupId);
			req.setAttribute("parentCgformReport", parentCgformReport);
		}
		if(StringUtils.isNotBlank(cgformReportIndex.getId())){
			cgformReportIndex = systemService.getEntity(CgformReportIndexEntity.class, cgformReportIndex.getId());
		}
		List<Map<String, Object>> selectList = systemService.findForJdbc("select t.* from cgform_select_back t ");
		JSONArray rows = new JSONArray();
		JSONObject node = new JSONObject();
			if(selectList!=null && selectList.size()>0){
				for(Map<String, Object> selec : selectList){
					node = new JSONObject();
						node.put("id", oConvertUtils.getString(selec.get("s_code"), ""));
						node.put("name", oConvertUtils.getString(selec.get("s_name"), ""));
						node.put("va", oConvertUtils.getString(selec.get("s_code"), ""));
						List<Map<String, Object>> fieldList = systemService.findForJdbc("select t.* from cgform_select_field t where main_id='"+oConvertUtils.getString(selec.get("id"), "")+"' ");
						String fields="";
						if(fieldList!=null&&fieldList.size()>0){
							for(Map<String, Object> f:fieldList){
								 fields+=f.get("field_code")+"#"+f.get("field_name")+"@";
							}
							fields=fields.substring(0, fields.length()-1);
						}
						node.put("sub", fields);
						rows.add(node);
				}
			}
			req.setAttribute("list", rows);
			if(StringUtils.isEmpty(cgformReportIndex.getInputId())){
				cgformReportIndex.setInputId("隐藏的值,显示的值");
			}
		req.setAttribute("bean", cgformReportIndex);
		req.setAttribute("bussCode", bussCode);
		req.setAttribute("oper", "update");
		
		CriteriaQuery cq1 = new CriteriaQuery(CgFormLgFieldEntity.class);
		cq1.eq("indexExtId", cgformReportIndex.getId());
		cq1.add();
		List<CgFormLgFieldEntity> cgFormLgFieldList = systemService.getListByCriteriaQuery(cq1, false);
		req.setAttribute("isUse", (cgFormLgFieldList!=null&&cgFormLgFieldList.size()>0)?true:false);
		return new ModelAndView(prefix+"pagegen/cgform/cgformReportIndexAdd"+suffix);
	}
	
	/**
	 * 更新
	 * @param cgformReportIndex
	 * @param depotId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "doUpdate")
	public @ResponseBody Map<String, Object> doUpdate(CgformReportIndexEntity cgformReportIndex, String depotId, HttpServletRequest request) throws Exception {
		Map<String, Object> j = new HashMap<>();
		String message = "更新成功";
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		boolean success = true;
		CgformReportIndexEntity t = systemService.get(CgformReportIndexEntity.class, cgformReportIndex.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(cgformReportIndex, t);
			systemService.saveOrUpdate(t);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
			success = false;
		}
		j.put("msg", message);
		j.put("success", success);
		return j;
	}
	
	/**
	 * 删除
	 * @param ids
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doBatchDel")
	public @ResponseBody Map<String, Object> doBatchDel(String ids,HttpServletRequest request) throws Exception{
		Map<String, Object> j = new HashMap<>();
		//LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String message = "删除成功";
		boolean success = true;
		try{
			List<CgformReportIndexEntity> list = new ArrayList<CgformReportIndexEntity>();
			for (String id : ids.split(",")) {
				
				CgformReportIndexEntity cgformReportIndex = systemService.getEntity(CgformReportIndexEntity.class, id);
//				CriteriaQuery cq1 = new CriteriaQuery(CgFormLgFieldEntity.class);
//				cq1.eq("indexExtId", cgformReportIndex.getId());
//				cq1.add();
//				List<CgFormLgFieldEntity> cgFormLgFieldList = systemService.getListByCriteriaQuery(cq1, false);
//				if(cgFormLgFieldList!=null&&cgFormLgFieldList.size()>0){
//					j.put("msg", "该指标已经在使用，不能删除！");
//					j.put("success", false);
//					return j;
//				}
				
				CriteriaQuery cq = new CriteriaQuery(CgformReportIndexEntity.class);
				cq.eq("groupId", cgformReportIndex.getId());
				cq.add();
				List<CgformReportIndexEntity> nextList = systemService.getListByCriteriaQuery(cq, false);
				if(nextList!=null&&nextList.size()>0){
					for (CgformReportIndexEntity cgformReportIndexEntity : nextList) {
						list.add(cgformReportIndexEntity);
					}
				}
				list.add(cgformReportIndex);
			}
			systemService.deleteAllEntitie(list);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
			success = false;
		}
		j.put("msg", message);
		j.put("success", success);
		return j;
	}
}
