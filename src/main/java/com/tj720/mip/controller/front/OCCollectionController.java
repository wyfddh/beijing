package com.tj720.mip.controller.front;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.From;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.AreaOrag;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.MipOpenCulturalrelicInfoDto;
import com.tj720.mip.dto.MipOpenFossilInfoDto;
import com.tj720.mip.dto.MipOrganizationDto;
import com.tj720.mip.dto.Museum;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipCollectService;
import com.tj720.mip.inter.service.table.IMipOpenCollectionInfoService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.MipCollect;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.MipOpenFossilInfoService;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller("frontOCCollectionController")
@RequestMapping("/front/OCCollection")
public class OCCollectionController extends BaseController<MipOpenCulturalrelicInfo> {

	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
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
	@Autowired
	private IMipOpenFossilInfoService mipOpenFossilInfoService;
	@Autowired
	private IMipOpenCollectionInfoService mipOpenCollectionInfoService;

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
	public JsonResult getCollectionInfo(String key, @ModelAttribute MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo,
			@RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "2") String order, @RequestParam(defaultValue = "0") String threeD) throws MyException {
		// 创建map集合，放置查询对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询年代集合
		/*
		 * String hql_yearType =
		 * "from YearType yt where (yt.code like '2%' or yt.code like '3%') and openCounts > 0"
		 * ; List<YearType> ytList = (List<YearType>)
		 * yearTypeService.queryByHql(hql_yearType, Tools.getMap());
		 * map.put("ytList", ytList);
		 */
//		String hql_yearType = "from YearType yt where (yt.code like '2%' or yt.code like '3%' or yt.code like '4%' or yt.code like '5%' or yt.code like '6%') and yt.code not in (200000, 300000, 400000) and openCounts > 0 order by sequence desc, yt.code";
		String hql_yearType = "from YearType yt where (yt.code like '2%' or yt.code like '3%' or yt.code like '4%' or yt.code like '5%' or yt.code like '6%') and openCounts > 0 order by sequence desc, yt.code";
		List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
				Tools.getMap());
		map.put("ytList", ytList);
		// 查询文物类别集合
		/*
		 * List<PickDto> ccList = (List<PickDto>) collectionCategoryService
		 * .queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物'"
		 * , Tools.getMap()); map.put("ccList", ccList);
		 */
		List<CollectionCategory> ccList = (List<CollectionCategory>) collectionCategoryService.queryByHql(
				"from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物%' order by sequence desc",
				Tools.getMap());
		map.put("ccList", ccList);

		// 收藏单位所属城市城市集合
		/*
		 * List<City> cityList = (List<City>)
		 * cityService.queryByHql("from City", Tools.getMap());
		 * map.put("cityList", cityList);
		 */

		// 查询组织机构的集合
		/*
		 * ArrayList<MipOrganizationDto> orgList = new ArrayList<>();
		 * List<MipOrganization> cityList = (List<MipOrganization>)
		 * mipOrganizationService.queryByHql(
		 * "from MipOrganization morg where platformId=2 and level=2 order by sequence"
		 * , Tools.getMap()); for (MipOrganization city : cityList) {
		 * MipOrganizationDto org = new MipOrganizationDto(); org.setCity(city);
		 * String orgId = city.getId(); List<MipOrganization> museums =
		 * (List<MipOrganization>) mipOrganizationService.queryByHql(
		 * "from MipOrganization where parentId=" + orgId +
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

		// 查询文物列表
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// List<MipOpenCulturalrelicInfo> mociList =
		// mipOpenCulturalrelicInfoService.findByMap(Tools.getMap(), "new
		// MipOpenCulturalrelicInfo(id, createTime, status, sequence, fpic,
		// name, isCollected)", page, null);
		List<MipCollect> mcList = new ArrayList<MipCollect>();
		try {
			// 获取用户登录信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			String uid = cacheUser.getId();
			// 查询用户收藏列表
			mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where uid='" + uid + "'",
					Tools.getMap());
		} finally {

			/*
			 * List<MipOpenCulturalrelicInfo> moList =
			 * (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
			 * .queryByHql("from MipOpenCulturalrelicInfo order by createTime desc"
			 * , Tools.getMap(), page);
			 */

//			String hql = "from MipOpenCulturalrelicInfo where status>0 and isOpen=2 ";
			String hql = "from MipOpenCulturalrelicInfo where isOpen=2 ";
			if (mipOpenCulturalrelicInfo.getYearType() != null && !"".equals(mipOpenCulturalrelicInfo.getYearType())) {
				hql += (" and yearType='" + mipOpenCulturalrelicInfo.getYearType() + "'");
			}
			if (mipOpenCulturalrelicInfo.getCollectionsCategory() != null
					&& !"".equals(mipOpenCulturalrelicInfo.getCollectionsCategory())) {
				hql += (" and collectionsCategory='" + mipOpenCulturalrelicInfo.getCollectionsCategory() + "'");
			}
			/*
			 * if (mipOpenCulturalrelicInfo.getCollectionUnitCity() != null &&
			 * !"".equals(mipOpenCulturalrelicInfo.getCollectionUnitCity())) {
			 * hql += (" and collectionUnitCity='" +
			 * mipOpenCulturalrelicInfo.getCollectionUnitCity() + "'"); }
			 */
			if (mipOpenCulturalrelicInfo.getCollectionUnit() != null
					&& !"".equals(mipOpenCulturalrelicInfo.getCollectionUnit())) {
				hql += (" and collectionUnit='" + mipOpenCulturalrelicInfo.getCollectionUnit() + "'");
			}

			if (key != null && !"".equals(key)) {
//				hql += " and (indexName like '%" + key + "%')";
				hql += " and locate('"+key+"', indexName)>0";
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
			List<MipOpenCulturalrelicInfo> moList = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
					.queryByHql(hql, Tools.getMap(), page);

			// 创建一个集合
			List<MipOpenCulturalrelicInfoDto> mociList = new ArrayList<MipOpenCulturalrelicInfoDto>();

			for (MipOpenCulturalrelicInfo mo : moList) {
				MipOpenCulturalrelicInfoDto mipOpenCulturalrelicInfoDto = new MipOpenCulturalrelicInfoDto();
				// 添加藏品信息
				// 重新给年代赋值
				String yearType = mo.getYearType();
				for (YearType yType : ytList) {
					if (yType.getId().equals(yearType)) {
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

				mipOpenCulturalrelicInfoDto.setMipOpenCulturalrelicInfo(mo);
				// 添加图片信息
				String pictureIds = mo.getPictureIds();
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
						mipOpenCulturalrelicInfoDto.setPicture(pictures.get(0));
					}
				}
				// 判断是否收藏信息
				if (MyString.isEmpty(mcList)) {
					for (MipCollect mc : mcList) {
						if (mo.getId().equals(mc.getCid())) {
							mipOpenCulturalrelicInfoDto.setIsCollected((byte) 1);
						}
					}
				}
				mociList.add(mipOpenCulturalrelicInfoDto);
			}
			if(page.getTotalPage() < currentPage){
				mociList.clear();
			}
			
			map.put("mociList", mociList);
			return new JsonResult(1, map, page);
		}

	}

	/**
	 * 文物藏品详情页
	 * 
	 * @param MipOpenCulturalrelicInfo
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/detail.do")
	@ResponseBody
	public JsonResult detail(MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo) throws MyException {
		mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(mipOpenCulturalrelicInfo.getId());
		String cid = mipOpenCulturalrelicInfo.getId();
		MipOpenCulturalrelicInfo moci = mipOpenCulturalrelicInfoService.get(cid);
		// 浏览次数+1
		int clickCounts = moci.getClickCounts();
		clickCounts++;
		moci.setClickCounts(clickCounts);
		// 更新数据库
		mipOpenCulturalrelicInfoService.update(moci);

		Map<String, Object> map = new HashMap<String, Object>();
		List<MipCollect> mcList = new ArrayList<MipCollect>();
		// 藏品详情
		MipOpenCulturalrelicInfoDto mocid = new MipOpenCulturalrelicInfoDto();
		try {
			// 获取用户登录信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			String uid = cacheUser.getId();
			// 查询用户收藏列表
			mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where uid='" + uid + "' and status > 0",
					Tools.getMap());
		} finally {
			if (mcList.size() > 0) {
				for (MipCollect mipCollect : mcList) {
					if (mipOpenCulturalrelicInfo.getId().equals(mipCollect.getCid())) {
						mocid.setIsCollected((byte) 1);
					} 
				}
			} 
			
			// 修改音频视频地址
			if (!MyString.isEmpty(moci.getfAudio())) {
				moci.setfAudio(config.getRootUrl() + moci.getfAudio());
			}
			if (!MyString.isEmpty(moci.getfVideo())) {
				moci.setfVideo(config.getRootUrl() + moci.getfVideo());
			}
			/*
			 * //添加藏品信息 mocid.setMipOpenCulturalrelicInfo(moci);
			 */
			// 查询本藏品的图片ids
			// 查询图片
			String pictureIds2 = moci.getPictureIds();
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
					mocid.setPicture(pictures.get(0));
				}
			}

			// 查询本馆的其他藏品
			String collectionUnit = moci.getCollectionUnit();
			List<MipOpenCulturalrelicInfo> qtInfos = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
					.queryLimitByHql("from MipOpenCulturalrelicInfo where collectionUnit = '" + collectionUnit
							+ "' and isOpen=2 order by clickCounts desc");
			ArrayList<MipOpenCulturalrelicInfo> otherMofiList = new ArrayList<MipOpenCulturalrelicInfo>();
			// 乱序集合
			Collections.shuffle(qtInfos);
			if (qtInfos.size() >= 16) {
				for (int i = 0; i < 16; i++) {
					MipOpenCulturalrelicInfo mofi = null;
					if (!qtInfos.get(i).getId().equals(cid)) {
						mofi = qtInfos.get(i);
						otherMofiList.add(mofi);
					}
					/*
					 * int selectCounts = mofi.getSelectCounts();
					 * selectCounts++; mofi.setSelectCounts(selectCounts);
					 * mipOpenCulturalrelicInfoService.update(mofi);
					 */
				}
			} else {
				for (int i = 0; i < qtInfos.size(); i++) {
					if (!qtInfos.get(i).getId().equals(cid)) {
						MipOpenCulturalrelicInfo mofi = qtInfos.get(i);
						/*
						 * int selectCounts = mofi.getSelectCounts();
						 * selectCounts++; mofi.setSelectCounts(selectCounts);
						 * mipOpenCulturalrelicInfoService.update(mofi);
						 */
						otherMofiList.add(mofi);
					}
				}
			}
			// 创建一个集合
			List<MipOpenCulturalrelicInfoDto> otherMocInfoDtos = new ArrayList<MipOpenCulturalrelicInfoDto>();
			for (MipOpenCulturalrelicInfo other : otherMofiList) {
				MipOpenCulturalrelicInfoDto mipOpenCulturalrelicInfoDto = new MipOpenCulturalrelicInfoDto();
				mipOpenCulturalrelicInfoDto.setMipOpenCulturalrelicInfo(other);
//				String pictureIds = other.getPictureIds();
//				if (!MyString.isEmpty(pictureIds)) {
//					String[] split = pictureIds.split(",");
//					StringBuffer sb = new StringBuffer("'");
//					for (String pid : split) {
//						sb.append(pid).append("','");
//					}
//					pictureIds = sb.substring(0, sb.length() - 2);
//					ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
//							"from Picture where id in (" + pictureIds + ") order by isMain desc,url", Tools.getMap());
//					if (!MyString.isEmpty(pictures)) {
//						for (Picture picture : pictures) {
//							picture.setUrl(config.getRootUrl() + picture.getUrl());
//							picture.setThumb1(config.getRootUrl() + picture.getThumb1());
//							picture.setThumb2(config.getRootUrl() + picture.getThumb2());
//							picture.setThumb3(config.getRootUrl() + picture.getThumb3());
//						}
//						mipOpenCulturalrelicInfoDto.setPicture(pictures.get(0));
//					}
//				}
				Picture picture =pictureService.getByHql("from Picture where objectId='"+other.getId()+"' order by isMain desc,url");
				if (!MyString.isEmpty(picture)) {
					picture.setUrl(config.getRootUrl() + picture.getUrl());
					picture.setThumb1(config.getRootUrl() + picture.getThumb1());
					picture.setThumb2(config.getRootUrl() + picture.getThumb2());
					picture.setThumb3(config.getRootUrl() + picture.getThumb3());
				}
				mipOpenCulturalrelicInfoDto.setPicture(picture);
				otherMocInfoDtos.add(mipOpenCulturalrelicInfoDto);
			}
			map.put("otherMofiList", otherMocInfoDtos);

			// 查询相关藏品
			String collectionsCategory = moci.getCollectionsCategory();
			String yearType = moci.getYearType();
			List<MipOpenCulturalrelicInfo> mofInfos = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
					.queryLimitByHql("from MipOpenCulturalrelicInfo where collectionsCategory = '" + collectionsCategory
							+ "' and yearType = '" + yearType + "' and isOpen=2 order by clickCounts desc");
			// 乱序集合
			Collections.shuffle(mofInfos);
			ArrayList<MipOpenCulturalrelicInfo> relationList = new ArrayList<MipOpenCulturalrelicInfo>();
			if (mofInfos.size() >= 16) {
				for (int i = 0; i < 16; i++) {
					if (!mofInfos.get(i).getId().equals(cid)) {
						MipOpenCulturalrelicInfo mofi = mofInfos.get(i);
						/*
						 * int selectCounts = mofi.getSelectCounts();
						 * selectCounts++; mofi.setSelectCounts(selectCounts);
						 * mipOpenCulturalrelicInfoService.update(mofi);
						 */
						relationList.add(mofi);
					}
				}
			} else {
				for (int i = 0; i < mofInfos.size(); i++) {
					if (!mofInfos.get(i).getId().equals(cid)) {
						MipOpenCulturalrelicInfo mofi = mofInfos.get(i);
						/*
						 * int selectCounts = mofi.getSelectCounts();
						 * selectCounts++; mofi.setSelectCounts(selectCounts);
						 * mipOpenCulturalrelicInfoService.update(mofi);
						 */
						relationList.add(mofi);
					}
				}
			}
			// 创建一个集合
			List<MipOpenCulturalrelicInfoDto> relations = new ArrayList<MipOpenCulturalrelicInfoDto>();
			for (MipOpenCulturalrelicInfo relation : relationList) {
				MipOpenCulturalrelicInfoDto mipOpenCulturalrelicInfoDto = new MipOpenCulturalrelicInfoDto();
				mipOpenCulturalrelicInfoDto.setMipOpenCulturalrelicInfo(relation);
//				String pictureIds = relation.getPictureIds();
//				if (!MyString.isEmpty(pictureIds)) {
//					String[] split = pictureIds.split(",");
//					StringBuffer sb = new StringBuffer("'");
//					for (String pid : split) {
//						sb.append(pid).append("','");
//					}
//					pictureIds = sb.substring(0, sb.length() - 2);
//					ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
//							"from Picture where id in (" + pictureIds + ") order by isMain desc,url", Tools.getMap());
//					if (!MyString.isEmpty(pictures)) {
//						for (Picture picture : pictures) {
//							picture.setUrl(config.getRootUrl() + picture.getUrl());
//							picture.setThumb1(config.getRootUrl() + picture.getThumb1());
//							picture.setThumb2(config.getRootUrl() + picture.getThumb2());
//							picture.setThumb3(config.getRootUrl() + picture.getThumb3());
//						}
//						mipOpenCulturalrelicInfoDto.setPicture(pictures.get(0));
//					}
//				}
				Picture picture = pictureService.getByHql("from Picture where objectId = '" + relation.getId()  + "' order by isMain desc,url");
				if (!MyString.isEmpty(picture)) {
					picture.setUrl(config.getRootUrl() + picture.getUrl());
					picture.setThumb1(config.getRootUrl() + picture.getThumb1());
					picture.setThumb2(config.getRootUrl() + picture.getThumb2());
					picture.setThumb3(config.getRootUrl() + picture.getThumb3());
				}
				mipOpenCulturalrelicInfoDto.setPicture(picture);
				relations.add(mipOpenCulturalrelicInfoDto);
			}
			map.put("relations", relations);

			// 重新赋值年代
			YearType yearType2 = yearTypeService.get(moci.getYearType());
			moci.setYearType(yearType2.getName());
			// 重新赋值分类
			CollectionCategory collectionCategory = collectionCategoryService.get(moci.getCollectionsCategory());
			moci.setCollectionsCategory(collectionCategory.getName());
			// 重新赋值博物馆信息
			MipOrganization mipOrganization = mipOrganizationService.get(moci.getCollectionUnit());
			moci.setCollectionUnit(mipOrganization.getName());
			// 重新赋值博物馆级别
			if ("1".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("一级");
			}
			if ("2".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("二级");
			}
			if ("3".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("三级");
			}
			if ("4".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("一般");
			}
			if ("5".equals(moci.getCollectionLevel())) {
				moci.setCollectionLevel("未定级");
			}
			mocid.setMipOpenCulturalrelicInfo(moci);

			map.put("mocid", mocid);

			return new JsonResult(1, map);
		}
	}

	/**
	 * 跳转到手机端导览页面
	 */
	@RequestMapping("/toDaoLan.do")
	@ResponseBody
	public Object toDaoLan(String gsNo) throws MyException {
		Object object = new Object();
		MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = new MipOpenCulturalrelicInfo();
		MipOpenFossilInfo mipOpenFossilInfo = new MipOpenFossilInfo();
		MipOpenCulturalrelicInfoDto infoDto = new MipOpenCulturalrelicInfoDto();
		MipOpenFossilInfoDto fossilInfoDto = new MipOpenFossilInfoDto();
		List<MipOpenCulturalrelicInfo> mipOpenCulturalrelicInfos = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
				.queryByHql("from MipOpenCulturalrelicInfo where gsNo = '" + gsNo + "'", Tools.getMap());
		List<MipOpenFossilInfo> mipOpenFossilInfos = (List<MipOpenFossilInfo>) mipOpenCulturalrelicInfoService
				.queryByHql("from MipOpenFossilInfo where gsNo = '" + gsNo + "'", Tools.getMap());
		if (MyString.isEmpty(mipOpenCulturalrelicInfos) && MyString.isEmpty(mipOpenFossilInfos)) {
			mipOpenCulturalrelicInfo.setId("-109");
			mipOpenCulturalrelicInfo.setName("-109");
			mipOpenCulturalrelicInfo.setfAudio("-109");
			mipOpenCulturalrelicInfo.setDescription("-109");
			mipOpenCulturalrelicInfo.setfVideo("-109");
			infoDto.setMipOpenCulturalrelicInfo(mipOpenCulturalrelicInfo);
			Picture picture = new Picture();
			picture.setThumb3("-109");
			infoDto.setPicture(picture);
			return infoDto;
		}
		if (!MyString.isEmpty(mipOpenCulturalrelicInfos)) {
			mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfos.get(0);
			// 浏览次数+1
			int clickCounts = mipOpenCulturalrelicInfo.getClickCounts();
			clickCounts++;
			mipOpenCulturalrelicInfo.setClickCounts(clickCounts);
			// 更新数据库
			mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
			/*if (MyString.isEmpty(mipOpenCulturalrelicInfo.getId())) {
				mipOpenCulturalrelicInfo.setId("-109");
			}
			if (MyString.isEmpty(mipOpenCulturalrelicInfo.getName())) {
				mipOpenCulturalrelicInfo.setName("-109");
			}
			if (!MyString.isEmpty(mipOpenCulturalrelicInfo.getfAudio())) {
				mipOpenCulturalrelicInfo.setfAudio(config.getRootUrl() + mipOpenCulturalrelicInfo.getfAudio());
			}else{
				mipOpenCulturalrelicInfo.setfAudio("-109");
			}
			if (!MyString.isEmpty(mipOpenCulturalrelicInfo.getfVideo())) {
				mipOpenCulturalrelicInfo.setfVideo(config.getRootUrl() + mipOpenCulturalrelicInfo.getfVideo());
			}else{
				mipOpenCulturalrelicInfo.setfVideo("-109");
			}
			if (MyString.isEmpty(mipOpenCulturalrelicInfo.getDescription())) {
				mipOpenCulturalrelicInfo.setDescription("-109");
			}*/
			if(!MyString.isEmpty(mipOpenCulturalrelicInfo.getfAudio()))
				mipOpenCulturalrelicInfo.setfAudio(config.getRootUrl() + mipOpenCulturalrelicInfo.getfAudio());
			if(!MyString.isEmpty(mipOpenCulturalrelicInfo.getfVideo()))
				mipOpenCulturalrelicInfo.setfVideo(config.getRootUrl() + mipOpenCulturalrelicInfo.getfVideo());
			// 重新赋值博物馆信息
			MipOrganization mipOrganization = mipOrganizationService.get(mipOpenCulturalrelicInfo.getCollectionUnit());
			mipOpenCulturalrelicInfo.setCollectionUnit(mipOrganization.getName());
			// 重新赋值年代
			YearType yearType2 = yearTypeService.get(mipOpenCulturalrelicInfo.getYearType());
			mipOpenCulturalrelicInfo.setYearType(yearType2.getName());
			// 重新赋值分类
			CollectionCategory collectionCategory = collectionCategoryService.get(mipOpenCulturalrelicInfo.getCollectionsCategory());
			mipOpenCulturalrelicInfo.setCollectionsCategory(collectionCategory.getName());
			
			
			infoDto.setMipOpenCulturalrelicInfo(mipOpenCulturalrelicInfo);
			String pictureIds = mipOpenCulturalrelicInfo.getPictureIds();
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
					infoDto.setPicture(pictures.get(0));
				}
			}
			
			
			object = infoDto;
		}
		if (!MyString.isEmpty(mipOpenFossilInfos)) {
			mipOpenFossilInfo = mipOpenFossilInfos.get(0);
			// 浏览次数+1
			int clickCounts = mipOpenFossilInfo.getClickCounts();
			clickCounts++;
			mipOpenFossilInfo.setClickCounts(clickCounts);
			// 更新数据库
			mipOpenFossilInfoService.update(mipOpenFossilInfo);
			/*if (MyString.isEmpty(mipOpenFossilInfo.getId())) {
				mipOpenFossilInfo.setId("-109");
			}
			if (MyString.isEmpty(mipOpenFossilInfo.getName())) {
				mipOpenFossilInfo.setName("-109");
			}
			if (!MyString.isEmpty(mipOpenFossilInfo.getfAudio())) {
				mipOpenFossilInfo.setfAudio(config.getRootUrl() + mipOpenFossilInfo.getfAudio());
			}else{
				mipOpenFossilInfo.setfAudio("-109");
			}
			if (!MyString.isEmpty(mipOpenCulturalrelicInfo.getfVideo())) {
				mipOpenFossilInfo.setfVideo(config.getRootUrl() + mipOpenFossilInfo.getfVideo());
			}else{
				mipOpenFossilInfo.setfVideo("-109");
			}
			if (MyString.isEmpty(mipOpenFossilInfo.getDescription())) {
				mipOpenFossilInfo.setDescription("-109");
			}*/
			if(!MyString.isEmpty(mipOpenCulturalrelicInfo.getfAudio()))
				mipOpenFossilInfo.setfAudio(config.getRootUrl() + mipOpenFossilInfo.getfAudio());
			if(!MyString.isEmpty(mipOpenCulturalrelicInfo.getfVideo()))
				mipOpenFossilInfo.setfVideo(config.getRootUrl() + mipOpenFossilInfo.getfVideo());
			fossilInfoDto.setMipOpenFossilInfo(mipOpenFossilInfo);
			
			// 重新赋值博物馆信息
			MipOrganization mipOrganization = mipOrganizationService.get(mipOpenFossilInfo.getCollectionUnit());
			mipOpenFossilInfo.setCollectionUnit(mipOrganization.getName());
			// 重新赋值年代
			if (MyString.isEmpty(mipOpenFossilInfo.getYearType())) {
				mipOpenFossilInfo.setYearType(mipOpenFossilInfo.getGsSpecificYear());
			}
			// 重新赋值分类
			CollectionCategory collectionCategory = collectionCategoryService.get(mipOpenFossilInfo.getCollectionsCategory());
			mipOpenFossilInfo.setCollectionsCategory(collectionCategory.getName());
			
			String pictureIds = mipOpenFossilInfo.getPictureId();
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
					infoDto.setPicture(pictures.get(0));
				}
			}
			
			object = fossilInfoDto;
		}
		return object;
	}

	// 收藏藏品
	@RequestMapping("/doCollect.do")
	@ResponseBody
	public JsonResult doCollect(String id, String collectionType) throws MyException {
		try {
			// 判断用户是否存在
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (MyString.isEmpty(cacheUser)) {
				// 用户没登录
				return new JsonResult(0, "请先登录！");
			}
			String uid = cacheUser.getId();
			// 查询用户收藏列表，判断藏品是否已收藏
			List<MipCollect> mcList = (List<MipCollect>) mipCollectService.getCollectsByUid(uid);
			if (!MyString.isEmpty(mcList)) {
				for (MipCollect mipCollect : mcList) {
					if (id.equals(mipCollect.getCid()) || id.equals(mipCollect.getFid())) {
						return new JsonResult(0, "该藏品已收藏！");
					}
				}
			}
			//收藏
			MipCollect mipCollect = new MipCollect();
			mipCollect.setUid(uid);
			if ("0".equals(collectionType)) {
				// 文物藏品
				mipCollect.setCid(id);
				mipCollect.setFid("");
				mipCollectService.save(mipCollect);
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				int collectedCounts = mipOpenCulturalrelicInfo.getCollectedCounts();
				collectedCounts++;
				mipOpenCulturalrelicInfo.setCollectedCounts(collectedCounts);
				mipOpenCollectionInfo.setCollectedCounts(collectedCounts);
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
				return new JsonResult(1, "收藏成功(文物)");
			}
			if ("1".equals(collectionType)) {
				// 化石藏品
				mipCollect.setFid(id);
				mipCollect.setCid("");
				mipCollectService.save(mipCollect);
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				int collectedCounts = mipOpenFossilInfo.getCollectedCounts();
				collectedCounts++;
				mipOpenFossilInfo.setCollectedCounts(collectedCounts);
				mipOpenCollectionInfo.setCollectedCounts(collectedCounts);
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
				return new JsonResult(1, "收藏成功（化石）");
			}
			return new JsonResult(0, "藏品类型参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统未知异常，请联系管理员！");
		}
	}

	// 取消收藏
	@RequestMapping("/notCollect.do")
	@ResponseBody
	public JsonResult notCollect(String id, String collectionType) throws MyException {
		try {
			// 判断用户是否存在
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (MyString.isEmpty(cacheUser)) {
				// 用户没登录
				return new JsonResult(0, "请先登录！");
			}
			String uid = cacheUser.getId();
			if ("0".equals(collectionType)) {
				// 文物藏品
				List<MipCollect> list = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where cid='"+id+"' and uid='"+uid+"'" , Tools.getMap());
				MipCollect mipCollect = list.get(0);
				mipCollectService.delete(mipCollect);
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				int collectedCounts = mipOpenCulturalrelicInfo.getCollectedCounts();
				if (collectedCounts>0) {
					collectedCounts--;
				}
				mipOpenCulturalrelicInfo.setCollectedCounts(collectedCounts);
				mipOpenCollectionInfo.setCollectedCounts(collectedCounts);
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
			} else if ("1".equals(collectionType)) {
				// 化石藏品
				List<MipCollect> list = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where fid='"+id+"' and uid='"+uid+"'" , Tools.getMap());
				MipCollect mipCollect = list.get(0);
				mipCollectService.delete(mipCollect);
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				int collectedCounts = mipOpenFossilInfo.getCollectedCounts();
				if (collectedCounts>0) {
					collectedCounts--;
				}
				mipOpenFossilInfo.setCollectedCounts(collectedCounts);
				mipOpenCollectionInfo.setCollectedCounts(collectedCounts);
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
			} else {
				return new JsonResult(0, "参数不正确");
			}
			return new JsonResult(1, "取消收藏成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统未知异常，请联系管理员！");
		}
	}
}
