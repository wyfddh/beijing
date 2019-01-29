package com.tj720.mip.controller.gov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dto.InsideInfoDto;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.GovNotice;
import com.tj720.admin.model.GovNoticeOrg;
import com.tj720.admin.model.MipArea;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.GovNoticeService;
import com.tj720.admin.service.IInsideInfoService;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.ReceiveNoticeService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.ExportExcelUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/notice/publish")
public class NoticePublishController extends BaseController<MipOrganization> {

	@Autowired
	private Config config;
	@Autowired
	private GovNoticeService govNoticeService;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	@Autowired
	private ReceiveNoticeService receiveNoticeService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipAreaService mipAreaService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IInsideInfoService insideInfoService;

	@RequestMapping("/goList.do")
	@ControllerAop(url="notice/publish/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList() {
		return "/WEB-INF/back/gov/NoticePublishList.jsp";
	}
	
	//去新增页面
	@RequestMapping("/goAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goAdd(Model model) {
		model.addAttribute("id", IdUtils.nextId(new GovNotice()));
		return "/WEB-INF/back/gov/noticePublishAdd.jsp";
	}
	
	//去选择填报页面
	@RequestMapping("/goSelectReport.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goSelectReport(Model model) {
		return "/WEB-INF/back/gov/selectReport.jsp";
	}
	
	//去新增表单页面
	@RequestMapping("/goReportAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goReportAdd(Model model) {
		return "/WEB-INF/back/gov/reportAdd.jsp";
	}
	
	//去编辑页面
	@RequestMapping("/goEdit.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goEdit(String id, Model model) {
		GovNotice govNotice = new GovNotice();
		govNotice = govNoticeService.get(id);
		if(govNotice != null && !StringUtil.isBlank(govNotice.getId())) {
			String reportCode = govNotice.getReportCode();
			if(!StringUtils.isBlank(reportCode)) {
				Map<String, Object> selectReportById = govNoticeService.selectReportById(reportCode);
				if(selectReportById != null && !StringUtils.isBlank(selectReportById.get("id").toString())) {
					govNotice.setReportName(selectReportById.get("buss_name").toString());
					govNotice.setDefineCode(selectReportById.get("define_code").toString());
					govNotice.setDefineId(selectReportById.get("define_id").toString());
				}
			}
			model.addAttribute("notice", govNotice);
			
			
			//获取receiveOrgs机构数据
			List<GovNoticeOrg> orgList = receiveNoticeService.getListByNoticeId(id);
			String orgListString = "";
			if(orgList != null && orgList.size() > 0) {
				for (GovNoticeOrg govNoticeOrg : orgList) {
					orgListString += govNoticeOrg.getOrgId() + ",";
				}
				if(!StringUtil.isBlank(orgListString)) {
					orgListString = orgListString.substring(0, orgListString.length()-1);
				}
			}
			model.addAttribute("receiveOrgs", orgListString);		//机构id，用逗号分隔
			
			//获取附件数据
			List<MipAttachment> attchmentList = mipAttachmentService.getListByFkid("gov_notice", id);
			List<Map<String, String>> attchmentDtoList = new ArrayList<>();
			for (MipAttachment attchment : attchmentList) {
				Map<String, String> map1 = new HashMap<>();
				map1.put("id", attchment.getAttId());
				map1.put("resultPath", attchment.getAttPath());
				map1.put("realFileName", attchment.getAttName());
				map1.put("isjunk", attchment.getAttIsjunk());
				map1.put("size", attchment.getAttSize()+"");
				map1.put("typeCode", attchment.getAttFileType()+"");
				map1.put("isnew", "0");
				attchmentDtoList.add(map1);
			}
			model.addAttribute("uploads", JSONObject.toJSONString(attchmentDtoList));		//附件json
		}
		return "/WEB-INF/back/gov/noticePublishEdit.jsp";
	}
	
	//去预览详情页面
	@RequestMapping("/goDetailView.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goDetailView(String id, Model model) {
		GovNotice govNotice = new GovNotice();
		govNotice = govNoticeService.get(id);
		if(govNotice != null && !StringUtil.isBlank(govNotice.getId())) {
			String reportCode = govNotice.getReportCode();
			if(!StringUtils.isBlank(reportCode)) {
				Map<String, Object> selectReportById = govNoticeService.selectReportById(reportCode);
				if(selectReportById != null && !StringUtils.isBlank(selectReportById.get("id").toString())) {
					govNotice.setReportName(selectReportById.get("buss_name").toString());
					govNotice.setDefineCode(selectReportById.get("define_code").toString());
					govNotice.setDefineId(selectReportById.get("define_id").toString());
				}
			}
			model.addAttribute("notice", govNotice);
			
			//获取receiveOrgs机构数据
			List<GovNoticeOrg> orgList = receiveNoticeService.getListByNoticeId(id);
			String orgListString = "";
			if(orgList != null && orgList.size() > 0) {
				for (GovNoticeOrg govNoticeOrg : orgList) {
					orgListString += govNoticeOrg.getOrgId() + ",";
				}
				if(!StringUtil.isBlank(orgListString)) {
					orgListString = orgListString.substring(0, orgListString.length()-1);
				}
			}
			model.addAttribute("receiveOrgs", orgListString);		//机构id，用逗号分隔
			
			//获取附件数据
			List<MipAttachment> attchmentList = mipAttachmentService.getListByFkid("gov_notice", id);
			List<Map<String, String>> attchmentDtoList = new ArrayList<>();
			for (MipAttachment attchment : attchmentList) {
				Map<String, String> map1 = new HashMap<>();
				map1.put("id", attchment.getAttId());
				map1.put("resultPath", attchment.getAttPath());
				map1.put("realFileName", attchment.getAttName());
				map1.put("isjunk", attchment.getAttIsjunk());
				map1.put("size", attchment.getAttSize()+"");
				map1.put("typeCode", attchment.getAttFileType()+"");
				map1.put("isnew", "0");
				attchmentDtoList.add(map1);
			}
			model.addAttribute("uploads", JSONObject.toJSONString(attchmentDtoList));		//附件json
		}
		return "/WEB-INF/back/gov/noticePublishDetailView.jsp";
	}

	//去接收单位选择页面
	@RequestMapping("/goSelectReceive.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goSelectReceive() {
		return "/WEB-INF/back/gov/noticePublishMuseSelect.jsp";
	}
	
	//去通知公告查阅/填报情况列表页
	@RequestMapping("/goReceiveCondition.do")
	public String goReceiveCondition(String id, Model model) {
		GovNotice govNotice = govNoticeService.get(id);
		model.addAttribute("isfeedback", govNotice.getIsfeedback());
		model.addAttribute("noticeId", id);
		return "/WEB-INF/back/gov/NoticeReceiveCondition.jsp";
	}

	/**
	 * 通知发布列表页数据请求
	 * 
	 * @param page
	 * @param key
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param publisher
	 * @return
	 */
	@RequestMapping("/getListData.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JSONObject getListData(String key, String dateRange, String status, String publisher,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		
		
		String startDate = null;
		String endDate = null;
		
		if(!StringUtil.isBlank(dateRange)) {
			startDate = dateRange.split(" - ")[0];
			endDate = dateRange.split(" - ")[1];
		}
		
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		List<GovNotice> list = govNoticeService.getList(page, key, startDate, endDate, status, publisher,
				userDto.getId());

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", list);
		
		return jsonObject;
	}
	
	/**
	 * 通知公告接收查看/填报详情页数据请求
	 * @param key
	 * @param lookStatus
	 * @param writeStatus
	 * @param noticeId
	 * @param currentPage
	 * @param size
	 * @return
	 */
	@RequestMapping("/getReceiveListCondition.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JSONObject getReceiveListCondition(String key, String lookStatus, String writeStatus, String noticeId,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		
		//String noticeId, String key, String lookStatus, String writeStatus,Page page
		List<ReceiveNoticeDto> list = receiveNoticeService.getListByNoticeId(noticeId, key, lookStatus, writeStatus, page);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", list);
		
		return jsonObject;
	}
	
	/**
	 * 请求当前区数据
	 * @return
	 */
	@RequestMapping("/getTownData.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult getTownData() {
		String currentCity = config.getCityId();
		List<MipArea> cityListByPid = mipAreaService.getCityListByPid(NumberUtils.stringToInt(currentCity));
		return new JsonResult(1, cityListByPid);
	}
	
	/**
	 * 通知公告保存
	 * @param notice				
	 * @param temp_deadlineTime		临时字段
	 * @param receiveOrgs			//单位id逗号分隔
	 * @param uploads		json字符串
	 * @return
	 */
	@RequestMapping("/saveNoticePublish.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult saveNoticePublish(GovNotice notice, String temp_deadlineTime, String receiveOrgs, String uploads, String submitStatus) {
		LoginInfoDto currentUser = Tools.getUser();
		if(StringUtil.isBlank(currentUser.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		User user = userService.get(currentUser.getId());
		if(user == null || StringUtil.isBlank(user.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		if(StringUtil.isBlank(notice.getTitle())) {
			new JsonResult(0, "标题为空", 0, null);
		}
		if(StringUtil.isBlank(notice.getContent())) {
			new JsonResult(0, "内容为空", 0, null);
		}
		if(StringUtil.isBlank(receiveOrgs)) {
			new JsonResult(0, "接收单位为空", 0, null);
		}
		notice.setId(IdUtils.nextId(new GovNotice()));
//		if("2".equals(submitStatus)) {
			notice.setPublisher(user.getId());
			notice.setPublishorg(user.getOrgId());
//		}
		Date currentTime = new Date();
		notice.setCreateTime(currentTime);
		notice.setLastupdateTime(currentTime);
		notice.setPublishStatus(submitStatus);
		notice.setCreater(user.getId());
		
		List<MipAttachment> attchList = new ArrayList<>();
		String attachment_ids = "";
		if(!StringUtil.isBlank(uploads)) {
			JSONArray fromObject = JSONArray.fromObject(uploads);
			for (int i = 0; i < fromObject.size(); i++) {
				net.sf.json.JSONObject jsonObject = fromObject.getJSONObject(i);
				MipAttachment cAttchment = new MipAttachment();
				cAttchment.setAttId(jsonObject.getString("id"));			//id
				cAttchment.setAttIsjunk(jsonObject.getString("isjunk"));			//是否删除
				cAttchment.setAttName(jsonObject.getString("realFileName"));			//原始文件名称
				cAttchment.setAttSize(jsonObject.getLong("size"));			//大小
				cAttchment.setAttPath(jsonObject.getString("resultPath"));		//上传后的相对路径
				cAttchment.setAttDate(new Date());			//上传时间
				cAttchment.setAttFileType(jsonObject.getInt("typeCode"));		//文件类型
				cAttchment.setAttrUser(user.getId());		//上传人
				cAttchment.setAttType("gov_notice");		//关联表名称
				cAttchment.setAttFkId(notice.getId());		//关联表id
				
				attachment_ids += cAttchment.getAttId() + ",";
				attchList.add(cAttchment);
			}
			if(!StringUtil.isBlank(attachment_ids)) {
				attachment_ids = attachment_ids.substring(0, attachment_ids.length()-1);
			}
		}
		notice.setAttachmentIds(attachment_ids);
		if("1".equals(notice.getIsfeedback())) {
			if(!"1".equals(notice.getIsfill())) {
				notice.setIsfill("0");
			}
			if(!StringUtil.isBlank(temp_deadlineTime)) {
				notice.setDeadlineTime(DateUtil.StringToDate(temp_deadlineTime));
			}
		}else {
			notice.setIsfeedback("0");
			notice.setDeadlineTime(null);
			notice.setIsfill("0");
		}
		//保存通知
		govNoticeService.create(notice);
		
		//批量保存文件
		if(attchList != null && attchList.size() > 0) {
			mipAttachmentService.batchSave(attchList);
		}
		
		//批量保存通知机构表
		String[] receives = receiveOrgs.split(",");
		List<GovNoticeOrg> govNoticeOrgList = new ArrayList<>();
		for (String orgId : receives) {
			GovNoticeOrg norg = new GovNoticeOrg();
			norg.setId(IdUtils.nextId(norg));
			norg.setNoticeId(notice.getId());
			norg.setOrgId(orgId);
			norg.setReceiveStatus("0");
			govNoticeOrgList.add(norg);
		}
		receiveNoticeService.batchSave(govNoticeOrgList);
		
		return new JsonResult(1, "保存成功", 0, null);
	}

	/**
	 * 删除通知公告
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteNotice.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult deleteNotice(String id) {
		govNoticeService.deleteNotice(id);
		return new JsonResult(1, "删除成功", 0, null);
	}
	
	/**
	 * 发布通知公告
	 * @param id
	 * @return
	 */
	@RequestMapping("/publishNotice.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult publishNotice(String id) {
		LoginInfoDto us = Tools.getUser();
		if(StringUtil.isBlank(us.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		User user = userService.get(us.getId());
		if(user == null || StringUtil.isBlank(user.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		//先查询当前是否为撤回状态
		GovNotice oldNotice = govNoticeService.get(id);
		if("3".equals(oldNotice.getPublishStatus())) {
			//将当前org状态为3的全部更新为0状态
			List<GovNoticeOrg> listByNoticeId = receiveNoticeService.getListByNoticeId(id);
			for (GovNoticeOrg govNoticeOrg : listByNoticeId) {
				if("3".equals(govNoticeOrg.getReceiveStatus())) {
					receiveNoticeService.changeStatus(govNoticeOrg.getId(), "0",null);
				}
			}
		}
		GovNotice govNotice = new GovNotice();
		govNotice.setId(id);
		govNotice.setPublishStatus("2");
		govNotice.setLastupdateTime(new Date());
		govNotice.setPublisher(user.getId());
		govNotice.setPublishorg(user.getOrgId());
		int result = govNoticeService.updateByPrimaryKeySelective(govNotice);
		if(result == 1) {
			return new JsonResult(1, "发布成功", 0, null);
		}else {
			return new JsonResult(0, "发布失败", 0, null);
		}
	}

	/**
	 * 撤回通知公告
	 * @param id
	 * @return
	 */
	@RequestMapping("/backNotice.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult backNotice(String id) {
		LoginInfoDto us = Tools.getUser();
		if(StringUtil.isBlank(us.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		User user = userService.get(us.getId());
		if(user == null || StringUtil.isBlank(user.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		
		GovNotice govNotice = new GovNotice();
		govNotice.setId(id);
		govNotice.setPublishStatus("3");
		govNotice.setLastupdateTime(new Date());
//		govNotice.setPublisher(user.getId());
//		govNotice.setPublishorg(user.getOrgId());
		int result = govNoticeService.updateByPrimaryKeySelective(govNotice);
		if(result == 1) {
			//撤回所有通知公告机构表数据
			int backResult = receiveNoticeService.updateStatusByNoticeId(id, "3");
			if(backResult >= 1) {
				return new JsonResult(1, "撤回成功", 0, null);
			}
		}
		return new JsonResult(0, "撤回失败", 0, null);
	}
	
	/**
	 * 通知公告编辑修改
	 * @param notice				
	 * @param temp_deadlineTime		临时字段
	 * @param receiveOrgs			//单位id逗号分隔
	 * @param uploads		json字符串
	 * @return
	 */
	@RequestMapping("/editNotice.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult editNotice(GovNotice notice, String temp_deadlineTime, String receiveOrgs, String uploads, String submitStatus) {
		LoginInfoDto currentUser = Tools.getUser();
		if(StringUtil.isBlank(currentUser.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		User user = userService.get(currentUser.getId());
		if(user == null || StringUtil.isBlank(user.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		if(StringUtil.isBlank(notice.getTitle())) {
			new JsonResult(0, "标题为空", 0, null);
		}
		if(StringUtil.isBlank(notice.getContent())) {
			new JsonResult(0, "内容为空", 0, null);
		}
		if(StringUtil.isBlank(receiveOrgs)) {
			new JsonResult(0, "接收单位为空", 0, null);
		}
		try {
			//查询当前数据
			GovNotice cNotice = govNoticeService.get(notice.getId());
			
			GovNotice saveNotice = new GovNotice();
			saveNotice.setId(notice.getId());
			saveNotice.setTitle(notice.getTitle());
			saveNotice.setContent(notice.getContent());
			saveNotice.setReportCode(notice.getReportCode());
			if("2".equals(submitStatus)) {
				saveNotice.setPublisher(user.getId());
				saveNotice.setPublishorg(user.getOrgId());
			}
			Date currentTime = new Date();
			saveNotice.setLastupdateTime(currentTime);
			saveNotice.setPublishStatus(submitStatus);
			
			if(!"2".equals(cNotice.getPublishStatus())) {
				List<MipAttachment> attchList = new ArrayList<>();
				String attachment_ids = "";
				if(!StringUtil.isBlank(uploads)) {
					JSONArray fromObject = JSONArray.fromObject(uploads);
					for (int i = 0; i < fromObject.size(); i++) {
						net.sf.json.JSONObject jsonObject = fromObject.getJSONObject(i);
						String attchid = jsonObject.getString("id");
						String isjunk = jsonObject.getString("isjunk");
						String isnew = jsonObject.getString("isnew");
						
						if(!StringUtil.isBlank(isnew) && "1".equals(isnew)) {		//新文件保存
							MipAttachment cAttchment = new MipAttachment();
							cAttchment.setAttId(jsonObject.getString("id"));			//id
							cAttchment.setAttIsjunk(jsonObject.getString("isjunk"));			//是否删除
							cAttchment.setAttName(jsonObject.getString("realFileName"));			//原始文件名称
							cAttchment.setAttSize(jsonObject.getLong("size"));			//大小
							cAttchment.setAttPath(jsonObject.getString("resultPath"));		//上传后的相对路径
							cAttchment.setAttDate(new Date());			//上传时间
							cAttchment.setAttFileType(jsonObject.getInt("typeCode"));		//文件类型
							cAttchment.setAttrUser(user.getId());		//上传人
							cAttchment.setAttType("gov_notice");		//关联表名称
							cAttchment.setAttFkId(notice.getId());		//关联表id
							
							attachment_ids += attchid + ",";
							attchList.add(cAttchment);
						}else {		//旧文件
							if("1".equals(isjunk)) {		//需要删除的文件
								mipAttachmentService.deleteFile(attchid);
							}else {
								attachment_ids += attchid + ",";
							}
						}
					}
					if(!StringUtil.isBlank(attachment_ids)) {
						attachment_ids = attachment_ids.substring(0, attachment_ids.length()-1);
					}
				}
				saveNotice.setAttachmentIds(attachment_ids);
				
				//批量保存文件
				if(attchList != null && attchList.size() > 0) {
					mipAttachmentService.batchSave(attchList);
				}
				//批量保存通知机构表
				String[] receives = receiveOrgs.split(",");
				List<String> receivesList = Arrays.asList(receives);
				//获取receiveOrgs机构数据
				List<GovNoticeOrg> corgList = receiveNoticeService.getListByNoticeId(cNotice.getId());
				List<String> corgStringList = new ArrayList<>();
				for (GovNoticeOrg corg : corgList) {
					corgStringList.add(corg.getOrgId());
				}
				List<String> addReceives = new ArrayList<>();		//新增数据
				addReceives.addAll(receivesList);
				addReceives.removeAll(corgStringList);
				
				List<String> deleteReceives = new ArrayList<>();		//删除数据
				deleteReceives.addAll(corgStringList);
				deleteReceives.removeAll(receivesList);
				
				List<GovNoticeOrg> govNoticeOrgList = new ArrayList<>();
				for (String orgId : addReceives) {		//新增数据
					GovNoticeOrg norg = new GovNoticeOrg();
					norg.setId(IdUtils.nextId(norg));
					norg.setNoticeId(notice.getId());
					norg.setOrgId(orgId);
					norg.setReceiveStatus("0");
					govNoticeOrgList.add(norg);
				}
				if(govNoticeOrgList != null && govNoticeOrgList.size() > 0) {
					receiveNoticeService.batchSave(govNoticeOrgList);		//批量新增
				}
				
				for (String orgId : deleteReceives) {		//批量删除
					receiveNoticeService.deleteByOrgIdAndNoticeid(orgId, notice.getId());
				}
				
				receiveNoticeService.updateStatusByNoticeId(notice.getId(), "0");
			}
			if("1".equals(notice.getIsfeedback())) {
				saveNotice.setIsfeedback("1");
				if(!"1".equals(notice.getIsfill())) {
					saveNotice.setIsfill("0");
				}else {
					saveNotice.setIsfill("1");
				}
				if(!StringUtil.isBlank(temp_deadlineTime)) {
					saveNotice.setDeadlineTime(DateUtil.StringToDate(temp_deadlineTime));
				}
			}else {
				saveNotice.setIsfeedback("0");
				saveNotice.setDeadlineTime(null);
				saveNotice.setIsfill("0");
			}
			//保存通知
			govNoticeService.updateByPrimaryKeySelectiveOutDeadlineTime(saveNotice);
			return new JsonResult(1, "保存成功", 0, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统错误", 0, null);
		}
	}
	
	/**
	 * 通知公告接收查看/填报详情页数据请求---导出
	 * @param key
	 * @param lookStatus
	 * @param writeStatus
	 * @param noticeId
	 * @param currentPage
	 * @param size
	 * @return
	 */
	@RequestMapping("/exportReceiveListCondition.do")
	@AuthPassport(authority = "SystemAdmin")
	public void exportReceiveListCondition(String key, String lookStatus, String writeStatus, String noticeId, HttpServletResponse response) {
		Page page = new Page();
		page.setSize(2147483647);
		page.setCurrentPage(1);
		List<ReceiveNoticeDto> list = receiveNoticeService.getListByNoticeId(noticeId, key, lookStatus, writeStatus, page);
		GovNotice govNotice = govNoticeService.get(noticeId);
		
		//表头数据
		String[] title = null; 
		String fileName = "";
		String isFeedBack = govNotice.getIsfeedback();
		if("1".equals(isFeedBack)) {
			title = new String[] {"序号", "机构单位名称", "查阅状态", "查阅时间", "填报状态", "填报时间"};
			fileName = govNotice.getTitle()+"-填报情况";
		}else {
			title = new String[] {"序号", "机构单位名称", "查阅状态", "查阅时间"};
			fileName = govNotice.getTitle()+"-查阅情况";
		}
		
		List<Object[]> dataList = new ArrayList<>();
		int i = 1;
		for (ReceiveNoticeDto noticeOrg : list) {
			String lookStatue = "-";		//查阅状态
			String writeStatue = "-";		//填报状态
			String lookTime = "-";		//查阅时间
			String writeTime = "-";		//填报时间
			if("0".equals(noticeOrg.getReceiveStatus())) {
				lookStatue = "未查阅";
			}else {
				lookStatue = "已查阅";
				lookTime = DateUtil.DateToString(noticeOrg.getLookTime(), DateStyle.YYYY_MM_DD_HH_MM);
			}
			if("0".equals(noticeOrg.getReceiveStatus()) || "1".equals(noticeOrg.getReceiveStatus())) {
				writeStatue = "未填写";
			}else if("2".equals(noticeOrg.getReceiveStatus())) {
				writeStatue = "未提交";
				writeTime = DateUtil.DateToString(noticeOrg.getWriteTime(), DateStyle.YYYY_MM_DD_HH_MM);
			}else if("4".equals(noticeOrg.getReceiveStatus())) {
				writeStatue = "已提交";
				writeTime = DateUtil.DateToString(noticeOrg.getWriteTime(), DateStyle.YYYY_MM_DD_HH_MM);
			}
			Object[] data1 = new Object[] {i, noticeOrg.getReceiveOrgName(), lookStatue, lookTime, writeStatue, writeTime};
			Object[] data2 = new Object[] {i, noticeOrg.getReceiveOrgName(), lookStatue, lookTime};
			if("1".equals(isFeedBack)) {
				dataList.add(data1);
			}else {
				dataList.add(data2);
			}
			i++;
		}
		
		//导出
		ExportExcelUtil exportExcelUtil = new ExportExcelUtil(fileName, title, dataList, response);
		try {
			exportExcelUtil.export();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 一键催办
	 * @param checkOrg
	 * @param isfeedback
	 * @param noticeId
	 * @param response
	 * @return
	 */
	@RequestMapping("/OnekeyUrges.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public JsonResult OnekeyUrges(String checkOrg,String isfeedback, String noticeId, HttpServletResponse response) {
		LoginInfoDto currentUser = Tools.getUser();
		if(StringUtil.isBlank(currentUser.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		User user = userService.get(currentUser.getId());
		if(user == null || StringUtil.isBlank(user.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		
		List<GovNoticeOrg> list = null;
		if(StringUtils.isBlank(checkOrg)) {	//没有选择接收对象
			return new JsonResult(0, "接收对象为空", 0, null);
		}else {
			try {
				String title = "";		//发送标题
				String content = "";		//发送内容
				GovNotice govNotice = govNoticeService.get(noticeId);
				if("true".equals(isfeedback)) {
					title = "您有一条通知公告未填报，请尽快查阅与填报";
					content = "您有一条通知公告未填报，通知公告标题为《"+govNotice.getTitle()+"》，请尽快查阅与填报";
				}else {
					title = "您有一条通知公告未查阅，请及时查阅";
					content = "您有一条通知公告未查阅，通知公告标题为《"+govNotice.getTitle()+"》，请及时查阅";
				}
				
				//查询接收对象
				String[] orgs = checkOrg.split(",");
				HashSet<String> recevers = new HashSet<String>();		//所有接收人
				if(orgs != null && orgs.length > 0) {
					List<String> receverList = receiveNoticeService.getReceverList(orgs);
					recevers.addAll(receverList);
					//查询所有转发接收人id
					List<String> forwardByOrgids = receiveNoticeService.getForwardByOrgids(orgs, noticeId);
					recevers.addAll(forwardByOrgids);
					
					//批量发送通知公告
					List<InsideInfoDto> insideInfoList = new ArrayList<>();
					Iterator<String> iterator = recevers.iterator();
					while(iterator.hasNext()) {
						String currentRecever = iterator.next();
						InsideInfoDto insideInfo = new InsideInfoDto();
						insideInfo.setCreatedBy(user.getId());
						insideInfo.setLastUpdatedBy(user.getId());
						insideInfo.setInfoTitle(title);
						insideInfo.setInfoContent(content);
						insideInfo.setReceiverId(currentRecever);
						insideInfo.setStatus("2");
						insideInfoList.add(insideInfo);
					}
					if(insideInfoList != null && insideInfoList.size() > 0) {
						int batchSave = insideInfoService.batchSave(insideInfoList);
						if(batchSave > 0) {
							return new JsonResult(1, "通知成功", 0, null);
						}else {
							return new JsonResult(0, "通知失败", 0, null);
						}
					}else {
						return new JsonResult(0, "接收对象为空", 0, null);
					}
				}else {
					return new JsonResult(0, "接收对象为空", 0, null);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0, "系统错误", 0, null);
			}
		}
	}
	

	/**
	 * 表单列表请求
	 * @param item
	 * @param name
	 * @return
	 */
	@RequestMapping("/getReportListDate.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult getReportListDate(String item, String name) {
		LoginInfoDto userDto = Tools.getUser();
		if(StringUtils.isBlank(userDto.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		User user = userService.get(userDto.getId());
		List<Map<String, Object>> selectReport = govNoticeService.selectReport(item, name, user.getOrgId());
		return new JsonResult(1, "加载成功", 0, selectReport);
	}

	
	@RequestMapping("/getReportData.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getReportData(String id) {
		LoginInfoDto userDto = Tools.getUser();
		if(StringUtils.isBlank(userDto.getId())) {
			return new JsonResult(0, "请先登陆", 0, null);
		}
		Map<String, Object> selectReportById = govNoticeService.selectReportById(id);
		if(selectReportById != null && !StringUtils.isBlank(selectReportById.get("buss_code").toString())) {
			return new JsonResult(1, "加载成功", 0, selectReportById.get("buss_code").toString());
		}
		return new JsonResult(0, "加载失败", 0, null);
	}
	
	/**
	 * list集合去重
	 * @param list
	 */
	private static void removeDuplicate(List<String> list) {
	    LinkedHashSet<String> set = new LinkedHashSet<String>(list.size());
	    set.addAll(list);
	    list.clear();
	    list.addAll(set);
	}
	
}
