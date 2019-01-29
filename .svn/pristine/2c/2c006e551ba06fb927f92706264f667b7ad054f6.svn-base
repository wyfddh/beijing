package com.design.form.controllers;
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
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformBussQueryEntity;
import com.design.entity.CgformDefineEntity;
import com.design.entity.CgformFieldTempEntity;
import com.design.form.service.CgformBussServiceI;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;


/**   
 * @Title: Controller
 * @Description: cgform_buss
 * @author onlineGenerator
 * @date 2018-06-28 17:35:18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cgformBussController")
public class CgformBussController{
	/**
	 * Logger for this class
	 */
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	private static final Logger logger = Logger.getLogger(CgformBussController.class);

	@Autowired
	private CgformBussServiceI cgformBussService;
	@Autowired
	private SystemService systemService;


	/**
	 * 业务类型信息列表 页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "cgformBuss")
	public ModelAndView cgformBuss(HttpServletRequest request) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//		}
		return new ModelAndView(prefix+"pagegen/buss/cgformBussList"+suffix);
	}
	
	/**
	 * 获取业务类型列表
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getCgformBuss")
	public @ResponseBody Map<String, Object> getCgformBuss(HttpServletRequest request) {
		return cgformBussService.getCgformBuss(request);
	}
	
	/**
	 * 删除“cgform_buss”表信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CgformBussEntity cgformBuss, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		cgformBuss = systemService.getEntity(CgformBussEntity.class, cgformBuss.getId());
		String message = "cgform_buss删除成功";
		try{
			cgformBussService.delete(cgformBuss);
		}catch(Exception e){
			e.printStackTrace();
			message = "cgform_buss删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除“cgform_buss”表信息
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
				CgformBussEntity cgformBuss = systemService.getEntity(CgformBussEntity.class, id);
				if("1".equals(cgformBuss.getStatus())){
					j.setMsg("当前业务已经发布，不能删除，请重新选择！");
					j.setSuccess(false);
					return j;
				}
				
				if("B1530842987354".equals(cgformBuss.getBussCode())
						||"B1530720176225".equals(cgformBuss.getBussCode())
						||"B1530720132097".equals(cgformBuss.getBussCode())
						||"B1530716962445".equals(cgformBuss.getBussCode())){
					j.setMsg(cgformBuss.getBussName()+"--系统表单不允许删除！");
					j.setSuccess(false);
					return j;
				}
				CriteriaQuery cq = new CriteriaQuery(CgformBussListEntity.class);
				cq.eq("bussId", id);
				cq.add();
				List<CgformBussListEntity> list = systemService.getListByCriteriaQuery(cq, false);
				for (CgformBussListEntity cgformBussListEntity : list) {
					systemService.delete(cgformBussListEntity);
				}
				CriteriaQuery cq1 = new CriteriaQuery(CgformBussQueryEntity.class);
				cq1.eq("bussId", id);
				cq1.add();
				List<CgformBussQueryEntity> queryList = systemService.getListByCriteriaQuery(cq1, false);
				for (CgformBussQueryEntity cgformBussQueryEntity : queryList) {
					systemService.delete(cgformBussQueryEntity);
				}
				cgformBussService.delete(cgformBuss);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
		}
		j.setMsg(message);
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
			CgformBussEntity cgformBuss = systemService.getEntity(CgformBussEntity.class,id);
			CgformDefineEntity tsConfigformEntity = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
			
			//先判断业务数据表中是否存在业务数据，如果存在则不允许操作
//			String sql1="select * from cgform_rdata_master where buss_id ='"+id+"'";
//			if(tsConfigformEntity!=null&&"1".equals(tsConfigformEntity.getSaveType())){
//				sql1="select * from "+tsConfigformEntity.getMtableName()+" ";
//			}
//			List<Map<String, Object>> list = systemService.findForJdbc(sql1);
//			if(!list.isEmpty()&&list.size()>0){
//				j.setMsg("当前业务已存在数据，不允许"+("1".equals(status)?"发布":"取消发布")+"！");
//				j.setSuccess(false);
//				return j;
//			}
			
			
			if(cgformBuss!=null){
				//发布
				if(StringUtils.isNotBlank(status)&&status.equals("1")){
					//2键值保存
					if(tsConfigformEntity!=null&&"2".equals(tsConfigformEntity.getSaveType())){
						//查询是否已有关联关系
						CriteriaQuery cq1 = new CriteriaQuery(CgformFieldTempEntity.class);
						cq1.eq("bussId",id);
						cq1.add();
						List<CgformFieldTempEntity> queryList = systemService.getListByCriteriaQuery(cq1, false);
						for (CgformFieldTempEntity cgformFieldTempEntity : queryList) {
							systemService.delete(cgformFieldTempEntity);
						}
						
						StringBuffer sql = new StringBuffer();
						sql.append("SELECT * FROM (SELECT");
						sql.append(" cbq.id AS id,");
						sql.append(" cbq.field_name AS fieldName,");
						sql.append(" cbq.buss_id AS bussId,");
						sql.append(" cbq.define_id AS defineId");
						sql.append(" FROM");
						sql.append(" `cgform_buss_query` cbq");
						sql.append(" WHERE");
						sql.append(" cbq.buss_id = '"+cgformBuss.getId()+"'");
						sql.append(" UNION ALL");
						sql.append(" SELECT");
						sql.append(" cbl.id AS id,");
						sql.append(" cbl.field_name AS fieldName,");
						sql.append(" cbl.buss_id AS bussId,");
						sql.append(" cbl.define_id AS defineId");
						sql.append(" FROM");
						sql.append(" cgform_buss_list cbl");
						sql.append(" WHERE");
						sql.append(" cbl.buss_id = '"+cgformBuss.getId()+"') abc");
						sql.append(" GROUP BY abc.fieldName");
						List<Map<String, Object>> lgFieldList =  systemService.findForJdbc(sql.toString());
						int tempNum = 1;
						for (Map<String, Object> map : lgFieldList) {
							CgformFieldTempEntity cgformFieldTempEntity = new CgformFieldTempEntity();
							cgformFieldTempEntity.setDefineId((String)map.get("defineId"));
							cgformFieldTempEntity.setFieldName((String)map.get("fieldName"));
							cgformFieldTempEntity.setBussId((String)map.get("bussId"));
							cgformFieldTempEntity.setTempField("temp"+tempNum);
							systemService.save(cgformFieldTempEntity);
							//将值重新切换字段，不然存在列头和值不对应的情况
							List<Map<String, Object>> ee = systemService.findForJdbc("SELECT d.field_value,d.master_id FROM cgform_rdata_detail d,cgform_rdata_master m where m.id=d.master_id and m.buss_id='"+cgformFieldTempEntity.getBussId()+"' and d.field_name='"+cgformFieldTempEntity.getFieldName()+"'");
							for (Map<String, Object> ee1 : ee) {
								systemService.executeSql("update cgform_rdata_master m set m.temp"+tempNum+"='"+ee1.get("field_value")+"' where id ='"+ee1.get("master_id")+"'");
							}
							tempNum++;
						}
					}
				}
				cgformBuss.setStatus(status);
				systemService.saveOrUpdate(cgformBuss);
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
	 * 添加“cgform_buss”表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CgformBussEntity cgformBuss, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "操作成功成功";
		boolean result = true;
		try{
			cgformBuss = cgformBussService.saveAndCopyDefine(cgformBuss,request);
			if(cgformBuss==null){
				message = "操作失败";
				result = false;
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "操作失败";
			result = false;
		}
		j.setMsg(message);
		j.setObj(cgformBuss);
		j.setSuccess(result);
		return j;
	}
	
	/**
	 * 更新“cgform_buss”表
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CgformBussEntity cgformBuss, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "cgform_buss更新成功";
		cgformBuss.setIsIndex(StringUtils.isNotBlank(cgformBuss.getIsIndex())?"Y":"N");
		cgformBuss.setIsPage(StringUtils.isNotBlank(cgformBuss.getIsPage())?"Y":"N");
		cgformBuss.setIsSum(StringUtils.isNotBlank(cgformBuss.getIsSum())?"Y":"N");
		cgformBuss.setIsCheckbox(StringUtils.isNotBlank(cgformBuss.getIsCheckbox())?"Y":"N");
		cgformBuss.setInitRow(oConvertUtils.getString(cgformBuss.getInitRow(),"2"));
		CgformBussEntity t = systemService.get(CgformBussEntity.class, cgformBuss.getId());
		try {
			//如果不是同一个表单则，先删除原来的表单配置数据
			if(!t.getDefineId().equals(cgformBuss.getDefineId())){
				if(StringUtil.isNotEmpty(t.getDefineId())){
					List<Map<String, Object>> r = systemService.findForJdbc("select * from cgform_define where resource_id='"+t.getDefineId()+"' and buss_id<>'"+t.getId()+"'");
					if(r!=null&&r.size()>0){
						//如果没有其他业务引用当前表单，则直接删除，如果有其他业务在引用则不做处理
					}else{
						int t1=systemService.executeSql("delete from cgform_buss_list  where buss_id='"+t.getId()+"' ");
						System.out.println("执行删除表：cgform_buss_list==受影响的条数："+t1);
						t1=systemService.executeSql("delete from cgform_buss_query where  buss_id='"+t.getId()+"' ");
						System.out.println("执行删除表：cgform_buss_query==受影响的条数："+t1);
						t1=systemService.executeSql("delete from cgform_define where buss_id='"+t.getId()+"' and id='"+t.getDefineId()+"' ");
						System.out.println("执行删除表：cgform_define==受影响的条数："+t1);
						t1=systemService.executeSql("delete from cgform_field_temp where  buss_id='"+t.getId()+"' ");
						System.out.println("执行删除表：cgform_field_temp==受影响的条数："+t1);
						t1=systemService.executeSql("delete from cgform_lg_field where define_id='"+t.getDefineId()+"' and buss_id='"+t.getId()+"' ");
						System.out.println("执行删除表：cgform_lg_field==受影响的条数："+t1);
						
						MyBeanUtils.copyBeanNotNull2Bean(cgformBuss, t);
						cgformBussService.saveOrUpdate(t);
						cgformBussService.saveAndCopyDefine(t,request);
					}
				}else{
					MyBeanUtils.copyBeanNotNull2Bean(cgformBuss, t);
					cgformBussService.saveOrUpdate(t);
					cgformBussService.saveAndCopyDefine(t,request);
				}
			}else{
				MyBeanUtils.copyBeanNotNull2Bean(cgformBuss, t);
				cgformBussService.saveOrUpdate(t);
			}
			
//			String step = request.getParameter("step");
//			if(step.equals("2")){
//				CgformDefineEntity cgformDefineEntity = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
//				if(cgformDefineEntity.getSaveType().equals("1")){
//					DbTableProcess dbTableProcess = new DbTableProcess(systemService.getSession());
//					dbTableProcess.updateTableByPara(cgformDefineEntity, systemService.getSession());
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "cgform_buss更新失败";
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	@RequestMapping(params = "getUseBussDefine")
	public ModelAndView getUseBussDefine(CgformBussEntity cgformBuss, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(cgformBuss.getId())) {
			cgformBuss = systemService.getEntity(CgformBussEntity.class, cgformBuss.getId());
		}
		cgformBuss.setPageSize(10);
		cgformBuss.setLimits("10,20,30");
		cgformBuss.setOperationWidth("200");
		//查询已启用表单
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
		sql.append(" where status = '1' and buss_type='1' and (resource_id='' or  resource_id is null) ");
		List<Map<String, Object>> list1 =  systemService.findForJdbc(sql.toString());
		 sql = new StringBuffer();
		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
		sql.append(" where status = '1' and buss_type='2'  and (resource_id='' or  resource_id is null) ");
		List<Map<String, Object>> list2 =  systemService.findForJdbc(sql.toString());
		 sql = new StringBuffer();
		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
		sql.append(" where  resource_id<>'' and  resource_id is not null  ");
		List<Map<String, Object>> list3 =  systemService.findForJdbc(sql.toString());
		sql = new StringBuffer();
		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
		sql.append(" where  status = '1' and buss_type='3'  ");
		List<Map<String, Object>> list4 =  systemService.findForJdbc(sql.toString());
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
		
		req.setAttribute("defineList1",list1);
		req.setAttribute("defineList2",list2);
		req.setAttribute("defineList3",list3);
		req.setAttribute("defineList4",list4);
		if (StringUtil.isNotEmpty(cgformBuss.getDefineId())) {
			CgformDefineEntity cgformDefine = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
			req.setAttribute("cgformDefine", cgformDefine);
		}
		req.setAttribute("bean", cgformBuss);
		req.setAttribute("post_method","doAdd");
		return new ModelAndView(prefix+"pagegen/buss/cgformUseBussDefine"+suffix);
	}
	
	/**
	 * 获取表单字段列表
	 * @param cgformBuss
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getLgFieldList")
	@ResponseBody
	public AjaxJson getLgFieldList(CgformBussEntity cgformBuss, HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String tableName=request.getParameter("tableName");
		String bussId =request.getParameter("bussId");
		List<Map<String, Object>> lgFieldList = null;
		cgformBuss = systemService.getEntity(CgformBussEntity.class, bussId);
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT clf.*,cbl.id as bussListId FROM cgform_lg_field  clf LEFT JOIN "+tableName+" cbl on clf.id = cbl.define_id and cbl.buss_id = '"+bussId+"' ");
			sql.append(" where clf.define_id = '"+cgformBuss.getDefineId()+"' ");
			sql.append(" and clf.show_type NOT LIKE '%v_form%' order by cbl.sort asc ");
			lgFieldList =  systemService.findForJdbc(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		j.setObj(lgFieldList);
		return j;
	}
	
	

	/**
	 * “cgform_buss”新增页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CgformBussEntity cgformBuss, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(cgformBuss.getId())) {
			cgformBuss = systemService.getEntity(CgformBussEntity.class, cgformBuss.getId());
		}
		cgformBuss.setPageSize(10);
		cgformBuss.setLimits("10,20,30");
		cgformBuss.setOperationWidth("200");
		//查询已启用表单
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where status = '1' and buss_type='1' and (resource_id='' or  resource_id is null) ");
//		List<Map<String, Object>> list1 =  systemService.findForJdbc(sql.toString());
//		 sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where status = '1' and buss_type='2'  and (resource_id='' or  resource_id is null) ");
//		List<Map<String, Object>> list2 =  systemService.findForJdbc(sql.toString());
//		 sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where  resource_id<>'' and  resource_id is not null  ");
//		List<Map<String, Object>> list3 =  systemService.findForJdbc(sql.toString());
//		sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where  status = '1' and buss_type='3'  ");
//		List<Map<String, Object>> list4 =  systemService.findForJdbc(sql.toString());
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
//		
//		req.setAttribute("defineList1",list1);
//		req.setAttribute("defineList2",list2);
//		req.setAttribute("defineList3",list3);
//		req.setAttribute("defineList4",list4);
		
		req.setAttribute("bean", cgformBuss);
		req.setAttribute("post_method","doAdd");
		return new ModelAndView(prefix+"pagegen/buss/cgformBussAdd"+suffix);
	}
	/**
	 * “cgform_buss”编辑页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CgformBussEntity cgformBuss, HttpServletRequest req) throws Exception {
		if (StringUtil.isNotEmpty(cgformBuss.getId())) {
			cgformBuss = systemService.getEntity(CgformBussEntity.class, cgformBuss.getId());
		}
		CgformDefineEntity cgformDefine = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
		req.setAttribute("cgformDefine", cgformDefine);
		req.setAttribute("bean", cgformBuss);
		//查询已启用表单
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where status = '1' and buss_type='1' and (resource_id='' or  resource_id is null) ");
//		List<Map<String, Object>> list1 =  systemService.findForJdbc(sql.toString());
//		 sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where status = '1' and buss_type='2'  and (resource_id='' or  resource_id is null) ");
//		List<Map<String, Object>> list2 =  systemService.findForJdbc(sql.toString());
//		 sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where  resource_id<>'' and  resource_id is not null ");
//		List<Map<String, Object>> list3 =  systemService.findForJdbc(sql.toString());
//		sql = new StringBuffer();
//		sql.append("SELECT *,(SELECT COUNT(*) FROM cgform_define c WHERE cd.id = c.resource_id ) as countsize FROM cgform_define cd ");
//		sql.append(" where  status = '1' and buss_type='3'  ");
//		List<Map<String, Object>> list4 =  systemService.findForJdbc(sql.toString());
//		
		String bussCode = req.getParameter("bussCode");
		req.setAttribute("bussCode", bussCode);
//		
//		req.setAttribute("defineList1",list1);
//		req.setAttribute("defineList2",list2);
//		req.setAttribute("defineList3",list3);
//		req.setAttribute("defineList4",list4);
//		req.setAttribute("bussCode", bussCode);
		req.setAttribute("post_method","doUpdate");//
		return new ModelAndView(prefix+"pagegen/buss/cgformBussAdd"+suffix);
	}


}
