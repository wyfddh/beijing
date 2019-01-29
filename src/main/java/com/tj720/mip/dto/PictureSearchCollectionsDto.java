package com.tj720.mip.dto;

import java.io.Serializable;
import java.util.List;

import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.MyString;

public class PictureSearchCollectionsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id="";
	private String name="";
	private String thumb1="";
	private int thumb1Width=0;
	private int thumb1Height=0;
	private String thumb2="";
	private int thumb2Width=0;
	private int thumb2Height=0;
	private String thumb3="";
	private int thumb3Width=0;
	private int thumb3Height=0;
	private String yearType="";
	private String collectionsCategory="";
	private String threeDimensionalCollection="";//="1"有3D
	private String fVideo="";//="1"有视频
	private String fAudio="";//="1"有音频
	private String type="1";//1文物，2化石标本
	public PictureSearchCollectionsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumb1() {
		return thumb1;
	}
	public void setThumb1(String thumb1) {
		this.thumb1 = thumb1;
	}
	public int getThumb1Width() {
		return thumb1Width;
	}
	public void setThumb1Width(int thumb1Width) {
		this.thumb1Width = thumb1Width;
	}
	public int getThumb1Height() {
		return thumb1Height;
	}
	public void setThumb1Height(int thumb1Height) {
		this.thumb1Height = thumb1Height;
	}
	public String getThumb2() {
		return thumb2;
	}
	public void setThumb2(String thumb2) {
		this.thumb2 = thumb2;
	}
	public int getThumb2Width() {
		return thumb2Width;
	}
	public void setThumb2Width(int thumb2Width) {
		this.thumb2Width = thumb2Width;
	}
	public int getThumb2Height() {
		return thumb2Height;
	}
	public void setThumb2Height(int thumb2Height) {
		this.thumb2Height = thumb2Height;
	}
	public String getThumb3() {
		return thumb3;
	}
	public void setThumb3(String thumb3) {
		this.thumb3 = thumb3;
	}
	public int getThumb3Width() {
		return thumb3Width;
	}
	public void setThumb3Width(int thumb3Width) {
		this.thumb3Width = thumb3Width;
	}
	public int getThumb3Height() {
		return thumb3Height;
	}
	public void setThumb3Height(int thumb3Height) {
		this.thumb3Height = thumb3Height;
	}
	public String getYearType() {
		return yearType;
	}
	public void setYearType(String yearType) {
		this.yearType = yearType;
	}
	public String getCollectionsCategory() {
		return collectionsCategory;
	}
	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}
	public String getThreeDimensionalCollection() {
		return threeDimensionalCollection;
	}
	public void setThreeDimensionalCollection(String threeDimensionalCollection) {
		this.threeDimensionalCollection = threeDimensionalCollection;
	}
	public String getfVideo() {
		return fVideo;
	}
	public void setfVideo(String fVideo) {
		this.fVideo = fVideo;
	}
	public String getfAudio() {
		return fAudio;
	}
	public void setfAudio(String fAudio) {
		this.fAudio = fAudio;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}