package com.design.form.service.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.config.util.DbTableProcess;
import com.design.core.system.service.SystemService;
import com.design.core.system.service.impl.CommonServiceImpl;
import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformButtonEntity;
import com.design.entity.CgformDefineEntity;
import com.design.entity.CgformDefineJsEntity;
import com.design.entity.CgformTabEntity;
import com.design.form.service.CgformBussServiceI;
import com.design.utils.DateUtils;
import com.design.utils.MyBeanUtils;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;

@Service("cgformBussService")
@Transactional
public class CgformBussServiceImpl extends CommonServiceImpl implements CgformBussServiceI {
	@Autowired
	private SystemService systemService;
	
 	public <T> void delete(T entity) throws Exception {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CgformBussEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) throws Exception {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((CgformBussEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) throws Exception {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((CgformBussEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformBussEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformBussEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformBussEntity t){
	 	return true;
 	}
 	
 	public Map<String, Object> getCgformBuss(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer mainSql = new StringBuffer();
		mainSql.append(" select * from cgform_buss where 1=1");
		String bussName = request.getParameter("bussName");
		if(StringUtil.isNotEmpty(bussName)){
			mainSql.append(" and buss_name like '%" + bussName + "%'");
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
			String status = (String)map.get("status");
			Date createDate = (Date)map.get("create_date");
			String status_cn = "";
			if(status.equals("0")){
				status_cn = "未发布";
			}else if(status.equals("1")){
				status_cn = "已发布";
			}
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
 	
	public CgformBussEntity saveAndCopyDefine(CgformBussEntity cgformBuss, HttpServletRequest request) throws Exception{
		if(StringUtil.isEmpty(cgformBuss.getId())){//如果为空则保存
			cgformBuss.setBussCode("B"+System.currentTimeMillis());
			cgformBuss.setCreateBy(oConvertUtils.getString(request.getSession().getAttribute("create_by"),"admin"));
			cgformBuss.setCreateName(oConvertUtils.getString(request.getSession().getAttribute("create_name"),"admin"));
			cgformBuss.setStatus("0");
			cgformBuss.setCreateDate(new Date());
			this.save(cgformBuss);
		}else{
			cgformBuss = systemService.get(CgformBussEntity.class, cgformBuss.getId());
		}
		CgformDefineEntity cgformDefineEntity = systemService.getEntity(CgformDefineEntity.class, cgformBuss.getDefineId());
		if(cgformDefineEntity==null){
			throw new Exception();
		}
		CgformDefineEntity t = new CgformDefineEntity();
		MyBeanUtils.copyBeanNotNull2Bean(cgformDefineEntity, t);
		t.setDefineCode("BD"+System.currentTimeMillis());
		t.setDefineName("引用("+cgformDefineEntity.getDefineCode()+")");
		t.setBussId(cgformBuss.getId());
		t.setResourceId(cgformDefineEntity.getId());
		t.setCreateDate(new Date());
		systemService.save(t);
		
		List<CgFormLgFieldEntity> queryList = cgformDefineEntity.getColumns();
		List<CgFormLgFieldEntity> newQueryList = new ArrayList<CgFormLgFieldEntity>();
		t.setColumns(newQueryList);
		if(queryList.isEmpty()||queryList.size()==0){
			throw new Exception();
		}
		for (CgFormLgFieldEntity cgFormLgFieldEntity : queryList) {
			CgFormLgFieldEntity newCgFormLgField = new CgFormLgFieldEntity();
			String oldBussCode=cgFormLgFieldEntity.getBussCode();
			String id=cgFormLgFieldEntity.getId();
			MyBeanUtils.copyBeanNotNull2Bean(cgFormLgFieldEntity, newCgFormLgField);
			newCgFormLgField.setDefineId(t.getId());
			newCgFormLgField.setBussId(cgformBuss.getId());
			newCgFormLgField.setBussCode(t.getDefineCode());
			newCgFormLgField.setInputId(cgFormLgFieldEntity.getInputId().replace(oldBussCode, t.getDefineCode()));
			newCgFormLgField.setCreateDate(new Date());
			newCgFormLgField.setId("");
			systemService.save(newCgFormLgField);
			newQueryList.add(newCgFormLgField);
			//默认id在列表展示
			if("id".equals(cgFormLgFieldEntity.getFieldName().toLowerCase())){
				CgformBussListEntity cgformBussList=new CgformBussListEntity();
				cgformBussList.setBussId(cgformBuss.getId());
				cgformBussList.setColumnWidth("100");
				cgformBussList.setContent(newCgFormLgField.getContent());
				cgformBussList.setDefineId(newCgFormLgField.getId());
				cgformBussList.setFieldName(newCgFormLgField.getFieldName());
				cgformBussList.setIsImagelist("N");
				cgformBussList.setIsListHide("Y");
				cgformBussList.setIsShowList("Y");
				cgformBussList.setSort(0);
				systemService.save(cgformBussList);
			}
			//保存按钮
			CriteriaQuery cq3 = new CriteriaQuery(CgformButtonEntity.class);
			cq3.eq("formId", cgFormLgFieldEntity.getFieldName());
			cq3.eq("defineCode", cgformDefineEntity.getDefineCode());
			cq3.add();
			List<CgformButtonEntity> cgformButtonList = systemService.getListByCriteriaQuery(cq3, false);
			if(cgformButtonList!=null&&cgformButtonList.size()>0){
				for(CgformButtonEntity old_cgformButton:cgformButtonList){
					CgformButtonEntity new_cgformButton=new CgformButtonEntity();
					try {
						MyBeanUtils.copyBeanNotNull2Bean(old_cgformButton, new_cgformButton);
						new_cgformButton.setFormId(newCgFormLgField.getFieldName());
						new_cgformButton.setDefineCode(t.getDefineCode());
						new_cgformButton.setId("");
						systemService.save(new_cgformButton);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//保存多页签
			CriteriaQuery cq31_ = new CriteriaQuery(CgformTabEntity.class);
			cq31_.eq("formId", cgFormLgFieldEntity.getFieldName());
			cq31_.eq("defineCode", cgformDefineEntity.getDefineCode());
			cq31_.add();
			List<CgformTabEntity> cgformTabList = systemService.getListByCriteriaQuery(cq31_, false);
			if(cgformTabList!=null&&cgformTabList.size()>0){
				for(CgformTabEntity old_cgformTab:cgformTabList){
					CgformTabEntity new_cgformTab=new CgformTabEntity();
					try {
						MyBeanUtils.copyBeanNotNull2Bean(old_cgformTab, new_cgformTab);
						new_cgformTab.setFormId(newCgFormLgField.getFieldName());
						new_cgformTab.setDefineCode(t.getDefineCode());
						new_cgformTab.setId("");
						systemService.save(new_cgformTab);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//---------------拷贝自定义js文件到新的文件路径
		
		CriteriaQuery oldcq1 = new CriteriaQuery(CgformDefineJsEntity.class);
		oldcq1.eq("defineCode", cgformDefineEntity.getDefineCode());
		oldcq1.eq("version", -1);
		oldcq1.add();
  		List<CgformDefineJsEntity> oldCgformDefineJsList= systemService.getListByCriteriaQuery(oldcq1, false);
		CriteriaQuery newcq1 = new CriteriaQuery(CgformDefineJsEntity.class);
		newcq1.eq("defineCode", t.getDefineCode());
		newcq1.eq("version", -1);
		newcq1.add();
  		List<CgformDefineJsEntity> newCgformDefineJsList= systemService.getListByCriteriaQuery(newcq1, false);
		
		
		if(oldCgformDefineJsList!=null&&oldCgformDefineJsList.size()>0){
			if(newCgformDefineJsList!=null&&newCgformDefineJsList.size()>0){
				systemService.deleteAllEntitie(newCgformDefineJsList);
			}
			for(int i=0;i<oldCgformDefineJsList.size();i++){
				String jsString = oldCgformDefineJsList.get(i).getJs();
				String jsonString = oldCgformDefineJsList.get(i).getJson();
				if(StringUtil.isNotEmpty(jsString)){
					jsString=jsString.replace(cgformDefineEntity.getDefineCode(), t.getDefineCode());
				}
				if(StringUtil.isNotEmpty(jsonString)){
					jsonString=jsonString.replace(cgformDefineEntity.getDefineCode(), t.getDefineCode());
				}
				
				CgformDefineJsEntity newCgformDefineJs=new CgformDefineJsEntity();
				newCgformDefineJs.setDefineCode(t.getDefineCode());
				newCgformDefineJs.setJs(jsString);
				newCgformDefineJs.setJson(jsonString);
				newCgformDefineJs.setVersion(-1);
				newCgformDefineJs.setNodeCode(oldCgformDefineJsList.get(i).getNodeCode());
				systemService.save(newCgformDefineJs);
			}
		}
		
		
//		String design_path =ResourceUtil.getConfigByName("designWebPath");
//		String oldJs=design_path+"designPlug-in/design-js/"+cgformDefineEntity.getDefineCode()+"/v-1.js";
//		String newJs=design_path+"designPlug-in/design-js/"+t.getDefineCode();
//		File newf = new File(newJs);
//		if(!newf.exists()){//文件夹不存在先创建文件夹
//			newf.mkdirs();
//		}
//		newJs+="/v-1.js";
//		File oldfile = new File(oldJs);
//		if(oldfile.exists()){
//			String input = org.apache.commons.io.FileUtils.readFileToString(oldfile, "UTF-8");
//			try {
//				File newfile = new File(newJs);
//				if (!newfile.exists()) {
//					//如果文件存在就先删除
//					newfile.createNewFile();
//				}
//				OutputStreamWriter out = new OutputStreamWriter(
//						new FileOutputStream(newfile), "UTF-8");
//				out.write(input.replace(cgformDefineEntity.getDefineCode(), t.getDefineCode()));
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//		}
//		String oldJson=design_path+"designPlug-in/design-js/"+cgformDefineEntity.getDefineCode()+"/JsEvent.json";
//		String newJson=design_path+"designPlug-in/design-js/"+t.getDefineCode()+"/JsEvent.json";
//		File oldJsonfile = new File(oldJson);
//		if(oldJsonfile.exists()){
//			String input = org.apache.commons.io.FileUtils.readFileToString(oldJsonfile, "UTF-8");
//			try {
//				File newJsonfile = new File(newJson);
//				if (!newJsonfile.exists()) {
//					//如果文件存在就先删除
//					newJsonfile.createNewFile();
//				}
//				OutputStreamWriter out = new OutputStreamWriter(
//						new FileOutputStream(newJsonfile), "UTF-8");
//				out.write(input.replace(cgformDefineEntity.getDefineCode(), t.getDefineCode()));
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//		}
		
		
		
		//---------------拷贝自定义js文件到新的文件路径
		
		
		t.setColumns(newQueryList);
		if("1".equals(t.getSaveType())){
			DbTableProcess dbTableProcess = new DbTableProcess(systemService.getSession());
			String tableName = "cgform_b_"+System.currentTimeMillis();
			t.setMtableName(tableName);
			boolean result = dbTableProcess.createOrDropTable(t, systemService.getSession());
			if(!result){
				throw new Exception();
			}
			t.setColumns(newQueryList);
			systemService.saveOrUpdate(t);
		}
		cgformBuss.setDefineId(t.getId());
		systemService.saveOrUpdate(cgformBuss);
		return cgformBuss;
	}
	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CgformBussEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{buss_code}",String.valueOf(t.getBussCode()));
 		sql  = sql.replace("#{buss_name}",String.valueOf(t.getBussName()));
 		sql  = sql.replace("#{menu_id}",String.valueOf(t.getMenuId()));
 		sql  = sql.replace("#{menu_name}",String.valueOf(t.getMenuName()));
 		sql  = sql.replace("#{define_id}",String.valueOf(t.getDefineId()));
 		sql  = sql.replace("#{versionnum}",String.valueOf(t.getVersionnum()));
 		sql  = sql.replace("#{is_index}",String.valueOf(t.getIsIndex()));
 		sql  = sql.replace("#{is_sum}",String.valueOf(t.getIsSum()));
 		sql  = sql.replace("#{sum_column}",String.valueOf(t.getSumColumn()));
 		sql  = sql.replace("#{is_page}",String.valueOf(t.getIsPage()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}