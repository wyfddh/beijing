package com.tj720.mip.controller.authority;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.MipRoleMenu;
import com.tj720.admin.service.MipRoleMenuService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.model.Role;
import com.tj720.mip.utils.MyString;

@Controller
@RequestMapping("/roleMenu")
public class RoleMenuController extends BaseController<Role> {

	@Autowired
	private MipRoleMenuService mipRoleMenuService;

	
	//权限配置
	@RequestMapping("/authorityEdit.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult authorityEdit(String roleid, String menus) throws MyException {
		JsonResult result = null;
		try {
			if (!MyString.isEmpty(roleid)) {
				//先清空权限
				mipRoleMenuService.deleteByRoleId(roleid);
				
				//批量插入
				String[] menuList = menus.split(",");
				List<MipRoleMenu> RoleMenuList = new ArrayList<>();
				if(menuList != null && menuList.length > 0) {
					for (String menuId : menuList) {
						if(!StringUtil.isBlank(menuId)) {
							MipRoleMenu roleMenu = new MipRoleMenu();
							roleMenu.setId(IdUtils.nextId(roleMenu));
							roleMenu.setRoleid(roleid);
							roleMenu.setMenuid(menuId);
							RoleMenuList.add(roleMenu);
						}
					}
					if(RoleMenuList != null && RoleMenuList.size() > 0) {
						int insertByBatch = mipRoleMenuService.insertByBatch(RoleMenuList);
					}
				}
				result = new JsonResult(1, "保存成功");
			}else {
				result = new JsonResult(0, "当前用户异常，请重新登陆");		
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(0, "系统异常，请稍后重试");
		}
		return result;
	}


}
