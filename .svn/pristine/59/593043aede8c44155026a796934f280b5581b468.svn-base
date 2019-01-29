package com.tj720.mip.controller.publish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.GeneratorKey;
import com.tj720.admin.model.MipActivity;
import com.tj720.admin.model.MipSpreadtrum;
import com.tj720.admin.service.ActivityService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.ActivityDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/activityAdmin")
public class ActivityAdminController extends BaseController{
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private Config config;//常量的取法
	
	//讲座列表页
	@RequestMapping("/goLectureList.do")
	@ControllerAop(url="activityAdmin/goLectureList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goLectureList(Model model){
		String level = getLevel();//1:博物馆2：文物局
		model.addAttribute("level", level);
		
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgId = user.getOrgId();
		model.addAttribute("orgId", orgId);
		return "/WEB-INF/back/publish/activity/lectureList.jsp";
	}
	//活动列表页
	@RequestMapping("/goActivityList.do")
	@ControllerAop(url="activityAdmin/goActivityList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goActivityList(Model model){
		String level = getLevel();//1:博物馆2：文物局
		model.addAttribute("level", level);
		
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgId = user.getOrgId();
		model.addAttribute("orgId", orgId);
		return "/WEB-INF/back/publish/activity/activityList.jsp";
	} 
	//讲座增加页面
	@RequestMapping("/toLectureAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toLectureAdd(){
		
		return "/WEB-INF/back/publish/activity/lectureAdd.jsp";
	}
	//活动增加页面
	@RequestMapping("/toActivityAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toActivityAdd(){
		
		return "/WEB-INF/back/publish/activity/activityAdd.jsp";
	}
	//跳转到修改页面
	@RequestMapping("/toLectureUpdate.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toLectureUpdate(String id,Model model){
		MipActivity activity = new MipActivity();
		activity =  activityService.get(id);
		activity.setPictureId(config.getRootUrl()+activity.getPictureId());
		model.addAttribute("activity",activity);
		return "/WEB-INF/back/publish/activity/lectureEdit.jsp";
	}
	//跳转到修改页面
	@RequestMapping("/toActivityUpdate.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toactivityUpdate(String id,Model model){
		MipActivity activity = new MipActivity();
		activity =  activityService.get(id);
		activity.setPictureId(config.getRootUrl()+activity.getPictureId());
		model.addAttribute("activity",activity);
		return "/WEB-INF/back/publish/activity/activityEdit.jsp";
	}	
	
	//前台查询亲子活动的列表
	@RequestMapping("/getActivityList.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getActivityList(String type,String key,String publishTime,String status,
			@RequestParam(defaultValue="1") Integer currentPage,@RequestParam(defaultValue="15")Integer size){
		Page page= new Page(size);
		page.setCurrentPage(currentPage);
		List<ActivityDto> activityList = new ArrayList<ActivityDto>();
		String startTime = null;
		String endTime = null;		
		if(!StringUtil.isBlank(publishTime)) {
			startTime = publishTime.split(" - ")[0];
			endTime = publishTime.split(" - ")[1];
		}
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
    	List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(orgId), true);
    	List<String> orgList = new ArrayList<>();
    	for (com.tj720.admin.model.MipOrganization org : sonOrg) {
    		if(org != null) {
    			orgList.add(org.getId()+"");
    		}
		}
    	if(orgList == null || orgList.size() == 0) {
    		orgList = null;
    	}
		if("0".equals(orgId)){
			activityList = activityService.getActivityList(null,key,type,startTime,endTime,status,page,orgId);
		}else{
			activityList = activityService.getActivityList(orgList,key,type,startTime,endTime,status,page,orgId);
		}
		for(ActivityDto ActivityDto : activityList){
			ActivityDto.setPictureId(config.getRootUrl()+ActivityDto.getPictureId());
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data",activityList);
		return jsonObject;
		
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult addActivity( MipActivity activity ){
		try{
        	LoginInfoDto us = Tools.getUser();
        	User user = userService.get(us.getId());
        	activity.setUserId(us.getId());
        	activity.setOrgId(user.getOrgId());
        	String uuid = UUID.randomUUID().toString().replace("-", "");
        	activity.setId(uuid);       	
        	activity.setStatus("0");
        	activity.setCreatetime(new Date());
           int flag = activityService.save(activity);
           if(flag == 1){
        	   return new JsonResult(Constants.RES_SUCCESS, "保存成功", 0, null);
           }else{
        	   return new JsonResult(Constants.RES_FAIL, "保存失败", 0, null);
           }
		}catch (Exception e){
	        e.printStackTrace();
	        return new JsonResult(Constants.RES_FAIL, "系统异常", 0, null);
	    }
	} 

	@RequestMapping("/update.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult updateActivity(MipActivity activity){
		try{
			MipActivity activityOld = activityService.get(activity.getId());
			activity.setOrgId(activityOld.getOrgId());
			activity.setStatus(activityOld.getStatus());
			activity.setCreatetime(activityOld.getCreatetime());
			String imgUrl = activity.getPictureId();
        	if (StringUtils.isNotBlank(imgUrl)) {
        		imgUrl = imgUrl.replaceAll(config.getRootUrl(), "");
        		activity.setPictureId(imgUrl);
			} else {
				activity.setPictureId(null);
			}
           int flag = activityService.update(activity);
           if(flag == 1){
        	   return new JsonResult(Constants.RES_SUCCESS, "保存成功", 0, null);
           }else{
        	   return new JsonResult(Constants.RES_FAIL, "保存失败", 0, null);
           }
		}catch (Exception e){
	        e.printStackTrace();
	        return new JsonResult(Constants.RES_FAIL, "系统异常", 0, null);
	    }
	} 	
    
	//删除一条信息
  	@RequestMapping("/deleteActivity.do")
  	@ResponseBody
  	@AuthPassport(authority = "SystemAdmin")
  	public JsonResult deleteActivity(String id){
  		try{
  		   int flag = activityService.delete(id);
           if(flag == 1){
        	   return new JsonResult(Constants.RES_SUCCESS, "删除成功", 0, null);
           }else{
        	   return new JsonResult(Constants.RES_FAIL, "删除失败", 0, null);
           }
		}catch (Exception e){
	        e.printStackTrace();
	        return new JsonResult(Constants.RES_FAIL, "系统异常", 0, null);
	    }
  	}
 
  	//发布
  	@RequestMapping("/publishActivity.do")
  	@ResponseBody
  	@AuthPassport(authority = "SystemAdmin")
  	public JsonResult publishActivity(String id,String status){
  		try{
  		   int flag = activityService.publish(id,status);
           if(flag == 1){
        	   return new JsonResult(Constants.RES_SUCCESS, "成功", 0, null);
           }else{
        	   return new JsonResult(Constants.RES_FAIL, "失败", 0, null);
           }
		}catch (Exception e){
	        e.printStackTrace();
	        return new JsonResult(Constants.RES_FAIL, "系统异常", 0, null);
	    }
  	}

	//点击+1
	@RequestMapping("/addOnclick.do")
	@ResponseBody
	public void addOnclick(String id) throws MyException{
		if(!MyString.isEmpty(id)){
			if(!id.equals(Const.NULL_ID)){
				MipActivity activity = activityService.get(id);
				Integer clickNumber = activity.getSequence();
				activity.setSequence(++clickNumber);
				activityService.update(activity);
			}
		}
	}

}