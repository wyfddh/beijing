package com.tj720.admin.listener;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tj720.mip.model.MipOpenCollectionInfo;

/**
 * 订阅消息监听器
 *  <p> Title:MessageDelegateListenerImpl </p>
 *  <p> Description:  </p>
 *  <p> Company: tj720 </p>
 *  @author zwp
 *  @date 2017年8月11日 下午5:17:20
 */
public class MessageDelegateListenerImpl implements MessageDelegateListener {

    
	Logger logger = LoggerFactory.getLogger(MessageDelegateListener.class);

	/**
	 * 图片传输消息
	 */
	@Override
	public void adminTranslateImg(Serializable message) {
		if(message != null && message instanceof String) {
			System.out.println("############admin##############" + message.toString());
		}
		/*if (message != null && message instanceof ShopDiscussVo) {
			ShopDiscussVo shopDiscussVo = (ShopDiscussVo) message;
		} else {
		
			logger.error("the type is error when create new movie shop discuss in" + TimeUtil.GetCurDateTime());
		}*/
	}


}
