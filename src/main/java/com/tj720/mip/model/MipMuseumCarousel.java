package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipCarousel    
 * 类描述：    
 * 创建人：Dengyn
 * 创建时间：2017年3月20日 下午16:48:20    
 * 修改人：Dengyn
 * 修改时间：2017年3月20日 下午16:48:20  
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name = "mip_museum_carousel")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipMuseumCarousel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String museumInfoId;
	private String title;
	private String url;
	private String pictureid;
	private String uid;
	private String updateTime;
	
	
	//业务字段
	private String backUrl;//返回前台的url
	
	@Transient
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	
	
	
	@Column(name = "museum_info_id")
	public String getMuseumInfoId() {
		return museumInfoId;
	}
	public void setMuseumInfoId(String museumInfoId) {
		this.museumInfoId = museumInfoId;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name = "picture_id")
	public String getPictureid() {
		return pictureid;
	}
	public void setPictureid(String pictureid) {
		this.pictureid = pictureid;
	}
	@Column(name = "uid")
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Column(name = "updateTime")
	public String getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	//前台展示的数据
	public MipMuseumCarousel(String museumInfoId, String title,String url,String uid,String pictureid,String updateTime) {
		super();
		this.museumInfoId = museumInfoId;
		this.title = title;
		this.url = url;
		this.uid = uid;
		this.pictureid = pictureid;
		this.updateTime = updateTime;
	}
	   
	public MipMuseumCarousel() {
		super();
	}
	public MipMuseumCarousel(String id,String pictureid,String url) {
		super();
		this.id = id;
		this.pictureid = pictureid;
		this.url = url;
	}
	public MipMuseumCarousel(String pictureid) {
		super();
		this.pictureid = pictureid;
	}
	
	
}
