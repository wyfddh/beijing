package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.dto.ReceiveNoticeDetailDto;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.GovNoticeOrg;
import com.tj720.mip.utils.Page;

/**
 * @author lc
 *
 */
public interface ReceiveNoticeService{
	//条件查询分页 消息接收列表
	Integer countList(String userId, String userOrg,String key, String startTime,String endTime, String isFeedBack, String publishOrg,String receiveStatus);
	List<ReceiveNoticeDto> getList(String userId,String userOrg,List<MipUserDto> users, String key, String startTime, String endTime, String isFeedBack, String publishOrg, String receiveStatus, Page page);
	
	//根据获取当前部门 通知消息接收人角色 获取人员
	List<MipUserDto> getUsers(String userOrg, String role);

	//修改查阅状态
	void changeStatus(String id, String receiveStatus, String reportId);
	//转发接收人
	void changeReceiver(String id, String receiver); 
	
	/**
	 * 批量保存
	 * @param list
	 */
	void batchSave(List<GovNoticeOrg> list);
	
	/**
	 * 根据通知公告id，修改接收状态
	 * @param noticeId
	 */
	int updateStatusByNoticeId(String noticeId, String status);

	/**
	 * 根据通知公告接收id，获取详情
	 * @param receiveNoticeId
	 */
	ReceiveNoticeDetailDto getDetail(String id);
	
	/**
	 * 根据通知表id查询数据
	 * @param noticeId
	 * @return
	 */
	List<GovNoticeOrg> getListByNoticeId(String noticeId);
	
	/**
	 * 根据通知表id和机构id进行删除（逻辑删除）
	 * @param attchid
	 * @return
	 */
	int deleteByOrgIdAndNoticeid(String orgId, String noticeId);
	
	/**
	 * 根据多个通知表id查询查阅情况，填报情况
	 * @param noticeIds
	 * @return
	 */
	List<Map<String, String>> getViewStatic(List<String> noticeIds);
	

	/**
	 * 根据通知表id查询分页数据
	 * @param noticeId
	 * @return
	 */
	List<ReceiveNoticeDto> getListByNoticeId(String noticeId, String key, String lookStatus, String writeStatus,Page page);
	
	/**
	 * 根据机构表id查询通知公告接收人
	 * @param orgId
	 * @return
	 */
	List<String> getReceverList(String[] orgId);
	
	/**
	 * 根据机构表id查询通知公告接收人
	 * @param orgId
	 * @return
	 */
	List<String> getForwardByOrgids(String[] orgs, String noticeId);
	/**
	 * 查询当前登录博物馆工作台通知公告列表
	 * @param orgId
	 * @return
	 */
	List<ReceiveNoticeDto> getNoticeForMuseumDesk(String orgId);
}
