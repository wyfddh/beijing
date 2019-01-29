package com.tj720.mip.dto;

import java.io.Serializable;

import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.Picture;

public class MipOpenFossilInfoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private byte isCollected;
	private MipOpenFossilInfo mipOpenFossilInfo;
	private Picture picture;
	
	public byte getIsCollected() {
		return isCollected;
	}
	public void setIsCollected(byte isCollected) {
		this.isCollected = isCollected;
	}
	public MipOpenFossilInfo getMipOpenFossilInfo() {
		return mipOpenFossilInfo;
	}
	public void setMipOpenFossilInfo(MipOpenFossilInfo mipOpenFossilInfo) {
		this.mipOpenFossilInfo = mipOpenFossilInfo;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	
	
	
	

}
