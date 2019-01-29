package com.tj720.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj720.admin.dto.MipFrontLogSearchDto;
import com.tj720.admin.dto.MipLogSearchDto;
import com.tj720.admin.model.MipFrontLog;
import com.tj720.admin.model.MipLog;
import com.tj720.admin.service.MipFrontLogService;
import com.tj720.admin.service.MipLogService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@RequestMapping("/mipLog")
@Controller("miplogController")
public class LogController {
	
	@Autowired
	private MipLogService mipLogService;
	@Autowired
	private MipFrontLogService mipFrontLogService;

	/**
	 * 后台日志查询页面
	 * @param modelMap
	 * @param size
	 * @param currentPage
	 * @param mipLog
	 * @return
	 */
	@RequestMapping("/getInfoList")
	@AuthPassport(authority="collectionAdmin")
	public String getInfoList(ModelMap modelMap,@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage,MipLogSearchDto mipLog){
		try {
			LoginInfoDto user = Tools.getUser();
			if (MyString.isEmpty(user)) {
				return "/WEB-INF/back/login/login.jsp";
			}
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<MipLog> listMipLog = mipLogService.listMipLog(mipLog,page);
			modelMap.put("listMipLog", listMipLog);
			modelMap.put("page", page);
			modelMap.put("dto", mipLog);
			return "/WEB-INF/back/log/infoList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	/**
	 * 前台日志查询页面
	 * @param modelMap
	 * @param size
	 * @param currentPage
	 * @param mipLog
	 * @return
	 */
	@RequestMapping("/getFrontInfoList")
	@AuthPassport(authority="collectionAdmin")
	public String getFrontInfoList(ModelMap modelMap,@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage,MipFrontLogSearchDto mipLog){
		try {
			LoginInfoDto user = Tools.getUser();
			if (MyString.isEmpty(user)) {
				return "/WEB-INF/back/login/login.jsp";
			}
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<MipFrontLog> listMipLog = mipFrontLogService.listMipLog(mipLog,page);
			modelMap.put("listMipLog", listMipLog);
			modelMap.put("page", page);
			modelMap.put("dto", mipLog);
			return "/WEB-INF/back/log/frontInfoList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
}
