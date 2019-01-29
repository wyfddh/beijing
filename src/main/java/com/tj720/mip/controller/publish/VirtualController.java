package com.tj720.mip.controller.publish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.GeneratorKey;
import com.tj720.admin.model.MipVirtualExibitionHall;
import com.tj720.admin.service.VirtualService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.dto.VirtualDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/virtual")
public class VirtualController extends BaseController{
	@Autowired
	private VirtualService virtualService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private Config config;//常量的取法
	@Autowired
	private MipOrganizationService organizationService;

	@RequestMapping("/goList.do")
	@ControllerAop(url="virtual/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList(Model model){
		String level = getLevel();//1:博物馆2：文物局
		model.addAttribute("level", level);
		
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgId = user.getOrgId();
		model.addAttribute("orgId", orgId);
		
		return "/WEB-INF/back/publish/virtualList.jsp";
	}
	 
	//跳转到增加页面
	@RequestMapping("/toVirtualAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toVirtualAdd(){
		
		return "/WEB-INF/back/publish/virtualAdd.jsp";
	}
	
	//跳转到修改页面
	@RequestMapping("/toVirtualUpdate.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toVirtualUpdate(String id,Model model){
		MipVirtualExibitionHall virtual = new MipVirtualExibitionHall();
		virtual = virtualService.get(id);
		virtual.setPictureId(config.getRootUrl()+virtual.getPictureId());
		model.addAttribute("virtual",virtual);
		return "/WEB-INF/back/publish/virtualEdit.jsp";
	}
		
	
	//前台查询虚拟展厅的列表
	@RequestMapping("/getVirtualList.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getVirtualList(String key,String type,String status,
			@RequestParam(defaultValue="1") Integer currentPage,@RequestParam(defaultValue="15")Integer size){
		Page page= new Page(size);
		page.setCurrentPage(currentPage);
		List<VirtualDto> virtualList = new ArrayList<VirtualDto>();
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
			virtualList = virtualService.getVirtualList(null,key,type,status,page,us.getOrgId());
		}else{
			virtualList = virtualService.getVirtualList(orgList,key,type,status,page,us.getOrgId());
		}
		for(VirtualDto virtualDto : virtualList){
			virtualDto.setPictureId(config.getRootUrl()+virtualDto.getPictureId());
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data",virtualList);
		return jsonObject;
		
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult addVirtual( MipVirtualExibitionHall virtual){
		try{
        	LoginInfoDto us = Tools.getUser();
        	User user = userService.get(us.getId());
        	virtual.setVicreater(us.getId());
        	virtual.setOrgId(Integer.parseInt(user.getOrgId()));
        	String uuid = UUID.randomUUID().toString().replace("-", "");
        	virtual.setId(uuid);
        	virtual.setStatus("0");
        	virtual.setCreatetime(new Date());
           int flag = virtualService.save(virtual);
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
	public JsonResult updateVirtual(MipVirtualExibitionHall virtual){
		try{
			MipVirtualExibitionHall virtualOld = new MipVirtualExibitionHall();
			virtualOld = virtualService.get(virtual.getId());
			virtual.setOrgId(virtualOld.getOrgId());
			virtual.setStatus(virtualOld.getStatus());
			virtual.setVicreater(virtualOld.getVicreater());
			virtual.setCreatetime(virtualOld.getCreatetime());
        	LoginInfoDto us = Tools.getUser();
        	virtual.setVilastperson(us.getId());
        	virtual.setVilasttime(new Date());
        	String imgUrl = virtual.getPictureId();
        	if (StringUtils.isNotBlank(imgUrl)) {
        		imgUrl = imgUrl.replaceAll(config.getRootUrl(), "");
        		virtual.setPictureId(imgUrl);
			} else {
				virtual.setPictureId(null);
			}
           int flag = virtualService.update(virtual);
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
  	@RequestMapping("/deleteVirtual.do")
  	@ResponseBody
  	@AuthPassport(authority = "SystemAdmin")
  	public JsonResult deleteVirtual(String id){
  		try{
  		   int flag = virtualService.delete(id);
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
  	@RequestMapping("/publishVirtual.do")
  	@ResponseBody
  	@AuthPassport(authority = "SystemAdmin")
  	public JsonResult publishVirtual(String id,String status){
  		try{
  		   int flag = virtualService.publish(id,status);
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
		/*if(!MyString.isEmpty(id)){
				if(!id.equals(Const.NULL_ID)){
					model= virtualService.get(id);
					Long clickNumber = (long)model.getClickNumber();
					model.setClickNumber(++clickNumber);
					virtualService.update(model);
				}
			}*/
	}

}