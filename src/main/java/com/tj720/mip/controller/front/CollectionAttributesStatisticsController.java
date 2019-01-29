package com.tj720.mip.controller.front;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.TjAttributesDto;
import com.tj720.mip.dto.TjCityDto;
import com.tj720.mip.dto.TjOrgDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipCollectionLevelService;
import com.tj720.mip.inter.service.table.IMipCollectionResidueLevelService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMipStatisticsService;
import com.tj720.mip.inter.service.table.IMipYearStatisticsService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipStatistics;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;
@Controller
@RequestMapping("/front/statisticsAttributes")
public class CollectionAttributesStatisticsController extends BaseController<MipStatistics> {
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IMipStatisticsService mipStatisticsService;
	@Autowired
	private IMipYearStatisticsService mipYearStatisticsService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IMipCollectionLevelService mipCollectionLevel;
	@Autowired
	private IMipCollectionResidueLevelService mipCollectionResidueLevelService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	@Autowired
	private AreaService areaService;

	@RequestMapping("/index.do")
	@ResponseBody
	public JsonResult index(@RequestParam(defaultValue = "") String cityId,@RequestParam(defaultValue = "") String orgId){
		byte level=0;
		try {
			//获取用户信息
			LoginInfoDto userDto = (LoginInfoDto) Tools.getUser();
			if (userDto == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				String uid = userDto.getId();
				User user = userService.get(uid);
				//获取用户的组织机构
				String userOrgId = user.getOrgId();
				MipOrganization org = mipOrganizationService.get(userOrgId);
				//查询组织机构的级别
				level = org.getLevel();
				if(level==2){
					String tmpCityId=org.getCityId();
					if(!MyString.isEmpty(cityId)&&tmpCityId!=cityId){
						return new JsonResult(new MyException("400000","市级管理员只能查询本市统计！"));
					}else{
						cityId=tmpCityId;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("300000","您不是管理人员！"));
		}
		if(MyString.isEmpty(level)||level>2){
			return new JsonResult(new MyException("300000","您不是管理人员！"));
		}
		HashMap<String,Object> result=new HashMap<>();
		String title="";
		String where="";
		//获取城市、博物馆
		String hqlCity = "SELECT new com.tj720.mip.dto.TjCityDto(c.id as cityId ,c.name) FROM MipArea as c where c.pid = "+config.getProvinceId();
		String hqlOrg = "SELECT new com.tj720.mip.dto.TjOrgDto(c.id as orgId ,c.name, c.cityId) FROM MipOrganization as c WHERE c.orgTypeId='2' AND c.platformId="+config.getPlatformId();
		switch(level){
		case 1:
			title="选择地区-博物馆";
			hqlCity+="  order by c.sequence desc";
			break;
		case 2:
			title="选择博物馆";
			hqlCity+=" and c.id="+cityId;
			break;
		}
		List<TjCityDto> cities = (List<TjCityDto>) areaService.queryByHql(hqlCity, Tools.getMap());
		if(!MyString.isEmpty(cities)){
			for(TjCityDto city:cities){
				List<TjOrgDto> orgs = (List<TjOrgDto>) mipOrganizationService.queryByHql(hqlOrg+" AND cityId="+city.getCityId(), Tools.getMap());
				if(!MyString.isEmpty(orgs)){
					if(cityId.equalsIgnoreCase(city.getCityId())&&!MyString.isEmpty(orgId)){
						for(TjOrgDto org:orgs){
							if(orgId.equalsIgnoreCase(org.getOrgId())){
								org.setSelected(1);
								city.setSelected(1);
								if(level==1)
									title=city.getName()+"-"+org.getName();
								else
									title=org.getName();
								where=" WHERE collectionUnit="+org.getOrgId();
								break;
							}
						}
					}
					city.setOrgs(orgs);
					TjOrgDto orgAll = new TjOrgDto("All","全部",cityId);
					if(cityId.equalsIgnoreCase(city.getCityId())&&(orgId.equalsIgnoreCase("All")||level==2&&MyString.isEmpty(orgId))){
						String ids=city.getOrgIds();
						if(!MyString.isEmpty(ids))
							where=" WHERE collectionUnit IN("+ids+")";
						else
							where=" WHERE false";
						orgAll.setSelected(1);
						city.setSelected(1);
						if(level==1)
							title=city.getName()+"-博物馆";
					}
					orgs.add(0,orgAll);
					city.setOragCount(orgs.size());
				}
			}
			if(cities.size()>1){
				TjCityDto allCity=new TjCityDto("All","全部");
				ArrayList<TjOrgDto> orgAll=new ArrayList<TjOrgDto>();
				orgAll.add(new TjOrgDto("All","全部",allCity.getCityId()));
				allCity.setOrgs(orgAll);
				if(cityId.equalsIgnoreCase("All")){
					allCity.setSelected(1);
				}
				cities.add(0, allCity);
			}
			result.put("cities", cities);
		}
		result.put("title", title);
		//属性查询
		String hqlCategory="SELECT new com.tj720.mip.dto.TjAttributesDto(c.id,c.name) FROM CollectionCategory as c WHERE type LIKE '文物%' ORDER BY id+0";
		List<TjAttributesDto> categories = (List<TjAttributesDto>) collectionCategoryService.queryByHql(hqlCategory, Tools.getMap());
		if(!MyString.isEmpty(categories)){
			for(TjAttributesDto attr:categories){
				String in=(MyString.isEmpty(where)?" where":" and")+" collectionsCategory ="+attr.getId();
				Object r=mipStatisticsService.getDtoByHql("select sum(numberOall) from MipStatistics"+where+in);
				if(!MyString.isEmpty(r))
					attr.setCount((long)r);
			}
		}
		result.put("categories", categories);

		String hqlYearType1="SELECT new com.tj720.mip.dto.TjAttributesDto(c.id,c.tjYtName as name,c.ytIds as ids,c.status) FROM MipYearStatistics as c WHERE c.status=1";
		List<TjAttributesDto> yearTypes1 = (List<TjAttributesDto>) mipYearStatisticsService.queryByHql(hqlYearType1, Tools.getMap());
		if(!MyString.isEmpty(yearTypes1)){
			long count=0;
			for(TjAttributesDto attr:yearTypes1){
				String in="";
				if(!MyString.isEmpty(attr.getIds())){
					in=(MyString.isEmpty(where)?" WHERE":" AND")+" yearType IN ("+attr.getIds()+")";
				}
				Object r=mipStatisticsService.getDtoByHql("SELECT SUM(numberOall) FROM MipStatistics"+where+in);
				if(!MyString.isEmpty(r)){
					long i=(long)r;
					attr.setCount(i);
					if(attr.getStatus()==1)
						count+=i;
				}
			}
			if(count>0){
				for(TjAttributesDto attr:yearTypes1){
					if(attr.getStatus()==1){
						attr.setPercentage(new DecimalFormat("#0.00").format((double)attr.getCount()*100.0/count));
					}
				}
			}
		}
		result.put("yearTypes1", yearTypes1);
		String hqlYearType2="SELECT new com.tj720.mip.dto.TjAttributesDto(c.id,c.tjYtName as name,c.ytIds as ids,c.status) FROM MipYearStatistics as c WHERE c.status=2";
		List<TjAttributesDto> yearTypes2 = (List<TjAttributesDto>) mipYearStatisticsService.queryByHql(hqlYearType2, Tools.getMap());
		if(!MyString.isEmpty(yearTypes2)){
			long count=0;
			for(TjAttributesDto attr:yearTypes2){
				String in="";
				if(!MyString.isEmpty(attr.getIds())){
					in=(MyString.isEmpty(where)?" WHERE":" AND")+" yearType IN ("+attr.getIds()+")";
				}
				Object r=mipStatisticsService.getDtoByHql("SELECT SUM(numberOall) FROM MipStatistics"+where+in);
				if(!MyString.isEmpty(r)){
					long i=(long)r;
					attr.setCount(i);
					if(attr.getStatus()==1)
						count+=i;
				}
			}
			if(count>0){
				for(TjAttributesDto attr:yearTypes2){
					if(attr.getStatus()==1){
						attr.setPercentage(new DecimalFormat("#0.00").format((double)attr.getCount()*100.0/count));
					}
				}
			}
		}
		result.put("yearTypes2", yearTypes2);

		String hqlCollectionLevel="SELECT new com.tj720.mip.dto.TjAttributesDto(c.id,c.name) FROM MipCollectionLevel as c ORDER BY id";
		List<TjAttributesDto> collectionLevels = (List<TjAttributesDto>) mipCollectionLevel.queryByHql(hqlCollectionLevel, Tools.getMap());
		if(!MyString.isEmpty(collectionLevels)){
			long count=0;
			for(TjAttributesDto attr:collectionLevels){
				String in=(MyString.isEmpty(where)?" WHERE":" AND")+" collectionLevel ="+attr.getId();
				Object r=mipStatisticsService.getDtoByHql("SELECT SUM(numberOall) FROM MipStatistics AS c "+where+in);
				if(!MyString.isEmpty(r)){
					long i=(long)r;
					attr.setCount((long)r);
					count+=i;
				}
			}
			if(count>0){
				for(TjAttributesDto attr:collectionLevels){
					attr.setPercentage(new DecimalFormat("#0.00").format((double)attr.getCount()*100.0/count));
				}
			}
		}
		result.put("collectionLevels", collectionLevels);

		String hqlCollectionResidueLevel="SELECT new com.tj720.mip.dto.TjAttributesDto(c.id,c.name) FROM MipCollectionResidueLevel as c ORDER BY id";
		List<TjAttributesDto> collectionResidueLevels = (List<TjAttributesDto>) mipCollectionResidueLevelService.queryByHql(hqlCollectionResidueLevel, Tools.getMap());
		if(!MyString.isEmpty(collectionResidueLevels)){
			long count=0;
			for(TjAttributesDto attr:collectionResidueLevels){
				String in=(MyString.isEmpty(where)?" WHERE":" AND")+" endResidueLevel ='"+attr.getName()+"'";
				Object r=mipStatisticsService.getDtoByHql("SELECT SUM(numberOall) FROM MipStatistics AS c "+where+in);
				if(!MyString.isEmpty(r)){
					long i=(long)r;
					attr.setCount((long)r);
					count+=i;
				}
			}
			if(count>0){
				for(TjAttributesDto attr:collectionResidueLevels){
					attr.setPercentage(new DecimalFormat("#0.00").format((double)attr.getCount()*100.0/count));
				}
			}
		}
		result.put("collectionResidueLevels", collectionResidueLevels);
		return new JsonResult(1,result);
	}

}
