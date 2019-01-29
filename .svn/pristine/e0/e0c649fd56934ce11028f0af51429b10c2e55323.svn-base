package com.tj720.admin.base.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.TokenCodeUtil;
import com.tj720.admin.common.vo.TokenCode;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.MyException;


/**
 * 
 * @author zwp
 * @date 2017年6月20日 上午11:02:51
 */
@SuppressWarnings({ "rawtypes", "unchecked","unused" })
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	protected HttpServletRequest request;
	
    protected HttpServletResponse response;
    
    protected HttpSession session;
    @ModelAttribute 
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){ 
        this.request = request; 
        this.response = response; 
        this.session = request.getSession(); 
    } 
    
    /**
     * 获取当前登录用户ID
     * </p>
     * @param token
     * 			登录签名
     * @return
     */
    public String getLoginUser(String token) {
		String cuserId = (String) this.session.getAttribute("userId");
		if (StringUtils.isBlank(cuserId)) {
			TokenCode tokenCode = TokenCodeUtil.getTokenCode(token);
			if (tokenCode != null && StringUtils.isNotBlank(tokenCode.getUserId())) {
				cuserId = tokenCode.getUserId();
			}
		}
		return cuserId;
	}
    
	
	/**
	 * 跨域返回结果
	 * </p>
	 * @param result
	 * 					返回结果集
	 * @param jsoncallback
	 * 					跨域
	 */
	public void returnCrossDomainResult(Object result, String jsoncallback){
		ServletOutputStream sos = null;
		try {
			response.setContentType("text/html; charset=utf-8");
			sos = response.getOutputStream();
			String content = JSON.toJSONString(result);
			content = jsoncallback + "(" + content + ")";
			sos.write(content.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sos != null){
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
     * 获取客户端真实IP地址
     * </p>
     * @return IP
     */
    public String getClientIp() {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	
	/**
     * 获取客户端真实IP地址
     * </p>
     * @param request HttpServletRequest
     * @return IP
     */
    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean isUnAvailableIp(String ip) {
        return (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip));
    }
    
    /**
     * 获取当前登录用户ID
     * </p>
     * @param token
     * 			登录签名
     * @return
     */
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
    
    public String getOrgId(){
    	UserDto user = (UserDto)this.session.getAttribute("user");
    	return user.getOrgId();
    }
    
    public String getOrgTypeId(){
    	UserDto user = (UserDto)this.session.getAttribute("user");
    	return user.getOrgTypeId();
    }
	
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public void expHandler(HttpServletRequest request, Exception ex) throws Exception {
		if (ex instanceof MyException) {
//			return new JsonResult((MyException) ex);
		} else {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			ex.printStackTrace();
			throw ex;
//			return new JsonResult(new MyException("000001", ex.getMessage()));
		}
	}
}