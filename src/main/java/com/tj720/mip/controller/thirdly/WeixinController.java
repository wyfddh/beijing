package com.tj720.mip.controller.thirdly;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.constant.Constants;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.thirdly.WeixinService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.AuthUtil;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONObject;


@Controller
public class WeixinController extends BaseController<User> {
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	
	@Autowired
	private WeixinService weixinService;
	
	
	/**
	 * PC微信授权
	 * @throws Exception
	 */
	@RequestMapping("/pcLogin.do")
	public void pcLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String backUrl = "http://test.tj720.com/admin/m/wxCallBack.do";
//		String backUrl = "http://demo.net.tj720.com/mip/pcCallBack.do";
		String aa = URLEncoder.encode(backUrl) ;
		String url = "https://open.weixin.qq.com/connect/qrconnect?appid="+AuthUtil.APPID
				+ "&redirect_uri="+aa
				+ "&response_type=code"
				+ "&scope=snsapi_login"
				+ "&state=STATE#wechat_redirect";
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.sendRedirect(url);
	}

	/**
	 * 移动端微信授权
	 * @throws Exception
	 */
	@RequestMapping("/m/wxLogin.do")
	public String  authorize(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		String backUrl = "http://test.tj720.com/mip/wxCallBack.do";
		String backUrl = "http://test.tj720.com/admin/wxCallBack.do";
		String strUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
				+ "&redirect_uri="+URLEncoder.encode(backUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.sendRedirect(strUrl);
		return null;
	}
	
	@RequestMapping("/ownerCheck.do")
	public void ownerCheck(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
	boolean isGet = request.getMethod().toLowerCase().equals("get");
	PrintWriter print;
	if (isGet) {
	 // 微信加密签名
	 String signature = request.getParameter("signature");
	 // 时间戳
	 String timestamp = request.getParameter("timestamp");
	 // 随机数
	 String nonce = request.getParameter("nonce");
	 // 随机字符串
	 String echostr = request.getParameter("echostr");
	 // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
	 if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
	 try {
	  print = response.getWriter();
	  print.write(echostr);
	  print.flush();
	 } catch (IOException e) {
	  e.printStackTrace();
	 }
	 }
	}
	}
	
	/**
	 * 微信回调函数
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/wxCallBack.do")
	public String wxCallBack(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		LoginDto model = new LoginDto();
		String code = req.getParameter("code");
		System.out.print("------------进入回调函数前-----------code="+code);
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
				+ "&secret="+AuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		System.out.print("------------调用微信access_token接口后-----------access_token="+token);
		
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println("--------------获取用户信息-------------userinfo="+userInfo);
		try {
			String nickname = userInfo.getString("nickname");
			String headimgurl = userInfo.getString("headimgurl");
			User user = null;
			List<User> userList = null;
			userList = userService.findByMap(
					Tools.getMap("weixinUnionid", openid), null, null);
			if(userList.size() == 0){
				user = new User();
				user.setWeixinUnionid(openid);//设置微信的openid
				user.setAvatarUrl(headimgurl);//头像路径
				user.setNickName(nickname);//昵称
				user = userService.save(user);//保存
			}else{
				user = userList.get(0);
			}
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			model.setSessionAdminName(user.getNickName());
			model.setHeadimgurl(user.getAvatarUrl());
			model.setId(user.getId());
			userService.login(model, user, request, response);
			JedisService.set(user.getWeixinUnionid(), JSON.toJSONString(user));
			System.out.println("---------调用回调函数后----------user="+ JSON.toJSONString(user));
			System.out.println(jsonObject.fromObject(new JsonResult(1, model)).toString());
			
			String redirectUrl = "http://test.tj720.com/#/index?wxlogin="+user.getWeixinUnionid();
			response.sendRedirect(redirectUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return "系统异常，请联系管理员！";
		}
		return null;
	}
	
	/**
	 * web回掉登陆
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/wxIsLogin.do")
	@ResponseBody
	public JsonResult wxauthoLogin(HttpServletRequest req, HttpServletResponse resp,String key)throws Exception{
		/*HttpSession session = req.getSession();
		User user = (User) session.getAttribute("userwx");*/
		System.out.println("---------------web回掉登陆------------key="+key);
		String jsonStr = JedisService.get(key);
		if(!MyString.isEmpty(jsonStr)){
			return new JsonResult(1, JSON.parse(jsonStr));
		}
		return new JsonResult(0, JSON.parse(jsonStr));
	}
	
	/**
	 * PC微信回调函数
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/pcCallBack.do")
	public String pcCallBack(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		LoginDto model = new LoginDto();
		String code = req.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
				+ "&secret="+AuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println(userInfo);
		try {
			String nickname = userInfo.getString("nickname");
			String headimgurl = userInfo.getString("headimgurl");
			User user = new User();
			user.setWeixinUnionid(openid);//设置微信的openid
			user.setAvatarUrl(headimgurl);//头像路径
			user.setNickName(nickname);//昵称
			userService.save(user);//保存
			MyCookie.addCookie("sessionAdminName", nickname, response);
			MyCookie.addCookie("headimgurl", user.getAvatarUrl(), response);
			HttpSession session = req.getSession();
			UserDto userDto = new UserDto();
			userDto.setNickname(nickname);
			userDto.setAvatarUrl(headimgurl);
			session.setAttribute("user", userDto);
			model.setSessionAdminName(user.getNickName());
			model.setHeadimgurl(user.getAvatarUrl());
			System.out.println(jsonObject.fromObject(new JsonResult(1, model)).toString());
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			return "系统异常，请联系管理员！";
		}
	}
	
	/**
	 * web端微信授权
	 * @param jsoncallback
	 * @param url
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wxJsAuth.do")
	public void wxJsAuth(String jsoncallback, String url
			, HttpServletRequest request
			, HttpServletResponse response){
		ServletOutputStream sos = null;
		try {
			Map<String, String> map = new HashMap<String, String>();
	        weixinService.wxWebAuth(map, url);
			response.setContentType("text/html; charset=utf-8");
			sos = response.getOutputStream();
			String content = JSON.toJSONString(map);
			//content = jsoncallback + "(" + content + ")";
			sos.write(content.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sos != null){
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * web端微信授权（语音合成）
	 * @param jsoncallback
	 * @param url
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/audioCompose.do")
	public void audioCompose(String jsoncallback, String[] ids, String collectionId
			, HttpServletRequest request
			, HttpServletResponse response){
		ServletOutputStream sos = null;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if(StringUtils.isBlank(collectionId)){
				map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_PARAM_ISNULL);
			} else {
				//语音合成
				List<String> idList = Arrays.asList(ids);
		        weixinService.audioCompose(map, idList, collectionId);
			}
			response.setContentType("text/html; charset=utf-8");
			sos = response.getOutputStream();
			String content = JSON.toJSONString(map);
			//content = jsoncallback + "(" + content + ")";
			sos.write(content.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sos != null){
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
