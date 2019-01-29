package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipRoleMenuMapper;
import com.tj720.admin.model.MipRoleMenu;
import com.tj720.admin.model.MipRoleMenuExample;
import com.tj720.admin.model.MipRoleMenuExample.Criteria;
import com.tj720.admin.service.MipRoleMenuService;
import com.tj720.mip.model.MenuZtreeNode;

/**
*
* @author:cm
* @date:2018年6月27日10:20:17
*/
@Service("MipRoleMenuService")
public class MipRoleMenuServiceImpl extends BaseServiceImpl<MipRoleMenu> implements MipRoleMenuService {

	@Autowired
	private MipRoleMenuMapper mipRoleMenuMapper;

	@Override
	public BaseDao<MipRoleMenu> getBaseDao() {
		return mipRoleMenuMapper;
	}

	@Override
	public List<MenuZtreeNode> selectMenuByRoleId(String roleId) {
		return mipRoleMenuMapper.selectMenuByRoleId(roleId);
	}

	@Override
	public int deleteByRoleId(String roleId) {
		MipRoleMenuExample example = new MipRoleMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		return mipRoleMenuMapper.deleteByExample(example);
	}

	@Override
	public int insertByBatch(List<MipRoleMenu> list) {
		return mipRoleMenuMapper.insertByBatch(list);
	}

	
}
