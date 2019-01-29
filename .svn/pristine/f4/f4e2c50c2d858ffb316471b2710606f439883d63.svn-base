package com.tj720.admin.timer;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tj720.admin.service.jedis.JedisService;

/**
 * 
 *  <p> Title:Timer </p>
 *  <p> Description:  </p>
 *  <p> Company: tj720 </p>
 *  @author zwp
 *  @date 2017年7月30日 下午12:06:25
 */
@Component
public class Timer {
	
	Logger logger = Logger.getLogger(Timer.class);
	private static boolean isStar = false;
	private static String KEY = "__key*__:*";
	
	/**
	 * 启动redis缓存可以到期触发事件
	 * </p>
	 */
	@Scheduled(fixedDelay= 60 * 24 * 60 * 60 *1000) 
	public void starRedisKeyExpiredListener() {
		try {
			if(!isStar){
				JedisService.psubscribe(KEY);
				isStar = true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	

}
