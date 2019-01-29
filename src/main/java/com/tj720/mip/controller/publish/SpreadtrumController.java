package com.tj720.mip.controller.publish;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.tj720.admin.model.MipSpreadtrum;
import com.tj720.admin.model.MipVirtualExibitionHall;
import com.tj720.admin.service.MipSpreadtrumService;
import com.tj720.admin.service.SpreadtrumService;
import com.tj720.admin.service.VirtualService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.SpreadtrumDto;
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
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/spreadtrum")
public class SpreadtrumController extends BaseController{
	@Autowired
	private MipSpreadtrumService spreadtrumService;
	@Autowired
	private UserService userService;	
	@Autowired
	private Config config;//常量的取法
	@Autowired
	SpreadtrumService spreadtrumServiceInterface;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipOrganizationService organizationService;
	
	@RequestMapping("/goList.do")
	@ControllerAop(url="spreadtrum/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList(Model model){
		String level = getLevel();//1:博物馆2：文物局
		model.addAttribute("level", level);
		
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgId = user.getOrgId();
		model.addAttribute("orgId", orgId);
		return "/WEB-INF/back/publish/spreadtrumList.jsp";
	}
	 
	//跳转到增加页面
	@RequestMapping("/toSpreadtrumAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toSpreadtrumAdd(){
		
		return "/WEB-INF/back/publish/spreadtrumAdd.jsp";
	}
	
	//跳转到修改页面
	@RequestMapping("/toSpreadtrumUpdate.do")
	@AuthPassport(authority = "SystemAdmin")
	public String toSpreadtrumUpdate(String id,Model model){
		MipSpreadtrum spreadtrum = new MipSpreadtrum();
		spreadtrum =  spreadtrumService.get(id);
		String beginTime = null;
		if(spreadtrum.getBeginTime() != null){
			 beginTime = new SimpleDateFormat("yyyy-MM-dd").format(spreadtrum.getBeginTime()); 
		}
		String endTime = null;
		if(spreadtrum.getEndTime() != null){
			 endTime = new SimpleDateFormat("yyyy-MM-dd").format(spreadtrum.getEndTime());
		}
		spreadtrum.setEditor(beginTime+" - "+endTime);
		spreadtrum.setPictureId(config.getRootUrl()+spreadtrum.getPictureId());
		model.addAttribute("spreadtrum",spreadtrum);
		return "/WEB-INF/back/publish/spreadtrumEdit.jsp";
	}
		
	
	//前台查询虚拟展厅的列表
	@RequestMapping("/getSpreadtrumList.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getSpreadtrumList(String key,String publishTime,String type,String status,
			@RequestParam(defaultValue="1") Integer currentPage,@RequestParam(defaultValue="15")Integer size){
		Page page= new Page(size);
		page.setCurrentPage(currentPage);
		List<SpreadtrumDto> spreadtrumList = new ArrayList<SpreadtrumDto>();
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
			spreadtrumList = spreadtrumService.getSpreadtrumList(null,key,type,startTime,endTime,status,page,orgId);
		}else{
			spreadtrumList = spreadtrumService.getSpreadtrumList(orgList,key,type,startTime,endTime,status,page,orgId);
		}
		for(SpreadtrumDto spreadtrumDto : spreadtrumList){
			spreadtrumDto.setPictureId(config.getRootUrl()+spreadtrumDto.getPictureId());
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data",spreadtrumList);
		return jsonObject;
		
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult addSpreadtrum( SpreadtrumDto spreadtrumOld ){
		try{
			MipSpreadtrum spreadtrum= new MipSpreadtrum();			
        	LoginInfoDto us = Tools.getUser();
        	User user = userService.get(us.getId());
        	spreadtrum.setUserId(us.getId());
        	spreadtrum.setOrgId(user.getOrgId());
        	String uuid = UUID.randomUUID().toString().replace("-", "");
        	spreadtrum.setId(uuid);       	
        	spreadtrum.setStatus("0");
        	spreadtrum.setClickNumber(0l);
        	spreadtrum.setCreatetime(new Date());
        	spreadtrum.setHeadline(spreadtrumOld.getHeadline());
        	spreadtrum.setContent(spreadtrumOld.getContent());
        	spreadtrum.setExhibitionType(spreadtrumOld.getExhibitionType());
        	spreadtrum.setPictureId(spreadtrumOld.getPictureId());
        	spreadtrum.setVipcurl(spreadtrumOld.getVipcurl());
        	spreadtrum.setVimoveurl(spreadtrumOld.getVimoveurl());
        	String exhibitionTime = spreadtrumOld.getExhibitionTime();       	
        	String startTime = null;
			String endTime = null;
			Date date1 = null ;
			Date date2 = null ;
			if(!StringUtil.isBlank(exhibitionTime)) {
				startTime = exhibitionTime.split(" - ")[0];
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime); 
				endTime = exhibitionTime.split(" - ")[1];
				date2 = new SimpleDateFormat("yyyy-MM-dd").parse(endTime);
			}
			spreadtrum.setBeginTime(date1);
			spreadtrum.setEndTime(date2);
           int flag = spreadtrumService.save(spreadtrum);
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
	public JsonResult updateSpreadtrum(SpreadtrumDto spreadtrumOld){
		try{
			MipSpreadtrum spreadtrum = new MipSpreadtrum();
			spreadtrum = spreadtrumService.get(spreadtrumOld.getId());
			spreadtrum.setHeadline(spreadtrumOld.getHeadline());
        	spreadtrum.setContent(spreadtrumOld.getContent());
        	spreadtrum.setExhibitionType(spreadtrumOld.getExhibitionType());
        	String imgUrl = spreadtrumOld.getPictureId();
        	if (StringUtils.isNotBlank(imgUrl)) {
        		imgUrl = imgUrl.replaceAll(config.getRootUrl(), "");
        		spreadtrum.setPictureId(imgUrl);
			} else {
				spreadtrum.setPictureId(null);
			}
        	spreadtrum.setVipcurl(spreadtrumOld.getVipcurl());
        	spreadtrum.setVimoveurl(spreadtrumOld.getVimoveurl());
        	spreadtrum.setUpdatedTime(new Date());
        	String exhibitionTime = spreadtrumOld.getExhibitionTime();
			String startTime = null;
			String endTime = null;		
			Date date1 = null ;
			Date date2 = null ;
			if(!StringUtil.isBlank(exhibitionTime)) {
				startTime = exhibitionTime.split(" - ")[0];
				if(!"null".equals(startTime)){
					date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime); 
					spreadtrum.setBeginTime(date1);
				}
				endTime = exhibitionTime.split(" - ")[1];
				if(!"null".equals(endTime)){
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(endTime);
					spreadtrum.setEndTime(date2);
				}
			}
           int flag = spreadtrumService.update(spreadtrum);
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
  	@RequestMapping("/deleteSpreadtrum.do")
  	@ResponseBody
  	@AuthPassport(authority = "SystemAdmin")
  	public JsonResult deleteSpreadtrum(String id){
  		try{
  		   int flag = spreadtrumService.delete(id);
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
  	@RequestMapping("/publishSpreadtrum.do")
  	@ResponseBody
  	@AuthPassport(authority = "SystemAdmin")
  	public JsonResult publishSpreadtrum(String id,String status){
  		try{
  		   int flag = spreadtrumService.publish(id,status);
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
					MipSpreadtrum spreadtrum = spreadtrumService.get(id);
					Long clickNumber = (long)spreadtrum.getClickNumber();
					spreadtrum.setClickNumber(++clickNumber);
					spreadtrumService.update(spreadtrum);
				}
			}
	}
	
	
	//chengrongkai 增加
	@RequestMapping("/getThreeSpreadtrum.do")
	@ResponseBody
	public JsonResult getThreeSpreadtrum(){
		try{
			HashMap data = new HashMap();
			//获取最新展览列表
			Page page = new Page();
			page.setSize(4);
			page.setCurrentPage(1);
			//按照发布时间排序
			String orderCondition = "publish_time";
			JsonResult lastSpreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page);				
			data.put("lastSpreadtrum", lastSpreadtrum);	
			
			//获取热门展览列表
			Page page1 = new Page();
			page1.setSize(4);
			page1.setCurrentPage(1);
			//按照点击次数排序
			orderCondition = "click_number";
			JsonResult hotSpreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page1);	
			data.put("hotSpreadtrum", hotSpreadtrum);
			//获取虚拟展览
			Page page2 = new Page();
			page1.setSize(3);
			page1.setCurrentPage(1);
			JsonResult virtualSpreadtrum = spreadtrumServiceInterface.getVirtualExibitionHallList(page2);		
			data.put("virtualSpreadtrum", virtualSpreadtrum);			
			//返回数据			
			return new JsonResult(1,data);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	@RequestMapping("/getSpreadtrumListInterface.do")
	@ResponseBody
	public JsonResult getlastSpreadtrumList(@RequestParam() String orderCondition,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "1") int currentPage){
		try{
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			JsonResult Spreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page);					
			//返回数据			
			return Spreadtrum;
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	@RequestMapping("/getlastSpreadtrumList.do")
	@ResponseBody
	public JsonResult getlastSpreadtrumList(@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "1") int currentPage){
		try{
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			//按照发布时间排序
			String orderCondition = "publish_time";
			JsonResult Spreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page);					
			//返回数据			
			return Spreadtrum;
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	@RequestMapping("/gethotSpreadtrumList.do")
	@ResponseBody
	public JsonResult getSpreadtrumList(@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "1") int currentPage){
		try{
			//获取最新展览列表
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			//按照发布时间排序
			String orderCondition = "click_number";
			JsonResult Spreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page);					
			//返回数据			
			return Spreadtrum;
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	@RequestMapping("/getvirtualSpreadtrumListInterface.do")
	@ResponseBody
	public JsonResult getvirtualSpreadtrumList(@RequestParam(defaultValue = "9") int size,
			@RequestParam(defaultValue = "1") int currentPage){
		try{
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			JsonResult Spreadtrum = spreadtrumServiceInterface.getVirtualExibitionHallList(page);					
			//返回数据			
			return Spreadtrum;
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	@RequestMapping("/getvirtualSpreadtrumById.do")
	@ResponseBody
	public JsonResult getvirtualSpreadtrumById(@RequestParam String id,String orgId){
		try{
			HashMap Spreadtrum = spreadtrumServiceInterface.getVirtualExibitionHallByCondition(orgId,id);					
			return new JsonResult(1,Spreadtrum);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	@RequestMapping("/getSpreadtrumById.do")
	@ResponseBody
	public JsonResult getSpreadtrumById(@RequestParam String id,String orgId){
		try{
			//获取数据
			HashMap data = new HashMap();
			HashMap Spreadtrum = spreadtrumServiceInterface.getSpreadtrumByCondition(orgId,id);	
			data.put("Spreadtrum", Spreadtrum);
			//点击量加一
			addOnclick(id);
			return new JsonResult(1,data);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}

}