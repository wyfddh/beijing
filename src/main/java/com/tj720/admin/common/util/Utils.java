package com.tj720.admin.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;
import com.tj720.admin.dto.MuseumDataProgressDto;

/**
 * 
 * @author zwp
 * @date 2017年6月20日 上午11:11:41
 */
public class Utils {
	public static final String PATTERN_FULL_NUMBER = "^\\d+$";
	public static final String PATTERN_FULL_DOUBLE = "^[0-9]*(\\.[0-9]*|[eE][+-][0-9]*)$";
	private static String propFilePath=null;
	private static Properties properties = new Properties();
	private static Map<String, ArrayList<String>> localDefineMap = new HashMap<String, ArrayList<String>>(); 
	public static final String DEFAULT_PROPERTY_FILE = "config.properties";
	
	public static String getStrValue(Object obj){
		if(obj==null){
			return null;
		}
		return obj.toString();
	}
	
	public static int getIntegerValue(Object obj){
		if(obj==null){
			return 0;
		}
		try{
		return Integer.parseInt(obj.toString());
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 获取类在service中注册的名称。类的首字母缩写
	 * @param clazz
	 * @return
	 */
	public static String gainClassServiceName(Class clazz){
		String name=clazz.getSimpleName();
		char first=Character.toLowerCase(name.charAt(0));
		
		name=first+name.substring(1);
		return name;
	}
	
	/**
	 * 拆分list
	 * @param resList 需要拆分的list
	 * @param subListLength  每个拆分后list 的长度
	 * @return
	 */
	public static <T> List<List<T>> split(List<T> resList, int subListLength) {  
        if (CollectionUtils.isEmpty(resList) || subListLength <= 0) {  
            return Lists.newArrayList();  
        }  
        List<List<T>> ret = Lists.newArrayList();  
        int size = resList.size();  
        if (size <= subListLength) {  
            // 数据量不足 subListLength 指定的大小  
            ret.add(resList);  
        } else {  
            int pre = size / subListLength;  
            int last = size % subListLength;  
            // 前面pre个集合，每个大小都是 subListLength 个元素  
            for (int i = 0; i < pre; i++) {  
                List<T> itemList = Lists.newArrayList();  
                for (int j = 0; j < subListLength; j++) {  
                    itemList.add(resList.get(i * subListLength + j));  
                }  
                ret.add(itemList);  
            }  
            // last的进行处理  
            if (last > 0) {  
                List<T> itemList = Lists.newArrayList();  
                for (int i = 0; i < last; i++) {  
                    itemList.add(resList.get(pre * subListLength + i));  
                }  
                ret.add(itemList);  
            }  
        }  
        return ret;  
    }  
	
	public static boolean isEmpty(String str){
		return str == null || str.trim().length() <= 0;
	}
	/**
	 * 将String类型转换成int型

	 * @param String sourceString
	 * @return int 转换后的int型

	 */
	public static int toNumber(String sourceString) {
		return toNumber(sourceString, 0);
	}

	/**
	 * @reload
	 * 将String类型转换成int型数字

	 * @param String sourceString
	 * @param int defaultValue
	 * @return int 转换后的int型

	 */
	public static int toNumber(String sourceString, int defaultValue) {
		return isDigitalNumber(sourceString)
				&& Long.parseLong(sourceString) <= Integer.MAX_VALUE ? Integer
				.parseInt(sourceString) : defaultValue;
	}
	
	/**
	 * 将String类型转换成double型

	 * @param String sourceString
	 * @return double 转换后的int型

	 */
	public static double toDouble(String sourceString) {
		return toDouble(sourceString, 0.0);
	}

	/**
	 * 将String类型转换成double型数字

	 * @param String sourceString
	 * @param double defaultValue
	 * @return double 转换后的double型
	 */
	public static double toDouble(String sourceString, double defaultValue) {
		return isDigitalDouble(sourceString) ? Double.parseDouble(sourceString) : defaultValue;
	}

	/**
	 * 将String类型转换成long型

	 * @param String sourceString
	 * @return long 转换后的long型

	 */
	public static long toLongNumber(String sourceString) {
		return toLongNumber(sourceString, 0);
	}

	/**
	 * @reload
	 * 将String类型转换成long型数字

	 * @param String sourceString
	 * @param long defaultValue
	 * @return long 转换后的long型

	 */
	public static long toLongNumber(String sourceString, long defaultValue) {
		return isDigitalNumber(sourceString) ? Long.parseLong(sourceString) : defaultValue;
	}
	/**
	 * 判断是否为数字

	 * @param String sourceString
	 * @return boolean
	 */
	public static boolean isDigitalNumber(String sourceString) {
		return sourceString != null && sourceString.matches(PATTERN_FULL_NUMBER);
	}
	/**
	 * 判断是否为double

	 * @param String sourceString
	 * @return boolean
	 */
	public static boolean isDigitalDouble(String sourceString) {
		return sourceString != null && (sourceString.matches(PATTERN_FULL_NUMBER) || sourceString.matches(PATTERN_FULL_DOUBLE));
	}
	
	public static boolean isURL(String url) {
		return url.startsWith("http") && !url.startsWith("http://127.0.0.1") && !url.startsWith("http://localhost");
	}
	
	
	public static double formatDouble(double d,String pattern){
		  DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
		  
		  // format.applyPattern("0.00");
		   format.applyPattern(pattern);
		   String s = format.format(d);
		   d = Double.parseDouble(s);
		   return d;

	}
	
	public static boolean loadProperties(InputStream is){
        try {
            properties.load(is);
        } catch (IOException e) {
            return false;
        } finally {
        	try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return true;
    }
	
	
	
	
	public static boolean loadProperties(String fileName){
          try {
        	  propFilePath=fileName;
			InputStream inputStream=new FileInputStream(fileName);
			return loadProperties(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
          
    }
	public static String getProperty(String key){
        return properties.getProperty(key);
    }

	public static String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }
	public static Properties getProperties(){
        return properties;
    }
	
	
	public static Map<String, ArrayList<String>> getLocalDefineMap() {
		return localDefineMap;
	}
	public static void setLocalDefineMap(Map<String, ArrayList<String>> defineMap) {
		localDefineMap = defineMap;
	}
	/**
	 * 替换字体类型中的空格
	 * @param str
	 * @return
	 */
	public static String replaceCharacterSpace(String contentHtml) {
		List<String[]> toReplaces=new ArrayList<String[]>();
    	
    	toReplaces.add(new String[]{"Comic&nbsp;Sans&nbsp;MS","Comic Sans MS"});
    	toReplaces.add(new String[]{"Courier&nbsp;New","Courier New"});
    	toReplaces.add(new String[]{"Times&nbsp;New&nbsp;Roman","Times New Roman"});
    	toReplaces.add(new String[]{"Arial&nbsp;Black","Arial Black"});
    	toReplaces.add(new String[]{"Lucida&nbsp;Sans&nbsp;Typewriter", "Lucida Sans Typewriter"});
    	toReplaces.add(new String[]{"Microsoft&nbsp;Sans&nbsp;Serif", "Microsoft Sans Serif"});
    	toReplaces.add(new String[]{"MS&nbsp;UI&nbsp;Gothic", "MS UI Gothic"});
    	toReplaces.add(new String[]{"Arial&nbsp;Unicode&nbsp;MS", "Arial Unicode MS"});
    	for(String[] cons:toReplaces){
    		String src=cons[0];
    		String tgt=cons[1];
    		contentHtml = contentHtml.replaceAll(src, tgt);
    	}
		return contentHtml;
	}
	

	
	public static boolean isEmpty(Collection list){
		  if(list!=null&&list.size()>0){
			  return false;
		  }
		  return true;
	}
	
	

	
    
     /**
      * 执行命令行参数
      * @param cmd 命令行参数
      * @return 成功返回true，失败返回false
      */
     public static boolean execCmd(String ip, String port) {
 		Runtime r = Runtime.getRuntime();
 		Process p = null;
 		String cmd = " cmd /c start telnet " + ip + " " + port + " ";
 		try {
 			p = r.exec(cmd);
 			Thread.sleep(10000);
			r.exec(" cmd /c start telnet " + ip + " ");
 			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));   
 	        String line = null;   
 	        while((line = br.readLine()) != null){  
 	           System.out.println(line);   
 	        }   
 	        br.close();  

 			p.waitFor();
 			if (p.exitValue() != 0) {//非0为不成功
 				byte[] temp = new byte[1024];
 				InputStream in = p.getErrorStream();
 				in.read(temp);
 				System.out.println("EROOR CODE:"+p.exitValue());
 				return false;
 			} else {//0：成功
 				return true;
 			}
 		} catch (IOException e) {
 			e.printStackTrace();
 			return false;
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
 		return true;
 	}
     
   
     public static boolean contain(Object[] partNames, Object dataType) {
 		if(partNames!=null){
 			for(Object ob:partNames){
 				if(ob.equals(dataType)){
 					return true;
 				}
 			}
 		}
 		return false;
 	}
	public static String getIpAddr(HttpServletRequest request) {
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
		return ip;
	}
	public static String GetInetAddress(String  host){  
	    String IPAddress = "";   
	    InetAddress ReturnStr1 = null;  
	    try {  
	        ReturnStr1 = java.net.InetAddress.getByName(host);  
	        IPAddress = ReturnStr1.getHostAddress();  
	    } catch (UnknownHostException e) {  
	        e.printStackTrace();  
	        return  IPAddress;  
	    }  
	    return IPAddress;  
	}  
	/**
	 * 将字符串转成unicode
	 * 
	 * @param str
	 *            待转字符串
	 * @return unicode字符串
	 */
	public static String convert(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); // 取出高8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); // 取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "http://www.comeup.com.cn/maidou/home.html?t=201601191509&oId=werxds12";
		System.out.println(java.net.URLEncoder.encode(url, "utf-8"));
		//System.out.println(convert("中国"));
		//System.out.println(GetInetAddress("m.comeup.com.cn"));
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(0, 3);
		for(Integer i : list){
			System.out.println(i);
		}*/
		Double count = 1000.5;
		Double preMoney = 0.1;
		/*for(int i=0; i<1000; i++){
			//count = doubleSubOrAdd(true, count.toString(), preMoney.toString());
			count = count - preMoney;
			System.out.println(count);
		}*/
		
		System.out.println(doubleMultOrDiv(true, "399.5", "0.005"));
		
	}

	public static String gainSuffix(String path) {
		int index=path.lastIndexOf(".");
		if(index>0){
			String avatarSuffix=path.substring(index);
			index = avatarSuffix.indexOf("?");
			if(index > 0 ){
				avatarSuffix = avatarSuffix.substring(0,index);
			}
			return avatarSuffix;
		}
		if(path.startsWith(".")) {
			return path;
		}
		return null;
	}

	public static String processImgUrlByIos(String imgSrc) {
		if(isEmpty(imgSrc)) return "";
		imgSrc = imgSrc.replaceAll("\"", "");
		imgSrc = imgSrc.replaceAll("\\\\", "");
		return imgSrc;
	}
	
	public static String getLocalIpAddress() {
		String ipAddress;
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				if (intf.getName().toLowerCase().equals("eth0") || intf.getName().toLowerCase().equals("wlan0")) {
					for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
						InetAddress inetAddress = enumIpAddr.nextElement();
						if (!inetAddress.isLoopbackAddress()) {
							ipAddress = inetAddress.getHostAddress().toString();
							if (!ipAddress.contains("::")) {// ipV6的地址
								return ipAddress;
							}
						}
					}
				} else {
					continue;
				}
			}
		} catch (SocketException ex) {
		}
		return null;
	}
	
	 /**
     * double类型数据加减
     * @param isSub 是否为减法
     * @param money
     * @param counterFee
     * @return
     */
	public static Double doubleSubOrAdd(boolean isSub, String money, String counterFee) {
		BigDecimal a1 = new BigDecimal(money);
		BigDecimal b1 = new BigDecimal(counterFee);
		if(isSub){
			return a1.subtract(b1).doubleValue();
		} else {
			return a1.add(b1).doubleValue();
		}
	}
	
	 /**
     * double类型数据乘除
     * @param isMult 是否乘法
     * @param money
     * @param counterFee
     * @return
     */
	public static Double doubleMultOrDiv(boolean isMult, String money, String counterFee) {
		BigDecimal a1 = new BigDecimal(money);
		BigDecimal b1 = new BigDecimal(counterFee);
		if(isMult){
			return a1.multiply(b1).doubleValue();
		} else {
			return a1.divide(b1).doubleValue();
		}
	}
	
	public static String progressIsFull(MuseumDataProgressDto pro){
		if("1".equals(pro.getBasePer()) && "1".equals(pro.getHousePer()) && "1".equals(pro.getCostPer())
			&& "1".equals(pro.getServicePer()) && "1".equals(pro.getPersonPer())
			&& "1".equals(pro.getDigitizationPer()) && "1".equals(pro.getCollectionPer()) && "1".equals(pro.getSafePer())){
			return "1";
		}else{
			return "0";
		}
	}
	
	public static String RelicsBureauIsFull(MuseumDataProgressDto pro){
		if("1".equals(pro.getBasePer()) && "1".equals(pro.getPersonPer()) && "1".equals(pro.getDigitizationPer())){
			return "1";
		}else{
			return "0";
		}
	}
	public static String RelicsUnitIsFull(MuseumDataProgressDto pro){
		if("1".equals(pro.getBasePer())){
			return "1";
		}else{
			return "0";
		}
	}
	
	public static String RelicsBureauEquipmentIsFull(MuseumDataProgressDto pro){
		if("1".equals(pro.getDigitizationPer())){
			return "1";
		}else{
			return "0";
		}
	}
	
	public static Boolean isChanged(Object before,Object after,String[] objectThree) throws Exception{
    	Map<String,Object> oldMap = objectToMap(before);//数据库里面的旧数据
		Map<String,Object> subMap = objectToMap(after);//提交的数据
		List<String> strlist = Arrays.asList(objectThree);
		Boolean change = false;
		for(String enter:strlist){
			if(org.springframework.util.StringUtils.isEmpty(subMap.get(enter))){
				if(!org.springframework.util.StringUtils.isEmpty(oldMap.get(enter))){
					change =true;
					break;
				}
			}else{
				if(!subMap.get(enter).equals(oldMap.get(enter))){
					change =true;
					break;
				}
			}
        }
		return change;
    }
	
	public static Map<String, Object> objectToMap(Object obj) throws Exception { 
		
        if(obj == null){    
            return null;    
        }   
        Map<String, Object> map = new HashMap<String, Object>();    
  
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            map.put(field.getName(), field.get(obj));  
        }    
  
        return map;  
	}
	
	/** 
     * 两个时间之间相差距离多少天 或者多少小时
     * @param one 时间参数 1： 
     * @param two 时间参数 2： 
     * @return result
     */  
    public static String getDistanceDaysOrHours(Date date1, Date date2){  
        long days=0;  
        long hour=0;
        String result = "";
        long time1 = date1.getTime();  
        long time2 = date2.getTime();  
        long diff ;  
        if(time1<time2) {  
            diff = time2 - time1;  
        } else {  
            diff = time1 - time2;  
        }  
        days = diff / (1000 * 60 * 60 * 24);  
        if(days>0){
        	result = String.valueOf(days)+"天前";
        }else{
        	hour = diff / (60 * 60 * 1000);
        	if(hour>0){
        		result = String.valueOf(hour)+"小时前";
        	}else{
        		result = "1小时前";
        	}
        }
        return result;  
    } 
}
