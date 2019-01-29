package com.tj720.mip.framework.auth;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.model.SysLog;
import com.tj720.admin.service.SysLogService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.dao.ICacheDao;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.springbeans.GetBeanByConfig;
import com.tj720.mip.utils.Aes;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;



/**
 * 对登录状态进行拦截
 * @author 
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private GetBeanByConfig getBEanByConfig;
	@Autowired
	private SysLogService sysLogService;
	@Autowired
	private Config config;
	
	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
        	AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
        	
        	long beginTime = System.currentTimeMillis(); //开始时间 
            startTimeThreadLocal.set(beginTime); //线程绑定变量（该数据只有当前请求的线程可见）
        	
        	 // 未登陆用户唯一识别
        	String uuid = MyCookie.getCookie(Const.COOKIE_UUID, false, request);
            if( MyString.isEmpty(uuid) ){
            	MyCookie.addCookie(Const.COOKIE_UUID, System.currentTimeMillis() + Tools.getChar(10), response);
            }
            
            try{
            	// 返回服务器ip
            	response.setHeader("serviceIp", InetAddress.getLocalHost().getHostAddress());
            }catch(Exception e){
            	e.printStackTrace();
            	response.setHeader("serviceIp", "服务器配置异常，无法获取服务器IP");
            }
            // 指定允许其他域名访问
        	response.setHeader("Access-Control-Allow-Origin", "*");
        	// 指定允许其他域名访问
        	response.setHeader("Access-Control-Allow-Credentials", "true");
        	// 响应类型
        	response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        	// 响应头设置
        	response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
            if(authPassport == null || authPassport.validate() == false) {
            	return true;
            }
            
        	
            String token = MyCookie.getCookie(Const.COOKIE_TOKEN, false, request);
        	String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
            // 前端没有传递token，未登录
            if(MyString.isEmpty(token) || MyString.isEmpty(uid) || !Aes.desEncrypt(token).equals(uid)){
            	String requrl = request.getRequestURI();
            	if(request.getRequestURI().endsWith("admin.do"))
            		response.sendRedirect("loginOrRegister.do#/login");
            	else{
            		String acceptHeader = request.getHeader("Accept");
            		String ajaxParam = request.getParameter("text/html;type=ajax");
					if ("text/html;type=ajax".equals(acceptHeader) || StringUtils.hasText(ajaxParam)) {
						response.setStatus(999);
						throw new MyException("000021");
					} else {
						response.getWriter().write("<script>top.location='"+request.getContextPath()+"/toLogin.do'</script>");
						return false;
					}
            	}
            }
            
            // 后端没登录信息：登录超时
            ICacheDao cacheDao = getBEanByConfig.getCacheDao();
            Object obj = cacheDao.getObj(Const.CACHE_USER + uid);
            HttpSession session = request.getSession();
            UserDto userDao = (UserDto)session.getAttribute("user");
            if(obj == null || userDao == null || org.apache.commons.lang3.StringUtils.isBlank(userDao.getUserId())){
            	// 删除cookie
            	MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
            	if(request.getRequestURI().endsWith("admin.do")){
            		response.sendRedirect("loginOrRegister.do#/login");
            		return false;
            	}else{
            		String acceptHeader = request.getHeader("Accept");
            		String ajaxParam = request.getParameter("text/html;type=ajax");
					if ("text/html;type=ajax".equals(acceptHeader) || StringUtils.hasText(ajaxParam)) {
						response.setStatus(999);
						throw new MyException("000021");
					} else {
						response.getWriter().write("<script>top.location='"+request.getContextPath()+"/toLogin.do'</script>");
//						response.sendRedirect(request.getContextPath()+"/toLogin.do");
						return false;
					}
            	}
            }
            
            // 每次访问，将用户登录有效信息延长
            cacheDao.setObj(Const.CACHE_USER + uid, obj, config.getLoginInforTime());
            
            if(!authPassport.authority().equals("")){
            	LoginInfoDto user = Tools.getUser();
        		if(user == null ){
        			throw new MyException("000003");
        		}
            	return true;
//            	return Tools.hasAuth(authPassport.authority());
            }else{
            	return true;
            }
            
        }
        else
            return true;   
     }

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//判断是否为ajax请求，默认不是  
        boolean isAjaxRequest = false;  
        if(!org.apache.commons.lang3.StringUtils.isBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")){  
            isAjaxRequest = true;  
        }
		long beginTime = startTimeThreadLocal.get(); //得到线程绑定的局部变量（开始时间） 
	    long endTime = System.currentTimeMillis(); //结束时间 
	    String statusCode = "200";
	    String errorInfo = "";
	    if(ex != null) {
	    	statusCode = "500";
	    	errorInfo = JSON.toJSONString(ex);
	    }
	    SysLog log = new SysLog(null,request.getRequestURI(),getIpAddress(request),
	    		beginTime,endTime,JSON.toJSONString(request.getParameterMap()),Tools.getUserId(),
	    		isAjaxRequest?1:0, statusCode, errorInfo);
	    sysLogService.create(log);
	    /*System.out.println("=================请求链接："+request.getRequestURI());
	    System.out.println("=================请求IP："+getIpAddress(request));
	    System.out.println("=================开始时间："+beginTime);
	    System.out.println("=================结束时间："+endTime);
	    System.out.println("=================执行耗时："+(endTime-beginTime));
	    System.out.println("=================请求参数："+JSON.toJSONString(request.getParameterMap()));
	    System.out.println("=================登陆用户："+Tools.getUserId());
	    System.out.println("=================是否ajax："+(isAjaxRequest?"是":"否"));
	    System.out.println("=================状态码："+response.toString());*/
	}
	
	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
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