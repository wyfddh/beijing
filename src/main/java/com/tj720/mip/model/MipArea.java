/** 
 * <pre>项目名称:mip 
 * 文件名称:Area.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年2月23日下午3:48:20 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：Area    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午3:48:20    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午3:48:20    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name = "mip_area")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipArea  extends BaseModel implements Serializable {
	private Integer pid;//父id--市级
	private String shortname;//简称
	private String name;//名称
	private String mergerName;//全称
	private byte level;//层级
	private String pinyin;//拼音
	private String code;//长途区号
	private String zipCode;//邮编
	private String first;//首字母
	private String lng;//经度
	private String lat;//纬度
	@Column(name = "pid")
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Column(name = "shortname")
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "merger_name")
	public String getMergerName() {
		return mergerName;
	}
	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}
	@Column(name = "level")
	public byte getLevel() {
		return level;
	}
	public void setLevel(byte level) {
		this.level = level;
	}
	@Column(name = "pinyin")
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	@Column(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "zip_code")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "first")
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	@Column(name = "lng")
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Column(name = "lat")
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	   
	//前台展示的数据
	public MipArea(Integer pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	   
	public MipArea() {
		super();
	}
	//前台展示的详情数据
	public MipArea(String name) {
		super();
		this.name = name;
	}
	public MipArea(String id, String shortname) {
		this.id = id;
		this.shortname = shortname;
	}
	
	public MipArea(String id, Integer pid, String name) {
		this.id = id;
		this.pid = pid;
		this.name = name;
	}
	
	
	
}
