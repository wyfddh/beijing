package com.tj720.admin.dao.redis;

import java.util.List;
import java.util.Set;

import com.tj720.admin.common.constant.RedisUtil;
import com.tj720.admin.listener.RedisKeyExpiredListener;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisDao {

	public static boolean isExist(String key) {
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource();  
            return jedis.exists(key);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
		return false;
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
		JedisPool pool = null;  
		Jedis jedis = null;  
		try {
			pool = RedisUtil.getPool();  
			jedis = pool.getResource();  
			List<String> lranges = jedis.lrange(key, 0, -1);
			return lranges;
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();  
		} finally {
			//返还到连接池  
			RedisUtil.returnResource(pool, jedis);  
		}
		return null;
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
		JedisPool pool = null;  
		Jedis jedis = null;  
		try {
			pool = RedisUtil.getPool();  
			jedis = pool.getResource();  
			return jedis.lindex(key, index);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();  
		} finally {
			//返还到连接池  
			RedisUtil.returnResource(pool, jedis);  
		}
		return null;
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
		JedisPool pool = null;  
		Jedis jedis = null;  
		try {
			pool = RedisUtil.getPool();  
			jedis = pool.getResource();  
			List<String> lranges = jedis.lrange(key, start, end);
			return lranges;
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();  
		} finally {
			//返还到连接池  
			RedisUtil.returnResource(pool, jedis);  
		}
		return null;
	}
	
	
	/**
	 * 获取指定key中list集合的长度的长度，要求key对应的value是一个list集合
	 * </p>
	 * @param key
	 * @return
	 */
	public static long llen(String key){
		JedisPool pool = null;  
		Jedis jedis = null;  
		try {  
			pool = RedisUtil.getPool();  
			jedis = pool.getResource(); 
			return jedis.llen(key);
		} catch (Exception e) {  
			//释放redis对象  
			if(pool != null){
				pool.returnBrokenResource(jedis);  
			}
			e.printStackTrace();  
		} finally {  
			//返还到连接池  
			RedisUtil.returnResource(pool, jedis);  
		}  
		return 0;
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
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {
        	pool = RedisUtil.getPool();  
            jedis = pool.getResource();  
	         return jedis.rpush(key, value);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
		} finally {
			 //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
		}
        return 0;
	}
	
	
	/**
	 * 根据key键递增value的值
	 * @param key
	 * @return
	 */
	public static long incr(String key){
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource(); 
            return jedis.incr(key);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
		return 0;
	}
	/**
	 * 根据key设置value值
	 * @param key 键
	 * @param value 值
	 */
	public static void set(String key, String value){
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource();  
            jedis.set(key, value);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
	}
	/**
	 * 根据key设置value值并设置一定的期限
	 * @param key 键
	 * @param value 值
	 * @param expireSencond 过期期限（单位：s）
	 */
	public static void set(String key, String value, int expireSencond){
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource();  
            jedis.set(key, value);
    		jedis.expire(key, expireSencond);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
	}
	/**
	 * 通过key获取value值
	 * @param key 键
	 * @return
	 */
	public static String get(String key){
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource();  
            return jedis.get(key);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
		return null;
	}
	
	/**
	 * 删除缓存
	 * @param nice
	 * @return
	 */
	public static boolean removeByKey(String key){
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource();  
    		if(jedis.exists(key)){
    			jedis.del(key);
    		}
    		return true;
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
        return false;
	}
	
	/**
	 * 集合添加
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	public static Long zadd(String key, Double score, String member) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			return jedis.zadd(key, score, member);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}
		return 0l;
	}
	
	/**
	 * 通过member获取score
	 * @param key
	 * @param member
	 * @return
	 */
	public static String zscore(String key, String member) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			Double zscore = jedis.zscore(key, member);
			if (zscore == null) {
				return "0";
			}
			return zscore.toString();
			//return jedis.zscore(key, member).toString();
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}
		return "";
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
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			return jedis.zrangeByLex(key, min, max, offset, count);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}
		return null;
	}
	/**
	 * 按升序取前三个排名  zrange key 0 2 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Set<String> zrange(String key, Integer start, long end) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			return jedis.zrange(key, start, end);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}
		return null;
	}
	
	/**
	 * 按降序取前三个排名  zrevrange key 0 2 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Set<String> zrevrange(String key, Integer start, long end) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			return jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}
		return null;
	}
	
	public static void main(String[] args) {
		Set<String> sets = zrevrange("salary", 0, -1);
		for(String s : sets) {
			System.out.println(s);
		}
	}
	/**
	 * key值有效期过期监听
	 * @param key
	 * @param curationService 
	 */
	public static void psubscribe(String key) {
		JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = RedisUtil.getPool();  
            jedis = pool.getResource();
            jedis.psubscribe(new RedisKeyExpiredListener(), key);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
        return ;
	}
	public static Long del(String key) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			return jedis.del(key);
		} catch (Exception e) {
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}
		return -1L;
	}
}
