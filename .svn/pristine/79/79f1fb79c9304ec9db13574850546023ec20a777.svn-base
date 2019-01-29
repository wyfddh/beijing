package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.GovNoticeMapper;
import com.tj720.admin.model.GovNotice;
import com.tj720.admin.model.GovNoticeExample;
import com.tj720.admin.model.GovNoticeExample.Criteria;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.service.GovNoticeService;
import com.tj720.admin.service.ReceiveNoticeService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;

/**
*
 * @author cm
 * @date 2018年7月2日19:41:53
*/
@Service("GovNoticeService")
public class GovNoticeServiceImpl extends BaseServiceImpl<GovNotice> implements GovNoticeService {

	@Autowired
	private GovNoticeMapper govNoticeMapper;
	@Autowired
	private ReceiveNoticeService receiveNoticeService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@Override  
    public BaseDao<GovNotice> getBaseDao() {  
        return govNoticeMapper;  
    }

	@Override
	public List<GovNotice> getList(Page page, String key, String startDate, String endDate, String status,
			String publisher, String uid) {
		Map<String, Object> par = new HashMap<String, Object>();
		
		par.put("pageSize", page.getSize());
		par.put("startRow", page.getStart());
		
		//标题搜索
		if(!StringUtil.isBlank(key)) {
			par.put("title", key);
		}
		
		//开始结束时间搜索
		if(!StringUtil.isBlank(startDate) && !StringUtil.isBlank(endDate)) {
			par.put("startDate", startDate);
			par.put("endDate", endDate);
		}
		
		//状态搜索
		if(!StringUtil.isBlank(status)) {
			par.put("publishStatus", status);
		}
		
		//发布人搜索
		if(!StringUtil.isBlank(publisher)) {
			par.put("publisher", publisher);
		}
		
		//查询当前人信息
		User user = userService.get(uid);
		String currentOrgId = user.getOrgId(); 		//当前人的机构id
		//查看当前机构的所有下级机构，以及下级的下级机构
		List<MipOrganization> list = new ArrayList<>();
		mipOrganizationService.getChildListByPid(NumberUtils.stringToInt(currentOrgId), list);
		
		List<String> publishOrgList = new ArrayList<>();
		publishOrgList.add(currentOrgId);		//当前的机构id
		for (MipOrganization corg : list) {		//下级、下下级所有机构
			publishOrgList.add(corg.getId()+"");
		}
		par.put("publishorg", publishOrgList);
		List<GovNotice> selectByExample = govNoticeMapper.getList(par);
		
		List<String> publishList = new ArrayList<>();
		for (GovNotice notice : selectByExample) {
			if("2".equals(notice.getPublishStatus())) {
				publishList.add(notice.getId());
			}
		}
		if(publishList != null && publishList.size() > 0) {			//查询查阅和填报情况
			List<Map<String, String>> viewStatic = receiveNoticeService.getViewStatic(publishList);
			for (GovNotice notice : selectByExample) {
				for (Map<String, String> map : viewStatic) {
					if(notice.getId().equals((String) map.get("notice_id"))) {
						notice.setTotalLookNum(NumberUtils.stringToInt(String.valueOf(map.get("sum")), 0));		//查看总人数
						notice.setTotalWriteNum(NumberUtils.stringToInt(String.valueOf(map.get("sum")), 0));		//填报总人数
						notice.setIsLookNum(NumberUtils.stringToInt(String.valueOf(map.get("loolNum")), 0));		//已经查看人数
						notice.setIsWriteNum(NumberUtils.stringToInt(String.valueOf(map.get("writeNum")), 0));		//已经填报人数
						break;
					}
				}
			}
		}
		
		int countByExample = govNoticeMapper.countList(par);
		page.setAllRow(countByExample);
		
		return selectByExample;
	}

	@Override
	public void deleteNotice(String id) {
		//逻辑删除
		//删除通知公告机构表
		receiveNoticeService.updateStatusByNoticeId(id, "-1");
		
		//逻辑删除通知公告表
		GovNotice govNotice = new GovNotice();
		govNotice.setId(id);
		govNotice.setPublishStatus("-1");
		govNotice.setLastupdateTime(new Date());
		govNoticeMapper.updateByPrimaryKeySelective(govNotice);
	}

	@Override
	public int updateByPrimaryKeySelective(GovNotice record) {
		return govNoticeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GovNotice record) {
		return govNoticeMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelectiveOutDeadlineTime(GovNotice record) {
		return govNoticeMapper.updateByPrimaryKeySelectiveOutDeadlineTime(record);
	}

	@Override
	public List<Map<String, Object>> selectReport(String item, String name, String orgId) {
		return govNoticeMapper.selectReport(item, name, orgId);
	}

	@Override
	public Map<String, Object> selectReportById(String id) {
		return govNoticeMapper.selectReportById(id);
	}

	@Override
	public List<GovNotice> selectListByOrgId(String orgId) {
		return govNoticeMapper.selectListByOrgId(orgId);
	}

}
