package com.tj720.mip.controller.gov;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.dto.ReceiveNoticeDetailDto;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.GovNoticeService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.ReceiveNoticeService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 
 * @author lc 通知公告接收controller
 */
@Controller
@RequestMapping("/notice/receive")
public class ReceiveNoticeController extends BaseController {

	@Autowired
	private Config config;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private ReceiveNoticeService receiveNoticeService;
	@Autowired
	private IUserService userService;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	@Autowired
	private GovNoticeService govNoticeService;

	/**
	 * 通知公告list页面
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/goList.do")
	@ControllerAop(url = "notice/receive/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goList() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/gov/notice/receiveList.jsp");
		String hql = "from MipOrganization where status <> -127 ";
		List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql, Tools.getMap());
		modelAndView.addObject("orgList", orgList);
		return modelAndView;
	}

	/**
	 * 查看想详情页面
	 */
	@RequestMapping("/goDetail.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goDetail(String id) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/gov/notice/receiveNoticeDetail.jsp");
		ReceiveNoticeDetailDto receiveNoticeDetail = new ReceiveNoticeDetailDto();
		receiveNoticeDetail = receiveNoticeService.getDetail(id);
		String reportCode = receiveNoticeDetail.getReportCode();
		if (!StringUtils.isBlank(reportCode)) {
			Map<String, Object> selectReportById = govNoticeService.selectReportById(reportCode);
			if (selectReportById != null && !StringUtils.isBlank(selectReportById.get("id").toString())) {
				receiveNoticeDetail.setReportName(selectReportById.get("buss_name").toString());
				receiveNoticeDetail.setDefineCode(selectReportById.get("buss_code").toString());
				receiveNoticeDetail.setDefineId(selectReportById.get("define_id").toString());
			}
		}
		modelAndView.addObject("receiveNoticeDetail", receiveNoticeDetail);
		//传到前台 判断截止时间是否大于当前时间
		modelAndView.addObject("now", new Date());
		// 获取附件数据
		List<MipAttachment> attchmentList = mipAttachmentService.getListByFkid("gov_notice",
				receiveNoticeDetail.getId());
		List<Map<String, String>> attchmentDtoList = new ArrayList<>();
		for (MipAttachment attchment : attchmentList) {
			Map<String, String> map1 = new HashMap<>();
			map1.put("id", attchment.getAttId());
			map1.put("resultPath", attchment.getAttPath());
			map1.put("realFileName", attchment.getAttName());
			map1.put("isjunk", attchment.getAttIsjunk());
			map1.put("size", attchment.getAttSize() + "");
			map1.put("typeCode", attchment.getAttFileType() + "");
			attchmentDtoList.add(map1);
		}
		modelAndView.addObject("uploads", JSONObject.toJSONString(attchmentDtoList)); // 附件json
		return modelAndView;
	}

	/**
	 * 转发页面
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/goSend.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goSend(String id) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/gov/notice/sendNotice.jsp");
		modelAndView.addObject("id", id);
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String userOrg = user.getOrgId();
		String hql = "from User where status = 1 and orgId = '" + userOrg + "'";
		List<User> userList = (List<User>) userService.queryByHql(hql, Tools.getMap());
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}

	@RequestMapping("/getList.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getList(String key, String lastUpdateTime, String isFeedBack, String publishOrg,
			String receiveStatus, @RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size) {
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(1);
		List<ReceiveNoticeDto> receiveList = new ArrayList<ReceiveNoticeDto>();
		String startTime = null;
		String endTime = null;
		if (!StringUtil.isBlank(lastUpdateTime)) {
			startTime = lastUpdateTime.split(" - ")[0];
			endTime = lastUpdateTime.split(" - ")[1];
		}

		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String userOrg = user.getOrgId();
		MipOrganization organization = mipOrganizationService.get(userOrg);
		// 获取当前部门 通知消息接收人角色
		String role = organization.getShortname();
		List<MipUserDto> users = receiveNoticeService.getUsers(userOrg, role);
		for (MipUserDto mipUserDto : users) {
			if (user.getId().equals(mipUserDto.getId())) {
				// 用户属于通知公告接收人角色
				receiveList = receiveNoticeService.getList(null, userOrg, users, key, startTime, endTime, isFeedBack,
						publishOrg, receiveStatus, page);
				// 查询记录总条数
				Integer count = receiveNoticeService.countList(null, userOrg, key, startTime, endTime, isFeedBack,
						publishOrg, receiveStatus);
				page.setAllRow(count);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("code", 0);
				jsonObject.put("msg", "");
				jsonObject.put("count", page.getAllRow());
				jsonObject.put("data", receiveList);
				return jsonObject;
			}
		}
		// 用户不属于通知公告接收人角色 但是是最后的通知接收人
		receiveList = receiveNoticeService.getList(user.getId(), userOrg, users, key, startTime, endTime, isFeedBack,
				publishOrg, receiveStatus, page);
		// 查询记录总条数
		Integer count = receiveNoticeService.countList(user.getId(), userOrg, key, startTime, endTime, isFeedBack,
				publishOrg, receiveStatus);
		page.setAllRow(count);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", receiveList);
		return jsonObject;
	}

	/**
	 * 自定义表单回调，更新状态
	 * @param otherParameters	otherParameters={id:'11111111'}
	 * @param receiveStatus
	 * @param reportId
	 * @return
	 */
	@RequestMapping("/changeStatusByReport.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public String changeStatusByReport(String otherParameters, String receiveStatus, String reportId) {
		try {
			JSONObject parseObject = JSON.parseObject(otherParameters);
			String id = parseObject.getString("id");	
			receiveNoticeService.changeStatus(id, receiveStatus, reportId);
			return "1";
		} catch (Exception e) {
			return "2";
		}
	}

	/**
	 * 更新查阅状态
	 * 
	 * @param id
	 * @param receiveStatus
	 * @return
	 */
	@RequestMapping("/changeStatus.do")
	@AuthPassport(authority = "SystemAdmin")
	@ResponseBody
	public String changeStatus(String id, String receiveStatus) {
		try {
			receiveNoticeService.changeStatus(id, receiveStatus, null);
			return "1";
		} catch (Exception e) {
			return "2";
		}
	}

	/**
	 * 更新接收人
	 * 
	 * @param id
	 * @param receiveStatus
	 * @return
	 */
	@RequestMapping("/changeReceiver.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String changeReceiver(String id, String receiver) {
		try {
			receiveNoticeService.changeReceiver(id, receiver);
			return "1";
		} catch (Exception e) {
			return "2";
		}
	}

}
