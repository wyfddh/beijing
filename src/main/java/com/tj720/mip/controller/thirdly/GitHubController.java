package com.tj720.mip.controller.thirdly;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.dto.thirdly.GitHubUser;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.thirdly.GitHubService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

/**
 * 前后台共用的Controller
 * @author Ehsan
 *
 */
@Controller
public class GitHubController extends BaseController<User> {
	@Autowired
	IMenuService menuService;
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private Config config;
	@Autowired
	private GitHubService githHubService;
	@Autowired
	private IUserService userService;
	
	//111
	/**
	 * gitHub授权
	 * @throws Exception
	 */
	@RequestMapping("/github/authorize.do")
	public void authorize() throws Exception {
		String authorizeUrl = "https://github.com/login/oauth/authorize?client_id=%s&state=%s";
		String state = Tools.getChar(20);
		cacheService.setStr( MyCookie.getCookie(Const.COOKIE_TOKEN, false, request) + Const.CACHE_AUTHORIZE, state, 10*60);
		response.sendRedirect(String.format(authorizeUrl, config.getClientID(), state));
	}
	@RequestMapping("/github/login.do")
	public String login(@RequestParam String code,@RequestParam String state) throws Exception {
		String myState = cacheService.getStr(MyCookie.getCookie(Const.COOKIE_TOKEN, false, request) + Const.CACHE_AUTHORIZE);
		if(myState == null || !myState.equals(state)){
			request.setAttribute("result", "非法参数，登陆失败！");
			return "WEB-INF/views/result.jsp";
		}else{
			User user = null;
			GitHubUser gitHubUser = githHubService.getUser(githHubService.getAccessToken(code, "").getAccess_token());
			List<User> users = userService.findByMap(Tools.getMap("thirdlyId",Const.GITHUB + gitHubUser.getId()), null, null);
			if(users.size() == 0){
				user = new User();
				user.setUserName(gitHubUser.getLogin());
//				user.setTrueName(gitHubUser.getName());
				/*if(!MyString.isEmpty(gitHubUser.getEmail()))
					user.setEmail(gitHubUser.getEmail());*/
				user.setPassword("");
				user.setStatus(Byte.valueOf("1"));
//				user.setType(Byte.valueOf("1"));
				user.setAvatarUrl(gitHubUser.getAvatar_url());
//				user.setThirdlyId(Const.GITHUB + gitHubUser.getId());
				userService.save(user);
			}else{
				user = users.get(0);
			}
			
			// 登陆
			LoginDto model = new LoginDto();
			model.setUserName(user.getUserName());
			model.setRemberPwd("NO");
			userService.login(model, user, request, response);
			
			response.sendRedirect("../admin.do");
		}
		return "";
	}
}
