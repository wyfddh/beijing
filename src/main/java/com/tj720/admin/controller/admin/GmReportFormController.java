package com.tj720.admin.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.GmAudit;
import com.tj720.admin.model.GmReportForm;
import com.tj720.admin.model.GmReportUpload;
import com.tj720.admin.model.RegisterInfo;
import com.tj720.admin.service.GmAuditService;
import com.tj720.admin.service.GmReportFormService;
import com.tj720.admin.service.GmReportUploadService;
import com.tj720.admin.service.RegisterInfoService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/gmReportForm")
public class GmReportFormController {
	@Autowired 
	private GmReportFormService gmReportFormService;
	@Autowired 
	private RegisterInfoService registerInfoService;
	@Autowired
	private GmReportUploadService gmReportUploadService;
	@Autowired
	private GmAuditService gmAuditService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	
	@ResponseBody
	@RequestMapping("save")
	@AuthPassport
	public String save(GmReportForm gmReportForm) {
		if (gmReportForm.getId() != null || gmReportForm.getId() != "") {
			gmReportFormService.update(gmReportForm);
			
		} else {
			String nextId = IdUtils.nextId(gmReportForm);
			gmReportForm.setId(nextId);
			gmReportFormService.save(gmReportForm);
		}
		return "ok";
	}
	
	@RequestMapping("form")
	@AuthPassport
	public String form(@RequestParam("reportId") String reportId,Model model) {
		//根据传的reportid查询详细申报的表
		GmReportForm gmReportForm = gmReportFormService.getByReportId(reportId);
		
		model.addAttribute("gmReportForm", gmReportForm);
		//查询该申报
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		
		model.addAttribute("registerInfo", registerInfo);
		
		return "/WEB-INF/back/gm/reportForm.jsp";
	}
	@RequestMapping("show")
	@AuthPassport
	public String show(@RequestParam("reportId") String reportId,Model model) throws ParseException {
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的组织类型
		String orgTypeId = org.getOrgTypeId();
		model.addAttribute("orgTypeId", orgTypeId);
		RegisterInfo report = registerInfoService.getById(reportId);
		
		GmReportForm gmReportForm = gmReportFormService.getByReportId(reportId);
		
		GmAudit gmAudit = gmAuditService.getByReportId(reportId);
		
		if (gmAudit != null) {
			//设置几个时间格式
			if (!StringUtils.isBlank(gmReportForm.getNowLevelDate())) {
				gmReportForm.setNowLevelDate(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(gmReportForm.getNowLevelDate())));
			}
			if (!StringUtils.isBlank(gmReportForm.getCreatDate())) {
				gmReportForm.setCreatDate(new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(gmReportForm.getCreatDate())));
			}
			if (!StringUtils.isBlank(gmReportForm.getOpenDate())) {
				gmReportForm.setOpenDate(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(gmReportForm.getOpenDate())));
			}
			if (!StringUtils.isBlank(gmReportForm.getLegalPersonBirth())) {
				gmReportForm.setLegalPersonBirth(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(gmReportForm.getLegalPersonBirth())));
			}
		}
		
		List<GmReportUpload> reportUploads = gmReportUploadService.getByReportId(reportId);
		
		model.addAttribute("report", report);
		model.addAttribute("gmReportForm", gmReportForm);
		model.addAttribute("reportUploads", reportUploads);
		model.addAttribute("gmAudit", gmAudit);
		//转成json格式方便页面js直接遍历
		String jsonString = JSON.toJSONString(reportUploads);
		model.addAttribute("jsonString", jsonString);
		String jsonStr = JSON.toJSONString(gmAudit);
		model.addAttribute("jsonStr", jsonStr);
		
		return "/WEB-INF/back/gm/auditView.jsp";
	}
}
