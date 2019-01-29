package com.tj720.mip.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IAuthService;
import com.tj720.mip.inter.service.table.IRoleAuthService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.RoleAuth;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
public class HasAuthController extends BaseController<MipOpenCulturalrelicInfo> {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IRoleAuthService roleAuthService;
	@Autowired
	private IAuthService authService;
	
	//判断是否可以编辑
	@RequestMapping("/hasEdit.do")
	@ResponseBody
	public boolean hasEdit(String userId) {
		String authStr = getAuth(userId);
		if (!MyString.isEmpty(authStr)) {
			String[] auths = authStr.split(",");
			for (String auth : auths) {
				if ("collectionAdmin".equals(auth)) {
					return true;
				} 
				if ("contentAdmin".equals(auth)) {
					return true;
				} 
				if ("SystemAdmin".equals(auth)) {
					return true;
				} 
			}
		} 
		return false;
	}
	
	
	//获取用户权限
	public String getAuth(String userId){
		String authStr = "";
		String roleIds = "";
		String authIds = "";
		List<UserRole> userRoleList = (List<UserRole>) userRoleService.queryByHql("from UserRole where userId="+userId, Tools.getMap());
		if (!MyString.isEmpty(userRoleList)) {
			for (UserRole userRole : userRoleList) {
				roleIds += userRole.getRoleId()+",";
			}
			roleIds = roleIds.substring(0, roleIds.length()-1);
			//通过role的ids查询auth的ids
			List<RoleAuth> roleAuthList = (List<RoleAuth>) roleService.queryByHql("from RoleAuth where roleId in ("+ roleIds +")", Tools.getMap());
			if (!MyString.isEmpty(roleAuthList)) {
				//遍历集合，获取权限ids
				for (RoleAuth roleAuth : roleAuthList) {
					authIds += roleAuth.getAuthId()+",";
				}
				authIds = authIds.substring(0, authIds.length()-1);
				//获取权限集合
				List<Auth> authList = (List<Auth>) authService.queryByHql("from Auth where id in ("+ authIds +")", Tools.getMap());
				if (!MyString.isEmpty(authIds)) {
					StringBuilder sb = new StringBuilder(",");
					for (Auth auth : authList) {
						sb.append(auth.getAuthName()+",");
					}
					authStr = sb.toString();
				}
			}
		}
		return authStr;
	}

}
