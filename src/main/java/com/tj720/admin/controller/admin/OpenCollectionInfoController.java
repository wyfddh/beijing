package com.tj720.admin.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.dto.PictureSimpleDto;
import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipOpenCollectionInfoService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.admin.service.PictureService;
import com.tj720.mip.dto.YearTypeDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 藏品公开库
 * @author Administrator
 *
 */
@RequestMapping("/collectionInfo")
@Controller
public class OpenCollectionInfoController extends BaseController{
	
	@Autowired
	private MipYearTypeService mipYearTypeService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipCollectionCategoryService mipCollectionCategoryService;
	@Autowired
	private Config config;
	@Autowired
	private MipOpenCollectionInfoService mipOpenCollectionInfoService;
	@Autowired
	private IMipUserService mipUserService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/info.do")
	@ResponseBody
	public ModelAndView getCuration(
			@ModelAttribute MipOpenCollectionInfo openCollectionInfo,
			String key,String area,String keyType,
			@RequestParam(defaultValue="1" ,name="page") Integer currentPage,
			@RequestParam(defaultValue = "20") int size
			){
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/open/openlist.jsp");
		// 查询年代集合
		List<YearTypeDto> yearTypeList = mipYearTypeService.yearTypeList();
		mod.addObject("ytList", yearTypeList);
		//查询博物馆集合
		List<MipOrganization> museums = mipOrganizationService.getListByPlatformId(config.getPlatformId());
		mod.addObject("museums", museums);
		String userId = Tools.getUser().getId();
		User user = userService.get(userId);
		byte level =1;
		List<MipOrganization> cityList = new ArrayList<MipOrganization>();
		List<MipOrganization> mesuemList = new ArrayList<MipOrganization>();
		MipUser mipUser = mipUserService.getUser(userId);
		MipOrganization mipOrganization = new MipOrganization();
		if (!MyString.isEmpty(mipUser.getOrgId())) {
			mipOrganization = mipOrganizationService.getOrganization(Integer.parseInt(mipUser.getOrgId()));
//			if(mipOrganization!=null){
//				level = mipOrganization.getLevel();
//			}
//			if(level==1){
//				cityList = mipOrganizationService.getCityList(mipOrganization.getId());
//				if(!MyString.isEmpty(area)){
//					mesuemList = mipOrganizationService.getCityList(Integer.parseInt(area));
//				}
//			}else if(level==2){
//				mesuemList = mipOrganizationService.getCityList(mipOrganization.getId());
//			}
			cityList = mipOrganizationService.getListByLevel((byte)2);
			if(!MyString.isEmpty(area)){
				mesuemList = mipOrganizationService.getCityList(Integer.parseInt(area));
			}
		}
		mod.addObject("cityList", cityList);
		mod.addObject("musList", mesuemList);
		//文物类别
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		int ctype = "1".equals(openCollectionInfo.getCollectionType())?0:1;
		List<CollectionCategoryDto> ccList = mipCollectionCategoryService.collectionCategoryList(ctype);
		mod.addObject("ccList", ccList);
		//查询条件
		if(keyType == null || "0".equals(keyType)) {
			openCollectionInfo.setName(key);
		}else if("3".equals(keyType)) {
			openCollectionInfo.setGsNo(key);
		}
		//查询所有公开文物
		List<MipOpenCollectionInfo> listCollectionInfo = mipOpenCollectionInfoService.listCollectionInfo(openCollectionInfo,page,user.getOrgId());
		for(MipOpenCollectionInfo info : listCollectionInfo) {
			PictureSimpleDto findPictureUrl = pictureService.findPictureUrl(info.getPictureIds());
			info.setPictureIds(findPictureUrl.getPicUrl());
		}
		mod.addObject("listCollectionInfo", listCollectionInfo);
		mod.addObject("page", page);
		mod.addObject("openCollectionInfo",openCollectionInfo);
		mod.addObject("key",key);
		mod.addObject("keyType",keyType);
		mod.addObject("area",area);
		return mod;
	}
}
