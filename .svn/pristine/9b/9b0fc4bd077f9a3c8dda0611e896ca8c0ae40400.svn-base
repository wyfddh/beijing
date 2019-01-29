package com.tj720.mip.controller.admin;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.dto.MipLogSearchDto;
import com.tj720.admin.model.MipLog;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.service.MipLogService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@RequestMapping("/mipLog")
@Controller("miplogController_new")
public class MipLogController {
	
	@Autowired
	private MipLogService mipLogService;
	@Autowired
	private MipOrganizationService organizationService;

	//去日志列表页面
	@RequestMapping("/list.do")
	@ControllerAop(url="mipLog/list.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList(Model model) {
		List<MipOrganization> orgList = organizationService.getList();
		model.addAttribute("orgList", orgList);
		return "/WEB-INF/back/log/logList.jsp";
	}
	
	/**
	 * 后台日志查询页面
	 * @param modelMap
	 * @param size
	 * @param currentPage
	 * @param mipLog
	 * @return
	 */
	@RequestMapping("/getLogList")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public JSONObject getLogList(@RequestParam(defaultValue="15") int size, @RequestParam(defaultValue="1") int currentPage,MipLogSearchDto mipLog){
		LoginInfoDto user = Tools.getUser();
		if(StringUtils.isBlank(user.getId())) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", 0);
			jsonObject.put("msg","请先登陆"); 
			jsonObject.put("count", 0);
			jsonObject.put("data", null);
			return jsonObject;
		}
		
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		List<MipLog> listMipLog = mipLogService.listMipLogByKey(mipLog, page);
		
		for (MipLog mipLog2 : listMipLog) {
			String createtime = mipLog2.getCreatetime();
			Date stringToDate = DateUtil.StringToDate(createtime, DateStyle.YYYY_MM_DD_HH_MM_SS_NO);
			String newTime = DateUtil.DateToString(stringToDate, DateStyle.YYYY_MM_DD_HH_MM_SS);
			mipLog2.setCreatetime(newTime);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", listMipLog);
		return jsonObject;
	}
}
