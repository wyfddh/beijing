package com.tj720.mip.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.model.MipUserTags;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipUserTagsService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.IUserTagsService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserTags;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController{

	@Autowired
	private IUserService userService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private IUserTagsService userTagsService;
	@Autowired
	private Config config;
	@Autowired
	private MipUserTagsService mipUserTagsService;
	@Autowired
	private MipAreaService mipAreaService;
	/**
	 * 用户信息查询
	 * @return
	 */
	@RequestMapping("/getUserInfo.do")
	@ResponseBody
	public JsonResult getUserInfo(String userId,String token){
		if(!this.isLogin(userId, token, this.request)){
			return new JsonResult(999);
		}
		try {
			//获取用户信息
			User user = userService.get(userId);
			//重设用户信息
			//重设省
			Integer province = user.getProvince();
			if (province != null && province != 0) {
				MipArea mipArea = areaService.get(""+province);
				if (!MyString.isEmpty(mipArea)) {
					user.setProvinceStr(mipArea.getName());
				} else {
					user.setProvinceStr("");
				}
			} else {
				user.setProvinceStr("");
			}
			//重设市
			Integer city = user.getCity();
			if (city != null && city != 0) {
				MipArea mipArea = areaService.get(""+city);
				if (!MyString.isEmpty(mipArea)) {
					user.setCityStr(mipArea.getName());
				} else {
					user.setCityStr("");
				}
			} else {
				user.setCityStr("");
			}
			//重设县
			Integer county = user.getCounty();
			if (county != null && county != 0) {
				MipArea mipArea = areaService.get(""+county);
				if (!MyString.isEmpty(mipArea)) {
					user.setCountyStr(mipArea.getName());
				} else {
					user.setCountyStr("");
				}
			} else {
				user.setCountyStr("");
			}
			//			//重设用户标签
			//			int tags = user.getTags();
			//			if (tags != 0) {
			//				UserTags userTags = userTagsService.get(""+tags);
			//				if (!MyString.isEmpty(userTags)) {
			//					user.setUserTags(userTags.getName());
			//				} else {
			//					user.setUserTags("");
			//				}
			//			} else {
			//				user.setUserTags("");
			//			}

			String rootUrl = config.getRootUrl();
			String avatarurl = user.getAvatarUrl();
			if (StringUtils.isNotBlank(avatarurl)) {
				user.setAvatarUrl(rootUrl + avatarurl);
			}
			//获取用户标签
			List<MipUserTags> tagsList = mipUserTagsService.getUserTags();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("tagsList", tagsList);
			map.put("user", user);
			return new JsonResult(1,map);

		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}

	@RequestMapping("/getArea.do")
	@ResponseBody
	public JSONObject getArea() {
		
		
		JSONObject json = new JSONObject();
		
		JSONObject parentJson = new JSONObject();
		//省
		List<com.tj720.admin.model.MipArea> provinces = new ArrayList<com.tj720.admin.model.MipArea>();
		//市
		List<com.tj720.admin.model.MipArea> citys = new ArrayList<com.tj720.admin.model.MipArea>();
		//区
		List<com.tj720.admin.model.MipArea> areas = new ArrayList<com.tj720.admin.model.MipArea>();
		//所有数据
		List<com.tj720.admin.model.MipArea> areaList = mipAreaService.getAreaJson();
		for (com.tj720.admin.model.MipArea mipArea : areaList) {
			if (mipArea.getLevel().toString().equals("1")) {
				provinces.add(mipArea);
			} else if (mipArea.getLevel().toString().equals("2")) {
				citys.add(mipArea);
			} else {
				areas.add(mipArea);
			}
		}
		JSONObject proJson = new JSONObject();
		for (com.tj720.admin.model.MipArea mipArea : provinces) {
			proJson.put(mipArea.getId(), mipArea.getName());
		}
		parentJson.put(86, proJson);
		for (com.tj720.admin.model.MipArea mipArea : provinces) {
			JSONObject cityJson = new JSONObject();
			for (com.tj720.admin.model.MipArea city : citys) {
				if (mipArea.getId().intValue() == city.getPid().intValue()) {
					cityJson.put(city.getId(), city.getName());
				}
			}
			parentJson.put(mipArea.getId(), cityJson);
		}
		for (com.tj720.admin.model.MipArea city : citys) {
			JSONObject areaJson = new JSONObject();
			for (com.tj720.admin.model.MipArea area : areas) {
				if (city.getId().intValue() == area.getPid().intValue()) {
					areaJson.put(area.getId(), area.getName());
				}
			}
			parentJson.put(city.getId(), areaJson);
		}
		
		json.put("ChineseDistricts", parentJson);

		return json;

	}

	/**
	 * 跳转修改用户信息页面
	 */
	@RequestMapping("/toUpdateUser.do")
	@ResponseBody
	public JsonResult toUpdateUser(){
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				String uid = cacheUser.getId();
				//获取用户信息
				User user = userService.get(uid);
				//重设用户信息
				//重设省
				int province = user.getProvince();
				if (province != 0) {
					MipArea mipArea = areaService.get(""+province);
					if (!MyString.isEmpty(mipArea)) {
						user.setProvinceStr(mipArea.getName());
					} else {
						user.setProvinceStr("");
					}
				} else {
					user.setProvinceStr("");
				}
				//重设市
				int city = user.getCity();
				if (city != 0) {
					MipArea mipArea = areaService.get(""+city);
					if (!MyString.isEmpty(mipArea)) {
						user.setCityStr(mipArea.getName());
					} else {
						user.setCityStr("");
					}
				} else {
					user.setCityStr("");
				}
				//重设县
				int county = user.getCounty();
				if (county != 0) {
					MipArea mipArea = areaService.get(""+county);
					if (!MyString.isEmpty(mipArea)) {
						user.setCountyStr(mipArea.getName());
					} else {
						user.setCountyStr("");
					}
				} else {
					user.setCountyStr("");
				}
				//重设用户标签
				String tags = user.getTags();
				if (tags != null) {
					UserTags userTags = userTagsService.get(""+tags);
					if (!MyString.isEmpty(userTags)) {
						user.setUserTags(userTags.getName());
					} else {
						user.setUserTags("");
					}
				} else {
					user.setUserTags("");
				}

				//获取所有省的信息
				List<MipArea> provinceList = (List<MipArea>) areaService.queryByHql("from MipArea where status > 0 and level = 1", Tools.getMap());
				//获取所有市的信息
				List<MipArea> cityList = new ArrayList<MipArea>();
				if (province != 0) {
					cityList = (List<MipArea>) areaService.queryByHql("from MipArea where status > 0 and level = 2 and pid = " + province, Tools.getMap());
				}
				//获取所有省的信息
				List<MipArea> countyList = new ArrayList<MipArea>();
				if (city != 0) {
					countyList = (List<MipArea>) areaService.queryByHql("from MipArea where status > 0 and level = 3 and pid = " + city, Tools.getMap());
				}
				//获取用户标签的信息
				List<UserTags> userTagsList = (List<UserTags>) userTagsService.queryByHql("from UserTags where status > 0", Tools.getMap());
				map.put("user", user);
				map.put("provinceList", provinceList);
				map.put("cityList", cityList);
				map.put("countyList", countyList);
				map.put("userTagsList", userTagsList);
				return new JsonResult(1,map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}


	/**
	 * 修改用户信息
	 */
	@RequestMapping("/updateUserInfo.do")
	@ResponseBody
	public JsonResult updateUserInfo(User model,String token){
		try {
			if(!this.isLogin(model.getId(), token, this.request)){
				return new JsonResult(999);
			}

			String uid = model.getId();
			//获取用户信息
			User user = userService.get(uid);
			//修改用户昵称
			if (!MyString.isEmpty(model.getNickName())) {
				user.setNickName(model.getNickName());
			}
			//修改性别
			user.setSex(model.getSex());
			//所在省
			user.setProvince(model.getProvince());
			//所在市
			user.setCity(model.getCity());
			//所在县
			user.setCounty(model.getCounty());
			//出生日期
			user.setBirthday(StringUtils.isBlank(model.getBirthday())?null:model.getBirthday());
			//职业
			user.setJob(model.getJob());
			//用户标签
			user.setTags(model.getTags());
			//个人简介
			user.setDescription(model.getDescription());

			//保存
			userService.update(user);
			return new JsonResult(1, "修改成功");

		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}

	/**
	 * 修改用户头像
	 */
	@RequestMapping(value="/updateUserAva.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	@CrossOrigin
	public String updateUserAva(String avatarUrl,String token,String userid){
		try {
			if(!this.isLogin(userid, token, this.request)){
				return null;
				//return new JsonResult(999);
			}
			//获取用户信息
			User user = userService.get(userid);
			//修改用户头像
			if (!MyString.isEmpty(avatarUrl)) {
				user.setAvatarUrl(avatarUrl);
			}
			//保存
			userService.update(user);
			com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();			
			object.put("result",new JsonResult(1, "修改成功") );
			String str = "callback("+object.toJSONString()+")";
			return str;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return new JsonResult(new MyException("000001"));
		}
	}

	/**
	 * 级联省市县
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/sltArea.do")
	@ResponseBody
	public List<MipArea> sltArea(@RequestParam(name = "parentId") Integer id) {
		String hql = "";
		if (!MyString.isEmpty(id)) {
			hql = "from MipArea where status>0 and pid=" + id;
		}else {
			hql = "from MipArea where 1 <> 1";
		}
		List<MipArea> areaList = (List<MipArea>) areaService.queryByHql(hql,
				Tools.getMap());
		return areaList;
	}

}
