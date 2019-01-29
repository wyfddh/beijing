package com.tj720.mip.controller.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hslf.dev.SlideAndNotesAtomListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.dto.CollectionUnitDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.MuseumRelicCountDto;
import com.tj720.mip.dto.RelicCountDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.IFCCollectionService;
import com.tj720.mip.inter.service.table.IFCFossilService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMipStatisticsService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipStatistics;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;
@Controller("frontStatisticsController")
@RequestMapping("/front/statistics")
public class StatisticsController extends BaseController<MipStatistics> {

	@Autowired
	private IMipStatisticsService mipStatisticsService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	@Autowired
	private IFCCollectionService fCCollectionService;
	@Autowired
	private IFCFossilService fCFossilService;
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private IMipOpenFossilInfoService mipOpenFossilInfoService;
	@Autowired
	private AreaService areaService;
	
	/*private  String cityName;//市
	private  int museumCount;//每个市的博物馆的数量
	private  List<MipOrganization> museumList;//每个市下面的博物馆的集合
*/

	/**
	 * 统计首页
	 * @return
	 */
	@RequestMapping("/info.do")
	@ResponseBody
	public JsonResult getInfo(){
		//获取用户信息
		User user = userService.get(Tools.getUser().getId());
		MipOrganization organization1 = mipOrganizationService.get(user.getOrgId());
		byte level = organization1.getLevel();
		
		//创建map集合，放置查询对象
		Map<String, Object> map = new HashMap<String,Object>();
		String hql = "select count(*) from MipOrganization where status > 0";
		if (level == 1) {
			hql += "and platformId="+config.getPlatformId()+" and orgTypeId = '2'";
			List<Long> countList = (List<Long>) mipOrganizationService.queryByHql(hql, Tools.getMap());
			//全省收藏单位数量
			Long count = countList.get(0);
			String hql2 = "select count(*) from MipOrganization where status > 0"
			 + "and platformId="+config.getPlatformId()+" and orgTypeId = '2' and dwid != ''";
			List<Long> countList2 = (List<Long>)mipOrganizationService.queryByHql(hql2, Tools.getMap());
			//一普全省收藏单位数量
			Long ypCount = countList2.get(0);
			//差值
			long count2 = Long.valueOf(count) - Long.valueOf(ypCount);
			String hql3 = "select sum(numberYall) from MipStatistics where status > 0";
			List<Long> ypList = (List<Long>) mipStatisticsService.queryByHql(hql3, Tools.getMap());
			//全省一普可移动文物数量
			Long ypSum = (long) 0;
			if (!MyString.isEmpty(ypList)) {
				ypSum = ypList.get(0);
			}
			 
			String hql4 = "select sum(numberOall) from MipStatistics where status > 0";
			List<Long> oaList = (List<Long>) mipStatisticsService.queryByHql(hql4, Tools.getMap());
			//全省当前可移动文物数量
			Long oaSum = (long) 0;
			if (!MyString.isEmpty(oaSum)) {
				oaSum = oaList.get(0);
			}
			
			//差值
			//long sumCount = Long.valueOf(oaSum) - Long.valueOf(ypSum);
			//String hql5 = "select id,name from MipArea where pid ="+config.getProvinceId();
			//市集合
			//List<MipArea> cityList = (List<MipArea>) areaService.queryByHql(hql5, Tools.getMap());
			//String hql6 = "select cityId,count(*) from MipOrganization where status <> -127 and platformId=2"
			//		+ "and level = 3 and parentId in (select id from MipOrganization where parentId = "+user.getOrgId()+")";
			//每个市博物馆数量集合
			//List<MipOrganization> orgCountList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql6, Tools.getMap());
			//String hql7 = "select cityId,name from MipOrganization where status <> -127 and platformId=2"
			//		+ "and level = 3 and parentId in (select id from MipOrganization where parentId = "+user.getOrgId()+")";
			//博物馆集合
			//List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql7, Tools.getMap());
			map.put("time",DateFormartUtil.getDateByFormat(new SimpleDateFormat("YYYY年MM月")));
			map.put("count", count);
			map.put("ypCount", ypCount);
			map.put("count2", count2);
			map.put("ypSum", ypSum);
			map.put("oaSum", oaSum);
			map.put("level", level);
			//map.put("sumCount", sumCount);
			//map.put("cityList", cityList);
			//map.put("orgCountList", orgCountList);
			//map.put("museumList", museumList);
		}
		if (level == 2) {
			
			hql += " and platformId="+config.getPlatformId()+" and orgTypeId = '2' and cityId ="+organization1.getCityId();
			@SuppressWarnings("unchecked")
			List<Long> countList = (List<Long>) mipOrganizationService.queryByHql(hql, Tools.getMap());
			//全市收藏单位数量
			Long count = countList.get(0);
			String hql2 = "select count(*) from MipOrganization where status > 0";
			hql2 += "and platformId="+config.getPlatformId()+" and orgTypeId = '2' and dwid != ''  and cityId ="+organization1.getCityId();
			List<Long> countList2 = (List<Long>)mipOrganizationService.queryByHql(hql2, Tools.getMap());
			//一普全市收藏单位数量
			Long ypCount = countList2.get(0);
			//差值
			long count2 = Long.valueOf(count) - Long.valueOf(ypCount);
			String hql3 = "select sum(numberYall) from MipStatistics where status > 0";
			hql3 += "and collectionUnit in(select id from MipOrganization where platformId ="+config.getPlatformId()+"and orgTypeId = '2' and dwid"
					+ "!= '' and cityId ="+organization1.getCityId()+")";
			List<Long> ypList = (List<Long>) mipStatisticsService.queryByHql(hql3, Tools.getMap());
			//全市一普可移动文物数量
			Long ypSum = (long) 0;
			if (!MyString.isEmpty(ypList)) {
				ypSum = ypList.get(0);
			}
			
			
			String hql4 = "select sum(numberOall) from MipStatistics where status > 0";
			hql4 += "and collectionUnit in(select id from MipOrganization where platformId ="+config.getPlatformId()+"and orgTypeId = '2' "
					+" and cityId ="+organization1.getCityId()+")";
			List<Long> oaList = (List<Long>) mipStatisticsService.queryByHql(hql4, Tools.getMap());
			//全市当前可移动文物数量
			Long oaSum = (long) 0;
			if (!MyString.isEmpty(oaSum)) {
				oaSum = oaList.get(0);
			}
			
			//差值
			long sumCount = Long.valueOf(oaSum) - Long.valueOf(ypSum);
			//全市博物馆名单
			//String hql5 = "from MipOrganization where status <> -127 and level = 3 and platformId ="+config.getPlatformId()+
			//		"and parentId = " + user.getOrgId();
			//List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql5, Tools.getMap());
			map.put("count", count);
			map.put("ypCount", ypCount);
			map.put("count2", count2);
			map.put("ypSum", ypSum);
			map.put("oaSum", oaSum);
			map.put("level", level);
			map.put("sumCount", sumCount);
			map.put("time",DateFormartUtil.getDateByFormat(new SimpleDateFormat("YYYY年MM月")));
			//map.put("museumList", museumList);
		}
		return new JsonResult(1, map);
	}
	
	/**
	 * 收藏单位数量分布、收藏单位名单
	 * @return
	 */
	@RequestMapping("/collectionUnit.do")
	@ResponseBody
	public JsonResult getCollectionUnit(){
		//获取用户信息
		User user = userService.get(Tools.getUser().getId());
		MipOrganization organization1 = mipOrganizationService.get(user.getOrgId());
		byte level = organization1.getLevel();
		//创建map集合，放置查询对象
		Map<String, Object> map = new HashMap<String,Object>();
		if (level == 1) {
			List<CollectionUnitDto> collectionUnitList = new ArrayList<CollectionUnitDto>();
			CollectionUnitDto collectionUnitDto = null;
			//市集合
			String hql5 = "from MipArea where pid ="+config.getProvinceId();
			List<MipArea> cityList = (List<MipArea>) areaService.queryByHql(hql5, Tools.getMap());
			//遍历市的集合
			for (MipArea mipArea : cityList) {
				collectionUnitDto = new CollectionUnitDto();
				collectionUnitDto.setCityName(mipArea.getName());
				String hql = "select count(*) from MipOrganization where cityId = "+mipArea.getId()
				+"and platformId ="+config.getPlatformId()+"and orgTypeId = '2' and status > 0";
				List<Long> orgCountList = (List<Long>) mipOrganizationService.queryByHql(hql, Tools.getMap());
				//每个市下博物馆的数量
				Long orgCount = orgCountList.get(0);
				collectionUnitDto.setMuseumCount(orgCount);
				String hql2 = "from MipOrganization where cityId = "+mipArea.getId()+"and platformId="+config.getPlatformId()
					+"and orgTypeId = '2' and status > 0";
				//每个市下博物馆的集合
				List<MipOrganization> museumList1 = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2, Tools.getMap());
				collectionUnitDto.setMuseumList(museumList1);
				collectionUnitList.add(collectionUnitDto);
			}
			
			/*String hql6 = "select count(*) as no from MipOrganization where status > 0 and platformId="+config.getPlatformId()
					+ "and level = 3 and parentId in (select id from MipOrganization where parentId = "+user.getOrgId()+")";
			//每个市博物馆数量集合
			List<Long> orgCountList = (List<Long>) mipOrganizationService.queryByHql(hql6, Tools.getMap());
			//遍历博物馆数量集合
			for (Long long1 : orgCountList) {
				collectionUnitDto.setMuseumCount(long1);
				collectionUnitList.add(collectionUnitDto);
			}
			String hql7 = "from MipOrganization where status > 0 and platformId="+config.getPlatformId()
					+ "and level = 3 and parentId in (select id from MipOrganization where parentId = "+user.getOrgId()+")";
			//博物馆集合
			List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql7, Tools.getMap());
			collectionUnitDto.setMuseumList(museumList);
			collectionUnitList.add(collectionUnitDto);*/
			//map.put("cityList", cityList);
			//map.put("orgCountList", orgCountList);
			//map.put("museumList", museumList);
			map.put("collectionUnitList", collectionUnitList);
			map.put("level", level);
		}
		if (level == 2) {
			
			String hql5 = "from MipOrganization where status > 0 and level = 3 and platformId ="+config.getPlatformId()+
					"and cityId = " + organization1.getCityId();
			List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql5, Tools.getMap());
			map.put("museumList", museumList);
			map.put("level", level);
		}
		return new JsonResult(1, map);
	}
	
	/**
	 * 可移动文物数量分布
	 */
	@RequestMapping("/relicCount.do")
	@ResponseBody
	public JsonResult getRelicCount(){
		//获取用户信息
		User user = userService.get(Tools.getUser().getId());
		MipOrganization organization1 = mipOrganizationService.get(user.getOrgId());
		byte level = organization1.getLevel();
		//创建map集合，放置查询对象
		Map<String, Object> map = new HashMap<String,Object>();
		if (level == 1) {
			List<RelicCountDto> relicCountList = new ArrayList<RelicCountDto>();
			List<MuseumRelicCountDto> museumRelicCountList = null;
			RelicCountDto relicCountDto = null;
			MuseumRelicCountDto museumRelicCountDto = null;
			//市集合
			String hql1 = "from MipArea where pid ="+config.getProvinceId();
			List<MipArea> cityList = (List<MipArea>) areaService.queryByHql(hql1, Tools.getMap());
			//遍历市集合
			for (MipArea mipArea : cityList) {
				long count = 0;
				relicCountDto = new RelicCountDto();
				relicCountDto.setCityName(mipArea.getName());
				/*String hql4 ="select sum(numberOall) from MipStatistics where collectionUnit in (select id from "
						+"MipOrganization where status　> 0 and orgTypeId = 2 and platformId ="+config.getPlatformId()+"and cityId=" 
							+mipArea.getId()+")";
				
				List<Long> relicCountCityList = (List<Long>) mipStatisticsService.queryByHql(hql4, Tools.getMap());
				//每个市下可移动文物的数量
				Long relicCount = relicCountCityList.get(0);
				relicCountDto.setRelicCount(relicCount);*/
				//每个博物馆可移动文物数量的集合
				museumRelicCountList = new ArrayList<MuseumRelicCountDto>();
				String hql2 = "from MipOrganization where cityId = "+mipArea.getId()+"and platformId="+config.getPlatformId()
				+"and orgTypeId = '2' and status > 0";
				//每个市下面的博物馆集合
				List<MipOrganization> museumList1 = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2, Tools.getMap());
				//遍历每个市下面的博物馆集合
				for (MipOrganization mipOrganization : museumList1) {
					museumRelicCountDto = new MuseumRelicCountDto();
					museumRelicCountDto.setMuseumName(mipOrganization.getName());
					String hql3 = "select sum(numberOall) from MipStatistics where collectionUnit="+mipOrganization.getId();
					Object r = mipStatisticsService.getDtoByHql(hql3);
					long museumRelicCount=MyString.isEmpty(r)?0:(long)r;
					museumRelicCountDto.setMuseumRelicCount(museumRelicCount);
					museumRelicCountList.add(museumRelicCountDto);
					count+=museumRelicCount;
				}
				relicCountDto.setMuseumRelicCountList(museumRelicCountList);
				relicCountDto.setRelicCount(count);
				relicCountList.add(relicCountDto);
				
			}
			map.put("relicCountList", relicCountList);
			map.put("level", level);
			/*//每个市可移动文物数量的集合
			
			//博物馆集合
			String hql7 = "select cityId,name from MipOrganization where status <> -127 and platformId=2"
					+ "and level = 3 and parentId in (select id from MipOrganization where parentId = "+user.getOrgId()+")";
			
			List<MipOrganization> museumList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql7, Tools.getMap());
			//每个博物馆可移动文物数量的集合
*/			
		}
		if (level == 2) {
			List<MuseumRelicCountDto> relicCountList = new ArrayList<MuseumRelicCountDto>();
			MuseumRelicCountDto museumRelicCountDto = null;
			String hql2 = "from MipOrganization where cityId = "+organization1.getCityId()+"and platformId="+config.getPlatformId()
			+"and orgTypeId = '2' and status > 0";
			//每个市下面的博物馆集合
			List<MipOrganization> museumList1 = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2, Tools.getMap());
			//遍历每个市下面的博物馆集合
			for (MipOrganization mipOrganization : museumList1) {
				museumRelicCountDto = new MuseumRelicCountDto();
				museumRelicCountDto.setMuseumName(mipOrganization.getName());
				/*String hql3 = "select numberOall from MipStatistics where collectionUnit="+mipOrganization.getId();
				List<Long> museumRelicCountList = (List<Long>) mipStatisticsService.queryByHql(hql3, Tools.getMap());
				//每个博物馆可移动文物的数量
				Long museumRelicCount = museumRelicCountList.get(0);
				museumRelicCountDto.setMuseumRelicCount(museumRelicCount);*/
				String hql3 = "select numberOall from MipStatistics where collectionUnit="+mipOrganization.getId();
				Object r = mipStatisticsService.getDtoByHql(hql3);
				long museumRelicCount=MyString.isEmpty(r)?0:(long)r;
				museumRelicCountDto.setMuseumRelicCount(museumRelicCount);
				//museumRelicCountList.add(museumRelicCountDto);
				relicCountList.add(museumRelicCountDto);
			}
			map.put("relicCountList", relicCountList);
			map.put("level", level);
		}
		return new JsonResult(1, map);
	}
}
