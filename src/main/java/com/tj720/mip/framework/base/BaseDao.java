package com.tj720.mip.framework.base;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@SuppressWarnings("unchecked")
public class BaseDao<T extends BaseModel> implements IBaseDao<T> {
	@Resource
	protected HibernateTemplate hibernateTemplate;

	public IBaseDao<T> genericDao;
	
	Class<T> entity;

	String entityName;

	public BaseDao() {
		this.entity = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.entityName = entity.getName();
	}

	@Override
	public T save(T t) {
		if(MyString.isEmpty(t.getCreateTime()))
			t.setCreateTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
		hibernateTemplate.save(entityName, t);
		return t;
	}


	@Override
	public void delete(T t) {
		hibernateTemplate.delete(entityName, t);
	}

	@Override
	public T get(String m) {
		return (T) hibernateTemplate.get(entity, m);
	}

	@Override	
	public List<T> findByExample(T t) {
		return hibernateTemplate.findByExample(entityName, t);
	}

	@Override
	public List<T> loadAll(T t) {
		return hibernateTemplate.loadAll(entity);
	}

	@Override	
	public void update(T t) {
		 hibernateTemplate.merge(t);
	}
	
	@Override
	public int update(String hql, Map<String, Object> map) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);  
		Tools.setQuery(map, query);
		return query.executeUpdate();  
	}
	
	@Override
	public List<T> queryByHql(String hql, Map<String, Object> map) {
		return queryByHql(hql, map, null);
	}
	
	@Override
	public List<T> queryByHql(String hql, Map<String, Object> map, Page pageBean) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
//			pageBean.setAllRow(  getCount(map, hql.toUpperCase().indexOf(" WHERE ")>0? hql.substring(  hql.toUpperCase().indexOf(" WHERE")  ) : "")  );
			pageBean.setAllRow(  getNewCount(map, hql.toUpperCase().indexOf("FROM")>=0? hql.substring(hql.toUpperCase().indexOf("FROM")):"")  );
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		
		return query.list();
	}
	
	@Override
	public int getCount(Map<String, Object> map, String conditions) {
		if (conditions.contains("order by")) {
			conditions = conditions.substring(0, conditions.indexOf("order by"));
		}
		String hql = "select count(*) from " + entity.getSimpleName() + conditions;
		
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		Tools.setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}
	@Override
	public int getNewCount(Map<String, Object> map, String conditions) {
		if (conditions.contains("order by")) {
			conditions = conditions.substring(0, conditions.indexOf("order by"));
		}
		
		String hql = "select count(*) " + conditions;
		
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		Tools.setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	/**
	 * @param constructed: 鏋勯�犲嚱鏁� 濡� new A(aa,bb)
	 */
	@Override
	public List<T> findByMap(String construct,Map<String, Object> map,
			Page pageBean, String order) {
		String conditions = Tools.getHql(map);
		String hql = "select " + construct +" from "+entity.getSimpleName() + conditions + (MyString.isEmpty(order) ? " order by sequence desc, createTime desc" : " order by " + order);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(getCount(map, conditions));
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	}
	
	@Override
	public List<T> findByMap(Map<String, Object> map,
			Page pageBean, String order) {
		String conditions = Tools.getHql(map);
		String hql = "from "+entity.getSimpleName() + conditions + (MyString.isEmpty(order) ? " order by sequence desc, createTime desc" : " order by " + order);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(getCount(map, conditions));
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	}
	
	//鏌ヨ瀹℃牳鍒楄〃
	@Override
	public List<?> findByObj(Map<String, Object> map,Object obj,
			Page pageBean, String order,String hqlCondition) {
		String conditions = Tools.getHql(map);
		String hql = "from "+((Class<?>) obj).getSimpleName() + conditions +hqlCondition+ (MyString.isEmpty(order) ? " order by sequence desc, createTime desc" : " order by " + order);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(getCount(map, conditions));
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	}
	
	
	
	@Override
	public HibernateTemplate gethibernateTemplate(){
		return hibernateTemplate;
	}        
	
	@Override
	public Object updateForIssue(final VirtualShowroom virtualShowroom) {
		hibernateTemplate.execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException {
				String sql = "update VirtualShowroom set postStatus = ? where id = ?";
				Query query = session.createQuery(sql);
				/*query.setParameter(0, virtualShowroom.getPostStatus())
					 .setParameter(1,virtualShowroom.getId());*/
				query.executeUpdate();
				return null;
			}
		});
		return null;
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseDao#insert(java.lang.Class)    
	 */
	@Override
	public void insert(Object model) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(model);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseDao#findByHql(java.lang.String, java.util.Map, com.tj720.mip.utils.Page)    
	 */
	@Override
	public List<?> findByHql(String hql, Map<String, Object> map, Page pageBean,String modelName) {

		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(  getModelCount(map,modelName, hql.toUpperCase().indexOf(" WHERE ")>0? hql.substring(  hql.toUpperCase().indexOf(" WHERE")  ) : "")  );
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	
	}
	@Override
	public int getModelCount(Map<String, Object> map, String modelName,String seach) {
		String hql = "select count(*) from " + modelName +  seach;
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		Tools.setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	@Override
	public int deleteByHql(String hql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		return query.executeUpdate();
	}
	@Override
	public List<?> findLimitByHql(String hql,int limit) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(limit);
		return query.list();
	}

	@Override
	public T getByHql(String hql){
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<T> result=query.list();
		if(MyString.isEmpty(result))
			return null;
		else
			return result.get(0);
	}
	@Override
	public Object getDtoByHql(String hql){
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<?> result=query.list();
		if(MyString.isEmpty(result))
			return null;
		else
			return result.get(0);
	}
	@Override
	public List<?> queryDtoByHql(String hql, Map<String, Object> map, Page pageBean){
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(getNewCount(map, hql.toUpperCase().indexOf("FROM")>=0? hql.substring(hql.toUpperCase().indexOf("FROM")):""));
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
			Tools.setPage(query, pageBean);
		}
		Tools.setQuery(map, query);
		return query.list();
	}

	/**
	 * 根据条件查询
	 * @param sql
	 * @return
	 */
	
	@Override
	public void deleteBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql);
		query.executeUpdate();
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseDao#queryByDto(java.lang.String, java.util.Map, com.tj720.mip.utils.Page)    
	 */
	@Override
	public List<?> queryByDto(String hql, Map<String, Object> map, Page pageBean) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(  getDtoCount(map, hql.toUpperCase().indexOf(" WHERE ")>0? hql.substring(  hql.toUpperCase().indexOf(" WHERE")  ) : "")  );
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	}

	/** <pre>getDtoCount(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月24日 下午5:27:32    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月24日 下午5:27:32    
	 * 修改备注： 
	 * @param map
	 * @param object
	 * @return</pre>    
	 */
	private Integer getDtoCount(Map<String, Object> map, String conditions) {
		String hql = "select count(*)  FROM MipOrganization as o, MipArea as c,MuseumInfo as i " + conditions;
		
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		Tools.setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseDao#queryByDto2(java.lang.String, java.util.Map, com.tj720.mip.utils.Page)    
	 */
	@Override
	public List<?> queryByDto2(String hql, Map<String, Object> map, Page pageBean) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(  getDtoCount1(map, hql.toUpperCase().indexOf(" WHERE ")>0? hql.substring(  hql.toUpperCase().indexOf(" WHERE")  ) : "")  );
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	}

	/** <pre>getDtoCount1(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月27日 下午2:34:51    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月27日 下午2:34:51    
	 * 修改备注： 
	 * @param map
	 * @param object
	 * @return</pre>    
	 */
	private Integer getDtoCount1(Map<String, Object> map,  String conditions) {
		String hql = "select count(*)  FROM MipOrganization as o,MuseumInfo as i, MipArea as c " + conditions;
		
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		Tools.setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}
}