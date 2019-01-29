package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.ExtVideo;
import com.tj720.mip.utils.Page;

public interface VideoService extends BaseService<ExtVideo>{
	List<ExtVideo> getVideoList(Page page,String orgId,byte level);
	int saveVideo(ExtVideo extVideo,String orgId);
	int delectVideo(String id);
	ExtVideo getVideo(String id);

}
