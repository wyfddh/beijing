package com.tj720.admin.listener;

import java.util.Date;

import com.github.pagehelper.StringUtil;
import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.utils.Aes;

import redis.clients.jedis.JedisPubSub;
/**
 * 
 * @author  zhou
 * @date 创建时间：2017年7月7日 下午6:37:42 
 * @version 2.0 
 * @parameter
 * @since  
 * @return
 */
public class RedisKeyExpiredListener extends JedisPubSub {

	
    public RedisKeyExpiredListener() {
		super();
	}

	@Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe " + pattern + " " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String key) {
    	//自己判断 key是否需要进行处理
        if(!key.startsWith("expire:")) return;
       
        //获取id
        int index = key.lastIndexOf(":");
        String id = key.substring(index + 1);
        //svae db
        if(key.startsWith(KeyConstants.USER_IP_TOKEN_CODE_KEY)) {
        	//更新用户token
        	reloadToken(key);
        }
        this.unsubscribe();
    }

    /**
     * 重新加载web端用户token
     */
    public void reloadToken(String key) {
    	String oldKey = key.replaceFirst(KeyConstants.USER_IP_TOKEN_CODE_KEY, "");
    	String userid = oldKey.split("##")[0];
    	String token = Aes.encrypt(userid+(new Date()).getTime());
		JedisService.set(key, token);
    }
}