
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
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IFCFossilService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.inter.service.tool.ISearchService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.FCCollection;
import com.tj720.mip.model.FCFossil;
import com.tj720.mip.model.MipArea;
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
@RequestMapping("/back/fCFossil")
public class FCFossilController extends BaseController<FCFossil> {

	@Autowired
	private IFCFossilService fCFossilService;
	@Autowired
	private IYearTypeService yearTypeService;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	
	/**
	 * 加载一普化石页面信息
	 * 
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/info.do")
	@ResponseBody
	public ModelAndView getFossilInfo(String key, @ModelAttribute FCFossil fCFossil, String erea,
			@RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "1", name="page") int currentPage,
			@RequestParam(defaultValue = "createTime") String order) throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/collection/yipu/yplist2.jsp");
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = user.getOrgId();
		String listKey = MessageFormat.format(KeyConstants.YP_FOSSIL_INFO_LIST_KEY, orgId);
		String jsonStr = JedisService.get(listKey);
		if(StringUtils.isNotBlank(jsonStr)) {
			mod = JSON.parseObject(jsonStr, ModelAndView.class);
		} else {
			 MipOrganization org = mipOrganizationService.get(orgId);
			 //查询组织机构的级别
			 byte level = org.getLevel();
			
			// 查询年代集合
			/*String hql_yearType = "from YearType yt where yt.code like '1%'";
			List<YearType> ytList = (List<YearType>) yearTypeService.queryByHql(hql_yearType, Tools.getMap());
			mod.addObject("ytList", ytList);*/
			
			// 查询年代（宙）集合
			List<YearType> ytEonList = (List<YearType>) yearTypeService
					.queryByHql("from YearType yt where yt.parentId=2 and yt.fcCounts>0", Tools.getMap());
			mod.addObject("ytEonList", ytEonList);
			// 查询年代（代）集合
			if (fCFossil.getYearTypeEon()!=null && !"".equals(fCFossil.getYearTypeEon())) {
				List<YearType> ytEraList = (List<YearType>) yearTypeService.queryByHql("from YearType yt where yt.parentId=" + fCFossil.getYearTypeEon() +" and yt.fcCounts>0", Tools.getMap());
				mod.addObject("ytEraList",ytEraList);
			}
			// 查询年代（纪）集合
			if (fCFossil.getYearTypeEra()!=null && !"".equals(fCFossil.getYearTypeEra())) {
				List<YearType> ytEpochList = (List<YearType>) yearTypeService.queryByHql("from YearType yt where yt.parentId=" + fCFossil.getYearTypeEra() +" and yt.fcCounts>0", Tools.getMap());
				mod.addObject("ytEpochList",ytEpochList);
			}
			
			// 查询化石类别集合
			List<PickDto> ccList = (List<PickDto>) collectionCategoryService
					.queryByHql("from CollectionCategory cc where cc.fcCounts>0 order by sequence desc", Tools.getMap());
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
			
			
			// 查询组织机构（城市）的集合
			/*List<MipArea> cityList = (List<MipArea>) areaService.queryByHql("from MipArea where pid=1375",Tools.getMap());
			mod.addObject("cityList", cityList);*/
			/*List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
					.queryByHql("from MipOrganization where platformId="+config.getPlatformId()+" and level=2 order by sequence", Tools.getMap());
			mod.addObject("cityList", cityList);*/
	
			// 查询组织机构（博物馆）的集合
				if (erea != null && !"".equals(erea)) {
					List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService
							.queryByHql("from MipOrganization where parentId=" + erea
									+ " and level=3 and status>0 and isdelete=0 order by sequence", Tools.getMap());
					mod.addObject("musList", musList);
				}
			
			
			//查询本省所有博物馆集合
			List<MipOrganization> museums = (List<MipOrganization>) mipOrganizationService
					.queryByHql("from MipOrganization where platformId=" + config.getPlatformId() + " and orgTypeId='2' and status>0 and isdelete=0 order by sequence desc", Tools.getMap());
			mod.addObject("museums", museums);
	
			// 查询化石列表
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			
			String hql = "from FCFossil where status>=0 and collectionUnit <>''";
			//通过判断用户级别查询
			if (level == 0) {
				//全国
			}
			if (level == 1) {
				//省级
				//查询省级下所有市
				String orgIds = "";
				List<MipOrganization> cityArrayList = (List<MipOrganization>) fCFossilService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
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
					List<MipOrganization> orgList = (List<MipOrganization>) fCFossilService.queryByHql("from MipOrganization where parentId in (" + cityIds + ")", Tools.getMap());
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
			}
			if (level == 2) {
				//市级
				String orgIds = "";
				List<MipOrganization> cityArrayList = (List<MipOrganization>) fCFossilService.queryByHql("from MipOrganization where parentId = " + org.getId(), Tools.getMap());
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
			
			
			if (fCFossil.getYearTypeEon() != null && !"".equals(fCFossil.getYearTypeEon())) {
				hql += (" and yearTypeEon='" + fCFossil.getYearTypeEon() + "'");
			}
			if (fCFossil.getYearTypeEra() != null && !"".equals(fCFossil.getYearTypeEra())) {
				hql += (" and yearTypeEra='" + fCFossil.getYearTypeEra() + "'");
			}
			if (fCFossil.getYearTypeEpoch() != null && !"".equals(fCFossil.getYearTypeEpoch())) {
				hql += (" and yearTypeEpoch='" + fCFossil.getYearTypeEpoch() + "'");
			}
			if (fCFossil.getCollectionsCategory() != null && !"".equals(fCFossil.getCollectionsCategory())) {
				hql += (" and collectionsCategory='" + fCFossil.getCollectionsCategory() + "'");
			}
			if (fCFossil.getCollectionUnit() != null && !"".equals(fCFossil.getCollectionUnit())) {
				hql += (" and collectionUnit='" + fCFossil.getCollectionUnit() + "'");
			}
			if (fCFossil.getCollectionLevel() != null && !"".equals(fCFossil.getCollectionLevel())) {
				hql += (" and collectionLevel='" + fCFossil.getCollectionLevel() + "'");
			}
			if (fCFossil.getIsOpen() != 0 && !"".equals(fCFossil.getIsOpen())) {
				hql += (" and isOpen=" + fCFossil.getIsOpen());
			}
			if (fCFossil.getIsHighQuality() != 0 && !"".equals(fCFossil.getIsHighQuality())) {
				hql += (" and isHighQuality=" + fCFossil.getIsHighQuality());
			}
			if (key != null && !"".equals(key)) {
				hql += " and (name like '%" + key 
						+ "%' or yearType like '%" + key 
						+ "%' or collectionsCategory like '%"+ key 
						+ "%' or collectionUnit like '%" + key 
						+ "%')";
			}
			hql += " order by createTime desc";
			List<FCFossil> fccList = (List<FCFossil>) fCFossilService.queryByHql(hql, Tools.getMap(), page);
			for (FCFossil m2 : fccList) {
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
			mod.addObject("fCFossil", fCFossil);
			mod.addObject("erea", erea);
			mod.addObject("key", key);
			jsonStr = JSON.toJSONString(mod);
			JedisService.set(listKey, jsonStr, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
		}
		return mod;
	}


	/**
	 * 通过藏品id查询藏品详细信息
	 * 
	 * @param fCFossil
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public ModelAndView detail(@ModelAttribute FCFossil fCFossil) throws MyException {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/collection/yipu/ypdetail2.jsp");
		try {
			FCFossil fossil = fCFossilService.get(fCFossil.getId());
			modelAndView.addObject("fossil", fossil);
			//年代
			YearType yearTypeEon = yearTypeService.get(fossil.getYearTypeEon());
			modelAndView.addObject("yearTypeEon", yearTypeEon);
			YearType yearTypeEra = yearTypeService.get(fossil.getYearTypeEra());
			modelAndView.addObject("yearTypeEra", yearTypeEra);
			YearType yearTypeEpoch = yearTypeService.get(fossil.getYearTypeEpoch());
			modelAndView.addObject("yearTypeEpoch", yearTypeEpoch);
			//查询博物馆名称
			String collectionUnitId = fossil.getCollectionUnit();
			MipOrganization mipOrganization = mipOrganizationService.get(collectionUnitId);
			modelAndView.addObject("mipOrganization", mipOrganization.getName());
			
			//查询藏品的文物类别
			String collectionsCategory = fossil.getCollectionsCategory();
			CollectionCategory collectionCategory = collectionCategoryService.get(collectionsCategory);
			modelAndView.addObject("collectionCategory", collectionCategory.getName());
			
			//查询图片
			ArrayList<Picture> pictures = new ArrayList<Picture>();
			String pictureIds = fossil.getPictureIds();
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
		FCFossil change = fCFossilService.get(changeId);
		FCFossil model = fCFossilService.get(id);

		int modelSequence = model.getSequence();

		model.setSequence(change.getSequence());
		change.setSequence(modelSequence);

		fCFossilService.update(model);
		fCFossilService.update(change);
		return new JsonResult(1, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/sltYearType.do")
	@ResponseBody
	public List<YearType> sltYearType(@RequestParam(name = "pid") String pid) {
		String hql = "";
		if (!MyString.isEmpty(pid)) {
			hql = "from YearType where parentId=" + pid;
		}else {
			hql = "from YearType where 1 <> 1";
		}
				
		List<YearType> yTypes = (List<YearType>) mipOrganizationService.queryByHql(hql,
				Tools.getMap());
		return yTypes;
	}

}
