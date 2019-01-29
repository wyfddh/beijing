package com.tj720.admin.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj720.admin.model.GmReportForm;
import com.tj720.admin.service.GmReportFormService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/gmMuseumStatistics")
public class GmMuseumStatistics {
	
	@Autowired 
	private GmReportFormService gmReportFormService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@RequestMapping("/list")
	@AuthPassport
	public String list(Model model) {
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的级别
		String orgTypeId = org.getOrgTypeId();
		model.addAttribute("orgTypeId", orgTypeId);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String format = simpleDateFormat.format(date);
		model.addAttribute("format", format); 
		Integer museumPropertyCount1 = 0;
		Integer museumPropertyCount2 = 0;
		Integer museumPropertyCount3 = 0;
		Integer museumRelationCount1 = 0;
		Integer museumRelationCount2 = 0;
		Integer museumRelationCount3 = 0;
		Integer museumRelationCount4 = 0;
		Integer museumTypeCount1 = 0;
		Integer museumTypeCount2 = 0;
		Integer museumTypeCount3 = 0;
		Integer museumTypeCount4 = 0;
		Integer museumTypeCount5 = 0;
		Integer museumTypeCount6 = 0;
		Integer museumTypeCount7 = 0;
				
		List<GmReportForm> museumPropertyCount = gmReportFormService.selectMuseumPropertyCount();
		if (museumPropertyCount.size() > 0) {
			for (GmReportForm gmReportForm : museumPropertyCount) {
				if (gmReportForm.getMuseumProperty() == 1) {
					museumPropertyCount1 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumProperty() == 2) {
					museumPropertyCount2 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumProperty() == 3) {
					museumPropertyCount3 = gmReportForm.getCount();
				}
			}
		}
		List<GmReportForm> museumRelationCount = gmReportFormService.selectMuseumRelationCount();
		if (museumRelationCount.size() > 0) {
			for (GmReportForm gmReportForm : museumRelationCount) {
				if (gmReportForm.getMuseumRelation() == 1) {
					museumRelationCount1 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumRelation() == 2) {
					museumRelationCount2 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumRelation() == 3) {
					museumRelationCount3 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumRelation() == 4) {
					museumRelationCount4 = gmReportForm.getCount();
				}
			}
		}
		List<GmReportForm> museumTypeCount = gmReportFormService.selectMuseumTypeCount();
		if (museumTypeCount.size() > 0) {
			for (GmReportForm gmReportForm : museumTypeCount) {
				if (gmReportForm.getMuseumType().equals("1")) {
					museumTypeCount1 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumType().equals("2")) {
					museumTypeCount2 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumType().equals("3")) {
					museumTypeCount3 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumType().equals("4")) {
					museumTypeCount4 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumType().equals("5")) {
					museumTypeCount5 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumType().equals("6")) {
					museumTypeCount6 = gmReportForm.getCount();
				} else if (gmReportForm.getMuseumType().equals("7")) {
					museumTypeCount7 = gmReportForm.getCount();
				}
			}
		}
		model.addAttribute("museumPropertyCount1", museumPropertyCount1);
		model.addAttribute("museumPropertyCount2", museumPropertyCount2);
		model.addAttribute("museumPropertyCount3", museumPropertyCount3);
		model.addAttribute("museumRelationCount1", museumRelationCount1);
		model.addAttribute("museumRelationCount2", museumRelationCount2);
		model.addAttribute("museumRelationCount3", museumRelationCount3);
		model.addAttribute("museumRelationCount4", museumRelationCount4);
		model.addAttribute("museumTypeCount1", museumTypeCount1);
		model.addAttribute("museumTypeCount2", museumTypeCount2);
		model.addAttribute("museumTypeCount3", museumTypeCount3);
		model.addAttribute("museumTypeCount4", museumTypeCount4);
		model.addAttribute("museumTypeCount5", museumTypeCount5);
		model.addAttribute("museumTypeCount6", museumTypeCount6);
		model.addAttribute("museumTypeCount7", museumTypeCount7);
		return "/WEB-INF/back/gm/museumStatistics.jsp";
	}
}
