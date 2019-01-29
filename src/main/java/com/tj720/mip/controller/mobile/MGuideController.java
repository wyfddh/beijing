package com.tj720.mip.controller.mobile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.model.MipArea;
import com.tj720.admin.model.MipTour;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.GuideService;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.MipCarouselService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;

/**
 * 博物馆导览
 * 
 * @author Caim
 *
 */
@Controller
@RequestMapping("/m/Guide")
public class MGuideController extends BaseController{
	@Autowired
	GuideService guideService;
	@Autowired
	private CmsArticleService articleService;
	@Autowired
	MipCarouselService mipCarouselService;
	@Autowired
	private Config config;
	@Autowired
	MipAttachmentService mipAttachmentService;
	@Autowired
	private MipAreaService mipAreaService;

	/**
	 * 获取博物馆资料
	 * 
	 * @param museum_id
	 *            博物馆ID
	 * @return
	 */
	@RequestMapping("/getMuseumDetail.do")
	@ResponseBody
	public JsonResult getMuseumDetail(String museumId, String userid) {
		try {
			Map<String,Object> data = new HashMap<String,Object>();
			// 获取博物馆详细资料
			Map<String,Object> museumDetail = guideService.getBjMuseumBaseInfo(museumId, userid);
			data.put("museumDetail", museumDetail);
			
			Page page = new Page();
			page.setSize(10);
			page.setCurrentPage(1);
			
			// 博物馆展览--常设+临时
			List<Map<String, Object>> spreadtrums = guideService.getSpreadtrumsByKeywordPage(museumId,null, page);
			for (Map<String, Object> map : spreadtrums) {
				if(map != null && map.get("exhibitionType") != null) {
					if("0".equals(map.get("exhibitionType").toString())) {
						String beginDate = map.get("beginDate").toString();
						String endDate = map.get("endDate").toString();
						if(!StringUtils.isBlank(beginDate) && !StringUtils.isBlank(endDate) && beginDate.length() >= 10 && endDate.length() >= 10){
							Date begin = DateUtil.StringToDate(beginDate.substring(0, 10));		//开始时间
							Date end = DateUtil.StringToDate(endDate.substring(0, 10));		//结束时间
							map.put("beginDate", DateUtil.DateToString(begin, DateStyle.YYYY_MM_DD_EN));
							map.put("endDate", DateUtil.DateToString(end, DateStyle.YYYY_MM_DD_EN));
							
							int closeDays = 0;		//闭展时间
							if(end.getTime() > (new Date()).getTime()) {
								closeDays = DateUtil.getIntervalDays(new Date(), end);
							}
							map.put("closeDays", closeDays);
						}
					}
				}
			}
			data.put("spreadtrums", spreadtrums);
			
			Page page1 = new Page();
			page1.setSize(10);
			page1.setCurrentPage(1);
			List<Map<String, Object>> collections = guideService.getBjMuseumCollection(museumId, null,page1);
			data.put("collections", collections);
			
			//增加语音导览
			List<MipTour> tourList = guideService.getTourListByMuseumId(museumId);
			data.put("tourList", tourList);
			return new JsonResult(1, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}
	
	/**
	 * 获取区域列表
	 * @return
	 */
	@RequestMapping("/getAreaList.do")
	@ResponseBody
	public JsonResult getAreaList() {
		try {
			String cityId = config.getCityId();
			List<MipArea> cityList = mipAreaService.getCityListByPid(Integer.parseInt(cityId));
			return new JsonResult(1, cityList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}
	
	/**
	 * 博物馆搜索
	 * @param name
	 * @param area
	 * @return
	 */
	@RequestMapping("/getMuseumSearchList.do")
	@ResponseBody
	public JsonResult getMuseumSearchList(@RequestParam(required=false) String name, @RequestParam(required=false) String area, 
			@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "1") int currentPage) {
		try {
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			List<Map<String, Object>> museumListByAreaAndKey = guideService.getMuseumListByAreaAndKey(name, area, page);
			return new JsonResult(1, museumListByAreaAndKey, page);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

	@RequestMapping("/addOnClick.do")
	@ResponseBody
	public JsonResult addOnClick(@RequestParam(defaultValue="1") String type){
		Integer result = guideService.getUserCount(type);
		boolean flag = false;
		if(result != null){
			flag = guideService.setUserCount(type,++result);
		}else{
			flag = guideService.insertUserCount(type, 1);
		}
		if(flag){
			return new JsonResult(1, "成功！");
		}
		return new JsonResult(0, "失败！");
	}
	
	@RequestMapping("/getGuideDetail.do")
	@ResponseBody
	public JsonResult getGuideDetatil(String id) {
		try {
			// 获取导览详细资料
			Map<String,Object> tourData = new HashMap<String,Object>();
			tourData = guideService.getTourDetail(id);
			return new JsonResult(1, tourData);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

	@RequestMapping("/getPictureList.do")
	@ResponseBody
	public JsonResult getGuidePictureList(String id) {
		try {
			// 获取导览图片列表
			Map<String,Object> resultMap = guideService.getPictureList(id);
			return new JsonResult(1, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

	@RequestMapping("/getCollectInfoList.do")
	@ResponseBody
	public JsonResult getCollectInfoList(String tourId,String collectionId) {
		try {
			// 获取导览藏品列表
			Map<String,Object> resultMap = guideService.getCollectInfoList(tourId,collectionId);
			return new JsonResult(1, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

}
