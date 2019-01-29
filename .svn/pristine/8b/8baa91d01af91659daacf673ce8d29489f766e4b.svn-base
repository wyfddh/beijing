package com.tj720.admin.controller.admin;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.mip.controller.BaseController;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.GovNotice;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumPublicServiceService;
import com.tj720.admin.service.IMuseumRecordService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 淇敼璁板綍Controller
 * @author chenshiya
 * @version 2018-05-17
 */
@Controller
@RequestMapping("/eidtRecord")
public class MuseumEditRecordController extends BaseController{

	@Autowired
	private IMuseumRecordService museumRecordService;
	
	@RequestMapping("/goList.do")
	public String goList(Model model,String museumId,String type) {
		model.addAttribute("museumId", museumId);
		model.addAttribute("recordType", type);
		return "/WEB-INF/back/baseInfo/editRecordList.jsp";
	}
	
	@RequestMapping("/showDetail.do")
	@AuthPassport(authority = "SystemAdmin")
	public String showDetail(Model model,String museumId,String id,String type) {
		model.addAttribute("museumId", museumId);
		model.addAttribute("id", id);
		model.addAttribute("type", type);
		return "/WEB-INF/back/baseInfo/editRecordDetailList.jsp";
	}
	
	@RequestMapping("/getBaseInfoList.do")
	@ResponseBody
	public JSONObject getBaseInfoEditRecord(@RequestParam String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		List<HashMap<String,Object>> baseRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			baseRecordList =  museumRecordService.getEditRecordList(museumId,delFlag,page,"base");	
		}	
		else{
			baseRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"base");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", baseRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getBaseHouseList.do")
	@ResponseBody
	public JSONObject getBaseHouseEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
		List<HashMap<String,Object>> baseHouseRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			baseHouseRecordList =  museumRecordService.getEditRecordList(museumId,delFlag,page,"baseHouse");	
		}	
		else{
			baseHouseRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"baseHouse");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", baseHouseRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getBuildList.do")
	@ResponseBody
	public JSONObject getBuildEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		museumId = "707";
		List<HashMap<String,Object>> buildRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			buildRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"build");	
		}	
		else{
			buildRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"build");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", buildRecordList);
		
		return jsonObject;
	}
	
	
	@RequestMapping("/getServiceList.do")
	@ResponseBody
	public JSONObject getServiceEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
//		museumId = "707";
		List<HashMap<String,Object>> serviceRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			serviceRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"publicService");	
		}	
		else{
			serviceRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"publicService");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", serviceRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getDigitizationList.do")
	@ResponseBody
	public JSONObject getDigitizationEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
//		museumId = "707";
		List<HashMap<String,Object>> digitizationRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			digitizationRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"digitization");	
		}	
		else{
			digitizationRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"digitization");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", digitizationRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getPromotionList.do")
	@ResponseBody
	public JSONObject getPromotionEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
//		museumId = "703";
		List<HashMap<String,Object>> promotionRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			promotionRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"promotion");	
		}	
		else{
			promotionRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"promotion");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", promotionRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getCollectionList.do")
	@ResponseBody
	public JSONObject getCollectionEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> collectionRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			collectionRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"collection");	
		}	
		else{
			collectionRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"collection");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", collectionRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getSafeList.do")
	@ResponseBody
	public JSONObject getSafeEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> safeRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			safeRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"safe");	
		}	
		else{
			safeRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"safe");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", safeRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getWarehouseList.do")
	@ResponseBody
	public JSONObject getWarehouseEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> warehouseRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			warehouseRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"warehouse");	
		}	
		else{
			warehouseRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"warehouse");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", warehouseRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getShowRoomList.do")
	@ResponseBody
	public JSONObject getShowRoomEditRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> showRoomRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			showRoomRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"showRoom");	
		}	
		else{
			showRoomRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"showRoom");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", showRoomRecordList);
		
		return jsonObject;
	}
	
	@RequestMapping("/getDiplayShowList.do")
	@ResponseBody
	public JSONObject getDiplayShowListRecord(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> diplayShowRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"diplayShow");	
		}	
		else{
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"diplayShow");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", diplayShowRecordList);
		
		return jsonObject;
	}

	@RequestMapping("/getRelicsBureauList.do")
	@ResponseBody
	public JSONObject getRelicsBureauList(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
		List<HashMap<String,Object>> diplayShowRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"relicsBureau");	
		}	
		else{
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"relicsBureau");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", diplayShowRecordList);
		
		return jsonObject;
	}
	@RequestMapping("/getRelicsBureauPersonChangeList.do")
	@ResponseBody
	public JSONObject getRelicsBureauPersonChangeList(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> diplayShowRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"relicsBureauPersonChange");	
		}	
		else{
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"relicsBureauPersonChange");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", diplayShowRecordList);
		
		return jsonObject;
	}
	@RequestMapping("/getRelicsBureauPersonDetailList.do")
	@ResponseBody
	public JSONObject getRelicsBureauPersonDetailList(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
//		museumId = "707";
		List<HashMap<String,Object>> diplayShowRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"relicsBureauPersonDetail");	
		}	
		else{
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"relicsBureauPersonDetail");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", diplayShowRecordList);
		
		return jsonObject;
	}
	@RequestMapping("/getRelicsUnitList.do")
	@ResponseBody
	public JSONObject getRelicsUnitList(String museumId,String id,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		String delFlag = "4";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		List<HashMap<String,Object>> diplayShowRecordList = new ArrayList<HashMap<String,Object>>();
		if(null == id || id == ""){
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, page,"relicsUnit");	
		}	
		else{
			diplayShowRecordList =  museumRecordService.getEditRecordList(museumId,delFlag, id,"relicsUnit");
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", diplayShowRecordList);
		
		return jsonObject;
	}
}