/** 
 * <pre>项目名称:mip 
 * 文件名称:WenChuangController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年3月28日下午5:07:48 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */
package com.tj720.mip.controller.publish;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.MipWenchuangService;
import com.tj720.mip.inter.service.table.WenChuangCategoryService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.User;
import com.tj720.mip.model.WenchuangCategory;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * <pre>
 * 项目名称：mip    
 * 类名称：WenChuangController    
 * 类描述：    
 * 创建人：caiming
 * 创建时间：2018年7月25日10:52:28
 * </pre>
 */
@Controller
@RequestMapping("wenChuang")
public class WenChuangController extends BaseController {
	@Autowired
	private MipWenchuangService wenchuangService;
	@Autowired
	private UserService userService;// 用户的service
	@Autowired
	private IMipOrganizationService mipOrganizationService;// 组织架构的service
	@Autowired
	private PictureService pictureService;// 图片表的service
	@Autowired
	private Config config;// 常量的取法
	@Autowired
	private WenChuangCategoryService categoryService;
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private MipOrganizationService organizationService;

	/**
	 * 去列表页面
	 * @return
	 */
	@RequestMapping("goList")
	@AuthPassport(authority = "SystemAdmin")
	@ControllerAop(url="wenChuang/goList.do")
	public String goList(Model model) throws MyException {
		@SuppressWarnings("unchecked")
		List<WenchuangCategory> categoryList = (List<WenchuangCategory>) categoryService
				.queryByHql(" from WenchuangCategory ", Tools.getMap());
		model.addAttribute("categoryList", categoryList);
		
		String level = getLevel();//1:博物馆2：文物局
		model.addAttribute("level", level);
		
		
		//可查询的机构列表
		LoginInfoDto userDto = Tools.getUser();
        User user = userService.get(userDto.getId());
		List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
		List<com.tj720.admin.model.MipOrganization> sonOrg = null;
		if("0".equals(user.getOrgId())) {	//超级管理员
			sonOrg = allByProvince;	
		}else {
			sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(user.getOrgId()), true);
		}
    	List<com.tj720.admin.model.MipOrganization> orgList = new ArrayList<>();
    	for (com.tj720.admin.model.MipOrganization org : sonOrg) {
    		if(org != null) {
    			orgList.add(org);
    		}
		}
    	if(orgList == null || orgList.size() == 0) {
    		orgList = new ArrayList<>();
    	}
    	model.addAttribute("orgId", user.getOrgId());
    	model.addAttribute("orgList", orgList);
		return "/WEB-INF/back/publish/WenChuangList.jsp";
	}
	
	/**
	 * 去新增页面
	 * @return
	 */
	@RequestMapping("goAdd")
	@AuthPassport(authority = "SystemAdmin")
	public String goAdd(Model model) throws MyException {
		@SuppressWarnings("unchecked")
		List<WenchuangCategory> categoryList = (List<WenchuangCategory>) categoryService
				.queryByHql(" from WenchuangCategory ", Tools.getMap());
		model.addAttribute("categoryList", categoryList);
		return "/WEB-INF/back/publish/WenChuangAdd.jsp";
	}

	/**
	 * 去修改页面
	 * @return
	 */
	@RequestMapping("goEdit")
	@AuthPassport(authority = "SystemAdmin")
	public String goEdit(String id, Model model) throws MyException {
		MipWenchuang mipWenchuang = wenchuangService.get(id);
		if(!StringUtils.isBlank(mipWenchuang.getPictureId())) {
			model.addAttribute("titleImg", config.getRootUrl() + mipWenchuang.getPictureId());
		}
		model.addAttribute("wenchuang", mipWenchuang);
		
		@SuppressWarnings("unchecked")
		List<WenchuangCategory> categoryList = (List<WenchuangCategory>) categoryService
				.queryByHql(" from WenchuangCategory ", Tools.getMap());
		model.addAttribute("categoryList", categoryList);
		return "/WEB-INF/back/publish/WenChuangEdit.jsp";
	}
	
	/**
	 * 获取列表数据
	 * @return
	 */
	@RequestMapping("getListData")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getListData(@RequestParam(required=false)String staPrice, @RequestParam(required=false)String overPrice, @RequestParam(required=false)String orgId, @RequestParam(required=false)String publish, 
			@RequestParam(required=false)String categoryId, @RequestParam(required=false)String key, 
			@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage) throws MyException {
		LoginInfoDto userDto = Tools.getUser();
        User user = userService.get(userDto.getId());
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
		List<com.tj720.admin.model.MipOrganization> sonOrg = null;
		if("0".equals(user.getOrgId())) {	//超级管理员
			sonOrg = allByProvince;	
		}else {
			sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(user.getOrgId()), true);
		}
    	List<String> orgList = new ArrayList<>();
    	for (com.tj720.admin.model.MipOrganization org : sonOrg) {
    		if(org != null) {
    			orgList.add(org.getId()+"");
    		}
		}
    	if(orgList == null || orgList.size() == 0) {
    		orgList = null;
    	}
    	List<MipWenchuang> list = wenchuangService.getList(key, publish, categoryId, staPrice, overPrice, orgId, orgList, page, user.getOrgId());
		
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", list);
		return jsonObject;
	}

	/**
	 * 保存或修改
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult save(@ModelAttribute MipWenchuang wenchuang) throws MyException {
		LoginInfoDto userDto = Tools.getUser();
		if(StringUtils.isBlank(userDto.getId())) {
			return new JsonResult(0, "未登录", 0, null);
		}
        User user = userService.get(userDto.getId());
        if(StringUtils.isBlank(user.getId())) {
			return new JsonResult(0, "未登录", 0, null);
		}
        MipWenchuang model = null;
        if(StringUtils.isBlank(wenchuang.getId())) {
        	//新增
        	wenchuang.setPublish((byte) 0);
			wenchuang.setUserId(user.getId());
			wenchuang.setOrgId(Integer.valueOf(user.getOrgId()));
			wenchuang.setPublishTime((long) 0);
			wenchuang.setCreateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
			wenchuangService.save(wenchuang);
			return new JsonResult(1, "保存成功", 0, null);
        }else {
        	//修改
        	model = wenchuangService.get(wenchuang.getId());
        	if("0".equals(model.getPublish()+"")) {
        		wenchuang.setPublish(model.getPublish());
				wenchuang.setUserId(model.getUserId());
				wenchuang.setOrgId(model.getOrgId());
				wenchuang.setCreateTime(model.getCreateTime());
				wenchuang.setPublishTime((long) 0);
				wenchuangService.update(wenchuang);
				return new JsonResult(1, "修改成功", 0, null);
        	}
        }
		return new JsonResult(0, "系统异常");
	}
	

	/**
	 * 删除
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult delete(String id) throws MyException {
		LoginInfoDto userDto = Tools.getUser();
		if(StringUtils.isBlank(userDto.getId())) {
			return new JsonResult(0, "未登录", 0, null);
		}
        User user = userService.get(userDto.getId());
        if(StringUtils.isBlank(user.getId())) {
			return new JsonResult(0, "未登录", 0, null);
		}
        MipWenchuang model = null;
        if(StringUtils.isBlank(id)) {
			return new JsonResult(0, "数据异常", 0, null);
        }else {
        	model = wenchuangService.get(id);
        	if(model.getPublish()==0) {
        		wenchuangService.delete(model);
				return new JsonResult(1, "删除成功", 0, null);
        	}
        }
		return new JsonResult(0, "系统异常");
	}
	
	// 发布跟取消发布
	@RequestMapping("updatePublish")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult updatePublish(HttpServletRequest request,@ModelAttribute MipWenchuang wenchuang) {
		MipWenchuang model = null;
		if (!MyString.isEmpty(wenchuang.getId())) {
			if (!wenchuang.getId().equals(Const.NULL_ID)) {
				model = wenchuangService.get(wenchuang.getId());
				if (model.getPublish() == 0) {
					model.setPublish((byte) 1);
					model.setPublishTime(new Date().getTime() / 1000);
					try {
						wenchuangService.update(model);
						return new JsonResult(1, "发布成功", 0, null);
					} catch (Exception e) {
						e.printStackTrace();
						return new JsonResult(0, "系统异常");
					}
				} else if (model.getPublish() == 1) {
					model.setPublish((byte) 0);
					model.setPublishTime((long) 0);
					try {
						wenchuangService.update(model);
						return new JsonResult(1, "取消发布成功", 0, null);
					} catch (Exception e) {
						e.printStackTrace();
						return new JsonResult(0, "系统异常");
					}
				}
			}
		}
		return new JsonResult(0, "系统异常");
	}
	
	/**
	 * （接口）获取列表数据
	 * @return
	 */
	@RequestMapping("getList")
	@ResponseBody
	public JsonResult getList(@RequestParam(required=false)String orgId, @RequestParam(defaultValue="12") int size, @RequestParam(defaultValue="1") int currentPage) throws MyException {
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
    	List<MipWenchuang> list = wenchuangService.getList(null, "1", null, null, null, orgId, null, page, null);
    	for (MipWenchuang mipWenchuang : list) {
			if(!StringUtils.isBlank(mipWenchuang.getPictureId())) {
				mipWenchuang.setPictureId(config.getRootUrl() + mipWenchuang.getPictureId());
			}
		}
		return new JsonResult(1, list, page);
	}

	/**
	 * （接口）文创详情
	 * @return
	 */
	@RequestMapping("getWenchuang")
	@ResponseBody
	public JsonResult getWenchuang(String id) throws MyException {
		MipWenchuang mipWenchuang = wenchuangService.get(id);
		if(!StringUtils.isBlank(mipWenchuang.getPictureId())) {
			mipWenchuang.setPictureId(config.getRootUrl() + mipWenchuang.getPictureId());
		}
		WenchuangCategory category = categoryService.get(mipWenchuang.getCategoryId()+"");
		if(category != null && StringUtils.isNotBlank(category.getCategoryName())) {
			mipWenchuang.setCategoryName(category.getCategoryName());
		}else {
			mipWenchuang.setCategoryName("无");
		}
		MipOrganization organization = mipOrganizationService.get(mipWenchuang.getOrgId()+"");
		if(organization != null) {
			mipWenchuang.setNickName(organization.getName());
		}
		
		//相关博物馆（根据分类，查找其他文创10个）
		List<MipWenchuang> releList = wenchuangService.getReleList(id, mipWenchuang.getCategoryId()+"", 10);
		for (MipWenchuang wenchuang : releList) {
			if(!StringUtils.isBlank(wenchuang.getPictureId())) {
				wenchuang.setPictureId(config.getRootUrl() + wenchuang.getPictureId());
			}
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("detail", mipWenchuang);
		result.put("other", releList);
		
		return new JsonResult(1, result);
	}
}
