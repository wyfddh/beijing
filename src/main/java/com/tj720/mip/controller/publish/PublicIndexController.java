package com.tj720.mip.controller.publish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.constant.FileUtil;
import com.tj720.admin.model.MipCarousel;
import com.tj720.admin.service.ActivityService;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.GuideService;
import com.tj720.admin.service.MipCarouselService;
import com.tj720.admin.service.SpreadtrumService;
import com.tj720.admin.service.VirtualService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.EveryDayMuseumDto;
import com.tj720.mip.dto.FullTextSearchDto;

@Controller
@RequestMapping("/public")
public class PublicIndexController extends BaseController{
	@Autowired
	private VirtualService virtualService;
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private MipCarouselService mipCarouselService;
	@Autowired
	private Config config;//常量的取法
	@Autowired
	private GuideService guideService;
	@Autowired
	private SpreadtrumService spreadtrumServiceInterface;
	@Autowired
	private CmsArticleService articleService;
	
	//公共服务平台 首页数据接口
	@RequestMapping("/index.do")
	@ResponseBody
	public JsonResult getIndexData() {
		try {
			//获取数据
			HashMap<String,Object> data = new HashMap<String,Object>();
			//取配置文件信息 
			String carouselPositionId = FileUtil.getConfigValue("web.carouselPositionId");		
			List<MipCarousel> carousels = new ArrayList<MipCarousel>();
			carousels = mipCarouselService.getCarouselList(null,carouselPositionId);		//PC端轮播图
			if (!MyString.isEmpty(carousels)) {
				data.put("Carousels", carousels);
			}
			//每日一馆
			List<EveryDayMuseumDto> everyDayMuseumList = guideService.getEveryDayMuseumList();
			data.put("MuseumImageList", everyDayMuseumList);
			//获取热门展览
			Page page = new Page();
			page.setSize(3);
			page.setCurrentPage(1);
			String orderCondition = "click_number";
			JsonResult Spreadtrum = spreadtrumServiceInterface.getSpreadtrumList(orderCondition, page);
			data.put("hotSpreadtrum", Spreadtrum.getData());
			//热门藏品
			List<Map<String,Object>> colList = guideService.getBjMuseumCollection(null, null,page);
			data.put("hotCollection", colList);
			//书刊
			JsonResult books = articleService.getArticleListByUniqueType1("xssk",null, page);
			data.put("books", books);
			//资讯新闻
			page.setSize(2);
			page.setCurrentPage(1);
			JsonResult information = articleService.getArticleListByUniqueType1("xwdt",null, page);
			data.put("information", information);
			//活动
			page.setSize(6);
			page.setCurrentPage(1);
			JsonResult activity = activityService.getActivityListByType("1", null, page);
			data.put("activity", activity);
			//论文
			JsonResult dissertation = articleService.getArticleListByUniqueType1("xslw",null, page);
			data.put("dissertation", dissertation);
			return new JsonResult(1,data);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常");
		}
	}
	
	 	//公共服务平台 全文检索
		@RequestMapping(value="/fullTextSearch.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public JsonResult fullTextSearch(String key,String type, @RequestParam(defaultValue = "10") int size,
				@RequestParam(defaultValue = "1") int currentPage) {
			try {
				// 分页page
				Page page = new Page();
				page.setSize(size);
				page.setCurrentPage(currentPage);
				List<FullTextSearchDto> fullTextSearchs = new ArrayList<FullTextSearchDto>();
				JsonResult jsonResult = new JsonResult(1,fullTextSearchs);
				String typeStr = StringUtils.isBlank(type)? null : type;
				jsonResult = activityService.fullTextSearch(page,key,typeStr);
				return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0, "系统异常");
			}
		}

}