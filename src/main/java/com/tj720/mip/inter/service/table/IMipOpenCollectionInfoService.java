package com.tj720.mip.inter.service.table;

import java.util.ArrayList;
import java.util.List;

import com.tj720.mip.dto.CollectionAudioDto;
import com.tj720.mip.dto.CollectionDto;
import com.tj720.mip.dto.CollectionPictureDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.utils.Page;

public interface IMipOpenCollectionInfoService extends IBaseService<MipOpenCollectionInfo>{
	
	 public JsonResult getList(String hql, Page page);
	 
	 public List<CollectionDto> getHighCollections(String id, Page page);
	 
	 public List<CollectionDto> getCollections(String id, Page page);

	 public List<CollectionAudioDto> myAudios(String uid, Page page);
	 
}
