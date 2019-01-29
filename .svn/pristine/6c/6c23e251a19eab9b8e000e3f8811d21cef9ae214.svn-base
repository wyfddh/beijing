package com.tj720.mip.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.service.MipLogService;
import com.tj720.mip.dto.AdminSearchListDto;
import com.tj720.mip.dto.UserQueryDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserRoleService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MD5;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/admin")
public class UserController extends BaseController<User> {

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private Config config;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IUserRoleService urService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MipLogService mipLogService;
	
	// 获取普通用户或管理员的列表
	@RequestMapping("/user/list.do")
	// @AuthPassport(authority=Const.AUTH_USER)
	public String list(@ModelAttribute UserQueryDto uqd, @RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size, Model model, HttpSession session) throws ParseException {
		// Page page= new Page(15);
		// page.setCurrentPage(currentPage);
		// Map<String,Object> map =
		// Tools.getMap("trueName|like",user.getTrueName());
		// return new JsonResult(1,userService.findByMap(map,page,null),page);

		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		String startCreateTime = uqd.getStartCreateTime();
		String endCreateTime = uqd.getEndCreateTime();
		String startLoginTime = uqd.getStartLoginTime();
		String endLoginTime = uqd.getEndLoginTime();

		// 通过session取出登录者信息
		// User u=(User) session.getAttribute("user");
		// String uid=u.getId();
		User u = new User();
		u.setId("1");
		// u.setDeptId("1");
		String uid = u.getId();
		// 通过用户ID查出角色
		String sql1 = "SELECT ur.role_id FROM mip_user u,mip_user_role ur WHERE u.id=ur.user_id and u.id='" + uid + "'";
		String roleId = userService.getBySql(sql1);
		session.setAttribute("roleId", roleId);

		String hql = "";
		if (roleId.equals("1")) {
			// 如果角色id等于1，属于省级超级管理员
			hql = "SELECT u.* FROM mip_user  u ,mip_organization  o WHERE u.dept_id=o.id and u.dept_id!='' ";
		} else if (roleId.equals("2")) {
			// 如果角色id等于2，属于地级超管
			// 通过部门id查出管理员
			// hql="select u.* from mip_user u,mip_organization o where
			// u.dept_id=o.id and o.parent_id='"+u.getDeptId()+"' and
			// u.dept_id!=''";
		} else if (roleId.equals("3")) {
			// 如果角色id等于3，属于博物馆超级管理员
			// hql="select u.* from mip_user u , mip_organization o where
			// u.dept_id = o.id and u.dept_id='"+u.getDeptId()+"'";
		}

		if (uqd.getDeptName() != null && !"".equals(uqd.getDeptName())) {
			hql += (" and o.name like'%" + uqd.getDeptName() + "%'");
		}
		if (uqd.getTrueName() != null && !"".equals(uqd.getTrueName())) {
			hql += " and u.trueName like '%" + uqd.getTrueName() + "%'";
		}
		if (uqd.getPhone() != null && !"".equals(uqd.getPhone())) {
			hql += " and u.phone like '%" + uqd.getPhone() + "%'";
		}
		if (startCreateTime != null && !"".equals(startCreateTime)) {
			if (endCreateTime != null && !"".equals(endCreateTime)) {
				hql += " and u.createTime between '" + startCreateTime + "'" + "and '" + endCreateTime + "'";
			} else {
				hql += " and u.createTime between '" + startCreateTime + "'" + " and now()";
			}
		} else {

			if (endCreateTime != null && !"".equals(endCreateTime)) {
				hql += " and u.createTime between '1970-01-01' and '" + endCreateTime + "'";
			}
		}

		if (startLoginTime != null && !"".equals(startLoginTime)) {
			if (endLoginTime != null && !"".equals(endLoginTime)) {
				hql += " and u.loginTime between '" + startLoginTime + "' and '" + endLoginTime + "'";
			} else {
				hql += " and u.loginTime between '" + startLoginTime + "' and now()";
			}
		} else {

			if (endLoginTime != null && !"".equals(endLoginTime)) {
				hql += " and u.loginTime between '1970-01-01' and '" + endLoginTime + "'";
			}
		}

		List<User> userList = (List<User>) userService.queryListBySql(hql);
		// JsonResult userList = new JsonResult(1,findByMap,page,uqd);
		List<MipOrganization> orgs = (List<MipOrganization>) mipOrganizationService.queryByHql("FROM MipOrganization",
				Tools.getMap());
		model.addAttribute("orgs", orgs);
		model.addAttribute("uqd", uqd);
		model.addAttribute("userList", userList);
		model.addAttribute("page", page);
		return "/WEB-INF/back/user/admin-gover.jsp";
	}
	// 根据登录人角色查出相应的组织
	// @RequestMapping("/user/outoFill.do")
	// public List<MipOrganization> outoFill(String deptName,HttpServletResponse
	// response,HttpSession session ) throws IOException{
	// 通过session取出登录者信息
	// User u=(User) session.getAttribute("user");
	// String uid=u.getId();

	// String roleId=(String) session.getAttribute("roleId");
	// User u=new User();
	// u.setId("1");
	// u.setDeptId("1");
	// String sql="select * from mip_organization where
	// FIND_IN_SET(id,getOrgs('"+u.getDeptId()+"') )and name like
	// '%"+deptName+"%'";

	// List<MipOrganization> list = (List<MipOrganization>)
	// mipOrganizationService.queryBySql(sql);

	// return list;

	// }

	// 编辑页（待写）
	@RequestMapping("/user/detail.do")
	@ResponseBody
	public JsonResult detail(@ModelAttribute User user) {

		if (!user.getId().equals(Const.NULL_ID)) {
			user = userService.get(user.getId());
		} else {
			user = new User();
		}
		user.setPassword("");
		return new JsonResult(1, user);
	}

	/*
	 * //删除管理员（清空组织，清空角色）
	 * 
	 * @RequestMapping("/user/deleteAdmin.do")
	 * 
	 * public void deleteAdmin(String id){
	 * 
	 * String hql="update User set isDelete=0,deptId='' where id='"+id+"'";
	 * userService.update(hql, null); //清空角色 UserRole ur=new UserRole();
	 * ur.setUserId(id); urService.delete(ur); }
	 */
	// 重置密码
	@RequestMapping("/user/resetPwd.do")

	public void resetPwd(String id) {

		String hql = "update User set password='123456' WHERE id='" + id + "'";
		userService.update(hql, null);

	}
	// 查询出所有角色返回到添加管理员页面(角色管理页面首页可用)
	/*
	 * @RequestMapping("/user/goAdd.do") public String goAdd(Model
	 * model,HttpSession session){
	 * 
	 * //session中取出当前登录人信息 // User u=(User)session.getAttribute("user");
	 * //查询出角色列表 User u=new User(); u.setId("1"); // u.setDeptId("1"); String
	 * uid=u.getId(); //通过用户ID查出角色 String
	 * sql="select ur.role_id from mip_user u,mip_user_role ur where u.id=ur.user_id and u.id='"
	 * +uid+"'"; String roleId = userService.getBySql(sql);
	 * session.setAttribute("roleId", roleId); String
	 * sql1="select * from mip_role where FIND_IN_SET(id,getChilds('"
	 * +roleId+"')) and id !='"+roleId+"' "; List<Role> roles =
	 * roleService.queryBySql(sql1); String
	 * sql2="select * from mip_organization where FIND_IN_SET(id,getOrgs('"+u.
	 * getDeptId()+"') )"; List<MipOrganization> orgs = (List<MipOrganization>)
	 * mipOrganizationService.queryBySql(sql2);
	 * 
	 * model.addAttribute("user",u); model.addAttribute("roles",roles);
	 * model.addAttribute("orgs",orgs); return
	 * "/WEB-INF/back/user/add-gover.jsp"; }
	 */

	/*
	 * //添加管理员
	 * 
	 * @RequestMapping("/user/addAdmin.do") public void addAdmin(@ModelAttribute
	 * User user,@RequestParam("roleId") String[]roleIds,HttpSession session){
	 * //String flag = (String) session.getAttribute("flag");
	 * //判断是否已经注册过了，1代表注册过了，0代表没注册 String flag="0"; UserRole ur=new UserRole();
	 * String id="";//用户id if(flag.equals("1")){ //通过账户查询出用户id String
	 * sql="select id from mip_user where userName='"+user.getUserName()+"'"; id
	 * = userService.getBySql(sql); }else if(flag.equals("0")){
	 * user.setUserName(user.getPhone()); User u = userService.save(user);
	 * id=u.getId(); } ur.setUserId(id); for (String roleId : roleIds) {
	 * ur.setRoleId(roleId); urService.insert(ur);
	 * 
	 * } }
	 */
	// 判断手机号是否已经注册
	/*
	 * @RequestMapping("/user/checkPhone.do")
	 * 
	 * @ResponseBody public String checkPhone(String phone,HttpSession session){
	 * String hql=" select u from User u where phone='"+phone+"'"; User user =
	 * userService.findOne(hql); if(user!=null){ session.setAttribute("flag",
	 * 1); if(user.getDeptId()!=null){ return "1"; //管理员 }else{ return
	 * "2";//非管理员 } }else{ session.setAttribute("flag", 0); return "3"; } }
	 */

	// @RequestMapping("/user/addOrUpdate.do")
	// @ResponseBody
	// @AuthPassport(authority=Const.AUTH_USER)
	// public JsonResult addOrUpdate(@ModelAttribute User user) throws
	// MyException{
	// // 判断是否重名
	// List<User> users = userService.findByMap(Tools.getMap("userName",
	// user.getUserName()), null, null);
	// if(users.size()>0 && !users.get(0).getId().equals(user.getId())){
	// throw new MyException("000015");
	// }
	//
	// if(user.getUserName().isEmpty() ||
	// !Tools.checkUserName(user.getUserName())){
	// throw new MyException("000028");
	// }
	//
	//
	//
	// // 如果前端设置了密码，则修改密码，否者使用就密码
	// if(!MyString.isEmpty(user.getPassword())){
	// user.setPassword(MD5.encrytMD5(user.getPassword()));
	// }
	//
	// User temp = null;
	// if(!MyString.isEmpty(user.getId())){
	// temp = userService.get(user.getId());
	// }
	//
	// LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
	//
	// // 如果不是最高管理员，不允许修改权限、角色、类型
	// //by guhao 用户表中不需要权限名
	// if((","+cacheUser.getRoleId()).indexOf(","+Const.SUPER+",") < 0){
	// if(temp != null){
	// user.setAuth(temp.getAuth());
	// // user.setAuthName(temp.getAuthName());
	// user.setRoleId(temp.getRoleId());
	// user.setRoleName(temp.getRoleName());
	// user.setType(temp.getType());
	// if( !MyString.isEmpty(user.getEmail()) && (
	// MyString.isEmpty(temp.getEmail()) ||
	// !user.getEmail().equals(temp.getEmail()) )){
	// user.setStatus(Byte.valueOf(UserStatus.邮箱未验证.getName()));
	// cacheService.setObj(Const.CACHE_USER + user.getId(),
	// new LoginInfoDto(user, roleService, projectService, projectUserService),
	// config.getLoginInforTime());
	// }
	// }else{
	// user.setAuth("");
	// user.setAuthName("");
	// user.setRoleId("");
	// user.setRoleName("");
	// user.setType(Byte.valueOf("1"));// 普通用户
	// }
	//
	// }
	//
	//
	// // 如果temp不为空，表示修改用户信息
	// if(temp != null){
	// // 如果密码为空，则设置为旧密码
	// if(MyString.isEmpty(user.getPassword())){
	// // 如果设置了密码，则修改为普通登陆
	// if(temp.getLoginType() != LoginType.COMMON.getValue()){
	// user.setLoginType(LoginType.COMMON.getValue());
	// }
	// user.setPassword(temp.getPassword());
	// }
	//
	// if(MyString.isEmpty(user.getEmail())){
	// user.setEmail(null);
	// }
	//
	// userService.update(user);
	// }else{
	// user.setEmail(null);
	// user.setStatus(Byte.valueOf("1"));
	// user.setId(null);
	// userService.save(user);
	// }
	// user.setPassword("");
	// return new JsonResult(1,user);
	// }

	@SuppressWarnings("unchecked")
	@RequestMapping("/user/find.do")
	public void find() {
		String hql = "SELECT user FROM User as user,MipOrganization as o WHERE user.deptId=o.id ";
		List<User> users = (List<User>) userService.queryByHql(hql, null, null);
		for (User user2 : users) {

			System.out.println(user2.toString());
		}

	}

	// 单位二级联动
	@SuppressWarnings("unchecked")
	@RequestMapping("/region.do")
	@ResponseBody
	public List<MipOrganization> sltYearType(@RequestParam(name = "pid") String pid) {
		MipOrganization organization = mipOrganizationService.get(pid);
		String hql = "FROM MipOrganization WHERE status > 0 and platformId = '" + config.getPlatformId() + "' and level = 3 and open = 1";
		//判断是省还是市
		if (organization.getLevel() > 1) {
			//查市
			hql += " and parentId = '"+ pid +"'";
		}
		List<MipOrganization> orgs = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,
				Tools.getMap());
		return orgs;
	}

	@RequestMapping("/user/adminList.do")
	@ResponseBody
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ModelAndView list(@ModelAttribute("adminSearchDto") AdminSearchListDto adminSearchDto,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "10") int size) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/adminAccount/admin.jsp");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 查出当前登录者的等级
		User user = userService.get(Tools.getUser().getId());
		if (!MyString.isEmpty(user.getOrgId())) {
			MipOrganization organization = organizationService.get(user.getOrgId());
			byte level = organization.getLevel();
			modelAndView.addObject("level", level);
			List<String> unitWhere = new ArrayList<String>();
			List<MipOrganization> unit = new ArrayList<MipOrganization>();
			List<String> hqlArr = new ArrayList<String>();
			String hqlArea="FROM MipOrganization WHERE orgTypeId='1' AND platformId=" + config.getPlatformId();
			switch (level) {
			case (byte) 2:
				hqlArea+=" AND id="+organization.getId();
			case (byte) 1:
				List<MipOrganization> area = (List<MipOrganization>) mipOrganizationService.queryByHql(hqlArea, Tools.getMap());
				modelAndView.addObject("area", area);
				if (!MyString.isEmpty(adminSearchDto.getArea())) {
					if (!MyString.isEmpty(adminSearchDto.getArea())){
						MipOrganization organization1 = organizationService.get(adminSearchDto.getArea());
						unitWhere.add("path like '" + organization1.getPath()+"/%'");
					}
					unitWhere.add("path like '" + organization.getPath() + "/%'");
					String unitHql = "FROM MipOrganization WHERE status > 0  and orgTypeId='2' AND platformId=" + config.getPlatformId();
					for (String str : unitWhere) {
						unitHql += " AND " + str;
					}
					unit = (List<MipOrganization>) mipOrganizationService.queryByHql(unitHql, Tools.getMap());
					modelAndView.addObject("unit", unit);
				}
				break;
			case (byte) 3:
				hqlArr.add("orgId = " + organization.getId());
				break;
			}
			// 查出符合条件的列表
			if (!MyString.isEmpty(adminSearchDto.getUnit())) {
				MipOrganization org = organizationService.get(adminSearchDto.getUnit());
				hqlArr.add("orgId=" + org.getId());
			}else if (!MyString.isEmpty(adminSearchDto.getArea())) {
				MipOrganization org = organizationService.get(adminSearchDto.getArea());
				hqlArr.add("orgId=" + org.getId());
			} else if (level == 1 || level == 2) {
				StringBuffer s=new StringBuffer();
				if (!MyString.isEmpty(unit)) {
					for (MipOrganization o : unit) {
						s.append(",'").append(o.getId()).append("'");
					}
					s.append(")");
					hqlArr.add(s.toString());
				}
			}
			if (!MyString.isEmpty(adminSearchDto.getCreateTimeS())) {
				hqlArr.add("createtime >= '" + adminSearchDto.getCreateTimeS() + " :00:00:00'");
			}
			if (!MyString.isEmpty(adminSearchDto.getCreateTimeE())) {
				hqlArr.add("createtime <= '" + adminSearchDto.getCreateTimeE() + " :23:59:59'");
			}
			if (!MyString.isEmpty(adminSearchDto.getLastLoginTimeS())) {
				//string转int
				Date date = DateUtil.StringToDate(adminSearchDto.getLastLoginTimeS(), DateStyle.YYYY_MM_DD);
				long time = date.getTime();
				int lastTimeS = (int) (time/1000);
				hqlArr.add("lastLoginTime >= " + lastTimeS);
			}
			if (!MyString.isEmpty(adminSearchDto.getLastLoginTimeE())) {
				Date date = DateUtil.StringToDate(adminSearchDto.getLastLoginTimeE(), DateStyle.YYYY_MM_DD);
				long time = date.getTime();
				int lastTimeE = (int) (time/1000 + 86400);
				hqlArr.add("lastLoginTime < " + lastTimeE);
			}
			if (!MyString.isEmpty(adminSearchDto.getUserName())) {
				hqlArr.add("userName like '%" + adminSearchDto.getUserName().trim() + "%'");
			}
			if (!MyString.isEmpty(adminSearchDto.getPhone())) {
				hqlArr.add("phone like '%" + adminSearchDto.getPhone().trim() + "%'");
			}
			hqlArr.add("orgId >0 ");
			StringBuffer hqlb=new StringBuffer("FROM User WHERE ");
			if (!MyString.isEmpty(hqlArr)) {
				for(String s:hqlArr){
					hqlb.append(s).append(" AND ");
				}
			}
			String hql=hqlb.substring(0, hqlb.length()-5);
			hql += " order by createTime desc";
			List<User> userAll = (List<User>) userService.queryByHql(hql, Tools.getMap(), page);
			for (User dto : userAll) {
				MipOrganization o = mipOrganizationService.get(dto.getOrgId());
				dto.setOrgName(o.getName());
			}
			modelAndView.addObject("userAll", userAll);
		}
		modelAndView.addObject("page", page);
		modelAndView.addObject("dto", adminSearchDto);

		return modelAndView;
	}

	@RequestMapping("/user/getInfolist.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public ModelAndView getInfolist(String adminId) {
		ModelAndView modelAndView;
		// 编辑页面进入
		if (!MyString.isEmpty(adminId)) {
			// 获取修改人的账号信息
			User admin = userService.get(adminId);
			modelAndView = new ModelAndView("/WEB-INF/back/organization/adminAccount/adminEdit.jsp");
			modelAndView.addObject("admin", admin);
			// 获取编辑页面的角色
			String roleHql = "FROM UserRole WHERE userId = '" + adminId + "'";
			List<UserRole> oldUr = (List<UserRole>)urService.queryByHql(roleHql, Tools.getMap());
			modelAndView.addObject("oldUr", oldUr);
			// 查出编辑对象的组织机构
			MipOrganization organ = organizationService.get(admin.getOrgId());
			if(organ.getOrgTypeId()=="1")
				modelAndView.addObject("areaId", organ.getId());
			else{
				modelAndView.addObject("areaId", organ.getParentId());
				modelAndView.addObject("unitId", organ.getId());
			}
		} else
			modelAndView = new ModelAndView("/WEB-INF/back/organization/adminAccount/adminAdd.jsp");
		// 查出当前登录者的等级和等到当前登录者昵称
		User user = userService.get(Tools.getUser().getId());
		MipOrganization organization = organizationService.get(user.getOrgId());
		
		modelAndView.addObject("user", user);
		byte level = organization.getLevel();
		modelAndView.addObject("level", level);
		List<String> unitWhere = new ArrayList<String>();
		List<MipOrganization> unit = new ArrayList<MipOrganization>();
		String hqlArea="FROM MipOrganization WHERE orgTypeId='1' AND platformId=" + config.getPlatformId();
		switch (level) {
		case (byte) 2:
			hqlArea+=" AND id="+organization.getId();
		case (byte) 1:
			List<MipOrganization> area = (List<MipOrganization>) mipOrganizationService.queryByHql(hqlArea, Tools.getMap());
			modelAndView.addObject("area", area);
			if (!MyString.isEmpty(adminId)) {
				unitWhere.add("path like '" + organization.getPath() + "/%'");
				String unitHql = "FROM MipOrganization WHERE orgTypeId='2' AND platformId=" + config.getPlatformId();
				for (String str : unitWhere) {
					unitHql += " AND " + str;
				}
				unit = (List<MipOrganization>) mipOrganizationService.queryByHql(unitHql, Tools.getMap());
				modelAndView.addObject("unit", unit);
			}
			break;
		}
		// 获得角色列表
		String hql = "FROM Role WHERE status=1 order by sequence desc";
		List<Role> role = (List<Role>) roleService.queryByHql(hql, Tools.getMap());
		modelAndView.addObject("role", role);
		return modelAndView;
	}

	// 判断用户是否注册
	@SuppressWarnings("unchecked")
	@RequestMapping("/user/checkAdmin.do")
	@ResponseBody
	public String checkAdmin(String phone) {
		if (!MyString.isEmpty(phone)) {
			phone = phone.replace(" ", "");
		}
		String hql = "FROM User where phone = '" + phone + "'";
		User u = userService.findOne(hql);
		// 如果输入非注册用户，提示：该用户尚未注册，请注册后在添加为管理员。
		if (MyString.isEmpty(u)){
			return "ERROR1";
		}else{
			//如果输入的手机号已经为管理员，提示：该用户已经是管理员，保存按钮置灰~
			String hqlofRole = "FROM UserRole WHERE userId = '"+u.getId()+"'";
			List<UserRole> userRole = (List<UserRole>) urService.queryByHql(hqlofRole, Tools.getMap());
			if(!MyString.isEmpty(userRole)){
				return "ERROR2";
			}
		}
		return "ERROR";
	}

	@RequestMapping("/user/addAdmin.do")
	@ResponseBody
	public String addAdmin(@ModelAttribute("user") User user, String aera, String unit) {
		String hql = "FROM User WHERE phone = '" + user.getPhone() + "'";
		User u = userService.findOne(hql);
		if("".equals(user.getUserName().trim())){
			return "ERROR1";
		}
		if(unit==null||"".equals(unit)){
			return "ERROR2";
		}
		// 判断是否是注册用户
		if (!MyString.isEmpty(u)) {
			// 查出当前登录者的等级
			User loginUser = userService.get(Tools.getUser().getId());
			
			if(!MyString.isEmpty(user.getRoleId())){
				 String[] role = user.getRoleId().split(",");
				    for (int i = 0 ; i <role.length ; i++ ) {
				    	UserRole uRole = new UserRole();
						uRole.setRoleId(role[i]);
						uRole.setStatus(user.getStatus());
						uRole.setUserId(u.getId());
						urService.save(uRole);
				    } 
			}
			
//			UserRole uRole = new UserRole();
//			uRole.setRoleId(user.getRoleId());
//			uRole.setStatus(user.getStatus());
			u.setStatus(user.getStatus());
			u.setUserName(user.getUserName());
			if (MyString.isEmpty(unit)) {
				if (!MyString.isEmpty(aera))
					u.setOrgId(aera);
				else
					u.setOrgId(loginUser.getOrgId());
			} else
				u.setOrgId(unit);
			userService.update(u);
			//记录日志（用户）
			mipLogService.userLog(request, u, "添加管理员");
//			String roleHql = "FROM UserRole WHERE userId = '" + u.getId() + "'";
//			UserRole oldUr = urService.getByHql(roleHql);
//			if (!MyString.isEmpty(oldUr))
//				urService.delete(oldUr);
//			uRole.setUserId(u.getId());
//			urService.save(uRole);
		}
		/*
		 * else{ //如果输入非注册用户，提示：该用户尚未注册，请注册后在添加为管理员。 return "ERROR";
		 * if(MyString.isEmpty(unit)){ if(!MyString.isEmpty(aera))
		 * user.setOrgId(aera); else user.setOrgId(loginUser.getOrgId()); }else
		 * user.setOrgId(unit); userService.save(user);
		 * uRole.setUserId(user.getId()); }
		 */
		return "SUCCESS";
	}

	@RequestMapping("/user/updateAdmin.do")
	public String updateAdmin(@ModelAttribute("user") User user, String aera, String unit) {
		// 查出当前登录者的等级
		User loginUser = userService.get(Tools.getUser().getId());
		String hql = "FROM User WHERE phone = '" + user.getPhone() + "'";
		User u = userService.findOne(hql);
		if(!MyString.isEmpty(u)){
			String roleHql = "FROM UserRole WHERE userId = '" + u.getId() + "'";
			@SuppressWarnings("unchecked")
			List<UserRole> oldUr = (List<UserRole>)urService.queryByHql(roleHql, Tools.getMap());
			if (!MyString.isEmpty(oldUr)){
				for(UserRole o :oldUr ){
					urService.delete(o);
				}
			}
			if(!MyString.isEmpty(user.getRoleId())){
				 String[] role = user.getRoleId().split(",");
				    for (int i = 0 ; i <role.length ; i++ ) {
				    	UserRole uRole = new UserRole();
						uRole.setRoleId(role[i]);
						uRole.setStatus(user.getStatus());
						uRole.setUserId(u.getId());
						urService.save(uRole);
				    } 
			}
		u.setUserName(user.getUserName());
		if (MyString.isEmpty(unit)) {
			if (!MyString.isEmpty(aera))
				u.setOrgId(aera);
			else
				u.setOrgId(loginUser.getOrgId());
		} else
			u.setOrgId(unit);
		userService.update(u);
		}
		return "redirect:/admin/user/adminList.do";
	}

	// 删除管理员（清空组织，清空角色）
	@RequestMapping("/user/deleteAdmin.do")
	@ResponseBody
	public String deleteAdmin(String adminId) {
		try {
			if (!MyString.isEmpty(adminId)) {
				// 清空组织
				User admin = userService.get(adminId);
				admin.setOrgId("");
				userService.update(admin);
				// 清空角色
				String roleHql = "FROM UserRole WHERE userId = '" + adminId + "'";
				List<UserRole> urList = (List<UserRole>) urService.queryByHql(roleHql, Tools.getMap());
				if (!MyString.isEmpty(urList)) {
					for (UserRole userRole : urList) {
						urService.delete(userRole);
					}
				}
			}
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
//	@RequestMapping("/download.do")
//	public String download(String id,HttpServletRequest request,HttpServletResponse response) {
//		
//		User user = userService.get(id);
//		try {
//			userService.down(user,response);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	// 重置管理员密码
	@RequestMapping("/user/updatePassword.do")
	@ResponseBody
	public String updatePassword(String adminId, String password) {
		if (!MyString.isEmpty(adminId)) {
			User admin = userService.get(adminId);
			admin.setPassword(MD5.encrytMD5(password));
			;
			userService.update(admin);
		}
		return "SUCCESS";
	}
	
	@RequestMapping("/user/extCuration.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public ModelAndView getCuration(@ModelAttribute("adminSearchDto") AdminSearchListDto adminSearchDto,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "10") int size) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/adminAccount/admin.jsp");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 查出当前登录者的等级
		User user = userService.get(Tools.getUser().getId());
		if (!MyString.isEmpty(user.getOrgId())) {
			MipOrganization organization = organizationService.get(user.getOrgId());
			byte level = organization.getLevel();
			modelAndView.addObject("level", level);
			List<String> unitWhere = new ArrayList<String>();
			List<MipOrganization> unit = new ArrayList<MipOrganization>();
			List<String> hqlArr = new ArrayList<String>();
			String hqlArea="FROM MipOrganization WHERE orgTypeId='1' AND platformId=" + config.getPlatformId();
			switch (level) {
			case (byte) 2:
				hqlArea+=" AND id="+organization.getId();
			case (byte) 1:
				List<MipOrganization> area = (List<MipOrganization>) mipOrganizationService.queryByHql(hqlArea, Tools.getMap());
				modelAndView.addObject("area", area);
				if (!MyString.isEmpty(adminSearchDto.getArea())){
					MipOrganization organization1 = organizationService.get(user.getOrgId());
					unitWhere.add("path like '" + organization1.getPath()+"/%'");
				}
				unitWhere.add("path like '" + organization.getPath() + "/%'");
				String unitHql = "FROM MipOrganization WHERE orgTypeId='2' AND platformId=" + config.getPlatformId();
				for (String str : unitWhere) {
					unitHql += " AND " + str;
				}
				unit = (List<MipOrganization>) mipOrganizationService.queryByHql(unitHql, Tools.getMap());
				modelAndView.addObject("unit", unit);
				break;
			case (byte) 3:
				hqlArr.add("orgId = " + organization.getId());
				break;
			}
			// 查出符合条件的列表
			if (!MyString.isEmpty(adminSearchDto.getUnit())) {
				MipOrganization org = organizationService.get(adminSearchDto.getUnit());
				hqlArr.add("orgId=" + org.getId());
			}else if (!MyString.isEmpty(adminSearchDto.getArea())) {
				MipOrganization org = organizationService.get(adminSearchDto.getArea());
				hqlArr.add("orgId=" + org.getId());
			} else if (level == 1 || level == 2) {
				StringBuffer s=new StringBuffer("orgId in ('"+ organization.getId()+"'");
				for (MipOrganization o : unit) {
					s.append(",'").append(o.getId()).append("'");
				}
				s.append(")");
				hqlArr.add(s.toString());
			}
			if (!MyString.isEmpty(adminSearchDto.getCreateTimeS())) {
				hqlArr.add("createtime >= '" + adminSearchDto.getCreateTimeS() + "'");
			}
			if (!MyString.isEmpty(adminSearchDto.getCreateTimeE())) {
				hqlArr.add("createtime <= '" + adminSearchDto.getCreateTimeE() + "'");
			}
			if (!MyString.isEmpty(adminSearchDto.getLastLoginTimeS())) {
				hqlArr.add("lastlogintime >= '" + adminSearchDto.getLastLoginTimeS() + "'");
			}
			if (!MyString.isEmpty(adminSearchDto.getLastLoginTimeE())) {
				hqlArr.add("lastlogintime <= '" + adminSearchDto.getLastLoginTimeE() + "'");
			}
			if (!MyString.isEmpty(adminSearchDto.getUserName())) {
				hqlArr.add("userName like '%" + adminSearchDto.getUserName().trim() + "%'");
			}
			if (!MyString.isEmpty(adminSearchDto.getPhone())) {
				hqlArr.add("phone like '%" + adminSearchDto.getPhone().trim() + "%'");
			}
			StringBuffer hqlb=new StringBuffer("FROM User WHERE ");
			for(String s:hqlArr){
				hqlb.append(s).append(" AND ");
			}
			String hql=hqlb.substring(0, hqlb.length()-5);
			List<User> userAll = (List<User>) userService.queryByHql(hql, Tools.getMap(), page);
			for (User dto : userAll) {
				MipOrganization o = mipOrganizationService.get(dto.getOrgId());
				dto.setOrgName(o.getName());
			}
			modelAndView.addObject("userAll", userAll);
		}
		modelAndView.addObject("page", page);
		modelAndView.addObject("dto", adminSearchDto);

		return modelAndView;
	}
	
	/**
	 * 验证手机号是否存在
	 */
	@RequestMapping("/user/isExist.do")
	@ResponseBody
	public String checkPhoneIsExist(String phone){
		try {
			String hql = "from User where phone = '"+ phone +"'";
			List<User> userList = (List<User>) userService.queryByHql(hql, Tools.getMap());
			if (MyString.isEmpty(userList)) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			return "-1";
		}
	} 
	
}
