package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.tj720.admin.common.util.TimeUtil;
import com.tj720.admin.dao.map.MipFrontLogMapper;
import com.tj720.admin.dao.map.MipUserMapper;
import com.tj720.admin.dto.MipFrontLogSearchDto;
import com.tj720.admin.model.MipFrontLog;
import com.tj720.admin.model.MipFrontLogExample;
import com.tj720.admin.model.MipFrontLogExample.Criteria;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.MipFrontLogService;
import com.tj720.mip.utils.Page;
@Service
public class MipFrontLogServiceImpl implements MipFrontLogService {

	@Autowired
	private MipFrontLogMapper mipFrontLogMapper;
	@Autowired
	private MipUserMapper mipUserMapper;
	
	@Override
	public List<MipFrontLog> listMipLog(MipFrontLogSearchDto mipLog, Page page) {
		MipFrontLogExample example = new MipFrontLogExample();
		if(mipLog != null) {
			Criteria createCriteria = example.createCriteria();
			if(!StringUtil.isEmpty(mipLog.getPhone())) {
				createCriteria.andPhoneEqualTo(mipLog.getPhone());
			}
			if(!StringUtil.isEmpty(mipLog.getOpType())) {
				createCriteria.andOpTypeEqualTo(mipLog.getOpType());
			}
			if(!StringUtil.isEmpty(mipLog.getOpStatus())) {
				createCriteria.andOpStatusEqualTo(mipLog.getOpStatus());
			}
			if(!StringUtil.isEmpty(mipLog.getStateTime())) {
				String sDate2String = TimeUtil.sDate2String(mipLog.getStateTime());
				createCriteria.andCreateTimeGreaterThanOrEqualTo(sDate2String);
			}
			if(!StringUtil.isEmpty(mipLog.getEndTime())) {
				String sDate2String = TimeUtil.sDate2StringEnd(mipLog.getEndTime());
				createCriteria.andCreateTimeLessThanOrEqualTo(sDate2String);
			}
		}
		if(page != null) {
			example.setStartPage(page.getStart());
			example.setSize(page.getSize());
			int countByExample = mipFrontLogMapper.countByExample(example);
			page.setAllRow(countByExample);
		}
		example.setOrderByClause("create_time desc");
		List<MipFrontLog> selectByExample = mipFrontLogMapper.selectByExample(example);
		for(MipFrontLog ml : selectByExample) {
			String updateby = ml.getUserId();
			if(!StringUtil.isEmpty(updateby)) {
				MipUser selectByPrimaryKey = mipUserMapper.selectByPrimaryKey(updateby);
				if(selectByPrimaryKey != null)
				ml.setUserId(selectByPrimaryKey.getName());
			}
		}
		return selectByExample;
	}

}
