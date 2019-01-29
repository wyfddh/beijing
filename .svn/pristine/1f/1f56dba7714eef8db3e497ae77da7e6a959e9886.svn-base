package com.tj720.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.dto.CWenChuangDetailDto;
import com.tj720.admin.dto.CWenChuangDto;
import com.tj720.admin.model.MipWenchuangCategory;
import com.tj720.admin.service.WenChuangCategoryService;
import com.tj720.admin.service.WenChuangService;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.Page;

@RequestMapping("cWenChuang")
@Controller
public class CWenChuangController extends BaseController {
	
	@Autowired
	private WenChuangService wenChuangService;
	@Autowired
	private WenChuangCategoryService wenChuangCategoryService;
	
	@RequestMapping("getWenChuangList")
	@AuthPassport(authority = "SystemAdmin")
	public String getWenChuangList(ModelMap modelMap, Integer categoryId, String key, @RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue="10") int size ){
		try {
			//查询文创类型
			List<MipWenchuangCategory> categories = wenChuangCategoryService.getAll();
			modelMap.put("categories", categories);
			
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<CWenChuangDto> list = wenChuangService.getAllPublished(page, categoryId, key);
			modelMap.put("wenChuangList", list);
			modelMap.put("page", page);
			
			return "/WEB-INF/back/supplier/article/wenchuangList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	@RequestMapping("getCWenChuangDetail")
	@AuthPassport(authority = "SystemAdmin")
	public String getCWenChuangDetail(ModelMap modelMap, String id){
		try {
			CWenChuangDetailDto detail = wenChuangService.getCWenChuangDetail(id);
			modelMap.put("detail", detail);
			return "/WEB-INF/back/supplier/article/wenchuangdetail.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	@RequestMapping("publishDown")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String publishDown(ModelMap modelMap, String id, String reason){
		try {
			int update = wenChuangService.updatePublishDown(id, reason);
			return ""+update;
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
}
