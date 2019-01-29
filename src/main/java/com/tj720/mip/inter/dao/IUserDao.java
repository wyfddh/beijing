package com.tj720.mip.inter.dao;

import java.util.List;
import java.util.Map;

import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.utils.Page;

public interface IUserDao extends IBaseDao<User>{
	int getCountBySql(String sql);
	String getBySql(String sql);//通过sql查询出id
	List<User> queryListBySql(String sql); //通过sql查询集合
	User findOne(String hql);
	String findMaxByHql(String phoneStart);

}