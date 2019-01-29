package com.tj720.mip.controller.authority;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipRole;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserRole;
import com.tj720.admin.service.MipRoleService;
import com.tj720.admin.service.MipUserRoleService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.utils.MD5;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;



@Controller
@RequestMapping("/userManagemen")
public class UserManagementController extends BaseController{

	@Autowired
	private IUserService userService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MipRoleService mipRoleService;
	@Autowired
	private MipUserRoleService mipUserRoleService;

	public static String phoneName = "101";//登录phone开头
	public static String org = "15";       //当前系统对应的省文物局id


	@RequestMapping("/list.do")
	@ControllerAop(url="userManagemen/list.do")
	@AuthPassport
	public String List() {

		return "/WEB-INF/back/authority/userManagemenList.jsp";
	}



	@RequestMapping("/dataList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject dataList(String userName,String orgId,String roleId,Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size) {

		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 当前登录者
		User user = userService.get(Tools.getUser().getId());

		JSONObject jsonObject = new JSONObject();
		if (!MyString.isEmpty(user.getOrgId())) {
			MipUserDto mipUserDto = new MipUserDto();
			Map<String,Object> map = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(userName)) {
				if (isEmail(userName)) {
					map.put("email", userName);
					mipUserDto.setEmail(userName);
				} else if (checkPhone(userName) || userName.startsWith(phoneName) || isNum(userName)) {
					map.put("phone", userName);
					mipUserDto.setPhone(userName);
				} else {
					map.put("name", userName);
					mipUserDto.setName(userName);
				}
			}
			if (StringUtils.isNotBlank(orgId)) {
				String replace = orgId.replace(",", "");
				map.put("orgId", replace);
				mipUserDto.setOrgId(replace);
			}
			if (StringUtils.isNotBlank(roleId)) {
				map.put("roleId", roleId);
				mipUserDto.setRoleId(roleId);
			}

			try {

				//如果超级管理员
				if (user.getOrgId().equals("0")) {
					mipUserDto.setParentId("super");
					map.put("parentId", "super");
				} else {
					//分级别显示不同内容
					//根据当前的id查询该机构下级的所有机构
					List<MipOrganization> orgList = organizationService.getList();
					List<MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(user.getOrgId()), true);
					mipUserDto.setOrgList(sonOrg);
					map.put("orgList", sonOrg);
				}

				mipUserDto.setMuseumId(user.getOrgId());
				Integer count = userService.countByMipUserDto(mipUserDto);
				page.setAllRow(count);
				Integer start = page.getStart();
				Integer end = start + page.getSize();

				map.put("start", start);
				map.put("end", end-start);
				map.put("museumId", user.getOrgId());
				//查询分页
				List<MipUserDto> pageList = userService.getListByMap(map);
				String jsonString = JSON.toJSONString(pageList);
				jsonObject.put("code", 0);
				jsonObject.put("msg",""); 
				jsonObject.put("count", count);
				jsonObject.put("data", jsonString);
			} catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("code", 1);
				jsonObject.put("msg","数据异常"); 
				jsonObject.put("count", 0);
				jsonObject.put("data", "");
			}
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg","数据异常"); 
			jsonObject.put("count", 0);
			jsonObject.put("data", "");
		}
		return jsonObject;
	}
	/**
	 * 描述：是否是邮箱.
	 *
	 * @param str 指定的字符串
	 * @return 是否是邮箱:是为true，否则false
	 */
	public static Boolean isEmail(String str) {
		Boolean isEmail = false;
		String expr = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";

		if (str.matches(expr)) {
			isEmail = true;
		}
		return isEmail;
	}
	/**
	 * 判断是否是手机号
	 *
	 * @param phone
	 * @return 是否是手机号:是为true，否则false
	 */
	public static boolean checkPhone(String phone) {
		Pattern pattern = Pattern
				.compile("^(13[0-9]|15[0-9]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$");
		Matcher matcher = pattern.matcher(phone);

		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	//是否是数字
	public static boolean isNum(String str){

		Pattern pattern = Pattern.compile("^-?[0-9]+");
		if(pattern.matcher(str).matches()){
			//数字
			return true;
		} else {
			//非数字
			return false;
		}
	}


	@RequestMapping("/save.do")
	@ResponseBody
	@AuthPassport
	public JsonResult save(String type,String userId,String name,String orgId,String phone,String email,String password,String roleBox,String status) {
		JsonResult result = null;
		Date date = new Date();//获得系统时间.
		MipUser user = null;
		String id = null;
		if (type.equals("1")) {
			user = new MipUser();
			id = IdUtils.nextId(user);
			user.setId(id);
			user.setCreatetime(date);
		} else {
			user = userService.getById(userId);
			id = user.getId();
		}
		if (StringUtils.isNotBlank(password)) {
			String encrytMD5 = MD5.encrytMD5(password);
			user.setPassword(encrytMD5);
		}
		if (StringUtils.isNotBlank(phone)) {
			user.setPhone(phone);
		}

		user.setOrgId(orgId);
		user.setName(name);
		user.setNickName(name);
		user.setEmail(email);

		user.setSequence(50);
		user.setSex((byte) 0);
		user.setProvince(0);
		user.setCity(0);
		user.setCounty(0);
		user.setTags(0);
		user.setLastLoginTime(0);
		user.setLoginType(0);
		user.setIsdelete((byte) 0);
		try {
			if (StringUtils.isBlank(status)) {
				user.setStatus((byte) 0);
			} else {
				user.setStatus((byte) Integer.parseInt(status));
			}
			if (type.equals("1")) {

			}

			String[] split = roleBox.split(",");

			List<MipUserRole> userRoleList = new ArrayList<MipUserRole>();
			for (String spl : split) {
				MipUserRole mipUserRole = new MipUserRole();

				mipUserRole.setId(IdUtils.nextId(mipUserRole));
				mipUserRole.setRoleId(spl);
				mipUserRole.setUserId(id);
				mipUserRole.setStatus((byte) 1);
				mipUserRole.setSequence(50);
				mipUserRole.setCreatetime(date);
				userRoleList.add(mipUserRole);
			}
			//type等于1是新增，2是修改
			if (type.equals("1")) {
				userService.saveEntity(user);
				mipUserRoleService.batchInsert(userRoleList);
			} else {
				userService.updateByMipUser(user);
				mipUserRoleService.deleteByUserId(userId, orgId);
				mipUserRoleService.batchInsert(userRoleList);
			}
			result = new JsonResult(1);
		} catch (Exception e1) {
			e1.printStackTrace();
			result = new JsonResult(2);
		}

		return result;
	}

	@RequestMapping("/toAdd.do")
	@AuthPassport
	public String toAdd(Model model) {
		// 当前登录者
		User user = userService.get(Tools.getUser().getId());
		if (user != null) {
			//组织机构列表
			List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
			List<MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(user.getOrgId()), true);
			
			model.addAttribute("orgList", sonOrg);
		}
		//		//当前选择的用户所拥有的角色列表
		//		List<MipRole> roleList = mipRoleService.getList();
		//		model.addAttribute("roleList", roleList);


		return "/WEB-INF/back/authority/userManagemenAdd.jsp";
	}

	@RequestMapping("/getRoleByOrg.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getRoleByOrg(String orgId) {
		//根据组织id查询该组织的orgtypeid
		com.tj720.mip.model.MipOrganization mipOrganization = organizationService.get(orgId);
		String orgTypeId = mipOrganization.getOrgTypeId();
		if (StringUtils.isNotBlank(orgTypeId)) {
			//查询所有角色
			List<MipRole> roleList = mipRoleService.getList();
			List<MipRole> roles = new ArrayList<MipRole>();
			for (MipRole mipRole : roleList) {
				String orgtype = mipRole.getOrgtype();
				if (StringUtils.isNotBlank(orgtype)) {
					//该组织的orgtypeid如果包含该角色的orgtype
					if (orgtype.contains(orgTypeId)) {
						roles.add(mipRole);
					}
				}
			}
			return new JsonResult(1,roles);
		} else {
			return new JsonResult(2);
		}
	}

	@RequestMapping("/getRoleList.do")
	@ResponseBody
	@AuthPassport
	public JsonResult toEdit(String id) {
		JsonResult result = null;
		try {
			List<MipUserRole> userRoleList = mipUserRoleService.getByUserId(id);
			result = new JsonResult(1,userRoleList);
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(2,null);
		}


		return result;
	}

	@RequestMapping("/getUserByOrgId")
	@ResponseBody
	@AuthPassport
	public int getUserByOrgId(String orgId) {
		Integer count = userService.getUserByOrg(orgId);

		return count;
	}

	@RequestMapping("/del.do") 
	@ResponseBody
	@AuthPassport
	public JsonResult del(String id) {
		JsonResult result = null;
		try {
			userService.deletById(id);
			mipUserRoleService.deleteByUserId(id);
			result = new JsonResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(2);
		}

		return result;
	}

	@RequestMapping("/updataStatus.do")
	@ResponseBody
	@AuthPassport
	public JsonResult updataStatus(String status,String id) {
		JsonResult result = null;
		Map<String,Object> map = new HashMap<String, Object>();
		if (status.equals("1")) {
			status = "0";
		} else {
			status = "1";
		}
		map.put("status", status);
		map.put("id", id);
		try {
			userService.updataStatus(map);
			result = new JsonResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(2);
		}

		return result;
	}

	@RequestMapping("/check.do")
	@ResponseBody
	@AuthPassport
	public JsonResult check(String phone) {
		JsonResult result = null;
		if (StringUtils.isNotBlank(phone)) {
			Integer count = userService.checkPhone(phone);
			if (count == 0) {
				result = new JsonResult(1);
			} else {
				result = new JsonResult(2);
			}
		} else {
			result = new JsonResult(2);
		}

		return result;
	}

	@RequestMapping("/getHeadData.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getHeadData() {
		JsonResult result = null;
		// 当前登录者
		User user = userService.get(Tools.getUser().getId());
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//角色列表
			//			com.tj720.mip.model.MipOrganization mipOrganization = organizationService.get(user.getOrgId());
			//			String orgTypeId = mipOrganization.getOrgTypeId();
			List<MipRole> roleList = mipRoleService.getList();
			//			List<MipRole> roles = new ArrayList<MipRole>();
			//			if (StringUtils.isNotBlank(orgTypeId)) {
			//				for (MipRole mipRole : roleList) {
			//					String orgtype = mipRole.getOrgtype();
			//					if (StringUtils.isNotBlank(orgtype)) {
			//						//该组织的orgtypeid如果包含该角色的orgtype
			//						if (orgTypeId.contains(orgtype)) {
			//							roles.add(mipRole);
			//						}
			//					}
			//				}
			//			}
			//组织机构列表
			List<MipOrganization> orgList = organizationService.getList();
			if (user.getOrgId().equals("0")) {
				map.put("orgList", orgList);
			} else {
				List<MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(user.getOrgId()), false);
				map.put("orgList", sonOrg);
			}

			map.put("roleList", roleList);
			result = new JsonResult(1,map);
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(2,null);
		}

		return result;
	}

	@RequestMapping("/toModifyPassword.do")
	@AuthPassport
	public String toModifyPassword() {

		return "/WEB-INF/back/authority/modifyPassword.jsp";
	}

	@RequestMapping("/checkPassword.do")
	@ResponseBody
	@AuthPassport
	public JsonResult checkPassword(String userId,String password) {
		JsonResult result = null;
		if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(password)) {
			//String encrytMD5 = MD5.encrytMD5(password);
			MipUser user = userService.getById(userId);
			if (user.getPassword().equals(password)) {
				result = new JsonResult(1); //密码正确
			} else {
				result = new JsonResult(2);//密码不正确
			}

		} else {
			result = new JsonResult(3);//系统异常
		}


		return result;
	}

	@RequestMapping("/modifyPassword.do")
	@ResponseBody
	@AuthPassport
	public JsonResult modifyPassword(String userId,String password) {
		JsonResult result = null;
		if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(password)) {
			MipUser user = userService.getById(userId);
			//String encrytMD5 = MD5.encrytMD5(password);
			user.setPassword(password);
			try {
				if("e10adc3949ba59abbe56e057f20f883e".equals(password)) {
					result = new JsonResult(0,"密码与默认密码一致，请更换密码重试");
				}else {
					userService.updateByMipUser(user);
					result = new JsonResult(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				result = new JsonResult(3,"系统异常");
			}
		}
		return result;
	}

}
