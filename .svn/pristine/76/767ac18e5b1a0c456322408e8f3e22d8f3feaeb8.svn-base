package com.tj720.mip.controller.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.SortDirection;
import com.design.core.system.service.SystemService;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformDefineEntity;
import com.tj720.admin.dto.ReportEchartsFormat;
import com.tj720.admin.dto.ReportRequestFormat;
import com.tj720.admin.service.ReportService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Tools;

/**
* @author chengrongkai
* @version 创建时间：2018年8月1日 上午10:31:21
* @ClassName 类名称
* @Description 类描述
*/
@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	ReportService reportService;
	@Autowired
	IUserService userService;
	@Autowired
	private Config config;
	@Autowired
	private SystemService systemService;
	@RequestMapping("/customReport.do")
	public ModelAndView customReport(){
		ModelAndView modle = new ModelAndView("/back/report/reportConfig.jsp");
		return modle;
	}
	@RequestMapping("/reportDemo.do")
	public ModelAndView reportDemo(){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/report/reportDemo.jsp");
		return modle;
	}
	@RequestMapping("/addkey.do")
	public ModelAndView addProperty(String type,String key,String name,String isValueKey){
		ModelAndView modle = new ModelAndView("/back/report/addProperty.jsp");
		modle.addObject("type", type);
		HashMap<String,Object> data = new HashMap<String,Object>();
		data.put("key", key);
		data.put("name", name);
		data.put("isValueKey", isValueKey);
		modle.addObject("data", data);
		return modle;
	}
	
	@RequestMapping("/collectionCount.do")
	public ModelAndView collectionCount(){
		ModelAndView modle = new ModelAndView("/back/report/collectionCount.jsp");
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
		modle.addObject("orgId",orgId);
		return modle;
	}
	/**
	 * 获取预览数据
	 * @param sql 
	 * @param reportType 报表类型
	 * @param convertData 映射关系
	 * @param title 报表标题
	 * @return
	 */
	@RequestMapping("/getPreviewReport.do")
	@ResponseBody
	public JsonResult getPreviewReport(@RequestBody ReportRequestFormat data){
		String selecetType = data.getSelectType();
		String title = data.getTitle();
		String type = data.getType();		
		List<HashMap<String, String>> convertData = data.getConvertData();
		String sql = getSqlStr(selecetType);
		ReportEchartsFormat format = reportService.getPriviewData(sql, convertData, type, title);
		return new JsonResult(1,format);
	}
	
	@RequestMapping("/getCollectionCount.do")
	@ResponseBody
	public JsonResult getCollectionCount(String unitId,String areaId){	
		Integer result = reportService.getCollectionCountByCondition(unitId, areaId);
		return new JsonResult(1,result);
	}
	
	@RequestMapping("/getAreaData.do")
	@ResponseBody
	public JsonResult getAreaData(String pid){	
		List<HashMap<String, Object>> result = reportService.getAreaData(pid);
		return new JsonResult(1,result);
	}
	@RequestMapping("/getUnitData.do")
	@ResponseBody
	public JsonResult getUnitData(String pid,String areaId){	
		List<HashMap<String, Object>> result = reportService.getUnitData(pid, areaId);
		return new JsonResult(1,result);
	}
	
	@RequestMapping("/getSelectData.do")
	@ResponseBody
	public JsonResult getSelectData(String pid){	
		List<HashMap<String, Object>> areaSelect = reportService.getAreaData(pid);
		List<HashMap<String, Object>> unitSelect = reportService.getUnitData(pid,null);
		HashMap<String,Object> data = new HashMap<String,Object>();		
		if(null != areaSelect){
			data.put("areaSelect", areaSelect);			
		}
		if(null != unitSelect){
			data.put("unitSelect", unitSelect);			
		}
		return new JsonResult(1,data);
	}
	
	private String getSqlStr(String selecetType){
		String sqlStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date startDay = new Date();
		if("attendanceDay".equals(selecetType)) {
			startDay.setDate(startDay.getDate() - 8);
			String year = sdf.format(startDay);
			for (int i = 7; i > 0; i--) {
				startDay.setDate(startDay.getDate() + 1);
				sqlStr += " select '"+getFormatDate(startDay.getMonth()+1)+"/"+getFormatDate(startDay.getDate())+"' as day,IFNULL(sum(day"+startDay.getDate()+"), 0) as num " +
					"from museum_visitor_number a "+
					"INNER JOIN mip_organization b on(a.museum_id=b.id and b.platform_id = '1') "+
					"where a.`year` = '"+year+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 1){
					sqlStr += " UNION ALL ";
				}
			}
		}
		if("attendanceDay2".equals(selecetType)) {
			startDay.setMonth(startDay.getMonth()-7);
			for (int i = 1; i <= 6; i++) {
				startDay.setMonth(startDay.getMonth() + 1);
				String year = sdf.format(startDay);
				sqlStr += " select '"+year+"年"+getFormatDate(startDay.getMonth()+1)+"月' as month,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a "+
					"INNER JOIN mip_organization b on(a.museum_id=b.id and b.platform_id = '1') "+
					"where a.`year` = '"+year+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 6){
					sqlStr += " UNION ALL ";
				}
			}
		}
		if("attendanceDay3".equals(selecetType)) {
			startDay.setYear(startDay.getYear()-6);
			for (int i = 1; i <= 6; i++) {
				startDay.setYear(startDay.getYear() + 1);
				String year = sdf.format(startDay);
				sqlStr += " select '"+year+"年' as year,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a "+
					"INNER JOIN mip_organization b on(a.museum_id=b.id and b.platform_id = '1') "+
					"where a.`year` = '"+year +"'";
				if(i != 6){
					sqlStr += " UNION ALL ";
				}
			}
		}
		if("attendanceMonth".equals(selecetType)) {
			startDay.setDate(startDay.getDate()-8);
			for (int i = 7; i > 0; i--) {
				startDay.setDate(startDay.getDate() + 1);
				String year = sdf.format(startDay);
				sqlStr += " select '"+getFormatDate(startDay.getMonth()+1)+"/"+getFormatDate(startDay.getDate())+"' as day,IFNULL(sum(day"+startDay.getDate()+"), 0) as num " +
					"from museum_visitor_number a where a.`year` = '"+year+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 1){
					sqlStr += " UNION ALL ";
				}
			}
		}
		if("attendanceMonth2".equals(selecetType)) {
			startDay.setMonth(startDay.getMonth()-7);
			for (int i = 1; i <= 6; i++) {
				startDay.setMonth(startDay.getMonth() + 1);
				String year = sdf.format(startDay);
				sqlStr += " select '"+year+"年"+getFormatDate(startDay.getMonth()+1)+"月' as month,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a where a.`year` = '"+year+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 6){
					sqlStr += " UNION ALL ";
				}
			}
		}
		if("attendanceMonth3".equals(selecetType)) {
			startDay.setYear(startDay.getYear()-6);
			for (int i = 1; i <= 6; i++) {
				startDay.setYear(startDay.getYear() + 1);
				String year = sdf.format(startDay);
				sqlStr += " select '"+year+"年' as year,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a where a.`year` = '"+year +"'";
				if(i != 6){
					sqlStr += " UNION ALL ";
				}
			}
		}
		if("collectionCount".equals(selecetType)) {
			sqlStr = "select b.name, count(a.id) as num from mip_open_culturalrelic_info a " +
					" left join mip_collection_level b on(a.collection_level = b.id) " +
					" GROUP BY b.id ";
		}
		if("tempExhibition".equals(selecetType)) {
			String businessData = getBusinessData(config.getBusinessExhibition());
			if(!StringUtils.isBlank(businessData)) {
				businessData = businessData.substring(0, businessData.lastIndexOf(" union all ")-1);
				for (int i = 7; i > 0; i--) {
					sqlStr += " select date_format(DATE_SUB(curdate(), INTERVAL "+i+" MONTH),'%Y年%m月') as month, count(a.id) as num " + 
							"from ( ";
					sqlStr += businessData;
					sqlStr += ") a where date_format(a.date, '%Y %m') = date_format(DATE_SUB(curdate(), INTERVAL "+i+" MONTH),'%Y %m')";
					
					if(i != 1) {
						sqlStr += " union all ";
					}
				}
			}
		}
		return sqlStr;
	}
	
	/**
	 * 根据busscode，拼接sql
	 * @param sql
	 * @param bussCode
	 */
	private String getBusinessData(String bussCode) {
		String mainTableName = "cgform_rdata_master";
		try {
			CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
			if(cgformBuss==null){
			}else {
				JSONObject jo=new JSONObject();
				String fields="",tempFields="";
				CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
				List<CgformBussListEntity> mainList = getFieldByBussList(cgformBuss.getId(),new String[]{"isShowList"});
				List<Map<String, Object>> rr1 = systemService.findForJdbc("SELECT field_name,temp_field   FROM cgform_field_temp"
						+ "  where buss_id='"+cgformBuss.getId()+"' ");
				if(mainList!=null&&mainList.size()>0){
					tempFields+="id as id,";
					tempFields+="create_date as date,";
					tempFields+="org_id as orgId,";
					if(mainList.get(1) != null) {
						for (Map<String, Object> map : rr1) {
							String fieldName = mainList.get(1).getFieldName();
							if(fieldName.equals(map.get("field_name"))) {
								tempFields+=map.get("temp_field")+" as name,";
							}
						}
					}
					tempFields += "'"+bussCode+"'" + " as bussCode,";
					tempFields=tempFields.substring(0, tempFields.length()-1);
				}
				StringBuffer ssq = new StringBuffer();
				ssq.append(" SELECT  "+(!"".equals(tempFields)?tempFields:fields));
				ssq.append(" FROM "+mainTableName+" ");
				ssq.append(" where 1=1 ");
				if("2".equals(tSConfigform.getSaveType())){
					ssq.append(" and  buss_id='"+cgformBuss.getId()+"' ");
				}
				return ssq.toString() + " union all ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public List<CgformBussListEntity> getFieldByBussList(String bussId,String[] flag) {
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
	
	private String getFormatDate(int arg) {
		String argStr = String.valueOf(arg);
		if(StringUtils.isBlank(argStr)) {
			return "";
		}
	    if (argStr.length()<2) {
	    	argStr = '0' + argStr;
	    }
	    return argStr;
	}
	
	
}

