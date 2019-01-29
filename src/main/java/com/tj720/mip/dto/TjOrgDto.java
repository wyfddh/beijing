/** 
 * <pre>项目名称:mip 
 * 文件名称:AreaOrag.java 
 * 包名:com.tj720.mip.dto 
 * 创建日期:2017年2月23日下午8:20:20 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dto;

/** 
 * <pre>项目名称：mip    
 * 类名称：AreaOrag    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午8:20:20    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午8:20:20    
 * 修改备注：       
 * @version </pre>    
 */
public class TjOrgDto {
	private String orgId;
	private String name;
	private String cityId;
	private int selected=0;

	   
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public TjOrgDto(String orgId, String name, String cityId) {
		super();
		this.orgId = orgId;
		this.name = name;
		this.cityId=cityId;
	}

	public TjOrgDto() {
		super();
	}
	
}
