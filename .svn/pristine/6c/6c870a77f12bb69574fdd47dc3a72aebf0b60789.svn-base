package com.tj720.admin.base.service;

import com.tj720.admin.base.dao.BaseDao;

/**
*
* @author:zwp
* @date:2017年6月20日 下午3:58:15
*/
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	/** 
     * 由业务类实现 
     * @return 
     */  
    public abstract BaseDao<T> getBaseDao();  
      
	@Override
	public T get(String id) {
		return getBaseDao().selectByPrimaryKey(id);
	}

	@Override
	public int create(T model) {
		return getBaseDao().insert(model);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return getBaseDao().deleteByPrimaryKey(id);
	}

}
