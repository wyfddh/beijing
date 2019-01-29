package com.design.form.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.AjaxJson;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformSelectBackEntity;
import com.design.entity.CgformSelectFieldEntity;
import com.design.entity.Result;
import com.design.form.service.CgformSelectFieldServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;


/**   
 * @Title: Controller
 * @Description: cgform_select_field
 * @author onlineGenerator
 * @date 2018-06-05 11:34:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cgformSelectFieldController")
public class CgformSelectFieldController  {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CgformSelectFieldController.class);
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	@Autowired
	private CgformSelectFieldServiceI CgformSelectFieldService;
	@Autowired
	private SystemService systemService;



	/**
	 * 删除“cgform_select_field”表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CgformSelectFieldEntity CgformSelectField, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		CgformSelectField = systemService.getEntity(CgformSelectFieldEntity.class, CgformSelectField.getId());
		String message = "删除成功";
		try{
			CgformSelectFieldService.delete(CgformSelectField);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除“cgform_select_field”表信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "删除成功";
		try{
			for(String id:ids.split(",")){
				CgformSelectFieldEntity cgformSelectField = systemService.getEntity(CgformSelectFieldEntity.class,id);
				CgformSelectBackEntity cgformSelectBack = systemService.getEntity(CgformSelectBackEntity.class,cgformSelectField.getMainId());
				
				CriteriaQuery cq1 = new CriteriaQuery(CgFormLgFieldEntity.class);
				cq1.eq("fieldHref", cgformSelectBack.getSelectCode());
				cq1.like("selectId", "%"+cgformSelectField.getFieldName()+"%");
				cq1.add();
				List<CgFormLgFieldEntity> cgFormLgFieldList = systemService.getListByCriteriaQuery(cq1, false);
				if(cgFormLgFieldList!=null&&cgFormLgFieldList.size()>0){
					j.setMsg("该来源字段正在使用，不能删除");
					j.setSuccess(false);
					return j;
				}
				CgformSelectFieldService.delete(cgformSelectField);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加“cgform_select_field”表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CgformSelectFieldEntity CgformSelectField, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			CgformSelectField.setFieldCode(CgformSelectField.getFieldCode().toLowerCase());
			CgformSelectFieldService.save(CgformSelectField);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新“cgform_select_field”表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CgformSelectFieldEntity CgformSelectField, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		CgformSelectField.setFieldCode(CgformSelectField.getFieldCode().toLowerCase());
		CgformSelectFieldEntity t = CgformSelectFieldService.get(CgformSelectFieldEntity.class, CgformSelectField.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(CgformSelectField, t);
			CgformSelectFieldService.saveOrUpdate(t);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * “cgform_select_field”新增页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CgformSelectFieldEntity CgformSelectField, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(CgformSelectField.getId())) {
			CgformSelectField = CgformSelectFieldService.getEntity(CgformSelectFieldEntity.class, CgformSelectField.getId());
		}
		CgformSelectBackEntity cgformSelectBack = systemService.getEntity(CgformSelectBackEntity.class, CgformSelectField.getMainId());
		req.setAttribute("cgformSelectBack", cgformSelectBack);
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		req.setAttribute("bean", CgformSelectField);
		req.setAttribute("oper","add");//wanhm 20140909 
		return new ModelAndView(prefix+"pagegen/cgform/selectFieldAdd"+suffix);
	}
	/**
	 * “cgform_select_field”编辑页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CgformSelectFieldEntity CgformSelectField, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(CgformSelectField.getId())) {
			CgformSelectField = CgformSelectFieldService.getEntity(CgformSelectFieldEntity.class, CgformSelectField.getId());
		}
		req.setAttribute("bean", CgformSelectField);
		CgformSelectBackEntity cgformSelectBack = systemService.getEntity(CgformSelectBackEntity.class, CgformSelectField.getMainId());
		req.setAttribute("cgformSelectBack", cgformSelectBack);
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		req.setAttribute("oper","update");//
		CriteriaQuery cq1 = new CriteriaQuery(CgFormLgFieldEntity.class);
		cq1.eq("fieldHref", cgformSelectBack.getSelectCode());
//		cq1.like("selectId", "%"+CgformSelectField.getFieldName()+"%");
		cq1.add();
		List<CgFormLgFieldEntity> cgFormLgFieldList = systemService.getListByCriteriaQuery(cq1, false);
		req.setAttribute("isUse",cgFormLgFieldList!=null&&cgFormLgFieldList.size()>0?true:false);//
		return new ModelAndView(prefix+"pagegen/cgform/selectFieldAdd"+suffix);
	}

	
	/**
	 * 根据CgformSelectFieldEntity的id获取数据
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(params="getCgformSelectFieldById")
	@ResponseBody
	public Result getCgformSelectFieldById(String id, HttpServletRequest req) {
		
		Result result = new Result();
		
		if (StringUtil.isNotEmpty(id)) {
			try {
				CgformSelectFieldEntity CgformSelectField = CgformSelectFieldService.getEntity(CgformSelectFieldEntity.class, id);
				if(CgformSelectField != null){
					result.setSuccess(1, "获取数据成功!", CgformSelectField);
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
