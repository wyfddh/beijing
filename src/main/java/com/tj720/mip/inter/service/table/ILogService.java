package com.tj720.mip.inter.service.table;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.Log;

public interface ILogService extends IBaseService<Log>{

	void recover(Log log);

}
