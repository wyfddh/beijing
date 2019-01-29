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
@Table(name="mip_curation")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Curation extends BaseModel implements Serializable,ILuceneDto{
	private static final long serialVersionUID = 1L;
	
	private String pid="";
	private String title="";
	private String uid="";
	private String seriesName="";
	private byte seriesNum = 1;
	private int fromDate;
	private int endDate;
	private String description="";
	private String image1="";
	private String image2="";
	private String image3="";
	private String image4="";
	private String image5="";
	private String image6="";
	private String image7="";
	private String image8="";
	private String image9="";
	private String image10="";
	private String image11="";
	private String image12="";
	private String mainImage="";
	private byte isPublished=0;
	private long publishTime;
	private long likeCounts;
	private String seriesDescription="";
	private String author="";
	private String audio = "";
	
	//业务字段
	private String userName;//策展人
	private long commentCounts;//评论数目
	private int isSeries;//是否为系列
	private String audioUrl;//
	
	@Transient
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Transient
	public long getCommentCounts() {
		return commentCounts;
	}
	public void setCommentCounts(long commentCounts) {
		this.commentCounts = commentCounts;
	}
	
	@Transient
	public int getIsSeries() {
		return isSeries;
	}
	public void setIsSeries(int isSeries) {
		this.isSeries = isSeries;
	}
	
	@Transient
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	
	@Column(name="pid")
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "series_name")
	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	@Column(name="series_num")
	public byte getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(byte seriesNum) {
		this.seriesNum = seriesNum;
	}

	@Column(name="from_date")
	public int getFromDate() {
		return fromDate;
	}

	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name="end_date")
	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="image1")
	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	@Column(name="image2")
	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@Column(name="image3")
	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	@Column(name="image4")
	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	@Column(name="image5")
	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	@Column(name="image6")
	public String getImage6() {
		return image6;
	}

	public void setImage6(String image6) {
		this.image6 = image6;
	}

	@Column(name="image7")
	public String getImage7() {
		return image7;
	}

	public void setImage7(String image7) {
		this.image7 = image7;
	}

	@Column(name="image8")
	public String getImage8() {
		return image8;
	}

	public void setImage8(String image8) {
		this.image8 = image8;
	}

	@Column(name="image9")
	public String getImage9() {
		return image9;
	}

	public void setImage9(String image9) {
		this.image9 = image9;
	}

	@Column(name="image10")
	public String getImage10() {
		return image10;
	}

	public void setImage10(String image10) {
		this.image10 = image10;
	}

	@Column(name="image11")
	public String getImage11() {
		return image11;
	}

	public void setImage11(String image11) {
		this.image11 = image11;
	}

	@Column(name="image12")
	public String getImage12() {
		return image12;
	}

	public void setImage12(String image12) {
		this.image12 = image12;
	}

	@Column(name="main_image")
	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	@Column(name="is_published")
	public byte getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(byte isPublished) {
		this.isPublished = isPublished;
	}

	@Column(name="publish_time")
	public long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	
	@Column(name="like_counts")
	public long getLikeCounts() {
		return likeCounts;
	}
	public void setLikeCounts(long likeCounts) {
		this.likeCounts = likeCounts;
	}
	
	@Column(name="series_description")
	public String getSeriesDescription() {
		return seriesDescription;
	}
	public void setSeriesDescription(String seriesDescription) {
		this.seriesDescription = seriesDescription;
	}
	
	@Column(name="author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name="audio")
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	
	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
	
}