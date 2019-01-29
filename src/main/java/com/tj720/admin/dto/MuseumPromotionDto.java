package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

/**
 * 宣传Entity
 * @author chenshiya
 * @version 2018-05-25
 */
public class MuseumPromotionDto extends BaseVO {

	private String museumId;		// 博物馆id
	private String broadcast;		// 广播(1:有；0：无)
	private String tv;		// 电视(1:有0：无)
	private String newspaper;		// 报刊(1:有0：无)
	private String wechat;		// 微信（1：有0：无）
	private String weibo;		// 微博(1：有0：无)
	private String app;		// app(1:有0：无)
	private String applets;		// 小程序（1：有0：无）
	private String website;		// 网站
	private String other;		// 其他（1：有0：无）
	private String otherDetail;		// 其他详细


	public String getMuseumId() {
		return museumId;
	}

	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	
	public String getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}
	
	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}
	
	public String getNewspaper() {
		return newspaper;
	}

	public void setNewspaper(String newspaper) {
		this.newspaper = newspaper;
	}
	
	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
	public String getApplets() {
		return applets;
	}

	public void setApplets(String applets) {
		this.applets = applets;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	public String getOtherDetail() {
		return otherDetail;
	}

	public void setOtherDetail(String otherDetail) {
		this.otherDetail = otherDetail;
	}
	
}