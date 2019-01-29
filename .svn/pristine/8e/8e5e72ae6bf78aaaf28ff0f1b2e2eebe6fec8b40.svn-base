package com.tj720.mip.controller.organization;
import java.util.List;

/**
 *@author mubaoning
 * 
 * 
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
@Controller
@RequestMapping("/organization/relic")
public class OrgrelicController extends BaseController<MipOrganization> {
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@Autowired
	private AreaService areaService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	//查询文物局列表页
	@RequestMapping("/info.do")
	public ModelAndView getOrganizationInfo(@ModelAttribute MipOrganization mipOrganization,
			@RequestParam(defaultValue = "20")int size,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "createTime") String order )throws MyException{
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgreliclist.jsp");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		User user = userService.get(Tools.getUser().getId());
		MipOrganization organization1 = mipOrganizationService.get(user.getOrgId());
		byte level = organization1.getLevel();
		String hql = "from MipOrganization where status <> -127";
		if (level == 1) {
			hql += "and orgTypeId = '1' and platformId ="+config.getPlatformId();
			List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,Tools.getMap(),page);
			//上級文物館
			String hql2 = "from MipOrganization where orgTypeId = '1' and level=2 and platformId = "+config.getPlatformId();
			List<MipOrganization> relicList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2, Tools.getMap());
			modelAndView.addObject("orgList", orgList);
			modelAndView.addObject("relicList", relicList);
		}
		if (level == 2) {
			
		}
		if (level == 3) {
			
		}
		
		modelAndView.addObject("organization1", organization1);
		modelAndView.addObject("page", page);
		modelAndView.addObject("level",level);
		return modelAndView;
		
		/*//ModelAndView  modelAndView = new ModelAndView("/WEB-INF/back/organization/orgreliclist.jsp");
		String hql = "from MipOrganization where orgTypeId = 1 and platformId ="+config.getPlatformId();
		List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,Tools.getMap());
		//上級文物館
		String hql2 = "from MipOrganization where orgTypeId = 1 and level=2 and platformId = "+config.getPlatformId();
		//System.out.println(hql2);
		List<MipOrganization> relicList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2, Tools.getMap());
		modelMap.put("orgList",orgList);
		modelMap.put("relicList", relicList);
		System.out.println(hql2);
		System.out.println(hql);
		
		//List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService.queryByHql("from MipArea where pid = 1375 ", Tools.getMap());
		//modelMap.put("cityList",cityList);
		//modelAndView.addObject("orgList", orgList);
		//查询省份
		List<MipArea> proList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = '0'", Tools.getMap());
		modelMap.put("proList", proList);
		//查询市
		if (mipArea.getId() != null && !"".equals(mipArea.getId())) {
			List<MipArea> cityList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+mipArea.getId()+"and level = 2", Tools.getMap());
			modelMap.put("cityList", cityList);
		}
		
		//查询区
		List<MipArea> townList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+mipArea.getId()+"and level = 3", Tools.getMap());
		modelMap.put("townList", townList);
		return "/WEB-INF/back/organization/orgreliclist.jsp";
		*/
	}
	//文物局编辑
	@RequestMapping("/edit.do")
	public ModelAndView edit(@ModelAttribute MipOrganization organization ,MipArea mipArea ,@RequestParam String relicOrganizationId ){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgrelicedit.jsp");
		 organization = mipOrganizationService.get(relicOrganizationId);
		 User user = userService.get(Tools.getUser().getId());
			MipOrganization organization1 = mipOrganizationService.get(user.getOrgId());
			byte level = organization1.getLevel();
		//查询省份
			List<MipArea> proList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = '0'", Tools.getMap());
			modelAndView.addObject("proList", proList);
			//查询市
			if (organization.getProvinceId() != null && !"".equals(organization.getProvinceId())) {
				List<MipArea> cityList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+organization.getProvinceId()+"and level = 2", Tools.getMap());
				modelAndView.addObject("cityList", cityList);
			}
			
			//查询区
			if (organization.getCityId() != null && !"".equals(organization.getCityId())) {
				List<MipArea> townList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+organization.getCityId()+"and level = 3", Tools.getMap());
				modelAndView.addObject("townList", townList);
			}
			//List<MipArea> townList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+mipArea.getId()+"and level = 3", Tools.getMap());
			//modelMap.put("townList", townList);
			//上級文物館
			String hql2 = "from MipOrganization where orgTypeId = '1' and level=2 and platformId = "+config.getPlatformId();
			List<MipOrganization> relicList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2, Tools.getMap());
		 modelAndView.addObject("organization", organization);
		 modelAndView.addObject("relicList", relicList);
		 modelAndView.addObject("organization1", organization1);
			//modelAndView.addObject("page", page);
			modelAndView.addObject("level",level);
		 return modelAndView;
		
	}
	
	//文物局详情
	@RequestMapping("/detail.do")
	/*public ModelAndView detail(@ModelAttribute MipOrganization relicOrganization) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgrelicdetail.jsp");
		relicOrganization = mipOrganizationService.get(relicOrganization.getId());
		
		modelAndView.addObject("relicOrganization", relicOrganization);
		return modelAndView;
		
	}*/
	public ModelAndView detail(@ModelAttribute MipOrganization organization ,@RequestParam String relicOrganizationId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgrelicdetail.jsp");
		 organization= mipOrganizationService.get(relicOrganizationId);
		//查询省份
			List<MipArea> proList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = '0'", Tools.getMap());
			modelAndView.addObject("proList", proList);
			//查询市
			if (organization.getProvinceId() != null && !"".equals(organization.getProvinceId())) {
				List<MipArea> cityList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+organization.getProvinceId()+"and level = 2", Tools.getMap());
				modelAndView.addObject("cityList", cityList);
			}
			
			//查询区
			if (organization.getCityId() != null && !"".equals(organization.getCityId())) {
				List<MipArea> townList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = "+organization.getCityId()+"and level = 3", Tools.getMap());
				modelAndView.addObject("townList", townList);
			}
		modelAndView.addObject("relicOrganization", organization);
		return modelAndView;
		
	}
	
	@RequestMapping("/save.do")
	public String save(@ModelAttribute MipOrganization organization){
		MipOrganization mipOrganization = mipOrganizationService.get(organization.getId());
		
		if (!MyString.isEmpty(organization.getAddress())) {
			mipOrganization.setAddress(organization.getAddress());
		}
		if (!MyString.isEmpty(organization.getCityId())) {
			mipOrganization.setCityId(organization.getCityId());
		}
		if (!MyString.isEmpty(organization.getEmail())) {
			mipOrganization.setEmail(organization.getEmail());
		}else {
			mipOrganization.setEmail("");
		}
		if (!MyString.isEmpty(organization.getFex())) {
			mipOrganization.setFex(organization.getFex());
		}else {
			mipOrganization.setFex("");
		}
		if (!MyString.isEmpty(organization.getInfo())) {
			mipOrganization.setInfo(organization.getInfo());
		}else {
			mipOrganization.setInfo("");
		}
		if (!MyString.isEmpty(organization.getProvinceId())) {
			mipOrganization.setProvinceId(organization.getProvinceId());
		}
		/*if (!MyString.isEmpty(organization.getOpen())) {
			mipOrganization.setOpen(organization.getOpen());
		}*/
		if (!MyString.isEmpty(organization.getTel())) {
			mipOrganization.setTel(organization.getTel());
		}else {
			mipOrganization.setTel("");
		}		
		if (!MyString.isEmpty(organization.getTownId())) {
			mipOrganization.setTownId(organization.getTownId());
		}		
		
		//mipOrganizationService.update(mipOrganization);
		try {
			//mipOpenFossilInfoService.update(mipOpenFossilInfo);
			mipOrganization.setOpen((byte)1);
			mipOrganizationService.update(mipOrganization);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "2";
	}
	
	@RequestMapping("/sltArea.do")
	@ResponseBody
	public List<MipArea> sltArea(@RequestParam(name = "pid") String pid) {
		String hql = "from MipArea where pid=" + pid;
		List<MipArea> yTypes = (List<MipArea>) areaService.queryByHql(hql,
				Tools.getMap());
		return yTypes;
	}
	
}
