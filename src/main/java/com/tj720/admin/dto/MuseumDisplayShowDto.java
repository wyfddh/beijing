package com.tj720.admin.dto;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.vo.BaseVO;

/**
 * 陈列展览Entity
 * @author chenshiya
 * @version 2018-07-13
 */
public class MuseumDisplayShowDto extends BaseVO {

	private String museumId;		// 博物馆id
	private String name;		// '展览名称'
	private Float showLength;//展线长度
	private String showLengthStr;		// 展线长度str
	private Integer collectionNum;		// 文物数量',
	private String outTime;//'退出时间',
	
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCollectionNum() {
		return collectionNum;
	}
	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public Float getShowLength() {
		return showLength;
	}
	public void setShowLength(Float showLength) {
		this.showLength = showLength;
	}
	public String getShowLengthStr() {
		if(showLength==null){
			return "";
		}
		return floatToString(showLength);
	}
	public void setShowLengthStr(String showLengthStr) {
		this.showLengthStr = showLengthStr;
	}
	
	public String floatToString(Float fVal){
    	DecimalFormat  dec  =  new  DecimalFormat("##0.00");
        return dec.format(fVal);
    }
}