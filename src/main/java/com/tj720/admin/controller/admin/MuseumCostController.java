package com.tj720.admin.controller.admin;


import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumCostService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Tools;

/**
 * 收入与花费Controller
 * @author chenshiya
 * @version 2018-06-28
 */
@Controller
@RequestMapping("/museumCost")
public class MuseumCostController extends BaseController{

	@Autowired
	private IMuseumCostService museumCoseService;
	
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;

	/**
	 * 收入与花费列表页面
	 */
	@ResponseBody
	@RequestMapping("/list.do")
	public ModelAndView list(String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumCost.jsp");
		
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		List<MuseumCostDto> museumCostList = museumCoseService.selectCostList(museumId,level);
		modelAndView.addObject("costList", museumCostList);
		modelAndView.addObject("museumId", museumId);
		return modelAndView;
	}

	/**
	 * 保存收入与花费列表
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult add(String costList,String isFull,String museumId) throws Exception{
		JsonResult result = null;
		JSONArray jsonArray=JSONArray.fromObject(costList);
		List<MuseumCostDto> costListArray =(List<MuseumCostDto>)JSONArray.toCollection(jsonArray,MuseumCostDto.class);
		int num = museumCoseService.save(costListArray);
		if(num>0){
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			progressInfo.setCostPer(isFull);
			progressInfo.setMuseumId(museumId);
			progressInfo.setFlag("1");
			int count =museumBaseInfoService.updateProgress(progressInfo);
			if(count>0){
				MuseumDataProgressDto pro = museumBaseInfoService.getDetail(museumId,"1");
				MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
				updateInfo.setAllDataPer(Utils.progressIsFull(pro));
				updateInfo.setMuseumId(museumId);
				updateInfo.setFlag("1");
				museumBaseInfoService.updateProgress(updateInfo);
				result = new JsonResult(1, "保存成功！");
			}else{
				result = new JsonResult(0, "保存失败！");
			}
		}else{
			result = new JsonResult(0, "保存失败！");
		}
		return result;
	}
	
	/**
	 * 删除收入与花费
	 */
	@RequestMapping("/deleteCost.do")
	@ResponseBody
	public JsonResult delete(MuseumCostDto museumCostDto) {
		JsonResult result = null;
		int num = museumCoseService.deleteByLogic(museumCostDto.getId());
		if(num>0){
			result = new JsonResult(1, "删除成功！");
		}else{
			result = new JsonResult(0, "删除失败！");
		}
		return result;
	}

}