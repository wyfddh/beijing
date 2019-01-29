package com.tj720.mip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;


/**
 * @date 2016-01-06
 */
@Entity
@Table(name="mip_thumbnail")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Thumbnail extends BaseModel implements Serializable,ILuceneDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pictureId;
	private String name;//名称
	private String url;//路径
	private String type;//类型
	private byte isMain;//主图
	
	@Column(name="parent_id")
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="is_main")
	public byte getIsMain() {
		return isMain;
	}
	public void setIsMain(byte isMain) {
		this.isMain = isMain;
	}
	
	
	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}