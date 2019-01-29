package com.design.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.design.utils.ParameterUtil;
import com.design.utils.oConvertUtils;
import com.zxlhdata.framework.auth.util.LicenseUtil;


/**
 * 
 *
 */
public class BaseTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String type = "default";// 加载类型

	public void setType(String type) {
		this.type = type;
	}

	
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	
	public int doEndTag() throws JspException {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			JspWriter out = this.pageContext.getOut();
			StringBuffer sb = new StringBuffer();

			String types[] = type.split(",");
			if (oConvertUtils.isIn("jquery", types)) {
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/jquery/jquery-1.11.2.min.js\"></script>");
				sb.append("<script type='text/javascript' src='designPlug-in/jquery/TableFreeze.js'></script>");
				sb.append("<script src=\"designPlug-in/jquery/jquery-migrate-1.2.1.js\"></script>");
			}
			if (oConvertUtils.isIn("easyui", types)) {
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/tools/dataformat.js\"></script>");
				sb.append("<link id=\"easyuiTheme\" rel=\"stylesheet\" href=\"designPlug-in/easyui/themes/default/easyui.css\" type=\"text/css\"></link>");
				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/easyui/themes/icon.css\" type=\"text/css\"></link>");
				sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"designPlug-in/accordion/css/accordion.css\">");
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/easyui/jquery.easyui.min.1.3.2.js\"></script>");
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/easyui/locale/easyui-lang-zh_CN.js\"></script>");
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/tools/syUtil.js\"></script>");
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/easyui/extends/datagrid-scrollview.js\"></script>");
				
			}
			
			if (oConvertUtils.isIn("DatePicker", types)) {
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/My97DatePicker/WdatePicker.js\"></script>");
			}
			if (oConvertUtils.isIn("prohibit", types)) {
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/tools/prohibitutil.js\"></script>");		}
			if (oConvertUtils.isIn("autocomplete", types)) {
				sb.append("<link rel=\"stylesheet\" href=\"designPlug-in/jquery/jquery-autocomplete/jquery.autocomplete.css\" type=\"text/css\"></link>");
				sb.append("<script type=\"text/javascript\" src=\"designPlug-in/jquery/jquery-autocomplete/jquery.autocomplete.min.js\"></script>");
			}
			if (oConvertUtils.isIn("layer", types)) {
				sb.append("<script type=\"text/javascript\" src='designPlug-in/layer/layer.js'></script>");
				sb.append("<script type=\"text/javascript\" src='designPlug-in/layer/extend/layer.ext.js'></script>");
				sb.append("<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/layui.css' type=\"text/css\" >");
//				sb.append("<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/global.css' type=\"text/css\" >");
//				sb.append("<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/code.css' type=\"text/css\" >");
//				sb.append("<script type=\"text/javascript\" src='designPlug-in/layui-2.3.0/laytpl.js'></script>");
				sb.append("<script type=\"text/javascript\" src='designPlug-in/layui-2.3.0/layui.js'></script>");
				
			}
			sb.append("<script src=\"designPlug-in/tools/icmstools.js\"></script>");
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
