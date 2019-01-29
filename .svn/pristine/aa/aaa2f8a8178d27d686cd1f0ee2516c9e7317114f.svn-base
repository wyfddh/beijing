package com.tj720.mip.service.table;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ImuseumSubjectDao;
import com.tj720.mip.inter.service.table.IMuseumSubject;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.MuseumSubject;
import com.tj720.mip.utils.Tools;

@Service
public class MuserumSubjectImle extends BaseService<MuseumSubject> implements IMuseumSubject{
	@Resource(name = "ImuseumSubjectDao")
	ImuseumSubjectDao museumSubjectDao;
	
	@Resource(name = "ImuseumSubjectDao")
	public void setDao(IBaseDao<MuseumSubject> dao) {
		super.setDao(dao);
	}

	@Override
	public MuseumSubject getOneMuseum(String hql) {
		return museumSubjectDao.getOneMuseum(hql);
	}

	@Override
	public List<Map> getAttr(String hql) {
		return museumSubjectDao.getAttr(hql);
	}


}
