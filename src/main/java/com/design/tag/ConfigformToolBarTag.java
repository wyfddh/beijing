package com.design.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 类描述：列表工具条标签
 */
public class ConfigformToolBarTag extends TagSupport {
	private String id;//按钮名称
	protected String url;
	protected String title;
	private String exp;//判断链接是否显示的表达式
	private String funname;//自定义函数名称
	private String icon;//图标
	private String onclick;
	private String width;
	private String height;
	private String operationCode;//按钮的操作Code
	private String filterStatus;//数据过滤状态，当选择条件中有此状态时不继续执行。实例：01,02
	
	public void setFilterStatus(String filterStatus) {
		this.filterStatus = filterStatus;
	}
	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}
	public int doEndTag() throws JspTagException {
		Tag t = findAncestorWithClass(this, ConfigformTag.class);
		ConfigformTag parent = (ConfigformTag) t;
		parent.setToolbar(id,url, title, icon, exp,onclick, funname,operationCode,width,height,filterStatus);
		return EVAL_PAGE;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
