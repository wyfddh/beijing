package com.tj720.admin.common.vo;

/**
 * 
 * @author zwp
 * @date 2017年6月20日 下午12:16:38
 * @param <T>
 */
public class PageVo<T> {
	
	/**
	 * 起始页
	 */
	private int start;
	
	/**
	 * 页面大小
	 */
	private int limit;
	
	/**
	 * 实体
	 */
	private T domain;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public T getDomain() {
		return domain;
	}

	public void setDomain(T domain) {
		this.domain = domain;
	}

	
	
	
	
}
