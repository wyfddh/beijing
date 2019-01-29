/** 
 * <pre>项目名称:mip 
 * 文件名称:CarouselDto.java 
 * 包名:com.tj720.mip.dto 
 * 创建日期:2017年3月22日下午6:48:44 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dto;

import java.util.List;

import com.tj720.mip.model.Picture;

/** 
 * <pre>项目名称：mip    
 * 类名称：CarouselDto    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月22日 下午6:48:44    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月22日 下午6:48:44    
 * 修改备注：       
 * @version </pre>    
 */
public class CarouselDto {
	private String name;
	private Picture pic;
	private String url;
	   
	/**    
	 * <pre>创建一个新的实例 CarouselDto.    
	 *    
	 * @param name
	 * @param pic
	 * @param url</pre>    
	 */
	public CarouselDto(String name, Picture pic, String url) {
		super();
		this.name = name;
		this.pic = pic;
		this.url = url;
	}

	   
	/**    
	 * <pre>创建一个新的实例 CarouselDto.    
	 *    </pre>    
	 */
	public CarouselDto() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Picture getPic() {
		return pic;
	}


	public void setPic(Picture pic) {
		this.pic = pic;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
}
