package com.tj720.mip.controller.publish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.util.FileUtil;
import com.tj720.admin.model.MipArea;
import com.tj720.admin.model.MipCarousel;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.GuideService;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.MipCarouselService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
//import com.tj720.mip.dto.CollectionInfoDto;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

/**
 * 博物馆导览
 * 
 * @author 程荣凯
 *
 */
@Controller
@RequestMapping("/Guide")
public class GuideController extends BaseController{
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
			page.setSize(1000);
			page.setCurrentPage(1);
			
			//展览
			Map<String, Object> spreadtrums = new HashMap<>();
			// 博物馆展览--常设
			List<Map<String, Object>> cs_spread = guideService.getSpreadtrumsByKeywordPage(museumId,"1", page);
			spreadtrums.put("cs_spread", cs_spread);
			
			// 博物馆展览--临时
			List<Map<String, Object>> ls_spread = guideService.getSpreadtrumsByKeywordPage(museumId,"0", page);
			spreadtrums.put("ls_spread", ls_spread);
			
			// 博物馆展览--虚拟展厅
			List<Map<String, Object>> xn_virtual = guideService.getVirtualByMuseumId(museumId);
			spreadtrums.put("xn_virtual", xn_virtual);
			
			data.put("spreadtrums", spreadtrums);
			
			//资讯(2个新闻动态，4个通知公告)
			Map<String, Object> zixun = new HashMap<>();
			List<Map<String, Object>> xwdt = guideService.getArticleByUniqueName("xwdt", museumId, 2);		//新闻动态
			List<Map<String, Object>> tzgg = guideService.getArticleByUniqueName("tzgg", museumId, 4);		//通知公告
			zixun.put("xwdt", xwdt);
			zixun.put("tzgg", tzgg);
			
			data.put("zixun", zixun);
		
			//获取博物馆藏品所有分类
			List<Map<String, Object>> collectionsType = guideService.getCollectionTypeByMuseum(museumId);
			data.put("collectionsType", collectionsType);
			return new JsonResult(1, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}
	
	/**
	 * 根据博物馆id，藏品分类查询藏品分页数据
	 * @param museumId		博物馆id
	 * @param type			藏品分类
	 * @param size
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/getCollectionByMuseumId.do")
	@ResponseBody
	public JsonResult getCollectionByMuseumId(@RequestParam(required=false) String museumId,@RequestParam(required=false) String type, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "1") int currentPage) {
		try {
//			Map<String, Object> types = new HashMap<>();
//			types.add("2");
//			types.add("4");
//			types.add("1");
//			types.add("5");
//			types.add("7");
//			types.add("10");
//			types.add("14");
//			types.add("3");
//			types.add("20");
//			1、陶器
//					2
//			2、青铜器
//					4
//			3、玉石器
//					1
//			4、金银器
//					5
//			5、漆器
//					7
//			6、书画
//					10
//			7、钱币
//					14
//			8、瓷器
//					3
//			9、古籍
//					20
//			10、其他
			
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			List<Map<String, Object>> collections = guideService.getBjMuseumCollection(museumId, type,page);
			return new JsonResult(1, collections, page);
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
	 * 获取区域列表-供自定义表单选择地址
	 * @return
	 */
	@RequestMapping("/getAreaJson.do")
	@ResponseBody
	public JsonResult getAreaJson(@RequestParam(required=false,defaultValue = "0") String pid) {
		try {
			List<MipArea> cityList = mipAreaService.getCityListByPid(Integer.parseInt(pid));
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
	public JsonResult getMuseumSearchList(@RequestParam(required=false) String name, @RequestParam(required=false) String area) {
		try {
			List<Map<String, Object>> museumListByAreaAndKey = guideService.getMuseumListByAreaAndKey(name, area);
			return new JsonResult(1, museumListByAreaAndKey);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

	/**
	 * 获取博物馆列表
	 * 
	 * @return
	 */
	@RequestMapping("/getMuseumList.do")
	@ResponseBody
	public JsonResult getMuseumList(String museumId) {
		// 获取博物馆列表
		try {
			List<Map<String, Object>> MuseumList = guideService.getBjMuseumBaseInfoList();
			HashMap<String, Object> data = new HashMap<>();
			data.put("MuseumList", MuseumList);
			// 获取博物馆总数及访问人数
			boolean result = guideService.addUserCount("1");
			if(!result){
				System.out.println("更新访问人数失败");
			}
			Map<String, Object> CountInfo = guideService.getBjMuseumCountAndUserCount();
			data.put("CountInfo", CountInfo);
			
			// 取配置文件信息
			String carouselGuidPositionId = FileUtil.getConfigValue("web.carouselGuidPositionId");
			List<MipCarousel> carousels = mipCarouselService.getCarouselList(null, carouselGuidPositionId);
			if (!MyString.isEmpty(carousels)) {
				data.put("Carousels", carousels);
			}
			Page page = new Page();
			page.setSize(12);
			page.setCurrentPage(1);
			JsonResult MuseumImageList = guideService.getMuseumImageList(museumId, page);
			if (!MyString.isEmpty(MuseumImageList)) {
				// JsonResult jsonResult = new JsonResult(1,MuseumImageList,page);
				data.put("MuseumImageList", MuseumImageList);
			}

			return new JsonResult(1, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
			// return new JsonResult(0, "系统异常");
		}
	}

	/**
	 * 获取博物馆藏品
	 * 
	 * @param museum_id
	 *            博物馆ID
	 * @return
	 */
	@RequestMapping("/getMuseumCollection.do")
	@ResponseBody
	public JsonResult getMuseumCollection(@RequestParam String museumId, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "1") int currentPage) {
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		List<Map<String, Object>> collections = guideService.getBjMuseumCollection(museumId, null, page);
		if (!MyString.isEmpty(collections)) {
			return new JsonResult(1, collections, page);
		}
		return new JsonResult(0, "未查询到数据");
	}

	/**
	 * 获取博物馆资讯交通
	 * 
	 * @param museum_id
	 *            博物馆ID
	 * @return
	 */
	@RequestMapping("/getMuseumInformation.do")
	@ResponseBody
	public JsonResult getMuseumInformation(@RequestParam String museumId,
			@RequestParam(defaultValue = "zx") String uniqueName, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "1") int currentPage) {
		HashMap data = new HashMap();
		if (!MyString.isEmpty(museumId)) {
			Map<String, Object> jiaotong = guideService.getBjMuseumInformation(museumId);
			if (!MyString.isEmpty(jiaotong)) {
				data.put("jiaotong", jiaotong);
			}
		}
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		List<Map<String, Object>> zixunList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list = articleService.getChildrenSubject(uniqueName);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				String tempName = list.get(i).get("uniqueName").toString();
				JsonResult tempZixun = articleService.getArticleListByUniqueType1(tempName, museumId, page);
				zixunList.addAll((List) tempZixun.getData());
			}
		}
		if (!MyString.isEmpty(zixunList)) {
			data.put("zixun", zixunList);
		}
		return new JsonResult(1, data, page);
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

}
