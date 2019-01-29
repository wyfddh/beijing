package com.tj720.admin.common.util;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.common.vo.TokenCode;
import com.tj720.admin.service.jedis.JedisService;

public class TokenCodeUtil {
	
	/**
	 * 生成tokenCode
	 * @param token
	 */
	public static String setTokenCode(TokenCode token){
		String tokenCode = null;
		if(StringUtils.isNotBlank(token.getUserId())){
			String key = MessageFormat.format(KeyConstants.USER_TOKEN_CODE_KEY, token.getUserId());
			
			//token码
			String value = JSONObject.toJSONString(token);
			tokenCode = CryptUtils.encode(value);
			JedisService.set(key, tokenCode, 30*60);//30分钟
		}
		return tokenCode;
	}
	
	/**
	 * 获取tokenCode
	 * @param token
	 */
	public static TokenCode getTokenCode(String token){
		TokenCode tokenCode = null;
		if(StringUtils.isNotBlank(token)){
			String jsonStr = CryptUtils.decode(token);
			tokenCode = JSONObject.parseObject(jsonStr, TokenCode.class);
		}
		return tokenCode;
	}
	
	public static void main(String[] args){
		TokenCode tokenCode = new TokenCode();
		tokenCode.setUserId("201704281008071114");
		System.out.println(setTokenCode(tokenCode));
	}
}
