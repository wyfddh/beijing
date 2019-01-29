package com.tj720.admin.base.dao;
/**
*
* @author:zwp
* @date:2017年6月20日 下午2:10:31
*/
public interface BaseDao<T> {
	T selectByPrimaryKey(String id);  
    int insert(T model);  
    int deleteByPrimaryKey(String id);
    int updateByPrimaryKey(T model);
}
