package com.tj720.mip.controller.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMipStatisticsService;
import com.tj720.mip.model.MipStatistics;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Tools;
@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseController<MipStatistics> {
	@Autowired
	private IMipStatisticsService mipStatisticsService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private Config config;
	@RequestMapping("/info.do")
	public ModelAndView getInfo(@ModelAttribute MipStatistics mipStatistics){
		ModelAndView modelAndView = new ModelAndView("");
		//mipStatisticsService.getCount(map);
//		String hql = "select count(distinct(orgId)) from MipStatistics where status <> -127"; 
		//int orgNo = mipStatisticsService.getNoByHql(hql);
		String hql = "select count(*) from MipOrganization where platformId="+config.getPlatformId()+" and level = 3";
		List<Long> countList = (List<Long>) mipOrganizationService.queryByHql(hql, Tools.getMap());
		Long count = countList.get(0);
		modelAndView.addObject("orgNo", count);
		return modelAndView;
	}

}
