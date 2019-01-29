package com.design.form.controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.AjaxJson;
import com.design.core.system.service.SystemService;
import com.design.entity.CgformSelectBackEntity;
import com.design.entity.CgformSelectFieldEntity;
import com.design.entity.Result;
import com.design.entity.Tree;
import com.design.form.service.CgformSelectBackServiceI;
import com.design.form.service.CgformSelectFieldServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;


/**   
 * @Title: Controller
 * @Description: cgform_select_back
 * @author onlineGenerator
 * @date 2018-06-05 14:25:37
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cgformSelectBackController")
public class CgformSelectBackController  {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CgformSelectBackController.class);
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	@Autowired
	private CgformSelectBackServiceI CgformSelectBackService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgformSelectFieldServiceI CgformSelectFieldService;



	/**
	 * 删除“cgform_select_back”表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CgformSelectBackEntity CgformSelectBack, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		CgformSelectBack = systemService.getEntity(CgformSelectBackEntity.class, CgformSelectBack.getId());
		String message = "cgform_select_back删除成功";
		try{
			CgformSelectBackService.delete(CgformSelectBack);
		}catch(Exception e){
			e.printStackTrace();
			message = "cgform_select_back删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除“cgform_select_back”表信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "删除成功";
		j.setSuccess(true);
		try{
			for(String id:ids.split(",")){
				CgformSelectBackEntity CgformSelectBack = systemService.getEntity(CgformSelectBackEntity.class,id);
				String sql="select * from cgform_lg_field where field_href='"+CgformSelectBack.getSelectCode()+"'";
				List<Map<String, Object>> w = systemService.findForJdbc(sql);
				if(w!=null&&w.size()>0){
					j.setMsg("已经使用的数据源不能删除");
					j.setSuccess(false);
					return j;
				}
				CgformSelectBackService.delete(CgformSelectBack);
				systemService.executeSql("delete  from cgform_select_field where main_id='"+id+"'");
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加“cgform_select_back”表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CgformSelectBackEntity CgformSelectBack, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		boolean result = true;
		try{
			
			/*String coderuleNO = systemService.getCoderuleNO("SZ", "SZ");
			CgformSelectBack.setSCode(coderuleNO);*/
			CgformSelectBack.setSelectCode("S"+System.currentTimeMillis());
			if(StringUtils.isNotBlank(CgformSelectBack.getJsonSql())){
				String jsonSql = CgformSelectBack.getJsonSql().toLowerCase();
				if(jsonSql.contains("update")
						||jsonSql.contains("delete")
						||jsonSql.contains("drop")
						||jsonSql.contains("insert")){
					j.setMsg("请输入正确的语句！");
					j.setSuccess(false);
					return j;
				}
			}
			CgformSelectBackService.save(CgformSelectBack);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			result = false;
		}
		j.setMsg(message);
		j.setSuccess(result);
		return j;
	}
	
	/**
	 * 更新“cgform_select_back”表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CgformSelectBackEntity CgformSelectBack, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		boolean result = true;
		if(StringUtils.isNotBlank(CgformSelectBack.getJsonSql())){
			String jsonSql = CgformSelectBack.getJsonSql();
			if(jsonSql.contains("update")
						||jsonSql.contains("delete")
						||jsonSql.contains("drop")
						||jsonSql.contains("insert")){
				j.setMsg("请输入正确的查询语句！");
				j.setSuccess(false);
				return j;
			}
		}
		CgformSelectBackEntity t = CgformSelectBackService.get(CgformSelectBackEntity.class, CgformSelectBack.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(CgformSelectBack, t);
			CgformSelectBackService.saveOrUpdate(t);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
			result = false;
		}
		j.setMsg(message);
		j.setSuccess(result);
		return j;
	}
	

	/**
	 * “cgform_select_back”新增页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CgformSelectBackEntity CgformSelectBack, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(CgformSelectBack.getId())) {
			CgformSelectBack = CgformSelectBackService.getEntity(CgformSelectBackEntity.class, CgformSelectBack.getId());
			req.setAttribute("bean", CgformSelectBack);
		}
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		req.setAttribute("oper","add");//wanhm 20140909 
		return new ModelAndView(prefix+"pagegen/cgform/selectBackAdd"+suffix);
	}
	/**
	 * “cgform_select_back”编辑页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CgformSelectBackEntity CgformSelectBack, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(CgformSelectBack.getId())) {
			CgformSelectBack = CgformSelectBackService.getEntity(CgformSelectBackEntity.class, CgformSelectBack.getId());
			req.setAttribute("bean", CgformSelectBack);
		}
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		req.setAttribute("oper","update");//
		return new ModelAndView(prefix+"pagegen/cgform/selectBackAdd"+suffix);
	}
	
	/**
	 * 获取数据提供给树形菜单
	 * @return
	 */
	@RequestMapping(params = "selectTree")
	@ResponseBody
	public List<Map<String, Object>> getSelectTree(HttpServletRequest request){
		CriteriaQuery cq = new CriteriaQuery(CgformSelectBackEntity.class);
		cq.eq("status", "1");
		String sNameStr = request.getParameter("request");
		if(StringUtils.isNotBlank(sNameStr)){
			cq.like("sName", sNameStr);
		}
		cq.add();
		List<CgformSelectBackEntity> list = CgformSelectBackService.getList(CgformSelectBackEntity.class);
		List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "ABC");
		map.put("name", "所有数据源");
		map.put("pId", "root");
		map.put("code", "root");
		json.add(map);
		if(list!=null && list.size()>0){
			for (CgformSelectBackEntity bean : list) {
				map = new HashMap<String, Object>();
				String name = bean.getSelectName()+"("+bean.getSelectCode()+")";
				map.put("id", bean.getId());
				map.put("name", name);
				map.put("pId", "ABC");
				json.add(map);
			}
		}
		return json;
	}
	
	
	/**
	 * 删除selectBack和selectFieldDetail关联表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDelSelect")
	@ResponseBody
	public AjaxJson doDelSelect(CgformSelectBackEntity CgformSelectBack, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "";
		CgformSelectBack = systemService.getEntity(CgformSelectBackEntity.class, CgformSelectBack.getId());
		try{
			CgformSelectFieldEntity tde = new CgformSelectFieldEntity();
			tde.setMainId(CgformSelectBack.getId());
			CriteriaQuery cq = new CriteriaQuery(CgformSelectFieldEntity.class);
			cq.eq("mainId", CgformSelectBack.getId());
			cq.add();
			List<CgformSelectFieldEntity> CgformSelectFieldlist = CgformSelectFieldService.getListByCriteriaQuery(cq, true);
			message = "删除成功";
			if(CgformSelectFieldlist != null && CgformSelectFieldlist.size() > 0){
				for (CgformSelectFieldEntity t : CgformSelectFieldlist) {
					CgformSelectFieldService.delete(t);
				}
			}
			CgformSelectBackService.delete(CgformSelectBack);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 根据CgformSelectBackEntity的id获取数据
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(params="getCgformSelectBackById")
	@ResponseBody
	public Result getCgformSelectBackById(String id, HttpServletRequest req) {
		
		Result result = new Result();
		
		if (StringUtil.isNotEmpty(id)) {
			try {
				CgformSelectBackEntity CgformSelectBack = CgformSelectBackService.getEntity(CgformSelectBackEntity.class, id);
				if(CgformSelectBack != null){
					result.setSuccess(1, "获取数据成功!", CgformSelectBack);
				}else{
					result.setFailure(0, "获取数据失败！");
				}
			} catch (Exception e) {
				result.setFailure(1, "获取数据异常！");;
				e.printStackTrace();
			}
			
			
		}
		
		return result;
	}
	
	
	
	

}
