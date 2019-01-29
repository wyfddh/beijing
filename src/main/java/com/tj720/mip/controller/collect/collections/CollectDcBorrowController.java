package com.tj720.mip.controller.collect.collections;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.dto.PictureSimpleDto;
import com.tj720.admin.model.DcBorrow;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.service.DcBorrowService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.admin.service.PictureService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.YearTypeDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 馆际交流
 * @author Administrator
 *
 */
@RequestMapping("/collectDcBorrow")
@Controller
public class CollectDcBorrowController extends BaseController{

	@Autowired
	private MipYearTypeService mipYearTypeService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipCollectionCategoryService mipCollectionCategoryService;
	@Autowired
	private Config config;
	@Autowired
	private DcBorrowService dcBorrowService;
	@Autowired
	private IMipUserService mipUserService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private IUserService userService;


	@RequestMapping("/list.do")
	@AuthPassport
	public String list(Model model) {

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization organization = mipOrganizationService.getOrganization(Integer.parseInt(orgId));
		//查询博物馆集合
		List<MipOrganization> musList;
		if (organization.getOrgTypeId().equals("3")) {
			musList = new ArrayList<MipOrganization>();
			musList.add(organization);
		} else {
			musList = mipOrganizationService.getMuseumList();
		}

		model.addAttribute("musList", musList);

		// 查询年代集合
		List<YearTypeDto> ytList = mipYearTypeService.yearTypeList();
		model.addAttribute("ytList", ytList);
		//查询文物类别
		List<CollectionCategoryDto> ccList = mipCollectionCategoryService.collectionCategoryList(1);
		model.addAttribute("ccList", ccList);
		//查询化石类别
		List<CollectionCategoryDto> ccList1 = mipCollectionCategoryService.collectionCategoryList(2);
		model.addAttribute("ccList1", ccList1);
		return "/WEB-INF/back/collect/collections/collectDcBorrowList.jsp";
	}


	@RequestMapping("/dataList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getCuration(
			@ModelAttribute DcBorrow borrow,
			String key,String gsNo,
			@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size
			){

		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		//类别
		int ctype = "2".equals(borrow.getCollectionType())?0:1;
		List<CollectionCategoryDto> ccList = mipCollectionCategoryService.collectionCategoryList(ctype);
		// 查询年代集合
		List<YearTypeDto> ytList = mipYearTypeService.yearTypeList();
		//查询博物馆集合
		List<MipOrganization> musList = mipOrganizationService.getMuseumList();
		//查询条件
		if (StringUtils.isNotBlank(key)) {
			borrow.setCollectionName(key);
		}
		if (StringUtils.isNotBlank(gsNo)) {
			borrow.setGsNo(gsNo);
		}
		//查询所有公开文物
		List<DcBorrow> listDcBorrow = dcBorrowService.listDcBorrow(borrow,page);
		for(DcBorrow info : listDcBorrow) {
			PictureSimpleDto findPictureUrl = pictureService.findPictureUrl(info.getPictureIds());
			if(findPictureUrl != null) {
				info.setPictureIds(findPictureUrl.getPicUrl());
			}
			if (ccList.size() > 0) {
				for (CollectionCategoryDto collectionCategoryDto : ccList) {
					if (info.getWenwuType().equals(collectionCategoryDto.getId())) {
						info.setWenwuType(collectionCategoryDto.getName());
					}
				}
			}
			if (ytList.size() > 0) {
				for (YearTypeDto yearTypeDto : ytList) {
					if (info.getYear().equals(yearTypeDto.getId())) {
						info.setYear(yearTypeDto.getName());
					}
				}
			}
			if (musList.size() > 0) {
				for (MipOrganization mipOrganization : musList) {
					if (info.getCollectionUnit().equals(mipOrganization.getId())) {
						info.setCollectionUnit(mipOrganization.getName());
					}
				}
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", listDcBorrow);
		return jsonObject;
	}
}
