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
@Table(name="mip_year_type")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class YearType extends BaseModel implements Serializable,ILuceneDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String parentId="";//父id
	private String code="";//编码
	private String name="";//名称
	private String fullname="";
	private String shortName="";
	private String path="";//节点结构
	private String pathJson="";
	private String pathName="";
	private int fcCounts;//一普表此类型数据有多少条
	private int openCounts;//公开表此类型数据有多少条
	
	
	public YearType(){}
	
	public YearType(String id, String parentId, String name, int fcCounts, int openCounts, String createTime, byte status,
			int sequence) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.fcCounts = fcCounts;
		this.openCounts = openCounts;
		this.createTime = createTime;
		this.status = status;
		this.sequence = sequence;
	}
	
	@Column(name = "parentId")
	public String getParentId() {
		return this.parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Column(name = "path", length = 256)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name = "path_json", length = 256)
	public String getPathJson() {
		return pathJson;
	}

	public void setPathJson(String pathJson) {
		this.pathJson = pathJson;
	}

	@Column(name = "path_name", length = 256)
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
	@Column(name="fullname")
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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