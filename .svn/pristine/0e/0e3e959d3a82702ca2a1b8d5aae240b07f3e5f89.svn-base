package com.design.form.controllers;
import java.util.Date;
import java.util.HashMap;
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
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformBussQueryEntity;
import com.design.form.service.CgformBussQueryServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;


/**   
 * @Title: Controller
 * @Description: cgform_buss_query
 * @author onlineGenerator
 * @date 2018-06-28 17:36:13
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cgformBussQueryController")
public class CgformBussQueryController{
	/**
	 * Logger for this class
	 */
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	private static final Logger logger = Logger.getLogger(CgformBussQueryController.class);

	@Autowired
	private CgformBussQueryServiceI cgformBussQueryService;
	@Autowired
	private SystemService systemService;


	/**
	 * 删除“cgform_buss_query”表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CgformBussQueryEntity cgformBussQuery, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		cgformBussQuery = systemService.getEntity(CgformBussQueryEntity.class, cgformBussQuery.getId());
		String message = "删除成功";
		try{
			cgformBussQueryService.delete(cgformBussQuery);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除“cgform_buss_query”表信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "cgform_buss_query删除成功";
		try{
			for(String id:ids.split(",")){
				CgformBussQueryEntity cgformBussQuery = systemService.getEntity(CgformBussQueryEntity.class, 
				id
				);
				cgformBussQueryService.delete(cgformBussQuery);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "cgform_buss_query删除失败";
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加“cgform_buss_query”表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CgformBussQueryEntity cgformBussQuery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "cgform_buss_query添加成功";
		try{
			CriteriaQuery cq = new CriteriaQuery(CgformBussListEntity.class);
			cq.eq("bussId", cgformBussQuery.getBussId());
			cq.add();
			List<CgformBussListEntity> list = systemService.getListByCriteriaQuery(cq, false);
			for (CgformBussListEntity cgformBussListEntity : list) {
				if(!cgformBussListEntity.getBussId().equals(cgformBussQuery.getBussId())){
					systemService.delete(cgformBussListEntity);
				}
			}
			cgformBussQuery.setCreateBy((String)request.getSession().getAttribute("create_by"));
			cgformBussQuery.setCreateName((String)request.getSession().getAttribute("create_name"));
			cgformBussQuery.setCreateDate(new Date());
			cgformBussQuery.setSort(list.size()+1);
			cgformBussQueryService.save(cgformBussQuery);
		}catch(Exception e){
			e.printStackTrace();
			message = "cgform_buss_query添加失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新“cgform_buss_query”表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CgformBussQueryEntity cgformBussQuery, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "cgform_buss_query更新成功";
		CgformBussQueryEntity t = systemService.get(CgformBussQueryEntity.class, cgformBussQuery.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(cgformBussQuery, t);
			cgformBussQueryService.saveOrUpdate(t);
		} catch (Exception e) {
			e.printStackTrace();
			message = "cgform_buss_query更新失败";
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 字段配置
	 * @param cgformBuss
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getLgFieldConfig")
	public ModelAndView getLgFieldConfig(CgformBussQueryEntity cgformBussQuery, HttpServletRequest req) throws Exception {
		CgFormLgFieldEntity cgFormLgFieldEntity = new CgFormLgFieldEntity();
		if (StringUtil.isNotEmpty(cgformBussQuery.getId())) {
			cgformBussQuery = systemService.getEntity(CgformBussQueryEntity.class, cgformBussQuery.getId());
			cgFormLgFieldEntity = systemService.getEntity(CgFormLgFieldEntity.class, cgformBussQuery.getDefineId());
		}else{
			cgFormLgFieldEntity = systemService.getEntity(CgFormLgFieldEntity.class, cgformBussQuery.getDefineId());
		}
		req.setAttribute("bean", cgformBussQuery);
		req.setAttribute("cgFormLgFieldEntity", cgFormLgFieldEntity);
		return new ModelAndView(prefix+"pagegen/buss/cgformBussQueryAdd"+suffix);
	}
	
}
