package com.design.form.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.system.service.SystemService;
import com.design.form.service.CgformReportIndexServiceI;
import com.design.utils.StringUtil;

@Service("cgformReportIndexService")
@Transactional
public class CgformReportIndexServiceImpl  implements
CgformReportIndexServiceI {

	@Autowired
	private SystemService systemService;
	
	public List<Map<String, Object>> getCgformReportIndexList(HttpServletRequest request) {
		StringBuffer sql = new StringBuffer();
		sql.append("select t.id,t.content,t.field_name,t.group_id from cgform_report_index t where 1=1 ");
		String content = request.getParameter("content");
		if(StringUtil.isNotEmpty(content)){
			sql.append(" and t.content like '%" + content + "%'");
		}
		return systemService.findForJdbc(sql.toString());
	}
	
	public Map<String, Object> getCgformReportIndex(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer mainSql = new StringBuffer();
		mainSql.append(" select * from cgform_report_index where 1=1");
		String groupId = request.getParameter("groupId");
		if(StringUtil.isNotEmpty(groupId)){
			mainSql.append(" and group_id = '" + groupId + "'");
		}
		//执行查询SQL，获取数据
		List<Map<String, Object>> mainList = null;
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if(StringUtil.isNotEmpty(rows) && StringUtil.isNotEmpty(page)){
			int count = this.getQueryCount(mainSql.toString(), null);
			result.put("DataLength", count);
			mainList = systemService.findForJdbc(this.getPageSql(mainSql.toString(), Integer.parseInt(rows), Integer.parseInt(page)));
		}else{
			mainList = systemService.findForJdbc(mainSql.toString());
		}
		result.put("MainList", mainList);
		return result;
	}
	
	/**
	 * 获取查询总条数
	 * @param sql
	 * @param par
	 * @return
	 */
	public int getQueryCount(String sql, Object[] par){
		//TODO @author hzq 
		//ORA-00904: "GROUP_CONCAT": 标识符无效
		sql = "SELECT count(1) RECORDS FROM ("+sql+") ABC";
		Map<String, Object> map = systemService.findOneForJdbc(sql, par);
		return Integer.parseInt(String.valueOf(map.get("RECORDS")));
	}
	
	/**
	 * 返回分页SQL
	 * @param sql		原始SQL
	 * @param pageSize	每页显示条数
	 * @param currPage	当前页
	 * @return
	 */
	public String getPageSql(String sql, int pageSize, int currPage){
		//sql = sql.toUpperCase();
		if(currPage<=0) currPage = 1;
		StringBuffer pageSql = new StringBuffer();
		//Mysql版本分页
		pageSql.append("SELECT * FROM ("+sql+") ABC LIMIT ");
		pageSql.append((currPage-1)*pageSize+","+pageSize);
		return pageSql.toString();
	}
}