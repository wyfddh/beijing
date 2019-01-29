package com.design.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *  @author XXXX
 * 类描述：列表工具条标签
 */
public class LayuiButtonTag extends TagSupport {
	protected String url;
	protected String title;
	private String exp;//判断链接是否显示的表达式
	private String funname;//自定义函数名称
	private String icon;//图标
	private String onclick;
	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getExp() {
		return exp;
	}

	public String getFunname() {
		return funname;
	}

	public String getIcon() {
		return icon;
	}

	public String getOnclick() {
		return onclick;
	}

	public String getOperationCode() {
		return operationCode;
	}
	private String width;
	private String height;
	private String operationCode;//按钮的操作Code
	private OptTypeDirection type;//按钮类型
	public void setType(OptTypeDirection type) {
		this.type = type;
	}

	public OptTypeDirection getType() {
		return type;
	}
	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}
	public int doEndTag() throws JspTagException {
		Tag t = findAncestorWithClass(this, LayuiTableTag.class);
		LayuiTableTag parent = (LayuiTableTag) t;
		parent.setButton(url, title, icon, exp,onclick, funname,operationCode,width,height);
		return EVAL_PAGE;
	}
	public void setFunname(String funname) {
		this.funname = funname;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	
}
