/** 
 * <pre>项目名称:mip 
 * 文件名称:AreaOrag.java 
 * 包名:com.tj720.mip.dto 
 * 创建日期:2017年2月23日下午8:20:20 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import com.tj720.mip.utils.MyString;

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
public class TjCityDto {
	private String cityId;
	private String name;
	private int oragCount=0;
	private int selected=0;
	private List<TjOrgDto> orgs=new ArrayList<TjOrgDto>();

	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOragCount() {
		return oragCount;
	}
	public void setOragCount(int oragCount) {
		this.oragCount = oragCount;
	}
	public List<TjOrgDto> getOrgs() {
		return orgs;
	}
	public void setOrgs(List<TjOrgDto> orgs) {
		this.orgs = orgs;
	}
	
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	@Transient
	public String getOrgIds(){
		StringBuffer result=new StringBuffer();
		if(!MyString.isEmpty(orgs)){
			for(TjOrgDto org:orgs){
				result.append(","+org.getOrgId());
			}
			result.deleteCharAt(0);
		}
		return result.toString();
	}
	/**    
	 * <pre>创建一个新的实例 AreaOrag.    
	 *    
	 * @param areaId
	 * @param areaName
	 * @param oragId
	 * @param oragName
	 * @param oragCount</pre>    
	 */
	public TjCityDto(String cityId, String name, int oragCount) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.oragCount = oragCount;
	}
	   
	public TjCityDto(String cityId, String name) {
		super();
		this.cityId = cityId;
		this.name = name;
	}
	/**    
	 * <pre>创建一个新的实例 AreaOrag.    
	 *    </pre>    
	 */
	public TjCityDto() {
		super();
	} 
	
}
