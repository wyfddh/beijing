package com.tj720.mip.controller.back;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IFCCollectionService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.FCCollection;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.YearTypeService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/back/fCCollection")
public class FCCollectionController extends BaseController<FCCollection> {

	@Autowired
	private IFCCollectionService fCCollectionService;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private IYearTypeService yearTypeService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;

	/**
	 * 
	 * @param fCCollection
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页显示多少条，-1表示查询全部
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/info.do")
	@ResponseBody
	public ModelAndView getCollectionInfo(String key, @ModelAttribute FCCollection fCCollection, String erea,
			@RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "1", name="page") int currentPage,
			@RequestParam(defaultValue = "createTime") String order) throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/yipu/yplist.jsp");
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
		String listKey = MessageFormat.format(KeyConstants.YP_COLLECTION_INFO_LIST_KEY, orgId);
		String jsonStr = JedisService.get(listKey);
		if(StringUtils.isNotBlank(jsonStr)) {
			mod = JSON.parseObject(jsonStr, ModelAndView.class);
		} else {
			MipOrganization org = mipOrganizationService.get(orgId);
			//查询组织机构的级别
			byte level = org.getLevel();
			
			// 创建map集合，放置查询对象
			// Map<String, Object> map = new HashMap<String, Object>();
			// 查询年代集合
			String hql_yearType = "from YearType yt where (yt.parentId ='43' or yt.parentId='46' or yt.parentId='98' or yt.id='142' or yt.id='143') and yt.fcCounts > 0 order by yt.code";
			List<YearType> ytList = (List<YearType>) fCCollectionService.queryByHql(hql_yearType, Tools.getMap());
			mod.addObject("ytList", ytList);
	
			// 查询文物类别集合
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService
					.queryByHql("from CollectionCategory cc where cc.openCounts>0 order by sequence desc", Tools.getMap());
			mod.addObject("ccList", ccList);
	
			// 查询组织机构（城市）的集合
			if (level==1) {
				//省级
				List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where platformId="+config.getPlatformId()+" and level=2 order by sequence", Tools.getMap());
				mod.addObject("cityList", cityList);
			}
			if (level==2) {
				//市级
				List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where platformId="+config.getPlatformId()+" and level=2 and id="+orgId+" order by sequence", Tools.getMap());
				mod.addObject("cityList", cityList);
			}
			
			//查询组织机构（博物馆）的集合
			if (erea != null && !"".equals(erea)) {
				List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where parentId="+ erea +" and level=3 and status>0 and isdelete=0 order by sequence", Tools.getMap());
				mod.addObject("musList", musList);
			}
			
			//查询山东所有博物馆集合
			List<MipOrganization> museums = (List<MipOrganization>) mipOrganizationService.queryByHql(
					"from MipOrganization where platformId="+config.getPlatformId()+" and level=3 and status>0 and isdelete=0 order by sequence desc",
					Tools.getMap());
			mod.addObject("museums", museums);
	
			// 查询一普文物列表
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
	
			String hql = "from FCCollection where status >= 0";
			
			//通过判断用户级别查询
			if (level == 0) {
				//全国
			}
			if (level == 1) {
				//省级
				//查询省级下所有市
				String orgIds = "";
				List<MipOrganization> cityArrayList = (List<MipOrganization>) fCCollectionService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
				StringBuffer sBuffer = new StringBuffer();
				if (!MyString.isEmpty(cityArrayList)) {
					for (MipOrganization mipOrganization : cityArrayList) {
						sBuffer.append("'"+mipOrganization.getId()+"'").append(",");
					}
				}
				String cityIds = sBuffer.toString();
				cityIds = cityIds.substring(0,cityIds.length()-1);
				//查询市级下所有博物馆
				if (!MyString.isEmpty(cityIds)) {
					List<MipOrganization> orgList = (List<MipOrganization>) fCCollectionService.queryByHql("from MipOrganization where parentId in (" + cityIds + ")", Tools.getMap());
					StringBuffer sBuffer2 = new StringBuffer();
					if (!MyString.isEmpty(orgList)) {
						for (MipOrganization mipOrganization2 : orgList) {
							sBuffer2.append("'"+mipOrganization2.getId()+"'").append(",");
						}
					}
					orgIds = sBuffer2.toString();
					orgIds = orgIds.substring(0, orgIds.length()-1);
				}
				hql += " and collectionUnit in ("+ orgIds +")";
			}
			if (level == 2) {
				//市级
				String orgIds = "";
				List<MipOrganization> cityArrayList = (List<MipOrganization>) fCCollectionService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
				StringBuffer sBuffer = new StringBuffer();
				if (!MyString.isEmpty(cityArrayList)) {
					for (MipOrganization mipOrganization : cityArrayList) {
						sBuffer.append("'"+mipOrganization.getId()+"'").append(",");
					}
				}
				orgIds = sBuffer.toString();
				orgIds = orgIds.substring(0,orgIds.length()-1);
				hql += " and collectionUnit in ("+ orgIds +")";
			}
			
			if (level == 3) {
				//博物馆级
				hql += " and collectionUnit in ("+ org.getId() +")";
			}
			
			if (fCCollection.getYearType() != null && !"".equals(fCCollection.getYearType())) {
				hql += (" and yearType='" + fCCollection.getYearType() + "'");
			}
			if (fCCollection.getCollectionsCategory() != null && !"".equals(fCCollection.getCollectionsCategory())) {
				hql += (" and collectionsCategory='" + fCCollection.getCollectionsCategory() + "'");
			}
			if (fCCollection.getCollectionUnit() != null && !"".equals(fCCollection.getCollectionUnit())) {
				hql += (" and collectionUnit='" + fCCollection.getCollectionUnit() + "'");
			}
			if (fCCollection.getCollectionLevel() != null && !"".equals(fCCollection.getCollectionLevel())) {
				hql += (" and collectionLevel='" + fCCollection.getCollectionLevel() + "'");
			}
			if (fCCollection.getIsHighQuality() != 0 && !"".equals(fCCollection.getIsHighQuality())) {
				hql += (" and isHighQuality=" + fCCollection.getIsHighQuality());
			}
			if (fCCollection.getIsOpen() != 0 && !"".equals(fCCollection.getIsOpen())) {
				hql += (" and isOpen=" + fCCollection.getIsOpen());
			}
			if (!MyString.isEmpty(key)) {
				key = key.trim();
				hql += " and (name like '%" + key + "%' or gsNo like '%" + key + "%')";
			}
			hql += " order by createTime desc";
			List<FCCollection> fccList = (List<FCCollection>) fCCollectionService.queryByHql(hql, Tools.getMap(), page);
			for (FCCollection m2 : fccList) {
				String pictureIds = m2.getPictureIds();
				if (!MyString.isEmpty(pictureIds)) {
					String[] split = pictureIds.split(",");
					String picId = split[0];
					Picture picture = pictureService.get(picId);
					m2.setPictureIds(config.getImageUrl()+picture.getUrl());
				}
			}
			mod.addObject("page", page);
			mod.addObject("fccList", fccList);
			mod.addObject("fCCollection", fCCollection);
			mod.addObject("erea", erea);
			mod.addObject("key", key);
			jsonStr = JSON.toJSONString(mod);
			JedisService.set(listKey, jsonStr, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
		}
		return mod;
	}


	@RequestMapping("/detail.do")
	@ResponseBody
	public ModelAndView detail(@ModelAttribute FCCollection fCCollection) throws MyException {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/collection/yipu/ypdetail.jsp");
		try {
			FCCollection collection = fCCollectionService.get(fCCollection.getId());
			modelAndView.addObject("collection", collection);
			//查询博物馆名称
			String collectionUnitId = collection.getCollectionUnit();
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnitId);
			modelAndView.addObject("mipOrganization", mipOrganization.getName());
			
			//查询藏品的文物类别
			String collectionsCategory = collection.getCollectionsCategory();
			CollectionCategory collectionCategory = collectionCategoryService.get(collectionsCategory);
			modelAndView.addObject("collectionCategory", collectionCategory.getName());
			//查询年代
			String yearTypeId = collection.getYearType();
			YearType yearType = yearTypeService.get(yearTypeId);
			modelAndView.addObject("yearType", yearType.getName());
			
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			String pictureIds = collection.getPictureIds();
			if (!MyString.isEmpty(pictureIds)) {
				String[] split = pictureIds.split(",");
				StringBuffer sb = new StringBuffer("'");
				for (String pid : split) {
					sb.append(pid).append("','");
				}
				pictureIds = sb.substring(0, sb.length()-2);
			}
			pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ") order by isMain desc,url",Tools.getMap());
			//重设图片访问路径
			if (!MyString.isEmpty(pictures)) {
				for (Picture picture : pictures) {
					picture.setUrl(config.getImageUrl()+picture.getUrl());
					picture.setThumb1(config.getImageUrl()+picture.getThumb1());
					picture.setThumb2(config.getImageUrl()+picture.getThumb2());
					picture.setThumb3(config.getImageUrl()+picture.getThumb3());
				}
			}
			modelAndView.addObject("pictures", pictures);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/changeSequence.do")
	@ResponseBody
	public JsonResult changeSequence(@RequestParam String id, @RequestParam String changeId) throws MyException {
		FCCollection change = fCCollectionService.get(changeId);
		FCCollection model = fCCollectionService.get(id);

		int modelSequence = model.getSequence();

		model.setSequence(change.getSequence());
		change.setSequence(modelSequence);

		fCCollectionService.update(model);
		fCCollectionService.update(change);
		return new JsonResult(1, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/sltMuseum.do")
	@ResponseBody
	public List<MipOrganization> getCollectionInfo(@RequestParam(name = "parentId") String id) {
		String hql = "from MipOrganization where status>0 and isdelete=0 and parentId=" + id +" order by sequence desc";
		List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,
				Tools.getMap());
		return museumList;
	}

}
