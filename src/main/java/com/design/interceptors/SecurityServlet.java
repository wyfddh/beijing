package com.design.interceptors;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.design.utils.ParameterUtil;
import com.design.utils.ResourceUtil;
import com.zxlhdata.framework.auth.util.LicenseUtil;

/***
 * 跨域请求过滤
* @ClassName: SecurityServlet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 何湘简
* @date 2017-12-12 上午10:07:49
 */
public class SecurityServlet extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;  
	  
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2) throws IOException, ServletException {  
    	HttpServletResponse response=(HttpServletResponse) resp; 
    	response.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	arg2.doFilter(req, resp);
            return ;
    }
    public void init(FilterConfig arg0) throws ServletException {  
//    	int randomCode = new java.util.Random(System.currentTimeMillis()).nextInt(100) +1;
//    	LicenseUtil.loadLicenseInfo(
//    			ResourceUtil.getSysPath() + "WEB-INF/classes/" + ParameterUtil.SYS_LIC_NAME,
//    			"",
//    			ParameterUtil.ATC_K, randomCode);
//    	System.out.println("系统注册码:"+com.zxlhdata.framework.auth.util.LicenseUtil.getRegisterCode(ParameterUtil.ATC_K));
    	
    }

}
