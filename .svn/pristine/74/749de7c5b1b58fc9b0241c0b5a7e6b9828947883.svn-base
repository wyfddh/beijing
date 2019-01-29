package com.tj720.admin.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.dto.InsideInfoDto;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserExample;
import com.tj720.admin.service.IInsideInfoService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@RequestMapping("/insideInfo")
@Controller
public class InsideInfoController extends BaseController{

	private Logger logger = LoggerFactory.getLogger(InsideInfoController.class);
	
	@Autowired
	private IInsideInfoService insideInfoService;
	
	@Autowired
	private IMipUserService mipUserService;
	
	@RequestMapping("/list.do")
	public String goList() {
		return "/WEB-INF/back/mess/insideInfoList.jsp";
	}
	
	@RequestMapping("/goAdd.do")
	public String goAdd() {
		return "/WEB-INF/back/mess/insideInfoAdd.jsp";
	}
	
	@RequestMapping("/goEdit.do")
	public String goEdit() {
		return "/WEB-INF/back/mess/insideInfoEdit.jsp";
	}
	
	@RequestMapping("/goDetail.do")
	public ModelAndView goDetail(String infoId) {
		LoginInfoDto user = Tools.getUser();
		InsideInfoDto insideInfoDto = new InsideInfoDto();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("infoId", infoId);
		map.put("receiverId", user.getId());
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/mess/insideInfoView.jsp");
		try {
			insideInfoDto = insideInfoService.queryInsideInfoDetailById(map);
			insideInfoDto.setReceiverId(user.getId());
			insideInfoService.updateReadFlag(insideInfoDto);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		modelAndView.addObject("insideInfoDetail",insideInfoDto);
		return modelAndView; 
	}
	
	@RequestMapping("/getRecUsers.do")
	@ResponseBody
	public JsonResult getRecUsers() {
		JsonResult jsonResult = null;
		try {
			MipUserExample mipUser = new MipUserExample();
			mipUser.setStartPage(1);
			mipUser.setSize(1000);
			List<MipUser> userList = mipUserService.getUserList(mipUser);
			jsonResult = new JsonResult(1,userList);
		} catch (Exception e) {
			jsonResult = new JsonResult(2, null);
		}
		
		return jsonResult;
	}
	
	@RequestMapping("/getList.do")
	@ResponseBody
	public JSONObject list(@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "1",name = "page") int currentPage ,String infoTitle,String readFlag,String dateRange) {
		LoginInfoDto user = Tools.getUser();
		Map<String,Object> map = new HashMap<String, Object>();
		//分页
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		Integer count = 0;
		
		Integer startInt = page.getStart();
		Integer endInt = page.getSize()+startInt;
		map.put("start", startInt);
		map.put("end", endInt-startInt);
		map.put("receiverId", user.getId());
		map.put("readFlag", readFlag);
		if(StringUtil.isNotEmpty(infoTitle)) {
			map.put("infoTitle", infoTitle.trim());
		}
		String submitTimeStart = "";
		String submitTimeEnd = "";
		
		if(StringUtil.isNotEmpty(dateRange)) {
			String[] submitTimes = {};
			submitTimes = dateRange.split("~");
			if(null != submitTimes && submitTimes.length > 0) {
				submitTimeStart = null != submitTimes[0] ? submitTimes[0].trim() : "";
				submitTimeEnd = null != submitTimes[1] ? submitTimes[1].trim() : "";
			}
		}
		
		map.put("submitTimeStart", submitTimeStart);
		map.put("submitTimeEnd", submitTimeEnd);
		
		try {
			count = insideInfoService.getCount(map);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		page.setAllRow(count);
		
		List<InsideInfoDto> infoList = new ArrayList<InsideInfoDto>();
		try {
			infoList = insideInfoService.selectList(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", infoList);
		 
		return jsonObject;
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	public JSONObject save(String infoTitle,String infoContent,String receiveUserId) {
		// 当前登录者
		LoginInfoDto user = Tools.getUser();
		InsideInfoDto dto = new InsideInfoDto();
		dto.setCreatedBy(user.getId());
		dto.setLastUpdatedBy(user.getId());
		dto.setInfoTitle(infoTitle);
		dto.setInfoContent(infoContent);
		dto.setReceiverId(receiveUserId);
		 
		 int result = 0;
		try {
			result = insideInfoService.save(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		 return returnJSONObject(result);
	}
	
	/**
	 * 查看
	 * @param infoId
	 * @return
	 */
	@RequestMapping("/queryInsideInfoDetailById.do")
	@ResponseBody
	public JSONObject queryInsideInfoDetailById(String infoId) {
		Tools.getUser();
		InsideInfoDto dto = new InsideInfoDto();	 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("infoId", infoId);
		map.put("receiverId", Tools.getUser().getId());
		try {
			dto = insideInfoService.queryInsideInfoDetailById(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return returnJSONObject(dto);
	}
	
	private JSONObject returnJSONObject(Object obj) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", 0);
		jsonObject.put("data", obj);
		return jsonObject;
	}
	
	/**
	 * 修改阅读状态
	 * @param infoTitle
	 * @param infoContent
	 * @param receiverId
	 * @return
	 */
	@RequestMapping("updateReadFlag")
	@ResponseBody
	public JSONObject updateReadFlag(Integer infoId,String receiverId,String readFlag) {
		// 当前登录者
		LoginInfoDto user = Tools.getUser();
		InsideInfoDto dto = new InsideInfoDto();
		
		if(null != readFlag && readFlag.equals("")) {
			dto.setReadFlag(Integer.parseInt(readFlag));
		}else {
			dto.setReadFlag(1);//已读
		}
		dto.setLastUpdatedBy(user.getId());
		dto.setReceiverId(receiverId);
		dto.setInfoId(infoId);
		
		try {
			 insideInfoService.updateReadFlag(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return returnJSONObject(null);
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public JSONObject delete(Integer infoId) {
		// 当前登录者
		LoginInfoDto user = Tools.getUser();
		InsideInfoDto dto = new InsideInfoDto();
	 
		dto.setLastUpdatedBy(user.getId());
		dto.setStatus("0");
		dto.setInfoId(infoId);
		 int result = 0;
		try {
			result = insideInfoService.delete(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		 return returnJSONObject(result);
	}
	
}
