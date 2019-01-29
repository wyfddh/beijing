package com.tj720.mip.framework.base;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.enumeration.LogType;
import com.tj720.mip.inter.dao.ILogDao;
import com.tj720.mip.model.Log;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONObject;

public class BaseService<T extends BaseModel> implements IBaseService<T> {
	protected IBaseDao<T> dao;
	@Autowired
	private ILogDao logDao;
	
	
	public void setDao(IBaseDao<T> dao) {
		this.dao = dao;
	}
	
	/**
	 * 保存对象
	 * */
	@Override
	@Transactional
	public T save(T model){
		if (MyString.isEmpty(model.getId())) {
			model.setId(null);
		}
		T tmp=dao.save(model);
		if(model.getId()=="0"){
			String modelPath=model.getClass().toString();
			String hql = "select max(id) from "+modelPath.substring(modelPath.lastIndexOf('.')+1);
			List<String> lst = new ArrayList<String>();
			lst = (List<String>) dao.gethibernateTemplate().find(hql);
			Integer num= Integer.parseInt(lst.get(0));
			if(num>0)
				model=dao.get(num.toString());
		}
		return model;
	}
	
	@Override
	@Transactional
	public void update(T model) {
		dao.update(model);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T model, String modelName, String remark) {
		T oldModel = dao.get(model.getId());
		if(MyString.isEmpty(remark))
			remark = "修改："+oldModel.getLogRemark();
		Log log = new Log(modelName, remark, LogType.UPDATE.name(), JSONObject.fromObject(oldModel).toString(),
				model.getClass().getSimpleName(), model.getId());
		logDao.save(log);
		dao.update(model);
	}
	
	
	
	@Override
	@Transactional
	public void update(String hql, Map<String, Object> map) {
		dao.update(hql, map);
	}
	

	/**
	 * 删除前，先将对象数据存入log对象
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T model, String modelName, String remark){
		model = get(model.getId());
		if(MyString.isEmpty(remark))
			remark = "删除："+model.getLogRemark();
		Log log = new Log(modelName, remark, LogType.DELTET.name(), JSONObject.fromObject(model).toString(),
				model.getClass().getSimpleName(), model.getId());
		logDao.save(log);
		dao.delete(model);
	}
	
	@Override
	@Transactional
	public void delete(T model){
		dao.delete(model);
	}


	/**
	 * 根据主键获取对象
	 * */
	@Override
	@Transactional
	public T get(String id){
		return dao.get(id);
	}

	/**
	 * 根据示例对象获取对象列表
	 * */
	@Override
	@Transactional
	public List<T> findByExample(T model){
		return dao.findByExample(model);
	}

	/**
	 * 根据示例对象获取对象列表
	 * */
	@Override
	@Transactional
	public List<T> loadAll(T model){
		return dao.loadAll(model);
	}

	@Override
	@Transactional
	public List<T> findByMap(Map<String, Object> map,
			Page page, String order) {
//		return dao.findByMap(page, map, order);
		return dao.findByMap(map, page, order);
	}
	
	@Override
	@Transactional
	public List<T> findByMap(Map<String, Object> map, String construct,
			Page page, String order) {
		return dao.findByMap(construct, map, page, order);
	}
	
	@Override
	@Transactional
	public int getCount(Map<String, Object> map) {
		String conditions = Tools.getHql(map);
		return dao.getCount(map,conditions);
	}
	
	
	@Override
	@Transactional
	public List<T> queryByHql(String hql, Map<String, Object> map){
		return  queryByHql(hql, map, null);
	}
	
	@Override
	@Transactional
	public List<T> queryByHql(String hql, Map<String, Object> map, Page page){
		return  dao.queryByHql(hql, map, page);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseService#updateForIssue(java.lang.Integer)    
	 */
	@Override
	public void updateForIssue(VirtualShowroom virtualShowroom) {
		dao.updateForIssue(virtualShowroom);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseService#insert(java.lang.Class)    
	 */
	@Override
	@Transactional
	public void insert(Object model) {
		dao.insert(model);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.framework.base.IBaseService#findByObj(java.util.Map, java.lang.Object, com.tj720.mip.utils.Page, java.lang.String)    
	 */
	@Override
	@Transactional
	public List<?> findByObj(Map<String, Object> map, Object obj, Page pageBean, String order,String hqlCondition) {
		return  dao.findByObj(map, obj, pageBean, order,hqlCondition);
	}
	
	@Override
	@Transactional
	public List<?> findByHql(String hql, String modelName ,Map<String, Object> map, Page page){
		return  dao.findByHql(hql, map, page,modelName);
	}

	
	@Override
	@Transactional
	public List<?> queryLimitByHql(String hql,int limit) {
		return dao.findLimitByHql(hql,limit);
	}
	@Override
	@Transactional
	public List<?> queryLimitByHql(String hql) {
		return dao.findLimitByHql(hql,50);
	}
	/**
	 * 根据条件取单条对象
	 * */
	@Override
	@Transactional
	public T getByHql(String hql){
		return dao.getByHql(hql);
	}
	/**
	 * 根据条件取单条对象
	 * */
	@Override
	@Transactional
	public Object getDtoByHql(String hql){
		return dao.getDtoByHql(hql);
	}
	@Override
	@Transactional
	public List<?> queryDtoByHql(String hql, Map<String, Object> map, Page pageBean){
		return dao.queryDtoByHql(hql, map, pageBean);
	}
	
	/**
	 * 根据条件删除对象
	 * */
	@Override
	@Transactional
	public int deleteByHql(String hql){
		return dao.deleteByHql(hql);
	}
	/**
	 * 根据条件删除对象
	 * */
	@Override
	@Transactional
	public void deleteBySql(String sql){
		dao.deleteBySql(sql);
	}
}
