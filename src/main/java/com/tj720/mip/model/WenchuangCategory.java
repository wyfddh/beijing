/** 
 * <pre>项目名称:mip 
 * 文件名称:WenchunagCategory.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年3月29日下午7:35:59 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：WenchunagCategory    
 * 类描述：    文创类别
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月29日 下午7:35:59    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月29日 下午7:35:59    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_wenchuang_category")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class WenchuangCategory extends BaseModel {
	private String categoryName;

	@Column(name="category_name")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	   
	/**    
	 * <pre>创建一个新的实例 WenchuangCategory.    
	 *    
	 * @param categoryName</pre>    
	 */
	public WenchuangCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	   
	/**    
	 * <pre>创建一个新的实例 WenchuangCategory.    
	 *    </pre>    
	 */
	public WenchuangCategory() {
		super();
	}

	

	   
	
	
}
