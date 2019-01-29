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
public class CityMuseum {
	private String cityName;
	private int cityOrder=0;
	private List<Museum> museum=new ArrayList();
	private Integer museumCount;
	
	
	
	public Integer getMuseumCount() {
		return museumCount;
	}
	public void setMuseumCount(Integer museumCount) {
		this.museumCount = museumCount;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCityOrder() {
		return cityOrder;
	}
	public void setCityOrder(int cityOrder) {
		this.cityOrder = cityOrder;
	}
	public List<Museum> getMuseum() {
		return museum;
	}
	public void setMuseum(List<Museum> museum) {
		this.museum = museum;
	}
	   
	/**    
	 * <pre>创建一个新的实例 CityMuseum.    
	 *    
	 * @param cityName
	 * @param cityOrder
	 * @param museum</pre>    
	 */
	public CityMuseum(String cityName) {
		super();
		this.cityName = cityName;
	}
	public CityMuseum(List<Museum> museum) {
		super();
		this.museum = museum;
	}
	   
	/**    
	 * <pre>创建一个新的实例 CityMuseum.    
	 *    </pre>    
	 */
	public CityMuseum() {
		super();
	}
	
}
