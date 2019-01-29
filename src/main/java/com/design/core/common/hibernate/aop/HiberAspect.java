package com.design.core.common.hibernate.aop;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import com.design.utils.ContextHolderUtils;
import com.design.utils.oConvertUtils;

/**
 * Hiberate拦截器：实现创建人，创建时间，创建人名称自动注入;
 *                修改人,修改时间,修改人名自动注入;
 * @author  XXXX
 */
@Component
public class HiberAspect extends EmptyInterceptor {
	private static final Logger logger = Logger.getLogger(HiberAspect.class);
	private static final long serialVersionUID = 1L;



public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types) {
	HttpSession session = ContextHolderUtils.getSession();
	
	String create_by=oConvertUtils.getString(session.getAttribute("create_by"),"admin");
	String create_name=oConvertUtils.getString(session.getAttribute("create_name"),"admin");
	String org_id=oConvertUtils.getString(session.getAttribute("org_id"),"");
	
//	TSUser currentUser = null;
//	try {
//		currentUser = ResourceUtil.getSessionUserName();
//	} catch (RuntimeException e) {
//		logger.warn("当前session为空,无法获取用户");
//	}
//	if(currentUser==null){
//		return true;
//	}
	try {
		//添加数据
		 for (int index=0;index<propertyNames.length;index++)
		 {
		     /*找到名为"创建时间"的属性*/
		     if ("createDate".equals(propertyNames[index]))
		     {
		         /*使用拦截器将对象的"创建时间"属性赋上值*/
		    	 if(oConvertUtils.isEmpty(state[index])){
		    		 state[index] = new Date();
		    	 }
		         continue;
		     }
		     /*找到名为"创建人"的属性*/
		     else if ("createBy".equals(propertyNames[index]))
		     {
		         /*使用拦截器将对象的"创建人"属性赋上值*/
		    	 if(oConvertUtils.isEmpty(state[index])){
		    		  state[index] = create_by;
		    	 }
		         continue;
		     }
		     /*找到名为"创建人名称"的属性*/
		     else if ("createName".equals(propertyNames[index]))
		     {
		         /*使用拦截器将对象的"创建人名称"属性赋上值*/
		    	 if(oConvertUtils.isEmpty(state[index])){
		    		 state[index] = create_name;
		    	 }
		         continue;
		     }
//		     /*找到名为"创建部门id"的属性*/
//		     else if ("createDepartmentId".equals(propertyNames[index]))
//		     {
//		         /*使用拦截器将对象的"创建人名称"属性赋上值*/
//		    	 if(oConvertUtils.isEmpty(state[index])){
//		    		 state[index] = currentUser.getTSDepart().getId();
//		    	 }
//		         continue;
//		     }
//		     /*找到名为"创建部门名称"的属性*/
//		     else if ("createDepartmentName".equals(propertyNames[index]))
//		     {
//		         /*使用拦截器将对象的"创建人名称"属性赋上值*/
//		    	 if(oConvertUtils.isEmpty(state[index])){
//		    		 state[index] = currentUser.getTSDepart().getDepartname();
//		    	 }
//		         continue;
//		     }
		     else if ("orgId".equals(propertyNames[index]))
		     {
		         /*使用拦截器将对象的"创建人名称"属性赋上值*/
		    	 if(oConvertUtils.isEmpty(state[index])){
		    		 state[index] = org_id;
		    	 }
		         continue;
		     }
		 }
	} catch (RuntimeException e) {
		e.printStackTrace();
	}
	 return true;
}


public boolean onFlushDirty(Object entity, Serializable id,
		Object[] currentState, Object[] previousState,
		String[] propertyNames, Type[] types) {
	HttpSession session = ContextHolderUtils.getSession();
	String update_by=(String)session.getAttribute("update_by");
	String update_name=(String)session.getAttribute("update_name");
	
//	TSUser currentUser = null;
//	try {
//		currentUser = ResourceUtil.getSessionUserName();
//	} catch (RuntimeException e1) {
//		logger.warn("当前session为空,无法获取用户");
//	}
//	if(currentUser==null){
//		return true;
//	}
//	//添加数据
     for (int index=0;index<propertyNames.length;index++)
     {
         /*找到名为"修改时间"的属性*/
         if ("updateDate".equals(propertyNames[index]))
         {
             /*使用拦截器将对象的"修改时间"属性赋上值*/
        	 currentState[index] = new Date();
             continue;
         }
         /*找到名为"修改人"的属性*/
         else if ("updateBy".equals(propertyNames[index]))
         {
             /*使用拦截器将对象的"修改人"属性赋上值*/
        	 currentState[index] =update_by;
        	 continue;
         }
         /*找到名为"修改人名称"的属性*/
         else if ("updateName".equals(propertyNames[index]))
         {
             /*使用拦截器将对象的"修改人名称"属性赋上值*/
        	 currentState[index] = update_name;
        	 continue;
         }
     }
	 return true;
}
}
