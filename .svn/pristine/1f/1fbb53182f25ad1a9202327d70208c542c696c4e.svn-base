package com.tj720.mip.controller.collectionTopic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.model.MipTopic;
import com.tj720.admin.model.MipTopicCollection;
import com.tj720.admin.model.MipTopicCollectionExample;
import com.tj720.admin.model.MipTopicCollectionExample.Criteria;
import com.tj720.admin.service.MipTopicCollectionService;
import com.tj720.admin.service.MipTopicService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.ExportExcelUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 藏品专题
 * 
 * @author cm
 *
 */
@Controller
@RequestMapping("topic")
public class MipTopicController {

	@Autowired
	private MipTopicService mipTopicService;
	@Autowired
	private MipTopicCollectionService mipTopicCollectionService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private Config config;// 常量的取法
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private MipOrganizationService organizationService;

	/**
	 * 去列表页面
	 * @return
	 */
	@RequestMapping("goList")
	@AuthPassport(authority = "contentCommon")
	@ControllerAop(url="topic/goList.do")
	public String goList(Model model) {
		User user = userService.get(Tools.getUser().getId());
		// 查询组织机构（博物馆）的集合
		List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
		if (user.getOrgId().equals("0")) {
			model.addAttribute("musList", orgList);
		} else {
			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(user.getOrgId()), true);
			model.addAttribute("musList", sonOrg);
		}
		
		return "/WEB-INF/back/topic/topicList.jsp";
	}
	
	/**
	 * 去新增页面
	 * @param model
	 * @return
	 */
	@RequestMapping("goAdd")
	@AuthPassport(authority = "contentCommon")
	public String goAdd(Model model) {
		return "/WEB-INF/back/topic/topicAdd.jsp";
	}
	
	/**
	 * 去编辑藏品专题详情页
	 * @return
	 */
	@RequestMapping("goEditTopicPage.do")
	@AuthPassport
	@ControllerAop(url="topic/goList.do")
	public ModelAndView goEditTopicPage(String topicId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/topic/topic_show.jsp");
		HashMap<String,Object> map = mipTopicCollectionService.getTopicById(topicId);
		modle.addObject("topic", map);
		return modle;
	}
	
	/**
	 * 去列表页面
	 * 
	 * @param model
	 * @param key
	 * @param status
	 * @param orgId
	 * @param currentPage
	 * @param size
	 * @return
	 */
	@RequestMapping("getListData")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JSONObject getListData(Model model, String key, String status, String museumId, 
			@RequestParam(defaultValue = "1", name = "page") Integer currentPage,
			@RequestParam(defaultValue = "10") int size) {
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
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", listByKey);
		return jsonObject;
	}
	
	/**
	 * 添加藏品页面
	 * @param model
	 * @return
	 */
	@RequestMapping("goSelectCollection")
	@AuthPassport(authority = "contentCommon")
	public String goSelectCollection(String topicId, Model model) {
		// 查询文物类别集合
		List<PickDto> ccList = (List<PickDto>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());
		model.addAttribute("category", ccList);
		
		// 查询年代集合
		String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
		List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
				Tools.getMap());
		model.addAttribute("year", ytList);
		
		model.addAttribute("topicId", topicId);
		return "/WEB-INF/back/content/topic/topic_collectionSelect.jsp";
	}
	
	/**
	 * 添加藏品页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="getSelectCollectionData")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult getSelectCollectionData(String topicId, MipTopicCollectionDto search, @RequestParam(defaultValue = "1", name = "page") Integer currentPage,
			@RequestParam(defaultValue = "15") int size) {
		LoginInfoDto user = Tools.getUser();
		if(StringUtils.isBlank(user.getId())) {		//未登录
			
		}else {
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			User user2 = userService.get(user.getId());
			MipOrganization mipOrganization = organizationService.get(user2.getOrgId());
			List<MipTopicCollectionDto> collectionList = new ArrayList<>();
			if(StringUtils.isNotBlank(mipOrganization.getOrgTypeId()) && "1".equals(mipOrganization.getOrgTypeId())) {
				collectionList = mipTopicService.getCollectionList(null, topicId, search, page);
			}else {
				List<com.tj720.admin.model.MipOrganization> orgAllList = organizationService.getList();
				List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgAllList, Integer.valueOf(user2.getOrgId()), true);
				if("2".equals(mipOrganization.getOrgTypeId())) {	//区文委去掉央、市属机构
					sonOrg = organizationService.getLitleOrgByParmOrg(sonOrg);
				}
				collectionList = mipTopicService.getCollectionList(sonOrg, topicId, search, page);
			}
			
			return new JsonResult(1, collectionList, page);
		}
		return new JsonResult(0, null, null);
	}


	/**
	 * 保存
	 * @param model
	 * @return
	 */
	@RequestMapping("saveTopic")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult saveTopic(Model model, String name) {
		if(StringUtils.isNotBlank(name)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			User user2 = userService.get(user.getId());
			MipTopic topic = new MipTopic();
			topic.setName(name);
			topic.setCreatedTime(new Date());
			topic.setId(IdUtils.nextId(MipTopic.class));
			topic.setPublishOrg(user2.getOrgId());
			topic.setStatus("1");
			topic.setPalyNum(0);
			mipTopicService.create(topic);
			return new JsonResult(1, topic);
		}
		return new JsonResult(0, "信息错误");
	}

	/**
	 * 发布，
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("publishTopic")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public String publishTopic(Model model, String id) {
		if(StringUtils.isNotBlank(id)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return "未登录";
			}
			
			MipTopic topic = mipTopicService.get(id);
			MipTopic updateTopic = new MipTopic();
			updateTopic.setId(id);
			if("1".equals(topic.getStatus())) {
				updateTopic.setStatus("2");				//发布
				updateTopic.setPublishTime(new Date());
			}else if("2".equals(topic.getStatus())) {
				updateTopic.setStatus("1");				//取消发布
			}
			if(StringUtils.isNotBlank(updateTopic.getStatus())) {
				updateTopic.setUpdateTime(new Date());
				int updateByidSelect = mipTopicService.updateByidSelect(updateTopic);
				if(updateByidSelect == 1) {
					return "success";
				}else {
					return "error";
				}
			}
		}
		return "error";
	}
	

	/**
	 * 删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteTopic")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult deleteTopic(Model model, String id) {
		if(StringUtils.isNotBlank(id)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			
			MipTopic updateTopic = new MipTopic();
			updateTopic.setId(id);
			updateTopic.setStatus("0");				//删除
			updateTopic.setUpdateTime(new Date());
			int updateByidSelect = mipTopicService.updateByidSelect(updateTopic);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "删除成功");
			}else {
				return new JsonResult(0, "删除失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}
	
	/**
	 * 编辑保存
	 * @param model
	 * @return
	 */
	@RequestMapping("/editTopic.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult editTopic(Model model,@ModelAttribute MipTopic mipTopic,String fristTime,String sencondTime) {
		if(StringUtils.isNotBlank(mipTopic.getId())) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			User user2 = userService.get(user.getId());
			MipTopic topic = mipTopicService.get(mipTopic.getId());
			topic.setName(mipTopic.getName());
			topic.setLabel(mipTopic.getLabel());
			topic.setExhibitionHall(mipTopic.getExhibitionHall());
			topic.setType(mipTopic.getType());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");						
			
			try {
				if(null != fristTime){
					topic.setStartTime(sdf.parse(fristTime));
				}
				if(null != sencondTime){
					topic.setEndTime(sdf.parse(sencondTime));
				}				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			topic.setIntroduction(mipTopic.getIntroduction());
			topic.setIconUrl(mipTopic.getIconUrl());
			int updateByid = mipTopicService.updateByid(topic);
			if(updateByid == 1) {
				return new JsonResult(1, topic);
			}else {
				return new JsonResult(0, "保存失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}
	
	/**
	 * 修改排序
	 * @return
	 */
	@RequestMapping("/editSequence.do")
	@ResponseBody
	@AuthPassport(authority = "contentCommon")
	public JsonResult editSequence(String id, String type) {
		MipTopicCollection topicCollection = mipTopicCollectionService.get(id);
		String topicId = topicCollection.getTopicId();
		if(!MyString.isEmpty(topicCollection)){
			MipTopicCollectionExample example = new MipTopicCollectionExample();
			Criteria criteria = example.createCriteria();
			criteria.andTopicIdEqualTo(topicId);
			if("up".equals(type)) {
				criteria.andSortLessThanOrEqualTo(topicCollection.getSort());
				example.setOrderByClause("sort desc");
			}else if("down".equals(type)) {
				criteria.andSortGreaterThanOrEqualTo(topicCollection.getSort());
				example.setOrderByClause("sort");
			}
			example.setSize(2);
			example.setStartPage(0);
			List<MipTopicCollection> selectListByExample = mipTopicCollectionService.selectByExample(example);
			
			if(selectListByExample != null && selectListByExample.size() > 0) {
				if(selectListByExample.size() == 1) {
					
				}else if(selectListByExample.size() == 2){
					Integer temp = 0;
					MipTopicCollection item1 = selectListByExample.get(0);
					MipTopicCollection item2 = selectListByExample.get(1);
					temp = item1.getSort();
					item1.setSort(item2.getSort());
					item2.setSort(temp);
					mipTopicCollectionService.updateById(item1);
					mipTopicCollectionService.updateById(item2);
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
	 * 获取藏品列表
	 * @param topicId
	 * @return
	 */
	@RequestMapping("/getCollectionList.do")
	@ResponseBody
	@AuthPassport(authority = "contentCommon")
	public JsonResult getCollectionList(String topicId) {
		if(StringUtils.isBlank(topicId)) {
			return new JsonResult(Constants.RES_FAIL, "该信息不存在");
		}
		List<MipTopicCollectionDto> listByTopicId = null;
		try {
			listByTopicId = mipTopicCollectionService.getListByTopicId(topicId);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(Constants.RES_FAIL, "系统错误");
		}
		return new JsonResult(Constants.RES_SUCCESS, listByTopicId);
	}
	
	/**
	 * 去修改藏品排序页面
	 * @param topicId
	 * @return
	 */
	@RequestMapping("/goEditSort.do")
	@AuthPassport(authority = "contentCommon")
	public String goEditSort(String topicId, Model model) {
		List<MipTopicCollectionDto> listByTopicId = null;
		try {
			listByTopicId = mipTopicCollectionService.getListByTopicId(topicId);
			model.addAttribute("collectionList", listByTopicId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/WEB-INF/back/content/topic/topic_editSort.jsp";
	}
	
	
	/**
	 * 去专题列表页面
	 */
	@RequestMapping("/goTopic.do")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView goTopic(String id,String topicId,String type) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/content/topic/orgTopicList.jsp");
		modelAndView.addObject("id", id);
		modelAndView.addObject("topicId", topicId);
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		modelAndView.addObject("orgId", orgId);
		modelAndView.addObject("type", StringUtils.isNotEmpty(type)?type:"");
		return modelAndView;
	}
	
	
	/**
	 * 添加到专题
	 */
	@RequestMapping("/addToTopic.do")
	@ResponseBody
	@AuthPassport(authority = "contentCommon")
	public JsonResult addToTopic(String id,String topicId,String type) {
		try{
			if(!StringUtils.isNotEmpty(type)) {
				MipTopicCollection model = mipTopicCollectionService.getByTopicidAndCollectionId(topicId,id);
				if(model==null){
					int flag = mipTopicService.addToTopic(id,topicId);
					if(flag == 1){
						return new JsonResult(Constants.RES_SUCCESS, "加入专题成功");
					}else{
						return new JsonResult(Constants.RES_FAIL, "加入专题失败");
					}
				}else{
					return new JsonResult(2, "已经加入过该专题了哦");
				}
			}
			//多选
			String[] ids = id.split(",");
			for(int i=0;i<ids.length;i++) {
				String collectionId = ids[i];
				MipTopicCollection model = mipTopicCollectionService.getByTopicidAndCollectionId(topicId,collectionId);
				if(model==null){
					mipTopicService.addToTopic(collectionId,topicId);
				}
			}
			return new JsonResult(Constants.RES_SUCCESS, "加入专题成功");
		}catch (Exception e){
	        e.printStackTrace();
	        return new JsonResult(Constants.RES_FAIL, null);
	    }
	}
	
	/**
	 * orgId 获取专题列表
	 */
	@RequestMapping("/getTopicLis.do")
	@ResponseBody
	@AuthPassport(authority = "contentCommon")
	public JsonResult getTopicLis(String orgId,String topicId) {
		try{
			List<MipTopic> list = mipTopicService.getListByOrgIdAndTopicId(orgId,topicId);		
			return new JsonResult(Constants.RES_SUCCESS,list);
		}catch (Exception e){
	        e.printStackTrace();
	        return new JsonResult(Constants.RES_FAIL, null);
	    }
	}
	
	
	/**
	 * 去添加专题页面
	 */
	@RequestMapping("/goAddTopic.do")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView goAddTopic() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/content/topic/addTopic.jsp");
		return modelAndView;
	}
	
	/**
	 * 编辑保存
	 * @param model
	 * @return
	 */
	@RequestMapping("batchSaveCollection")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult batchSaveCollection(String topicId, String collectionIds) {
		if(StringUtils.isNotBlank(topicId) && StringUtils.isNotBlank(collectionIds)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			MipTopic mipTopic = mipTopicService.get(topicId);
			if(StringUtils.isNotBlank(mipTopic.getId())) {
				int maxSort = mipTopicCollectionService.getMaxSort(topicId);
				String[] split = collectionIds.split(",");
				List<MipTopicCollection> asList = new ArrayList<>();
				int i = 1;
				for (String collectionid : split) {
					if(StringUtils.isNotBlank(collectionid)) {
						MipTopicCollection collection = new MipTopicCollection();
						collection.setId(UUID.randomUUID().toString().replace("-", ""));
						collection.setSort(i+maxSort);
						collection.setTopicId(topicId);
						collection.setCollectionId(collectionid);
						asList.add(collection);
						i++;
					}
				}
				try {
					//批量保存
					if(asList != null && asList.size() > 0) {
						int batchSave = mipTopicCollectionService.batchSave(asList);
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
	@RequestMapping("/deleteCollectionByTopic.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult deleteCollectionByTopic(Model model, String collectionId,String topicId) {
		if(StringUtils.isNotBlank(collectionId)) {
			LoginInfoDto user = Tools.getUser();
			if(StringUtils.isBlank(user.getId())) {
				return new JsonResult(0, "未登录");
			}
			
			MipTopicCollection deleteCollection = new MipTopicCollection();
			deleteCollection.setCollectionId(collectionId);
			deleteCollection.setTopicId(topicId);;				//删除
			int updateByidSelect = mipTopicCollectionService.deleteByTopicId(deleteCollection);
			if(updateByidSelect == 1) {
				return new JsonResult(1, "删除成功");
			}else {
				return new JsonResult(0, "删除失败");
			}
		}
		return new JsonResult(0, "信息错误");
	}
	
	/**
	 * 根据专题id，获取藏品导出
	 * @param topicIds
	 * @param response
	 */
	@RequestMapping("/exportCollection.do")
	@AuthPassport(authority = "contentCommon")
	public void exportCollection(String topicIds, HttpServletResponse response) {
		//查询藏品列表
		List<String> asList = Arrays.asList(topicIds.split(","));
		List<MipTopicCollectionDto> data = mipTopicCollectionService.getListByTopicIds(asList);
		
		String[] title = new String[] {"序号", "藏品名称", "类别", "级别", "一普编号", "年代", "存放博物馆"};
		String fileName = "藏品专题库藏品列表";
		List<Object[]> dataList = new ArrayList<>();
		for (int i=0; i<data.size(); i++) {
			MipTopicCollectionDto mipTopicCollectionDto = data.get(i);
			if(StringUtils.isBlank(mipTopicCollectionDto.getName())) {
				mipTopicCollectionDto.setName("-");
			}
			if(StringUtils.isBlank(mipTopicCollectionDto.getCollectionsCategory())) {
				mipTopicCollectionDto.setCollectionsCategory("-");
			}
			if(StringUtils.isBlank(mipTopicCollectionDto.getCollectionLevel())) {
				mipTopicCollectionDto.setCollectionLevel("-");
			}
			if(StringUtils.isBlank(mipTopicCollectionDto.getGsNo())) {
				mipTopicCollectionDto.setGsNo("-");
			}
			if(StringUtils.isBlank(mipTopicCollectionDto.getYearType())) {
				mipTopicCollectionDto.setYearType("-");
			}
			if(StringUtils.isBlank(mipTopicCollectionDto.getCollectionUnit())) {
				mipTopicCollectionDto.setCollectionUnit("-");
			}
			Object[] data1 = new Object[] {i+1, data.get(i).getName(), data.get(i).getCollectionsCategory(), 
					data.get(i).getCollectionLevel(), data.get(i).getGsNo(), 
					data.get(i).getYearType(), data.get(i).getCollectionUnit()};
			dataList.add(data1);
		}
		//导出
		ExportExcelUtil exportExcelUtil = new ExportExcelUtil(fileName, title, dataList, response);
		try {
			exportExcelUtil.export();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
