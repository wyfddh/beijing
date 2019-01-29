package com.tj720.admin.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.CurationChapterDto;
import com.tj720.admin.model.CurationChapter;
import com.tj720.mip.framework.JsonResult;

public interface CurationChapterService extends BaseService<CurationChapter>{

	JsonResult saveCurationChapter(CurationChapterDto curationChapter) throws IllegalAccessException, InvocationTargetException;

	List<CurationChapterDto> findCurationChaptersByCurationId(String id) throws IllegalAccessException, InvocationTargetException;

}
