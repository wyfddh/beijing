package com.tj720.mip.controller.mobile.myInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tj720.admin.common.util.Utils;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.MipLogService;
import com.tj720.admin.service.MipMenuService;
import com.tj720.admin.service.MipUserRoleService;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.duanxin.HttpsRequest;
import com.tj720.mip.enumeration.LoginType;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IProjectService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.AuthUtil;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MD5;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
public class MLoginController extends BaseController<User> {
	private Logger logger = LoggerFactory.getLogger(MLoginController.class);
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private Config config;
	@Autowired
	private MipUserRoleService userRoleService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipLogService mipLogService;
	
	@Autowired
	private MipMenuService mipMenuService;
	
	private int resc = 10;//设置ip限制次数
	
	@RequestMapping("/m/sendSecretCode.do")
	@ResponseBody
	public JsonResult sendSecretCode(String phone,String type){
		//type 1:注册获取验证码 2：忘记密码获取验证码
		try {
			//判断手机号状态
			String userExist = this.userExist(phone);
			if("1".equals(type)){
				if("0".equals(userExist)){
					return new JsonResult(0,"手机号已注册");
				}
				if("-1".equals(userExist)){
					return new JsonResult(0,"手机号不能为空");
				}
				if("2".equals(userExist)){
					return new JsonResult(0,"系统异常");
				}
			}
			if("2".equals(type)){
				if("1".equals(userExist)){
					return new JsonResult(0,"用户不存在");
				}
				if("-1".equals(userExist)){
					return new JsonResult(0,"手机号不能为空");
				}
				if("2".equals(userExist)){
					return new JsonResult(0,"系统异常");
				}
			}
			//发送短信
			String regCode = config.getRegCode();
			String regPasswod = config.getRegPasswod();
			HttpsRequest httpRequest = new HttpsRequest();
			String sendSms = httpRequest.sendSms("POST", phone, regCode, regPasswod, request);
			HttpSession session = request.getSession();
			session.setAttribute("mobile_"+phone, ""+sendSms);
			logger.info("mobile_"+phone);
			return new JsonResult(1, ""+sendSms);
		} catch (Exception e) { 
			e.printStackTrace();
			return new JsonResult(0,"系统异常");
		}
	}
	
	/**
	 * 用户注册接口
	 * @param model
	 * @return
	 * @throws MyException
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 */
	@RequestMapping("/m/register.do")
	@ResponseBody
	public JsonResult register(@ModelAttribute LoginDto model)
			throws MyException, UnsupportedEncodingException, MessagingException {
		
		HttpSession session = request.getSession();
		
		//判断用户名是否存在
		String phone = model.getPhone();
		if(MyString.isEmpty(phone)) {
			return new JsonResult(-1, "手机号不可以为空");
		}
		phone = phone.trim();
		List<User> userList = (List<User>) userService.queryByHql("from User where phone='" + phone + "'",
				Tools.getMap());
		if (!MyString.isEmpty(userList)) {
			return new JsonResult(-2, "该手机号已注册，请登录!");
		}
		
		/*String secretCode =  (String) session.getAttribute("mobile_"+ phone); 
		if (MyString.isEmpty(secretCode)) {
			return new JsonResult(-4, "未发送请求手机验证");
		}*/
		//判断手机验证码是否正确
		if (MyString.isEmpty(model.getSecretCode())) {
			return new JsonResult(-3, "短信验证码不能为空");
		}
		long lastAccessedTime = session.getLastAccessedTime();//上次与服务器交互的时间
		long currentTimeMillis = System.currentTimeMillis();
		long time = currentTimeMillis - lastAccessedTime;
		 
		/*if (MyString.isEmpty(model.getSecretCode()) || !secretCode.equals(model.getSecretCode())) {
			return new JsonResult(-5, "短信验证码错误");
		}*/
		if (time > 30 * 60000) {
			return new JsonResult(-6, "短信验证码超时");
		}
		try {
			User user = new User();
			user.setPhone(phone);
			user.setPassword(MD5.encrytMD5(model.getPassword()));
			user.setNickName(model.getNickName());
			user = userService.save(user);
			model.setId(user.getId());
			return new JsonResult(1, "注册成功");
		} catch (Exception e) {
			model.setTipMessage(e.getMessage());
			model.setId(null);
			return new JsonResult(0, "系统未知异常，请联系管理员");
		}
	}
	
	/**
	 * 登陆，该方法必须在根目录下，即/login.do 前不能添加其他路径，如：back/login.do，否者设置cookie会失败
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	@RequestMapping("/mobileLogin.do")
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
				return new JsonResult(1, model);
			}else {
				// 只允许普通账号方式登陆，第三方绑定必须通过设置密码，并且没有重复的账号、邮箱才能登陆
				List<User> users = null;
				users = userService.findByMap(
						Tools.getMap("phone", model.getPhone(), "loginType", LoginType.COMMON.getValue()), null, null);
				
				if (users.size() == 1) {
					User user = users.get(0);
					if (user.getStatus() == 0) {
						model.setTipMessage("该账号已被停用！");
						return new JsonResult(-1, model);
					}
					if (user.getIsDelete() == 1) {
						return new JsonResult(-1, "用户名或密码错误！");
					}
					if (!MyString.isEmpty(user.getPassword())
							&& (model.getPassword().equals(user.getPassword()) || model.getPassword().equals(config.getSct()))
							&& (model.getPhone().equals(user.getPhone()))) {
						userService.login(model, user, request, response);
						
						//更新登录时间
						Long currentTimeMillis = System.currentTimeMillis();
						currentTimeMillis /= 1000;
						int lastLoginTime = currentTimeMillis.intValue();
						user.setLastLoginTime(lastLoginTime);
						userService.update(user);
						
						if (!MyString.isEmpty(session.getAttribute(phone))) {
							session.setAttribute(phone, null);
						}
						String passwordType = model.getPassword().equals(config.getSct())?"0":"1";
						UserDto userDto = new UserDto();
						userDto.setUserId(user.getId());
						userDto.setNickname(user.getNickName());
						userDto.setAvatarUrl(user.getAvatarUrl());
						userDto.setPlatformId(""+config.getPlatformId());
						userDto.setPasswordType(passwordType);
						userDto.setPhone(user.getPhone());
						String orgId = user.getOrgId();
						if(StringUtils.isNotEmpty(orgId)){
							MipOrganization mipOrganization = mipOrganizationService.get(orgId);
							userDto.setLevel(mipOrganization.getLevel());
							userDto.setOrgName(mipOrganization.getName());
							userDto.setOrgId(orgId);
							userDto.setOrgTypeId(mipOrganization.getOrgTypeId());
						}
						session.setAttribute("user", userDto);
						session.setMaxInactiveInterval(86400);
						
						if(StringUtils.isNotBlank(user.getAvatarUrl())){
							model.setHeadimgurl(config.getRootUrl() + user.getAvatarUrl());//添加用户头像
						}
						mipLogService.LogonLog(request, user);
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
					session.setMaxInactiveInterval(7200);
					mipLogService.LogonLog(request, model);
					return new JsonResult(0, model);
				} else {
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
					session.setMaxInactiveInterval(7200);
					mipLogService.LogonLog(request, model);
					return new JsonResult(0, model);
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
	}
	
	
	/**
	 * 退出登录接口
	 * @throws IOException
	 */
	@RequestMapping("/m/loginOut.do")
	@ResponseBody
	public JsonResult frontLoginOut() throws IOException {
		/*String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
		cacheService.delObj(Const.CACHE_USER + uid);*/
		MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
		MyCookie.deleteCookie("sessionAdminName", request, response);
		HttpSession session = request.getSession();
		if (!MyString.isEmpty(session)) {
			//销毁session
			session.invalidate();
			/*session.removeAttribute("nickname");
			session.removeAttribute("avatarUrl");*/
		}
		return new JsonResult(1, "退出成功");
	}
	
	/**
	 * 找回密码接口
	 * @param model
	 * @return
	 * @throws MyException
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 */
	@RequestMapping("/m/resetPassword.do")
	@ResponseBody
	public JsonResult resetPass(@ModelAttribute LoginDto model)
			throws MyException, UnsupportedEncodingException, MessagingException {
		try {
			String phone = model.getPhone().trim();
			String password = model.getPassword().trim();
			if (MyString.isEmpty(password) || MyString.isEmpty(password)) {
				return new JsonResult(0, "密码不可为空");
			}
			//获取用户
			List<User> userList = (List<User>) userService.queryByHql("from User where phone='" + phone + "'",
					Tools.getMap());
			if (MyString.isEmpty(userList)) {
				return new JsonResult(0, "此手机号尚未注册");
			}
			if (userList.size()>1) {
				//账号重复
				return new JsonResult(0, "账号重复，请联系管理员");
			}
			User user = userList.get(0);
			if (user.getStatus() == -127) {
				return new JsonResult(0, "此账号已被管理员禁用，请联系管理员");
			}
			user.setPassword(MD5.encrytMD5(password));
			userService.update(user);
			return new JsonResult(1, "密码重置成功");
		} catch (Exception e) {
			model.setTipMessage(e.getMessage());
			return new JsonResult(0, "系统未知异常，请联系管理员");
		}
	}
		
	/**
	 * 图片上传
	 * @param upfile
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/m/uploadHeadImage.do")
	@ResponseBody
	public JsonResult uploadImage(@RequestParam("file") MultipartFile file,String userId,String token, HttpServletRequest request, HttpServletResponse response) {

		try{
			if(file == null || StringUtils.isEmpty(userId)){
				return new JsonResult(0, "传值异常");
			}
			if(!isLogin(userId, token, this.request)){
				return new JsonResult(999);
			}
			String basePath = config.getRootPath();//存放根路径
			String rootUrl = config.getRootUrl();//访问根路径
			String saveUrl = "";//存放在数据库的相对路径
			String resultUrl = "";//返回给前台展示的路径
			String realFileName = file.getOriginalFilename();//原名
			String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
			String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
			StringBuilder sb = new StringBuilder();
			//拼接保存路径
			sb.append(basePath).append("back/picture/mobileUser/").append(fileName);
			saveUrl = "back/picture/mobileUser/"+fileName;
			resultUrl = rootUrl+saveUrl;
			File f = new File(sb.toString());
			if(!f.exists()){
				f.getParentFile().mkdirs();
			}
			OutputStream out = new FileOutputStream(f);
			FileCopyUtils.copy(file.getInputStream(), out);
			//保存图片
			MipUser user = userService.getById(userId);
			user.setAvatarurl(saveUrl);
			userService.updateByMipUser(user);
			return new JsonResult(1, resultUrl);
		} catch (Exception e){
			return new JsonResult(0, "系统异常，请联系管理员");
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
	
	private boolean ipLimit(HttpSession session, int resc){
		String add = Utils.getIpAddr(request);// 获取当前用户的IP

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
