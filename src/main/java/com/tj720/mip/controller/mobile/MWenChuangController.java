/** 
 * <pre>项目名称:mip 
 * 文件名称:WenChuangController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年3月28日下午5:07:48 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */
package com.tj720.mip.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.MipWenchuangService;
import com.tj720.mip.inter.service.table.WenChuangCategoryService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.WenchuangCategory;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

/**
 * 文创移动端接口
 * @author Caim
 *
 */
@Controller
@RequestMapping("m/wenChuang")
public class MWenChuangController extends BaseController {
	@Autowired
	private MipWenchuangService wenchuangService;
	@Autowired
	private Config config;// 常量的取法
	@Autowired
	private WenChuangCategoryService categoryService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;// 组织架构的service

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
		if(category != null) {
			mipWenchuang.setCategoryName(category.getCategoryName());
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
