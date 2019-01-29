package com.tj720.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipSpreadtrumMapper;
import com.tj720.admin.model.MipSpreadtrum;
import com.tj720.admin.model.MipVirtualExibitionHall;
import com.tj720.admin.service.MipSpreadtrumService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.SpreadtrumDto;
import com.tj720.mip.dto.VirtualDto;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
@Service("MipSpreadtrumServiceImpl")
public class MipSpreadtrumServiceImpl extends BaseServiceImpl<MipSpreadtrum> implements MipSpreadtrumService{

	@Autowired
	MipSpreadtrumMapper mipSpreadtrumMapper;
	@Override
	public BaseDao<MipSpreadtrum> getBaseDao() {
		return mipSpreadtrumMapper;
	}
	@Override
	public MipSpreadtrum get(String id) {
		return mipSpreadtrumMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SpreadtrumDto> getSpreadtrumList(List<String> orgList, String key,String type, String startTime,String endTime,String status,Page page, String currentOrg) {
		List<SpreadtrumDto> spreadtrumList = mipSpreadtrumMapper.getSpreadtrumList(orgList,key,type,startTime,endTime,status,page.getStart(),page.getSize(), currentOrg);
		int count = mipSpreadtrumMapper.countSpreadtrumList(orgList,key,type,startTime,endTime,status,currentOrg);
		page.setAllRow(count);
		return spreadtrumList;
	}

	@Override
	public int save(MipSpreadtrum spreadtrum) {
		
		return mipSpreadtrumMapper.insert(spreadtrum);
	}

	@Override
	public int delete(String id) {
		
		return mipSpreadtrumMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(MipSpreadtrum spreadtrum) {
		
		return mipSpreadtrumMapper.updateByPrimaryKeyWithBLOBs(spreadtrum);
	}
	@Override
	public int publish(String id, String status) {
		LoginInfoDto user = Tools.getUser();
		return mipSpreadtrumMapper.publish(id,status,user.getId(),new Date());
	}
	@Override
	public boolean saveDesignData(Map<String, Object> map, String userId, String orgId) {
		if(map == null) {
			return false;
		}
    	try {
    		MipSpreadtrum spreadtrum = new MipSpreadtrum();
    		spreadtrum.setUserId(userId);
    		spreadtrum.setOrgId(orgId);
    		String uuid = UUID.randomUUID().toString().replace("-", "");
    		spreadtrum.setId(uuid);
    		spreadtrum.setStatus("0");
    		spreadtrum.setClickNumber(0l);
    		spreadtrum.setCreatetime(new Date());
    		spreadtrum.setHeadline(((String[]) map.get("BD1537760233851@0300001"))[0]);		//标题-展览名称
    		spreadtrum.setExhibitionType("0"); 		//默认临时展览
    		spreadtrum.setContent(((String[]) map.get("BD1537760233851@0300018"))[0]);			//内容-展览内容简介
    		spreadtrum.setVimoveurl(((String[]) map.get("BD1537760233851@0300014"))[0]);			//展览地址-举办地
    		Object startDate = ((String[]) map.get("BD1537760233851@0300010"))[0];		//开始时间
    		if(startDate != null && startDate.toString().length() > 0) {
    			spreadtrum.setBeginTime(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(startDate)));
    		}
			Object endDate = ((String[]) map.get("BD1537760233851@0300011"))[0];		//结束时间
			if(endDate != null && endDate.toString().length() > 0) {
				spreadtrum.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(endDate)));
			}
			int save = this.save(spreadtrum);
			if(save == 1) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}
