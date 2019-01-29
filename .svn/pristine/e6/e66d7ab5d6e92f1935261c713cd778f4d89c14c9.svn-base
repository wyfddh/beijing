package com.tj720.admin.controller.admin;


import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumDisplayShowDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumDisplayShowService;
import com.tj720.admin.service.IMuseumPublicServiceService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Tools;

/**
 * 陈列展览与社会服务Controller
 * @author chenshiya
 * @version 2018-05-17
 */
@Controller
@RequestMapping("/museumPublicService")
public class MuseumPublicServiceController extends BaseController{

	@Autowired
	private IMuseumPublicServiceService museumPublicServiceService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	@Autowired
	private IMuseumDisplayShowService museumShowService;
	/**
	 * 陈列展览与社会服务页面
	 */
	@RequestMapping("/form.do")
	public ModelAndView form(String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumPublicService.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		MuseumPublicServiceDto museumServiceDto = museumPublicServiceService.selectForm(museumId,level);
		modelAndView.addObject("serviceInfo", museumServiceDto);
		modelAndView.addObject("museumId", museumId);
		List<MuseumDisplayShowDto> museumShowList = museumShowService.selectShowList(museumId,level);
		modelAndView.addObject("showList", museumShowList);
		return modelAndView;
	}

	/**
	 * 保存陈列展览与社会服务
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String add(MuseumPublicServiceDto serviceDto,String isFull,String showListStr) throws Exception{
		String result = "";
		try {
			//保存基本陈列列表
			JSONArray jsonArray=JSONArray.fromObject(showListStr);
			List<MuseumDisplayShowDto> showListArray =(List<MuseumDisplayShowDto>)JSONArray.toCollection(jsonArray,MuseumDisplayShowDto.class);
			museumShowService.save(showListArray);
			String userId = Tools.getUser().getId();
			String serviceId = serviceDto.getId();
			if(StringUtils.isNotEmpty(serviceId)){
				museumPublicServiceService.update(serviceDto);
				//删除所有为3状态的记录
				museumPublicServiceService.deleteBase(serviceDto.getMuseumId(), "3");
	            //插入一条状态为3的修改记录数据
	            serviceDto.setFlag("3");
	            museumPublicServiceService.insert(serviceDto);
			}else{
				serviceDto.setFlag("1");
				museumPublicServiceService.insert(serviceDto);
			}
			
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			progressInfo.setServicePer(isFull);
			progressInfo.setMuseumId(serviceDto.getMuseumId());
			progressInfo.setFlag("1");
			int count =museumBaseInfoService.updateProgress(progressInfo);
			if(count>0){
				MuseumDataProgressDto pro = museumBaseInfoService.getDetail(serviceDto.getMuseumId(),"1");
				MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
				updateInfo.setAllDataPer(Utils.progressIsFull(pro));
				updateInfo.setMuseumId(serviceDto.getMuseumId());
				updateInfo.setFlag("1");
				museumBaseInfoService.updateProgress(updateInfo);
				result = "1";
			}else{
				result = "0";
			}
			result = "1";
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result = "0";
		}
		
		return result;
	}
	
	/**
	 * 删除陈列展览
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public JsonResult delete(String id) {
		JsonResult result = null;
		int num = museumShowService.deleteByLogic(id);
		if(num>0){
			result = new JsonResult(1, "删除成功！");
		}else{
			result = new JsonResult(0, "删除失败！");
		}
		return result;
	}
	
}