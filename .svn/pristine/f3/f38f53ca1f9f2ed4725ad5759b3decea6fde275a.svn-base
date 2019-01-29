package com.tj720.admin.controller.admin;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.dto.MuseumInfoManageDto;
import com.tj720.admin.dto.MuseumInfoManageSpreDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipSpreadtrum;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.MipSpreadtrumService;
import com.tj720.admin.service.MuseumInfoManageService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("museumInfoManage")
public class MuseumInfoManageController {
	@Autowired
	private UserService userService;
	@Autowired
	private com.tj720.mip.inter.service.table.IMipOrganizationService mipOrganizationService1;
	@Autowired
	private com.tj720.admin.service.IMipOrganizationService mipOrganizationService;
	@Autowired
	MuseumInfoManageService museumInfoManageService;
	@Autowired
	MipSpreadtrumService mipSpreadtrumService;
	@RequestMapping("info")
	@AuthPassport(authority = "SystemAdmin")
	public String info(ModelMap modelMap,@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size,String area,String unit){
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		com.tj720.mip.model.MipOrganization org = mipOrganizationService1.get(orgId);
		//查询组织机构的级别
		byte level = org.getLevel();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		List<MipOrganization> areaList = mipOrganizationService.getListByPId(7);
		List<MuseumInfoManageDto> dtoList = museumInfoManageService.getMuseumInfoList(area,unit,page);
		modelMap.put("dtoList", dtoList);
		modelMap.put("areaList", areaList);
		modelMap.put("page", page);
		modelMap.put("level", level);
		return "/WEB-INF/back/organization/manage/manageList.jsp";
	}
	@RequestMapping("spreInfo")
	@AuthPassport(authority = "SystemAdmin")
	public String spreInfo(ModelMap modelMap,@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size,String title,String id,String orgId){
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
//		List<MipOrganization> areaList = mipOrganizationService.getListByPId(7);
//		List<MuseumInfoManageDto> dtoList = museumInfoManageService.getMuseumInfoList(area,unit,page);
//		modelMap.put("dtoList", dtoList);
//		modelMap.put("areaList", areaList);
//		modelMap.put("page", page);
		List<MuseumInfoManageSpreDto> dtoList = museumInfoManageService.getMuseumInfoSpreList(page,id);
		modelMap.put("dtoList", dtoList);
		modelMap.put("title", title);
		modelMap.put("spreId", id);
		modelMap.put("orgId", orgId);
		return "/WEB-INF/back/content/spretTemplet.jsp";
	}

	@RequestMapping("region")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public List<MipOrganization> sltYearType(String pid) {
		List<MipOrganization> organization = new ArrayList<MipOrganization>();
		if(!MyString.isEmpty(pid)){
			organization = mipOrganizationService.getListByPId(Integer.parseInt(pid));
		}
		return organization;
	}
	@RequestMapping("delect")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String delectInfo(String id) {
		String result = museumInfoManageService.delectInfo(id);
		return result;
	}
	@RequestMapping("delectSpre")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String delectInfo(String id,String spreId) {
		String result = museumInfoManageService.delectInfoSpre(id, spreId);
		return result;
	}
	@RequestMapping("addInfo")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String addInfo(String type,String unit,String imgUrl,String urlPsd,String area,String fileName) {
		MuseumInfoManageDto dto = new MuseumInfoManageDto();
		List<MuseumInfoManageDto> dtoList = new ArrayList<MuseumInfoManageDto>();
		String listKey = MessageFormat.format(KeyConstants.MUSEUN_INFO_MANAGE_LIST_KEY, "infoList");
		String jsonStr =JedisService.get(listKey);
		dto = contenstDto(type,unit,imgUrl,urlPsd,area,fileName); 
		if(StringUtils.isNotBlank(jsonStr)) {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);//把String转换为json
			dtoList = (List<MuseumInfoManageDto>) JSONArray.toCollection(jsonArray);
			dtoList.add(dto);
			JSONArray json = JSONArray.fromObject(dtoList); 
			String str = json.toString();//把json转换为String
			JedisService.set(listKey, str, 0);
		} else {
			dtoList.add(dto);
			JSONArray json = JSONArray.fromObject(dtoList); 
			String str = json.toString();//把json转换为String
			JedisService.set(listKey, str, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
		}
		return "1";
	}
	@RequestMapping("addSpreInfo")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String addSpreInfo(String type,String imgUrl,String urlPsd,String fileName,String spreId,String orgId) {
		MuseumInfoManageSpreDto dto = new MuseumInfoManageSpreDto();
		List<MuseumInfoManageSpreDto> dtoList = new ArrayList<MuseumInfoManageSpreDto>();
		String listKey = MessageFormat.format(KeyConstants.MUSEUN_INFO_MANAGE_LIST_KEY, spreId);
		String jsonStr =JedisService.get(listKey);
		dto = contenstSpreDto(type,imgUrl,urlPsd,spreId,fileName,orgId); 
		if(StringUtils.isNotBlank(jsonStr)) {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);//把String转换为json
			dtoList = (List<MuseumInfoManageSpreDto>) JSONArray.toCollection(jsonArray);
			dtoList.add(dto);
			JSONArray json = JSONArray.fromObject(dtoList); 
			String str = json.toString();//把json转换为String
			JedisService.set(listKey, str, 0);
		} else {
			dtoList.add(dto);
			JSONArray json = JSONArray.fromObject(dtoList); 
			String str = json.toString();//把json转换为String
			JedisService.set(listKey, str, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
		}
		return "1";
	}
	
	private MuseumInfoManageDto contenstDto(String type,String unit,String imgUrl,String urlPsd,String area,String fileName){
		MuseumInfoManageDto dto = new MuseumInfoManageDto();
		LoginInfoDto userDto = Tools.getUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String uuid = UUID.randomUUID().toString().replace("-", "");
//		User user = userService.get(userDto.getId());
		dto.setId(uuid);
		dto.setName(fileName);
		dto.setType(type);
		dto.setUserId(userDto.getId());
		dto.setUserName(userDto.getUserName());
		dto.setImageUrl(imgUrl);
		dto.setPsdUrl(urlPsd);
		dto.setArea(area);
		dto.setUnit(unit);
		dto.setCreatTime(sdf.format(new Date()));
		return dto;
	}
	private MuseumInfoManageSpreDto contenstSpreDto(String type,String imgUrl,String urlPsd,String spreId,String fileName,String orgId){
		MuseumInfoManageSpreDto dto = new MuseumInfoManageSpreDto();
//		MipSpreadtrum spreadtrum = mipSpreadtrumService.getSpreadtrum(spreId);
		if(MyString.isEmpty(orgId)){
			orgId="251";
		}
		LoginInfoDto userDto = Tools.getUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String uuid = UUID.randomUUID().toString().replace("-", "");
		dto.setId(uuid);
		dto.setSpreId(spreId);
		dto.setFileName(fileName);
		dto.setType(type);
		dto.setUserId(userDto.getId());
		dto.setUserName(userDto.getUserName());
		dto.setImageUrl(imgUrl);
		dto.setPsdUrl(urlPsd);
		dto.setUnit(orgId);
		dto.setCreatTime(sdf.format(new Date()));
		return dto;
	}
}
