package com.tj720.admin.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.CurationDto;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationExample;
import com.tj720.admin.model.MipUser;
import com.tj720.mip.utils.Page;

public interface ExtCurationService extends BaseService<Curation>{
	public List<Curation> getAllCuration(CurationExample curation);
	public int updateStatus(Curation curation);
	
	public int allPage(CurationExample curation);
	public CurationDto getCuration(String id) throws IllegalAccessException, InvocationTargetException;
	public List<CurationDto> getCurationList(Page page) throws IllegalAccessException, InvocationTargetException;



}
