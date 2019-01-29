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
@Table(name="mip_audio")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipAudio extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name = "";//名称
	private String description = "";//备注
	private byte type;//类型
	private byte isOpen;//公开
	private String url ="";//音频地址
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="type")
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	@Column(name="is_open")
	public byte getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(byte isOpen) {
		this.isOpen = isOpen;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
