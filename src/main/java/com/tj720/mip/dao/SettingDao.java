package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.ISettingDao;
import com.tj720.mip.model.Setting;

@Repository("settingDao")
public class SettingDao extends BaseDao<Setting>
		implements ISettingDao {

}