package com.tj720.mip.controller.collect.collections;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.es.EsSearchDao;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoMapper;
import com.tj720.admin.model.DcBorrow;
import com.tj720.admin.model.DcVersionContent;
import com.tj720.admin.model.DcVersionSelect;
import com.tj720.admin.model.ESModel;
import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipOpenCulturalrelicInfoApproval;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStaticExample;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipStatistics;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStaticExample.Criteria;
import com.tj720.admin.service.DcBorrowService;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.DcVersionSelectService;
import com.tj720.admin.service.MipCollectionAudioService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipLogService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoStaticService;
import com.tj720.admin.service.MipStatisticsService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.common.dto.ImageTranslateDto;
import com.tj720.mip.constant.Constants;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.dto.YearTypeDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipDeleteCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenCollectionInfoService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMipYearCategoryService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.MipDeleteCulturalrelicInfo;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStatic;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipYearCategory;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.FtpUtil;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.ImageToZip;
import com.tj720.mip.utils.KdxfUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
import com.zxlhdata.framework.core.authtool.u.j;

@Controller
@RequestMapping("/collections")
public class CollectionsController extends BaseController<MipOpenCulturalrelicInfo>{

	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private MipOpenCulturalrelicInfoStaticService mipOpenCulturalrelicInfoStaticService;
	@Autowired
	private MipOpenCulturalrelicInfoMapper mipOpenCulturalrelicInfoMapper;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IYearTypeService yearTypeService;
	@Autowired
	private Config config;
	@Autowired
	private IMipDeleteCulturalrelicInfoService mipDeleteCulturalrelicInfoService;
	@Autowired
	private IMipOpenCollectionInfoService mipOpenCollectionInfoService;
	@Autowired
	private IMipYearCategoryService mipYearCategoryService;
	@Autowired
	private DcVersionSelectService dcVersionSelectService;
	@Autowired
	private DcVersionContentService dcVersionContentService;
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private EsSearchDao esSearchDao;
	@Autowired
	MipCollectionAudioService mipCollectionAudioService;
	@Autowired 
	DcBorrowService dcBorrowService;
	@Autowired
	private MipStatisticsService mipStatisticsService;
	@Autowired
	private MipLogService mipLogService;
	@Autowired
	private MipYearTypeService mipYearTypeService;
	@Autowired
	private MipCollectionCategoryService mipCollectionCategoryService;

	private FtpUtil ftpUtil;

	@Autowired
	MipOpenCulturalrelicInfoApprovalService mipOpenCulturalrelicInfoApprovalService;


	@RequestMapping("/list.do")
	@ControllerAop(url="collections/list.do")
	@AuthPassport
	public String list(Model mod) {

		// 当前登录者
		User user = userService.get(Tools.getUser().getId());
		
		String orgId = user.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		String level = org.getOrgTypeId();
		mod.addAttribute("level", level);
		// 查询年代集合
		List<YearTypeDto> ytList = mipYearTypeService.yearTypeList();
		mod.addAttribute("ytList", ytList);
		// 查询文物类别集合
		List<PickDto> ccList = (List<PickDto>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());
		mod.addAttribute("ccList", ccList);
		// 查询化石类别集合
		List<PickDto> ccList1 = (List<PickDto>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>=0 and cc.type like '%化石%'", Tools.getMap());
		mod.addAttribute("ccList1", ccList1);

		// 查询组织机构（博物馆）的集合
		List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
		if (user.getOrgId().equals("0")) {
			mod.addAttribute("musList", orgList);
		} else {
			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(user.getOrgId()), true);
			if("2".equals(org.getOrgTypeId())) {
				sonOrg = organizationService.getLitleOrgByParmOrg(sonOrg);
			}
			mod.addAttribute("musList", sonOrg);
		}

		// 查询年代（宙）集合
		List<YearType> ytEonList = (List<YearType>) yearTypeService
				.queryByHql("from YearType yt where yt.parentId=2 ", Tools.getMap());//and yt.fcCounts>0
		mod.addAttribute("ytEonList", ytEonList);


		return "/WEB-INF/back/collect/collections/collectionsList.jsp";
	}
	
	@RequestMapping("/listStatic.do")
	@ControllerAop(url="collections/listStatic.do")
	@AuthPassport
	public String listStatic(Model mod) {

		// 当前登录者
		User user = userService.get(Tools.getUser().getId());
		
		String orgId = user.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		String level = org.getOrgTypeId();
		mod.addAttribute("level", level);
		// 查询年代集合
		List<YearTypeDto> ytList = mipYearTypeService.yearTypeList();
		mod.addAttribute("ytList", ytList);
		// 查询文物类别集合
		List<PickDto> ccList = (List<PickDto>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());
		mod.addAttribute("ccList", ccList);
		// 查询化石类别集合
		List<PickDto> ccList1 = (List<PickDto>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>=0 and cc.type like '%化石%'", Tools.getMap());
		mod.addAttribute("ccList1", ccList1);

		// 查询组织机构（博物馆）的集合
		List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
		if (user.getOrgId().equals("0")) {
			mod.addAttribute("musList", orgList);
		} else {
			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(user.getOrgId()), true);
			if("2".equals(org.getOrgTypeId())) {
				sonOrg = organizationService.getLitleOrgByParmOrg(sonOrg);
			}
			mod.addAttribute("musList", sonOrg);
		}

		// 查询年代（宙）集合
		List<YearType> ytEonList = (List<YearType>) yearTypeService
				.queryByHql("from YearType yt where yt.parentId=2 ", Tools.getMap());//and yt.fcCounts>0
		mod.addAttribute("ytEonList", ytEonList);


		return "/WEB-INF/back/collect/collections/collectionsStaticList.jsp";
	}

	@RequestMapping("/dataList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject dataList(String key,String levelStatus,String erea,
			@ModelAttribute MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo,
			@RequestParam(defaultValue = "createTime") String order,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size) throws MyException{

		System.out.println("·····················藏品查询测试速度开始····················");
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
		String collectionUnit = mipOpenCulturalrelicInfo.getCollectionUnit();

		long stateTime_thirdly = System.currentTimeMillis();//附加条件开始时间
		// 查询文物藏品列表
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);

		String hql = "select new MipOpenCulturalrelicInfo(id,pictureIds,collectionUnit,gsNo,gsCollectionsNo,name,yearType,collectionsCategory,gsTexture,collectionLevel,isHighQuality,isOpen,gjOpen,sequence,status,description) from MipOpenCulturalrelicInfo where";

		String[] orgIdsEs = null;
		ESModel em = new ESModel();
		MipOrganization mipOrganization11 = new MipOrganization();
		MipOrganization mipOrganization2 = organizationService.get(orgId);

		//博物馆 ------------------------------------------------------------------------------------
		if (!orgId.equals("0")) {
			if (StringUtils.isBlank(collectionUnit)) {
				List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();

				List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
				if("2".equals(mipOrganization2.getOrgTypeId())) {
					sonOrg = organizationService.getLitleOrgByParmOrg(sonOrg);
				}
				String orgIds = "";
				StringBuffer sBuffer = new StringBuffer();
				orgIdsEs = new String[sonOrg.size()];
				int i =0;
				for (com.tj720.admin.model.MipOrganization mipOrganization : sonOrg) {
					sBuffer.append(mipOrganization.getId()).append(",");
					orgIdsEs[i++] = mipOrganization.getId().toString();
				}
				orgIds = sBuffer.toString();
				orgIds = orgIds.substring(0,orgIds.length()-1);
				hql += " and collectionUnit in ("+ orgIds +")";
			} else {
				mipOrganization11 = organizationService.get(collectionUnit);
				hql += " and collectionUnit in ("+ collectionUnit +")";
			}
		}


		Map<String,String> andMap = new HashMap<>();
		Map<String,String[]> inMap = new HashMap<>();
		Map<String,String> likeMap = new HashMap<>();
		Map<String,String> orderMap = new HashMap<>();
		Map<String,String> isNullMap = new HashMap<>();

		if (mipOpenCulturalrelicInfo.getYearType() != null && !"".equals(mipOpenCulturalrelicInfo.getYearType())) {
			hql += (" and yearType='" + mipOpenCulturalrelicInfo.getYearType() + "'");
			andMap.put("yeartype", mipOpenCulturalrelicInfo.getYearType());
		}
		if (mipOpenCulturalrelicInfo.getCollectionsCategory() != null
				&& !"".equals(mipOpenCulturalrelicInfo.getCollectionsCategory())) {
			hql += (" and collectionsCategory='" + mipOpenCulturalrelicInfo.getCollectionsCategory() + "'");
			andMap.put("collectionscategory", mipOpenCulturalrelicInfo.getCollectionsCategory());
		}
		if (mipOpenCulturalrelicInfo.getCollectionUnit() != null
				&& !"".equals(mipOpenCulturalrelicInfo.getCollectionUnit())) {
			if("2".equals(mipOrganization2.getOrgTypeId())) {
				mipOrganization11 = organizationService.get(mipOpenCulturalrelicInfo.getCollectionUnit());
			}
			hql += (" and collectionUnit='" + mipOpenCulturalrelicInfo.getCollectionUnit() + "'");
			andMap.put("collectionunit", mipOpenCulturalrelicInfo.getCollectionUnit());
		}
		if (mipOpenCulturalrelicInfo.getCollectionLevel() != null
				&& !"".equals(mipOpenCulturalrelicInfo.getCollectionLevel())) {
			if("0".equals(mipOpenCulturalrelicInfo.getCollectionLevel())){
				hql += (" and collectionLevel in ('1','2','3')");
				inMap.put("collectionlevel", new String[] {"1","2","3"});
			}else {	
				hql += (" and collectionLevel='" + mipOpenCulturalrelicInfo.getCollectionLevel() + "'");
				andMap.put("collectionlevel", mipOpenCulturalrelicInfo.getCollectionLevel());
			}
		}
		if (mipOpenCulturalrelicInfo.getIsHighQuality() != 0
				&& !"".equals(mipOpenCulturalrelicInfo.getIsHighQuality())) {
			hql += (" and isHighQuality=" + mipOpenCulturalrelicInfo.getIsHighQuality());
			andMap.put("ishighquality",Byte.toString(mipOpenCulturalrelicInfo.getIsHighQuality()));
		}
		if (mipOpenCulturalrelicInfo.getIsOpen() != 0 && !"".equals(mipOpenCulturalrelicInfo.getIsOpen())) {
			hql += (" and isOpen=" + mipOpenCulturalrelicInfo.getIsOpen());
			andMap.put("isopen", Byte.toString(mipOpenCulturalrelicInfo.getIsOpen()));
		}
		if (mipOpenCulturalrelicInfo.getGjOpen() != 0 && !"".equals(mipOpenCulturalrelicInfo.getGjOpen())) {
			hql += (" and gjOpen=" + mipOpenCulturalrelicInfo.getGjOpen());
			andMap.put("gjopen", Byte.toString(mipOpenCulturalrelicInfo.getGjOpen()));
		}
		//藏品质地
		if (mipOpenCulturalrelicInfo.getGsTexture() != null && !"".equals(mipOpenCulturalrelicInfo.getGsTexture())) {
			hql += (" and gsTexture ='"+gsTextureCategory(mipOpenCulturalrelicInfo.getGsTexture())+"'");
			andMap.put("gstexture", gsTextureCategory(mipOpenCulturalrelicInfo.getGsTexture()));
			//				if("1".equals(mipOpenCulturalrelicInfo.getGsTexture())) {
			//					hql += (" and gsTexture in (\"木\",\"竹\",\"纸\",\"毛\",\"丝\",\"皮革\",\"骨角牙\",\"棉麻纤维\",\"其他植物质\",\"其他动物质\",\"其他有机质\")");
			//					// 有机质
			//					inMap.put("gstexture", new String[] {"木","竹","纸","毛","丝","皮革","骨角牙","棉麻纤维","其他植物质","其他动物质","其他有机质"});
			//				}
			//				if("2".equals(mipOpenCulturalrelicInfo.getGsTexture())) {
			//					hql += (" and gsTexture in (\"石\",\"瓷\",\"砖瓦\",\"泥\",\"陶\",\"玻璃\",\"铁\",\"铜\",\"宝玉石\",\"金\",\"银\",\"其他金属\",\"其他无机质\")");
			//					// 无机质
			//					inMap.put("gstexture", new String[] {"石","瓷","砖瓦","泥","陶","玻璃","铁","铜","宝玉石","金","银","其他金属","其他无机质"});
			//				}
		}
		//来源
		if (mipOpenCulturalrelicInfo.getGsSource() != null && !"".equals(mipOpenCulturalrelicInfo.getGsSource())) {
			hql += (" and gsSource=" + mipOpenCulturalrelicInfo.getGsSource());
			andMap.put("gssource", mipOpenCulturalrelicInfo.getGsSource());
		}

		//入藏时间范围
		if (mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame() != null && !"".equals(mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame())) {
			hql += (" and gsEntryWarehouseTimeFrame=" + mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
			andMap.put("gsentrywarehousetimeframe", mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
		}

		//判断输入的是一普编号还是藏品名
		if (!MyString.isEmpty(key)) {
			key = key.trim();
			if (!isNum(key)) {
				hql += " and locate('"+key+"', indexName)>0";
				likeMap.put("name",key);
			} else {
				hql += " and (gsNo like '" + key + "%')";
				likeMap.put("gsno",key);
			}
		}
		if (hql.contains(" where and ")) {
			hql = hql.replace(" where and ", " where ");
		}
		String[] split = hql.split(" ");
		if ("where".equals(split[split.length-1])) {
			hql = hql.substring(0, hql.indexOf(" where"));
		}
		hql += " order by sequence desc,updatedTime desc";
		orderMap.put("sequence","desc");
		orderMap.put("updatedtime","desc");
		List<MipOpenCulturalrelicInfo> fccList = null;
		long endTime_thirdly = System.currentTimeMillis();//附加条件结束时间
		System.out.println("java组装查询条件运行时间："+(endTime_thirdly-stateTime_thirdly)+"ms");
		Integer a = 999999;
		if(page.getCurrentPage() < a) {
			long stateTime_mysql = System.currentTimeMillis();//查询数据库开始时间
			if(!"1".equals(mipOrganization11.getHide_relation_ship()) && !"2".equals(mipOrganization11.getHide_relation_ship())) {
				fccList = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
						.queryByHql(hql, Tools.getMap(), page);
			}else {
				fccList = new ArrayList<MipOpenCulturalrelicInfo>();
			}
			long endTime_mysql = System.currentTimeMillis();//查询数据库结束时间
			System.out.println("mysql查询运行时间："+(endTime_mysql-stateTime_mysql)+"ms");
		}else {
			long stateTime_es = System.currentTimeMillis();//查询数据库开始时间
			//es-------
			fccList = new ArrayList<>();
			if(!"1".equals(mipOrganization11.getHide_relation_ship()) && !"2".equals(mipOrganization11.getHide_relation_ship())) {
				em.setType("mipopenculturalrelicinfo");
				if(orgIdsEs != null && orgIdsEs.length > 0) {
					inMap.put("collectionunit", orgIdsEs);
				}
				em.setAndObject(andMap);
				em.setInObject(inMap);
				em.setLikeObject(likeMap);
				em.setSortObject(orderMap);
				em.setIsNullObject(isNullMap);
				SearchHits queryCombinatorial = esSearchDao.queryCombinatorial(em, page);
				for(SearchHit searchHit : queryCombinatorial) {
					String sourceAsString = searchHit.getSourceAsString();
					MipOpenCulturalrelicInfo parseObject = JSON.parseObject(sourceAsString, MipOpenCulturalrelicInfo.class);
					fccList.add(parseObject);
				}
			}
			//es-------
			long endTime_es = System.currentTimeMillis();//查询数据库结束时间
			System.out.println("es查询运行时间："+(endTime_es-stateTime_es)+"ms");
		}
		//		 查询年代集合
		String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
		List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
				Tools.getMap());
		//     文物类别集合
		List<CollectionCategory> ccList = (List<CollectionCategory>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());

		// 查询组织机构（博物馆）的集合
		List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService.queryByHql(
				"from MipOrganization where status>0 and isdelete=0 order by sequence desc", 
				Tools.getMap());


		long stateTime_image = System.currentTimeMillis();//查询图片开始时间
		for (MipOpenCulturalrelicInfo m2 : fccList) {
			Picture pic = pictureService.getByHql("from Picture where objectId='"+m2.getId()+"' order by isMain desc,url");
			if (null!=pic) {
				if (!MyString.isEmpty(pic.getThumb3())) {
					m2.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
					m2.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
				} else {
					m2.setPicUrl("");
					m2.setFpic("");
				}
			}

			if (ytList.size() > 0) {
				for (YearType yearType : ytList) {
					if (m2.getYearType().equals(yearType.id)) {
						m2.setYearType(yearType.getName());
					}
				}
			}
			if (ccList.size() > 0) {
				for (CollectionCategory gory : ccList) {
					if (m2.getCollectionsCategory().equals(gory.getId())) {
						m2.setCollectionsCategory(gory.getName());
					}
				}
			}
			if (musList.size() > 0) {
				for (MipOrganization mipOrganization : musList) {
					if (m2.getCollectionUnit().equals(mipOrganization.getId())) {
						m2.setCollectionUnit(mipOrganization.getName());
					}
				}
			}
		}
		long endTime_image = System.currentTimeMillis();//查询图片结束时间
		System.out.println("图片查询运行时间："+(endTime_image-stateTime_image)+"ms");
		System.out.println("·····················藏品查询测试速度结束····················");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", fccList);

		return jsonObject;
	}
	
	@RequestMapping("/dataListStatic.do")
	@ResponseBody
	@AuthPassport
	public JSONObject dataListStatic(String key,String levelStatus,String erea,
			@ModelAttribute MipOpenCulturalrelicInfoStatic mipOpenCulturalrelicInfo,
			@RequestParam(defaultValue = "createTime") String order,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size) throws MyException{

		System.out.println("·····················藏品查询测试速度开始····················");
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
		String collectionUnit = mipOpenCulturalrelicInfo.getCollectionUnit();

		long stateTime_thirdly = System.currentTimeMillis();//附加条件开始时间
		// 查询文物藏品列表
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("startRow", page.getStart());
		condition.put("pageSize", page.getSize());
		String[] orgIdsEs = null;
		ESModel em = new ESModel();
		MipOrganization mipOrganization11 = new MipOrganization();
		MipOrganization mipOrganization2 = organizationService.get(orgId);
		//博物馆 ------------------------------------------------------------------------------------
		if (!orgId.equals("0")) {
			if (StringUtils.isBlank(collectionUnit)) {
				List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
				List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
				if("2".equals(mipOrganization2.getOrgTypeId())) {
					sonOrg = organizationService.getLitleOrgByParmOrg(sonOrg);
				}
				String orgIds = "";
				StringBuffer sBuffer = new StringBuffer();
				orgIdsEs = new String[sonOrg.size()];
				int i =0;
				for (com.tj720.admin.model.MipOrganization mipOrganization : sonOrg) {
					sBuffer.append(mipOrganization.getId()).append(",");
					orgIdsEs[i++] = mipOrganization.getId().toString();
				}
				orgIds = sBuffer.toString();
				orgIds = orgIds.substring(0,orgIds.length()-1);
				condition.put("collectionUnit", orgIds);
//				hql += " and collectionUnit in ("+ orgIds +")";
			} else {
				mipOrganization11 = organizationService.get(collectionUnit);
				condition.put("collectionUnit", collectionUnit);
//				hql += " and collectionUnit in ("+ collectionUnit +")";
			}
		}


		Map<String,String> andMap = new HashMap<>();
		Map<String,String[]> inMap = new HashMap<>();
		Map<String,String> likeMap = new HashMap<>();
		Map<String,String> orderMap = new HashMap<>();
		Map<String,String> isNullMap = new HashMap<>();

		if (mipOpenCulturalrelicInfo.getYearType() != null && !"".equals(mipOpenCulturalrelicInfo.getYearType())) {
			condition.put("yearType", mipOpenCulturalrelicInfo.getYearType());
//			hql += (" and yearType='" + mipOpenCulturalrelicInfo.getYearType() + "'");
			
			andMap.put("yeartype", mipOpenCulturalrelicInfo.getYearType());
		}
		if (mipOpenCulturalrelicInfo.getCollectionsCategory() != null
				&& !"".equals(mipOpenCulturalrelicInfo.getCollectionsCategory())) {
			condition.put("collectionsCategory", mipOpenCulturalrelicInfo.getCollectionsCategory());
//			hql += (" and collectionsCategory='" + mipOpenCulturalrelicInfo.getCollectionsCategory() + "'");
			andMap.put("collectionscategory", mipOpenCulturalrelicInfo.getCollectionsCategory());
		}
		if (mipOpenCulturalrelicInfo.getCollectionUnit() != null
				&& !"".equals(mipOpenCulturalrelicInfo.getCollectionUnit())) {
			if("2".equals(mipOrganization2.getOrgTypeId())) {
				mipOrganization11 = organizationService.get(mipOpenCulturalrelicInfo.getCollectionUnit());
			}
			condition.put("collectionUnit", mipOpenCulturalrelicInfo.getCollectionUnit());
//			hql += (" and collectionUnit='" + mipOpenCulturalrelicInfo.getCollectionUnit() + "'");
			andMap.put("collectionunit", mipOpenCulturalrelicInfo.getCollectionUnit());
		}
		if (mipOpenCulturalrelicInfo.getCollectionLevel() != null
				&& !"".equals(mipOpenCulturalrelicInfo.getCollectionLevel())) {
			if("0".equals(mipOpenCulturalrelicInfo.getCollectionLevel())){
				condition.put("collectionLevel", "1,2,3");
//				hql += (" and collectionLevel in ('1','2','3')");
				inMap.put("collectionlevel", new String[] {"1","2","3"});
			}else {	
				condition.put("collectionLevel", mipOpenCulturalrelicInfo.getCollectionLevel());
//				hql += (" and collectionLevel='" + mipOpenCulturalrelicInfo.getCollectionLevel() + "'");
				andMap.put("collectionlevel", mipOpenCulturalrelicInfo.getCollectionLevel());
			}
		}
		if (mipOpenCulturalrelicInfo.getIsHighQuality() != null &&mipOpenCulturalrelicInfo.getIsHighQuality() != 0
				&& !"".equals(mipOpenCulturalrelicInfo.getIsHighQuality())) {
			condition.put("isHighQuality", mipOpenCulturalrelicInfo.getIsHighQuality());
//			hql += (" and isHighQuality=" + mipOpenCulturalrelicInfo.getIsHighQuality());
			andMap.put("ishighquality",Byte.toString(mipOpenCulturalrelicInfo.getIsHighQuality()));
		}
		if (mipOpenCulturalrelicInfo.getIsHighQuality() != null &&mipOpenCulturalrelicInfo.getIsOpen() != 0 && !"".equals(mipOpenCulturalrelicInfo.getIsOpen())) {
			condition.put("isOpen", mipOpenCulturalrelicInfo.getIsOpen());
//			hql += (" and isOpen=" + mipOpenCulturalrelicInfo.getIsOpen());
			andMap.put("isopen", Byte.toString(mipOpenCulturalrelicInfo.getIsOpen()));
		}
		if (mipOpenCulturalrelicInfo.getIsHighQuality() != null &&mipOpenCulturalrelicInfo.getGjOpen() != 0 && !"".equals(mipOpenCulturalrelicInfo.getGjOpen())) {
			condition.put("gjOpen", mipOpenCulturalrelicInfo.getGjOpen());
//			hql += (" and gjOpen=" + mipOpenCulturalrelicInfo.getGjOpen());
			andMap.put("gjopen", Byte.toString(mipOpenCulturalrelicInfo.getGjOpen()));
		}
		//藏品质地
		if (mipOpenCulturalrelicInfo.getGsTexture() != null && !"".equals(mipOpenCulturalrelicInfo.getGsTexture())) {
			condition.put("gsTexture", mipOpenCulturalrelicInfo.getGsTexture());
//			hql += (" and gsTexture ='"+gsTextureCategory(mipOpenCulturalrelicInfo.getGsTexture())+"'");
			andMap.put("gstexture", gsTextureCategory(mipOpenCulturalrelicInfo.getGsTexture()));
			//				if("1".equals(mipOpenCulturalrelicInfo.getGsTexture())) {
			//					hql += (" and gsTexture in (\"木\",\"竹\",\"纸\",\"毛\",\"丝\",\"皮革\",\"骨角牙\",\"棉麻纤维\",\"其他植物质\",\"其他动物质\",\"其他有机质\")");
			//					// 有机质
			//					inMap.put("gstexture", new String[] {"木","竹","纸","毛","丝","皮革","骨角牙","棉麻纤维","其他植物质","其他动物质","其他有机质"});
			//				}
			//				if("2".equals(mipOpenCulturalrelicInfo.getGsTexture())) {
			//					hql += (" and gsTexture in (\"石\",\"瓷\",\"砖瓦\",\"泥\",\"陶\",\"玻璃\",\"铁\",\"铜\",\"宝玉石\",\"金\",\"银\",\"其他金属\",\"其他无机质\")");
			//					// 无机质
			//					inMap.put("gstexture", new String[] {"石","瓷","砖瓦","泥","陶","玻璃","铁","铜","宝玉石","金","银","其他金属","其他无机质"});
			//				}
		}
		//来源
		if (mipOpenCulturalrelicInfo.getGsSource() != null && !"".equals(mipOpenCulturalrelicInfo.getGsSource())) {
			condition.put("gsSource", mipOpenCulturalrelicInfo.getGsSource());
//			hql += (" and gsSource=" + mipOpenCulturalrelicInfo.getGsSource());
			andMap.put("gssource", mipOpenCulturalrelicInfo.getGsSource());
		}

		//入藏时间范围
		if (mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame() != null && !"".equals(mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame())) {
			condition.put("gsEntryWarehouseTimeFrame", mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
//			hql += (" and gsEntryWarehouseTimeFrame=" + mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
			andMap.put("gsentrywarehousetimeframe", mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
		}

		//判断输入的是一普编号还是藏品名
		if (!MyString.isEmpty(key)) {
			key = key.trim();
			if (!isNum(key)) {
				condition.put("name", key);
//				hql += " and locate('"+key+"', indexName)>0";
				likeMap.put("name",key);
			} else {
				condition.put("gsNo", key);
//				hql += " and (gsNo like '" + key + "%')";
				likeMap.put("gsno",key);
			}
		}
//		if (hql.contains(" where and ")) {
//			hql = hql.replace(" where and ", " where ");
//		}
//		String[] split = hql.split(" ");
//		if ("where".equals(split[split.length-1])) {
//			hql = hql.substring(0, hql.indexOf(" where"));
//		}
//		hql += " order by sequence desc,updatedTime desc";
		orderMap.put("sequence","desc");
		orderMap.put("updatedtime","desc");
		List<MipOpenCulturalrelicInfoStatic> fccList = null;
		long endTime_thirdly = System.currentTimeMillis();//附加条件结束时间
		System.out.println("java组装查询条件运行时间："+(endTime_thirdly-stateTime_thirdly)+"ms");
		Integer a = 999999;
		if(page.getCurrentPage() < a) {
			long stateTime_mysql = System.currentTimeMillis();//查询数据库开始时间
//			fccList = (List<MipOpenCulturalrelicInfoStatic>) mipOpenCulturalrelicInfoStaticService
//					.queryByHql(hql, Tools.getMap(), page);
			if("1".equals(mipOrganization11.getHide_relation_ship()) || "2".equals(mipOrganization11.getHide_relation_ship())) {
				fccList = new ArrayList<MipOpenCulturalrelicInfoStatic>();
			}else {
				JsonResult jsonResult = mipOpenCulturalrelicInfoStaticService.getStaticData(condition, page);
				if(jsonResult.getSuccess() == 1){
					fccList = (List<MipOpenCulturalrelicInfoStatic>) jsonResult.getData();
				}
			}
			long endTime_mysql = System.currentTimeMillis();//查询数据库结束时间
			System.out.println("mysql查询运行时间："+(endTime_mysql-stateTime_mysql)+"ms");
		}else {
			long stateTime_es = System.currentTimeMillis();//查询数据库开始时间
			//es-------
			fccList = new ArrayList<>();
			if(!"1".equals(mipOrganization11.getHide_relation_ship()) && !"2".equals(mipOrganization11.getHide_relation_ship())) {
				em.setType("mipopenculturalrelicinfostatic");
				if(orgIdsEs != null && orgIdsEs.length > 0) {
					inMap.put("collectionunit", orgIdsEs);
				}
				em.setAndObject(andMap);
				em.setInObject(inMap);
				em.setLikeObject(likeMap);
				em.setSortObject(orderMap);
				em.setIsNullObject(isNullMap);
				SearchHits queryCombinatorial = esSearchDao.queryCombinatorial(em, page);
				for(SearchHit searchHit : queryCombinatorial) {
					String sourceAsString = searchHit.getSourceAsString();
					MipOpenCulturalrelicInfoStatic parseObject = JSON.parseObject(sourceAsString, MipOpenCulturalrelicInfoStatic.class);
					fccList.add(parseObject);
				}
			}
			//es-------
			long endTime_es = System.currentTimeMillis();//查询数据库结束时间
			System.out.println("es查询运行时间："+(endTime_es-stateTime_es)+"ms");
		}
		//		 查询年代集合
		String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
		List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
				Tools.getMap());
		//     文物类别集合
		List<CollectionCategory> ccList = (List<CollectionCategory>) collectionCategoryService
				.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());

		// 查询组织机构（博物馆）的集合
		List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService.queryByHql(
				"from MipOrganization where status>0 and isdelete=0 order by sequence desc", 
				Tools.getMap());


		long stateTime_image = System.currentTimeMillis();//查询图片开始时间
		for (MipOpenCulturalrelicInfoStatic m2 : fccList) {
			Picture pic = pictureService.getByHql("from Picture where objectId='"+m2.getId()+"' order by isMain desc,url");
			if (null!=pic) {
				if (!MyString.isEmpty(pic.getThumb3())) {
					m2.setPicUrl(config.getImageUrl()+pic.getThumb3());//藏品图URL现存储藏品缩略图地址
					m2.setFpic(config.getImageUrl()+pic.getUrl());//藏品缩略图地址 现存储藏品原图URL
				} else {
					m2.setPicUrl("");
					m2.setFpic("");
				}
			}

			if (ytList.size() > 0) {
				for (YearType yearType : ytList) {
					if (m2.getYearType().equals(yearType.id)) {
						m2.setYearType(yearType.getName());
					}
				}
			}
			if (ccList.size() > 0) {
				for (CollectionCategory gory : ccList) {
					if (m2.getCollectionsCategory().equals(gory.getId())) {
						m2.setCollectionsCategory(gory.getName());
					}
				}
			}
			if (musList.size() > 0) {
				for (MipOrganization mipOrganization : musList) {
					if (m2.getCollectionUnit().equals(mipOrganization.getId())) {
						m2.setCollectionUnit(mipOrganization.getName());
					}
				}
			}
		}
		long endTime_image = System.currentTimeMillis();//查询图片结束时间
		System.out.println("图片查询运行时间："+(endTime_image-stateTime_image)+"ms");
		System.out.println("·····················藏品查询测试速度结束····················");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", fccList);

		return jsonObject;
	}
	
	//是否是数字
	public static boolean isNum(String str){

		Pattern pattern = Pattern.compile("^-?[0-9]+");
		if(pattern.matcher(str).matches()){
			//数字
			return true;
		} else {
			//非数字
			return false;
		}
	}
	public String gsTextureCategory(String content){
		switch (content) {
		case "1":
			return "木";
		case "2":
			return "竹";
		case "3":
			return "纸";
		case "4":
			return "毛";
		case "5":
			return "丝";
		case "6":
			return "石";
		case "7":
			return "瓷";
		case "8":
			return "泥";
		case "9":
			return "陶";
		case "10":
			return "铜";
		case "11":
			return "铁";
		case "12":
			return "金";
		case "13":
			return "银";
		case "14":
			return "皮革";
		case "15":
			return "砖瓦";
		case "16":
			return "玻璃";
		case "17":
			return "骨角牙";
		case "18":
			return "宝玉石";
		case "19":
			return "棉麻纤维";
		case "20":
			return "其他金属";
		case "21":
			return "其他植物质";
		case "22":
			return "其他动物质";
		case "23":
			return "其他有机物";
		case "24":
			return "其他无机物";
		default:
			return "";
		}
	}

	/**
	 * 跳转新增页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toAdd.do")
	@ResponseBody
	@AuthPassport
	public ModelAndView toAdd() {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collect/collections/collectionsAdd.jsp");
		try {
			// 查询藏品分类信息
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService.queryByHql(
					"from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物%' order by sequence desc", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代分类信息
			//			String hql_yearType = "from YearType yt where (yt.parentId ='43' or yt.parentId='46' or yt.parentId='98' or yt.id='142' or yt.id='143') order by yt.code";
			String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') order by yt.code";
			List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
					Tools.getMap());
			mod.addObject("ytList", ytList);

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toAdd.do")) {
				preUrl = request.getContextPath() + "/back/oCCollection/info.do";
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
	@AuthPassport
	public ModelAndView toEdit(@ModelAttribute MipOpenCulturalrelicInfo collection) {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collect/collections/collectionsEdit.jsp");
		try {
			// 根据id查询藏品信息
			collection = mipOpenCulturalrelicInfoService.get(collection.getId());
			/*if (!MyString.isEmpty(collection.getfAudio())) {
				collection.setfAudio(config.getRootUrl()+collection.getfAudio());
			}
			if (!MyString.isEmpty(collection.getfVideo())) {
				collection.setfVideo(config.getRootUrl()+collection.getfVideo());
			}*/
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			mod.addObject("collection", collection);
			// 查询藏品分类信息
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService.queryByHql(
					"from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物%' order by sequence desc", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代分类信息
			//			String hql_yearType = "from YearType yt where (yt.parentId ='43' or yt.parentId='46' or yt.parentId='98' or yt.id='142' or yt.id='143') order by yt.code";
			String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') order by yt.code";
			List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
					Tools.getMap());
			mod.addObject("ytList", ytList);

			// 获取图片路径
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			// String pictureIds = collection.getPictureIds();
			// if (!MyString.isEmpty(pictureIds)) {
			// pictures = (ArrayList<Picture>) pictureService.queryByHql("from
			// Picture where id in (" + pictureIds + ") order by isMain desc,url",
			// Tools.getMap());
			pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where objectId = '" + collection.getId() + "' order by isMain desc,url",
					Tools.getMap());
			pictures = ImageHepler.changePicUrl(pictures, config);
			// }
			mod.addObject("pictures", pictures);

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toEdit.do")) {
				preUrl = request.getContextPath() + "/back/oCCollection/info.do";
			}
			mod.addObject("preUrl", preUrl);


			MipOrganization mipOrganization = mipOrganizationService.get(collection.getCollectionUnit());

			mod.addObject("org", mipOrganization);

			mod.addObject("rootUrl", config.getImageUrl());

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return mod;
	}

	/**
	 * 查看页面
	 * 
	 * @param mocli
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toShow.do")
	@ResponseBody
	@AuthPassport
	public ModelAndView toShow(@ModelAttribute MipOpenCulturalrelicInfo collection) {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collect/collections/collectionsShow.jsp");
		try {
			// 根据id查询藏品信息
			collection = mipOpenCulturalrelicInfoService.get(collection.getId());
			/*if (!MyString.isEmpty(collection.getfAudio())) {
				collection.setfAudio(config.getRootUrl()+collection.getfAudio());
			}
			if (!MyString.isEmpty(collection.getfVideo())) {
				collection.setfVideo(config.getRootUrl()+collection.getfVideo());
			}*/
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			mod.addObject("collection", collection);
			// 查询藏品分类信息
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService.queryByHql(
					"from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物%' order by sequence desc", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代分类信息
			//			String hql_yearType = "from YearType yt where (yt.parentId ='43' or yt.parentId='46' or yt.parentId='98' or yt.id='142' or yt.id='143') order by yt.code";
			String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') order by yt.code";
			List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
					Tools.getMap());
			mod.addObject("ytList", ytList);

			// 获取图片路径
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			// String pictureIds = collection.getPictureIds();
			// if (!MyString.isEmpty(pictureIds)) {
			// pictures = (ArrayList<Picture>) pictureService.queryByHql("from
			// Picture where id in (" + pictureIds + ") order by isMain desc,url",
			// Tools.getMap());
			pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where objectId = '" + collection.getId() + "' order by isMain desc,url",
					Tools.getMap());
			pictures = ImageHepler.changePicUrl(pictures, config);
			// }
			mod.addObject("pictures", pictures);

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toEdit.do")) {
				preUrl = request.getContextPath() + "/back/oCCollection/info.do";
			}
			mod.addObject("preUrl", preUrl);


			MipOrganization mipOrganization = mipOrganizationService.get(collection.getCollectionUnit());

			mod.addObject("org", mipOrganization);

			mod.addObject("rootUrl", config.getImageUrl());

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return mod;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/toShow4Open.do")
	@AuthPassport
	public ModelAndView toShow4Open(String id) {
		id = id.split(",")[0];
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collect/collections/collectionsShow.jsp");
		try {
			// 根据id查询藏品信息
			MipOpenCulturalrelicInfo collection = mipOpenCulturalrelicInfoService.get(id);
			/*if (!MyString.isEmpty(collection.getfAudio())) {
				collection.setfAudio(config.getRootUrl()+collection.getfAudio());
			}
			if (!MyString.isEmpty(collection.getfVideo())) {
				collection.setfVideo(config.getRootUrl()+collection.getfVideo());
			}*/
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			mod.addObject("collection", collection);
			// 查询藏品分类信息
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService.queryByHql(
					"from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物%' order by sequence desc", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代分类信息
			//			String hql_yearType = "from YearType yt where (yt.parentId ='43' or yt.parentId='46' or yt.parentId='98' or yt.id='142' or yt.id='143') order by yt.code";
			String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') order by yt.code";
			List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
					Tools.getMap());
			mod.addObject("ytList", ytList);

			// 获取图片路径
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			// String pictureIds = collection.getPictureIds();
			// if (!MyString.isEmpty(pictureIds)) {
			// pictures = (ArrayList<Picture>) pictureService.queryByHql("from
			// Picture where id in (" + pictureIds + ") order by isMain desc,url",
			// Tools.getMap());
			pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where objectId = '" + collection.getId() + "' order by isMain desc,url",
					Tools.getMap());
			pictures = ImageHepler.changePicUrl(pictures, config);
			// }
			mod.addObject("pictures", pictures);

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toEdit.do")) {
				preUrl = request.getContextPath() + "/back/oCCollection/info.do";
			}
			mod.addObject("preUrl", preUrl);


			MipOrganization mipOrganization = mipOrganizationService.get(collection.getCollectionUnit());

			mod.addObject("org", mipOrganization);

			mod.addObject("rootUrl", config.getImageUrl());

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/WEB-INF/back/error.jsp");
		}
		return mod;
	}
	
	/**
	 * 查看页面
	 * 
	 * @param mocli
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toShowStatic.do")
	@ResponseBody
	@AuthPassport
	public ModelAndView toShowStatic(@ModelAttribute MipOpenCulturalrelicInfoStatic collection) {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collect/collections/collectionsShowStatic.jsp");
		try {
			// 根据id查询藏品信息
			JsonResult jsonResult = mipOpenCulturalrelicInfoStaticService.get(collection.getId());
			if(jsonResult.getSuccess() == 1){
				collection = (MipOpenCulturalrelicInfoStatic) jsonResult.getData();
			}
			/*if (!MyString.isEmpty(collection.getfAudio())) {
				collection.setfAudio(config.getRootUrl()+collection.getfAudio());
			}
			if (!MyString.isEmpty(collection.getfVideo())) {
				collection.setfVideo(config.getRootUrl()+collection.getfVideo());
			}*/
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			mod.addObject("collection", collection);
			// 查询藏品分类信息
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService.queryByHql(
					"from CollectionCategory cc where cc.openCounts>0 and cc.type like '文物%' order by sequence desc", Tools.getMap());
			mod.addObject("ccList", ccList);
			// 查询年代分类信息
			//			String hql_yearType = "from YearType yt where (yt.parentId ='43' or yt.parentId='46' or yt.parentId='98' or yt.id='142' or yt.id='143') order by yt.code";
			String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') order by yt.code";
			List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
					Tools.getMap());
			mod.addObject("ytList", ytList);

			// 获取图片路径
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			// String pictureIds = collection.getPictureIds();
			// if (!MyString.isEmpty(pictureIds)) {
			// pictures = (ArrayList<Picture>) pictureService.queryByHql("from
			// Picture where id in (" + pictureIds + ") order by isMain desc,url",
			// Tools.getMap());
			pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where objectId = '" + collection.getId() + "' order by isMain desc,url",
					Tools.getMap());
			pictures = ImageHepler.changePicUrl(pictures, config);
			// }
			mod.addObject("pictures", pictures);

			// 获取前一个页面路径
			String preUrl = request.getHeader("Referer");
			if (MyString.isEmpty(preUrl) || preUrl.contains("toEdit.do")) {
				preUrl = request.getContextPath() + "/back/oCCollection/info.do";
			}
			mod.addObject("preUrl", preUrl);


			MipOrganization mipOrganization = mipOrganizationService.get(collection.getCollectionUnit());

			mod.addObject("org", mipOrganization);

			mod.addObject("rootUrl", config.getImageUrl());

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
	@AuthPassport
	public String addOrUpdate(@ModelAttribute MipOpenCulturalrelicInfo moci,
			@RequestParam(value="saveStatus",required=false) String saveStatus,
			String picUrl,String fileName,String width,String height,String typeId) {
		ImageTranslateDto imageTranslateDto = new ImageTranslateDto();
		imageTranslateDto.setOpType("add");
		List<String> imgPaths = new ArrayList<String>();
		try {
			// 判断增加还是修改
			if (MyString.isEmpty(moci.getId())) {
				//增加
				String mociId = IdUtils.nextId(moci);
				moci.setId(mociId);
				moci.setCollectionType("0");
				moci.setIsOpen((byte)1);//设置为不公开
				moci.setGjOpen((byte) 1);
				if (saveStatus.equals("1")) {
					moci.setStatus((byte)1);
				} else if (saveStatus.equals("2")) {
					moci.setStatus((byte)2);
				}
				moci.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				try {
					if (StringUtils.isNotBlank(picUrl)) {
						String[] saveUrl = picUrl.split(",");


						String[] picName = fileName.split(",");

						String[] wid = width.split(",");

						String[] hei = height.split(",");
						String pictureIdsStr = "";
						for (int i = 0;i < hei.length;i++) {
							Picture picture = new Picture();
							String picId = IdUtils.nextId(picture);
							picture.setId(picId);
							picture.setObjectId(mociId);
							picture.setTypeId(typeId);
							picture.setName(picName[i]);
							picture.setUrl(saveUrl[i]);
							picture.setStatus((byte) 1);

							picture.setPicWidth(Integer.parseInt(wid[i]));
							picture.setPicHeight(Integer.parseInt(hei[i]));
							Picture pic = setMain(picture);

							Picture savePic = pictureService.save(pic);
							pictureIdsStr+=picId + ",";

							imgPaths.add(picture.getUrl());
						}
						imageTranslateDto.setImgPaths(imgPaths);
						//发布
						redisTemplate.convertAndSend("translateImg", imageTranslateDto);

						String pictureIds = pictureIdsStr.substring(0, pictureIdsStr.length() - 1);
						moci.setPictureIds(pictureIds);
					}
					MipOpenCulturalrelicInfo saveInfo = mipOpenCulturalrelicInfoService.save(moci);
					// 更新es
					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(saveInfo.getId());
					addES(mipOpenCulturalrelicInfoBLOBs);

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
					//在图片表中保存所属藏品id
					//					if (!MyString.isEmpty(pictureIds)) {
					//						String[] pids = pictureIds.split(",");
					//						for (String pid : pids) {
					//							Picture picture = pictureService.get(pid);
					//							imgPaths.add(picture.getUrl());
					//							picture.setObjectId(saveInfo.getId());
					//							pictureService.update(picture);
					//						}
					//						imageTranslateDto.setImgPaths(imgPaths);
					//						//发布
					//						redisTemplate.convertAndSend("translateImg", imageTranslateDto);
					//					}
					String selectId = dcVersionSelect(saveInfo,(byte)1,(byte)1);
					dcVersionContent(saveInfo,selectId,(byte)1);
					//更新统计表数据
					addStatisti(moci);
					//记录日志(新增)
					mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"新增藏品");
					return "1";
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				// 修改
				// 通过id查询到藏品具体信息
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(moci.getId());

				//不知道这几行干嘛的
				//更新统计表
				modifyStatisti(mipOpenCulturalrelicInfo);
				DcVersionSelect startSelect = dcVersionSelectService.selectByCollectionId(mipOpenCulturalrelicInfo.getId());
				if(MyString.isEmpty(startSelect)){
					String selectId = dcVersionSelect(mipOpenCulturalrelicInfo,(byte)1,(byte)2);
					dcVersionContent(mipOpenCulturalrelicInfo,selectId,(byte)2);
				}


				// 更新信息
				boolean isContentChange = moci.getDescription().trim().equals(mipOpenCulturalrelicInfo.getDescription().trim());
				if (StringUtils.isNotBlank(picUrl)) {
					String[] saveUrl = picUrl.split(",");

					String[] picName = fileName.split(",");

					String[] wid = width.split(",");

					String[] hei = height.split(",");
					String rootUrl = config.getRootUrl();

					String pictureIdsStr = moci.getPictureIds();
					String[] picIdArr = pictureIdsStr.split(",");
					List<String> picList = Arrays.asList(picIdArr);
					ArrayList<String> arrayList = new ArrayList<String>(picList);
					for (int i = 0;i < hei.length;i++) {
						String picNewUrl = saveUrl[i].replace(rootUrl, "");
						//标志状态，1就是该图片是新增，2就是已存在
						String picStatus = "1";
						//遍历picid，查询该pic的高是否和hei里面相等，相等就不用新增pic
						for (int j = 0;j < arrayList.size();j++) {
							Picture pic = pictureService.get(arrayList.get(j));
							if (pic.getPicHeight() == Integer.parseInt(hei[i])) {
								arrayList.remove(j);
								picStatus = "2";
								break;
							}
						}
						if (picStatus.equals("1")) {

							Picture picture = new Picture();
							String picID = IdUtils.nextId(picture);
							picture.setId(picID);
							picture.setObjectId(moci.getId());
							picture.setTypeId(typeId);
							picture.setName(picName[i]);
							picture.setUrl(picNewUrl);
							picture.setStatus((byte) 1);

							picture.setPicWidth(Integer.parseInt(wid[i]));
							picture.setPicHeight(Integer.parseInt(hei[i]));
							Picture picNew = setMain(picture);

							Picture savePic = pictureService.save(picNew);
							pictureIdsStr+=picID + ",";
							imgPaths.add(picture.getUrl());
						}


					}
					imageTranslateDto.setImgPaths(imgPaths);
					//发布
					redisTemplate.convertAndSend("translateImg", imageTranslateDto);
					String pictureIds = pictureIdsStr;
					if(",".equals(pictureIdsStr.substring(pictureIdsStr.length() - 1))) {
						pictureIds = pictureIdsStr.substring(0, pictureIdsStr.length() - 1);
					}
					moci.setPictureIds(pictureIds);
				}

				mipOpenCulturalrelicInfo.setCollectionUnit(moci.getCollectionUnit());
				mipOpenCulturalrelicInfo.setDwid(moci.getDwid());
				mipOpenCulturalrelicInfo.setGsNo(moci.getGsNo());
				mipOpenCulturalrelicInfo.setGsCollectionsNo(moci.getGsCollectionsNo());
				mipOpenCulturalrelicInfo.setGsCollectionsNoType(moci.getGsCollectionsNoType());
				mipOpenCulturalrelicInfo.setFormerly(moci.getFormerly());
				mipOpenCulturalrelicInfo.setName(moci.getName());
				mipOpenCulturalrelicInfo.setCollectionsCategory(moci.getCollectionsCategory());
				mipOpenCulturalrelicInfo.setYearType(moci.getYearType());
				mipOpenCulturalrelicInfo.setGsSpecificYear(moci.getGsSpecificYear());
				mipOpenCulturalrelicInfo.setGsTexture(moci.getGsTexture());
				mipOpenCulturalrelicInfo.setGsTextureCategory(moci.getGsTextureCategory());
				mipOpenCulturalrelicInfo.setGsTextureSubcategories(moci.getGsTextureSubcategories());
				mipOpenCulturalrelicInfo.setActualQuantity(moci.getActualQuantity());
				mipOpenCulturalrelicInfo.setActualQuantityUnit(moci.getActualQuantityUnit());
				mipOpenCulturalrelicInfo.setSize(moci.getSize());
				mipOpenCulturalrelicInfo.setGsLength(moci.getGsLength());
				mipOpenCulturalrelicInfo.setGsWidth(moci.getGsWidth());
				mipOpenCulturalrelicInfo.setGsHeight(moci.getGsHeight());
				mipOpenCulturalrelicInfo.setMassRange(moci.getMassRange());
				mipOpenCulturalrelicInfo.setMass(moci.getMass());
				mipOpenCulturalrelicInfo.setMassUnit(moci.getMassUnit());
				mipOpenCulturalrelicInfo.setEndResidueLevel(moci.getEndResidueLevel());
				mipOpenCulturalrelicInfo.setEndResidualCondition(moci.getEndResidualCondition());
				mipOpenCulturalrelicInfo.setGsSource(moci.getGsSource());
				mipOpenCulturalrelicInfo.setCollectionLevel(moci.getCollectionLevel());
				mipOpenCulturalrelicInfo.setGsStorageState(moci.getGsStorageState());
				mipOpenCulturalrelicInfo.setGsEntryWarehouseTimeFrame(moci.getGsEntryWarehouseTimeFrame());
				mipOpenCulturalrelicInfo.setGsAuthor(moci.getGsAuthor());
				mipOpenCulturalrelicInfo.setGsVersion(moci.getGsVersion());
				mipOpenCulturalrelicInfo.setGsKeepOnFile(moci.getGsKeepOnFile());
				mipOpenCulturalrelicInfo.setCreator(moci.getCreator());
				mipOpenCulturalrelicInfo.setAssessor(moci.getAssessor());
				mipOpenCulturalrelicInfo.setDescription(moci.getDescription());
				mipOpenCulturalrelicInfo.setRemark(moci.getRemark());
				mipOpenCulturalrelicInfo.setIsHighQuality(moci.getIsHighQuality());
				mipOpenCulturalrelicInfo.setThreeDimensionalCollection(moci.getThreeDimensionalCollection());
				mipOpenCulturalrelicInfo.setRingBeatData(moci.getRingBeatData());
				mipOpenCulturalrelicInfo.setfVideo(moci.getfVideo());
				mipOpenCulturalrelicInfo.setfAudio(moci.getfAudio());
				mipOpenCulturalrelicInfo.setIsOpen((byte)1);
				mipOpenCulturalrelicInfo.setStatus((byte)2);
				mipOpenCulturalrelicInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				if(1==mipOpenCulturalrelicInfo.getIsOpen()){
					// 更新es
					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(moci.getId());
					updateES(mipOpenCulturalrelicInfoBLOBs);
					//删除公开表数据
					MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(moci.getId());
					if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
						mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
						//条件表藏品数减一或删除
						conditionDec(mipOpenCollectionInfo);
					}
				}
				DcBorrow borrow = dcBorrowService.getDcBorrow(moci.getId());
				if(1==moci.getIsBorrow()){//可借展
					if(MyString.isEmpty(borrow)){
						installBorrow(mipOpenCulturalrelicInfo);
					}
				}else{
					if(!MyString.isEmpty(borrow)){
						dcBorrowService.delectBorrow(borrow.getId());
					}
				}
				//保存图片
				String pids = mipOpenCulturalrelicInfo.getPictureIds();
				mipOpenCulturalrelicInfo.setPictureIds(moci.getPictureIds().replace("'", ""));
				mipOpenCulturalrelicInfo
				.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				try {
					if(1==config.getIsCommentary()&&!isContentChange){
						collectionAudio(mipOpenCulturalrelicInfo);
					}


					mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
					// 更新es
					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(moci.getId());
					updateES(mipOpenCulturalrelicInfoBLOBs);
					DcVersionSelect versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenCulturalrelicInfo.getId());
					if(!MyString.isEmpty(versionSelect)){
						if(2==versionSelect.getStatus()){
							versionSelect.setUpdateTime(new Date());
							versionSelect.setStatus((byte)1);
							dcVersionSelectService.updateDcVersionSelect(versionSelect);
							dcVersionContent(mipOpenCulturalrelicInfo,versionSelect.getId(),(byte)2);
						}else{
							versionSelect.setUpdateTime(new Date());
							dcVersionSelectService.updateDcVersionSelect(versionSelect);
							DcVersionContent content = dcVersionContentService.selectByVersionId(versionSelect.getId());
							content.setContent(JSONObject.fromObject(mipOpenCulturalrelicInfo).toString());
							dcVersionContentService.updateInfo(content);
							dcVersionContent(mipOpenCulturalrelicInfo,versionSelect.getId(),(byte)2);
						}
					}else{
						String selectId = dcVersionSelect(mipOpenCulturalrelicInfo,(byte)1,(byte)1);
						dcVersionContent(mipOpenCulturalrelicInfo,selectId,(byte)2);
					}
					//更新统计表
					addStatisti(mipOpenCulturalrelicInfo);
					//记录日志(修改)
					mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"编辑藏品");
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

	// 设置主图
	public Picture setMain(Picture pic) throws MyException {
		ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
		try {

			// 获取新主图存放路径
			String url = pic.getUrl();
			url = url.replace("_wm.", ".");
			String rootPath = config.getRootPath();
			String imagePath = rootPath + url;
			// 设置缩略图的存放路径路径
			int lastIndexOf = url.lastIndexOf("/");
			String substring = url.substring(0, lastIndexOf);
			String imageName = url.substring(lastIndexOf + 1);

			//上传到临时文件夹中
			String tempPath =System.getProperty("java.io.tmpdir")+File.separator;

			if (MyString.isEmpty(pic.getThumb1())) {
				// 藏品详情页大图C1（640*426）
				if (!new File(tempPath + rootPath + substring).exists()) {
					new File(tempPath + rootPath + substring).mkdirs();
				}
				String thumbUrl1 = substring + "/640x426_" + imageName;
				String thumbnailPath1 = rootPath + thumbUrl1;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C2_640.png";
					//				 File file1 =new File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C2_640.png");
					//					BufferedImage watermarkImagePath1 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath1 = null;
					// 生成缩略图
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath1, 640, 426,watermarkImagePath1);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}else {
					// 生成缩略图
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath1, 640, 426, null);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}
				File thumbnailFile = new File(tempPath + thumbnailPath1);
				InputStream thumbnailFileIs = new FileInputStream(thumbnailFile);
				//将缩略图上传到ftp
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(thumbnailPath1.substring(0, thumbnailPath1.lastIndexOf("/640x426_" + imageName))+"/", "640x426_" + imageName, thumbnailFileIs);
			}

			if (MyString.isEmpty(pic.getThumb2())) {
				// 藏品详情页相关图等C2（278*）
				if (!new File(tempPath + rootPath + substring).exists()) {
					new File(tempPath + rootPath + substring).mkdirs();
				}
				String thumbUrl2 = substring + "/278x_" + imageName;
				String thumbnailPath2 = rootPath + thumbUrl2;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C1_278.png";
					// File file1 =new
					// File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C1_278.png");
					//					BufferedImage watermarkImagePath2 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath2 = null;
					// 生成缩略图
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath2, 278,
							0, watermarkImagePath2);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}else {
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath2, 278,
							0, null);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}
				File thumbnailFile = new File(tempPath + thumbnailPath2);
				InputStream thumbnailFileIs = new FileInputStream(thumbnailFile);
				//将缩略图上传到ftp
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(thumbnailPath2.substring(0, thumbnailPath2.lastIndexOf("/278x_" + imageName))+"/", "278x_" + imageName, thumbnailFileIs);
			}

			if (MyString.isEmpty(pic.getThumb3())) {
				// 藏品详情页相关图等C1（192*128）
				if (!new File(tempPath + rootPath + substring).exists()) {
					new File(tempPath + rootPath + substring).mkdirs();
				}
				String thumbUrl3 = substring + "/192x128_" + imageName;
				String thumbnailPath3 = rootPath + thumbUrl3;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C3_192.png";
					//					File file1 =new File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C3_192.png");
					//					BufferedImage watermarkImagePath3 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath3 = null;
					// 生成缩略图
					Map<String, Integer> thumb3 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath3, 192, 128, watermarkImagePath3);
					pic.setThumb3(thumbUrl3);
					pic.setThumb3Width(thumb3.get("width"));
					pic.setThumb3Height(thumb3.get("height"));
				}else {
					Map<String, Integer> thumb3 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath3, 192, 128, null);
					pic.setThumb3(thumbUrl3);
					pic.setThumb3Width(thumb3.get("width"));
					pic.setThumb3Height(thumb3.get("height"));
				}
				File thumbnailFile = new File(tempPath + thumbnailPath3);
				InputStream thumbnailFileIs = new FileInputStream(thumbnailFile);
				//将缩略图上传到ftp
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(thumbnailPath3.substring(0, thumbnailPath3.lastIndexOf("/192x128_" + imageName))+"/", "192x128_" + imageName, thumbnailFileIs);
			}


			pic.setIsMain((byte) 1);

			return pic;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 组装插入借展表
	 * @param info
	 */
	private void installBorrow(MipOpenCulturalrelicInfo info){
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
		borrow.setPictureIds(info.getPictureIds());
		borrow.setGsNo(info.getGsNo());
		borrow.setFormerly(info.getFormerly());
		dcBorrowService.insertBorrow(borrow);
	}
	//插入版本查询信息
	private String dcVersionSelect(MipOpenCulturalrelicInfo info,byte type,byte status){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		DcVersionSelect version = new DcVersionSelect();
		version.setId(uuid);
		version.setName(info.getName());
		version.setYearType(info.getYearType());
		version.setCollectionUnit(info.getCollectionUnit());
		version.setCollectionCategory(info.getCollectionsCategory());
		version.setCollectionId(info.getId());
		version.setCollectionType(type);
		version.setCreatTime(new Date());
		version.setUpdateTime(new Date());
		version.setStatus(status);
		dcVersionSelectService.insertDcVersionSelect(version);
		return uuid;
	}
	//插入版本内容信息
	private void dcVersionContent(MipOpenCulturalrelicInfo info,String versionId,byte status){
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
	/**
	 * 查看详情页
	 * 
	 * @param mipOpenCulturalrelicInfo
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	@AuthPassport
	public ModelAndView detail(@ModelAttribute MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo,@RequestParam(defaultValue="0")int type) throws MyException {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/collection/open/wwdetail.jsp");
		try {
			MipOpenCulturalrelicInfo collection = mipOpenCulturalrelicInfoService.get(mipOpenCulturalrelicInfo.getId());
			int isBorrow = dcBorrowService.getDcBorrowByCollectionId(collection.getId());
			collection.setIsBorrow(isBorrow);
			modelAndView.addObject("collection", collection);
			modelAndView.addObject("type", type);

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
			pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where objectId = '" + collection.getId() + "' and status >= 0 order by isMain desc,url",Tools.getMap());

			/*String pictureIds = collection.getPictureIds();
			if (!MyString.isEmpty(pictureIds)) {
				String[] split = pictureIds.split(",");
				StringBuffer sb = new StringBuffer("'");
				for (String pid : split) {
					sb.append(pid).append("','");
				}
				pictureIds = sb.substring(0, sb.length()-2);
				pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ") order by isMain desc,url",Tools.getMap());
			}*/
			//重设图片访问路径
			if (!MyString.isEmpty(pictures)) {
				for (Picture picture : pictures) {
					picture.setUrl(config.getImageUrl()+picture.getUrl());
					picture.setThumb1(config.getImageUrl()+picture.getThumb1());
					picture.setThumb2(config.getImageUrl()+picture.getThumb2());
					picture.setThumb3(config.getImageUrl()+picture.getThumb3());
				}
			}

			/*if (!MyString.isEmpty(pictureIds)) {
				String[] strArray = pictureIds.split(",");
				for (String str : strArray) {
					Picture picture = pictureService.get(str);
					pictures.add(picture);
				}
			}*/

			/*// 获取图片路径
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			pictures = (ArrayList<Picture>) pictureService.queryByHql(
					"from Picture where objectId = '" + collection.getId() + "' and typeId=1 order by isMain desc,url",
					Tools.getMap());*/
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
	@AuthPassport
	public String publishAll(String[] ids) throws MyException {
		//发布时需要删除首页缓存
		JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
		try {
			if (!MyString.isEmpty(ids)) {
				for (String id : ids) {
					// 获取藏品
					MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
					// 设置公开
					if (MyString.isEmpty(mipOpenCulturalrelicInfo.getPictureIds())) {
						return "-1";
					}

					/*MipOpenCollectionNumber mipOpenCollectionNumber = new MipOpenCollectionNumber();
					mipOpenCollectionNumber.setId(id);
					int isExist = mipOpenCollectionNumberService.selectModel(id);
					if(isExist==0){
						mipOpenCollectionNumberService.insert(mipOpenCollectionNumber);
					}*/
					mipOpenCulturalrelicInfo.setIsOpen((byte) 2);
					mipOpenCulturalrelicInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
					// 更新
					mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
					// 更新es
					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
					updateES(mipOpenCulturalrelicInfoBLOBs);
					//保存到公开表中
					MipOpenCollectionInfo save = saveMipOpenCollectionInfo(mipOpenCulturalrelicInfo);
					//添加水印
					addWaterMark(save);
					//条件表中相应藏品数+1 或 增加条件
					conditionAdd(save);
					//相关表藏品数目+1
					numberAdd(mipOpenCulturalrelicInfo);
					//公开时更新版本查询表状态为2（需送审时 1 账号同意时执行此方法  2 3权限账号不执行此方法）
					DcVersionSelect versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenCulturalrelicInfoBLOBs.getId());
					if(!MyString.isEmpty(versionSelect)){
						versionSelect.setStatus((byte)2);
						dcVersionSelectService.updateDcVersionSelect(versionSelect);
					}
					//记录日志(公开)
					mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"馆际公开藏品");
				}
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	// 批量公开
	@RequestMapping("/publishAllNew.do")
	@ResponseBody
	@AuthPassport
		public String publishAllNew(String[] ids) throws MyException {
			//发布时需要删除首页缓存
			JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
			try {
				if (!MyString.isEmpty(ids)) {
					for (String id : ids) {
						// 获取藏品
						MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
						// 设置公开
						if (MyString.isEmpty(mipOpenCulturalrelicInfo.getPictureIds())) {
							return "-1";
						}
						mipOpenCulturalrelicInfo.setGjOpen((byte) 2);
						mipOpenCulturalrelicInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
						// 更新
						mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
						// 更新es
						MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
						updateES(mipOpenCulturalrelicInfoBLOBs);
//						//保存到公开表中
//						MipOpenCollectionInfo save = saveMipOpenCollectionInfo(mipOpenCulturalrelicInfo);
						//添加水印
						addWaterMark(mipOpenCulturalrelicInfo);
						//条件表中相应藏品数+1 或 增加条件
						conditionAdd(mipOpenCulturalrelicInfo);
						//相关表藏品数目+1
						numberAdd(mipOpenCulturalrelicInfo);
						//公开时更新版本查询表状态为2（需送审时 1 账号同意时执行此方法  2 3权限账号不执行此方法）
						DcVersionSelect versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenCulturalrelicInfoBLOBs.getId());
						if(!MyString.isEmpty(versionSelect)){
							versionSelect.setStatus((byte)2);
							dcVersionSelectService.updateDcVersionSelect(versionSelect);
						}
						//记录日志(公开)
						mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"公开藏品");
					}
					return "1";
				}else {
					return "0";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			}
		}
	
	// 批量公开(2019年1月1日修改)
		@RequestMapping("/publishByType.do")
		@ResponseBody
		@AuthPassport
		public String publishByType(String[] ids,String type) throws MyException {
			//发布时需要删除首页缓存
			JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
			if("2".equals(type)){//馆际公开
				return publishAllNew(ids);
			}else if("3".equals(type)){//公众服务公开
				return publishToOpen(ids);	
			}else if("4".equals(type)){//全部公开
				return publishToAll(ids);	
			}else{
				return "0";
			}
		}
		@RequestMapping("/publishToOpen.do")
		@ResponseBody
		@AuthPassport
		//批量公开至公众服务
		public String publishToOpen(String[] ids) throws MyException{
			JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
			try {				
				if (!MyString.isEmpty(ids)) {
					MipOpenCulturalrelicInfoApproval approval = new MipOpenCulturalrelicInfoApproval();
					String objectId = IdUtils.nextId(approval);
					approval.setId(objectId);
					int collectionNumber = ids.length;
					approval.setApplyCollectCount(collectionNumber);
					UserDto user = (UserDto)this.session.getAttribute("user");
			    	String orgId = user.getOrgId();
			    	approval.setApplyDept(orgId);
			    	approval.setApplyTime(new Date());
			    	approval.setCreatetime(new Date());
			    	approval.setUpdateTime(new Date());
			    	approval.setUpdaterId(Tools.getUserId());
			    	approval.setCreatorId(Tools.getUserId());
			    	approval.setStatus((byte)1);
			    	approval.setExt1("1");
			    	JsonResult jsonResult = mipOpenCulturalrelicInfoApprovalService.addApprovalInfo(approval);
			    	if(jsonResult.getSuccess()==1){
			    		JsonResult jsonResult2 = mipOpenCulturalrelicInfoApprovalService.batchAddApprovalRel(ids,objectId,"1");
			    		if(jsonResult2.getSuccess()==1){
			    			return "1";		
			    		}else{
			    			return "0";
			    		}
			    	}else{
			    		return "0";
			    	}
				}else {
					return "0";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			}
			
		}
		@RequestMapping("/publishToAll.do")
		@ResponseBody
		@AuthPassport
		//批量公开至公众服务和馆际公开库
		public String publishToAll(String[] ids){
			try {
				String gjResult = publishAllNew(ids);
				String isResult = publishToOpen(ids);
				if(gjResult.equals("1") && isResult.equals("1")){
					return "1";
				}else{
					return "0";
				}
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "0";
			}
			
		}

	// 公开
	@RequestMapping("/publish.do")
	@ResponseBody
	@AuthPassport
	public String publish(String[] ids) throws MyException {
		//发布时需要删除首页缓存
		JedisService.del(KeyConstants.HOME_PAGE_DATA_KEY);
		try {
			// 获取藏品
			if (!MyString.isEmpty(ids)) {
				for (String id : ids) {
					MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
					// 如果为空
					if (MyString.isEmpty(mipOpenCulturalrelicInfo.getPictureIds())) {
						return "-1";
					}
					mipOpenCulturalrelicInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
					// 不为空，更新
					mipOpenCulturalrelicInfo.setIsOpen((byte) 2);
					mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
					//保存到公开表中
					MipOpenCollectionInfo save = saveMipOpenCollectionInfo(mipOpenCulturalrelicInfo);
					// 更新es
					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
					updateES(mipOpenCulturalrelicInfoBLOBs);
					//添加水印
					addWaterMark(save);
					//条件表中相应藏品数+1 或 增加条件
					conditionAdd(save);
					//相关表藏品数目+1
					numberAdd(mipOpenCulturalrelicInfo);
					//公开时更新版本查询表状态为2（需送审时 1 账号同意时执行此方法  2 3权限账号不执行此方法）
					DcVersionSelect versionSelect = dcVersionSelectService.selectByCollectionId(mipOpenCulturalrelicInfoBLOBs.getId());
					if(!MyString.isEmpty(versionSelect)){
						versionSelect.setStatus((byte)2);
						dcVersionSelectService.updateDcVersionSelect(versionSelect);
					}
					//记录日志(公开)
					mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"公开藏品");
					return "1";
				} 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	private void addWaterMark(MipOpenCollectionInfo info) throws FileNotFoundException, IOException {
		String orgId = info.getCollectionUnit();
		//水印地址
		String waterMarkPath = JedisService.get(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId));
		waterMarkPath = StringUtils.isBlank(waterMarkPath) ? Constants.DEFAULT_WATER_MARK_IMT_PATH : waterMarkPath;
		//拼接水印图片的地址
		String rootPath = config.getRootPath();
		String wartmarkPathSource = rootPath + waterMarkPath;
		BufferedImage watermarkImagePath = null;
		if (!new File(wartmarkPathSource).exists()) {
			return;
		}
		watermarkImagePath = ImageIO.read(new FileInputStream(wartmarkPathSource));
		//获取藏品图片的id
		String pictureIds = info.getPictureIds();
		if (!MyString.isEmpty(pictureIds)) {
			String[] idArray = pictureIds.split(",");
			for (String id : idArray) {
				Picture picture = pictureService.get(id);
				if (!MyString.isEmpty(picture)) {
					//获取图片地址
					String url = picture.getUrl();
					//url = url.replace("_wm.", ".");
					if(url.indexOf("_wm.") != -1){
						url = picture.getThumb6();
					}
					//拼接图片真实地址
					String realPath = rootPath + url;
					//拼接图片保存地址
					String imgWithWatermark = url.replace(".", "_wm.");
					String savePath = rootPath + imgWithWatermark;
					//添加水印
					boolean exists_realPath = new File(realPath).exists();
					if (!MyString.isEmpty(watermarkImagePath) && exists_realPath) {
						ImageHepler.changePictureAddWatermark(realPath, savePath, watermarkImagePath);
						//数据库url换有水印的，原图存到thumb6中
						picture.setThumb6(url);
						picture.setUrl(imgWithWatermark);
						pictureService.update(picture);
					}

				}
			}
		}
	}

	private void addWaterMark(MipOpenCulturalrelicInfo info) throws FileNotFoundException, IOException {
		String orgId = info.getCollectionUnit();
		//水印地址
		String waterMarkPath = JedisService.get(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId));
		waterMarkPath = StringUtils.isBlank(waterMarkPath) ? Constants.DEFAULT_WATER_MARK_IMT_PATH : waterMarkPath;
		//拼接水印图片的地址
		String rootPath = config.getRootPath();
		String wartmarkPathSource = rootPath + waterMarkPath;
		BufferedImage watermarkImagePath = null;
		if (!new File(wartmarkPathSource).exists()) {
			return;
		}
		watermarkImagePath = ImageIO.read(new FileInputStream(wartmarkPathSource));
		//获取藏品图片的id
		String pictureIds = info.getPictureIds();
		if (!MyString.isEmpty(pictureIds)) {
			String[] idArray = pictureIds.split(",");
			for (String id : idArray) {
				Picture picture = pictureService.get(id);
				if (!MyString.isEmpty(picture)) {
					//获取图片地址
					String url = picture.getUrl();
					//url = url.replace("_wm.", ".");
					if(url.indexOf("_wm.") != -1){
						url = picture.getThumb6();
					}
					//拼接图片真实地址
					String realPath = rootPath + url;
					//拼接图片保存地址
					String imgWithWatermark = url.replace(".", "_wm.");
					String savePath = rootPath + imgWithWatermark;
					//添加水印
					boolean exists_realPath = new File(realPath).exists();
					if (!MyString.isEmpty(watermarkImagePath) && exists_realPath) {
						ImageHepler.changePictureAddWatermark(realPath, savePath, watermarkImagePath);
						//数据库url换有水印的，原图存到thumb6中
						picture.setThumb6(url);
						picture.setUrl(imgWithWatermark);
						pictureService.update(picture);
					}

				}
			}
		}
	}
	
	// 批量不公开
	@RequestMapping("/nonPublishAll.do")
	@ResponseBody
	@AuthPassport
	public String nonPublishAll(String[] ids) throws MyException {
		try {
			for (String id : ids) {
				// 获取藏品
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				// 设置公开
				/*if (MyString.isEmpty(mipOpenCulturalrelicInfo.getPictureIds())) {
					return "-1";
				}*/
				mipOpenCulturalrelicInfo.setIsOpen((byte) 1);
				// 更新
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				// 更新es
				MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
				mipOpenCulturalrelicInfoBLOBs.setIsOpen((byte) 1);
				updateES(mipOpenCulturalrelicInfoBLOBs);
				//删除公开表数据
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
					mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
					//条件表藏品数减一或删除
					conditionDec(mipOpenCollectionInfo);
				}

				//相关表藏品数目-1
				numberDec(mipOpenCulturalrelicInfo);
				//记录日志(取消公开)
				mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"取消公开");
				return "1";
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	private boolean updateES(MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfo) {
		//es-------
		mipOpenCulturalrelicInfo.setDescription("".equals(mipOpenCulturalrelicInfo.getDescription())? null:mipOpenCulturalrelicInfo.getDescription());
		ESModel em = new ESModel();
		em.setType("mipopenculturalrelicinfo");
		em.setId(mipOpenCulturalrelicInfo.getId());
		em.setJsonString(JSON.toJSONString(mipOpenCulturalrelicInfo));
		boolean addDocument = esSearchDao.modifyDocument(em, null);
		return addDocument;
		//es-------
	}
	private boolean addES(MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfo) {
		//es-------
		mipOpenCulturalrelicInfo.setDescription("".equals(mipOpenCulturalrelicInfo.getDescription())? null:mipOpenCulturalrelicInfo.getDescription());
		ESModel em = new ESModel();
		em.setType("mipopenculturalrelicinfo");
		em.setId(mipOpenCulturalrelicInfo.getId());
		em.setJsonString(JSON.toJSONString(mipOpenCulturalrelicInfo));
		boolean addDocument = esSearchDao.addDocument(em, null);
		return addDocument;
		//es-------
	}
	//es删除
	private boolean removeES(String id){
		//es-------
		ESModel em = new ESModel();
		em.setType("mipopenculturalrelicinfo");
		em.setId(id);
		boolean addDocument = esSearchDao.deleteById(em);
		return addDocument;
		//es-------
	}
	private boolean addStatisti(MipOpenCulturalrelicInfo moci) {
		MipStatistics mipStatistics = new MipStatistics();
		mipStatistics.setCollectionLevel(moci.getCollectionLevel());
		mipStatistics.setCollectionsCategory(moci.getCollectionsCategory());
		mipStatistics.setCollectionUnit(moci.getCollectionUnit());
		mipStatistics.setEndResidueLevel(moci.getEndResidueLevel());
		mipStatistics.setGsEntryWarehouseTimeFrame(moci.getGsEntryWarehouseTimeFrame());
		mipStatistics.setGsSource(moci.getGsSource());
		mipStatistics.setGsStorageState(moci.getGsStorageState());
		mipStatistics.setYearType(moci.getYearType());
		int updateStatistics = mipStatisticsService.updateStatistics(mipStatistics);
		if(updateStatistics > 0) {
			return true;
		}
		return false;
	}
	private boolean modifyStatisti(MipOpenCulturalrelicInfo moci) {
		MipStatistics mipStatistics = new MipStatistics();
		mipStatistics.setCollectionLevel(moci.getCollectionLevel());
		mipStatistics.setCollectionsCategory(moci.getCollectionsCategory());
		mipStatistics.setCollectionUnit(moci.getCollectionUnit());
		mipStatistics.setEndResidueLevel(moci.getEndResidueLevel());
		mipStatistics.setGsEntryWarehouseTimeFrame(moci.getGsEntryWarehouseTimeFrame());
		mipStatistics.setGsSource(moci.getGsSource());
		mipStatistics.setGsStorageState(moci.getGsStorageState());
		mipStatistics.setYearType(moci.getYearType());
		Integer updateStatistics = mipStatisticsService.updateStatisticsSub(mipStatistics);
		if(updateStatistics > 0) {
			return true;
		}
		return false;
	}
	// 不公开
	@RequestMapping("/nonPublish.do")
	@ResponseBody
	@AuthPassport
	public String nonPublish( String[] ids) throws MyException {
		try {
			// 获取藏品
			if (!MyString.isEmpty(ids)) {
				for (String id : ids) {
					MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
					if (MyString.isEmpty(mipOpenCulturalrelicInfo.getId())) {
						return "0";
					}
					// 如果为空
					/*if (MyString.isEmpty(mipOpenCulturalrelicInfo.getPictureIds())) {
					return "-1";
				}*/

					// 不为空，更新
					mipOpenCulturalrelicInfo.setIsOpen((byte) 1);
					mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
					// 更新es
					MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
					mipOpenCulturalrelicInfoBLOBs.setIsOpen((byte) 1);
					updateES(mipOpenCulturalrelicInfoBLOBs);
					//删除公开表数据
					MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
					if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
						mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
						//条件表藏品数减一或删除
						conditionDec(mipOpenCollectionInfo);
					}
					//相关表藏品数目-1
					numberDec(mipOpenCulturalrelicInfo);
					//记录日志(取消公开)
					mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"取消公开");
					return "1";
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	// 删除
	@RequestMapping(value = "/del.do")
	@ResponseBody
	@AuthPassport
	public String del(String[] ids) throws MyException {
		try {
			for (String id : ids) {
				// 获取对象
				MipOpenCulturalrelicInfo model = mipOpenCulturalrelicInfoService.get(id);
				MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
				if (!MyString.isEmpty(model.getId())) {
					// 设置状态（-127）
					//					model.setStatus((byte) -127);
					//					mipOpenCulturalrelicInfoService.update(model);//修改
					// 删除并保存到删除表中
					mipOpenCulturalrelicInfoService.delete(model);//真删除
					//保存到删除表
					MipDeleteCulturalrelicInfo mdci = new MipDeleteCulturalrelicInfo();
					mdci.setActualQuantity(model.getActualQuantity());
					mdci.setActualQuantityUnit(model.getActualQuantityUnit());
					mdci.setAssessor(model.getAssessor());
					mdci.setCheckState(model.getCheckState());
					mdci.setClickCounts(model.getClickCounts());
					mdci.setCollectedCounts(model.getCollectedCounts());
					mdci.setCollectionLevel(model.getCollectionLevel());
					mdci.setCollectionPlace(model.getCollectionPlace());
					mdci.setCollectionsCategory(model.getCollectionsCategory());
					mdci.setCollectionType(model.getCollectionType());
					mdci.setCollectionUnit(model.getCollectionUnit());
					mdci.setCreateTime(model.getCreateTime());
					mdci.setCreator(model.getCreator());
					mdci.setDescription(model.getDescription());
					mdci.setDwid(model.getDwid());
					mdci.setEndResidualCondition(model.getEndResidualCondition());
					mdci.setEndResidueLevel(model.getEndResidueLevel());
					mdci.setfAudio(model.getfAudio());
					mdci.setfCreateDept(model.getfCreateDept());
					mdci.setFKey(model.getFKey());
					mdci.setForeignName(model.getForeignName());
					mdci.setFormerly(model.getFormerly());
					mdci.setFpic(model.getFpic());
					mdci.setFpicHeight(model.getFpicHeight());
					mdci.setFpicWidth(model.getFpicWidth());
					mdci.setfVideo(model.getfVideo());
					mdci.setGsAuthor(model.getGsAuthor());
					mdci.setGsCollectionsNo(model.getGsCollectionsNo());
					mdci.setGsCollectionsNoType(model.getGsCollectionsNoType());
					mdci.setGsEntryMeseumTime(model.getGsEntryMeseumTime());
					mdci.setGsEntryWarehouseTimeFrame(model.getGsEntryWarehouseTimeFrame());
					mdci.setGsEntryWarehouseYear(model.getGsEntryWarehouseYear());
					mdci.setGsHeight(model.getGsHeight());
					mdci.setGsKeepOnFile(model.getGsKeepOnFile());
					mdci.setGsLength(model.getGsLength());
					mdci.setGsNo(model.getGsNo());
					mdci.setGsSource(model.getGsSource());
					mdci.setGsSpecificYear(model.getGsSpecificYear());
					mdci.setGsStorageState(model.getGsStorageState());
					mdci.setGsStorageType(model.getGsStorageType());
					mdci.setGsTexture(model.getGsTexture());
					mdci.setGsTextureCategory(model.getGsTextureCategory());
					mdci.setGsTextureSubcategories(model.getGsTextureSubcategories());
					mdci.setGsVersion(model.getGsVersion());
					mdci.setGsWidth(model.getGsWidth());
					mdci.setIndexName(model.getIndexName());
					mdci.setIsHighQuality(model.getIsHighQuality());
					mdci.setIsOpen(model.getIsOpen());
					mdci.setMass(model.getMass());
					mdci.setMassRange(model.getMassRange());
					mdci.setMassUnit(model.getMassUnit());
					mdci.setName(model.getName());
					mdci.setPictureIds(model.getPictureIds());
					mdci.setPicUrl(model.getPicUrl());
					mdci.setRemark(model.getRemark());
					mdci.setRingBeatData(model.getRingBeatData());
					mdci.setSelectCounts(mdci.getSelectCounts());
					mdci.setSequence(model.getSequence());
					mdci.setSize(model.getSize());
					mdci.setStatus(model.getStatus());
					mdci.setSubmitTime(model.getSubmitTime());
					mdci.setThreeDimensionalCollection(model.getThreeDimensionalCollection());
					mdci.setYearType(model.getYearType());

					mipDeleteCulturalrelicInfoService.save(mdci);
				}
				//公开表相应作删除
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				if (!MyString.isEmpty(mipOpenCollectionInfo.getId())) {
					//					 设置状态（-127）
					mipOpenCollectionInfo.setStatus((byte) -127);
					mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
					//					真删除
					mipOpenCollectionInfoService.delete(mipOpenCollectionInfo);
					//					查询条件表中关联的藏品数,并将条件表中数据减1或删除
					conditionDec(mipOpenCollectionInfo);
				}
				//es删除
				removeES(id);
				//es删除结束

				//相关表藏品数目-1
				numberDec(model);

				//记录日志(删除)
				mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"删除藏品");
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	// 置顶
	@RequestMapping("/top.do")
	@ResponseBody
	@AuthPassport
	public String top(String[] ids) throws MyException {

		try {
			// 获取藏品
			for (String id : ids) {
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				// 更新
				mipOpenCulturalrelicInfo.setSequence(100);
				mipOpenCulturalrelicInfo.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				//更新公开表
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				if (StringUtils.isNotBlank(mipOpenCollectionInfo.getId())) {
					mipOpenCollectionInfo.setSequence(100);
					mipOpenCollectionInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
					mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
				}
				// 更新es
				MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
				updateES(mipOpenCulturalrelicInfoBLOBs);
				//记录日志(置顶)
				mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"置顶");
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
	@AuthPassport
	public String down(String[] ids) throws MyException {
		try {
			for (String id : ids) {

				// 获取藏品
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				// 更新
				mipOpenCulturalrelicInfo.setSequence(50);
				mipOpenCulturalrelicInfo.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				//更新公开表
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(id);
				if (StringUtils.isNotBlank(mipOpenCollectionInfo.getId())) {
					mipOpenCollectionInfo.setSequence(50);
					mipOpenCollectionInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
					mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
				}
				// 更新es
				MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
				updateES(mipOpenCulturalrelicInfoBLOBs);
				//记录日志(取消置顶)
				mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"取消置顶");
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
	@AuthPassport
	public String setMain(String picId, String collectionId) throws MyException {
		try {
			// 查询藏品的所有图片
			MipOpenCulturalrelicInfo moci = mipOpenCulturalrelicInfoService.get(collectionId);
			pictureService.update(
					"update Picture set isMain = 1 where objectId='" + collectionId + "' and status>0",
					Tools.getMap());

			Picture pic = pictureService.get(picId);
			// 获取新主图存放路径
			String url = pic.getUrl();
			url = url.replace("_wm.", ".");
			String rootPath = config.getRootPath();
			String imagePath = rootPath + url;
			// 设置缩略图的存放路径路径
			int lastIndexOf = url.lastIndexOf("/");
			String substring = url.substring(0, lastIndexOf);
			String imageName = url.substring(lastIndexOf + 1);

			if (MyString.isEmpty(pic.getThumb1())) {
				// 藏品详情页大图C1（640*426）
				String thumbUrl1 = substring + "/640x426_" + imageName;
				String thumbnailPath1 = rootPath + thumbUrl1;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C2_640.png";
					//				 File file1 =new File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C2_640.png");
					//					BufferedImage watermarkImagePath1 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath1 = null;
					// 生成缩略图
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath1, 640, 426,watermarkImagePath1);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}else {
					// 生成缩略图
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath1, 640, 426, null);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}
			}

			if (MyString.isEmpty(pic.getThumb2())) {
				// 藏品详情页相关图等C2（278*）
				String thumbUrl2 = substring + "/278x_" + imageName;
				String thumbnailPath2 = rootPath + thumbUrl2;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C1_278.png";
					// File file1 =new
					// File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C1_278.png");
					//					BufferedImage watermarkImagePath2 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath2 = null;
					// 生成缩略图
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath2, 278,
							0, watermarkImagePath2);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}else {
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(imagePath, thumbnailPath2, 278,
							0, null);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}
			}

			if (MyString.isEmpty(pic.getThumb3())) {
				// 藏品详情页相关图等C1（192*128）
				String thumbUrl3 = substring + "/192x128_" + imageName;
				String thumbnailPath3 = rootPath + thumbUrl3;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C3_192.png";
					//					File file1 =new File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C3_192.png");
					//					BufferedImage watermarkImagePath3 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath3 = null;
					// 生成缩略图
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
			MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(collectionId);
			mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"更换主图,picId:"+picId);
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
	@AuthPassport
	public String deletePic(String picId) throws MyException {
		try {
			//删除图片
			if (!MyString.isEmpty(picId)) {
				//判|断图片的type是否为1和2，1和2不可以删除
				Picture picture = pictureService.get(picId);
				if(!MyString.isEmpty(picture)){
					if ("1".equals(picture.getTypeId()) || "2".equals(picture.getType())) {
						return "2";//此图不可以删除
					}
					String objectId = picture.getObjectId();//所属藏品id
					//删除图片
					pictureService.delete(picture);
					//删除藏品中pictureIds中的图片id
					if (!MyString.isEmpty(objectId)) {
						MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(objectId);
						if (!MyString.isEmpty(mipOpenCulturalrelicInfo)) {
							String pictureIds = mipOpenCulturalrelicInfo.getPictureIds();
							if (!MyString.isEmpty(pictureIds)) {
								//将原图片id设置为空 ,同时去掉多余的逗号
								pictureIds = pictureIds.replace(picId, "").replace(",,", ",").replaceFirst("^,", "").replaceFirst(",$", "");
								mipOpenCulturalrelicInfo.setPictureIds(pictureIds);
								mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
								//记录日志(删除图片)
								MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(objectId);
								mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"删除图片,picId:"+picId);
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




	@RequestMapping("/changeSequence.do")
	@ResponseBody
	@AuthPassport
	public JsonResult changeSequence(@RequestParam String id, @RequestParam String changeId) throws MyException {
		MipOpenCulturalrelicInfo change = mipOpenCulturalrelicInfoService.get(changeId);
		MipOpenCulturalrelicInfo model = mipOpenCulturalrelicInfoService.get(id);

		int modelSequence = model.getSequence();

		model.setSequence(change.getSequence());
		change.setSequence(modelSequence);

		mipOpenCulturalrelicInfoService.update(model);
		mipOpenCulturalrelicInfoService.update(change);
		return new JsonResult(1, null);
	}

	/**
	 * 级联
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/sltMuseum.do")
	@ResponseBody
	@AuthPassport
	public List<MipOrganization> getCollectionInfo(@RequestParam(name = "parentId") String id) {
		String hql = "";
		if (!MyString.isEmpty(id)) {
			hql = "from MipOrganization where status>0 and isdelete=0 and parentId=" + id;
		}else {
			hql = "from MipOrganization where 1 <> 1";
		}
		List<MipOrganization> museumList2 = (List<MipOrganization>) mipOrganizationService.queryByHql(hql,
				Tools.getMap());
		return museumList2;
	}

	/**
	 * 相关表藏品书+1
	 * @param moci
	 */
	public void numberAdd(MipOpenCulturalrelicInfo moci){
		//在组织机构表中，藏品数目+1
		String collectionUnit = moci.getCollectionUnit();
		if (!MyString.isEmpty(collectionUnit)) {
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnit);
			mipOrganization.setCollectionCount(mipOrganization.getCollectionCount()+1);
			if (mipOrganization.getParentId().equals("")) {
				mipOrganization.setParentId("0");
			}
			mipOrganizationService.update(mipOrganization);
		}
		//在年代表中，藏品数目+1
		String yearType = moci.getYearType();
		if (!MyString.isEmpty(yearType)) {
			YearType yt = yearTypeService.get(yearType);
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
	public void numberDec(MipOpenCulturalrelicInfo moci){
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

	@RequestMapping(value = "/insertColl.do")
	@AuthPassport
	public void insertColl() throws MyException {
		int j = 0;
		for (int i = 0; i < 3000000; i++) {
			mipOpenCulturalrelicInfoService.deleteBySql("INSERT INTO `mip_open_culturalrelic_info` (`id`, `collection_unit`, `dwid`, `gs_No`, `fPic`, `fPic_width`, `fPic_height`, `gs_collectionsNo_type`, `gs_collectionsNo`, `collection_type`, `name`, `formerly`, `foreign_name`, `year_type`, `gs_specific_year`, `collections_category`, `gs_texture_category`, `gs_texture_subcategories`, `gs_texture`, `actual_quantity_unit`, `actual_quantity`, `gs_length`, `gs_width`, `gs_height`, `size`, `mass_range`, `mass`, `mass_unit`, `collection_level`, `gs_source`, `collection_place`, `end_residue_level`, `end_residual_condition`, `gs_storage_type`, `gs_storage_state`, `gs_entry_warehouse_time_frame`, `gs_entry_warehouse_year`, `gs_entry_warehouse_time`, `gs_author`, `gs_version`, `gs_keep_on_file`, `picture_ids`, `creator`, `is_high_quality`, `is_open`, `remark`, `description`, `assessor`, `f_create_dept`, `f_key`, `three_dimensional_collection`, `ring_beat_data`, `f_video`, `f_audio`, `f_museum_id`, `check_state`, `click_counts`, `select_counts`, `collected_counts`, `submitTime`, `updated_time`, `createTime`, `status`, `sequence`) VALUES(UUID(), '251', '', '', '', 0, 0, '', '', '0', '颂簋', '', '', '49', '', '4', '', '', '', '', 1, 0, 0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '21232d7a-64a5-44c3-8b1c-f69c305e4ca9', '', 1, 2, '', '西周（约公元前11世纪——公元前771年）\r\n通高30.1、口径24.2厘米\r\n盛食器。圆盖圆腹，子母口，盖顶部有圆形捉手。双耳作兽首形，有珥。圈足下有三小足。器、盖口沿饰窃曲纹，腹与盖上部饰瓦纹，足部为垂鳞纹。铭文15行152字，记述周王册命颂为监造新宫的官吏，并赏以官服、旗帜等事。与颂壶、颂钟并称“三颂”。铭文收录于郭沫若《两周金文辞大系》，既为西周时期的优秀书法作品，又有较高的史料价值，值得珍视', '', '', '', 'http://192.168.2.201/files/3d/01.html', '', '', 'back/audio/c2d051b8b8034e6c9b25369e17334aef.OGG', '', 0, 100, 0, 0, '2017-03-27 06:17:54', '2017-04-20 05:45:56', '2017-03-23 05:57:51', 1, 100);");
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
	 * 将（新）条件表中符合条件的藏品数+1或增加一条数据
	 * @param mipOpenCollectionInfo
	 */
	public void conditionAdd(MipOpenCulturalrelicInfo mipOpenCollectionInfo) {
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
	 * 将原文物藏品带id保存到公开表
	 * @param mipOpenCulturalrelicInfo
	 * @return
	 */
	public MipOpenCollectionInfo saveMipOpenCollectionInfo(MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo) {
		MipOpenCollectionInfo mipOpenCollectionInfo = new MipOpenCollectionInfo();
		mipOpenCollectionInfo.setId(mipOpenCulturalrelicInfo.getId());
		mipOpenCollectionInfo.setName(mipOpenCulturalrelicInfo.getName());
		mipOpenCollectionInfo.setGsNo(mipOpenCulturalrelicInfo.getGsNo());
		mipOpenCollectionInfo.setCollectionUnit(mipOpenCulturalrelicInfo.getCollectionUnit());
		mipOpenCollectionInfo.setCollectionLevel(mipOpenCulturalrelicInfo.getCollectionLevel());
		mipOpenCollectionInfo.setYearType(mipOpenCulturalrelicInfo.getYearType());
		mipOpenCollectionInfo.setCollectionsCategory(mipOpenCulturalrelicInfo.getCollectionsCategory());
		mipOpenCollectionInfo.setDescription(mipOpenCulturalrelicInfo.getDescription());
		mipOpenCollectionInfo.setfAudio(mipOpenCulturalrelicInfo.getfAudio());
		mipOpenCollectionInfo.setfVideo(mipOpenCulturalrelicInfo.getfVideo());
		mipOpenCollectionInfo.setThreeDimensionalCollection(mipOpenCulturalrelicInfo.getThreeDimensionalCollection());
		mipOpenCollectionInfo.setPictureIds(mipOpenCulturalrelicInfo.getPictureIds());
		mipOpenCollectionInfo.setClickCounts(mipOpenCulturalrelicInfo.getClickCounts());
		mipOpenCollectionInfo.setCollectedCounts(mipOpenCulturalrelicInfo.getCollectedCounts());
		mipOpenCollectionInfo.setUpdatedTime(mipOpenCulturalrelicInfo.getSubmitTime());
		mipOpenCollectionInfo.setIsHighQuality(mipOpenCulturalrelicInfo.getIsHighQuality());
		mipOpenCollectionInfo.setCollectionType(mipOpenCulturalrelicInfo.getCollectionType());
		mipOpenCollectionInfo.setCreateTime(mipOpenCulturalrelicInfo.getCreateTime());
		mipOpenCollectionInfo.setStatus(mipOpenCulturalrelicInfo.getStatus());
		mipOpenCollectionInfo.setSequence(mipOpenCulturalrelicInfo.getSequence());
		mipOpenCollectionInfo.setRingBeatData(mipOpenCulturalrelicInfo.getRingBeatData());
		MipOpenCollectionInfo save = mipOpenCollectionInfoService.save(mipOpenCollectionInfo);
		return save;
	}
	/**
	 * 批量下载图片zip
	 * @param request
	 * @param response
	 * @param mipOpenCulturalrelicInfo
	 */
	@RequestMapping("/exportPicture.do")
	@AuthPassport
	public void exportPicture(HttpServletRequest request,HttpServletResponse response,@ModelAttribute MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo) {
		ArrayList<Picture> pictures = new ArrayList<Picture>();
		pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where objectId = '" + mipOpenCulturalrelicInfo.getId() + "' and status >= 0 order by isMain desc,url",Tools.getMap());
		//重设图片访问路径
		List<File> files = new ArrayList<>();
		if (!MyString.isEmpty(pictures)) {
			for (Picture picture : pictures) {
				picture.setUrl(config.getRootPath()+picture.getUrl());
				picture.setThumb1(config.getRootPath()+picture.getThumb1());
				picture.setThumb2(config.getRootPath()+picture.getThumb2());
				picture.setThumb3(config.getRootPath()+picture.getThumb3());
				files.add(new File(picture.getUrl()));
				files.add(new File(picture.getThumb1()));
				files.add(new File(picture.getThumb2()));
				files.add(new File(picture.getThumb3()));
			}
		}
		//		files.add(new File("D://1.JPG"));
		//		files.add(new File("D://2.JPG"));
		try {
			ImageToZip.downLoadFiles(files, config.getRootPath()+mipOpenCulturalrelicInfo.getName(), request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 弹出讲解词新增
	 * @return
	 */
	@RequestMapping("/addView.do")
	@AuthPassport
	public ModelAndView audioAddView(String id) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/collection/open/audio.jsp");
		MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
		MipCollectionAudio officeAudio = mipCollectionAudioService.getOfficialAudio(id, (byte)1);
		if(!MyString.isEmpty(officeAudio)) {
			modelAndView.addObject("audioUrl",config.getImageUrl()+officeAudio.getUrl());
			modelAndView.addObject("audioRootUrl",officeAudio.getUrl());
		}
		modelAndView.addObject("culturalrelic",mipOpenCulturalrelicInfoBLOBs);
		return modelAndView;
	}
	/**
	 * 保存讲解词
	 * @param description
	 * @param fAudio
	 * @param id
	 * @return
	 * @throws MalformedURLException 
	 */
	@RequestMapping("/saveView.do")
	@ResponseBody
	@AuthPassport
	public JsonResult saveAddView(String description,String fAudio,String id) throws MalformedURLException {
		MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
		mipOpenCulturalrelicInfo.setDescription(description);
		mipOpenCulturalrelicInfo.setfAudio(fAudio);
		mipOpenCulturalrelicInfo
		.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
		//mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
		if(MyString.isEmpty(fAudio)) {
			collectionAudio(mipOpenCulturalrelicInfo);
		}else {
			//URL audioUrl = new URL(fAudio);audioUrl.getPath().substring(1)
			MipCollectionAudio audio = constractorAudio(mipOpenCulturalrelicInfo.getName(),fAudio,mipOpenCulturalrelicInfo.getId(),"",(byte)1);
			mipCollectionAudioService.insertAudio(audio);
		}
		mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
		MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
		updateES(mipOpenCulturalrelicInfoBLOBs);
		//记录日志(保存讲解词)
		mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"保存讲解词");
		return new JsonResult(1,"ok");
	}

	/**
	 * 保存讲解词信息
	 */
	private void collectionAudio(MipOpenCulturalrelicInfo culturalrelicInfo){
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
