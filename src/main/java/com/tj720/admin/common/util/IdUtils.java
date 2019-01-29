package com.tj720.admin.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;


public class IdUtils {
	static int id = 1000;
	/**
	 * id生成，传一个策略String
	 * @param className : 对象名称
	 * @return String id
	 */
    public static String nextId(String className){
    	synchronized(IdUtils.class){
    		String idCodeByCache = "";
    		//特殊时期redis端口会被禁用,如果被禁用则直接用内存缓存
    		if(StringUtils.isNotBlank(FileUtil.getConfigValue("redis.host"))) {
    			idCodeByCache = GeneratorKey.generatorIDCodeByCache(className, null);
    		} else {
    			id = id > 9999 ? 1000 : id;
        		id++;
        		idCodeByCache = id + "";
    		}
	        String curDateTime = TimeUtil.GetCurDateTime();
	        return curDateTime + idCodeByCache;
    	}
    }
    
    /**
	 * id生成，传一个策略String
	 * @param t : 对象
	 * @return String id
	 */
    public static String nextId(Object o){
    	synchronized(IdUtils.class){
    		String idCodeByCache = "";
    		//特殊时期redis端口会被禁用,如果被禁用则直接用内存缓存
    		if(StringUtils.isNotBlank(FileUtil.getConfigValue("redis.host"))) {
    			String className = o.getClass().getName();
    			idCodeByCache = GeneratorKey.generatorIDCodeByCache(className, null);
    		} else {
    			id = id > 9999 ? 1000 : id;
        		id++;
        		idCodeByCache = id + "";
    		}
	        String curDateTime = TimeUtil.GetCurDateTime();
	        return curDateTime + idCodeByCache;
    	}
    }
}
