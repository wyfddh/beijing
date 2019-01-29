package com.tj720.mip.springbeans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tj720.mip.inter.dao.ICacheDao;

@Component
public class GetBeanByConfig {
	
	@Autowired
	private Config config;
	@Resource(name="memoryCacheDao")
	private ICacheDao memoryCacheDao;
	@Resource(name="redisCacheDao")
	private ICacheDao redisCacheDao;
	
	public ICacheDao getCacheDao(){
		if( config.getRedisIp().trim().equals("") ){
			return memoryCacheDao;
		}else{
			return redisCacheDao;
		}
	}
}
