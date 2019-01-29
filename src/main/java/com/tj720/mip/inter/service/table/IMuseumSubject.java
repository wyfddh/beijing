package com.tj720.mip.inter.service.table;

import java.util.List;
import java.util.Map;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.MuseumSubject;

public interface IMuseumSubject extends IBaseService<MuseumSubject>{
	MuseumSubject getOneMuseum(String hql);
	List<Map> getAttr(String hql);

}
