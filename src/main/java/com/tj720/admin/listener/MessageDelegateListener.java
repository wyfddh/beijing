package com.tj720.admin.listener;

import java.io.Serializable;


/**
 * 订阅redis消息接口
 *  <p> Title:MessageDelegateListener </p>
 *  <p> Description:  </p>
 *  <p> Company: tj720 </p>
 *  @author zwp
 *  @date 2017年8月11日 下午5:13:49
 */
public interface MessageDelegateListener {
	
	/**
	 * 图片传输消息
	 * @param message
	 */
	public void adminTranslateImg(Serializable message);
	
}
