/** 
 * <pre>项目名称:mip 
 * 文件名称:City.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月17日上午10:58:52 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;

/** 
 * <pre>项目名称：mip    
 * 类名称：City    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月17日 上午10:58:52    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月17日 上午10:58:52    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_city")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class City extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;//名称
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
