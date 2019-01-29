package com.tj720.mip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.duanxin.HttpsRequest;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IAuthService;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.RoleAuth;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.service.table.UserRoleService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;
import com.tj720.mip.utils.ValidateCodeService;

/**
 * 前后台共用的Controller
 * @author Ehsan
 *
 */
@Controller
public class IndexController extends BaseController<User> {
	@Autowired
	IMenuService menuService;
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IAuthService authService;
	
	/**
	 * 
	 * @param code
	 *            需要显示的pick code
	 * @param key
	 *            可选参数：根据具体情况定义，如当为模块是，key代表父id
	 * @param radio
	 *            是否为单选
	 * @param def
	 *            默认值
	 * @param tag
	 *            保存选中结果的id
	 * @param tagName
	 *            显示名称的输入框id
	 * @param notNull
	 *            是否可以为空：当为单选，且notNull=false是，则可以选着为空
	 * @return
	 * @throws Exception
	 */
	//生成权限下拉框，修改时有回显
	@RequestMapping(value = "pick.do")
	public String pickOut(String code,@RequestParam(defaultValue = "")  String key, 
			@RequestParam(defaultValue = "true") String radio, String def,
			String tag, String tagName, String notNull) throws Exception {
		if (MyString.isEmpty(radio)) {
			radio = "true";
		}
		List<PickDto> picks = new ArrayList<PickDto>();
		String pickContent = menuService.pick(picks, radio, code, key, def, notNull);
		request.setAttribute("radio", radio);
		request.setAttribute("picks", picks);
		request.setAttribute("tag", tag);
		request.setAttribute("def", def);
		request.setAttribute("iCallBack", getParam("iCallBack", "voidFunction"));
		request.setAttribute("iCallBackParam", getParam("iCallBackParam", ""));
		request.setAttribute("tagName", tagName);
		request.setAttribute("pickContent", pickContent);
		return "WEB-INF/views/pick.jsp";
	}

	@RequestMapping("getImgCode.do")
	@ResponseBody
	public void getImgvcode() throws IOException {
		// 设置response，输出图片客户端不缓存
		response.setDateHeader("Expires", 0);
		response.addHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		ValidateCodeService vservice = new ValidateCodeService();
		String uuid = MyCookie.getCookie(Const.COOKIE_UUID, false, request);
		cacheService.setStr(Const.CACHE_IMGCODE + uuid, vservice.getCode() , 10 * 60);
		cacheService.setStr(Const.CACHE_IMGCODE_TIMES + uuid, "0" , 10 * 60);
		try {
			vservice.write(out);
			out.flush();
		} finally {
			out.close();
		}
	}

	/**
	 * 
	 * @param 跳转至指定页面
	 * @return
	 */
	@RequestMapping("go.do")
	public String go(@RequestParam String p) {
		return p;
	}
	
	/**
	 * 
	 * @param 跳转至后台登录页面
	 * @return
	 */
	@RequestMapping("toLogin.do")
	public String toLogin() {
		return "/WEB-INF/back/login/loginBJ.jsp";
	}
	
	/**
	 * 
	 * @param 跳转至首页
	 * @return
	 */
	@RequestMapping("back/index.do")
	public String toIndex() {
		// 判断用户是否登录
		// 获取用户信息
		LoginInfoDto userLoginDto = Tools.getUser();
		if (!MyString.isEmpty(userLoginDto)) {
			//有登陆
			String authStr = userLoginDto.getAuthStr();
			if (!MyString.isEmpty(authStr)) {
				if (",collectionAdmin,collectionCommon,contentAdmin,contentCommon,SystemAdmin,".contains(authStr)) {
					return "/WEB-INF/back/index.jsp";
				}else{
					return "/WEB-INF/back/errorNoAuth.jsp";
				}
			}else {
				return "/WEB-INF/back/errorNoAuth.jsp";
			}
		}else {
			//没登录
			return "/WEB-INF/back/login/login.jsp";
		}
	}
	
	/**
	 * 
	 * @param 跳转至测试页面
	 * @return
	 */
	@RequestMapping("test.do")
	public ModelAndView test() {
		ModelAndView mod = new ModelAndView("/WEB-INF/test/testClass.jsp");
		User user = new User();
		//user.setRoleName("张三");
		user.setPassword("123456");
		mod.addObject("user", user);
		mod.addObject("str", "张三");
		request.setAttribute("aaa", "qqq");
		return mod; 
	}
	
	
	@RequestMapping("toErrorNoAuth.do")
	public ModelAndView toErrorNoAuth() {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/errorNoAuth.jsp");
		return mod; 
	}
	
	@RequestMapping("toHome.do")
	@ResponseBody
	public String toHome() {
		@SuppressWarnings("unused")
		LoginInfoDto user = Tools.getUser();
		if (MyString.isEmpty(user)) {
			return "0";
		}
		return "/WEB-INF/back/index.jsp"; 
	}
	
	@RequestMapping("toCeZhan.do")
	public ModelAndView toCeZhan() {
		ModelAndView mod = new ModelAndView("/upload/jquery-publicity20151104/index.jsp");
		return mod; 
	}
	
	@RequestMapping("testDX.do")
	public void testDX(HttpServletRequest request) {
		HttpsRequest httpRequest = new HttpsRequest();
		httpRequest.sendSms("POST", "15652935152", "101100-WEB-HUAX-034433", "KTAAKDZP", request);
	}
	
}
