/** 
 * <pre>项目名称:mip 
 * 文件名称:AreaController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年2月23日下午4:21:03 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.controller.content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.AreaOrag;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.dto.Museum;
import com.tj720.mip.dto.MuseumInfoDto;
import com.tj720.mip.framework.ErrorInfos;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.CategoryService;
import com.tj720.mip.inter.service.table.MuseumCarouselService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.model.Category;
import com.tj720.mip.model.MipMuseumCarousel;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.Spreadtrum;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MapValueComparator;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;


/** 
 * <pre>项目名称：mip    
 * 类名称：AreaController    
 * 类描述：    博物馆导览页(博物馆子页面)
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午4:21:03    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午4:21:03    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	@Autowired
	private MuseumInfoService museumInfoService;//博物馆信息
	@Autowired
	private CategoryService  categoryService;//博物馆类别
	//组织架构表
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MuseumCarouselService museumCarouselService;//博物馆轮播图
	@Autowired
	private PictureService pictureService;//图片表的service
	@Autowired
	private Config config;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("getAreaList")
	@ResponseBody
	public List<CityMuseum> getAreaList(){
		HashMap<String, CityMuseum> cityMap = new HashMap<>();
		Map<String, Long> sorted_map=new HashMap<String, Long>();
		ArrayList<String> ids = new ArrayList<>();
		List<CityMuseum> cityList=new ArrayList<>();
		String hql = "SELECT new com.tj720.mip.dto.AreaOrag(c.id as areaId ,c.name as areaName,o.id as oragId,o.name as oragName,o.collectionCount as oragCount, o.open) FROM MipOrganization as o, MipArea as c where o.cityId=c.id "
			+ "and c.pid = "+config.getProvinceId()+" and o.orgTypeId = '2' and o.status > 0 and o.isdelete = 0  order by c.sequence desc, o.sequence desc";
		List<AreaOrag> queryByHql = (List<AreaOrag>) areaService.queryByHql(hql, Tools.getMap());
		for(AreaOrag area:queryByHql){
				String key=area.getAreaId();
//				String key=area.getOragId();
				if(cityMap.get(key)==null){
					cityMap.put(key, new CityMuseum(area.getAreaName()));
					sorted_map.put(key, (long)0);
					ids.add(key);
				}
				CityMuseum cm=cityMap.get(key);
				sorted_map.put(key,sorted_map.get(key)+area.getOragCount());
				if(area.getOpen()==1){
					List<Museum> m=cm.getMuseum();
					m.add(new Museum(area.getOragId(),key,area.getOragName(),""+area.getOragCount()));
					cm.setMuseum(m);
				}
		}
		Map<String, Long> sorted_map2 = MapValueComparator.sortByValues(sorted_map);
		int index=1;
		for (String key : sorted_map2.keySet()) {
			CityMuseum cm=cityMap.get(key);
			cm.setCityOrder(index++);
      	}
		for (String key : ids) {
			cityList.add(cityMap.get(key));
		}
		for (CityMuseum cityCount : cityList) {
			cityCount.setMuseumCount(cityCount.getMuseum().size());
		}
		return cityList;
	}
	
	
	private String change(int count){
		//接收输入的整数
		String str=String.valueOf(count);
		
		//把整数转化为字符串
		StringBuilder sb=new StringBuilder(str);
		
		for(int i=0;i<str.length();i++){
	   	if(i<2){
	   		sb.setCharAt(i, str.charAt(i));
	   	}else sb.setCharAt(i, '0');
	   }
	   String s=sb.toString();
	   return s;
	}
	
	@RequestMapping("getmuseumList")
	@ResponseBody
	//手机端查询列表
	public JsonResult getmuseumList(@ModelAttribute MuseumInfoDto museumInfoDto,@ModelAttribute Category category,@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue="2") Integer flag){
		List<CityMuseum> cityList =  areaService.getOrgList();
		Page page= new Page(6);
		page.setCurrentPage(currentPage);
		//0是未发布(取消发布)状态,1是发布状态
		Integer orgId = null;
		List<MuseumInfo> museumList = museumInfoService.findByMap(Tools.getMap(), " new MuseumInfo(id,museumName,level,ticket, openingHours,address,orgId,cityId) ", null, null);
		List<Category> categoryList = categoryService.findByMap(null," new Category(categoryName, orgId,id) ",null,null);
		String order = " ORDER BY ";
		//flag排序标识 1/最新排序   	2/最热排序	3/区域排序
		if(flag == 1){
			order += "  o.updatedTime DESC, ";
		}
		if(flag == 2){
			order += " i.clickCount DESC, ";
		}
		if(flag == 3){
			order += " c.sequence DESC, o.sequence DESC, ";
		}
		order += " o.id ASC ";
//		String hql = "SELECT new com.tj720.mip.dto.MuseumInfoDto(o.id as museumId ,o.name as museumName) FROM MipOrganization as o, MipArea as c where o.cityId=c.id "
//				+ "and  o.platformId = 2 and o.open = 1 and o.status > 0 and o.isdelete = 0 "+order;
//		String hql = "SELECT new com.tj720.mip.dto.MuseumInfoDto(o.id as museumId ,o.name as museumName) FROM MipOrganization as o, MipArea as c,MuseumInfo as i"
//				+ " where i.orgId = o.id and  o.cityId=c.id and  o.platformId = 2 and o.open = 1 and o.status > 0 and o.isdelete = 0 "+order;
		String hql = areaService.getSeachHql(museumInfoDto);
		hql += order; 
		List<MuseumInfoDto> musList = (List<MuseumInfoDto>) areaService.queryDtoByHql(hql, Tools.getMap(),page);
//		List<MuseumInfoDto> musList = (List<MuseumInfoDto>) areaService.queryByDto(hql, Tools.getMap(),page);
//		List<MuseumInfoDto> musList = (List<MuseumInfoDto>) areaService.queryByHql(hql, Tools.getMap(),page);
		ArrayList<MuseumInfoDto> museumArr = new ArrayList<>();
		for (MuseumInfoDto museum : musList) {
			for (MuseumInfo mus : museumList) {
				if(museum.getMuseumId().equals(String.valueOf(mus.getOrgId()))){
					List<MipMuseumCarousel> carousel = museumCarouselService.findByMap(Tools.getMap("museumInfoId",museum.getMuseumInfoId()), "new MipMuseumCarousel(id,pictureid,url)", null, null);
					if(carousel.size() > 0){
						Picture picture = pictureService.get(carousel.get(0).getPictureid());
						museum.setMuseumPicture(config.getRootUrl()+picture.getUrl());
					}
					museum.setMuseumAddress(mus.getAddress());
					museum.setMuseumOpenTime(mus.getOpeningHours());
					museum.setMuseumTicket(mus.getTicket());
					museum.setMuseumCityId(mus.getCityId());
					museumArr.add(museum);
					break;
				}
			}
		}
		if(page.getTotalPage() < currentPage){
			museumArr.clear();
		}
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("cityList", cityList);
		hashMap.put("museumArr", museumArr);
		hashMap.put("categoryList", categoryList);
		return new JsonResult(1,hashMap,page,null);
	}
	
	
	@RequestMapping("getmuseumListMB")
	@ResponseBody
	//手机端查询列表
	public JsonResult getmuseumListMB(@ModelAttribute MuseumInfoDto museumInfoDto,@ModelAttribute Category category,@RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue="2") Integer flag){
		List<CityMuseum> cityList =  areaService.getOrgListMB();
		Page page= new Page(6);
		page.setCurrentPage(currentPage);
		//0是未发布(取消发布)状态,1是发布状态
		Integer orgId = null;
		List<MuseumInfo> museumList = museumInfoService.findByMap(Tools.getMap(), " new MuseumInfo(id,museumName,level,ticket, openingHours,address,orgId,cityId) ", null, null);
		List<Category> categoryList = categoryService.findByMap(null," new Category(categoryName, orgId,id) ",null,null);
		String order = " ORDER BY ";
		//flag排序标识 1/最新排序   	2/最热排序	3/区域排序
		if(flag == 1){
			order += "  o.updatedTime DESC, ";
		}
		if(flag == 2){
			order += " i.clickCount DESC, ";
		}
		if(flag == 3){
			order += " c.sequence DESC, o.sequence DESC, ";
		}
		order += " o.id ASC ";
//		String hql = "SELECT new com.tj720.mip.dto.MuseumInfoDto(o.id as museumId ,o.name as museumName) FROM MipOrganization as o, MipArea as c where o.cityId=c.id "
//				+ "and  o.platformId = 2 and o.open = 1 and o.status > 0 and o.isdelete = 0 "+order;
//		String hql = "SELECT new com.tj720.mip.dto.MuseumInfoDto(o.id as museumId ,o.name as museumName) FROM MipOrganization as o, MipArea as c,MuseumInfo as i"
//				+ " where i.orgId = o.id and  o.cityId=c.id and  o.platformId = 2 and o.open = 1 and o.status > 0 and o.isdelete = 0 "+order;
		String hql = areaService.getSeachHqlMB(museumInfoDto);
		hql += order; 
		List<MuseumInfoDto> musList = (List<MuseumInfoDto>) areaService.queryDtoByHql(hql, Tools.getMap(),page);
//		List<MuseumInfoDto> musList = (List<MuseumInfoDto>) areaService.queryByDto(hql, Tools.getMap(),page);
//		List<MuseumInfoDto> musList = (List<MuseumInfoDto>) areaService.queryByHql(hql, Tools.getMap(),page);
		ArrayList<MuseumInfoDto> museumArr = new ArrayList<>();
		for (MuseumInfoDto museum : musList) {
			for (MuseumInfo mus : museumList) {
				if(museum.getMuseumId().equals(String.valueOf(mus.getOrgId()))){
					List<MipMuseumCarousel> carousel = museumCarouselService.findByMap(Tools.getMap("museumInfoId",museum.getMuseumInfoId()), "new MipMuseumCarousel(id,pictureid,url)", null, null);
					if(carousel.size() > 0){
						Picture picture = pictureService.get(carousel.get(0).getPictureid());
						museum.setMuseumPicture(config.getRootUrl()+picture.getUrl());
					}
					museum.setMuseumAddress(mus.getAddress());
					museum.setMuseumOpenTime(mus.getOpeningHours());
					museum.setMuseumTicket(mus.getTicket());
					museum.setMuseumCityId(mus.getCityId());
					museumArr.add(museum);
					break;
				}
			}
		}
		if(page.getTotalPage() < currentPage){
			museumArr.clear();
		}
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("cityList", cityList);
		hashMap.put("museumArr", museumArr);
		hashMap.put("categoryList", categoryList);
		return new JsonResult(1,hashMap,page,null);
	}
	
}	
