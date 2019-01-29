package com.tj720.mip.controller.front;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.MipOpenCulturalrelicInfoDto;
import com.tj720.mip.dto.MipOpenFossilInfoDto;
import com.tj720.mip.dto.MipOrganizationDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.ICityService;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipCollectService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.inter.service.tool.ISearchService;
import com.tj720.mip.model.City;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.MipCollect;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.MipCollectService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller("frontOCFossilController")
@RequestMapping("/front/OCFossil")
public class OCFossilController extends BaseController<MipOpenFossilInfo> {

	@Autowired
	private IMipOpenFossilInfoService mipOpenFossilInfoService;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IYearTypeService yearTypeService;
	@Autowired
	private IMipCollectService mipCollectService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private Config config;

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
	@SuppressWarnings({ "unchecked", "finally" })
	@RequestMapping("/info.do")
	@ResponseBody
	public JsonResult getCollectionInfo(String key, @ModelAttribute MipOpenFossilInfo mipOpenFossilInfo,
			@RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "2") String order, @RequestParam(defaultValue = "0") String threeD) throws MyException {
		// 创建map集合，放置查询对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询年代集合
		String hql_yearType = "from YearType yt where yt.code like '1%' or yt.code like '5%' or yt.code like '6%' and openCounts > 0 order by sequence desc, yt.code";
		List<YearType> ytList = (List<YearType>) yearTypeService.queryByHql(hql_yearType, Tools.getMap());
		map.put("ytList", ytList);

		// 查询化石类别集合
		List<CollectionCategory> ccList = (List<CollectionCategory>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type like '%化石%'", Tools.getMap());
		map.put("ccList", ccList);

		// 收藏单位所属城市城市集合
		/*
		 * List<City> cityList = (List<City>)
		 * cityService.queryByHql("from City", Tools.getMap());
		 * map.put("cityList", cityList);
		 */

		// 查询收藏单位集合
		/*
		 * List<MuseumInfo> menuList = (List<MuseumInfo>)
		 * museumInfoServiceImpl.queryByHql("from MuseumInfo", Tools.getMap());
		 * map.put("menuList", menuList);
		 */

		// 查询组织机构的集合
		/*
		 * ArrayList<MipOrganizationDto> orgList = new ArrayList<>();
		 * List<MipOrganization> cityList = (List<MipOrganization>)
		 * mipOrganizationService.queryByHql(
		 * "from MipOrganization where platformId=2 and level=2 order by sequence"
		 * , Tools.getMap()); for (MipOrganization city : cityList) {
		 * MipOrganizationDto org = new MipOrganizationDto(); org.setCity(city);
		 * String orgId = city.getId(); List<MipOrganization> museums =
		 * (List<MipOrganization>) mipOrganizationService
		 * .queryByHql("from MipOrganization where parentId=" + orgId +
		 * " and orgTypeId=2 and open=1 order by sequence", Tools.getMap());
		 * org.setMuseums(museums); orgList.add(org); } map.put("orgList",
		 * orgList);
		 */
		// 查询组织机构的集合--开始
		List<CityMuseum> orgList = areaService.getOrgList();
		map.put("orgList", orgList);
		// 查询组织机构的集合--结束

		// 查询所有的博物馆集合
		List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService
				.queryByHql("from MipOrganization where status>0 and open=1", Tools.getMap());

		// 查询化石列表
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// List<MipOpenFossilInfo> mociList =
		// mipOpenCulturalrelicInfoService.findByMap(Tools.getMap(), "new
		// MipOpenFossilInfo(id, createTime, status, sequence, fpic,
		// name, isCollected)", page, null);
		List<MipCollect> mcList = new ArrayList<MipCollect>();
		try {
			// 获取用户登录信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			String uid = cacheUser.getId();
			// 查询用户收藏列表
			mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where uid='" + uid + "' and status >0",
					Tools.getMap());
		} finally {

			/*
			 * List<MipOpenFossilInfo> moList = (List<MipOpenFossilInfo>)
			 * mipOpenFossilInfoService
			 * .queryByHql("from MipOpenFossilInfo order by createTime desc",
			 * Tools.getMap(), page);
			 */
			String hql = "from MipOpenFossilInfo where status>0 and isOpen=2 ";
			if (key != null && !"".equals(key)) {
				hql += " and (name like '%" + key + "%')";
			}
			if (mipOpenFossilInfo.getYearType() != null && !"".equals(mipOpenFossilInfo.getYearType())) {
				YearType yt1 = yearTypeService.get(mipOpenFossilInfo.getYearType());
				hql += (" and yearType='" + yt1.getPathName() + "'");
				// selectMap.put("yearPath", mipOpenFossilInfo.getYearPath());
			}
			if (mipOpenFossilInfo.getCollectionsCategory() != null
					&& !"".equals(mipOpenFossilInfo.getCollectionsCategory())) {
				hql += (" and collectionsCategory='" + mipOpenFossilInfo.getCollectionsCategory() + "'");
				// selectMap.put("collectionsCategory",
				// mipOpenFossilInfo.getCollectionsCategory());
			}
			if (mipOpenFossilInfo.getCollectionUnit() != null && !"".equals(mipOpenFossilInfo.getCollectionUnit())) {
				hql += (" and collectionUnit='" + mipOpenFossilInfo.getCollectionUnit() + "'");
				// selectMap.put("collectionUnit",
				// mipOpenFossilInfo.getCollectionUnit());
			}
			if ("1".equals(threeD)) {
				hql += " and (threeDimensionalCollection is not '')";
			}
			if ("1".equals(order)) {
				hql += " order by createTime desc, id desc";
			}
			if ("2".equals(order)) {
				hql += " order by clickCounts desc, id desc";
			}
			// 查询藏品列表
			List<MipOpenFossilInfo> moList = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryByHql(hql,
					Tools.getMap(), page);

			// 创建一个集合
			List<MipOpenFossilInfoDto> mociList = new ArrayList<MipOpenFossilInfoDto>();

			for (MipOpenFossilInfo mo : moList) {
				MipOpenFossilInfoDto mipOpenFossilInfoDto = new MipOpenFossilInfoDto();
				// 添加藏品信息
				String yearType = mo.getYearType();
				for (YearType yType : ytList) {
					if (yType.getPath().equals(yearType)) {
						mo.setYearType(yType.getName());
					}
				}
				// 重新给分类赋值
				String collectionsCategory = mo.getCollectionsCategory();
				for (CollectionCategory cc : ccList) {
					if (cc.getId().equals(collectionsCategory)) {
						mo.setCollectionsCategory(cc.getName());
					}
				}
				// 重新给收藏单位赋值
				String collectionUnit = mo.getCollectionUnit();
				for (MipOrganization org : museumList) {
					if (org.getId().equals(collectionUnit)) {
						mo.setCollectionUnit(org.getName());
					}
				}

				mipOpenFossilInfoDto.setMipOpenFossilInfo(mo);
				// 添加图片信息
				String pictureIds = mo.getPictureId();
				if (!MyString.isEmpty(pictureIds)) {
					String[] split = pictureIds.split(",");
					StringBuffer sb = new StringBuffer("'");
					for (String pid : split) {
						sb.append(pid).append("','");
					}
					pictureIds = sb.substring(0, sb.length() - 2);
					ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
							"from Picture where id in (" + pictureIds + ") order by isMain desc,url", Tools.getMap());
					for (Picture picture : pictures) {
						picture.setUrl(config.getRootUrl() + picture.getUrl());
						picture.setThumb1(config.getRootUrl() + picture.getThumb1());
						picture.setThumb2(config.getRootUrl() + picture.getThumb2());
						picture.setThumb3(config.getRootUrl() + picture.getThumb3());
					}
					if (!MyString.isEmpty(pictures)) {
						mipOpenFossilInfoDto.setPicture(pictures.get(0));
					}
				}

				// 判断是否收藏信息
				for (MipCollect mc : mcList) {
					if (mo.getId().equals(mc.getFid())) {
						mipOpenFossilInfoDto.setIsCollected((byte) 1);
					}
				}
				mociList.add(mipOpenFossilInfoDto);
			}
			
			if(page.getTotalPage() < currentPage){
				mociList.clear();
			}
			
			map.put("mociList", mociList);

			return new JsonResult(1, map, page);

		}

	}

	/**
	 * 查询藏品列表，默认排序，按时间倒序排
	 * 
	 * @param key
	 * @param mipOpenFossilInfo
	 * @param currentPage
	 * @return
	 * @throws MyException
	 */
	/*
	 * @SuppressWarnings({ "unchecked", "finally" })
	 * 
	 * @RequestMapping("/list.do")
	 * 
	 * @ResponseBody public JsonResult list(String key, @ModelAttribute
	 * MipOpenFossilInfo mipOpenFossilInfo,
	 * 
	 * @RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue =
	 * "1") int currentPage,
	 * 
	 * @RequestParam(defaultValue = "createTime") String order) throws
	 * MyException { // Map<String, Object> selectMap = new HashMap<String,
	 * Object>(); Map<String, Object> map = new HashMap<String, Object>(); Page
	 * page = new Page(); page.setCurrentPage(currentPage); page.setSize(size);
	 * String hql = "from MipOpenFossilInfo where 1=1"; if (key != null &&
	 * !"".equals(key)) { hql += " and (name like '%" + key +
	 * "%' or yearTypeEon like '%" + key + "%' or yearTypeEra like '%" + key +
	 * "%' or yearTypeEpoch like '%" + key + "%' or collectionsCategory like '%"
	 * + key + "%' or collectionUnit like '%" + key + "%')"; } if
	 * (mipOpenFossilInfo.getYearType() != null &&
	 * !"".equals(mipOpenFossilInfo.getYearType())) { hql += (" and yearType='"
	 * + mipOpenFossilInfo.getYearType() + "'"); // selectMap.put("yearPath",
	 * mipOpenFossilInfo.getYearPath()); } if
	 * (mipOpenFossilInfo.getCollectionsCategory() != null &&
	 * !"".equals(mipOpenFossilInfo.getCollectionsCategory())) { hql +=
	 * (" and collectionsCategory='" +
	 * mipOpenFossilInfo.getCollectionsCategory() + "'"); //
	 * selectMap.put("collectionsCategory", //
	 * mipOpenFossilInfo.getCollectionsCategory()); }
	 * 
	 * if (mipOpenFossilInfo.getCollectionUnitCity() != null &&
	 * !"".equals(mipOpenFossilInfo.getCollectionUnitCity())) { hql +=
	 * (" and collectionUnitCity='" + mipOpenFossilInfo.getCollectionUnitCity()
	 * + "'"); // selectMap.put("collectionUnitCity",
	 * mipOpenFossilInfo.getCollectionUnitCity()); }
	 * 
	 * if (mipOpenFossilInfo.getCollectionUnit() != null &&
	 * !"".equals(mipOpenFossilInfo.getCollectionUnit())) { hql +=
	 * (" and collectionUnit='" + mipOpenFossilInfo.getCollectionUnit() + "'");
	 * // selectMap.put("collectionUnit", //
	 * mipOpenFossilInfo.getCollectionUnit()); } if ("createTime".equals(order))
	 * { hql += " order by createTime desc"; } if ("clickCounts".equals(order))
	 * { hql += " order by clickCounts desc"; } List<MipCollect> mcList = new
	 * ArrayList<MipCollect>(); try { // 获取用户登录信息 LoginInfoDto cacheUser =
	 * (LoginInfoDto) Tools.getUser(); String uid = cacheUser.getId(); //
	 * 查询用户收藏列表 mcList = (List<MipCollect>)
	 * mipCollectService.queryByHql("from MipCollect where uid='" + uid + "'",
	 * Tools.getMap()); } finally { // 查询藏品列表 List<MipOpenFossilInfo> moList =
	 * (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryByHql(hql,
	 * Tools.getMap(), page);
	 * 
	 * // 创建一个集合 List<MipOpenFossilInfoDto> mociList = new
	 * ArrayList<MipOpenFossilInfoDto>();
	 * 
	 * for (MipOpenFossilInfo mo : moList) { MipOpenFossilInfoDto
	 * mipOpenFossilInfoDto = new MipOpenFossilInfoDto();
	 * mipOpenFossilInfoDto.setMipOpenFossilInfo(mo); for (MipCollect mc :
	 * mcList) { if (mo.getId().equals(mc.getCid())) {
	 * mipOpenFossilInfoDto.setIsCollected((byte) 1); } }
	 * mociList.add(mipOpenFossilInfoDto); } map.put("mociList", mociList);
	 * return new JsonResult(1, map, page); }
	 * 
	 * }
	 */

	/**
	 * 化石藏品详情页
	 * 
	 * @param MipOpenFossilInfo
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/detail.do")
	@ResponseBody
	public JsonResult detail(@ModelAttribute MipOpenFossilInfo mipOpenFossilInfo) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MipCollect> mcList = new ArrayList<MipCollect>();
		// 文物详情
		MipOpenFossilInfoDto mofid = new MipOpenFossilInfoDto();
		try {
			// 获取用户登录信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			String uid = cacheUser.getId();
			// 查询用户收藏列表
			mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where uid='" + uid + "'",
					Tools.getMap());
		} finally {
			if (mcList.size() > 0) {
				for (MipCollect mipCollect : mcList) {
					if (mipOpenFossilInfo.getId().equals(mipCollect.getFid())) {
						mofid.setIsCollected((byte) 1);
					} 
				}
			} 
			String cid = mipOpenFossilInfo.getId();
			MipOpenFossilInfo moci = mipOpenFossilInfoService.get(cid);
			//浏览次数+1
			int clickCounts = moci.getClickCounts();
			clickCounts++;
			moci.setClickCounts(clickCounts);
			//更新数据库
			mipOpenFossilInfoService.update(moci);
			
			// 修改音频视频地址
			moci.setfAudio(config.getRootUrl() + moci.getfAudio());
			moci.setfVideo(config.getRootUrl() + moci.getfVideo());
			

			// 查询图片
			String pictureIds2 = moci.getPictureId();
			if (!MyString.isEmpty(pictureIds2)) {
				String[] split = pictureIds2.split(",");
				StringBuffer sb = new StringBuffer("'");
				for (String pid : split) {
					sb.append(pid).append("','");
				}
				pictureIds2 = sb.substring(0, sb.length() - 2);
				ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
						"from Picture where id in (" + pictureIds2 + ") order by isMain desc,url", Tools.getMap());
				if (!MyString.isEmpty(pictures)) {
					for (Picture picture : pictures) {
						picture.setUrl(config.getRootUrl() + picture.getUrl());
						picture.setThumb1(config.getRootUrl() + picture.getThumb1());
						picture.setThumb2(config.getRootUrl() + picture.getThumb2());
						picture.setThumb3(config.getRootUrl() + picture.getThumb3());
					}
					// 添加图片信息
					mofid.setPicture(pictures.get(0));
				}
			}

			// 查询本馆的其他藏品
			String collectionUnit = moci.getCollectionUnit();
			List<MipOpenFossilInfo> qtInfos = (List<MipOpenFossilInfo>) mipOpenFossilInfoService
					.queryLimitByHql("from MipOpenFossilInfo where collectionUnit = '" + collectionUnit
							+ "' and id != '" + mipOpenFossilInfo.getId() + "' and status>0 and isOpen=2 order by clickCounts desc");
			ArrayList<MipOpenFossilInfo> otherMofiList = new ArrayList<MipOpenFossilInfo>();
			// 乱序集合
			Collections.shuffle(qtInfos);
			if (qtInfos.size()>=15) {
				for (int i = 0; i < 15; i++) {
					MipOpenFossilInfo mofi = qtInfos.get(i);
					/*int selectCounts = mofi.getSelectCounts();
					selectCounts++;
					mofi.setSelectCounts(selectCounts);
					mipOpenFossilInfoService.update(mofi);*/
					(otherMofiList).add(mofi);
				}
			}else {
				for (int i = 0; i < qtInfos.size(); i++) {
					MipOpenFossilInfo mofi = qtInfos.get(i);
					/*int selectCounts = mofi.getSelectCounts();
					selectCounts++;
					mofi.setSelectCounts(selectCounts);
					mipOpenFossilInfoService.update(mofi);*/
					(otherMofiList).add(mofi);
				}
			}
			// 创建一个集合
			List<MipOpenFossilInfoDto> otherMocInfoDtos = new ArrayList<MipOpenFossilInfoDto>();
			for (MipOpenFossilInfo other : otherMofiList) {
				MipOpenFossilInfoDto mipOpenFossilInfoDto = new MipOpenFossilInfoDto();
				mipOpenFossilInfoDto.setMipOpenFossilInfo(other);
				String pictureIds = other.getPictureId();
				if (!MyString.isEmpty(pictureIds)) {
					String[] split = pictureIds.split(",");
					StringBuffer sb = new StringBuffer("'");
					for (String pid : split) {
						sb.append(pid).append("','");
					}
					pictureIds = sb.substring(0, sb.length() - 2);
					ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
							"from Picture where id in (" + pictureIds + ") order by isMain desc,url", Tools.getMap());
					if (!MyString.isEmpty(pictures)) {
						for (Picture picture : pictures) {
							picture.setUrl(config.getRootUrl() + picture.getUrl());
							picture.setThumb1(config.getRootUrl() + picture.getThumb1());
							picture.setThumb2(config.getRootUrl() + picture.getThumb2());
							picture.setThumb3(config.getRootUrl() + picture.getThumb3());
						}
						mipOpenFossilInfoDto.setPicture(pictures.get(0));
					}
				}
				otherMocInfoDtos.add(mipOpenFossilInfoDto);
			}

			map.put("otherMofiList", otherMocInfoDtos);

			// 查询相关藏品
			String collectionsCategory = moci.getCollectionsCategory();
			String yearType = moci.getYearType();
			List<MipOpenFossilInfo> mofInfos = new ArrayList<MipOpenFossilInfo>();
			if (!MyString.isEmpty(collectionsCategory)) {
				mofInfos = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryLimitByHql(
						"from MipOpenFossilInfo where collectionsCategory = '" + collectionsCategory + "' and yearType = '"
								+ yearType + "' and id != '" + mipOpenFossilInfo.getId() + "' and status>0 and isOpen=2 order by clickCounts desc");
			} 

			if (MyString.isEmpty(collectionsCategory)) {
				mofInfos = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryLimitByHql(
						"from MipOpenFossilInfo where yearType = '"
								+ yearType + "' and id != '" + mipOpenFossilInfo.getId() + "' and status>0 and isOpen=2 order by clickCounts desc");
			} 
			// 乱序集合
			Collections.shuffle(mofInfos);
			ArrayList<MipOpenFossilInfo> relations = new ArrayList<MipOpenFossilInfo>();
			if (mofInfos.size()>=15) {
				for (int i = 0; i < 15; i++) {
					MipOpenFossilInfo mofi = mofInfos.get(i);
					/*int selectCounts = mofi.getSelectCounts();
					selectCounts++;
					mofi.setSelectCounts(selectCounts);*/
					mipOpenFossilInfoService.update(mofi);
					(relations).add(mofi);
				}
			}else {
				for (int i = 0; i < mofInfos.size(); i++) {
					MipOpenFossilInfo mofi = mofInfos.get(i);
					/*int selectCounts = mofi.getSelectCounts();
					selectCounts++;
					mofi.setSelectCounts(selectCounts);
					mipOpenFossilInfoService.update(mofi);*/
					(relations).add(mofi);
				}
			}
			// 创建一个集合
			List<MipOpenFossilInfoDto> relateMocInfoDtos = new ArrayList<MipOpenFossilInfoDto>();
			for (MipOpenFossilInfo other : otherMofiList) {
				MipOpenFossilInfoDto mipOpenFossilInfoDto = new MipOpenFossilInfoDto();
				mipOpenFossilInfoDto.setMipOpenFossilInfo(other);
				String pictureIds = other.getPictureId();
				if (!MyString.isEmpty(pictureIds)) {
					String[] split = pictureIds.split(",");
					StringBuffer sb = new StringBuffer("'");
					for (String pid : split) {
						sb.append(pid).append("','");
					}
					pictureIds = sb.substring(0, sb.length() - 2);
					ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
							"from Picture where id in (" + pictureIds + ") order by isMain desc,url", Tools.getMap());
					if (!MyString.isEmpty(pictures)) {
						for (Picture picture : pictures) {
							picture.setUrl(config.getRootUrl() + picture.getUrl());
							picture.setThumb1(config.getRootUrl() + picture.getThumb1());
							picture.setThumb2(config.getRootUrl() + picture.getThumb2());
							picture.setThumb3(config.getRootUrl() + picture.getThumb3());
						}
						mipOpenFossilInfoDto.setPicture(pictures.get(0));
					}
				}
				relateMocInfoDtos.add(mipOpenFossilInfoDto);
			}
			map.put("relations", relateMocInfoDtos);
			//重新赋值年代
//			YearType yearType2 = yearTypeService.get(moci.getYearType());
//			moci.setYearType(yearType2.getName());
			//重新赋值分类
			CollectionCategory collectionCategory = collectionCategoryService.get(moci.getCollectionsCategory());
			moci.setCollectionsCategory(collectionCategory.getName());
			//重新赋值博物馆信息
			MipOrganization mipOrganization = mipOrganizationService.get(moci.getCollectionUnit());
			moci.setCollectionUnit(mipOrganization.getName());
			// 重新赋值博物馆级别
			if ("1".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("珍贵");
			}
			if ("2".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("一般");
			}
			if ("3".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("其他");
			}
			// 添加藏品信息
			mofid.setMipOpenFossilInfo(moci);
			map.put("mofid", mofid);
			return new JsonResult(1, map);
		}
	}

}
