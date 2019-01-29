package com.tj720.mip.controller.publish;

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
import com.tj720.admin.service.MipCollectService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

@Controller
@RequestMapping("/publish")
public class CollectController extends BaseController{

	@Autowired
	private IUserService userService;
	@Autowired
	private MipCollectService mipCollectService;
	@Autowired
	private Config config;

	/**
	 * 查询该用户的收藏
	 * @param userID
	 * @return
	 */
	@RequestMapping("/myCollects.do")
	@ResponseBody
	public JsonResult myCollects(String userID,String type,String token,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "0") int openPage) {
		/*if(!this.isLogin(userID, token, this.request)){
			return new JsonResult(999);
		}*/

		MipUser user = userService.getById(userID);
		if (user == null) {
			return new JsonResult(2,"传值异常！");
		} else {
			String rootUrl = config.getRootUrl();
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
			//1藏品2博物馆
			if (type.equals("1")) {
				collects = mipCollectService.getColByUserID(map);
				for (MipCollect mipCollect : collects) {
					mipCollect.setPicUrl(rootUrl + mipCollect.getPicUrl());
				}
			} else if (type.equals("2")) {
				collects = mipCollectService.getOrgByUserID(map);
				for (MipCollect mipCollect : collects) {
					mipCollect.setPicUrl(rootUrl + mipCollect.getPicUrl());
					String orgLevel = mipCollect.getOrgLevel();
					if (orgLevel.equals("1")) {
						mipCollect.setOrgLevel("一级");
					} else if (orgLevel.equals("2")) {
						mipCollect.setOrgLevel("二级");
					} else if (orgLevel.equals("3")) {
						mipCollect.setOrgLevel("三级");
					} else {
						mipCollect.setOrgLevel("其他级别");
					}
				}
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
