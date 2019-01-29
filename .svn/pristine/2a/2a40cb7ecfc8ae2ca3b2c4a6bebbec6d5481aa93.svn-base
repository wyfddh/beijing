package com.tj720.admin.service.jedis;

import java.util.List;
import java.util.Set;

import com.tj720.admin.dao.redis.JedisDao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author zwp
 * @date 2017年6月20日 上午11:47:52
 */
public class JedisService {
	
	/**
	 * 判断是否存在这个key值
	 * @param key
	 * @return
	 */
	public static boolean isExist(String key){
		return JedisDao.isExist(key);
	}
	
	/**
	 * 根据key键递增value的值
	 * @param key
	 * @return
	 */
	public static long incr(String key){
		return JedisDao.incr(key);
	}
	/**
	 * 根据key设置value值
	 * @param key 键
	 * @param value 值
	 */
	public static void set(String key, String value){
		JedisDao.set(key, value);
	}
	/**
	 * 根据key设置value值并设置一定的期限
	 * @param key 键
	 * @param value 值
	 * @param expireSencond 过期期限（单位：s）
	 */
	public static void set(String key, String value, int expireSencond){
		JedisDao.set(key, value, expireSencond);
	}
	/**
	 * 通过key获取value值
	 * @param key 键
	 * @return
	 */
	public static String get(String key){
		return JedisDao.get(key);
	}
	
	/**
	 * 删除缓存
	 * @param nice
	 * @return
	 */
	public static boolean removeByKey(String key){
		return JedisDao.removeByKey(key);
	}
	
	/**
	 * 获取队列中所有的数据
	 * </p>
	 * @param key
	 * 					缓存键
	 * @param value
	 * 					值
	 * @return
	 */
	public static List<String> lrange(String key){
		return JedisDao.lrange(key);
	}
	/**
	 * 根据索引获取值
	 * </p>
	 * @param key
	 * 					缓存键
	 * @param value
	 * 					值
	 * @return
	 */
	public static String index(String key,long index){
		return JedisDao.index(key, index);
	}
	/**
	 * 获取队列中指定范围内的数据
	 * </p>
	 * @param key
	 * 					缓存键
	 * @param value
	 * 					值
	 * @return
	 */
	public static List<String> lrange(String key,int start,int end){
		return JedisDao.lrange(key);
	}
	
	
	/**
	 * 获取指定key中list集合的长度的长度，要求key对应的value是一个list集合
	 * </p>
	 * @param key
	 * @return
	 */
	public static long llen(String key){
		return JedisDao.llen(key);
	}
	
	/**
	 * 将数据添加到缓存的指定集合中
	 * </p>
	 * @param key
	 * 					缓存键
	 * @param value
	 * 					值
	 * @return
	 */
	public static long add(String key, String value){
		return JedisDao.add(key, value);
	}
	
	/**
	 * 集合添加
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	public static Long zadd(String key, Double score, String member) {
		return JedisDao.zadd(key, score, member);
	}
	
	/**
	 * 通过member获取score
	 * @param key
	 * @param member
	 * @return
	 */
	public static String zscore(String key, String member) {
		return JedisDao.zscore(key, member);
	}
	
	/**
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return
	 */
	public static Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
		return JedisDao.zrangeByLex(key, min, max, offset, count);
	}
	/**
	 * 按升序取前三个排名  zrange key 0 2 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Set<String> zrange(String key, Integer start, long end) {
		return JedisDao.zrange(key, start, end);
	}
	/**
	 * 按降序取前三个排名  zrange key 0 2 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Set<String> zrevrange(String key, Integer start, long end) {
		return JedisDao.zrevrange(key, start, end);
	}
	/**
	 * key值有效期过期监听
	 * "__key*__:*"
	 * @param key
	 * @param curationService 
	 */
	public static void psubscribe(String key){
		JedisDao.psubscribe(key);
	}

	/**
	 * 删除key
	 * @param key
	 */
	public static Long del(String key) {
		return JedisDao.del(key);
	}
}

