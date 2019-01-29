package com.tj720.mip.controller.collect.collectManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.dao.map.MipOpenFossilInfoMapper;
import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.dto.CollectionObjectDto;
import com.tj720.admin.dto.EchartData;
import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.dto.ObjectChangeDto;
import com.tj720.admin.dto.Series;
import com.tj720.admin.dto.TotalNumDto;
import com.tj720.admin.dto.VersionContentDto;
import com.tj720.admin.dto.VersionSelectDto;
import com.tj720.admin.model.DcVersionSelect;
import com.tj720.admin.model.MipArea;
import com.tj720.admin.model.MipCollectionCategory;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipOpenFossilInfoWithBLOBs;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.MipYearType;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.DcVersionSelectService;
import com.tj720.admin.service.EchartService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipPictureService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.admin.service.ObjectChangeService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.YearTypeDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;


@Controller
@RequestMapping("/objectChange")
public class ObjectChangeManageController{
	@Autowired
	DcVersionSelectService dcVersionSelectService;
	@Autowired
	MipYearTypeService mipYearTypeService;
	@Autowired
	IMipOrganizationService mipOrganizationService;
	@Autowired
	MipCollectionCategoryService mipCollectionCategoryService;
	@Autowired
	DcVersionContentService dcVersionContentService;
	@Autowired
	ObjectChangeService objectChangeService;
	@Autowired
	EchartService echartService;
	@Autowired
	MipAreaService mipAreaService;
	@Autowired
	MipPictureService mipPictureService;
	@Autowired
	Config config;
	@Autowired
	MipOpenFossilInfoMapper mipOpenFossilInfoMapper;
	@Autowired
	private IUserService userService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	
	
	@RequestMapping("/list.do")
	public String list(Model model,@RequestParam(defaultValue="1")int collectionType) {
		List<YearTypeDto> yearTypeList =  mipYearTypeService.yearTypeList();
		List<MipOrganization> organizationList = mipOrganizationService.getListByOrgType("1");
		List<CollectionCategoryDto> collectionCategoryList = mipCollectionCategoryService.collectionCategoryList(1);
		List<CollectionCategoryDto> collectionCategoryListFoss = mipCollectionCategoryService.collectionCategoryList(2);
		model.addAttribute("yearTypeList", yearTypeList);//其他年代
		model.addAttribute("collectionCategoryList", collectionCategoryList);//文物类别列表
		model.addAttribute("collectionCategoryListFoss", collectionCategoryListFoss);//文物类别列表化石
		model.addAttribute("collectionType", collectionType);//类型：1文物；2化石
		List<YearTypeDto> yearTypeEonList =  mipYearTypeService.yearTypeByParentIdList("2");
		model.addAttribute("yearTypeEonList", yearTypeEonList);//宙
		
		model.addAttribute("organizationList", organizationList);
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(orgId));
		model.addAttribute("level", org.getOrgTypeId());//level类型
		return "/WEB-INF/back/collect/collectManagement/collectionChangeList.jsp";
	}
	
	/**
	 * 藏品变动列表
	 * @param modelMap
	 * @param size
	 * @param currentPage
	 * @param dcVersion
	 * @param otherYearType
	 * @param collectionType
	 * @return
	 */
	@RequestMapping("/infoList.do")
	@ResponseBody
	public JSONObject getInfoList(ModelMap modelMap,@RequestParam(defaultValue="10") int size,
			@RequestParam(defaultValue="1") int currentPage,DcVersionSelect dcVersion,String otherYearType,@RequestParam(defaultValue="1")int collectionType){
		JSONObject jsonObject = new JSONObject();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		if(MyString.isEmpty(dcVersion.getYearType())){
			dcVersion.setYearType(otherYearType);
		}
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(orgId));
		List<VersionSelectDto> versionSelectList = new ArrayList<VersionSelectDto>();
		String orgTypeId = org.getOrgTypeId();
		//文物局或者区文委登录
		versionSelectList = dcVersionSelectService.getVersionSelectList(dcVersion,page,collectionType,orgTypeId,orgId);
		
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", versionSelectList);
		return jsonObject;
	}
	
	@RequestMapping("/goChangeList.do")
	public String goList(Model model,String selectId,int collectionType) {
		model.addAttribute("selectId", selectId);
		model.addAttribute("collectionType", collectionType);
		return "/WEB-INF/back/collect/collectManagement/versionChangeList.jsp";
	}
	/**
	 * 藏品动态统计页面
	 * @return
	 */

	@RequestMapping("/statisticsInfo.do")
	public String statisticsInfo(ModelMap modelMap){
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(orgId));
		ObjectChangeDto changeDto = new ObjectChangeDto();
		String orgTypeId = org.getOrgTypeId();
		String level = "";
		if("1".equals(orgTypeId) || "2".equals(orgTypeId)){
			level = "1";
		}
		changeDto = objectChangeService.getChangeDto(orgTypeId,orgId);
		modelMap.put("changeDto", changeDto);
		modelMap.put("level", level);
		return "/WEB-INF/back/collect/collectManagement/collectionStatistics.jsp";
	}
	
	/**
	 * 折线图
	 * @param type
	 * @param status
	 * @return
	 */
	@RequestMapping("/showEchartLine.do")
    @ResponseBody
    public EchartData lineData(@RequestParam(defaultValue="1") int type,@RequestParam(defaultValue="0") byte status) {
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(orgId));
		List<TotalNumDto> list = new ArrayList<TotalNumDto>();
		String orgTypeId = org.getOrgTypeId();
		if("1".equals(orgTypeId) || "2".equals(orgTypeId)){
			list = echartService.getLineData(type,status,orgId);
		}else{
			list = echartService.getLineDataByOrgId(type,status,orgId);
		}
        List<String> category = new ArrayList<String>();
        List<Integer> serisData=new ArrayList<Integer>();
        for (TotalNumDto totalNum : list) {
            category.add(totalNum.getWeek());
            serisData.add(totalNum.getCount());
        }
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[] { "总数比较" }));// 数据分组
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("变更数量", "line", serisData));
        EchartData data = new EchartData(legend, category, series);
        return data;
    }
	 /**
     * 饼状图
     * @param <T>
     * @return
     */ 
    @RequestMapping("/showEchartPie.do")
    @ResponseBody
    public EchartData PieData(@RequestParam(defaultValue="0") byte picType,@RequestParam(defaultValue="0") int picArea
    		,String beginTime,String endTime) {
    	try {
    		List<String> legend = new ArrayList<String>();
    		List<String> areaId = new ArrayList<String>();
    		List<Map> serisData=new ArrayList<Map>();
    		List<Map<String,Object>> areaList = museumBaseInfoService.getAreaList();
    		List<TotalNumDto> list = echartService.getPieData(picType,picArea,beginTime,endTime,areaList);
    		for (TotalNumDto visit : list) {
    			Map map =new HashMap();
    			legend.add(visit.getWeek());
    			areaId.add(visit.getId());
    			map.put("value", visit.getCount());
    			map.put("name",visit.getWeek());
    			serisData.add(map);
    		}
    		List<Series> series = new ArrayList<Series>();// 纵坐标
    		series.add(new Series("总数比较", "pie",serisData));
    		EchartData data = new EchartData(legend,areaId, series);
    		return data;
		} catch (Exception e) {
			return null;
		}
    }
	
	/**
	 * 藏品版本信息查询
	 * @param selectId
	 * @return
	 */
	@RequestMapping("/getVersionSelect.do")
	@ResponseBody
	public JSONObject getVersionSelect(String selectId ){
		JSONObject jsonObject = new JSONObject();
		try {
			if(!MyString.isEmpty(selectId)){
				List<VersionContentDto> versionConteneList = dcVersionContentService.selectByVersionIdList(selectId);
				jsonObject.put("code", 0);
				jsonObject.put("msg",""); 
				jsonObject.put("data", versionConteneList);
			}else{
				jsonObject.put("code", 0);
				jsonObject.put("msg",""); 
				jsonObject.put("data", "");
			}
		} catch (Exception e) {
			jsonObject.put("code", 0);
			jsonObject.put("msg",""); 
			jsonObject.put("data", "");
		}
		return jsonObject;
	}
	
	/**
	 * 获取北京市城区列表
	 * @return
	 */
	@RequestMapping("/getAreaList.do")
	@ResponseBody
	public JsonResult getAreaList(){
		try {
			List<Map<String,Object>> areaList = museumBaseInfoService.getAreaList();
			return new JsonResult(1,areaList);
		} catch (Exception e) {
			return new JsonResult(0,"系统异常");
		}
	}
	/**
	 * 藏品版本对比信息
	 * @param modelMap
	 * @param contentId
	 * @param contentType
	 * @return
	 */
	@RequestMapping("/compareVersionSelect.do")
	public String compareVersion(ModelMap modelMap,String contentId,int contentType){
		try {
			if(!MyString.isEmpty(contentId)){
				String[] contentIdList = contentId.split(",");
				if(contentIdList.length==2){
					CollectionObjectDto contentNow = dcVersionContentService.selectById(contentIdList[0],contentType);
					CollectionObjectDto contentNext = dcVersionContentService.selectById(contentIdList[1],contentType);
					modelMap.put("contentNow", contentNow);
					modelMap.put("contentNext", contentNext);
					return "/WEB-INF/back/collect/collectManagement/objectCompareNew.jsp";
				}else{
					return "0";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "0";
	}
	
	/**
	 * 版本列表藏品详情
	 */
	@RequestMapping("/versionSelect.do")
	public String versionSelect(ModelMap modelMap,String contentId,int contentType){
		try {
			if(1==contentType){
				MipOpenCulturalrelicInfoWithBLOBs collection = dcVersionContentService.selectByCulturalrelic(contentId);
				modelMap.put("collection", collection);
				//查询博物馆名称
				String collectionUnitId = collection.getCollectionUnit();
				if(!MyString.isEmpty(collectionUnitId)){
					MipOrganization mipOrganization = mipOrganizationService.getOrganization(Integer.parseInt(collectionUnitId));
					if(mipOrganization !=null){
						modelMap.put("mipOrganization", mipOrganization.getName());
					}
				}
				//查询藏品的文物类别
				String collectionsCategory = collection.getCollectionsCategory();
				MipCollectionCategory collectionCategory = mipCollectionCategoryService.getCollectionCategoryById(collectionsCategory);
				if(collectionCategory!=null){
					modelMap.put("collectionCategory", collectionCategory.getName());
				}
				//查询年代
				String yearTypeId = collection.getYearType();
				MipYearType yearType = mipYearTypeService.getYearTypeById(yearTypeId);
				if(yearType!=null){
					modelMap.put("yearType", yearType.getName());
				}
				List<MipPicture> pictures = new ArrayList<MipPicture>();
				pictures = mipPictureService.getPictureListByObjectId(collection.getId());
				if (!MyString.isEmpty(pictures)) {
					for (MipPicture picture : pictures) {
						picture.setUrl(config.getImageUrl()+picture.getUrl());
						picture.setThumb1(config.getImageUrl()+picture.getThumb1());
						picture.setThumb2(config.getImageUrl()+picture.getThumb2());
						picture.setThumb3(config.getImageUrl()+picture.getThumb3());
					}
				}
				modelMap.put("pictures", pictures);
				return "/WEB-INF/back/collect/collectManagement/wwdetailNew.jsp";
			}else if(2==contentType){
				MipOpenFossilInfoWithBLOBs collection = dcVersionContentService.selectByFossil(contentId);
				modelMap.put("collection", collection);
				// 查询博物馆名称
				String collectionUnitId = collection.getCollectionUnit();
				MipOrganization mipOrganization = mipOrganizationService.getOrganization(Integer.parseInt(collectionUnitId));
				if(mipOrganization!=null){
					modelMap.put("mipOrganization", mipOrganization.getName());
				}
				
				// 查询藏品的文物类别
				String collectionsCategory = collection.getCollectionsCategory();
				MipCollectionCategory collectionCategory = mipCollectionCategoryService.getCollectionCategoryById(collectionsCategory);
				if(collectionCategory!=null){
					modelMap.put("collectionCategory", collectionCategory.getName());
				}
				
				// 查询年代
				String yearTypeId = collection.getYearType();
				modelMap.put("yearType", yearTypeId);
				List<MipPicture> pictures = new ArrayList<MipPicture>();
				pictures = mipPictureService.getPictureListByObjectId(collection.getId());
				if (!MyString.isEmpty(pictures)) {
					for (MipPicture picture : pictures) {
						picture.setUrl(config.getImageUrl()+picture.getUrl());
						picture.setThumb1(config.getImageUrl()+picture.getThumb1());
						picture.setThumb2(config.getImageUrl()+picture.getThumb2());
						picture.setThumb3(config.getImageUrl()+picture.getThumb3());
					}
				}
				modelMap.put("pictures", pictures);
				return "/WEB-INF/back/collect/collectManagement/hsdetailNew.jsp";
			}else{
				return "/WEB-INF/back/error.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	/**
	 * 根据父id查询纪  代
	 * @return
	 */
	@RequestMapping("/selectEra.do")
	@ResponseBody
	public JsonResult selectEra(String id){
		try {
			if(!MyString.isEmpty(id)){
				List<YearTypeDto> yearTypeEonList =  mipYearTypeService.yearTypeByParentIdList(id);
				return new JsonResult(1, yearTypeEonList);
			}else{
				return new JsonResult(0, "系统异常");
			}
		} catch (Exception e) {
			return new JsonResult(0, "系统异常");
		}
	}
	

}
