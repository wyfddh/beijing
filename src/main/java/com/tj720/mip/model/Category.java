/** 
 * <pre>项目名称:mip 
 * 文件名称:Category.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年3月7日下午7:23:32 
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
 * 类名称：Category    
 * 类描述：    类别
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月7日 下午7:23:32    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月7日 下午7:23:32    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_museum_type")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Category extends BaseModel implements Serializable{
	private String categoryName;
	private Integer orgId;
	@Column(name="category_name")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Column(name="org_id")
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 Category.    
	 *    
	 * @param categoryName
	 * @param orgId</pre>    
	 */
	public Category(String categoryName, Integer orgId,String id) {
		super();
		this.categoryName = categoryName;
		this.orgId = orgId;
		this.id = id;
	}
	   
	/**    
	 * <pre>创建一个新的实例 Category.    
	 *    </pre>    
	 */
	public Category() {
		super();
	}
	
	
}	
