package com.tj720.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.dto.CurationDto;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationExample;
import com.tj720.admin.service.ExtCurationService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/curation")
public class CurationController extends com.tj720.admin.base.controller.BaseController{
	
	@Autowired
	private ExtCurationService extCurationService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@RequestMapping("/curation.do")
	@AuthPassport(authority = "SystemAdmin")
	public String getCuration(@ModelAttribute Curation curation,ModelMap modelMap,String keys,
			@RequestParam(defaultValue="1" ,name="page") Integer currentPage,@RequestParam(defaultValue = "10") int size){
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		byte level = org.getLevel();
		
		CurationExample cura = new CurationExample();
		int allPage = 0;
		if(currentPage>0){
			cura.setStartPage((currentPage-1)*cura.getSize());
			if(currentPage*cura.getSize()>allPage){
				cura.setSize(allPage-(currentPage-1)*cura.getSize());
			}
		}
		if(curation.getOverTime()!=null&&!"".equals(curation.getOverTime())){
			String a  = curation.getOverTime().replace("-", "")+"000000";
			cura.setOverTime(a);
		}
		if(curation.getStaTime()!=null&&!"".equals(curation.getStaTime())){
			String b = curation.getStaTime().replace("-", "")+"000000";
			cura.setStaTime(b);
		}
		if(curation.getPublish()!=null&&!"0".equals(curation.getPublish())){
			cura.setPublish(curation.getPublish());
		}
		if(curation.getPublish()==null){
			cura.setPublish("2");
		}
		if(keys!=null&&!"".equals(keys)){
			cura.setKeys(keys);
		}
		allPage = extCurationService.allPage(cura);
		cura.setSize(size);
		cura.setCurrentPage(currentPage);
		if(allPage%10>0){
			cura.setTotalPage(allPage/size+1);
		}else{
			cura.setTotalPage(allPage/size);
		}
		List<Curation> list = extCurationService.getAllCuration(cura);
		modelMap.put("allPage", allPage);
		modelMap.put("listweihu", list);
		modelMap.put("cura", curation);
		modelMap.put("CurationExample", cura);
		modelMap.put("keys", keys);
		modelMap.put("level", level);
		return "/WEB-INF/back/organization/cezhan/cezhan.jsp";
	}
	@RequestMapping("/updateStatus.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String updateStastus(@ModelAttribute Curation curation){
		if (!MyString.isEmpty(curation.getId())) {
			if (!curation.getId().equals(Const.NULL_ID)) {
				curation.setStatus("3");
				int a = extCurationService.updateStatus(curation);
				if(a!=1){
					return "/WEB-INF/back/error.jsp";
				}
			}
		}
		return "success";
	}
	@RequestMapping("/delectCuration.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public void delectCuration(@ModelAttribute Curation curation){
		if (!MyString.isEmpty(curation.getId())) {
			if (!curation.getId().equals(Const.NULL_ID)) {
				curation.setStatus("-1");
				int a = extCurationService.updateStatus(curation);
				if(a!=1){
				}
			}
		}
	}

	/**
	 * 审核策展
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/toCheckCuration.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toCheckCuration(String id, ModelMap modelMap){
		try {
			CurationDto curationDto = extCurationService.getCuration(id);
			modelMap.put("curation", curationDto);
			return "/WEB-INF/back/organization/cezhan/cezhanYuLan.jsp";//审核策展地址
			
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	/**
	 * 后台策展审核列表
	 */
	@RequestMapping("/getCheckCurations.do")
	@AuthPassport(authority = "SystemAdmin")
	public String getCheckCurations(@RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue="10") int size, ModelMap modelMap){
		try {
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<CurationDto> list = extCurationService.getCurationList(page);
			modelMap.put("curations", list);
			return "/WEB-INF/back/organization/cezhan/checkList.jsp";//审核列表地址
			
		} catch (Exception e) {
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	/**
	 * 后台删除策展
	 */
	@RequestMapping("/delCuration.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String delCuration(String id){
		try {
			Curation curation = new Curation();
			curation.setId(id);
			curation.setStatus("-1");
			int delete = extCurationService.updateStatus(curation);
			if (delete < 1) {
				return "0";//删除失败
			}
			return "1";//删除成功
		} catch (Exception e) {
			return "0";//删除失败
		}
	}
	
	/**
	 * 后台审核策展--通过
	 */
	@RequestMapping("/checkCurationPass.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String checkCurationPass(String id){
		try {
			Curation curation = new Curation();
			curation.setId(id);
			curation.setStatus("3");
			int update = extCurationService.updateStatus(curation);
			if (update < 1) {
				return "0";//审核失败
			}
			return "1";//审核成功
		} catch (Exception e) {
			return "0";//审核失败
		}
	}
}
