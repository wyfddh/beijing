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
import com.tj720.admin.dto.MuseumSafeEnsureDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumDigitizationService;
import com.tj720.admin.service.IMuseumSafeEnsureService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Tools;

/**
 *	安全保障Controller
 * @author chenshiya
 * @version 2018-05-17
 */
@Controller
@RequestMapping("/safeEnsure")
public class MuseumSafeEnsureController extends BaseController{

	@Autowired
	private IMuseumSafeEnsureService safeEnsureService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	/**
	 * 安全保障页面
	 */
	@ResponseBody
	@RequestMapping("/form.do")
	public ModelAndView form(String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumSafeEnsure.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		MuseumSafeEnsureDto safeEnsureDto = safeEnsureService.selectForm(museumId,level);
		modelAndView.addObject("safeEnsureInfo", safeEnsureDto);
		modelAndView.addObject("museumId", museumId);
		return modelAndView;
	}

	/**
	 * 保存安全保障
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String add(MuseumSafeEnsureDto safDto, String isFull) throws Exception{
		String result="";
		try {
			int num = safeEnsureService.save(safDto);
			if(num>0){
				MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
				progressInfo.setSafePer(isFull);
				progressInfo.setMuseumId(safDto.getMuseumId());
				progressInfo.setFlag("1");
				int count =museumBaseInfoService.updateProgress(progressInfo);
				if(count>0){
					MuseumDataProgressDto pro = museumBaseInfoService.getDetail(safDto.getMuseumId(),"1");
					MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
					updateInfo.setAllDataPer(Utils.progressIsFull(pro));
					updateInfo.setMuseumId(safDto.getMuseumId());
					updateInfo.setFlag("1");
					museumBaseInfoService.updateProgress(updateInfo);
					result = "1";
				}else{
					result = "0";
				}
			}else{
				result = "0";
			}
		} catch (Exception e) {
			// TODO: handle exception
			result = "0";
		}
		return result;
	}
}