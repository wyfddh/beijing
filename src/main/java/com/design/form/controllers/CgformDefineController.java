package com.design.form.controllers;
import java.util.Date;
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
import com.design.core.config.util.DbTableProcess;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformDefineEntity;
import com.design.form.service.CgformDefineServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;


/**   
 * @Title: Controller
 * @Description: cgform_buss
 * @author onlineGenerator
 * @date 2018-06-28 17:35:18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cgformDefineController")
public class CgformDefineController{
	/**
	 * Logger for this class
	 */
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	private static final Logger logger = Logger.getLogger(CgformDefineController.class);

	@Autowired
	private CgformDefineServiceI cgformDefineService;
	@Autowired
	private SystemService systemService;

	/**
	 * 表单信息列表 页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "cgformDefine")
	public ModelAndView cgformDefine(HttpServletRequest request) throws Exception {
		String type = request.getParameter("type");
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		request.setAttribute("type", type);
		return new ModelAndView(prefix+"pagegen/buss/cgformDefineList"+suffix);
	}
	
	/**
	 * 获取表单列表
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getCgformDefine")
	public @ResponseBody Map<String, Object> getcgformDefine(HttpServletRequest request) {
		return cgformDefineService.getCgformDefine(request);
	}
	
	/**
	 * 删除表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CgformDefineEntity cgformDefine, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		cgformDefine = systemService.getEntity(CgformDefineEntity.class, cgformDefine.getId());
		String message = "cgform_buss删除成功";
		try{
			cgformDefineService.delete(cgformDefine);
		}catch(Exception e){
			e.printStackTrace();
			message = "cgform_buss删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除表信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "删除成功";
		boolean result = true;
		try{
			for(String id:ids.split(",")){
				CgformDefineEntity cgformDefine = systemService.getEntity(CgformDefineEntity.class,id);
				if("B201800050".equals(cgformDefine.getDefineCode())
						||"B201800051".equals(cgformDefine.getDefineCode())
						||"B201800052".equals(cgformDefine.getDefineCode())){
					j.setMsg(cgformDefine.getDefineName()+"--系统表单不允许删除！");
					return j;
				}
				
//				CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "defineId", cgformDefine.getId());
//				if(cgformBuss!=null){
//					j.setMsg("已经发布的表单不允许删除！");
//					j.setSuccess(false);
//					return j;
//				}
				if(cgformDefine!=null&&cgformDefine.getSaveType().equals("1")){
					DbTableProcess dbTableProcess = new DbTableProcess(systemService.getSession());
					result = dbTableProcess.dropTableByPara(cgformDefine, systemService.getSession());
				}
				if(result){
					cgformDefineService.delete(cgformDefine);
					CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
					cq.eq("defineId", id);
					cq.add();
					List<CgFormLgFieldEntity> list = systemService.getListByCriteriaQuery(cq, false);
					for (CgFormLgFieldEntity cgFormLgFieldEntity : list) {
						systemService.delete(cgFormLgFieldEntity);
					}
				}else {
					message = "删除失败";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
			result = false;
		}
		j.setMsg(message);
		j.setSuccess(result);
		return j;
	}
	

	/**
	 * 添加表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CgformDefineEntity cgformDefine, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		boolean success = true;
		try{
			cgformDefine.setDefineCode("BD"+System.currentTimeMillis());
			cgformDefine.setCreateBy((String)request.getSession().getAttribute("create_by"));
			cgformDefine.setCreateName((String)request.getSession().getAttribute("create_name"));
			cgformDefine.setStatus("0");
			cgformDefine.setVersionnum(0);
			cgformDefine.setCreateDate(new Date());
			cgformDefineService.save(cgformDefine);
			message = cgformDefine.getDefineCode();
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			success = false;
		}
		j.setSuccess(success);
		j.setMsg(message);
		//j.setObj(cgformDefine);
		return j;
	}
	
	/**
	 * 更新表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CgformDefineEntity cgformDefine, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		boolean success = true;
		CgformDefineEntity t = systemService.get(CgformDefineEntity.class, cgformDefine.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(cgformDefine, t);
			cgformDefineService.saveOrUpdate(t);
			message = t.getDefineCode();
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
			success = false;
		}
		j.setSuccess(success);
		j.setMsg(message);
		//j.setObj(t);
		return j;
	}
	
	@RequestMapping(params = "getDefine")
	@ResponseBody
	public AjaxJson getDefine(CgformDefineEntity cgformDefine, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "更新成功",Obj="";
		try {
			CgformBussEntity cgformBussEntity = systemService.get(CgformBussEntity.class, cgformDefine.getBussId());
			CgformDefineEntity t = systemService.get(CgformDefineEntity.class, cgformBussEntity.getDefineId());
			Obj = t.getDefineCode()+","+t.getBussType()+","+t.getId();
			
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		j.setObj(Obj);
		j.setMsg(message);
		//j.setObj(t);
		return j;
	}
	
	 /**
	  * 发布或取消发布
	  * @param id
	  * @param status
	  * @param request
	  * @return
	  */
	@RequestMapping(params = "doRelease")
	@ResponseBody
	public AjaxJson doRelease(String id,String status,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "发布成功";
		boolean success = true;
		try{
			CgformDefineEntity cgformDefineEntity = systemService.getEntity(CgformDefineEntity.class,id);
			if(cgformDefineEntity!=null){
				if(StringUtils.isNotBlank(status)&&status.equals("1")&&cgformDefineEntity.getSaveType().equals("1")){
					String tableName = "";
					/*StringBuffer sql = new StringBuffer();
					sql.append("SELECT clf.field_name as fieldName,clf.length as length,clf.content as remark,clf.type as type,clf.point_length as pointLength FROM cgform_lg_field clf where clf.define_id='"+cgformDefineEntity.getId()+"' and clf.show_type not like 'v_form%' ");
					List<Map<String, Object>> tableClumJson =  systemService.findForJdbc(sql.toString());*/
					/*Map<String, Object> tableClum = new HashMap<>();
					tableClum.put("feildName", "user_name");
					tableClum.put("length", "100");
					tableClum.put("remark", "用户名");
					tableClum.put("type", "string");
					tableClumJson.add(tableClum);*/
					if(!cgformDefineEntity.getColumns().isEmpty()&&cgformDefineEntity.getColumns().size()>0){
						//cgformDefineEntity.setColumns(list);
						int versionnum = cgformDefineEntity.getVersionnum();
//						DbTableProcess dbTableProcess = new DbTableProcess(systemService.getSession());
						if(StringUtils.isNotBlank(cgformDefineEntity.getMtableName())){
//							success = dbTableProcess.updateTableByPara(cgformDefineEntity, systemService.getSession());
							cgformDefineEntity.setVersionnum(versionnum+1);
						}else{
							tableName = "cgform_b_"+System.currentTimeMillis();
							//success = DbTableCreateUtil.createTableByPara(tableName,tableClumJson,systemService.getSession());
//							cgformDefineEntity.setMtableName(tableName);
//							success = dbTableProcess.createOrDropTable(cgformDefineEntity, systemService.getSession());
						}
					}
				}
				if(success){
//					CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "defineId", cgformDefineEntity.getId());
//					if(cgformBuss!=null){
//						j.setMsg("已经发布的表单不允许取消发布！");
//						j.setSuccess(false);
//						return j;
//					}
					cgformDefineEntity.setStatus(status);
					systemService.saveOrUpdate(cgformDefineEntity);
				}else{
					message = "发布失败";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "发布失败";
			success=false;
		}
		j.setMsg(message);
		j.setSuccess(success);
		return j;
	}

	/**
	 * 新增页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CgformDefineEntity cgformDefine, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(cgformDefine.getId())) {
			cgformDefine = systemService.getEntity(CgformDefineEntity.class, cgformDefine.getId());
			req.setAttribute("bean", cgformDefine);
		}
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		String bussType = req.getParameter("type");
		req.setAttribute("oper","add");
		req.setAttribute("bussType",bussType);
		return new ModelAndView(prefix+"pagegen/buss/cgformDefineAdd"+suffix);
	}
	/**
	 * 编辑页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CgformDefineEntity cgformDefine, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(cgformDefine.getId())) {
			cgformDefine = systemService.getEntity(CgformDefineEntity.class, cgformDefine.getId());
			req.setAttribute("bean", cgformDefine);
		}
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		String bussType = req.getParameter("type");
		req.setAttribute("bussType",bussType);
		req.setAttribute("oper","update");//
		return new ModelAndView(prefix+"pagegen/buss/cgformDefineAdd"+suffix);
	}


}
