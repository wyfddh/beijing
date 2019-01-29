package com.tj720.mip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;


/**
 * @date 2016-01-06
 */
@Entity
@Table(name="mip_picture")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Picture extends BaseModel implements Serializable,ILuceneDto{
	/**
	 * 111
	 */
	private static final long serialVersionUID = 1L;
	
	private String objectId="";//图片所属对象id
	private String typeId="";//对象类型（1、文物藏品，2、化石藏品，3、展览...）
	private String gsNo="";//普查编号gs_No
	private String name="";//名称
	private String url="";//路径
	private int picWidth;//图片宽
	private int picHeight;//图片高
	private byte type;//类型
	private byte isMain;//主图
	
	private String thumb1="";//缩略图1地址
	private int thumb1Width;//缩略图1宽
	private int thumb1Height;//缩略图1宽
	
	private String thumb2="";//缩略图2地址
	private int thumb2Width;//缩略图2宽
	private int thumb2Height;//缩略图2宽
	
	private String thumb3="";//缩略图3地址
	private int thumb3Width;//缩略图3宽
	private int thumb3Height;//缩略图3宽
	
	private String thumb4="";//缩略图4地址  列表页  	 展览/   首页?列表	数字展厅的图片大小
	private int thumb4Width;//缩略图4宽
	private int thumb4Height;//缩略图4宽
	
	private String thumb5="";//缩略图5地址  首页		展览的图片大小
	private int thumb5Width;//缩略图5宽
	private int thumb5Height;//缩略图5宽
	
	private String thumb6="";//缩略图6地址
	private int thumb6Width;//缩略图6宽
	private int thumb6Height;//缩略图6宽
	
	
	//业务字段
	private String backUrl;//返回前台的url
	private String frontBackUrl;//返回前台的url
	
	private String urlStr;
	private String thumb1Str;
	private String thumb2Str;
	private String thumb3Str;
	
	
	@Transient
	public String getFrontBackUrl() {
		return frontBackUrl;
	}
	public void setFrontBackUrl(String frontBackUrl) {
		this.frontBackUrl = frontBackUrl;
	}
	
	
	@Transient
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	@Transient
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	@Transient
	public String getThumb1Str() {
		return thumb1Str;
	}
	public void setThumb1Str(String thumb1Str) {
		this.thumb1Str = thumb1Str;
	}
	@Transient
	public String getThumb2Str() {
		return thumb2Str;
	}
	public void setThumb2Str(String thumb2Str) {
		this.thumb2Str = thumb2Str;
	}
	@Transient
	public String getThumb3Str() {
		return thumb3Str;
	}
	public void setThumb3Str(String thumb3Str) {
		this.thumb3Str = thumb3Str;
	}
	
	@Column(name="object_id")
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	@Column(name="type_id")
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	@Column(name="gs_No")
	public String getGsNo() {
		return gsNo;
	}
	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="type")
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	
	@Column(name="is_main")
	public byte getIsMain() {
		return isMain;
	}
	public void setIsMain(byte isMain) {
		this.isMain = isMain;
	}
	
	@Column(name="pic_width")
	public int getPicWidth() {
		return picWidth;
	}
	public void setPicWidth(int picWidth) {
		this.picWidth = picWidth;
	}
	
	@Column(name="pic_height")
	public int getPicHeight() {
		return picHeight;
	}
	public void setPicHeight(int picHeight) {
		this.picHeight = picHeight;
	}
	
	@Column(name="thumb1")
	public String getThumb1() {
		return thumb1;
	}
	public void setThumb1(String thumb1) {
		this.thumb1 = thumb1;
	}
	@Column(name="thumb1_width")
	public int getThumb1Width() {
		return thumb1Width;
	}
	public void setThumb1Width(int thumb1Width) {
		this.thumb1Width = thumb1Width;
	}
	@Column(name="thumb1_height")
	public int getThumb1Height() {
		return thumb1Height;
	}
	public void setThumb1Height(int thumb1Height) {
		this.thumb1Height = thumb1Height;
	}
	@Column(name="thumb2")
	public String getThumb2() {
		return thumb2;
	}
	public void setThumb2(String thumb2) {
		this.thumb2 = thumb2;
	}
	@Column(name="thumb2_width")
	public int getThumb2Width() {
		return thumb2Width;
	}
	public void setThumb2Width(int thumb2Width) {
		this.thumb2Width = thumb2Width;
	}
	@Column(name="thumb2_height")
	public int getThumb2Height() {
		return thumb2Height;
	}
	public void setThumb2Height(int thumb2Height) {
		this.thumb2Height = thumb2Height;
	}
	@Column(name="thumb3")
	public String getThumb3() {
		return thumb3;
	}
	public void setThumb3(String thumb3) {
		this.thumb3 = thumb3;
	}
	@Column(name="thumb3_width")
	public int getThumb3Width() {
		return thumb3Width;
	}
	public void setThumb3Width(int thumb3Width) {
		this.thumb3Width = thumb3Width;
	}
	@Column(name="thumb3_height")
	public int getThumb3Height() {
		return thumb3Height;
	}
	public void setThumb3Height(int thumb3Height) {
		this.thumb3Height = thumb3Height;
	}
	@Column(name="thumb4")
	public String getThumb4() {
		return thumb4;
	}
	public void setThumb4(String thumb4) {
		this.thumb4 = thumb4;
	}
	@Column(name="thumb4_width")
	public int getThumb4Width() {
		return thumb4Width;
	}
	public void setThumb4Width(int thumb4Width) {
		this.thumb4Width = thumb4Width;
	}
	@Column(name="thumb4_height")
	public int getThumb4Height() {
		return thumb4Height;
	}
	public void setThumb4Height(int thumb4Height) {
		this.thumb4Height = thumb4Height;
	}
	@Column(name="thumb5")
	public String getThumb5() {
		return thumb5;
	}
	public void setThumb5(String thumb5) {
		this.thumb5 = thumb5;
	}
	@Column(name="thumb5_width")
	public int getThumb5Width() {
		return thumb5Width;
	}
	public void setThumb5Width(int thumb5Width) {
		this.thumb5Width = thumb5Width;
	}
	@Column(name="thumb5_height")
	public int getThumb5Height() {
		return thumb5Height;
	}
	public void setThumb5Height(int thumb5Height) {
		this.thumb5Height = thumb5Height;
	}
	@Column(name="thumb6")
	public String getThumb6() {
		return thumb6;
	}
	public void setThumb6(String thumb6) {
		this.thumb6 = thumb6;
	}
	@Column(name="thumb6_width")
	public int getThumb6Width() {
		return thumb6Width;
	}
	public void setThumb6Width(int thumb6Width) {
		this.thumb6Width = thumb6Width;
	}
	@Column(name="thumb6_height")
	public int getThumb6Height() {
		return thumb6Height;
	}
	public void setThumb6Height(int thumb6Height) {
		this.thumb6Height = thumb6Height;
	}
	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}
	   
	/**    
	 * <pre>创建一个新的实例 Picture.    
	 *    
	 * @param objectId
	 * @param typeId
	 * @param name
	 * @param url
	 * @param picWidth
	 * @param picHeight
	 * @param type
	 * @param isMain
	 * @param thumb1
	 * @param thumb1Width
	 * @param thumb1Height
	 * @param thumb2
	 * @param thumb2Width
	 * @param thumb2Height
	 * @param thumb3
	 * @param thumb3Width
	 * @param thumb3Height
	 * @param thumb4
	 * @param thumb4Width
	 * @param thumb4Height
	 * @param thumb5
	 * @param thumb5Width
	 * @param thumb5Height
	 * @param thumb6
	 * @param thumb6Width
	 * @param thumb6Height</pre>    
	 */
	   
	
	
	public Picture(String gsNo, String url, int picWidth, int picHeight) {
		super();
		this.gsNo = gsNo;
		this.url = url;
		this.picWidth = picWidth;
		this.picHeight = picHeight;
	}
	/**    
	 * <pre>创建一个新的实例 Picture.    
	 *    </pre>    
	 */
	public Picture() {
		super();
	}
	
	public Picture(String id, String thumb1,String thumb5,String thumb4) {
		super();
		this.id = id;
		this.thumb1 = thumb1;
		this.thumb5 = thumb5;
		this.thumb4 = thumb4;
	}
	public Picture(String id, String url,String thumb1,String thumb5,String thumb4) {
		super();
		this.id = id;
		this.url = url;
		this.thumb1 = thumb1;
		this.thumb5 = thumb5;
		this.thumb4 = thumb4;
	}
	
	public Picture(String gsNo, String url, int picWidth, int picHeight,String thumb1,int thumb1Width,int thumb1Height,
			String thumb2,int thumb2Width,int thumb2Height,String thumb3,int thumb3Width,int thumb3Height) {
		super();
		this.gsNo = gsNo;
		this.url = url;
		this.picWidth = picWidth;
		this.picHeight = picHeight;
		this.thumb1 = thumb1;
		this.thumb1Width = thumb1Width;
		this.thumb1Height = thumb1Height;
		this.thumb2 = thumb2;
		this.thumb2Width = thumb2Width;
		this.thumb2Height = thumb2Height;
		this.thumb3 = thumb3;
		this.thumb3Width = thumb3Width;
		this.thumb3Height = thumb3Height;
		this.status=1;
	}
}