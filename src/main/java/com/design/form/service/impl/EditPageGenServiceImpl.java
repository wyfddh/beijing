package com.design.form.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.AjaxJson;
import com.design.core.common.model.json.SortDirection;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformDefineEntity;
import com.design.entity.CgformFieldTempEntity;
import com.design.entity.CgformRdataChistoryEntity;
import com.design.entity.CgformRdataDetailEntity;
import com.design.entity.CgformRdataMasterEntity;
import com.design.form.service.EditPageGenServiceI;
import com.design.utils.ConvertArrayListUtil;
import com.design.utils.DateUtils;
import com.design.utils.ParameterUtil;
import com.design.utils.ReflectHelper;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.UUIDGenerator;
import com.design.utils.oConvertUtils;
import com.zxlhdata.framework.auth.util.LicenseUtil;

@Service("editPageGenService")
@Transactional
public class EditPageGenServiceImpl  implements
		EditPageGenServiceI {

	@Autowired
	private SystemService systemService;

	
	/**
	 * 查询主业务数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> getBussDataJson(Map<String, Object> pMap,HttpServletRequest request) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TSUser user = ResourceUtil.getSessionUserName();
//		Map<String, TSRole> roles = ResourceUtil.getSessionTSRole();
		String mainId=oConvertUtils.getString(pMap.get("mainId"),"");
		String taskId=oConvertUtils.getString(pMap.get("taskId"),"");
		String bussCode=oConvertUtils.getString(pMap.get("bussCode"),"");
		int versions = oConvertUtils.getInt(pMap.get("versionNum"),-1);
		String bussTemplateId = oConvertUtils.getString(pMap.get("bussTemplateId"),"");
		StringBuffer ssq = new StringBuffer();
		List<Map<String, Object>> mapVal = new ArrayList<Map<String, Object>>();
		Map<String, Object> mainMap = new HashMap<String, Object>();
		List<Map<String, Object>> mainListMap = new ArrayList<Map<String, Object>>();
		CgformDefineEntity cgformDefine = systemService.findUniqueByProperty(
				CgformDefineEntity.class, "defineCode", bussCode);
		String mainTableName = "";
		if (cgformDefine != null) {
//			detailTableName = tSConfigform.getDtableName();
			mainTableName = cgformDefine.getMtableName();
		}
		mainId = mainId.replace(",", "','");
		taskId = taskId.replace(",", "','");
		List<CgFormLgFieldEntity> mainList = getFieldByTable(mainTableName,bussCode,new String[]{"isShow"},bussTemplateId,versions);
		String linkBussCode="";
		List<Map<String, Object>> ww1 =null;
		Map<String, Object> dataFieldMap = new HashMap<String, Object>();
		if("2".equals(cgformDefine.getSaveType())){//键值保存方式
			ssq.append(" SELECT * ");
			ssq.append(" FROM cgform_rdata_detail ");
			ssq.append(" where 1=1 ");
			//主要是为了区分流程中表单数据的存储，流程中表单必须配置taskId字段
			ssq.append("  and  master_id='" + mainId + "' ");
			List<Map<String, Object>> ww2 = systemService.findForJdbc(ssq
					.toString());
			for(Map<String, Object> m1:ww2){
				dataFieldMap.put(m1.get("field_name").toString().toUpperCase(), m1.get("field_value"));
			}
			dataFieldMap.put("ID", mainId);
		}else{
			//查询主表数据
			if (mainList != null && mainList.size() > 0) {
				
				String mainsQL = systemService.assemblyTableFieldSql(mainList, mainTableName);
				ssq.append(" SELECT ");
				ssq.append(mainsQL);
				ssq.append(" FROM "+mainTableName+" ");
				ssq.append(" where 1=1 ");
				//主要是为了区分流程中表单数据的存储，流程中表单必须配置taskId字段
				if(StringUtil.isNotEmpty(taskId)&&StringUtil.isEmpty(cgformDefine.getProcessKey())){
					ssq.append("  and  "+mainTableName + ".task_id in('" + taskId + "') ");
				}else{
					ssq.append("  and  "+mainTableName + ".ID in('" + mainId + "') ");
				}
//				ssq.append("  ORDER BY  "+mainTableName+".create_date desc ");//后续应该配置排序字段或语句
				ww1 = systemService.findForJdbc(ssq
						.toString());
				
			}
		}
				for (int iq = 0; iq < mainList.size(); iq++) {
					Map<String, Object> trMap = new HashMap<String, Object>();
					CgFormLgFieldEntity cgFormField = mainList.get(iq);
					trMap.put("id",bussCode+"@"+oConvertUtils.getString(cgFormField.getFieldName(),""));
					String defval = "";
						if("2".equals(cgformDefine.getSaveType())){//键值保存方式
							defval = replaceEnter(oConvertUtils.getString(dataFieldMap.get(cgFormField.getFieldName().toUpperCase()), ""));
						}else{
							if(ww1!=null&&ww1.size()>0){
								defval = replaceEnter(oConvertUtils.getString(ww1.get(0).get(cgFormField.getFieldName().toUpperCase()), ""));
							}
						}
					if("task_id".equals(cgFormField.getFieldName().toLowerCase())&&StringUtil.isEmpty(defval)){
						defval=taskId;
					}
					//获取系统默认值
					defval=getSystemDefval(defval,cgFormField.getFieldDefault(),request);
					if(StringUtil.isNotEmpty(defval)){
						if("datetime".equalsIgnoreCase(cgFormField.getShowType())){
							defval = DateUtils.dataformat(defval, "yyyy-MM-dd HH:mm:ss");
						}else if("date".equalsIgnoreCase(cgFormField.getShowType())){
							defval = DateUtils.dataformat(defval, "yyyy-MM-dd");
						}else if("year".equalsIgnoreCase(cgFormField.getShowType())){
							defval = DateUtils.dataformat(defval, "yyyy");
						}else if("yymm".equalsIgnoreCase(cgFormField.getShowType())){
							defval = DateUtils.dataformat(defval, "yyyy-MM");
						}else if("time".equalsIgnoreCase(cgFormField.getShowType())){
							defval = DateUtils.dataformat(defval, "HH:mm:ss");
						}
					}
					
					trMap.put("value", replaceEnter(defval));
					mainListMap.add(trMap);
					if("popup".equals(cgFormField.getShowType())){//弹窗选择需要查询汉字
						if(StringUtil.isNotEmpty(cgFormField.getDictText())
								&&StringUtil.isNotEmpty(cgFormField.getDictField())
								&&StringUtil.isNotEmpty(cgFormField.getFieldHref())){
								List<Map<String, Object>> rr1 = systemService.findForJdbc("select json_sql from cgform_select_back where s_code='"+cgFormField.getFieldHref()+"'");
								List<Map<String, Object>> rr = systemService.findForJdbc("select "+cgFormField.getDictField()+" from ("+rr1.get(0).get("json_sql")+") as w where w."+cgFormField.getDictText()+"='"+defval+"'");
								if(rr!=null&&rr.size()>0){
									defval=rr.get(0).get(cgFormField.getDictField()).toString();
								}
							}else{
								defval="未配置查询数据表参数，请联系管理员！";
							}
						
						trMap = new HashMap<String, Object>();
						trMap.put("id", "showName_"+bussCode+"_"+oConvertUtils.getString(cgFormField.getFieldName(), ""));
						trMap.put("value", replaceEnter(defval));
						mainListMap.add(trMap);
					}
					if(StringUtil.isNotEmpty(cgFormField.getLinkBussCode())){
						linkBussCode+=cgFormField.getLinkBussCode()+",";
					}
				}
				mainMap.put("type", "main");
				mainMap.put("main", mainListMap);
				
				mapVal.add(mainMap);
		return mapVal;
	}
	
	public String getSystemDefval(String defval, String fieldDefault,HttpServletRequest request) {
		String create_by=oConvertUtils.getString(request.getSession().getAttribute("create_by"), "admin");
		String create_name=oConvertUtils.getString(request.getSession().getAttribute("create_name"), "admin");
		String org_id=oConvertUtils.getString(request.getSession().getAttribute("org_id"), "");
		String org_name=oConvertUtils.getString(request.getSession().getAttribute("org_name"), "");
		String update_by=oConvertUtils.getString(request.getSession().getAttribute("update_by"), "admin");
		String update_name=oConvertUtils.getString(request.getSession().getAttribute("update_name"), "admin");
		System.out.println("request.getSession().getAttribute('create_by')=====:"+create_by);
		System.out.println("request.getSession().getAttribute('create_name')=====:"+create_name);
		System.out.println("request.getSession().getAttribute('org_id')=====:"+org_id);
		System.out.println("request.getSession().getAttribute('org_name')=====:"+org_name);
		System.out.println("request.getSession().getAttribute('update_by')=====:"+update_by);
		System.out.println("request.getSession().getAttribute('update_name')=====:"+update_name);
		
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TSUser user_ = ResourceUtil.getSessionUserName();
		if ("createDate".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建时间"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
			}
		}
		if ("status".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建时间"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval = "0";//草稿
			}
		}
		/* 找到名为"创建人"的属性 */
		else if ("createBy".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建人"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval = create_by;
			}
		}
		/* 找到名为"创建人名称"的属性 */
		else if ("createName".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建人名称"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval = create_name;
			}
		}
		/* 找到名为"创建部门id"的属性 */
		else if ("createDepartmentId".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建人名称"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval = org_id;
			}
		}
		/* 找到名为"创建部门名称"的属性 */
		else if ("createDepartmentName".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建人名称"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval = org_name;
			}
		} else if ("orgId".equals(fieldDefault)) {
			/* 使用拦截器将对象的"创建人名称"属性赋上值 */
			if (oConvertUtils.isEmpty(defval)) {
				defval =org_id;
			}
		}
		return defval;
	}
	
	/**
	 * 查询关联业务数据
	 * @param pMap
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> getLinkBussDataJson(Map<String, Object> pMap,HttpServletRequest request) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TSUser user = ResourceUtil.getSessionUserName();
//		Map<String, TSRole> roles = ResourceUtil.getSessionTSRole();
		String mainId=oConvertUtils.getString(pMap.get("mainId"),"");
		String bussCode=oConvertUtils.getString(pMap.get("bussCode"),"");
		int versions = oConvertUtils.getInt(pMap.get("versionNum"),-1);
		String bussTemplateId = oConvertUtils.getString(pMap.get("bussTemplateId"),"");
		StringBuffer ssq = new StringBuffer();
		Map<String, Object> linkMap = new HashMap<String, Object>();
		CgformDefineEntity tSConfigform = systemService.findUniqueByProperty(
				CgformDefineEntity.class, "defineCode", bussCode);
		String mainTableName = "";
		if (tSConfigform != null) {
//			detailTableName = tSConfigform.getDtableName();
			mainTableName = tSConfigform.getMtableName();
		}
		mainId = mainId.replace(",", "','");
		String linkBussCode="",fieldNames="";
		//查询主表数据需要关联模板id和版本号
		List<CgFormLgFieldEntity> mainList = getFieldByTable(mainTableName,bussCode,new String[]{"isShow"},bussTemplateId,versions);
		if(mainList!=null&&mainList.size()>0){
			for(int i=0;i<mainList.size();i++){
				if(StringUtil.isNotEmpty(mainList.get(i).getLinkBussCode())){
					linkBussCode+=mainList.get(i).getLinkBussCode()+",";
					fieldNames+=mainList.get(i).getFieldName()+",";
				}
				if(StringUtil.isNotEmpty(mainList.get(i).getShowType())&&"v_formDetailedTab".equals(mainList.get(i).getShowType())){
					Map<String, Object> map1 = systemService.findOneForJdbc("SELECT  GROUP_CONCAT(link_buss_code) as link_buss_code from  cgform_tab where form_id='"+mainList.get(i).getId()+"' ");
					if(!map1.isEmpty()){
						linkBussCode+=map1.get("link_buss_code")+",";
						for(int q=0;q<map1.get("link_buss_code").toString().split("\\,").length;q++){
							fieldNames+=mainList.get(i).getFieldName()+",";
						}
					}
				}
			}
		}
		//查询主表数据
				if(StringUtil.isNotEmpty(linkBussCode)){
					linkBussCode=linkBussCode.substring(0, linkBussCode.length()-1);
					String spLink[]=linkBussCode.split("\\,");
					String spfieldNames[]=fieldNames.split("\\,");
					for(int i=0;i<spLink.length;i++){
						CgformDefineEntity linkTSConfigform = systemService.findUniqueByProperty(
								CgformDefineEntity.class, "defineCode", spLink[i]);
						List<CgFormLgFieldEntity> linkList = getFieldByTable(linkTSConfigform.getMtableName(),spLink[i],new String[]{"isShowList"},"",-1);
						//查询明细列表数据
						linkMap.put("linkBussCode"+i, spLink[i]);
						linkMap.put("fieldName"+i,spfieldNames[i]);
						if (linkList != null && linkList.size() > 0) {
							
							if(StringUtil.isNotEmpty(mainTableName)&&StringUtil.isNotEmpty(bussCode)){
								//查询明细表中配置的外键字段，且同一个主表只能配置一个外键
								List<Map<String, Object>> main_fieldList = systemService.findForJdbc("SELECT t.field_name FROM cgform_lg_field t where  t.buss_code = '"+spLink[i]+"' and t.main_table like'%"+mainTableName+",%'"); 
								// and deleteflag<>'"+ResourceUtil.DELETEFLAG+"'
								
								if(main_fieldList!=null&&main_fieldList.size()>0&&main_fieldList.size()==1){
								ssq = new StringBuffer();
								String detailQL = systemService.assemblyTableFieldSql(linkList, linkTSConfigform.getMtableName());
								ssq.append(" SELECT ");
								ssq.append(detailQL);
								ssq.append(" FROM "+linkTSConfigform.getMtableName()+" ");
								ssq.append(" where 1=1 ");
								
								ssq.append("  and  "+linkTSConfigform.getMtableName() + "."+main_fieldList.get(0).get("field_name")+" in('" + mainId + "') ");
//								ssq.append("  ORDER BY  "+mainTableName+".create_date desc ");//后续应该配置排序字段或语句
								List<Map<String, Object>> ww1 = systemService.findForJdbc(ssq
										.toString());
								List linkTRListMap = new ArrayList<>();
									if(ww1!=null&&ww1.size()>0){
										for (int iq1 = 0; iq1 < ww1.size(); iq1++) {
											List<Map<String, Object>> trListMap = new ArrayList<Map<String, Object>>();
											for (int iq = 0; iq < linkList.size(); iq++) {
												Map<String, Object> trMap = new HashMap<String, Object>();
												CgFormLgFieldEntity cgFormField = linkList.get(iq);
												trMap.put("id", linkTSConfigform.getDefineCode()+".["+iq1+"]."+oConvertUtils.getString(cgFormField.getFieldName(), ""));
												String defval = "";
												if(ww1!=null&&ww1.size()>0){
													defval = replaceEnter(oConvertUtils.getString(ww1.get(iq1).get(cgFormField.getFieldName().toUpperCase()), ""));
												}
												//获取系统默认值
												defval=getSystemDefval(defval,cgFormField.getFieldDefault(),request);
												
												trMap.put("value", replaceEnter(defval));
												trListMap.add(trMap);
												if("popup".equals(cgFormField.getShowType())){//弹窗选择需要查询汉字
													if(StringUtil.isNotEmpty(cgFormField.getDictField())
															&&StringUtil.isNotEmpty(cgFormField.getDictTable())
															&&StringUtil.isNotEmpty(cgFormField.getDictText())){
														List<Map<String, Object>> rr = systemService.findForJdbc("select "+cgFormField.getDictField()+" from "+cgFormField.getDictTable()+" where "+cgFormField.getDictText()+"='"+defval+"'");
														if(rr!=null&&rr.size()>0){
															defval=rr.get(0).get(cgFormField.getDictField()).toString();
														}
													}else{
														defval="未配置查询数据表参数，请联系管理员！";
													}
													trMap = new HashMap<String, Object>();
													trMap.put("id", "showName_"+linkTSConfigform.getDefineCode()+".["+iq1+"]."+oConvertUtils.getString(cgFormField.getFieldName(), ""));
													trMap.put("value", replaceEnter(defval));
													trListMap.add(trMap);
												}
											}
											linkTRListMap.add(trListMap);
										}
									}
									linkMap.put("link"+i, linkTRListMap);
								}
							}
						}
					}
					linkMap.put("linkCount", spLink.length);
				}
				linkMap.put("type", "link");
		return linkMap;
	}
	/**
	 * 查询附件数据
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getAttachDataJson(Map<String, Object> pMap) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TSUser user = ResourceUtil.getSessionUserName();
//		Map<String, TSRole> roles = ResourceUtil.getSessionTSRole();
		String mainId=oConvertUtils.getString(pMap.get("mainId"),"");
		String showType=oConvertUtils.getString(pMap.get("showType"),"");
		
		String bussCode=oConvertUtils.getString(pMap.get("bussCode"),"");
		String mainTable=oConvertUtils.getString(pMap.get("mainTable"),"");
		String versions = oConvertUtils.getString(pMap.get("versions"),"");
		String bussTemplateId = oConvertUtils.getString(pMap.get("bussTemplateId"),"");
		List<Map<String, Object>> mapVal = new ArrayList<Map<String, Object>>();
		Map<String, Object> attachMap = new HashMap<String, Object>();
		mainId = mainId.replace(",", "','");
		List<Map<String, Object>> aa = systemService.findForJdbc("select t.* from cgform_attachment t where t.businesskey in ('"+mainId+"') and attchtype='"+showType+"'  ");
		attachMap.put("type", showType);
		attachMap.put("main", aa);
		mapVal.add(attachMap);
		
		
		return mapVal;
	}
	
	/**
	 * 查询图片数据
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getPicDataJson(Map<String, Object> pMap) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TSUser user = ResourceUtil.getSessionUserName();
//		Map<String, TSRole> roles = ResourceUtil.getSessionTSRole();
		String mainId=oConvertUtils.getString(pMap.get("mainId"),"");
		String bussCode=oConvertUtils.getString(pMap.get("bussCode"),"");
		String versions = oConvertUtils.getString(pMap.get("versions"),"");
		String bussTemplateId = oConvertUtils.getString(pMap.get("bussTemplateId"),"");
		List<Map<String, Object>> mapVal = new ArrayList<Map<String, Object>>();
		Map<String, Object> picMap = new HashMap<String, Object>();
		mainId = mainId.replace(",", "','");
		
		List<Map<String, Object>> aa1 = systemService.findForJdbc("select t.* from cgform_attachment t where t.businesskey in ('"+mainId+"') and attchtype='v_formPic'  ");
		picMap.put("type", "v_formPic");
		picMap.put("main", aa1);
		mapVal.add(picMap);
		return mapVal;
	}
	
	
	public Map<String, Object> getRegionDataJson(Map<String, Object> pMap) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mainId=oConvertUtils.getString(pMap.get("mainId"),"");
		String fieldName = oConvertUtils.getString(pMap.get("fieldName"),"");
		mainId = mainId.replace(",", "','");
		Map<String, Object> aa1 = systemService.findOneForJdbc("select t.* from cgform_region_save t where t.master_id in ('"+mainId+"') and field_name='"+fieldName+"'  ");
		if(aa1==null){
			aa1 = new HashMap<String, Object>();
			aa1.put("province", "");
			aa1.put("city", "");
			aa1.put("county", "");
			aa1.put("address", "");
		}
		return aa1;
	}

	public AjaxJson doSaveOrUpdateData(HttpServletRequest request) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		Map properties = request.getParameterMap();
		String refBusscode = oConvertUtils.getString(request.getParameter("refBusscode"), "");
		String releaseCode = oConvertUtils.getString(request.getParameter("releaseCode"), "");
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		String bussId = oConvertUtils.getString(request.getParameter("bussId"),"");
		int versions = oConvertUtils.getInt(request.getParameter("versionNum"),-1);
		String linkBussCode = "";
		Map<String, Map<String, Object>> allT2Map =new HashMap<String, Map<String, Object>>();//表名对应的map，用于存储用
		Map<String, String> allT2HID =new HashMap<String, String>();
		Map<String, String> keyMap =new HashMap<String, String>();
		Map<String, String> mainT2ID =new HashMap<String, String>();
		String tableName = "";
		/*****************************************/
		//1、处理主业务表单数据
		CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", releaseCode);
		CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
		if(!"1".equals(cgformBuss.getStatus())){
			j.setSuccess(false);
			j.setMsg("未发布的表单不允许保存数据！");
			return j;
		}
		
		
		
		if (tSConfigform != null) {tableName = tSConfigform.getMtableName();}
		if(StringUtil.isNotEmpty(tSConfigform.getSaveType())
				&&"2".equals(tSConfigform.getSaveType())){
			tableName="cgform_rdata_master";
		}
		List<CgFormLgFieldEntity> cgFormLgFieldList = getFieldByTable(tableName,refBusscode,new String[]{"isShow"},bussTemplateId,versions);
		genTablePropertyMap(request,cgFormLgFieldList,allT2Map,allT2HID,refBusscode+"@",tableName);
		//如果是键值保存
		if(StringUtil.isNotEmpty(tSConfigform.getSaveType())
				&&"2".equals(tSConfigform.getSaveType())){
			mainT2ID =saverMasterData(allT2Map,request,cgformBuss);
			saveMasterDetailData(allT2Map,request,mainT2ID.get("cgform_rdata_master"));
		}else{
			 mainT2ID =saveData(allT2Map,request);
		}
//		if(!mainT2ID.containsKey(tableName)){//如果保存失败，则直接返回
//			j.setMsg(mainT2ID.get("msg"));
//			j.setSuccess(false);
//			return j;
//		}
		//2、保存虚拟字段数据
		saveVirtualData(cgFormLgFieldList,mainT2ID,properties,tableName);
		//3、处理关联业务表单数据
		//查询逻辑视图中当前表单有没有配置明细列表字段-start--------------------
//		List<Map<String, Object>> linkBussList = systemService.findForJdbc("select d.link_buss_code from cgform_lg_field d where "
//				+ " d.is_show='Y' "
//						+ " and d.link_buss_code is not null "
//						+ " and d.IS_FORM_HIDE <>'Y' "
//						+ " and d.VERSIONNUM= "+versions
//						+ " and d.link_buss_code <>''  "
//						+ " and d.show_type ='v_formDetailed'  "
//						+ " and d.buss_template_id ='"+bussTemplateId+"'  "
//						+ " and d.buss_code='"+refBusscode+"' ");
//		//and deleteflag<>'"+ResourceUtil.DELETEFLAG+"'
//		
//		//获取多页签
//		List<Map<String, Object>> map1 = systemService.findForJdbc("SELECT  link_buss_code from  cgform_tab where form_id in (select d.id from cgform_lg_field d where "
//				+ " d.is_show='Y' "
//						+ " and d.IS_FORM_HIDE <>'Y' "
//						+ " and d.VERSIONNUM= "+versions
//						+ " and d.show_type ='v_formDetailedTab'  "
//						+ " and d.buss_template_id ='"+bussTemplateId+"'  "
//						+ " and d.buss_code='"+refBusscode+"' ) ");
//			if(map1!=null&&map1.size()>0){
//				for(Map<String, Object> e:map1){
//					linkBussList.add(e);
//				}
//			}
//		
//		if(linkBussList!=null&&linkBussList.size()>0){
//			
//			for(Map<String, Object> mp:linkBussList){
//				CgformDefineEntity linkTSConfigform = systemService.findUniqueByProperty(CgformDefineEntity.class, "defineCode", mp.get("link_buss_code"));
//				List<CgFormLgFieldEntity> linkCgFormLgFieldList = getFieldByTable(linkTSConfigform.getMtableName(),mp.get("link_buss_code").toString(),new String[]{"isShowList"},"",-1);
//				String notNullFieldName="",linkbussId="";
//				
//				if(linkCgFormLgFieldList!=null&&linkCgFormLgFieldList.size()>0){
//					for(int i=0;i<linkCgFormLgFieldList.size();i++){
//						 notNullFieldName+=linkCgFormLgFieldList.get(i).getFieldName()+",";
//					}
//					notNullFieldName=notNullFieldName.substring(0, notNullFieldName.length()-1);
//					int requetsSize = ConvertArrayListUtil.requetsListSize(request,mp.get("link_buss_code")+".");
//					
//					
//					List<Map<String, Object>> linkTableList = systemService.findForJdbc("select d.main_table,d.main_field,d.id,d.field_name from cgform_lg_field d where "
//							+ "  d.main_table like '%"+tSConfigform.getMtableName()+"%' "
//							+ "  and d.buss_code='"+linkTSConfigform.getDefineCode()+"' ");//and deleteflag<>'"+ResourceUtil.DELETEFLAG+"'
//					if(linkTableList!=null&&linkTableList.size()>0){
//						//删除原来的存入的数据
//						systemService.executeSql("delete from "+linkTSConfigform.getMtableName()+" where "+linkTableList.get(0).get("field_name")+"='"+mainT2ID.get(tSConfigform.getMtableName())+"'");
//						//保存明细表单数据
//						if(requetsSize>0){
//							for(int c=0;c<requetsSize;c++){
//								String qz=mp.get("link_buss_code")+".["+c+"].";
//								allT2Map =new HashMap<String, Map<String, Object>>();//表名对应的map，用于存储用
//								genTablePropertyMap(request,linkCgFormLgFieldList,allT2Map,allT2HID,qz);
//								if (allT2Map != null && !allT2Map.isEmpty()) {
//									for (Iterator iterator = allT2Map.entrySet().iterator(); iterator
//											.hasNext();) {
//										Map.Entry entry1 = (Map.Entry) iterator.next();
//										Map<String, Object> map0 = (Map<String, Object>) entry1.getValue();
//										String sql="";
//										
//										if (map0.containsKey("id")) {
//											map0.put("id", "");
//										}
//									}
//								}
//								Map<String, String> linkT2ID =saveData(allT2Map,request);
//								if(linkT2ID.containsKey(linkCgFormLgFieldList.get(0).getDefineId())){
//									linkbussId+=linkT2ID.get(linkCgFormLgFieldList.get(0).getDefineId())+",";
//								}
//							}
//							linkbussId=linkbussId.substring(0, linkbussId.length()-1);
//						}
//						
////						if("dtl2".equals(mp.get("show_type"))){//弹窗的方式,更新某个字段的值
////							linkbussId=((String[])properties.get(mp.get("id")))[0];
////						}
//						
//						if(StringUtil.isNotEmpty(linkbussId)){
//							//删除原来的存入的数据
//							systemService.executeSql(" update  "+linkTSConfigform.getMtableName()+" set "+linkTableList.get(0).get("field_name")+"='"+mainT2ID.get(tSConfigform.getMtableName())+"' where "
//									+ " id in ('"+linkbussId.replace(",", "','")+"')");
//						}
//					}
//					
//				}
//			}
//		}
		
		
		
		//查询逻辑视图中当前表单有没有配置明细列表字段-end--------------------
		
		j.setSuccess(true);
		j.setObj(mainT2ID.get(tableName));
		
		return j;
	}
	
	
	private  void saveDefaultData(String mainTable,String mainId,HttpServletRequest request) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String defaultField =ResourceUtil.getConfigByName("system.default.field");
		Map<String, Object> tableMap = systemService.findOneForJdbc("select * from "+mainTable+"  where "
				+ "  id='"+mainId+"' ");
		Map<String, Object> defMap=new HashMap<String, Object>(); 
		defMap.put("create_date", new Date());
		//业务系统需要往session中传入这几个参数
		System.out.println("request.getSession().getAttribute('create_by')=====:"+request.getSession().getAttribute("create_by"));
		System.out.println("request.getSession().getAttribute('create_name')=====:"+request.getSession().getAttribute("create_name"));
		System.out.println("request.getSession().getAttribute('org_id')=====:"+request.getSession().getAttribute("org_id"));
		System.out.println("request.getSession().getAttribute('org_name')=====:"+request.getSession().getAttribute("org_name"));
		System.out.println("request.getSession().getAttribute('update_by')=====:"+request.getSession().getAttribute("update_by"));
		System.out.println("request.getSession().getAttribute('update_name')=====:"+request.getSession().getAttribute("update_name"));
		
		defMap.put("create_by", oConvertUtils.getString(request.getSession().getAttribute("create_by"), "admin"));
		defMap.put("create_name", oConvertUtils.getString(request.getSession().getAttribute("create_name"), "admin"));
		defMap.put("org_id", oConvertUtils.getString(request.getSession().getAttribute("org_id"), ""));
		defMap.put("org_name", oConvertUtils.getString(request.getSession().getAttribute("org_name"), ""));
		defMap.put("update_by", oConvertUtils.getString(request.getSession().getAttribute("update_by"), "admin"));
		defMap.put("update_name", oConvertUtils.getString(request.getSession().getAttribute("update_name"), "admin"));
		defMap.put("update_date", new Date());
		Map<String, Object> newTableMap=new HashMap<String, Object>(); 
		if(tableMap!=null){
			//统一处理成小写字段
			for (Iterator iterator = tableMap.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry entry1 = (Map.Entry) iterator.next();
				newTableMap.put(entry1.getKey().toString().toLowerCase(), entry1.getValue());
			}
			if(StringUtil.isNotEmpty(defaultField)&&!tableMap.isEmpty()){
				String defaultFields[]=defaultField.split("\\,");
				String sql="",sql1="";
				String comma="";
				//如果是创建人为空的话，更新人字段需设置为空
				if(newTableMap.containsKey("create_by")&&StringUtil.isEmpty(newTableMap.get("create_by")+"")){
					defMap.put("update_by", "");
					defMap.put("update_name", "");
					defMap.put("update_date",null);
				}
				if(StringUtil.isNotEmpty(newTableMap.get("create_by"))){
					//如果是创建人不为空时，更新人字段需设置为空，重新赋值
					if(newTableMap.containsKey("update_by")){
						newTableMap.put("update_by", "");
					}
					if(newTableMap.containsKey("update_name")){
						newTableMap.put("update_name", "");
									}
					if(newTableMap.containsKey("update_date")){
						newTableMap.put("update_date", "");
					}
				}
				sql=" update "+mainTable+" set ";
				for(String df:defaultFields){
					if(defMap.containsKey(df)){
						//如果为空，则赋值
							Object value_11_ = defMap.get(df);
							if(value_11_!=null&&value_11_.toString().length()>0){
								sql1+=comma+df+"=:"+df;
							}else{
								sql1+=comma+df+"=null";
							}
							comma = ", ";
					}
				}
				sql+=sql1;
				sql+=" where id='"+mainId+"'";
				if(StringUtil.isNotEmpty(sql1)){
					systemService.executeSql(sql, defMap);
				}
			}
		}
	}
	
	/**
	 * 保存历史修改记录
	 * @param cgformRdataDetail
	 * @param oldValue
	 * @throws Exception
	 */
	private  void saveRdataChistory(CgformRdataDetailEntity cgformRdataDetail,Map oldValue,HttpServletRequest request) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CgformRdataChistoryEntity cgformRdataChistory=new CgformRdataChistoryEntity();
		cgformRdataChistory.setFieldName(cgformRdataDetail.getFieldName());
		cgformRdataChistory.setMasterId(cgformRdataDetail.getMasterId());
		cgformRdataChistory.setNewValue(cgformRdataDetail.getFieldValue());
//		cgformRdataChistory.setNewValueRem("");
		cgformRdataChistory.setOldValue(oldValue.get(cgformRdataDetail.getFieldName()).toString());
//		cgformRdataChistory.setOldValueRem(oldValueRem);
		systemService.save(cgformRdataChistory);
		//保存系统默认字段值-----------------
		saveDefaultData("cgform_rdata_chistory",cgformRdataChistory.getId(),request);
		//保存系统默认字段值-----------------
	}
	
	
	private  void saveVirtualData(List<CgFormLgFieldEntity> cgFormLgFieldList,
			Map<String, String> mainT2ID,
			Map properties,String tableName) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cgFormLgFieldList!=null&&cgFormLgFieldList.size()>0){
			for(int i=0;i<cgFormLgFieldList.size();i++){
				CgFormLgFieldEntity cgLgField=cgFormLgFieldList.get(i);
				if(cgLgField.getShowType().startsWith("v_formFile")
						||"v_formPic".equals(cgLgField.getShowType())){//这种类型需要单独处理
					if(properties.containsKey(cgLgField.getFieldName())){
						String beforeV = oConvertUtils.getString(((String[])properties.get(cgLgField.getFieldName()))[0]);
						if(mainT2ID.containsKey(tableName)){
							systemService.executeSql(" update  cgform_attachment  set businesskey ='"+mainT2ID.get(tableName)+"'"
									+ ",attchtype='"+cgLgField.getShowType()+"',field_name='"+cgLgField.getFieldName()+"' where "
									+ " id in ('"+beforeV.replace(",", "','")+"')");
						}
					}
				}
				if("v_formRegion".equals(cgLgField.getShowType())){
					String province = oConvertUtils.getString(((String[])properties.get(cgLgField.getFieldName()+"_province"))[0]);
					String city = oConvertUtils.getString(((String[])properties.get(cgLgField.getFieldName()+"_city"))[0]);
					String county = oConvertUtils.getString(((String[])properties.get(cgLgField.getFieldName()+"_county"))[0]);
					String address = oConvertUtils.getString(((String[])properties.get(cgLgField.getFieldName()+"_address"))[0]);
					String sql="select * from cgform_region_save where  master_id ='"+mainT2ID.get(tableName)+"' and  field_name='"+cgLgField.getFieldName()+"' ";
					List<Map<String, Object>> e = systemService.findForJdbc(sql);
					if(e!=null&&e.size()>0){
						systemService.executeSql(" update  cgform_region_save  set province ='"+province+"'"
								+ ",city='"+city+"',county='"+county+"'"
										+ ", address='"+address+"' where "
								+ " master_id ='"+mainT2ID.get(tableName)+"' and field_name='"+cgLgField.getFieldName()+"' ");
					}else{
						systemService.executeSql(" INSERT INTO   cgform_region_save (id,province,city,county,address,master_id,field_name) "
								+ " values ('"+UUIDGenerator.generate()+"','"+province+"','"+city+"','"+county+"','"+address+"','"+mainT2ID.get(tableName)+"','"+cgLgField.getFieldName()+"') ");
					}
					
				}
						
			}
		}
	}
	
	
	
	/***
	 * 保存数据
	 * @param allMap
	 * @return
	 * @throws Exception 
	 */
	private  Map<String, String> saveMasterDetailData(Map<String, Map<String, Object>> allMap,
			HttpServletRequest request,String masterId) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map oldValue=new HashMap();
		
		CriteriaQuery cq = new CriteriaQuery(CgformRdataDetailEntity.class);
		cq.eq("masterId", masterId);
		cq.add();
		List<CgformRdataDetailEntity> ee = systemService.getListByCriteriaQuery(cq, false);
		for(CgformRdataDetailEntity e:ee){//把老数据存储在map中，用于生成历史修改记录
			oldValue.put(e.getFieldName(), e.getFieldValue());
		}
		systemService.deleteAllEntitie(ee);//先删除老数据
		Map<String, String> keyMap =new HashMap<String, String>();
		String msg="保存成功！";
		if (allMap != null && !allMap.isEmpty()) {
			for (Iterator iterator = allMap.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry entry1 = (Map.Entry) iterator.next();
				Map<String, Object> map0 = (Map<String, Object>) entry1.getValue();
				String sql="";
				
					for (Entry<String, Object> entry : map0.entrySet()) {
						// 判断key是否为表配置的属性
						String newV=oConvertUtils.getString(map0.get(entry.getKey()));
						String oldV="";
							CgformRdataDetailEntity cgformRdataDetail=new CgformRdataDetailEntity();
							cgformRdataDetail.setMasterId(masterId);
							cgformRdataDetail.setFieldName(entry.getKey());
							cgformRdataDetail.setFieldValue(newV+"");
//							cgformRdataDetail.setVersionnum("");
							systemService.save(cgformRdataDetail);
							try{
								//保存系统默认字段值-----------------
								saveDefaultData("cgform_rdata_detail",cgformRdataDetail.getId(),request);
								//保存系统默认字段值-----------------
								if(oldValue.containsKey(entry.getKey())){
									oldV=oConvertUtils.getString(oldValue.get(entry.getKey()));
									if(!oldV.equals(newV)){
										saveRdataChistory(cgformRdataDetail,oldValue,request);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
//								msg=e.getLocalizedMessage();//操作失败，删除保存的数据，重新赋值为空
//								systemService.executeSql("delete from cgform_rdata_detail where id='"+cgformRdataDetail.getId()+"'");
//								keyMap.put("msg", msg);
//								return keyMap;
							}
					}
			}
		}
		
		return keyMap;
	}
	
	/***
	 * 保存数据
	 * @param allMap
	 * @return
	 * @throws Exception 
	 */
	private  Map<String, String> saverMasterData(Map<String, Map<String, Object>> allMap,
			HttpServletRequest request,CgformBussEntity cgformBuss) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> keyMap =new HashMap<String, String>();
		String msg="保存成功！";
		if (allMap != null && !allMap.isEmpty()) {
			for (Iterator iterator = allMap.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry entry1 = (Map.Entry) iterator.next();
				Map<String, Object> map0 = (Map<String, Object>) entry1.getValue();
				//查询字段对应的数据关联关系表，然后把列表和查询数据更新到主表中，方便数据查询和展示
				CriteriaQuery cq = new CriteriaQuery(CgformFieldTempEntity.class);
				cq.eq("bussId", cgformBuss.getId());
				cq.add();
				List<CgformFieldTempEntity> ee = systemService.getListByCriteriaQuery(cq, false);
				CgformRdataMasterEntity cgformRdataMaster=systemService.getEntity(CgformRdataMasterEntity.class, oConvertUtils.getString(map0.get("id")));
				if (StringUtil.isNotEmpty(cgformRdataMaster)&&StringUtil.isNotEmpty(cgformRdataMaster.getId())) {
					ReflectHelper reflectHelper = new ReflectHelper(cgformRdataMaster);
					if (entry1.getValue() instanceof Map) {
						for (CgformFieldTempEntity entry : ee) {
							// 判断key是否为表配置的属性
								reflectHelper.setMethodValue(entry.getTempField(), map0.get(entry.getFieldName().toLowerCase()));
						}
						systemService.updateEntitie(cgformRdataMaster);
					}
				}else{
					cgformRdataMaster =new CgformRdataMasterEntity();
					ReflectHelper reflectHelper = new ReflectHelper(cgformRdataMaster);
					for (CgformFieldTempEntity entry : ee) {
						// 判断key是否为表配置的属性
							reflectHelper.setMethodValue(entry.getTempField(), map0.get(entry.getFieldName().toLowerCase()));
					}
					try{
						cgformRdataMaster.setBussId(cgformBuss.getId());
						cgformRdataMaster.setOrg_name((String)request.getSession().getAttribute("org_name"));
						systemService.save(cgformRdataMaster);
					} catch (Exception e) {
						e.printStackTrace();
						msg=e.getLocalizedMessage();//操作失败，删除保存的数据，重新赋值为空
						systemService.executeSql("delete from cgform_rdata_master where id='"+cgformRdataMaster.getId()+"'");
						keyMap.put("msg", msg);
						return keyMap;
					}
					keyMap.put("msg", msg);
				}
				//保存系统默认字段值-----------------
				saveDefaultData("cgform_rdata_master",cgformRdataMaster.getId(),request);
				//保存系统默认字段值-----------------
				keyMap.put("cgform_rdata_master", cgformRdataMaster.getId());
			}
		}
		return keyMap;
	}

	
	/***
	 * 保存数据
	 * @param allMap
	 * @return
	 */
	private  Map<String, String> saveData(Map<String, Map<String, Object>> allMap,HttpServletRequest request) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> keyMap =new HashMap<String, String>();
		String msg="保存成功！";
		if (allMap != null && !allMap.isEmpty()) {
			for (Iterator iterator = allMap.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry entry1 = (Map.Entry) iterator.next();
				Map<String, Object> map0 = (Map<String, Object>) entry1.getValue();
				String sql="";
				if (map0.containsKey("id")&& StringUtil.isNotEmpty(map0.get("id"))) {
					String comma = "";
					
					if (entry1.getValue() instanceof Map) {
						sql=" update "+entry1.getKey()+" set ";
						for (Iterator it = map0.entrySet().iterator(); it.hasNext();) {
							Map.Entry entry2 = (Map.Entry) it.next();
							String xx = entry2.getKey().toString().toLowerCase();
							Object value_11_ = entry2.getValue();
							if(value_11_!=null&&value_11_.toString().length()>0){
								sql+=comma+xx+"=:"+xx;
							}else{
								sql+=comma+xx+"=null";
							}
							comma = ", ";
						}
						sql+=" where id='"+map0.get("id")+"'";
						int num = systemService.executeSql(sql, map0);
						keyMap.put(entry1.getKey().toString(), map0.get("id").toString());
						//保存系统默认字段值-----------------
						saveDefaultData(entry1.getKey().toString(),map0.get("id").toString(),request);
						//保存系统默认字段值-----------------
					}
				}else{
					String comma = "",id=UUIDGenerator.generate();
					StringBuffer insertKey = new StringBuffer();
					StringBuffer insertValue = new StringBuffer();
					for (Entry<String, Object> entry : map0.entrySet()) {
						// 判断key是否为表配置的属性
							insertKey.append(comma  + entry.getKey());
							if("id".equals(entry.getKey())){
								insertValue.append(comma + "'"+id+"' ");
							}else{
								if(entry.getValue()!=null&&entry.getValue().toString().length()>0){
									insertValue.append(comma + ":"+entry.getKey());
								}else{
									insertValue.append(comma + "null");
								}
							}
							comma = ", ";
					}
					sql = "INSERT INTO " + entry1.getKey() + " (" + insertKey + ") VALUES (" + insertValue + ")";
					try{
						if(!map0.containsKey("id")){//验证是否存在id
							keyMap.put("msg", "未配置业务主键在表单中，请在后台配置！");
							return keyMap;
						}
						systemService.executeSqlReturnKey(sql,map0);
						//保存系统默认字段值-----------------
						saveDefaultData(entry1.getKey().toString(),id,request);
						//保存系统默认字段值-----------------
					} catch (Exception e) {
						e.printStackTrace();
						msg=e.getLocalizedMessage();//操作失败，删除保存的数据，重新赋值为空
						systemService.executeSql("delete from " + entry1.getKey() + " where id='"+id+"'");
						keyMap.put("msg", msg);
						return keyMap;
					}
					keyMap.put("msg", msg);
					keyMap.put(entry1.getKey().toString(), id);
				}
			}
		}
		return keyMap;
	}


	
	/**
	 * 数据类型适配-根据表单配置的字段类型将前台传递的值将map-value转换成相应的类型
	 * @param tableName 表单名
	 * @param data 数据
	 */
	private Object dataAdapter(Map properties,CgFormLgFieldEntity cgFormLgField,String qz,String tableName) {
			//根据类型进行值的适配
		Object newV = null;
		if(properties.containsKey(qz+cgFormLgField.getFieldName())){
		Object beforeV = ((String[])properties.get(qz+cgFormLgField.getFieldName()))[0];
		if("cgform_rdata_master".equals(tableName)){//键值保存不需要转换类型
			return beforeV;
		}
			if("date".equalsIgnoreCase(cgFormLgField.getType())){
				//日期->java.util.Date
				try {
					String dateType = cgFormLgField.getShowType();
					if(beforeV!=null&&beforeV.toString().length()>0){
						if("datetime".equalsIgnoreCase(dateType)){
							newV = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(String.valueOf(beforeV));
						}else if("date".equalsIgnoreCase(dateType)){
							newV = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(beforeV));
						}else if("year".equalsIgnoreCase(dateType)){
							newV = new SimpleDateFormat("yyyy").parse(String.valueOf(beforeV));
						}else if("yymm".equalsIgnoreCase(dateType)){
							newV = new SimpleDateFormat("yyyy-MM").parse(String.valueOf(beforeV));
						}else if("time".equalsIgnoreCase(dateType)){
							newV = new SimpleDateFormat("HH:mm:ss").parse(String.valueOf(beforeV));
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else if("int".equalsIgnoreCase(cgFormLgField.getType())){
				newV = new Integer(0);
				try{
					if(beforeV!=null&&beforeV.toString().length()>0){
					newV = Integer.parseInt(String.valueOf(beforeV));
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else if("double".equalsIgnoreCase(cgFormLgField.getType())){
				//double->java.lang.Double
				 newV = new Double(0);
				try{
					if(beforeV!=null&&beforeV.toString().length()>0){
					newV = Double.parseDouble(String.valueOf(beforeV));
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				newV = ((String[])properties.get(qz+cgFormLgField.getFieldName()))[0];
			}
		}else{
			newV ="";
		}
		return newV;
	}
	
	/**
	 * 将页面的map数据转换为数据库map
	 * @param request
	 * @param allMap
	 * @param newList
	 */
	public void genTablePropertyMap(HttpServletRequest request,
			List<CgFormLgFieldEntity> cgFormLgFieldList,
			Map<String, Map<String, Object>> allT2Map,
			Map<String, String> allT2HID,String qz,String tableName) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map properties = request.getParameterMap();
		Map<String, Object> map2 = new HashMap<String, Object>();
		for(CgFormLgFieldEntity cgLgField:cgFormLgFieldList){
			if(!cgLgField.getShowType().toLowerCase().startsWith("v_form")) {
					if (allT2Map.containsKey(tableName)) {
						map2 = allT2Map.get(tableName);
						map2.put(cgLgField.getFieldName().toLowerCase(), dataAdapter(properties,cgLgField,qz,tableName));
						allT2Map.put(tableName, map2);
//						allT2HID.put(cgLgField.getDefineId().toString(), cgLgField.getTable().getId());
					} else {
						map2 = new HashMap<String, Object>();
						map2.put(cgLgField.getFieldName().toLowerCase(), dataAdapter(properties,cgLgField,qz,tableName));
						allT2Map.put(tableName, map2);
//						allT2HID.put(cgLgField.getDefineId().toString(),cgLgField.getTable().getId() );
					}
				}
			}
	}

	public String getTableData(List<Map<String, Object>> ww1,
			CgFormLgFieldEntity tbculindex, String temp2) {
		// 如果从数据字典中没有查到就从配置的表、要显示的字段、被查找的字段
		if (StringUtil.isEmpty(temp2)) {
			if (StringUtil.isNotEmpty(tbculindex.getDictField())
					&& StringUtil.isNotEmpty(tbculindex.getDictTable())
					&& StringUtil.isNotEmpty(tbculindex.getDictText())) {
				if (ww1 != null && ww1.size() > 0) {
					List<Map<String, Object>> tvalue = systemService
							.findForJdbc("SELECT t."
									+ tbculindex.getDictField()
									+ " FROM "
									+ tbculindex.getDictTable()
									+ " t where t."
									+ tbculindex.getDictText()
									+ "='"
									+ ww1.get(0).get(
											tbculindex.getFieldName()
													.toUpperCase()) + "'");
					if (tvalue != null && tvalue.size() > 0) {
						temp2 = tvalue.get(0)
								.get(tbculindex.getDictField().toUpperCase())
								.toString();
					}
				}
			}
		}
		return temp2;
	}

	public String replaceEnter(String value) {
		if (value != null && !"".equals(value)) {
			Pattern p = Pattern.compile("\r\n|\r|\n|\n\r");
			Matcher m = p.matcher(value);
			value = m.replaceAll("");
		}
		return value;
	}

	/**
	 * 根据表名获取实体对象类名(全路径),isReplace_是否是获取数据库字段
	 * 
	 * @param tableName
	 * @return
	 */
	public AjaxJson getClassNameByTBName(String tableName,
			Boolean isGetDataBaseName) {
		AjaxJson j = new AjaxJson();
		org.hibernate.SessionFactory factory = systemService.getSession()
				.getSessionFactory();
		Map metaMap = factory.getAllClassMetadata();
		for (String key : (Set<String>) metaMap.keySet()) {
			AbstractEntityPersister classMetadata = (AbstractEntityPersister) metaMap
					.get(key);
			String tableName2 = classMetadata.getTableName().toLowerCase();

			if (tableName.equals(tableName2)) {

				Map<String, String> qq0 = new HashMap<String, String>();
				if (isGetDataBaseName) {
					String[] qq1 = classMetadata
							.getSubclassColumnReaderTemplateClosure();
					String[] qq2 = classMetadata.getPropertyNames();
					if (qq2.length > 0) {
						for (int i = 0; i < qq2.length; i++) {
							String dx = qq1[i]
									.substring((qq1[i].indexOf('.') + 1));
							qq0.put(qq2[i], dx);
						}
					}
				} else {
					String[] qq1 = classMetadata.getPropertyNames();
					Set<String> set1 = new HashSet<String>(Arrays.asList(qq1));
					Iterator<String> it = set1.iterator();
					while (it.hasNext()) {
						String xx = it.next().toString();
						String dx = xx.toUpperCase().replace("_", "");
						if (StringUtil.isNotEmpty(dx)) {
							qq0.put(dx, xx);
						}

					}
				}
				j.setObj(qq0);
				j.setMsg(key);
				return j;
			}
		}
		j.setMsg("0");
		return j;
	}
	
	
	/**
	 * 
	 * @Title: getMainStatusNoById
	 * @Description:
	 * @param @param mainTable
	 * @param @param mainId
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getMainStatusNoById(String mainTable, String mainId) {
		String status = "0";
		if (StringUtil.isNotEmpty(mainTable) && StringUtil.isNotEmpty(mainId)) {
			mainId = mainId.replace(",", "','");
			String sql = "select status from " + mainTable + " where id in('"
					+ mainId + "')";
			Map<String, Object> map = systemService.findOneForJdbc(sql);
			status = oConvertUtils.getString(map.get("STATUS"), "0");
		}
		return status;
	}


	
	
//	/**
//	 * 获得明细Item
//	 */
//	public String getDetailItemData(String detailTable, String mainId,String status) {
//		StringBuffer qqw = new StringBuffer();
//		StringBuffer detailSql = new StringBuffer();
//		Map<String, TSRole> roles = ResourceUtil.getSessionTSRole();
//		/**获取明细的时候只能获取访问录入人员录入的违法登记及对应状态的数据集合**/
//		TSUser user = ResourceUtil.getSessionUserName();
//		detailSql.append("SELECT ");
//		detailSql.append(detailTable + ".* ");
//		detailSql.append(" FROM ");
//		detailSql.append(" " + detailTable + " ");
//		detailSql.append(" WHERE ");
//		detailSql.append(detailTable + ".BUSINESS_ID='" + mainId + "'  ");
//		
//		if(roles.containsKey("SJ_LU")){
//			detailSql.append(" and "+detailTable+".CREATE_BY='"+user.getUserName()+"'   ");
//		}
//		detailSql.append(" and "+detailTable+".STATUS='"+status+"'   ");
//		detailSql.append("   order by "+ detailTable + ".CREATE_DATE DESC");
//		List<Map<String, Object>> detailList = systemService.findForJdbc(detailSql.toString());
//		if (detailList != null && detailList.size() > 0) {
//			for (int i = 0; i < detailList.size(); i++) {
//				qqw.append(" {");
//				qqw.append("\"trData\": [{");
//				qqw.append("\"ID\": \"" + detailList.get(i).get("ID") + "\",");
//				qqw.append("\"MAIN_ID\": \"" + detailList.get(i).get("BUSINESS_ID") + "\",");
//				qqw.append("\"DETAIL_NO\": \"" + detailList.get(i).get("ID") + "\"");
//				qqw.append("}]");
//				qqw.append("}");
//				if ((detailList.size() - i) != 1) {
//					qqw.append(",");
//				}
//			}
//		}
//		return qqw.toString();
//	}
	
//	
//	public String delDetail(String detailTable, String detailId) {
//		String qqw = "";
//		StringBuffer sqlc = new StringBuffer();
//		sqlc.append("delete  from ");
//		sqlc.append(detailTable);
//		sqlc.append(" WHERE ");
//		sqlc.append(detailTable+".ID='"
//				+ detailId + "' ");
//		systemService.executeSql(sqlc.toString());
//		return qqw;
//	}
	
	
	/**
	 * 根据表名获取字段集合
	 * 
	 * @param tableName
	 * @return
	 */
	public List<CgFormLgFieldEntity> getFieldByTable(String tableName,String bussCode,String[] flag,String bussTemplateId,int versions) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CriteriaQuery cq = new CriteriaQuery(CgFormLgFieldEntity.class);
//		cq.createAlias("table", "table");
		cq.eq("bussCode", bussCode);
		if(StringUtil.isNotEmpty(bussTemplateId)){
			cq.eq("bussTemplateId", bussTemplateId);
		}
//		if(StringUtil.isNotEmpty(tableName)){
//			if(tableName.split(",").length>1){
//				cq.in("table.tableName", tableName.split(","));// 需要改成变量
//			}else{
//				cq.eq("table.tableName", tableName);// 需要改成变量
//			}
//		}
		if(flag!=null&&flag.length>0){
			for(int i=0;i<flag.length;i++){
				if("isEdit".equals(flag[i])){
					cq.eq("isEdit", "Y");
				}
				if("isShowList".equals(flag[i])){
					cq.eq("isShowList", "Y");
				}
				if("isIdx".equals(flag[i])){
					cq.isNotNull("isIdx");
				}
				if("isQuery".equals(flag[i])){
					cq.eq("isQuery", "Y");
				}
				if("isFormDetailEdit".equals(flag[i])){
					cq.eq("isFormDetailEdit", "Y");
				}
				if("isNotnull".equals(flag[i])){
					cq.eq("isNotnull", "Y");
				}
				if("isSimple".equals(flag[i])){
					cq.eq("isSimple", "Y");
				}
				if("isShow".equals(flag[i])){
					cq.eq("isShow", "Y");
				}
			}
		}
//		cq.notEq("deleteflag",ResourceUtil.DELETEFLAG);
		cq.eq("versionNum", versions);
		cq.addOrder("orderNum", SortDirection.asc);
		cq.add();
		return systemService.getListByCriteriaQuery(cq, false);
	}
	

}