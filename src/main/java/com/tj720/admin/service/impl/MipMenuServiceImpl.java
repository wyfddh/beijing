package com.tj720.admin.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.common.vo.ConditionVo;
import com.tj720.admin.dao.map.MipMenuMapper;
import com.tj720.admin.model.MipMenu;
import com.tj720.admin.model.MipMenuExample;
import com.tj720.admin.model.MipMenuExample.Criteria;
import com.tj720.admin.service.MipMenuService;
import com.tj720.mip.model.MenuNode;
import com.tj720.mip.model.MenuZtreeNode;

/**
*
* @author:cm
* @date:2018年6月27日10:20:17
*/
@Service("MipMenuService")
public class MipMenuServiceImpl extends BaseServiceImpl<MipMenu> implements MipMenuService {

	@Autowired
	private MipMenuMapper mipMenuMapper;

	@Override
	public BaseDao<MipMenu> getBaseDao() {
		return mipMenuMapper;
	}

	@Override
	public List<MenuNode> getAllMenuNodeList() {
		List<MenuNode> menuList = new ArrayList<>();
		
		//查询所有菜单
		MipMenuExample example = new MipMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte) 1);
		criteria.andParentidEqualTo("0");
		example.setOrderByClause("sequence");
		//查询第一级菜单
		List<MipMenu> menuList1 = mipMenuMapper.selectByExample(example);
		for (MipMenu mipMenu : menuList1) {
			MenuNode menuNode = new MenuNode();
			try {
				BeanUtils.copyProperties(menuNode, mipMenu);
				menuNode.setName(mipMenu.getMenuname());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<MenuNode> chileList = this.getAllMenuNodeListByPid(mipMenu.getId());
			menuNode.setChildren(chileList);
			menuList.add(menuNode);
		}
		return menuList;
	}
	
	/**
	 * 根据父id返回下级菜单列表
	 * @param parentId
	 * @return
	 */
	private List<MenuNode> getAllMenuNodeListByPid(String parentId){
		List<MenuNode> chileMenuList = new ArrayList<>();
		MipMenuExample example = new MipMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte) 1);
		criteria.andParentidEqualTo(parentId);
		example.setOrderByClause("sequence");
		List<MipMenu> menuList = mipMenuMapper.selectByExample(example);
		if(menuList != null && menuList.size() > 0) {
			for (MipMenu mipMenu : menuList) {
				MenuNode menuNode = new MenuNode();
				try {
					BeanUtils.copyProperties(menuNode, mipMenu);
					menuNode.setName(mipMenu.getMenuname());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<MenuNode> childList = getAllMenuNodeListByPid(mipMenu.getId());
				menuNode.setChildren(childList);
				chileMenuList.add(menuNode);
			}
		}
		return chileMenuList;
	}

	@Override
	public void updateBySelect(MipMenu mipMenu) {
		MipMenuExample example = new MipMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(mipMenu.getId());
		mipMenuMapper.updateByExampleSelective(mipMenu, example);
	}

	@Override
	public List<MipMenu> getMenuListByParentId(String parentId) {
		MipMenuExample example = new MipMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentId);
		criteria.andStatusEqualTo((byte) 1);
		return mipMenuMapper.selectByExample(example);
	}

	@Override
	public List<MenuZtreeNode> getAllMenuZtreeList(String type) {
		List<MenuZtreeNode> list = new ArrayList<>();
		MipMenuExample example = new MipMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte) 1);
		if(!StringUtil.isBlank(type)) {
			if("1".equals(type)) {
				criteria.andTypeEqualTo(type);
			}
		}
		example.setOrderByClause("sequence");
		List<MipMenu> allMenu = mipMenuMapper.selectByExample(example);
		for (MipMenu mipMenu : allMenu) {
			MenuZtreeNode node = new MenuZtreeNode();
			node.setId(mipMenu.getId());
			node.setName(mipMenu.getMenuname());
			node.setOpen(true);
			node.setpId(mipMenu.getParentid());
			node.setSequence(mipMenu.getSequence());
			node.setType(mipMenu.getType());
			list.add(node);
		}
		return list;
	}

	@Override
	public List<MipMenu> getMenuListByRoleIds(String[] roleIds) {
		
		List<MipMenu>roleHasMenus = mipMenuMapper.selectMenusByRoleIds(roleIds);
		return roleHasMenus;
	}

	@Override
	public boolean checkOnlyName(String roleids, String parentid, String id) {
		MipMenuExample example = new MipMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidsEqualTo(roleids);
		criteria.andParentidEqualTo(parentid);
		criteria.andStatusEqualTo((byte) 1);
		if(!StringUtils.isBlank(id)) {
			criteria.andIdNotEqualTo(id);
		}
		List<MipMenu> selectByExample = mipMenuMapper.selectByExample(example);
		if(selectByExample != null && selectByExample.size() > 0) {
			return false;
		}else {
			return true;
		}
	}
}
