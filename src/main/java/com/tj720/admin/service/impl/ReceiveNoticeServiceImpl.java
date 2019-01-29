package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GovNoticeMapper;
import com.tj720.admin.dao.map.GovNoticeOrgMapper;
import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.dto.ReceiveNoticeDetailDto;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.GovNoticeOrg;
import com.tj720.admin.model.GovNoticeOrgExample;
import com.tj720.admin.model.GovNoticeOrgExample.Criteria;
import com.tj720.admin.service.ReceiveNoticeService;
import com.tj720.mip.utils.Page;


/**
 * @author lc
 *
 */
@Service
public class ReceiveNoticeServiceImpl implements ReceiveNoticeService{

	@Autowired 
	private GovNoticeOrgMapper govNoticeOrgMapper;
	@Autowired
	private GovNoticeMapper govNoticeMapper;
	@Override
	public List<MipUserDto> getUsers(String userOrg, String role) {
		List<MipUserDto> users = govNoticeOrgMapper.getUsers(userOrg,role);
		return users;
	}

	@Override
	public List<ReceiveNoticeDto> getList(String userId, String userOrg, List<MipUserDto> users,
			String key, String startTime, String endTime, String isFeedBack,
			String publishOrg, String receiveStatus, Page page) {
		List<ReceiveNoticeDto> list = govNoticeOrgMapper.getList(userId,userOrg,key,startTime,endTime,isFeedBack,publishOrg,receiveStatus,page.getStart(),page.getSize());
		for(ReceiveNoticeDto receiveNoticeDto : list){
			//如果没有转发人 取通知接收角色的人 为当前负责人
			if(StringUtils.isBlank(receiveNoticeDto.getReceiver())){
				String receiverRole = "";
				for(MipUserDto user : users){
					receiverRole +=  user.getName()+",";
				}
				receiverRole = receiverRole.substring(0, receiverRole.length()-1);
				receiveNoticeDto.setReceiver(receiverRole);
			} 
			if(receiveNoticeDto.getDeadlineTime() !=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String deadlineTimeStr = sdf.format(receiveNoticeDto.getDeadlineTime());
				receiveNoticeDto.setDeadlineTimeStr(deadlineTimeStr);
			}
		}
		return list;
	}

	@Override
	public Integer countList(String userId, String userOrg, String key,
			String startTime, String endTime, String isFeedBack,
			String publishOrg, String receiveStatus) {
		Integer count = govNoticeOrgMapper.countList(userId,userOrg,key,startTime,endTime,isFeedBack,publishOrg,receiveStatus);
		return count;
	}

	@Override
	public void changeStatus(String id, String receiveStatus,String reportId) {
		if("1".equals(receiveStatus) || "5".equals(receiveStatus)){
			//未查阅状态 点进来 赋值查阅时间
			Date viewTime = new Date();
			govNoticeOrgMapper.changeStatus(id,receiveStatus,viewTime,null,reportId);
		}else if("2".equals(receiveStatus)){
				govNoticeOrgMapper.changeStatus(id,receiveStatus,null,null,reportId);
		}else if("4".equals(receiveStatus)){
			//同时更新提交时间
			Date writeTime = new Date();
			govNoticeOrgMapper.changeStatus(id,receiveStatus,null,writeTime,reportId);
		}else{
			govNoticeOrgMapper.changeStatus(id,receiveStatus,null,null,reportId);
		}
		
	}

	@Override
	public void changeReceiver(String id, String receiver) {
		govNoticeOrgMapper.changeReceiver(id,receiver);
	}

	@Override
	public void batchSave(List<GovNoticeOrg> list) {
		govNoticeOrgMapper.insertByBatch(list);
	}

	@Override
	public int updateStatusByNoticeId(String noticeId, String status) {
		GovNoticeOrgExample example = new GovNoticeOrgExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoticeIdEqualTo(noticeId);
		GovNoticeOrg record = new GovNoticeOrg();
		record.setReceiveStatus(status);
		if("3".equals(status)) {
			record.setReceiver("");
		}
		return govNoticeOrgMapper.updateByExampleSelective(record, example);
	}
	@Override
	public ReceiveNoticeDetailDto getDetail(String id) {
		ReceiveNoticeDetailDto receiveNoticeDetail = new ReceiveNoticeDetailDto();
		receiveNoticeDetail = govNoticeOrgMapper.getDetail(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(receiveNoticeDetail.getDeadlineTime()!=null){
			String deadlineTimeStr = sdf.format(receiveNoticeDetail.getDeadlineTime());
			receiveNoticeDetail.setDeadlineTimeStr(deadlineTimeStr);
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		if(receiveNoticeDetail.getLastupdateTime()!=null){
			String publishTime = sdf1.format(receiveNoticeDetail.getLastupdateTime());
			receiveNoticeDetail.setPublishTime(publishTime);
		}
		return receiveNoticeDetail;
				
	}
	@Override
	public List<GovNoticeOrg> getListByNoticeId(String noticeId) {
		List<GovNoticeOrg> selectByExample = govNoticeOrgMapper.getListByNoticeId(noticeId);
		return selectByExample;
	}

	@Override
	public int deleteByOrgIdAndNoticeid(String orgId, String noticeId) {
		GovNoticeOrgExample example = new GovNoticeOrgExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(orgId);
		criteria.andNoticeIdEqualTo(noticeId);
		GovNoticeOrg org = new GovNoticeOrg();
		org.setReceiveStatus("-1");
		return govNoticeOrgMapper.updateByExampleSelective(org, example);
	}

	@Override
	public List<Map<String, String>> getViewStatic(List<String> noticeIds) {
		return govNoticeOrgMapper.getViewStatic(noticeIds);
	}

	@Override
	public List<ReceiveNoticeDto> getListByNoticeId(String noticeId, String key, String lookStatus, String writeStatus,Page page) {
		int count = govNoticeOrgMapper.countReceiveConditionList(noticeId, key, lookStatus, writeStatus);
		page.setAllRow(count);
		return govNoticeOrgMapper.selectReceiveConditionList(noticeId, key, lookStatus, writeStatus, page.getStart(),page.getSize());
	}

	@Override
	public List<String> getReceverList(String[] orgId) {
		return govNoticeOrgMapper.getReceiverByOrgids(orgId);
	}

	@Override
	public List<String> getForwardByOrgids(String[] orgs, String noticeId) {
		return govNoticeOrgMapper.getForwardByOrgids(orgs, noticeId);
	}
	/**
	 * 查博物馆工作台通知公告列表
	 */
	@Override
	public List<ReceiveNoticeDto> getNoticeForMuseumDesk(String orgId){
		
		List<ReceiveNoticeDto> list = govNoticeOrgMapper.getNoticeListForDesk(orgId);
		
		for(ReceiveNoticeDto receiveNoticeDto : list){
			
			String isFeedBack = receiveNoticeDto.getIsFeedBack();
			if("1".equals(isFeedBack)){
				//查询填报的自定义表单信息
				Map<String, Object> selectReportById = govNoticeMapper.selectReportById(receiveNoticeDto.getReportCode());
				if (selectReportById != null && !StringUtils.isBlank(selectReportById.get("id").toString())) {
					receiveNoticeDto.setReportName(selectReportById.get("buss_name").toString());
					receiveNoticeDto.setDefineCode(selectReportById.get("buss_code").toString());
					receiveNoticeDto.setDefineId(selectReportById.get("define_id").toString());
				}
			}
			//时间格式转换
			if(receiveNoticeDto.getDeadlineTime() !=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String deadlineTimeStr = sdf.format(receiveNoticeDto.getDeadlineTime());
				receiveNoticeDto.setDeadlineTimeStr(deadlineTimeStr);
			}
			//发布时间距离现在时间差提示
			if(receiveNoticeDto.getLastUpdateTime() !=null){
				String timeTip = Utils.getDistanceDaysOrHours(receiveNoticeDto.getLastUpdateTime(),new Date());
				receiveNoticeDto.setTimeTip(timeTip);
			}
		}
		return list;
	}
}
