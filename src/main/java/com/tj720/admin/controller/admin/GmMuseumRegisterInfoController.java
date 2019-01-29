package com.tj720.admin.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tj720.admin.model.GmMuseumRegisterInfo;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.GmMuseumRegisterInfoWithBLOBs;
import com.tj720.admin.service.GmMuseumRegisterInfoService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@RequestMapping("/registerInfo")
@Controller
public class GmMuseumRegisterInfoController {
	
	@Autowired
	GmMuseumRegisterInfoService registerInfo;
	@Autowired
	private IMipUserService userService;
	@Autowired
	private IMipOrganizationService organizationService;
	
	/*@RequestMapping("/getInfoList")
	@AuthPassport(authority="collectionAdmin")
	public String getInfoList(ModelMap modelMap,@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage){
		try {
			LoginInfoDto user = Tools.getUser();
			if (MyString.isEmpty(user)) {
				return "/WEB-INF/back/login/login.jsp";
			}
			
			String uid = user.getId();
			MipUser mipUser = userService.getUser(uid);
			int orgId = 0;
			byte level = 0;
			if (!MyString.isEmpty(mipUser)) {
				orgId = Integer.parseInt(mipUser.getOrgId());
				MipOrganization organization = organizationService.getOrganization(orgId);
				if (!MyString.isEmpty(organization)) {
					level = organization.getLevel();
				}
			}
			
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<GmMuseumRegisterInfoWithBLOBs> list = registerInfo.getInfoList(page, orgId, level);
			modelMap.put("register", list);
			modelMap.put("page", page);
			GmMuseumRegisterInfoWithBLOBs blob = new GmMuseumRegisterInfoWithBLOBs();
			if(list.size()>0){
				blob=list.get(0);
				if("".equals(blob.getCollectionSecurity())){
					modelMap.put("security", "0");
				}else{
					modelMap.put("security", "1");
				}
				if("".equals(blob.getAudienceSecurity())){
					modelMap.put("asecurity", "0");
				}else{
					modelMap.put("asecurity", "1");
				}
				modelMap.put("zhezhao", "1");
			}
			modelMap.put("reg", blob);
			
			if (level == 3) {
				return "/WEB-INF/back/super/infoeidter.jsp";
			} 
			if (level == 1 || level == 2) {
				return "/WEB-INF/back/super/infoList.jsp";
			}
			
			return "/WEB-INF/back/error.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}*/
	
	@RequestMapping("/registerInfo")
	public String registerInfo(){
		LoginInfoDto user = Tools.getUser();
		if (MyString.isEmpty(user)) {
			return "/WEB-INF/back/login/login.jsp";
		}
		String uid = user.getId();
		MipUser mipUser = userService.getUser(uid);
		int orgId = 0;
		byte level = 0;
		if (!MyString.isEmpty(mipUser)) {
			orgId = Integer.parseInt(mipUser.getOrgId());
			MipOrganization organization = organizationService.getOrganization(orgId);
			if (!MyString.isEmpty(organization)) {
				level = organization.getLevel();
			}
		}
		if (level == 3) {
			return "/WEB-INF/back/super/infoeidter.jsp";
		} 
		if (level == 1 || level == 2) {
			return "redirect:/registerInfo/getInfoList.do";
		}else{
			return "/WEB-INF/back/super/infoeidter.jsp";
		}
	}
	@RequestMapping("/saveRegister")
	public String saveRegister(ModelMap modelMap,@ModelAttribute GmMuseumRegisterInfoWithBLOBs gmRegisterInfo){
		try {
			GmMuseumRegisterInfoWithBLOBs success = registerInfo.saveRegister(gmRegisterInfo);
			if(success!=null){
				if("".equals(success.getCollectionSecurity())){
					modelMap.put("security", "0");
				}else{
					modelMap.put("security", "1");
				}
				if("".equals(success.getAudienceSecurity())){
					modelMap.put("asecurity", "0");
				}else{
					modelMap.put("asecurity", "1");
				}
				modelMap.put("zhezhao", "1");
				modelMap.put("reg", success);
				return "/WEB-INF/back/super/infoeidter.jsp";
			}else{
				return "/WEB-INF/back/error.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("error", "保存失败");
			return "/WEB-INF/back/error.jsp";
		}
	}
	@RequestMapping("/getRegister")
	public String getRegister(ModelMap modelMap,String id){
		try {
			GmMuseumRegisterInfoWithBLOBs result = registerInfo.getRegister(id);
			if(result!=null){
				if("".equals(result.getCollectionSecurity())){
					modelMap.put("security", "0");
				}else{
					modelMap.put("security", "1");
				}
				if("".equals(result.getAudienceSecurity())){
					modelMap.put("asecurity", "0");
				}else{
					modelMap.put("asecurity", "1");
				}
				modelMap.put("zhezhao", "1");
				modelMap.put("reg", result);
				return "/WEB-INF/back/super/infoeidter.jsp";
			}else{
				return "/WEB-INF/back/error.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("error", "查询失败");
			return "/WEB-INF/back/error.jsp";
		}
	}

}
