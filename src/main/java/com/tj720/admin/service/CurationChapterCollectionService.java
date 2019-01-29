package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.CurationChapterCollection;


public interface CurationChapterCollectionService extends BaseService<CurationChapterCollection>{

	int saveCollection(CurationChapterCollection collection);

	List<CurationChapterCollection> findCollectionsByChapterId(String id);

}
