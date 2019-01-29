package com.tj720.admin.controller.admin;


import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumCollectionInfoService;
import com.tj720.admin.service.IMuseumPromotionService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Tools;

/**
 * 藏品信息Controller
 * @author chenshiya
 * @version 2018-07-13
 */
@Controller
@RequestMapping("/colletionInfo")
public class MuseumCollectionInfoController extends BaseController{

	@Autowired
	private IMuseumCollectionInfoService museumCollectionInfoService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	/**
	 * 查询藏品信息
	 */
	@RequestMapping("/form.do")
	public ModelAndView form(String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumCollection.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		MuseumCollectionDto Info = museumCollectionInfoService.selectForm(museumId,level);
		modelAndView.addObject("result", Info);
		modelAndView.addObject("museumId", museumId);
		return modelAndView;
	}

	/**
	 * 保存藏品信息
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String  add(MuseumCollectionDto promotionDto,String isFull) throws Exception{
		String result="";
		try {
			String serviceId = promotionDto.getId();
			if(StringUtils.isNotEmpty(serviceId)){
				museumCollectionInfoService.update(promotionDto);
				
				//删除所有为3状态的记录
				museumCollectionInfoService.deleteBase(promotionDto.getMuseumId(), "3");
	            //插入一条状态为3的修改记录数据
				promotionDto.setFlag("3");
				museumCollectionInfoService.insert(promotionDto);
			}else{
				promotionDto.setFlag("1");
				museumCollectionInfoService.insert(promotionDto);
			}
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			progressInfo.setCollectionPer(isFull);
			progressInfo.setMuseumId(promotionDto.getMuseumId());
			progressInfo.setFlag("1");
			int count =museumBaseInfoService.updateProgress(progressInfo);
			if(count>0){
				MuseumDataProgressDto pro = museumBaseInfoService.getDetail(promotionDto.getMuseumId(),"1");
				MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
				updateInfo.setAllDataPer(Utils.progressIsFull(pro));
				updateInfo.setMuseumId(promotionDto.getMuseumId());
				updateInfo.setFlag("1");
				museumBaseInfoService.updateProgress(updateInfo);
				result = "1";
			}else{
				result = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result="0";
		}
		return result;
	}
}