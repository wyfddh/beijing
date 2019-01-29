/**
 * 
 */
package com.tj720.mip.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.model.MipArea;
import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipOpenCollectionInfoService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

/**
 * @author caim 藏品接口
 */
@Controller("mCollectionInterface")
@RequestMapping("/m/collection")
public class MCollectionController extends BaseController{
	@Autowired
	MipOpenCollectionInfoService mipOpenCollectionInfoService;
	@Autowired
	private MipYearTypeService mipYearTypeService;
	@Autowired
	private MipCollectionCategoryService mipCollectionCategoryService;
	@Autowired
	private Config config;
	@Autowired
	private MipAreaService mipAreaService;

	// 藏品首页单独接口
	@RequestMapping("/getTwoCollectionList.do")
	@ResponseBody
	public JsonResult getTwoCollectionList() {
		try {
			HashMap data = new HashMap();
			// 获取精品藏品
			Page page = new Page();
			page.setSize(4);
			page.setCurrentPage(1);
			JsonResult highQualityCollection = mipOpenCollectionInfoService.getCollectionList(null, null, null, null, 1,page, "0", null);
			data.put("highQualityCollection", highQualityCollection);

			// 获取藏品专题
//			Page page1 = new Page();
//			page1.setSize(10);
//			page1.setCurrentPage(1);
//			JsonResult collectionsCategorys = mipOpenCollectionInfoService.getCollectionCategoryList(page1);
//			data.put("collectionsCategorys", collectionsCategorys);

			// 返回数据
			return new JsonResult(1, data);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

	/**
	 * 获取藏品列表
	 * 
	 * @param collectionsCategory
	 *            藏品分类
	 * @param city
	 *            藏品区域
	 * @param year
	 *            藏品年代
	 * @param name
	 * @param isHighQuality
	 * @param size
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/getCollectionList.do")
	@ResponseBody
	public JsonResult getCollectionList(@RequestParam(required=false) String userid, @RequestParam(required=false) String collectionsCategory, @RequestParam(required=false) String city, @RequestParam(required=false) String year, @RequestParam(required=false) String name,
			@RequestParam(required=false) Integer isHighQuality, @RequestParam(defaultValue = "9") int size,
			@RequestParam(defaultValue = "1") int currentPage) {
		try {
			// 获取精品藏品
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			JsonResult Collections = mipOpenCollectionInfoService.getCollectionList(collectionsCategory, city, year,
					name, isHighQuality, page, "1", userid);
			// 返回数据
			
			//返回藏品总个数
			Integer countCollectionList = mipOpenCollectionInfoService.countCollectionList(collectionsCategory, city, year, name, isHighQuality);
			Map<String, Object> allCount = new HashMap<>();
			allCount.put("total", countCollectionList);
			Collections.setOthers(allCount);
			
			return Collections;
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}
	
	/**
	 * 获取藏品列表，查询条件
	 * 
	 * @return
	 */
	@RequestMapping("/getCollectionSearch.do")
	@ResponseBody
	public JsonResult getCollectionSearch(HttpServletResponse response) {
		try {
			JsonResult result = null;
			// 查询文物类别
			List<CollectionCategoryDto> ccList = mipCollectionCategoryService.collectionCategoryList(1);
			result = new JsonResult(1, ccList);
			// 返回数据
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}

	// 获取藏品详情
	@RequestMapping("/getCollectionById.do")
	@ResponseBody
	public JsonResult getCollectionById(String id, @RequestParam(required=false)String userid) {
		try {
			Map<String, Object> result  = new HashMap<>();
			//藏品详情
			if(!MyString.isEmpty(id)){
				Map<String, Object> Collections = mipOpenCollectionInfoService.getCollectionById(id, userid);
				result.put("collectionInfo", Collections);
				
				//点击+1
				MipOpenCollectionInfo collec = new MipOpenCollectionInfo();
				collec.setId(id);
				int clickCounts = Integer.parseInt(Collections.get("clickCounts")==null?"0":Collections.get("clickCounts").toString());
				collec.setClickCounts(clickCounts+1);
				mipOpenCollectionInfoService.update(collec);
				// 返回数据
				return new JsonResult(1, result);
			}
			return new JsonResult(0, "参数为空");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员");
		}
	}
}
