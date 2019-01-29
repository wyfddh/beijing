package com.tj720.admin.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static final String SECRET_KEY = "882F6147AFC1D200";
	//6379
	private static int timeOut = 1000;
	private static int dataBase = 0;
	private static JedisPool pool = null;  
	//6378
	private static int shareTimeOut = 1000;
	private static int shareDataBase = 0;
	private static JedisPool sharePool = null;
	//6377
	private static int masterTimeOut = 1000;
	private static int masterDataBase = 0;
	private static JedisPool masterPool = null;  
    
	private RedisUtil(){}
	
	
   
    /** 
     * 构建redis连接池 
     *  
     * @param ip 
     * @param port 
     * @return JedisPool 
     */  
    public static JedisPool getPool() {  
        if (pool == null) {  
            JedisPoolConfig config = new JedisPoolConfig();  
            //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；  
            config.setMaxIdle(1024); 
            config.setMaxTotal(1024);
            config.setMinIdle(20);
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
            config.setMaxWaitMillis(1000 * 10);  
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
            config.setTestOnBorrow(true);
            String masterUrl = FileUtil.getConfigValue("redis.host");
			String masterPort = FileUtil.getConfigValue("redis.port");
			String password = FileUtil.getConfigValue("redis.password");
			//System.out.println("masterUrl=" + masterUrl + "***masterPort=" + masterPort + "****password=" + password);
            pool = new JedisPool(config, masterUrl, Integer.parseInt(masterPort), timeOut, password, dataBase);  
        }  
        return pool;  
    }
    
   
    
    /** 
     * 返还到连接池 
     *  
     * @param pool  
     * @param redis 
     */  
    public static void returnResource(JedisPool pool, Jedis redis) {  
        if (redis != null && pool != null) {  
            pool.returnResource(redis);
        }  
    } 
    
    /** 
     * 返还到连接池 
     *  
     * @param pool  
     * @param redis 
     */  
    public static void returnShareResource(JedisPool pool, Jedis redis) {  
        if (redis != null && sharePool != null) {   
            sharePool.returnResource(redis);
        }  
    }  
}
