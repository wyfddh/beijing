package com.tj720.mip.framework.base;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

@Transactional  
public class BaseService2Impl<T> implements BaseService2<T> {

	/** 
     * 注入BaseDao 
     */  
    private BaseDao2<T> dao;  
    @Resource  
    public void setDao(BaseDao2<T> dao) {  
        this.dao = dao;  
    }  
  
    public void save(T entity) {  
        dao.save(entity);  
    }  
  
    public void update(T entity) {  
        dao.update(entity);  
    }  
  
    public void delete(Serializable id) {  
        dao.delete(id);  
    }  
  
    public T getById(Serializable id) {  
        return dao.findById(id);  
    }  
  
    public List<T> getByHQL(String hql, Object... params) {  
        return dao.findByHQL(hql, params);  
    }  
}
