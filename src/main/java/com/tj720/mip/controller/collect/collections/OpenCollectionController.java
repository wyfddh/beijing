package com.tj720.mip.controller.collect.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoMapper;
import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.dto.PictureSimpleDto;
import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfoApproval;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStatic;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.DcBorrowService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipOpenCollectionInfoService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.admin.service.PictureService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.dto.YearTypeDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 藏品公开库
 * @author Administrator
 *
 */
@RequestMapping("/openCollection")
@Controller
public class OpenCollectionController extends BaseController{
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private MipOpenCulturalrelicInfoMapper mipOpenCulturalrelicInfoMapper;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	


	@Autowired
	private MipYearTypeService mipYearTypeService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private com.tj720.mip.inter.service.table.IMipOrganizationService mipOrganizationService1;
	@Autowired
	private MipOrganizationService organizationService;
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
	private IPictureService ipictureService;
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MipOpenCulturalrelicInfoApprovalService mipOpenCulturalrelicInfoApprovalService;

	@Autowired 
	DcBorrowService dcBorrowService;


	@RequestMapping("/list.do")
	@AuthPassport
	public String list(Model model) {

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization mipOrganization = mipOrganizationService.getOrganization(Integer.valueOf(orgId));
		String level = mipOrganization.getOrgTypeId();
		model.addAttribute("level", level);
		model.addAttribute("orgId", mipOrganization.getName());
		// 查询组织机构（博物馆）的集合
		List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();																
		List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
		model.addAttribute("musList", sonOrg);


		// 查询年代集合
		List<YearTypeDto> ytList = mipYearTypeService.yearTypeList();
		model.addAttribute("ytList", ytList);
		//查询文物类别
		List<CollectionCategoryDto> ccList = mipCollectionCategoryService.collectionCategoryList(1);
		model.addAttribute("ccList", ccList);
		//查询化石类别
		List<CollectionCategoryDto> ccList1 = mipCollectionCategoryService.collectionCategoryList(2);
		model.addAttribute("ccList1", ccList1);
		return "/WEB-INF/back/collect/collections/openCollectionsList.jsp";
	}
	
	/**
	 * 查看页面
	 * 
	 * @param mocli
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toShowStatic.do")
	@AuthPassport
	public ModelAndView toShowStatic(@ModelAttribute com.tj720.admin.model.MipOpenCollectionInfo collection) {
		try {
			// 根据id查询藏品信息
			JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.getOpenDetail(collection.getId());
			if(jsonResult.getSuccess() == 1){
				collection = (com.tj720.admin.model.MipOpenCollectionInfo) jsonResult.getData();
				if(collection.getCollectionType().equals("1")){
					return new ModelAndView("redirect:/collectionsFossil/toShow4Open.do?id="+collection.getId());
				}else{
					return new ModelAndView("redirect:/collections/toShow4Open.do?id="+collection.getId());
				}
			}else{
				return new ModelAndView("/WEB-INF/back/error.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
	}
	
	@RequestMapping("/publicList.do")
	@AuthPassport
	public String publicList(Model model) {

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization mipOrganization = mipOrganizationService.getOrganization(Integer.valueOf(orgId));
		String level = mipOrganization.getOrgTypeId();
		model.addAttribute("level", level);
		model.addAttribute("orgId", mipOrganization.getName());
		// 查询组织机构（博物馆）的集合
		List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();																
		List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
		model.addAttribute("musList", sonOrg);


		// 查询年代集合
		List<YearTypeDto> ytList = mipYearTypeService.yearTypeList();
		model.addAttribute("ytList", ytList);
		//查询文物类别
		List<CollectionCategoryDto> ccList = mipCollectionCategoryService.collectionCategoryList(1);
		model.addAttribute("ccList", ccList);
		//查询化石类别
		List<CollectionCategoryDto> ccList1 = mipCollectionCategoryService.collectionCategoryList(2);
		model.addAttribute("ccList1", ccList1);
		return "/WEB-INF/back/collect/collections/publicOpenCollectionsList.jsp";
	}
	
	@RequestMapping("/getConfirm.do")
	@AuthPassport
	public String getConfirm(Model model,String ids) {
		model.addAttribute("ids", ids);
		return "/WEB-INF/back/collect/collections/confirm.jsp";
	}
	
	@RequestMapping("/getCollectionDetail.do")
	@AuthPassport
	public String getCollectionDetail(Model model,String id) {
		model.addAttribute("id", id);
		return "/WEB-INF/back/collect/collections/showCollections.jsp";
	}


	@RequestMapping("/dataList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getCuration(
			@ModelAttribute MipOpenCulturalrelicInfo openCollectionInfo,
			String key,String gsNo,String collectionType,
			@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size
			){

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		//查询条件
		if (StringUtils.isNotBlank(key)) {
			openCollectionInfo.setName(key);
		}
		if (StringUtils.isNotBlank(gsNo)) {
			openCollectionInfo.setGsNo(gsNo);
		}
		List<CollectionCategoryDto> ccList;
		List<YearTypeDto> ytList;
		if (openCollectionInfo.getCollectionType().equals("0")) {
			//文物类别
			ccList	= mipCollectionCategoryService.collectionCategoryList(1);
			
			ytList = mipYearTypeService.yearTypeList();
		} else {
			//化石类别
			ccList	= mipCollectionCategoryService.collectionCategoryList(2);
			ytList = mipYearTypeService.yearhsTypeList();
			
		}
		//查询博物馆集合
		List<MipOrganization> musList = mipOrganizationService.getMuseumList();

		//查询所有公开文物
		if(collectionType.equals("0")){
			
		}
		List<MipOpenCulturalrelicInfo> listCollectionInfo = mipOpenCollectionInfoService.listCollectionInfo4Culturalrelic(openCollectionInfo, page, orgId);
		for(MipOpenCulturalrelicInfo info : listCollectionInfo) {
			//			PictureSimpleDto findPictureUrl = pictureService.findPictureUrl(info.getPictureIds());
			//			info.setPictureIds(findPictureUrl.getPicUrl());

			MipPicture pic = pictureService.getByObjectId(info.getId());
			if (null!=pic) {
				if (!MyString.isEmpty(pic.getThumb3())) {
					info.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
					info.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
				} else {
					info.setPicUrl("");
					info.setFpic("");
				}
			}


			if (ccList.size() > 0) {
				for (CollectionCategoryDto collectionCategoryDto : ccList) {
					if (info.getCollectionsCategory().equals(collectionCategoryDto.getId())) {
						info.setCollectionsCategory(collectionCategoryDto.getName());
					}
				}
			}
			if (ytList.size() > 0) {
				for (YearTypeDto ytInfo : ytList) {
					if (info.getYearType().equals(ytInfo.getId())) {
						info.setYearType(ytInfo.getName());
					}
				}
			}
			if (musList.size() > 0) {
				for (MipOrganization mipOrganization : musList) {
					if (info.getCollectionUnit().equals(mipOrganization.getId()+"")) {
						info.setCollectionUnit(mipOrganization.getName());
					}
				}
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", listCollectionInfo);
		return jsonObject;
	}
	
	@RequestMapping("/dataList4Fossil.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getCuration4Fossil(
			@ModelAttribute MipOpenFossilInfo openCollectionInfo,
			String key,String gsNo,String collectionType,
			@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size
			){

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		//查询条件
		if (StringUtils.isNotBlank(key)) {
			openCollectionInfo.setName(key);
		}
		if (StringUtils.isNotBlank(gsNo)) {
			openCollectionInfo.setGsNo(gsNo);
		}
		List<CollectionCategoryDto> ccList;
		List<YearTypeDto> ytList;
		if (openCollectionInfo.getCollectionType().equals("0")) {
			//文物类别
			ccList	= mipCollectionCategoryService.collectionCategoryList(1);
			
			ytList = mipYearTypeService.yearTypeList();
		} else {
			//化石类别
			ccList	= mipCollectionCategoryService.collectionCategoryList(2);
			ytList = mipYearTypeService.yearhsTypeList();
			
		}
		//查询博物馆集合
		List<MipOrganization> musList = mipOrganizationService.getMuseumList();

		//查询所有公开文物
		if(collectionType.equals("0")){
			
		}
		List<MipOpenFossilInfo> listCollectionInfo = mipOpenCollectionInfoService.listCollectionInfo4Fossil(openCollectionInfo, page, orgId);
		for(MipOpenFossilInfo info : listCollectionInfo) {
			//			PictureSimpleDto findPictureUrl = pictureService.findPictureUrl(info.getPictureIds());
			//			info.setPictureIds(findPictureUrl.getPicUrl());

			MipPicture pic = pictureService.getByObjectId(info.getId());
			if (null!=pic) {
				if (!MyString.isEmpty(pic.getThumb3())) {
					info.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
					info.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
				} else {
					info.setPicUrl("");
					info.setFpic("");
				}
			}
			


			if (ccList.size() > 0) {
				for (CollectionCategoryDto collectionCategoryDto : ccList) {
					if (info.getCollectionsCategory().equals(collectionCategoryDto.getId())) {
						info.setCollectionsCategory(collectionCategoryDto.getName());
					}
				}
			}
			if (ytList.size() > 0) {
				for (YearTypeDto ytInfo : ytList) {
					if (info.getYearType().equals(ytInfo.getId())) {
						info.setYearType(ytInfo.getName());
					}
				}
			}
			if (musList.size() > 0) {
				for (MipOrganization mipOrganization : musList) {
					if (info.getCollectionUnit().equals(mipOrganization.getId()+"")) {
						info.setCollectionUnit(mipOrganization.getName());
					}
				}
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", listCollectionInfo);
		return jsonObject;
	}
	
	@RequestMapping("/getPublicOpenList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getPublicOpenList(
			String applyDept,String status,
			@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size
			){

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		int newStatus = 0;
		if(status != null && status != ""){
			newStatus = Integer.parseInt(status);
		}
		JsonResult list = mipOpenCulturalrelicInfoApprovalService.getApprovalInfoList(applyDept, newStatus, page);
		JSONObject jsonObject = new JSONObject();
		if(list.getSuccess()==1){
			jsonObject.put("code", 0);
			jsonObject.put("msg",""); 
			jsonObject.put("count", page.getAllRow());
			jsonObject.put("data", list.getData());
		}else{
			jsonObject.put("code", 1);
		}		
		return jsonObject;
	}
	
	@RequestMapping("/getCollectionDetailList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getCollectionDetailList(
			String id,
			@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size
			){

		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		MipOpenCulturalrelicInfoApproval mipOpenCulturalrelicInfoApproval = mipOpenCulturalrelicInfoApprovalService.getApprovalInfo(id);
		if(mipOpenCulturalrelicInfoApproval.getExt1().equals("1")){
			JsonResult list = mipOpenCulturalrelicInfoApprovalService.getApprovalInfoDetail(id, page);
			JSONObject jsonObject = new JSONObject();
			if(list.getSuccess()==1){
				List<MipOpenCulturalrelicInfo> data= (List<MipOpenCulturalrelicInfo>)list.getData();
//				 查询年代集合
				String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
				List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
						Tools.getMap());
				//     文物类别集合
				List<CollectionCategory> ccList = (List<CollectionCategory>) collectionCategoryService
						.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());

				for(int j=0;j<data.size();j++){
					MipOpenCulturalrelicInfo m2 = data.get(j);
					Picture pic = ipictureService.getByHql("from Picture where objectId='"+m2.getId()+"' order by isMain desc,url");
					if (null!=pic) {
						if (!MyString.isEmpty(pic.getThumb3())) {
							m2.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
							m2.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
						} else {
							m2.setPicUrl("");
							m2.setFpic("");
						}
					}
					if (ytList.size() > 0) {
						for (YearType yearType : ytList) {
							if (m2.getYearType().equals(yearType.id)) {
								m2.setYearType(yearType.getName());
							}
						}
					}
					if (ccList.size() > 0) {
						for (CollectionCategory gory : ccList) {
							if (m2.getCollectionsCategory().equals(gory.getId())) {
								m2.setCollectionsCategory(gory.getName());
							}
						}
					}
				}
				jsonObject.put("code", 0);
				jsonObject.put("msg",""); 
				jsonObject.put("count", page.getAllRow());
				jsonObject.put("data", list.getData());
			}else{
				jsonObject.put("code", 1);
			}		
			return jsonObject;
		}else{
			JsonResult list = mipOpenCulturalrelicInfoApprovalService.getApprovalInfoDetail4OpenFossil(id, page);
			JSONObject jsonObject = new JSONObject();
			if(list.getSuccess()==1){
				List<MipOpenFossilInfo> data= (List<MipOpenFossilInfo>)list.getData();
//				 查询年代集合
				String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
				List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
						Tools.getMap());
				//     文物类别集合
				List<CollectionCategory> ccList = (List<CollectionCategory>) collectionCategoryService
						.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());

				for(int j=0;j<data.size();j++){
					MipOpenFossilInfo m2 = data.get(j);
					Picture pic = ipictureService.getByHql("from Picture where objectId='"+m2.getId()+"' order by isMain desc,url");
					if (null!=pic) {
						if (!MyString.isEmpty(pic.getThumb3())) {
							m2.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
							m2.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
						} else {
							m2.setPicUrl("");
							m2.setFpic("");
						}
					}
					if (ytList.size() > 0) {
						for (YearType yearType : ytList) {
							if (m2.getYearType().equals(yearType.id)) {
								m2.setYearType(yearType.getName());
							}
						}
					}
					if (ccList.size() > 0) {
						for (CollectionCategory gory : ccList) {
							if (m2.getCollectionsCategory().equals(gory.getId())) {
								m2.setCollectionsCategory(gory.getName());
							}
						}
					}
				}
				jsonObject.put("code", 0);
				jsonObject.put("msg",""); 
				jsonObject.put("count", page.getAllRow());
				jsonObject.put("data", list.getData());
			}else{
				jsonObject.put("code", 1);
			}		
			return jsonObject;
		}
		
	}
	
	@RequestMapping("/removeCollections.do")
	@ResponseBody
	@AuthPassport
	public String removeCollections(String id){
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.updateCollectionInfo(id, 0, 1);
		if(jsonResult.getSuccess()==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/batchRemoveCollections.do")
	@ResponseBody
	@AuthPassport
	public String batchRemoveCollections(String[] ids){
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.batchUpdateCollectionInfo(ids, 0, 1);
		if(jsonResult.getSuccess()==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/removeFossils.do")
	@ResponseBody
	@AuthPassport
	public String removeFossils(String id){
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.update4OpenFossilInfo(id, 0, 1);
		if(jsonResult.getSuccess()==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/batchRemoveFossils.do")
	@ResponseBody
	@AuthPassport
	public String batchRemoveFossils(String[] ids){
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.batchUpdateOpenFossilInfo(ids, 0, 1);
		if(jsonResult.getSuccess()==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/approvalCollection.do")
	@ResponseBody
	@AuthPassport
	public String approvalCollection(String[] ids,int type){
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.batchOperaterApprovalInfo(ids, type);
		if(jsonResult.getSuccess()==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/getOpenColectionList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getOpenColectionList(String applyDept,@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue = "20") int size){
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.getOpenInfoList(applyDept, page);
		JSONObject jsonObject = new JSONObject();
		if(jsonResult.getSuccess()==1){
			List<MipOpenCollectionInfo> data = (List<MipOpenCollectionInfo>)jsonResult.getData();
			for(int j=0;j<data.size();j++){
				MipOpenCollectionInfo m2 = data.get(j);
				Picture pic = ipictureService.getByHql("from Picture where objectId='"+m2.getId()+"' order by isMain desc,url");
				if (null!=pic) {
					if (!MyString.isEmpty(pic.getThumb3())) {
						m2.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
						m2.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
					} else {
						m2.setPicUrl("");
						m2.setFpic("");
					}
				}
			}
			jsonObject.put("code", 0);
			jsonObject.put("msg",""); 
			jsonObject.put("count", page.getAllRow());
			jsonObject.put("data", data);
		}else{
			jsonObject.put("code", 1);
		}
		return jsonObject;
	}
	//从公众公开库移除
	@RequestMapping("/remove4OpenCollection.do")
	@ResponseBody
	@AuthPassport
	public String remove4OpenCollection(String id){
		JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.remove4OpenInfo(id);
		if(jsonResult.getSuccess()==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	//从公众公开库批量移除
		@RequestMapping("/batchRemove4OpenCollection.do")
		@ResponseBody
		@AuthPassport
		public String batchRemove4OpenCollection(String[] ids){
			JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.batchRemove4OpenInfo(ids);
			if(jsonResult.getSuccess()==1){
				return "1";
			}else{
				return "0";
			}
		}
	

}
