package com.tj720.admin.common.vo;

import java.io.Serializable;

/**
*
* @author:zwp
* @date:2017年6月20日 下午12:18:12
*/
public class ConditionVo<T> implements Serializable{

	private static final long serialVersionUID = -2867242574505146737L;
	
	private String order;
	/**
	 * 实体
	 */
	private T domain;
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public T getDomain() {
		return domain;
	}
	public void setDomain(T domain) {
		this.domain = domain;
	}
	
	
}
