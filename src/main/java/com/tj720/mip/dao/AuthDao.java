package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IAuthDao;
import com.tj720.mip.model.Auth;


@Repository("authDao")
public class AuthDao extends BaseDao<Auth>
            implements IAuthDao {

}
