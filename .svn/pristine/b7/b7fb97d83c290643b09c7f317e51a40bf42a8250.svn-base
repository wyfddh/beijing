package com.design.core.system.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.hibernate.qbc.HqlQuery;
import com.design.core.common.hibernate.qbc.PageList;
import com.design.core.common.model.common.UploadFile;
import com.design.core.common.model.json.DataTableReturn;
import com.design.core.dao.ICommonDao;
import com.design.core.system.service.CommonService;
import com.design.utils.ParameterUtil;
import com.zxlhdata.framework.auth.util.LicenseUtil;

@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {
	public ICommonDao commonDao = null;


	@Resource
	public void setCommonDao(ICommonDao commonDao) {
		this.commonDao = commonDao;
	}

	
	public <T> Serializable save(T entity) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		return commonDao.save(entity);
	}

	
	public <T> void saveOrUpdate(T entity) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		commonDao.saveOrUpdate(entity);

	}

	
	public <T> void delete(T entity) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		commonDao.delete(entity);

	}

	/**
	 * 删除实体集合
	 * 
	 * @param <T>
	 * @param entities
	 * @throws Exception 
	 */
	public <T> void deleteAllEntitie(Collection<T> entities) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		commonDao.deleteAllEntitie(entities);
	}

	/**
	 * 根据实体名获取对象
	 * @throws Exception 
	 */
	@Transactional(readOnly = true)  
	public <T> T get(Class<T> class1, Serializable id) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		return commonDao.get(class1, id);
	}

	/**
	 * 根据实体名返回全部对象
	 * 
	 * @param <T>
	 * @param hql
	 * @param size
	 * @return
	 */
    @Transactional(readOnly = true)
	public <T> List<T> getList(Class clas) {
		return commonDao.loadAll(clas);
	}

	/**
	 * 根据实体名获取对象
	 * @throws Exception 
	 */
    @Transactional(readOnly = true)
	public <T> T getEntity(Class entityName, Serializable id) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		return commonDao.getEntity(entityName, id);
	}

	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 * @throws Exception 
	 */
    @Transactional(readOnly = true)
	public <T> T findUniqueByProperty(Class<T> entityClass,
			String propertyName, Object value) throws Exception {
//    	int randomCode = new Random(System.currentTimeMillis()).nextInt(100) +1;
//			//LicenseUtil.valid(ParameterUtil.ATC_K,randomCode);
		return commonDao.findUniqueByProperty(entityClass, propertyName, value);
	}

	/**
	 * 按属性查找对象列表.
	 * @throws Exception 
	 */
    @Transactional(readOnly = true)
	public <T> List<T> findByProperty(Class<T> entityClass,
			String propertyName, Object value) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		return commonDao.findByProperty(entityClass, propertyName, value);
	}

	/**
	 * 加载全部实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
    @Transactional(readOnly = true)
	public <T> List<T> loadAll(final Class<T> entityClass) {
    	try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.loadAll(entityClass);
	}

    @Transactional(readOnly = true)
	public <T> T singleResult(String hql) {
		return commonDao.singleResult(hql);
	}

	/**
	 * 删除实体主键ID删除对象
	 * 
	 * @param <T>
	 * @param entities
	 * @throws Exception 
	 */
	public <T> void deleteEntityById(Class entityName, Serializable id) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		commonDao.deleteEntityById(entityName, id);
	}

	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 * @throws Exception 
	 */
	public <T> void updateEntitie(T pojo) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		commonDao.updateEntitie(pojo);

	}

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> findByQueryString(String hql) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findByQueryString(hql);
	}

	/**
	 * 根据sql更新
	 * 
	 * @param query
	 * @return
	 */
	public int updateBySqlString(String sql) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.updateBySqlString(sql);
	}

	/**
	 * 根据sql查找List
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> findListbySql(String query) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findListbySql(query);
	}

	/**
	 * 通过属性称获取实体带排序
	 * 
	 * @param <T>
	 * @param clas
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
			String propertyName, Object value, boolean isAsc) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findByPropertyisOrder(entityClass, propertyName,
				value, isAsc);
	}

	/**
	 * 
	 * cq方式分页
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	@Transactional(readOnly = true)
	public PageList getPageList(final CriteriaQuery cq, final boolean isOffset) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getPageList(cq, isOffset);
	}

	/**
	 * 返回DataTableReturn模型
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	@Transactional(readOnly = true)
	public DataTableReturn getDataTableReturn(final CriteriaQuery cq,
			final boolean isOffset) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getDataTableReturn(cq, isOffset);
	}

	/**
	 * 返回easyui datagrid模型
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */

	@Transactional(readOnly = true)
	public void getDataGridReturn(final CriteriaQuery cq,
			final boolean isOffset) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commonDao.getDataGridReturn(cq, isOffset);

	}

	/**
	 * 
	 * hqlQuery方式分页
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	@Transactional(readOnly = true)
	public PageList getPageList(final HqlQuery hqlQuery,
			final boolean needParameter) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getPageList(hqlQuery, needParameter);
	}

	/**
	 * 
	 * sqlQuery方式分页
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	@Transactional(readOnly = true)
	public PageList getPageListBySql(final HqlQuery hqlQuery,
			final boolean isToEntity) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getPageListBySql(hqlQuery, isToEntity);
	}

	public Session getSession()

	{
		return commonDao.getSession();
	}

	@Transactional(readOnly = true)
	public List findByExample(final String entityName,
			final Object exampleEntity) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findByExample(entityName, exampleEntity);
	}

	/**
	 * 通过cq获取全部实体
	 * 
	 * @param <T>
	 * @param cq
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> getListByCriteriaQuery(final CriteriaQuery cq,
			Boolean ispage) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getListByCriteriaQuery(cq, ispage);
	}

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @throws Exception 
	 */
	public <T> T uploadFile(UploadFile uploadFile) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		return commonDao.uploadFile(uploadFile);
	}

	@Transactional(readOnly = true)
	public HttpServletResponse viewOrDownloadFile(UploadFile uploadFile)

	{
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.viewOrDownloadFile(uploadFile);
	}


	
	public Integer executeSql(String sql, List<Object> param) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.executeSql(sql, param);
	}

	
	public Integer executeSql(String sql, Object... param) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.executeSql(sql, param);
	}

	
	public Integer executeSql(String sql, Map<String, Object> param) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.executeSql(sql, param);
	}
	
	public Object executeSqlReturnKey(String sql, Map<String, Object> param) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.executeSqlReturnKey(sql, param);
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findForJdbc(sql, page, rows);
	}

	@Transactional(readOnly = true)
	public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findForJdbc(sql, objs);
	}

	@Transactional(readOnly = true)
	public List<Map<String, Object>> findForJdbcParam(String sql, int page,
			int rows, Object... objs) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findForJdbcParam(sql, page, rows, objs);
	}

	@Transactional(readOnly = true)
	public <T> List<T> findObjForJdbc(String sql, int page, int rows,
			Class<T> clazz) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findObjForJdbc(sql, page, rows, clazz);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.findOneForJdbc(sql, objs);
	}

	@Transactional(readOnly = true)
	public Long getCountForJdbc(String sql) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getCountForJdbc(sql);
	}

	@Transactional(readOnly = true)
	public Long getCountForJdbcParam(String sql, Object... objs) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonDao.getCountForJdbcParam(sql,objs);
	}


	
	public <T> void batchSave(List<T> entitys) throws Exception {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		this.commonDao.batchSave(entitys);
	}

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> findHql(String hql, Object... param) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.commonDao.findHql(hql, param);
	}

	@Transactional(readOnly = true)
	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
			int maxResult) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.commonDao.pageList(dc, firstResult, maxResult);
	}

	@Transactional(readOnly = true)
	public <T> List<T> findByDetached(DetachedCriteria dc) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.commonDao.findByDetached(dc);
	}

	/**
	 * 调用存储过程
	 */
	public <T> List<T> executeProcedure(String procedureSql,Object... params) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.commonDao.executeProcedure(procedureSql, params);
	}


}
