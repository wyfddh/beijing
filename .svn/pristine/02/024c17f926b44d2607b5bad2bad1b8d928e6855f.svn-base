package com.design.form.service.impl;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.system.service.SystemService;
import com.design.core.system.service.impl.CommonServiceImpl;
import com.design.entity.CgformDefineEntity;
import com.design.form.service.CgformDefineServiceI;
import com.design.utils.DateUtils;
import com.design.utils.StringUtil;

@Service("cgformDefineService")
@Transactional
public class CgformDefineServiceImpl extends CommonServiceImpl implements CgformDefineServiceI {
	@Autowired
	private SystemService systemService;
	
 	public <T> void delete(T entity) throws Exception {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CgformDefineEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) throws Exception {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((CgformDefineEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) throws Exception {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((CgformDefineEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformDefineEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformDefineEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformDefineEntity t){
	 	return true;
 	}
 	
 	public Map<String, Object> getCgformDefine(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer mainSql = new StringBuffer();
		mainSql.append(" select * from cgform_define where 1=1");
		String defineName = request.getParameter("defineName");
		String type = request.getParameter("type");
		if(StringUtil.isNotEmpty(defineName)){
			mainSql.append(" and define_name like '%" + defineName + "%'");
		}
		if(StringUtil.isNotEmpty(type)){
			mainSql.append(" and buss_type = '" + type + "'");
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
		for (Map<String, Object> map : mainList) {
			String status = (String)map.get("status");//状态：0未发布；1：已发布
			String define_type = (String)map.get("type");//表单类别：1研究；2藏品；3展览；4教育
			String buss_type = (String)map.get("buss_type");//业务分类：1：业务表单；2：非业务表单
			String save_type = (String)map.get("save_type");//存储方式：1建表存储；2键值存储
			Date createDate = (Date)map.get("create_date");
			String status_cn = "";
			if("0".equals(status)){
				status_cn = "未发布";
			}else if("1".equals(status)){
				status_cn = "已发布";
			}
			String buss_type_cn = "";
			if("1".equals(buss_type)){
				buss_type_cn = "业务表单";
			}else if("2".equals(buss_type)){
				buss_type_cn = "非业务表单";
			}else if("3".equals(buss_type)){
				buss_type_cn = "系统表单";
			}
			
			String save_type_cn = "";
			if("1".equals(save_type)){
				save_type_cn = "建表存储";
			}else if("2".equals(save_type)){
				save_type_cn = "键值存储";
			}
			
			String type_cn = "";
			if("1".equals(define_type)){
				type_cn = "研究";
			}else if("2".equals(define_type)){
				type_cn = "藏品";
			}else if("3".equals(define_type)){
				type_cn = "展览";
			}else if("4".equals(define_type)){
				type_cn = "教育";
			}
			map.put("type_cn", type_cn);
			map.put("save_type_cn", save_type_cn);
			map.put("buss_type_cn", buss_type_cn);
			map.put("status_cn", status_cn);
			map.put("createDate_cn", DateUtils.formatDate(createDate,"yyyy-MM-dd HH:mm:ss"));
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