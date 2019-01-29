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
public class AreaOrag {
	private String areaId;
	private String areaName;
	private String oragId;
	private String oragName;
	private int oragCount;
	private byte open;
	
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getOragId() {
		return oragId;
	}
	public void setOragId(String oragId) {
		this.oragId = oragId;
	}
	public String getOragName() {
		return oragName;
	}
	public void setOragName(String oragName) {
		this.oragName = oragName;
	}
	public int getOragCount() {
		return oragCount;
	}
	public void setOragCount(int oragCount) {
		this.oragCount = oragCount;
	}
	
	public byte getOpen() {
		return open;
	}
	public void setOpen(byte open) {
		this.open = open;
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
	public AreaOrag(String areaId, String areaName, String oragId, String oragName, int oragCount, byte open) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.oragId = oragId;
		this.oragName = oragName;
		this.oragCount = oragCount;
		this.open=open;
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
	public AreaOrag(String areaId, String areaName, String oragId, String oragName, int oragCount) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.oragId = oragId;
		this.oragName = oragName;
		this.oragCount = oragCount;
		this.open=open;
	}
	/**    
	 * <pre>创建一个新的实例 AreaOrag.    
	 *    </pre>    
	 */
	public AreaOrag() {
		super();
	} 
	
}
