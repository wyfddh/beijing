package com.tj720.mip.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.service.ActivityService;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.GuideService;
import com.tj720.admin.service.SpreadtrumService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

@Controller
@RequestMapping("/m/index")
public class MIndexController {
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private GuideService guideService;
	@Autowired
	SpreadtrumService spreadtrumServiceInterface;
	@Autowired
	private CmsArticleService articleService;


	//公共服务平台 首页数据接口
	@RequestMapping("/info.do")
	@ResponseBody
	public JsonResult getIndexData(@RequestParam(defaultValue = "3") int size1,
			@RequestParam(defaultValue = "3") int size2,
			@RequestParam(defaultValue = "2") int size3,
			@RequestParam(defaultValue = "6") int size4) {
		try {
			//获取数据
			HashMap<String,Object> data = new HashMap<String,Object>();
			
			//获取热门展览
			Page page = new Page();
			page.setSize(size1);
			page.setCurrentPage(1);
			String orderCondition = "click_number";
			JsonResult Spreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page);
			data.put("hotSpreadtrum", Spreadtrum.getData());
			//热门藏品
			page.setSize(size2);
			page.setCurrentPage(1);
			List<Map<String,Object>> colList = guideService.getBjMuseumCollection(null, null,page);
			data.put("hotCollection", colList);
			//资讯新闻
			page.setSize(size3);
			page.setCurrentPage(1);
			JsonResult information = articleService.getArticleListByUniqueType1("xwdt",null, page);
			data.put("information", information);
			//活动
			page.setSize(size4);
			page.setCurrentPage(1);
			JsonResult activity = activityService.getActivityListByType("1", null, page);
			data.put("activity", activity);
			return new JsonResult(1,data);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(2, "系统异常");
		}
	}
}
