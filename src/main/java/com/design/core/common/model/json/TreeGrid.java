package com.design.core.common.model.json;

import java.util.Map;

public class TreeGrid implements java.io.Serializable {
	private String id;
	private String text;
	private String parentId;
	private String parentText;
	private String code;
	private String src;
	private String note;
	private Map<String, String> attributes;// 其他参数
	private String operations;// 其他参数
	private String state = "open";// 是否展开(open,closed)
	private String order;// 排序

	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;
	private String temp5;
	private String temp6;
	private String temp7;
	private String temp8;
	private String temp9;
	private String temp10;
	private String temp11;
	private String temp12;
	private String temp13;
	private String temp14;
	private String temp15;

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getTemp3() {
		return temp3;
	}

	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}

	public String getTemp4() {
		return temp4;
	}

	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}

	public String getTemp5() {
		return temp5;
	}

	public void setTemp5(String temp5) {
		this.temp5 = temp5;
	}

	public String getTemp6() {
		return temp6;
	}

	public void setTemp6(String temp6) {
		this.temp6 = temp6;
	}

	public String getTemp7() {
		return temp7;
	}

	public void setTemp7(String temp7) {
		this.temp7 = temp7;
	}

	public String getTemp8() {
		return temp8;
	}

	public void setTemp8(String temp8) {
		this.temp8 = temp8;
	}

	public String getTemp9() {
		return temp9;
	}

	public void setTemp9(String temp9) {
		this.temp9 = temp9;
	}

	public String getTemp10() {
		return temp10;
	}

	public void setTemp10(String temp10) {
		this.temp10 = temp10;
	}

	public String getTemp11() {
		return temp11;
	}

	public void setTemp11(String temp11) {
		this.temp11 = temp11;
	}

	public String getTemp12() {
		return temp12;
	}

	public void setTemp12(String temp12) {
		this.temp12 = temp12;
	}

	public String getTemp13() {
		return temp13;
	}

	public void setTemp13(String temp13) {
		this.temp13 = temp13;
	}

	public String getTemp14() {
		return temp14;
	}

	public void setTemp14(String temp14) {
		this.temp14 = temp14;
	}

	public String getTemp15() {
		return temp15;
	}

	public void setTemp15(String temp15) {
		this.temp15 = temp15;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOperations() {
		return operations;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getParentText() {
		return parentText;
	}

	public void setParentText(String parentText) {
		this.parentText = parentText;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
