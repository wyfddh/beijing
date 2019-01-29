package com.tj720.mip.controller.thirdly;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.StringUtil;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.tj720.admin.common.util.FileUtil;
import com.tj720.admin.dao.map.MipUserMapper;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
public class MqqloginController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private MipUserMapper mipUserMapper;

	@RequestMapping("/qq.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	@RequestMapping("/afterlogin.do")
	public String afterlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    try {
	        AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
	        String accessToken   = null,
	               openID        = null;
	        //long tokenExpireIn = 0L;
	        if (accessTokenObj.getAccessToken().equals("")) {
	            System.out.print("没有获取到响应参数");
	        }else{
	            accessToken = accessTokenObj.getAccessToken();
	            //tokenExpireIn = accessTokenObj.getExpireIn();
	            OpenID openIDObj =  new OpenID(accessToken);
	            openID = openIDObj.getUserOpenID();
	            UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
	            UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
	            String name = userInfoBean.getNickname();
	            System.out.println(openID);
	           System.out.println("欢迎你，" + name + "!");
	           com.tj720.mip.model.User user = null;
	           List<com.tj720.mip.model.User> users = userService.findByMap(Tools.getMap("qqOpenid",Const.QQ + openID), null, null);
				if(users.size() == 0){
					user = new com.tj720.mip.model.User();
					user.setUserName(userInfoBean.getNickname());
					user.setNickName(userInfoBean.getNickname());
					user.setPassword("");
					user.setStatus(Byte.valueOf("1"));
					user.setSex("男".equals(userInfoBean.getGender())?(byte)1:(byte)0);
					user.setAvatarUrl(userInfoBean.getAvatar().getAvatarURL50());
					user.setQqOpenid(Const.QQ + openID);
					userService.save(user);
				}else{
					user = users.get(0);
					//更新登录时间
					Long currentTimeMillis = System.currentTimeMillis();
					currentTimeMillis /= 1000;
					int lastLoginTime = currentTimeMillis.intValue();
					MipUser muser = new MipUser();
						muser.setId(user.getId());
						muser.setLastLoginTime(lastLoginTime);
					mipUserMapper.updateByPrimaryKeySelective(muser);
				}
				// 登陆
				LoginDto model = new LoginDto();
				model.setUserName(user.getUserName());
				model.setRemberPwd("NO");
				userService.login(model, user, request, response);
				
				HttpSession session = request.getSession();
				session.setAttribute("userqq", user);
				
				JedisService.set(user.getQqOpenid(), JSON.toJSONString(user));
				/*String configValue = FileUtil.getConfigValue("thirdly.phone");
				if("1".equals(configValue)&&StringUtil.isEmpty(user.getPhone())) {
					return "redirect:/jilin2/index.html#/register_three?qqlogin="+user.getQqOpenid();
				}else {
					return "redirect:/jilin2/index.html#/home?qqlogin="+user.getQqOpenid();
				}*/
				//String url = "http://192.168.137.1:8081/#/index?qqlogin="+user.getQqOpenid();
				String url = "http://123.56.50.236/#/index?qqlogin="+user.getQqOpenid();
				response.sendRedirect(url);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return null;
	}

/**
 * web回掉登陆
 * @param req
 * @param resp
 * @throws Exception
 */
@RequestMapping("/qqIsLogin.do")
@ResponseBody
public JsonResult wxauthoLogin(HttpServletRequest req, HttpServletResponse resp,String key)throws Exception{
	System.out.println("---------------qq回掉登陆------------key="+key);
	String jsonStr = JedisService.get(key);
	if(!MyString.isEmpty(jsonStr)) {
		return new JsonResult(1, JSON.parse(jsonStr));
	}
	return new JsonResult(0, jsonStr);
}
}
