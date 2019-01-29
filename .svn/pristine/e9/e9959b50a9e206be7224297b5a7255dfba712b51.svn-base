package com.design.main.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.common.JsJson;
import com.design.core.common.model.common.JsJsonList;
import com.design.core.common.model.json.SortDirection;
import com.design.core.config.util.ColumnMeta;
import com.design.core.config.util.DbTableProcess;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgFormLgHeadEntity;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformButtonEntity;
import com.design.entity.CgformDefineEntity;
import com.design.entity.CgformDefineJsEntity;
import com.design.entity.CgformTabEntity;
import com.design.form.service.CgformBussServiceI;
import com.design.utils.ConvertArrayListUtil;
import com.design.utils.HttpClientUtil;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.UUIDGenerator;
import com.design.utils.oConvertUtils;

@Controller
@RequestMapping("/designController")
public class DesignController   {
	String designWebPath = ResourceUtil.getConfigByName("designWebPath");
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	private String jsVersion= ResourceUtil.getConfigByName("core.js.version");
	private String cityDataJsonUrl= ResourceUtil.getConfigByName("cityDataJsonUrl");
	private String noBusinessFormAutoRelease= ResourceUtil.getConfigByName("noBusinessFormAutoRelease");
	
//	@Autowired  
//    private JdbcTemplate jdbcTemplate; 
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgformBussServiceI cgformBussService;
	
	@RequestMapping(params = "design")
	public ModelAndView design(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		String nodeCode=oConvertUtils.getString(req.getParameter("nodeCode"),"");
		String defineId = oConvertUtils.getString(req.getParameter("defineId"),"");
		String type = oConvertUtils.getString(req.getParameter("type"),"");//显示模板ID
		String businessCode=oConvertUtils.getString(req.getParameter("businessCode"),"");
		CgformDefineEntity tSConfigform = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "defineCode",
						businessCode);
  		 if(StringUtil.isEmpty(defineId)){
  			defineId=tSConfigform.getId();
  		 }
  		req.setAttribute("title", tSConfigform.getDefineName());
		req.setAttribute("businessCode", businessCode);//业务编码
		req.setAttribute("defineId", defineId); //业务配置表ID
		req.setAttribute("versionNum", oConvertUtils.getString(req.getParameter("versionNum"),"-1")); //配置的流程版本
		req.setAttribute("type", type );
		req.setAttribute("nodeCode", nodeCode );
		return new ModelAndView(prefix+"design/design"+suffix);
	}
	
	
	
	@RequestMapping(params = "designJsEvent")
	public ModelAndView designJsEvent(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
			JsJson jsJson =new JsJson();
			String fieldName=oConvertUtils.getString(req.getParameter("fieldName"),"");
			String businessCode=oConvertUtils.getString(req.getParameter("businessCode"),"");
			String id=oConvertUtils.getString(req.getParameter("id"),"");
			String fieldType=oConvertUtils.getString(req.getParameter("fieldType"),"");
			
//			String jsS=designWebPath+"designPlug-in/design-js/"+businessCode;
////			if(StringUtil.isNotEmpty(nodeCode)){
////				jsS+="/"+nodeCode;
////			}
//			jsS+="/JsEvent.json";
//			File file = new File(jsS);
			
			CgformDefineJsEntity cgformDefineJs = systemService
					.findUniqueByProperty(CgformDefineJsEntity.class, "defineCode",
					businessCode);
			if(cgformDefineJs!=null){
				String input = cgformDefineJs.getJson();
				if(StringUtil.isNotEmpty(input)){
		            JSONArray oldArray = JSONArray.fromObject(input);
		            if(oldArray!=null&&oldArray.size()>0){
		    			for(int i=0;i<oldArray.size();i++){
		    				 JSONObject oldjson = JSONObject.fromObject(oldArray.get(i));
		    				 if(oldjson.containsKey(fieldName)){
		    					 JSONArray oldjsonA1 = JSONArray.fromObject(oldjson.get(fieldName));
		    					 for(int i1=0;i1<oldjsonA1.size();i1++){
		    						 JSONObject jobj = JSONObject.fromObject(oldjsonA1.get(i1));
		    						 if(id.equals(jobj.get("id"))){
		    							 jsJson=(JsJson) oldjson.toBean(jobj, JsJson.class);
		    						 }
		    					 }
		    				 }
		    			}
		    		}
	            }
			}
			
//			if(file.exists()){
//				String input = FileUtils.readFileToString(new File(jsS), "UTF-8");
//				if(StringUtil.isNotEmpty(input)){
//		            JSONArray oldArray = JSONArray.fromObject(input);
//		            if(oldArray!=null&&oldArray.size()>0){
//		    			for(int i=0;i<oldArray.size();i++){
//		    				 JSONObject oldjson = JSONObject.fromObject(oldArray.get(i));
//		    				 if(oldjson.containsKey(fieldName)){
//		    					 JSONArray oldjsonA1 = JSONArray.fromObject(oldjson.get(fieldName));
//		    					 for(int i1=0;i1<oldjsonA1.size();i1++){
//		    						 JSONObject jobj = JSONObject.fromObject(oldjsonA1.get(i1));
//		    						 if(id.equals(jobj.get("id"))){
//		    							 jsJson=(JsJson) oldjson.toBean(jobj, JsJson.class);
//		    						 }
//		    					 }
//		    				 }
//		    			}
//		    		}
//	            }
//			}
		req.setAttribute("jsJson", jsJson);
		req.setAttribute("fieldType", fieldType);
		req.setAttribute("fieldName", fieldName);
		req.setAttribute("businessCode", businessCode);
		req.setAttribute("id", id);
		return new ModelAndView(prefix+"design/designJsEvent"+suffix);
	}
	@RequestMapping(params = "designJsPreview")
	public ModelAndView designJsPreview(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		String businessCode=oConvertUtils.getString(req.getParameter("businessCode"),"");
		String nodeCode=oConvertUtils.getString(req.getParameter("nodeCode"),"");
		req.setAttribute("nodeCode", nodeCode );
		String jsHtml = getJsHtml(businessCode);
		req.setAttribute("jsHtml", jsHtml );
		
		return new ModelAndView(prefix+"design/designJsPreview"+suffix);
	}



	private String getJsHtml(String businessCode) throws Exception {
		String jsHtml="";
//		String jsS=designWebPath+"designPlug-in/design-js/"+businessCode+"/JsEvent.json";
		
		CgformDefineJsEntity cgformDefineJs = systemService
				.findUniqueByProperty(CgformDefineJsEntity.class, "defineCode",
				businessCode);
		
		
//		File file = new File(jsS);
//		if(file.exists()){
//			String input = FileUtils.readFileToString(new File(jsS), "UTF-8");
		if(cgformDefineJs!=null){
			String input = cgformDefineJs.getJson();
			if(StringUtil.isNotEmpty(input)){
	            JSONArray oldArray = JSONArray.fromObject(input);
	            if(oldArray!=null&&oldArray.size()>0){
	    			for(int i=0;i<oldArray.size();i++){
	    				 JSONObject oldjson = JSONObject.fromObject(oldArray.get(i));
	    				 Iterator<String> iterator1 =oldjson.keys();
	    			        while(iterator1.hasNext()){
	    			        	String key1 = iterator1.next();
	    			        	JSONArray oldjsonA1 = JSONArray.fromObject(oldjson.get(key1));
	    			        	for(int i1=0;i1<oldjsonA1.size();i1++){
		    						 JSONObject jobj = JSONObject.fromObject(oldjsonA1.get(i1));
		    						 JsJson jsJson=(JsJson) oldjson.toBean(jobj, JsJson.class);
		    						 if("Y".equals(jsJson.getDj_input())){
		    							 jsHtml+="/**--"+oConvertUtils.getString(jsJson.getDj_remark(),"单击事件备注信息")+"--******/\n";
		    							 jsHtml+="try{\n";
		    							 jsHtml+="	$(\"[id='"+jsJson.getId()+"']\").click(function(){\n";
		    							 jsHtml+="		/**--执行方法体-start--******/\n";
		    							 if("s_true".equals(jsJson.getDj_select())){//保存
		    								 jsHtml+="			$.saveData(false);\n";
		    							 }
		    							 if("s_true_r".equals(jsJson.getDj_select())){//保存并刷新
		    								 jsHtml+="			$.saveData(true);\n";
		    								 jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
		    								 jsHtml+="			parent.layui.layer.close(index);\n";
		    							 }
										if("p_s_true".equals(jsJson.getDj_select())){//执行父页面保存方法
											jsHtml+="			parent.$.saveData(false);\n";   								 
		    							 }
										if("p_s_true_r".equals(jsJson.getDj_select())){//保存
											jsHtml+="			parent.$.saveData(true);\n";   			
										}
										if("w_close".equals(jsJson.getDj_select())){//保存
//											jsHtml+="			window.close();\n"; 
											jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
											jsHtml+="			parent.layui.layer.close(index);\n"; 
										}
										if("custom".equals(jsJson.getDj_select())){//保存
											jsHtml+="			"+jsJson.getDj_textarea()+"\n";
										}
		    							 jsHtml+="		/**--执行方法体-end--******/\n";
		    							 jsHtml+="	});\n";
		    							 jsHtml+="}catch(e){}\n";
		    						 }
		    						 if("Y".equals(jsJson.getSj_input())){
		    							 jsHtml+="/**--"+oConvertUtils.getString(jsJson.getSj_remark(),"双击事件备注信息")+"--******/\n";
		    							 jsHtml+="try{\n";
		    							 jsHtml+="	$(\"[id='"+jsJson.getId()+"']\").click(function(){\n";
		    							 jsHtml+="		/**--执行方法体-start--******/\n";
		    							 if("s_true".equals(jsJson.getSj_select())){//保存
		    								 jsHtml+="			$.saveData(false);\n";
		    							 }
		    							 if("s_true_r".equals(jsJson.getSj_select())){//保存并刷新
		    								 jsHtml+="			$.saveData(true);\n";
		    								 jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
		    								 jsHtml+="			parent.layui.layer.close(index);\n";
		    							 }
										if("p_s_true".equals(jsJson.getSj_select())){//执行父页面保存方法
											jsHtml+="			parent.$.saveData(false);\n";   								 
		    							 }
										if("p_s_true_r".equals(jsJson.getSj_select())){//保存
											jsHtml+="			parent.$.saveData(true);\n";   			
										}
										if("w_close".equals(jsJson.getSj_select())){//保存
//											jsHtml+="			window.close();\n"; 
											jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
											jsHtml+="			parent.layui.layer.close(index);\n"; 
										}
										if("custom".equals(jsJson.getSj_select())){//保存
											jsHtml+="			"+jsJson.getDj_textarea()+"\n";
										}
		    							 jsHtml+="		/**--执行方法体-end--******/\n";
		    							 jsHtml+="	});\n";
		    							 jsHtml+="}catch(e){}\n";
		    						 }
		    						 if("Y".equals(jsJson.getHqgb_input())){
		    							 jsHtml+="/**--"+oConvertUtils.getString(jsJson.getHqgb_remark(),"获取光标事件备注信息")+"--******/\n";
		    							 jsHtml+="try{\n";
		    							 jsHtml+="	$(\"[id='"+jsJson.getId()+"']\").click(function(){\n";
		    							 jsHtml+="		/**--执行方法体-start--******/\n";
		    							 if("s_true".equals(jsJson.getHqgb_select())){//保存
		    								 jsHtml+="			$.saveData(false);\n";
		    							 }
		    							 if("s_true_r".equals(jsJson.getHqgb_select())){//保存并刷新
		    								 jsHtml+="			$.saveData(true);\n";
		    								 jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
		    								 jsHtml+="			parent.layui.layer.close(index);\n";
		    							 }
										if("p_s_true".equals(jsJson.getHqgb_select())){//执行父页面保存方法
											jsHtml+="			parent.$.saveData(false);\n";   								 
		    							 }
										if("p_s_true_r".equals(jsJson.getHqgb_select())){//保存
											jsHtml+="			parent.$.saveData(true);\n";   			
										}
										if("w_close".equals(jsJson.getHqgb_select())){//保存
//											jsHtml+="			window.close();\n"; 
											jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
											jsHtml+="			parent.layui.layer.close(index);\n"; 
										}
										if("custom".equals(jsJson.getHqgb_select())){//保存
											jsHtml+="			"+jsJson.getDj_textarea()+"\n";
										}
		    							 jsHtml+="		/**--执行方法体-end--******/\n";
		    							 jsHtml+="	});\n";
		    							 jsHtml+="}catch(e){}\n";
		    						 }
		    						 if("Y".equals(jsJson.getSqgb_input())){
		    							 jsHtml+="/**--"+oConvertUtils.getString(jsJson.getSqgb_remark(),"失去光标事件备注信息")+"--******/\n";
		    							 jsHtml+="try{\n";
		    							 jsHtml+="	$(\"[id='"+jsJson.getId()+"']\").click(function(){\n";
		    							 jsHtml+="		/**--执行方法体-start--******/\n";
		    							 if("s_true".equals(jsJson.getSqgb_select())){//保存
		    								 jsHtml+="			$.saveData(false);\n";
		    							 }
		    							 if("s_true_r".equals(jsJson.getSqgb_select())){//保存并刷新
		    								 jsHtml+="			$.saveData(true);\n";
		    								 jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
		    								 jsHtml+="			parent.layui.layer.close(index);\n";
		    							 }
										if("p_s_true".equals(jsJson.getSqgb_select())){//执行父页面保存方法
											jsHtml+=" 			parent.$.saveData(false);\n";   								 
		    							 }
										if("p_s_true_r".equals(jsJson.getSqgb_select())){//保存
											jsHtml+="			parent.$.saveData(true);\n";   			
										}
										if("w_close".equals(jsJson.getSqgb_select())){//保存
//											jsHtml+="			window.close();\n"; 
											jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
											jsHtml+="			parent.layui.layer.close(index);\n"; 
										}
										if("custom".equals(jsJson.getSqgb_select())){//保存
											jsHtml+="			"+jsJson.getDj_textarea()+"\n";
										}
		    							 jsHtml+="		/**--执行方法体-end--******/\n";
		    							 jsHtml+="	});\n";
		    							 jsHtml+="}catch(e){}\n";
		    						 }
		    						 if("Y".equals(jsJson.getSjgg_input())){
		    							 jsHtml+="/**--"+oConvertUtils.getString(jsJson.getSjgg_remark(),"数据更改事件备注信息")+"--******/\n";
		    							 jsHtml+="try{\n";
		    							 jsHtml+="	$(\"[id='"+jsJson.getId()+"']\").click(function(){\n";
		    							 jsHtml+="		/**--执行方法体-start--******/\n";
		    							 if("s_true".equals(jsJson.getSjgg_select())){//保存
		    								 jsHtml+="			$.saveData(false);\n";
		    							 }
		    							 if("s_true_r".equals(jsJson.getSjgg_select())){//保存并刷新
		    								 jsHtml+="			$.saveData(true);\n";
		    								 jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
		    								 jsHtml+="			parent.layui.layer.close(index);\n";
		    							 }
										if("p_s_true".equals(jsJson.getSjgg_select())){//执行父页面保存方法
											jsHtml+="			parent.$.saveData(false);\n";   								 
		    							 }
										if("p_s_true_r".equals(jsJson.getSjgg_select())){//保存
											jsHtml+="			parent.$.saveData(true);\n";   			
										}
										if("w_close".equals(jsJson.getSjgg_select())){//保存
//											jsHtml+="			window.close();\n"; 
											jsHtml+="			var index=parent.layui.layer.getFrameIndex(window.name);\n"; 
											jsHtml+="			parent.layui.layer.close(index);\n"; 
										}
										if("custom".equals(jsJson.getSjgg_select())){//保存
											jsHtml+="			"+jsJson.getDj_textarea()+"\n";
										}
		    							 jsHtml+="		/**--执行方法体-end--******/\n";
		    							 jsHtml+="	});\n";
		    							 jsHtml+="}catch(e){}\n";
		    						 }
		    					 }
	    			        }
	    			}
	    		}
            }
		}
		return jsHtml;
	}
	@RequestMapping(params = "designJsHelp")
	public ModelAndView designJsHelp(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		String nodeCode=oConvertUtils.getString(req.getParameter("nodeCode"),"");
		req.setAttribute("nodeCode", nodeCode );
		return new ModelAndView(prefix+"design/designJsHelp"+suffix);
	}
	
	
	
	
	
	@RequestMapping(params = "designCenter")
	public ModelAndView designCenter(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//				if(!LicenseUtil.valid(authType, randomCode)){
//					return new ModelAndView("redirect:/authController.do?register&flag=1");
//				}
		String businessCode=oConvertUtils.getString(req.getParameter("businessCode"),"");
//		String sql="select * from cgform_lg_head ";
//  		sql+=" where BUSS_CODE='"+businessCode+"' ";
//  		System.out.println("sql:"+sql);
//  		 List<Map<String, Object>> map = systemService.findForJdbc(sql);
//  		 if(map!=null&&map.size()>0){
//  			req.setAttribute("tableId", map.get(0).get("id") );
//  		 }
  		 
		String defineId = oConvertUtils.getString(req.getParameter("defineId"),"");
  		req.setAttribute("defineId", defineId);
  		req.setAttribute("jsVersion", jsVersion);
  		req.setAttribute("businessCode", businessCode);
  		req.setAttribute("type", oConvertUtils.getString(req.getParameter("type"),""));
		req.setAttribute("bussTemplateId", oConvertUtils.getString(req.getParameter("bussTemplateId"),""));
		req.setAttribute("versionNum", oConvertUtils.getString(req.getParameter("versionNum"),"-1"));
		return new ModelAndView(prefix+"design/designCenter"+suffix);
	}
	
	@RequestMapping(params = "designRight")
	public ModelAndView designRight(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		return new ModelAndView(prefix+"design/designRight"+suffix);
	}
	@RequestMapping(params = "designPreviewHtmlIframe")
	public ModelAndView designPreviewHtmlIframe(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//		String authType =ParameterUtil.ATC_K;
//		int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			if(!LicenseUtil.valid(authType, randomCode)){
//				return new ModelAndView("redirect:/authController.do?register&flag=1");
//			}
		String businessCode=oConvertUtils.getString(req.getParameter("businessCode"),"");
		String bussTemplateId = oConvertUtils.getString(req.getParameter("bussTemplateId"),"");//显示模板ID
		req.setAttribute("businessCode", businessCode);
		req.setAttribute("defineId", oConvertUtils.getString(req.getParameter("defineId"),""));
		req.setAttribute("bussTemplateId", bussTemplateId );
		req.setAttribute("jsVersion", jsVersion );
		req.setAttribute("versionNum", oConvertUtils.getString(req.getParameter("versionNum"),"-1")); //配置的流程版本
		return new ModelAndView(prefix+"design/designPreviewHtmlIframe"+suffix);
	}
	@RequestMapping(params = "designPreviewHtml")
	public ModelAndView designPreviewHtml(HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//					if(!LicenseUtil.valid(authType, randomCode)){
//						return new ModelAndView("redirect:/authController.do?register&flag=1");
//					}
		String businessCode=oConvertUtils.getString(req.getParameter("businessCode"),"");
		String bussTemplateId = oConvertUtils.getString(req.getParameter("bussTemplateId"),"");//显示模板ID
		req.setAttribute("defineId", oConvertUtils.getString(req.getParameter("defineId"),""));
		req.setAttribute("businessCode", businessCode);
		req.setAttribute("bussTemplateId", bussTemplateId);
		req.setAttribute("versionNum", oConvertUtils.getString(req.getParameter("versionNum"),"-1")); //配置的流程版本
		return new ModelAndView(prefix+"design/designPreviewHtml"+suffix);
	}
	
	@RequestMapping(params = "designLeft")
	public ModelAndView designLeft(HttpServletRequest req,HttpServletResponse response) throws Exception {
		String type = oConvertUtils.getString(req.getParameter("type"),"");//显示模板ID
		String defineId = oConvertUtils.getString(req.getParameter("defineId"),"");
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//					if(!LicenseUtil.valid(authType, randomCode)){
//						return new ModelAndView("redirect:/authController.do?register&flag=1");
//					}
					req.setAttribute("type", type);
					req.setAttribute("defineId", defineId);
		return new ModelAndView(prefix+"design/designLeft"+suffix);
	}
	
	@RequestMapping(params = "saveJson")
	@ResponseBody
	public String saveJson(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//List<Map<String, Object>> map = systemService.findForJdbc("select * from cgform_lg_field ");  
		String businessCode=oConvertUtils.getString(request.getParameter("businessCode"),"");
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");//显示模板ID
		int versionNum = oConvertUtils.getInt(request.getParameter("versionNum"),-1); //配置的流程版本
		String FieldsMap=oConvertUtils.getString(request.getParameter("FieldsMap"),"");
		String FormDataMap=oConvertUtils.getString(request.getParameter("FormDataMap"),"");
		String nodeCode=oConvertUtils.getString(request.getParameter("nodeCode"),"");
//		String jsS=designWebPath+"designPlug-in/design-js/"+businessCode;
//		if(StringUtil.isNotEmpty(nodeCode)){
//			jsS+="/"+nodeCode;
//		}
//		File file = new File(jsS);
//		if(!file.exists()){
//			file.mkdirs();
//		}
//		jsS+="/v"+versionNum+".js";
//		file = new File(jsS);
		
		CgformDefineJsEntity cgformDefineJs = null;
		 CriteriaQuery cq1 = new CriteriaQuery(CgformDefineJsEntity.class);
	  		cq1.eq("defineCode", businessCode);
//	  		cq1.eq("version", versionNum);
	  		if(StringUtil.isNotEmpty(nodeCode)){
	  			cq1.eq("nodeCode", nodeCode);
	  		}
	  		cq1.add();
	  		List<CgformDefineJsEntity> cgformDefineJsList= systemService.getListByCriteriaQuery(cq1, false);
		if(cgformDefineJsList!=null&&cgformDefineJsList.size()>0){
			cgformDefineJs=cgformDefineJsList.get(0);
		}
		
//		try {
//			if (file.exists()) {
//				file.deleteOnExit();
//			}
			String jsHtml = getJsHtml(businessCode);
//			file.createNewFile();
//			OutputStreamWriter out = new OutputStreamWriter(
//					new FileOutputStream(file), "UTF-8");
//			out.write(jsHtml);
//			out.flush();
//			out.close();
			if(cgformDefineJs!=null){
				cgformDefineJs.setJs(jsHtml);
				cgformDefineJs.setVersion(versionNum);
				systemService.updateEntitie(cgformDefineJs);
			}else{
				cgformDefineJs=new CgformDefineJsEntity();
				cgformDefineJs.setJs(jsHtml);
				cgformDefineJs.setVersion(versionNum);
				cgformDefineJs.setDefineCode(businessCode);
				systemService.save(cgformDefineJs);
			}
			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			JSONObject treeJsonString = new JSONObject();
			treeJsonString.put("msg", "保存成功!");
		List<Map<String, Object>> map1 = systemService.findForJdbc("select * from cgform_define where define_code='"+businessCode+"' ");  
		JSONObject formDataMap = JSONObject.fromObject(FormDataMap);
		CgformDefineEntity cgformDefine=(CgformDefineEntity) formDataMap.toBean(formDataMap, CgformDefineEntity.class);
		
		JSONArray fieldsMap = JSONArray.fromObject("["+FieldsMap+"]");
		if(fieldsMap.size()>0){
			  for(int i=0;i<fieldsMap.size();i++){
				  JSONObject job1 = fieldsMap.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				  Iterator iterator = job1.keys();
				  while(iterator.hasNext()){
				          String key = (String) iterator.next();
				          JSONObject value = JSONObject.fromObject(job1.get(key));
//				          System.out.println(value.get("name")+"=") ;  // 得到 每个对象中的属性值
				          CgFormLgFieldEntity cgFormLgField = (CgFormLgFieldEntity)JSONObject.toBean(value,CgFormLgFieldEntity.class);
				          cgFormLgField.setBussTemplateId(bussTemplateId);
				          cgFormLgField.setVersionNum(versionNum);
				          cgFormLgField.setDefineId(cgformDefine.getId());
				          cgFormLgField.setBussCode(businessCode);
				          cgFormLgField.setOrderNum("id".equals(cgFormLgField.getFieldName())?0:1);//增加排序，在生成表结构中会使用到，不能随意更改id的排序值
//				        String sql="select * from cgform_lg_field ";
//				  		sql+=" where id='"+cgFormLgField.getId()+"' ";
				          
				        CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
				  		cq.eq("defineId", cgformDefine.getId());
				  		cq.eq("fieldName", cgFormLgField.getFieldName());
				  		cq.add();
				  		List<CgFormLgFieldEntity> t= systemService.getListByCriteriaQuery(cq, false);
				          
//				  		System.out.println("sql:"+sql);
//				  		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
				  		 if(t!=null&&t.size()>0){
//				  			 updateField(cgFormLgField);
				  			CgFormLgFieldEntity t1=t.get(0);
				  			String id=t1.getId();
				  			//处理字段中选择控件的基础数据，在生成表结构的时候需要用到这些参数
				  			if(cgFormLgField.getFieldName().split("\\_").length>2){
				  				String f1[]=cgFormLgField.getFieldName().split("\\_");
				  				String sql="select * from cgform_component where cp_code = '"+f1[0]+"_"+f1[1]+"'";
					  			List<Map<String, Object>> r = systemService.findForJdbc(sql);
					  			if(r!=null&&r.size()>0){
					  				cgFormLgField.setType(r.get(0).get("type")+"");
					  				cgFormLgField.setLength(oConvertUtils.getInt(r.get(0).get("length")+""));
					  			}
				  			}
				  			MyBeanUtils.copyBeanNotNull2Bean(cgFormLgField, t1);
				  			t1.setId(id);
							systemService.updateEntitie(t1);
				  		 }else{
//				  			 saveField(cgFormLgField);
				  			cgFormLgField.setId("");
				  			//处理字段中选择控件的基础数据，在生成表结构的时候需要用到这些参数
				  			if(cgFormLgField.getFieldName().split("\\_").length>2){
				  				String f1[]=cgFormLgField.getFieldName().split("\\_");
				  				String sql="select * from cgform_component where cp_code = '"+f1[0]+"_"+f1[1]+"'";
					  			List<Map<String, Object>> r = systemService.findForJdbc(sql);
					  			if(r!=null&&r.size()>0){
					  				cgFormLgField.setType(r.get(0).get("type")+"");
					  				cgFormLgField.setLength(oConvertUtils.getInt(r.get(0).get("length")+""));
					  			}
				  			}
				  			if("隐藏的值,显示的值".equals(cgFormLgField.getInputId())){
				  				cgFormLgField.setInputId(""+businessCode+"@"+cgFormLgField.getFieldName()+",showName_"+businessCode+"_"+cgFormLgField.getFieldName()+",");
				  			}
				  			systemService.save(cgFormLgField);
				  		 }
				  		//更新明细业务配置表的关联关系
				  		if(StringUtil.isNotEmpty(cgFormLgField.getLinkBussCode())){
							if(map1!=null&&map1.size()>0){
								genLinkBussCodeData(cgFormLgField.getMainField(),
										cgFormLgField.getDetailField(),
										cgFormLgField.getLinkBussCode(), 
										oConvertUtils.getString(map1.get(0).get("mtable_name")));
							}
						}
				  	//更新表单明细配置
				  		if("v_formDetailedTab".equals(cgFormLgField.getShowType())){
				  			String sql_tab="select * from cgform_tab ";
				  			sql_tab+=" where form_id='"+cgFormLgField.getId()+"' ";
					  		System.out.println("sql:"+sql_tab);
					  		 List<Map<String, Object>> map_tab = systemService.findForJdbc(sql_tab);  
					  		 if(map_tab!=null&&map_tab.size()>0){
					  			 for(Map<String, Object> m1:map_tab){
					  				genLinkBussCodeData(oConvertUtils.getString(m1.get("main_field")),
					  						oConvertUtils.getString(m1.get("detail_field")),
					  								oConvertUtils.getString(m1.get("link_buss_code")), 
					  								oConvertUtils.getString(map1.get(0).get("mtable_name")));
					  			 }
					  		 }
				  		}
				  }
			  }
			}
		
		if(cgformDefine!=null){
			CgformDefineEntity t=systemService.getEntity(CgformDefineEntity.class, cgformDefine.getId());
			if(t!=null){
				MyBeanUtils.copyBeanNotNull2Bean(cgformDefine, t);
				systemService.updateEntitie(t);
			}
//			 String sql="select * from t_s_buss_template ";
//		  		sql+=" where id='"+cgformDefine.getId()+"' ";
//		  		System.out.println("sql:"+sql);
//		  		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
//		  		 if(map!=null&&map.size()>0){
//		  			 updateBussTemplateField(tSBussTemplate);
//		  		 }
		}
		
		//自动发布
		treeJsonString.put("defineCode", "");
		if("true".equals(noBusinessFormAutoRelease)&&"2".equals(formDataMap.get("bussType"))){
			CgformBussEntity cgformBuss_ = systemService.findUniqueByProperty(CgformBussEntity.class,"defineId", formDataMap.get("id").toString());
			if(cgformBuss_!=null){
				//先删除就数据
				int i1=systemService.executeSql(" delete from cgform_buss_list where buss_id='"+cgformBuss_.getId()+"' ");
				CgformDefineEntity cgformDefineEntity = systemService.getEntity(CgformDefineEntity.class, cgformBuss_.getDefineId());
				List<CgFormLgFieldEntity> queryList = cgformDefineEntity.getColumns();
				if(queryList!=null&&queryList.size()>0){
					for(int i=0;i<queryList.size();i++){
						CgformBussListEntity cgformBussList =new CgformBussListEntity();
						cgformBussList.setBussId(cgformBuss_.getId());
						cgformBussList.setColumnWidth("200");
						cgformBussList.setContent(queryList.get(i).getContent());
						cgformBussList.setDefineId(queryList.get(i).getId());
						cgformBussList.setFieldName(queryList.get(i).getFieldName());
						cgformBussList.setIsImagelist("N");
						cgformBussList.setIsImagelistHide("N");
						cgformBussList.setIsListHide("N");
						if("id".equals(queryList.get(i).getFieldName())){
							cgformBussList.setIsListHide("Y");
						}
						cgformBussList.setIsShowList("Y");
						cgformBussList.setSort((i+1));
						if(!queryList.get(i).getShowType().startsWith("v_form")){
							systemService.save(cgformBussList);
							String sql_ = "describe " + cgformDefineEntity.getMtableName() + " "+queryList.get(i).getFieldName();
							List<Map<String, Object>> aaq1 = systemService.findForJdbc(sql_);
							if(aaq1!=null&&aaq1.size()>0){
							}else{
								String alterTable="alter table  "+cgformDefineEntity.getMtableName().toLowerCase()+" ";
								DbTableProcess dbTableProcess = new DbTableProcess(systemService.getSession());
								ColumnMeta columnMeta =new ColumnMeta();
								columnMeta.setTableName(cgformDefineEntity.getMtableName().toLowerCase());
								columnMeta.setColumnId(oConvertUtils.getString(queryList.get(i).getId()));
								columnMeta.setColumnName(oConvertUtils.getString(queryList.get(i).getFieldName().toLowerCase()));
								columnMeta.setColumnSize(queryList.get(i).getLength());
								columnMeta.setColunmType(oConvertUtils.getString(queryList.get(i).getType().toLowerCase()));
								columnMeta.setIsNullable("Y");
	//							columnMeta.setComment(cgFormFieldEntity.getContent());增加备注字段，原来的Content当做字段中文名称使用
								columnMeta.setComment(oConvertUtils.getString(queryList.get(i).getFieldRemark()));
	//							columnMeta.setDecimalDigits(queryList.get(i).getPointLength());
								columnMeta.setFieldDefault(dbTableProcess.judgeIsNumber(queryList.get(i).getFieldDefault()));
								//columnMeta.setPkType(table.getJformPkType()==null?"UUID":table.getJformPkType());
								columnMeta.setOldColumnName(queryList.get(i).getOldFieldName()!=null?queryList.get(i).getOldFieldName().toLowerCase():null);
								String addColumnString= dbTableProcess.getAddColumnSql(columnMeta);
								systemService.executeSql(alterTable+addColumnString);
							}
						}
					}
				}
			}else{
				CgformBussEntity cgformBuss=new CgformBussEntity();
				cgformBuss.setIsIndex("Y");
				cgformBuss.setIsPage("Y");
				cgformBuss.setIsSum("Y");
				cgformBuss.setIsCheckbox("Y");
				cgformBuss.setInitRow("2");
				cgformBuss.setDefineId(formDataMap.get("id").toString());
				cgformBuss.setBussName(formDataMap.get("defineName").toString());
				cgformBuss.setPageSize(10);
				cgformBuss.setLimits("10,20,30");
				cgformBuss.setOperationWidth("200");
				cgformBuss=cgformBussService.saveAndCopyDefine(cgformBuss,request);
				cgformBuss.setStatus("1");
				systemService.updateEntitie(cgformBuss);
				CgformDefineEntity cgformDefineEntity = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
				treeJsonString.put("defineCode", cgformDefineEntity.getDefineCode());
				List<CgFormLgFieldEntity> queryList = cgformDefineEntity.getColumns();
				if(queryList!=null&&queryList.size()>0){
					for(int i=0;i<queryList.size();i++){
						CgformBussListEntity cgformBussList =new CgformBussListEntity();
						cgformBussList.setBussId(cgformBuss.getId());
						cgformBussList.setColumnWidth("200");
						cgformBussList.setContent(queryList.get(i).getContent());
						cgformBussList.setDefineId(queryList.get(i).getId());
						cgformBussList.setFieldName(queryList.get(i).getFieldName());
						cgformBussList.setIsImagelist("N");
						cgformBussList.setIsImagelistHide("N");
						cgformBussList.setIsListHide("N");
						if("id".equals(queryList.get(i).getFieldName())){
							cgformBussList.setIsListHide("Y");
						}
						cgformBussList.setIsShowList("Y");
						cgformBussList.setSort((i+1));
						if(!queryList.get(i).getShowType().startsWith("v_form")){
							systemService.save(cgformBussList);
						}
					}
				}
			}
			
		}
		return treeJsonString.toString();
	}

	private void genLinkBussCodeData(
			String mainField,
			String detailField,
			String linkBussCode,
			String mtable_name) {
		List<Map<String, Object>> map2 = systemService.findForJdbc("select * from cgform_lg_field where main_table like '%"+mtable_name+",%'"
				+ " and main_field like '%"+mainField+",%' and  buss_code='"+linkBussCode+"'"
						+ " and field_name='"+detailField+"' ");  
		if(map2==null||map2.size()==0){//如果不存在，则需要判断字段是否有值，没有的话就直接插入，有的话，就追加
			List<Map<String, Object>> map3 = systemService.findForJdbc("select * from cgform_lg_field where  buss_code='"+linkBussCode+"'"
							+ " and field_name='"+detailField+"' ");  
			if(map3!=null&&map3.size()>0){
				String sql_="";
				if(StringUtil.isNotEmpty(map3.get(0).get("main_table"))){
					sql_="update cgform_lg_field set main_table ='"+map3.get(0).get("main_table")+mtable_name+",'"
							+ " ,main_field='"+map3.get(0).get("main_field")+mainField+",' where buss_code='"+linkBussCode+"' "
									+ " and field_name='"+detailField+"' ";
				}else{
					sql_="update cgform_lg_field set main_table ='"+mtable_name+",' "
							+ " ,main_field='"+mainField+",' where buss_code='"+linkBussCode+"' "
									+ " and field_name='"+detailField+"' ";
				}
				systemService.executeSql(sql_);
			}
		}
	}
	
	
	
	@RequestMapping(params = "cgformButton")
	public ModelAndView cgformButton(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//					if(!LicenseUtil.valid(authType, randomCode)){
//						return new ModelAndView("redirect:/authController.do?register&flag=1");
//					}
		String defineCode = request.getParameter("defineCode");
		String formId = request.getParameter("formId");
		String isEdit = request.getParameter("isEdit");
		request.setAttribute("formId", formId);
		request.setAttribute("defineCode", defineCode);
		List<CgformButtonEntity> designButtonList = getButtonList(formId,"true",defineCode);
		request.setAttribute("designButtonList", designButtonList);
		return new ModelAndView(prefix+"design/designButtonList"+suffix);
	}
	
	@RequestMapping(params = "cgformTab")
	public ModelAndView cgformTab(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//					if(!LicenseUtil.valid(authType, randomCode)){
//						return new ModelAndView("redirect:/authController.do?register&flag=1");
//					}
		String formId = request.getParameter("formId");
		String defineCode = request.getParameter("defineCode");
		String isEdit = request.getParameter("isEdit");
		request.setAttribute("formId", formId);
		request.setAttribute("defineCode", defineCode);
		List<CgformTabEntity> designTabList = getTabList(formId,"true",defineCode);
		request.setAttribute("designTabList", designTabList);
		return new ModelAndView(prefix+"design/designTabList"+suffix);
	}
	
	

	
	@RequestMapping(params = "getButtonList")
	@ResponseBody
	public List<CgformButtonEntity> getButtonList(String formId,String isEdit,String defineCode) {
		String sql="select * from cgform_button ";
		sql+=" where form_id='"+formId+"' and define_code='"+defineCode+"' ";
		if(!"true".equals(isEdit)){
			sql+="and (button_type is null or button_type='')  order by order_num asc  ";
		}
		System.out.println("sql:"+sql);
		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		List<CgformButtonEntity> designButtonList = new ArrayList<CgformButtonEntity>();
		if(map!=null&&map.size()>0){
			  for(Map<String, Object> m:map){
				  CgformButtonEntity designButton=new CgformButtonEntity();
			try {
				designButton = DesignGenObject.getCgformButton(m);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			designButtonList.add(designButton);
			  }
		   }
		return designButtonList;
	}
	
	
	@RequestMapping(params = "getTabList")
	@ResponseBody
	public List<CgformTabEntity> getTabList(String formId,String isEdit,String defineCode) {
		String sql="select * from cgform_tab ";
		sql+=" where form_id='"+formId+"'  and define_code='"+defineCode+"' ";
		System.out.println("sql:"+sql);
		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		List<CgformTabEntity> designTabList = new ArrayList<CgformTabEntity>();
		if(map!=null&&map.size()>0){
			  for(Map<String, Object> m:map){
				  CgformTabEntity designTab=new CgformTabEntity();
			try {
				designTab = DesignGenObject.getCgformTab(m);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			designTabList.add(designTab);
			  }
		   }
		return designTabList;
	}
	
	/**
	 * 表单自定义按钮列表页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "addTab")
	public ModelAndView addTab(CgformTabEntity designTab, HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//					if(!LicenseUtil.valid(authType, randomCode)){
//						return new ModelAndView("redirect:/authController.do?register&flag=1");
//					}
		String sql="select * from cgform_tab ";
		sql+=" where id='"+designTab.getId()+"' ";
		System.out.println("sql:"+sql);
		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		if(map!=null&&map.size()>0){
			try {
				designTab = DesignGenObject.getCgformTab(map.get(0));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		req.setAttribute("designTabPage", designTab);
		return new ModelAndView(prefix+"design/designTab"+suffix);
	}
	
	/**
	 * 添加表单自定义按钮
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "saveTab")
	@ResponseBody
	public String saveTab(CgformTabEntity cgformTab, HttpServletRequest request,HttpServletResponse response) throws Exception {
		String message="";
		String sql="select * from cgform_tab ";
  		sql+=" where id='"+cgformTab.getId()+"' ";
  		System.out.println("sql:"+sql);
  		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		if (map!=null&&map.size()>0) {
			message = "更新成功";
			toUpdateTab(cgformTab);
		} else {
			toSaveTab(cgformTab);
		}
		return message;
	}
	
	@RequestMapping(params = "delTab")
	@ResponseBody
	public Map<String, Object> delTab(HttpServletRequest request,HttpServletResponse response) {
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		String msg = "删除成功";
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String id=oConvertUtils.getString(request.getParameter("id"),"");

		if(StringUtil.isNotEmpty(id)){
			String sql = "DELETE FROM cgform_tab WHERE ID='"+id+"'";
			systemService.executeSql(sql);
		}else{
			msg="删除失败";
		} 
		dataMap.put("msg", msg);
		return dataMap;
	}
	
	@RequestMapping(params = "getEndButton")
	@ResponseBody
	public List<CgformButtonEntity> getEndButton(
			String bussTemplateId,
			String versionNum,String defineCode) {
		String sql="select * from cgform_button ";
		sql+=" where 1=1 ";
		sql+="and button_type is not null and button_type<>'' ";
			sql+="and form_id in (select id from cgform_lg_field where "
					+ " show_type='v_formGroupButton'"
					+ "and buss_template_id='"+bussTemplateId+"'"
							+ "and versionnum="+versionNum+" ) order by order_num asc ";
		
		System.out.println("sql:"+sql);
		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		List<CgformButtonEntity> designButtonList = new ArrayList<CgformButtonEntity>();
		if(map!=null&&map.size()>0){
			  for(Map<String, Object> m:map){
				  CgformButtonEntity designButton=new CgformButtonEntity();
			try {
				designButton = DesignGenObject.getCgformButton(m);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			designButtonList.add(designButton);
			  }
		   }
		return designButtonList;
	}
	
	/**
	 * 表单自定义按钮列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CgformButtonEntity designButton, HttpServletRequest req) {
		String sql="select * from cgform_button ";
		sql+=" where id='"+designButton.getId()+"' ";
		System.out.println("sql:"+sql);
		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		if(map!=null&&map.size()>0){
			try {
				designButton = DesignGenObject.getCgformButton(map.get(0));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		req.setAttribute("designButtonPage", designButton);
		return new ModelAndView(prefix+"design/designButton"+suffix);
	}
	
	@RequestMapping(params = "delButton")
	@ResponseBody
	public Map<String, Object> delButton(HttpServletRequest request,HttpServletResponse response) {
		
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		String msg = "删除成功";
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String id=oConvertUtils.getString(request.getParameter("id"),"");

		if(StringUtil.isNotEmpty(id)){
			String sql = "DELETE FROM cgform_button WHERE ID='"+id+"'";
			systemService.executeSql(sql);
		}else{
			msg="删除失败";
		} 
		
		dataMap.put("msg", msg);
		return dataMap;
	}
	
	/**
	 * 添加表单自定义按钮
	 * 
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "saveButton")
	@ResponseBody
	public String saveButton(CgformButtonEntity cgformButton, HttpServletRequest request,HttpServletResponse response) throws Exception {
		String message="";
		if("add".equalsIgnoreCase(cgformButton.getButtonCode())
				||"update".equalsIgnoreCase(cgformButton.getButtonCode())
				||"delete".equalsIgnoreCase(cgformButton.getButtonCode())){
			message = "按钮编码不能是add/update/delete";
			return message;
		}
		String sql="select * from cgform_button ";
  		sql+=" where id='"+cgformButton.getId()+"' ";
  		System.out.println("sql:"+sql);
  		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		if (map!=null&&map.size()>0) {
			message = "更新成功";
			toUpdateButton(cgformButton);
		} else {
			toSaveButton(cgformButton);
		}
		return message;
	}
	
	public  void saveField(CgFormLgFieldEntity cgFormLgField) throws Exception {
//		String sql="INSERT INTO cgform_lg_field  ( ";
//				sql+="buss_template_id,";
//				sql+="id,";
//				sql+="x,";
//				sql+="y,";
//				sql+="w,";
//				sql+="content,";
//				sql+="show_type,";
//				sql+="IS_FORM_HIDE,";
//				sql+="is_show,";
//				sql+="link_buss_code,";
//				sql+="field_alert,";
//				sql+="field_remark,";
//				sql+="is_edit,";
//				sql+="field_name,";
//				sql+="is_notnull,";
//				sql+="field_valid_type,";
//				sql+="is_null,";
////				sql+="table_id,";
//				sql+="BUSS_CODE,";
//				sql+="length,";
//				sql+="type,";
//				sql+="VERSIONNUM,";
//				sql+="is_process_variables,";
//				sql+="main_field,";
//				sql+="main_table,";
//				sql+="detail_field,";
//				sql+="define_id,";
//				sql+="h";
//				sql+=") VALUES ( ";
//				
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getBussTemplateId())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getId())+"',";
//				sql+=""+oConvertUtils.getInt(cgFormLgField.getX(),1)+",";
//				sql+=""+oConvertUtils.getInt(cgFormLgField.getY(),1)+",";
//				sql+=""+oConvertUtils.getInt(cgFormLgField.getW(),3)+",";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getContent())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getShowType())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getIsFormHide())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getIsShow(),"Y")+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getLinkBussCode())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getFieldAlert())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getFieldRemark(),"提示信息")+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getIsEdit())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getFieldName())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getIsNotnull())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getFieldValidType())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getIsNull())+"',";
////				sql+="'"+oConvertUtils.getString(cgFormLgField.getTable().getId())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getBussCode())+"',";
//				sql+=""+oConvertUtils.getInt(cgFormLgField.getLength(),1)+", ";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getType(),"string")+"', ";
//				sql+="'"+oConvertUtils.getInt(cgFormLgField.getVersionNum(),-1)+"', ";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getIsProcessVariables())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getMainField())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getMainTable())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getDetailField())+"',";
//				sql+="'"+oConvertUtils.getString(cgFormLgField.getDefineId())+"',";
//				sql+=""+oConvertUtils.getInt(cgFormLgField.getH(),1)+" ";
//				sql+=" ) ";
				systemService.save(cgFormLgField);
//		systemService.executeSql(sql);
//		System.out.println("sql:"+sql);
	}
	
	
	public  void toSaveTab(CgformTabEntity cgformTab) throws Exception {
		String sql="INSERT INTO cgform_tab  ( ";
				sql+="id,";
				sql+="tab_code,";
				sql+="tab_icon,";
				sql+="tab_name,";
				sql+="tab_status,";
				sql+=" link_buss_code, ";
				sql+=" main_field, ";
				sql+=" detail_field, ";
				sql+="form_id,";
				sql+="define_code,";
				sql+="order_num";
				sql+=") VALUES ( ";
				sql+="'"+oConvertUtils.getString(UUIDGenerator.generate())+"',";
				sql+="'"+oConvertUtils.getString("tab_"+System.currentTimeMillis())+"',";
				sql+="'"+oConvertUtils.getString(cgformTab.getTabIcon())+"',";
				sql+="'"+oConvertUtils.getString(cgformTab.getTabName())+"',";
				sql+="'"+oConvertUtils.getString(cgformTab.getTabStatus())+"',";
				sql+="'"+oConvertUtils.getString(cgformTab.getLinkBussCode())+"', ";
				sql+="'"+oConvertUtils.getString(cgformTab.getMainField())+"', ";
				sql+="'"+oConvertUtils.getString(cgformTab.getDetailField())+"', ";
				sql+="'"+oConvertUtils.getString(cgformTab.getFormId())+"',";
				sql+="'"+oConvertUtils.getString(cgformTab.getDefineCode())+"',";
				sql+=""+oConvertUtils.getInt(cgformTab.getOrderNum(),0)+"";
				sql+=" ) ";
		systemService.executeSql(sql);
		System.out.println("sql:"+sql);
	}
	
	
	public  void toUpdateTab(CgformTabEntity cgformTab) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String sql="update cgform_tab d set ";
				sql+=" tab_code='"+oConvertUtils.getString(cgformTab.getTabCode())+"', ";
				sql+=" tab_icon='"+oConvertUtils.getString(cgformTab.getTabIcon())+"', ";
				sql+=" tab_name='"+oConvertUtils.getString(cgformTab.getTabName())+"', ";
				sql+=" tab_status='"+oConvertUtils.getString(cgformTab.getTabStatus())+"', ";
				sql+=" form_id='"+oConvertUtils.getString(cgformTab.getFormId())+"', ";
				sql+=" link_buss_code='"+oConvertUtils.getString(cgformTab.getLinkBussCode())+"', ";
				sql+=" main_field='"+oConvertUtils.getString(cgformTab.getMainField())+"', ";
				sql+=" detail_field='"+oConvertUtils.getString(cgformTab.getDetailField())+"', ";
				sql+=" order_num="+oConvertUtils.getInt(cgformTab.getOrderNum(),0)+" ";
				sql+=" where d.id='"+oConvertUtils.getString(cgformTab.getId())+"' ";
		systemService.executeSql(sql);
		System.out.println("sql:"+sql);
	}
	
	
	public  void toSaveButton(CgformButtonEntity cgformButton) throws Exception {
		String sql="INSERT INTO cgform_button  ( ";
				sql+="id,";
				sql+="button_code,";
				sql+="button_icon,";
				sql+="button_name,";
				sql+="button_status,";
				sql+="button_style,";
				sql+="button_type,";
				sql+="exp,";
				sql+="form_id,";
				sql+="define_code,";
				sql+="opt_type,";
				sql+="order_num";
				sql+=") VALUES ( ";
				sql+="'"+oConvertUtils.getString(UUIDGenerator.generate())+"',";
				sql+="'"+oConvertUtils.getString("botton_"+System.currentTimeMillis())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getButtonIcon())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getButtonName())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getButtonStatus())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getButtonStyle())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getButtonType())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getExp())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getFormId())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getDefineCode())+"',";
				sql+="'"+oConvertUtils.getString(cgformButton.getOptType())+"',";
				sql+=""+oConvertUtils.getInt(cgformButton.getOrderNum(),0)+"";
				sql+=" ) ";
		systemService.executeSql(sql);
		System.out.println("sql:"+sql);
	}
	
	
	public  void toUpdateButton(CgformButtonEntity cgformButton) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String sql="update cgform_button d set ";
				sql+=" button_code='"+oConvertUtils.getString(cgformButton.getButtonCode())+"', ";
				sql+=" button_icon='"+oConvertUtils.getString(cgformButton.getButtonIcon())+"', ";
				sql+=" button_name='"+oConvertUtils.getString(cgformButton.getButtonName())+"', ";
				sql+=" button_status='"+oConvertUtils.getString(cgformButton.getButtonStatus())+"', ";
				sql+=" button_style='"+oConvertUtils.getString(cgformButton.getButtonStyle())+"', ";
				sql+=" button_type='"+oConvertUtils.getString(cgformButton.getButtonType())+"', ";
				sql+=" exp='"+oConvertUtils.getString(cgformButton.getExp())+"', ";
				sql+=" form_id='"+oConvertUtils.getString(cgformButton.getFormId())+"', ";
				sql+=" opt_type='"+oConvertUtils.getString(cgformButton.getOptType())+"',";
				sql+=" order_num="+oConvertUtils.getInt(cgformButton.getOrderNum(),0)+" ";
				sql+=" where d.id='"+oConvertUtils.getString(cgformButton.getId())+"' ";
		systemService.executeSql(sql);
		System.out.println("sql:"+sql);
	}
	
	public  void updateField(CgFormLgFieldEntity cgFormLgField) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String sql="update cgform_lg_field d set ";
		
				sql+="d.x="+oConvertUtils.getInt(cgFormLgField.getX(),1)+",";
				sql+="d.y="+oConvertUtils.getInt(cgFormLgField.getY(),1)+",";
				sql+="d.w="+oConvertUtils.getInt(cgFormLgField.getW(),3)+",";
				sql+="d.content='"+oConvertUtils.getString(cgFormLgField.getContent())+"',";
				sql+="d.define_id='"+oConvertUtils.getString(cgFormLgField.getDefineId())+"',";
				sql+="d.show_type='"+oConvertUtils.getString(cgFormLgField.getShowType())+"',";
				sql+="d.IS_FORM_HIDE='"+oConvertUtils.getString(cgFormLgField.getIsFormHide())+"',";
				sql+="d.is_show='"+oConvertUtils.getString(cgFormLgField.getIsShow())+"',";
				sql+="d.link_buss_code='"+oConvertUtils.getString(cgFormLgField.getLinkBussCode())+"',";
				sql+="d.field_alert='"+oConvertUtils.getString(cgFormLgField.getFieldAlert())+"',";
				sql+="d.field_remark='"+oConvertUtils.getString(cgFormLgField.getFieldRemark())+"',";
				sql+="d.is_edit='"+oConvertUtils.getString(cgFormLgField.getIsEdit())+"',";
				sql+="d.is_show='"+oConvertUtils.getString(cgFormLgField.getIsShow())+"',";
				sql+="d.is_notnull='"+oConvertUtils.getString(cgFormLgField.getIsNotnull())+"',";
				sql+="d.is_form_hide='"+oConvertUtils.getString(cgFormLgField.getIsFormHide())+"',";
				sql+="d.field_valid_type='"+oConvertUtils.getString(cgFormLgField.getFieldValidType())+"',";
				sql+="d.is_null='"+oConvertUtils.getString(cgFormLgField.getIsNull())+"',";
				sql+="d.buss_template_id='"+oConvertUtils.getString(cgFormLgField.getBussTemplateId())+"',";
				sql+="d.versionNum="+oConvertUtils.getInt(cgFormLgField.getVersionNum(),-1)+",";
				sql+="d.is_process_variables='"+oConvertUtils.getString(cgFormLgField.getIsProcessVariables())+"',";
				sql+="d.field_href='"+oConvertUtils.getString(cgFormLgField.getFieldHref())+"',";
				sql+="d.dict_field='"+oConvertUtils.getString(cgFormLgField.getDictField())+"',";
				sql+="d.dict_table='"+oConvertUtils.getString(cgFormLgField.getDictTable())+"',";
				sql+="d.dict_text='"+oConvertUtils.getString(cgFormLgField.getDictText())+"',";
				sql+="d.main_field='"+oConvertUtils.getString(cgFormLgField.getMainField())+"',";
				sql+="d.main_table='"+oConvertUtils.getString(cgFormLgField.getMainTable())+"',";
				sql+="d.detail_field='"+oConvertUtils.getString(cgFormLgField.getDetailField())+"',";
				sql+="d.field_default='"+oConvertUtils.getString(cgFormLgField.getFieldDefault())+"',";
				sql+="d.window_height='"+oConvertUtils.getString(cgFormLgField.getWindowHeight())+"',";
				sql+="d.window_width='"+oConvertUtils.getString(cgFormLgField.getWindowWidth())+"',";
				sql+="d.input_id='"+oConvertUtils.getString(cgFormLgField.getInputId())+"',";
				sql+="d.select_id='"+oConvertUtils.getString(cgFormLgField.getSelectId())+"',";
				sql+="d.where_para='"+oConvertUtils.getString(cgFormLgField.getWherePara())+"',";
				sql+="d.h="+oConvertUtils.getInt(cgFormLgField.getH(),1)+" ";
				sql+="where d.id='"+oConvertUtils.getString(cgFormLgField.getId())+"'";
		
		
		systemService.executeSql(sql);
		System.out.println("sql:"+sql);
	}
	
	
	@RequestMapping(params = "mconfigure")
	public ModelAndView mConfigure(CgFormLgHeadEntity cgFormHead, HttpServletRequest req,HttpServletResponse response) throws Exception {
		//增加授权
//				String authType =ParameterUtil.ATC_K;
//				int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//					if(!LicenseUtil.valid(authType, randomCode)){
//						return new ModelAndView("redirect:/authController.do?register&flag=1");
//					}
		int versionNum = oConvertUtils.getInt(req.getParameter("versionNum"),0);
		String bussTemplateId = oConvertUtils.getString(req.getParameter("bussTemplateId"),"");//显示模板ID
		String bussCode = oConvertUtils.getString(req.getParameter("bussCode"));
		CgformBussEntity tSConfigform = systemService
				.findUniqueByProperty(CgformBussEntity.class, "bussCode",
						bussCode);
		CgformDefineEntity define = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "id",
						tSConfigform.getDefineId());
		
//		if(StringUtil.isEmpty(bussTemplateId)){
//			String sql="select t.id from t_s_buss_template t,cgform_define c   where t.CONFIGFORM_ID= c.id and t.TEMPLATE_TYPE='0' ";
//			sql+=" and c.define_code='"+bussCode+"' ";
//			System.out.println("sql:"+sql);
//			 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
//			 if(map!=null&&map.size()>0){
//				 bussTemplateId=map.get(0).get("id").toString();
//			 }
//		}
			req.setAttribute("list", getCgFormLgField(bussTemplateId,define.getDefineCode(),versionNum));
			req.setAttribute("cgFormHeadPage", getCgFormLgHead(define.getDefineCode()));
		return new ModelAndView(prefix+"design/tSConfigform-mConfigure"+suffix);
	}
	
	
	/**
	 * 根据表名和业务编码获取逻辑视图
	 * @throws Exception 
	 */
	public CgFormLgHeadEntity getCgFormLgHead(String linkBussCode) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String sql="select * from cgform_lg_field ";
		sql+=" where BUSS_CODE='"+linkBussCode+"' ";
		System.out.println("sql:"+sql);
		 List<Map<String, Object>> map = systemService.findForJdbc(sql);  
		List<CgFormLgHeadEntity> cgFormLgHeadList = new ArrayList<CgFormLgHeadEntity>();
		if(map!=null&&map.size()>0){
			  for(Map<String, Object> m:map){
			  CgFormLgHeadEntity cgFormLgHead=new CgFormLgHeadEntity();
			try {
				cgFormLgHead = DesignGenObject.getCgFormLgHead(m);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  cgFormLgHeadList.add(cgFormLgHead);
			  }
		   }
		return cgFormLgHeadList.get(0);
	}
	
	
	
	public List<CgFormLgFieldEntity> getCgFormLgField(String bussTemplateId,String bussCode,int versionNum) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		List<CgFormLgFieldEntity> cgFormLgFieldList=new ArrayList<CgFormLgFieldEntity>();
		
		  CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
			cq.eq("bussCode", bussCode);
			cq.addOrder("y", SortDirection.asc);//需按照此排序才能知道第一个是否属于按钮，如果是按钮的话需要处理
			cq.add();
			List<CgFormLgFieldEntity> cgFormLgFieldList_old = systemService.getListByCriteriaQuery(cq, false);
		   int x1_=0;
		   if(cgFormLgFieldList_old!=null&&cgFormLgFieldList_old.size()>0){
			  for(CgFormLgFieldEntity m1:cgFormLgFieldList_old){
			   CgFormLgFieldEntity cgFormLgField=new CgFormLgFieldEntity();
			try {
				cgFormLgField = DesignGenObject.getCgFormLgField(m1,x1_,"",false);//此处不需要过滤按钮
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   cgFormLgFieldList.add(cgFormLgField);
		   }
 	}
		   return cgFormLgFieldList;
	}
	
	
	@RequestMapping(params = "save")
	@ResponseBody
	public String save(CgFormLgHeadEntity cgFormLgHead, HttpServletRequest request,HttpServletResponse response) throws Exception {
		////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		String message = "系统配置信息更新成功";
		List<CgFormLgFieldEntity> formFieldEntities =ConvertArrayListUtil.requets2List(request, CgFormLgFieldEntity.class, "columns", "fieldName");
		try {
			for (int i =0 ;i<formFieldEntities.size();i++) {
				CgFormLgFieldEntity cgFormLgField=formFieldEntities.get(i);
				
				if (("on").equals(cgFormLgField.getIsFormDetailEdit())) {
					cgFormLgField.setIsFormDetailEdit("Y");
				} else {
					cgFormLgField.setIsFormDetailEdit("N");
				}

				if (("on").equals(cgFormLgField.getIsShow())) {
					cgFormLgField.setIsShow("Y");
				} else {
					cgFormLgField.setIsShow("N");
				}
				if (("on").equals(cgFormLgField.getIsShowList())) {
					cgFormLgField.setIsShowList("Y");
				} else {
					cgFormLgField.setIsShowList("N");
				}

				if (("on").equals(cgFormLgField.getIsEdit())) {
					cgFormLgField.setIsEdit("Y");
				} else {
					cgFormLgField.setIsEdit("N");
				}
				if (("on").equals(cgFormLgField.getIsNotnull())) {
					cgFormLgField.setIsNotnull("Y");
				} else {
					cgFormLgField.setIsNotnull("N");
				}
				if (("on").equals(cgFormLgField.getIsFormHide())) {
					cgFormLgField.setIsFormHide("Y");
				} else {
					cgFormLgField.setIsFormHide("N");
				}
				if (("on").equals(cgFormLgField.getIsListHide())) {
					cgFormLgField.setIsListHide("Y");
				} else {
					cgFormLgField.setIsListHide("N");
				}
				String sql="update cgform_lg_field d set ";
				
				sql+="d.is_show='"+oConvertUtils.getString(cgFormLgField.getIsShow())+"',";
				sql+="d.is_show_list='"+oConvertUtils.getString(cgFormLgField.getIsShowList())+"',";
				sql+="d.IS_EDIT='"+oConvertUtils.getString(cgFormLgField.getIsEdit())+"',";
				sql+="d.IS_NOTNULL='"+oConvertUtils.getString(cgFormLgField.getIsNotnull())+"',";
				sql+="d.field_remark='"+oConvertUtils.getString(cgFormLgField.getFieldRemark())+"',";
				sql+="d.IS_LIST_HIDE='"+oConvertUtils.getString(cgFormLgField.getIsListHide())+"',";
				sql+="d.IS_PROCESS_VARIABLES='"+oConvertUtils.getString(cgFormLgField.getIsProcessVariables())+"',";
				sql+="d.IS_FORMDETAIL_EDIT='"+oConvertUtils.getString(cgFormLgField.getIsFormDetailEdit())+"',";
				sql+="d.content='"+oConvertUtils.getString(cgFormLgField.getContent())+"',";
				sql+="d.link_buss_code='"+oConvertUtils.getString(cgFormLgField.getLinkBussCode())+"',";
				sql+="d.show_type='"+oConvertUtils.getString(cgFormLgField.getShowType())+"' ";
				sql+=" where d.id='"+oConvertUtils.getString(cgFormLgField.getId())+"'";
				System.out.println("sql:"+sql);
				systemService.executeSql(sql);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "系统配置信息更新失败";
		}
		return "";
	}

	public List<Map<String, Object>> getField(String linkBussCode,
			String bussTemplateId, String versionNum) {
		String sql=" SELECT	this_.* FROM " +
				   " cgform_lg_field this_  " +
				   " WHERE	 this_.BUSS_CODE='"+linkBussCode+"' ";
		   sql+="  and this_.is_show_list='Y' order by this_.order_num asc";
		   System.out.println("sql:"+sql);
		   List<Map<String, Object>> map1 = systemService.findForJdbc(sql);
		return map1;
	}
	
	@RequestMapping(params = "getTableBody")
	@ResponseBody
	public List<Map<String, Object>> getTableBody(HttpServletRequest request) throws Exception {
		String linkBussCode = oConvertUtils.getString(request.getParameter("linkBussCode"));
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"));
		String versionNum = oConvertUtils.getString(request.getParameter("versionNum"));
		CgformBussEntity tSConfigform = systemService
				.findUniqueByProperty(CgformBussEntity.class, "bussCode",
						linkBussCode);
		CgformDefineEntity define = systemService
				.findUniqueByProperty(CgformDefineEntity.class, "id",
						tSConfigform.getDefineId());
		List<Map<String, Object>> map1 = getField(define.getDefineCode(),
				bussTemplateId, versionNum);
		return map1;
	}
	
	
	
	
	@RequestMapping(params = "getIndexTree")
	@ResponseBody
	public JSONArray getIndexTree(HttpServletRequest request) throws Exception {
		String indexExtId = oConvertUtils.getString(request.getParameter("indexExtId"));
		String defineId = oConvertUtils.getString(request.getParameter("defineId"));
		String sql="select t.* from cgform_report_index t where 1=1 ";
		if(StringUtil.isNotEmpty(indexExtId)){
			sql+=" and  group_id='"+indexExtId+"'";
		}else{
			sql+=" and (group_id='' or group_id is null) ";
		}
		List<Map<String, Object>> selectList = systemService.findForJdbc(sql);
		
		CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class,defineId);
		
		
		JSONArray rows = new JSONArray();
		if(selectList!=null && selectList.size()>0){
			for(int i=0;i<selectList.size();i++){
            	JSONObject node = new JSONObject();
            	Map<String, Object> selec=selectList.get(i);
            	
				node.put("id", oConvertUtils.getString(selec.get("id"), ""));
				node.put("indexExtId", oConvertUtils.getString(selec.get("id"), ""));
				node.put("fieldName", oConvertUtils.getString(selec.get("field_name"), ""));
				node.put("showType", oConvertUtils.getString(selec.get("show_type"), ""));
				node.put("inputId", oConvertUtils.getString(selec.get("input_id"), ""));
				if("隐藏的值,显示的值".equals(selec.get("input_id")) && tSConfigform!=null){
					node.put("inputId", ""+tSConfigform.getDefineCode()+"@"+oConvertUtils.getString(selec.get("field_name"), "")+",showName_"+tSConfigform.getDefineCode()+"_"+oConvertUtils.getString(selec.get("field_name"), "")+",");
				}
				node.put("dictField", oConvertUtils.getString(selec.get("dict_field"), ""));
				node.put("dictText", oConvertUtils.getString(selec.get("dict_text"), ""));
				node.put("fieldHref", oConvertUtils.getString(selec.get("field_href"), ""));
				node.put("selectId", oConvertUtils.getString(selec.get("select_id"), ""));
				node.put("windowHeight", oConvertUtils.getString(selec.get("window_height"), ""));
				node.put("windowWidth", oConvertUtils.getString(selec.get("window_width"), ""));
				node.put("defineId",defineId);
				node.put("type",oConvertUtils.getString(selec.get("type"), ""));
				node.put("length",oConvertUtils.getString(selec.get("length"), ""));
				node.put("checked", false);
				node.put("name", oConvertUtils.getString(selec.get("content"), ""));
				node.put("isParent", false);
				Map<String, Object> ew1 = systemService.findOneForJdbc("SELECT count(*) countIndex FROM cgform_lg_field where define_id='"+defineId+"' and index_ext_id='"+selec.get("id")+"' ");
				if(oConvertUtils.getInt(ew1.get("countIndex"),0)>0){
					node.put("checked", true);
				}
				List<Map<String, Object>> ew = systemService.findForJdbc("select t.* from cgform_report_index t where group_id='"+selec.get("id")+"' ");
				if(ew!=null&&ew.size()>0){
					node.put("isParent", true);
				}
				rows.add(node);
			}
		}
		return rows;
	}
	
	/**
	 * 获得城市数据
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getCityData",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getCityData(HttpServletRequest request) throws Exception {
		String pid = oConvertUtils.getString(request.getParameter("pid"));
		String returnData=HttpClientUtil.executeByGET(cityDataJsonUrl+"&pid="+pid);
//		List<Map<String, Object>> ew = systemService.findForJdbc("select t.* from test_city t where 1=1 "+(pid!=""?" and pid='"+pid+"' ":"")+"  ");
//		JSONArray rows = JSONArray.fromObject(ew);
//		System.out.println("returnData:====="+rows.toString());
//		return rows.toString();
		if(StringUtil.isNotEmpty(returnData)){
			if(!returnData.startsWith("[")){
				JSONObject rows = JSONObject.fromObject(returnData);
				JSONArray rows1 = JSONArray.fromObject(rows.get("data"));
				System.out.println("returnData:====="+rows1.toString());
				return rows1.toString();
			}
			JSONArray rows = JSONArray.fromObject(returnData);
			System.out.println("returnData:====="+rows.toString());
			return rows.toString();
		}
		return new JSONArray().toString();
	}
	
	
	
	@RequestMapping(params = "getSelectList")
	@ResponseBody
	public JSONArray getSelectList(HttpServletRequest request,HttpServletResponse response) {
		List<Map<String, Object>> selectList = systemService.findForJdbc("select t.* from cgform_select_back t ");
		JSONArray rows = new JSONArray();
		JSONObject node = new JSONObject();
		node.put("id", "");
		node.put("name", "");
		node.put("va", "");
		node.put("sub", "");
		rows.add(node);
			if(selectList!=null && selectList.size()>0){
				for(Map<String, Object> selec : selectList){
					node = new JSONObject();
						node.put("id", oConvertUtils.getString(selec.get("s_code"), ""));
						node.put("name", oConvertUtils.getString(selec.get("s_name"), ""));
						node.put("va", oConvertUtils.getString(selec.get("s_code"), ""));
						List<Map<String, Object>> fieldList = systemService.findForJdbc("select t.* from cgform_select_field t where main_id='"+oConvertUtils.getString(selec.get("id"), "")+"' ");
						String fields="";
						if(fieldList!=null&&fieldList.size()>0){
							for(Map<String, Object> f:fieldList){
								 fields+=f.get("field_code")+"#"+f.get("field_name")+"@";
							}
							fields=fields.substring(0, fields.length()-1);
						}
						node.put("sub", fields);
						rows.add(node);
				}
			}
	return rows;
	}
	
	
	@RequestMapping(params = "getJson")
	@ResponseBody
	public Map<String, Object> getJson(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String linkBussCode = oConvertUtils.getString(request.getParameter("linkBussCode"));
		String isTask = oConvertUtils.getString(request.getParameter("isTask"));//任务办理中
		String businessCode=oConvertUtils.getString(request.getParameter("businessCode"),"");
		int versionNum=oConvertUtils.getInt(request.getParameter("versionNum"),-1);
		Map<String, Object> cgFormMap=new HashMap<String, Object>();
		Map<String, Object> cgFormLgFieldMap=new HashMap<String, Object>();
		List<CgFormLgFieldEntity> cgFormLgFieldList=new ArrayList<CgFormLgFieldEntity>();
		CgformDefineEntity tSConfigform = systemService.findUniqueByProperty(CgformDefineEntity.class, "defineCode",businessCode);
			try {
				cgFormMap.put("tSConfigform", tSConfigform);
				   if(tSConfigform!=null){
					   CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
						cq.eq("defineId", tSConfigform.getId());
						cq.eq("versionNum", versionNum);
						cq.addOrder("y", SortDirection.asc);//需按照此排序才能知道第一个是否属于按钮，如果是按钮的话需要处理
						cq.add();
						List<CgFormLgFieldEntity> cgFormLgFieldList_old = systemService.getListByCriteriaQuery(cq, false);
					   int x1_=0;
					   boolean y1= false;
					   if(cgFormLgFieldList_old!=null&&cgFormLgFieldList_old.size()>0){
						  for(CgFormLgFieldEntity m1:cgFormLgFieldList_old){
						   if (x1_ == 12) {
							   x1_=0;
						   }
						   CgFormLgFieldEntity cgFormLgField = DesignGenObject.getCgFormLgField(m1,x1_,isTask,y1);
						   if(cgFormLgField!=null){
							   cgFormLgFieldList.add(cgFormLgField);
						   }else{
							   y1= true;
						   }
						   x1_=x1_+3;
					   }
			    	}else{//如果未查询到字段信息，说明是新增业务，需要生成主键等字段信息
			    		String [] sq={"id#50#string#text#id",
			    				"create_date#0#Date#datetime#创建时间",
			    				"create_by#150#string#text#创建人",
			    				"create_name#150#string#text#创建人名称",
			    				"org_id#350#string#text#单位id",
			    				"org_name#350#string#text#单位名称",
			    				"update_by#150#string#text#更新人",
			    				"update_name#150#string#text#更新人名称",
			    				"update_date#0#Date#datetime#更新时间",
			    				"buss_id#50#string#text#业务id",
			    				"status#50#string#text#状态"};
			    		for(String w:sq){
			    			String[] w1=w.split("#");
			    			CgFormLgFieldEntity cgFormLgField = new CgFormLgFieldEntity();
				    		cgFormLgField.setContent(w1[4]);
				    		cgFormLgField.setBussCode(tSConfigform.getDefineCode());
				    		cgFormLgField.setDefineId(tSConfigform.getId());
				    		cgFormLgField.setFieldName(w1[0]);
				    		cgFormLgField.setLength(oConvertUtils.getInt(w1[1]));
				    		cgFormLgField.setType(w1[2]);
				    		cgFormLgField.setShowType(w1[3]);
				    		cgFormLgField.setIsShow("Y");
				    		cgFormLgField.setIsFormHide("Y");
				    		cgFormLgField.setVersionNum(-1);
				    		cgFormLgField.setW(12);
				    		cgFormLgField.setH(1);
				    		systemService.save(cgFormLgField);
				    		cgFormLgFieldList.add(cgFormLgField);
			    		}
			    	}
					   cgFormLgFieldMap.put(tSConfigform.getId(), cgFormLgFieldList);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cgFormMap.put("designBusinessMList", tSConfigform);
			cgFormMap.put("designBusinessDMap", cgFormLgFieldMap);
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[] { "table","columns","updateDate","createDate"});//排除不形成json
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONObject jsonObject = JSONObject.fromObject(cgFormMap,config);
		return jsonObject;
	}
	
	
	
	
	
	@RequestMapping(params = "getUserDefinedJsTextData")
	@ResponseBody
	public Map<String, Object> getUserDefinedJsTextData(HttpServletRequest request,HttpServletResponse response) {
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		String businessCode=oConvertUtils.getString(request.getParameter("businessCode"),"");
		String versionNum=oConvertUtils.getString(request.getParameter("versionNum"),"");
		String nodeCode=oConvertUtils.getString(request.getParameter("nodeCode"),"");
		String jsS=designWebPath+"designPlug-in/design-js/"+businessCode;
		if(StringUtil.isNotEmpty(nodeCode)){
			jsS+="/"+nodeCode;
		}
		File file = new File(jsS);
		if(!file.exists()){
			file.mkdirs();
		}
		jsS+="/v"+versionNum+".js";
		file = new File(jsS);
		Map<String, Object> dataMap=new HashMap<String, Object>();
		FileInputStream in = null; 
		BufferedReader reader = null;
		StringBuffer jsHtml = new StringBuffer();
		try {
			if (!file.exists()) {
				//如果文件不存在则创建该文件,然后从默认模板中读取文件内容
				File defaultJs = new File(designWebPath+"designPlug-in/design-js/default/default.js");
				in = new FileInputStream(defaultJs);
				reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            String tempString = "";
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                System.out.println("line " + line + ": " + tempString);
	                jsHtml.append(tempString);
	                jsHtml.append("\r\n");//换行用,不然返回页面会出现乱码
	                line++;
	            }
				file.createNewFile();
				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream(file), "UTF-8");
				out.write(jsHtml.toString());
				out.flush();
				out.close();
				
			}else{
				in = new FileInputStream(file);
				reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            String tempString = "";
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                System.out.println("line " + line + ": " + tempString);
	                jsHtml.append(tempString);
	                jsHtml.append("\r\n");//换行用,不然返回页面会出现乱码
	                line++;
	            }
	            reader.close();	
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	e1.printStackTrace();
                }
            }
        }
		dataMap.put("UserDefinedJsText", jsHtml.toString());
		return dataMap;
	}
	
	
	@RequestMapping(params = "updateUserDefinedJsTextData")
	@ResponseBody
	public Map<String, Object> updateUserDefinedJsTextData(HttpServletRequest request,HttpServletResponse response) {
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		String msg = "1";
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String businessCode=oConvertUtils.getString(request.getParameter("businessCode"),"");
		String UserDefinedJsText=oConvertUtils.getString(request.getParameter("jsText"),"");
		String versionNum=oConvertUtils.getString(request.getParameter("versionNum"),"");
		String nodeCode=oConvertUtils.getString(request.getParameter("nodeCode"),"");
		String jsS=designWebPath+"designPlug-in/design-js/"+businessCode;
		if(StringUtil.isNotEmpty(nodeCode)){
			jsS+="/"+nodeCode;
			
		}
		File file = new File(jsS);
		if(!file.exists()){
			file.mkdirs();
		}
		jsS+="/v"+versionNum+".js";
		file = new File(jsS);
		try {
			if (!file.exists()) {
				//如果文件不存在则创建该文件
				file.createNewFile();
			}
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8");
			out.write(UserDefinedJsText.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			msg="0";
			e.printStackTrace();
		} 
		dataMap.put("msg", msg);
		return dataMap;
	}
	
	
	@RequestMapping(params = "saveEventJs")
	@ResponseBody
	public Map<String, Object> saveEventJs(JsJsonList jsJsonList,HttpServletRequest request,HttpServletResponse response) throws Exception {
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		String msg = "1";
		
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String businessCode=oConvertUtils.getString(request.getParameter("businessCode"),"");
//		String versionNum=oConvertUtils.getString(request.getParameter("versionNum"),"");
//		String nodeCode=oConvertUtils.getString(request.getParameter("nodeCode"),"");
//		if(StringUtil.isNotEmpty(nodeCode)){
//			jsS+="/"+nodeCode;
//		}
//		String jsS=designWebPath+"designPlug-in/design-js/"+businessCode;
//		File file = new File(jsS);
//		if(!file.exists()){
//			file.mkdirs();
//		}
//		jsS+="/JsEvent.json";
		
		
		
		CgformDefineJsEntity cgformDefineJs = null;
		CriteriaQuery cq1 = new CriteriaQuery(CgformDefineJsEntity.class);
  		cq1.eq("defineCode", businessCode);
  		cq1.add();
  		List<CgformDefineJsEntity> cgformDefineJsList= systemService.getListByCriteriaQuery(cq1, false);
		if(cgformDefineJsList!=null&&cgformDefineJsList.size()>0){
			cgformDefineJs=cgformDefineJsList.get(0);
		}
		
		
//		file = new File(jsS);
//		try {
//			if (!file.exists()) {
//				//如果文件不存在则创建该文件
//				file.createNewFile();
//			}
//			try {
				//取出已经生成的json文件中的数据
				Map<String ,Object> jList=new HashMap<String ,Object>();
				Map<String ,Object> oldjList=new HashMap<String ,Object>();
//				String input = FileUtils.readFileToString(new File(jsS), "UTF-8");
				String input ="";
				if(cgformDefineJs!=null&&StringUtil.isNotEmpty(cgformDefineJs.getJson())){
					input =cgformDefineJs.getJson();
				}
	            
	            if(StringUtil.isNotEmpty(input)){
		            JSONArray oldArray = JSONArray.fromObject(input);
		            if(oldArray!=null&&oldArray.size()>0){
		    			for(int i=0;i<oldArray.size();i++){
		    				 JSONObject oldjson = JSONObject.fromObject(oldArray.get(i));
		    				 Iterator<String> iterator1 =oldjson.keys();
		    			        while(iterator1.hasNext()){
		    			        	String key1 = iterator1.next();
		    			        	oldjList.put(key1, oldjson.get(key1));
		    			        }
		    				 if(oldjson.containsKey(jsJsonList.getFieldName())){
		    					 JSONArray oldjsonA1 = JSONArray.fromObject(oldjson.get(jsJsonList.getFieldName()));
		    					 boolean isadd=true;
		    					 for(int i1=0;i1<oldjsonA1.size();i1++){
		    						 JSONObject jobj = JSONObject.fromObject(oldjsonA1.get(i1));
		    						 JSONObject jobj1 = JSONObject.fromObject(jsJsonList.getJsJson());
		    						 if(jobj1.get("id").equals(jobj.get("id"))){
		    							 oldjsonA1.remove(jobj);//删除老的
		    							 oldjsonA1.add(jobj1);//添加新的
		    							 isadd=false;
		    						 }
		    					 }
		    					 if(isadd){
		    						 oldjsonA1.add(jsJsonList.getJsJson());//添加新的
		    					 }
		    					 jList.put(jsJsonList.getFieldName(), oldjsonA1);
		    				 }else{
		    					 jList.put(jsJsonList.getFieldName(), jsJsonList.getJsJson());
		    				 }
		    			}
		    			if(oldjList.containsKey(jsJsonList.getFieldName())){
		    				oldjList.remove(jsJsonList.getFieldName());//
		    			}
	    				for (Map.Entry<String, Object> entry : oldjList.entrySet()) {
	    					jList.put(entry.getKey(), entry.getValue());
    			        }
		    		}
	            }else{
	            	jList.put(jsJsonList.getFieldName(), jsJsonList.getJsJson());
	            }
	            JSONObject jobj = JSONObject.fromObject(jList);
	            if(cgformDefineJs!=null){
	            	cgformDefineJs.setJson("["+jobj.toString()+"]");
	            	systemService.updateEntitie(cgformDefineJs);
	            }else{
	            	cgformDefineJs=new CgformDefineJsEntity();
	            	cgformDefineJs.setDefineCode(businessCode);
	            	cgformDefineJs.setJson("["+jobj.toString()+"]");
	            	systemService.save(cgformDefineJs);
	            }
//	            OutputStreamWriter out = new OutputStreamWriter(
//						new FileOutputStream(file), "UTF-8");
//				out.write("["+jobj.toString()+"]");
//				out.flush();
//				out.close();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//		} catch (IOException e) {
//			msg="0";
//			e.printStackTrace();
//		}
		dataMap.put("msg", msg);
		return dataMap;
	}
	
	
	@RequestMapping(params = "deleteWidget")
	@ResponseBody
	public Map<String, Object> deleteWidget(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String field_name=oConvertUtils.getString(request.getParameter("field_name"),"");
		String defineId=oConvertUtils.getString(request.getParameter("defineId"),"");
		dataMap.put("msg", "删除成功！");
		dataMap.put("success", true);
		CgformDefineEntity tSConfigform = systemService
				.getEntity(CgformDefineEntity.class,defineId);
		String sql = "update  cgform_lg_field set define_id='"+tSConfigform.getId()+"_del',buss_code='"+tSConfigform.getDefineCode()+"_del' where buss_code='"+tSConfigform.getDefineCode()+"' and  field_name='"+field_name+"'";
		systemService.executeSql(sql);
		
//			String tableName=tSConfigform.getMtableName();
//			if(tSConfigform!=null&&"2".equals(tSConfigform.getSaveType())){
//				tableName="cgform_rdata_master";
////				List<Map<String, Object>> rr1 = systemService.findForJdbc("select "+rr.get(0).get("field_name")+" FROM "+tableName+" where "+rr.get(0).get("field_name")+" is not null and "+rr.get(0).get("field_name")+" <>''");
//				String sql = "DELETE FROM CGFORM_LG_FIELD WHERE CGFORM_LG_FIELD.ID='"+design_id+"'";
//				systemService.executeSql(sql);
//			}else{
//				List<Map<String, Object>> rr1 = systemService.findForJdbc("select "+rr.get(0).get("field_name")+" FROM "+tableName+" where "+rr.get(0).get("field_name")+" is not null and "+rr.get(0).get("field_name")+" <>''");
//				if(rr1!=null&&rr1.size()>0){
//					dataMap.put("msg", "该字段中已经存储数据，不能删除！");
//					dataMap.put("success", false);
//				}else{
//					String sql = "DELETE FROM CGFORM_LG_FIELD WHERE CGFORM_LG_FIELD.ID='"+design_id+"'";
//					systemService.executeSql(sql);
					sql = "update  cgform_buss_list set define_id='"+tSConfigform.getId()+"_del' where define_id='"+tSConfigform.getId()+"' and field_name='"+field_name+"'";
					systemService.executeSql(sql);
					sql = "update cgform_buss_query set define_id='"+tSConfigform.getId()+"_del' where define_id='"+tSConfigform.getId()+"' and field_name='"+field_name+"'";
					systemService.executeSql(sql);
					sql = "update cgform_field_temp set define_id='"+tSConfigform.getId()+"_del' where define_id='"+tSConfigform.getId()+"' and field_name='"+field_name+"'";
					systemService.executeSql(sql);
//				}
//			}
		
		return dataMap;
	}
	
	
	@RequestMapping(params = "getDictDataHtml")
	@ResponseBody
	public Map<String, Object> getDictDataHtml(HttpServletRequest request,HttpServletResponse response) {
		//获取页面传递过来的业务编码同时也是JS文件的文件名
		String msg = "1";
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String mainId=oConvertUtils.getString(request.getParameter("mainId"),"");
		String selectid=oConvertUtils.getString(request.getParameter("selectid"),"");
		String fieldhref=oConvertUtils.getString(request.getParameter("fieldhref"),"");
		String defaultValue=oConvertUtils.getString(request.getParameter("defaultValue"),"");
		if(selectid.endsWith(",")){
			selectid=selectid.substring(0, selectid.length()-1);
			}
		selectid=selectid.replace(",", " as typecode,");
		selectid=selectid+" as typename";
		List<Map<String, Object>> rr1 =null;
		
		
		//获取数据字典CODE t1.show_type,t1.dict_field,t1.is_notnull,t1.field_length,t1.is_null,t1.t1.field_alert,t1.field_default,t1.field_href,t1.field_name
//		String cgformsql = "SELECT t1.* FROM cgform_lg_field t1 where t1.id='"+design_id+"' ";
//		List<Map<String, Object>> cgformList = systemService.findForJdbc(cgformsql);
//		if(cgformList.size()>0 && StringUtil.isNotEmpty(cgformList.get(0).get("dict_field"))){
			/**组装数据字典**/
			List<Map<String, Object>> dictDataList = new ArrayList<Map<String, Object>>();
			if(StringUtil.isNotEmpty(mainId)){
				 rr1 = systemService.findForJdbc("select json_sql from cgform_select_back where id='"+mainId+"'");
			}else{
				 rr1 = systemService.findForJdbc("select json_sql from cgform_select_back where s_code='"+fieldhref+"'");
			}
			
			if(rr1!=null&&rr1.size()>0&&StringUtil.isNotEmpty(selectid)){
				String sql = " SELECT "+selectid+",'' field_name,'' is_notnull,'' field_alert  FROM ("+rr1.get(0).get("json_sql")+") as w ";
				dictDataList = systemService.findForJdbc(sql);
				if (dictDataList.size()>0 && dictDataList != null) {
					StringBuffer sb = new StringBuffer();
			     	sb.append("{");
			        sb.append("\"count\":" + dictDataList.size() + ",");
			        sb.append("\"resultList\":");
			        JSONArray jsonArray = JSONArray.fromObject(dictDataList);
			        sb.append(jsonArray);
			        sb.append("}");
			        dataMap.put("dictDataList", sb.toString());
				}
			}
//		}
		
		return dataMap;
	}
	
}
