package com.tj720.mip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;

public abstract class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected Logger log = Logger.getLogger(getClass());
	
	/**
	 * spring 中request、response是线程安全的，可以直接注入
	 * 
	 * @ModelAttribute注解只有在被
	 * @Controller和@ControllerAdvice两个注解的类下使用 ModelAttribute的作用
	 *    1)放置在方法的形参上： 表示引用Model中的数据
	 *    2)放置在方法上面：表示请求该类的每个Action前都会首先执行它也可以将一些准备数据的操作放置在该方法里面。
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(); 
	}

	public String getLevel() {
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgType = user.getOrgTypeId();//1：政府2：博物馆
		String level = "";
		if("1".equals(orgType) || "2".equals(orgType)){
			level = "2";//代表文物局登录/区文委登录
		}else{
			level = "1";//代表非文物局登录、非区文委登录
		}
		return level;
	}
	/**
	 * @return
	 */
	protected HashMap<String, String> getRequestHeaders() {
		HashMap<String, String> requestHeaders = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			requestHeaders.put(headerName, headerValue);
		}
		return requestHeaders;
	}

	/**
	 * @return
	 */
	protected HashMap<String, String> getRequestParams() {
		HashMap<String, String> requestParams = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			requestParams.put(paramName, paramValue);
		}
		return requestParams;
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public void expHandler(HttpServletRequest request, Exception ex) throws Exception {
		if (ex instanceof MyException) {
//			return new JsonResult((MyException) ex);
		} else {
			ex.printStackTrace();
			log.error(ex.getMessage());
			ex.printStackTrace();
			throw ex;
//			return new JsonResult(new MyException("000001", ex.getMessage()));
		}
	}

	protected void printMsg(String message) {
		response.setHeader("Content-Type", "text/html");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(message);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * web端判断用户是否登录超时
	 * @param userid		当前用户id
	 * @param oldToken		token
	 * @param request		
	 * @return
	 */
	public boolean isLogin(String userid, String oldToken, HttpServletRequest request) {
		if(StringUtils.isBlank(userid) || StringUtils.isBlank(oldToken)) {
			return false;
		}
		String key = KeyConstants.USER_IP_TOKEN_CODE_KEY + userid+"##"+this.getIpAddress(request);
		String value = JedisService.get(key);
		if(StringUtils.isBlank(value)) {
			return false;
		}
		String token = value.replaceFirst(KeyConstants.USER_IP_TOKEN_CODE_KEY, "").split("##")[0];
		return oldToken.equals(token);
	}
	
	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	public String getIpAddress(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    if (ip.contains(",")) {
	        return ip.split(",")[0];
	    } else {
	        return ip;
	    }
	}
}
