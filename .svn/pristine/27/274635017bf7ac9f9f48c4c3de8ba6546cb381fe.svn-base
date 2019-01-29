package com.tj720.admin.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipCollectionAudioExample;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.IAudioSearchService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/back/audioSearch")
public class AudioSearchController {
	
	@Autowired
	private IAudioSearchService audioSearchService;
	
	@Autowired
	private IMipUserService mipUserService;
	
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@Autowired
	private Config config;
	
	
	@RequestMapping("/index.do")
	@AuthPassport(authority = "SystemAdmin")
	public String index(@ModelAttribute MipCollectionAudio audio,ModelMap modelMap,
			@RequestParam(defaultValue="1" ,name="page") Integer currentPage,
			@RequestParam(defaultValue = "10")int size,String unit,String area) throws MyException {
		MipCollectionAudioExample example = new MipCollectionAudioExample();
		if(audio.getStatus()!=null&&!"".equals(audio.getStatus())){
			example.setStatus(audio.getStatus().toString());
		}
		if(unit!=null&&!"".equals(unit)){
			example.setCollectionUnit(unit);
		}
		if(audio.getStartTime()!=null&&!"".equals(audio.getStartTime())){
			example.setStartTime(audio.getStartTime().trim());
		}
		if(audio.getEndTime()!=null&&!"".equals(audio.getEndTime())){
			example.setEndTime(audio.getEndTime().trim());
		}
		if(audio.getCollectionName()!=null&&!"".equals(audio.getCollectionName())){
			example.setCollectionName(audio.getCollectionName().toString());
		}
		if(audio.getUserName()!=null&&!"".equals(audio.getUserName())){
			example.setUserName(audio.getUserName().toString());
		}
		String userId = Tools.getUser().getId();
		byte level =1;
		List<MipOrganization> cityList = new ArrayList<MipOrganization>();
		List<MipOrganization> mesuemList = new ArrayList<MipOrganization>();
		MipUser mipUser = mipUserService.getUser(userId);
		MipOrganization mipOrganization = new MipOrganization();
		if (!MyString.isEmpty(mipUser.getOrgId())) {
			mipOrganization = mipOrganizationService.getOrganization(Integer.parseInt(mipUser.getOrgId()));
			if(mipOrganization!=null){
				level = mipOrganization.getLevel();
			}
			if(level==1){
				cityList = mipOrganizationService.getCityList(mipOrganization.getId());
				if(area!=null&&!"".equals(unit)){
					mesuemList = mipOrganizationService.getCityList(Integer.parseInt(area));
					example.setCityId(unit);
				}
			}else if(level==2){
				mesuemList = mipOrganizationService.getCityList(mipOrganization.getId());
				example.setParentCityId(mipUser.getOrgId());
			}else{
				example.setCityId(mipUser.getOrgId());
			}
		}
		int totle = audioSearchService.allPage(example);
		example.setSize(size);
		example.setCurrentPage(currentPage);
		if(totle%10>0){
			example.setTotalPage(totle/size+1);
		}else{
			example.setTotalPage(totle/size);
		}
		if(currentPage>0){
			example.setStartPage((currentPage-1)*example.getSize());
//			if(currentPage*example.getSize()>totle){
//				example.setSize(totle-(currentPage-1)*example.getSize());
//			}
		}
		List<MipCollectionAudio> list = audioSearchService.getUserList(example);
		if(CollectionUtils.isNotEmpty(list)) {
			for(MipCollectionAudio mipCollectionAudio : list) {
				mipCollectionAudio.getDuration();
				mipCollectionAudio.setUrl(config.getRootUrl() + "/audio" + mipCollectionAudio.getUrl());
			}
		}
		modelMap.put("totle", totle);
		modelMap.put("area", area);
		modelMap.put("mesuemList", mesuemList);
		modelMap.put("cityList", cityList);
		modelMap.put("level", level);
		modelMap.put("mipAudioList", list);
		modelMap.put("example", example);
		return "/WEB-INF/back/organization/checkAudio/check_audio.jsp";
	}
	@RequestMapping("/getMuseum.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult getMuseum(String id){
		List<MipOrganization> mesuemList = new ArrayList<MipOrganization>();
		if(id!=null&&!"".equals(id)){
			mesuemList = mipOrganizationService.getCityList(Integer.parseInt(id));
		}
		return new JsonResult(1, mesuemList);
	}
	@RequestMapping("/delectAudio.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult delectAudio(String id){//删除
		MipCollectionAudio record = new MipCollectionAudio();
		record.setId(id);
		record.setStatus((byte)-1);
		int a =audioSearchService.updateAudio(record);
		if(a==1){
			return new JsonResult(1, "SUCCESS");
		}else{
			return new JsonResult(1, "删除失败");
		}
	}
	@RequestMapping("/updateAudio.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult updateAudio(String id){//审核
		MipCollectionAudio record = new MipCollectionAudio();
		record.setId(id);
		record.setStatus((byte)2);
		int a =audioSearchService.updateAudio(record);
		if(a==1){
			return new JsonResult(1, "SUCCESS");
		}else{
			return new JsonResult(1, "审核失败");
		}
	}

}