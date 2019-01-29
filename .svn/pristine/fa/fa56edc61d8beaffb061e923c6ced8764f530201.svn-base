package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipRoleMenu;
import com.tj720.mip.model.MenuZtreeNode;


/**
 * 
 * @author:cm
 * @date:2018年6月27日10:20:17
 */
public interface MipRoleMenuService extends BaseService<MipRoleMenu>{
	
	/**
	 * 根据role获取菜单权限
	 * @return
	 */
	public List<MenuZtreeNode> selectMenuByRoleId(String roleId);
	
	/**
	 * 根据权限删除数据
	 * @param roleId
	 */
	public int deleteByRoleId(String roleId);
	
	/**
	 * 批量保存
	 * @param roleId
	 */
	public int insertByBatch(List<MipRoleMenu> list);
	
}
	
