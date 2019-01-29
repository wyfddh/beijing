package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ISettingDao;
import com.tj720.mip.inter.service.table.ISettingService;
import com.tj720.mip.model.Setting;

@Service
public class SettingService extends BaseService<Setting>
		implements ISettingService {

	@Autowired
	private ISettingDao settingDao;

	@Resource(name="settingDao")
	public void setDao(IBaseDao<Setting> dao) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Setting get(String id){
		Setting model = settingDao.get(id);
		if(model == null)
			 return new Setting();
		return model;
	}
}
