package com.design.list.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.SortDirection;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformDefineEntity;
import com.design.list.service.ListPageGenServiceI;
import com.design.utils.DateUtils;
import com.design.utils.ParameterUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;
import com.zxlhdata.framework.auth.util.LicenseUtil;

@Service("listPageGenService")
@Transactional
public class ListPageGenServiceImpl  implements
		ListPageGenServiceI {

	private SystemService systemService;
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * 获得各种情况下的json数据
	 * 
	 * @param request
	 * @param jsonType
	 * @param gno
	 * @return
	 * @throws Exception 
	 */
	public String getJsonByBussData(HttpServletRequest request) throws Exception {
		String tmageTextJson = getJYJsonByBussData(request);
		System.out.println(tmageTextJson);
		return tmageTextJson;
	}

	public String getJYJsonByBussData(HttpServletRequest request) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer qqw = new StringBuffer();
		String linkBussCode = oConvertUtils.getString(request.getParameter("linkBussCode"));
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"));
		String bussTemplateId = oConvertUtils.getString(request.getParameter("bussTemplateId"),"");
		String configformId = oConvertUtils.getString(request.getParameter("configformId"),"");
		String mainId = oConvertUtils.getString(request.getParameter("mainId"),"");//如果有值，则表示是明细列表
		int versions = oConvertUtils.getInt(request.getParameter("versions"),-1);
		int currpage = oConvertUtils.getInt(request.getParameter("currpage"), 1);
		int pagecount = oConvertUtils.getInt(request.getParameter("pagecount"),1);
		CgformDefineEntity tSConfigform = new CgformDefineEntity();
		
		
		
		CgformBussEntity cgformBuss = new CgformBussEntity();
		String  mainTableName = "";
		if(StringUtil.isNotEmpty(linkBussCode)){
			cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", linkBussCode);
			tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
//			tSConfigform = systemService.findUniqueByProperty(
//					CgformDefineEntity.class, "defineCode", linkBussCode);//业务编码不能重复，否则会报错
		}else{
			cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
			tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
//			 tSConfigform = systemService.findUniqueByProperty(
//						CgformDefineEntity.class, "defineCode", bussCode);//业务编码不能重复，否则会报错
		}
		 
//		configformId=oConvertUtils.getString(tSConfigform.getId());
//		//列表默认显示基础模板
//		List<Map<String, Object>> map = systemService.findForJdbc("select id from t_s_buss_template where configform_id=? and template_type='0' ",configformId);
//		if(map!=null&&map.size()>0){
//			bussTemplateId = oConvertUtils.getString(map.get(0).get("id"));
//		}
		List<CgformBussListEntity> mainList = getFieldByBussList(cgformBuss.getId(),new String[]{"isShowList"},versions);

		mainTableName = tSConfigform.getMtableName();
		if("2".equals(tSConfigform.getSaveType())){
			mainTableName = "cgform_rdata_master";
		}
		List<Map<String, Object>> aaq = new ArrayList<Map<String, Object>>();
		
		StringBuffer ssq = new StringBuffer();
		ssq.append(" SELECT * ");
		ssq.append(" FROM "+mainTableName+" ");
		ssq.append(" where 1=1 ");
//		if(StringUtil.isNotEmpty(linkBussCode)){//如果有值，则表示是明细列表,需要从配置中查询关联的主表数据存储在哪个明细字段中
//			CgformDefineEntity mainTSConfigform = systemService.findUniqueByProperty(
//					CgformDefineEntity.class, "defineCode", bussCode);
//			List<Map<String, Object>> map11 = systemService.findForJdbc("select field_name,main_field,main_table from "
//					+ "cgform_lg_field where main_table like'%"+mainTSConfigform.getMtableName().toLowerCase()+"%' and BUSS_TEMPLATE_ID in (select id from t_s_buss_template where"
//					+ " configform_id='"+tSConfigform.getId()+"'  and template_type='0')  ");// and deleteflag<>'"+ResourceUtil.DELETEFLAG+"'
//			if(map11!=null&&map11.size()>0){
//				ssq.append(" and ( ");
//				for(int i=0;i<map11.size();i++){
//					ssq.append( map11.get(i).get("field_name")+" ='"+mainId+"' ");
//					if((map11.size()-i)!=1){
//						ssq.append(" or ");
//					}
//				}
//				ssq.append(" ) ");
//			}
//		}
		querySql(request, ssq);
		
		String sql_="describe "+mainTableName+" create_date";
		List<Map<String, Object>> aaq1 = systemService.findForJdbc(sql_);
		if(aaq1!=null&&aaq1.size()>0){
			ssq.append("  ORDER BY  "+mainTableName+".create_date desc ");
		}
		
		
		/******* 查询总数 ********/
		StringBuffer countQuerySql = new StringBuffer();
		countQuerySql.append(" SELECT ");
		countQuerySql.append(" COUNT(*) countsize ");
		countQuerySql.append(" FROM ");
		countQuerySql.append(" ( ");
		countQuerySql.append(ssq);
		countQuerySql.append(" ) countall ");

		List<Map<String, Object>> countQueryList = systemService
				.findForJdbc(countQuerySql.toString());// 总数
		/******* 查询总数 ********/
		ssq.append(" LIMIT " + ((currpage - 1) * pagecount) + ","
				+ (currpage * pagecount) + " ");

		aaq = systemService.findForJdbc(ssq.toString());
		qqw.append("[");
		qqw.append("{");
		qqw.append("\"mainColumnsTitle\": [");
		if (mainList != null && mainList.size() > 0) {
			for (int iq = 0; iq < mainList.size(); iq++) {
				qqw.append("{");
				qqw.append("\"isShow\": \"" + mainList.get(iq).getIsShowList()
						+ "\",");
				qqw.append("\"isListHide\": \"" + mainList.get(iq).getIsListHide()
						+ "\",");
				qqw.append("\"dataLength\": 0,");
				qqw.append("\"titleName\": \"" + mainList.get(iq).getContent()
						+ "\"");
				qqw.append("}");
				if ((mainList.size() - iq) != 1) {
					qqw.append(",");
				}
			}
		}
		qqw.append("],");

		qqw.append("\"mainColumns\": [");
		if (aaq != null && aaq.size() > 0) {
			for (int ie = 0; ie < aaq.size(); ie++) {
				qqw.append("{");
				qqw.append("\"XH\":" + ((currpage - 1) * pagecount) + ", ");// 序号
				qqw.append("\"BUSSCODE\": \"" + oConvertUtils.getString(linkBussCode,bussCode) + "\",");
				if (mainList != null && mainList.size() > 0) {
					for (int iq = 0; iq < mainList.size(); iq++) {
						String value = oConvertUtils.getString(
								aaq.get(ie).get(
										mainList.get(iq).getFieldName()), "");

						value = replaceEnter(value);
						qqw.append("\""
								+ oConvertUtils.getString(mainList.get(iq)
										.getFieldName().toUpperCase(), "")
								+ "\": \"" + value + "\",");
					}
				}

				qqw.append("\"mainColumn\":[");
				// ******************指标表*************************/
				if (mainList != null && mainList.size() > 0) {
					for (int iww = 0; iww < mainList.size(); iww++) {
						qqw.append("{");
						qqw.append("\"isShow\":\""
								+ mainList.get(iww).getIsShowList() + "\",");
						qqw.append("\"isListHide\": \"" + mainList.get(iww).getIsListHide()
								+ "\",");
						qqw.append("\"fieldname\":\""
								+ mainList.get(iww).getFieldName()
										.toUpperCase() + "\",");
						qqw.append("\"name\":\""
								+ oConvertUtils.getString(mainList.get(iww)
										.getContent(), "") + "\",");
						String value = oConvertUtils.getString(
								aaq.get(ie).get(
										mainList.get(iww).getFieldName()), "");
//						if("date".equalsIgnoreCase(mainList.get(iww).getType())){
//							String dateType = mainList.get(iww).getShowType();
//							if(value!=null&&value.length()>0){
//								try{
//								if("datetime".equalsIgnoreCase(dateType)){
//									value = DateUtils.dataformat(value, "yyyy-MM-dd HH:mm:ss");
//								}else if("date".equalsIgnoreCase(dateType)){
//									value =  DateUtils.dataformat(value, "yyyy-MM-dd");
//								}
//								}catch(Exception e){
//								}
//							}
//						}
//						if (("select".equals(mainList.get(iww).getShowType())||
//								"list".equals(mainList.get(iww).getShowType()))
//								&&oConvertUtils.isNotEmpty(mainList.get(iww)
//								.getDictField())) {
////							value = systemService.getTypenameByCode(mainList.get(iww)
////									.getDictField(),
////									oConvertUtils.getString(
////											aaq.get(ie).get(
////													mainList.get(iww)
////															.getFieldName()),
////											""));
//							//要换成动态获取表数据，从数据选择来源表中获取
//							
//						}
//						if("popup".equals(mainList.get(iww).getShowType())){//弹窗选择需要查询汉字
//							if(StringUtil.isNotEmpty(mainList.get(iww).getDictField())
//									&&StringUtil.isNotEmpty(mainList.get(iww).getDictTable())
//									&&StringUtil.isNotEmpty(mainList.get(iww).getDictText())){
//								List<Map<String, Object>> rr = systemService.findForJdbc("select "+mainList.get(iww).getDictField()+" from "+mainList.get(iww).getDictTable()+" where "+mainList.get(iww).getDictText()+"='"+value+"'");
//								if(rr!=null&&rr.size()>0){
//									value=rr.get(0).get(mainList.get(iww).getDictField()).toString();
//								}
//							}else{
//								value="未配置查询数据表参数，请联系管理员！";
//							}
//						}

						value = replaceEnter(value);
						
						qqw.append("\"value\":\"" + value + "\"");
						qqw.append("}");
						if ((mainList.size() - iww) != 1) {
							qqw.append(",");
						}
					}
				}
				// ******************指标表*************************/
				qqw.append("]");
				qqw.append("}");
				if ((aaq.size() - ie) != 1) {
					qqw.append(",");
				}
			}
		}
		qqw.append("],");
		qqw.append("\"DataLength\": " + countQueryList.get(0).get("countsize") + ",");
		qqw.append("\"listType\": \"db\"");
		qqw.append("}]");
		System.out.println(qqw.toString());
		return qqw.toString();
	}

	public void querySql(HttpServletRequest request, StringBuffer ssq) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String queryFromFieldNmae = oConvertUtils.getString(
				request.getParameter("queryFromFieldNmae"), "");
		String gno = oConvertUtils.getString(request.getParameter("gno"), "");
		String mainId = oConvertUtils.getString(request.getParameter("mainId"),
				"");
		if (StringUtil.isNotEmpty(queryFromFieldNmae)) {
			String ss[] = queryFromFieldNmae.split("\\,");
			for (int i = 1; i < ss.length; i++) {
				String queryData = oConvertUtils.getString(
						request.getParameter(ss[i]), "");
				String queryDatas[] = queryData.split("\\,");
				if (StringUtil.isNotEmpty(queryData)) {
					if (queryDatas.length > 1) {
						queryData = queryData.replace(",", "','");
						ssq.append("and " + ss[i].replace("@", ".") + " in ('"
								+ queryData + "') ");
					} else {
						ssq.append("and " + ss[i].replace("@", ".")
								+ " like '%" + queryData + "%' ");
					}
				}
			}
		}
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
	 * 根据表名获取字段集合
	 * 
	 * @param tableName
	 * @return
	 */
	public List<CgFormLgFieldEntity> getFieldByTable(String tableName,String bussCode,String[] flag,String bussTemplateId,int versions) {
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
	
	
	public List<CgformBussListEntity> getFieldByBussList(String bussId,String[] flag,int versions) {
		CriteriaQuery cq = new CriteriaQuery(CgformBussListEntity.class);
		cq.eq("bussId", bussId);
		if(flag!=null&&flag.length>0){
			for(int i=0;i<flag.length;i++){
				if("isShowList".equals(flag[i])){
					cq.eq("isShowList", "Y");
				}
			}
		}
		cq.addOrder("sort", SortDirection.asc);
		cq.add();
		return systemService.getListByCriteriaQuery(cq, false);
	}
	
	

}