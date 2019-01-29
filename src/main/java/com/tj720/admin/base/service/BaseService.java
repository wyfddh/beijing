package com.tj720.admin.base.service;

public interface BaseService<T> {
   
    /** 
     * 根据id,查询单个 
     * @param id 
     * @return 
     */  
    T get(String id); 
      
    /** 
     * 插入单个对象 
     * @param model 
     * @return 
     */  
    int create(T model);
	
    /**
     * 根据id删除单个对象
     * @param id
     * @return
     */
	int deleteByPrimaryKey(String id);
}