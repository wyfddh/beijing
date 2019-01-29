package com.tj720.mip.service.table;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.admin.dao.map.MipOrganizationMapper;
import com.tj720.admin.model.MipOrganizationExample;
import com.tj720.admin.model.MipOrganizationExample.Criteria;
import com.tj720.mip.dao.MipOrganizationDao;
import com.tj720.mip.dto.CityMuseumDto;
import com.tj720.mip.dto.LatLong;
import com.tj720.mip.dto.MuseumDto;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.MuseumCarouselService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.MipMuseumCarousel;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.GeogUtil;
import com.tj720.mip.utils.GetLatAndLngByBaidu;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.SortListUtil;
import com.tj720.mip.utils.Tools;

@Service
public class MipOrganizationService extends BaseService<MipOrganization> implements IMipOrganizationService {
	
	@Autowired
	private AreaService areaService;
	@Autowired
	private Config config;
	@Autowired
	private MuseumInfoService museumInfoService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private MuseumCarouselService museumCarouselService;// 博物馆轮播图
	@Autowired
	private MipOrganizationMapper mipOrganizationMapper;

	@Resource(name = "mipOrganizationDao")
	MipOrganizationDao mipOrganizationDao;

	@Resource(name = "mipOrganizationDao")
	public void setDao(IBaseDao<MipOrganization> dao) {
		super.setDao(dao);
	}
	

	@Override
	@Transactional
	public MipOrganization get(String id) {
		MipOrganization model = mipOrganizationDao.get(id);
		if (model == null)
			return new MipOrganization();
		return model;
	}

	@Override
	@Transactional
	public List<MipOrganization> queryBySql(String sql) {
		return mipOrganizationDao.queryBySql(sql);
	}

	/**
	 * 博物馆的城市博物馆集合
	 */
	@Override
	@Transactional
	public List<CityMuseumDto> getCityMuseum() {
		ArrayList<CityMuseumDto> cityMuseumDtos = new ArrayList<CityMuseumDto>();
		//查询城市的集合
		String hql = "select new MipArea(id, shortname) from MipArea  where pid = " +config.getProvinceId()+ " and level = 2";
		List<MipArea> cityList = (List<MipArea>) areaService.queryByHql(hql, Tools.getMap());
		if (!MyString.isEmpty(cityList)) {
			for (MipArea mipArea : cityList) {
				//创建dto对象保存数据
				CityMuseumDto cityMuseumDto = new CityMuseumDto();
				String cityId = mipArea.getId();
				String mus_hql = "select new MipOrganization(id, name) from MipOrganization where  cityId = '" + cityId + "' and level = 3 and open = 1 order by sequence desc";
				List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationDao.queryByHql(mus_hql, Tools.getMap());
				if (!MyString.isEmpty(musList)) {
					for (MipOrganization mipOrganization : musList) {
						String orgId = mipOrganization.getId();
						List<MuseumInfo> museumInfos = (List<MuseumInfo>) museumInfoService.queryByHql("select new MuseumInfo(logo) from MuseumInfo where orgId = '"+ orgId +"'", Tools.getMap());
						if (!MyString.isEmpty(museumInfos)) {
							MuseumInfo museumInfo = museumInfos.get(0);
							String logoId = museumInfo.getLogo();
							if (!MyString.isEmpty(logoId)) {
								Picture picture = pictureService.get(logoId);
								if (!MyString.isEmpty(picture.getUrl())) {
									mipOrganization.setLogo(config.getRootUrl() + picture.getUrl());
								}
							}
						}
					}
				}
				cityMuseumDto.setId(cityId);
				cityMuseumDto.setName(mipArea.getShortname());
				cityMuseumDto.setMuseum(musList);
				cityMuseumDtos.add(cityMuseumDto);
			}
		}
		return cityMuseumDtos;
	}
	
	/**
	 * 藏品列表的城市博物馆集合
	 */
	@Override
	@Transactional
	public List<CityMuseumDto> getCityMuseumForColl() {
		ArrayList<CityMuseumDto> cityMuseumDtos = new ArrayList<CityMuseumDto>();
		//查询城市的集合
		String hql = "select new MipArea(id, shortname) from MipArea  where pid = " +config.getProvinceId()+ " and level = 2";
		List<MipArea> cityList = (List<MipArea>) areaService.queryByHql(hql, Tools.getMap());
		if (!MyString.isEmpty(cityList)) {
			for (MipArea mipArea : cityList) {
				//创建dto对象保存数据
				CityMuseumDto cityMuseumDto = new CityMuseumDto();
				String cityId = mipArea.getId();
				String mus_hql = "select distinct new MipOrganization(o.id as id, o.name as name) from MipYearCategory y, MipOrganization o where y.collectionUnit = o.id and y.cityId = '" + cityId + "' order by o.sequence desc";
				List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationDao.queryByHql(mus_hql, Tools.getMap());
				if (!MyString.isEmpty(musList)) {
					for (MipOrganization mipOrganization : musList) {
						String orgId = mipOrganization.getId();
						List<MuseumInfo> museumInfos = (List<MuseumInfo>) museumInfoService.queryByHql("select new MuseumInfo(logo) from MuseumInfo where orgId = '"+ orgId +"'", Tools.getMap());
						if (!MyString.isEmpty(museumInfos)) {
							MuseumInfo museumInfo = museumInfos.get(0);
							String logoId = museumInfo.getLogo();
							if (!MyString.isEmpty(logoId)) {
								Picture picture = pictureService.get(logoId);
								if (!MyString.isEmpty(picture.getUrl())) {
									mipOrganization.setLogo(config.getRootUrl() + picture.getUrl());
								}
							}
						}
					}
				}
				cityMuseumDto.setId(cityId);
				cityMuseumDto.setName(mipArea.getShortname());
				cityMuseumDto.setMuseum(musList);
				cityMuseumDtos.add(cityMuseumDto);
			}
		}
		return cityMuseumDtos;
	}

	/**
	 * 获取最热博物馆（2个）
	 */
	@Override
	@Transactional
	public List<MuseumDto> gethots(String cityId, int size) {
		// 查询博物馆
		List<MuseumDto> museumDtos = getAllMusFromCity(cityId, size);
		// 设置图片
		if (!MyString.isEmpty(museumDtos)) {
			for (MuseumDto museumDto : museumDtos) {
				String infoId = museumDto.getInfoId();
				List<MipMuseumCarousel> carousels = (List<MipMuseumCarousel>) museumCarouselService.queryByHql(
						"select new MipMuseumCarousel(pictureid) from MipMuseumCarousel where museumInfoId = '"
								+ infoId + "'",
						Tools.getMap());
				if (!MyString.isEmpty(carousels)) {
					MipMuseumCarousel mipMuseumCarousel = carousels.get(0);
					if (!MyString.isEmpty(mipMuseumCarousel)) {
						String pictureId = mipMuseumCarousel.getPictureid();
						Picture picture = pictureService.get(pictureId);
						String picUrl = picture.getThumb1();
						if (!MyString.isEmpty(picUrl)) {
							picUrl = config.getRootUrl() + picUrl;
						} else {
							picUrl = "";
						}
						museumDto.setPicUrl(picUrl);
					}
				}
			}

		}
		return museumDtos;
	}

	/**
	 * 根据经纬度查询所属哪个城市（没有返回长春市id）
	 */
	@Override
	@Transactional
	public String getCityFromLatLong(double latitude, double longitude) {
		String cityId = "";
		//秘钥
		String ak = config.getAk();
		//转换为百度经纬度
		LatLong latLong = GetLatAndLngByBaidu.tranLatLong(ak, latitude, longitude);
		double lat = latLong.getX();//经度
		double lng = latLong.getY();//纬度
		//通过经纬度解析出所在城市
		String cityName = GetLatAndLngByBaidu.parseLatLngToCity(ak, lat, lng);
		System.out.println("cityName=" +cityName + "&&&&&cityId=" +cityId);
		if (MyString.isEmpty(cityName)) {
			return config.getCityId();
		}
		//判断解析出来的城市是否在吉林九个城市之中
		List<MipArea> areas = areaService.findByMap(Tools.getMap("pid",config.getProvinceId()), "new MipArea(id,pid,name)", null, null);
		if (!MyString.isEmpty(areas)) {
			for (MipArea mipArea : areas) {
				if (cityName.equals(mipArea.getName())) {
					cityId = mipArea.getId();
					break;
				} else {
					cityId = config.getCityId();
				}
			}
			
		}
		System.out.println("cityId=" + cityId);
		return cityId;
	}
	
	/**
	 * 根据经纬度查询附近博物馆（包括图片）（所有）
	 */
	@Override
	@Transactional
	public List<MuseumDto> getNear(String cityId, double latitude, double longitude) {
		List<MuseumDto> museums = new ArrayList<MuseumDto>();
		if (!MyString.isEmpty(cityId)) {
			String hql = "from MipOrganization where cityId = '"+ cityId +"' and platformId = '" + config.getPlatformId() + "' and level = 3 and open =1 and isdelete = 0"
					+ " and latitude > " + (latitude - 1) + " and latitude < " + (latitude + 1) + " and longitude > "+ (longitude-1) +" and longitude < " + (longitude+1);
			List<MipOrganization> orgs = (List<MipOrganization>) mipOrganizationDao.queryByHql(hql, Tools.getMap());
			if (!MyString.isEmpty(orgs)) {
				for (MipOrganization org : orgs) {
					MuseumDto museumDto = new MuseumDto();
					museumDto.setId(org.getId());
					museumDto.setName(org.getName());
					String orgId = org.getId();
					List<MuseumInfo> museumInfos = (List<MuseumInfo>) museumInfoService.queryByHql("from MuseumInfo where orgId = '"+ orgId +"'", Tools.getMap());
					if (!MyString.isEmpty(museumInfos)) {
						MuseumInfo museumInfo = museumInfos.get(0);
						String infoId = museumInfo.getId();
						List<MipMuseumCarousel> carousels = (List<MipMuseumCarousel>) museumCarouselService.queryByHql(
								"select new MipMuseumCarousel(pictureid) from MipMuseumCarousel where museumInfoId = '"
										+ infoId + "'",
								Tools.getMap());
						if (!MyString.isEmpty(carousels)) {
							MipMuseumCarousel mipMuseumCarousel = carousels.get(0);
							if (!MyString.isEmpty(mipMuseumCarousel)) {
								String pictureId = mipMuseumCarousel.getPictureid();
								Picture picture = pictureService.get(pictureId);
								String picUrl = picture.getThumb1();
								if (!MyString.isEmpty(picUrl)) {
									picUrl = config.getRootUrl() + picUrl;
								} else {
									picUrl = "";
								}
								museumDto.setPicUrl(picUrl);
							}
						}
					}
					double mus_latitude = org.getLatitude();
					double mus_longitude = org.getLongitude();
					double meter = GeogUtil.lantitudeLongitudeDist(latitude, longitude, mus_latitude, mus_longitude);
					museumDto.setDistance(meter);
					museums.add(museumDto);
				}
			}
		}
		//按照距离正序排序
		museums = (List<MuseumDto>) SortListUtil.sort(museums, "distance", "asc");
		
		return museums;
	}
	
	
	/**
	 * 根据经纬度查询附近博物馆（id和名称），并按距离正排
	 */
	@Override
	@Transactional
	public List<MuseumDto> getNearSimple(String cityId, double latitude, double longitude) {
		List<MuseumDto> museums = new ArrayList<MuseumDto>();
		if (!MyString.isEmpty(cityId)) {
			String hql = "from MipOrganization where cityId = '"+ cityId +"' and platformId = '" + config.getPlatformId() + "' and level = 3 and open =1 and isdelete = 0"
					+ " and latitude > " + (latitude - 1) + " and latitude < " + (latitude + 1) + " and longitude > "+ (longitude-1) +" and longitude < " + (longitude+1);
			List<MipOrganization> orgs = (List<MipOrganization>) mipOrganizationDao.queryByHql(hql, Tools.getMap());
			if (!MyString.isEmpty(orgs)) {
				for (MipOrganization org : orgs) {
					MuseumDto museumDto = new MuseumDto();
					museumDto.setId(org.getId());
					museumDto.setName(org.getName());
					double mus_latitude = org.getLatitude();
					double mus_longitude = org.getLongitude();
					double meter = GeogUtil.lantitudeLongitudeDist(latitude, longitude, mus_latitude, mus_longitude);
					museumDto.setDistance(meter);
					museums.add(museumDto);
				}
			}
		}
		//按照距离正序排序
		museums = (List<MuseumDto>) SortListUtil.sort(museums, "distance", "asc");
		return museums;
	}
	

	/**
	 * 根据城市id查询该城市下所有博物馆
	 */
	@Override
	@Transactional
	public List<MuseumDto> getHotMuseumsFromCity(String cityId) {
		List<MuseumDto> gethots = gethots(cityId,Integer.MAX_VALUE);
		return gethots;
	}
	
	/**
	 * 查询城市下所有博物馆
	 * @param cityId
	 * @param size
	 * @return
	 */
	@Override
	@Transactional
	public List<MuseumDto> getAllMusFromCity(String cityId, int size) {
		Page page = new Page();
		page.setSize(size);
		// 查询数据集合
		List<MuseumDto> museumDtos = new ArrayList<MuseumDto>();
		// 查询语句
		String hql = "select new com.tj720.mip.dto.MuseumDto(o.id as id, o.name as name, m.id as infoId, m.clickCount as clickCounts) from MipOrganization o, MuseumInfo m where o.id = m.orgId and o.platformId = '"
				+ config.getPlatformId() + "' and o.level =3 and o.open = 1 and o.isdelete = 0 and o.cityId = '"+ cityId +"'  order by m.clickCount desc";
		// 查询结果
		museumDtos = (List<MuseumDto>) mipOrganizationDao.findLimitByHql(hql, size);
		return museumDtos;
	}
	
	/**
	 * 根据经纬度查询附近博物馆（所有）,不要图片
	 */
	@Override
	@Transactional
	public List<MuseumDto> getNearAll(String cityId, double latitude, double longitude) {
		List<MuseumDto> museums = new ArrayList<MuseumDto>();
		if (!MyString.isEmpty(cityId)) {
			String hql = "from MipOrganization where cityId = '"+ cityId +"' and platformId = '" + config.getPlatformId() + "' and level = 3 and open =1 and isdelete = 0"
					+ " and latitude > " + (latitude - 1) + " and latitude < " + (latitude + 1) + " and longitude > "+ (longitude-1) +" and longitude < " + (longitude+1);
			List<MipOrganization> orgs = (List<MipOrganization>) mipOrganizationDao.queryByHql(hql, Tools.getMap());
			if (!MyString.isEmpty(orgs)) {
				for (MipOrganization org : orgs) {
					MuseumDto museumDto = new MuseumDto();
					museumDto.setId(org.getId());
					museumDto.setName(org.getName());
					double mus_latitude = org.getLatitude();
					double mus_longitude = org.getLongitude();
					double meter = GeogUtil.lantitudeLongitudeDist(latitude, longitude, mus_latitude, mus_longitude);
					museumDto.setDistance(meter);
					museums.add(museumDto);
				}
			}
		}
		//按照距离正序排序
		museums = (List<MuseumDto>) SortListUtil.sort(museums, "distance", "asc");
		
		return museums;
	}

	/**
	 * 获取整个省的热门博物馆
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<MuseumDto> getHotMuseums(Page page) {
		List<MuseumDto> museumDtos = new ArrayList<MuseumDto>();
		// 查询语句
		String hql = "select new com.tj720.mip.dto.MuseumDto(o.id as id, o.name as name, m.id as infoId, m.clickCount as clickCounts) from MipOrganization o, MuseumInfo m where o.id = m.orgId and o.platformId = '"
				+ config.getPlatformId() + "' and o.level =3 and o.open = 1 and o.isdelete = 0 order by m.clickCount desc";
		// 查询结果
		museumDtos = (List<MuseumDto>) mipOrganizationDao.queryDtoByHql(hql, Tools.getMap(), page);
		// 设置图片
			if (!MyString.isEmpty(museumDtos)) {
				for (MuseumDto museumDto : museumDtos) {
					String infoId = museumDto.getInfoId();
					List<MipMuseumCarousel> carousels = (List<MipMuseumCarousel>) museumCarouselService.queryByHql(
							"select new MipMuseumCarousel(pictureid) from MipMuseumCarousel where museumInfoId = '"
									+ infoId + "'",
							Tools.getMap(), page);
					if (!MyString.isEmpty(carousels)) {
						MipMuseumCarousel mipMuseumCarousel = carousels.get(0);
						if (!MyString.isEmpty(mipMuseumCarousel)) {
							String pictureId = mipMuseumCarousel.getPictureid();
							Picture picture = pictureService.get(pictureId);
							String picUrl = picture.getThumb1();
							if (!MyString.isEmpty(picUrl)) {
								picUrl = config.getRootUrl() + picUrl;
							} else {
								picUrl = "";
							}
							museumDto.setPicUrl(picUrl);
						}
					}
				}
			}
		return museumDtos;
	}

	/**
	 * 根据传的orgid查询parentid等于该orgid的组织集合
	 */
	@Override
	public List<MipOrganization> getListById(String orgId) {
		
		return mipOrganizationMapper.getListById(orgId);
	}


	@Override
	public List<MipOrganization> getListByArea(String area) {
	
		return mipOrganizationMapper.getListByArea(area);
	}

	//查 全部组织
	public List<com.tj720.admin.model.MipOrganization> getList() {
		return mipOrganizationMapper.getList();
	}

	public List<MipOrganization> getPageList(String key,String orgTypeId,String platformId,Page page) {
		int count = mipOrganizationMapper.countPageList(key,orgTypeId,platformId);
		page.setAllRow(count);
		return mipOrganizationMapper.getPageList(key,orgTypeId,platformId,page.getStart(),page.getSize());
	}

	@Override
	public List<com.tj720.admin.model.MipOrganization> getChildListByPid(Integer parentId, List<com.tj720.admin.model.MipOrganization> list) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo((byte) 1);
		List<com.tj720.admin.model.MipOrganization> resuleList = mipOrganizationMapper.selectByExample(example);
		list.addAll(resuleList);
		for (com.tj720.admin.model.MipOrganization mipOrg : resuleList) {
			getChildListByPid(mipOrg.getId(), list);
		}
		return list;
	}


	@Override
	public List<com.tj720.admin.model.MipOrganization> getAllByProvince(String province, String city, String town, String orgTypeId,
			String key) {
		return mipOrganizationMapper.getListByProvince(province, city, town, orgTypeId, key);
	}


	@Override
	public List<MipOrganization> getListByOrgTypeId(String orgTypeId) {
		// TODO Auto-generated method stub
		return mipOrganizationMapper.getListByOrgTypeId(orgTypeId);
	}


	@Override
	public List<com.tj720.admin.model.MipOrganization> getLitleOrgByParmOrg(
			List<com.tj720.admin.model.MipOrganization> source) {
		return mipOrganizationMapper.getLitleOrgByParmOrg(source);
	}
	
}
