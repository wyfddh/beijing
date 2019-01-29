package com.tj720.mip.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tj720.mip.enumeration.UserType;
import com.tj720.mip.inter.service.table.IAuthService;
import com.tj720.mip.inter.service.table.IProjectService;
import com.tj720.mip.inter.service.table.IProjectUserService;
import com.tj720.mip.inter.service.table.IRoleAuthService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.Project;
import com.tj720.mip.model.ProjectUser;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.RoleAuth;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.service.table.UserRoleService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

public class LoginInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String userName;
	private String trueName;
	private String authStr;//权限，由用户权限、角色拼接而成
	private String roleId; 
	private String id;
	private byte type;
	private String email;
	private String nickName;
	private Map<String, ProjectUser> projects = new HashMap<String, ProjectUser>();
	
	public LoginInfoDto(User user, IRoleService roleService, IProjectService projectService, IProjectUserService projectUserService){
		this.userName = user.getUserName();
//		this.trueName = user.getTrueName();
//		this.roleId = user.getRoleId();
		this.id = user.getId();
//		this.type = user.getType();
//		this.email = user.getEmail();
		
		StringBuilder sb = new StringBuilder(",");
		// 将用户的自己的模块添加至权限中
		List<Project> myProjects = projectService.findByMap(Tools.getMap("userId", user.getId()), null, null);
		for(Project project:myProjects){
			sb.append(Const.AUTH_PROJECT + project.getId()+",");
		}
		
		// 管理员，将最高管理员，管理员
		/*if( (user.getType() + "").equals(UserType.ADMIN.getType() +"") ){
			sb.append(user.getAuth()+",");
			sb.append("ADMIN,");
			if(user.getRoleId().indexOf("super") >= 0)
				sb.append("super,");
			if (user.getRoleId() != null && !user.getRoleId().equals("")) {
				List<Role> roles = roleService.findByMap(
						Tools.getMap("id|in", Tools.getIdsFromField(user.getRoleId())), null, null);
				// 将角色中的权限添加至用户权限中
				for (Role role : roles) {
					sb.append(role.getAuth()+",");
				}
			}
		}*/
		this.authStr = sb.toString();
	}
	
	public LoginInfoDto(User user, IUserRoleService userRoleService, IRoleService roleService, IRoleAuthService roleAuthService, IAuthService authService, IProjectService projectService, IProjectUserService projectUserService){
		this.userName = user.getUserName();
//		this.trueName = user.getTrueName();
//		this.roleId = user.getRoleId();
		this.id = user.getId();
//		this.type = user.getType();
//		this.email = user.getEmail();
		this.nickName = user.getNickName();
		
//		StringBuilder sb = new StringBuilder(",");
		//通过user的id查询其角色ids
		String roleIds = "";
		String authIds = "";
		List<UserRole> userRoleList = (List<UserRole>) userRoleService.queryByHql("from UserRole where userId='"+user.getId()+"'", Tools.getMap());
		if (!MyString.isEmpty(userRoleList)) {
			for (UserRole userRole : userRoleList) {
				roleIds += "'" + userRole.getRoleId()+"',";
			}
			roleIds = roleIds.substring(0, roleIds.length()-1);
			//通过role的ids查询auth的ids
			List<RoleAuth> roleAuthList = (List<RoleAuth>) roleService.queryByHql("from RoleAuth where roleId in ("+ roleIds +")", Tools.getMap());
			if (!MyString.isEmpty(roleAuthList)) {
				//遍历集合，获取权限ids
				for (RoleAuth roleAuth : roleAuthList) {
					authIds += "'" + roleAuth.getAuthId()+"',";
				}
				authIds = authIds.substring(0, authIds.length()-1);
				//获取权限集合
				List<Auth> authList = (List<Auth>) authService.queryByHql("from Auth where id in ("+ authIds +")", Tools.getMap());
				if (!MyString.isEmpty(authIds)) {
					StringBuilder sb = new StringBuilder(",");
					for (Auth auth : authList) {
						sb.append(auth.getAuthName()+",");
					}
					this.authStr = sb.toString();
				}
			}
		}
		
		
		// 将用户的自己的模块添加至权限中
		/*List<Project> myProjects = projectService.findByMap(Tools.getMap("userId", user.getId()), null, null);
		for(Project project:myProjects){
			sb.append(Const.AUTH_PROJECT + project.getId()+",");
		}*/
		
		// 管理员，将最高管理员，管理员
		/*if( (user.getType() + "").equals(UserType.ADMIN.getType() +"") ){
			sb.append(user.getAuth()+",");
			sb.append("ADMIN,");
			if(user.getRoleId().indexOf("super") >= 0)
				sb.append("super,");
			if (user.getRoleId() != null && !user.getRoleId().equals("")) {
				List<Role> roles = roleService.findByMap(
						Tools.getMap("id|in", Tools.getIdsFromField(user.getRoleId())), null, null);
				// 将角色中的权限添加至用户权限中
				for (Role role : roles) {
					sb.append(role.getAuth()+",");
				}
			}
		}*/
		
		
		// 项目成员
		/*for(ProjectUser p: projectUserService.findByMap(Tools.getMap("userId", user.getId()), null, null)){
			projects.put(p.getProjectId(), p);
			sb.append(Const.AUTH_PROJECT + p.getProjectId()+",");
		}*/
		
	}

	public String getUserName() {
		return userName;
	}

	public String getTrueName() {
		return trueName;
	}

	public String getAuthStr() {
		if(authStr == null)
			return "";
		return authStr;
	}

	public String getRoleId() {
		return roleId;
	}
	
	public String getId(){
		return id;
	}
	
	public byte getType(){
		return type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, ProjectUser> getProjects() {
		return projects;
	}

	public void setProjects(Map<String, ProjectUser> projects) {
		this.projects = projects;
	}

}
