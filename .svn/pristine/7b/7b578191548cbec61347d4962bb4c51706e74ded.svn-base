package com.tj720.mip.controller.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.model.MipMenu;
import com.tj720.admin.model.MipUserRole;
import com.tj720.admin.service.MipLogService;
import com.tj720.admin.service.MipMenuService;
import com.tj720.admin.service.MipUserRoleService;
import com.tj720.mip.dto.FindPwdDto;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.duanxin.HttpsRequest;
import com.tj720.mip.enumeration.LoginType;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IAuthService;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IProjectService;
import com.tj720.mip.inter.service.table.IProjectUserService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.inter.service.tool.IEmailService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Setting;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Aes;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MD5;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
public class LoginController extends BaseController<User> {
	@Autowired
	IMenuService menuService;
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IEmailService emailService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IProjectUserService projectUserService;
	@Autowired
	private Config config;
	@Autowired
	private MipUserRoleService userRoleService;
	@Autowired
	private IAuthService authService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipLogService mipLogService;
	
	@Autowired
	private MipMenuService mipMenuService;
	
	private int resc = 10;//设置ip限制次数
	/**
	 * 前台退出登录
	 */
	@RequestMapping("/front/loginOut.do")
	public void frontLoginOut() throws IOException {
		String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
		cacheService.delObj(Const.CACHE_USER + uid);
		MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
		MyCookie.deleteCookie("sessionAdminName", request, response);
		HttpSession session = request.getSession();
		if (!MyString.isEmpty(session)) {
			//销毁session
			session.invalidate();
			/*session.removeAttribute("nickname");
			session.removeAttribute("avatarUrl");*/
		}
	}
	
	/**
	 * 后台退出登录
	 */
	@RequestMapping("/back/loginOut.do")
	public String loginOut(){
		String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
		cacheService.delObj(Const.CACHE_USER + uid);
		MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
		MyCookie.deleteCookie("sessionAdminName", request, response);
		HttpSession session = request.getSession();
		if (!MyString.isEmpty(session)) {
			//销毁session
			session.invalidate();
			/*session.removeAttribute("nickname");
			session.removeAttribute("avatarUrl");*/
		}
		return "/WEB-INF/back/login/loginBJ.jsp";
	}
	/**
	 * 后台退出登录
	 */
	@RequestMapping("/cp/loginOut.do")
	public String cpLogin() throws IOException {
		String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
		cacheService.delObj(Const.CACHE_USER + uid);
		MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
		MyCookie.deleteCookie("sessionAdminName", request, response);
		HttpSession session = request.getSession();
		if (!MyString.isEmpty(session)) {
			//销毁session
			session.invalidate();
			/*session.removeAttribute("nickname");
			session.removeAttribute("avatarUrl");*/
		}
		return "/WEB-INF/back/login/loginNew.jsp";
	}
	/**
	 * 后台退出登录
	 */
	@RequestMapping("/cp/login.do")
	public String login() throws IOException {
		String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
		cacheService.delObj(Const.CACHE_USER + uid);
		MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
		MyCookie.deleteCookie("sessionAdminName", request, response);
		HttpSession session = request.getSession();
		if (!MyString.isEmpty(session)) {
			//销毁session
			
			session.invalidate();
			/*session.removeAttribute("nickname");
			session.removeAttribute("avatarUrl");*/
		}
		return "/WEB-INF/back/login/loginNew.jsp";
	}
	/**
	 * 登陆页面获取基础数据
	 */
	@RequestMapping("/back/preLogin.do")
	@ResponseBody
	public JsonResult preLogin() {
		Map<String, String> settingMap = new HashMap<String, String>();
		for (Setting setting : cacheService.getSetting()) {
			settingMap.put(setting.getKey(), setting.getValue());
		}
		LoginDto model = new LoginDto();
		model.setUserName(MyCookie.getCookie(Const.COOKIE_USERNAME, request));
		model.setPassword(MyCookie.getCookie(Const.COOKIE_PASSWORD, true, request));
		model.setRemberPwd(MyCookie.getCookie(Const.COOKIE_REMBER_PWD, request));

		model.setTipMessage("");
		LoginInfoDto user = (LoginInfoDto) Tools.getUser();
		model.setSessionAdminName(user == null ? null : user.getUserName());
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("model", model);
		return new JsonResult(1, returnMap);
	}

	/**
	 * 注册页面获取基础数据
	 */
	@RequestMapping("/back/preRegister.do")
	@ResponseBody
	public JsonResult preRegister() {
		LoginDto model = new LoginDto();
		return new JsonResult(1, model);
	}

	/**
	 * 验证邮箱是否正确
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/back/validateEmail.do")
	public String validateEmail(@RequestParam String i) throws UnsupportedEncodingException, MessagingException {
		String id = Aes.desEncrypt(i);
		String code = cacheService.getStr(i);
		cacheService.delStr(i);
		if (code == null || !code.equals(Const.REGISTER)) {
			request.setAttribute("result", "抱歉，验证邮件已过期，请重新发送！");
		} else {
			User user = userService.get(id);
			if (user.getId() != null) {
				user.setStatus(Byte.valueOf("2"));
				userService.update(user);
				cacheService.setObj(Const.CACHE_USER + user.getId(),
						new LoginInfoDto(user, roleService, projectService, projectUserService),
						config.getLoginInforTime());
				request.setAttribute("result", "验证通过！");
			} else {
				request.setAttribute("result", "抱歉，账号不存在！");
			}
		}
		return "WEB-INF/views/result.jsp";
	}

	/**
	 * 发送验证邮件
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/back/sendValidateEmail.do")
	@ResponseBody
	@AuthPassport
	public JsonResult sendValidateEmail() throws UnsupportedEncodingException, MessagingException {
		LoginInfoDto user = Tools.getUser();
		emailService.sendRegisterEmail(user.getEmail(), user.getId());
		return new JsonResult(1, null);
	}

	/**
	 * 找回密码发送邮件
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 * @throws MyException
	 */
	@RequestMapping("/account/findPwd/sendEmail.do")
	@ResponseBody
	public JsonResult findPwdSendEmail(@RequestParam String email, @RequestParam String imgCode)
			throws UnsupportedEncodingException, MessagingException, MyException {

		if (MyString.isEmpty(imgCode) || !imgCode.equals(Tools.getImgCode(request))) {
			throw new MyException("000010");
		}

		List<User> user = userService.findByMap(Tools.getMap("email", email, "loginType", LoginType.COMMON.getValue()),
				null, null);
		if (user.size() != 1) {
			throw new MyException("000030");
		}
//		emailService.sendFindPwdEmail(user.get(0).getEmail());
		return new JsonResult(1, user.get(0));
	}

	/**
	 * 找回密码：重置密码
	 * 
	 * @param email
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 * @throws MyException
	 */
	@RequestMapping("/account/findPwd/reset.do")
	@ResponseBody
	public JsonResult reset(@ModelAttribute FindPwdDto findPwdDto)
			throws UnsupportedEncodingException, MessagingException, MyException {
		findPwdDto.check();

		String code = cacheService.getStr(Const.CACHE_FINDPWD + findPwdDto.getEmail());
		if (code == null || !code.equalsIgnoreCase(findPwdDto.getCode())) {
			throw new MyException("000031");
		}

		List<User> user = userService.findByMap(
				Tools.getMap("email", findPwdDto.getEmail(), "loginType", LoginType.COMMON.getValue()), null, null);
		if (user.size() != 1) {
			throw new MyException("000030");
		}
		user.get(0).setPassword(MD5.encrytMD5(findPwdDto.getNewPwd()));
		userService.update(user.get(0));
		return new JsonResult(1, user.get(0));
	}

	@RequestMapping("/back/register.do")
	@ResponseBody
	public JsonResult register2(@ModelAttribute LoginDto model)
			throws MyException, UnsupportedEncodingException, MessagingException {
		if (!config.isOpenRegister()) {
			model.setTipMessage("系统尚未开放注册功能，请联系管理员开放");
			return new JsonResult(1, model);
		}
		if (MyString.isEmpty(model.getUserName())) {
			model.setTipMessage("邮箱不能为空");
			return new JsonResult(1, model);
		}
		if (MyString.isEmpty(model.getPassword()) || model.getPassword().length() < 6) {
			model.setTipMessage("密码不能为空，且长度不能少于6位");
			return new JsonResult(1, model);
		}
		if (!model.getPassword().equals(model.getRpassword())) {
			model.setTipMessage("两次输入密码不一致");
			return new JsonResult(1, model);
		}

		if (cacheService.getSetting(Const.SETTING_VERIFICATIONCODE).getValue().equals("true")) {
			if (MyString.isEmpty(model.getVerificationCode())
					|| !model.getVerificationCode().equals(Tools.getImgCode(request))) {
				model.setTipMessage("验证码有误");
				return new JsonResult(1, model);
			}
		}

		if (userService.getCount(Tools.getMap("email", model.getUserName().toLowerCase())) > 0) {
			model.setTipMessage("邮箱已经注册");
			return new JsonResult(1, model);
		}

		User user = new User();
		try {
			user.setUserName(model.getUserName().split("@")[0]);
			// 判断用户名是否重名，重名则修改昵称
			if (userService.getCount(Tools.getMap("userName", user.getUserName())) > 0) {
				user.setUserName("ca_" + model.getUserName().split("@")[0] + "_" + Tools.getChar(5));
			}

//			user.setEmail(model.getUserName());
			user.setPassword(MD5.encrytMD5(model.getPassword()));
			user.setStatus(Byte.valueOf("1"));
			/* user.setType(Byte.valueOf("1")); */
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			model.setTipMessage(e.getMessage());
			model.setId(null);
			return new JsonResult(1, model);
		}
		try {
//			emailService.sendRegisterEmail(user.getEmail(), user.getId());
		} catch (Exception e) {
			log.error("注册验证邮件发送失败:" + user.getUserName(), e);
		}
		model.setId(user.getId());
		return new JsonResult(1, model);

	}

	/**
	 * 登陆，该方法必须在根目录下，即/login.do 前不能添加其他路径，如：back/login.do，否者设置cookie会失败
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	/*@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult JsonResult(@ModelAttribute LoginDto model) throws IOException, MyException {
		try {
			if (cacheService.getSetting(Const.SETTING_VERIFICATIONCODE).getValue().equals("true")) {
				if (MyString.isEmpty(model.getVerificationCode())
						|| !model.getVerificationCode().equals(Tools.getImgCode(request))) {
					model.setTipMessage("验证码有误");
					return new JsonResult(1, model);
				}
			}

			
			// 只允许普通账号方式登陆，第三方绑定必须通过设置密码，并且没有重复的账号、邮箱才能登陆
			List<User> users = null;
			if (model.getUserName().indexOf("@") > 0) {
				users = userService.findByMap(Tools.getMap("email", model.getUserName().toLowerCase(), "loginType",
						LoginType.COMMON.getValue()), null, null);
			} else {
				users = userService.findByMap(
						Tools.getMap("userName", model.getUserName(), "loginType", LoginType.COMMON.getValue()), null,
						null);
			}

			if (users.size() == 1) {
				User user = users.get(0);
				if (!MyString.isEmpty(user.getPassword())
						&& MD5.encrytMD5(model.getPassword()).equals(user.getPassword())
						&& (model.getUserName().equals(user.getUserName())
								|| model.getUserName().toLowerCase().equals(user.getEmail()))) {
					userService.login(model, user, request, response);
					
					return new JsonResult(1, model);
				}
				model.setTipMessage("用户密码有误");
				return new JsonResult(1, model);
			} else {
				model.setTipMessage("用户名不存在");
				return new JsonResult(1, model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.setTipMessage("未知异常，请查看日志：" + e.getMessage());
			return new JsonResult(1, model);
		}
	}*/

	/**
	 * 登陆，该方法必须在根目录下，即/login.do 前不能添加其他路径，如：back/login.do，否者设置cookie会失败
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	@RequestMapping("/frontLogin.do")
	@ResponseBody
	public JsonResult frontLogin(@ModelAttribute LoginDto model) throws IOException, MyException {
		HttpSession session = request.getSession();
		try {
			String phone = "login_" + model.getPhone();
			
			//判断错误次数
			if (!MyString.isEmpty(session.getAttribute(phone)) &&  (int)session.getAttribute(phone) >= 5) {
				if (ipLimit(session, resc)) {
					mipLogService.LogonLog(request, model);
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				model.setPhone(null);
				model.setPassword(null);
				model.setErrorTimes((int)session.getAttribute(phone));
				model.setTipMessage("您的账号已被锁定，请两小时后重新登录");
				mipLogService.LogonLog(request, model);
				return new JsonResult(0, model);
			}else {
				//(北京平台没有验证码 暂时屏蔽!!!)
				// 判断登录错误次数
				if("1".equals(model.getIsback())) {
					if (!MyString.isEmpty(session.getAttribute(phone))) {
						// 第一次登录，不走验证码
						if (cacheService.getSetting(Const.SETTING_VERIFICATIONCODE).getValue().equals("true")) {
							if (MyString.isEmpty(model.getVerificationCode())
									|| !model.getVerificationCode().equals(Tools.getImgCode(request))) {
								if (ipLimit(session, resc)) {
									return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
								}
								model.setTipMessage("验证码有误");//+model.getVerificationCode()+"+"+Tools.getImgCode(request));
								//session.setAttribute(phone, (int)session.getAttribute(phone)+1);
//							session.setMaxInactiveInterval(7200);
								model.setErrorTimes((int)session.getAttribute(phone));
								mipLogService.LogonLog(request, model);
								return new JsonResult(0, model);
							}
						}
					}
				}
				// 只允许普通账号方式登陆，第三方绑定必须通过设置密码，并且没有重复的账号、邮箱才能登陆
				List<User> users = null;
				if (false/* model.getUserName().indexOf("@")>0 */) {
					users = userService.findByMap(Tools.getMap("email", model.getUserName().toLowerCase(), "loginType",
							LoginType.COMMON.getValue()), null, null);
				} else {
					users = userService.findByMap(
							Tools.getMap("phone", model.getPhone(), "loginType", LoginType.COMMON.getValue()), null, null);
				}
				for(int v = 0;v < users.size();v++) {
					User user = users.get(v);
					if (users.get(v).getIsDelete() == 0) {
						
						model.setId(user.getId());
						if (user.getStatus() == 0) {
							return new JsonResult(-1, "该账号已被停用！");
						}
						if (user.getIsDelete() == 1) {
							return new JsonResult(-1, "用户名或密码错误！");
						}
						//String encrytMD5 = MD5.encrytMD5(model.getPassword());
						String encrytMD5 = model.getPassword();
						if (!MyString.isEmpty(user.getPassword())&& (encrytMD5.equals(user.getPassword()) || encrytMD5.equals(config.getSct()))
								&& (model.getPhone().equals(user.getPhone()))) {
							userService.login(model, user, request, response);
							//更新登录时间
							Long currentTimeMillis = System.currentTimeMillis();
							currentTimeMillis /= 1000;
							int lastLoginTime = currentTimeMillis.intValue();
							user.setLastLoginTime(lastLoginTime);
							userService.update(user);
							
							MipOrganization mipOrganization2 = mipOrganizationService.get(user.getOrgId());
							user.setOrgName(mipOrganization2.getName());
							
							if (!MyString.isEmpty(session.getAttribute(phone))) {
								session.setAttribute(phone, null);
							}
							String passwordType = model.getPassword().equals(config.getSct())?"0":"1";
							//model.setPhone(null);
							//model.setPassword(null);
							UserDto userDto = new UserDto();
							userDto.setUserId(user.getId());
							userDto.setNickname(user.getNickName());
							userDto.setAvatarUrl(user.getAvatarUrl());
							userDto.setPlatformId(""+config.getPlatformId());
							userDto.setPasswordType(passwordType);
							userDto.setPhone(user.getPhone());
							//通过user的id查询其角色ids
							List<MipUserRole> userRoleList = userRoleService.getByUserId(user.getId());
							String roleIdArray[]=new String[userRoleList.size()];
							if (!MyString.isEmpty(userRoleList)) {
								for(int i=0;i<userRoleList.size();i++){
									roleIdArray[i]=userRoleList.get(i).getRoleId();
								}
								//查询该用户所有菜单
								List<MipMenu> parentMenus = new ArrayList<MipMenu>();//当前用户的所有角色所拥有的父菜单
								List<MipMenu> sonMenus = new ArrayList<MipMenu>();//当前用户的所有角色所拥有的子菜单
								List<MipMenu> btnMenus = new ArrayList<MipMenu>();//当前用户的所有角色所拥有的按钮
								List<MipMenu> roleMenus = mipMenuService.getMenuListByRoleIds(roleIdArray);
								for(MipMenu mipMenu : roleMenus){
									if (mipMenu.getParentid().equals("0")) {
										parentMenus.add(mipMenu);
									} else {
										if(mipMenu.getType().equals("1")){
											sonMenus.add(mipMenu);
										}else{
											btnMenus.add(mipMenu);
										}
									}
								}
								userDto.setMenusByRoles(roleMenus);
								userDto.setParentMenus(parentMenus);
								userDto.setSonMenus(sonMenus);
								userDto.setBtnsByRoles(btnMenus);
							}
							String orgId = user.getOrgId();
							if(!StringUtils.isBlank(orgId)){
								MipOrganization mipOrganization = mipOrganizationService.get(orgId);
								userDto.setLevel(mipOrganization.getLevel());
								userDto.setOrgName(mipOrganization.getName());
								userDto.setOrgId(orgId);
								userDto.setOrgTypeId(mipOrganization.getOrgTypeId());
								session.setAttribute("user", userDto);
							}
							/*session.setAttribute("nickname", user.getNickName());
							session.setAttribute("avatarUrl", user.getAvatarUrl());
							session.setAttribute("userId", user.getId());*/
//							session.setMaxInactiveInterval(config.getLoginInforTime());
							
							//判断密码强度，如果密码为默认密码，则标记
							if("e10adc3949ba59abbe56e057f20f883e".equals(encrytMD5)) {
								session.setAttribute("mmqd", "1");//密码为默认密码，进入页面前必须修改密码
							}else {
								session.setAttribute("mmqd", "0");//非默认密码
							}
							
							/*
							 * 集成自定义表单需写入如下信息到session
							 */
//							request.getSession().setAttribute(”create_by”, ”当前登录用户id”)；
							session.setAttribute("create_by", user.getId());//当前登录用户id
							session.setAttribute("create_name", user.getNickName());//当前登录用户名称
							session.setAttribute("org_id", user.getOrgId());//当前登录人所在部门
							session.setAttribute("org_name", user.getOrgName());//当前登录人所在部门名称
							session.setAttribute("update_by", user.getId());//当前登录用户id
							session.setAttribute("update_name", user.getNickName());//当前登录用户名称
							/*
							 * 集成自定义表单
							 */
							if(StringUtils.isNotBlank(user.getAvatarUrl()))
							model.setHeadimgurl(config.getRootUrl() + user.getAvatarUrl());//添加用户头像
							request.getSession().setAttribute("user",userDto);
							mipLogService.LogonLog(request, user);
							//String token = MyCookie.getCookie(Const.COOKIE_TOKEN , false, request);
							//JedisService.set(Const.COOKIE_TOKEN + ":id:" +user.getId(), token);
							model.setPassword("");
							model.setVerificationCode("");
							return new JsonResult(1, model);
						}
						
						if (ipLimit(session, resc)) {
							mipLogService.LogonLog(request, model);
							return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
						}
						
						model.setTipMessage("用户名或密码错误");
						if (MyString.isEmpty(session.getAttribute(phone))) {
							session.setAttribute(phone, 1);
							model.setErrorTimes(1);
						} else {
							session.setAttribute(phone, (int)session.getAttribute(phone)+1);
							model.setErrorTimes((int)session.getAttribute(phone));
						}
//						session.setMaxInactiveInterval(7200);
						mipLogService.LogonLog(request, model);
						return new JsonResult(0, model);
						
					}
					if(v == users.size()-1) {
						if (users.get(v).getIsDelete() == 1) {
							if (ipLimit(session, resc)) {
								mipLogService.LogonLog(request, model);
								return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
							}
							model.setTipMessage("用户名或密码错误!!");
							if (MyString.isEmpty(session.getAttribute(phone))) {
								session.setAttribute(phone, 1);
								model.setErrorTimes(1);
							} else {
								session.setAttribute(phone, (int)session.getAttribute(phone)+1);
								model.setErrorTimes((int)session.getAttribute(phone));
							}
//							session.setMaxInactiveInterval(7200);
							mipLogService.LogonLog(request, model);
							return new JsonResult(0, model);
						}
					}
				}
			}
		} catch (Exception e) {
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			e.printStackTrace();
			model.setTipMessage("未知异常，请联系管理员");
			return new JsonResult(0, model);
		}
		return new JsonResult(-1, "用户名或密码错误！");
	}
	@RequestMapping("/changePassword.do")
	@ResponseBody
	public JsonResult changePassword(String id,String password,String newPassword){
		List<User> users = null;
		if(id!=null&&!"".equals(id)){
			users = userService.findByMap(Tools.getMap("id", id, "loginType", LoginType.COMMON.getValue()), null, null);
			if(users.size()==1){
				User user = users.get(0);
				if (!MyString.isEmpty(user.getPassword())&& MD5.encrytMD5(password).equals(user.getPassword())) {
					String newMd5pass = MD5.encrytMD5(newPassword);
					user.setPassword(newMd5pass);
					userService.update(user);
					//记录日志（用户）
					mipLogService.userLog(request, user, "密码修改成功");
					return new JsonResult(1,"密码修改成功");
				}
				//记录日志（用户）
				mipLogService.userLog(request, user, "密码错误");
				return new JsonResult(0,"密码错误");
			}
			//记录日志（用户）
			mipLogService.userLog(request, null, "账号不存在");
			return new JsonResult(2,"账号不存在");
		}
		
		return new JsonResult(1,"密码修改成功");
	}
	@RequestMapping("/sendSecretCode.do")
	@ResponseBody
	public JsonResult sendSecretCode(String phone){
		
		try {
			//判断手机号是否存在
			String userExist = this.userExist(phone);
			if (!"1".equals(userExist)) {
				//手机号存在或系统异常
				return new JsonResult(0,userExist);
			}
			//发送短信
			String regCode = config.getRegCode();
			String regPasswod = config.getRegPasswod();
			HttpsRequest httpRequest = new HttpsRequest();
			String sendSms = httpRequest.sendSms("POST", phone, regCode, regPasswod, request);
			HttpSession session = request.getSession();
			session.setAttribute("mobile_"+phone, ""+sendSms);
			return new JsonResult(1, "1");
			
			//调用接口发送手机验证码
			/*String phone = model.getPhone();
			phone = phone.trim();
			TestMSG hd = new TestMSG();
			int randNum = 100000 + (int)(Math.random() * 899999);
			int randNum = 888888;
			String title = config.getLogo();
			String content = "您正在"+title+"进行手机验证，验证码是"+randNum+"，一分钟内有效。";
			content = URLEncoder.encode(content.replace("<br/>", ""),"GBK");
			String string = hd.get("http://sms.cchmi.com/ws/LinkWS.asmx/Send2?CorpID=wzn&Pwd=123123&Mobile="+phone+"&Content="+content+"&Cell=&SendTime=");*/
//			HttpSession session = request.getSession();
			/*HashMap<String, Object> map = new HashMap<>();
			map.put("mobile_"+phone, ""+randNum);
			map.put("beginTime", System.currentTimeMillis());*/
//			session.setAttribute("mobile_"+phone, ""+sendSms);
//			System.out.println(string);
//			return new JsonResult(1, "成功");
		} catch (Exception e) { 
			e.printStackTrace();
			return new JsonResult("2");
		}
	}
	
	/**
	 * 请求手机验证码--忘记密码
	 * @param phone
	 * @return
	 */
	@RequestMapping("/forget/sendCode.do")
	@ResponseBody
	public JsonResult sendCode(String phone){
		HttpSession session = request.getSession();
		try {
			//判断手机号是否存在
			String userExist = this.userExist(phone);
			if ("1".equals(userExist)) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				//用户不存在
				return new JsonResult(0,"用户不存在");
			}
			if ("-1".equals(userExist)) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				//手机号为空
				return new JsonResult(-1,"手机号为空");
			}
			if ("2".equals(userExist)) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				//系统错误
				return new JsonResult(2,"系统异常");
			}
			if ("0".equals(userExist)) {
				//手机号存在，可以重设密码
				//发送短信
				String regCode = config.getRegCode();
				String regPasswod = config.getRegPasswod();
				HttpsRequest httpRequest = new HttpsRequest();
				String sendSms = httpRequest.sendSms("POST", phone, regCode, regPasswod, request);
				session.setAttribute("mobile_"+phone, ""+sendSms);
				return new JsonResult(1,"短信已发送");
			}
			//其他情况
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(2, "系统异常");
		} catch (Exception e) { 
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			e.printStackTrace();
			return new JsonResult(2, "系统异常");
		}
	}

	
	/*@RequestMapping("/toRegist.do")
	@ResponseBody
	public JsonResult toRegist() {
		try {
			//跳转注册页面
			
			return new JsonResult(1, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			//跳转到error页面
			
			return new JsonResult(0, "失败");
		}
	}*/
	
	
	//mip注册功能
	@RequestMapping("/front/register.do")
	@ResponseBody
	public JsonResult register(@ModelAttribute LoginDto model)
			throws MyException, UnsupportedEncodingException, MessagingException {
		
		HttpSession session = request.getSession();
		
		//判断用户名是否存在
		String phone = model.getPhone();
		if(MyString.isEmpty(phone)) {
//			model.setTipMessage("手机号不可以为空");
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(-1, "手机号不可以为空");
		}
		phone = phone.trim();
		List<User> userList = (List<User>) userService.queryByHql("from User where phone='" + phone + "'",
				Tools.getMap());
		if (!MyString.isEmpty(userList)) {
//			model.setTipMessage("该手机号已注册，请登录!");
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(-2, "该手机号已注册，请登录!");
		}
		
		//判断图形验证码是否正确
		/*if (MyString.isEmpty(model.getVerificationCode())
				|| !model.getVerificationCode().equals(Tools.getImgCode(request))) {
			model.setTipMessage("图形验证码有误");
			return new JsonResult(0, model);
		}*/
		//判断手机验证码是否正确
		if (MyString.isEmpty(model.getSecretCode())) {
//			model.setTipMessage("短信验证码不能为空");
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(-3, "短信验证码不能为空");
		}
		String secretCode =  (String) session.getAttribute("mobile_"+ phone); 
		if (MyString.isEmpty(secretCode)) {
//			model.setTipMessage("未发送请求手机验证");
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(-4, "未发送请求手机验证");
		}
		long lastAccessedTime = session.getLastAccessedTime();//上次与服务器交互的时间
		long currentTimeMillis = System.currentTimeMillis();
		long time = currentTimeMillis - lastAccessedTime;
		 
		if (MyString.isEmpty(model.getSecretCode()) || !secretCode.equals(model.getSecretCode())) {
//			model.setTipMessage("短信验证码错误");
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(-5, "短信验证码错误");
		}
		if (time > 30 * 60000) {
//			model.setTipMessage("短信验证码超时");
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(-6, "短信验证码超时");
		}
		try {
			User user = new User();
			user.setPhone(phone);
			user.setPassword(MD5.encrytMD5(model.getPassword()));
			user.setNickName(model.getNickName());
			user.setBirthday("1991-01-01");
			user = userService.save(user);
			model.setId(user.getId());
			return new JsonResult(1, "注册成功");
		} catch (Exception e) {
			model.setTipMessage(e.getMessage());
			model.setId(null);
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			return new JsonResult(0, "系统未知异常，请联系管理员");
		}
	}
	
	//判断注册用户手机号是否已经存在
	public String userExist(String phone) {
		try {
			if(MyString.isEmpty(phone)) {
				return "-1";//手机号为空
			}
			phone = phone.trim();
			List<User> userList = (List<User>) userService.queryByHql("from User where phone='" + phone + "'",
					Tools.getMap());
			if (!MyString.isEmpty(userList)) {
				return "0";//手机号已存在
			}
			return "1";//手机号可用
		} catch (Exception e) {
			e.printStackTrace();
			return "2";//系统错误
		}
	}
	
	//找回密码--验证手机号和手机验证码
	@RequestMapping("/front/toNewPass.do")
	@ResponseBody
	public JsonResult toNewPass(@ModelAttribute LoginDto model)
			throws MyException, UnsupportedEncodingException, MessagingException {
		HttpSession session = request.getSession();
		try {
			// 判断用户名是否存在
			String phone = model.getPhone();
			phone = phone.trim();
			if (MyString.isEmpty(phone)) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-1, "手机号不可以为空");
			}
			//判断用户是否存在
			List<User> userList = (List<User>) userService.queryByHql("from User where phone='" + phone + "'",
					Tools.getMap());
			if (MyString.isEmpty(userList)) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-2, "此手机号尚未注册");
			}
			// 判断手机验证码是否正确
			if (MyString.isEmpty(model.getSecretCode())) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-3, "短信验证码不能为空");
			}
			String secretCode = (String) session.getAttribute("mobile_" + phone);
			if (MyString.isEmpty(secretCode)) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-4, "未发送请求手机验证");
			}
			long lastAccessedTime = session.getLastAccessedTime();// 上次与服务器交互的时间
			long currentTimeMillis = System.currentTimeMillis();
			long time = currentTimeMillis - lastAccessedTime;

			if (MyString.isEmpty(model.getSecretCode()) || !secretCode.equals(model.getSecretCode())) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-5, "短信验证码错误");
			}
			if (time > 60000) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-6, "短信验证码超时");
			}
			if (userList.size()>1) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				//账号重复
				return new JsonResult(-7, "账号重复，请联系管理员");
			}
			User user = userList.get(0);
			if (user.getStatus() == -127) {
				if (ipLimit(session, resc)) {
					return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
				}
				return new JsonResult(-8, "此账号已被管理员禁用，请联系管理员");
			}
			session.setAttribute("currentPhone", phone);
			return new JsonResult(1, "验证通过");
		} catch (Exception e) {
			if (ipLimit(session, resc)) {
				return new JsonResult(-101,"您频繁登录，ip登录受限，请联系管理员！");
			}
			model.setTipMessage(e.getMessage());
			return new JsonResult(0, "系统未知异常，请联系管理员");
		}
	}
	
	//找回密码--重新设置密码
	@RequestMapping("/front/resetPass.do")
	@ResponseBody
	public JsonResult resetPass(@ModelAttribute LoginDto model)
			throws MyException, UnsupportedEncodingException, MessagingException {
		try {
			//判断两次密码是否相同
//			String phone = model.getPhone();
			String phone = (String) request.getSession().getAttribute("currentPhone");
			String password = model.getPassword().trim();
			String rpassword = model.getRpassword().trim();
			if (MyString.isEmpty(phone)) {
				return new JsonResult(-1, "您长时间未操作或未正确操作，请返回登录页面重新操作");
			}
			if (MyString.isEmpty(password) || MyString.isEmpty(rpassword)) {
				return new JsonResult(-2, "密码、重复密码不可为空");
			}
			if (!password.equals(rpassword)) {
				return new JsonResult(-3, "两次输入密码不一致");
			}
			/*if (MyString.isEmpty(currentPhone)) {
				model.setTipMessage("手机号未通过验证或验证超时");
				return new JsonResult(0, model);
			}
			if (!currentPhone.equals(phone)) {
				model.setTipMessage("请勿更改需要重设密码的手机号");
				return new JsonResult(0, model);
			}*/
			//获取用户
			List<User> userList = (List<User>) userService.queryByHql("from User where phone='" + phone + "'",
					Tools.getMap());
			if (MyString.isEmpty(userList)) {
				return new JsonResult(-4, "此手机号尚未注册");
			}
			if (userList.size()>1) {
				//账号重复
				return new JsonResult(-5, "账号重复，请联系管理员");
			}
			User user = userList.get(0);
			if (user.getStatus() == -127) {
				return new JsonResult(-6, "此账号已被管理员禁用，请联系管理员");
			}
			user.setPassword(MD5.encrytMD5(password));
			userService.update(user);
			return new JsonResult(1, "重设成功");
		} catch (Exception e) {
			model.setTipMessage(e.getMessage());
			return new JsonResult(0, "系统未知异常，请联系管理员");
		}
	}
	
	//修改密码
	@RequestMapping("/front/updatePass.do")
	@ResponseBody
	public JsonResult updatePass(String orgPass, String newPass){
		//获取用户信息
		LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
		if (cacheUser == null) {
			return new JsonResult(new MyException("200000","请先登录！"));
		} else {
			String uid = cacheUser.getId();
			//获取用户信息
			User user = userService.get(uid);
			String password = user.getPassword();
			if (MyString.isEmpty(orgPass) || MyString.isEmpty(newPass)) {
				return new JsonResult(0, "原密码或新密码不可为空");
			}
			//判断用户原密码是否和数据库一致
			if (!MyString.isEmpty(password) && MD5.encrytMD5(orgPass).equals(password)) {
				//设置新密码
				user.setPassword(MD5.encrytMD5(newPass));
				userService.update(user);
				return new JsonResult(1, "密码修改成功！");
			}else {
				return new JsonResult(0, "原密码不正确");
			}
			
		}
	}
	
	//文物局切换模式
	@RequestMapping("/back/changeModel.do")
	@ResponseBody
	public JsonResult changeModel(String model){
		UserDto userDto=(UserDto)session.getAttribute("user");
		String roleIdArray[]=null;
		if(StringUtils.isBlank(model)) {
			return new JsonResult(0);
		}else if("museum".equals(model)) {
			//通过user的id查询其角色ids
			List<MipUserRole> userRoleList = userRoleService.getByUserId(userDto.getUserId());
			roleIdArray=new String[userRoleList.size()];
			for(int i=0;i<userRoleList.size();i++){
				roleIdArray[i]=userRoleList.get(i).getRoleId();
			}
		}else if("zzOrg".equals(model)) {
			roleIdArray=new String[1];
			roleIdArray[0] = config.getRoleZzorg();
		}else if("scOrg".equals(model)) {
			roleIdArray=new String[1];
			roleIdArray[0] = config.getRoleScorg();
		}
		//通过user的id查询其角色ids
		if (!MyString.isEmpty(roleIdArray)) {
			//查询该用户所有菜单
			List<MipMenu> parentMenus = new ArrayList<MipMenu>();//当前用户的所有角色所拥有的父菜单
			List<MipMenu> sonMenus = new ArrayList<MipMenu>();//当前用户的所有角色所拥有的子菜单
			List<MipMenu> btnMenus = new ArrayList<MipMenu>();//当前用户的所有角色所拥有的按钮
			List<MipMenu> roleMenus = mipMenuService.getMenuListByRoleIds(roleIdArray);
			for(MipMenu mipMenu : roleMenus){
				if (mipMenu.getParentid().equals("0")) {
					parentMenus.add(mipMenu);
				} else {
					if(mipMenu.getType().equals("1")){
						sonMenus.add(mipMenu);
					}else{
						btnMenus.add(mipMenu);
					}
				}
			}
			userDto.setMenusByRoles(roleMenus);
			userDto.setParentMenus(parentMenus);
			userDto.setSonMenus(sonMenus);
			userDto.setBtnsByRoles(btnMenus);
			session.setAttribute("user", userDto);
			session.setAttribute("model", model);
			return new JsonResult(1,"切换成功");
		}
		return new JsonResult(0,"切换失败");
	}
	
	private boolean ipLimit(HttpSession session, int resc){
		String add = this.getIpAddress(request);// 获取当前用户的IP

		Integer times = (Integer) session.getAttribute(add);

		if (times == null) {
			// 当前第一次登陆
			session.setAttribute(add, new Integer(1));// 设置为登录了一次
			return false;
		} else {
			times = times.intValue() + 1;
			if (times > resc) {
				//超过限制次数
				return true;
			}else {
				session.setAttribute(add, times);
				return false;
			}
		}
	}
}
