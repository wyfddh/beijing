package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipUserMapper;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationExample;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserExample;
import com.tj720.admin.service.IMipUserService;
import com.tj720.mip.framework.auth.AuthPassport;
@Service("mipUserServiceImpl")
public class MipUserServiceImpl extends BaseServiceImpl<MipUser> implements IMipUserService{
	
	@Autowired
	MipUserMapper mipUserMapper;
	
	@Override
	public BaseDao<MipUser> getBaseDao() {
		return mipUserMapper;
	}
	
	public MipUser getUser(String id){
		MipUser mip = new MipUser();
		mip = mipUserMapper.selectByPrimaryKey(id);
		return mip;
	}

	@Override
	public List<MipUser> getUserList(MipUserExample example) {
		List<MipUser> list = new ArrayList<MipUser>();
		list = mipUserMapper.selectByExample(example);
		return list;
	}

	@Override
	public int updateStatus(MipUser mipUser) {
		int a = mipUserMapper.updateByPrimaryKeySelective(mipUser);
		return a ;
	}

	@Override
	public int allPage(MipUserExample mipUser) {
		int a= 0;
		a=mipUserMapper.countByExample(mipUser);
		return a;
	}




}
