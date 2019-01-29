package com.tj720.mip.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.inter.service.tool.ISearchService;
import com.tj720.mip.model.Setting;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.HttpPostGet;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONObject;

@Controller
public class MainController extends BaseController<User> {
	@Autowired
	IMenuService menuService;
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private ISearchService luceneService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	/**
	 * 后台管理主页面
	 */
	@RequestMapping("/admin.do")
	@AuthPassport
	public String showHomePage() throws Exception {
		return "resources/html/backHtml/index.html";
	}
	@RequestMapping("/property.do")
	@AuthPassport(authority=Const.AUTH_SETTING)
	@ResponseBody
	public JsonResult property() throws Exception {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("properties", config);
		
		// 从crapApi获取版本信息
		try{
			String crapApiInfo = 
				HttpPostGet.get("http://api.crap.cn/mock/trueExam.do?id=c107b205-c365-4050-8fa9-dbb7a38b3d11", null, null);
			JSONObject json = JSONObject.fromObject(crapApiInfo);
			if(json.getInt("success") == 1){
				json = json.getJSONObject("data");
				returnMap.put("crapApiInfo", 
						Tools.getStrMap("latestVersion", json.getString("latestVersion"),
								"latestVersion", json.getString("latestVersion"),
								"addFunction", json.getString("addFunction"),
								"updateUrl", json.getString("updateUrl"),
								"noticeUrl", json.getString("noticeUrl"),
								"notice", json.getString("notice")));
			}
			
		}catch(Exception e){
			
		}
		return new JsonResult(1, returnMap);
	}
	
	@RequestMapping("/loginOrRegister.do")
	public String loginOrRegister() throws Exception {
		return "resources/html/backHtml/loginOrRegister.html";
	}

    /**
     * 博物馆主页
     */
    @AuthPassport
    @RequestMapping("/entrance.do")
    public String entrance(ModelMap modelMap) throws IOException {
    	HttpSession session = request.getSession();
    	UserDto user = (UserDto) session.getAttribute("user");
    	modelMap.put("user", user);
    	return "/WEB-INF/back/index.jsp";
    }
	
	/**
	 * 删除错误提示
	 */
	@RequestMapping("/back/closeErrorTips.do")
	@ResponseBody
	@AuthPassport(authority = Const.AUTH_ADMIN)
	public JsonResult closeErrorTips() throws Exception {
		cacheService.delStr(Const.CACHE_ERROR_TIP);
		return new JsonResult(1, null);
	}
	
	/**
	 * 后台页面初始化
	 */
	@RequestMapping("/back/init.do")
	@ResponseBody
	@AuthPassport
	public JsonResult init(HttpServletRequest request) throws Exception {
		Map<String, String> settingMap = new HashMap<String, String>();
		for (Setting setting : cacheService.getSetting()) {
			settingMap.put(setting.getKey(), setting.getValue());
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("settingMap", settingMap);
		LoginInfoDto user = (LoginInfoDto) Tools.getUser();
		returnMap.put("sessionAdminName", user.getUserName());
		returnMap.put("sessionAdminAuthor", user.getAuthStr());
		returnMap.put("sessionAdminRoleIds", user.getRoleId());
		returnMap.put("sessionAdminId", user.getId());
		returnMap.put("errorTips", cacheService.getStr(Const.CACHE_ERROR_TIP));
		return new JsonResult(1, returnMap);
	}
	
	/**
	 * 重建索引，只有最高管理员才具有该权限
	 */
	@ResponseBody
	@RequestMapping("/back/rebuildIndex.do")
	@AuthPassport(authority=Const.SUPER)
	public JsonResult rebuildIndex() throws Exception {
		return new JsonResult(1, luceneService.rebuild());
	}
	
	/**
	 * 清除缓存，只有最高管理员才具有该权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/back/flushDB.do")
	@AuthPassport(authority=Const.SUPER)
	public JsonResult flushDb(){
		return new JsonResult(1, cacheService.flushDB());
	}
}
