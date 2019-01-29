/** 
 * <pre>项目名称:mip 
 * 文件名称:City.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月17日上午10:58:52 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;

/** 
 * <pre>项目名称：mip    
 * 类名称：City    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月17日 上午10:58:52    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月17日 上午10:58:52    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_comment")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipComment extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String uid="";
	private String cid="";
	private String content="";
	private long publishTime;
	private String updateTime;
	
	//业务字段
	private String userName;//用户昵称
	private String publishTimeStr;//发布时间
	private String avatarUrl;//头像路径
	private String curName;//策展名称
	private Long totalComm;//评论数
	
	@Transient
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Transient
	public String getPublishTimeStr() {
		return publishTimeStr;
	}
	public void setPublishTimeStr(String publishTimeStr) {
		this.publishTimeStr = publishTimeStr;
	}
	@Transient
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	@Transient
	public String getCurName() {
		return curName;
	}
	public void setCurName(String curName) {
		this.curName = curName;
	}
	@Transient
	public Long getTotalComm() {
		return totalComm;
	}
	public void setTotalComm(Long totalComm) {
		this.totalComm = totalComm;
	}
	
	@Column(name="uid")
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Column(name="cid")
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="publish_time")
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	
	@Column(name="updated_time")
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
