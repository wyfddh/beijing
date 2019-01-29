/** 
 * <pre>项目名称:mip 
 * 文件名称:MipJiLinArticle.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年3月28日上午11:12:41 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipJiLinArticle    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 上午11:12:41    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 上午11:12:41    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_lishijilin_article")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipJiLinArticle extends BaseModel {
	private Integer articleCategory = 0;//文章类目
	private String headline;//标题
	private String pictureId;//图片表的外键
	private String userId;//用户的外键
	private String content;//内容
	private Long publishTime;//发布时间
	private byte publish = -127;//发布状态
	private Integer orgId;//博物馆的外键
	private Integer clickCounts=0;//点击次数
	
	
	
	//业务字段
	private String staTime = "";
	private String overTime = "";
	private String musExhibition;
	private String issemTime;
	private String pictureThumb;
	private String nickName;
	private String categoryName;
	private String publishDate;
	
	
	@Transient
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	@Transient
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Transient
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Transient
	public String getPictureThumb() {
		return pictureThumb;
	}
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}
	@Transient
	public String getIssemTime() {
		return issemTime;
	}
	public void setIssemTime(String issemTime) {
		this.issemTime = issemTime;
	}
	
	
	@Transient
	public String getStaTime() {
		return staTime;
	}
	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}
	@Transient
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	@Transient
	public String getMusExhibition() {
		return musExhibition;
	}
	public void setMusExhibition(String musExhibition) {
		this.musExhibition = musExhibition;
	}
	@Column(name="article_category")
	public Integer getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(Integer articleCategory) {
		this.articleCategory = articleCategory;
	}
	@Column(name="headline")
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	@Column(name="picture_id")
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	@Column(name="org_id")
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	@Column(name="click_counts")
	public Integer getClickCounts() {
		return clickCounts;
	}
	public void setClickCounts(Integer clickCounts) {
		this.clickCounts = clickCounts;
	}
	/**    
	 * <pre>创建一个新的实例 MipJiLinArticle.    
	 *    
	 * @param articleCategory
	 * @param headline
	 * @param pictureId
	 * @param userId
	 * @param content
	 * @param publishTime
	 * @param publish
	 * @param orgId</pre>    
	 */
	public MipJiLinArticle(Integer articleCategory, String headline, String pictureId, String userId, String content,
			Long publishTime, byte publish, Integer orgId) {
		super();
		this.articleCategory = articleCategory;
		this.headline = headline;
		this.pictureId = pictureId;
		this.userId = userId;
		this.content = content;
		this.publishTime = publishTime;
		this.publish = publish;
		this.orgId = orgId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MipJiLinArticle.    
	 *    </pre>    
	 */
	public MipJiLinArticle() {
		super();
	}
	
	
	
}
