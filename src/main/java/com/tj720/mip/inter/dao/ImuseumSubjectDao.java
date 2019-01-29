package com.tj720.mip.inter.dao;

import java.util.List;
import java.util.Map;

import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.MuseumSubject;

public interface ImuseumSubjectDao extends IBaseDao<MuseumSubject>{
	
	MuseumSubject getOneMuseum(String hql);
	List<Map> getAttr(String hql);

}
