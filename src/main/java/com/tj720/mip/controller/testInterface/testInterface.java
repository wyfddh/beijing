/** 
 * <pre>项目名称:mip 
 * 文件名称:testInterface.java 
 * 包名:com.tj720.mip.controller.testInterface 
 * 创建日期:2017年2月12日上午9:57:40 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.controller.testInterface;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * <pre>项目名称：mip    
 * 类名称：testInterface    
 * 类描述：    测试接口类
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月12日 上午9:57:40    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月12日 上午9:57:40    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("testInterface")
public class testInterface {
	/**
	 * <pre>toShow(跳转到测试接口页面)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月12日 上午9:59:08    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月12日 上午9:59:08    
	 * 修改备注： 
	 * @param name
	 * @param age
	 * @param request
	 * @param img
	 * @return</pre>
	 */
	@RequestMapping("toTest")
	public String toTest(){
		return "/WEB-INF/test/testInterface.jsp";
	} 
}
