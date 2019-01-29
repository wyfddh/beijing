package com.tj720.admin.dto;


import java.text.DecimalFormat;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.vo.BaseVO;

/**
 * 收入与花费Entity
 * @author chenshiya
 * @version 2018-05-20
 */
public class MuseumCostDto extends BaseVO {

	private String museumId;		// 博物馆id
	private String costType;		// 费用类型
	private String description;		// 费用描述
	private Float money;		// 金额
	private String moneyStr;//金额str
	private String costTime;		// 费用/收入产生时间

	public String getCostTime() {
		return costTime;
	}


	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}

	public String getMuseumId() {
		return museumId;
	}

	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	
	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Float getMoney() {
		return money;
	}


	public void setMoney(Float money) {
		this.money = money;
	}


	public String getMoneyStr() {
		if(money == null){
			return "";
		}
		return floatToString(money);
	}

	public void setMoneyStr(String moneyStr) {
		this.moneyStr = moneyStr;
	}

	public String floatToString(Float fVal){
    	DecimalFormat  dec  =  new  DecimalFormat("##0.00");
        return dec.format(fVal);
    }
}