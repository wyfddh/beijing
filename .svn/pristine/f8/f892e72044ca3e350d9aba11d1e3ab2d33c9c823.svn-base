package com.design.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.hibernate.qbc.HqlQuery;
import com.design.core.common.hibernate.qbc.PageList;
import com.design.core.common.model.common.DBTable;
import com.design.core.common.model.json.DataTableReturn;

/**
 * 
 * 类描述：DAO层泛型基类接口
 * 
 * 张代浩
 * @date： 日期：2012-12-8 时间：下午05:37:33
 * @version 1.0
 */
public interface IGenericBaseCommonDao {

	public Integer getAllDbTableSize() throws Exception;

	public <T> Serializable save(T entity) throws Exception;

	public <T> void batchSave(List<T> entitys) throws Exception;

	public <T> void saveOrUpdate(T entity) throws Exception;

	/**
	 * 删除实体
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param entitie
	 * @throws Exception 
	 */
	public <T> void delete(T entitie) throws Exception;

	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public <T> T get(Class<T> entityName, Serializable id) throws Exception;

	/**
	 * 根据实体名字获取唯一记录
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	public <T> T findUniqueByProperty(Class<T> entityClass,
			String propertyName, Object value) throws Exception;

	/**
	 * 按属性查找对象列表.
	 */
	public <T> List<T> findByProperty(Class<T> entityClass,
			String propertyName, Object value);

	/**
	 * 加载全部实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> loadAll(final Class<T> entityClass);

	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public <T> T getEntity(Class entityName, Serializable id) throws Exception;

	public <T> void deleteEntityById(Class entityName, Serializable id) throws Exception;

	/**
	 * 删除实体集合
	 * 
	 * @param <T>
	 * @param entities
	 * @throws Exception 
	 */
	public <T> void deleteAllEntitie(Collection<T> entities) throws Exception;

	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 * @throws Exception 
	 */
	public <T> void updateEntitie(T pojo) throws Exception;

	public <T> void updateEntityById(Class entityName, Serializable id) throws Exception;

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);

	/**
	 * 通过hql查询唯一对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> T singleResult(String hql);

	/**
	 * 根据sql更新
	 * 
	 * @param query
	 * @return
	 */
	public int updateBySqlString(String sql);

	/**
	 * 根据sql查找List
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findListbySql(String query);

	/**
	 * 通过属性称获取实体带排序
	 * 
	 * @param <T>
	 * @param clas
	 * @return
	 */
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
			String propertyName, Object value, boolean isAsc);

	/**
	 * 
	 * cq方式分页
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	public PageList getPageList(final CriteriaQuery cq, final boolean isOffset);

	/**
	 * 通过cq获取全部实体
	 * 
	 * @param <T>
	 * @param cq
	 * @return
	 */
	public <T> List<T> getListByCriteriaQuery(final CriteriaQuery cq,
			Boolean ispage);

	/**
	 * 
	 * hqlQuery方式分页
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	public PageList getPageList(final HqlQuery hqlQuery,
			final boolean needParameter);

	/**
	 * 
	 * sqlQuery方式分页
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	public PageList getPageListBySql(final HqlQuery hqlQuery,
			final boolean needParameter);

	public Session getSession();

	public List findByExample(final String entityName,
			final Object exampleEntity);

	/**
	 * 通过hql 查询语句查找HashMap对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public Map<Object, Object> getHashMapbyQuery(String query);

	/**
	 * 返回jquery datatables模型
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */
	public DataTableReturn getDataTableReturn(final CriteriaQuery cq,
			final boolean isOffset);

	/**
	 * 返回easyui datagrid模型
	 * 
	 * @param cq
	 * @param isOffset
	 * @return
	 */

	public void getDataGridReturn(CriteriaQuery cq,
			final boolean isOffset);


	/**
	 * 执行SQL
	 */
	public Integer executeSql(String sql, List<Object> param);

	/**
	 * 执行SQL
	 */
	public Integer executeSql(String sql, Object... param);

	/**
	 * 执行SQL 使用:name占位符
	 */
	public Integer executeSql(String sql, Map<String, Object> param);
	/**
	 * 执行SQL 使用:name占位符,并返回插入的主键值
	 */
	public Object executeSqlReturnKey(String sql, Map<String, Object> param);
	/**
	 * 通过JDBC查找对象集合 使用指定的检索标准检索数据返回数据
	 */
	public List<Map<String, Object>> findForJdbc(String sql, Object... objs);

	/**
	 * 通过JDBC查找对象集合 使用指定的检索标准检索数据返回数据
	 */
	public Map<String, Object> findOneForJdbc(String sql, Object... objs);

	/**
	 * 通过JDBC查找对象集合,带分页 使用指定的检索标准检索数据并分页返回数据
	 */
	public List<Map<String, Object>> findForJdbc(String sql, int page, int rows);

	/**
	 * 通过JDBC查找对象集合,带分页 使用指定的检索标准检索数据并分页返回数据
	 */
	public <T> List<T> findObjForJdbc(String sql, int page, int rows,
			Class<T> clazz);

	/**
	 * 使用指定的检索标准检索数据并分页返回数据-采用预处理方式
	 * 
	 * @param criteria
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws DataAccessException
	 */
	public List<Map<String, Object>> findForJdbcParam(String sql, int page,
			int rows, Object... objs);

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC
	 */
	public Long getCountForJdbc(String sql);

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
	 * 
	 */
	public Long getCountForJdbcParam(String sql, Object[] objs);

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findHql(String hql, Object... param);

	/**
	 * 执行HQL语句操作更新
	 * 
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql);

	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
			int maxResult);

	public <T> List<T> findByDetached(DetachedCriteria dc);

	/**
	 * 执行存储过程
	 * @param execute
	 */
	public <T> List<T> executeProcedure(String procedureSql,Object... params);

}
