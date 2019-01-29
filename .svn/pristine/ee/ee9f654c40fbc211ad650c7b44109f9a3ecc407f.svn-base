package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.enumeration.ProjectType;
import com.tj720.mip.framework.SpringContextHolder;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.service.tool.CacheService;
import com.tj720.mip.utils.GetTextFromFile;
import com.tj720.mip.utils.MyString;


/**
 * @date 2016-01-06
 */
@Entity
@Table(name="mip_collection_category")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class CollectionCategory extends BaseModel implements Serializable,ILuceneDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name="";//名称
	private String shortName="";//简称
	private String type="";//所属类型
	private int fcCounts;//一普表此类型数据有多少条
	private int openCounts;//公开表此类型数据有多少条
	
	public CollectionCategory(){}
	
	public CollectionCategory(String id, String createTime, byte status, int sequence, String name, int fcCounts, int openCounts) {
		this.id = id;
		this.createTime = createTime;
		this.status = status;
		this.sequence = sequence;
		this.name = name;
		this.fcCounts = fcCounts;
		this.openCounts = openCounts;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="fc_counts")
	public int getFcCounts() {
		return fcCounts;
	}
	public void setFcCounts(int fcCounts) {
		this.fcCounts = fcCounts;
	}

	@Column(name="open_counts")
	public int getOpenCounts() {
		return openCounts;
	}
	public void setOpenCounts(int openCounts) {
		this.openCounts = openCounts;
	}
	
	@Column(name = "short_name")
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}