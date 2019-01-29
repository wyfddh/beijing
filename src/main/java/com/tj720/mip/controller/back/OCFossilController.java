
package com.tj720.mip.controller.back;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.common.IdentityConstraint.IdState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.DcBorrow;
import com.tj720.admin.model.DcVersionContent;
import com.tj720.admin.model.DcVersionSelect;
import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.service.DcBorrowService;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.DcVersionSelectService;
import com.tj720.admin.service.MipCollectionAudioService;
import com.tj720.admin.service.MipLogService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.common.dto.ImageTranslateDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.enumeration.RequestMethod;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipCollectService;
import com.tj720.mip.inter.service.table.IMipOpenCollectionInfoService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMipYearCategoryService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipYearCategory;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.KdxfUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/back/oCFossil")
public class OCFossilController extends BaseController<MipOpenCulturalrelicInfo> {

	// @Autowired
	// private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	// @Autowired
	// private ICollectionCategoryService collectionCategoryService;
	// @Autowired
	// private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IPictureService pictureService;

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
	private IUserService userService;
	@Autowired
	private Config config;
	@Autowired
	private IMipOpenCollectionInfoService mipOpenCollectionInfoService;
	@Autowired
	private IMipYearCategoryService mipYearCategoryService;
	@Autowired
	private DcVersionSelectService dcVersionSelectService;
	@Autowired
	private DcVersionContentService dcVersionContentService;
	@Autowired
	MipCollectionAudioService mipCollectionAudioService;
	@Autowired 
	DcBorrowService dcBorrowService;
	@Autowired
	private MipLogService mipLogService;
	
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 
	 * @param key
	 *            关键字
	 * @param MipOpenFossilInfo
	 *            化石对象
	 * @param erea
	 *            城市
	 * @param size
	 *            每页查询条数
	 * @param currentPage
	 *            当前页
	 * @param order
	 *            排序方式
	 * @return mod 返回值
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/info.do")
	@ResponseBody
	@AuthPassport(authority="collectionCommon")
	public ModelAndView getCollectionInfo(String key, @ModelAttribute MipOpenFossilInfo mipOpenFossilInfo, String erea,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "createTime") String order,@RequestParam(defaultValue = "0")int type) throws MyException {
		ModelAndView mod = null;
		if(1==type){
			mod = new ModelAndView("/WEB-INF/back/collection/trends/dchslist.jsp");
		}else{
			mod = new ModelAndView("/WEB-INF/back/collection/open/hslist.jsp");
		}
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
//		String listKey = MessageFormat.format(KeyConstants.FOSSIL_INFO_LIST_KEY, orgId);
//		String jsonStr = JedisService.get(listKey);
//		if(StringUtils.isNotBlank(jsonStr)) {
//			mod = JSON.parseObject(jsonStr, ModelAndView.class);
//		} else {
			//获取用户信息
			 MipOrganization org = mipOrganizationService.get(orgId);
			 //查询组织机构的级别
			 byte level = org.getLevel();
	
			// 创建map集合，放置查询对象
			// Map<String, Object> map = new HashMap<String, Object>();
			// 查询年代（宙）集合
			List<YearType> ytEonList = (List<YearType>) yearTypeService
					.queryByHql("from YearType yt where yt.parentId=2 ", Tools.getMap());//and yt.fcCounts>0
			mod.addObject("ytEonList", ytEonList);
			// 查询年代（代）集合
			if (mipOpenFossilInfo.getYearTypeEon() != null && !"".equals(mipOpenFossilInfo.getYearTypeEon())) {
				List<YearType> ytEraList = (List<YearType>) yearTypeService.queryByHql(
						"from YearType yt where yt.parentId=" + mipOpenFossilInfo.getYearTypeEon(),// + " and yt.fcCounts>0",
						Tools.getMap());
				mod.addObject("ytEraList", ytEraList);
			}
			// 查询年代（纪）集合
			if (mipOpenFossilInfo.getYearTypeEra() != null && !"".equals(mipOpenFossilInfo.getYearTypeEra())) {
				List<YearType> ytEpochList = (List<YearType>) yearTypeService.queryByHql(
						"from YearType yt where yt.parentId=" + mipOpenFossilInfo.getYearTypeEra(),// + " and yt.fcCounts>0",
						Tools.getMap());
				mod.addObject("ytEpochList", ytEpochList);
			}
			// 查询化石类别集合
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService
					.queryByHql("from CollectionCategory cc where cc.openCounts>=0 and cc.type like '%化石%'", Tools.getMap());
			mod.addObject("ccList", ccList);
	
			/*// 查询组织机构（城市）的集合
			List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
					.queryByHql("from MipOrganization where platformId=2 and level=2 order by sequence", Tools.getMap());
			mod.addObject("cityList", cityList);*/
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
			// 查询组织机构（博物馆）的集合
			if (erea != null && !"".equals(erea)) {
				List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where parentId=" + erea
								+ " and level=3 and status>0 and isdelete=0 order by sequence", Tools.getMap());
				mod.addObject("musList", musList);
			}
	
			// 查询山东所有博物馆集合
			List<MipOrganization> museums = (List<MipOrganization>) mipOrganizationService.queryByHql(
					"from MipOrganization where platformId=" + config.getPlatformId() + " and orgTypeId='2' and status>0 and isdelete=0 order by sequence desc", 
					Tools.getMap());
			mod.addObject("museums", museums);
	
			// 查询化石藏品列表
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
	
			String hql = "from MipOpenFossilInfo where status>=0 and collectionUnit <>''";
			//通过判断用户级别查询
					if (level == 0) {
						//全国
					}
					/*if (level == 1) {
						//省级
						//查询省级下所有市
						String orgIds = "";
						List<MipOrganization> cityArrayList = (List<MipOrganization>) mipOpenFossilInfoService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
						StringBuffer sBuffer = new StringBuffer();
						if (!MyString.isEmpty(cityArrayList)) {
							for (MipOrganization mipOrganization : cityArrayList) {
								sBuffer.append(mipOrganization.getId()).append(",");
							}
						}
						String cityIds = sBuffer.toString();
						cityIds = cityIds.substring(0,cityIds.length()-1);
						//查询市级下所有博物馆
						if (!MyString.isEmpty(cityIds)) {
							List<MipOrganization> orgList = (List<MipOrganization>) mipOpenFossilInfoService.queryByHql("from MipOrganization where parentId in (" + cityIds + ")", Tools.getMap());
							StringBuffer sBuffer2 = new StringBuffer();
							if (!MyString.isEmpty(orgList)) {
								for (MipOrganization mipOrganization2 : orgList) {
									sBuffer2.append(mipOrganization2.getId()).append(",");
								}
							}
							orgIds = sBuffer2.toString();
							orgIds = orgIds.substring(0, orgIds.length()-1);
							
						}
						
						hql += " and collectionUnit in ("+ orgIds +")";
					}*/
					if (level == 2) {
						//市级
						String orgIds = "";
						List<MipOrganization> cityArrayList = (List<MipOrganization>) mipOpenFossilInfoService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
						StringBuffer sBuffer = new StringBuffer();
						if (!MyString.isEmpty(cityArrayList)) {
							for (MipOrganization mipOrganization : cityArrayList) {
								sBuffer.append(mipOrganization.getId()).append(",");
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
			if (mipOpenFossilInfo.getYearTypeEon() != null && !"".equals(mipOpenFossilInfo.getYearTypeEon())) {
				hql += (" and yearTypeEon='" + mipOpenFossilInfo.getYearTypeEon() + "'");
				// selectMap.put("yearPath", mipOpenFossilInfo.getYearPath());
			}
			if (mipOpenFossilInfo.getYearTypeEra() != null && !"".equals(mipOpenFossilInfo.getYearTypeEra())) {
				hql += (" and yearTypeEra='" + mipOpenFossilInfo.getYearTypeEra() + "'");
			}
			if (mipOpenFossilInfo.getYearTypeEpoch() != null && !"".equals(mipOpenFossilInfo.getYearTypeEpoch())) {
				hql += (" and yearTypeEpoch='" + mipOpenFossilInfo.getYearTypeEpoch() + "'");
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
			if (mipOpenFossilInfo.getCollectionLevel() != null && !"".equals(mipOpenFossilInfo.getCollectionLevel())) {
				hql += (" and collectionLevel='" + mipOpenFossilInfo.getCollectionLevel() + "'");
			}
			if (mipOpenFossilInfo.getCollectionPlace() != null && !"".equals(mipOpenFossilInfo.getCollectionPlace())) {
				hql += (" and collectionPlace='" + mipOpenFossilInfo.getCollectionPlace() + "'");
			}
			if (mipOpenFossilInfo.getIsHighQuality() != 0 && !"".equals(mipOpenFossilInfo.getIsHighQuality())) {
				hql += (" and isHighQuality=" + mipOpenFossilInfo.getIsHighQuality());
			}
			if (mipOpenFossilInfo.getIsOpen() != 0 && !"".equals(mipOpenFossilInfo.getIsOpen())) {
				hql += (" and isOpen=" + mipOpenFossilInfo.getIsOpen());
			}
	
			/*
			 * if ("submitTime".equals(order)) {
			 * 
			 * }
			 */
			/*
			 * if ("clickCounts".equals(order)) { hql +=
			 * " order by clickCounts desc"; }
			 */
			if (!MyString.isEmpty(key)) {
				key = key.trim();
				hql += " and (name like '%" + key + "%' or gsNo like '%" + key + "%')";
			}
			hql += " order by sequence desc, submitTime desc";
			List<MipOpenFossilInfo> fccList = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryByHql(hql,
					Tools.getMap(), page);
			/*for (MipOpenFossilInfo m2 : fccList) {
				String pictureIds = m2.getPictureId();
				if (!MyString.isEmpty(pictureIds)) {
					String[] split = pictureIds.split(",");
					String picId = split[0];
					Picture picture = pictureService.get(picId);
					m2.setPictureId(config.getRootUrl() + picture.getUrl());
				}
			}*/
			for (MipOpenFossilInfo m2 : fccList) {
				String listKey = MessageFormat.format(KeyConstants.COLLECTION_INFO_LIST_KEY, m2.getId());
				String jsonStr =JedisService.get(listKey);
				if(StringUtils.isNotBlank(jsonStr)) {
					String[] con = jsonStr.split(",");
					if(con.length>1){
						m2.setUserName(con[0]);
						m2.setContent(con[1]);
					}
				}
				List<Picture> pics = (List<Picture>) pictureService.queryByHql("from Picture where objectId='"+m2.getId()+"' order by isMain desc,url", Tools.getMap());
				if (!MyString.isEmpty(pics)) {
					Picture pic = pics.get(0);
					m2.setPictureId(config.getRootUrl()+pic.getThumb3());
					m2.setFpic(config.getRootUrl()+pic.getUrl());
				}
			}
			mod.addObject("page", page);
			mod.addObject("fccList", fccList);
			mod.addObject("mipOpenFossilInfo", mipOpenFossilInfo);
			mod.addObject("erea", erea);
			mod.addObject("key", key);
//			jsonStr = JSON.toJSONString(mod);
//			JedisService.set(listKey, jsonStr, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
//		}
		return mod;
	}

	/**
	 * 跳转新增页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toAdd.do")
	@ResponseBody
	public ModelAndView toAdd(@ModelAttribute MipOpenFossilInfo collection) {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/open/hsadd.jsp");
		try {
			// 查询藏品分类信息
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService
					.queryByHql("from CollectionCategory cc where cc.openCounts>=0 and cc.type like '%化石%'", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代分类信息
			// 查询年代（宙）集合
			List<YearType> ytEonList = (List<YearType>) yearTypeService
					.queryByHql("from YearType yt where yt.parentId=2", Tools.getMap());
			mod.addObject("ytEonList", ytEonList);
			// 查询年代（代）集合
			if (collection.getYearTypeEon() != null && !"".equals(collection.getYearTypeEon())) {
				List<YearType> ytEraList = (List<YearType>) yearTypeService.queryByHql(
						"from YearType yt where yt.parentId=" + collection.getYearTypeEon(), Tools.getMap());
				mod.addObject("ytEraList", ytEraList);
			}
			// 查询年代（纪）集合
			if (collection.getYearTypeEra() != null && !"".equals(collection.getYearTypeEra())) {
				List<YearType> ytEpochList = (List<YearType>) yearTypeService.queryByHql(
						"from YearType yt where yt.parentId=" + collection.getYearTypeEra(), Tools.getMap());
				mod.addObject("ytEpochList", ytEpochList);
			}
			/*
			 * String hql_yearType = "from YearType yt where yt.code like '1%'";
			 * List<YearType> ytList = (List<YearType>)
			 * yearTypeService.queryByHql(hql_yearType, Tools.getMap());
			 * mod.addObject("ytList", ytList);
			 */
			// 获取图片路径
			/*
			 * ArrayList<Picture> pictures = new ArrayList<Picture>(); //String
			 * pictureIds = collection.getPictureIds(); //if
			 * (!MyString.isEmpty(pictureIds)) { //pictures =
			 * (ArrayList<Picture>)
			 * pictureService.queryByHql("from Picture where id in (" +
			 * pictureIds + ") order by isMain desc,url", Tools.getMap()); pictures
			 * = (ArrayList<Picture>)
			 * pictureService.queryByHql("from Picture where collection_id = "
			 * +collection.getId()+" and type=1 order by isMain desc,url",
			 * Tools.getMap()); //} mod.addObject("pictures", pictures);
			 */

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toAdd.do")) {
				preUrl = request.getContextPath() + "/back/oCFossil/info.do";
			}
			mod.addObject("preUrl", preUrl);
			// 获取用户的组织机构
			// 获取用户登录信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			String orgId = "";
			if (!MyString.isEmpty(cacheUser)) {
				String uid = cacheUser.getId();
				User user = userService.get(uid);
				orgId = user.getOrgId();
			}
			MipOrganization mipOrganization = mipOrganizationService.get(orgId);

			mod.addObject("org", mipOrganization);

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return mod;
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param mocli
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toEdit.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public ModelAndView toEdit(@ModelAttribute MipOpenFossilInfo collection) {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/open/hsedit.jsp");

		try {
			// 根据id查询藏品信息
			collection = mipOpenFossilInfoService.get(collection.getId());
			/*if (!MyString.isEmpty(collection.getfAudio())) {
				collection.setfAudio(config.getRootUrl()+collection.getfAudio());
			}
			if (!MyString.isEmpty(collection.getfVideo())) {
				collection.setfVideo(config.getRootUrl()+collection.getfVideo());
			}*/
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			mod.addObject("collection", collection);
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService
					.queryByHql("from CollectionCategory cc where cc.openCounts>=0 and cc.type like '%化石%'", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代（宙）集合
			List<YearType> ytEonList = (List<YearType>) yearTypeService
					.queryByHql("from YearType yt where yt.parentId=2", Tools.getMap());
			mod.addObject("ytEonList", ytEonList);
			// 查询年代（代）集合
			if (collection.getYearTypeEon() != null && !"".equals(collection.getYearTypeEon())) {
				List<YearType> ytEraList = (List<YearType>) yearTypeService.queryByHql(
						"from YearType yt where yt.parentId=" + collection.getYearTypeEon(), Tools.getMap());
				mod.addObject("ytEraList", ytEraList);
			}
			// 查询年代（纪）集合
			if (collection.getYearTypeEra() != null && !"".equals(collection.getYearTypeEra())) {
				List<YearType> ytEpochList = (List<YearType>) yearTypeService.queryByHql(
						"from YearType yt where yt.parentId=" + collection.getYearTypeEra(), Tools.getMap());
				mod.addObject("ytEpochList", ytEpochList);
			}
			// 获取图片路径
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			// String pictureIds = collection.getPictureIds();
			// if (!MyString.isEmpty(pictureIds)) {
			// pictures = (ArrayList<Picture>) pictureService.queryByHql("from
			// Picture where id in (" + pictureIds + ") order by isMain desc,url",
			// Tools.getMap());
			pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where objectId = '" + collection.getId() + "'  order by isMain desc,url", Tools.getMap());
			pictures = ImageHepler.changePicUrl(pictures, config);
			// }
			mod.addObject("pictures", pictures);
			

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toEdit.do")) {
				preUrl = request.getContextPath() + "/back/oCFossil/info.do";
			}
			mod.addObject("preUrl", preUrl);
			// 获取用户的组织机构
					/*	// 获取用户登录信息
						LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
						String orgId = "";
						if (!MyString.isEmpty(cacheUser)) {
							String uid = cacheUser.getId();
							User user = userService.get(uid);
							orgId = user.getOrgId();
						}*/
			MipOrganization mipOrganization = mipOrganizationService.get(collection.getCollectionUnit());

			mod.addObject("org", mipOrganization);
			
			mod.addObject("rootUrl", config.getRootUrl());
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return mod;
	}

	/**
	 * 增加或者修改
	 * 
	 * @param moci
	 * @return
	 */
	@RequestMapping("/addOrUpdate.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String addOrUpdate(@ModelAttribute MipOpenFossilInfo moci ) {
		ImageTranslateDto imageTranslateDto = new ImageTranslateDto();
		imageTranslateDto.setOpType("add");
		List<String> imgPaths = new ArrayList<String>();
		DcVersionSelect versionSelect = new DcVersionSelect();
		try {
			// 获取用户登录信息
			@SuppressWarnings("unused")
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			// 判断增加还是修改
			if (MyString.isEmpty(moci.getId())) {
				// 增加
				moci.setCollectionType("1");
				moci.setIsOpen((byte)1);//设置为不公开
				moci.setStatus((byte)2);
				moci.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				String s = "";
				// 查询年代（宙）集合
				YearType ytEon = (YearType) yearTypeService.get(moci.getYearTypeEon());
				YearType ytEra = (YearType) yearTypeService.get(moci.getYearTypeEra());
				YearType ytEpoch = (YearType) yearTypeService.get(moci.getYearTypeEpoch());
				String yearType = ytEon.getName();
				if (!MyString.isEmpty(ytEra.getName())) {
					yearType += "." + ytEra.getName();
				}
				if (!MyString.isEmpty(ytEpoch.getName())) {
					yearType += "." + ytEpoch.getName();
				}
				moci.setYearType(yearType);
						
				try {
					MipOpenFossilInfo saveInfo = mipOpenFossilInfoService.save(moci);
					String pictureIds = saveInfo.getPictureId();
					if (!MyString.isEmpty(pictureIds)) {
						String[] pids = pictureIds.split(",");
						for (String pid : pids) {
							Picture picture = pictureService.get(pid);
							imgPaths.add(picture.getUrl());
							picture.setObjectId(saveInfo.getId());
							pictureService.update(picture);
						}
						imageTranslateDto.setImgPaths(imgPaths);
						//发布
						redisTemplate.convertAndSend("translateImg", imageTranslateDto);
					}
					if(1==config.getIsCommentary()){
						collectionAudio(saveInfo);
					}
					if(1==moci.getIsBorrow()){//可借展
						installBorrow(saveInfo);
					}
					if(2==moci.getIsOpen()){
						//保存到公开表中
						MipOpenCollectionInfo save = saveMipOpenCollectionInfo(saveInfo);
					}
					//在组织机构表中，藏品数目+1
					String collectionUnit = moci.getCollectionUnit();
					if (!MyString.isEmpty(collectionUnit)) {
						MipOrganization mipOrganization = mipOrganizationService.get(collectionUnit);
						mipOrganization.setCollectionCount(mipOrganization.getCollectionCount()+1);
						mipOrganizationService.update(mipOrganization);
					}
					versionSelect = dcVersionSelect(saveInfo,(byte)2,(byte)1);
					dcVersionSelectService.insertDcVersionSelect(versionSelect);
					dcVersionContent(saveInfo,versionSelect.getId(),(byte)1);
					//记录日志(新增化石)
					mipLogService.ocfLog(request, moci,"新增化石");
					return "1";
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				// 修改
				// 通过id查询到藏品具体信息
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(moci.getId());
				boolean isContentChange = moci.getDescription().trim().equals(mipOpenFossilInfo.getDescription().trim());
				DcVersionSelect startSelect = dcVersionSelectService.selectByCollectionId(mipOpenFossilInfo.getId());
				if(MyString.isEmpty(startSelect)){
					versionSelect = dcVersionSelect(mipOpenFossilInfo,(byte)2,(byte)2);
					dcVersionContent(mipOpenFossilInfo,versionSelect.getId(),(byte)2);
				}
				// 更新信息
				mipOpenFossilInfo.setCollectionUnit(moci.getCollectionUnit());
				mipOpenFossilInfo.setDwid(moci.getDwid());
				mipOpenFossilInfo.setGsNo(moci.getGsNo());
				mipOpenFossilInfo.setGsCollectionsNo(moci.getGsCollectionsNo());
				mipOpenFossilInfo.setGsCollectionsNoType(moci.getGsCollectionsNoType());
				mipOpenFossilInfo.setFormerly(moci.getFormerly());
				mipOpenFossilInfo.setName(moci.getName());
				mipOpenFossilInfo.setCollectionsCategory(moci.getCollectionsCategory());
				// 查询年代（宙）集合
				YearType ytEon = (YearType) yearTypeService.get(moci.getYearTypeEon());
				YearType ytEra = (YearType) yearTypeService.get(moci.getYearTypeEra());
				YearType ytEpoch = (YearType) yearTypeService.get(moci.getYearTypeEpoch());
				mipOpenFossilInfo.setYearType(ytEon.getName()+"."+ytEra.getName()+"."+ytEpoch.getName());
				mipOpenFossilInfo.setGsSpecificYear(moci.getGsSpecificYear());
				mipOpenFossilInfo.setGsTexture(moci.getGsTexture());
				mipOpenFossilInfo.setGsTextureCategory(moci.getGsTextureCategory());
				mipOpenFossilInfo.setGsTextureSubcategories(moci.getGsTextureSubcategories());
				mipOpenFossilInfo.setActualQuantity(moci.getActualQuantity());
				mipOpenFossilInfo.setActualQuantityUnit(moci.getActualQuantityUnit());
				mipOpenFossilInfo.setSize(moci.getSize());
				mipOpenFossilInfo.setGsLength(moci.getGsLength());
				mipOpenFossilInfo.setGsWidth(moci.getGsWidth());
				mipOpenFossilInfo.setGsHeight(moci.getGsHeight());
				mipOpenFossilInfo.setMassRange(moci.getMassRange());
				mipOpenFossilInfo.setMass(moci.getMass());
				mipOpenFossilInfo.setMassUnit(moci.getMassUnit());
				mipOpenFossilInfo.setEndResidueLevel(moci.getEndResidueLevel());
				mipOpenFossilInfo.setEndResidualCondition(moci.getEndResidualCondition());
				mipOpenFossilInfo.setGsSource(moci.getGsSource());
				mipOpenFossilInfo.setCollectionLevel(moci.getCollectionLevel());
				mipOpenFossilInfo.setGsStorageState(moci.getGsStorageState());
				mipOpenFossilInfo.setGsEntryWarehouseTimeFrame(moci.getGsEntryWarehouseTimeFrame());
				mipOpenFossilInfo.setGsAuthor(moci.getGsAuthor());
				mipOpenFossilInfo.setGsVersion(moci.getGsVersion());
				mipOpenFossilInfo.setGsKeepOnFile(moci.getGsKeepOnFile());
				mipOpenFossilInfo.setCreator(moci.getCreator());
				mipOpenFossilInfo.setAssessor(moci.getAssessor());
				mipOpenFossilInfo.setDescription(moci.getDescription());
				mipOpenFossilInfo.setRemark(moci.getRemark());
				mipOpenFossilInfo.setIsHighQuality(moci.getIsHighQuality());
				mipOpenFossilInfo.setThreeDimensionalCollection(moci.getThreeDimensionalCollection());
				mipOpenFossilInfo.setRingBeatData(moci.getRingBeatData());
				mipOpenFossilInfo.setfVideo(moci.getfVideo());
				mipOpenFossilInfo.setfAudio(moci.getfAudio());
				mipOpenFossilInfo.setYearTypeEon(moci.getYearTypeEon());
				mipOpenFossilInfo.setYearTypeEra(moci.getYearTypeEra());
				mipOpenFossilInfo.setYearTypeEpoch(moci.getYearTypeEpoch());
				mipOpenFossilInfo.setCollectionPlace(moci.getCollectionPlace());
				mipOpenFossilInfo.setIsOpen((byte)1);
				mipOpenFossilInfo.setStatus((byte)2);
				if(1==mipOpenFossilInfo.getIsOpen()){
					//删除公开表数据
					MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(moci.getId());
					if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
						mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
						//条件表藏品数减一或删除
						conditionDec(mipOpenCollectionInfo);
					}
				}
				//保存图片
				String pids = mipOpenFossilInfo.getPictureId();
				mipOpenFossilInfo.setPictureId(moci.getPictureId().replace("'", ""));
				
				mipOpenFossilInfo.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				try {
					if(1==config.getIsCommentary()&&!isContentChange){
						collectionAudio(mipOpenFossilInfo);
					}
					DcBorrow borrow = dcBorrowService.getDcBorrow(moci.getId());
					if(1==moci.getIsBorrow()){//可借展
						if(MyString.isEmpty(borrow)){
							installBorrow(mipOpenFossilInfo);
						}
					}else{
						if(!MyString.isEmpty(borrow)){
							dcBorrowService.delectBorrow(borrow.getId());
						}
					}
					mipOpenFossilInfoService.update(mipOpenFossilInfo);
					versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenFossilInfo.getId());
					if(!MyString.isEmpty(versionSelect)){
						if(2==versionSelect.getStatus()){
							versionSelect.setUpdateTime(new Date());
							versionSelect.setStatus((byte)1);
							dcVersionSelectService.updateDcVersionSelect(versionSelect);
							dcVersionContent(mipOpenFossilInfo,versionSelect.getId(),(byte)2);
						}else{
							versionSelect.setUpdateTime(new Date());
							dcVersionSelectService.updateDcVersionSelect(versionSelect);
							DcVersionContent content = dcVersionContentService.selectByVersionId(versionSelect.getId());
							content.setContent(JSONObject.fromObject(mipOpenFossilInfo).toString());
							dcVersionContentService.updateInfo(content);
							
						}
					}else{
						versionSelect = dcVersionSelect(mipOpenFossilInfo,(byte)2,(byte)1);
						dcVersionContent(mipOpenFossilInfo,versionSelect.getId(),(byte)2);
					}
					//记录日志(修改化石)
					mipLogService.ocfLog(request, moci,"编辑化石");
					return "1";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	/**
	 * 组装插入借展表
	 * @param info
	 */
	private void installBorrow(MipOpenFossilInfo info){
		DcBorrow borrow = new DcBorrow();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		borrow.setId(uuid);
		borrow.setStatus((byte)1);
		borrow.setCreatetime(new Date());
		borrow.setCollectionUnit(info.getCollectionUnit());
		borrow.setCollectionName(info.getName());
		borrow.setCollectionId(info.getId());
		borrow.setCollectionType("1");
		borrow.setYear(info.getYearType());
		borrow.setWenwuType(info.getCollectionsCategory());
		borrow.setWenwuLeve(info.getCollectionLevel());
		borrow.setZhidiType(info.getGsTextureCategory());
		borrow.setPictureIds(info.getPictureId());
		borrow.setGsNo(info.getGsNo());
		borrow.setFormerly(info.getFormerly());
		dcBorrowService.insertBorrow(borrow);
	}

	//组装版本查询信息
		private DcVersionSelect dcVersionSelect(MipOpenFossilInfo info,byte type,byte status){
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			DcVersionSelect version = new DcVersionSelect();
			version.setId(uuid);
			version.setName(info.getName());
//			version.setYearType(info.getYearType());
			version.setYearTypeEon(info.getYearTypeEon());
			version.setYearTypeEpoch(info.getYearTypeEpoch());
			version.setYearTypeEra(info.getYearTypeEra());
			version.setCollectionUnit(info.getCollectionUnit());
			version.setCollectionCategory(info.getCollectionsCategory());
			version.setStatus(status);
			version.setCollectionId(info.getId());
			version.setCollectionType(type);
			version.setCreatTime(new Date());
			version.setUpdateTime(new Date());
			dcVersionSelectService.insertDcVersionSelect(version);
			return version;
		}
		//组装版本内容信息
		private void dcVersionContent(MipOpenFossilInfo info,String versionId,byte status){
			DcVersionContent version = new DcVersionContent();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			//获取用户信息
			LoginInfoDto userDto = Tools.getUser();
			User user = userService.get(userDto.getId());
			version.setId(uuid);
			version.setContent(JSONObject.fromObject(info).toString());
			version.setUserId(user.getId());
			version.setCreatTime(new Date());
			version.setVersionId(versionId);
			version.setStatus(status);
			DcVersionContent content = dcVersionContentService.selectByVersionId(versionId);
			if(!MyString.isEmpty(content)&&!MyString.isEmpty(content.getVersion())){
				String ver = content.getVersion().replace("V", "");
				int versionInt = Integer.parseInt(ver)+1;
				version.setVersion("V"+versionInt);
			}else{
				version.setVersion("V1");
			}
			dcVersionContentService.insertDcVersionContent(version);
		}
		
	@RequestMapping("/detail.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public ModelAndView detail(@ModelAttribute MipOpenFossilInfo mipOpenFossilInfo,@RequestParam(defaultValue="0")int type) throws MyException {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/collection/open/hsdetail.jsp");
		try {
			MipOpenFossilInfo collection = mipOpenFossilInfoService.get(mipOpenFossilInfo.getId());
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			modelAndView.addObject("collection", collection);
			modelAndView.addObject("type", type);
			// 查询博物馆名称
			String collectionUnitId = collection.getCollectionUnit();
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnitId);
			modelAndView.addObject("mipOrganization", mipOrganization.getName());
			// 查询藏品的文物类别
			String collectionsCategory = collection.getCollectionsCategory();
			CollectionCategory collectionCategory = collectionCategoryService.get(collectionsCategory);
			modelAndView.addObject("collectionCategory", collectionCategory.getName());
			// 查询年代
			String yearTypeId = collection.getYearType();
			YearType yearType = yearTypeService.get(yearTypeId);
			modelAndView.addObject("yearType", yearType.getName());

//			ArrayList<Picture> pictures = new ArrayList<Picture>();
//			String pictureIds = collection.getPictureId();
//			if (!MyString.isEmpty(pictureIds)) {
//				String[] split = pictureIds.split(",");
//				StringBuffer sb = new StringBuffer("'");
//				for (String pid : split) {
//					sb.append(pid).append("','");
//				}
//				pictureIds = sb.substring(0, sb.length()-2);
//				pictures = (ArrayList<Picture>) pictureService.queryByHql(
//						"from Picture where id in (" + pictureIds + ") order by isMain desc,url",Tools.getMap());
//			}
			ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where  objectId = '" + collection.getId() + "' order by isMain desc,url",Tools.getMap());
			//重设图片访问路径
			if (!MyString.isEmpty(pictures)) {
				for (Picture picture : pictures) {
					picture.setUrl(config.getRootUrl()+picture.getUrl());
					picture.setThumb1(config.getRootUrl()+picture.getThumb1());
					picture.setThumb2(config.getRootUrl()+picture.getThumb2());
					picture.setThumb3(config.getRootUrl()+picture.getThumb3());
				}
			}
			modelAndView.addObject("pictures", pictures);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return modelAndView;
	}

	// 批量公开
	@RequestMapping("/publishAll.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String publishAll(String[] ids) throws MyException {
		//发布时需要删除首页缓存
		JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
		try {
			for (String id : ids) {
				// 获取藏品
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				// 设置公开
				if (MyString.isEmpty(mipOpenFossilInfo.getPictureId())) {
					return "-1";
				}
				mipOpenFossilInfo.setIsOpen((byte) 2);
				// 更新
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				//保存到公开表中
				MipOpenCollectionInfo save = saveMipOpenCollectionInfo(mipOpenFossilInfo);
				//条件表中相应藏品数+1 或 增加条件
				conditionAdd(save);
				//相关表藏品数目+1
				numberAdd(mipOpenFossilInfo);
				//公开时更新版本查询表状态为2（需送审时 1 账号同意时执行此方法  2 3权限账号不执行此方法）
				DcVersionSelect versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenFossilInfo.getId());
				if(!MyString.isEmpty(versionSelect)){
					versionSelect.setStatus((byte)2);
					dcVersionSelectService.updateDcVersionSelect(versionSelect);
				}
				//记录日志(公开化石)
				mipLogService.ocfLog(request, mipOpenFossilInfo,"公开化石");
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	// 公开
	@RequestMapping("/publish.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String publish(String[] ids) throws MyException {
		//发布时需要删除首页缓存
		JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
		try {
			// 获取藏品
			if (!MyString.isEmpty(ids)) {
				for (String id : ids) {
					MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
					// 如果为空
					if (MyString.isEmpty(mipOpenFossilInfo.getPictureId())) {
						return "-1";
					}
					// 不为空，更新
					mipOpenFossilInfo.setIsOpen((byte) 2);
					mipOpenFossilInfoService.update(mipOpenFossilInfo);
					//保存到公开表中
					MipOpenCollectionInfo save = saveMipOpenCollectionInfo(mipOpenFossilInfo);
					//条件表中相应藏品数+1 或 增加条件
					conditionAdd(save);
					// 相关表藏品数目+1
					numberAdd(mipOpenFossilInfo);
					//公开时更新版本查询表状态为2（需送审时 1 账号同意时执行此方法  2 3权限账号不执行此方法）
					DcVersionSelect versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenFossilInfo.getId());
					if(!MyString.isEmpty(versionSelect)){
						versionSelect.setStatus((byte)2);
						dcVersionSelectService.updateDcVersionSelect(versionSelect);
					}
					//记录日志(公开化石)
					mipLogService.ocfLog(request, mipOpenFossilInfo,"公开化石");
					return "1";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
		}

	// 批量不公开
	@RequestMapping("/nonPublishAll.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String nonPublishAll(String[] ids) throws MyException {
		try {
			for (String id : ids) {
				// 获取藏品
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				// 设置公开
				/*if (MyString.isEmpty(mipOpenFossilInfo.getPictureId())) {
					return "-1";
				}*/
				mipOpenFossilInfo.setIsOpen((byte) 1);
				// 更新
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				//删除公开表数据
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
					mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
					//条件表藏品数减一或删除
					conditionDec(mipOpenCollectionInfo);
				}
				//相关表藏品数目-1
				numberDec(mipOpenFossilInfo);
				//记录日志(取消公开化石)
				mipLogService.ocfLog(request, mipOpenFossilInfo,"取消公开化石");
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	// 不公开
	@RequestMapping("/nonPublish.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String nonPublish(String[] ids) throws MyException {
		try {
			// 获取藏品
			if (!MyString.isEmpty(ids)) {
				for (String id : ids) {
					MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
					// 如果为空
					/*
					 * if (MyString.isEmpty(mipOpenFossilInfo.getPictureId())) {
					 * return "-1"; }
					 */

					// 不为空，更新
					mipOpenFossilInfo.setIsOpen((byte) 1);
					mipOpenFossilInfoService.update(mipOpenFossilInfo);
					//删除公开表数据
					MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
					if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
						mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
						//条件表藏品数减一或删除
						conditionDec(mipOpenCollectionInfo);
					}
					// 相关表藏品数目-1
					numberDec(mipOpenFossilInfo);
					//记录日志(取消公开化石)
					mipLogService.ocfLog(request, mipOpenFossilInfo,"取消公开化石");
					return "1";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	// 博物馆管理员审核
	@RequestMapping("reviewObject")
	@ResponseBody
	@AuthPassport(authority="collectionCommon")
	public String reviewObject(String id,Byte status,String auditMsg) throws MyException{
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String userName = user.getNickName();
		if (!MyString.isEmpty(id)) {
			MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
			// 如果为空
			if (MyString.isEmpty(mipOpenFossilInfo)) {
				return "-1";
			}
			String listKey = MessageFormat.format(KeyConstants.COLLECTION_INFO_LIST_KEY, id);
			String jsonStr = userName+","+auditMsg;
			JedisService.set(listKey, jsonStr+"", KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
			// 不为空，更新
			mipOpenFossilInfo.setStatus((byte)status);
			mipOpenFossilInfoService.update(mipOpenFossilInfo);
			// 更新es
//					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
//					mipOpenCulturalrelicInfoBLOBs.setStatus((byte)status);
//					updateES(mipOpenCulturalrelicInfoBLOBs);
			//记录日志(博物馆管理员审核)
			//状态（1 审核不通过 2 待审核 3 博物馆管理员已审核 4 省级管理员已审核）
			String statusName = "";
			switch (status) {
				case 1:
					statusName = "审核不通过";
					break;
				case 2:
					statusName = "待审核";
					break;
				case 3:
					statusName = "博物馆管理员已审核";
					break;
				case 4:
					statusName = "省级管理员已审核";
					break;
			}
			mipLogService.ocfLog(request, mipOpenFossilInfo,"博物馆管理员审核:"+statusName+",说明:"+auditMsg);
			return "1";
		}else{
			return "0";
		}
	}
	// 删除
	@RequestMapping(value = "/del.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String del(String[] ids) throws MyException {
		try {
			for (String id : ids) {
				// 获取对象
				MipOpenFossilInfo model = mipOpenFossilInfoService.get(id);
				if (!MyString.isEmpty(model.getId())) {
					// 设置状态（-127）
					model.setStatus((byte) -127);
					mipOpenFossilInfoService.update(model);
					//记录日志(删除化石)
					mipLogService.ocfLog(request, model,"删除化石");
				}
				//公开表相应作删除
				/*MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
					// 设置状态（-127）
//					mipOpenCollectionInfo.setStatus((byte) -127);
//					mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
					//真删除
					mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
					//查询条件表中关联的藏品数
					String yearType = mipOpenCollectionInfo.getYearType();
					String collectionsCategory = mipOpenCollectionInfo.getCollectionsCategory();
					String collectionUnit = mipOpenCollectionInfo.getCollectionUnit();
					//将化石子分类合并为标本化石
					if ("35".equals(collectionsCategory) || "36".equals(collectionsCategory) || "37".equals(collectionsCategory)) {
						collectionsCategory = "34";
					}
					//查询条件表藏品数目
					List<MipYearCategory> conditions = (List<MipYearCategory>) mipYearCategoryService.queryByHql(
							"from MipYearCategory where collectionUnit = '" + collectionUnit + "' and yearType = '"
									+ yearType + "' and collectionsCategory = '" + collectionsCategory + "'",
							Tools.getMap());
					if (!MyString.isEmpty(conditions)) {
						MipYearCategory mipYearCategory = conditions.get(0);
						int counts = mipYearCategory.getCounts();
						if (counts == 1) {
							//如果此条件下只有一件藏品
							mipYearCategoryService.delete(mipYearCategory);
						}
						if (counts > 1) {
							//藏品数目减一
							mipYearCategory.setCounts(counts - 1);
							mipYearCategoryService.update(mipYearCategory);
						}
					}
				
				}*/
				//相关表藏品数目-1
				numberDec(model);
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	// 更换主图
	@SuppressWarnings("unused")
	@RequestMapping(value = "/setMain.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String setMain(String picId, String collectionId) throws MyException {
		try {
			// 查询藏品的所有图片
			MipOpenFossilInfo moci = mipOpenFossilInfoService.get(collectionId);
			String pictureIds = moci.getPictureId();
			// 将所有图片的主图清除
			if (!MyString.isEmpty(pictureIds)) {
				// pictureService.update("update Picture set isMain = 1 where id
				// in (" + pictureIds + ")", Tools.getMap());
				pictureService.update(
						"update Picture set isMain = 1 where objectId='" + collectionId + "' and status>0",
						Tools.getMap());

			}
			Picture pic = pictureService.get(picId);

			/*
			 * // 获取图片路径 ArrayList<Picture> pictures = new ArrayList<Picture>();
			 * pictures = (ArrayList<Picture>) pictureService.queryByHql(
			 * "from Picture where objectId = '" + moci.getId() +
			 * " 'order by isMain desc,url", Tools.getMap()); //
			 * modelAndView.addObject("pictures", pictures); Picture pic =
			 * pictureService.get(picId);
			 */
			// 获取新主图存放路径
			String url = pic.getUrl();
			String rootPath = config.getRootPath();
			String imagePath = rootPath + url;
			// 设置缩略图的存放路径路径
			int lastIndexOf = url.lastIndexOf("/");
			String substring = url.substring(0, lastIndexOf);
			String imageName = url.substring(lastIndexOf + 1);

			if (MyString.isEmpty(pic.getThumb1())) {
				// 藏品详情页大图C2（640*426）
				String thumbUrl1 = substring + "/640x426_" + imageName;
				String thumbnailPath1 = rootPath + thumbUrl1;
				// 生成缩略图
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C2_640.png";
					BufferedImage watermarkImagePath3 = ImageIO.read(new FileInputStream(filePathString));
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath1, 640, 426, watermarkImagePath3);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}else {
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath1, 640, 426, null);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}
			}

			if (MyString.isEmpty(pic.getThumb2())) {
				// 藏品详情页相关图等C3（192*128）
				String thumbUrl2 = substring + "/278x_" + imageName;
				String thumbnailPath2 = rootPath + thumbUrl2;
				// 生成缩略图
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C1_278.png";
					BufferedImage watermarkImagePath3 = ImageIO.read(new FileInputStream(filePathString));
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath2, 278, 0, watermarkImagePath3);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}else {
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath2, 278, 0, null);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}
			}

			if (MyString.isEmpty(pic.getThumb3())) {
				// 藏品详情页相关图等C1（278*）
				String thumbUrl3 = substring + "/192x128_" + imageName;
				String thumbnailPath3 = rootPath + thumbUrl3;
				// 生成缩略图
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C3_192.png";
					BufferedImage watermarkImagePath3 = ImageIO.read(new FileInputStream(filePathString));
					Map<String, Integer> thumb3 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath3, 192, 128, watermarkImagePath3);
					pic.setThumb3(thumbUrl3);
					pic.setThumb3Width(thumb3.get("width"));
					pic.setThumb3Height(thumb3.get("height"));
				}else {
					Map<String, Integer> thumb3 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath3, 192, 128, null);
					pic.setThumb3(thumbUrl3);
					pic.setThumb3Width(thumb3.get("width"));
					pic.setThumb3Height(thumb3.get("height"));
				}
			}

			// 将新主图上架
			pic.setIsMain((byte) 2);

			pictureService.update(pic);
			//记录日志(更换主图)
			mipLogService.ocfLog(request, moci,"更换主图,picId:"+picId);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	
	// 删除图片
	@SuppressWarnings("unused")
	@RequestMapping(value = "/deletePic.do")
	@ResponseBody
	@AuthPassport(authority = "collectionAdmin")
	public String deletePic(String picId) throws MyException {
		try {
			// 删除图片
			if (!MyString.isEmpty(picId)) {
				// 判|断图片的type是否为1和2，1和2不可以删除
				Picture picture = pictureService.get(picId);
				if (!MyString.isEmpty(picture)) {
					if (picture.getType() == 1 || picture.getType() == 2) {
						return "2";// 此图不可以删除
					}
					String objectId = picture.getObjectId();// 所属藏品id
					// 删除图片
					pictureService.delete(picture);
					// 删除藏品中pictureIds中的图片id
					if (!MyString.isEmpty(objectId)) {
						MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(objectId);
						if (!MyString.isEmpty(mipOpenFossilInfo)) {
							String pictureIds = mipOpenFossilInfo.getPictureId();
							if (!MyString.isEmpty(pictureIds)) {
								// 将原图片id设置为空 ,同时去掉多余的逗号
								pictureIds = pictureIds.replace(picId, "").replace(",,", ",").replaceFirst("^,", "")
										.replaceFirst(",$", "");
								mipOpenFossilInfo.setPictureId(pictureIds);
								mipOpenFossilInfoService.update(mipOpenFossilInfo);
								//记录日志(删除图片)
								mipLogService.ocfLog(request, mipOpenFossilInfo,"删除图片,picId:"+picId);
							}

						}
					}
				}
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	/*@RequestMapping("/createThumnb.do")
	@ResponseBody
	public void createThumnb(String collectionId, String picId, String imagePath, String thumbnailPath, int width,
			int height) throws IOException {
		Picture thumbPic = new Picture();
		int lastIndexOf = imagePath.lastIndexOf("/");
		String imageName = imagePath.substring(lastIndexOf + 1);
		if (width > 0 && height > 0) {
			Thumbnails.of(imagePath).size(width, height).toFile(thumbnailPath);
		}
		if (height == 0) {
			Thumbnails.of(imagePath).width(width).toFile(thumbnailPath);
		}
		if (width == 0) {
			Thumbnails.of(imagePath).height(height).toFile(thumbnailPath);
		}

		// 存数据库
		
		 * thumbPic.setCollectionId(collectionId); thumbPic.setFossilId("");
		 * thumbPic.setName(""+ width + "x" +height + "_" +imageName);
		 * thumbPic.setPid(picId);
		 
		thumbPic.setUrl(thumbnailPath.substring(thumbnailPath.lastIndexOf("\\") + 2));
		thumbPic.setType((byte) 2);
		thumbPic.setStatus((byte) 1);
		// 获取缩略图图片真实长宽
		BufferedImage sourceImg = ImageIO.read(new FileInputStream(new File(thumbnailPath)));
		thumbPic.setPicWidth(sourceImg.getWidth());
		thumbPic.setPicHeight(sourceImg.getHeight());
		pictureService.save(thumbPic);
	}
*/
	@RequestMapping("/changeSequence.do")
	@ResponseBody
	public JsonResult changeSequence(@RequestParam String id, @RequestParam String changeId) throws MyException {
		MipOpenFossilInfo change = mipOpenFossilInfoService.get(changeId);
		MipOpenFossilInfo model = mipOpenFossilInfoService.get(id);

		int modelSequence = model.getSequence();

		model.setSequence(change.getSequence());
		change.setSequence(modelSequence);

		mipOpenFossilInfoService.update(model);
		mipOpenFossilInfoService.update(change);
		return new JsonResult(1, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/sltMuseum.do")
	@ResponseBody
	public List<MipOrganization> getCollectionInfo(@RequestParam(name = "parentId") String id) {
		String hql = "select new MipOrganization(id,shortname,parentId) from MipOrganization where status>0 and isdelete=0 and parentId="
				+ id;
		List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,
				Tools.getMap());
		return museumList;
	}

	// 置顶
	@RequestMapping("/top.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String top(String[] ids) throws MyException {

		try {
			// 获取藏品
			for (String id : ids) {
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				// 更新
				mipOpenFossilInfo.setSequence(100);
				mipOpenFossilInfo.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				//更新公开表
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				mipOpenCollectionInfo.setSequence(100);
				mipOpenCollectionInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
				//记录日志(置顶)
				mipLogService.ocfLog(request, mipOpenFossilInfo,"置顶");
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	// 取消置顶
	@RequestMapping("/down.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String down(String[] ids) throws MyException {
		try {
			for (String id : ids) {

				// 获取藏品
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				// 更新
				mipOpenFossilInfo.setSequence(50);
				mipOpenFossilInfo.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				//更新公开表
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				mipOpenCollectionInfo.setSequence(50);
				mipOpenCollectionInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
				//记录日志(置顶)
				mipLogService.ocfLog(request, mipOpenFossilInfo,"取消置顶");
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	
	/**
	 * 相关表藏品书+1
	 * @param moci
	 */
	public void numberAdd(MipOpenFossilInfo moci){
		//在组织机构表中，藏品数目+1
		String collectionUnit = moci.getCollectionUnit();
		if (!MyString.isEmpty(collectionUnit)) {
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnit);
			mipOrganization.setCollectionCount(mipOrganization.getCollectionCount()+1);
			mipOrganizationService.update(mipOrganization);
		}
		//在年代表中，藏品数目+1
		String yearTypeEon = moci.getYearTypeEon();
		String yearTypeEra = moci.getYearTypeEra();
		String yearTypeEpoch = moci.getYearTypeEpoch();
		if (!MyString.isEmpty(yearTypeEon)) {
			YearType yt = yearTypeService.get(yearTypeEon);
			yt.setOpenCounts(yt.getOpenCounts()+1);
			yearTypeService.update(yt);
		}
		if (!MyString.isEmpty(yearTypeEra)) {
			YearType yt = yearTypeService.get(yearTypeEra);
			yt.setOpenCounts(yt.getOpenCounts()+1);
			yearTypeService.update(yt);
		}
		if (!MyString.isEmpty(yearTypeEpoch)) {
			YearType yt = yearTypeService.get(yearTypeEpoch);
			yt.setOpenCounts(yt.getOpenCounts()+1);
			yearTypeService.update(yt);
		}
		//在分类表中，藏品数目+1
		String collectionsCategory = moci.getCollectionsCategory();
		if (!MyString.isEmpty(collectionsCategory)) {
			CollectionCategory collectionCategory = collectionCategoryService.get(collectionsCategory);
			collectionCategory.setOpenCounts(collectionCategory.getOpenCounts()+1);
			collectionCategoryService.update(collectionCategory);
		}
	}
	
	/**
	 * 相关表藏品书-1
	 * @param moci
	 */
	public void numberDec(MipOpenFossilInfo moci){
		//在组织机构表中，藏品数目-1
		String collectionUnit = moci.getCollectionUnit();
		if (!MyString.isEmpty(collectionUnit)) {
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnit);
			if (mipOrganization.getCollectionCount() > 0) {
				mipOrganization.setCollectionCount(mipOrganization.getCollectionCount()-1);
				mipOrganizationService.update(mipOrganization);
			}
		}
		//在年代表中，藏品数目-1
		String yearType = moci.getYearType();
		if (!MyString.isEmpty(yearType)) {
			YearType yt = yearTypeService.get(yearType);
			if (yt.getOpenCounts() > 0) {
				yt.setOpenCounts(yt.getOpenCounts()-1);
				yearTypeService.update(yt);
			}
		}
		//在分类表中，藏品数目-1
		String collectionsCategory = moci.getCollectionsCategory();
		if (!MyString.isEmpty(collectionsCategory)) {
			CollectionCategory collectionCategory = collectionCategoryService.get(collectionsCategory);
			if (collectionCategory.getOpenCounts() > 0) {
				collectionCategory.setOpenCounts(collectionCategory.getOpenCounts()-1);
				collectionCategoryService.update(collectionCategory);
			}
		}
	}

	/**
	 * 将原化石藏品带id保存到公开表
	 * @param mipOpenCulturalrelicInfo
	 * @return
	 */
	public MipOpenCollectionInfo saveMipOpenCollectionInfo(MipOpenFossilInfo mipOpenFossilInfo) {
		MipOpenCollectionInfo mipOpenCollectionInfo = new MipOpenCollectionInfo();
		mipOpenCollectionInfo.setId(mipOpenFossilInfo.getId());
		mipOpenCollectionInfo.setName(mipOpenFossilInfo.getName());
		mipOpenCollectionInfo.setGsNo(mipOpenFossilInfo.getGsNo());
		mipOpenCollectionInfo.setCollectionUnit(mipOpenFossilInfo.getCollectionUnit());
		mipOpenCollectionInfo.setCollectionLevel(mipOpenFossilInfo.getCollectionLevel());
		if (!MyString.isEmpty(mipOpenFossilInfo.getYearTypeEpoch())) {
			mipOpenCollectionInfo.setYearType(mipOpenFossilInfo.getYearTypeEpoch());
		} else {
			if (!MyString.isEmpty(mipOpenFossilInfo.getYearTypeEra())) {
				mipOpenCollectionInfo.setYearType(mipOpenFossilInfo.getYearTypeEra());
			} else {
				if (!MyString.isEmpty(mipOpenFossilInfo.getYearTypeEon())) {
					mipOpenCollectionInfo.setYearType(mipOpenFossilInfo.getYearTypeEon());
				} else {
					mipOpenCollectionInfo.setYearType("2");//年代没选，设置为地质年代
				}
			}
		} 
		mipOpenCollectionInfo.setCollectionsCategory("34");//保存大分类（标本、化石）
		mipOpenCollectionInfo.setDescription(mipOpenFossilInfo.getDescription());
		mipOpenCollectionInfo.setfAudio(mipOpenFossilInfo.getfAudio());
		mipOpenCollectionInfo.setfVideo(mipOpenFossilInfo.getfVideo());
		mipOpenCollectionInfo.setThreeDimensionalCollection(mipOpenFossilInfo.getThreeDimensionalCollection());
		mipOpenCollectionInfo.setPictureIds(mipOpenFossilInfo.getPictureId());
		mipOpenCollectionInfo.setClickCounts(mipOpenFossilInfo.getClickCounts());
		mipOpenCollectionInfo.setCollectedCounts(mipOpenFossilInfo.getCollectedCounts());
		mipOpenCollectionInfo.setUpdatedTime(mipOpenFossilInfo.getSubmitTime());
		mipOpenCollectionInfo.setIsHighQuality(mipOpenFossilInfo.getIsHighQuality());
		mipOpenCollectionInfo.setCollectionType(mipOpenFossilInfo.getCollectionType());
		mipOpenCollectionInfo.setCreateTime(mipOpenFossilInfo.getCreateTime());
		mipOpenCollectionInfo.setStatus(mipOpenFossilInfo.getStatus());
		mipOpenCollectionInfo.setSequence(mipOpenFossilInfo.getSequence());
		MipOpenCollectionInfo save = mipOpenCollectionInfoService.save(mipOpenCollectionInfo);
		return save;
	}
	
	/**
	 * 将（新）条件表中符合条件的藏品数+1或增加一条数据
	 * @param mipOpenCollectionInfo
	 */
	public void conditionAdd(MipOpenCollectionInfo mipOpenCollectionInfo) {
		String yearType = mipOpenCollectionInfo.getYearType();
		String collectionsCategory = mipOpenCollectionInfo.getCollectionsCategory();
		String collectionUnit = mipOpenCollectionInfo.getCollectionUnit();
		//查询条件表藏品数目
		List<MipYearCategory> conditions = (List<MipYearCategory>) mipYearCategoryService.queryByHql(
				"from MipYearCategory where collectionUnit = '" + collectionUnit + "' and yearType = '"
						+ yearType + "' and collectionsCategory = '" + collectionsCategory + "'",
				Tools.getMap());
		if (!MyString.isEmpty(conditions)) {
			//有此条件
			MipYearCategory mipYearCategory = conditions.get(0);
			int counts = mipYearCategory.getCounts();
			//藏品数目加1
			mipYearCategory.setCounts(counts + 1);
			mipYearCategoryService.update(mipYearCategory);
		} else {
			//如果此条件下没有藏品，增加此条件
			MipYearCategory newMipYearCategory = new MipYearCategory();
			newMipYearCategory.setCollectionsCategory(collectionsCategory);
			newMipYearCategory.setYearType(yearType);
			newMipYearCategory.setCollectionUnit(collectionUnit);
			//设置城市id
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnit);
			if (!MyString.isEmpty(mipOrganization)) {
				newMipYearCategory.setCityId(mipOrganization.getCityId());
			}
			//设置分类顺序
			CollectionCategory collectionCategory = collectionCategoryService.get(collectionsCategory);
			if (!MyString.isEmpty(collectionCategory)) {
				newMipYearCategory.setSequence(collectionCategory.getSequence());
			}
			//设置年代顺序
			YearType yearType2 = yearTypeService.get(yearType);
			if (!MyString.isEmpty(yearType2)) {
				newMipYearCategory.setYearSequence(yearType2.getSequence());
			}
			newMipYearCategory.setCounts(1);
			//保存
			mipYearCategoryService.save(newMipYearCategory);
		}
	}
	
	/**
	 * 将（新）条件表中符合条件的藏品数-1或删除
	 * @param mipOpenCollectionInfo
	 */
	public void conditionDec(MipOpenCollectionInfo mipOpenCollectionInfo) {
		String yearType = mipOpenCollectionInfo.getYearType();
		String collectionsCategory = mipOpenCollectionInfo.getCollectionsCategory();
		String collectionUnit = mipOpenCollectionInfo.getCollectionUnit();
		//查询条件表藏品数目
		List<MipYearCategory> conditions = (List<MipYearCategory>) mipYearCategoryService.queryByHql(
				"from MipYearCategory where collectionUnit = '" + collectionUnit + "' and yearType = '"
						+ yearType + "' and collectionsCategory = '" + collectionsCategory + "'",
				Tools.getMap());
		if (!MyString.isEmpty(conditions)) {
			MipYearCategory mipYearCategory = conditions.get(0);
			int counts = mipYearCategory.getCounts();
			if (counts == 1) {
				//如果此条件下只有一件藏品
				mipYearCategoryService.delete(mipYearCategory);
			}
			if (counts > 1) {
				//藏品数目减一
				mipYearCategory.setCounts(counts - 1);
				mipYearCategoryService.update(mipYearCategory);
			}
		}
	}
	/**
	 * 保存讲解词信息
	 */
	private void collectionAudio(MipOpenFossilInfo culturalrelicInfo){
		MipCollectionAudio officeAudio = mipCollectionAudioService.getOfficialAudio(culturalrelicInfo.getId(), (byte)1);
		String uuid = UUID.randomUUID().toString().replace("-", "");
		KdxfUtil.content = culturalrelicInfo.getDescription();
		KdxfUtil.pcnPath = config.getRootPath()+"back/audio/"+uuid+".pcm";
		KdxfUtil.mp3Path = config.getRootPath()+"back/audio/"+uuid+".mp3";
		KdxfUtil.speechSynthesis();
		MipCollectionAudio audio = constractorAudio(culturalrelicInfo.getName(),"back/audio/"+uuid+".mp3",culturalrelicInfo.getId(),"",(byte)1);
		if(!MyString.isEmpty(officeAudio)){
			File fileMp3 = new File(config.getRootPath()+officeAudio.getUrl());
			File filePcm = new File(config.getRootPath()+officeAudio.getUrl().replace(".mp3", ".pcm"));
			if (fileMp3.exists() && fileMp3.isFile()) {
				fileMp3.delete();
	        }
			if (filePcm.exists() && filePcm.isFile()) {
				filePcm.delete();
	        }
			officeAudio.setUrl("back/audio/"+uuid+".mp3");
			mipCollectionAudioService.updateAudio(officeAudio);
		}else{
			mipCollectionAudioService.insertAudio(audio);
		}
	}
	/**
	 * 组装化石藏品音频信息
	 */
	private MipCollectionAudio constractorAudio(String name,String urlVideo,String id,String audioLength,byte isOfficial){
		MipCollectionAudio audio  = new MipCollectionAudio();
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		Date dt = new Date();
		long publishTime = dt.getTime();
		audio.setId(IdUtils.nextId(MipCollectionAudio.class.getName()));
		audio.setCollectionId(id);
		if(!MyString.isEmpty(userDto.getId())){
			audio.setUserId(userDto.getId());
		}
		audio.setUrl(urlVideo);
		audio.setPublishTime(publishTime);
		audio.setIsOfficial((byte)isOfficial);
		audio.setCreatetime(new Date());
		audio.setLikeCounts(0);
		audio.setStatus((byte)1);
		audio.setDuration(intToString(audioLength));
		audio.setSequence(1);
		return audio;
	}
	/**
	 * 处理音频时长
	 */
	private String intToString(String duration){
		String timeLength = "";
		if(!MyString.isEmpty(duration)){
			double time = Double.parseDouble(duration)+1;
			int hour = (int) (time/3600);
			int min = (int)(time-3600*hour)/60;
			int second = (int)(time-3600*hour)%60;
			if(hour>0){
				if(second>9){
					timeLength = hour+":"+min+":"+second;
				}else{
					timeLength = hour+":"+min+":0"+second;
				}
			}else{
				if(second>9){
					timeLength = min+":"+second;
				}else{
					timeLength = min+":0"+second;
				}
			}
		}
		return timeLength;
	}
}
