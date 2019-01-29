/**
 * 
 */
package com.tj720.admin.common.util;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.service.jedis.JedisService;


/**
 *  主键生成工具类
 *  <p> Title:GeneratorKey </p>
 *  <p> Description:  </p>
 *  <p> Company: tj720 </p>
 *  @author zwp
 *  @date 2017年7月28日 上午9:32:43
 */
public class GeneratorKey {
	// 邀请码缓存key值
//	public static final String CACHE_KEY_INVITATIONKEY_CODE = "up_cache_invitation_code"; 
	
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };
	
	/**
	 * 生成主键Code
	 * </p>
	 * @param key
	 * 					主键key值
	 * @param initValue
	 * 					对应主键的初始值，只在创建key时需要，以后每次累加,默认值为1
	 * @return
	 */
	public static final String generatorIDCodeByCache(String key, String initValue){
		if(StringUtils.isBlank(key)){
			return null;
		}
		String idCode = null;
		if(JedisService.isExist(key)){
			// key存在
			idCode = JedisService.get(key);
			if(idCode.compareTo("9999") >= 0){
				JedisService.set(key, Constants.CACHE_KEY_GLOE_INIT_VALUE, 0);
				idCode = Constants.CACHE_KEY_GLOE_INIT_VALUE;
			} else {
				JedisService.incr(key);
				idCode = (Integer.parseInt(idCode) + 1) + "";
			}
		} else {
			// key不存在
	        if(StringUtils.isBlank(initValue)){
	            initValue = Constants.CACHE_KEY_GLOE_INIT_VALUE;
	        }
	        JedisService.set(key, initValue);
			idCode = initValue;
		}
		return idCode;
	}
	
	
	/**
	 * 生成8位邀请码
	 * </p>
	 * @return
	 */
	public static final String generatorInviteCode(){
		StringBuffer shortBuffer = new StringBuffer();
	    String uuid = UUID.randomUUID().toString().replace("-", "");
	    for (int i = 0; i < 8; i++) {
	        String str = uuid.substring(i * 4, i * 4 + 4);
	        int x = Integer.parseInt(str, 16);
	        shortBuffer.append(chars[x % 0x3E]);
	    }
	    return shortBuffer.toString();
	}
	
	
	
	// 产生后台管理系统UUID主键
	public static final String generatorAdminMSKey(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static void main(String[] args) {
	     System.out.println(System.currentTimeMillis());
	}
}