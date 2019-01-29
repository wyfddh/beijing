package com.tj720.admin.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumDigitizationService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Tools;

/**
 *	藏品数字化Controller
 * @author chenshiya
 * @version 2018-05-17
 */
@Controller
@RequestMapping("/museumDigitization")
public class MuseumDigitizationController extends BaseController{

	@Autowired
	private IMuseumDigitizationService museumDigitizationService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	/**
	 * 藏品数字化列表页面
	 */
	@ResponseBody
	@RequestMapping("/form.do")
	public ModelAndView form(String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumDigitization.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		MuseumDigitizationDto digitizationInfo = museumDigitizationService.selectForm(museumId,level);
		modelAndView.addObject("digitizationInfo", digitizationInfo);
		modelAndView.addObject("museumId", museumId);
		return modelAndView;
	}

	/**
	 * 保存藏品数字化
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String add(MuseumDigitizationDto digitizationDto, String isFull) throws Exception{
		String result="";
		try {
			int num = museumDigitizationService.save(digitizationDto);
			if(num>0){
				MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
				progressInfo.setDigitizationPer(isFull);
				progressInfo.setMuseumId(digitizationDto.getMuseumId());
				progressInfo.setFlag("1");
				int count =museumBaseInfoService.updateProgress(progressInfo);
				if(count>0){
					MuseumDataProgressDto pro = museumBaseInfoService.getDetail(digitizationDto.getMuseumId(),"1");
					MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
					updateInfo.setAllDataPer(Utils.progressIsFull(pro));
					updateInfo.setMuseumId(digitizationDto.getMuseumId());
					progressInfo.setFlag("1");
					museumBaseInfoService.updateProgress(updateInfo);
					result = "1";
				}else{
					result = "0";
				}
			}else{
				result = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result = "0";
		}
		return result;
	}
}