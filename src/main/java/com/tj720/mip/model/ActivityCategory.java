/** 
 * <pre>项目名称:mip 
 * 文件名称:ActivityCategory.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年3月30日下午5:03:24 
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
 * 类名称：ActivityCategory    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月30日 下午5:03:24    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月30日 下午5:03:24    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_activity_category")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class ActivityCategory extends BaseModel {
	private String categoryName;

	@Column(name="category_name")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	   
	/**    
	 * <pre>创建一个新的实例 ArticleCategory.    
	 *    
	 * @param categoryName</pre>    
	 */
	public ActivityCategory(String id,String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	   
	/**    
	 * <pre>创建一个新的实例 ArticleCategory.    
	 *    </pre>    
	 */
	public ActivityCategory() {
		super();
	}
	
}
