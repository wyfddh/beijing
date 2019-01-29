package com.tj720.admin.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.dto.CCompanyDto;
import com.tj720.admin.service.CCompanyService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@RequestMapping("/cCompany")
@Controller
public class CCompanyController extends BaseController {

	@Autowired
	private CCompanyService cCompanyService;
	
	/**
	 * 企业详细信息
	 * @return
	 */
	@RequestMapping("getDetail")
	@ResponseBody
	public ModelAndView getDetail(String id){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/supplier/detail.jsp");
		try {
			if (MyString.isEmpty(id)) {
				System.out.println("id为空");
				return new ModelAndView("/WEB-INF/back/error.jsp");
			}
			CCompanyDto detail = cCompanyService.getDetail(id);
			modelAndView.addObject("result", detail);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
	}
	
	/**
	 * 获取所有企业信息
	 * @param size
	 * @param currentPage
	 * @param companyName
	 * @param phone
	 * @return
	 */
	@RequestMapping("getCcompanies")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView getCcompanies(@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage, String companyName, String phone){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/supplier/comList.jsp");
		try {
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			Map map = cCompanyService.getAllCompanies(page, companyName, phone);
			modelAndView.addObject("result", map);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
	}
	
	/**
	 * 启用企业
	 * @param id
	 * @return
	 */
	@RequestMapping("enable")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String enable(String id){
		try {
			if (MyString.isEmpty(id)) {
				return "/WEB-INF/back/error.jsp";
			}
			int update = cCompanyService.enable(id);
			if (update == 1) {
				return "1";
			} else {
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	/**
	 * 停用企业
	 * @param id
	 * @return
	 */
	@RequestMapping("notEnable")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String notEnable(String id){
		try {
			if (MyString.isEmpty(id)) {
				return "/WEB-INF/back/error.jsp";
			}
			int update = cCompanyService.notEnable(id);
			if (update == 1) {
				return "1";
			} else {
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	
	/**
	 * 审核企业信息列表
	 * @param size
	 * @param currentPage
	 * @param status
	 * @param companyName
	 * @param categoryName
	 * @return
	 */
	@RequestMapping("getCheckCCompanies")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView getCheckCCompanies(@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue="1") int status, String companyName, String categoryName){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/supplier/checkList.jsp");
		try {
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			Map map = cCompanyService.getCheckCCompanies(page, companyName, status, categoryName);
			modelAndView.addObject("result", map);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
	}
	
	/**
	 * 审核企业信息
	 * @param id
	 * @param auditMsg
	 * @param status
	 * @return
	 */
	@RequestMapping("checkCCompany")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String checkCCompany(String id, String auditMsg, @RequestParam(defaultValue="2") int status){
		try {
			if (MyString.isEmpty(id)) {
				System.out.println("id为空");
				return "/WEB-INF/back/error.jsp";
			}
			int update = cCompanyService.checkCCompany(id, auditMsg, status);
			if (update == 1) {
				return "1";
			} else {
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
}
