package com.tj720.mip.controller.tour;


import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.dto.MipTourCollectionDto;
import com.tj720.admin.dto.MipTourDto;
import com.tj720.admin.model.*;
import com.tj720.admin.service.MipTopicCollectionService;
import com.tj720.admin.service.MipTopicService;
import com.tj720.admin.service.MipTourCollectionService;
import com.tj720.admin.service.MipTourService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("tour")
public class MipTourController extends BaseController {

	@Autowired
	private MipTourService mipTourService;

	@Autowired
	private UserService userService;

	@Autowired
	private MipOrganizationService organizationService;

	@Autowired
	private MipTopicService mipTopicService;
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private MipTopicCollectionService mipTopicCollectionService;

	@Autowired
	private MipTourCollectionService mipTourCollectionService;

	/**
	 * 去列表页面
	 * @return
	 */
	@RequestMapping("/tourList")
	@AuthPassport(authority = "contentCommon")
	@ControllerAop(url="tour/tourList.do")
	public ModelAndView tourList(Model model){

		ModelAndView modelAndView =new ModelAndView("/WEB-INF/back/tour/tourList.jsp");
		String level = getLevel();
		if(level.equals("2")){
			// 查询组织机构（博物馆）的集合
			//0是文物局
			List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
			model.addAttribute("orgList", orgList);
			modelAndView.addObject("orgType", "0");
		}else{
			modelAndView.addObject("orgType", "1");
		}
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgId = user.getOrgId();
		model.addAttribute("orgId", orgId);
		return modelAndView;
	}

	@RequestMapping("/getListData.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JSONObject getListData(Model model, String name, String status, String publishOrg,
								  Integer currentPage,
								  int size){
		User user  = userService.get(Tools.getUser().getId());
		// 获取用户的组织机构
		String currentOrgId = user.getOrgId();
		String level = getLevel();
		String museumId= currentOrgId;
		List<String> orgList = null;
		if(("2").equals(level) && StringUtils.isBlank(publishOrg)){
			List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(currentOrgId), false);
			 orgList = new ArrayList<>();
			for (com.tj720.admin.model.MipOrganization org1 : sonOrg) {
				if(org1 != null) {
					orgList.add(org1.getId()+"");
				}
			}
			if(orgList == null || orgList.size() == 0) {
				orgList = null;
			}
		}else if(("1").equals(level)){
			 publishOrg = currentOrgId;
		}
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		List<MipTour>  result = mipTourService.selectMipTourList(name, status, page, publishOrg,orgList,currentOrgId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", result);
		return jsonObject;
	}

	/**
	 * 去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/goAdd")
	@AuthPassport(authority = "contentCommon")
	public String goAdd(Model model) {
		return "/WEB-INF/back/tour/tourNewadd.jsp";
	}

	@RequestMapping("/saveTour.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult saveTour (Model model,MipTour record){
		if(StringUtils.isNotBlank(record.getName())){
			User user  = userService.get(Tools.getUser().getId());
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			record.setId(IdUtils.nextId(MipTour.class));
			record.setCreatedTime(new Date());
			record.setPublishOrg(user.getOrgId());
			record.setStatus("1");
			try {
				int num  = mipTourService.insert(record);
				if(num > 0){
					return new JsonResult(1, record);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return  new JsonResult(0, "新增失败");
	}

	/**
	 * 删除导览
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteTour")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult deleteTopic(Model model, String id) {
		if(StringUtils.isNotBlank(id)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}

			MipTourDto updateTour = new MipTourDto();
			updateTour.setId(id);
			updateTour.setStatus("0");				//删除
			updateTour.setUpdateTime(new Date());
			int updateByidSelect = mipTourService.updateByPrimaryKey(updateTour);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "删除成功");
			}else {
				return new JsonResult(0, "删除失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}


	/**
	 * 去编辑页面
	 * @return
	 */
	@RequestMapping("/goEdit")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView getEditTourUrl(String id){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/tour/tour_show.jsp");
		MipTour mipTour = mipTourService.selectMipTourById(id);
		modle.addObject("tour", mipTour);
		return modle;
	}

	/**
	 * 提交审批
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/submitApproval")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult approvalTour(Model model, String id) {
		if(StringUtils.isNotBlank(id)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			MipTourDto updateTour = new MipTourDto();
			updateTour.setId(id);
			updateTour.setStatus("3");			//提交审批
			updateTour.setUpdateTime(new Date());
			int updateByidSelect = mipTourService.updateByPrimaryKey(updateTour);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "提交成功");
			}else {
				return new JsonResult(0, "提交失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}


	/**
	 * 发布、取消发表
	 * @return
	 */
	@RequestMapping("/publishTopic")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public String  publish(String id,Model model){
		if(StringUtils.isNotBlank(id)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return "未登录";
			}
			MipTour tour = mipTourService.selectMipTourById(id);
			MipTourDto updateTour = new MipTourDto();
			updateTour.setId(id);
			if("1".equals(tour.getStatus())) {
				updateTour.setStatus("2");				//发布
				updateTour.setPublishTime(new Date());
			}else if("2".equals(tour.getStatus())) {
				updateTour.setStatus("1");				//取消发布
			}
			if(StringUtils.isNotBlank(tour.getStatus())) {
				updateTour.setUpdateTime(new Date());
				int updateByKeySelect = mipTourService.updateByPrimaryKeySelective(updateTour);
				if(updateByKeySelect == 1) {
					return "success";
				}else {
					return "error";
				}
			}
		}
		return "error";

	}

	/**
	 * 去详情编辑页面
	 * @return
	 */
	@RequestMapping("/goInfoEdit")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView getInfoEditTourUrl(Model model ,String id){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/tour/tourEdit.jsp");
		MipTour mipTour = mipTourService.selectMipTourById(id);
		modle.addObject("infoTour", mipTour);
		return modle;
	}


	/**
	 * 编辑导览
	 * @param model
	 * @param updateTour
	 * @return
	 */
	@RequestMapping("/editTour")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult editTour(Model model, MipTourDto updateTour) {
		if(StringUtils.isNotBlank(updateTour.getId())) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}

			int updateByidSelect = mipTourService.updateByPrimaryKeySelective(updateTour);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "编辑成功");
			}else {
				return new JsonResult(0, "编辑失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}


	@RequestMapping("/getThemeData.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JSONObject referenceTheme(Model model, String key, String status, String museumId,
									 @RequestParam(defaultValue = "1", name = "page") Integer currentPage,
								  @RequestParam(defaultValue = "10") int size){
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		// 获取用户的组织机构
		String currentOrgId = us.getOrgId();

		List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
		List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(currentOrgId), false);
		List<String> orgList = new ArrayList<>();
		for (com.tj720.admin.model.MipOrganization org1 : sonOrg) {
			if(org1 != null) {
				orgList.add(org1.getId()+"");
			}
		}
		if(orgList == null || orgList.size() == 0) {
			orgList = null;
		}
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		List<MipTopic> listByKey = mipTopicService.getListByKey(key, status, currentOrgId, orgList, page, museumId);
		for (MipTopic mipTopic : listByKey) {
			if(currentOrgId.equals(mipTopic.getPublishOrg())) {
				mipTopic.setIsShow("1");
			}
		}JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", listByKey);
		return jsonObject;
	}

	/**
	 * 去编辑页面
	 * @return
	 */
	@RequestMapping("/goTheme")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView getThemeUrl(Model model){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/tour/referenceTheme.jsp");
		return modle;
	}

	/**
	 * 添加藏品页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/goSelectCollection")
	@AuthPassport(authority = "contentCommon")
	public String goSelectCollection(String tourId, Model model) {
		model.addAttribute("tourId", tourId);
		// 查询文物类别集合
		List<PickDto> ccList = (List<PickDto>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());
		model.addAttribute("category", ccList);

		// 查询年代集合
		String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
		List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
				Tools.getMap());
		model.addAttribute("year", ytList);

		return "/WEB-INF/back/tour/tour_collection.jsp";
	}

	/**
	 * 导览添加藏品保存
	 * @param
	 * @return
	 */
	@RequestMapping("/batchSaveCollection")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult batchSaveCollection(String tourId, String collectionIds) {
		if(StringUtils.isNotBlank(tourId) && StringUtils.isNotBlank(collectionIds)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			//MipTopic mipTopic = mipTopicService.get(topicId);
			MipTour mipTour = mipTourService.selectMipTourById(tourId);
			if(StringUtils.isNotBlank(mipTour.getId())) {
				int maxSort = mipTourCollectionService.getMaxSort(tourId);
				String[] split = collectionIds.split(",");
				List<MipTourCollection> asList = new ArrayList<>();
				int i = 1;
				for (String collectionid : split) {
					if(StringUtils.isNotBlank(collectionid)) {
						MipTourCollection collection = new MipTourCollection();
						collection.setId(UUID.randomUUID().toString().replace("-", ""));
						collection.setSort(i+maxSort);
						collection.setTourId(tourId);
						collection.setCollectionId(collectionid);
						asList.add(collection);
						i++;
					}
				}
				try {
					//批量保存
					if(asList != null && asList.size() > 0) {
						int batchSave = mipTourCollectionService.batchSave(asList);
						if(batchSave > 0) {
							return new JsonResult(1, "保存成功");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new JsonResult(0, "系统异常");
				}
			}
		}
		return new JsonResult(0, "信息错误");
	}

	/**
	 * 添加藏品页面展示数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="getSelectCollectionData")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult getSelectCollectionData(String tourId, MipTourCollectionDto search, @RequestParam(defaultValue = "1", name = "page") Integer currentPage,
											  @RequestParam(defaultValue = "10") int size) {
		LoginInfoDto user = Tools.getUser();
		if(StringUtils.isBlank(user.getId())) {		//未登录
			return new JsonResult(0, "未登录");
		}else {
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			User user2 = userService.get(user.getId());
			try {
				List<MipTourCollectionDto> collectionList = mipTourService.getCollectionList(user2.getOrgId(), tourId, search, page);
				return new JsonResult(1, collectionList, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new JsonResult(0, null, null);
	}

	/**
	 * 获取藏品图片列表
	 * @param
	 * @return
	 */
	@RequestMapping("/getCollectionList.do")
	@ResponseBody
	@AuthPassport(authority = "contentCommon")
	public JsonResult getCollectionList(String tourId) {
		if(StringUtils.isBlank(tourId)) {
			return new JsonResult(Constants.RES_FAIL, "该信息不存在");
		}
		List<MipTourCollectionDto> listByTourId = null;
		try {
			listByTourId = mipTourService.getListByTourId(tourId);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(Constants.RES_FAIL, "系统错误");
		}
		return new JsonResult(Constants.RES_SUCCESS, listByTourId);
	}

	/**
	 * 保存引用主题
	 * @param
	 * @return
	 */
	@RequestMapping("/saveTheme.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult saveTheme(Model model,String  mipTopicId){
		MipTopic mipTopic = mipTopicService.get(mipTopicId);
		MipTour mipTour = new MipTour();
		if(mipTopic != null){
			mipTour.setId(IdUtils.nextId(MipTour.class));
			mipTour.setName(mipTopic.getName());
			mipTour.setPublishOrg(mipTopic.getPublishOrg());
			mipTour.setPublishTime(mipTopic.getPublishTime());
			mipTour.setIconUrl(mipTopic.getIconUrl());
			mipTour.setLabel(mipTopic.getLabel());
			mipTour.setIntroduction(mipTopic.getIntroduction());
			mipTour.setStatus("1");
			mipTour.setCreatedTime(new Date());
		}
		int num  = mipTourService.insert(mipTour);
		if(num > 0){
			return new JsonResult(1,mipTour);
		}
		return  new JsonResult(0, "引用主题失败");
	}


	/**
	 * 去修改藏品排序页面
	 * @param tourId
	 * @return
	 */
	@RequestMapping("/goEditSort.do")
	@AuthPassport(authority = "contentCommon")
	public String goEditSort(String tourId, Model model) {
		List<MipTourCollectionDto> listByTourId = null;
		try {
			listByTourId = mipTourCollectionService.getListBytourId(tourId);
			model.addAttribute("collectionList", listByTourId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/WEB-INF/back/tour/tour_editSort.jsp";
	}

	/**
	 * 修改排序
	 * @return
	 */
	@RequestMapping("/editSequence.do")
	@ResponseBody
	@AuthPassport(authority = "contentCommon")
	public JsonResult editSequence(String id, String type) {
		MipTourCollection tourCollection = mipTourCollectionService.get(id);
		String tourId = tourCollection.getTourId();
		if(!MyString.isEmpty(tourCollection)){
			MipTourCollectionExample example = new MipTourCollectionExample();
			MipTourCollectionExample.Criteria criteria = example.createCriteria();
			criteria.andTopicIdEqualTo(tourId);
			if("up".equals(type)) {
				criteria.andSortLessThanOrEqualTo(tourCollection.getSort());
				example.setOrderByClause("sort desc");
			}else if("down".equals(type)) {
				criteria.andSortGreaterThanOrEqualTo(tourCollection.getSort());
				example.setOrderByClause("sort");
			}
			example.setSize(2);
			example.setStartPage(0);
			List<MipTourCollection> selectListByExample = mipTourCollectionService.selectByExample(example);

			if(selectListByExample != null && selectListByExample.size() > 0) {
				if(selectListByExample.size() == 1) {

				}else if(selectListByExample.size() == 2){
					Integer temp = 0;
					MipTourCollection item1 = selectListByExample.get(0);
					MipTourCollection item2 = selectListByExample.get(1);
					temp = item1.getSort();
					item1.setSort(item2.getSort());
					item2.setSort(temp);
					mipTourCollectionService.updateById(item1);
					mipTourCollectionService.updateById(item2);
				}
				return new JsonResult(Constants.RES_SUCCESS, "排序修改成功");
			}else {
				return new JsonResult(Constants.RES_FAIL, "排序修改失败");
			}
		}else{
			return new JsonResult(Constants.RES_FAIL, "该信息不存在");
		}
	}

	/**
	 * 删除藏品图片
	 * @param model
	 * @param collectionId
	 * @param tourId
	 * @return
	 */
	@RequestMapping("/deleteCollectionById.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult deleteCollectionByTopic(Model model, String collectionId,String tourId) {
		if(StringUtils.isNotBlank(collectionId)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			MipTourCollection deleteCollection = new MipTourCollection();
			deleteCollection.setCollectionId(collectionId);
			deleteCollection.setTourId(tourId);;				//删除
			int updateByidSelect = mipTourCollectionService.deleteBytourId(deleteCollection);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "删除成功");
			}else {
				return new JsonResult(0, "删除失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}


	/**
	 * 去审批页面
	 * @return
	 */
	@RequestMapping("/getApprovalUrl")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView getApprovalUrl(Model model,String tourId){
		model.addAttribute("approvalTourId",tourId);
		ModelAndView modle = new ModelAndView("/WEB-INF/back/tour/tour_approval.jsp");
		return modle;
	}

	@RequestMapping("/approvalTour.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult approvalTour(String status,String tourId){
		if(StringUtils.isNotBlank(tourId)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			MipTourDto updateTour = new MipTourDto();
			updateTour.setId(tourId);
			if(("1").equals(status)){
				updateTour.setStatus("2");
			}else if(("0").equals(status)){
				updateTour.setStatus("4");
			}
			updateTour.setUpdateTime(new Date());
			int updateByidSelect = mipTourService.updateByPrimaryKey(updateTour);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "审批成功");
			}else {
				return new JsonResult(0, "审批失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}


}
