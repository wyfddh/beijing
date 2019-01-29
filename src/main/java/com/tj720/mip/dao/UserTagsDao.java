package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IUserTagsDao;
import com.tj720.mip.model.UserTags;

@Repository("userTagsDao")
public class UserTagsDao extends BaseDao<UserTags>
		implements IUserTagsDao {

}