/** 
 * <pre>项目名称:mip 
 * 文件名称:Muimage.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月17日上午11:00:33 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;


/** 
 * <pre>项目名称：mip    
 * 类名称：Muimage    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月17日 上午11:00:33    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月17日 上午11:00:33    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_muimage")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MuImage extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String imageName;
	private String muid;
	
	
	
	

	@Column(name="imageName")
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**    
	 * <pre>创建一个新的实例 MuImage.    
	 *    </pre>    
	 */
	public MuImage() {
		super();
	}
	@Column(name="muid")
	public String getMuid() {
		return muid;
	}

	public void setMuid(String muid) {
		this.muid = muid;
	}
	

	/**    
	 * <pre>创建一个新的实例 MuImage.    
	 *    
	 * @param id
	 * @param imageName
	 * @param muid</pre>    
	 */
	public MuImage(String imageName, String muid) {
		super();
		this.imageName = imageName;
		this.muid = muid;
	}

	
	
	
	
}
