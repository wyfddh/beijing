/** 
 * <pre>项目名称:mip 
 * 文件名称:AuditController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年2月4日下午3:49:59 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.controller.content;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.ApplicationDetailsService;
import com.tj720.mip.inter.service.table.ApplyAuditingRecordService;
import com.tj720.mip.model.ApplyAuditingRecord;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.HqlWhere;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/** 
 * <pre>项目名称：mip    
 * 类名称：AuditController    
 * 类描述：审核数据
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月4日 下午3:49:59    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月4日 下午3:49:59    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("audit")
public class AuditController {
	@Autowired
	private static ApplicationDetailsService applicationDetailsService;
	//申请审核记录表
	@Autowired
	private  ApplyAuditingRecordService applyAuditingRecordService;
	
	
/*
	//所有要审核的都需要调这个方法
	public  void applicationReview(ApplyAuditingRecord record){
		//申请审核记录表
		//applyAuditingRecordService
		applyAuditingRecordService.save(record);
		try {
			Class forName = Class.forName(name);
			Object obj = forName.newInstance();
			//获取方法  
			Method m = obj.getClass().getDeclaredMethod("setViUnit", String.class);
			m.invoke(obj, "曹梦奇");
			//virtualService.insert(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	//查询需要审核的东西
	@RequestMapping("getOneAudit")
	@ResponseBody
	public JsonResult getOneAudit(@ModelAttribute ApplyAuditingRecord auditingRecord) throws MyException{
		ApplyAuditingRecord model = null;
		if(!auditingRecord.getId().equals(Const.NULL_ID)){
				model= applyAuditingRecordService.get(auditingRecord.getId());
		}else{
			model=new ApplyAuditingRecord();
		}
		return new JsonResult(1,model);
	}
	
	//查询未审核列表(所有的审核都走这个方法)
	@RequestMapping("getAuditList")
	@ResponseBody
	public JsonResult getAuditList(@ModelAttribute ApplyAuditingRecord auditingRecord,String modelName,
								@RequestParam(defaultValue="1") Integer currentPage,Integer size,@RequestParam(defaultValue="1") String status) throws MyException{
		Page page= new Page(size);
		page.setCurrentPage(currentPage);
		String hqlCondition = applyAuditingRecordService.getHqlCondition(auditingRecord,modelName,status);
		return new JsonResult(1,applyAuditingRecordService.findByHql(hqlCondition,modelName, null, page),page);
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {  
		  Class clazz = Class.forName("com.tj720.mip.model.VirtualShowroom");//这里的类名是全名。。有包的话要加上包名  
		  Object obj = clazz.newInstance();  
		  Field[] fields = clazz.getDeclaredFields();  
	}  
	
	
}
