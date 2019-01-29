package com.tj720.mip.framework.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService2<T> {
	
	public void save(T entity);  
	  
    public void update(T entity);  
  
    public void delete(Serializable id);  
  
    public T getById(Serializable id);  
  
    public List<T> getByHQL(String hql, Object... params);  

}
