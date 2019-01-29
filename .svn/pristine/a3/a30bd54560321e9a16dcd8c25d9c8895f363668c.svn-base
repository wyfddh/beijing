package com.tj720.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.vo.ConditionVo;
import com.tj720.admin.dao.map.MipActivityMapper;
import com.tj720.admin.model.MipActivity;
import com.tj720.admin.service.ActivityService;
import com.tj720.mip.dto.ActivityDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
import com.tj720.mip.dto.FullTextSearchDto;

@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private MipActivityMapper mipActivityMapper;
	@Autowired
	private Config config;// 常量的取法

	@Override
	public List<T> listActivity(ConditionVo<T> conditionVo) {
		return null;
	}

	@Override
	public JsonResult getActivityListByType(String activityCategory, String orgid, Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipActivityMapper.countActivityListByType(activityCategory, orgid);
		page.setAllRow(allCounts);
		List<HashMap> list = mipActivityMapper.getActivityListByType(activityCategory, orgid, startRow, page.getSize());
		for (int i = 0; i < list.size(); i++) {
			Date time = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(list.get(i) != null && list.get(i).get("activityTime") != null) {
				String[] str = list.get(i).get("activityTime").toString().split(" - ");
				if(str.length > 1 && StringUtils.isNotBlank(str[1])) {
					String otherDate = str[1];
					Date sd;
					try {
						sd = df.parse(otherDate);
						boolean hasFinished = time.after(sd);
						list.get(i).put("hasFinished", hasFinished);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			list.get(i).put("picUrl",
					addRootUrl(list.get(i).get("picUrl") == null ? "" : list.get(i).get("picUrl").toString()));
			list.get(i).put("activityTime", getSpecialDate(
					list.get(i).get("activityTime") == null ? "" : list.get(i).get("activityTime").toString()));

		}
		return new JsonResult(1, list, page);
	}

	@Override
	public HashMap getActivityListById(String activityId) {
		HashMap data = mipActivityMapper.getActivityListById(activityId);
		if (null != data) {
			data.put("picUrl", addRootUrl(data.get("picUrl") == null ? "" : data.get("picUrl").toString()));
			data.put("activityTime",
					getSpecialDate(data.get("activityTime") == null ? "" : data.get("activityTime").toString()));
		}
		return data;
	}

	private String addRootUrl(String url) {
		if (null != url && url != "") {
			return config.getRootUrl() + url;
		} else {
			return url;
		}
	}
	//
	// private static String getSpecialDate(String date){
	// if(null != date && date!=""){
	// String[] str = date.split(" - ");
	// String[] mainDate = str[0].split(" ");
	// String[] otherDate = str[1].split(" ");
	// String day = mainDate[0];
	// String startTime = mainDate[1].substring(0, 5);
	// String endTime = otherDate[1].substring(0, 5);
	// date = day + " " + startTime+"~"+endTime;
	// return date;
	// }else
	// {
	// return date;
	// }
	// }

	private static String getSpecialDate(String date) {
		if (null != date && date != "") {
			String[] str = date.split(" - ");
			String[] mainDate = str[0].split(" ");
			String[] otherDate = str[1].split(" ");
			String day = mainDate[0];
			String endday = otherDate[0];
			String startTime = mainDate[1].substring(0, 5);
			String endTime = otherDate[1].substring(0, 5);
			// date = day + " " + startTime+"~"+endTime;
			if (day.equals(endday)) {
				date = day + " " + startTime + "~" + endTime;
			} else {
				// startTime = startTime.substring(0,3);
				// endTime = endTime.substring(0, 3);
				date = day + " " + startTime + "~" + endday + " " + endTime;
			}
			return date;
		} else {
			return date;
		}
	}

	// 后台接口
	@Override
	public MipActivity get(String id) {
		return mipActivityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ActivityDto> getActivityList(List<String> orgList, String key, String type, String startTime,
			String endTime, String status, Page page, String currentOrg) {
		List<ActivityDto> activityList = mipActivityMapper.getActivityList(orgList, key, type, status, startTime, endTime,
				page.getStart(), page.getSize(), currentOrg);
		int count = mipActivityMapper.countActivityList(orgList, key, type, status, startTime, endTime, currentOrg);
		page.setAllRow(count);
		return activityList;
	}

	@Override
	public int save(MipActivity activity) {

		return mipActivityMapper.insert(activity);
	}

	@Override
	public int delete(String id) {

		return mipActivityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(MipActivity activity) {

		return mipActivityMapper.updateByPrimaryKeyWithBLOBs(activity);
	}

	@Override
	public int publish(String id, String status) {
		LoginInfoDto user = Tools.getUser();
		return mipActivityMapper.publish(id, status, user.getId(), new Date());
	}

	@Override
	public JsonResult fullTextSearch(Page page, String key, String type) {
		List<FullTextSearchDto> fullTextSearchs = new ArrayList<FullTextSearchDto>();
		List<FullTextSearchDto> fullTextSearchsNew = new ArrayList<FullTextSearchDto>();
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipActivityMapper.countFullTextSearch(key, type);
		page.setAllRow(allCounts);
		fullTextSearchs = mipActivityMapper.fullTextSearch(key, type, startRow, page.getSize());
		for (FullTextSearchDto fullTextSearch : fullTextSearchs) {
			if ("6".equals(fullTextSearch.getType())) {
				fullTextSearch.setUrl(config.getRootUrl() + fullTextSearch.getUrl());
			}
			fullTextSearchsNew.add(fullTextSearch);
		}
		return new JsonResult(1, fullTextSearchsNew, page);
	}

	@Override
	public boolean saveDesignData(Map<String, Object> map, String userId, String orgId, String type) {
		MipActivity activity = new MipActivity();
		activity.setUserId(userId);
		activity.setOrgId(orgId);
		String uuid = UUID.randomUUID().toString().replace("-", "");
		activity.setId(uuid);
		activity.setStatus("0");
		activity.setCreatetime(new Date());
		
		if("1".equals(type)) {
			activity.setActivityName(((String[]) map.get("BD1537761254852@0401001"))[0]);		//活动标题-活动名称
			activity.setContent(((String[]) map.get("BD1537761254852@0401009"))[0]);		//内容-新闻稿
			String date = ((String[]) map.get("BD1537761254852@0401003"))[0];
			if(StringUtils.isNotBlank(date)) {
				activity.setActivityTime(date+" 00:00:00 - " + date +" 23:59:59");		//活动时间-活动时间
			}
			activity.setActivityPlace(((String[]) map.get("BD1537761254852@0401004"))[0]);		//地址-活动地点
			activity.setModule(((String[]) map.get("BD1537761254852@0401007"))[0]);		//活动描述-活动内容梗概
			activity.setActivityCategory(type);		//类型 1：活动 2：讲座
		}else if("2".equals(type)) {
			activity.setActivityName(((String[]) map.get("BD1537762904059@0402001"))[0]);		//讲座标题-讲座名称
			activity.setContent(((String[]) map.get("BD1537762904059@0402006"))[0]);		//内容-活动内容梗概
			String date = ((String[]) map.get("BD1537762904059@0402002"))[0];
			if(StringUtils.isNotBlank(date)) {
				Date stringToDate = DateUtil.StringToDate(date);
				Date addDay = DateUtil.addDay(stringToDate, 1);
				activity.setActivityTime(DateUtil.DateToString(stringToDate, DateStyle.YYYY_MM_DD_HH_MM_SS) + " - " + DateUtil.DateToString(addDay, DateStyle.YYYY_MM_DD_HH_MM_SS));		//讲座时间-讲座时间
			}
			activity.setActivityPlace(((String[]) map.get("BD1537762904059@0402003"))[0]);		//地址-讲座地点
			activity.setSpeaker(((String[]) map.get("BD1537762904059@0402005"))[0]);		//主讲人-主讲人
			activity.setActivityCategory(type);		//类型 1：活动 2：讲座
		}else {
			return false;
		}
		
		int flag = this.save(activity);
		if (flag == 1) {
			return true;
		}
		return false;
	}

}
