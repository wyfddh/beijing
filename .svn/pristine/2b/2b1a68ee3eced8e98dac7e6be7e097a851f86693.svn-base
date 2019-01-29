package com.design.form.controllers;
import java.util.Date;
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
import com.design.form.service.CgformBussListServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;


/**   
 * @Title: Controller
 * @Description: cgform_buss_list
 * @author onlineGenerator
 * @date 2018-06-28 17:35:47
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cgformBussListController")
public class CgformBussListController{
	/**
	 * Logger for this class
	 */
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	private static final Logger logger = Logger.getLogger(CgformBussListController.class);

	@Autowired
	private CgformBussListServiceI cgformBussListService;
	@Autowired
	private SystemService systemService;




	/**
	 * 删除“cgform_buss_list”表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CgformBussListEntity cgformBussList, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		cgformBussList = systemService.getEntity(CgformBussListEntity.class, cgformBussList.getId());
		String message = "删除成功";
		try{
			cgformBussListService.delete(cgformBussList);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除“cgform_buss_list”表信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "cgform_buss_list删除成功";
		try{
			for(String id:ids.split(",")){
				CgformBussListEntity cgformBussList = systemService.getEntity(CgformBussListEntity.class, 
				id
				);
				cgformBussListService.delete(cgformBussList);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "cgform_buss_list删除失败";
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加“cgform_buss_list”表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CgformBussListEntity cgformBussList, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			CriteriaQuery cq = new CriteriaQuery(CgformBussListEntity.class);
			cq.eq("bussId", cgformBussList.getBussId());
			cq.add();
			List<CgformBussListEntity> list = systemService.getListByCriteriaQuery(cq, false);
			for (CgformBussListEntity cgformBussListEntity : list) {
				if(!cgformBussListEntity.getBussId().equals(cgformBussList.getBussId())){
					systemService.delete(cgformBussListEntity);
				}
			}
			cgformBussList.setIsShowList("Y");
			cgformBussList.setCreateBy(oConvertUtils.getString(request.getSession().getAttribute("create_by"),"admin"));
			cgformBussList.setCreateName(oConvertUtils.getString(request.getSession().getAttribute("create_name"),"admin"));
			cgformBussList.setCreateDate(new Date());
			cgformBussList.setSort(list.size()+1);
			cgformBussListService.save(cgformBussList);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新“cgform_buss_list”表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CgformBussListEntity cgformBussList, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "cgform_buss_list更新成功";
		CgformBussListEntity t = systemService.get(CgformBussListEntity.class, cgformBussList.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(cgformBussList, t);
			cgformBussListService.saveOrUpdate(t);
		} catch (Exception e) {
			e.printStackTrace();
			message = "cgform_buss_list更新失败";
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
	public ModelAndView getLgFieldConfig(CgformBussListEntity cgformBussList, HttpServletRequest req) throws Exception {
		CgFormLgFieldEntity cgFormLgFieldEntity = new CgFormLgFieldEntity();
		if (StringUtil.isNotEmpty(cgformBussList.getId())) {
			cgformBussList = systemService.getEntity(CgformBussListEntity.class, cgformBussList.getId());
			cgFormLgFieldEntity = systemService.getEntity(CgFormLgFieldEntity.class, cgformBussList.getDefineId());
		}else{
			cgFormLgFieldEntity = systemService.getEntity(CgFormLgFieldEntity.class, cgformBussList.getDefineId());
		}
		req.setAttribute("bean", cgformBussList);
		req.setAttribute("cgFormLgFieldEntity", cgFormLgFieldEntity);
		return new ModelAndView(prefix+"pagegen/buss/cgformBussListAdd"+suffix);
	}
}
