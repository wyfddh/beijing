package com.tj720.mip.controller.authority;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.service.MipMenuService;
import com.tj720.admin.service.MipRoleMenuService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.MenuZtreeNode;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IUserRoleService urService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private Config config;
	@Autowired
	private MipMenuService mipMenuService;
	@Autowired
	private MipRoleMenuService mipRoleMenuService;

	//去角色新增页面
	@RequestMapping("/goAdd.do")
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goAdd() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/authority/roleAdd.jsp");
		return modelAndView;
	}

	//去角色修改页面
	@RequestMapping("/goEdit.do")
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goEdit(String id) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/authority/roleEdit.jsp");
		Role role = roleService.get(id);
		modelAndView.addObject("role", role);
		return modelAndView;
	}

	//去权限配置修改页面
	@RequestMapping("/goEditAuthor.do")
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goEditAuthor(String id) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/authority/roleAuthorEdit.jsp");
		List<MenuZtreeNode> allMenuZtreeList = mipRoleMenuService.selectMenuByRoleId(id);
		modelAndView.addObject("menuZtreeList", JSONObject.toJSON(allMenuZtreeList));
		modelAndView.addObject("roleid", id);
		return modelAndView;
	}
	
	//新增角色
	@RequestMapping("/roleAdd.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult roleAdd(String roleName, String remark, String orgType) throws MyException {
		JsonResult result = null;
		try {
			//查询当前人信息
			LoginInfoDto userDto = Tools.getUser();
			User us = userService.get(userDto.getId());
			if (!MyString.isEmpty(us)) {
				Role role = new Role();
				role.setRoleName(roleName);
				role.setSequence(0);
				role.setStatus((byte) 1);
				role.setParentId("0");
				role.setIsdelete(0);
				role.setCreatorId(us.getId());
				role.setRemark(remark);
				role.setUpdaterId(us.getId());
				role.setOrgType(orgType);
				roleService.insert(role);
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

	//修改角色
	@RequestMapping("/roleEdit.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult roleEdit(String id, String roleName, String remark, String orgType) throws MyException {
		JsonResult result = null;
		try {
			//查询当前人信息
			LoginInfoDto userDto = Tools.getUser();
			User us = userService.get(userDto.getId());
			if (!MyString.isEmpty(us)) {
				Role role = roleService.get(id);
				role.setRoleName(roleName);
				role.setRemark(remark);
				role.setOrgType(orgType);
				role.setUpdaterId(us.getId());
				roleService.update(role);
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
	
	//去角色列表页面
	@RequestMapping("/info.do")
	@ControllerAop(url="role/info.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList() {
		return "/WEB-INF/back/authority/roleList.jsp";
	}
	
	// 角色管理首页显示角色
	@RequestMapping("/getListInfo.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getListInfo(@RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "10") int size,String roleName) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的级别
		byte level = org.getLevel();
		
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		if(StringUtil.isBlank(roleName)) {
			roleName = "";
		}
		String hql = "from Role where status = 1 and name like '%"+roleName+"%' order by createTime";
		List<Role> roles = (List<Role>) roleService.queryByHql(hql, Tools.getMap(), page);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", roles);
		return jsonObject;
	}
	
	// 删除选中用户的当前角色
	@RequestMapping("/deleteRole.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult deleteRole(String roleId) throws MyException {
		JsonResult result = null;
		try {
			//查询当前人信息
			LoginInfoDto userDto = Tools.getUser();
			User us = userService.get(userDto.getId());
			if (!MyString.isEmpty(us)) {
				String hql = "from UserRole where roleId = '" + roleId + "' and status = '1'";
				List<UserRole> queryByHql = (List<UserRole>) urService.queryByHql(hql, Tools.getMap());
				if(MyString.isEmpty(queryByHql)) {
					String hql1 = "from Role where status = 1 and id = '" + roleId + "'";
					List<Role> roles = (List<Role>) roleService.queryByHql(hql1, Tools.getMap());
					if(!MyString.isEmpty(roles)) {
						roleService.delete(roles.get(0));
						result = new JsonResult(1, "删除成功");
						return result;
					}else {
						result = new JsonResult(0, "权限不存在");		
					}
				}else {
					result = new JsonResult(0, "权限下存在用户，请去掉权限再进行删除");		
				}
			}else {
				result = new JsonResult(0, "当前用户异常，请重新登陆");		
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(0, "系统异常，请稍后重试");
		}
		return result;
	}

	// 人员管理
	// 根据当前登录角色情况，和选中的角色id查出当前角色下所有的管理员
	@SuppressWarnings("unchecked")
	@RequestMapping("/userManage.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView userManage(String areap, String unitp, String keywordp, String roleGrade,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "10") int size) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/roleGover/roleEdit.jsp");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 根据登陆者的orgID判断他的level.level=1是省级2是市级3是博物馆级
		User user = userService.get(Tools.getUser().getId());
		if (!MyString.isEmpty(user.getOrgId())) {
			MipOrganization organization = organizationService.get(user.getOrgId());
			byte level = organization.getLevel();
			modelAndView.addObject("level", level);
			List<String> unitWhere = new ArrayList<String>();
			List<MipOrganization> unit = new ArrayList<MipOrganization>();
			if (!MyString.isEmpty(areap))
				unitWhere.add("parentId=" + areap);
			switch (level) {
			case (byte) 1:
				List<MipOrganization> area = (List<MipOrganization>) mipOrganizationService.queryByHql(
						"FROM MipOrganization WHERE level=2 AND platformId=" + config.getPlatformId(), Tools.getMap());
				modelAndView.addObject("area", area);
				if (!MyString.isEmpty(areap)) {
					MipOrganization mipOrganization = mipOrganizationService.get(areap);
					String path = mipOrganization.getPath();
					unitWhere.add("path like '" + path + "/%'");
					String unitHql = "FROM MipOrganization WHERE open = 1 and level=3 AND platformId=" + config.getPlatformId();
					for (String str : unitWhere) {
						unitHql += " AND " + str;
					}
					unit = (List<MipOrganization>) mipOrganizationService.queryByHql(unitHql, Tools.getMap());
					modelAndView.addObject("unit", unit);
				}
				break;
			case (byte) 2:
				unitWhere.add("path like '" + organization.getPath() + "/%'");
				String unitHql = "FROM MipOrganization WHERE open = 1 level=3 AND platformId=" + config.getPlatformId();
				for (String str : unitWhere) {
					unitHql += " AND " + str;
				}
				unit = (List<MipOrganization>) mipOrganizationService.queryByHql(unitHql, Tools.getMap());
				if (level != 1 || !MyString.isEmpty(unitp))
					modelAndView.addObject("unit", unit);
				break;
			}
			if (!MyString.isEmpty(roleGrade)) {
				String hql = "FROM User WHERE ";
				List<UserRole> userRoles = (List<UserRole>) urService
						.queryByHql("FROM UserRole WHERE roleId=" + roleGrade, Tools.getMap());
				if (MyString.isEmpty(userRoles)) {
					hql += " 1=1";
				}
				String user_ids = "";
				for (UserRole ur : userRoles)
					user_ids += "'" + ur.getUserId() + "',";
				if (user_ids.length() > 0)
					hql += "id in (" + user_ids.substring(0, user_ids.length() - 1) + ")";
				if (!MyString.isEmpty(unitp)) {
					MipOrganization org = organizationService.get(unitp);
					hql += " AND orgId=" + org.getId();
				} else if (level == 1 || level == 2) {
					if (unit.size() > 0) {
						hql += " AND orgId in (";
						for (MipOrganization o : unit) {
							hql += "'"+o.getId() + "',";
						}
						hql = hql.substring(0, hql.length() - 1) + ")";
					}
				}else if(level == 3 ){
					hql += " AND orgId = '" + user.getOrgId()+"'";
				}
				if (!MyString.isEmpty(keywordp)) {
					Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
					if (pattern.matcher(keywordp).matches() == true)
						hql += " AND phone like '%" + keywordp + "%'";
					else
						hql += " AND userName like '%" + keywordp + "%'";
				}
				List<User> userAll = (List<User>) userService.queryByHql(hql, Tools.getMap(), page);
				Role role = roleService.get(roleGrade);
				if (!MyString.isEmpty(role)) {
					modelAndView.addObject("theRoleName", role.getRoleName());
				}
				for (User dto : userAll) {
					dto.setRoleName(role.getRoleName());
					MipOrganization o = mipOrganizationService.get(dto.getOrgId());
					dto.setOrgName(o.getName());
				}
				modelAndView.addObject("userAll", userAll);
			}
		}
		if (MyString.isEmpty(keywordp)) {
			keywordp = "";
		}
		modelAndView.addObject("page", page);
		modelAndView.addObject("unit2", unitp);
		modelAndView.addObject("area2", areap);
		modelAndView.addObject("keyword2", keywordp);
		modelAndView.addObject("roleGrade", roleGrade);
		return modelAndView;
	}

	// 单位
	@SuppressWarnings("unchecked")
	@RequestMapping("/region.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public List<MipOrganization> sltYearType(@RequestParam(name = "pid") String pid) {
		String hql = "from MipOrganization where status > 0 and parentId=" + pid + " and open = 1";
		List<MipOrganization> organization = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,
				Tools.getMap());
		return organization;
	}

	// 删除选中用户的当前角色
	@RequestMapping("/deleteUser.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public String delete(String userId, String roleGrade) throws MyException {
		try {
			String hql = "from UserRole where userId='" + userId + "' and roleId = " + roleGrade;
			List<UserRole> queryByHql = (List<UserRole>) urService.queryByHql(hql, Tools.getMap());
			for (UserRole us : queryByHql) {
				urService.delete(us);
			}
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@RequestMapping("/list.do")
	@ResponseBody
	@AuthPassport(authority = Const.AUTH_ROLE)
	public JsonResult list(@ModelAttribute Role role, @RequestParam(defaultValue = "1") Integer currentPage) {
		Page page = new Page(2);
		page.setCurrentPage(currentPage);
		Map<String, Object> map = Tools.getMap("roleName|like", role.getRoleName());
		List<Role> roles = roleService.findByMap(map, page, null);
		// 遍历角色，查询角色权限并set进角色
		for (Role r : roles) {
			StringBuilder sb = new StringBuilder(",");
			List<Auth> auths = (List<Auth>) roleService
					.findBySql("select a.authName from mip_auth a,mip_role_auth ra,mip_role r "
							+ "where ra.role_id=r.id and ra.auth_id=a.id and r.id='" + r.getId() + "'");
			// r.setAuthName(auths.toString().substring(1,
			// auths.toString().length()-1));
		}
		return new JsonResult(1, roles, page);
	}

}
