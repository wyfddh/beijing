package com.tj720.mip.utils;

import java.io.ByteArrayOutputStream; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tj720.mip.dto.CrumbDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.SpringContextHolder;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.service.tool.CacheService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;


public class Tools {
	public static void staticize(String html, String filePath) throws MyException, IOException{
		if(html == null){
			throw new MyException("000045");
		}
		FileWriter fw = new FileWriter(filePath, false);
		try{
			fw.write(html);
			fw.flush();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("000001", e.getMessage());
		}finally{
			fw.close();
		}
	}
	/** 
     * 通过递归调用删除一个文件夹及下面的所有文件 
     * @param file 
     */  
    public static void deleteFile(String filePath){  
    	File file = new File(filePath);
    	if( !file.exists()){
    		return;
    	}
        if(file.isFile()){//表示该文件不是文件夹  
            file.delete();  
        }else{  
            //首先得到当前的路径  
            String[] childFilePaths = file.list();  
            for(String childFilePath : childFilePaths){  
                deleteFile(file.getAbsolutePath()+"\\"+childFilePath);  
            }  
            file.delete();  
        }  
    } 
    // 创建文件夹
    public static void createFile(String filePath){  
    	File file = new File(filePath);
    	if( !file.exists()){
    		file.mkdirs();
    	}
    }  
	/**
	 * 构造查询的id
	 * @param roleName
	 * @return
	 */
	public static List<String> getIdsFromField(String ids) {
		return Arrays.asList(ids.split(","));
	}
	
	// 获取图形验证码
	public static String getImgCode(HttpServletRequest request) throws MyException{
		ICacheService cacheService = SpringContextHolder.getBean("cacheService", CacheService.class);
		String timesStr = cacheService.getStr(Const.CACHE_IMGCODE_TIMES + MyCookie.getCookie(Const.COOKIE_UUID, false, request));
		int times = 0;
		if(timesStr != null){
			times = Integer.parseInt(timesStr.toString()) + 1;
		}
		if(times > 3){
			throw new MyException("000011");
		}
		cacheService.setStr(Const.CACHE_IMGCODE_TIMES + MyCookie.getCookie(Const.COOKIE_UUID, false, request), times + "", 10 * 60);
		String imgCode = cacheService.getStr(Const.CACHE_IMGCODE + MyCookie.getCookie(Const.COOKIE_UUID, false, request));
		return imgCode == null? System.currentTimeMillis()+"" : imgCode.toString();
	}
	
	public static boolean hasAuth(String authPassport) throws MyException {
		LoginInfoDto user = Tools.getUser();
		if(user == null ){
			throw new MyException("000003");
		}
		
		String authority = user.getAuthStr();
		if( user != null && (","+user.getRoleId()).indexOf(","+Const.SUPER+",")>=0){
			return true;//超级管理员
		}
		
		// 管理员修改自己的资料
		if(authPassport.equals("USER")){
			// 如果session中的管理员id和参数中的id一致
			if( MyString.isEquals(  user.getId(),  user.getId() )  ){
				return true;
			}
		}
		
		if(authority.indexOf(","+authPassport+",")>=0){
			return true;
		}
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		String acceptHeader = request.getHeader("Accept");
		String ajaxParam = request.getParameter("text/html;type=ajax");
		if ("text/html;type=ajax".equals(acceptHeader) || StringUtils.hasText(ajaxParam)) {
			throw new MyException("000003");
		} else {
			/*try {
				 response.setContentType("text/html; charset=UTF-8"); //转码
				    PrintWriter out = response.getWriter();
				    out.flush();
				    out.println("<script>");
				    out.println("alert('您没有此操作权限，请更换账号重新登录！');");
				    out.println("history.go(-1);");
				    out.println("</script>");
				    out.close();
//				response.sendRedirect(request.getContextPath()+"/toLogin.do");
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			try {
				response.sendRedirect(request.getContextPath()+"/toErrorNoAuth.do");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*throw new MyException("000003");*/
		throw new MyException("000003");
	}
	
	/**
	 * 构造查询Map集合
	 * @param params 不定数量参数 格式(key1,value1,key2,value2....)
	 * @return
	 */
	public static Map<String, Object> getMap(Object... params) {
		if (params.length == 0 || params.length % 2 != 0) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < params.length; i = i + 2) {
			if (!MyString.isEmpty(params[i + 1]))
				map.put(params[i].toString(), params[i + 1]);
		}
		return map;

	}
	
	public static Map<String, String> getStrMap(String... params) {
		if (params.length == 0 || params.length % 2 != 0) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < params.length; i = i + 2) {
			if (!MyString.isEmpty(params[i + 1]))
				map.put(params[i].toString(), params[i + 1]);
		}
		return map;

	}
	
	
	/**
	 * 构造导航条
	 */
	public static List<CrumbDto> getCrumbs(String... params) {
		 List<CrumbDto> crumbDtos = new ArrayList<CrumbDto>();
		if (params.length == 0 || params.length % 2 != 0) {
			return crumbDtos;
		}
		for (int i = 0; i < params.length; i = i + 2) {
			if (!MyString.isEmpty(params[i + 1])){
				CrumbDto crumb = new CrumbDto(params[i], params[i + 1]);
				crumbDtos.add(crumb);
			}
		}
		return crumbDtos;

	}
	//查询需要添加过滤器status>-1
	public static String getHql(Map<String, Object> map) {
		StringBuffer hql = new StringBuffer();
		if (map == null || map.size() == 0) {
			return " where status > -127 ";
		}
		hql.append(" where ");
		if (!map.containsKey("status")) {
			hql.append(" status > -127 and ");
		}
		List<String> removes = new ArrayList<String>();
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.indexOf("|") > 0) {
				String[] keys = key.split("\\|");
				keys[0] = keys[0].replaceAll("\\.", "_");
				
				if (keys[1].equals("in")) {
					hql.append(keys[0] + " in (:" + keys[0]+"_in) and ");
				} 
				
				else if (keys[1].equals(Const.NULL)) {
					hql.append(keys[0] + " =null and ");
					removes.add(key);
				} 
				
				else if (keys[1].equals(Const.NOT_NULL)) {
					hql.append(keys[0] + "!=null and ");
					removes.add(key);
				} 
				
				else if (keys[1].equals(Const.BLANK)) {
					hql.append(keys[0] + " ='' and ");
					removes.add(key);
				} else if (keys[1].equals("like")) {
					hql.append(keys[0] + " like :" + keys[0] + " and  ");
				} else if (keys[1].equals("or")){
					hql.replace(hql.lastIndexOf("and"), hql.length(), " or  ");
					hql.append( keys[0] + " like :" + keys[0] +" and  ");
				} else if(keys[1].equals("overtime")){
					hql.append(keys[0] + " < :" + keys[0] + " and  ");
				} else if(keys[1].equals("staTime")){
					hql.append(keys[0] + " >= :" + keys[0] + " and  ");
				} else if(keys[1].equals("endTime")){
					hql.append(keys[0] + " <= :" + keys[0] + " and  ");
				}
				else {
					hql.append(keys[0] + " " + keys[1] + ":"+ keys[0]+ " and ");
				}
			} else if(key.equals("beginTime")){
				hql.append(key + ">=:" + key.replaceAll("\\.", "_") + " and ");
			} else if(key.equals("endTime")){
				hql.append(key + "<=:" + key.replaceAll("\\.", "_") + " and ");
			} else if(key.equals("publish") && String.valueOf(entry.getValue()).equals("-128")){
				hql.append(key + ">:" + key.replaceAll("\\.", "_") + " and ");
				
			}
			else{
				hql.append(key + "=:" + key.replaceAll("\\.", "_") + " and ");
			}
				
		}
		if (map.size() > 0) {
			hql.replace(hql.lastIndexOf("and"), hql.length(), "");
		}
		for (String remove : removes)
			map.remove(remove);
		return hql.toString();
	}

	public static void setPage(Query query, Page pageBean) {
		if (pageBean != null) {
			query.setFirstResult(pageBean.getStart()).setMaxResults(
					pageBean.getSize());
		}
	}

	// 根据map设置参数
	public static void setQuery(Map<String, Object> map, Query query) {
		if (map == null)
			return;
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			String operator = "";
			if (key.indexOf("|") > 0) {
				key = entry.getKey().split("\\|")[0];
				operator = entry.getKey().split("\\|")[1];
			}
			Object value = entry.getValue();
			key = key.replaceAll("\\.", "_");
			if (operator.toUpperCase().equals("LIKE")) {
				query.setString(key, "%" + value.toString() +"%");
			} else if(operator.toUpperCase().equals("OR")){
				query.setString(key, "%" + value.toString() +"%");
			} else if(operator.toUpperCase().equals("STATIME")){
				query.setParameter(key, value);
			} else if(operator.toUpperCase().equals("ENDTIME")){
				query.setParameter(key, value);
			}
			 else if (value instanceof Integer) {
				query.setInteger(key, Integer.parseInt(value.toString()));
			} else if (value instanceof String) {
				query.setString(key, value.toString());
			} else if (value instanceof Byte) {
				query.setByte(key, Byte.valueOf(value.toString()));
			}else if(value instanceof List){
				query.setParameterList(key+"_in",(List<?>) value); 
			} else {
				query.setParameter(key, value);
			}
		}
	}
//	public static String getConf(String key, String fileName) throws Exception{
//		return getConf(key,fileName,null);
//	}
//	public static String getConf(String key, String fileName, String def) throws Exception{
//		if(fileName == null)
//			fileName = "/jdbc.properties";
//		InputStream in = Tools.class.getResourceAsStream(fileName);
//		Properties prop = new Properties();
//		try {
//			prop.load(in);
//			return prop.getProperty(key).trim();
//		} catch (Exception e) {
//			System.out.println("配置有误，params config have error,"+key+" not exist.");
//			if(def!=null){
//				return def;
//			}else{
//				e.printStackTrace();
//				throw new Exception("配置有误，"+key+"不存在");
//			}
//		}
//	}
	//获取根目录
	public static String getServicePath(HttpServletRequest request){
		return request.getSession().getServletContext().getRealPath("/")+"/";
	}
	public static String getChar(int num){
		String md="123456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ789abcd";
		Random random = new Random();
		String temp="";
		for(int i=0;i<num;i++){
			temp=temp+md.charAt(random.nextInt(50));
		}
		return temp;
	}
	
	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	
	public static HttpServletResponse getResponse(){
		HttpServletResponse response=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();;
		response.setContentType( "text/html" );
		response.setCharacterEncoding( "UTF-8" );
		return response;
	}
	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
	}
	public static ServletContext getServletContext(){
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();  
        return webApplicationContext.getServletContext(); 
	}
	public static String readStream(InputStream inStream, String encoding)
			throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return new String(outSteam.toByteArray(), encoding);
	}

	public static String removeHtml(String inputStr){
		inputStr=inputStr.replaceAll("<[a-zA-Z|//]+[1-9]?[^><]*>", "");
		inputStr=inputStr.replaceAll("&nbsp;", "");
		StringBuffer temp=new StringBuffer();
		String str="[a-z]*[A-Z]*[0-9]*[\u4E00-\u9FA5]*[Ⅰ|,|。|，|.|：|(|)|（|）|:|/]*";
		Pattern pattern = Pattern.compile(str,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		while (matcher.find())
		{
			temp.append(matcher.group());
		}
		return temp.toString();
	}
	/**
	 * 获取用户登录信息
	 * @return
	 */
	public static String getUserId(){
		return MyCookie.getCookie(Const.COOKIE_USERID, false, Tools.getRequest());
	}
	/**
	 * 获取企业用户登录信息
	 * @return
	 */
	public static String getCUserId(){
		return MyCookie.getCookie(Const.COOKIE_CUSERID, false, Tools.getRequest());
	}
	/**
	 * 获取用户登录信息
	 * @return
	 */
	public static LoginInfoDto getUser(){
		ICacheService cacheService = SpringContextHolder.getBean("cacheService", CacheService.class);
		String uId = MyCookie.getCookie(Const.COOKIE_USERID, false, Tools.getRequest());
		return (LoginInfoDto) cacheService.getObj(Const.CACHE_USER + uId);
	}
	/**
	 * 获取企业用户登录信息
	 * @return
	 */
	public static LoginInfoDto getCUser(){
		ICacheService cacheService = SpringContextHolder.getBean("newCacheService", CacheService.class);
		String uId = MyCookie.getCookie(Const.COOKIE_CUSERID, false, Tools.getRequest());
		return (LoginInfoDto) cacheService.getObj(Const.CACHE_CUSER + uId);
	}
	public static boolean checkUserName(String userName){
		String regex = "^[0-9A-Za-z-_\\.]{5,20}$";		
		return userName.matches(regex);
	}
	public static boolean checkEmail(String email){
	        boolean flag = false;
	        try{
	                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	                Pattern regex = Pattern.compile(check);
	                Matcher matcher = regex.matcher(email);
	                flag = matcher.matches();
	            }catch(Exception e){
	                flag = false;
	            }
	        return flag;
	    }
	/**
	 * <pre>isValidDate(判断是不是正规格式的日期)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月8日 下午4:35:02    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月8日 下午4:35:02    
	 * 修改备注： 
	 * @param str
	 * @return</pre>
	 */
	public static boolean isValidDate(String str){
		 boolean convertSuccess=true;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			convertSuccess=false;
		}
		 return convertSuccess;
	}
	
	

   /**
    * <pre>useList(判断数组包含某个值未使用到)   
    * 创建人：Caomq caomqvip@sina.com
    * 创建时间：2017年2月9日 上午11:10:13    
    * 修改人：Caomq caomqvip@sina.com
    * 修改时间：2017年2月9日 上午11:10:13    
    * 修改备注： 
    * @param arr
    * @param i
    * @return</pre>
    */
    public static boolean useList(Object object) {
//    	0未提交、1待审核、 10,审核通过  127待删除、-127已删除、-126审核不通过  -128 查询全部
    	String[] statusByte={"0","1","10","127","-127","-126"};
        return Arrays.asList(statusByte).contains(String.valueOf(object));
    }
    

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String format = sdf.format(date);
		try {
			long millionSeconds = sdf.parse("2017-02-21").getTime();
			
			System.out.println(millionSeconds / 1000);
			System.out.println(millionSeconds);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
