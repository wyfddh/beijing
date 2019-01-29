/** 
 * <pre>项目名称:mip 
 * 文件名称:MipWenchuang.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年3月28日下午4:27:34 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipWenchuang    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 下午4:27:34    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 下午4:27:34    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_wenchuang")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipWenchuang extends BaseModel {
	private Integer categoryId = 0;//类别表外键
	private BigDecimal productPrice;//价钱
	private String userId;//用户外键
	private String pictureId;//图片 表外键
	private String content;//介绍
	private Long publishTime;//发布时间
	private byte publish = -1;//发布状态
	private String productNumber;//产品编号
	private String productName;//产品名称
	private String designElements;//设计元素
	private Integer orgId;//所属博物馆
	private String  message;
	
	
	//业务字段
	private String staPrice = "";
	private String overPrice = "";
	private String musExhibition;
	private String issemTime;
	private String pictureThumb;
	private String nickName;
	private String categoryName;
	private String price;	
	
		
		
		
		
		
		
		
		
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Transient
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Transient
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Transient
	public String getStaPrice() {
		return staPrice;
	}
	public void setStaPrice(String staPrice) {
		this.staPrice = staPrice;
	}
	@Transient
	public String getOverPrice() {
		return overPrice;
	}
	public void setOverPrice(String overPrice) {
		this.overPrice = overPrice;
	}
	@Transient
	public String getMusExhibition() {
		return musExhibition;
	}
	public void setMusExhibition(String musExhibition) {
		this.musExhibition = musExhibition;
	}
	@Transient
	public String getIssemTime() {
		return issemTime;
	}
	public void setIssemTime(String issemTime) {
		this.issemTime = issemTime;
	}
	@Transient
	public String getPictureThumb() {
		return pictureThumb;
	}
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}
	@Transient
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
	
	@Column(name="category_id")
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name="product_price")
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="picture_id")
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="publish_time")
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	@Column(name="publish")
	public byte getPublish() {
		return publish;
	}
	public void setPublish(byte publish) {
		this.publish = publish;
	}
	@Column(name="product_number")
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	@Column(name="product_name")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name="design_elements")
	public String getDesignElements() {
		return designElements;
	}
	public void setDesignElements(String designElements) {
		this.designElements = designElements;
	}
	@Column(name="org_id")
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MipWenchuang.    
	 *    
	 * @param categoryId
	 * @param productPrice
	 * @param userId
	 * @param pictureId
	 * @param content
	 * @param publishTime
	 * @param publish
	 * @param productNumber
	 * @param productName
	 * @param designElements
	 * @param orgId</pre>    
	 */
	public MipWenchuang(Integer categoryId, BigDecimal productPrice, String userId, String pictureId, String content,
			Long publishTime, byte publish, String productNumber, String productName, String designElements,
			Integer orgId) {
		super();
		this.categoryId = categoryId;
		this.productPrice = productPrice;
		this.userId = userId;
		this.pictureId = pictureId;
		this.content = content;
		this.publishTime = publishTime;
		this.publish = publish;
		this.productNumber = productNumber;
		this.productName = productName;
		this.designElements = designElements;
		this.orgId = orgId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MipWenchuang.    
	 *    </pre>    
	 */
	public MipWenchuang() {
		super();
	}
	
	
	
	
}
