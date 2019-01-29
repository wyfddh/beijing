package com.tj720.mip.controller.mobile.myInfo;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.MipCollect;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserTags;
import com.tj720.admin.service.MipCollectService;
import com.tj720.admin.service.MipUserTagsService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MD5;
import com.tj720.mip.utils.Page;

@Controller
@RequestMapping("/m/myInfo")
public class MUserInfo extends BaseController{
	@Autowired
	private IUserService userService;
	@Autowired
	private MipCollectService mipCollectService;
	@Autowired
	private MipUserTagsService mipUserTagsService;
	@Autowired
	private Config config;
	
	/**
	 * 查询个人信息
	 * @param userID用户id
	 * @return
	 */
	@RequestMapping("/userInfo.do")
	@ResponseBody
	public JsonResult userInfo(String userID,String token) {

		if (StringUtils.isNotBlank(userID)) {
//			if(!this.isLogin(userID, token, this.request)){
//				return new JsonResult(999);
//			}
			MipUser user = userService.getById(userID);
			
			//获取用户标签
			List<MipUserTags> tagsList = mipUserTagsService.getUserTags();

			Map<String,Object> map = new HashMap<String, Object>();
			if (user == null) {
				return new JsonResult(2,"传值异常！");
			} else {
				Date birthday = user.getBirthday();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				String birth = format.format(birthday);
				user.setBirth(birth);
				String rootUrl = config.getRootUrl();
				String avatarurl = user.getAvatarurl();
				String qqOpenid = user.getQqOpenid();
				String weixinUnionid = user.getWeixinUnionid();
				//qq微信登录直接取图片
				if (StringUtils.isNotBlank(qqOpenid) || StringUtils.isNotBlank(weixinUnionid)) {
					user.setAvatarurl(avatarurl);
				}  else if (StringUtils.isNotBlank(avatarurl)) {
					user.setAvatarurl(rootUrl + avatarurl);
				}
				for (MipUserTags mipUserTags : tagsList) {
					if (user.getTags().toString().equals(mipUserTags.getId())) {
						user.setTag(mipUserTags.getName());
					}
				}
				map.put("user", user);
				map.put("tagsList", tagsList);
				return new JsonResult(1,map);
			}
		} else {
			return new JsonResult(2,"传值异常！");
		}
	}
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveInfo.do")
	@ResponseBody
	public JsonResult saveInfo(MipUser user,String token) {
		if (user != null) {
			if(!this.isLogin(user.getId(), token, this.request)){
				return new JsonResult(999);
			}
			try {
				userService.updateByMipUser(user);
				return new JsonResult(1);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(3,"系统异常！");
			}
		} else {
			return new JsonResult(2,"传值异常！");
		}
	}
	/**
	 * 校验原密码
	 * @param userID
	 * @param password
	 * @return
	 */
	@RequestMapping("/checkPassword.do")
	@ResponseBody
	public JsonResult checkPassword(String userID,String password,String token) {
		/*if(!this.isLogin(userID, token, this.request)){
			return new JsonResult(999);
		}*/
		JsonResult result = null;
		if (StringUtils.isNotBlank(password)) {

			String encrytMD5 = MD5.encrytMD5(password);
			MipUser user = userService.getById(userID);
			if (user.getPassword().equals(encrytMD5)) {
				result = new JsonResult(1); //密码正确
			} else {
				result = new JsonResult(3,"原密码不正确");//密码不正确
			}

		} else {
			result = new JsonResult(2,"传值异常");
		}


		return result;
	}
	/**
	 * 修改密码
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping("/modifyPassword.do")
	@ResponseBody
	public JsonResult modifyPassword(String userID,String password,String token) {
		if(!this.isLogin(userID, token, this.request)){
			return new JsonResult(999);
		}
		if (StringUtils.isNotBlank(password)) {
			MipUser user = userService.getById(userID);
			String encrytMD5 = MD5.encrytMD5(password);
			user.setPassword(encrytMD5);
			try {
				userService.updateByMipUser(user);
				return new JsonResult(1);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(3,"系统异常");
			}
		} else {
			return new JsonResult(2,"传值异常");
		}
	}



	/**
	 * 查询该用户的收藏
	 * @param userID
	 * type:1藏品2博物馆
	 * openPage 0不开启分页1开启
	 * @return
	 */
	@RequestMapping("/myCollects.do")
	@ResponseBody
	public JsonResult myCollects(String userID,String type,String token,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "0") int openPage) {
		if(!this.isLogin(userID, token, this.request)){
			return new JsonResult(999);
		}

		MipUser user = userService.getById(userID);
		if (user == null) {
			return new JsonResult(2,"传值异常！");
		} else {
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userID", userID);
			map.put("type", type);

			Integer count = mipCollectService.getCountColByUid(map);

			page.setAllRow(count);
			Integer start = page.getStart();
			Integer end = start + page.getSize();

			map.put("start", start);
			map.put("end", end-start);
			map.put("openPage", openPage);
			List<MipCollect> collects = null;
			if (type.equals("1")) {
				collects = mipCollectService.getColByUserID(map);
			} else if (type.equals("2")){
				collects = mipCollectService.getOrgByUserID(map);
			} else {
				return new JsonResult(2,"传值异常！");
			}
			return new JsonResult(1,collects);
		}

	}
	/**
	 * 根据用户id和藏品id删除该收藏
	 * @param userID
	 * @param collectId
	 * @return
	 */
	@RequestMapping("/delCollect.do")
	@ResponseBody
	public JsonResult delCollect(String userID,String collectID,String token) {
		if(!this.isLogin(userID, token, this.request)){
			return new JsonResult(999);
		}
		if (StringUtils.isNotBlank(collectID)) {
			Map<String,String> map = new HashMap<String, String>();
			try {
				map.put("userID", userID);
				map.put("collectID", collectID);
				mipCollectService.delCollect(map);
				return new JsonResult(1);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(3,"系统异常！");
			}
		} else {
			return new JsonResult(2,"传值异常！");
		}
	}
	/**
	 * 用户添加收藏
	 * @param userID
	 * @param collectId
	 * @param type 1藏品2博物馆
	 * @return
	 */
	@RequestMapping("/addCollect.do")
	@ResponseBody
	public JsonResult addCollect(String userID,String collectID,String type,String token) {
		if(!this.isLogin(userID, token, this.request)){
			return new JsonResult(999);
		}
		if (StringUtils.isNotBlank(collectID) && StringUtils.isNotBlank(type)) {
			MipUser user = userService.getById(userID);
			if (user != null) {
				Map<String,String> map = new HashMap<String, String>();
				map.put("userID", userID);
				map.put("collectID", collectID);
				MipCollect mipCollect = mipCollectService.getCollect(map);

				if (mipCollect == null) {
					mipCollect = new MipCollect();
					String id = IdUtils.nextId(mipCollect);
					mipCollect.setId(id);
					mipCollect.setUid(userID);
					mipCollect.setCid(collectID);
					mipCollect.setType(type);
					mipCollect.setCreatetime(new Date());
					mipCollect.setStatus((byte) 1);
					mipCollect.setSequence(0);
					try {
						mipCollectService.save(mipCollect);
						return new JsonResult(1);
					} catch (Exception e) {
						e.printStackTrace();
						return new JsonResult(3,"系统异常！");
					}
				} else {
					if (mipCollect.getStatus() == 1) {
						return new JsonResult(4,"重复收藏！");
					} else if (mipCollect.getStatus() == 0) {
						mipCollect.setStatus((byte) 1);
						mipCollect.setCreatetime(new Date());
						try {
							mipCollectService.update(mipCollect);
							return new JsonResult(1);
						} catch (Exception e) {
							return new JsonResult(3,"系统异常！");
						}
					} else {
						return new JsonResult(3,"系统异常！");
					}
				}
			} else {
				return new JsonResult(2,"传值异常！");
			}
		} else {
			return new JsonResult(2,"传值异常！");
		}
	}

}
