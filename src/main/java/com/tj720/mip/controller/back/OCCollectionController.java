package com.tj720.mip.controller.back;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
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
import com.tj720.admin.dao.es.EsSearchDao;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoMapper;
import com.tj720.admin.model.DcBorrow;
import com.tj720.admin.model.DcVersionContent;
import com.tj720.admin.model.DcVersionSelect;
import com.tj720.admin.model.ESModel;
import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipStatistics;
import com.tj720.admin.service.DcBorrowService;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.DcVersionSelectService;
import com.tj720.admin.service.MipCollectionAudioService;
import com.tj720.admin.service.MipLogService;
import com.tj720.admin.service.MipStatisticsService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.common.dto.ImageTranslateDto;
import com.tj720.mip.constant.Constants;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
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
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipYearCategory;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.ImageToZip;
import com.tj720.mip.utils.KdxfUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/back/oCCollection")
public class OCCollectionController extends BaseController<MipOpenCulturalrelicInfo> {
	
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private MipOpenCulturalrelicInfoMapper mipOpenCulturalrelicInfoMapper;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
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
	/**
	 * 
	 * @param key
	 * @param mipOpenCulturalrelicInfo
	 * @param erea
	 * @param size
	 * @param currentPage
	 * @param order
	 * @return
	 * @throws MyException
	 *             加载文物列表信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/info.do")
	@ResponseBody
	@AuthPassport(authority="collectionCommon")
	public ModelAndView getCollectionInfo(String key, String gsNo,String levelStatus, @ModelAttribute MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo,
			String erea, @RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "createTime") String order,@RequestParam(defaultValue = "0")int type) throws MyException {
		System.out.println("·····················藏品查询测试速度开始····················");
		long startTime_redis = System.currentTimeMillis();//redis开始时间
		ModelAndView mod = null;
		if(1==type){
			mod = new ModelAndView("/WEB-INF/back/collection/trends/dcwwlist.jsp");
		}else{
			mod = new ModelAndView("/WEB-INF/back/collection/open/wwlist.jsp");
		}
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
		// 缓存查询
		String listKey = MessageFormat.format(KeyConstants.COLLECTION_INFO_LIST_KEY, orgId,type);
		String jsonStr =JedisService.get(listKey);
		if(StringUtils.isNotBlank(jsonStr)) {
			mod = JSON.parseObject(jsonStr, ModelAndView.class);
			long endTime_redis = System.currentTimeMillis();//redis结束时间
			System.out.println("redis查询运行时间："+(endTime_redis-startTime_redis)+"ms");
		} else {
			long startTime_noredis = System.currentTimeMillis();//没有使用redis开始时间
			MipOrganization org = mipOrganizationService.get(orgId);
			//查询组织机构的级别
			byte level = org.getLevel();
			mod.addObject("level", level);
			// 创建map集合，放置查询对象
			// Map<String, Object> map = new HashMap<String, Object>();
			// 查询年代集合
			String hql_yearType = "from YearType yt where (yt.code not like '1%' and yt.code <> '200000' and yt.code <> '300000' and yt.code <> '400000') and openCounts > 0 order by yt.code";
			List<YearType> ytList = (List<YearType>) mipOpenCulturalrelicInfoService.queryByHql(hql_yearType,
					Tools.getMap());
			mod.addObject("ytList", ytList);
	
			// 查询文物类别集合
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService
					.queryByHql("from CollectionCategory cc where cc.openCounts>0 and cc.type LIKE '文物%' order by sequence desc", Tools.getMap());
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
			
	
			// 查询组织机构（博物馆）的集合
			if (erea != null && !"".equals(erea)) {
				List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where parentId=" + erea
								+ " and level=3 and status>0 and isdelete=0 order by sequence", Tools.getMap());
				mod.addObject("musList", musList);
			}
	
			// 查询吉林所有博物馆集合
			List<MipOrganization> museums = (List<MipOrganization>) mipOrganizationService.queryByHql(
					"from MipOrganization where platformId="+config.getPlatformId()+" and level=3 and status>0 and isdelete=0 order by sequence desc",
					Tools.getMap());
			mod.addObject("museums", museums);
			// 加入redis
			jsonStr = JSON.toJSONString(mod);
			JedisService.set(listKey, jsonStr, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
			long endTime_noredis = System.currentTimeMillis();//没有使用redis开始时间
			System.out.println("没有使用redis查询运行时间："+(endTime_noredis-startTime_noredis)+"ms");
		}
		long stateTime_thirdly = System.currentTimeMillis();//附加条件开始时间
		Object level = mod.getModel().get("level");
			// 查询文物藏品列表
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
	
	//		String hql = "select new MipOpenCulturalrelicInfo(id,pictureIds,collectionUnit,gsNo,gsCollectionsNo,name,yearType,collectionsCategory,gsTexture,collectionLevel,isHighQuality,isOpen) from MipOpenCulturalrelicInfo where";
			String hql = "select new MipOpenCulturalrelicInfo(id,pictureIds,collectionUnit,gsNo,gsCollectionsNo,name,yearType,collectionsCategory,gsTexture,collectionLevel,isHighQuality,isOpen,sequence,status,description) from MipOpenCulturalrelicInfo where";
			
			String[] orgIdsEs = null;
			ESModel em = new ESModel();
			//通过判断用户级别查询
			if ("0".equals(level.toString())) {
				//全国
			}
			/*if (level == 1) {
				//省级
				//查询省级下所有市
				String orgIds = "";
				List<MipOrganization> cityArrayList = (List<MipOrganization>) mipOpenCulturalrelicInfoService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
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
					List<MipOrganization> orgList = (List<MipOrganization>) mipOpenCulturalrelicInfoService.queryByHql("from MipOrganization where parentId in (" + cityIds + ")", Tools.getMap());
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
			if ("2".equals(level.toString())) {
				//市级
				String orgIds = "";
				List<MipOrganization> cityArrayList = (List<MipOrganization>) mipOpenCulturalrelicInfoService.queryByHql("from MipOrganization where parentId = " + orgId, Tools.getMap());
				StringBuffer sBuffer = new StringBuffer();
				if (!MyString.isEmpty(cityArrayList)) {
					int i =0;
					orgIdsEs = new String[cityArrayList.size()];
					for (MipOrganization mipOrganization : cityArrayList) {
						sBuffer.append(mipOrganization.getId()).append(",");
						orgIdsEs[i++] = mipOrganization.getId();
					}
				}
				orgIds = sBuffer.toString();
				orgIds = orgIds.substring(0,orgIds.length()-1);
				hql += " and collectionUnit in ("+ orgIds +")";
			}
			
			if ("3".equals(level.toString())) {
				//博物馆级
				hql += " and collectionUnit in ("+ orgId +")";
				orgIdsEs = new String[]{orgId};
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
			//质地类别
			if (mipOpenCulturalrelicInfo.getGsTextureCategory() != null && !"".equals(mipOpenCulturalrelicInfo.getGsTextureCategory())) {
				hql += (" and gsTextureCategory=" + mipOpenCulturalrelicInfo.getGsTextureCategory());
				andMap.put("gstexturecategory", mipOpenCulturalrelicInfo.getGsTextureCategory());
			}
			//质地子类别
			if (mipOpenCulturalrelicInfo.getGsTextureSubcategories() != null && !"".equals(mipOpenCulturalrelicInfo.getGsTextureSubcategories())) {
				hql += (" and gsTextureSubcategories=" + mipOpenCulturalrelicInfo.getGsTextureSubcategories());
				andMap.put("gstexturesubcategories", mipOpenCulturalrelicInfo.getGsTextureSubcategories());
			}
			//来源
			if (mipOpenCulturalrelicInfo.getGsSource() != null && !"".equals(mipOpenCulturalrelicInfo.getGsSource())) {
				hql += (" and gsSource=" + mipOpenCulturalrelicInfo.getGsSource());
				andMap.put("gssource", mipOpenCulturalrelicInfo.getGsSource());
			}
			//完残程度
			if (mipOpenCulturalrelicInfo.getEndResidueLevel() != null && !"".equals(mipOpenCulturalrelicInfo.getEndResidueLevel())) {
				hql += (" and endResidueLevel=" + mipOpenCulturalrelicInfo.getEndResidueLevel());
				andMap.put("endresiduelevel", mipOpenCulturalrelicInfo.getEndResidueLevel());
			}
			//入藏时间范围
			if (mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame() != null && !"".equals(mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame())) {
				hql += (" and gsEntryWarehouseTimeFrame=" + mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
				andMap.put("gsentrywarehousetimeframe", mipOpenCulturalrelicInfo.getGsEntryWarehouseTimeFrame());
			}
			//质量范围
			if (mipOpenCulturalrelicInfo.getMassRange() != null && !"".equals(mipOpenCulturalrelicInfo.getMassRange())) {
				hql += (" and massRange=" + mipOpenCulturalrelicInfo.getMassRange());
				andMap.put("massrange", mipOpenCulturalrelicInfo.getMassRange());
			}
			//藏品编号
			if (mipOpenCulturalrelicInfo.getGsCollectionsNo() != null && !"".equals(mipOpenCulturalrelicInfo.getGsCollectionsNo())) {
				String[] array=mipOpenCulturalrelicInfo.getGsCollectionsNo().split("[\\t \\n]+");
				inMap.put("gscollectionsno",array);
				hql += (" and gsCollectionsNo in("+array+")");
			}
			//讲解词
			if (mipOpenCulturalrelicInfo.getDescription() != null && !"".equals(mipOpenCulturalrelicInfo.getDescription())) {
				if("1".equals(mipOpenCulturalrelicInfo.getDescription())) {
					isNullMap.put("isNull", "description");
					hql += (" and description = ''");
				}
				if("2".equals(mipOpenCulturalrelicInfo.getDescription())) {
					isNullMap.put("notNull", "description");
					hql += (" and description <> ''");
				}
			}
			//状态
			if (!MyString.isEmpty(levelStatus)) {
				String[] ary = levelStatus.split(",");
				inMap.put("status",ary);
				if(ary.length > 1) {
					StringBuffer strbf = new StringBuffer();
					for(String str : ary) {
						strbf.append(str).append(",");
					}
					String str = strbf.toString();
					str = str.substring(0,str.length()-1);
					hql += (" and status in("+str+")");
				}else {
					hql += (" and status in("+ary[0]+")");
				}
			}else {
				if("1".equals(level.toString())) {
					hql += (" and status in (1,3,4)");
					inMap.put("status",new String[] {"1","3","4"});
					levelStatus = "1,3,4";
				}
				if("3".equals(level.toString())) {
					hql += (" and status in (1,2,4)");
					inMap.put("status",new String[] {"1","2","4"});
					levelStatus = "1,2,4";
				}
			}
			if (!MyString.isEmpty(key)) {
				key = key.trim();
					hql += " and locate('"+key+"', indexName)>0";
					likeMap.put("name",key);
			}
			if (!MyString.isEmpty(gsNo)) {
				key = key.trim();
					hql += " and (gsNo like '" + gsNo + "%')";
					likeMap.put("gsno",gsNo);
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
			if(page.getCurrentPage() > 9500) {
				long stateTime_mysql = System.currentTimeMillis();//查询数据库开始时间
				fccList = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService
						.queryByHql(hql, Tools.getMap(), page);
				long endTime_mysql = System.currentTimeMillis();//查询数据库结束时间
				System.out.println("mysql查询运行时间："+(endTime_mysql-stateTime_mysql)+"ms");
			}else {
				long stateTime_es = System.currentTimeMillis();//查询数据库开始时间
				//es-------
				fccList = new ArrayList<>();
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
				//es-------
				long endTime_es = System.currentTimeMillis();//查询数据库结束时间
				System.out.println("es查询运行时间："+(endTime_es-stateTime_es)+"ms");
			}
			
			
			//List<MipOpenCulturalrelicInfoDto> mDtos = new ArrayList<MipOpenCulturalrelicInfoDto>();
			/*for (MipOpenCulturalrelicInfo m2 : fccList) {
				MipOpenCulturalrelicInfoDto md = new MipOpenCulturalrelicInfoDto();
				md.setMipOpenCulturalrelicInfo(m2);
				String pictureIds = m2.getPictureIds();
				if (!MyString.isEmpty(pictureIds)) {
					String[] split = pictureIds.split(",");
					String picId = split[0];
					Picture picture = pictureService.get(picId);
					md.setPicture(picture);
				}
				mDtos.add(md);
			}*/
			long stateTime_image = System.currentTimeMillis();//查询图片开始时间
			for (MipOpenCulturalrelicInfo m2 : fccList) {
				listKey = MessageFormat.format(KeyConstants.COLLECTION_INFO_LIST_KEY, m2.getId());
				jsonStr =JedisService.get(listKey);
				if(StringUtils.isNotBlank(jsonStr)) {
					String[] con = jsonStr.split(",");
					if(con.length>1){
						m2.setUserName(con[0]);
						m2.setContent(con[1]);
					}
				}
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
			}
			long endTime_image = System.currentTimeMillis();//查询图片结束时间
			System.out.println("图片查询运行时间："+(endTime_image-stateTime_image)+"ms");
			System.out.println("·····················藏品查询测试速度结束····················");
			mod.addObject("page", page);
			mod.addObject("fccList", fccList);
			mod.addObject("mipOpenCulturalrelicInfo", mipOpenCulturalrelicInfo);
			mod.addObject("erea", erea);
			mod.addObject("key", key);
			mod.addObject("gsNo", gsNo);
			mod.addObject("levelStatus", levelStatus);
//			jsonStr = JSON.toJSONString(mod);
//			JedisService.set(listKey, jsonStr, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
//		}
		return mod;
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
	@AuthPassport(authority="collectionAdmin")
	public ModelAndView toAdd() {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/open/wwadd.jsp");
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
	@AuthPassport(authority="collectionAdmin")
	public ModelAndView toEdit(@ModelAttribute MipOpenCulturalrelicInfo collection) {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/open/wwedit.jsp");
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
	 * 增加或者修改
	 * 
	 * @param moci
	 * @return
	 */
	@RequestMapping("/addOrUpdate.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
	public String addOrUpdate(@ModelAttribute MipOpenCulturalrelicInfo moci,@RequestParam(value="saveStatus",required=false) String saveStatus) {
		ImageTranslateDto imageTranslateDto = new ImageTranslateDto();
		imageTranslateDto.setOpType("add");
		List<String> imgPaths = new ArrayList<String>();
		try {
			// 判断增加还是修改
			if (MyString.isEmpty(moci.getId())) {
				//增加
				moci.setCollectionType("0");
				moci.setIsOpen((byte)1);//设置为不公开
				if (saveStatus.equals("1")) {
					moci.setStatus((byte)1);
				} else if (saveStatus.equals("2")) {
					moci.setStatus((byte)2);
				}
				moci.setSubmitTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));// 添加用户提交时间
				try {
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
					String pictureIds = saveInfo.getPictureIds();
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
				//更新统计表
				modifyStatisti(mipOpenCulturalrelicInfo);
				DcVersionSelect startSelect = dcVersionSelectService.selectByCollectionId(mipOpenCulturalrelicInfo.getId());
				if(MyString.isEmpty(startSelect)){
					String selectId = dcVersionSelect(mipOpenCulturalrelicInfo,(byte)1,(byte)2);
					dcVersionContent(mipOpenCulturalrelicInfo,selectId,(byte)2);
				}
				// 更新信息
				boolean isContentChange = moci.getDescription().trim().equals(mipOpenCulturalrelicInfo.getDescription().trim());
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
			
			//添加音频路径
			collection.setfAudio(config.getRootUrl()+collection.getfAudio());
			
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
	@AuthPassport(authority="collectionAdmin")
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
					if (mipOpenCulturalrelicInfo.getStatus()<4) {
						return "-2";
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
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				// 如果为空
				if (MyString.isEmpty(mipOpenCulturalrelicInfo.getPictureIds())) {
					return "-1";
				}
				if (mipOpenCulturalrelicInfo.getStatus()<4) {
					return "-2";
				}
				mipOpenCulturalrelicInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				// 不为空，更新
				mipOpenCulturalrelicInfo.setIsOpen((byte) 2);
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				//保存到公开表中
				MipOpenCollectionInfo save = saveMipOpenCollectionInfo(mipOpenCulturalrelicInfo);
				/*MipOpenCollectionNumber mipOpenCollectionNumber = new MipOpenCollectionNumber();
				mipOpenCollectionNumber.setId(id);
				int isExist = mipOpenCollectionNumberService.selectModel(id);
				if(isExist==0){
					mipOpenCollectionNumberService.insert(mipOpenCollectionNumber);
				}*/
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
	
	// 博物馆管理员审核
	@RequestMapping("reviewObject")
	@ResponseBody
	@AuthPassport(authority="collectionCommon")
	public String reviewObject(String id,Byte status,String auditMsg) throws MyException{
			//获取用户信息
			LoginInfoDto userDto = Tools.getUser();
			User user = userService.get(userDto.getId());
			String userName = user.getNickName();
			if (!MyString.isEmpty(id)) {
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				// 如果为空
				if (MyString.isEmpty(mipOpenCulturalrelicInfo)) {
					return "-1";
				}
				String listKey = MessageFormat.format(KeyConstants.COLLECTION_INFO_LIST_KEY, id);
				String jsonStr = userName+","+auditMsg;
				JedisService.set(listKey, jsonStr+"", KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
				// 不为空，更新
				mipOpenCulturalrelicInfo.setStatus((byte)status);
				mipOpenCulturalrelicInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				// 更新es
				MipOpenCulturalrelicInfoWithBLOBs mipOpenCulturalrelicInfoBLOBs = mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
				mipOpenCulturalrelicInfoBLOBs.setStatus((byte)status);
				mipOpenCulturalrelicInfoBLOBs.setUpdatedTime(new Date());
				updateES(mipOpenCulturalrelicInfoBLOBs);
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
				mipLogService.occLog(request, mipOpenCulturalrelicInfoBLOBs,"博物馆管理员审核:"+statusName+",说明:"+auditMsg);
				return "1";
			}else{
				return "0";
			}
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

	// 批量不公开
	@RequestMapping("/nonPublishAll.do")
	@ResponseBody
	@AuthPassport(authority="collectionAdmin")
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
	@AuthPassport(authority="collectionAdmin")
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
	@AuthPassport(authority="collectionAdmin")
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
	@AuthPassport(authority="collectionAdmin")
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
				mipOpenCollectionInfo.setSequence(100);
				mipOpenCollectionInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
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
	@AuthPassport(authority="collectionAdmin")
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
				mipOpenCollectionInfo.setSequence(50);
				mipOpenCollectionInfo.setUpdatedTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
				mipOpenCollectionInfoService.update(mipOpenCollectionInfo);
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
	@AuthPassport(authority="collectionAdmin")
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
	@AuthPassport(authority="collectionAdmin")
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
			

	/*
	 * @RequestMapping("/createThumnb.do")
	 * 
	 * @ResponseBody public void createThumnb(String collectionId, String picId,
	 * String imagePath, String thumbnailPath, int width, int height) throws
	 * IOException { Picture thumbPic = new Picture(); int lastIndexOf =
	 * imagePath.lastIndexOf("/"); String imageName =
	 * imagePath.substring(lastIndexOf+1); if (width >0 && height > 0) {
	 * Thumbnails.of(imagePath) .size(width, height) .toFile(thumbnailPath); }
	 * if(height == 0){ Thumbnails.of(imagePath) .width(width)
	 * .toFile(thumbnailPath); } if (width == 0) { Thumbnails.of(imagePath)
	 * .height(height) .toFile(thumbnailPath); }
	 * 
	 * //存数据库 thumbPic.setCollectionId(collectionId); thumbPic.setFossilId("");
	 * thumbPic.setName(""+ width + "x" +height + "_" +imageName);
	 * thumbPic.setPid(picId);
	 * thumbPic.setUrl(thumbnailPath.substring(thumbnailPath.lastIndexOf("\\")+2
	 * )); thumbPic.setType((byte)2); thumbPic.setStatus((byte)1); //获取缩略图图片真实长宽
	 * BufferedImage sourceImg =ImageIO.read(new FileInputStream(new
	 * File(thumbnailPath))); thumbPic.setPicWidth(sourceImg.getWidth());
	 * thumbPic.setPicHeight(sourceImg.getHeight());
	 * pictureService.save(thumbPic); }
	 */

	@RequestMapping("/changeSequence.do")
	@ResponseBody
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
