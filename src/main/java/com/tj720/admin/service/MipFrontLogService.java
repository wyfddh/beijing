package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.dto.MipFrontLogSearchDto;
import com.tj720.admin.model.MipFrontLog;
import com.tj720.mip.utils.Page;

public interface MipFrontLogService {

	/**
	 * 查询前台日志列表
	 * @param mipLog
	 * @return
	 */
	public List<MipFrontLog> listMipLog(MipFrontLogSearchDto mipLog,Page page);
}
