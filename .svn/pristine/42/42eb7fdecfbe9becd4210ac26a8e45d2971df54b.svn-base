package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.GovNotice;
import com.tj720.mip.utils.Page;


/**
 * 
 * @author cm
 * @date 2018年7月2日19:41:53
 */
public interface GovNoticeService extends BaseService<GovNotice>{
	
	/**
	 * 获取列表数据，并返回数据集
	 * @param page		//page
	 * @param key		//关键词
	 * @param startDate		//开始时间
	 * @param endDate		//结束时间
	 * @param status		//搜索状态
	 * @param publisher		//搜索发布人
	 * @param uid		//当前登录人id
	 * @return  返回数据集
	 */
	public List<GovNotice> getList(Page page, String key, String startDate, String endDate, String status, String publisher, String uid);
	
	/**
	 * 删除通知公告
	 * @param id
	 */
	public void deleteNotice(String id);
	
	/**
	 * 根据id进行更新数据
	 * 字段为空的不更新
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(GovNotice record);
	
	/**
	 * 根据id进行更新数据
	 * 字段为空则置空
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(GovNotice record);
	
	/**
	 * 根据id进行更新数据
	 * 字段为空的不更新，除了DeadlineTime字段，DeadlineTime字段为null时，则置空
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelectiveOutDeadlineTime(GovNotice record);
	
	/**
	 * 根据选中的项目，查询表单
	 * @param item  项目   1-全部  2-最常使用   3-上次使用
	 * @return
	 */
	public List<Map<String, Object>> selectReport(String item, String name, String orgId);
	
	/**
	 * 根据表单id，获取表单数据
	 * @param id
	 * @return
	 */
	public Map<String, Object> selectReportById(String id);
	
	public List<GovNotice> selectListByOrgId(String orgId);
	
}
