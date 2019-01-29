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

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;

@Entity
@Table(name="mip_audio_like")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipAudioLike extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String audioId;
	
	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name = "audio_id")
	public String getAudioId() {
		return audioId;
	}
	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}
	
	

}
