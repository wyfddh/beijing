package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipStatistics;

public interface MipStatisticsService extends BaseService<MipStatistics>{
	List<MipStatistics> getStatisticsList();
	/**
	 * 新增文物时更新统计表
	 * @param mipStatistics
	 * @return
	 */
	int updateStatistics(MipStatistics mipStatistics);
	int updateStatisticsSub(MipStatistics mipStatistics);

}
